package com.sam.amman.rescue.Actors;

import java.util.Date;

/**
 * Created by SAM on 4/20/2016.
 */
public class User {


    int UID;
    private String Username, FirstName, LastName, Password, Email, Phone, Address, Blood, Sex;
    private Date DoB ;
    String status;

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
//        this.Blood = BloodSample;
//        this.Sex = Sex;
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

    public String getBlood() {
        return Blood;
    }

    public void setBlood(String BlodSample) {
        this.Blood = BlodSample;
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

    public String getSex() {
        return Sex;
    }

    public void setSex(String Gender) {
        this.Sex = Gender;
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

    public void setUID(int UID) {
        this.UID = UID;
    }

    public int getUID() {
        return UID;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public String toString(){

        return getEmail() + " " + getPassword() ;
    }


}
