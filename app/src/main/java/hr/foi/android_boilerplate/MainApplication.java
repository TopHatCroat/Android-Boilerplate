package hr.foi.android_boilerplate;

import android.app.Application;
import android.content.Context;
import android.os.StrictMode;

import hr.foi.android_boilerplate.injection.ApplicationComponent;
import hr.foi.android_boilerplate.injection.DaggerApplicationComponent;
import hr.foi.android_boilerplate.injection.UserComponent;
import hr.foi.android_boilerplate.injection.modules.ApplicationModule;
import hr.foi.android_boilerplate.injection.modules.NetworkModule;
import hr.foi.android_boilerplate.injection.modules.UserModule;
import timber.log.Timber;

/**
 * Created by Antonio Martinović on 21.02.17.
 */
public class MainApplication extends Application {
    private static ApplicationComponent applicationComponent;
    private static UserComponent userComponent;

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

        initializeInjection();
    }

    private void initializeInjection() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .networkModule(new NetworkModule())
                .build();

    }

    public static void setUserComponent(UserModule userModule) {
        userComponent = applicationComponent.plus(userModule);
    }

    public static UserComponent getUserComponent() {
        return userComponent;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public static MainApplication get(Context context) {
        return (MainApplication) context.getApplicationContext();
    }

    public static ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }


}
