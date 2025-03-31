package com.example.storageapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogout = findViewById(R.id.btnLogout);

        SharedPreferences preferences = getSharedPreferences("user_prefs", MODE_PRIVATE);
        String loggedInUser = preferences.getString("logged_in_user", null);

        if (loggedInUser == null) {
            startActivity(new Intent(this, Loginactivity.class));
            finish();
        }

        btnLogout.setOnClickListener(v -> {
            SharedPreferences.Editor editor = preferences.edit();
            editor.remove("logged_in_user");
            editor.apply();

            Intent intent = new Intent(MainActivity.this, Loginactivity.class);
            startActivity(intent);
            finish();
        });
    }
}
