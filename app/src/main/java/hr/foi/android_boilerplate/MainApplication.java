package hr.foi.android_boilerplate;

import android.app.Application;
import android.content.Context;
import android.os.StrictMode;

import hr.foi.android_boilerplate.injection.ApplicationComponent;
import hr.foi.android_boilerplate.injection.DaggerApplicationComponent;
import hr.foi.android_boilerplate.injection.modules.ApplicationModule;
import timber.log.Timber;

/**
 * Created by Antonio Martinović on 21.02.17.
 */
public class MainApplication extends Application {
    ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        if(BuildConfig.DEBUG_LOG) {
            Timber.plant(new Timber.DebugTree());
        }

        if(BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .penaltyDeath()
                    .build());
        }

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
