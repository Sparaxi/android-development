//package com.example.googlebooksapp;
//
//import android.content.Context;
//
//import com.android.volley.Request;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.JsonArrayRequest;
//
//import org.json.JSONArray;
//
//public class BookDataservice {
//    Context context;
//    String bookID;
//
//    public static final String urlGBooks = "https://www.googleapis.com/books/v1/volumes?q=";
//    public static final String QUERY_FOR_GOOGLE_BOOKS_ID = urlGBooks;
//
//    // for connection to Main activity
//    public BookDataservice(Context context) {
//        this.context = context;
//    }
//
//    // on error and response listener for Book search
//    public interface BookResponseListener{
//        void onError(String message);
//
//        void onResponse(String bookID);
//
//    }
//
//    public void getBookID(String bookID, final BookResponseListener bookResponseListener) {
//
//        String url = QUERY_FOR_GOOGLE_BOOKS_ID + bookID;
//
//        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>(){
//            @Override
//            public void onResponse(JSONArray response) {
//
//
//            }, new Response.ErrorListener(){
//                public void onErrorResponse(BookError error)
//            }
//        });
//
//
//    }
//
//
//}
