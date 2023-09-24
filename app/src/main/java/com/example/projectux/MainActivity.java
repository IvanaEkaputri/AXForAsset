package com.example.projectux;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etUser;
    EditText etPassword;
    Button loginbutton;
    String username;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUser = findViewById(R.id.etUser);
        etPassword = findViewById(R.id.etPassword);
        loginbutton = findViewById(R.id.loginbutton);

        loginbutton.setOnClickListener(e->{
            username = etUser.getText().toString();
            password = etPassword.getText().toString();
            Log.d("Register", "Username: "+username);
            Log.d("Register", "Password: "+password);
            if (username.isEmpty()) {
                Toast.makeText(this, "Please Input Username", Toast.LENGTH_SHORT).show();
            }
            else if (password.isEmpty()) {
                Toast.makeText(this, "Please Input Password", Toast.LENGTH_SHORT).show();
            }
            else if(password.length() < 8){
                Toast.makeText(this, "Password Must be Atleast 8 Characters Long", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT);
                etUser.setText("");
                etPassword.setText("");
                Intent intent = new Intent(this, homepage.class);
                intent.putExtra("username", username);
                intent.putExtra("password", password);
                startActivity(intent);
            }
        });

    }
}