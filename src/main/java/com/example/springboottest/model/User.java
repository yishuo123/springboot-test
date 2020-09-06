package com.example.springboottest.model;

public class User {

    private int id;
    private String name;
    private String userName;
    private String passWord;

    private String peralm;

    public User(int id, String name, String userName, String passWord, String peralm) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.passWord = passWord;
        this.peralm = peralm;
    }

    public User() {

    }

    public String getPeralm() {
        return peralm;
    }

    public void setPeralm(String peralm) {
        this.peralm = peralm;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
