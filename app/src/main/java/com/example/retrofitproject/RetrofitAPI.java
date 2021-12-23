package com.example.retrofitproject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface RetrofitAPI {
    @POST("insert")
    @FormUrlEncoded
    Call<PostModel> insertPost(@Field("dummy_name") String name,
                             @Field("dummy_phone") String phone,
                             @Field("dummy_course") String courses,
                             @Field("dummy_address") String address);


    @GET("dummy_view")
    Call<ArrayList<GetModel>> getApi();
}
