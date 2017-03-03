package hr.foi.android_boilerplate.base;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

/**
 * Created by Antonio Martinović on 03.03.17.
 */

public abstract class BaseManager<K, V> {
    private final Cache<K, V> cache;
    protected final int MAX_SIZE = 100;
    protected final int EXPIRATION_DURATION = 30;

    protected BaseManager() {
        cache = CacheBuilder
                .newBuilder()
                .maximumSize(MAX_SIZE)
                .expireAfterWrite(EXPIRATION_DURATION, TimeUnit.MINUTES)
                .build();
    }

    protected Cache getCache() {
        return cache;
    }
}
