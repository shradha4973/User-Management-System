/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.usermanagement.model;


public class BlockUser {
     int id;
     String email;
     private String dateandtime;


     public BlockUser(String email){
         this.email=email;
     }

    public BlockUser(String email, String dateandtime) {
        this.email = email;
        this.dateandtime = dateandtime;
    }

    public BlockUser() {
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
 
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateandtime() {
        return dateandtime;
    }

    public void setDateandtime(String dateandtime) {
        this.dateandtime = dateandtime;
    }
    
 
    

  
}

