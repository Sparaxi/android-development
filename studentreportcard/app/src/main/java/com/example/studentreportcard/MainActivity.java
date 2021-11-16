package com.example.studentreportcard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int dataBaseLength = 100;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        // create data
        ArrayList<Person> arrayList = new ArrayList<>();

        for (int i = 0; i <dataBaseLength ; i ++){
            arrayList.add(new Person(R.drawable.item1, "this is a test"));
        }

        //adapter
        PersonAdapter personAdapter = new PersonAdapter(this,R.layout.list_row,arrayList);

        listView.setAdapter(personAdapter);
    }
}