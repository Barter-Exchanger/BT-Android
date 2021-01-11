package com.esprit.barterexchange;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.esprit.barterexchange.Entities.CurrentUser;
import com.esprit.barterexchange.Entities.Goods;
import com.esprit.barterexchange.Entities.Publication;
import com.esprit.barterexchange.Entities.User;
import com.esprit.barterexchange.Services.GoodsServices;
import com.esprit.barterexchange.Services.PublicationService;
import com.esprit.barterexchange.Services.UserServices;

import java.util.ArrayList;

public class Profile extends Fragment {

    View rootView;

    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    RecyclerView recyclerView;
    String[] names ;
    String[] descriptions ;
    String[] location ;
    String[] goodLabel ;
    int[] imgProfile = {R.drawable.ellipse_32, R.drawable.ellipse_32, R.drawable.ellipse_32, R.drawable.ellipse_32};
    int[] imgGoods = {R.drawable.ellipse_32, R.drawable.ellipse_32, R.drawable.ellipse_32, R.drawable.ellipse_32};
    TextView username, name;
    ArrayList<Publication> publicationArrayList;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.profile, container, false);

        username = rootView.findViewById(R.id.textView);
        name = rootView.findViewById(R.id.textView3);
        UserServices us = new UserServices();
        User u = us.getUserById(CurrentUser.getId());

        username.setText(u.getUsername());
        name.setText(u.getFirstName()+" "+u.getLastName());
        PublicationService ps = new PublicationService();
        publicationArrayList = ps.getUserPublications(CurrentUser.getId());

        names = publicationArrayList.stream().map(p -> p.getUsername()).toArray(String[]::new);
        descriptions = publicationArrayList.stream().map(p -> p.getGoodDescription()).toArray(String[]::new);
        goodLabel = publicationArrayList.stream().map(p -> p.getGoodLabel()).toArray(String[]::new);
        location = publicationArrayList.stream().map(p -> p.getLocation()).toArray(String[]::new);

        recyclerView = rootView.findViewById(R.id.profile_recycler);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(rootView.getContext());
        recyclerView.setLayoutManager(layoutManager);

        ProgramAdapter programAdapter = new ProgramAdapter(rootView.getContext(), names, descriptions, location, goodLabel, imgGoods, imgProfile);
        recyclerView.setAdapter(programAdapter);

        return rootView;

    }
}
