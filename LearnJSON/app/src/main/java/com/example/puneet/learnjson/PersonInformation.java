package com.example.puneet.learnjson;

/**
 * Created by puneet on 10/10/15.
 */
public class PersonInformation {
    private String name;
    private String phoneNumber;

    /**
     * PersonInformation() is the class constructor
     * @param name - It is the name of the person
     * @param phoneNumber - It the phone number of the person
     */
    public PersonInformation(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    /**
     *
     *getName() is the getter function that fetches the name
     * @return - It returns the name of the person
     */
    public String getName(){
        return name;
    }

    /**
     * getPhoneNumber() is the getter function that fetches the phone number
     * @return  - It returns the phone number of the person
     */
    public String getPhoneNumber(){
        return phoneNumber;
    }
}
