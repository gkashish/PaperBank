package com.manan.dev.paperbank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.manan.dev.paperbank.Adapters.SubjectAdapter;
import com.manan.dev.paperbank.Models.SubjectModel;
import com.manan.dev.paperbank.Models.batchModel;

import java.util.ArrayList;

public class SubjectActivity extends AppCompatActivity implements SubjectAdapter.onItemClickListener{
    private ArrayList<SubjectModel> mSubjectList;
    batchModel mBatch;
    SubjectAdapter mSubjectAdapter;
    RecyclerView mSubjectView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);
        mSubjectList = new ArrayList<>();
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            mBatch = (batchModel) bundle.getSerializable("obj");
            mSubjectList = mBatch.getSubjectList();
        }
        mSubjectAdapter = new SubjectAdapter(mSubjectList,this);
        mSubjectView = findViewById(R.id.subject_recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mSubjectView.setLayoutManager(mLayoutManager);
        mSubjectView.setItemAnimator(new DefaultItemAnimator());
        mSubjectView.setAdapter(mSubjectAdapter);
    }
    @Override
    public void onItemClicked(int pos) {
        SubjectModel sub = mSubjectList.get(pos);
        Intent intent = new Intent(SubjectActivity.this,ExamTypeActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("obj",sub);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
