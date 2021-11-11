package com.example.lelystadtourapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class aviodromeActivity extends AppCompatActivity {

    TextView infotext;
    View infobackgroundview;
    Button hide;
    Button Home;
    Button info;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aviodrome);
        infotext = findViewById(R.id.info_text_aviodome);
        info = findViewById(R.id.info_textview_aviodome);
        infobackgroundview = findViewById(R.id.info_background_view);
        hide = findViewById(R.id.info_hide);
        Home = findViewById(R.id.home_textview_aviodome);
    }

    public void MainActivity(View view) {
        Intent MainActivity = new Intent(this, com.example.lelystadtourapp.MainActivity.class);
        startActivity(MainActivity);
    }

    public void info(View view) {
        infobackgroundview.setVisibility(View.VISIBLE);
        infotext.setVisibility(View.VISIBLE);
        Home.setVisibility(View.GONE);
        info.setVisibility(View.GONE);
        hide.setVisibility(View.VISIBLE);
    }

    public void infoHide(View view) {
        infobackgroundview.setVisibility(View.GONE);
        Home.setVisibility(View.VISIBLE);
        info.setVisibility(View.VISIBLE);
        infotext.setVisibility(View.GONE);
        hide.setVisibility(View.GONE);

    }
}