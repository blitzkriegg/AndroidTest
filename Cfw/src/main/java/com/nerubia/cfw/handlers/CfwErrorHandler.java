package com.nerubia.cfw.handlers;

import android.content.Context;
import android.util.Log;

import com.nerubia.cfw.CfwApplication;
import com.nerubia.cfw.R;
import com.nerubia.cfw.entities.CfwErrorResponse;

import retrofit.ErrorHandler;
import retrofit.RetrofitError;

/**
 * Created by meldy on 03/07/2015.
 */
public class CfwErrorHandler implements ErrorHandler {

    private Context mContext;
    private static String TAG = "CfwErrorHandler";

    public CfwErrorHandler() {
        mContext = CfwApplication.getContext();
    }

    @Override
    public Throwable handleError(RetrofitError cause) {
        String errorDescription;

        if (cause.isNetworkError()) {
            errorDescription = mContext.getString(R.string.stat_msg_network_prob);
        } else {
            if (cause.getResponse() == null) {
                errorDescription = mContext.getString(R.string.stat_msg_no_response);
            } else {

                // Error message handling - return a simple error to Retrofit handlers..
                try {
                    CfwErrorResponse errorResponse = (CfwErrorResponse) cause.getBodyAs(CfwErrorResponse.class);
                    errorDescription = errorResponse.error.data.message;
                } catch (Exception ex) {
                    try {
                        errorDescription = mContext.getString(R.string.stat_msg_network_prob, cause.getResponse().getStatus());
                    } catch (Exception ex2) {
                        Log.e(TAG, "handleError: " + ex2.getLocalizedMessage());
                        errorDescription = mContext.getString(R.string.stat_msg_uknown_error);
                    }
                }
            }
        }
        return new Exception(errorDescription);
    }
}
