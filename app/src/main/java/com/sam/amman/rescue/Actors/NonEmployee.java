package com.sam.amman.rescue.Actors;

/**
 * Created by SAM on 4/20/2016.
 */
public class NonEmployee extends User{

    private int SSN;
    private String Role;  // duplicated


    /**
     * aggregation or composition ?????????
     *
     * complete creation of user..
     */
    public void NonEmployee(int SSN, String Role){
        super.User("","","","");
        this.SSN = SSN;
        this.Role = Role;
    }

    /**
     * setters & getters
     */
}
