package com.example.storageapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {
    private EditText edUsername;
    private EditText edPassword;
    private EditText edConfirmPassword;
    private Button btnCreateUser;

    private final String CREDENTIAL_SHARED_PREF = "our_shared_pref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edUsername = findViewById(R.id.ed_username);
        edPassword = findViewById(R.id.ed_password);
        edConfirmPassword = findViewById(R.id.ed_confirm_pwd);
        btnCreateUser = findViewById(R.id.btn_create_user);

        btnCreateUser.setOnClickListener(view -> {
            String strPassword = edPassword.getText().toString();
            String strConfirmPassword = edConfirmPassword.getText().toString();
            String strUsername = edUsername.getText().toString();

            if (!strPassword.equals(strConfirmPassword)) {
                Toast.makeText(SignUpActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                return;
            }

            SharedPreferences credentials = getSharedPreferences(CREDENTIAL_SHARED_PREF, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = credentials.edit();
            editor.putString("Username", strUsername);
            editor.putString("Password", strPassword);
            editor.apply();

            Toast.makeText(SignUpActivity.this, "User Registered", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
