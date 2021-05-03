package com.AddressBookProblem;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
            System.out.println("2.Find Duplicate Entry in Address Book");
            System.out.println("3.Search Contact from a city");
            System.out.println("4.Search Contact from a State");
            System.out.println("5.Search contact By State Using State and Person HashMap");
            System.out.println("6.Search Contact by city Using City and Person HashMap");
            System.out.println("7.Count Contact By State");
            System.out.println("8.Count Contact By City");
            System.out.println("9.Sort and Print in Alphabetically Order");
            System.out.println("10.Exit");
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
                    for (Map.Entry<String,AddressBook> entry: addBookMain.bookList.entrySet()){
                        AddressBook value = entry.getValue();
                        System.out.println("Address Book Name: "+entry.getKey());
                        value.checkDuplicate();
                    }
                }
                case 3:{
                    System.out.println("Enter Name of City: ");
                    String CityName = sc.next();
                   addBookMain.searchPersonByCity(CityName);
                    break;
                }
                case 4:{
                    System.out.println("Enter Name of State: ");
                    String StateName = sc.next();
                    addBookMain.searchPersonByState(StateName);
                    break;
                }
                case 5:{
                    System.out.println("Enter Name of State: ");
                    String StateName = sc.next();
                    addBookMain.searchPersonByCityUsinghashmap(StateName);
                    break;
                }
                case 6:{
                    System.out.println("Enter Name of City: ");
                    String CityName = sc.next();
                    addBookMain.searchPersonByStateUsinHashMap(CityName);
                    break;
                }
                case 7:{
                    System.out.println("Enter Name of State: ");
                    String StateName = sc.next();
                    addBookMain.CountByState(StateName);
                    break;
                }
                case 8:{
                    System.out.println("Enter Name of City: ");
                    String CityName = sc.next();
                    addBookMain.CountByCity(CityName);
                    break;
                }
                case 9:{
                    addBookMain.sortContactByName();
                }
                case 10:{
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

    private void searchPersonByState(String stateName) {
        for(Map.Entry<String,AddressBook> entry: bookList.entrySet()){
            AddressBook value = entry.getValue();
            System.out.println("The Address Book: "+entry.getKey());
            value.getPersonNameByState(stateName);
        }
    }

    private void searchPersonByCity(String cityName) {
        for(Map.Entry<String,AddressBook> entry: bookList.entrySet()){
            AddressBook value = entry.getValue();
            System.out.println("The Address Book: "+entry.getKey());
            value.getPersonNameByCity(cityName);
        }
    }
    private void searchPersonByCityUsinghashmap(String stateName) {
        for (Map.Entry<String, AddressBook> entry : bookList.entrySet()) {
            AddressBook value = entry.getValue();
           ArrayList<Contact> contacts = value.ContactByState.entrySet().stream().filter(findState -> findState.getKey().equals(stateName)).map(Map.Entry::getValue).findFirst().orElse(null);
            for(Contact contact: contacts){
                System.out.println("First Name: "+contact.getFirst_name());
                System.out.println("Last Name: "+contact.getLast_name());
            }
        }
    }
    private void searchPersonByStateUsinHashMap(String cityName) {
        for (Map.Entry<String, AddressBook> entry : bookList.entrySet()) {
            AddressBook value = entry.getValue();
            ArrayList<Contact> contacts = value.ContactByCity.entrySet().stream().filter(findCity -> findCity.getKey().equals(cityName)).map(Map.Entry::getValue).findFirst().orElse(null);
            for(Contact contact: contacts){
                System.out.println("First Name: "+contact.getFirst_name());
                System.out.println("Last Name: "+contact.getLast_name());
            }
        }
    }

    public void CountByState(String state) {
        int count = 0;
        for(Map.Entry<String, AddressBook> entry: bookList.entrySet()){
            for(int i=0;i<(entry.getValue()).contactList.size();i++)
            {
                Contact contact= entry.getValue().contactList.get(i);

                if(state.equals(contact.getState()))
                {
                    count++;
                }

            }
        }
        System.out.println("Total Person Count in state "+state+": "+count);
    }
    public void CountByCity(String city) {
        int count=0;
        for(Map.Entry<String, AddressBook> entry: bookList.entrySet())
        {
            for(int i=0;i<(entry.getValue()).contactList.size();i++)
            {
                Contact d= (Contact)entry.getValue().contactList.get(i);

                if(city.equals(d.getCity()))
                {
                    count++;
                }

            }
        }
        System.out.println("Total number of people in this city "+city+": "+count);
    }

    private void sortContactByName() {
        for (Map.Entry<String,AddressBook>entry:bookList.entrySet()){
            AddressBook value = entry.getValue();
            List<Contact> sortedList = value.contactList.stream().sorted(Comparator.comparing(Contact::getFirst_name)).collect(Collectors.toList());

            for(Contact contact:sortedList){
                System.out.println("First Name: "+contact.getFirst_name());
                System.out.println("Last Name: "+contact.getLast_name());
            }
        }
    }
}