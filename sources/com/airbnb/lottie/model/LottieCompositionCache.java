package com.airbnb.lottie.model;

import androidx.collection.LruCache;
import com.airbnb.lottie.LottieComposition;

public class LottieCompositionCache {

    /* renamed from: a */
    private static final LottieCompositionCache f1383a = new LottieCompositionCache();

    /* renamed from: b */
    private final LruCache<String, LottieComposition> f1384b = new LruCache<>(20);

    public static LottieCompositionCache getInstance() {
        return f1383a;
    }

    LottieCompositionCache() {
    }

    public LottieComposition get(String str) {
        if (str == null) {
            return null;
        }
        return this.f1384b.get(str);
    }

    public void put(String str, LottieComposition lottieComposition) {
        if (str != null) {
            this.f1384b.put(str, lottieComposition);
        }
    }

    public void clear() {
        this.f1384b.evictAll();
    }

    public void resize(int i) {
        this.f1384b.resize(i);
    }
}
