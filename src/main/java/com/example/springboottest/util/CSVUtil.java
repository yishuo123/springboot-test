package com.example.springboottest.util;

import com.csvreader.CsvReader;
import com.example.springboottest.model.Hotel;
import com.example.springboottest.model.taskRule;
import org.apache.log4j.Logger;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;


public class CSVUtil {
    private static Logger log = Logger.getLogger(CSVUtil.class);

    public static List<Hotel> readCSV(String csvFilePath) {
        Hotel hotel = null;
        //生成CsvReader对象，以，为分隔符，GBK编码方式
        CsvReader r = null;
        try {
            List<Hotel> hotels = new ArrayList<>();
//            String csvFilePath = "D:\\1.csv";
            r = new CsvReader(csvFilePath, '|', Charset.forName("UTF-8"));
            //读取表头
            r.readHeaders();
            //逐条读取记录，直至读完
            while (r.readRecord()) {

                hotel = new Hotel();
//                hotel.setId(r.getId(0));
//                hotel.setAddress(r.get("Address"));
//                hotel.setAddressCn(r.get("Address_CN"));
//                hotel.setAirportCode(r.get("AirportCode"));
//                hotel.setCityCode(r.get("CityCode"));
                hotel.setName(r.get("name"));
                hotel.setContent(r.get("content"));
                hotels.add(hotel);
            }
            r.close();
            return hotels;
        } catch (Exception e) {
            log.info("批量导入csv异常!", e);
            return null;
        } finally {
            r.close();
        }
    }



    /**

     * 读取csv文件用list对象存储的公共调用方法

     * @param inpath csv文件存储路径

     * @return 返回List<taskRule>对象

     */
    public static List<taskRule> readCsv(String inpath) {

        List<taskRule> list = new ArrayList<taskRule>(); // 保存读取到的CSV数据

        try {

            File file = new File(inpath); // 判断文件是否存在

            if (!file.exists()) {

                System.out.println("文件不存在！");

            } else {

                System.out.println("文件存在！");

                DataInputStream in = new DataInputStream(new FileInputStream(file));

                BufferedReader reader = new BufferedReader(new InputStreamReader(in,"GBK")); // 读取CSV文件

                String line = null;// 循环读取每行
                String splitBy = ",";
                while ((line = reader.readLine()) != null) {

//                    String[] row = line.split("\\|", -1); // 分隔字符串（这里用到转义），存储到List<taskRule>里

                    String[] row = line.split(splitBy);

                    taskRule infos = new taskRule();

                    infos.setName(row[0]);

                    infos.setContent(row[1]);
                    System.out.println(row[0]);

                    list.add(infos);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    /**
     * 把 CSV  文件写入到 txt文件
     * @param inpath  路径
     * @throws Exception
     */
    public static void readCSVWriteTxt(String inpath)throws Exception{

        // CSV 文件路径
        List<taskRule> taskRulesList = readCsv(inpath);

        //循环list 里面的内容
        for (int i = 0; i <taskRulesList.size() ; i++) {
            taskRule taskRule = taskRulesList.get(i);
            String name = taskRule.getName();
            String content = taskRule.getContent();
            String nameContent = name +"\r\n"+content;

            //去掉 html的标签
            String  replaceAllContent = StringUtil.removeHTMLLabel(nameContent);

            // 去掉特殊字符
            String  newStr = StringUtil.removeSpecifiedStr(replaceAllContent);

            // 创建文件， 写入文件中
            txtExport.creatTxtFile(i+1);
            // 写入内容
            txtExport.writeTxtFile(newStr);
        }

    }



}
