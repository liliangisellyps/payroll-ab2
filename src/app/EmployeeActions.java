package src.app;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import src.employees.Commissioned;
import src.employees.Employee;
import src.employees.Hourly;
import src.employees.Salaried;
import src.employees.UnionMember;
import src.payment.Payment;
import src.payment.Salary;

public class EmployeeActions {

    public static Employee addEmployee(Scanner input) {
        Employee employee;

        System.out.println("-----------------------------------");
        System.out.println("\nLet's start our employee registration!\n");
        System.out.println("-----------------------------------");

        String name = auxMethods.getNameFromInput(input);
        String address = auxMethods.getAddressFromInput(input);
        int employeeType = auxMethods.getTypeFromInput(input);
        int id = auxMethods.getIdFromInput(input);
        UnionMember unionMember = auxMethods.getUnionTradeInformationsFromInput(input);
        Payment payment = auxMethods.getPaymentInformationsFromInput(input);

        String paymentDay = " ";
        int salary;
        switch(employeeType){
            case 1: // Salaried
                salary = Salary.getSalaryFromInput(input);
                paymentDay = "Monthly - Last day of the month";
                employee = new Salaried(name, id, address, unionMember, payment, employeeType, paymentDay, salary);
                break;
            case 2: // Commissioned 
                paymentDay = "Bi-weekly - Friday";
                salary = Salary.getSalaryFromInput(input);
                System.out.println("What's the comission of your employee?\n");
                int comission = input.nextInt();
                employee = new Commissioned(name, id, address, unionMember, payment, employeeType, paymentDay, salary, comission, null);
                break;
            case 3: // Hourly
                paymentDay = "Weekly - Every friday";
                System.out.println("How much your employee is paid for hour worked?\n");
                int hourSalary = input.nextInt();
                employee = new Hourly(name, id, address, unionMember, payment, employeeType, paymentDay, hourSalary);
                break;
            default: 
                employee = new Employee(name, id, address, unionMember, payment, employeeType, paymentDay);
        }
        System.out.println("\nNew employee was successfully registered! Thank you.\n");
        System.out.println(employee.employeeInfos());
        System.out.println("\n\n\n\n");
        return employee;
    }
    
    public static void removeEmployee(Scanner input, List<Employee> employeesList) {
        printEmployees(input, employeesList);
        System.out.println("Which employee do you wanna remove? Enter the number correspondent.");
        int index = input.nextInt();
        employeesList.remove(index);
        System.out.println("Removed successfully!");
        System.out.println("\n\n\n\n");
    }

    public static void printEmployees(Scanner input, List<Employee> employeesList) {
        int i=0;
        System.out.println("Here's a list of all your employees:\n\n");
        for(Employee employee : employeesList){
            System.out.println("Employee " + i + " - ");
            System.out.println(employee.employeeInfos());
            System.out.println("\n\n");
            i++;
        }
    }

    public static void changeEmpInfos(Scanner input, List<Employee> employeesList) {
        printEmployees(input, employeesList);
        System.out.println("Which employee do you wanna make changes? Enter the number correspondent.");
        int index = input.nextInt();
        Employee employee = employeesList.get(index);
        int option = 1;
        while(option != 0){
            System.out.println("What do you wanna do?");
            System.out.println("1 - Change Name\n2 - Change Address\n3 - Change Type of Employee\n4 - Change Method of Payment\n5 - Change Union Trade Memembership\n6 - Change Union Trade ID\n7 - Change Union Trade Tax\n0 - Exit.");
            option = input.nextInt();               
            auxMethods.structures(option, employee, input);
        }
    }
}
