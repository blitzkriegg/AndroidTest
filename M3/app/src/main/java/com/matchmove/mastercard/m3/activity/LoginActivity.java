package com.matchmove.mastercard.m3.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import com.matchmove.mastercard.m3.R;

public class LoginActivity extends AppCompatActivity {

    private static EditText username;
    private static EditText password;
    private static Button loginButton;  
    private static Button forgotPasswordButton;
    private static Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initializeVariables();
        setupLoginButton();
        setupForgotPasswordButton();
        setupSignUpButton();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void initializeVariables(){
        username = (EditText)findViewById(R.id.login_editText_email);
        password = (EditText)findViewById(R.id.login_editText_password);
        loginButton = (Button)findViewById(R.id.login_button_login);
        forgotPasswordButton = (Button)findViewById(R.id.login_button_forgotPassword);
        signUpButton = (Button)findViewById(R.id.login_button_signUp);
    }

    public void setupLoginButton(){
        loginButton.setOnClickListener(
            new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    // do validation for login -> create a validation class
                }
            }
        );
    }

    public void setupForgotPasswordButton(){
        forgotPasswordButton.setOnClickListener(
            new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    // go to forgot password page
                }
            }
        );
    }

    public void setupSignUpButton(){
        signUpButton.setOnClickListener(
            new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    // go to register page
                }
            }
        );
    }
}
