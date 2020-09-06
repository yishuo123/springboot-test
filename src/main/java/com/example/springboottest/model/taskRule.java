package com.example.springboottest.model;

public class taskRule {


    private String name;
    private String content;

    public taskRule() {

    }


    @Override
    public String toString() {
        return "taskRule{" +
                "name='" + name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public taskRule(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
