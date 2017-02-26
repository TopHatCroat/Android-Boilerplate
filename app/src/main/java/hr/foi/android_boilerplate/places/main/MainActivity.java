package hr.foi.android_boilerplate.places.main;

import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import hr.foi.android_boilerplate.MainApplication;
import hr.foi.android_boilerplate.R;
import hr.foi.android_boilerplate.base.BaseActivity;
import hr.foi.android_boilerplate.injection.modules.BasicModule;

public class MainActivity extends BaseActivity {

    @Inject
    MainPresenter mainPresenter;

    @BindView(R.id.text_main_activity)
    TextView textView;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainPresenter.attachView(this);

        mainPresenter.loadDummyData();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mainPresenter.detachView();
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
        textView = (TextView) findViewById(R.id.text_main_activity);
        textView.setText(value);
    }
}
