/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oe.models;

/**
 *
 * @author user1
 */
public class UpdateModel {
    private String Name;
    private String Id;
    private String Email;
    private String Des;
    private Float pl;
    private String addr;
    private String contact;
    private String doj;

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDes() {
        return Des;
    }

    public void setDes(String Des) {
        this.Des = Des;
    }

    public Float getPl() {
        return pl;
    }

    public void setPl(Float pl) {
        this.pl = pl;
    }
    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
     public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    
     public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }
    
}
