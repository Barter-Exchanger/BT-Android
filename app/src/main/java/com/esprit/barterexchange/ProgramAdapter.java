package com.esprit.barterexchange;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.esprit.barterexchange.Entities.CurrentUser;
import com.esprit.barterexchange.Entities.Goods;
import com.esprit.barterexchange.Entities.User;
import com.esprit.barterexchange.Services.ExchangeServices;
import com.esprit.barterexchange.Services.GoodsServices;
import com.esprit.barterexchange.Services.UserServices;

import java.util.List;

public class ProgramAdapter extends RecyclerView.Adapter<ProgramAdapter.ViewHolder> {

    Context context;

    String[] goodLabel, description, location, username;
    int[] userImg, goodImg, goodId;

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

        holder.req.setOnClickListener(v ->{
            System.out.println("i'm clicked : "+goodId[position]);
            AlertDialog.Builder mBuild = new AlertDialog.Builder(v.getContext());
            View mView = LayoutInflater.from(v.getContext()).inflate(R.layout.exchange_demande, null);

            Button sendReq = mView.findViewById(R.id.send_req);
            Spinner spinner = mView.findViewById(R.id.other_good);
            GoodsServices goodsServices = new GoodsServices();
            List<Goods> goodsList = goodsServices.getGoodsByUserId(CurrentUser.getId());
            ArrayAdapter<Goods> goodsArrayAdapter = new ArrayAdapter<>(mView.getContext(), android.R.layout.simple_spinner_item, goodsList);
            goodsArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinner.setAdapter(goodsArrayAdapter);

            sendReq.setOnClickListener(view -> {
                ExchangeServices exchangeServices = new ExchangeServices();
                UserServices userServices = new UserServices();
                Goods user2Good = goodsServices.getGoodById(goodId[position]);

                exchangeServices.addExchange((Goods) spinner.getSelectedItem(), user2Good,
                        new User(CurrentUser.getId(), CurrentUser.getFirstName(), CurrentUser.getLastName(), CurrentUser.getUsername(), CurrentUser.getEmail(),
                                CurrentUser.getPassword())
                        ,userServices.getUserById(user2Good.getUser()) );
            });

            mBuild.setView(mView);
            AlertDialog dialog = mBuild.create();
            dialog.show();

        });

    }

    @Override
    public int getItemCount() {
        return username.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView goodLabel, description, location, username;
        ImageView userImg, goodImg;
        RelativeLayout layout;
        Button req ;


        public ViewHolder(View itemView){
            super(itemView);
            username = itemView.findViewById(R.id.UserNamme);
            location = itemView.findViewById(R.id.location);
            description = itemView.findViewById(R.id.description);
            goodLabel = itemView.findViewById(R.id.label);
            userImg = itemView.findViewById(R.id.UserImage);
            goodImg = itemView.findViewById(R.id.good_image);
            layout = itemView.findViewById(R.id.container);
            req = itemView.findViewById(R.id.request);

        }

    }

    public ProgramAdapter(Context context, String[] username, String[] desc, String[] location,String[] goodLabel,  int[] goodImg, int[] userImg, int[] goodId){
        this.context = context;
        this.username = username;
        this.description=desc;
        this.location = location;
        this.userImg = userImg;
        this.goodImg = goodImg;
        this.goodLabel = goodLabel;
        this.goodId = goodId;
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
