package com.conceptcoding.structuralpatterns.proxy;

// Enum for user roles
enum UserRole {
    EMPLOYEE, MANAGER, ADMIN, HR
}

// Enum for access types
enum AccessType {
    CREATE, DELETE, UPDATE, VIEW_ALL_DETAILS, VIEW_BASIC_INFO
}

// Client
public class EmployeeManagement {
    public static void main(String[] args) {
        System.out.println("===== Proxy Design Pattern =====");

        // Demo for ADMIN user
        EmployeeDao admin = new EmployeeDaoProxy(1, "John", "HR", 30000.00, UserRole.ADMIN);
        admin.getEmployeeInfo();
        admin.displayEmployeeDetails();
        admin.createEmployee();
        admin.updateSalary(40000.00);
        admin.deleteEmployee();

        // Demo for HR user
        EmployeeDao hr = new EmployeeDaoProxy(2, "Jane", "HR", 25000.00, UserRole.HR);
        hr.getEmployeeInfo();
        hr.displayEmployeeDetails();
        // hr.createEmployee(); // Access Denied
        hr.updateSalary(30000.00);
        // hr.deleteEmployee(); // Access Denied

        // Demo for MANAGER user
        EmployeeDao manager = new EmployeeDaoProxy(3, "Bob", "IT", 20000.00, UserRole.MANAGER);
        manager.getEmployeeInfo();
        manager.displayEmployeeDetails();
        // manager.createEmployee(); // Access Denied
        // manager.updateSalary(30000.00); // Access Denied
        // manager.deleteEmployee(); // Access Denied

        // Demo for EMPLOYEE user
        EmployeeDao employee = new EmployeeDaoProxy(3, "Bob", "IT", 20000.00, UserRole.EMPLOYEE);
        employee.getEmployeeInfo();
        // employee.displayEmployeeDetails(); // Access Denied
        // employee.createEmployee(); // Access Denied
        // employee.updateSalary(30000.00); // Access Denied
        // employee.deleteEmployee(); // Access Denied
    }
}