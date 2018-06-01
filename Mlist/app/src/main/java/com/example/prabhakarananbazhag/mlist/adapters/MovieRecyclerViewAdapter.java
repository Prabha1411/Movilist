package com.example.prabhakarananbazhag.mlist.adapters;

import android.content.Context;
import android.graphics.Movie;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.example.prabhakarananbazhag.mlist.R;
import com.example.prabhakarananbazhag.mlist.models.Movies;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieRecyclerViewAdapter extends RecyclerView.Adapter<MovieRecyclerViewAdapter.ViewHolder> {
    Context context;
    List<Movies> movies;
    public MovieRecyclerViewAdapter(Context context, List<Movies> movies){
        this.movies=movies;

        this.context=context;

    }
    public Context getContext(){
       return context;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
  Movies movie=movies.get(position);
  holder.tvTitle.setText(movie.getTitle());
  holder.tvoview.setText(movie.getOverview());
        Picasso.with(getContext())
                .load(movie.getPosterPath())
                .into(holder.ivmovie);

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.ivmovie)ImageView  ivmovie;
        @BindView(R.id.tvTitle)TextView tvTitle;
        @BindView(R.id.tvoview)TextView tvoview;
        @BindView(R.id.cvmovie)CardView cvmovie;
         ViewHolder(View view){
             super(view);
             ButterKnife.bind(this,view);
         }


    }
}
