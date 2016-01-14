package com.matchmove.mastercard.m3.validation;

import android.content.Context;
import android.view.View;
import android.widget.EditText;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;

import java.util.List;

/**
 * Created by michael on 04/12/15.
 */
public final class LoginValidator implements Validator.ValidationListener {

    private static Context context;

    public LoginValidator(Context context) {
        this.context = context;
    }

    @Override
    public void onValidationSucceeded() {
        // Submit login form
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(context);

            // Display error messages ;)
            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            } else {

            }
        }
    }
}

