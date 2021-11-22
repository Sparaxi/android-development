package com.example.apitest;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class WeatherDataService {

    static Context context;

    public interface VolleyResponseListener{
        void onError(String message);

        void onResponse(String cityID);

    }

    public WeatherDataService(Context context) {
        this.context = context;
    }

    public static final String QUERY_FOR_CITY_ID = "https://www.metaweather.com/api/location/search/?query=";

    public void getCityID(String cityName,VolleyResponseListener volleyResponseListener ) {

            String url = QUERY_FOR_CITY_ID + cityName;

            JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    String cityID= "";
                    try {
                        JSONObject cityInfo = response.getJSONObject(0);
                        cityID = cityInfo.getString("woeid");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                    //Toast.makeText(context, "City ID = " + cityID, Toast.LENGTH_SHORT).show();
                    volleyResponseListener.onResponse(cityID);

                }
            },new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    volleyResponseListener.onError("Oops something went wrong...");
                }
            });
            MySingleton.getInstance(context).addToRequestQueue(request);

            //return cityName;
        }



    public  getCityForeCastByID(String cityID){
        List<WeatherReportModel> report = new ArrayList<>();
    }
}
//
//    public List<WeatherReportModel> getCityForeCastByName(String cityName) {
//
//
//    }


