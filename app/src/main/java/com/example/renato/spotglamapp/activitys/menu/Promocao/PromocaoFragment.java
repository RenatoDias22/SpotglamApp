package com.example.renato.spotglamapp.activitys.menu.Promocao;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.renato.spotglamapp.R;



public class PromocaoFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_promocao, container, false);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
