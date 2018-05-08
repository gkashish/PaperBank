package com.manan.dev.paperbank.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.manan.dev.paperbank.Models.SubjectModel;
import com.manan.dev.paperbank.Models.batchModel;
import com.manan.dev.paperbank.R;

import java.util.List;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.MyViewHolder>
{
    private List<SubjectModel> subjectsList;
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


    public SubjectAdapter(List<SubjectModel> subjectlist,onItemClickListener listener) {
        this.subjectsList = subjectlist;
        mOnItemClickListener = listener;
    }

    @Override
    public SubjectAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.batch_list_row, parent, false);

        return new SubjectAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SubjectAdapter.MyViewHolder holder, final int position) {
        SubjectModel b = subjectsList.get(position);
        holder.subjectListRow.setText(b.getSubjectName());
        holder.subjectListRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onItemClicked(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return subjectsList.size();
    }
}
