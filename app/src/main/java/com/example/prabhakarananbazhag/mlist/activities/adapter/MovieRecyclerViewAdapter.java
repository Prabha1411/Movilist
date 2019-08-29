package com.example.prabhakarananbazhag.mlist.activities.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.prabhakarananbazhag.mlist.R;
import com.example.prabhakarananbazhag.mlist.activities.activities.MovieDetailActivity;
import com.example.prabhakarananbazhag.mlist.activities.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieRecyclerViewAdapter extends RecyclerView.Adapter<MovieRecyclerViewAdapter.ViewHolder> {
    public List<Movie> movies;
    public Context context;

    public MovieRecyclerViewAdapter(Context context, List<Movie> movies) {
        this.movies = movies;
        this.context = context;

    }

    private Context getContext() {
        return context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Movie movie = movies.get(position);
        holder.tvTitle.setText(movie.getTitle());
        holder.tvoview.setText(movie.getOverview());
        Picasso.with(getContext()).load(movie.getPosterPath())
                .resize(300, 300)
                .into(holder.ivmovie);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.ivmovie)
        ImageView ivmovie;
        @BindView(R.id.tvTitle)
        TextView tvTitle;
        @BindView(R.id.tvoview)
        TextView tvoview;
        @BindView(R.id.cvMovies)
        CardView cvMovies;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            Movie movie = movies.get(getAdapterPosition());

            Intent intent = new Intent(getContext(), MovieDetailActivity.class);
            Bundle b = new Bundle();
            b.putSerializable("Movie1", movie);
            //intent.putExtra("MOVIE", movie);
            intent.putExtras(b);
            getContext().startActivity(intent);

        }
    }
}
