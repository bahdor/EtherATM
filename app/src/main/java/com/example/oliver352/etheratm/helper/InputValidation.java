package com.example.oliver352.etheratm.helper;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.awt.font.TextAttribute;
import java.util.ConcurrentModificationException;

/**
 * Created by Mingmin Bai on 9/25/2017.
 */

public class InputValidation {

    private Context conext;

    public InputValidation(Context context) {
        this.conext = context;
    }

    public boolean isEditTextFilled(EditText editText, TextInputLayout textInputLayout, String message) {
        String value = editText.getText().toString().trim();
        if (value.isEmpty()) {
            textInputLayout.setError(message);
            hideKeyboardFrom(editText);
            return false;
        }
        else {
            textInputLayout.setErrorEnabled(false);
        }
        return true;
    }

    public boolean isEditTextEmail() {
        String value = editText.getText().toString().trim();
        if (value.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(value).matches()) {
            editText.setError(message);
            hideKeyboardFrom(editText);
            return false;
        }
        else {
            textInputLayout.setErrorEnabled(false);
        }
        return true;
    }

    public boolean isEditTextMatches(EditText editText, EditText editText1, TextInputLayout textInputLayout, String message) {
        String value = editText.getText().toString().trim();
        String value1 = editText1.getText().toString().trim();
        if (!value.contentEquals(value1)) {
            editText.setError(message);
            hideKeyboardFrom(editText1);
            return false;
        }
        else {
            textInputLayout.setErrorEnabled(false);
        }
        return true;
    }

    private void hideKeyboardFrom(View view) {
        InputMethodManager imm = (InputMethodManager) conext.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }
}
