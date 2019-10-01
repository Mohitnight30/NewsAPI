package com.example.newsreader;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerAdapter extends
        RecyclerView.Adapter<RecyclerAdapter.NewsViewHolder> {

    Context context;
    ArrayList<NewsModel> newsModelArrayList;

    public RecyclerAdapter(Context context, ArrayList<NewsModel> newsModelArrayList) {
        this.context = context;
        this.newsModelArrayList = newsModelArrayList;
    }


    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());

        View itemView = layoutInflater.inflate(R.layout.news_item_layout, viewGroup, false);

        NewsViewHolder newsViewHolder = new NewsViewHolder(itemView);

        return newsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder newsViewHolder, int i) {

        NewsModel newsModel = newsModelArrayList.get(i);

        newsViewHolder.newsTitle.setText(String.valueOf(newsModel.getNewsTitle()));
        newsViewHolder.newsDescription.setText(String.valueOf(newsModel.getNewsDescription()));
        newsViewHolder.newsDate.setText(String.valueOf(newsModel.getNewsDate()));
        Glide.with(context).load(newsModel.getNewsImageUrl()).into(newsViewHolder.newsImageViews);
    }

    @Override
    public int getItemCount() {
        return newsModelArrayList.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {

        public ImageView newsImageViews;
        public TextView newsTitle, newsDescription, newsDate;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);

            newsTitle = itemView.findViewById(R.id.news_title);
            newsDescription = itemView.findViewById(R.id.news_description);
            newsDate = itemView.findViewById(R.id.news_date);
            newsImageViews = itemView.findViewById(R.id.news_image_view);
        }
    }
}
