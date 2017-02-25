package hr.foi.android_boilerplate.data;

import io.reactivex.Observable;

/**
 * Created by Antonio Martinović on 25.02.17.
 */

public class DummyManager {

    private final String NAME;

    public DummyManager(String name) {
        NAME = name;
    }

    public Observable<String> getData() {
        return Observable.just("Hi, my name is " + NAME);
    }
}
