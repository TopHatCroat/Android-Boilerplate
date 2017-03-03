package hr.foi.android_boilerplate.injection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Antonio Martinović on 01.03.17.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface UserScope {
}
