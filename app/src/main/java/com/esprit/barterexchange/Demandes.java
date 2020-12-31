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

public class Demandes extends Fragment {

    View rootView;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    DemandesAdapter demandesAdapter;

    String[] otherGoods = {"other good 1" , "other good2"};
    String[] myGoods = {"my good 1", "my good2"};
    int[] otherGoodsImages = {R.drawable.ellipse_32, R.drawable.ellipse_32, R.drawable.ellipse_32, };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.demandes, container, false);
        recyclerView = rootView.findViewById(R.id.demandes_recycler);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(rootView.getContext());
        recyclerView.setLayoutManager(layoutManager);

        DemandesAdapter demandesAdapter = new DemandesAdapter(rootView.getContext(), otherGoods, myGoods, otherGoodsImages);
        recyclerView.setAdapter(demandesAdapter);


        return rootView;

    }
}
