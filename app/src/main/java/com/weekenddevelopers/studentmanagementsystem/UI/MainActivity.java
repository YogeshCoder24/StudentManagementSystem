package com.weekenddevelopers.studentmanagementsystem.UI;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.weekenddevelopers.studentmanagementsystem.R;
import com.weekenddevelopers.studentmanagementsystem.model.StudentDB;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
StudentDB studentDB;
List<StudentDB> list=new ArrayList<>();

TextView registerNoTxt,passwordTxt;
String registerNo,password,id;
    String registerNoFromHome="", passwordFromHome="";
Button loginBtn;
    boolean isFromRegister=false;
Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            id = getIntent().getStringExtra("stu_id");
            registerNoFromHome = getIntent().getStringExtra("stu_register");
            passwordFromHome = getIntent().getStringExtra("stu_password");


        registerNoTxt=findViewById(R.id.login_register_no);
        passwordTxt=findViewById(R.id.login_password);
        loginBtn=findViewById(R.id.login_btn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                registerNo=registerNoTxt.getText().toString();
                password=passwordTxt.getText().toString();
                if(registerNo.isEmpty()||password.isEmpty()){
                    Toast.makeText(MainActivity.this,"Please fill all the values", Toast.LENGTH_SHORT).show();
                }else {

                    if (registerNo.equals(registerNoFromHome) && password.equals(passwordFromHome)) {
                        Toast.makeText(MainActivity.this, "Log in Successfull", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                        intent.putExtra("stu_id", id);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(MainActivity.this, "Incorrect Register number or password", Toast.LENGTH_SHORT).show();
                    }
                }

            }


        });

    }
public void toRegister(View view){
        startActivity(new Intent(MainActivity.this, RegisterActivity.class));
}
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }



}