package hr.foi.android_boilerplate.injection;

import android.support.annotation.NonNull;

import dagger.Subcomponent;
import hr.foi.android_boilerplate.MainActivity;
import hr.foi.android_boilerplate.injection.modules.BasicModule;

/**
 * Created by Antonio Martinović on 21.02.17.
 */

@ActivityScope
@Subcomponent(modules = {
        BasicModule.class
})
public interface MainActivityComponent {

    @NonNull
    MainActivity inject(MainActivity mainActivity);
}
