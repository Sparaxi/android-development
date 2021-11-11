package com.example.scoreboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int quantityRed = 0;
    int quantityBlue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void valueRedTeam(View view) {
        quantityRed++;
        displayRed(quantityRed);
    }

    private void displayRed(int quantity) {
        TextView redQuantityTextView = findViewById(R.id.button_Red_Team);
        redQuantityTextView.setText("" + quantityRed);
    }


    public void valueBlueTeam(View view) {
        quantityBlue++;
        displayblue(quantityBlue);
    }

    private void displayblue(int quantity) {
        TextView blueQuantityTextView = findViewById(R.id.button_Blue_Team);
        blueQuantityTextView.setText("" + quantityBlue);
    }

    public void Reset_Score(View view) {
        quantityRed = 0;
        quantityBlue = 0;
        displayReset(quantityBlue,quantityRed);
    }

    private void displayReset(int quantityBlue, int quantityRed) {
        TextView BluequantityTextView = findViewById(R.id.button_Blue_Team);
        BluequantityTextView.setText("0");
        TextView RedquantityTextView = findViewById(R.id.button_Red_Team);
        RedquantityTextView.setText("0");

    }


}