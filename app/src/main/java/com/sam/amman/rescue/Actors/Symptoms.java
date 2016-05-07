package com.sam.amman.rescue.Actors;

import java.util.ArrayList;

/**
 * Created by SAM on 4/26/2016.
 */
public class Symptoms {
    public String category ,Description;
    public ArrayList<String> symptoms;


    public void Symptoms(String category , String Description, ArrayList<String> symptoms){
        this.category = category;
        this.Description= Description;
        this.symptoms = symptoms ;
    }
}
