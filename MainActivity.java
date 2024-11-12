package com.example.myapplication;

import android.animation.ValueAnimator;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
    LottieAnimationView animationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Initialize the animation view after setContentView
        animationView = findViewById(R.id.animation_view);

        if (animationView == null) {
            throw new NullPointerException("animationView is null. Check if the ID in XML is correct.");
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Custom animation speed or duration.
        ValueAnimator animator = ValueAnimator.ofFloat(0f, 1f);
        animator.addUpdateListener(animation -> {
            animationView.setProgress((Float) animation.getAnimatedValue());
        });
        animator.start();

        // Add animator update listener to the animation view
        animationView.addAnimatorUpdateListener(animation -> {
            // Do something
        });

        animationView.playAnimation();

        if (animationView.isAnimating()) {
            // Do something
        }
    }
}

