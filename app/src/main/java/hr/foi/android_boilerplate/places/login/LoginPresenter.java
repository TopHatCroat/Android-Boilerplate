package hr.foi.android_boilerplate.places.login;

import javax.inject.Inject;

import hr.foi.android_boilerplate.base.BasePresenter;
import hr.foi.android_boilerplate.data.UserManager;

/**
 * Created by Antonio Martinović on 02.03.17.
 */

public class LoginPresenter extends BasePresenter<LoginActivity> {

    @Inject
    UserManager userManager;

    @Inject
    public LoginPresenter() {

    }

}
