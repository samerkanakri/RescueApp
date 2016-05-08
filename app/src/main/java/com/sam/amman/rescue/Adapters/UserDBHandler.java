package com.sam.amman.rescue.Adapters;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.sam.amman.rescue.Actors.User;

/**
 * Created by SAM on 5/8/2016.
 */
public class UserDBHandler extends DBHandler {
    public UserDBHandler(Context context) {
        super(context);
    }

    // Creating User Table
    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(SQLCreate_UserTable);
        } catch (SQLException e) {
            Log.w(TAG, "onCreate: ",e );
        }
    }

    /**
     * adding new user to db using User object [ NOT WORKING ]
     *
     * @param user
     */
    public void addUser(User user) {
        try {
            SQLiteDatabase db = getWritableDatabase();
            String SQLcode = "insert into " + TABLE_USERS + "(" + KEY_EMAIL + "," + KEY_PASSWORD + ") values ('" + user.getEmail() + "'," + user.getPassword() + ")";
            db.execSQL(SQLcode);
            db.close();

//			SQLiteDatabase db = getWritableDatabase();
//
//			ContentValues values = new ContentValues();
//			values.put(KEY_EMAIL, user.getEmail());
//			values.put(KEY_PASSWORD, user.getPassword());
//
//			db.insert(TABLE_USERS, null, values);
//			db.close();
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
        try {

            do
            {

                if(c.getString(0).equals(email) && c.getString(1).equals(password)){
                    return true;
                }

            }
            while(c.moveToNext());
            return false;
        }catch (SQLException e){
            Log.w(TAG, "IsUser: stoped at " + c.getColumnIndex(KEY_EMAIL) , e);
        }

        return false;
    }


    public User getUser(String email) {
        try {
            String SQLcode = "select " + KEY_EMAIL + "," + KEY_PASSWORD + " from " + TABLE_USERS + " where " + KEY_EMAIL + " = " + email;
            SQLiteDatabase db = getReadableDatabase();
            Cursor c = db.rawQuery(SQLcode,null);
            c.moveToFirst();
            User user = new User();
            user.setEmail(c.getString(0));
            user.setPassword(c.getString(1));
            return user;
        }catch (SQLException e){
            Log.w(TAG, "getUser: ",e );
        }
        return null;
    }


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
