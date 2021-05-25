package src.app.strategy;

import java.util.List;
import java.util.Scanner;

import src.app.PaymentActions;
import src.employees.Employee;
import src.payment.Payroll;

public class CreateSchedule implements MenuController {

    @Override
    public void executeAction(Scanner input, List<Employee> employeesList, Payroll payroll) {
        PaymentActions.createSchedule(input, payroll);
    }
    
}
