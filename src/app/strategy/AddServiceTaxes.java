package src.app.strategy;

import java.util.List;
import java.util.Scanner;

import src.app.AuxiliarActions;
import src.employees.Employee;
import src.payment.Payroll;

public class AddServiceTaxes implements MenuController {

    @Override
    public void executeAction(Scanner input, List<Employee> employeesList, Payroll payroll) {
        AuxiliarActions.addServiceTaxes(input, employeesList);
    }
    
}
