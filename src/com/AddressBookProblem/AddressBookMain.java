package com.AddressBookProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookMain {

    static Scanner sc = new Scanner(System.in);
    public Map<String,AddressBook> bookList = new HashMap<>();

    public static void main(String[] args) {

        System.out.println("Welcome to Address book Management Program");
        AddressBookMain addBookMain = new AddressBookMain();
        boolean flag =true;
        while(flag)
        {
            System.out.println("1.Add New Address Book");
            System.out.println("2.Exit");
            System.out.println("Enter choice: ");
            int option = sc.nextInt();
            switch (option){
                case 1: {
                    System.out.println("Enter the Name of Address Book: ");
                    String bookName = sc.next();
                    if(addBookMain.bookList.containsKey(bookName)){
                        System.out.println("The Address book Already Exists");
                        break;
                    }else {
                        addBookMain.addAddressBook(bookName);
                        break;
                    }
                }
                case 2:{
                    flag = false;
                    break;
                }
            }
        }
    }

    public void addAddressBook(String bookName){
        boolean flag = true;
        AddressBook addBookObj = new AddressBook();
        while(flag){
            System.out.println("1.Add Contact");

            System.out.println("2.Edit Contact");

            System.out.println("3.Delete Contact");

            System.out.println("4.Exit");

            System.out.println("Enter Choice: ");
            ArrayList<Contact> list = null;
            int option = sc.nextInt();

            switch (option)
            {
                case 1: {
                        addBookObj.addContact();
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
        bookList.put(bookName,addBookObj);
        System.out.println("Address Book Added Successfully");
    }
}