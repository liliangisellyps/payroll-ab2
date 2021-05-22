package src.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import src.employees.Employee;
import src.payment.Payroll;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int option = 0;
        List<Employee> employeesList = new ArrayList<Employee>();
        Payroll payroll = new Payroll();
        payroll.schedule.add("Monthly - Last day of the month");
        payroll.schedule.add("Bi-weekly - Friday");
        payroll.schedule.add("Weekly - Every friday");

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

            option = input.nextInt();
            input.nextLine();
           
            if(option == 2 || option == 3 || option == 4 || option == 5 || option == 6 || option == 7 || option == 9) {
                if(employeesList.isEmpty()) System.out.println("There's no employee in the system.");
                break;
            }
            switch(option) {
                case 1: // register new employee
                    employeesList.add(EmployeeActions.addEmployee(input));
                    break;
                case 2: // remove a employee
                    EmployeeActions.removeEmployee(input, employeesList);
                    break;
                case 3: // add time card
                    AuxiliarActions.addTimeCard(input, employeesList);
                    break;
                case 4: // add sale report
                    AuxiliarActions.addSaleReport(input, employeesList);
                    break;
                case 5: // add service taxes
                    AuxiliarActions.addServiceTaxes(input, employeesList);
                    break;
                case 6: // Change Employee Infos
                    EmployeeActions.changeEmpInfos(input, employeesList);
                    break;
                case 7: // Pay Employees
                    PaymentActions.payEmployees(input, employeesList, payroll);
                    break;
                case 8: // undo/redo
                    PaymentActions.undoRedo(input);
                    break;
                case 9: // Change Payment Day
                    PaymentActions.changePayDay(input, employeesList, payroll);
                    break;
                case 10: // Create New Payment Schedule
                    PaymentActions.createSchedule(input, payroll);
                    break;
                case 11:
                    System.out.println("Thank You for using the system. Bye!");
                    break;
                default:
                    break;
            }
            System.out.println("\n\n\n");
        }
        input.close();
    }
}
