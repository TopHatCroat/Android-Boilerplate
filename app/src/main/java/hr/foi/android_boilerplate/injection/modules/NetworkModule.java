package hr.foi.android_boilerplate.injection.modules;

import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import hr.foi.android_boilerplate.BuildConfig;
import hr.foi.android_boilerplate.MainApplication;
import hr.foi.android_boilerplate.api.RestService;
import hr.foi.android_boilerplate.data.UserManager;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Antonio Martinović on 21.02.17.
 */

@Module
public class NetworkModule {

    private static final String API_ENDPOINT = "http://www.example.com";

    @Provides
    @Singleton
    public UserManager dummyManager(RestService restService) {
        return new UserManager(restService);
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient() {
        final OkHttpClient.Builder builder = new OkHttpClient.Builder();

        if(BuildConfig.DEBUG_LOG) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(httpLoggingInterceptor);
        }

        builder.connectTimeout(60 * 1000, TimeUnit.MILLISECONDS).readTimeout(60 * 1000, TimeUnit.MILLISECONDS);

        return builder.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRestAdapter(MainApplication mainApplication, OkHttpClient okHttpClient) {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.client(okHttpClient).baseUrl(API_ENDPOINT)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());
        return builder.build();
    }

    @Provides
    @Singleton
    public RestService provideRestService(Retrofit restAdapter) {
        return restAdapter.create(RestService.class);
    }
}
