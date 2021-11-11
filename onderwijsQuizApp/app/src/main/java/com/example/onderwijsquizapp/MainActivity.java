package com.example.onderwijsquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CheckBox cb0;
    CheckBox cb1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cb0 = findViewById(R.id.checkbox0);
        cb1 = findViewById(R.id.checkbox1);

    }


    public void Submit(View v) {

        if (cb0.isChecked()) {
            TextView textView = findViewById(R.id.correct_TextView);
            textView.setVisibility(View.VISIBLE);
            TextView t = findViewById(R.id.Wrong_TextView);
            t.setVisibility(View.GONE);
        }
        if (cb1.isChecked()) {
            TextView t = findViewById(R.id.Wrong_TextView);
            t.setVisibility(View.VISIBLE);
            TextView textView = findViewById(R.id.correct_TextView);
            textView.setVisibility(View.GONE);
        }
    }

}

