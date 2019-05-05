package com.ahmed.movieapp.contract;

import com.ahmed.movieapp.data.Movie;

import java.util.List;

public interface MovieContract {

    void showLoader();
    void hideLoader();
    void showMessage(String msg);

    void onReceiveMovieList(List<Movie> list);
}
