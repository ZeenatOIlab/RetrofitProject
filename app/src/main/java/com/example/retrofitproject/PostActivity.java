package com.example.retrofitproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostActivity extends AppCompatActivity {
    EditText nameEdittext, phoneEditText, courseEditText, addressEditText;
    MaterialButton postButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        initViews();
        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postApi();
            }
        });
    }

    void initViews() {
        nameEdittext = findViewById(R.id.nameEdittext);
        phoneEditText = findViewById(R.id.phoneEditText);
        courseEditText = findViewById(R.id.courseEditText);
        addressEditText = findViewById(R.id.addressEditText);
        postButton = findViewById(R.id.postButton);
    }

    void postApi() {
        RetrofitAPI mAPIService = ApiUtils.getAPIService();
        mAPIService.insertPost(nameEdittext.getText().toString(),
               phoneEditText.getText().toString(),
                courseEditText.getText().toString(),
                addressEditText.getText().toString()).enqueue(new Callback<PostModel>() {
            @Override
            public void onResponse(Call<PostModel> call, Response<PostModel> response) {
                Log.i("TAG", "post submitted to API." + response.body().toString());
                PostModel model=new PostModel();
                model= response.body();
                Toast.makeText(PostActivity.this, "uploaded "+model.getName(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<PostModel> call, Throwable t) {
                Toast.makeText(PostActivity.this, "not uploaded", Toast.LENGTH_SHORT).show();
                Log.e("TAG", t.getMessage());
                Log.e("TAG", "Unable to submit post to API.");

            }
        });

    }
}