package com.example.fittrack;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    private FirebaseAuth auth;
    private EditText loginEmail;
    private TextView signupRedirectText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // References to UI components
        EditText etUsername = findViewById(R.id.etUsername);
        EditText etPassword = findViewById(R.id.etPassword);
        Button btnLogin = findViewById(R.id.btnLogin);
        TextView tvError = findViewById(R.id.tvError);

        // Predefined username and password
        String validUsername = "admin";
        String validPassword = "password123";

        // Set button click listener
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                // Validate credentials
                if (username.isEmpty() || password.isEmpty()) {
                    tvError.setText("Please fill all fields");
                } else if (username.equals(validUsername) && password.equals(validPassword)) {
                    tvError.setText("Login successful!");
                    tvError.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
                } else {
                    tvError.setText("Invalid username or password");
                    tvError.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                }
            }
        });
    }
}
