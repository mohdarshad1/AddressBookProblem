package com.AddressBookProblem;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {

    static Scanner sc = new Scanner(System.in);

    ArrayList<Contact> contactList = new ArrayList<Contact>();

    public void setList(ArrayList<Contact> list)
    {
        this.contactList = contactList;
    }

    public ArrayList<Contact> getContact_list() {
        return contactList;
    }

    public void addContact(){

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

        contactList.add(contactObj);
    }

    public boolean editContact(String Name)
    {
        int flag = 0;
        for(Contact contact: contactList)
        {
            if(contact.getFirst_name().equals(Name))
            {
                System.out.println("Enter the detail which needs to be updated:");

                System.out.println("1.First Name");
                System.out.println("2.Last Name");
                System.out.println("3.Address");
                System.out.println("4.City");
                System.out.println("5.State");
                System.out.println("6.ZipCode");
                System.out.println("7.Phone Number");

                System.out.println("Choose Option");

                int choice = sc.nextInt();
                switch(choice)
                {
                    case 1:
                    {
                        System.out.println("Enter First Name: ");
                        String firstname = sc.next();
                        contact.setFirst_name(firstname);
                        break;
                    }
                    case 2:
                    {
                        System.out.println("Enter last name: ");
                        String lastname = sc.next();
                        contact.setLast_name(lastname);
                        break;
                    }
                    case 3:
                    {
                        System.out.println("Enter Address: ");
                        String address = sc.next();
                        contact.setAddress(address);
                        break;
                    }
                    case 4:
                    {
                        System.out.println("Enter City: ");
                        String city = sc.next();
                        contact.setCity(city);
                        break;
                    }
                    case 5:
                    {
                        System.out.println("Enter State: ");
                        String state =sc.next();
                        contact.setState(state);
                        break;
                    }
                    case 6:
                    {
                        System.out.println("Enter Zip Code: ");
                        int zip = sc.nextInt();
                        contact.setZip_code(zip);
                        break;
                    }
                    case 7:
                    {
                        System.out.println("Enter Phone Number:");
                        long phonenumber = sc.nextLong();
                        contact.setPhone_number(phonenumber);
                        break;
                    }
                }

                flag = 1;
                break;
            }
        }
        if(flag==1)
            return true;
        else
            return false;
    }
}