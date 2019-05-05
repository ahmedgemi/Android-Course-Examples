package com.ahmed.movieapp.presenter;

import com.ahmed.movieapp.MovieApp;
import com.ahmed.movieapp.contract.MovieContract;
import com.ahmed.movieapp.data.MovieResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

public class MoviePresenter implements Response.Listener<String>, Response.ErrorListener {

    private MovieContract contract;

    public MoviePresenter(MovieContract contract) {
        this.contract = contract;
    }

    public void getMovies(){

        contract.showLoader();

        String url = "https://api.themoviedb.org/3/movie/now_playing?api_key=31521ab741626851b73c684539c33b5a";
        RequestQueue queue = Volley.newRequestQueue(MovieApp.getInstance().getApplicationContext());
        StringRequest request = new StringRequest(Request.Method.GET,url,this, this);
        queue.add(request);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        contract.hideLoader();
        contract.showMessage("Check internet connection");

        // you can fetch data from database and pass it to view
        // List<Movie> list = get data from database
        // contract.hideLoader();
        // contract.onReceiveMovies(list);
    }

    @Override
    public void onResponse(String response) {

        Gson gson = new Gson();
        MovieResponse apiResponse = gson.fromJson(response,MovieResponse.class);

        contract.hideLoader();
        contract.onReceiveMovieList(apiResponse.getMovieList());
    }
}
