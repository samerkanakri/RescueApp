package com.sam.amman.rescue.Actors;

/**
 * Created by SAM on 4/20/2016.
 */
public class Employee extends User{


    private int EID;
    private String status,Role;


    /**
     * aggregation or composition ?????????
     *
     * complete creation of user..
     */
    public void Employee(int EID, String status, String Role){
        super.User("","","","");
        this.EID = EID;
        this.status = status ;
        this.Role = Role;
    }

    /**
     * setters & getters
     */

}
