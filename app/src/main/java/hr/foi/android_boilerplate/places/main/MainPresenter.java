package hr.foi.android_boilerplate.places.main;

import javax.inject.Inject;

import hr.foi.android_boilerplate.base.BasePresenter;
import hr.foi.android_boilerplate.data.UserManager;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Antonio Martinović on 25.02.17.
 */

public class MainPresenter extends BasePresenter<MainActivity> {

    private final UserManager userManager;

    @Inject
    public MainPresenter(UserManager userManager) {
        this.userManager = userManager;
    }

    public void loadDummyData() {
        checkViewAttached();

        Observer<String> dummyObserver = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {}

            @Override
            public void onNext(String value) {
                getViewLayer().showDummyData(value);
            }

            @Override
            public void onError(Throwable e) {
                getViewLayer().showBasicError(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        };

        Observable<String> dummyStream = userManager.getData();
        dummyStream.subscribe(dummyObserver);
    }

}
