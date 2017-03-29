package com.example.renato.spotglamapp.activitys.menu.Mapa;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.renato.spotglamapp.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    private SupportMapFragment supportMapFragment;
    private int typeMap;
    private View rootView;

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
        if (fragmentManager != null) {
            fragmentManager.beginTransaction().replace(R.id.map, supportMapFragment).commitAllowingStateLoss();
        }
        supportMapFragment.getMapAsync(this);
        return rootView;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
//        switch (typeMap) {
//            case MainActivity.TYPE_MAP_BASIC:
//                configBasicMap(googleMap);
//                break;
//            case MainActivity.TYPE_MAP_CUSTOM_MARKER:
//                configCustomMarkerMap(googleMap);
//                break;
//        }
    }

    private void configBasicMap(GoogleMap googleMap) {
        LatLng sydney = new LatLng(-33.867, 151.206); //Cria uma coordenada de ponto para o mapa
        //Configura o zoom da camera do mapa
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 13));

        /**
         * Adiciona um pino na posição da coordenada.
         * Ao clicar em cima do pino exibirá o título Sidney e a descrição que está no snippet
         */
        googleMap.addMarker(new MarkerOptions()
                .title("Sydney")
                .snippet("Cidade mais populosa da Austrália.")
                .position(sydney));
    }

    private void configCustomMarkerMap(GoogleMap googleMap) {
        LatLng sydney = new LatLng(-33.867, 151.206);
        //Exibi o botão de localizar a localização do usuário
//        googleMap.setMyLocationEnabled(true);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 10));
        MarkerOptions markerOptions = new MarkerOptions();
        /**
         * O arquivo de imagem pin48.png deve estar presente dentro da pasta mipmap-mdpi
         * Caso esteja usando uma versão mais antiga do Android Studio e do SDK,
         * você pode ter somente as pastas drawable. Nesse caso, cole dentro de drawable-mdpi
         * e altere a linha markerOptions.icon(BitmapDescriptorFactory.fromResource(R.mipmap.pin48))
         * para markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.pin48))
         */
        markerOptions.icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher_round))
                .anchor(0.0f, 1.0f) //Posiciona o pino um pouco mais pra cima
                .position(sydney)
                .title("Sydney");
        googleMap.addMarker(markerOptions);
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.activity_maps, container, false);
//    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_maps);
//        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
//    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        mMap = googleMap;
//
//        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
//    }
}
