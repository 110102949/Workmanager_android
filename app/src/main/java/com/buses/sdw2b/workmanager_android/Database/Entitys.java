package com.buses.sdw2b.workmanager_android.Database;


import android.arch.persistence.room.PrimaryKey;

@android.arch.persistence.room.Entity(tableName = "user")
public class Entitys {

    @PrimaryKey(autoGenerate = true)
    int userid;


    public Entitys(String username, String mobilenumber, String mail_id) {

        this.username = username;
        this.mobilenumber = mobilenumber;
        this.mail_id = mail_id;
    }

    String username;


    String mobilenumber;


    String mail_id;


    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getMail_id() {
        return mail_id;
    }

    public void setMail_id(String mail_id) {
        this.mail_id = mail_id;
    }
}
