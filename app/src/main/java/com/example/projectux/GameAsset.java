package com.example.projectux;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class GameAsset extends AppCompatActivity {

    ImageButton back = findViewById(R.id.backmenu);

    String globaluname;

    String passglobal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_asset);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String password = intent.getStringExtra("password");

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
    }

}