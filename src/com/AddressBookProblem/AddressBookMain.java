package com.AddressBookProblem;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        AddressBookMain addBookMain = new AddressBookMain();
        addBookMain.addContactToAddressBook();
    }

    public void addContactToAddressBook(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter First Name: ");
        String firstname = sc.next();

        System.out.println("Enter last name: ");
        String lastname = sc.next();

        System.out.println("Enter Address: ");
        String address = sc.next();

        sc.nextLine();

        System.out.println("Enter City: ");
        String city = sc.next();

        System.out.println("Enter State: ");
        String state =sc.next();

        System.out.println("Enter Zip Code: ");
        int zip = sc.nextInt();

        System.out.println("Enter Phone Number:");
        long phonenumber = sc.nextLong();

        System.out.println("Enter Email: ");
        String email = sc.next();

        Contact contactObj = new Contact(firstname,lastname,address,city,state,zip,phonenumber,email);

        AddressBook AddObj = new AddressBook();

        ArrayList<Contact> contactList = AddObj.getContact_list();

        contactList.add(contactObj);
        }

}