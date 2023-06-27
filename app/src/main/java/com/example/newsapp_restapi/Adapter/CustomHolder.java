package com.example.newsapp_restapi.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp_restapi.R;

public class CustomHolder extends RecyclerView.ViewHolder {

    TextView text_title, text_source;
    ImageView img_headline;
    CardView cardView;

    public CustomHolder(@NonNull View itemView) {
        super(itemView);
        text_title = itemView.findViewById(R.id.tv_name);
        text_source = itemView.findViewById(R.id.tv_source);
        img_headline = itemView.findViewById(R.id.image_News_detailse);
        cardView = itemView.findViewById(R.id.card_news);
    }

}
