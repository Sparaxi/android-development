package com.example.apitest;

import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class WeatherDataService {

    public String getCityID(String cityName){

    }

    public List<WeatherReportModel> getCityForceCastByID(String cityID) {
        String url = "https://www.metaweather.com/api/location/search/?query=" + searchWeatherData.getText().toString();

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


                Toast.makeText(MainActivity.this, "City ID = " + cityID, Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        MySingleton.getInstance(MainActivity.this).addToRequestQueue(request);
    }

    }

    public List<WeatherReportModel> getCityForeCastByName(String cityName) {


    }
}
