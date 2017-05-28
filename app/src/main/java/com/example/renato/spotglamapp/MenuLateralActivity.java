package com.example.renato.spotglamapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.renato.spotglamapp.activitys.menu.Ajuda.AjudaFragment;
import com.example.renato.spotglamapp.activitys.menu.Conta.ContaFragment;
import com.example.renato.spotglamapp.activitys.menu.Contato.ContatoFragment;
import com.example.renato.spotglamapp.activitys.menu.Mapa.MapsActivity;
import com.example.renato.spotglamapp.activitys.menu.Pecas.PecasFragment;
import com.example.renato.spotglamapp.activitys.menu.Promocao.PromocaoFragment;
import com.example.renato.spotglamapp.activitys.menu.Sobre.SobreFragment;
import com.example.renato.spotglamapp.activitys.menu.Updates.UpdatesFragment;

public class MenuLateralActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_lateral);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FragmentManager fragmantManager = getSupportFragmentManager();
        fragmantManager.beginTransaction().replace(R.id.contenedor, new MapsActivity()).commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lateral, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        FragmentManager fragmantManager = getSupportFragmentManager();
        int id = item.getItemId();


        if (id == R.id.menu_map) {
            fragmantManager.beginTransaction().replace(R.id.contenedor, new MapsActivity()).commit();
//            Intent intent = new Intent(this, MapsActivity.class);
//            startActivity(intent);
        }else if (id == R.id.pecas) {
            fragmantManager.beginTransaction().replace(R.id.contenedor, new PecasFragment()).commit();
        } else if (id == R.id.promocoes) {
            fragmantManager.beginTransaction().replace(R.id.contenedor, new PromocaoFragment()).commit();
        } else if (id == R.id.updates) {
            fragmantManager.beginTransaction().replace(R.id.contenedor, new UpdatesFragment()).commit();
        } else if (id == R.id.sobre) {
            fragmantManager.beginTransaction().replace(R.id.contenedor, new SobreFragment()).commit();
        } else if (id == R.id.contato) {
            fragmantManager.beginTransaction().replace(R.id.contenedor, new ContatoFragment()).commit();
        } else if (id == R.id.ajuda) {
            fragmantManager.beginTransaction().replace(R.id.contenedor, new AjudaFragment()).commit();
        } else if (id == R.id.conta) {
            fragmantManager.beginTransaction().replace(R.id.contenedor, new ContaFragment()).commit();
        } else if (id == R.id.sair) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
