package com.example.theguardiannewsapp;

import android.content.Context;

import com.android.volley.toolbox.JsonArrayRequest;

import java.util.ArrayList;
import java.util.List;

public class GuardianDataService {
    Context context;

    public GuardianDataService(Context context){this.context = context;}

    public interface VolleyResponseListener{
        void onError(String message);

        void onResponse(List<GuardianStrinStorage> guardianStrinStorages);

    }

    public void NewsApi(String newsApi, final VolleyResponseListener volleyResponseListener){
        List<GuardianDataService> guardianDataServices = new ArrayList<>();

        String url = "https://content.guardianapis.com/search?page=2&q=debate&api-key=test";

        JsonArrayRequest
    }

}
