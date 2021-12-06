package com.example.googlebooksapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;




public class MainActivity extends AppCompatActivity {


    final GbooksDataService gbooksDataService = new GbooksDataService(MainActivity.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button gBooks_Search;
        gBooks_Search = findViewById(R.id.gb_SearchButton);
        EditText gBooks_EditText;
        gBooks_EditText = findViewById(R.id.gb_EditTextButton);

        gBooks_Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gbooksDataService.getBookID(gBooks_EditText.getText().toString(), new GbooksDataService.VolleyResponseListener() {
                    @Override
                    public void onResponse(String bookID) {
                        Toast.makeText(MainActivity.this, "book Title" + bookID, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(String message) {
                        Toast.makeText(MainActivity.this, "Json error" , Toast.LENGTH_SHORT).show();

                    }


                });

            }
        });

    }
}