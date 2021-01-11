package com.esprit.barterexchange.Services;

import com.esprit.barterexchange.Entities.Goods;
import com.esprit.barterexchange.Entities.User;
import com.esprit.barterexchange.Model.OkHttp;
import com.esprit.barterexchange.Statics.Statics;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ExchangeServices {

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    public void addExchange(Goods goodUser1, Goods goodUser2, User user1, User user2) {
        OkHttpClient client = OkHttp.getInstance();

        JSONObject json = new JSONObject();
        try {
            json.put("User1", user1.getId());
            json.put("User2", user2.getId());
            json.put("GoodUser1", goodUser1.getId());
            json.put("GoodUser2", goodUser2.getId());
            //json.put("user1_confirmation", g.getUser());
            //json.put("user2_confirmation", g.getUser());

        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(JSON, json.toString());
        //HttpUrl localUrl = HttpUrl.parse("http//192.168.1.9:3000/addGood");

        Request request = new Request.Builder()
                .url(Statics._BASE_URL + "addExchange")
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
