package com.example.recyclerviewsample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.StudentViewHolder> {

    Context context;
    ArrayList<StudentModel> arrayList = new ArrayList<>();

    public RecyclerAdapter(Context context, ArrayList<StudentModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }


    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        View itemView = inflater.inflate(R.layout.item_layout, viewGroup, false);

        StudentViewHolder studentViewHolder = new StudentViewHolder(itemView);
        return studentViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder studentViewHolder, int i) {
        StudentModel studentModel = arrayList.get(i);
        studentViewHolder.studentName.setText(studentModel.getStudentName());
        studentViewHolder.studentPhone.setText("" + studentModel.getStudentPhone());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView studentName, studentPhone;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);

            studentName = itemView.findViewById(R.id.tv_student_name);
            studentPhone = itemView.findViewById(R.id.tv_student_phone);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), "Item clicked position: " + getAdapterPosition(), Toast.LENGTH_LONG).show();
        }
    }
}
