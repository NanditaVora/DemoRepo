/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niit.gniitproject.daoimpl;

import com.niit.gniitproject.dao.EmployeeDAO;
import com.niit.gniitproject.entities.Employee;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MRuser
 */
public class EmployeeDAOImpl implements EmployeeDAO {

   
    
    @Override
    public int addEmployee(Employee employee) {
        int count=0;
        try {
            //return addEmployee(employee);
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into employees(employeeid,employeename,email,joindate) values(?,?,?,?)");
            preparedStatement.setInt(1,employee.getEmployeeID());
            preparedStatement.setString(2,employee.getEmployeeName());
            preparedStatement.setString(3,employee.getEmail());
            java.util.Date joindate = new java.util.Date(employee.getJoindate());
            preparedStatement.setDate(4,new Date(joindate.getYear(),joindate.getMonth(),joindate.getDate()));
            count = preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    @Override
    public int deleteEmployee(int employeeID) {
        int count=0;
        try {
            
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from Employees where employeeid=?");
            preparedStatement.setInt(1,employeeID);
            count=preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = null;
        try {
            Connection connection = DBConnection.getConnection(); 
            PreparedStatement preparedStatement = connection.prepareStatement("select * from employees");
            ResultSet resultSet = preparedStatement.executeQuery();
            employeeList = new ArrayList<Employee>();
            if(resultSet!=null){
                //resultSet.first();
                while(resultSet.next()){
                    int employeeId = resultSet.getInt(1);
                    String employeeName = resultSet.getString(2);
                    String email = resultSet.getString(3);
                    String joindate = resultSet.getDate(4).toString();
                    Employee employee = new Employee(employeeId,employeeName,email,joindate);
                    employeeList.add(employee);
                }
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
     return employeeList;
    }

    @Override
    public Employee getEmployeeByID(int employeeID) {
          List<Employee> employeeList = null;
        try {
            Connection connection = DBConnection.getConnection(); 
            PreparedStatement preparedStatement = connection.prepareStatement("select * from employees where employeeid=?");
            preparedStatement.setInt(1, employeeID);
            ResultSet resultSet = preparedStatement.executeQuery();
            employeeList = new ArrayList<Employee>();
            if(resultSet!=null){
                //resultSet.first();
                while(resultSet.next()){
                    int employeeId = resultSet.getInt(1);
                    String employeeName = resultSet.getString(2);
                    String email = resultSet.getString(3);
                    String joindate = resultSet.getDate(4).toString();
                    Employee employee = new Employee(employeeId,employeeName,email,joindate);
                    employeeList.add(employee);
                }
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
     if(employeeList.size()>0) return employeeList.get(0);
     else return null;
    }

    @Override
    public int updateEmployee(int employeeID, Employee employee) {
        int count=0;
        try {
            Connection connection  = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update employees set employeename=?, email=? where employeeid=?");
            preparedStatement.setString(1,employee.getEmployeeName());
            preparedStatement.setString(2,employee.getEmail());
            preparedStatement.setInt(3,employeeID);
            count=preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
    
}
