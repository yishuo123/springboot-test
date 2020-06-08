package com.example.springboottest.core;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author lizy
 * @Date 2018/7/26 9:41
 * @Version V1.0
 * @Description: 获扫描配置属性
 */
@Configuration
@ConfigurationProperties(prefix = "scan")
public class ScanConf {

    private String soPath;      //dll程序包存放位置

    private String juserID;     //SDK 秘钥

    private String filePath;    //扫描图片文件保存路径

    public String getSoPath() {
        return soPath;
    }

    public void setSoPath(String soPath) {
        this.soPath = soPath;
    }

    public String getJuserID() {
        return juserID;
    }

    public void setJuserID(String juserID) {
        this.juserID = juserID;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
