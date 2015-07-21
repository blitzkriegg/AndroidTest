package com.nerubia.cfw.utils;

import android.text.TextUtils;

/**
 * Created by meldy on 08/07/2015.
 */
public class CfwStringUtils {

    /**
     * Checks if the value specified is null, empty or "null"
     * @param value string to check
     */
    public static boolean isEmpty(String value){
        return TextUtils.isEmpty(value) || value.equals("null");
    }

}
