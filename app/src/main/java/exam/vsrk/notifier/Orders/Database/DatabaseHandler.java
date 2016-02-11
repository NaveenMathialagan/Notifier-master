package exam.vsrk.notifier.Orders.Database;

/**
 * Created by VSRK on 1/13/2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import exam.vsrk.notifier.Instances.Notify;


/**
 * Created by VSRK on 12/21/2015.
 */
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import exam.vsrk.notifier.Instances.Notify;
import exam.vsrk.notifier.Orders.Instances.Orders;

public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "KFC_VELLORE";

    // Contacts table name
    private static final String TABLE_NOTIFICATIONS = "KFC_VELLORE";

    // Contacts Table Columns names

    private static final String KEY_ITEM = "item";
    private static final String KEY_PRICE = "price";
    private static final String KEY_QUANTITY = "quantity";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_NOTIFICATIONS + "("
                + KEY_ITEM + " TEXT,"
                + KEY_PRICE + " TEXT," + KEY_QUANTITY + " TEXT " +" )";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTIFICATIONS);

        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new contact
    public void addNotify(Orders notify ) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ITEM, notify.getItem());
        Log.v("PACK_TEST", notify.getItem());// Contact Name
        values.put(KEY_PRICE, notify.getPrice()); // Contact Phone
        values.put(KEY_QUANTITY,notify.getQuantity());


        // Inserting Row
        db.insert(TABLE_NOTIFICATIONS, null, values);
        db.close(); // Closing database connection
    }



    // Getting All Contacts
    public List<Orders> getAllNotify() {
        List<Orders> contactList = new ArrayList<Orders>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NOTIFICATIONS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToLast()) {
            do {
                Orders notify = new Orders();
                //  notify.setID((cursor.getString(0)));
                notify.setItem(cursor.getString(0));

                notify.setPrice(cursor.getString(1));
                notify.setQuantity(cursor.getString(2));

                // Adding contact to list
                contactList.add(notify);
            } while (cursor.moveToPrevious());
        }

        // return contact list
        return contactList;
    }

    public void truncate()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ TABLE_NOTIFICATIONS);

    }


    public void delete(String item)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_NOTIFICATIONS, "item = ?", new String[] { item });

    }


}
