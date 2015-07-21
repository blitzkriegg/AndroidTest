package com.nerubia.cfw.fragments;

import android.app.ProgressDialog;
import android.support.v4.app.Fragment;

import com.nerubia.cfw.view.ICfwView;

import de.greenrobot.event.EventBus;

/**
 * Created by meldy on 07/07/2015.
 */
public class CfwFragment extends Fragment implements ICfwView {

    protected ProgressDialog mProgressDialog;
    protected boolean        registerEventBus;

    /**
     * Displays progress dialog if instantiated
     */
    @Override
    public void showProgressDialog(int titleID, int messageId) {
        mProgressDialog = ProgressDialog.show(getActivity(), getString(titleID),
                getString(messageId), true);
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
    public void onStart() {
        super.onStart();
        if(registerEventBus) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if(registerEventBus) {
            EventBus.getDefault().unregister(this);
        }
    }
}
