package com.ahmed.movieapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.ahmed.movieapp.data.Movie;
import com.ahmed.movieapp.adapter.MovieListAdapter;
import com.ahmed.movieapp.data.MovieResponse;
import com.ahmed.movieapp.R;
import com.ahmed.movieapp.contract.MovieContract;
import com.ahmed.movieapp.presenter.MoviePresenter;
import com.android.volley.VolleyError;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MovieContract{

    RecyclerView recyclerView;
    MovieListAdapter adapter;
    ProgressBar progressBar;

    MoviePresenter moviePresenter = new MoviePresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        progressBar = findViewById(R.id.progressBar);


        moviePresenter.getMovies();

    }

    @Override
    public void showLoader() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoader() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onReceiveMovieList(List<Movie> list) {
        adapter = new MovieListAdapter(this,list);
        recyclerView.setAdapter(adapter);
    }
}
