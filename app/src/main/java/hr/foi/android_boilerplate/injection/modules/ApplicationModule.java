package hr.foi.android_boilerplate.injection.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hr.foi.android_boilerplate.MainApplication;

/**
 * Created by Antonio Martinović on 21.02.17.
 */
@Module
public class ApplicationModule {
    protected final MainApplication mainApplication;

    public ApplicationModule(MainApplication mainApplication) {
        this.mainApplication = mainApplication;
    }

    @Singleton
    @Provides
    public MainApplication getMainApplication() {
        return mainApplication;
    }
}
