package com.esprit.barterexchange.Services;

import android.util.MalformedJsonException;

import com.esprit.barterexchange.Entities.CurrentUser;
import com.esprit.barterexchange.Model.OkHttp;
import com.esprit.barterexchange.Statics.Statics;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.MalformedInputException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class CurrentUserServices {

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    public void login(String email, String password) {
        OkHttpClient client = OkHttp.getInstance();
        JSONObject obj = new JSONObject();

        try {
            obj.put("email", email);
            obj.put("password", password);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(JSON, obj.toString());
        Request request = new Request.Builder()
                .url(Statics._BASE_URL +"login")
                .post(body)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                }//else {
                try {
                    JsonElement res = JsonParser.parseString(response.body().string());
                    JsonObject jElem = res.getAsJsonObject();

                    CurrentUser.setId(Integer.parseInt(jElem.get("ID").getAsString()));
                    CurrentUser.setFirstName(jElem.get("FirstName").getAsString());
                    CurrentUser.setLastName(jElem.get("LastName").getAsString());
                    CurrentUser.setUsername(jElem.get("Username").getAsString());
                    CurrentUser.setEmail(jElem.get("email").getAsString());
                    CurrentUser.setPassword(jElem.get("password").getAsString());

                    System.out.println(CurrentUser.getFirstName());
                }catch (Exception e){
                    e.printStackTrace();
                }
                //}

            }
        });

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
