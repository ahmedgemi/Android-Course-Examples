package com.ahmed.resturantwithmap;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapLoadedCallback, OnResturantClick {

    RecyclerView recyclerView;
    ArrayList<Resurant> list = new ArrayList<>();
    ListAdapter adapter;

    MapView mapView;
    GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list.add( new Resurant("KFC","https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fimages.hellogiggles.com%2Fuploads%2F2018%2F06%2F05101847%2Fkfc-vegetarian-fried-chicken-e1528219155826.jpg&w=450&c=sc&poi=face&q=85",new LatLng(29.984636, 31.233727)));
        list.add( new Resurant("Macdonald's","https://upload.wikimedia.org/wikipedia/commons/thumb/3/36/McDonald%27s_Golden_Arches.svg/1200px-McDonald%27s_Golden_Arches.svg.png",new LatLng(29.984636, 31.134727)));
        list.add( new Resurant("Semsema","https://upload.wikimedia.org/wikipedia/commons/thumb/3/36/McDonald%27s_Golden_Arches.svg/1200px-McDonald%27s_Golden_Arches.svg.png",new LatLng(29.996636, 31.431727)));
        list.add( new Resurant("Mac","https://upload.wikimedia.org/wikipedia/commons/thumb/3/36/McDonald%27s_Golden_Arches.svg/1200px-McDonald%27s_Golden_Arches.svg.png",new LatLng(29.984636, 31.243727)));
        list.add( new Resurant("Macdonald's","https://upload.wikimedia.org/wikipedia/commons/thumb/3/36/McDonald%27s_Golden_Arches.svg/1200px-McDonald%27s_Golden_Arches.svg.png",new LatLng(29.994636, 31.336727)));
        list.add( new Resurant("ABC","https://upload.wikimedia.org/wikipedia/commons/thumb/3/36/McDonald%27s_Golden_Arches.svg/1200px-McDonald%27s_Golden_Arches.svg.png",new LatLng(29.99936, 31.423727)));

        adapter = new ListAdapter(this,list,this);
        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();

        mapView.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        this.googleMap = googleMap;
        googleMap.setOnMapLoadedCallback(this);
    }

    @Override
    public void onMapLoaded() {

        LatLngBounds.Builder builder = new LatLngBounds.Builder();

        for (Resurant resurant : list){

            MarkerOptions options = new MarkerOptions()
                    .position(resurant.getLocation())
                    .title(resurant.getName());

            googleMap.addMarker(options);

            builder.include(resurant.getLocation());

        }

        googleMap.animateCamera(CameraUpdateFactory.newLatLngBounds(builder.build(),20));

    }

    @Override
    public void onResurantClick(Resurant resurant) {

        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(resurant.getLocation(),15));
    }
}
