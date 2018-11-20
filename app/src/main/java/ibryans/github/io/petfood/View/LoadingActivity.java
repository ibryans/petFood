package ibryans.github.io.petfood.View;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import ibryans.github.io.petfood.R;

import static ibryans.github.io.petfood.R.animator.fade_in;

public class LoadingActivity extends Activity {

    Animation fadeIn;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        // Gerando a imagem
        ImageView logo = findViewById(R.id.logo);
        Glide.with(this).load(R.drawable.logo).into(logo);

        fadeIn = AnimationUtils.loadAnimation(getApplicationContext(), fade_in);
        logo.startAnimation(fadeIn);

        // Criando a intent intro
        final Intent intro = new Intent(LoadingActivity.this, IntroActivity.class);

        // Vai para a intro depois de 1,5 s
        Handler handle = new Handler();
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {

                finish();

                // Verifica se o usuário já se conectou com sua máquina
                // if (userConnected == true) {
                    startActivity(intro);
                // } else {
                //  startActivity(connect);
                // }

            }
        }, 1500);
    }
}
