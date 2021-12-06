package com.example.googlebooksapp;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONObject;

public class GbooksDataService {

    Context context;
    String bookID;

    public static final String QUERY_FOR_GOOGLE_BOOK_SEARCH = "https://www.googleapis.com/books/v1/volumes?q=android";

    public interface VolleyResponseListener{
        void onError(String message);

        void onResponse(String bookID);
    }

    public GbooksDataService(Context context) {
        this.context = context;
    }

    public String getBookID(String bookName, final VolleyResponseListener volleyResponseListener){
        String url = QUERY_FOR_GOOGLE_BOOK_SEARCH + bookName;

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                bookID = "";
                try {
                    JSONObject bookInfo = response.getJSONObject(0);
                    bookID = bookInfo.getString("kind");

                } catch (Exception e) {
                    e.printStackTrace();
                        Toast.makeText(context, "JSON error"+ e.getMessage(), Toast.LENGTH_SHORT).show();
                }

                Toast.makeText(context, "Book id = " + bookID, Toast.LENGTH_SHORT).show();
                volleyResponseListener.onResponse(bookID);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                volleyResponseListener.onError("something went wrong");

            }
        });


        MySingleton.getInstance(context).addToRequestQueue(request);
        return bookID;

    }



//    public List<GbooksReportModel> getBooksByName(String gBookName){
//
//    }
}
