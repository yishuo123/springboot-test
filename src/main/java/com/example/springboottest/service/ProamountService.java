package com.example.springboottest.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 项目金额业务逻辑层接口
 */
public interface ProamountService {

    /**
     * 批量添加项目金额
     * @param receiptNumber	单据编号
     * @param date			操作时间
     * @param userName		操作账户
     * @param projectMap
     * @return              项目金额总和
     * @throws Exception
     */
    Float batchAddProamount(String receiptNumber, Date date, String userName,
                            List<Map<String, Object>> projectMap) throws Exception;

    /**
     * 添加单个项目金额
     * @param receiptNumber	单据编号
     * @param userName		操作账户
     * @param date			操作时间
     * @param projectNumber	项目编号
     * @param amount		项目金额
     * @return              返回添加项目金额ID
     * @throws Exception
     */
    int addProamount(String receiptNumber, String userName, Date date, String projectNumber,
                     Float amount) throws Exception;
}
