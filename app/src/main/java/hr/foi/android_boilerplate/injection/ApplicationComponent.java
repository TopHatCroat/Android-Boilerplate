package hr.foi.android_boilerplate.injection;

import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Component;
import hr.foi.android_boilerplate.data.DummyManager;
import hr.foi.android_boilerplate.injection.modules.ApplicationModule;
import hr.foi.android_boilerplate.injection.modules.BasicModule;
import hr.foi.android_boilerplate.injection.modules.NetworkModule;
import hr.foi.android_boilerplate.injection.modules.UserModule;
import hr.foi.android_boilerplate.places.login.LoginActivity;

/**
 * Created by Antonio Martinović on 21.02.17.
 */
@Singleton
@Component(modules = {
        ApplicationModule.class,
        NetworkModule.class
})
public interface ApplicationComponent {

    @NonNull
    UserComponent plus(UserModule userModule);

    DummyManager getDummyManager();

    void inject(BasicModule basicModule);
}
