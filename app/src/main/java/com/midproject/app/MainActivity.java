package com.midproject.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.midproject.app.databinding.ActivityLoginBinding;
import com.midproject.app.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnSubmit.setOnClickListener(this);
        binding.btnHide.setOnClickListener(this);
        binding.btnImage.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == binding.btnSubmit.getId()) {
            String name = binding.etName.getText().toString();
            binding.resultName.setText(name);
            showResult(View.VISIBLE);
            }
        else if (view.getId() == binding.btnHide.getId()){
            showResult(View.GONE);
        }
        else if (view.getId() == binding.btnImage.getId()){
            String link = binding.etImage.getText().toString();
            Glide.with( this)
                    .load(link)
                    .into(binding.image);
        }
    }

    private void showResult (int state){
        binding.resultName.setVisibility(state);
        binding.tvImage.setVisibility(state);
        binding.etImage.setVisibility(state);
        binding.btnImage.setVisibility(state);
        binding.image.setVisibility(state);
    }
}