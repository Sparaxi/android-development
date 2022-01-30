package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button HITME;
        HITME = findViewById(R.id.HITME);
        ListView newsListView = findViewById(R.id.newsList);

        final NewsDataService newsDataService = new NewsDataService(MainActivity.this);

        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                newsDataService.getNewsID(new NewsDataService.VolleyResponseListener() {
                    @Override
                    public void onError(String message) {
                        Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(List<NewsStringStorage> newsStringStorages) {
                        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, newsStringStorages);
                        newsListView.setAdapter(arrayAdapter);
                    }
                });
            }
        }, 10000);

//        HITME.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                newsDataService.getNewsID(new NewsDataService.VolleyResponseListener() {
//                    @Override
//                    public void onError(String message) {
//                        Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onResponse(List<NewsStringStorage> newsStringStorages) {
//                        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, newsStringStorages);
//                        newsListView.setAdapter(arrayAdapter);
//                    }
//                });
//
//            }
//        });
    }
}