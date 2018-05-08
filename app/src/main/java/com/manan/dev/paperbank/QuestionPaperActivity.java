package com.manan.dev.paperbank;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.manan.dev.paperbank.Models.qpLinkModel;
import com.manan.dev.paperbank.Models.qpYearModel;
import com.squareup.picasso.Picasso;

public class QuestionPaperActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_paper);
        qpLinkModel mod;
        String link=null;
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            mod = (qpLinkModel) bundle.getSerializable("obj");
            link = mod.getQplink();
        }
        ImageView qp=findViewById(R.id.iv_question_paper);
        Picasso.with(this).load(link).into(qp);

    }
}
