package hr.foi.android_boilerplate.data;

import hr.foi.android_boilerplate.base.BaseManager;
import io.reactivex.Observable;

/**
 * Created by Antonio Martinović on 25.02.17.
 */

public class DummyManager extends BaseManager<Integer, String> {

    private final String NAME;

    public DummyManager(String name) {
        NAME = name;

        dummyInit();
    }

    private void dummyInit() {

    }

    public Observable<String> getData() {
        return Observable.just("Hi, my name is " + NAME);
    }
}
