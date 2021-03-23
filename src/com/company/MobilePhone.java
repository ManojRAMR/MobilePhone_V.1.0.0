package com.company;

import java.util.ArrayList;

public class MobilePhone{
    private ArrayList<Contacts> myContacts = new ArrayList<>();

    public void addContact(Contacts newContact){
        String newContactName = newContact.getName();
        boolean exist = false;
        for (Contacts myContact : myContacts){
            if (myContact.getName().equals(newContactName)) {
                exist = true;
                break;
            }
        }

        if (!exist) {
            myContacts.add(newContact);
            System.out.println("Added new contact into contact list");
        } else {
            System.out.println("Contact is already in the list.");
        }
    }

    public void modifyContact(String name, Contacts newContact){
        boolean exist = false;
        int indexOfExistingContact = 0;
        for (Contacts myContact : myContacts){
            if (myContact.getName().equals(name)) {
                exist = true;
                indexOfExistingContact = myContacts.indexOf(myContact);
                break;
            }
        }

        if (exist) {
            myContacts.get(indexOfExistingContact).setNumber(newContact.getNumber());
            myContacts.get(indexOfExistingContact).setName(newContact.getName());
            System.out.println("Contact was modified");
        } else {
            System.out.println("Contact is not in the list.");
            addContact(newContact);
        }

    }

    public void removeContact(String name){
        boolean exist = false;
        int indexOfContact = 0;
        for (Contacts myContact : myContacts){
            if (myContact.getName().equals(name)) {
                exist = true;
                indexOfContact = myContacts.indexOf(myContact);
                break;
            }
        }

        if (exist) {
            myContacts.remove(indexOfContact);
            System.out.println("Contact was removed.");
        } else {
            System.out.println("Contact is not in the list.");
        }
    }

    public Contacts findContact(String name){
        boolean contactExist = false;
        int indexOfExistingContact = -1;

        for (Contacts contact : myContacts){
            if (contact.getName().equals(name)) {
                contactExist = true;
                indexOfExistingContact = myContacts.indexOf(contact);
                break;
            }
        }
        if (contactExist) {
            Contacts contact = myContacts.get(indexOfExistingContact);
            System.out.println("Contact exists.");
            System.out.println("Name: " + contact.getName() + " Number: " + contact.getNumber());
            return myContacts.get(indexOfExistingContact);
        } else {
            System.out.println("Queried name is not in the contact list.");
            return null;
        }
    }


    public void printContactList(){
        if (myContacts.size() > 0) {
            for (Contacts contact : myContacts){
                System.out.println("Name: " + contact.getName() + " Number: " + contact.getNumber());
            }
        } else {
            System.out.println("No contacts.");
        }
    }

}
