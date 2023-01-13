package org.example;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerStorage {

    private HashMap<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }


    public void addCustomer(String token) throws IllegalAccessException {

        String[] components = token.split("\\s");
        if(components.length != 4 ) {
            throw new IllegalAccessException("Wrong format!");
        } else if (!components[2].matches("[A-z]+@[A-z]+.[A-z].")) {
            throw new IllegalAccessException(("Wrong mail format!"));

        } else if (!components[3].matches("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$")) {
            throw new IllegalAccessException("Wrong phone format!");
        } else if (!components[0].matches("^[A-ЯЁ][а-яё]+")) {
            throw new IllegalAccessException("Wrong name format!");
        } else if (!components[1].matches("^[A-ЯЁ][а-яё]+")) {
            throw new IllegalAccessException("Wrong sureName format!");
        }

        String name = components[0] + " " + components[1];
        storage.put(name, new Customer(name, components[2], components[3]));
    }

    public void listCustomer() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String token) {
        storage.remove(token);
    }

    public int getCount() {
        return storage.size();
    }
}
