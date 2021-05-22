package src.app;

import java.time.LocalDate;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

import src.employees.Employee;
import src.payment.Payroll;

public class PaymentActions {

    public static void payEmployees(Scanner input, List<Employee> employeesList, Payroll payroll) {
        EmployeeActions.printEmployees(input, employeesList);
        LocalDate today = LocalDate.now();
        List<Employee> employeesToPay = new ArrayList<Employee>();
        int size = employeesList.size();
        int i;

        if(today.getDayOfMonth() == 27 || today.getDayOfMonth() == 29 || today.getDayOfMonth() == 30 ||today.getDayOfMonth() == 31){
            // pay salaried
            System.out.println("Today is " + today.getDayOfMonth() + " of " + today.getMonth() + ". It's time to pay salaried employees.\n");
            System.out.println("These are the employees that got paid today:\n");
            for(i = 0; i < size; i++){
                if(employeesList.get(i).getPaymentDay() == "Monthly - Last day of the month"){
                    employeesToPay.add(employeesList.get(i));
                    System.out.println(employeesList.get(i).getName());
                    System.out.println("\n");
                }
            }
        }
        else if(today.getDayOfWeek() == DayOfWeek.FRIDAY){
            // pay hourly
            System.out.println("Today is " + today.getDayOfWeek() + ". It's time to pay Hourly employees.\n");
            System.out.println("These are the employees that got paid today:\n");
            for(i = 0; i < size; i++){
                if(employeesList.get(i).getPaymentDay() == "Weekly - Every friday"){
                    employeesToPay.add(employeesList.get(i));
                    System.out.println(employeesList.get(i).getName());
                    System.out.println("\n");
                }
            }
            int fridays = 0;



            if(fridays % 2 == 0){
                // pay commissioned
                System.out.println("Today is " + today.getDayOfWeek() + ". It's time to pay commissioned employees.\n");
                System.out.println("These are the employees that got paid today:\n");
                for(i = 0; i < size; i++){
                    if(employeesList.get(i).getPaymentDay() == "Bi-weekly - Friday"){
                        employeesToPay.add(employeesList.get(i));
                        System.out.println(employeesList.get(i).getName());
                        System.out.println("\n");
                    }
                }
            }
            fridays++;
        } else System.out.println("The company don't have any employees to pay today.\n");
    }

    public static void printSchedule(List<String> sch) {
        int size = sch.size();
        for(int i=0; i < size; i++){
            System.out.println(sch.get(i));
        }
    }
    public static void changePayDay(Scanner input, List<Employee> employeesList, Payroll payroll) {
        EmployeeActions.printEmployees(input, employeesList);
        System.out.println("Which employee do you wanna change the payment day? Enter the number correspondent.");
        int index = input.nextInt();
        Employee employee = employeesList.get(index);
        int op;

        System.out.println("This is the payment day of your employee: \n");
        int empType = employee.getEmployeeType();
        if(empType == 1) System.out.println("Last day of the month, monthly");
        else if (empType == 2) System.out.println("Friday, bi-weekly");
        else if (empType == 3) System.out.println("Every friday, weekly"); // Hourly
        else System.out.println();
 
        System.out.println("\nAre you sure you want to change it? Press '1' to 'Yes and '0' to 'No'\n");
        op = input.nextInt();
        input.nextLine();
        
        if(op == 1){
            System.out.println("\nEnter the payment method of your preference. Copy and paste the string.\n");
            printSchedule(payroll.schedule);
            String newPayDay = input.nextLine();
            employee.setPaymentDay(newPayDay);
            System.out.println("\n\nThis is your employee's new payday:");
            System.out.println(employee.getPaymentDay());
        }
    }

    public static void createSchedule(Scanner input, Payroll payroll) {
        System.out.println("You can create a new schedule of payment. Here are a few examples.\n");
        System.out.println("Monthly 1: pays every day 1 \n");
        System.out.println("Monthly 7: pays every day 7\n");
        System.out.println("Monthly L: pays last day of the month\n");
        System.out.println("Weekly M: pays every monday of every week\n");
        System.out.println("Bi-Weekly M: pays every two mondays\n");

        System.out.println("Please enter the new schedule.");
        String sch = input.nextLine();
        payroll.schedule.add(sch);
        System.out.println("\n\nPayment Schedule created successfullly!");
        System.out.println("\n\nNow, you have these options of schedule:");  
        printSchedule(payroll.schedule);
    }

    public static void undoRedo(Scanner input){
        System.out.println("Press '0' to undo previous action and '1' to redo.");
        int op = input.nextInt();
        if(op == 0) System.out.println("Previous action undone.");
        else if (op == 1) System.out.println("Previous action redone.");
    }

}
