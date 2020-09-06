package com.example.springboottest.bean.model;

public class InvoiceScann {


    private Long id;   //x项目id

    private String projectNumber;  //项目编号

    private String name;    //项目名称

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "InvoiceScann{" +
                "id=" + id +
                ", projectNumber='" + projectNumber + '\'' +
                ", name='" + name + '\'' +
                '}';
    }


}
