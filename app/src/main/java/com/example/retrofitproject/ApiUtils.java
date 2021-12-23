package com.example.retrofitproject;

public class ApiUtils {
    private ApiUtils() {}

    public static final String BASE_URL = "http://learning.oilab.in/management_l/api/";

    public static RetrofitAPI getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(RetrofitAPI.class);
    }
}
