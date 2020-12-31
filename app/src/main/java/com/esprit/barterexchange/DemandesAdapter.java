package com.esprit.barterexchange;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DemandesAdapter extends RecyclerView.Adapter<DemandesAdapter.ViewHolder> {

    Context context;
    String[] otherGoods, myGoods;
    int[] otherGoodsImages;

    public DemandesAdapter(Context context, String[] otherGoods, String[] myGoods, int[] otherGoodsImages){
        this.context = context;
        this.otherGoods = otherGoods;
        this.myGoods = otherGoods;
        this.otherGoodsImages = otherGoodsImages;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView otherGood, myGood;
        ImageView otherGoodImage;

        public ViewHolder(View itemView){
            super(itemView);
            otherGood = itemView.findViewById(R.id.other_good);
            myGood = itemView.findViewById(R.id.my_good);
            otherGoodImage = itemView.findViewById(R.id.other_good_image);

        }

    }

    @NonNull
    @Override
    public DemandesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.demandes_card, parent, false);
        DemandesAdapter.ViewHolder viewHolder = new DemandesAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DemandesAdapter.ViewHolder holder, int position) {

        holder.myGood.setText(myGoods[position]);
        holder.otherGood.setText(otherGoods[position]);
        holder.otherGoodImage.setImageResource(otherGoodsImages[position]);

    }

    @Override
    public int getItemCount() {
        return myGoods.length;
    }
}
