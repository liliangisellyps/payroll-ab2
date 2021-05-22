package src.payment;


import java.util.Scanner;

import src.employees.Employee;

public class Salary extends Payroll{
    public Double value;
    public Double normalTaxes;
    public Double extraHours;
    public Salary(Company company, Employee employee, Salary salary, String schedule, Double value, Double normalTaxes,
            Double extraHours, Commissions comissions) {
        super(company, employee, salary, schedule);
        this.value = value;
        this.normalTaxes = normalTaxes;
        this.extraHours = extraHours;
    }
  
    public static int getSalaryFromInput(Scanner input) {
        System.out.println("Enter the Salary of your employee:\n");
        int salary = input.nextInt();
        return salary;
    }
}
