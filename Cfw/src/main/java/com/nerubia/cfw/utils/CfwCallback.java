package com.nerubia.cfw.utils;

import android.support.v4.app.DialogFragment;
import android.text.TextUtils;

import com.nerubia.cfw.R;
import com.nerubia.cfw.activity.CfwActivity;
import com.nerubia.cfw.constants.CfwHttpRequestConstants;
import com.nerubia.cfw.dialogs.CfwNoticeDialogFragment;
import com.nerubia.cfw.entities.CfwCallbackPojo;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by meldy on 23/06/2015.
 */
public class CfwCallback implements Callback<CfwCallbackPojo> {

    private static final String DIALOG_FAILURE_MESSAGE = "dialog_request_failed";
    private static final String DIALOG_SUCCESS_MESSAGE = "dialog_success_failed";

    private CfwActivity mActivity;

    public CfwCallback(CfwActivity activity) {
        mActivity = activity;
    }

    @Override
    public void success(CfwCallbackPojo o, Response response) {
        DialogFragment dialogFragment = CfwNoticeDialogFragment.newInstance(-1, response.getReason(),
                android.R.string.ok, -1, DIALOG_SUCCESS_MESSAGE);
        dialogFragment.show(mActivity.getSupportFragmentManager(),DIALOG_SUCCESS_MESSAGE );
    }

    @Override
    public void failure(RetrofitError error) {
        String message = retrieveStatusMessage(error.getResponse().getStatus());
        if(TextUtils.isEmpty(message)) {
            message = error.getMessage();
        }
        DialogFragment dialogFragment = CfwNoticeDialogFragment.newInstance(-1, message,
                android.R.string.ok, -1, DIALOG_FAILURE_MESSAGE);
        dialogFragment.show(mActivity.getSupportFragmentManager(),DIALOG_FAILURE_MESSAGE );
    }

    public String retrieveStatusMessage(int statusCode){
        if(statusCode >= CfwHttpRequestConstants.HTTP_STATUS_CODE_SERVER_ERROR) {
            return mActivity.getString(R.string.stat_msg_server_error);
        } else if (statusCode >= CfwHttpRequestConstants.HTTP_STATUS_CODE_CLIENT_ERROR) {
            return mActivity.getString(R.string.stat_msg_client_error);
        }
        return null;
    }

}