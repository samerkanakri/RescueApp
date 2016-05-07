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

public class DataBaseHandler extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;

	private static final String DATABASE_NAME = "rescue";
	private static final String TABLE_USERS = "user";

	private static final String KEY_ID = "id";
	private static final String KEY_EMAIL = "email";
	private static final String KEY_PASSWORD = "password";

	private static final String TAG = "DATABASE";

	private static final String SQLCreateUserTable = "CREATE TABLE " + TABLE_USERS + "(" + KEY_ID + " integer primary key autoincrement, " +
			KEY_EMAIL + " varchar," + KEY_PASSWORD + " varchar" + ")";

	public DataBaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}


	// Creating Tables
	@Override
	public void onCreate(SQLiteDatabase db) {
		try {
			db.execSQL(SQLCreateUserTable);
		} catch (SQLException e) {
			Log.w(TAG, "onCreate: ",e );
		}
	}

	// Upgrading database
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//		try {
//			db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
//			onCreate(db);
//		}catch (SQLException e){
//			Log.w(TAG, "onUpgrade: ", e);
//		}
	}

	/**
	 * adding new user to db using User object [ NOT WORKING ]
	 *
	 * @param user
	 */
	public void addUser(User user) {
		try {
//			SQLiteDatabase db = getWritableDatabase();
//			String SQLcode = "insert into " + TABLE_USERS + "(" + KEY_EMAIL + "," + KEY_PASSWORD + ") values ('" + user.getEmail() + "'," + user.getPassword() + ")";
//			db.execSQL(SQLcode);
//			db.close();

			SQLiteDatabase usersDb = getWritableDatabase();

			ContentValues values = new ContentValues();
			values.put("name", user.getEmail());
			values.put("major", user.getPassword());

			usersDb.insert("studentTable", null, values);

		}catch (SQLException e){
			Log.w(TAG, "addUser: ",e );
		}

	}

	/**
	 * adding new user to db using String username and password
	 * (problem with using an object of User)
	 *
	 * @param email
	 * @param password
     */
	public void addUserStr(String email,String password) {
		try {
			SQLiteDatabase db = getWritableDatabase();
			String SQLcode = "insert into " + TABLE_USERS + "(" + KEY_EMAIL + "," + KEY_PASSWORD + ") values ('" + email + "'," + password + ")";
			db.execSQL(SQLcode);
			db.close();
		}catch (SQLException e){
			Log.w(TAG, "addUser: ",e );
		}

	}


	/**
	 * search for String username and password in db
	 * @param email
	 * @param password
	 * @return Boolean
	 */
	public Boolean IsUser(String email,String password){
		String SQLcode = "Select " + KEY_EMAIL + "," + KEY_PASSWORD + " from " + TABLE_USERS;
		SQLiteDatabase db = getReadableDatabase();
		Cursor c = db.rawQuery(SQLcode,null);
		c.moveToFirst();
		do
		{
			User u = new User();
			if(c.getString(0).equals(email) && c.getString(1).equals(password)){
				return true;
			}

		}
		while(c.moveToNext());

		return false;
	}


//	public User getUser(int id) {
//		String SQLcode = "select " + KEY_EMAIL + "," + KEY_PASSWORD + " from " + TABLE_USERS + " where " + KEY_ID + " = " + id;
//		SQLiteDatabase db = getReadableDatabase();
//		Cursor c = db.rawQuery(SQLcode,null);
//		c.moveToFirst();
//		User user = new User();
//		user.setEmail(c.getString(0));
//		user.setPassword(c.getString(1));
//		return user;
//	}


//	public List<User> getAllUsers() {
//		String SQLcode = "Select " + KEY_EMAIL + "," + KEY_PASSWORD + " from " + TABLE_USERS;
//		SQLiteDatabase db = getReadableDatabase();
//		Cursor c = db.rawQuery(SQLcode,null);
//		c.moveToFirst();
//		List<User> LstOfContact = new ArrayList<User>();
//		do
//		{
//			User u = new User();
//			u.setEmail(c.getString(0));
//			u.setPassword(c.getString(1));
//			LstOfContact.add(u);
//		}
//		while(c.moveToNext());
//		return LstOfContact;
//	}



}