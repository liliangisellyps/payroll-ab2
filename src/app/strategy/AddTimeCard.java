package src.app.strategy;

import java.util.List;
import java.util.Scanner;

import src.app.AuxiliarActions;
import src.employees.Employee;
import src.payment.Payroll;

public class AddTimeCard implements MenuController {

    @Override
    public void executeAction(Scanner input, List<Employee> employeesList, Payroll payroll) {
        AuxiliarActions.addTimeCard(input, employeesList);
    }
    
}
