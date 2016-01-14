package com.matchmove.mastercard.m3.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.matchmove.mastercard.m3.R;

public class IntroActivity extends AppCompatActivity {

    private static Button loginButton;
    private static Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initializeVariables();
        setupLoginButton();
        setupSignUpButton();

    }

    public void initializeVariables(){
        loginButton = (Button)findViewById(R.id.into_button_logIn);
        signUpButton = (Button)findViewById(R.id.intro_button_signUp);
    }

    public void setupLoginButton(){
        loginButton.setOnClickListener(
            new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Intent intent = new Intent(IntroActivity.this , LoginActivity.class);
                    startActivity(intent);
                }
            }
        );
    }

    public void setupSignUpButton(){
        signUpButton.setOnClickListener(
            new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Intent intent = new Intent(IntroActivity.this , SignUpActivity.class);
                    startActivity(intent);
                }
            }
        );
    }
}
