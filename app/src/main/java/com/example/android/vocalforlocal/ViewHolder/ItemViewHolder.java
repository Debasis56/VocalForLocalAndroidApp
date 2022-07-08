package com.example.android.vocalforlocal.ViewHolder;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.vocalforlocal.Interface.itemClickListener;
import com.example.android.vocalforlocal.R;

public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


    public TextView textProductName, textProductDescription, textProductPrice, txtProductStatus;
    public ImageView imageView;
    public itemClickListener listener;


    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = (ImageView) itemView.findViewById(R.id.product_seller_image);
        textProductName = (TextView) itemView.findViewById(R.id.product_seller_name);
        textProductDescription = (TextView) itemView.findViewById(R.id.product_seller_description);
        textProductPrice = (TextView) itemView.findViewById(R.id.product_seller_price);
        txtProductStatus = (TextView) itemView.findViewById(R.id.seller_product_status);
    }
    public void setItemClickListener(itemClickListener listener) {
        this.listener = listener;

    }

    @Override
    public void onClick(View v) {
        listener.onClick(v, getAdapterPosition(),false);

    }
}

