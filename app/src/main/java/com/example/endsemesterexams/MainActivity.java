package com.example.endsemesterexams;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private ListView List_View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List_View = findViewById(R.id.List_View);
        //create an array to store the lists
        List<String> list = new ArrayList<>();
        list.add("UON");
        list.add("KU");
        list.add("USIU");
        list.add("STRATHMORE");

        //create an array adapter to populate the List_View
        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_expandable_list_item_1, list);
        //link the adapter to the list view
        List_View.setAdapter(adapter);

        //Making the List_View items clickable
        List_View.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if (position == 0) {
                    //clicked on UON
                } else if (position == 1) {
                    //clicked on KU
                } else if (position == 2){
                    //clicked on USIU
                    startActivity(new Intent(MainActivity.this, USIUActivity.class));
                } else if (position == 3) {
                    //clicked on strathmore
                }
            }
        });
    }
}