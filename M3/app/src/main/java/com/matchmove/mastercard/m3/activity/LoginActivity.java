package com.matchmove.mastercard.m3.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.matchmove.mastercard.m3.R;
import com.matchmove.mastercard.m3.validation.LoginValidator;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;
import com.mobsandgeeks.saripaar.Validator;


public class LoginActivity extends AppCompatActivity{

    @NotEmpty @Email private static EditText username;
    @NotEmpty @Password private static EditText password;
    private static Button loginButton;  
    private static TextView forgotPasswordButton;
    private static TextView signUpButton;
    private static Validator validator;
    private static LoginValidator loginValidator;
    private static TextView emailError;
    private static TextView passwordError;
    private static TextView loginError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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
        forgotPasswordButton = (TextView)findViewById(R.id.login_textView_forgotPassword);
        signUpButton = (TextView)findViewById(R.id.login_textView_SignUp);
        emailError = (TextView)findViewById(R.id.login_textView_emailError);
        passwordError = (TextView)findViewById(R.id.login_textView_passwordError);
        loginError = (TextView)findViewById(R.id.login_textView_loginError);
        loginValidator = new LoginValidator(this);
        validator = new Validator(this);
        validator.setValidationListener(loginValidator);
    }

    public void setupLoginButton(){
        loginButton.setOnClickListener(
            new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    validator.validate();
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
                    Intent intent = new Intent(LoginActivity.this , SignUpActivity.class);
                    startActivity(intent);
                }
            }
        );
    }
}
