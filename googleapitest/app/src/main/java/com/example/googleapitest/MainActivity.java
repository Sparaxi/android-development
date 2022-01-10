package com.example.googleapitest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button gBooks_Search;
        gBooks_Search = findViewById(R.id.gb_SearchButton);
        EditText gBooks_EditText;
        gBooks_EditText = findViewById(R.id.gb_EditTextButton);


        ListView gb_listview;
        gb_listview = findViewById(R.id.gb_ListView);

        final GbookDataservice gbookDataservice = new GbookDataservice(MainActivity.this);

        gBooks_Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gbookDataservice.getBookID(gBooks_EditText.getText().toString(), new GbookDataservice.VolleyResponseListener() {


                    @Override
                    public void onError(String message) {
                        Toast.makeText(MainActivity.this, "error something went wrong, please help", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(List<GbooksStringStorage> gbooksStringStorages) {
                        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, gbooksStringStorages);
                        gb_listview.setAdapter(arrayAdapter);

                    }
                });
            }
        });
    }
}