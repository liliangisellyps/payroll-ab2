package src.app.strategy;

import java.util.List;
import java.util.Scanner;

import src.employees.Employee;
import src.payment.Payroll;

public interface MenuController {
    public void executeAction(Scanner input, List<Employee> employeesList, Payroll payroll);
}
