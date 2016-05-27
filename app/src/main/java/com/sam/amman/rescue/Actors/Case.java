package com.sam.amman.rescue.Actors;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

/**
 * Created by SAM on 4/20/2016.
 */
public class Case {

    private String isNew;
    private int CID;
    private int UID;
    private String time;
    String Location ;
    private java.util.Date Date;
    ArrayList<String> sypptoms;


    public void setTime(String time) {
        this.time = time;
    }

    public void setCID(int CID) {
        this.CID = CID;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public void setSypptoms(ArrayList<String> sypptoms) {
        this.sypptoms = sypptoms;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }



    public int getCID() {
        return CID;
    }

    public String getTime() {
        return time;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public ArrayList<String> getSypptoms() {
        return sypptoms;
    }

    public String getLocation() {
        return Location;
    }

    public int getUID() {
        return UID;
    }

    public String toString(){
        return "User : " + getCID() + "\nTime : " + getTime() + "\nLocation : " + getLocation() ;
    }

    public void setSetNew(String isNew) {
        this.isNew = isNew;
    }


    public String getSetNew() {
        return isNew;
    }
}
