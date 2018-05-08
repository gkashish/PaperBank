package com.manan.dev.paperbank;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.manan.dev.paperbank.Adapters.BatchAdapter;
import com.manan.dev.paperbank.Models.batchModel;

import java.util.ArrayList;

public class BatchActivity extends AppCompatActivity implements BatchAdapter.onItemClickListener {
    public static ArrayList<batchModel> mBatchList;
    private RecyclerView recyclerView;
    private BatchAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batch);
        mBatchList = new ArrayList<>();
    }

    @Override
    protected void onResume() {
        super.onResume();


        SharedPreferences prefs = getSharedPreferences("Institute", MODE_PRIVATE);
        String restoredText = prefs.getString("name", null);
        if (restoredText == null) {
            Intent intent = new Intent(BatchActivity.this,SettingsActivity.class);
            startActivity(intent);
            finish();
        }
        recyclerView=findViewById(R.id.batch_recycler_view);
        mAdapter = new BatchAdapter(mBatchList,this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Institues").child(restoredText);

        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mBatchList.clear();
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    batchModel post = postSnapshot.getValue(batchModel.class);

                    mBatchList.add(post);
                }
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    @Override
    public void onItemClicked(int pos) {
        batchModel batchModel = mBatchList.get(pos);
        Intent intent = new Intent(BatchActivity.this,SubjectActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("obj",batchModel);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_option, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.add_question :
                startActivity(new Intent(BatchActivity.this, AddQuestionActivity.class));
                return true;
            case R.id.action_settings:
                startActivity(new Intent(BatchActivity.this,SettingsActivity.class));
                finish();
                return true;
            case R.id.action_logout:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(BatchActivity.this,LoginActivity.class));
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
