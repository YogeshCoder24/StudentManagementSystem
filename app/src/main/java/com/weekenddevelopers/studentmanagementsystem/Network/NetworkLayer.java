package com.weekenddevelopers.studentmanagementsystem.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkLayer {

    private static Retrofit retrofit ;


    private static String BASE_URL="https://student-lists.herokuapp.com";
    static {
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private static ApiService apiService;

    public NetworkLayer(){
        apiService =retrofit.create(ApiService.class);
        apiClient = new ApiClient(apiService);
    }

    public static  ApiClient apiClient;
}
