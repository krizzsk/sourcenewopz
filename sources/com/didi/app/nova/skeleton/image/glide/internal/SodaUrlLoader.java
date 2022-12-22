package com.didi.app.nova.skeleton.image.glide.internal;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.signature.ObjectKey;
import java.io.InputStream;

public class SodaUrlLoader implements ModelLoader<SodaUrl, InputStream> {

    /* renamed from: a */
    private final ModelCache<SodaUrl, SodaUrl> f8478a;

    public boolean handles(SodaUrl sodaUrl) {
        return true;
    }

    public ModelLoader.LoadData<InputStream> buildLoadData(SodaUrl sodaUrl, int i, int i2, Options options) {
        SodaUrl sodaUrl2;
        ModelCache<SodaUrl, SodaUrl> modelCache = this.f8478a;
        if (modelCache != null) {
            sodaUrl2 = modelCache.get(sodaUrl, 0, 0);
            if (sodaUrl2 == null) {
                this.f8478a.put(sodaUrl, 0, 0, sodaUrl);
            }
            return new ModelLoader.LoadData<>(new ObjectKey(sodaUrl.getResizeUrl().getCacheKey()), new SodaUrlFetcher(sodaUrl2));
        }
        sodaUrl2 = sodaUrl;
        return new ModelLoader.LoadData<>(new ObjectKey(sodaUrl.getResizeUrl().getCacheKey()), new SodaUrlFetcher(sodaUrl2));
    }

    public static class Factory implements ModelLoaderFactory<SodaUrl, InputStream> {
        private final ModelCache<SodaUrl, SodaUrl> modelCache = new ModelCache<>(500);

        public void teardown() {
        }

        public ModelLoader<SodaUrl, InputStream> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new SodaUrlLoader(this.modelCache);
        }
    }

    public SodaUrlLoader() {
        this((ModelCache<SodaUrl, SodaUrl>) null);
    }

    public SodaUrlLoader(ModelCache<SodaUrl, SodaUrl> modelCache) {
        this.f8478a = modelCache;
    }
}
