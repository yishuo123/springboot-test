package com.example.springboottest.bean.model;


import com.example.springboottest.core.util.DateUtil;

import java.util.Date;

public class Invoice {


	private Long  id;   //发票编号

	private String code;  //发票代码

	private String number;	//发票号码

	private String financialNumber;  //财务编号

	private String receiptNumber;	//单据编号 规则：单据编号规则：公司名称首字母4个字母 + 年月日6位 +“4位流水号

	private Date date;		    //开票日期

	private String content;		//发票内容(货物或应税劳务、服务明细)

	private String payee;		//收款人

	private String drawer;		//开票人

	private String noteo;		//备注1

	private String notet;		//备注2

	private String notes;		//备注3

	private String sname;		//销售方名称

	private String staxpayerNumber;	    //销售方纳税人识别号

	private String saddressPhone;		//销售方地址、电话

	private String sbankNumber;		    //销售方开户行及账号

	private String bname;				//购买方名称

	private String btaxpayerNumber;	    //	购买方纳税人识别号

	private String baddressPhone;		//购买方地址电话

	private String bbankNumber;		    //购买方开户行及账号

	private float btotall;				//金额合计（小写）

	private String btax;				//价税合计（大写）

	private String operator;			//操作人姓名

	private Date opedate;				//操作时间

	private String pageno;				// 页码

	private String pagesize;			// 页数

	private String name;			    // 项目名称

	private String amount;			    // 项目金额

	private String proId;			    // 项目编号

	private String startTime;			// 开始时间

    private String endTime;			    // 结束时间

	private String startTotal;			// 开始金额

	private String endTotal;			// 结束金额

    private String imgName;             //发票图片名称

    private String imgUrl;              //发票图片保存路径

    private Integer type;               //识别类型 1：识别为发票；2：未识别；

    private Integer isExis;             //数据库中是否存在 1：数据库中存在；2：不存在；

    private String checkCode;           //校验码

    private String password;            //密码区

    private String formImgUrl;          //表单图片路径

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStartTotal() {
        return startTotal;
    }

    public void setStartTotal(String startTotal) {
        this.startTotal = startTotal;
    }

    public String getEndTotal() {
        return endTotal;
    }

    public void setEndTotal(String endTotal) {
        this.endTotal = endTotal;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFinancialNumber() {
        return financialNumber;
    }

    public void setFinancialNumber(String financialNumber) {
        this.financialNumber = financialNumber;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public String getDrawer() {
        return drawer;
    }

    public void setDrawer(String drawer) {
        this.drawer = drawer;
    }

    public String getNoteo() {
        return noteo;
    }

    public void setNoteo(String noteo) {
        this.noteo = noteo;
    }

    public String getNotet() {
        return notet;
    }

    public void setNotet(String notet) {
        this.notet = notet;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getStaxpayerNumber() {
        return staxpayerNumber;
    }

    public void setStaxpayerNumber(String staxpayerNumber) {
        this.staxpayerNumber = staxpayerNumber;
    }

    public String getSaddressPhone() {
        return saddressPhone;
    }

    public void setSaddressPhone(String saddressPhone) {
        this.saddressPhone = saddressPhone;
    }

    public String getSbankNumber() {
        return sbankNumber;
    }

    public void setSbankNumber(String sbankNumber) {
        this.sbankNumber = sbankNumber;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBtaxpayerNumber() {
        return btaxpayerNumber;
    }

    public void setBtaxpayerNumber(String btaxpayerNumber) {
        this.btaxpayerNumber = btaxpayerNumber;
    }

    public String getBaddressPhone() {
        return baddressPhone;
    }

    public void setBaddressPhone(String baddressPhone) {
        this.baddressPhone = baddressPhone;
    }

    public String getBbankNumber() {
        return bbankNumber;
    }

    public void setBbankNumber(String bbankNumber) {
        this.bbankNumber = bbankNumber;
    }

    public float getBtotall() {
        return btotall;
    }

    public void setBtotall(float btotall) {
        this.btotall = btotall;
    }

    public String getBtax() {
        return btax;
    }

    public void setBtax(String btax) {
        this.btax = btax;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Date getOpedate() {
        return opedate;
    }

    public void setOpedate(Date opedate) {
        this.opedate = opedate;
    }

    public String getPageno() {
        return pageno;
    }

    public void setPageno(String pageno) {
        this.pageno = pageno;
    }

    public String getPagesize() {
        return pagesize;
    }

    public void setPagesize(String pagesize) {
        this.pagesize = pagesize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIsExis() {
        return isExis;
    }

    public void setIsExis(Integer isExis) {
        this.isExis = isExis;
    }

    public String getFormImgUrl() {
        return formImgUrl;
    }

    public void setFormImgUrl(String formImgUrl) {
        this.formImgUrl = formImgUrl;
    }

    // 把字段中的" ，" 替换成"/"
    public String getNameFmt() {
        if(this.name != null){
            return name.replace(",","/");
        }
        return "";
    }
//    把字段中的" ，" 替换成"/"
    public String getAmountFmt() {

        if(this.amount != null){
            return amount.replace(",","/");
        }
        return "";
    }

    /**
     * 格式化开票时间
     * @return
     */
    public String getDateFmt() {

        if(this.date != null){
            return DateUtil.sdfDate(this.date);
        }
        return "";
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", number='" + number + '\'' +
                ", financialNumber='" + financialNumber + '\'' +
                ", receiptNumber='" + receiptNumber + '\'' +
                ", date=" + date +
                ", content='" + content + '\'' +
                ", payee='" + payee + '\'' +
                ", drawer='" + drawer + '\'' +
                ", noteo='" + noteo + '\'' +
                ", notet='" + notet + '\'' +
                ", notes='" + notes + '\'' +
                ", sname='" + sname + '\'' +
                ", staxpayerNumber='" + staxpayerNumber + '\'' +
                ", saddressPhone='" + saddressPhone + '\'' +
                ", sbankNumber='" + sbankNumber + '\'' +
                ", bname='" + bname + '\'' +
                ", btaxpayerNumber='" + btaxpayerNumber + '\'' +
                ", baddressPhone='" + baddressPhone + '\'' +
                ", bbankNumber='" + bbankNumber + '\'' +
                ", btotall=" + btotall +
                ", btax='" + btax + '\'' +
                ", operator='" + operator + '\'' +
                ", opedate=" + opedate +
                ", pageno='" + pageno + '\'' +
                ", pagesize='" + pagesize + '\'' +
                ", name='" + name + '\'' +
                ", amount='" + amount + '\'' +
                ", proId='" + proId + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", startTotal='" + startTotal + '\'' +
                ", endTotal='" + endTotal + '\'' +
                '}';
    }
}
