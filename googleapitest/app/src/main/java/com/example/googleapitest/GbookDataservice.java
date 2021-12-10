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

    Context context;

    public static final String GOOGLE_API_BOOK_SEARCH = "https://www.googleapis.com/books/v1/volumes?q=";




    public GbookDataservice(Context context) {
        this.context = context;
    }

    public interface VolleyResponseListener{
        void onError(String message);

        void onResponse(List<GbooksStringStorage> gbooksStringStorages);
    }

    public void getBookID(String bookName, final VolleyResponseListener volleyResponseListener){
        List<GbooksStringStorage> gbooksStringStorages = new ArrayList<>();

        String url = GOOGLE_API_BOOK_SEARCH + bookName + "&maxResults=10";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray bookInfo = response.getJSONArray("items");
//                            JSONObject item = bookInfo.getJSONObject(0);
//                            Toast.makeText(context, "" + item.getJSONObject("volumeInfo").getString("subtitle"), Toast.LENGTH_SHORT).show();
//                              Toast.makeText(context, "" + bookInfo, Toast.LENGTH_SHORT).show();


                            GbooksStringStorage gb_volume_info = new GbooksStringStorage();

                            for (int i = 0; i < bookInfo.length(); i++) {
                                JSONObject items = bookInfo.getJSONObject(i);
                                gb_volume_info.setTitle(items.getJSONObject("volumeInfo").getString("title"));
                                gb_volume_info.setSubtitle(items.getJSONObject("volumeInfo").getString("subtitle"));
//                                Toast.makeText(context, "" + gb_volume_info, Toast.LENGTH_SHORT).show();

                            }


                                volleyResponseListener.onResponse(gbooksStringStorages);



                        } catch (Exception e) {
                            e.printStackTrace();

                        }

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




}

