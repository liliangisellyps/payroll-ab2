package src.app.strategy;

import java.util.List;
import java.util.Scanner;

import src.app.EmployeeActions;
import src.employees.Employee;
import src.payment.Payroll;

public class RemoveEmployee implements MenuController {

    @Override
    public void executeAction(Scanner input, List<Employee> employeesList, Payroll payroll) {
        EmployeeActions.removeEmployee(input, employeesList);
    }
    
}
