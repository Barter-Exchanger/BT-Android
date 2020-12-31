package com.esprit.barterexchange;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {

    Context context;
    String[] users, notes;
    int[] imgs;

    public NotificationAdapter(Context context, String[] users, String[] notes, int[] imgs) {
        this.context = context;
        this.users = users;
        this.notes = notes;
        this.imgs = imgs;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView username, notification;
        ImageView userImage;

        public ViewHolder(View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.user_name);
            notification = itemView.findViewById(R.id.notification_title);
            userImage = itemView.findViewById(R.id.user_image);

        }

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.notifications_card, parent, false);
        NotificationAdapter.ViewHolder viewHolder = new NotificationAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.userImage.setImageResource(imgs [position]);
        holder.notification.setText(notes[position]);
        holder.username.setText(users[position]);

    }

    @Override
    public int getItemCount() {
        return users.length;
    }


}
