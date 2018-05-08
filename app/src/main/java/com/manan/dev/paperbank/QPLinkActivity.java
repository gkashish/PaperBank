package com.manan.dev.paperbank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.manan.dev.paperbank.Adapters.QPLinkAdapter;
import com.manan.dev.paperbank.Adapters.QPYearAdapter;
import com.manan.dev.paperbank.Adapters.SubjectAdapter;
import com.manan.dev.paperbank.Models.SubjectModel;
import com.manan.dev.paperbank.Models.batchModel;
import com.manan.dev.paperbank.Models.examTypeModel;
import com.manan.dev.paperbank.Models.qpLinkModel;
import com.manan.dev.paperbank.Models.qpYearModel;

import java.util.ArrayList;

public class QPLinkActivity extends AppCompatActivity implements QPLinkAdapter.onItemClickListener{
    private ArrayList<qpLinkModel> mSubjectList;
    qpYearModel mBatch;
    QPLinkAdapter qpYearAdapter;
    RecyclerView mSubjectView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qplink);
        mSubjectList = new ArrayList<>();
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            mBatch = (qpYearModel) bundle.getSerializable("obj");
            mSubjectList = mBatch.getQpLinkList();
        }
        qpYearAdapter = new QPLinkAdapter(mSubjectList,this);
        mSubjectView = findViewById(R.id.qp_link_recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mSubjectView.setLayoutManager(mLayoutManager);
        mSubjectView.setItemAnimator(new DefaultItemAnimator());
        mSubjectView.setAdapter(qpYearAdapter);
    }
    @Override
    public void onItemClicked(int pos) {
        qpLinkModel sub = mSubjectList.get(pos);
        Intent intent = new Intent(QPLinkActivity.this,QuestionPaperActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("obj",sub);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}