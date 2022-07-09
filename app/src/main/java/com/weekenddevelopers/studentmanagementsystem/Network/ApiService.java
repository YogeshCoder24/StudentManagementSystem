package com.weekenddevelopers.studentmanagementsystem.Network;


import com.weekenddevelopers.studentmanagementsystem.model.StudentDB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface ApiService {

    @POST("/student")
    public Call<StudentDB> addStudent(@Body StudentDB student);


    @GET("/student")
    public Call<ArrayList<StudentDB>> getStudents();

    @GET("/student/{id}")
    public Call<StudentDB> getStudent(@Path("id") String id);


    @DELETE("/student/{id}")
    public Call<StudentDB> deleteStudent(@Path("id") String id);

    @PATCH("/student/{id}")
    public Call<StudentDB> updateStudent(@Path("id") String id, @Body StudentDB student);


}
