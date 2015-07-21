package com.nerubia.cfw.view;

/**
 * Created by meldy on 11/06/2015.
 */

import com.nerubia.cfw.utils.CfwCallback;

/**
 * Contains the methods/functions common to most
 * login modules of applications
 */
public interface ICfwLoginView extends ICfwView{


    public void showInvalidEmailError();

    public void showInvalidPasswordError();

    public void showLoginSuccessful();

}
