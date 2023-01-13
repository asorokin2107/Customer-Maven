package org.example;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    private static String addCommand = "add Василий Петров vasya@mail.ru +799988877766";
    private static String commandExample = "\t" + addCommand + "\n"
            + "\tlist\n\tcount\n\tremove Василий Петров";
    private static String commandError = "Wrong command! Available command examples:\n " + commandExample;
    private static String helpText = "Command example: " + commandExample;

    public static void main(String[] args) throws IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        CustomerStorage executor = new CustomerStorage();
        while (true) {
            String command = scanner.nextLine();

            try {
                String[] tokens = command.split("\\s", 2);
                if (tokens[0].equals("add")) {
                    executor.addCustomer(tokens[1]);
                } else if (tokens[0].equals("list")) {
                    executor.listCustomer();
                } else if (tokens[0].equals("remove")) {
                    executor.removeCustomer(tokens[1]);
                } else if (tokens[0].equals("count")) {
                    System.out.println("There are " + executor.getCount() + " customer(s)");

                } else if (tokens[0].equals("help")) {
                    System.out.println(helpText);

                } else {
                    System.out.println(commandError);
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

        }

    }

}
