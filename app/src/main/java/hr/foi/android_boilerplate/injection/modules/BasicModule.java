package hr.foi.android_boilerplate.injection.modules;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;
import hr.foi.android_boilerplate.injection.ActivityScope;

/**
 * Created by Antonio Martinović on 21.02.17.
 */
@Module
public class BasicModule {
    protected final Activity activity;

    public BasicModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    public Activity getActivity() {
        return activity;
    }
}
