package com.example.test;

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

import java.util.ArrayList;
import java.util.List;

public class NewsDataService {

    public static final String GUARDIAN_NEWS_API = "https://content.guardianapis.com/search?q=tech&api-key=test";
    Context context;



    public NewsDataService(Context context) {
        this.context = context;
    }

    public interface VolleyResponseListener{
        void onError(String message);

        void onResponse(List<NewsStringStorage> newsStringStorages);
    }

   public void getNewsID(final VolleyResponseListener volleyResponseListener){
        List<NewsStringStorage> newsStringStorages = new ArrayList<>();

        String url = GUARDIAN_NEWS_API;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject newsInfo = response.getJSONObject("response");
                    for (int i = 0; i < newsInfo.length(); i++) {
                        NewsStringStorage news_item_info = new NewsStringStorage();
                        JSONArray newsItems = newsInfo.getJSONArray("results");
                        if ( newsItems.getJSONObject(0).has("webTitle")) {
                            news_item_info.setWebTitle(newsItems.getJSONObject(i).getString("webTitle"));
                        }

                        newsStringStorages.add(news_item_info);
                    }

                    volleyResponseListener.onResponse(newsStringStorages);
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
       MySingleton.getInstance(context).addToRequestQueue(jsonObjectRequest);

   }

}
