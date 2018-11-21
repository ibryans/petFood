package ibryans.github.io.petfood.View;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import ibryans.github.io.petfood.Model.User;
import ibryans.github.io.petfood.R;

public class InitialUserActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_user);

        // ID
        final String id = InitialUserActivity.this.getIntent().getExtras().getString("id");


        /*   Pega os valores digitados pelo user   */

        final EditText username = findViewById(R.id.userName);
        final EditText petname = findViewById(R.id.petName);
        final RadioGroup radioGroup = findViewById(R.id.sexo);
        final Spinner dropdown = findViewById(R.id.especies);
        Button btn = findViewById(R.id.btn);

        // Pega o item selecionado do radio group
        final int idSexo = radioGroup.getCheckedRadioButtonId();
        final String petSexo = ((RadioButton) findViewById(idSexo)).getText().toString();

        // Seta as espécies no spinner
        String[] items = new String[]{"Cachorro", "Gato", "Ave", "Coelho"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent view = new Intent(InitialUserActivity.this, MainActivity.class);

                /* *** Armazena no SharedPreferences *** */

                SharedPreferences pref = InitialUserActivity.this.getSharedPreferences("PET07", 0);

                SharedPreferences.Editor editor = pref.edit();
                editor.putString("id", id);
                editor.putString("username", username.getText().toString());
                editor.putString("petname", petname.getText().toString());
                editor.putString("petEspecie", dropdown.getSelectedItem().toString());
                editor.putString("petGender", petSexo);

                editor.commit();


                /* *** Armazena no banco de dados *** */

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference ref = database.getReference(id);

                Map<String, User> users = new HashMap<>();
                users.put("User",
                        new User(username.getText().toString(),
                                petname.getText().toString(),
                                dropdown.getSelectedItem().toString(),
                                petSexo) );

                ref.setValue(users);

                startActivity(view);
            }
        });
    }
}
