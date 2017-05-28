package com.example.renato.spotglamapp.activitys.menu.Mapa;

import android.Manifest;
import android.content.SyncStatusObserver;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.renato.spotglamapp.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import android.support.v4.app.FragmentManager;

import java.lang.reflect.Array;
import java.util.ArrayList;


class Ponto {
    private LatLng latLng;
    private String titulo;

    public Ponto(LatLng latLng, String titulo) {
        this.latLng = latLng;
        this.titulo = titulo;
    }
    LatLng getLatLng(){
        return this.latLng;
    }
    String getTitulo(){
        return this.titulo;
    }
}
public class MapsActivity extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    private SupportMapFragment supportMapFragment;
    private int typeMap;
    private View rootView;


    private ArrayList<Ponto> pontos = new ArrayList<Ponto>();
    private LocationManager locationManager;
    private LocationListener listener;
    private double latitude;
    private double longitude;

    public static MapsActivity newInstance(int typeMap) {
        MapsActivity fragment = new MapsActivity();
        Bundle args = new Bundle();
        args.putInt("typeMap", typeMap);
        fragment.setArguments(args);
        return fragment;
    }

    public MapsActivity() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            typeMap = getArguments().getInt("typeMap"); //Recupera o tipo de mapa passado por parâmetro
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        supportMapFragment = SupportMapFragment.newInstance();
        rootView = inflater.inflate(R.layout.activity_maps, null);
        FragmentManager fragmentManager = getFragmentManager();

        LocationManager lm = (LocationManager) getActivity().getSystemService(getContext().LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return rootView;
        }
//        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, (android.location.LocationListener) this);

        if (fragmentManager != null) {
            fragmentManager.beginTransaction().replace(R.id.map, supportMapFragment).commitAllowingStateLoss();
        }
        supportMapFragment.getMapAsync(this);

        return rootView;
    }

    private void addPontos() {
        pontos.add(new Ponto(new LatLng(-3.7688874, -38.4816098), "UNIFOR"));
        pontos.add(new Ponto(new LatLng(-3.7213003, -38.5202098), "Dragão do Mar"));
        pontos.add(new Ponto(new LatLng(-3.755851, -38.4889458), "Iguatemi"));
        pontos.add(new Ponto(new LatLng(-3.7192433, -38.516688), "Ponte dos Ingleses"));
        pontos.add(new Ponto(new LatLng(-3.8072834, -38.5224331), "Castelão"));
        pontos.add(new Ponto(new LatLng(-3.8641382,-38.5062965), "Trem da Alegria"));
        pontos.add(new Ponto(new LatLng(-3.8438588,-38.3904518), "Beach Park"));
        pontos.add(new Ponto(new LatLng(-3.722848,-38.5251113), "Fortaleza de Nossa Sra. da Assunção"));
        pontos.add(new Ponto(new LatLng(-3.7523768,-38.5264899), "Santuário Nossa Senhora de Fátima"));
        pontos.add(new Ponto(new LatLng(-3.8361877,-38.5546062), "Black Gate"));
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        addPontos();
        LatLng fortaleza = new LatLng(-3.7282066, -38.5361633);

        googleMap.addMarker(new MarkerOptions().position(fortaleza)
                .title("Fortaleza"));

        for (Ponto ponto: pontos) {
            googleMap.addMarker(new MarkerOptions().position(ponto.getLatLng())
                    .title(ponto.getTitulo()));
        }
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(10);

        googleMap.moveCamera(CameraUpdateFactory.newLatLng(fortaleza));
        googleMap.animateCamera(zoom);

    }

//    @Override
//    public void onLocationChanged(Location location) {
////        latitude = location.getLatitude();
////        longitude = location.getLongitude();
////        System.out.println("onLocationChanged");
////        System.out.println(latitude);
////        System.out.println(longitude);
//    }
//
//    @Override
//    public void onStatusChanged(String provider, int status, Bundle extras) {
//
//    }
//
//    @Override
//    public void onProviderEnabled(String provider) {
//
//    }
//
//    @Override
//    public void onProviderDisabled(String provider) {
//
//    }
}
