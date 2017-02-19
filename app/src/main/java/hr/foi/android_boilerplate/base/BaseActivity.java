package hr.foi.android_boilerplate.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import hr.foi.android_boilerplate.R;

/**
 * Base activity that every class should extend, it handles basic UI components
 * like the toolbar and base layout, as well as calls methods for setting the content view,
 * Butter Knife binding and constructing DI graph
 * Created by Antonio Martinović on 12.10.16.
 */

public abstract class BaseActivity extends AppCompatActivity implements ViewLayer {
    protected Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setupActivityComponent();
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        unbinder = ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    /**
     * Specify wich layout should be inflated for the activity
     * @return layout resource ID
     */
    protected abstract int getLayout();

    /**
     * Activity should put define DI graph genrating
     * code by overriding this method
     */
    protected abstract void setupActivityComponent();

    /**
     * Displays a short error message to the user
     * by using a Snackbar
     * @param message error message to display
     */
    @Override
    public void showBasicError(String message) {
//        Snackbar.make(coordinatorLayout, message, Snackbar.LENGTH_LONG).show();
    }

    @Nullable
    public Toolbar getToolbar() {
        return null;
    }
}
