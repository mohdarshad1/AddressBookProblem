package com.AddressBookProblem;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain {

    static Scanner sc = new Scanner(System.in);
    static AddressBook addBookObj = new AddressBook();

    public static void main(String[] args) {

        System.out.println("Welcome to Address book Management Program");

        boolean flag = true;

        while(flag){
            System.out.println("1.Add Contact");

            System.out.println("2.Edit Contact");

            System.out.println("3.Delete Contact");

            System.out.println("4.Exit");

            System.out.println("Enter Choice: ");

            int option = sc.nextInt();

            switch (option)
            {
                case 1: {
                    System.out.println("Enter the number of Contact to be Added: ");
                    int numberOfContacts = sc.nextInt();
                    for (int i = 0; i < numberOfContacts; i++) {
                        addBookObj.addContact();
                    }
                    break;
                }
                case 2: {
                    System.out.println("Enter the Person First name to edit details: ");
                    String person_name = sc.next();

                    boolean b = addBookObj.editContact(person_name);
                    if (b) {
                        System.out.println("Details Updated");
                    } else {
                        System.out.println("Contact Not Found");
                    }
                    break;
                }
                case 3: {
                    System.out.println("Enter the Contact to be deleted:");
                    String Name = sc.next();
                    boolean b1 = addBookObj.deleteContact(Name);
                    if (b1) {
                        System.out.println("Details Deleted");
                    } else {
                        System.out.println("Contact Not Found");
                    }
                    break;
                }
                case 4: {
                    flag =false;
                    break;
                }
            }
        }
    }

}