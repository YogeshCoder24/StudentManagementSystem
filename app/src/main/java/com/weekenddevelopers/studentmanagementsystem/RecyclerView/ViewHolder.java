package com.weekenddevelopers.studentmanagementsystem.RecyclerView;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.weekenddevelopers.studentmanagementsystem.R;

public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    TextView name,CGPA;
    View view;
    OnItemClickListener onItemClickListener;
    public ViewHolder(@NonNull View itemView, OnItemClickListener onItemClickListener) {
        super(itemView);
        view=itemView;
        name=itemView.findViewById(R.id.name_text);
        CGPA=itemView.findViewById(R.id.CGPA_text);
        this.onItemClickListener=onItemClickListener;
    itemView.setOnClickListener(this);
    }

    public void setData(String sName, String marks) {
        name.setText(sName);
        CGPA.setText(marks);
    }

    @Override
    public void onClick(View view) {
        onItemClickListener.clickListener(getAdapterPosition());

    }
    public interface OnItemClickListener{
        default  void clickListener(int position){

        }
    }
}
