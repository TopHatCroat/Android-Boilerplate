package hr.foi.android_boilerplate.places.login;

import android.widget.TextView;

import javax.inject.Inject;
import butterknife.BindView;
import butterknife.OnClick;

import hr.foi.android_boilerplate.MainApplication;
import hr.foi.android_boilerplate.R;
import hr.foi.android_boilerplate.base.BaseActivity;
import hr.foi.android_boilerplate.data.models.User;
import hr.foi.android_boilerplate.injection.modules.UserModule;
import hr.foi.android_boilerplate.places.main.MainActivity;

/**
 * Created by Antonio Martinović on 01.03.17.
 */

public class LoginActivity extends BaseActivity {
    @Inject
    LoginPresenter presenter;

    @BindView(R.id.username_input_login)
    TextView usernameInput;

    @BindView(R.id.password_input_login)
    TextView passwordInput;

    @Override
    protected void onResume() {
        super.onResume();
        presenter.attachView(this);

    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.detachView();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void setupActivityComponent() {
        MainApplication
                .getApplicationComponent()
                .inject(this);
    }

    public void onLoginSuccess() {
        MainApplication.setUserComponent(
                new UserModule(new User(
                        usernameInput.getText().toString(),
                        passwordInput.getText().toString()
                )));

        MainActivity.start(this);
    }

    @OnClick(R.id.login_button_login)
    public void onLoginButtonClicked() {
        presenter.tryLogin(usernameInput.getText().toString(), passwordInput.getText().toString());
    }
}
