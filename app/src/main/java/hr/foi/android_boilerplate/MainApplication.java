package hr.foi.android_boilerplate;

import android.app.Application;
import android.content.Context;

import hr.foi.android_boilerplate.injection.ApplicationComponent;
import hr.foi.android_boilerplate.injection.DaggerApplicationComponent;
import hr.foi.android_boilerplate.injection.modules.ApplicationModule;

/**
 * Created by Antonio Martinović on 21.02.17.
 */
public class MainApplication extends Application {
    ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        getApplicationComponent();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public static MainApplication get(Context context) {
        return (MainApplication) context.getApplicationContext();
    }

    public ApplicationComponent getApplicationComponent() {
        if (applicationComponent == null) {
            applicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .build();
        }
        return applicationComponent;
    }
}
