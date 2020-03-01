/*package seclass.qc.edu.glm;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;


public class Database extends SQLiteOpenHelper {
    //database version
    private static final int DATABASE_VERSION = 2;

    //database name
    private static final String DATABASE_NAME = "Database";

    //table name
    private static final String remTable = "ReminderTable";

    //columns names
    private static final String rem_ID = "id";
    private static final String rem_Name = "name";
    private static final String rem_Type = "type"
    private static final String rem_Date = "date";
    private static final String rem_Time = "time";
    private static final String rem_Repeat = "repeat";
    private static final String rem_CheckOff = "checkOff";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Tables creation
    @Override
    public void onCreate(SQLiteDatabase db) {
        String Create_Table = "Create Table" + remTable +
                "("
                + rem_ID + " Integer pk,"
                + rem_Name + " Text,"
                + rem_Type + " Text"
                + rem_Date + " text,"
                + rem_Time + " Integer,"
                + rem_Repeat + " Boolean,"
                + rem_CheckOff + " Boolean" + ")";

        db.execSQL(Create_Table);
    }

    //we must upgrade the database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // drop older if existed
        if (oldVersion >= newVersion)
            return;
        db.execSQL("If any Table exists, drop" + remTable);

        // Creating table again
        onCreate(db);
    }

    // Add a new reminder into the database
    public int addReminder(Reminder reminder){
        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

        //Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(rem_Name, reminder.getName());
        values.put(rem_Type, reminder.getType());
        values.put(rem_Date, reminder.getDate());
        values.put(rem_Time, reminder.getTime());
        values.put(rem_Repeat, reminder.getRepeat());
        values.put(rem_CheckOff, reminder.getCheckOff());

        // inserting the row
        long ID = db.insert(remTable, null, values);
        db.close();
        return (int) ID;
    }

    // getting a reminder
    public Reminder getReminder(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(remTable, new String[]
                        {
                                rem_ID,
                                rem_Name,
                                rem_Type
                                rem_Date,
                                rem_Time,
                                rem_Repeat,
                                rem_CheckOff,

                        }, rem_ID + "=?",

                new String[] {String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        Reminder reminder = new Reminder(Integer.parseInt(cursor.getString(0)), cursor.getString(1),
                cursor.getString(2), cursor.getString(3), cursor.getString(4),
                cursor.getString(5), cursor.getString(6));

        return reminder;
    }

    // getting all the reminders
    public List<Reminder> getAllReminders(){
        List<Reminder> reminderList = new ArrayList<>();

        // queries
        String selectQuery = "SELECT * FROM " + remTable;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // added to the list
        if(cursor.moveToFirst()){
            do{
                Reminder reminder = new Reminder();
                reminder.setID(Integer.parseInt(cursor.getString(0)));
                reminder.setName(cursor.getString(1));
                reminder.setType(cursor.getString(2))
                reminder.setDate(cursor.getString(3));
                reminder.setTime(cursor.getString(4));
                reminder.setRepeat(cursor.getString(5));
                reminder.setCheckOff(cursor.getString(6));

                // adding reminders to the list
                reminderList.add(reminder);
            } while (cursor.moveToNext());
        }
        return reminderList;
    }

    // updating reminder
    public int updateReminder(Reminder reminder){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(rem_Name , reminder.getTitle());
        values.put(rem_Type , reminder.getType());
        values.put(rem_Date , reminder.getDate());
        values.put(rem_Time , reminder.getTime());
        values.put(rem_Repeat , reminder.getRepeat());
        values.put(rem_CheckOff, reminder.getCheckOff());

        // updating rows
        return db.update(remTable, values, rem_ID + "=?",
                new String[]{String.valueOf(reminder.getID())});
    }

    // deleting a reminder
    public void deleteReminder(Reminder reminder){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(remTable, rem_ID + "=?",
                new String[]{String.valueOf(reminder.getID())});
        db.close();
    }
}*/
