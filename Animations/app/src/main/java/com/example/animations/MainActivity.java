package com.example.animations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
Button fadein,fadeout;
ImageView image;
Animation animationfadein,animationfadeout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image=findViewById(R.id.image);
        fadein=findViewById(R.id.fadein);
        fadeout=findViewById(R.id.fadeout);
        fadein.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationfadein= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
                image.startAnimation(animationfadein);
            }
        });

        fadeout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationfadeout=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_up);
                image.startAnimation(animationfadeout);
            }
        });
    }
}
