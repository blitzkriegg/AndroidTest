package com.nerubia.cfw.view;

/**
 * Created by meldy on 11/06/2015.
 */

import android.app.Activity;

/**
 * Base View interface for all common view methods
 * These methods should be implemented in the
 * activites, fragments and the like
 */
public interface ICfwView {

    /**
     * Show progress/loading dialog
     */
    public void showProgressDialog(int titleId, int messageId);

    /**
     * Hide progress/loading dialog
     */
    public void hideProgressDialog();

    /**
     * Retrieves user activity
     */
    public Activity getActivity();

}
