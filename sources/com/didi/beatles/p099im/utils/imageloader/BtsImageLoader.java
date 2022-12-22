package com.didi.beatles.p099im.utils.imageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.didi.beatles.p099im.IMCommonContextInfoHelper;
import com.didi.beatles.p099im.utils.IMLog;
import com.didichuxing.foundation.spi.ServiceLoader;

/* renamed from: com.didi.beatles.im.utils.imageloader.BtsImageLoader */
public final class BtsImageLoader implements IBtsImageLoader {

    /* renamed from: a */
    private static BtsImageLoader f9831a;

    /* renamed from: b */
    private IBtsImageLoader f9832b;

    public static BtsImageLoader getInstance() {
        if (f9831a == null) {
            synchronized (BtsImageLoader.class) {
                if (f9831a == null) {
                    f9831a = new BtsImageLoader();
                }
            }
        }
        f9831a.with(IMCommonContextInfoHelper.getContext());
        return f9831a;
    }

    public BtsImageLoader() {
        IBtsImageLoader iBtsImageLoader = (IBtsImageLoader) ServiceLoader.load(IBtsImageLoader.class).iterator().next();
        this.f9832b = iBtsImageLoader;
        if (iBtsImageLoader == null) {
            IMLog.m6632e("IMImageLoader", "init fail not found IBtsImageLoader spi");
            this.f9832b = IBtsImageLoader.empty;
        }
    }

    public IBtsImageLoader with(Context context) {
        this.f9832b.with(context);
        return f9831a;
    }

    public void loadInto(Object obj, View view) {
        this.f9832b.loadInto(obj, view);
    }

    public void loadInto(Object obj, View view, Drawable drawable) {
        this.f9832b.loadInto(obj, view, drawable);
    }

    public void loadInto(Object obj, View view, int i) {
        this.f9832b.loadInto(obj, view, i);
    }

    public void loadInto(Object obj, View view, Callback callback) {
        this.f9832b.loadInto(obj, view, callback);
    }

    public void loadIntoAsGif(Object obj, View view, Callback callback) {
        this.f9832b.loadIntoAsGif(obj, view, callback);
    }

    public void loadIntoAsGif(Object obj, View view, int i, Callback callback) {
        this.f9832b.loadIntoAsGif(obj, view, i, callback);
    }

    public void loadRoundInto(Object obj, View view, int i) {
        this.f9832b.loadRoundInto(obj, view, i);
    }

    public void loadRoundInto(Object obj, View view) {
        this.f9832b.loadRoundInto(obj, view);
    }

    public void loadRoundInto(Object obj, int i, View view) {
        this.f9832b.loadRoundInto(obj, i, view);
    }

    public Object download(String str, Callback callback) {
        return this.f9832b.download(str, callback);
    }

    public Object download(String str, int i, int i2, Callback callback) {
        return this.f9832b.download(str, i, i2, callback);
    }

    public void loadInto(Object obj, View view, Animator animator, IMImageRequestOptions iMImageRequestOptions, Callback callback) {
        this.f9832b.loadInto(obj, view, animator, iMImageRequestOptions, callback);
    }

    public Object download(String str, int i, int i2, IMImageRequestOptions iMImageRequestOptions, Callback callback) {
        return this.f9832b.download(str, i, i2, iMImageRequestOptions, callback);
    }

    public void cancel(Object obj) {
        this.f9832b.cancel(obj);
    }

    public void clearMemory() {
        this.f9832b.clearMemory();
    }

    public static Callback getEmptyCallback() {
        return new Callback() {
            public void onFailed() {
            }

            public void onStart() {
            }

            public void onSuccess(Bitmap bitmap) {
            }
        };
    }
}
