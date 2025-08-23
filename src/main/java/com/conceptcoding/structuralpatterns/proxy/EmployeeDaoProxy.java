package com.conceptcoding.structuralpatterns.proxy;

// Proxy class - controls access to RealEmployee
public class EmployeeDaoProxy implements EmployeeDao {

    // Reference to the RealSubject
    EmployeeDaoImpl realEmployee;

    public EmployeeDaoProxy(int id, String name, String department, Double salary, UserRole role) {
        realEmployee = new EmployeeDaoImpl(id, name, department, salary, role);
    }

    // Access control for viewing complete employee details
    public void displayEmployeeDetails() {
        if (hasAccessForRole(AccessType.VIEW_ALL_DETAILS, this.realEmployee.role)) {
            this.realEmployee.displayEmployeeDetails();
        } else {
            throw new RuntimeException("Access Denied");
        }
    }

    // Access control for salary updates
    public void updateSalary(double newSalary) {
        if (hasAccessForRole(AccessType.UPDATE, this.realEmployee.role)) {
            this.realEmployee.updateSalary(newSalary);
        } else {
            throw new RuntimeException("Access Denied");
        }
    }

    // Access control for employee deletion
    public void deleteEmployee() {
        if (hasAccessForRole(AccessType.DELETE, this.realEmployee.role)) {
            this.realEmployee.deleteEmployee();
        } else {
            throw new RuntimeException("Access Denied");
        }
    }

    // Access control for employee creation - resource intensive
    public void createEmployee() {
        if (hasAccessForRole(AccessType.CREATE, this.realEmployee.role)) {
            this.realEmployee.createEmployee();
        } else {
            throw new RuntimeException("Access Denied");
        }
    }

    // All employees can view basic info
    public void getEmployeeInfo() {
        if (hasAccessForRole(AccessType.VIEW_BASIC_INFO, this.realEmployee.role)) {
            this.realEmployee.getEmployeeInfo();
        }
    }

    // Helper method to simulate different access capabilities for different roles
    private boolean hasAccessForRole(AccessType acesssType, UserRole role) {
        return switch (acesssType) {
            case AccessType.CREATE, AccessType.DELETE -> role == UserRole.ADMIN;
            case AccessType.UPDATE -> role == UserRole.ADMIN || role == UserRole.HR;
            case AccessType.VIEW_ALL_DETAILS -> role == UserRole.MANAGER || role == UserRole.HR || role == UserRole.ADMIN;
            case AccessType.VIEW_BASIC_INFO -> role == UserRole.EMPLOYEE || role == UserRole.MANAGER || role == UserRole.HR || role == UserRole.ADMIN;
            default -> false;
        };
    }
}
