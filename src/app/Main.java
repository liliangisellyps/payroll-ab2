package src.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import src.employees.Employee;
import src.payment.Payroll;

import src.app.strategy.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int option = 0;

        List<Employee> employeesList = new ArrayList<Employee>();

        Payroll payroll = new Payroll();

        payroll.schedule.add("Monthly - Last day of the month");
        payroll.schedule.add("Bi-weekly - Friday");
        payroll.schedule.add("Weekly - Every friday");

        List<MenuController> menuControllers = new ArrayList<MenuController>();
        
        menuControllers.add(new AddEmployee());
        menuControllers.add(new RemoveEmployee());
        menuControllers.add(new AddTimeCard());
        menuControllers.add(new AddSaleReport());
        menuControllers.add(new AddServiceTaxes());
        menuControllers.add(new ChangeEmpInfos());
        menuControllers.add(new PayEmployees());
        menuControllers.add(new UndoRedo());
        menuControllers.add(new ChangePayDay());
        menuControllers.add(new CreateSchedule());
        
        AuxiliarActions.clearconsole();
        
        while(option != 11){ 
            System.out.println("-----------------------------------");
            System.out.println("\nWelcome to the payroll system!\n");
            System.out.println("-----------------------------------");
            System.out.println("What would you like to do? Please choose an option below:\n");
            System.out.println("1 - Add Employee\n");
            System.out.println("2 - Remove Employee\n");
            System.out.println("3 - Add TimeCard\n");
            System.out.println("4 - Add Sale Report\n");
            System.out.println("5 - Add Service Taxes\n");
            System.out.println("6 - Modify Employee Infos\n");
            System.out.println("7 - Pay Employees\n");
            System.out.println("8 - Undo/redo previous action\n");
            System.out.println("9 - Change Payment Day\n");
            System.out.println("10 - Create New Payment Schedule\n");
            System.out.println("11 - Exit System");
            System.out.print("\nOption: ");

            option = InputMethods.readBetween(input, "", 0, 11);
            AuxiliarActions.clearconsole();
            System.out.println(option);
            if(option >= 1 && option <= 10) {
                if(option != 1 && option != 9 && option != 10 && employeesList.isEmpty()) {
                    System.out.println("\n\n\nThere's no employee in the system.");
                } else {
                    menuControllers.get(option - 1).executeAction(input, employeesList, payroll);
                }
            } else if(option == 11) {
                System.out.println("Thank You for using the system. Bye!");
            } else { 
                System.out.println("Choose a valid option.");
            }
            System.out.println("\n\n\n");
        }
        input.close();
    }
}

