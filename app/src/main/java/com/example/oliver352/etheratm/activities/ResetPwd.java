package com.example.oliver352.etheratm.activities;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.oliver352.etheratm.R;
import com.example.oliver352.etheratm.helper.InputValidation;
import com.example.oliver352.etheratm.modules.User;
import com.example.oliver352.etheratm.sql.DatabaseHelper;


/**
 * Created by Mingmin Bai on 9/25/2017.
 */


public class ResetPwd extends AppCompatActivity implements OnClickListener {

    private final AppCompatActivity activity = ResetPwd.this;

    private LinearLayout resetForm;
    private TextInputLayout newPasswordLayout;
    private TextInputLayout confirmPasswordLayout;

    private EditText newPasswordText;
    private EditText confirmPasswordText;

    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;
    private User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_reset_pwd );

        initViews();
        initListeners();
        initObjects();
    }

    private void initObjects() {
        inputValidation = new InputValidation( activity );
        databaseHelper = new DatabaseHelper( activity );
        user = new User();
    }

    private void initListeners() {

    }

    private void initViews() {
        resetForm = (LinearLayout) findViewById( R.id.reset_pwd_layout );
        newPasswordLayout = (TextInputLayout) findViewById( R.id.new_password_layout );
        confirmPasswordLayout = (TextInputLayout) findViewById( R.id.confirm_pwd_layout ) ;

        newPasswordText = (EditText) findViewById( R.id.new_password );
        confirmPasswordText = (EditText) findViewById( R.id.confirm_pwd_text );
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.reset_button:
                postDataToSQLite();
                //link to login page to login
                Intent intentLogin = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity( intentLogin);
                break;
        }
    }

    private void postDataToSQLite() {

        user.setPassword( newPasswordText.getText().toString().trim() );

        databaseHelper.addUser( user );
    }
}
