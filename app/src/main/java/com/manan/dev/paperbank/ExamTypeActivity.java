package com.manan.dev.paperbank;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.manan.dev.paperbank.Adapters.ExamTypeAdapter;
import com.manan.dev.paperbank.Adapters.SubjectAdapter;
import com.manan.dev.paperbank.Models.SubjectModel;
import com.manan.dev.paperbank.Models.batchModel;
import com.manan.dev.paperbank.Models.examTypeModel;

import java.util.ArrayList;

public class ExamTypeActivity extends AppCompatActivity implements ExamTypeAdapter.onItemClickListener{
    private ArrayList<examTypeModel> mSubjectList;
    SubjectModel mBatch;
    ExamTypeAdapter mSubjectAdapter;
    RecyclerView mSubjectView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_type);
        mSubjectList = new ArrayList<>();
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            mBatch = (SubjectModel) bundle.getSerializable("obj");
            mSubjectList = mBatch.getExamTypeList();
        }
        mSubjectAdapter = new ExamTypeAdapter(mSubjectList,this);
        mSubjectView = findViewById(R.id.exam_type_recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mSubjectView.setLayoutManager(mLayoutManager);
        mSubjectView.setItemAnimator(new DefaultItemAnimator());
        mSubjectView.setAdapter(mSubjectAdapter);
    }
    @Override
    public void onItemClicked(int pos) {
        examTypeModel sub = mSubjectList.get(pos);
        Intent intent = new Intent(ExamTypeActivity.this,QPYearActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("obj",sub);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }
}

