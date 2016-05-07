package com.sam.amman.rescue.Actors;

import java.util.Date;

/**
 * Created by SAM on 4/20/2016.
 */
public class User {
    private String Username, FirstName, LastName, Password, Email, Phone, Address, BlodSample, Gender;
    private Date DoB ;
    // UID incremental

    /**
     * REGISTRATION TEST CONSTRUCTOR
     */
    public User(String Email, String Password) {
        setEmail(Email);
        setPassword(Password);
    }

    public User(){

    }



    /**
     * most required information
     */
    public void User(String Username, String FirstName, String LastName, String Password){
//        this.FirstName  = FirstName;
//        this.LastName = LastName;
//        this.Username = Username;
//        this.Password = Password;
    }




    /**
     * all information
     */
    public void User(String Username, String FirstName, String LastName, String Password,
                     String Email, String Address, String Phone, String Gender, String BloodSample, Date DoB){
//        this.FirstName  = FirstName;
//        this.LastName = LastName;
//        this.Username = Username;
//        this.Password = Password;
//        this.Email = Email;
//        this.Phone = Phone;
//        this.Address = Address;
//        this.BlodSample = BloodSample;
//        this.Gender = Gender;
//        this.DoB = DoB;
    }

    /**
     * setters & getters
     */

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getBlodSample() {
        return BlodSample;
    }

    public void setBlodSample(String BlodSample) {
        this.BlodSample = BlodSample;
    }

    public Date getDoB() {
        return DoB;
    }

    public void setDoB(Date DoB) {
        this.DoB = DoB;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }


}
