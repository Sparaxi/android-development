package com.example.googleapitest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

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
            public void onClick(View view) {
                String url = "https://www.googleapis.com/books/v1/volumes?q=android";

                JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, "https://www.googleapis.com/books/v1/volumes?q=android", null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(MainActivity.this, "" + response, Toast.LENGTH_SHORT).show();
                    },new Response.ErrorListener(){
                        
                    }
                });
            }
        });
    }
}