package com.nerubia.cfw.utils;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Patterns;

import com.nerubia.cfw.constants.CfwValidationConstants;

/**
 * Created by meldy on 01/06/2015.
 */

/**
 * Global utility class which includes functions used by most applications
 */
public class CfwValidationUtility {

    /**
     * Checks if specified email address is valid
     * @param emailAdd email address to validate
     * @return {true} if email address is valid
     */
    public final static boolean isEmailValid(@NonNull CharSequence emailAdd) {
        return !TextUtils.isEmpty(emailAdd) &&
                Patterns.EMAIL_ADDRESS.matcher(emailAdd).matches();
    }

    /**
     * Checks if specified password is valid
     * @param password password to validate
     * @return {true} if password is valid
     */
    public final static boolean isPasswordValid(@NonNull CharSequence password){
        return !TextUtils.isEmpty(password) &&
                password.length() >= CfwValidationConstants.MIN_PASSWORD_CHARACTERS &&
                password.length() <= CfwValidationConstants.MAX_PASSWORD_CHARACTERS;
    }

    /**
     * Checks if specified phone number is valid
     * @param phoneNumber phone number to validate
     * @return {true} if phone number is valid
     */
    public final static boolean isPhoneValid(@NonNull CharSequence phoneNumber) {
        return !TextUtils.isEmpty(phoneNumber) &&
                Patterns.PHONE.matcher(phoneNumber).matches();
    }

}

