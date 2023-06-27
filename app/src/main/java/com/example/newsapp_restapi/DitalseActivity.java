package com.example.newsapp_restapi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DitalseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ditalse);
        //... code
        ImageView img = findViewById(R.id.image_News_det);

        TextView title = findViewById(R.id.tv_name_det);
        TextView desc = findViewById(R.id.tv_desc_det);
        TextView time = findViewById(R.id.tv_time_det);
        TextView aouther = findViewById(R.id.aouther_det);
        Button go = findViewById(R.id.btn_go);
        title.setText(getIntent().getStringExtra("title"));
        aouther.setText(getIntent().getStringExtra("aouther"));
        desc.setText(getIntent().getStringExtra("desc"));
        time.setText(getIntent().getStringExtra("time"));
        String url_go = getIntent().getStringExtra("go");
        String image = getIntent().getStringExtra("image");

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url_go.toString()));
                startActivity(i);
            }
        });

        Glide.with(this).load(image.toString())
                .error(R.drawable.image_ai)
                .into(img);
    }
}