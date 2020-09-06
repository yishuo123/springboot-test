package com.example.springboottest.controller.util;

import com.example.springboottest.bean.model.Invoice;
import com.example.springboottest.core.ResultValue;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * @Author lizy
 * @Date 2018/8/2 14:45
 * @Version V1.0
 * @Description: 发票信息校验
 */
@Component
public class InvoiceValidator {
    private Logger logger = LoggerFactory.getLogger(InvoiceValidator.class);

    /**
     * 校验发票信息长度
     *
     * @param invoice 发票信息
     * @return
     * @throws Exception
     */
    public int checkInvoice(Invoice invoice) throws Exception {
        String receiptNumber = invoice.getReceiptNumber();

        if (invoice.getId() == null) {
            //单据编号
            if (StringUtils.isBlank(receiptNumber) || receiptNumber.length() > 50) {
                logger.error("checkInvoice receiptNumber:" + receiptNumber + ", receiptNumber is null or receiptNumber size 大于50");
                return ResultValue._ERROR;
            }
        }
        //发票代码
        if (StringUtils.isBlank(invoice.getCode()) || invoice.getCode().length() > 50) {
            logger.error("checkInvoice receiptNumber:" + receiptNumber + ", code is null or code size 大于50");
            return ResultValue._ERROR;
        }
        //发票号码
        if (StringUtils.isBlank(invoice.getNumber()) || invoice.getNumber().length() > 50) {
            logger.error("checkInvoice receiptNumber:" + receiptNumber + ", Number is null or Number size 大于50");
            return ResultValue._ERROR;
        }
        //金额合计（小写）
        if (invoice.getBtotall() > 1200000 || invoice.getBtotall() <= 0) {
            logger.error("checkInvoice receiptNumber:" + receiptNumber + ", Btotall 大于 120万元或者小于等于0元");
            return ResultValue._ERROR;
        }
        //发票内容
        if (StringUtils.isNotBlank(invoice.getContent()) && invoice.getContent().length() > 500) {
            logger.error("checkInvoice receiptNumber:" + receiptNumber + ", content size 大于500");
            return ResultValue._ERROR;
        }
        //财务编号
        if (StringUtils.isNotBlank(invoice.getFinancialNumber()) && invoice.getFinancialNumber().length() > 50) {
            logger.error("checkInvoice receiptNumber:" + receiptNumber + ", FinancialNumber size 大于50");
            return ResultValue._ERROR;
        }
        //购买方地址电话
        if (StringUtils.isNotBlank(invoice.getBaddressPhone()) && invoice.getBaddressPhone().length() > 100) {
            logger.error("checkInvoice receiptNumber:" + receiptNumber + ", BaddressPhone size 大于50");
            return ResultValue._ERROR;
        }
        //购买方名称
        if (StringUtils.isNotBlank(invoice.getBname()) && invoice.getBname().length() > 50) {
            logger.error("checkInvoice receiptNumber:" + receiptNumber + ", Bname size 大于50");
            return ResultValue._ERROR;
        }
        //购买方开户行及账号
        if (StringUtils.isNotBlank(invoice.getBbankNumber()) && invoice.getBbankNumber().length() > 50) {
            logger.error("checkInvoice receiptNumber:" + receiptNumber + ", BbankNumber size 大于50");
            return ResultValue._ERROR;
        }
        //购买方纳税人识别号
        if (StringUtils.isNotBlank(invoice.getBtaxpayerNumber()) && invoice.getBtaxpayerNumber().length() > 50) {
            logger.error("checkInvoice receiptNumber:" + receiptNumber + ", BtaxpayerNumber size 大于50");
            return ResultValue._ERROR;
        }
        //销售方名称
        if (StringUtils.isNotBlank(invoice.getSname()) && invoice.getSname().length() > 50) {
            logger.error("checkInvoice receiptNumber:" + receiptNumber + ", Sname size 大于50");
            return ResultValue._ERROR;
        }
        //价税合计（大写）
        if (StringUtils.isNotBlank(invoice.getBtax()) && invoice.getBtax().length() > 50) {
            logger.error("checkInvoice receiptNumber:" + receiptNumber + ", Btax size 大于50");
            return ResultValue._ERROR;
        }
        //销售方名称
        if (StringUtils.isNotBlank(invoice.getSname()) && invoice.getSname().length() > 50) {
            logger.error("checkInvoice receiptNumber:" + receiptNumber + ", sname size 大于50");
            return ResultValue._ERROR;
        }
        //销售方地址、电话
        if (StringUtils.isNotBlank(invoice.getSaddressPhone()) && invoice.getSaddressPhone().length() > 100) {
            logger.error("checkInvoice receiptNumber:" + receiptNumber + ", SaddressPhone size 大于50");
            return ResultValue._ERROR;
        }
        //销售方开户行及账号
        if (StringUtils.isNotBlank(invoice.getSbankNumber()) && invoice.getSbankNumber().length() > 50) {
            logger.error("checkInvoice receiptNumber:" + receiptNumber + ", SbankNumber size 大于50");
            return ResultValue._ERROR;
        }
        //销售方纳税人识别号
        if (StringUtils.isNotBlank(invoice.getStaxpayerNumber()) && invoice.getStaxpayerNumber().length() > 50) {
            logger.error("checkInvoice receiptNumber:" + receiptNumber + ", StaxpayerNumber size 大于50");
            return ResultValue._ERROR;
        }
        //收款人长度不能大于50
        if (StringUtils.isNotBlank(invoice.getPayee()) && invoice.getPayee().length() > 50) {
            logger.error("checkInvoice receiptNumber:" + receiptNumber + ", payee size 大于50");
            return ResultValue._ERROR;
        }
        //开票人长度不能大于50
        if (StringUtils.isNotBlank(invoice.getDrawer()) && invoice.getDrawer().length() > 50) {
            logger.error("checkInvoice receiptNumber:" + receiptNumber + ", drawer size 大于50");
            return ResultValue._ERROR;
        }
        //销售方名称长度不能大于50
        if (StringUtils.isNotBlank(invoice.getSname()) && invoice.getSname().length() > 50) {
            logger.error("checkInvoice receiptNumber:" + receiptNumber + ", sname size 大于50");
            return ResultValue._ERROR;
        }
        //销售方纳税人识别号
        if (StringUtils.isNotBlank(invoice.getStaxpayerNumber()) && invoice.getStaxpayerNumber().length() > 50) {
            logger.error("checkInvoice receiptNumber:" + receiptNumber + ", staxpayerNumber size 大于50");
            return ResultValue._ERROR;
        }
        //销售方地址、电话
        if (StringUtils.isNotBlank(invoice.getSaddressPhone()) && invoice.getSaddressPhone().length() > 50) {
            logger.error("checkInvoice receiptNumber:" + receiptNumber + ", saddressPhone size 大于50");
            return ResultValue._ERROR;
        }
        //销售方开户行及账号
        if (StringUtils.isNotBlank(invoice.getSbankNumber()) && invoice.getSbankNumber().length() > 50) {
            logger.error("checkInvoice receiptNumber:" + receiptNumber + ", sbankNumber size 大于50");
            return ResultValue._ERROR;
        }
        //购买方名称长度不能大于50
        if (StringUtils.isNotBlank(invoice.getBname()) && invoice.getBname().length() > 50) {
            logger.error("checkInvoice receiptNumber:" + receiptNumber + ", bname size 大于50");
            return ResultValue._ERROR;
        }
        //购买方纳税人识别号
        if (StringUtils.isNotBlank(invoice.getBtaxpayerNumber()) && invoice.getBtaxpayerNumber().length() > 50) {
            logger.error("checkInvoice receiptNumber:" + receiptNumber + ", BtaxpayerNumber size 大于50");
            return ResultValue._ERROR;
        }
        //购买方地址、电话
        if (StringUtils.isNotBlank(invoice.getBaddressPhone()) && invoice.getBaddressPhone().length() > 50) {
            logger.error("checkInvoice beceiptNumber:" + receiptNumber + ", baddressPhone size 大于50");
            return ResultValue._ERROR;
        }
        //购买方开户行及账号
        if (StringUtils.isNotBlank(invoice.getBbankNumber()) && invoice.getBbankNumber().length() > 50) {
            logger.error("checkInvoice receiptNumber:" + receiptNumber + ", bbankNumber size 大于50");
            return ResultValue._ERROR;
        }

        if (StringUtils.isNotBlank(invoice.getNotes()) && invoice.getNotes().length() > 500) {
            logger.error("checkInvoice receiptNumber:" + receiptNumber + ", Notes size 大于500");
            return ResultValue._ERROR;
        }

        if (StringUtils.isNotBlank(invoice.getNoteo()) && invoice.getNoteo().length() > 500) {
            logger.error("checkInvoice receiptNumber:" + receiptNumber + ", Noteo size 大于500");
            return ResultValue._ERROR;
        }

        if (StringUtils.isNotBlank(invoice.getNotet()) && invoice.getNotet().length() > 500) {
            logger.error("checkInvoice receiptNumber:" + receiptNumber + ", Notet size 大于500");
            return ResultValue._ERROR;
        }

        return ResultValue._SUCCESS;
    }
}