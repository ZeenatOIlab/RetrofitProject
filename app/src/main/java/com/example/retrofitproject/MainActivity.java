package com.example.retrofitproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
public class MainActivity extends AppCompatActivity {
    MaterialButton getMaterialButton,postMaterialButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getMaterialButton=findViewById(R.id.getMaterialButton);
        postMaterialButton=findViewById(R.id.postMaterialButton);
        getMaterialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GetActivity.class));

            }
        });
        postMaterialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PostActivity.class));

            }
        });
    }
}