package com.example.googlebooksapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button gBooks_SearchButton;
        EditText gBooks_SearchBooks;

        gBooks_SearchButton = findViewById(R.id.gBooks_SearchButton);
        gBooks_SearchBooks = findViewById(R.id.gBooks_SearchBooks);

        gBooks_SearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BookDataService.getBookID(gBooks_SearchBooks.getText().toString(), new BookDataService.VolleyResponseListener() {
                    @Override
                    public void onError(String message) {
                        Toast.makeText(MainActivity.this, "oops something is wrong...", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(String bookName) {
                        Toast.makeText(MainActivity.this, "Here is your book," + bookName, Toast.LENGTH_SHORT).show();
                    }
                });


            }//onclick
        });// onclicklistener
    }//onCreate
}//EOC