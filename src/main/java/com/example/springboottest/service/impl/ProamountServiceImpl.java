package com.example.springboottest.service.impl;

import com.example.springboottest.bean.model.Proamount;
import com.example.springboottest.dao.ProamountMapper;
import com.example.springboottest.service.ProamountService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author lizy
 * @Date 2018/8/2 11:17
 * @Version V1.0
 * @Description:    项目金额业务
 */
@Service
public class ProamountServiceImpl implements ProamountService {

    @Autowired
    ProamountMapper proamountMapper;

    /**
     * 添加单个项目金额
     * @param receiptNumber	单据编号
     * @param userName		操作账户
     * @param date			操作时间
     * @param projectNumber	项目编号
     * @param amount		项目金额
     * @return              返回新增的项目金额ID
     * @throws Exception
     */
    @Override
    public int addProamount(String receiptNumber, String userName, Date date, String projectNumber,
                             Float amount) throws Exception{

        Proamount proamount = new Proamount();

        proamount.setProjectNumber(projectNumber);
        proamount.setAmount(amount);
        proamount.setOpedate(date);
        proamount.setOperator(userName);
        proamount.setReceiptNumber(receiptNumber);

        return proamountMapper.insert(proamount);
    }

    /**
     * 批量添加项目金额
     * @param receiptNumber	单据编号
     * @param date			操作时间
     * @param userName		操作账户
     * @param projectMap
     * @throws Exception
     */
    @Override
    public Float batchAddProamount(String receiptNumber, Date date, String userName,
                                  List<Map<String, Object>> projectMap) throws Exception{
        float projectAmount = 0f;   //项目金额

        for (Map<String, Object> project : projectMap) {

            String projectNumber = project.get("projectNumber") + "";	    //获取项目编号

            if(StringUtils.isBlank(projectNumber)) {					    //校验项目编号不能为null 或者 ""
                throw new RuntimeException("saveInvoice add proamount error:-2 receiptNumber:"+ receiptNumber +", 项目编号不能为空");
            }

            Float amount = Float.parseFloat(project.get("amount")+"");  //获取项目金额

            int id = addProamount(receiptNumber, userName, date, projectNumber, amount);

            if(id < 1){   //如果返回id is null or id 小于1 添加失败
                throw new RuntimeException("saveInvoice add proamount error receiptNumber:"+ receiptNumber +", projectNumber="+ projectNumber );
            }

            projectAmount += amount;
        }

        return projectAmount;
    }
}
