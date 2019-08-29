package com.example.prabhakarananbazhag.mlist.activities.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.prabhakarananbazhag.mlist.R;
import com.example.prabhakarananbazhag.mlist.activities.adapter.MovieRecyclerViewAdapter;
import com.example.prabhakarananbazhag.mlist.activities.models.Movie;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class NowPlayingFragment extends Fragment {


    @BindView(R.id.rvMovies)
    RecyclerView recyclerviewmovie;
    public List<Movie> movies;

    public NowPlayingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_now_playing, container, false);
        ButterKnife.bind(this, view);
        initializeData();
        LinearLayoutManager llm = new LinearLayoutManager(this.getContext());

        recyclerviewmovie.setHasFixedSize(true);
        recyclerviewmovie.setLayoutManager(llm);

        MovieRecyclerViewAdapter adapter = new MovieRecyclerViewAdapter(getContext(), movies);
        recyclerviewmovie.setAdapter(adapter);


        return view;
    }

    private void initializeData() {
        movies = new ArrayList<>();
        movies.add(new Movie("277834", "Moana", "In Ancient Polynesia, when a terrible curse incurred by Maui reaches an impetuous Chieftain's daughter's island, she answers the Ocean's call to seek out the demigod to set things right.", 6.5f, 854, "https://i.ytimg.com/vi/Ljik3zsGNF4/maxresdefault.jpg", "https://i.ytimg.com/vi/Ljik3zsGNF4/maxresdefault.jpg"));
        movies.add(new Movie("121856", "Passengers", "A spacecraft traveling to a distant colony planet and transporting thousands of people has a malfunction in its sleep chambers. As a result, two passengers are awakened 90 years early.", 6.2f, 745, "https://pbs.twimg.com/profile_images/834102207356116993/Z0dFwGnF_400x400.jpg", "https://pbs.twimg.com/profile_images/834102207356116993/Z0dFwGnF_400x400.jpg"));
        movies.add(new Movie("330459", "Assassin's Creed", "Lynch discovers he is a descendant of the secret Assassins society through unlocked genetic memories that allow him to relive the adventures of his ancestor, Aguilar, in 15th Century Spain. After gaining incredible knowledge and skills he’s poised to take on the oppressive Knights Templar in the present day.", 5.3f, 691, "http://www.mineralblu.com/wp-content/uploads/2016/10/assassin_s_creed_movie_flipped_poster_by_maximumsohan-da2byc0-334x494.jpg", "http://www.mineralblu.com/wp-content/uploads/2016/10/assassin_s_creed_movie_flipped_poster_by_maximumsohan-da2byc0-334x494.jpg"));
        movies.add(new Movie("283366", "Rogue One: A StarWars Story", "A rogue band of resistance fighters unite for a mission to steal the Death Star plans and bring a new hope to the galaxy.", 7.2f, 1802, "https://images.penguinrandomhouse.com/cover/9780399178474", "https://images.penguinrandomhouse.com/cover/9780399178474"));
        movies.add(new Movie("313369", "La La Land", "Mia, an aspiring actress, serves lattes to movie stars in between auditions and Sebastian, a jazz musician, scrapes by playing cocktail party gigs in dingy bars, but as success mounts they are faced with decisions that begin to fray the fragile fabric of their love affair, and the dreams they worked so hard to maintain in each other threaten to rip them apart.", 8, 396, "https://i.ytimg.com/vi/unhAKWQgWGI/movieposter.jpg", "https://i.ytimg.com/vi/unhAKWQgWGI/movieposter.jpg"));

    }
}


