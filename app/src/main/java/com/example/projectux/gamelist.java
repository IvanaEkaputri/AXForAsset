package com.example.projectux;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class gamelist extends AppCompatActivity {

    String globaluname;

    String passglobal;
    private Button button;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamelist);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String password = intent.getStringExtra("password");
        toolbar.setSubtitle("Welcome, "+username+"!");
        globaluname = username;
        passglobal = password;
        button = findViewById((R.id.Button1));
        button1 = findViewById(R.id.Button2);
        button2 = findViewById(R.id.Button3);
        button3 = findViewById(R.id.Button4);
        button4 = findViewById(R.id.Button5);
//        button.setOnClickListener(e-> {
//            openGameAsset();
//        });
        button.setOnClickListener(e-> {
                openGameAsset();
            });
        button1.setOnClickListener(e-> {
            openGameAsset1();
        });
        button2.setOnClickListener(e-> {
            openGameAsset2();
        });
        button3.setOnClickListener(e-> {
            openGameAsset3();
        });
        button4.setOnClickListener(e-> {
            openGameAsset4();
        });
    }

    public void openGameAsset() {
        Intent intent = new Intent(this, GameDetails.class);
        intent.putExtra("username", globaluname);
        intent.putExtra("password", passglobal);
        startActivity(intent);
    }

    public void openGameAsset1() {
        Intent intent = new Intent(this, GameDetails1.class);
        intent.putExtra("username", globaluname);
        intent.putExtra("password", passglobal);
        startActivity(intent);
    }

    public void openGameAsset2() {
        Intent intent = new Intent(this, GameDetails2.class);
        intent.putExtra("username", globaluname);
        intent.putExtra("password", passglobal);
        startActivity(intent);
    }
//
    public void openGameAsset3() {
        Intent intent = new Intent(this, GameDetails3.class);
        intent.putExtra("username", globaluname);
        intent.putExtra("password", passglobal);
        startActivity(intent);
    }
//
    public void openGameAsset4() {
        Intent intent = new Intent(this, GameDetails4.class);
        intent.putExtra("username", globaluname);
        intent.putExtra("password", passglobal);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menugame, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.logoutmenu) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        if (item.getItemId() == R.id.homepage) {
            Intent intent = new Intent(this, homepage.class);
            intent.putExtra("username", globaluname);
            intent.putExtra("password", passglobal);
            startActivity(intent);
        }
        if (item.getItemId() == R.id.profilemenu) {
            Intent intent = new Intent(this, profile.class);
            intent.putExtra("username", globaluname);
            intent.putExtra("password", passglobal);
            startActivity(intent);

        }

        return true;
    }

}