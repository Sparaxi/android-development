package com.example.googlebooksapp;

import android.content.Context;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BookDataService {
    Context context;

    public static final String url = "https://www.googleapis.com/books/v1/volumes?q=android&maxResults=1";

    public interface VolleyResponseListener{
        void onError(String message);

        void onResponse(String bookName);

    }

    public BookDataService(Context context){
        this.context = context;
    }

    public static String getBookID(String bookNameID, final VolleyResponseListener volleyResponseListener) {
        String url = "https://www.googleapis.com/books/v1/volumes?q=" + bookNameID;

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

            }
        });

    }




}
