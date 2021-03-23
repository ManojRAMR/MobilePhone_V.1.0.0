package com.company;

public class Contact{
    private String name;
    private String phoneNumber;

    public Contact(String name, String number){
        this.name = name;
        this.phoneNumber = number;
    }

    public String getName(){
        return name;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public static Contact createContact(String name, String phoneNumber){
        return new Contact(name, phoneNumber);
    }


}
