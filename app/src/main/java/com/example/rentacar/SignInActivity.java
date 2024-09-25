package com.example.rentacar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.rentacar.model.Customer;
import com.example.rentacar.model.GlobalVariables;
import com.example.rentacar.model.InternalDataBase;

public class SignInActivity extends AppCompatActivity {

    private EditText emailInput, passwordInput;
    private Button signInButton, twitterButton, facebookButton;
    private TextView forgotPasswordText, signUpText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        signInButton = findViewById(R.id.signInButton);
        twitterButton = findViewById(R.id.twitterButton);
        facebookButton = findViewById(R.id.facebookButton);
        forgotPasswordText = findViewById(R.id.forgotPasswordText);
        signUpText = findViewById(R.id.signUpText);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle sign-in logic here
                String email = emailInput.getText().toString();
                String password = passwordInput.getText().toString();

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(SignInActivity.this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
                } else {
                    // Perform authentication
                    for (Customer user : InternalDataBase.users) {
                        if (user.getUsername().equals(email) && user.getPassword().equals(password)) {
                            GlobalVariables.activeUser = user;
                            Intent intent = new Intent(SignInActivity.this, HomeActivity.class);
                            startActivity(intent);
                            return;
                        }
                    }
                    Toast.makeText(SignInActivity.this, "Wrong credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });

        twitterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle Twitter login logic here
                Toast.makeText(SignInActivity.this, "Twitter Login Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        facebookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle Facebook login logic here
                Toast.makeText(SignInActivity.this, "Facebook Login Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        signUpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Sign Up screen
                Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        forgotPasswordText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle Forgot Password logic
                Toast.makeText(SignInActivity.this, "Forgot Password Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
