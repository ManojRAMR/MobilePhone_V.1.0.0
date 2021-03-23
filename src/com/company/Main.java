package com.company;

import java.util.Scanner;

public class Main{
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone myContact = new MobilePhone("0715190114");

    public static void main(String[] args){
        boolean quit = false;
        int choice = 0;
        printInstructions();
        while (!quit) {
            System.out.println();
            System.out.print("Add an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printInstructions();

                    break;
                case 1:
                    printContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    modifyContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    searchContact();
                    break;
                case 6:
                    quit = true;
            }
        }


    }

    public static void printInstructions(){
        System.out.println("Press ");
        System.out.println("0 - To print choice options.");
        System.out.println("1 - To print the contact list.");
        System.out.println("2 - To add a contact.");
        System.out.println("3 - To modify a contact.");
        System.out.println("4 - To remove a contact.");
        System.out.println("5 - To search for a contact.");
        System.out.println("6 - To quit the application.");


    }

    public static void printContacts(){
        System.out.println("Mobile contacts");
        myContact.printContacts();

    }

    public static void addContact(){
        System.out.println("Add a contact");

        System.out.print("New contact name: ");
        String name = scanner.nextLine();
        System.out.print("New contact number: ");
        String number = scanner.nextLine();

        myContact.addNewContact(new Contact(name, number));
    }

    public static void modifyContact(){
        System.out.println("Modify a contact");

        System.out.print("Contact name: ");
        String oldName = scanner.nextLine();

        System.out.print("New contact name: ");
        String newName = scanner.nextLine();
        System.out.print("New contact number: ");
        String number = scanner.nextLine();
        Contact existingContact = myContact.queryContact(oldName);

        myContact.updateContact(existingContact, new Contact(newName, number));
    }

    public static void removeContact(){
        System.out.println("Remove a contact");

        System.out.print("Contact name: ");
        String name = scanner.nextLine();
        Contact existingContact = myContact.queryContact(name);

        myContact.removeContact(existingContact);
    }

    public static void searchContact(){
        System.out.println("Find a contact");

        System.out.print("Contact name: ");
        String name = scanner.nextLine();

        Contact contact = myContact.queryContact(name);
        System.out.println(contact.getName()+" -> "+contact.getPhoneNumber());
    }
}
