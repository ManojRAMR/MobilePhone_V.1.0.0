package com.company;

import java.util.ArrayList;

public class MobilePhone{
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber){
        this.myContacts = new ArrayList<>();
        this.myNumber = myNumber;
    }

    public boolean addNewContact(Contact newContact){
        int newContactId = findContact(newContact);

        if (newContactId < 0) {
            myContacts.add(newContact);
            return true;
        } else {
            return false;
        }
    }

    public boolean updateContact(Contact existingContact, Contact newContact){
        int indexOfExistingContact = findContact(existingContact);
        if (indexOfExistingContact >= 0) {
            myContacts.remove(indexOfExistingContact);
            Contact newContactToCreate = Contact.createContact(newContact.getName(), newContact.getPhoneNumber());
            myContacts.add(newContactToCreate);
            return true;
        } else {
            return false;
        }

    }

    public boolean removeContact(Contact contact){
        int findContactIndex = findContact(contact);
        if (findContactIndex >= 0) {
            myContacts.remove(findContactIndex);
            return true;
        } else {
            return false;
        }

    }

    private int findContact(Contact contactToFind){
        boolean contactExist = false;
        int indexOfExistingContact = -1;
        String contactToFindName = contactToFind.getName();
        for (Contact contact : myContacts){
            if (contact.getName().equals(contactToFindName)) {
                contactExist = true;
                indexOfExistingContact = myContacts.indexOf(contact);
                break;
            }
        }
        if (contactExist) {
            Contact contact = myContacts.get(indexOfExistingContact);
            return indexOfExistingContact;
        } else {
            return -1;
        }
    }

    private int findContact(String name){
        boolean contactExist = false;
        int indexOfExistingContact = -1;
        for (Contact contact : myContacts){
            if (contact.getName().equals(name)) {
                contactExist = true;
                indexOfExistingContact = myContacts.indexOf(contact);
                break;
            }
        }
        if (contactExist) {
            Contact contact = myContacts.get(indexOfExistingContact);
            return indexOfExistingContact;
        } else {
            return -1;
        }
    }

    public Contact queryContact(String name){
        int findContactReturn = findContact(name);
        if (findContactReturn >= 0) {
            return myContacts.get(findContactReturn);
        } else {
            return null;
        }
    }

    public void printContacts(){
        System.out.println("Contact List:");
        for (Contact contact : myContacts){
            System.out.println((myContacts.indexOf(contact) + 1) + ". " + contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }

}
