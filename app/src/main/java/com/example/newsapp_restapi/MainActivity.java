package com.example.newsapp_restapi;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp_restapi.Adapter.CustomAdapter;
import com.example.newsapp_restapi.Api.OnFetchDataListener;
import com.example.newsapp_restapi.Api.RequestManager;
import com.example.newsapp_restapi.Models.NewsApiResponse;
import com.example.newsapp_restapi.Models.NewsHeadline;

import java.util.List;


/*
تطبيق الاخبار معتمد على api
من موقع مخصص للاخبار
https://newsapi.org/
 */
public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CustomAdapter adapter;
    ProgressDialog dialog;
    RequestManager requestManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //.......

        dialog = new ProgressDialog(this);
        dialog.setTitle("Loding..");
        dialog.show();
        requestManager = new RequestManager(this);
        requestManager.getNewsHeadlines(listener, "general", null);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_category, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.business:
                requestManager.getNewsHeadlines(listener, "business", null);
                break;
            case R.id.entertainment:
                requestManager.getNewsHeadlines(listener, "entertainment", null);
                break;
            case R.id.general:
                requestManager.getNewsHeadlines(listener, "general", null);
                break;
            case R.id.health:
                requestManager.getNewsHeadlines(listener, "health", null);
                break;
            case R.id.science:
                requestManager.getNewsHeadlines(listener, "science", null);
                break;
            case R.id.sports:
                requestManager.getNewsHeadlines(listener, "sports", null);
                break;
            case R.id.technology:
                requestManager.getNewsHeadlines(listener, "technology", null);
                break;
        }
        return true;
    }

    private final OnFetchDataListener<NewsApiResponse> listener = new OnFetchDataListener<NewsApiResponse>() {
        @Override
        public void onFetchData(List<NewsHeadline> list, String message) {
            showNews(list);
            dialog.dismiss();
        }

        @Override
        public void onError(String message) {

        }
    };

    private void showNews(List<NewsHeadline> list) {
        recyclerView = findViewById(R.id.recycler_news);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        adapter = new CustomAdapter(this, list);
        recyclerView.setAdapter(adapter);
    }
}