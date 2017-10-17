package com.example.oliver352.etheratm.activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.oliver352.etheratm.R;
import com.example.oliver352.etheratm.helper.InputValidation;
import com.example.oliver352.etheratm.sql.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;


/**
 * Created by Mingmin Bai on 9/25/2017.
 */


/**
 * A login screen that offers login via email and password.
 */
public class LoginActivity extends AppCompatActivity implements OnClickListener {

    private final AppCompatActivity activity = LoginActivity.this;
    // UI references.
    private ProgressBar progressBar;
    private ScrollView loginFormView;

    private AutoCompleteTextView emailView;
    private EditText passwordView;

    private CheckBox rememberCheckBox;
    private CheckBox autoLoginCheckBox;

    private Button signInButton;
    private Button forgetPwdButton;
    private Button signUpButton;

    private InputValidation inputValidation;
    private DatabaseHelper dataBaseHelper;

    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        initViews();
        iniListeners();
        iniObjects();
    }

    private void iniObjects() {
        dataBaseHelper = new DatabaseHelper(activity);
        inputValidation = new InputValidation( activity );
    }

    private void initViews() {
        //sp = this.getSharedPreferences("userInfo", Context.MODE_WORLD_READABLE);
        progressBar = (ProgressBar) findViewById( R.id.login_progress );
        loginFormView = (ScrollView) findViewById( R.id.login_form );

        emailView = (AutoCompleteTextView) findViewById( R.id.email );
        passwordView = (EditText) findViewById( R.id.password );

        rememberCheckBox = (CheckBox) findViewById(R.id.remember_pwd_checkbox);
        autoLoginCheckBox = (CheckBox) findViewById(R.id.auto_login_checkbox);

        signInButton = (Button) findViewById( R.id.email_sign_in_button );

        forgetPwdButton = (Button) findViewById( R.id.forget_password_button );
        signUpButton = (Button) findViewById( R.id.sign_up_button );
    }

    private void iniListeners() {
        signInButton.setOnClickListener( this );

        forgetPwdButton.setOnClickListener( this );
        signUpButton.setOnClickListener( this );

        /*
        rememberCheckBox.setOnCheckedChangeListener(this);
        autoLoginCheckBox.setOnCheckedChangeListener(this);
        */
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.email_sign_in_button:
                verifyFromSQLite();
                break;
            case R.id.forget_password_button:
                Intent intentResetPwd = new Intent(getApplicationContext(), ResetPwd.class);
                startActivity( intentResetPwd );
                break;
            case R.id.sign_up_button:
                Intent intentRegister = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity( intentRegister );
                break;
        }
    }

    private void verifyFromSQLite() {
        if (!inputValidation.isEditTextEmail(emailView)) {

        }

        if (dataBaseHelper.checkUser(emailView.getText().toString().trim(),
                passwordView.getText().toString().trim())) {
            Intent accountIntent = new Intent(activity, DisplayBalanceActivity.class );
            accountIntent.putExtra("Email", emailView.getText().toString().trim());
            emptyInputEditText();
            startActivity(accountIntent);
        }
        else {
            Snackbar.make(loginFormView, getString(R.string.error_invalid_password), Snackbar.LENGTH_LONG.show());
        }
    }

    private void emptyInputEditText() {
        emailView.setText( null );
        passwordView.setText( null );
    }

    /*
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()) {
            case R.id.remember_pwd_checkbox:
                if (rememberCheckBox.isChecked()) {
                    sp.edit().putBoolean("ISCHECK", true).commit();
                }
                else {
                    sp.edit().putBoolean("ISCHECK", false).commit();
                }
                break;
            case R.id.auto_login_checkbox:
                if (autoLoginCheckBox.isChecked()) {
                    sp.edit().putBoolean("ISCHECK", true).commit();
                }
                else {
                    sp.edit().putBoolean("ISCHECK", false).commit();
                }
                break;
        }
    }
    */
}

