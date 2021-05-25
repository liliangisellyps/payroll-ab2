package src.app;

import java.io.IOException;
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

     public static void clearconsole(){
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    public static void addTimeCard(Scanner input, List<Employee> employeesList) {
        EmployeeActions.printEmployees(input, employeesList);
        int index = InputMethods.readBetween(input, "Which employee do you wanna add a time card? Enter the number correspondent.", 0, employeesList.size()-1);

        Employee employee2 = (Employee) employeesList.get(index);
        if(employee2.getEmployeeType() != 3) {
            System.out.println("You can't add a time card to this employee. He/She is not an hourly employee");
            return;
        } else {
            Hourly employee = (Hourly) employeesList.get(index);
            LocalTime checkIn = InputMethods.SetTime(input, "Let's configure the Check-In");
            LocalTime checkOut = InputMethods.SetTime(input, "Now, let's configure the Check-Out");
            LocalDate date = InputMethods.SetDate(input);

            TimeCard timecard = new TimeCard(checkIn, checkOut, date);
            employee.getTimecard().add(timecard);

            System.out.println("TimeCard Successfully Added!");
            System.out.println("\n\n\n\n");
        }
    }

    public static void addSaleReport(Scanner input, List<Employee> employeesList) {
        EmployeeActions.printEmployees(input, employeesList);
        int index = InputMethods.readBetween(input, "For which employee do you wanna add a sales report? Enter the number correspondent.", 0, employeesList.size()-1);
        Employee employee2 = (Employee) employeesList.get(index);
        if(employee2.getEmployeeType() != 2) {
            System.out.println("You can't add a time card to this employee. He/She is not an commissioned employee.");
            return;
        } else {
            Commissioned employee = (Commissioned) employeesList.get(index);

            int priceOfSale = InputMethods.readInt(input, "Enter the price of the sale:");
            int dayOfMonth = InputMethods.readInt(input, "Enter the day of the month of the sale:");
            int month = InputMethods.readInt(input, "Enter the month of the sale:");
            int year = InputMethods.readInt(input, "Enter the year of the sale:");

            LocalDate dateOfSale = LocalDate.of(year, month, dayOfMonth);

            SaleReport saleReport = new SaleReport(dateOfSale, priceOfSale);
            employee.getSalesReport().add(saleReport);
            System.out.println("\nSale Report Successfully Added!");
            System.out.println("\n\n\n\n");
        }

    }

    public static void addServiceTaxes(Scanner input, List<Employee> employeesList) {
        EmployeeActions.printEmployees(input, employeesList);
        int index = InputMethods.readBetween(input, "Which employee do you wanna add a service tax? Enter the number correspondent.", 0, employeesList.size()-1);
        
        Employee employee = employeesList.get(index);
        
        if(employee.getUnionMember().getIdUT() == 0) {
            System.out.println("You can't add a time card to this employee. He/She is not an Union Member.");
            return;
        } else {
            int serviceTax = InputMethods.readInt(input, "Enter the Service Tax value:");
            employee.getUnionMember().setServiceTaxes(serviceTax);
            System.out.println("\nService Tax Successfully Added!\n\n\n\n");
        }
    }
}
