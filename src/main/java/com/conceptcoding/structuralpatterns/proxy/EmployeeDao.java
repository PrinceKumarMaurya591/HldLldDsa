package com.conceptcoding.structuralpatterns.proxy;

// Subject interface - common interface for RealSubject and Proxy
public interface EmployeeDao {

    void getEmployeeInfo();

    void createEmployee();

    void deleteEmployee();

    void updateSalary(double newSalary);

    void displayEmployeeDetails();
}
