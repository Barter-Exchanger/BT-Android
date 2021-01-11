package com.esprit.barterexchange;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.esprit.barterexchange.Entities.Publication;
import com.esprit.barterexchange.Services.PublicationService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class Home extends Fragment {

    View rootView;

    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    RecyclerView recyclerView;
    /*String[] names = {"john", "carley", "james", "rian"};
    String[] descriptions = {"some random text", "some random text", "some random text", "some random text"};
    String[] goodLabel = {"good label", "good label", "good label", "good label"};*/
    String[] names, descriptions, goodLabel;
    String[] location ;
    int[] goodId;
    int[] imgProfile = {R.drawable.profile, R.drawable.profile};
    int[] imgGoods = {R.drawable.download, R.drawable.download};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.home, container, false);

        recyclerView = rootView.findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(rootView.getContext());
        recyclerView.setLayoutManager(layoutManager);

        PublicationService ps = new PublicationService();
        ArrayList<Publication> publicationArrayList = ps.getPublications();

        names = publicationArrayList.stream().map(p -> p.getUsername()).toArray(String[]::new);
        descriptions = publicationArrayList.stream().map(p -> p.getGoodDescription()).toArray(String[]::new);
        goodLabel = publicationArrayList.stream().map(p -> p.getGoodLabel()).toArray(String[]::new);
        location = publicationArrayList.stream().map(p -> p.getLocation()).toArray(String[]::new);
        goodId = publicationArrayList.stream().mapToInt(p -> p.getGoodId()).toArray();


        ProgramAdapter programAdapter = new ProgramAdapter(rootView.getContext(), names, descriptions, location, goodLabel, imgGoods, imgProfile, goodId);
        recyclerView.setAdapter(programAdapter);

        return rootView;
    }
}
