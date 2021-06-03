/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.usermanagement.model;

import java.sql.Date;

/**
 *
 * @author sasmi
 */
public class AdminReport {
    
    int id;
    String uname, activity;
    Date date;

    public AdminReport(int id, String uname, Date date) {
        this.id = id;
        this.uname = uname;
        this.date = date;
    }

    public AdminReport(Date date, String activity) {
        this.activity = activity;
        this.date = date;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
}
