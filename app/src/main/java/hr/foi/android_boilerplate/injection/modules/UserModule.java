package hr.foi.android_boilerplate.injection.modules;

import dagger.Module;
import dagger.Provides;
import hr.foi.android_boilerplate.data.models.User;
import hr.foi.android_boilerplate.injection.UserScope;

/**
 * Created by Antonio Martinović on 03.03.17.
 */
@Module
public class UserModule {
    private final User user;

    public UserModule(User user) {
        this.user = user;
    }

    @Provides
    @UserScope
    User getUser() {
        return user;
    }
}
