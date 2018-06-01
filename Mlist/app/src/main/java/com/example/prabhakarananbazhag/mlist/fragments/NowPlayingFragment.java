package com.example.prabhakarananbazhag.mlist.fragments;


import android.graphics.Movie;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.prabhakarananbazhag.mlist.R;
import com.example.prabhakarananbazhag.mlist.adapters.MovieRecyclerViewAdapter;
import com.example.prabhakarananbazhag.mlist.models.Movies;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class NowPlayingFragment extends Fragment {
private List<Movies> movies;
    @BindView(R.id.rvmoview)
    RecyclerView rvmoview;


    public NowPlayingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_now_playing, container, false);
        ButterKnife.bind(this, view);

        initializeData();
        LinearLayoutManager llm = new LinearLayoutManager(this.getContext());
        rvmoview.setHasFixedSize(true);
        rvmoview.setLayoutManager(llm);

        MovieRecyclerViewAdapter adapter = new MovieRecyclerViewAdapter(getContext(), movies);
        rvmoview.setAdapter(adapter);

        return view;
    }

    private void initializeData() {
        movies=new ArrayList<>();
        movies.add(new Movies("5","title","xsxcsdakcjhd",3.3f,4.4f,"232","232"));
        movies.add(new Movies("6","title","xsxcsdakcjhd",3.3f,4.4f,"232","232"));

    }

}
