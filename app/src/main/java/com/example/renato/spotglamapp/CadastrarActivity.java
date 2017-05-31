package com.example.renato.spotglamapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CadastrarActivity extends AppCompatActivity {

    private EditText nome;
    private EditText login;
    private EditText senha;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        nome = (EditText) findViewById(R.id.nome);
        login = (EditText) findViewById(R.id.emailCadastro);
        senha = (EditText) findViewById(R.id.senhaCadastro);
        auth = FirebaseAuth.getInstance();

 }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void clickLoginCadastrar(View v) {
        String email = login.getText().toString().trim();
        String password = senha.getText().toString().trim();

        if (email.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.length() < 6) {
            Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
            return;
        }

        //create user
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(CadastrarActivity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    Toast.makeText(CadastrarActivity.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();

                    // If sign in fails, display a message to the user. If sign in succeeds
                    // the auth state listener will be notified and logic to handle the
                    // signed in user can be handled in the listener.
                    if (!task.isSuccessful()) {
                        Toast.makeText(CadastrarActivity.this, "Authentication failed." + task.getException(),
                                Toast.LENGTH_SHORT).show();
                    } else {
                        startActivity(new Intent(CadastrarActivity.this, MenuLateralActivity.class));
                        finish();
                    }
                }
            });
    }

}
