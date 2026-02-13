package org.example.minionsapi.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CacheManager {

    private static CacheManager instance;

    private final Map<String, Object> cache;

    private CacheManager() {
        cache = new ConcurrentHashMap<>();
    }

    public static synchronized CacheManager getInstance() {
        if (instance == null) {
            instance = new CacheManager();
        }
        return instance;
    }

    public <T> T get(String key) {
        return (T) cache.get(key);
    }

    public void put(String key, Object value) {
        cache.put(key, value);
    }

    public boolean contains(String key) {
        return cache.containsKey(key);
    }

    public void remove(String key) {
        cache.remove(key);
    }

    public void clear() {
        cache.clear();
    }
}
