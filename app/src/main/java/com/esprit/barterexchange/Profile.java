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

public class Profile extends Fragment {

    View rootView;

    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    RecyclerView recyclerView;
    String[] names = {"john", "carley", "james", "rian"};
    String[] descriptions = {"some random text", "some random text", "some random text", "some random text"};
    String[] location = {"new orleans", "california", "washingnon", "texas"};
    String[] goodLabel = {"good label", "good label", "good label", "good label"};
    int[] imgProfile = {R.drawable.ellipse_32, R.drawable.ellipse_32, R.drawable.ellipse_32, R.drawable.ellipse_32};
    int[] imgGoods = {R.drawable.ellipse_32, R.drawable.ellipse_32, R.drawable.ellipse_32, R.drawable.ellipse_32};


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.profile, container, false);

        recyclerView = rootView.findViewById(R.id.profile_recycler);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(rootView.getContext());
        recyclerView.setLayoutManager(layoutManager);

        ProgramAdapter programAdapter = new ProgramAdapter(rootView.getContext(), names, descriptions, location, goodLabel, imgGoods, imgProfile);
        recyclerView.setAdapter(programAdapter);

        return rootView;

    }
}
