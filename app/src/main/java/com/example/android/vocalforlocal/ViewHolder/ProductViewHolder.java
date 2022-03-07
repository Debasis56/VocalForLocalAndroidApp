package com.example.android.vocalforlocal.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.vocalforlocal.Interface.itemClickListener;
import com.example.android.vocalforlocal.R;

public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


    public TextView textProductName, textProductDescription, textProductPrice;
    public ImageView imageView;
    public itemClickListener listener;


    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = (ImageView) itemView.findViewById(R.id.product_image);
        textProductName = (TextView) itemView.findViewById(R.id.product_name);
        textProductDescription = (TextView) itemView.findViewById(R.id.product_description);
        textProductPrice = (TextView) itemView.findViewById(R.id.product_price);
    }
    public void setItemClickListener(itemClickListener listener) {
        this.listener = listener;

    }

    @Override
    public void onClick(View v) {
        listener.onClick(v, getAdapterPosition(),false);

    }
}
