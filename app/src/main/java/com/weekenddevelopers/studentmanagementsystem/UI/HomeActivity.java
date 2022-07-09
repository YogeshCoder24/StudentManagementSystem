package com.weekenddevelopers.studentmanagementsystem.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.weekenddevelopers.studentmanagementsystem.Network.NetworkLayer;
import com.weekenddevelopers.studentmanagementsystem.R;
import com.weekenddevelopers.studentmanagementsystem.RecyclerView.RecyclerAdapter;
import com.weekenddevelopers.studentmanagementsystem.RecyclerView.ViewHolder;
import com.weekenddevelopers.studentmanagementsystem.model.RecyclerModel;
import com.weekenddevelopers.studentmanagementsystem.model.StudentDB;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity implements ViewHolder.OnItemClickListener {
List<StudentDB> studentsList=new ArrayList<>();
StudentDB studentDB;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    List<RecyclerModel> recyclerModels=new ArrayList<>();
    RecyclerAdapter recyclerAdapter;
ViewHolder.OnItemClickListener onItemClickListener;
    TextView register;

    ImageView profileImage;

    boolean isLogged=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        findViews();
//isLogged=getIntent().getBooleanExtra("profile",false);
        //checkIsLogged();

//retrieving all students from server
        new NetworkLayer().apiClient.getStudents().enqueue(new Callback<ArrayList<StudentDB>>() {
            @Override
            public void onResponse(Call<ArrayList<StudentDB>> call, Response<ArrayList<StudentDB>> response) {
                if(response.isSuccessful()){
                    int a=0;
                    while(a<response.body().size()){
                        studentDB=response.body().get(a++);

                        studentsList.add(studentDB);
                    }
                    initData();
                    initRecycler();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<StudentDB>> call, Throwable t) {
                Toast.makeText(HomeActivity.this, "error:\n"+t, Toast.LENGTH_LONG).show();
            }
        });

    }

    private void findViews() {
        register=findViewById(R.id.clickable_register);

         }

    private void checkIsLogged() {
        if(!isLogged){
            profileImage.setVisibility(View.GONE);

            register.setVisibility(View.VISIBLE);

        }
        else{
            profileImage.setVisibility(View.VISIBLE);

            register.setVisibility(View.GONE);

        }
    }

    public void onClickLogin(View view){
        Intent in=new Intent(this, MainActivity.class);

        startActivity(in);

    }

    public void onClickRegister(View view){
        Intent in=new Intent(this, RegisterActivity.class);
        //in.putParcelableArrayListExtra("students_list", (ArrayList<? extends Parcelable>) studentsList);
        startActivity(in); }

    public void onClickProfile(View view){ startActivity(new Intent(this, ProfileActivity.class)); }

    public void saveLogged(){
        SharedPreferences sharedPreferences=getSharedPreferences("My_preference", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
    }

    private void initData(){
        int count=0;
        //recyclerModels.add(new RecyclerModel("yogesh", "8.0"));
if(studentsList.isEmpty()){
    Toast.makeText(this,"list is empty",Toast.LENGTH_SHORT).show();
    return;
}
        while (count < studentsList.size()) {
            recyclerModels.add(new RecyclerModel(studentsList.get(count).getName(), studentsList.get(count++).getCGPA()));
        }
    }

    private  void initRecycler(){
        recyclerView=findViewById(R.id.recycler_view);
        linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerAdapter=new RecyclerAdapter(recyclerModels,this);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void clickListener(int position) {

        String id= String.valueOf(studentsList.get(position).get_id());
        String register= String.valueOf(studentsList.get(position).getRegister_no());
        String password= String.valueOf(studentsList.get(position).getPhone());
        Intent intent=new Intent(HomeActivity.this,MainActivity.class);
        intent.putExtra("stu_id" ,id);
        intent.putExtra("stu_register" ,register);
        intent.putExtra("stu_password" ,password);
        System.out.println(register);
        startActivity(intent);
    }
}