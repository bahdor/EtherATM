package com.example.oliver352.etheratm.activities;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.oliver352.etheratm.R;
import com.example.oliver352.etheratm.helper.InputValidation;
import com.example.oliver352.etheratm.modules.User;
import com.example.oliver352.etheratm.sql.DatabaseHelper;


/**
 * Created by Mingmin Bai on 9/25/2017.
 */


public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private final AppCompatActivity activity = RegisterActivity.this;

    private LinearLayout registerForm;
    private TextInputLayout nameLayout;
    private TextInputLayout emailLayout;
    private TextInputLayout passwordLaout;
    private TextInputLayout confirmLayout;

    private EditText nameTextInput;
    private EditText emailTextInput;
    private EditText passwordTextInput;
    private EditText confirmTextInput;

    private Button submitButton;

    private AppCompatTextView appCompatTextViewLoginLink;

    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;
    private User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();
        
        iniView();
        initListeners();
        initObjects();
    }

    private void iniView() {
        registerForm = (LinearLayout) findViewById( R.id.register_form );

        emailLayout = (TextInputLayout) findViewById(R.id.name_layout);
        emailLayout = (TextInputLayout) findViewById(R.id.email_layout);
        passwordLaout = (TextInputLayout) findViewById( R.id.password_layout );
        confirmLayout = (TextInputLayout) findViewById( R.id.confirm_layout );

        nameTextInput = (EditText) findViewById(R.id.name_text_input);
        emailTextInput = (EditText) findViewById( R.id.email_text_input );
        passwordTextInput = (EditText) findViewById( R.id.password_text_input );
        confirmTextInput = (EditText) findViewById( R.id.comfirm_password_text_input );

        submitButton = (Button) findViewById( R.id.register_button );
    }

    private void initListeners() {
        submitButton.setOnClickListener( this );
    }

    private void initObjects() {
        inputValidation = new InputValidation( activity );
        databaseHelper = new DatabaseHelper( activity );
        user = new User();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.register_button:
                postDataToSQLite();
                //link to login page to login
                Intent intentLogin = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity( intentLogin);
                break;
        }
    }

    private void postDataToSQLite() {
        user.setName(nameTextInput.getText().toString().trim());
        user.setEmail(emailTextInput.getText().toString().trim());
        user.setPassword( passwordTextInput.getText().toString().trim() );

        databaseHelper.addUser( user );
    }
}
