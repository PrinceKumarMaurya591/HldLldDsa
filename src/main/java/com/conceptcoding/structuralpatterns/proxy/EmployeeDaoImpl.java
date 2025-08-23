package com.conceptcoding.structuralpatterns.proxy;

// RealSubject - the actual employee object that does the real work
public class EmployeeDaoImpl implements EmployeeDao {

    int id;
    String name;
    String department;
    Double salary;
    UserRole role;

    public EmployeeDaoImpl(int id, String name, String department, Double salary, UserRole role) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.role = role;
    }

    @Override
    public void displayEmployeeDetails() {
        System.out.println("Employee Details: " + "Id: " + id + ", Name: " + name + ", Department: " + department + ", Salary: Rs" + salary + ", Role: " + role);
    }

    @Override
    public void updateSalary(double newSalary) {
        this.salary = newSalary;
        System.out.println("Salary updated to: Rs. " + newSalary);
    }

    @Override
    public void deleteEmployee() {
        System.out.println("Employee " + name + " has been deleted from the system.");
    }

    @Override
    public void createEmployee() {
        System.out.println("Employee " + name + " has been created in the system.");
    }

    @Override
    public void getEmployeeInfo() {
        System.out.println("Employee Info:" + " Name: " + name + ", Department: " + department);
    }

}
