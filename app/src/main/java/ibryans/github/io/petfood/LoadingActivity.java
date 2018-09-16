package ibryans.github.io.petfood;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import static ibryans.github.io.petfood.R.animator.fade_in;

public class LoadingActivity extends Activity {

    Animation fadeIn;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        final ImageView logo = findViewById(R.id.logo);
        Glide.with(this).load(R.drawable.logo).into(logo);

        fadeIn = AnimationUtils.loadAnimation(getApplicationContext(), fade_in);

        Handler handle = new Handler();

        final Intent main = new Intent(LoadingActivity.this, MainActivity.class);

        logo.startAnimation(fadeIn);

        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
                startActivity(main);
            }
        }, 1500);
    }
}
