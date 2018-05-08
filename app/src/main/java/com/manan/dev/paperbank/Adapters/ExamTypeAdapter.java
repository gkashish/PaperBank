package com.manan.dev.paperbank.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.manan.dev.paperbank.ExamTypeActivity;
import com.manan.dev.paperbank.Models.SubjectModel;
import com.manan.dev.paperbank.Models.batchModel;
import com.manan.dev.paperbank.Models.examTypeModel;
import com.manan.dev.paperbank.R;

import java.util.List;

public class ExamTypeAdapter extends RecyclerView.Adapter<ExamTypeAdapter.MyViewHolder>
{
    private List<examTypeModel> examTypeList;
    private onItemClickListener mOnItemClickListener;

    public interface onItemClickListener {
        public void onItemClicked(int pos);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView subjectListRow;

        public MyViewHolder(View view) {
            super(view);
            subjectListRow = (TextView) view.findViewById(R.id.tv_batch_list_row);
        }
    }


    public ExamTypeAdapter(List<examTypeModel> examTypeList,onItemClickListener listener) {
        this.examTypeList = examTypeList;
        mOnItemClickListener = listener;
    }

    @Override
    public ExamTypeAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.batch_list_row, parent, false);

        return new ExamTypeAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ExamTypeAdapter.MyViewHolder holder, final int position) {
        examTypeModel b = examTypeList.get(position);
        holder.subjectListRow.setText(b.getExamType());
        holder.subjectListRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onItemClicked(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return examTypeList.size();
    }
}
