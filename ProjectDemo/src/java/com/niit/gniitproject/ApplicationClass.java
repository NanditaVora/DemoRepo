/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niit.gniitproject;

import com.niit.gniitproject.dao.EmployeeDAO;
import com.niit.gniitproject.daoimpl.EmployeeDAOImpl;
import com.niit.gniitproject.entities.Employee;
import java.util.List;

/**
 *
 * @author MRuser
 */
public class ApplicationClass {
    public static void main(String[] args){
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        int count = employeeDAO.addEmployee(new Employee(1,"Shweta","shweta@niit.com","10/25/2015"));
        if(count>0)System.out.println("Record Added Successfully");
        else System.out.println("Record Failed to get added");
//        count=employeeDAO.deleteEmployee(1);
//        if(count>0)System.out.println("Record Deleted Successfully");
//        else System.out.println("Record Failed to get deleted");
//        Employee employee = new Employee(2,"sonam","sonam@gmail.com");
//        count=employeeDAO.updateEmployee(2, employee);
//        if(count>0)System.out.println("Record Updated Successfully");
//        else System.out.println("Record Failed to get updated");
        List<Employee> employeelist = employeeDAO.getAllEmployees();
        for(Employee emp : employeelist){
            System.out.println(emp.getEmployeeID() + "|" + emp.getEmployeeName() + "|" + emp.getEmail() + "|" + emp.getJoindate());
        }
        Employee emp = employeeDAO.getEmployeeByID(3);
            System.out.println(emp.getEmployeeID() + "|" + emp.getEmployeeName() + "|" + emp.getEmail() + "|" + emp.getJoindate());
    }
}
