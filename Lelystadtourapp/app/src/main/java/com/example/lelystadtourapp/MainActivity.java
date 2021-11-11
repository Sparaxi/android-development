package com.example.lelystadtourapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void aviodromeActivity(View view) {
        Intent Aviodrome = new Intent(this, aviodromeActivity.class);
        startActivity(Aviodrome);
    }

    public void batavialandActivity(View view) {
        Intent BataviaLand = new Intent(this, batavialandActivity.class);
        startActivity(BataviaLand);
    }

    public void bataviastadActivity(View view) {
        Intent Bataviastad = new Intent(this, bataviastadActivity.class);
        startActivity(Bataviastad);
    }

    public void natuurparkActivity(View view) {
        Intent natuurpark = new Intent(this, natuurparkActivity.class);
        startActivity(natuurpark);
    }
}