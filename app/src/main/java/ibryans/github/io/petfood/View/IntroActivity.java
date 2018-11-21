package ibryans.github.io.petfood.View;

import android.Manifest;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import agency.tango.materialintroscreen.MaterialIntroActivity;
import agency.tango.materialintroscreen.MessageButtonBehaviour;
import agency.tango.materialintroscreen.SlideFragmentBuilder;
import ibryans.github.io.petfood.R;

// Tela de introdução
public class IntroActivity extends MaterialIntroActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        addSlide(new SlideFragmentBuilder()
                        .backgroundColor(R.color.colorPrimaryDark)
                        .buttonsColor(R.color.colorIntroAccent)
                        .image(R.drawable.logo)
                        .title("Bem vindo ao petFood!")
                        .description("O melhor sistema para automatizar a alimentação de seu animal de estimação :)")
                        .build());

        addSlide(new SlideFragmentBuilder()
                        .backgroundColor(R.color.colorIntro)
                        .buttonsColor(R.color.colorIntroAccent)
                        .neededPermissions(new String[]{Manifest.permission.CAMERA})
                        .image(R.drawable.qr_code)
                        .title("Conexão com a máquina")
                        .description("Para conectar o app à sua máquina automática, precisamos escanear o QR code presente na mesma")
                        .build());
    }

    @Override
    public void onFinish() {
        super.onFinish();

        Intent view = new Intent(this, ScannerActivity.class);
        startActivity(view);
    }
}
