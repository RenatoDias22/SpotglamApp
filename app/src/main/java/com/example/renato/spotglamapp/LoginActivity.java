package com.example.renato.spotglamapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void ClickLoginFacebook(View view) {
    }

    public void clickLoginEntrar(View view) {
        Intent intent = new Intent(this, MenuLateralActivity.class);
        startActivity(intent);
    }
}
