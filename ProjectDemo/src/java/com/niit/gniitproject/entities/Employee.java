/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niit.gniitproject.entities;

/**
 *
 * @author MRuser
 */
public class Employee {

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJoindate() {
        return joindate;
    }

    public void setJoindate(String joindate) {
        this.joindate = joindate;
    }
    int employeeID;
    String employeeName;
    String email;
    String joindate;
    
    public Employee(){}

    public Employee(int employeeID, String employeeName, String email, String joindate) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.email = email;
        this.joindate = joindate;
    }

    public Employee(String employeeName, String email, String joindate) {
        this.employeeName = employeeName;
        this.email = email;
        this.joindate=joindate;
        
    }
    
    
    
    
    
    
    
}






