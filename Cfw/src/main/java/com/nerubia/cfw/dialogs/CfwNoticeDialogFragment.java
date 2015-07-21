package com.nerubia.cfw.dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;

import com.nerubia.cfw.events.noticedialog.CfwNoticeDialogPositiveEvent;

import de.greenrobot.event.EventBus;

/**
 * Created by meldy on 01/06/2015.
 */

/**
 * Using dialog fragments are better compared to pure dialogs.
 * Dialog fragments handles configuration changes like orientation
 * changes.
 */
public class CfwNoticeDialogFragment extends DialogFragment{

    // parameters to set as bundle keys
    public static final String ARG_DIALOG_TITLE        = "dialog_title";
    public static final String ARG_DIALOG_MESSAGE_ID   = "dialog_message_id";
    public static final String ARG_DIALOG_MESSAGE_STR   = "dialog_message_STR";
    public static final String ARG_DIALOG_POSITIVE_BTN = "dialog_positive_btn";
    public static final String ARG_DIALOG_NEGATIVE_BTN = "dialog_negative_btn";
    public static final String ARG_DIALOG_TAG          = "dialog_tag";

    /**
     * Use tag to determine which classes/events called the dialog
     */
    private String mTag;

    /**
     * Creates a new instance of this class with required bundle data
     *
     * @param title string id of the text to be used as dialog title
     * @param message string id of the text to be used as dialog message
     * @param positiveBtnTxt string id of the text to be used as positive button label
     * @param negativeBtnTxt string id of the text to be used as negative button label
     * @param tag tag to determine which classes/events called the dialog
     * @return new CfwNoticeDialogFragment instance
     */
    public static CfwNoticeDialogFragment newInstance(int title, int message, int positiveBtnTxt,
                                                       int negativeBtnTxt, String tag) {
        CfwNoticeDialogFragment fragment = new CfwNoticeDialogFragment();

        Bundle args = new Bundle();
        args.putInt(ARG_DIALOG_TITLE, title);
        args.putInt(ARG_DIALOG_MESSAGE_ID, message);
        args.putInt(ARG_DIALOG_POSITIVE_BTN, positiveBtnTxt);
        args.putInt(ARG_DIALOG_NEGATIVE_BTN, negativeBtnTxt);
        args.putString(ARG_DIALOG_TAG, tag);

        fragment.setArguments(args);
        return fragment;
    }

    public static CfwNoticeDialogFragment newInstance(int title, String message, int positiveBtnTxt,
                                                      int negativeBtnTxt, String tag) {
        CfwNoticeDialogFragment fragment = new CfwNoticeDialogFragment();

        Bundle args = new Bundle();
        args.putInt(ARG_DIALOG_TITLE, title);
        args.putString(ARG_DIALOG_MESSAGE_STR, message);
        args.putInt(ARG_DIALOG_POSITIVE_BTN, positiveBtnTxt);
        args.putInt(ARG_DIALOG_NEGATIVE_BTN, negativeBtnTxt);
        args.putString(ARG_DIALOG_TAG, tag);

        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Inherited method to create the dialog
     */
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        int title = getArguments().getInt(ARG_DIALOG_TITLE, -1);
        int message = getArguments().getInt(ARG_DIALOG_MESSAGE_ID, -1);
        String strMessage = getArguments().getString(ARG_DIALOG_MESSAGE_STR);
        int positiveBtn = getArguments().getInt(ARG_DIALOG_POSITIVE_BTN, -1);
        positiveBtn = positiveBtn != -1 ? positiveBtn : android.R.string.ok;
        int negativeBtn = getArguments().getInt(ARG_DIALOG_NEGATIVE_BTN, -1);
        mTag = getArguments().getString(ARG_DIALOG_TAG);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setPositiveButton(positiveBtn,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                EventBus.getDefault().post(new CfwNoticeDialogPositiveEvent(mTag, CfwNoticeDialogFragment.this));
                            }
                        }
                );

        if(title != -1) {
            builder.setTitle(title);
        }
        if(message != -1){
            builder.setMessage(message);
        } else if(!TextUtils.isEmpty(strMessage)){
            builder.setMessage(strMessage);
        }

        if(negativeBtn != -1){
            builder.setNegativeButton(negativeBtn,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {

                    }
                }
            );
        }
        return builder.create();
    }

}
