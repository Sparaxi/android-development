package com.example.googleapitest;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GbookDataservice {
    String bookVolume;
    String bookID;
    Context context;

    public static final String GOOGLE_API_BOOK_SEARCH = "https://www.googleapis.com/books/v1/volumes?q=";


    public GbookDataservice(Context context) {
        this.context = context;
    }

    public interface VolleyResponseListener{
        void onError(String message);

        void onResponse(String bookID);
    }

    public void getBookID(String bookName, final VolleyResponseListener volleyResponseListener){
        String url = GOOGLE_API_BOOK_SEARCH + bookName;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                       bookID = "";
                       bookVolume = "";
                        try {
                            JSONArray bookInfo = response.getJSONArray("items");
                            bookID = bookInfo.getString(2);


//                            Toast.makeText(context, "" + bookInfo.getJSONObject(3).getJSONObject("volumeInfo"), Toast.LENGTH_SHORT).show();
                        } catch (Exception e) {
                            e.printStackTrace();

                        }


//                        Toast.makeText(context, "" + bookVolume, Toast.LENGTH_SHORT).show();

//                        Toast.makeText(context, "" + bookID, Toast.LENGTH_SHORT).show();
                        volleyResponseListener.onResponse(bookID);


                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        volleyResponseListener.onError("error something went wrong");

                    }
                });

// Access the RequestQueue through your singleton class.
        MySingleton.getInstance(context).addToRequestQueue(jsonObjectRequest);


    }

    public interface GBooksResponse{
        void onError(String message);

        void onResponse(List<GbooksStringStorage> gbooksStringStorages);
    }

    public void getGBooksResponse(String bookID, GBooksResponse gBooksResponse){
        List<GbooksStringStorage> gbooksStringStorages = new ArrayList<>();


    }
}
