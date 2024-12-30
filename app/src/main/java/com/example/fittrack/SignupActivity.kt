package com.example.fittrack

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fittrack.Activity.MainActivity
import com.google.firebase.auth.FirebaseAuth

class SignupActivity : AppCompatActivity() {

    private lateinit var etSignUpEmail: EditText
    private lateinit var etSignUpPassword: EditText
    private lateinit var btnSignUp: Button
    private lateinit var tvLogin: TextView
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        // Initialize views
        etSignUpEmail = findViewById(R.id.etSignupEmail)
        etSignUpPassword = findViewById(R.id.etSignupPassword)
        btnSignUp = findViewById(R.id.btnSignup)
        tvLogin = findViewById(R.id.tvLogin)

        // Initialize FirebaseAuth
        mAuth = FirebaseAuth.getInstance()

        // Set click listener for sign-up button
        btnSignUp.setOnClickListener {
            val email = etSignUpEmail.text.toString().trim()
            val password = etSignUpPassword.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter both email and password", Toast.LENGTH_SHORT).show()
            } else if (password.length < 6) {
                Toast.makeText(this, "Password must be at least 6 characters long", Toast.LENGTH_SHORT).show()
            } else {
                mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Signup successful!", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this, MainActivity::class.java)) // Redirect to main screen
                            finish()
                        } else {
                            Toast.makeText(this, "Signup failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }

        // Set click listener for login text
        tvLogin.setOnClickListener {
            startActivity(Intent(this, Login::class.java)) // Redirect to login screen
        }
    }
}
