package com.example.spinbottle;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.RotateDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

  private   Button button;
  private ImageView imageView;
  private   Random random = new Random();
  private int lastdirection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        imageView=findViewById(R.id.imageView);

    }
    public void spin (View view)
    {
        int newdirection=random.nextInt(36000)+360;
        float pivotX=imageView.getWidth()/2,pivotY=imageView.getHeight()/2;
        int laststage;
        Animation rotate = new RotateAnimation(lastdirection,newdirection,pivotX,pivotY);
        rotate.setDuration(random.nextInt(9000)+1000);
        rotate.setFillAfter(true);
        rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                button.setEnabled(false);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
            button.setEnabled(true);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        imageView.startAnimation(rotate);
    }
}
