/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niit.gniitproject.dao;

import com.niit.gniitproject.entities.Employee;
import java.util.List;

/**
 *
 * @author MRuser
 */
public interface EmployeeDAO {
    int addEmployee(Employee employee);
    int deleteEmployee(int employeeID);
    List<Employee> getAllEmployees();
    Employee getEmployeeByID(int employeeID);
    int updateEmployee(int employeeID, Employee employee);
}
