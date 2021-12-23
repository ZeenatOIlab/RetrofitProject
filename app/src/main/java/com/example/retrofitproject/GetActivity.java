package com.example.retrofitproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetActivity extends AppCompatActivity {
    ListView getListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get);
        getListView=findViewById(R.id.getListView);
        getApi();
    }

    void getApi()
    {
        RetrofitAPI mAPIService = ApiUtils.getAPIService();
        mAPIService.getApi().enqueue(new Callback<ArrayList<GetModel>>() {
            @Override
            public void onResponse(Call<ArrayList<GetModel>> call, Response<ArrayList<GetModel>> response) {
                ArrayList<GetModel> getList = response.body();

                for (int i = 0; i < getList.size(); i++) {
                    Log.d("List=",getList.get(i).getName());
                //    Log.d("List=",getList.get(i).getName());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<GetModel>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "An error has occured", Toast.LENGTH_LONG).show();

            }
        });

    }
}