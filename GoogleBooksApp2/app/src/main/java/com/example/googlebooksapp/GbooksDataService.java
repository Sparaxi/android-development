package com.example.googlebooksapp;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class GbooksDataService {

    public static final String QUERY_FOR_GOOGLE_BOOK_SEARCH = "https://www.googleapis.com/books/v1/volumes?q=";

    Context context;
    String bookID;

    public GbooksDataService(Context context) {
        this.context = context;
    }

    public String getBookID(String bookName){
        String url = QUERY_FOR_GOOGLE_BOOK_SEARCH + bookName;

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                bookID = "";
                try {
                    JSONObject bookInfo = response.getJSONObject(0);
                    String getBookInfo = bookInfo.getString("title");
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Toast.makeText(context, "Book id = " + bookID, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "error something went wrong.", Toast.LENGTH_SHORT).show();
            }
        });

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(context, response, Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle error
                    }
                });


        MySingleton.getInstance(context).addToRequestQueue(request);

        return bookID;
    }



//    public List<GbooksReportModel> getBooksByName(String gBookName){
//
//    }
}
