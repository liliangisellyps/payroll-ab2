package src.app;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.DayOfWeek;
// import java.time.MonthDay;
// import java.time.Month;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

import src.employees.Commissioned;
import src.employees.Employee;
import src.employees.Hourly;
import src.employees.Salaried;
import src.employees.SaleReport;
import src.employees.TimeCard;
import src.employees.UnionMember;
import src.payment.Payment;
import src.payment.Payroll;


public class EmployeeActions {

    public static Employee addEmployee(Scanner input) {
        Employee employee;

        System.out.println("-----------------------------------");
        System.out.println("\nLet's start our employee registration!\n");
        System.out.println("-----------------------------------");

        System.out.println("\nWhat's the name of the Employee?\n");
        String name = input.nextLine();

        System.out.println("\nWhat's the address of the Employee?\n");
        String address = input.nextLine();

        System.out.println("\nIs your new employee a Union Trade Member? Please enter only the number correspondent.\n");
        System.out.println("1- Yes\n2- No\n");
        int op = input.nextInt();
        UnionMember unionMember;
        if(op == 1) {
            System.out.println("\nEnter the Monthly Tax from the Union Trade\n");
            int monthlyTax = input.nextInt();
    
            System.out.println("\nEnter the Service Taxes from the Union Trade\n");
            int serviceTaxes = input.nextInt();
    
            int idUT = new Random().nextInt(10000);

            unionMember =  new UnionMember(monthlyTax, serviceTaxes, idUT);

            System.out.println("\nYour employee was successfully registered in the union trade system and his/hers ID is ");
            System.out.println(idUT);
        } else {
            unionMember =  new UnionMember(0, 0, 0);
        }

        System.out.println("Now, let's configure the payment informations!");
        System.out.println("What's the payment method of your employee's preference? Please enter only the number correspondent.\n");
        System.out.println("1 - Check sent by mail\n2 - Check delivered on hands\n3 - Bank Account Deposit\n");
       
        int paymentMethod = input.nextInt();;

        System.out.println("Now, enter your employee bank's number\n");
        int bank = input.nextInt();

        System.out.println("And his/hers agency correspondent number\n");
        int agency = input.nextInt();

        System.out.println("Enter his/hers account number\n");
        int account = input.nextInt();

        Payment payment = new Payment(paymentMethod, bank, agency, account);


        System.out.println("Finally, what's the type of the Employee? Please enter only the number correspondent.\n1 - Salaried\n2 - Commissioned\n3 - Hourly\n");
        int employeeType = input.nextInt();
        String paymentDay = " ";
        int salary;
        int id = new Random().nextInt(10000);
        switch(employeeType){
            case 1: // Salaried
                System.out.println("Enter the Salary of your employee:\n");
                salary = input.nextInt();
                paymentDay = "Monthly - Last day of the month";
                employee = new Salaried(name, id, address, unionMember, payment, employeeType, paymentDay, salary);
                break;
            case 2: // Commissioned 
                paymentDay = "Bi-weekly - Friday";
                System.out.println("Enter the Salary of your employee:\n");
                salary = input.nextInt();
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

    private static void printEmployees(Scanner input, List<Employee> employeesList) {
        int i=0;
        System.out.println("Here's a list of all your employees:\n\n");
        for(Employee employee : employeesList){
            System.out.println("Employee " + i + " - ");
            System.out.println(employee.employeeInfos());
            System.out.println("\n\n");
            i++;
        }
    }

    public static void addTimeCard(Scanner input, List<Employee> employeesList) {
        printEmployees(input, employeesList);
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
        printEmployees(input, employeesList);
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
        printEmployees(input, employeesList);
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

    public static void changeEmpInfos(Scanner input, List<Employee> employeesList) {
        printEmployees(input, employeesList);
        System.out.println("Which employee do you wanna make changes? Enter the number correspondent.");
        int index = input.nextInt();
        Employee employee = employeesList.get(index);
        int option = 1;
        int op;
        while(option != 0){

            System.out.println("What do you wanna do?");
            System.out.println("1 - Change Name\n2 - Change Address\n3 - Change Type of Employee\n4 - Change Method of Payment\n5 - Change Union Trade Memembership\n6 - Change Union Trade ID\n7 - Change Union Trade Tax\n0 - Exit.");
            option = input.nextInt();
            switch(option){
                case 1:
                    System.out.println("This is the name of your employee:");
                    System.out.println(employee.getName());
                    System.out.println("Are you sure you want to change it? Press '1' to 'Yes and '0' to 'No'");
                    op = input.nextInt();
                    input.nextLine();
                    if(op == 1){
                        System.out.println("Enter new name.");
                        String newName = input.nextLine();
                        employee.setName(newName);
                        System.out.println("This is your employee's new name:");
                        System.out.println(employee.getName());
                    }
                    break;
                case 2:
                    System.out.println("This is the address of your employee:");
                    System.out.println(employee.getAddress());
                    System.out.println("Are you sure you want to change it? Press '1' to 'Yes and '0' to 'No'");
                    op = input.nextInt();
                    input.nextLine();
                    if(op == 1){
                        System.out.println("Enter new address.");
                        employee.setAddress(input.nextLine());
                        System.out.println("This is your employee's new address:");
                        System.out.println(employee.getAddress());
                    }
                    break;
                case 3:
                    System.out.println("This is the type of your employee:");
                    System.out.println(employee.employeeTypeToString());
                    System.out.println("Are you sure you want to change it? Press '1' to 'Yes and '0' to 'No'");
                    op = input.nextInt();
                    input.nextLine();
                    if(op == 1){
                        System.out.println("Enter new type. (1 for Salaried, 2 for Commisioned and 3 for Hourly.");
                        employee.setEmployeeType(input.nextInt());
                        System.out.println("This is your employee's new type:");
                        System.out.println(employee.employeeTypeToString());
                    }
                    break;
                case 4:
                    System.out.println("This is the method of payment of your employee:");
                    System.out.println(employee.getPayment().paymentMethodToString());
                    System.out.println("Are you sure you want to change it? Press '1' to 'Yes and '0' to 'No'");
                    op = input.nextInt();
                    input.nextLine();
                    if(op == 1){
                        System.out.println("Enter new payment method. (1 for Mail Check, 2 for Hand Check and 3 for Bank Deposit.\n");
                        int newMet = input.nextInt();
                        employee.getPayment().setPaymentMethod(newMet);
                        System.out.println("This is your employee's new payment method:");
                        System.out.println(employee.getPayment().paymentMethodToString());
                    }
                    break;
                case 5:
                    System.out.println("Your employee is currently");
                    if(employee.getUnionMember().getIdUT() == 0) System.out.println("not");
                    System.out.println("associated to the Union Trade. Are you sure you want to change it?\n");
                    System.out.println("Press '1' to 'Yes' and '0' to 'No'");
                    option = input.nextInt();
                    if(option == 1 && employee.getUnionMember().getIdUT() == 0) {
                        System.out.println("\nEnter the Monthly Tax from the Union Trade\n");
                        employee.getUnionMember().setMonthlyTax(input.nextInt());
                        System.out.println("\nEnter the Service Taxes from the Union Trade\n");
                        employee.getUnionMember().setServiceTaxes(input.nextInt());
                        int idUT = new Random().nextInt(10000);
                        employee.getUnionMember().setIdUT(idUT);
                        System.out.println("Your employee is now associated to the Union Trade.");
                    } else if (option == 1 && employee.getUnionMember().getIdUT() != 0) {
                        employee.getUnionMember().setIdUT(0);
                        System.out.println("Your employee isn't associated to the Union Trade anymore.");
                    }
                    break;
                case 6:
                    System.out.println("Your employee's union trade id is:");
                    System.out.println(employee.getUnionMember().getIdUT());
                    System.out.println("Are you sure you want to change it?");
                    System.out.println("Press '1' to 'Yes' and '0' to 'No'\n");
                    option = input.nextInt();
                    if(option == 1){
                        int idUT = new Random().nextInt(10000);
                        employee.getUnionMember().setIdUT(idUT);
                        System.out.println("Your new ID is");
                        System.out.println(employee.getUnionMember().getIdUT());
                    }
                    break;
                case 7:
                    System.out.println("The current service monthly tax is:");
                    System.out.println(employee.getUnionMember().getMonthlyTax());
                    System.out.println("Are you sure you want to change it?");
                    System.out.println("Press '1' to 'Yes' and '0' to 'No'\n");
                    option = input.nextInt();
                    if(option == 1){
                        System.out.println("Enter new service tax.");
                        employee.getUnionMember().setMonthlyTax(input.nextInt());
                        System.out.println("Your new  service monthly tax is:");
                        System.out.println(employee.getUnionMember().getMonthlyTax());
                    }
                    break;
            }

        }
    }
    public static void payEmployees(Scanner input, List<Employee> employeesList, Payroll payroll) {
        printEmployees(input, employeesList);
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
        printEmployees(input, employeesList);
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
