package com.example.endsemesterexams;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class USIUActivity extends AppCompatActivity {
private Button insert, view;
private EditText FirstNameText, LastNameText, StudIDInt, SchoolsText, SchoolCodeText;
    ExamsDBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usiuactivity);

        insert = findViewById(R.id.insert);
        view = findViewById(R.id.view);
        FirstNameText = findViewById(R.id.FirstNameText);
        LastNameText = findViewById(R.id.LastNameText);
        StudIDInt = findViewById(R.id.StudIDInt);
        SchoolsText = findViewById(R.id.SchoolsText);
        SchoolCodeText = findViewById(R.id.SchoolCodeText);
        db = new ExamsDBHelper(this);


        //inserting to the database
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String FirstName = FirstNameText.getText().toString();
                String LastName = LastNameText.getText().toString();
                String IDNo = StudIDInt.getText().toString();
                String Schools = SchoolsText.getText().toString();
                String SchoolCode = SchoolCodeText.getText().toString();

                Boolean checkinsertdata = db.insertSchoolData(FirstName, LastName, IDNo, Schools, SchoolCode);
                if (checkinsertdata == true)
                    Toast.makeText(USIUActivity.this, "New entry inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(USIUActivity.this, "Entry was not inserted", Toast.LENGTH_SHORT).show();
            }
        });

        //view the data
        view.setOnClickListener(new View.OnClickListener() {
            @Override
          public void onClick(View view) {

                Cursor res = db.getData();
                if (res.getCount() == 0) {
                    Toast.makeText(USIUActivity.this, "No entry exists", Toast.LENGTH_SHORT).show();
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("FirstName : " + res.getString(0) + "\n");
                    buffer.append("LastName : " + res.getString(1) + "\n");
                    buffer.append("IDNo : " + res.getString(2) + "\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(USIUActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Data Entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
    }
}