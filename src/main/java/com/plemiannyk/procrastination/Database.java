package com.plemiannyk.procrastination;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Database {
    private static final String[] FIRSTNAMES = {"Liam", "Noah", "Oliver", "Elijah", "William", "James", "Benjamin", "Lucas", "Henry", "Alexander", "Mason", "Michael", "Ethan", "Daniel", "Jacob", "Logan", "Jackson", "Olivia", "Ema", "Mia"};
    private static final String[] LASTNAMES = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis", "Rodriguez", "Martinez", "Hernandez", "Lopez", "Gonzalez", "Wilson", "Anderson", "Thomas", "Taylor", "Moore", "Jackson", "Martin"};
    ArrayList<String> fname_data = new ArrayList<String>();
    ArrayList<String> lname_data = new ArrayList<String>();

    private static String getRandomFName() {
        return FIRSTNAMES[new Random().nextInt(FIRSTNAMES.length)];
    }

    private static String getRandomLName() {
        return LASTNAMES[new Random().nextInt(LASTNAMES.length)];
    }

    private static int getRandomAge() {
        return new Random().nextInt(30) + 18;
    }

    HashMap<Integer, String> users = new HashMap<>();

    public String fnames() {
        return getRandomFName();
    }

    public String lnames() {
        return getRandomLName();
    }

    public void friends() {
        for (int i = 0; i <= 10; i++) {
            users.put(i, fnames().concat(" " + lnames()) + "\n");
        }
    }

    public String print_users() {

        String content;
        friends();
        content = users.toString();
        return content;
    }



}
