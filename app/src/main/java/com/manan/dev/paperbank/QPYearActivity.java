package com.manan.dev.paperbank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.manan.dev.paperbank.Adapters.QPYearAdapter;
import com.manan.dev.paperbank.Adapters.SubjectAdapter;
import com.manan.dev.paperbank.Models.SubjectModel;
import com.manan.dev.paperbank.Models.batchModel;
import com.manan.dev.paperbank.Models.examTypeModel;
import com.manan.dev.paperbank.Models.qpYearModel;

import java.util.ArrayList;

public class QPYearActivity extends AppCompatActivity implements QPYearAdapter.onItemClickListener{
    private ArrayList<qpYearModel> mSubjectList;
    examTypeModel mBatch;
    QPYearAdapter qpYearAdapter;
    RecyclerView mSubjectView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qpyear);
        mSubjectList = new ArrayList<>();
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            mBatch = (examTypeModel) bundle.getSerializable("obj");
            mSubjectList = mBatch.getQpYearList();
        }
        qpYearAdapter = new QPYearAdapter(mSubjectList,this);
        mSubjectView = findViewById(R.id.qp_year_recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mSubjectView.setLayoutManager(mLayoutManager);
        mSubjectView.setItemAnimator(new DefaultItemAnimator());
        mSubjectView.setAdapter(qpYearAdapter);
    }
    @Override
    public void onItemClicked(int pos) {
        qpYearModel sub = mSubjectList.get(pos);
        Intent intent = new Intent(QPYearActivity.this,QPLinkActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("obj",sub);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
