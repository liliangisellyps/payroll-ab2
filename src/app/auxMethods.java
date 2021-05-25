package src.app;
import java.util.Random;
import java.util.Scanner;

import src.employees.Employee;
import src.employees.UnionMember;
import src.payment.Payment;


public class AuxMethods {
    public static String getNameFromInput(Scanner input) {
        return InputMethods.readString(input, "\nWhat's the name of the Employee?\n");
    }

    public static String getAddressFromInput(Scanner input) {
        return InputMethods.readString(input, "\nWhat's the address of the Employee?\n");
    }
    public static int getTypeFromInput(Scanner input) {
        return InputMethods.readBetween(input, "What's the type of the Employee? Please enter only the number correspondent.\n1 - Salaried\n2 - Commissioned\n3 - Hourly\n", 1, 3);
    }
    public static int getIdFromInput(Scanner input) {
        return new Random().nextInt(10000);
    }

    public static UnionMember getUnionTradeInformationsFromInput(Scanner input) {
        int op = InputMethods.readBetween(input, "\nIs your new employee a Union Trade Member? Please enter only the number correspondent.\n1- Yes\n2- No\n", 1, 2);
        UnionMember unionMember;
        if(op == 1) {
            int monthlyTax = InputMethods.readInt(input, "\nEnter the Monthly Tax from the Union Trade\n");
    
            int serviceTaxes = InputMethods.readInt(input, "\nEnter the Service Taxes from the Union Trade\n");
    
            int idUT = new Random().nextInt(10000);

            unionMember =  new UnionMember(monthlyTax, serviceTaxes, idUT);

            System.out.println("\nYour employee was successfully registered in the union trade system and his/hers ID is " + idUT + "\n");
        } else {
            unionMember =  new UnionMember(0, 0, 0);
        }
        return unionMember;
    }

    public static Payment getPaymentInformationsFromInput(Scanner input) {
         System.out.println("Now, let's configure the payment informations!\n");
        System.out.println("What's the payment method of your employee's preference? Please enter only the number correspondent.\n");
        System.out.println("1 - Check sent by mail\n2 - Check delivered on hands\n3 - Bank Account Deposit\n");
       
        int paymentMethod = InputMethods.readBetween(input, "", 1, 3);

        int bank = InputMethods.readInt(input, "Now, enter your employee bank's number\n");

        int agency = InputMethods.readInt(input, "And his/hers agency correspondent number\n");

        int account = InputMethods.readInt(input, "Enter his/hers account number\n");

        Payment payment = new Payment(paymentMethod, bank, agency, account);

        return payment;
    }
    public static void structures(int optionNumber, Employee employee, Scanner input) {
        switch(optionNumber){
            case 1:
                System.out.println("This is the name of your employee:");
                System.out.println(employee.getName());
            break;
            case 2:
                System.out.println("This is the address of your employee:");
                System.out.println(employee.getAddress());
            break;
            case 3:
                System.out.println("This is the Type of your employee:");
                System.out.println(employee.employeeTypeToString());
            break;
            case 4:
                System.out.println("This is the payment method of your employee:");
                System.out.println(employee.getPayment().paymentMethodToString());
            break;
            case 5:
                System.out.println("Your employee is currently");
                if(employee.getUnionMember().getIdUT() == 0) System.out.println("not");
                System.out.println("associated to the Union Trade");
            break;
            case 6:
                System.out.println("This is the Union Trade ID of your employee");
                System.out.println(employee.getUnionMember().getIdUT());
            break;
            case 7:
                System.out.println("This is the Union Trade tax of your employee:");
                System.out.println(employee.getUnionMember().getMonthlyTax());
            break;
        }
        if(optionNumber != 0){
            int op = InputMethods.readBetween(input, "Are you sure you want to change it? Press '1' to 'Yes and '0' to 'No'\n", 0, 1);
            
            if(op == 1){
                switch(optionNumber){
                    case 1:
                        changeName(input, employee);
                    break;
                    case 2:
                        changeAddress(input, employee);
                    break;
                    case 3:
                        changeType(input, employee);
                    break;
                    case 4:
                        changePayMethod(input, employee);
                    break;
                    case 5:
                        changeUTMembership(input, employee);
                    break;
                    case 6:
                        changeId(input, employee);
                    break;
                    case 7:
                        changeServiceTax(input, employee);
                    break;
                }
            }
        }
    }

    public static void changeName(Scanner input, Employee employee) {
        String newName = InputMethods.readString(input, "Enter new name.\n");

        employee.setName(newName);
        System.out.println("This is your employee's new name:");
        System.out.println(employee.getName());
        System.out.println("\n");
    }
    public static void changeAddress(Scanner input, Employee employee) {
        employee.setAddress(InputMethods.readString(input, "Enter new address.\n"));
        System.out.println("This is your employee's new address:");
        System.out.println(employee.getAddress());
        System.out.println("\n");
    }
    public static void changeType(Scanner input, Employee employee) {
        employee.setEmployeeType(InputMethods.readBetween(input, "Enter new type. (1 for Salaried, 2 for Commisioned and 3 for Hourly.)", 1, 3));
        System.out.println("This is your employee's new type:");
        System.out.println(employee.employeeTypeToString());
        System.out.println("\n");
    }
    public static void changePayMethod(Scanner input, Employee employee) {
        int newMet = InputMethods.readBetween(input, "Enter new payment method. (1 for Mail Check, 2 for Hand Check and 3 for Bank Deposit.)\n", 1, 3);
        employee.getPayment().setPaymentMethod(newMet);
        System.out.println("This is your employee's new payment method:");
        System.out.println(employee.getPayment().paymentMethodToString());
        System.out.println("\n");
    }
    public static void changeUTMembership(Scanner input, Employee employee) {
         if(employee.getUnionMember().getIdUT() == 0) {
            int monthlyTax = InputMethods.readInt(input, ("\nEnter the Monthly Tax from the Union Trade\n"));
            employee.getUnionMember().setMonthlyTax(monthlyTax);
            
            int serviceTaxes = InputMethods.readInt(input, "\nEnter the Service Taxes from the Union Trade\n");
            employee.getUnionMember().setServiceTaxes(serviceTaxes);
            int idUT = new Random().nextInt(10000);
            employee.getUnionMember().setIdUT(idUT);
            System.out.println("Your employee is now associated to the Union Trade.\n");
        } else if (employee.getUnionMember().getIdUT() != 0) {
            employee.getUnionMember().setIdUT(0);
            System.out.println("Your employee isn't associated to the Union Trade anymore.\n");
        } 
        System.out.println("\n");
    }
    public static void changeId(Scanner input, Employee employee) {
        int idUT = new Random().nextInt(10000);
        employee.getUnionMember().setIdUT(idUT);
        System.out.println("Your new ID is");
        System.out.println(employee.getUnionMember().getIdUT());
        System.out.println("\n");
    }
    public static void changeServiceTax(Scanner input, Employee employee) {
        int serviceTaxes = InputMethods.readInt(input, "\nEnter new service tax.\n");
        employee.getUnionMember().setMonthlyTax(serviceTaxes);
        System.out.println("Your new  service monthly tax is:");
        System.out.println(employee.getUnionMember().getMonthlyTax());
        System.out.println("\n");

    }
}
