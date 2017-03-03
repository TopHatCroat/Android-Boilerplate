package hr.foi.android_boilerplate.injection;

import android.support.annotation.NonNull;

import dagger.Subcomponent;
import hr.foi.android_boilerplate.api.RestService;
import hr.foi.android_boilerplate.injection.modules.BasicModule;
import hr.foi.android_boilerplate.injection.modules.UserModule;
import hr.foi.android_boilerplate.places.main.MainActivity;

/**
 * Created by Antonio Martinović on 01.03.17.
 */
@UserScope
@Subcomponent(modules = {
        UserModule.class,
        BasicModule.class,
})
public interface UserComponent {

    @NonNull
    void inject(MainActivity mainActivity);

    RestService getRestService();

}
