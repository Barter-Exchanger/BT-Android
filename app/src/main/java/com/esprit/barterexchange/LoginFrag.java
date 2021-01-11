package com.esprit.barterexchange;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.esprit.barterexchange.Entities.CurrentUser;
import com.esprit.barterexchange.Entities.Goods;
import com.esprit.barterexchange.Entities.Publication;
import com.esprit.barterexchange.Entities.User;
import com.esprit.barterexchange.Services.CurrentUserServices;
import com.esprit.barterexchange.Services.ExchangeServices;
import com.esprit.barterexchange.Services.GoodsServices;
import com.esprit.barterexchange.Services.PublicationService;
import com.esprit.barterexchange.Services.UserServices;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginFrag extends Fragment {
    Button loginButton, fbButton;
    EditText email, password;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView;

        rootView = inflater.inflate(R.layout.login, container, false);
        loginButton = rootView.findViewById(R.id.login_button);
        email = rootView.findViewById(R.id.edit_email);
        password = rootView.findViewById(R.id.edit_password);
        fbButton = rootView.findViewById(R.id.signin_button);

        fbButton.setOnClickListener(v -> {
            System.out.println("clicked");
            GoodsServices goodsServices = new GoodsServices();
            ArrayList<Goods> goodsList = goodsServices.getGoodsByUserId(1);

        });

        loginButton.setOnClickListener(v -> {

            CurrentUserServices cu = new CurrentUserServices();

            if (email.getText().toString().matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+") && email.getText().toString().length() > 0) {
                cu.login(email.getText().toString(), password.getText().toString());
                if (CurrentUser.getFirstName() != null) {
                    Intent i = new Intent(getActivity(), Navigation.class);
                    startActivity(i);
                } else {
                    Toast toast = Toast.makeText(getContext(), "Something went wrong try again", Toast.LENGTH_SHORT);
                    toast.show();
                }
            } else {
                Toast.makeText(v.getContext(), "Invalid email address", Toast.LENGTH_SHORT).show();

            }


        });

        return rootView;
    }
}
