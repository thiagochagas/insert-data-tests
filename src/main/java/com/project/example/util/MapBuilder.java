package com.project.example.util;

import java.util.HashMap;
import java.util.Map;

public class MapBuilder<T, V> {
    private Map<T, V> map = new HashMap<>();

    public MapBuilder() {}

    public MapBuilder(T key, V value) {
        with(key, value);
    }

    public MapBuilder<T, V> with(T key, V value) {
        map.put(key, value);
        return this;
    }

    public Map<T, V> build() {
        return map;
    }

    public static <T, V> Map<T, V> empty() {
        return new HashMap<>();
    }
}