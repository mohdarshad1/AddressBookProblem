package com.AddressBookProblem;

import java.util.*;
import java.util.stream.Collectors;

public class AddressBook {

    static Scanner sc = new Scanner(System.in);

    ArrayList<Contact> contactList;
    public Map<String,ArrayList<Contact>> ContactByState;
    public Map<String,ArrayList<Contact>> ContactByCity;

    public AddressBook() {
        contactList = new ArrayList<>();
        ContactByState = new HashMap<>();
        ContactByCity = new HashMap<>();
    }

    public void setList(ArrayList<Contact> list)
    {
        this.contactList = contactList;
    }

    public ArrayList<Contact> getContact_list() {
        return contactList;
    }

    public ArrayList<Contact> addContact(){

        System.out.println("Enter First Name: ");
        String firstname = sc.next();

        checkDuplicate();

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

        if(!ContactByState.containsKey(state)){
            ContactByState.put(state,new ArrayList<Contact>());
        }
        ContactByState.get(state).add(contactObj);

        if(!ContactByCity.containsKey(city)){
            ContactByCity.put(city,new ArrayList<>());
        }
        ContactByCity.get(city).add(contactObj);

        return contactList;
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

    public boolean deleteContact(String name) {
        int flag = 0;
        for(Contact contact: contactList)
        {
            if(contact.getFirst_name().equals(name))
            {
                contactList.remove(contact);
                flag = 1;
                break;
            }
        }
        if(flag==1)
            return true;
        else
            return false;
    }

    public void checkDuplicate(){
        Set<String> ContactSet = new HashSet<>();
        Set<Contact> FilterSet = contactList.stream().filter( n -> !ContactSet.add(n.getFirst_name())).collect(Collectors.toSet());

        for(Contact contact:FilterSet){
            System.out.println("The Duplicate Contact is: "+contact.getFirst_name()+" "+contact.getLast_name());
        }
    }

    public void getPersonNameByState(String State) {
        List<Contact> list  = contactList.stream().filter(findState ->findState.getCity().equals(State)).collect(Collectors.toList());
        for(Contact contact: list){
            System.out.println("First Name: "+contact.getFirst_name());
            System.out.println("Last Name: "+contact.getLast_name());
        }

    }

    public void getPersonNameByCity(String cityName) {
        List<Contact> list  = contactList.stream().filter(city ->city.getCity().equals(cityName)).collect(Collectors.toList());
        for(Contact contact: list){
            System.out.println("First Name: "+contact.getFirst_name());
            System.out.println("Last Name: "+contact.getLast_name());

        }
    }
}