package com.example.newsapp_restapi.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newsapp_restapi.DitalseActivity;
import com.example.newsapp_restapi.Models.NewsHeadline;
import com.example.newsapp_restapi.R;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomHolder> {

    private Activity activity;
    private List<NewsHeadline> headlines;

    public CustomAdapter(Activity activity, List<NewsHeadline> headlines) {
        this.activity = activity;
        this.headlines = headlines;
    }

    @NonNull
    @Override

    public CustomHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomHolder(LayoutInflater.from(activity).inflate(R.layout.headline_list_itemss, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomHolder holder, int position) {
        holder.text_title.setText(headlines.get(position).getTitle());
        holder.text_source.setText(headlines.get(position).getSource().getName());
        if (headlines.get(position).getUrlToImage() != null) {
            Glide.with(activity).load(headlines.get(position).getUrlToImage())
                    .error(R.drawable.image_ai)
                    .into(holder.img_headline);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(activity, DitalseActivity.class);
                    i.putExtra("title", headlines.get(position).getTitle());
                    i.putExtra("aouther", headlines.get(position).getAuthor());
                    i.putExtra("image", headlines.get(position).getUrlToImage());
                    i.putExtra("desc", headlines.get(position).getDescription());
                    i.putExtra("time", headlines.get(position).getPublishedAt());
                    i.putExtra("go", headlines.get(position).getUrl());
                    activity.startActivity(i);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return headlines.size();
    }
}
