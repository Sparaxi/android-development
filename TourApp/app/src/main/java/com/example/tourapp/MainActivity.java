package com.example.tourapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void info(View view) {
        TextView a  = findViewById(R.id.text_avio_info);
        a.setVisibility(View.VISIBLE);
        View b = findViewById(R.id.box_View_Avio);
        b.setVisibility(View.VISIBLE);
        View c = findViewById(R.id.button_info2);
        c.setVisibility(View.VISIBLE);
        View d = findViewById(R.id.button_info);
        d.setVisibility(View.GONE);
        View e = findViewById(R.id.button_volgende);
        e.setVisibility(View.GONE);
        TextView a2 = findViewById(R.id.text_avio_header);
        a2.setVisibility(View.GONE);

    }

    public void Hide(View view) {
        TextView a  = findViewById(R.id.text_avio_info);
        a.setVisibility(View.GONE);
        View b = findViewById(R.id.box_View_Avio);
        b.setVisibility(View.GONE);
        View c = findViewById(R.id.button_info2);
        c.setVisibility(View.GONE);
        View d = findViewById(R.id.button_info);
        d.setVisibility(View.VISIBLE);
        View e = findViewById(R.id.button_volgende);
        e.setVisibility(View.VISIBLE);
        TextView a2 = findViewById(R.id.text_avio_header);
        a2.setVisibility(View.VISIBLE);
    }

    public void volgende(View view) {

    }

    public void Home(View view) {
    }
}