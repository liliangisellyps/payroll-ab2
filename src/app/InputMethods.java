package src.app;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputMethods {
    protected static boolean isInt(String in){
        return in != null && in.matches("\\d+");
    }

    public static String readString(Scanner input, String message){
        while(true){
            System.out.println(message);

            String in = input.nextLine();
            try {
                if(in.length() > 0){
                    System.out.println();
                    return in;
                }
            } catch(InputMismatchException ex){
                System.out.println("Ocorreu um erro! Por favor, tente novamente.\n");
            }
        }
    }

    protected static int readInt(Scanner input, String message){
        while(true){
            System.out.println(message);

            String in = input.nextLine();

            if(isInt(in)) {
                System.out.println();
                try {
                    return Integer.parseInt(in);
                } catch(NumberFormatException ex) {
                    System.out.println("Ocorreu um erro! Por favor, tente novamente, inserindo um número inteiro.\n");
                }
            }
            System.out.println("Ocorreu um erro! Por favor, tente novamente, inserindo um número inteiro.\n");
        }
    }
     public static int readBetween(Scanner input, String message, int start, int end){
        while(true){
            int option = readInt(input, message);

            if(option >= start && option <= end){
                System.out.println();
                return option;
            }
            System.out.println("Ocorreu um erro! Por favor, tente novamente.\n");
            System.out.println("Por favor, insira um número inteiro entre " + start + " e " + end + "\n");
        } 
    }

    protected static LocalDate SetDate(Scanner input){
        while(true){
            try {
                int day = readBetween(input, "Insira o dia", 1, 31);
                int month = readBetween(input, "Insira o número do mês:", 1, 12);
                int year = readInt(input, "Insira o ano:");

                LocalDate date = LocalDate.of(year, month, day);
                return date;
            } 
            catch (DateTimeException ex){
                System.out.println("Ocorreu um erro e essa data é inválida! Vamos tentar novamente.");
            }
        }
    }

    protected static LocalTime SetTime(Scanner input, String message){
        while(true) {
            System.out.println(message);
            System.out.println("Formato 24 horas.\n");
            try {
                int hour = readBetween(input, "Insira a hora", 0, 23);
                int minute = readBetween(input, "Insira os minutos:", 0, 59);

                LocalTime time = LocalTime.of(hour, minute);
                return time;
            }
            catch (Exception ex){
                System.out.println("Ocorreu um erro e essa hora é inválida! Vamos tentar novamente.");
            }
        }
    }
}
