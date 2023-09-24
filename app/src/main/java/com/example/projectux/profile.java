package com.example.projectux;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class profile extends AppCompatActivity {

    String globaluname;

    String passglobal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tbprofile);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String password = intent.getStringExtra("password");
        toolbar.setSubtitle("Hi, "+username+"!");
        globaluname = username;
        passglobal = password;
        TextView email = findViewById(R.id.emailadd);
        email.setText(username+"@gmail.com");
        TextView add = findViewById(R.id.addressans);
        add.setText(username+" Road, West Jakarta");
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuprofile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.logoutmenu){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        if(item.getItemId() == R.id.homepage){
            Intent intent = new Intent(this, homepage.class);
            intent.putExtra("username", globaluname);
            intent.putExtra("password", passglobal);
            startActivity(intent);
        }
        if(item.getItemId() == R.id.itemmenu) {
            Intent intent = new Intent(this, gamelist.class);
            intent.putExtra("username", globaluname);
            intent.putExtra("password", passglobal);
            startActivity(intent);
        }
        return true;
    }
}