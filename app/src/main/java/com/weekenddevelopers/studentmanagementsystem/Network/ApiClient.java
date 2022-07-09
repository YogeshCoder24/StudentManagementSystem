package com.weekenddevelopers.studentmanagementsystem.Network;


import com.weekenddevelopers.studentmanagementsystem.model.StudentDB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;

public class ApiClient {
    private ApiService apiService;

    public ApiClient(ApiService apiService) {
        this.apiService = apiService;
    }

    public Call<StudentDB> addStudent(StudentDB studentDB) {
        return apiService.addStudent(studentDB);
    }


    public Call<ArrayList<StudentDB>> getStudents() {
        return apiService.getStudents();
    }

    public Call<StudentDB> deleteStudent(String id) {
        return apiService.deleteStudent(id);
    }

    public Call<StudentDB> updateStudent(String id, StudentDB studentDB) {
        return apiService.updateStudent(id, studentDB);
    }


    public Call<StudentDB> getStudent(String id) {
        return apiService.getStudent(id);
    }
}
