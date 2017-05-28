package com.example.renato.spotglamapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LoginActivity extends AppCompatActivity {

    private EditText login;
    private EditText senha;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = (EditText) findViewById(R.id.emailLogin);
        senha = (EditText) findViewById(R.id.senhaLogin);
        auth = FirebaseAuth.getInstance();

        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(LoginActivity.this, MenuLateralActivity.class));
            finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void ClickLoginFacebook(View view) {
    }

    public void clickLoginEntrar(View view) {

        String email = login.getText().toString();
        final String password = senha.getText().toString();

//        String email = login.getText().toString().trim();
//        String password = senha.getText().toString().trim();

        System.out.print("EMAIL: " + email);
        System.out.print("SENHA: " + password);

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

        //authenticate user
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    // If sign in fails, display a message to the user. If sign in succeeds
                    // the auth state listener will be notified and logic to handle the
                    // signed in user can be handled in the listener.

                    if (!task.isSuccessful()) {
                        // there was an error
                        if (password.length() < 6) {
                            senha.setError("Tem que ter 6 caracteres no minimo");
                        } else {
                            Toast.makeText(LoginActivity.this, "Algo deu errado", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Intent intent = new Intent(LoginActivity.this, MenuLateralActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            });

    }

}
