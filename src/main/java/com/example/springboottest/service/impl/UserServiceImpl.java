package com.example.springboottest.service.impl;

import com.example.springboottest.anno.WebServiceLogger;
import com.example.springboottest.dao.UserMapper;
import com.example.springboottest.model.User;
import com.example.springboottest.service.UserService;
import com.example.springboottest.util.Page;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    @WebServiceLogger(logger = "查询用书全部数据！！！")
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User findByName(String name) {
        return userMapper.findByName(name);
    }

    @Override
    public User getById(int id) {
        return userMapper.getById(id);
    }

    //  分页查询
    @Override
    public Page<Map<String, Object>> selectAll(Map<String, Object> map) throws Exception {
        List<Map<String, Object>> list = userMapper.selectAll(map);
        Integer total = userMapper.selectCount(map);
        return new Page<Map<String, Object>>(total,list);
    }


    /**
     * 在service 里面调用另一个事物的方法 需要开启aop事务
     * 在springboot启动类上 加上 @EnableAspectJAutoProxy 注解
     *
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<User> getListUser() {
        String  name = "李斯特";
        this.findByName(name);

        // 调用 别的事务上的方法，
          User user = ((UserService) AopContext.currentProxy()).findByName(name);

        return null;
    }

    private final static String XLS = "xls";
    private final static String XLSX = "xlsx";

    //导入
    @Override
    public Integer importExcel(MultipartFile myFile)throws Exception{
        //        1、用HSSFWorkbook打开或者创建“Excel文件对象”
        //
        //        2、用HSSFWorkbook对象返回或者创建Sheet对象
        //
        //        3、用Sheet对象返回行对象，用行对象得到Cell对象
        //
        //        4、对Cell对象读写。
        //获得文件名
        Workbook workbook = null ;
        String fileName = myFile.getOriginalFilename();
        if(fileName.endsWith(XLS)){
            //2003
            workbook = new HSSFWorkbook(myFile.getInputStream());
        }else if(fileName.endsWith(XLSX)){
            //2007
            workbook = new XSSFWorkbook(myFile.getInputStream());
        }else{
            throw new Exception("文件不是Excel文件");
        }

        Sheet sheet = workbook.getSheet("Sheet1");
        int rows = sheet.getLastRowNum();// 指的行数，一共有多少行+
        if(rows==0){
            throw new Exception("请填写数据");
        }
        // 取xls 中 表头的字段的坐标
        Map<String,Integer>  mapIndex = getSheetTitleIndex(sheet);

        // 循环所有的行
        for (int i = 1; i <= rows+1; i++) {
            // 读取左上端单元格
            Row row = sheet.getRow(i);
            // 行不为空
            if (row != null) {
                // **读取cell**
                User user = new User();
                //姓名
//                String name = getCellValue(row.getCell(mapIndex.get("名称")));
                String name = getCellValue(row.getCell(0));
                user.setName(name);
                //密码
                String classes = getCellValue(row.getCell(1));
                user.setPassWord(classes);
                //分数
//                String scoreString = getCellValue(row.getCell(2));
//                if (!StringUtils.isEmpty(scoreString)) {
//                    Integer score = Integer.parseInt(scoreString);
//                    user.setPeralm(score);
//                }
                //考试时间
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟
                String dateString = getCellValue(row.getCell(3));
                if (!StringUtils.isEmpty(dateString)) {
                    Date date=sdf.parse(dateString);
//                    user.setTime(date);
                }

                /**
                 *
                 *   把数据存入到数据库中
                 */
//                userMapper.insert(user);
            }
        }
        return rows-1;
    }

    /**
     * 取xls 表格中第一行表格的坐标
     * @param
     */
    private Map<String,Integer> getSheetTitleIndex(Sheet sheet) {
        Map<String,Integer> map = new HashMap<>();
        // 获取表格中第一行的标题的下标
        Row rows = sheet.getRow(0);
        for(Cell cell:rows){
            cell.setCellType(cell.CELL_TYPE_STRING);//不推荐使用的方法,但是取出列有数字的话,要转换一下
            if(!org.apache.commons.lang3.StringUtils.isBlank(cell.getStringCellValue())){
                if(cell.getStringCellValue().equals("标题")){
                    map.put("标题",cell.getColumnIndex());
                }
                if(cell.getStringCellValue().equals("作者")){
                    map.put("作者",cell.getColumnIndex());
                }
                if(cell.getStringCellValue().equals("来源")){
                    map.put("来源",cell.getColumnIndex());
                }

            }
        }

        return map;
    }

    /**
     * 获得Cell内容
     *
     * @param cell
     * @return
     */
    public String getCellValue(Cell cell) {
        String value = "";
        if (cell != null) {
            // 以下是判断数据的类型
            switch (cell.getCellType()) {
                case HSSFCell.CELL_TYPE_NUMERIC: // 数字
                    value = cell.getNumericCellValue() + "";
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                        Date date = cell.getDateCellValue();
                        if (date != null) {
                            value = new SimpleDateFormat("yyyy-MM-dd").format(date);
                        } else {
                            value = "";
                        }
                    } else {
                        value = new DecimalFormat("0").format(cell.getNumericCellValue());
                    }
                    break;
                case HSSFCell.CELL_TYPE_STRING: // 字符串
                    value = cell.getStringCellValue();
                    break;
                case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
                    value = cell.getBooleanCellValue() + "";
                    break;
                case HSSFCell.CELL_TYPE_FORMULA: // 公式
                    value = cell.getCellFormula() + "";
                    break;
                case HSSFCell.CELL_TYPE_BLANK: // 空值
                    value = "";
                    break;
                case HSSFCell.CELL_TYPE_ERROR: // 故障
                    value = "非法字符";
                    break;
                default:
                    value = "未知类型";
                    break;
            }
        }
        return value.trim();
    }


    //导出
    @Override
    public void exportExcel(HttpServletResponse response)throws Exception {
        // 第一步，创建一个webbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet("Sheet1");
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        HSSFRow row = sheet.createRow(0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

        HSSFCell cell = row.createCell(0);
        cell.setCellValue("姓名");
        cell.setCellStyle(style);
        cell = row.createCell(1);
        cell.setCellValue("班级");
        cell.setCellStyle(style);
        cell = row.createCell(2);
        cell.setCellValue("分数");
        cell.setCellStyle(style);
        cell = row.createCell(3);
        cell.setCellValue("时间");
        cell.setCellStyle(style);

        /**
         * 第五步，写入实体数据 实际应用中这些数据从数据库得到，
         */
        List<User> list = userMapper.findAll();

        for (int i = 0; i < list.size(); i++){
            row = sheet.createRow(i + 1);
            User user = list.get(i);
            // 第四步，创建单元格，并设置值
            row.createCell(0).setCellValue(user.getName());
            row.createCell(1).setCellValue(user.getPassWord());
            row.createCell(2).setCellValue(user.getPeralm());
            cell = row.createCell(3);
//            cell.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(user.getTime()));
        }
        //第六步,输出Excel文件
        OutputStream output=response.getOutputStream();
        response.reset();
        long filename = System.currentTimeMillis();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
        String fileName = df.format(new Date());// new Date()为获取当前系统时间
        response.setHeader("Content-disposition", "attachment; filename="+fileName+".xls");
        response.setContentType("application/msexcel");
        wb.write(output);
        output.close();
    }
}

