package com.materialdesignstudy.floatingactionbutton;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.materialdesignstudy.R;

public class FloatingActionButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floating_action_button);
    }

    private boolean isReverse = false;

    public void getRotate(View view) {
        float toDegree = isReverse ? -180 : 180f;
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "rotation", 101f, toDegree).setDuration(100);
        animator.start();
        isReverse = !isReverse;
    }

}
