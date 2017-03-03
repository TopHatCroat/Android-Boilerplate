package hr.foi.android_boilerplate.api;

import hr.foi.android_boilerplate.api.responses.UserResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Antonio Martinović on 03.03.17.
 */

public interface RestService {
    @GET("users")
    Observable<UserResponse> getUserById(@Query("id") Integer id);
}
