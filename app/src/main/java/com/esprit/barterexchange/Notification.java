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

public class Notification extends Fragment {

    View rootView;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    NotificationAdapter notificationAdapter;

    String[] names = {"jessy", "walter", "hank"};
    String[] notifs = {"Wants to sell you some crack", "wants to partner up and coock", "Watch out he's wide awake"};
    int[] imgs = {R.drawable.ellipse_32, R.drawable.ellipse_32, R.drawable.ellipse_32};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.notification, container, false);
        recyclerView = rootView.findViewById(R.id.notification_recycler);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(rootView.getContext());
        recyclerView.setLayoutManager(layoutManager);
        notificationAdapter = new NotificationAdapter(rootView.getContext(), names, notifs, imgs);

        recyclerView.setAdapter(notificationAdapter);


        return rootView;

    }
}
