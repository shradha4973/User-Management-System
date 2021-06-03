/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.usermanagement.model;

import java.lang.String;

/**
 *
 * @author sonams
 */
public class User {
    int id;
    String fname; 
    String lname; 
    String uname; 
    String email;
    long contact;
    String address;
    String pword;
    String pwordconf;
    String dob;
    String gender;
    String info;
    String profile_pic;
    String cover_pic;
    int userType;
    
    
   
    public User(String fname, String lname, String uname, String email, String address0, long contact, String address, String dob, String info,String gender,String profile_pic, String cover_pic) {
        this.fname = fname;
        this.lname = lname;
        this.uname = uname;
        this.email = email;
        this.contact = contact;
        this.address = address;
        this.dob = dob;
        this.info = info;
        this.profile_pic = profile_pic;  
        this.cover_pic = cover_pic;
    }
   

    public User() {
        
    }

    public User(int id,String fname, String lname, String uname, String pword, String email, long contact, String dob, String address, String gender) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.uname = uname;
        this.pword = pword;
        this.email = email;
        this.contact = contact;
        this.address = address;
        this.gender = gender;
        this.dob = dob;
    }
    
    public User(String fname, String lname, String uname, String pword, String email, long contact, String dob, String address, String gender) {
    
        this.fname = fname;
        this.lname = lname;
        this.uname = uname;
        this.pword = pword;
        this.email = email;
        this.contact = contact;
        this.address = address;
        this.gender = gender;
        this.dob = dob;
    }

    public User(int id) {
        this.id = id;
    }

    public User(String fname, String lname, String uname, String pword, String email, long contact, String dob, String address, String gender, int userType) {
        this.fname = fname;
        this.lname = lname;
        this.uname = uname;
        this.pword = pword;
        this.email = email;
        this.contact = contact;
        this.address = address;
        this.gender = gender;
        this.dob = dob;
        this.userType = userType;
    }

    public User(int id, String uname, String fname, String lname, String email) {
        this.id = id;
        this.fname = fname;
        this.uname = uname;
    }
    
    
    
    //Getters
    
    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getUname() {
        return uname;
    }

    public String getEmail() {
        return email;
    }

    public long getContact() {
        return contact;
    }

    public String getAddress() {
        return address;
    }

    public String getPword() {
        return pword;
    }

    public String getPwordconf() {
        return pwordconf;
    }

    public String getDob() {
        return dob;
    }

    public String getGender() {
        return gender;
    }

    public String getInfo() {
        return info;
    }

    public String getProfile_pic() {
        return profile_pic;
    }
    

    public String getCover_pic() {
        return cover_pic;
    }

    public int getUserType() {
        return userType;
    }
    
    
    

    
    //Setters

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPword(String pword) {
        this.pword = pword;
    }

    public void setPwordconf(String pwordconf) {
        this.pwordconf = pwordconf;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setProfile_pic(String profile_pic) {
        this.profile_pic = profile_pic;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCover_pic(String cover_pic) {
        this.cover_pic = cover_pic;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
    

    
    
    
    
    
}
