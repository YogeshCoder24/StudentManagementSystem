package com.weekenddevelopers.studentmanagementsystem.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.weekenddevelopers.studentmanagementsystem.R;
import com.weekenddevelopers.studentmanagementsystem.model.RecyclerModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<ViewHolder> {

    List<RecyclerModel> recyclerModel;
    ViewHolder.OnItemClickListener onItemClickListener;

    public RecyclerAdapter(List<RecyclerModel> recyclerModel,ViewHolder.OnItemClickListener onItemClickListener) {
        this.recyclerModel= Collections.unmodifiableList(recyclerModel);
        this.onItemClickListener=onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_ui,parent,false);

        return new ViewHolder(view,onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
String name=recyclerModel.get(position).getRecycleName();
String marks=recyclerModel.get(position).getRecycleCGPA();
holder.setData(name,marks);
    }

    @Override
    public int getItemCount() {
        int size=0;
        if(recyclerModel.size()>0){
            size=recyclerModel.size();
        }
        return size;
    }
}
