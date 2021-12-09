package com.example.googleapitest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button gBooks_Search;
        gBooks_Search = findViewById(R.id.gb_SearchButton);
        EditText gBooks_EditText;
        gBooks_EditText = findViewById(R.id.gb_EditTextButton);
        TextView gb_TextView;
        gb_TextView = findViewById(R.id.gb_textView);

        final GbookDataservice gbookDataservice = new GbookDataservice(MainActivity.this);

        gBooks_Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gbookDataservice.getBookID(gBooks_EditText.getText().toString(), new GbookDataservice.VolleyResponseListener() {
                    @Override
                    public void onError(String message) {
                        Toast.makeText(MainActivity.this, "something went wrong", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(String bookID) {
//                        Toast.makeText(MainActivity.this, "" + bookID, Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
    }
}