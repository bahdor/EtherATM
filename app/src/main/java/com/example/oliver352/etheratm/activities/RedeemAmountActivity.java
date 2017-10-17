package com.example.oliver352.etheratm.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import android.view.View;
import android.view.View.OnClickListener;

import com.example.oliver352.etheratm.R;

public class RedeemAmountActivity extends AppCompatActivity implements OnClickListener {

    private final RedeemAmountActivity activity = RedeemAmountActivity.this;

    private LinearLayout redeemAmountLayout;
    private TextView redeemAmountText;

    private RelativeLayout amountInputLayout;
    private TextView etherLogo;
    private EditText inputAmount;

    private RelativeLayout availableBalanceLayout;
    private TextView availableText;
    private TextView availableEther;
    private TextView etherLogo2;

    private Button confirmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_redeem_amount );

        initViews();
        initListeners();

    }


    private void initViews() {
        redeemAmountLayout = (LinearLayout) findViewById( R.id.amount_form_layout );
        redeemAmountText = (TextView) findViewById( R.id.redeem_amount_text );
        amountInputLayout = (RelativeLayout) findViewById( R.id.redeem_amount_layout);
        etherLogo = (TextView) findViewById( R.id.ether_logo );
        inputAmount = (EditText) findViewById( R.id.input_amount );

        availableBalanceLayout = (RelativeLayout) findViewById( R.id.available_layout );
        availableText = (TextView) findViewById( R.id.available_balance_text );
        availableText = (TextView) findViewById( R.id.available_balance_num );
        etherLogo2 = (TextView) findViewById( R.id.ether_logo );

        confirmButton = (Button) findViewById( R.id.confirm_amount_button );
    }
    private void initListeners() {
        confirmButton.setOnClickListener( this );
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.confirm_amount_button:
                Intent intentGiversMap = new Intent(getApplicationContext(), GiversMapsActivity.class);
                startActivity( intentGiversMap);
                break;
        }
    }
}
