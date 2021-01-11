package com.esprit.barterexchange;

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

import com.esprit.barterexchange.Entities.Exchange;
import com.esprit.barterexchange.Entities.User;
import com.esprit.barterexchange.Services.UserServices;

public class SignInFrag extends Fragment {
    EditText firstName, lastName, username, email, password, retypePassword;
    Button register;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.singn_in, container, false);

        firstName = rootView.findViewById(R.id.fname);
        lastName = rootView.findViewById(R.id.lname);
        username = rootView.findViewById(R.id.username);
        email = rootView.findViewById(R.id.email);
        password = rootView.findViewById(R.id.password);
        retypePassword = rootView.findViewById(R.id.retype_password);
        register = rootView.findViewById(R.id.register);

        register.setOnClickListener(v ->{
            if (email.getText().toString().matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+") && email.getText().toString().length() > 0) {

                UserServices userServices = new UserServices();
                User user = new User(firstName.getText().toString(), lastName.getText().toString(), username.getText().toString(), email.getText().toString(), password.getText().toString());
                userServices.addUser(user);

            }else if (password.getText().toString().equals(retypePassword.getText().toString()) && password.getText().toString().length() >= 8){
                Toast.makeText(v.getContext(), "Invalid password", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(v.getContext(), "Invalid email address", Toast.LENGTH_SHORT).show();

            }

        });

        return rootView;
    }
}
