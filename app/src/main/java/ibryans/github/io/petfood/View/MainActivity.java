package ibryans.github.io.petfood.View;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

import ibryans.github.io.petfood.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences pref = this.getSharedPreferences("PET07", 0);

        final String id = pref.getString("id","");
        final String nomeUser = pref.getString("username","");

        TextView txt = findViewById(R.id.txt);
        txt.setText("Bem vindo, " + nomeUser + "!");

        final EditText period = findViewById(R.id.periodo_alimentacao);

        Button btn = findViewById(R.id.btn_periodo);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference ref = database.getReference(id);

                Map<String, Object> userUpdates = new HashMap<>();
                userUpdates.put("User/period", period.getText().toString());

                ref.updateChildren(userUpdates);

                Toast.makeText(MainActivity.this, "Período definido: " + period.getText().toString() + " segundos", Toast.LENGTH_LONG).show();

            }
        });

    }
}
