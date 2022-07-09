package com.weekenddevelopers.studentmanagementsystem.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.*;

import com.weekenddevelopers.studentmanagementsystem.Network.NetworkLayer;
import com.weekenddevelopers.studentmanagementsystem.R;
import com.weekenddevelopers.studentmanagementsystem.model.StudentDB;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    TextView topText,wantLogin;
    Button pageBtn;
EditText nameTxt,registerNoTxt,dobTxt,yearTxt,departmentTxt,CGPATxt,mailTxt,phoneTxt;
String name,registerNo,dob,year,department,CGPA,mail,phone;

private StudentDB studentDB;
boolean isFromProfile=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        findViews();
isFromProfile=getIntent().getBooleanExtra("from_Profile",false);
if(isFromProfile){
    topText.setText("Update");
    pageBtn.setText("Update");
    studentDB=(StudentDB) getIntent().getSerializableExtra("student");
    nameTxt.setText(studentDB.getName());
    registerNoTxt.setText(String.valueOf(studentDB.getRegister_no()));
    dobTxt.setText(studentDB.getDob());
    yearTxt.setText(String.valueOf(studentDB.getYear()));
    departmentTxt.setText(studentDB.getDepartment());
   CGPATxt.setText(studentDB.getCGPA());
    mailTxt.setText(studentDB.getMail());
    phoneTxt.setText(String.valueOf(studentDB.getPhone()));
    wantLogin.setVisibility(View.GONE);
}else{
    topText.setText("Register");
    pageBtn.setText("Register");
    nameTxt.setText("");
    registerNoTxt.setText("");
    dobTxt.setText("");
    yearTxt.setText("");
    departmentTxt.setText("");
    CGPATxt.setText("");
    mailTxt.setText("");
    phoneTxt.setText("");
    wantLogin.setVisibility(View.VISIBLE);
}
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
    public void toLogin(View view){
        startActivity(new Intent(RegisterActivity.this, MainActivity.class));
    }

    public void onCLickRegister(View view){
        name=nameTxt.getText().toString();
        registerNo=registerNoTxt.getText().toString();
        dob=dobTxt.getText().toString();
        year=yearTxt.getText().toString();
        department=departmentTxt.getText().toString();
        CGPA=CGPATxt.getText().toString();
        mail=mailTxt.getText().toString();
        phone=phoneTxt.getText().toString();

        if(name.isEmpty()||registerNo.isEmpty()||dob.isEmpty()||year.isEmpty()||department.isEmpty()||CGPA.isEmpty()||mail.isEmpty()||phone.isEmpty()){
            Toast.makeText(RegisterActivity.this,"Please fill all the vales",Toast.LENGTH_SHORT).show();
        }
        //7397452889
        else{
            int y = Integer.parseInt(year);
            studentDB = new StudentDB(name, dob, department, CGPA, mail, y, Long.parseLong(phone), Long.parseLong(registerNo));
            if(isFromProfile){
                new NetworkLayer().apiClient.updateStudent(studentDB.get_id(),studentDB).enqueue(new Callback<StudentDB>() {
                    @Override
                    public void onResponse(Call<StudentDB> call, Response<StudentDB> response) {
                        if(response.isSuccessful()){
                            Toast.makeText(RegisterActivity.this,"Updated Successfully",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(RegisterActivity.this,HomeActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }

                    @Override
                    public void onFailure(Call<StudentDB> call, Throwable t) {
                        Toast.makeText(RegisterActivity.this,"Updated Successfully",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(RegisterActivity.this,HomeActivity.class);
                        startActivity(intent);
                        finish();

                    }
                });
            }
            else {

//            studentDB.setName(name);
//            studentDB.setRegister_no(Long.parseLong(registerNo));
//            studentDB.setDob(dob);
//            studentDB.setYear(Integer.parseInt(year));
//            studentDB.setDepartment(department);
//            studentDB.setCGPA(CGPA);
//            studentDB.setMail(mail);
//            studentDB.setPhone(Long.parseLong(phone));
                //  Toast.makeText(RegisterActivity.this,studentDB.getName(),Toast.LENGTH_SHORT).show();
                new NetworkLayer().apiClient.addStudent(studentDB).enqueue(new Callback<StudentDB>() {
                    @Override
                    public void onResponse(Call<StudentDB> call, Response<StudentDB> response) {
                        if (response.isSuccessful()) {
//                        String res=response.message();
                            Toast.makeText(RegisterActivity.this, studentDB.getName() + " registered successfully", Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onFailure(Call<StudentDB> call, Throwable t) {
                        Toast.makeText(RegisterActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegisterActivity.this, HomeActivity.class);
//                    intent.putExtra("from_register",true);
//                    intent.putExtra("from_registerId",studentDB.get_id());
//                    intent.putExtra("from_registerNumber",studentDB.getRegister_no());
//                    intent.putExtra("from_registerPhone",studentDB.getPhone());
                        startActivity(intent);
                        finish();
                    }
                });
            }
        }
    }

    public void findViews(){
        nameTxt=findViewById(R.id.student_name);
        registerNoTxt=findViewById(R.id.student_registerno);
        dobTxt=findViewById(R.id.student_DOB);
        yearTxt=findViewById(R.id.student_year);
        departmentTxt=findViewById(R.id.student_department);
        CGPATxt=findViewById(R.id.student_CGPA);
        mailTxt=findViewById(R.id.student_mail);
        phoneTxt=findViewById(R.id.student_phone);
        topText=findViewById(R.id.register_text);
        pageBtn=findViewById(R.id.register_btn);
        wantLogin=findViewById(R.id.want_login_txt);
    }


}