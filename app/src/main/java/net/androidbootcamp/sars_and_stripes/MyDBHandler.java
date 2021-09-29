package net.androidbootcamp.sars_and_stripes;

import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.sql.ResultSet;
import java.sql.Statement;


/* IF YOU NEED TO SEE WHAT THE DATABASE LOOKS LIKE ON THE EMULATOR GO TO:
*   'View' > 'Tools Windows' > 'Device File Explorer' > 'data' > 'data' >
*       net.androidbootcamp.sars_and_stripes > 'databases' > 'userinfo.db'
********************************************************************************/

// the actual Database to store userInfo
public class MyDBHandler extends SQLiteOpenHelper {

    public static final String USERINFO_TABLE = "USERINFO_TABLE";
    public static final String COLUMN_ID = "ID";

    public static final String COLUMN_FIRST_NAME = "FIRST_NAME";
    public static final String COLUMN_LAST_NAME = "LAST_NAME";
    public static final String COLUMN_PHONE_NUMBER = "PHONE_NUMBER";
    public static final String COLUMN_ADDRESS = "ADDRESS";

    public static final String COLUMN_USER_NAME = "USER_NAME";
    public static final String COLUMN_USER_PASSWORD = "USER_PASSWORD";
    public static final String COLUMN_FIRST_NAME = "FIRST_NAME";
    public static final String COLUMN_LAST_NAME = "LAST_NAME";
    public static final String COLUMN_ADDRESS = "ADDRESS";
    public static final String COLUMN_PHONE_NUMBER = "PHONE_NUMBER";
    public static final String COLUMN_USER_EMAIL = "USER_EMAIL";


    // constructor
    public MyDBHandler(@Nullable Context context)
    {
        super(context, "userinfo.db", null, 1);
    }

    // Called when no database exists in disk and the helper class needs
    // to create a new one.
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String createTableStatement = "CREATE TABLE " + USERINFO_TABLE +

                "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_USER_NAME + " TEXT, " + COLUMN_USER_PASSWORD + " TEXT, " + COLUMN_USER_EMAIL + " TEXT, "
        + COLUMN_FIRST_NAME + " TEXT, " + COLUMN_LAST_NAME + " TEXT, " + COLUMN_PHONE_NUMBER + " TEXT, " + COLUMN_ADDRESS + " TEXT)";

                "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_USER_NAME + " TEXT, " + COLUMN_USER_PASSWORD + " TEXT, " + COLUMN_FIRST_NAME + " TEXT, " + COLUMN_LAST_NAME + " TEXT, " + COLUMN_ADDRESS + " TEXT, " + COLUMN_PHONE_NUMBER + " TEXT, " + COLUMN_USER_EMAIL + " TEXT)";

        //_db.execSQL(LoginDataBaseAdapter.DATABASE_CREATE);
        db.execSQL(createTableStatement);

    }

    // Called when there is a database version mismatch meaning that the version
    // of the database on disk needs to be upgraded to the current version.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
     /* Log the version upgrade.
        Log.w("TaskDBAdapter", "Upgrading from version " +_oldVersion + " to " +_newVersion + ", which will destroy all old data");

        Upgrade the existing database to conform to the new version. Multiple
        previous versions can be handled by comparing _oldVersion and _newVersion values
        The simplest case is to drop the old table and create a new table.
        _db.execSQL("DROP TABLE IF EXISTS " + "TEMPLATE");
        Create a new table.
        onCreate(_db);  */
    }

    // Add new user to users database
    public boolean addRow(UserInfo newUser) {
        SQLiteDatabase db = this.getWritableDatabase(); // get a writeable database
        ContentValues cv = new ContentValues();         // hash map - value pairs

        cv.put(COLUMN_USER_NAME, newUser.getUserName());
        cv.put(COLUMN_USER_PASSWORD, newUser.getPassWord());
        cv.put(COLUMN_FIRST_NAME, newUser.getFirstName());
        cv.put(COLUMN_LAST_NAME, newUser.getLastName());
        cv.put(COLUMN_ADDRESS, newUser.getAddress());
        cv.put(COLUMN_PHONE_NUMBER, newUser.getPhoneNumber());
        cv.put(COLUMN_USER_EMAIL, newUser.getEmail());
        cv.put(COLUMN_FIRST_NAME, newUser.getFirstName());
        cv.put(COLUMN_LAST_NAME, newUser.getLastName());
        cv.put(COLUMN_PHONE_NUMBER, newUser.getPhoneNumber());
        cv.put(COLUMN_ADDRESS, newUser.getAddress());


        long insert = db.insert(USERINFO_TABLE, null, cv);
        if (insert == -1){
            return false;
        }
        else {
            return true;
        }
    }
///////added method///////////
    public String find_firstName (String userData) {
        SQLiteDatabase db = this.getReadableDatabase();
        String mQuery = "select "  +  COLUMN_FIRST_NAME  + " from " + USERINFO_TABLE + " where " + COLUMN_USER_NAME + " = " + userData;//, new String[]{String.valueOf(userData)});
        Cursor cursor = db.rawQuery(mQuery, null);
        cursor.moveToFirst();
        String firstName = cursor.getString(1);


        return firstName;
    }

        //UserInfo userInfo = null;





          //  cursor.moveToFirst();


            /*userArray[0] = (cursor.getString(1)); //firstName
            userArray[1] = (cursor.getString(2)); //lastName
            userArray[2] = (cursor.getString(3)); //phoneNumber
            userArray[3] = (cursor.getString(4)); //address
            userArray[4] = (cursor.getString(5)); //userName
            userArray[5] = (cursor.getString(7)); //email */


           // return userArray;
       // }

/////////////ends here/////////////
    // SEARCH FROM USERS DATABASE USERNAME & PASSWORD - returns boolean value true (if exists) or false (if does not exist)
    public boolean doesUserExist(String userName, String passWord){
        SQLiteDatabase db = this.getReadableDatabase();
        String mQuery ="SELECT " + "*" + " FROM " + USERINFO_TABLE + " WHERE " + COLUMN_USER_NAME
                + " = " + "'" + userName + "'" + " AND " + COLUMN_USER_PASSWORD + " = " +  "'" + passWord + "'";

        Cursor cursor = db.rawQuery(mQuery, null);
        if(cursor.moveToFirst()){
            return true;
        }
        else{
            return false;
        }

    }

    // USED TO PULL ONLY USERNAME FROM DATABASE FOR SIGNUP CHECK - returns boolean value true (if exists) or false (if does not exist)
    public boolean doesUsernameExist(String userName){
        SQLiteDatabase db = this.getReadableDatabase();
        String mQuery ="SELECT " + "*" + " FROM " + USERINFO_TABLE + " WHERE " + COLUMN_USER_NAME
                + " = " + "'" + userName + "'";

        Cursor cursor = db.rawQuery(mQuery, null);
        if(cursor.moveToFirst()){
            return true;
        }
        else{
            return false;
        }
    }

    // -------------- GET SELECTED FIELDS FOR PROFILE PAGE ----------------
    public String getFName(String userName){

        SQLiteDatabase db = this.getReadableDatabase();
        String mQuery ="SELECT " + COLUMN_FIRST_NAME + " FROM " + USERINFO_TABLE + " WHERE " + COLUMN_USER_NAME
                + " = " + "'" + userName + "'";

        Cursor cursor = db.rawQuery(mQuery, null);
        cursor.moveToFirst();
        String firstName = cursor.getString(0);

        return firstName;
    }

    // UPDATE & DELETE USER FROM 'PROFILE' PAGE TO DATABASE -- removed settings page --
    // integrate buttons in profile page instead





}

