package com.example.renato.spotglamapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class LoginActivity extends AppCompatActivity {

    private EditText login;
    private EditText senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = (EditText) findViewById(R.id.emailLogin);
        senha = (EditText) findViewById(R.id.senhaLogin);
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
