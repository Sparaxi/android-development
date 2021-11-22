package com.example.apitest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {



    WeatherDataService weatherDataService = new WeatherDataService(MainActivity.this);
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button search_ByCity;
        Button search_By_Location;
        Button city_Location;

        EditText searchWeatherData;

        search_ByCity = findViewById(R.id.search_ByCity);
        search_By_Location = findViewById(R.id.weather_By_ID);
        city_Location = findViewById(R.id.city_Location);
        searchWeatherData = findViewById(R.id.search_Weather_Location);

        search_ByCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                weatherDataService.getCityID(searchWeatherData.getText().toString(), new WeatherDataService.VolleyResponseListener() {
                    @Override
                    public void onError(String message) {
                        Toast.makeText(MainActivity.this, "Oops something is wrong...", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(String cityID) {
                        Toast.makeText(MainActivity.this, "City ID = " + cityID, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


        search_By_Location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                weatherDataService.getCityForeCastByID(searchWeatherData.getText().toString(), new WeatherDataService.VolleyResponseListener() {
                    @Override
                    public void onError(String message) {
                        Toast.makeText(MainActivity.this, "Oops something is wrong...", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(String cityID) {
                        Toast.makeText(MainActivity.this, "City ID = " + cityID, Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        city_Location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}
