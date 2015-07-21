package com.nerubia.cfw.modules.login;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.nerubia.cfw.activity.CfwActivity;

/**
 * Created by meldy on 11/06/2015.
 */

/**
 * Contains the common components needed for a Login module
 */
public abstract class CfwLoginActivity extends CfwActivity implements View.OnClickListener{

    protected EditText mEtEmail;
    protected EditText mEtPassword;
    protected Button mBtnLogin;

}
