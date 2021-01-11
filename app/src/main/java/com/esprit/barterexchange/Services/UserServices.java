package com.esprit.barterexchange.Services;

import com.esprit.barterexchange.Entities.CurrentUser;
import com.esprit.barterexchange.Entities.Goods;
import com.esprit.barterexchange.Entities.User;
import com.esprit.barterexchange.Model.OkHttp;
import com.esprit.barterexchange.Statics.Statics;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class UserServices {

    User u;
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    public User getUserById(int id) {

        OkHttpClient client = OkHttp.getInstance();
        Request request = new Request.Builder()
                .url(Statics._BASE_URL + "getUserById/" + id)
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
                }

                try {
                    JsonElement res = JsonParser.parseString(response.body().string());
                    JsonObject jElem = res.getAsJsonObject();

                    u = new User();

                    u.setId(Integer.parseInt(jElem.get("ID").getAsString()));
                    u.setFirstName(jElem.get("FirstName").getAsString());
                    u.setLastName(jElem.get("LastName").getAsString());
                    u.setUsername(jElem.get("Username").getAsString());
                    u.setEmail(jElem.get("email").getAsString());
                    u.setPassword(jElem.get("password").getAsString());

                    System.out.println(u.getFirstName());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        });

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return u;

    }

    public void addUser(User u) {
        OkHttpClient client = OkHttp.getInstance();

        JSONObject json = new JSONObject();
        try {
            json.put("FirstName", u.getFirstName());
            json.put("LastName", u.getLastName());
            json.put("Username", u.getUsername());
            json.put("email", u.getEmail());
            json.put("password", u.getPassword());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestBody body = RequestBody.create(JSON, json.toString());
        Request request = new Request.Builder()
                .url(Statics._BASE_URL + "addUser")
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
                }

            }
        });

    }
}

