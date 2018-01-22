package com.dwbook.phonebook.representations;

//Representations class for Contact

public class Contact {
    private final int id;
    private final String firstName; //properties are declared FINAL to make them immutable and to initialise them we made the constructors
    private final String lastName;
    private final String phone;

    public Contact() {
        this.id = 0;
        this.firstName = null;
        this.lastName = null;
        this.phone = null;
    }

    public Contact(int id, String firstName, String lastName, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getPhone(){
        return phone;
    }
}
