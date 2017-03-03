package hr.foi.android_boilerplate.places.login;

import com.google.common.base.Strings;

import javax.inject.Inject;

import hr.foi.android_boilerplate.base.BasePresenter;
import hr.foi.android_boilerplate.data.UserManager;

/**
 * Created by Antonio Martinović on 02.03.17.
 */

public class LoginPresenter extends BasePresenter<LoginActivity> {

    private final UserManager userManager;

    @Inject
    public LoginPresenter(UserManager userManager) {
        this.userManager = userManager;
    }

    void tryLogin(String username, String password) {
        if(Strings.isNullOrEmpty(username)) {
            getViewLayer().showBasicError("Username must not be empty");
            return;
        }

        if(Strings.isNullOrEmpty(password)) {
            getViewLayer().showBasicError("Password must not be empty");
            return;
        }

        getViewLayer().onLoginSuccess();
    }

}
