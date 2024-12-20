package com.example.fittrack;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private EditText signupEmail, signupPassword;
    private Button signupButton;
    private TextView loginRedirectText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // References to UI components
        EditText etUsername = findViewById(R.id.etUsername);
        EditText etEmail = findViewById(R.id.etEmail);
        EditText etPassword = findViewById(R.id.etPassword);
        EditText etConfirmPassword = findViewById(R.id.etConfirmPassword);
        Button btnSignup = findViewById(R.id.btnSignup);
        TextView tvError = findViewById(R.id.tvError);

        // Set button click listener
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                String confirmPassword = etConfirmPassword.getText().toString().trim();

                // Basic validation
                if (TextUtils.isEmpty(username)) {
                    tvError.setText("Please enter a username");
                } else if (TextUtils.isEmpty(email)) {
                    tvError.setText("Please enter an email");
                } else if (TextUtils.isEmpty(password)) {
                    tvError.setText("Please enter a password");
                } else if (!password.equals(confirmPassword)) {
                    tvError.setText("Passwords do not match");
                } else {
                    // Successful signup action
                    tvError.setText("");
                    Toast.makeText(SignupActivity.this, "Sign-Up Successful!", Toast.LENGTH_LONG).show();

                    // Clear inputs after successful signup
                    etUsername.setText("");
                    etEmail.setText("");
                    etPassword.setText("");
                    etConfirmPassword.setText("");
                }
            }
        });

        auth=FirebaseAuth.getInstance();



    }
}
