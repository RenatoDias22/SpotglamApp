package com.example.renato.spotglamapp.activitys.menu.Pecas;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.renato.spotglamapp.R;

public class PecasFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pecas, container, false);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
