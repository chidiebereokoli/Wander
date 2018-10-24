package com.example.chidi.wander;
//The MapsActivity.java file instantiates the SupportMapFragment class and uses the class's
// getMapAsync() method to prepare the Google Map
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * steps:
 * 1) Get an API key, that will be placed in the google maps api xml file.
 * 2) We extend appCompatActivity, because we want to show the app bar, and then the menu
 * 3)The onMapReadyCallback includes the code that places the marker at the desired location.
 * 4) Then, we also pass in the Long and Lat values of our location, and using the moveCamera method, and the addMarker method
 * of the GoogleMap object, we can zoom and mark a particular location.
 */

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {
//We extend appCompatActivity, because we want to show the app bar, and then the menu
    private GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        //getMapAsync() method is used to prepare the Google Map
        //getMapAsync() method returns a googleMap object, signifying that a map has been loaded.
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.map_options, menu);
        return true;
    }

    //It is here that the marker is placed in Sydney, Australia, and it is from here that the camera is moved.
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(-34, 151);

        float zoom = 5; //other zoom levels; streets-15, buildings -20, world - 1

       // mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney")); //For Sidney, Australia

      //  mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));//For Sidney, Australia
        LatLng home = new LatLng(41.9041716,-88.3380184);
        mMap.addMarker(new MarkerOptions().position(home).title("Marker at Home"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(home, zoom));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Change the map type based on the user's selection.
        // the setmaptype function, which accepts a GoogleMap object as argument(Map type constants)
        switch (item.getItemId()) {
            case R.id.normal_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                return true;
            case R.id.hybrid_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                return true;
            case R.id.satellite_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                return true;
            case R.id.terrain_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
