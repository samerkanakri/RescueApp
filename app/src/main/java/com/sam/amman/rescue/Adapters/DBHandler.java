package com.sam.amman.rescue.Adapters;
	
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.sam.amman.rescue.Actors.User;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {

	//version
	protected static final int DATABASE_VERSION = 1;

	//TAG
	protected static final String TAG = "DATABASE";

	//database name
	protected static final String DATABASE_NAME = "rescue";

	//tables names
	protected static final String TABLE_USERS = "user";
	protected static final String TABLE_SYMPTOMS = "symptoms";
	protected static final String TABLE_DIAGNOSES = "diagnoses";


	//USER fields
	protected static final String KEY_UserID = "Uid";
	protected static final String KEY_FIRST_NAME = "Fname";
	protected static final String KEY_LAST_NAME = "Lname";
	protected static final String KEY_DoB = "DoB";
	protected static final String KEY_PHONE = "phone";
	protected static final String KEY_ADDRESS = "address";
	protected static final String KEY_GENDER = "gender";
	protected static final String KEY_BLOOD = "blood";
	protected static final String KEY_EMAIL = "email";
	protected static final String KEY_PASSWORD = "password";

	//Symptoms fields
	protected static final String KEY_SymptomID = "Sid";
	protected static final String KEY_SYMPTOMS_NAME = "symp_name";
	protected static final String KEY_FOREIGN_DIAGNOSES = "diagnoses_id";

	//diagnoses fields
	protected static final String KEY_DiagnoseID = "Did";
	protected static final String KEY_DIAGNOSES_NAME = "symp_name";



	//create statements
	//CREATE USER TABLE
	protected static final String SQLCreate_UserTable = "CREATE TABLE " + TABLE_USERS + "(" + KEY_UserID + " integer primary key autoincrement, " +
			KEY_EMAIL + " varchar," + KEY_PASSWORD + " varchar" + ")";

	//CREATE DIAGNOSES TABLE
	protected static final String SQLCreate_DiagnosesTable = "CREATE TABLE " + TABLE_DIAGNOSES + "(" + KEY_DiagnoseID + " integer primary key autoincrement, " +
			KEY_DIAGNOSES_NAME + " varchar" + ")";

	//CREATE SYMPTOMS TABLE
	protected static final String SQLCreate_SymptomsTable = "CREATE TABLE " + TABLE_SYMPTOMS + "(" + KEY_SymptomID + " integer primary key autoincrement, " +
			KEY_SYMPTOMS_NAME + " varchar," + KEY_FOREIGN_DIAGNOSES + " integer references " + TABLE_DIAGNOSES + "(" + KEY_DiagnoseID + ")" + ")";


	//constructor
	public DBHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}



	// Creating Tables
	@Override
	public void onCreate(SQLiteDatabase db) {
		try {
//			db.execSQL(SQLCreate_UserTable);
//			db.execSQL(SQLCreate_DiagnosesTable);
//			db.execSQL(SQLCreate_SymptomsTable);
		} catch (SQLException e) {
			Log.w(TAG, "onCreate: ",e );
		}
	}

	// Upgrading database ???
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//		try {
//			db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
//			onCreate(db);
//		}catch (SQLException e){
//			Log.w(TAG, "onUpgrade: ", e);
//		}
	}

}