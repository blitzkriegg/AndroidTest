package com.nerubia.cfw.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;

import com.nerubia.cfw.R;
import com.nerubia.cfw.dialogs.CfwNoticeDialogFragment;
import com.nerubia.cfw.view.ICfwView;

import de.greenrobot.event.EventBus;

/**
 * Created by meldy on 11/06/2015.
 */

/**
 * Constains the common functions/methods for Application Activities
 */
public class CfwActivity extends AppCompatActivity implements ICfwView{

    protected ProgressDialog mProgressDialog;
    protected boolean registerEventBus = false;

    /**
     * Displays progress dialog if instantiated
     */
    @Override
    public void showProgressDialog(int titleID, int messageId) {
        mProgressDialog = ProgressDialog.show(this, getString(titleID),
                getString(messageId), true);
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    /**
     * Hides progress dialog if instantiated
     */
    @Override
    public void hideProgressDialog() {
        if(mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        if(registerEventBus) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(registerEventBus) {
            EventBus.getDefault().unregister(this);
        }
    }

    public void showNoticeDialog(String message, String tag){
        CfwNoticeDialogFragment dialog = CfwNoticeDialogFragment.newInstance(R.string.app_name, message,
                android.R.string.ok, -1, tag == null ? tag : tag);
        dialog.show(getSupportFragmentManager(), tag);
    }

}
