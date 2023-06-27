package com.example.newsapp_restapi.Api;

import com.example.newsapp_restapi.Models.NewsHeadline;

import java.util.List;

public interface OnFetchDataListener<NewsApiResponse> {
    void onFetchData(List<NewsHeadline> list, String message);

    void onError(String message);

}
