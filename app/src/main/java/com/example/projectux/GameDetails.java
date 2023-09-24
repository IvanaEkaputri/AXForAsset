package com.example.projectux;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GameDetails extends AppCompatActivity {



    String globaluname;

    String passglobal;
    private Button button;
    private EditText emailinput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_details);

        ImageButton back = findViewById(R.id.backmenu);
        button = findViewById(R.id.button);
        emailinput = findViewById(R.id.editTextEmail);
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String password = intent.getStringExtra("password");
        globaluname = username;
        passglobal = password;
        Spinner spinnerPayment=findViewById(R.id.spinnerPayment);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,
                R.array.PaymentType,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerPayment.setAdapter(adapter);

        back.setOnClickListener(e->{
            Intent intent2 = new Intent(this, gamelist.class);
            intent2.putExtra("username", globaluname);
            intent2.putExtra("password", passglobal);
            startActivity(intent2);
        });

        button.setOnClickListener(e->{
            String email = emailinput.getText().toString();
            if(email.isEmpty()){
                Toast.makeText(this, "Please Input Your Email!", Toast.LENGTH_SHORT).show();
            }else{
                emailinput.setText("");
            }
        });
    }

}