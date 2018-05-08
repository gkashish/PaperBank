package com.manan.dev.paperbank.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.manan.dev.paperbank.Models.batchModel;
import com.manan.dev.paperbank.R;

import java.util.List;

public class BatchAdapter extends RecyclerView.Adapter<BatchAdapter.MyViewHolder> {

    private List<batchModel> batchesList;
    private onItemClickListener mOnItemClickListener;

    public interface onItemClickListener {
        public void onItemClicked(int pos);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView batchListRow;

        public MyViewHolder(View view) {
            super(view);
            batchListRow = (TextView) view.findViewById(R.id.tv_batch_list_row);
        }
    }


    public BatchAdapter(List<batchModel> batchesList,onItemClickListener listener) {
        this.batchesList = batchesList;
        mOnItemClickListener = listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.batch_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        batchModel b = batchesList.get(position);
        holder.batchListRow.setText(b.getBatchName());
        holder.batchListRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onItemClicked(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return batchesList.size();
    }
}
