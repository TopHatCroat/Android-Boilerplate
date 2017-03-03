package hr.foi.android_boilerplate.places.login;

import android.os.Bundle;
import android.widget.TextView;

import com.google.common.base.Strings;

import javax.inject.Inject;
import butterknife.BindView;

import butterknife.OnClick;
import hr.foi.android_boilerplate.MainApplication;
import hr.foi.android_boilerplate.R;
import hr.foi.android_boilerplate.base.BaseActivity;
import hr.foi.android_boilerplate.data.UserManager;
import hr.foi.android_boilerplate.data.models.User;
import hr.foi.android_boilerplate.injection.modules.BasicModule;
import hr.foi.android_boilerplate.injection.modules.UserModule;
import hr.foi.android_boilerplate.places.main.MainActivity;

/**
 * Created by Antonio Martinović on 01.03.17.
 */

public class LoginActivity extends BaseActivity {

    @Inject
    UserManager userManager;

    @BindView(R.id.username_input_login)
    TextView usernameInput;

    @BindView(R.id.password_input_login)
    TextView passwordInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void setupActivityComponent() {
        MainApplication
                .getApplicationComponent()
                .inject(new BasicModule(this));
    }

    @OnClick(R.id.login_button_login)
    public void onLoginButtonClicked() {
        if(Strings.isNullOrEmpty(usernameInput.getText().toString())) {
            showBasicError("Username must not be empty");
            return;
        }

        if(Strings.isNullOrEmpty(passwordInput.getText().toString())) {
            showBasicError("Password must not be empty");
            return;
        }

        MainApplication.setUserComponent(
                new UserModule(new User(
                        usernameInput.getText().toString(),
                        passwordInput.getText().toString()
        )));

        MainActivity.start(this);
    }

}
