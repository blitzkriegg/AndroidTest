package com.nerubia.cfw.events.noticedialog;

/**
 * Created by meldy on 11/06/2015.
 */

import android.support.v4.app.DialogFragment;

/**
 * Event determine Positive Button of Notice
 * Dialog has been triggered
 */
public class CfwNoticeDialogNegativeEvent {

    /**
     * Tag to identify which triggered the event
     */
    String mTag;
    /**
     * Holds the dialog fragment associated with this event
     */
    DialogFragment mDialogFragment;

    public CfwNoticeDialogNegativeEvent(String tag, DialogFragment dialogFragment ) {
        mTag = tag;
        mDialogFragment = dialogFragment;
    }

    /**
     * @return Tag to identify which triggered the event
     */
    public String getTag() {
        return mTag;
    }

    /**
     * @return Dialog fragment associated with this event
     */
    public DialogFragment getDialogFragment() {
        return mDialogFragment;
    }
}
