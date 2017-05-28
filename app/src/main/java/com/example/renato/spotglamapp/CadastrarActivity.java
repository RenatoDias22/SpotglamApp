package com.example.renato.spotglamapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class CadastrarActivity extends AppCompatActivity {

    private EditText nome;
    private EditText email;
    private EditText senha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        nome = (EditText) findViewById(R.id.nome);
        email = (EditText) findViewById(R.id.emailCadastro);
        senha = (EditText) findViewById(R.id.senhaCadastro);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
