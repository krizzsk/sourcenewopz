package com.didi.app.nova.skeleton.image.glide.internal;

import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.didi.app.nova.skeleton.image.FitType;
import com.didi.app.nova.skeleton.image.glide.FitUri;
import java.io.InputStream;

public class DiFitUriLoader implements ModelLoader<FitUri, InputStream> {

    /* renamed from: a */
    static final FitSize[] f8464a = {FitSize.SIZE_240_180, FitSize.SIZE_320_240, FitSize.SIZE_480_360, FitSize.SIZE_960_720};

    /* renamed from: b */
    static final FitSize[] f8465b = {FitSize.SIZE_240_240, FitSize.SIZE_320_320, FitSize.SIZE_480_480, FitSize.SIZE_960_960};

    /* renamed from: c */
    private final ModelLoader<Uri, InputStream> f8466c;

    /* renamed from: d */
    private final ModelLoader<SodaUrl, InputStream> f8467d;

    public boolean handles(FitUri fitUri) {
        return true;
    }

    public DiFitUriLoader(ModelLoader<SodaUrl, InputStream> modelLoader, ModelLoader<Uri, InputStream> modelLoader2) {
        this.f8467d = modelLoader;
        this.f8466c = modelLoader2;
    }

    public ModelLoader.LoadData<InputStream> buildLoadData(FitUri fitUri, int i, int i2, Options options) {
        if (fitUri.fitType == null || fitUri.fitType == FitType.FIT_None) {
            return this.f8466c.buildLoadData(fitUri.uri, i, i2, options);
        }
        String scheme = fitUri.uri.getScheme();
        if (!"http".equals(scheme) && !"https".equals(scheme)) {
            return this.f8466c.buildLoadData(fitUri.uri, i, i2, options);
        }
        FitSize a = m5672a(fitUri.fitType == FitType.FIT_4_3 ? f8464a : f8465b, i, i2);
        if (a != null) {
            return this.f8467d.buildLoadData(new SodaUrl(fitUri.uri, a), i, i2, options);
        }
        return this.f8466c.buildLoadData(fitUri.uri, i, i2, options);
    }

    /* renamed from: a */
    static FitSize m5672a(FitSize[] fitSizeArr, int i, int i2) {
        FitSize fitSize = null;
        for (int i3 = 0; i3 < fitSizeArr.length; i3++) {
            fitSize = fitSizeArr[i3];
            if (i <= fitSizeArr[i3].width() || i2 <= fitSizeArr[i3].height()) {
                break;
            }
        }
        return fitSize;
    }

    public static class Factory implements ModelLoaderFactory<FitUri, InputStream> {
        public void teardown() {
        }

        public ModelLoader<FitUri, InputStream> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new DiFitUriLoader(multiModelLoaderFactory.build(SodaUrl.class, InputStream.class), multiModelLoaderFactory.build(Uri.class, InputStream.class));
        }
    }

    enum FitSize {
        SIZE_240_180(240, 180),
        SIZE_320_240(320, 240),
        SIZE_480_360(480, 360),
        SIZE_960_720(960, 720),
        SIZE_240_240(240, 240),
        SIZE_320_320(320, 320),
        SIZE_480_480(480, 480),
        SIZE_960_960(960, 960);
        
        private int height;
        private int width;

        private FitSize(int i, int i2) {
            this.width = i;
            this.height = i2;
        }

        public int width() {
            return this.width;
        }

        public int height() {
            return this.height;
        }
    }

    public static boolean isEqualsSize(FitSize fitSize, FitSize fitSize2) {
        if (fitSize == null && fitSize2 == null) {
            return true;
        }
        return fitSize != null && fitSize2 != null && fitSize.width() == fitSize2.width() && fitSize.height() == fitSize2.height();
    }
}
