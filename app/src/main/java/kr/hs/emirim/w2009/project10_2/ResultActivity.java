package kr.hs.emirim.w2009.project10_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        int[] voteCount = intent.getIntArrayExtra("voteCount");
        String[] imgNames = intent.getStringArrayExtra("imgNames");

        int max =0 ;
        int index = 0;
        for(int i = 0; i < voteCount.length; i++){
            if(voteCount[i]>max){
                max = voteCount[i];
                index = i;
            }
        }
        Toast.makeText(getApplicationContext(), "max : " + max + "index : " + index, Toast.LENGTH_SHORT).show();
        TextView[] tv = new TextView[imgNames.length];
        RatingBar[] rb = new RatingBar[imgNames.length];

        int[] imgSrcIds = {R.drawable.iu, R.drawable.karina, R.drawable.joy, R.drawable.sejung, R.drawable.seohyun, R.drawable.winter, R.drawable.taeyeon, R.drawable.taeyeon, R.drawable.ujung, R.drawable.yooa};
        int[] tvIds = {R.id.text1, R.id.text2,R.id.text3, R.id.text4, R.id.text5, R.id.text6, R.id.text7,R.id.text8, R.id.text9};
        int[] rbIds = {R.id.rating1, R.id.rating2, R.id.rating3, R.id.rating4, R.id.rating5, R.id.rating6, R.id.rating7, R.id.rating8, R.id.rating9};


        for(int i = 0; i < tv.length; i++) {
            tv[i] = findViewById(tvIds[i]);
            rb[i] = findViewById(rbIds[i]);
            tv[i].setText(imgNames[i]);
            rb[i].setRating(voteCount[i]);

        }

        TextView textTitle = findViewById(R.id.text_title);
        ImageView imgv = findViewById(R.id.imgv);
        textTitle.setText(imgNames[index]);
        imgv.setImageResource(imgSrcIds[index]);

        Button btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}