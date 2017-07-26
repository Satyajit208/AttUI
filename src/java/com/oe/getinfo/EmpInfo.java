package com.oe.getinfo; 
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user1
 */
public class EmpInfo {
    private String empid;
    private String empname;
    private String empemail;
    private String empdes;
    private float emppl;

    public String getEmpemail() {
        return empemail;
    }

    public void setEmpemail(String empemail) {
        this.empemail = empemail;
    }

    public String getEmpdes() {
        return empdes;
    }

    public void setEmpdes(String empdes) {
        this.empdes = empdes;
    }

    public float getEmppl() {
        return emppl;
    }

    public void setEmppl(float emppl) {
        this.emppl = emppl;
    }
    
    
    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }
    
}
