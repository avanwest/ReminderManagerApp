package seclass.qc.edu.glm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class activity_username extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_username);
    }

    public void storeName(View v){
        EditText userName = (EditText) findViewById(R.id.userNameField);
        Intent userIntent = new Intent (this, RListActivity.class);
        userIntent.putExtra("username", userName.getText().toString());
        startActivity(userIntent);
    }
}
