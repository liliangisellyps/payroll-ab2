package src.app;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import src.employees.Commissioned;
import src.employees.Employee;
import src.employees.Hourly;
import src.employees.SaleReport;
import src.employees.TimeCard;

public class AuxiliarActions {

    public static void addTimeCard(Scanner input, List<Employee> employeesList) {
        EmployeeActions.printEmployees(input, employeesList);
        System.out.println("Which employee do you wanna add a time card? Enter the number correspondent.");
        int index = input.nextInt();
        Hourly employee = (Hourly) employeesList.get(index);
        if(employee.getEmployeeType() != 3) {
            System.out.println("You can't add a time card to this employee. He/She is not an hourly employee");
            return;
        } else {
            System.out.println("Enter the hour the employee got in:");
            int hourIn = input.nextInt();
            System.out.println("Enter the minute the employee got in:");
            int minuteIn = input.nextInt();
            LocalTime checkIn = LocalTime.of(hourIn, minuteIn);

            System.out.println("Enter the hour the employee got out:");
            int hourOut = input.nextInt();
            System.out.println("Enter the minute the employee got out:");
            int minuteOut = input.nextInt();
            LocalTime checkOut = LocalTime.of(hourOut, minuteOut);

            System.out.println("Enter the day of the month of the time card:");
            int dayOfMonth = input.nextInt();
            System.out.println("Enter the month of the time card:");
            int month = input.nextInt();
            System.out.println("Enter the year of the time card:");
            int year = input.nextInt();

            LocalDate date = LocalDate.of(year, month, dayOfMonth);

            TimeCard timecard = new TimeCard(checkIn, checkOut, date);
            employee.getTimecard().add(timecard);

            System.out.println("TimeCard Successfully Added!");
            System.out.println("\n\n\n\n");
        }
    }

    public static void addSaleReport(Scanner input, List<Employee> employeesList) {
        EmployeeActions.printEmployees(input, employeesList);
        System.out.println("Which employee do you wanna add a sales report? Enter the number correspondent.");
        int index = input.nextInt();
        Commissioned employee = (Commissioned) employeesList.get(index);
        if(employee.getEmployeeType() != 2) {
            System.out.println("You can't add a time card to this employee. He/She is not an commissioned employee.");
            return;
        } else {
            System.out.println("Enter the price of the sale:");
            int priceOfSale = input.nextInt();
            
            System.out.println("Enter the day of the month of the sale:");
            int dayOfMonth = input.nextInt();
            System.out.println("Enter the month of the sale:");
            int month = input.nextInt();
            System.out.println("Enter the year of the sale:");
            int year = input.nextInt();

            LocalDate dateOfSale = LocalDate.of(year, month, dayOfMonth);

            SaleReport saleReport = new SaleReport(dateOfSale, priceOfSale);
            employee.getSalesReport().add(saleReport);
            System.out.println("\nSale Report Successfully Added!");
            System.out.println("\n\n\n\n");
        }

    }

    public static void addServiceTaxes(Scanner input, List<Employee> employeesList) {
        EmployeeActions.printEmployees(input, employeesList);
        System.out.println("Which employee do you wanna add a service tax? Enter the number correspondent.");
        int index = input.nextInt();
        Employee employee = employeesList.get(index);
        if(employee.getUnionMember().getIdUT() == 0) {
            System.out.println("You can't add a time card to this employee. He/She is not an Union Member.");
            return;
        } else {
            System.out.println("Enter the Service Tax value:");
            int serviceTax = input.nextInt();
            employee.getUnionMember().setServiceTaxes(serviceTax);
            System.out.println("\nService Tax Successfully Added!");
            System.out.println("\n\n\n\n");

        }
    }
}
