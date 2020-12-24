package com.esprit.barterexchange;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Authentication extends AppCompatActivity {

    Button login, signIn;
    TextView forgetPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);

        login = findViewById(R.id.login_button);
        signIn = findViewById(R.id.signin_button);


        login.setOnClickListener(v -> {
            showFragment(new LoginFrag());
        });

        signIn.setOnClickListener(v -> {
            showFragment(new SignInFrag());
        });


        showFragment(new LoginFrag());
    }

    void showFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame, fragment)
                .commit();
    }
}