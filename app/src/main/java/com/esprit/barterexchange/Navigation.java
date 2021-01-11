package com.esprit.barterexchange;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.esprit.barterexchange.Entities.CurrentUser;
import com.esprit.barterexchange.Entities.Goods;
import com.esprit.barterexchange.Services.GoodsServices;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Navigation extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.getMenu().getItem(2).setEnabled(false);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setItemIconTintList(null);

        fab = findViewById(R.id.fab);
        fab.setSupportBackgroundTintList(null);

        fab.setOnClickListener(v ->{
            AlertDialog.Builder mBuild = new AlertDialog.Builder(v.getContext());
            View mView = getLayoutInflater().inflate(R.layout.add_good, null);

            EditText goodName = mView.findViewById(R.id.good_name);
            EditText imagePath = mView.findViewById(R.id.image_path);
            EditText location = mView.findViewById(R.id.location);
            Button uploadBtn = mView.findViewById(R.id.upload_btn);
            EditText desc = mView.findViewById(R.id.desc);
            Button addBtn = mView.findViewById(R.id.add_button);

            addBtn.setOnClickListener(view ->{
                GoodsServices gs = new GoodsServices();
                gs.addGood(new Goods(CurrentUser.getId(), goodName.getText().toString(), desc.getText().toString(), imagePath.getText().toString(), location.getText().toString()));
            });


            mBuild.setView(mView);
            AlertDialog dialog = mBuild.create();
            dialog.show();
        });

        showFragment(new Home());

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                showFragment(new Home());
                return true;

            case R.id.demandes:
                showFragment(new Demandes());
                return true;

            case R.id.notification:
                showFragment(new Notification());
                return true;

            case R.id.profil:
                showFragment(new Profile());
                return true;
        }
        return false;
    }

    void showFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame, fragment)
                .commit();
    }

}