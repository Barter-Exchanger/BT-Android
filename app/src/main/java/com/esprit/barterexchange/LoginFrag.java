package com.esprit.barterexchange;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LoginFrag extends Fragment {
    Button loginButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView;

        rootView = inflater.inflate(R.layout.login, container, false);
        loginButton = rootView.findViewById(R.id.login_button);
        loginButton.setOnClickListener(v -> {
            Intent i = new Intent(getActivity(), Navigation.class);
            startActivity(i);
        });

        return rootView;
    }
}
