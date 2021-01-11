package com.esprit.barterexchange.Model;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class OkHttp {

    private static OkHttpClient instance;

    private OkHttp(){
        new OkHttpClient();
    }

    public static OkHttpClient getInstance(){
        if (instance == null){
            instance =  new OkHttpClient();
            return instance;
        }
        return instance;
    }

}
