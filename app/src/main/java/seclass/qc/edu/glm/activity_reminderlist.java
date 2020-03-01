package seclass.qc.edu.glm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

//Class for Non Expandable Reminder List
public class activity_reminderlist extends AppCompatActivity {
    ListView reminderList;
    ArrayAdapter<Button> rAdapter;
    ArrayList<Button> rList;
    EditText listName;
    String name;
    Button addList;
    Button btns[] = new Button[30];
    int count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminderlist);
        addList = (Button) findViewById(R.id.addReminderListButton);
        rList = new ArrayList<Button>();
        reminderList = (ListView) findViewById(R.id.reminderListListView);
        rAdapter=new ArrayAdapter<Button>(this, android.R.layout.simple_list_item_1, rList);
        reminderList.setAdapter(rAdapter);
        for(int i = 0; i < 30; i++) {
            btns[i] = new Button(this);
            registerForContextMenu(btns[i]);
        }

        registerForContextMenu(reminderList);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        /*super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Context Menu");
        menu.add(0, v.getId(), 0, "Edit");
        menu.add(1, v.getId(), 0, "Delete");*/
        if (v.getId() == R.id.reminderListListView) {
            ListView lv = (ListView) v;
            AdapterView.AdapterContextMenuInfo acmi = (AdapterView.AdapterContextMenuInfo) menuInfo;
            Button obj = (Button) lv.getItemAtPosition(acmi.position);

            menu.add(0, acmi.position, 0, "Edit");
            menu.add(1, acmi.position, 0, "Delete");

        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        /*if(item.getItemId()==1) {
            Intent attrIntent = new Intent(this, ReminderActivity.class);
            startActivity(attrIntent);
        } else {
            Toast.makeText(this, "This will be deleted " + item.getItemId(), Toast.LENGTH_SHORT).show();

        }*/
        //reminderList.getItemAtPosition(item.getItemId());
        Toast.makeText(this, "This will be deleted " + item.getItemId(), Toast.LENGTH_SHORT).show();

        return true;
    }

    public void addList(View v) {
        listName = (EditText) findViewById(R.id.addReminderListName);
        name = listName.getText().toString();
        rList.add(btns[count]);
        rAdapter.notifyDataSetChanged();
        listName.setText("");
        count++;

    }
}
