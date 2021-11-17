package com.example.studentreportcardv2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        //ArrayList
        ArrayList<schoolClasses> arrayList = new ArrayList<>();
        arrayList.add(new schoolClasses(R.layout.list_row, "6", "Rekenen"));
        arrayList.add(new schoolClasses(R.layout.list_row, "10", "Loopbaan & Burgerschap"));
        arrayList.add(new schoolClasses(R.layout.list_row, "9", "Nederlands"));
        arrayList.add(new schoolClasses(R.layout.list_row, "8", "Engels"));



        schoolClassesAdapter schoolClassesAdapter = new schoolClassesAdapter(this, R.layout.list_row,arrayList);

        listView.setAdapter(schoolClassesAdapter);


    }
}