package com.sam.amman.rescue.Actors;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by SAM on 4/20/2016.
 */
public class Case {

    private int CID;
    private Time time;
    private java.util.Date Date;
    ArrayList<String> sypptoms;


    public void setTime(Time time) {
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



    public int getCID() {
        return CID;
    }

    public Time getTime() {
        return time;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public ArrayList<String> getSypptoms() {
        return sypptoms;
    }

}
