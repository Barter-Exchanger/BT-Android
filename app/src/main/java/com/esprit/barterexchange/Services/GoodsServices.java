package com.esprit.barterexchange.Services;

import com.esprit.barterexchange.Entities.CurrentUser;
import com.esprit.barterexchange.Entities.Goods;
import com.esprit.barterexchange.Model.OkHttp;
import com.esprit.barterexchange.Statics.Statics;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class GoodsServices {

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    ArrayList<Goods> goods;
    Goods good;

    public ArrayList<Goods> getGoods() {

        OkHttpClient client = OkHttp.getInstance();
        Request request = new Request.Builder()
                .url(Statics._BASE_URL + "getGoods")
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

                Gson gson = new Gson();
                Goods[] goodsArray = gson.fromJson(response.body().string(), Goods[].class);
                Collections.addAll(goods, goodsArray);

            }
        });
        return goods;
    }

    public void addGood(Goods g) {
        OkHttpClient client = OkHttp.getInstance();

        JSONObject json = new JSONObject();
        try {
            json.put("name", g.getName());
            json.put("image", g.getImage());
            json.put("description", g.getDescription());
            json.put("location", g.getLocation());
            json.put("user", g.getUser());

        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(JSON, json.toString());
        //HttpUrl localUrl = HttpUrl.parse("http//192.168.1.9:3000/addGood");

        Request request = new Request.Builder()
                .url(Statics._BASE_URL + "addGood")
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

                //Gson gson = new Gson();
                //Goods[] goodsArray = gson.fromJson(response.body().string(), Goods[].class);
                //Collections.addAll(goods, goodsArray);

            }
        });

    }

    public Goods getGoodById(int id) {

        OkHttpClient client = OkHttp.getInstance();
        Request request = new Request.Builder()
                .url(Statics._BASE_URL + "goods/" + id)
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
                    good = new Goods();

                    good.setId(Integer.parseInt(jElem.get("id").getAsString()));
                    good.setName(jElem.get("name").getAsString());
                    good.setImage(jElem.get("image").getAsString());
                    good.setDescription(jElem.get("description").getAsString());
                    good.setUser(Integer.parseInt(jElem.get("user").getAsString()));

                    System.out.println(good.getName());
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
        return good;

    }

    public void deleteGoodById(int id) {

        OkHttpClient client = OkHttp.getInstance();
        Request request = new Request.Builder()
                .url(Statics._BASE_URL + "goods/delete/" + id)
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

    public ArrayList<Goods> getGoodsByUserId(int id) {

        OkHttpClient client = OkHttp.getInstance();
        Request request = new Request.Builder()
                .url(Statics._BASE_URL + "getGoodByUserId/" + id)
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

                Gson gson = new Gson();
                Goods[] goodsArray = gson.fromJson(response.body().string(), Goods[].class);
                goods = new ArrayList<>();
                Collections.addAll(goods, goodsArray);
            }
        });

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return goods;
    }
}

