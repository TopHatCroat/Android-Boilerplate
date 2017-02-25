package hr.foi.android_boilerplate.places.main;

import android.os.Bundle;

import javax.inject.Inject;

import hr.foi.android_boilerplate.MainApplication;
import hr.foi.android_boilerplate.R;
import hr.foi.android_boilerplate.base.BaseActivity;
import hr.foi.android_boilerplate.injection.modules.BasicModule;

public class MainActivity extends BaseActivity {

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void setupActivityComponent() {
        MainApplication
                .get(this)
                .getApplicationComponent()
                .inject(new BasicModule(this))
                .inject(this);
    }

    public void showDummyData(String value) {
        //TODO
    }
}
