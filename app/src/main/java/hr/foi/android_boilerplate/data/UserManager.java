package hr.foi.android_boilerplate.data;


import hr.foi.android_boilerplate.api.RestService;
import hr.foi.android_boilerplate.base.BaseManager;
import hr.foi.android_boilerplate.data.models.User;
import io.reactivex.Observable;

/**
 * Created by Antonio Martinović on 02.03.17.
 */

public class UserManager extends BaseManager<Integer, User> {

    private final RestService restService;

    public UserManager(RestService restService) {
        this.restService = restService;
    }

    public Observable<String> getData() {
       return Observable.just("Hi, my name is [placeholder]");
   }
}
