package hr.foi.android_boilerplate.injection.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hr.foi.android_boilerplate.data.DummyManager;

/**
 * Created by Antonio Martinović on 21.02.17.
 */
@Module
public class NetworkModule {

    @Provides
    @Singleton
    public DummyManager dummyManager() {
        return new DummyManager("DUMMY");
    }
}
