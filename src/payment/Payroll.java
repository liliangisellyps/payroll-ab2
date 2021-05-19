package src.payment;

import src.employees.Employee;

import java.util.ArrayList;
import java.util.List;

public class Payroll {
    public Company company;
    public Employee employee;
    public Salary salary;
    public List<String> schedule;
    
    public Payroll() {
        this.schedule = new ArrayList<String>();
    }
    public Payroll(Company company, Employee employee, Salary salary, String schedule) {
        this.company = company;
        this.employee = employee;
        this.salary = salary;
    }
    public List<String> getSchedule() {
        return schedule;
    }
    public void setSchedule(List<String> sch) {
        this.schedule = sch;
    }
    public void setSalary(Salary salary) {
        this.salary = salary;
    }
    public Salary getSalary() {
        return salary;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    public Employee getEmployee() {
        return employee;
    }
    public void setCompany(Company company) {
        this.company = company;
    }
    public Company getCompany() {
        return company;
    }
}
