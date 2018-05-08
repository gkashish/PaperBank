package com.manan.dev.paperbank.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.manan.dev.paperbank.Models.qpLinkModel;
import com.manan.dev.paperbank.R;

import java.util.List;

public class QPLinkAdapter extends RecyclerView.Adapter<QPLinkAdapter.MyViewHolder>
{
    private List<qpLinkModel> subjectsList;
    private onItemClickListener mOnItemClickListener;

    public interface onItemClickListener {
        public void onItemClicked(int pos);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView qpTitle,qpAuthor;

        public MyViewHolder(View view) {
            super(view);
            qpTitle = (TextView) view.findViewById(R.id.tv_qp_link_title);
            qpAuthor= view.findViewById(R.id.tv_author);
        }
    }


    public QPLinkAdapter(List<qpLinkModel> subjectlist,QPLinkAdapter.onItemClickListener listener) {
        this.subjectsList = subjectlist;
        mOnItemClickListener = listener;
    }

    @Override
    public QPLinkAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.qplink_list_row, parent, false);

        return new QPLinkAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(QPLinkAdapter.MyViewHolder holder, final int position) {
        qpLinkModel b = subjectsList.get(position);
        holder.qpTitle.setText(b.getQptitle());
        holder.qpAuthor.setText(b.getAuthor());
        holder.qpTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onItemClicked(position);
            }
        });
        holder.qpAuthor.setOnClickListener(new View.OnClickListener() {
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
