package com.AddressBookProblem;

import java.util.ArrayList;

public class AddressBook {

    ArrayList<Contact> contactList = new ArrayList<Contact>();

    public void setList(ArrayList<Contact> list)
    {
        this.contactList = contactList;
    }

    public ArrayList<Contact> getContact_list() {
        return contactList;
    }

    public void addContact(Contact contact){
        contactList.add(contact);
    }
}
