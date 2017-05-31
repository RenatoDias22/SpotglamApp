package com.example.renato.spotglamapp.activitys.menu.Conta;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.renato.spotglamapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ContaFragment extends Fragment {
    Button buttonEditarSenha;
    private EditText novaSenha;
    private EditText confirmarSenha;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_conta, container, false);
        buttonEditarSenha = (Button) view.findViewById(R.id.confirmarButton);

        novaSenha = (EditText) view.findViewById(R.id.novaSenha);
        confirmarSenha = (EditText) view.findViewById(R.id.confirmarNovaSenha);

        buttonEditarSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                final String nova_senha = novaSenha.getText().toString();
                final String confirmar_senha = confirmarSenha.getText().toString();

                if (nova_senha.isEmpty()) {
                    Toast.makeText(getActivity().getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (confirmar_senha.isEmpty()) {
                    Toast.makeText(getActivity().getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (confirmar_senha.length() < 6 || nova_senha.length() > 6) {
                    Toast.makeText(getActivity().getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (confirmar_senha.compareTo(nova_senha)!=0) {
                    Toast.makeText(getActivity().getApplicationContext(), "Password erro", Toast.LENGTH_SHORT).show();
                    return;
                }
                user.updatePassword(novaSenha.getText().toString().trim())
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(getActivity(), "Password is updated!", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(getActivity(), "Failed to update password!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
        return view;
    }
}
