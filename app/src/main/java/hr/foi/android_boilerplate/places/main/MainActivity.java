package hr.foi.android_boilerplate.places.main;

import android.app.Activity;
import android.content.Intent;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import hr.foi.android_boilerplate.MainApplication;
import hr.foi.android_boilerplate.R;
import hr.foi.android_boilerplate.base.BaseActivity;

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
                .getUserComponent()
                .inject(this);
    }

    public void showDummyData(String value) {
        textView = (TextView) findViewById(R.id.text_main_activity);
        textView.setText(value);
    }

    public static void start(Activity startingActivity) {
        Intent intent = new Intent(startingActivity, MainActivity.class);
        startingActivity.startActivity(intent);
    }
}
