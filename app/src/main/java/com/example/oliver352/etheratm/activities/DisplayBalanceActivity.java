package com.example.oliver352.etheratm.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import android.view.View;
import android.view.View.OnClickListener;

import com.example.oliver352.etheratm.R;
import com.example.oliver352.etheratm.helper.InputValidation;
import com.example.oliver352.etheratm.sql.DatabaseHelper;
import com.google.android.gms.vision.text.Line;
import com.google.android.gms.vision.text.Text;

public class DisplayBalanceActivity extends AppCompatActivity implements OnClickListener{

    private final AppCompatActivity activity = DisplayBalanceActivity.this;

    // UI references.
    private LinearLayout balanceLayout;
    private TextView balanceTitle;
    private TextView balanceNum;

    private Button redeemButton;
    private RelativeLayout checkBoxLayout;
    private CheckBox atmCheckBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_display_balance );

        initViews();
        initListeners();
    }

    private void initViews() {
        balanceLayout = (LinearLayout) findViewById( R.id.balance_layout );
        balanceTitle = (TextView) findViewById( R.id.balance_text );
        balanceNum = (TextView) findViewById( R.id.balance_num );

        redeemButton = (Button) findViewById( R.id.redeem_button );
        atmCheckBox = (CheckBox) findViewById( R.id.atm_checkbox );
    }

    private void initListeners() {
        redeemButton.setOnClickListener( this );
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.redeem_button:
                Intent intentInputAmount = new Intent(getApplicationContext(), RedeemAmountActivity.class);
                startActivity( intentInputAmount );
                break;
        }
    }
}
