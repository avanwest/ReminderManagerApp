package seclass.qc.edu.glm;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.*;

public class ReminderActivity extends AppCompatActivity {

    public static int hour;
    public static int minute;
    EditText getName;
    EditText getType;
    String name = "";
    String type = "";

    EditText getDate;
    EditText getTime;
    String date;
    String time;
/*
    Date date;
    String formatDate = new SimpleDateFormat("MMddyyyy").format(date);
    Date time;
    String formatTime = new SimpleDateFormat("hhmmaa").format(time);
*/

    Intent rListActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminders);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void submitAttributes(View v) {
        getName = (EditText) findViewById(R.id.enterName);
        name = getName.getText().toString();
        getType = (EditText) findViewById(R.id.enterType);
        type = getType.getText().toString();

        getDate = (EditText) findViewById(R.id.enterDate);
        date = getDate.getText().toString();
        getTime = (EditText) findViewById(R.id.enterTime);
        time = getTime.getText().toString();

        Reminder reminder = new Reminder(type, name, date, time);
        rListActivity = new Intent(this, RListActivity.class);
        rListActivity.putExtra("name", name);
        rListActivity.putExtra("type", type);

        if(date.trim().length() != 0 && time.trim().length() != 0) {
            rListActivity.putExtra("date", date);
            rListActivity.putExtra("time", time);
        }
        finish();
    }

    public void dateAndTime(View v) {
        Toast.makeText(this, "Date and Time not implemented yet"  , Toast.LENGTH_SHORT).show();

    }

    @Override
    public void finish(){
        setResult(1, rListActivity);
        super.finish();
    }

}
