package com.nerubia.cfw.modules.login;

import android.support.annotation.NonNull;

/**
 * Created by meldy on 11/06/2015.
 */

/**
 * Contain common classes to be used for a login flow
 */
public interface ICfwLoginPresenter {

    public void validateCredentials(@NonNull String email, @NonNull String password);

}
