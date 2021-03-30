package com.midproject.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.midproject.app.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityLoginBinding binding;

    private final String username = "test@test.com";
    private final String password = "test";

    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

                binding.btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == binding.btnLogin.getId()){
            String getUsername = binding.etUsername.getText().toString();
            String getPassword = binding.etPassword.getText().toString();

            if(getUsername.isEmpty()) binding.etUsername.setError("The Username is Empty ");
            else if (getPassword.isEmpty()) binding.etPassword.setError("Enter the Password");

            if(getUsername.equals(username) && getPassword.equals(password)){
                Intent moveToMainActivity = new Intent(this, MainActivity.class);
                startActivity(moveToMainActivity);
            }
            else Toast.makeText(this, "Wrong Password or Wrong Ussername", Toast.LENGTH_SHORT).show();


        }
    }
}