package com.example.firebase_recyclersample;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerAdapter extends
        RecyclerView.Adapter<RecyclerAdapter.
                StudentViewHolder> {

    private static final String TAG = RecyclerAdapter.class.getName();

    private final ListItemClickListener itemClickListener;

    private ArrayList<StudentModel> studentModelArrayList;

    public interface ListItemClickListener {
        void onListItemClickListener(int clickedItemIndex);
    }

    public RecyclerAdapter(ArrayList<StudentModel> studentModelArrayList,
                           ListItemClickListener itemClickListener) {
        this.studentModelArrayList = studentModelArrayList;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater =
                LayoutInflater.from(
                        parent.getContext());
        View view = inflater.inflate(
                R.layout.item_layout,
                parent,
                false);

        StudentViewHolder studentViewHolder =
                new StudentViewHolder(view);

        return studentViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        StudentModel student = studentModelArrayList.get(position);
        holder.studentName.setText("Name is: " + student.name);
        holder.collegeName.setText(student.college);
    }

    @Override
    public int getItemCount() {
        return studentModelArrayList.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView studentName, collegeName;

        public StudentViewHolder(View itemView) {
            super(itemView);

            studentName = itemView.findViewById(R.id.student_name);
            collegeName = itemView.findViewById(R.id.college_name);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            itemClickListener.onListItemClickListener(clickedPosition);
        }
    }
}

