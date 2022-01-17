package com.example.test;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class NewsDataService {

    public static final String GUARDIAN_NEWS_API = "https://content.guardianapis.com/search?q=tech&api-key=test";
    Context context;

    public String url = "https://content.guardianapis.com/search?q=tech&api-key=test";

    public NewsDataService(Context context) {
        this.context = context;
    }

    public interface VolleyResponseListener{
        void onError(String message);

        void onResponse(List<NewsStringStorage> newsStringStorages);
    }

   public void getNewsID(String newsName, final VolleyResponseListener volleyResponseListener){
        List<NewsStringStorage> newsStringStorages = new ArrayList<>();

        String url = GUARDIAN_NEWS_API;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                

            }
        });

   }

}
