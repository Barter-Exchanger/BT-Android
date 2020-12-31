package com.esprit.barterexchange;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProgramAdapter extends RecyclerView.Adapter<ProgramAdapter.ViewHolder> {

    Context context;

    String[] goodLabel, description, location, username;
    int[] userImg, goodImg;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.card, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.userImg.setAnimation(AnimationUtils.loadAnimation(context,R.anim.fade_trans));
        holder.layout.setAnimation(AnimationUtils.loadAnimation(context, R.anim.scale_anim));

        holder.username.setText(username[position]);
        holder.description.setText(description[position]);
        holder.goodLabel.setText(goodLabel[position]);
        holder.location.setText(location[position]);
        holder.userImg.setImageResource(userImg[position]);
        holder.goodImg.setImageResource(goodImg[position]);

    }

    @Override
    public int getItemCount() {
        return username.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView goodLabel, description, location, username;
        ImageView userImg, goodImg;
        RelativeLayout layout;


        public ViewHolder(View itemView){
            super(itemView);
            username = itemView.findViewById(R.id.UserNamme);
            location = itemView.findViewById(R.id.location);
            description = itemView.findViewById(R.id.description);
            goodLabel = itemView.findViewById(R.id.label);
            userImg = itemView.findViewById(R.id.UserImage);
            goodImg = itemView.findViewById(R.id.good_image);
            layout = itemView.findViewById(R.id.container);

        }

    }

    public ProgramAdapter(Context context, String[] username, String[] desc, String[] location,String[] goodLabel,  int[] goodImg, int[] userImg){
        this.context = context;
        this.username = username;
        this.description=desc;
        this.location = location;
        this.userImg = userImg;
        this.goodImg = goodImg;
        this.goodLabel = goodLabel;
    }

    public ProgramAdapter(Context context, String[] username, String[] desc, String[] location, String[] goodLabel){
        this.context = context;
        this.username = username;
        this.description=desc;
        this.location = location;
        this.goodLabel = goodLabel;
    }


}
