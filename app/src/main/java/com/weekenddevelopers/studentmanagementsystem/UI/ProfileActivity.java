package com.weekenddevelopers.studentmanagementsystem.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.weekenddevelopers.studentmanagementsystem.Network.NetworkLayer;
import com.weekenddevelopers.studentmanagementsystem.R;
import com.weekenddevelopers.studentmanagementsystem.model.StudentDB;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {
String id;
TextView nameTxt,registerNoTxt,dobTxt,yearTxt,departmentTxt,CGPATxt,mobileTxt,mailTxt,registerNoTxt2;
String name,register,dob,year,department,cgpa,phone,mail;
StudentDB studentDB;
boolean isupdated=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

    id = getIntent().getStringExtra("stu_id");




findView();


new NetworkLayer().apiClient.getStudent(id).enqueue(new Callback<StudentDB>() {
    @Override
    public void onResponse(Call<StudentDB> call, Response<StudentDB> response) {
        if(response.isSuccessful()) {
            studentDB = response.body();
            setValues();
        }
    }



    @Override
    public void onFailure(Call<StudentDB> call, Throwable t) {
        Toast.makeText(ProfileActivity.this,"Something went wrong",Toast.LENGTH_SHORT).show();

    }
});

    }

    private void findView() {
        nameTxt=findViewById(R.id.profile_name);
        registerNoTxt=findViewById(R.id.profile_register_no);
        registerNoTxt2=findViewById(R.id.profile_register_no2);
        dobTxt=findViewById(R.id.profile_dob);
        yearTxt=findViewById(R.id.profile_year);
        departmentTxt=findViewById(R.id.profile_dapartment);
        CGPATxt=findViewById(R.id.profile_CGPA);
        mobileTxt=findViewById(R.id.profile_phone);
        mailTxt=findViewById(R.id.profile_mail);
    }
    private void setValues() {
        name=studentDB.getName();
        nameTxt.setText(name);
        register= String.valueOf(studentDB.getRegister_no());
        registerNoTxt.setText(register);
        registerNoTxt2.setText(register);
        dob=studentDB.getDob();
        dobTxt.setText(dob);
        year= String.valueOf(studentDB.getYear());
        yearTxt.setText(year);
        department=studentDB.getDepartment();
        departmentTxt.setText(department);
        cgpa=studentDB.getCGPA();
        CGPATxt.setText(cgpa);
        phone= String.valueOf(studentDB.getPhone());
        mobileTxt.setText(phone);
        mail=studentDB.getMail();
        mailTxt.setText(mail);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(ProfileActivity.this,HomeActivity.class);
        intent.putExtra("profile",true);
        startActivity(intent);
        finish();
    }
    public void backPressed(View view){
        onBackPressed();
    }
    public void onClickEdit(View view){
        Intent intent=new Intent(ProfileActivity.this,RegisterActivity.class);
        intent.putExtra("from_Profile",true);
        intent.putExtra("student",studentDB);
        startActivity(intent);
        finish();
    }
}