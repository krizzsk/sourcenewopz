package com.didi.beatles.p099im.glide4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.GenericTransitionOptions;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.request.transition.ViewPropertyTransition;
import com.didi.beatles.p099im.IMCmLoader;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.beatles.p099im.utils.imageloader.Animator;
import com.didi.beatles.p099im.utils.imageloader.BtsImageLoader;
import com.didi.beatles.p099im.utils.imageloader.Callback;
import com.didi.beatles.p099im.utils.imageloader.IBtsImageLoader;
import com.didi.beatles.p099im.utils.imageloader.IMImageRequestOptions;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.io.File;

@ServiceProvider({IBtsImageLoader.class})
/* renamed from: com.didi.beatles.im.glide4.BtsImageLoaderGlideModule */
public final class BtsImageLoaderGlideModule implements IBtsImageLoader {

    /* renamed from: a */
    private static final String f9216a = BtsImageLoaderGlideModule.class.getSimpleName();

    /* renamed from: b */
    private RequestManager f9217b;

    /* renamed from: c */
    private Context f9218c;

    public void cancel(Object obj) {
    }

    public IBtsImageLoader with(Context context) {
        try {
            this.f9217b = Glide.with(context);
        } catch (Exception e) {
            IMLog.m6632e(f9216a, e);
        }
        this.f9218c = context;
        return this;
    }

    public void loadInto(Object obj, View view) {
        if (m6233a(view)) {
            if (view instanceof ImageView) {
                m6232a(obj, (Animator) null).into((ImageView) view);
            } else {
                m6236b(obj, (Animator) null).into(new BitmapViewTarget(view, (Callback) null));
            }
        }
    }

    public void loadInto(Object obj, View view, Drawable drawable) {
        if (m6233a(view)) {
            if (view instanceof ImageView) {
                ((RequestBuilder) m6232a(obj, (Animator) null).placeholder(drawable)).into((ImageView) view);
            } else {
                ((RequestBuilder) m6236b(obj, (Animator) null).placeholder(drawable)).into(new BitmapViewTarget(view, (Callback) null));
            }
        }
    }

    public void loadInto(Object obj, View view, int i) {
        if (m6233a(view)) {
            if (view instanceof ImageView) {
                ((RequestBuilder) m6232a(obj, (Animator) null).placeholder(i)).into((ImageView) view);
            } else {
                ((RequestBuilder) m6236b(obj, (Animator) null).placeholder(i)).into(new BitmapViewTarget(view, (Callback) null));
            }
        }
    }

    public void loadInto(Object obj, View view, Callback callback) {
        if (m6233a(view)) {
            if (view instanceof ImageView) {
                m6232a(obj, (Animator) null).into(new DrawableTarget((ImageView) view, callback));
            } else {
                m6236b(obj, (Animator) null).into(new BitmapViewTarget(view, callback));
            }
        }
    }

    public void loadIntoAsGif(Object obj, View view, Callback callback) {
        if (m6233a(view)) {
            if (view instanceof ImageView) {
                m6231a(obj).into(new GifTarget((ImageView) view, callback));
            } else {
                m6231a(obj).into(new GifViewTarget(view, callback));
            }
        }
    }

    public void loadIntoAsGif(Object obj, View view, int i, Callback callback) {
        if (m6233a(view)) {
            if (view instanceof ImageView) {
                ((RequestBuilder) m6231a(obj).placeholder(i)).into(new GifTarget((ImageView) view, callback));
            } else {
                ((RequestBuilder) m6231a(obj).placeholder(i)).into(new GifViewTarget(view, callback));
            }
        }
    }

    public void loadRoundInto(Object obj, View view) {
        if (m6233a(view)) {
            if (view instanceof ImageView) {
                ((RequestBuilder) m6232a(obj, (Animator) null).transform((Transformation<Bitmap>) new RoundedCorners(IMCmLoader.getInstance().getViewUtil().dp2px(this.f9218c, 4.0f)))).into((ImageView) view);
            } else {
                ((RequestBuilder) m6236b(obj, (Animator) null).transform((Transformation<Bitmap>) new RoundedCorners(IMCmLoader.getInstance().getViewUtil().dp2px(this.f9218c, 4.0f)))).into(new BitmapViewTarget(view, (Callback) null));
            }
        }
    }

    public void loadRoundInto(Object obj, int i, View view) {
        if (m6233a(view)) {
            if (view instanceof ImageView) {
                ((RequestBuilder) m6232a(obj, (Animator) null).transform((Transformation<Bitmap>) new RoundedCorners(IMCmLoader.getInstance().getViewUtil().dp2px(this.f9218c, (float) i)))).into((ImageView) view);
            } else {
                ((RequestBuilder) m6236b(obj, (Animator) null).transform((Transformation<Bitmap>) new RoundedCorners(IMCmLoader.getInstance().getViewUtil().dp2px(this.f9218c, (float) i)))).into(new BitmapViewTarget(view, (Callback) null));
            }
        }
    }

    public void loadRoundInto(Object obj, View view, int i) {
        if (m6233a(view)) {
            if (view instanceof ImageView) {
                ((RequestBuilder) ((RequestBuilder) m6232a(obj, (Animator) null).transform((Transformation<Bitmap>) new RoundedCorners(IMCmLoader.getInstance().getViewUtil().dp2px(this.f9218c, 4.0f)))).placeholder(i)).into((ImageView) view);
            } else {
                ((RequestBuilder) ((RequestBuilder) m6236b(obj, (Animator) null).transform((Transformation<Bitmap>) new RoundedCorners(IMCmLoader.getInstance().getViewUtil().dp2px(this.f9218c, 4.0f)))).placeholder(i)).into(new BitmapViewTarget(view, (Callback) null));
            }
        }
    }

    public Object download(String str, Callback callback) {
        DownloadTarget downloadTarget = new DownloadTarget(callback);
        this.f9217b.asBitmap().load(str).into(downloadTarget);
        return downloadTarget;
    }

    public Object download(String str, int i, int i2, Callback callback) {
        DownloadTarget downloadTarget = new DownloadTarget(i, i2, callback);
        this.f9217b.asBitmap().load(str).into(downloadTarget);
        return downloadTarget;
    }

    public void loadInto(Object obj, View view, Animator animator, IMImageRequestOptions iMImageRequestOptions, Callback callback) {
        if (m6233a(view)) {
            if (view instanceof ImageView) {
                RequestBuilder<Drawable> a = m6232a(obj, animator);
                m6230a(a, iMImageRequestOptions);
                a.into((ImageView) view);
                return;
            }
            RequestBuilder<Bitmap> b = m6236b(obj, animator);
            m6234b(b, iMImageRequestOptions);
            b.into(new BitmapViewTarget(view, callback));
        }
    }

    public Object download(String str, int i, int i2, IMImageRequestOptions iMImageRequestOptions, Callback callback) {
        DownloadTarget downloadTarget = new DownloadTarget(i, i2, callback);
        RequestBuilder<Bitmap> load = this.f9217b.asBitmap().load(str);
        m6234b(load, iMImageRequestOptions);
        load.into(downloadTarget);
        return downloadTarget;
    }

    public void clearMemory() {
        Context context = this.f9218c;
        if (context != null) {
            Glide.get(context).clearMemory();
        }
    }

    /* renamed from: a */
    private RequestBuilder<Drawable> m6230a(RequestBuilder<Drawable> requestBuilder, IMImageRequestOptions iMImageRequestOptions) {
        DiskCacheStrategy diskCacheStrategy;
        if (iMImageRequestOptions == null) {
            return requestBuilder;
        }
        if (iMImageRequestOptions.isValidSizeMultiplier()) {
            requestBuilder.sizeMultiplier(iMImageRequestOptions.getSizeMultiplier());
        }
        if (iMImageRequestOptions.isValidOverrideSize()) {
            requestBuilder.override(iMImageRequestOptions.getOverrideWidth(), iMImageRequestOptions.getOverrideHeight());
        }
        if (iMImageRequestOptions.isValidPlaceholderId()) {
            requestBuilder.placeholder(iMImageRequestOptions.getPlaceholderId());
        }
        DiskCacheStrategy diskCacheStrategy2 = DiskCacheStrategy.AUTOMATIC;
        if (iMImageRequestOptions.getDiskCacheStrategy() == IMImageRequestOptions.DiskCacheStrategy.ALL) {
            diskCacheStrategy = DiskCacheStrategy.ALL;
        } else if (iMImageRequestOptions.getDiskCacheStrategy() == IMImageRequestOptions.DiskCacheStrategy.NONE) {
            diskCacheStrategy = DiskCacheStrategy.NONE;
        } else if (iMImageRequestOptions.getDiskCacheStrategy() == IMImageRequestOptions.DiskCacheStrategy.DATA) {
            diskCacheStrategy = DiskCacheStrategy.DATA;
        } else if (iMImageRequestOptions.getDiskCacheStrategy() == IMImageRequestOptions.DiskCacheStrategy.RESOURCE) {
            diskCacheStrategy = DiskCacheStrategy.RESOURCE;
        } else {
            diskCacheStrategy = DiskCacheStrategy.AUTOMATIC;
        }
        requestBuilder.diskCacheStrategy(diskCacheStrategy);
        if (iMImageRequestOptions.isValidCenterCrop()) {
            requestBuilder.centerCrop();
        }
        return requestBuilder;
    }

    /* renamed from: b */
    private RequestBuilder<Bitmap> m6234b(RequestBuilder<Bitmap> requestBuilder, IMImageRequestOptions iMImageRequestOptions) {
        DiskCacheStrategy diskCacheStrategy;
        if (iMImageRequestOptions == null) {
            return requestBuilder;
        }
        if (iMImageRequestOptions.isValidSizeMultiplier()) {
            requestBuilder.sizeMultiplier(iMImageRequestOptions.getSizeMultiplier());
        }
        if (iMImageRequestOptions.isValidOverrideSize()) {
            requestBuilder.override(iMImageRequestOptions.getOverrideWidth(), iMImageRequestOptions.getOverrideHeight());
        }
        if (iMImageRequestOptions.isValidPlaceholderId()) {
            requestBuilder.placeholder(iMImageRequestOptions.getPlaceholderId());
        }
        DiskCacheStrategy diskCacheStrategy2 = DiskCacheStrategy.AUTOMATIC;
        if (iMImageRequestOptions.getDiskCacheStrategy() == IMImageRequestOptions.DiskCacheStrategy.ALL) {
            diskCacheStrategy = DiskCacheStrategy.ALL;
        } else if (iMImageRequestOptions.getDiskCacheStrategy() == IMImageRequestOptions.DiskCacheStrategy.NONE) {
            diskCacheStrategy = DiskCacheStrategy.NONE;
        } else if (iMImageRequestOptions.getDiskCacheStrategy() == IMImageRequestOptions.DiskCacheStrategy.DATA) {
            diskCacheStrategy = DiskCacheStrategy.DATA;
        } else if (iMImageRequestOptions.getDiskCacheStrategy() == IMImageRequestOptions.DiskCacheStrategy.RESOURCE) {
            diskCacheStrategy = DiskCacheStrategy.RESOURCE;
        } else {
            diskCacheStrategy = DiskCacheStrategy.AUTOMATIC;
        }
        requestBuilder.diskCacheStrategy(diskCacheStrategy);
        if (iMImageRequestOptions.isValidCenterCrop()) {
            requestBuilder.centerCrop();
        }
        return requestBuilder;
    }

    /* renamed from: a */
    private RequestBuilder<Drawable> m6232a(Object obj, Animator animator) {
        RequestBuilder<Drawable> d = m6238d(obj);
        if (animator == null) {
            return (RequestBuilder) d.dontAnimate();
        }
        return d.transition(GenericTransitionOptions.with((ViewPropertyTransition.Animator) new AnimateWrapper(animator)));
    }

    /* renamed from: b */
    private RequestBuilder<Bitmap> m6236b(Object obj, Animator animator) {
        RequestBuilder<Bitmap> c = m6237c(obj);
        if (animator == null) {
            return (RequestBuilder) c.dontAnimate();
        }
        return c.transition(GenericTransitionOptions.with((ViewPropertyTransition.Animator) new AnimateWrapper(animator)));
    }

    /* renamed from: a */
    private RequestBuilder<GifDrawable> m6231a(Object obj) {
        return m6235b(obj);
    }

    /* renamed from: b */
    private RequestBuilder<GifDrawable> m6235b(Object obj) {
        if (obj instanceof Integer) {
            return this.f9217b.asGif().load((Integer) obj);
        }
        if (obj instanceof Uri) {
            return this.f9217b.asGif().load((Uri) obj);
        }
        if (obj instanceof String) {
            return this.f9217b.asGif().load((String) obj);
        }
        if (obj instanceof File) {
            return this.f9217b.asGif().load((File) obj);
        }
        IMLog.m6632e("IM_SDK", "load image failed while the src = " + obj);
        return this.f9217b.asGif().load("null");
    }

    /* renamed from: c */
    private RequestBuilder<Bitmap> m6237c(Object obj) {
        if (obj instanceof Integer) {
            return this.f9217b.asBitmap().load((Integer) obj);
        }
        if (obj instanceof Uri) {
            return this.f9217b.asBitmap().load((Uri) obj);
        }
        if (obj instanceof String) {
            return this.f9217b.asBitmap().load((String) obj);
        }
        if (obj instanceof File) {
            return this.f9217b.asBitmap().load((File) obj);
        }
        IMLog.m6632e("IM_SDK", "load image failed while the src = " + obj);
        return this.f9217b.asBitmap().load("null");
    }

    /* renamed from: d */
    private RequestBuilder<Drawable> m6238d(Object obj) {
        if (obj instanceof Integer) {
            return this.f9217b.load((Integer) obj);
        }
        if (obj instanceof Uri) {
            return this.f9217b.load((Uri) obj);
        }
        if (obj instanceof String) {
            return this.f9217b.load((String) obj);
        }
        if (obj instanceof File) {
            return this.f9217b.load((File) obj);
        }
        IMLog.m6632e("IM_SDK", "load image failed while the src = " + obj);
        return this.f9217b.load("null");
    }

    /* renamed from: a */
    private boolean m6233a(View view) {
        return (view == null || view.getVisibility() == 8) ? false : true;
    }

    /* renamed from: com.didi.beatles.im.glide4.BtsImageLoaderGlideModule$AnimateWrapper */
    private static class AnimateWrapper implements ViewPropertyTransition.Animator {
        final Animator animator;

        public AnimateWrapper(Animator animator2) {
            this.animator = animator2;
        }

        public void animate(View view) {
            this.animator.animate(view);
        }
    }

    /* renamed from: com.didi.beatles.im.glide4.BtsImageLoaderGlideModule$DownloadTarget */
    private static class DownloadTarget extends CustomTarget<Bitmap> {

        /* renamed from: cb */
        private final Callback f9220cb;

        public void onLoadCleared(Drawable drawable) {
        }

        private DownloadTarget(Callback callback) {
            this.f9220cb = callback == null ? BtsImageLoader.getEmptyCallback() : callback;
        }

        private DownloadTarget(int i, int i2, Callback callback) {
            super(i, i2);
            this.f9220cb = callback == null ? BtsImageLoader.getEmptyCallback() : callback;
        }

        public void onLoadStarted(Drawable drawable) {
            super.onLoadStarted(drawable);
            this.f9220cb.onStart();
        }

        public void onLoadFailed(Drawable drawable) {
            super.onLoadFailed(drawable);
            this.f9220cb.onFailed();
        }

        public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
            this.f9220cb.onSuccess(bitmap);
        }
    }

    /* renamed from: com.didi.beatles.im.glide4.BtsImageLoaderGlideModule$DrawableTarget */
    private static class DrawableTarget extends DrawableImageViewTarget {

        /* renamed from: cb */
        private final Callback f9221cb;

        private DrawableTarget(ImageView imageView, Callback callback) {
            super(imageView);
            this.f9221cb = callback == null ? BtsImageLoader.getEmptyCallback() : callback;
        }

        public void onLoadStarted(Drawable drawable) {
            super.onLoadStarted(drawable);
            this.f9221cb.onStart();
        }

        public void onLoadFailed(Drawable drawable) {
            super.onLoadFailed(drawable);
            this.f9221cb.onFailed();
        }

        public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
            super.onResourceReady(drawable, transition);
            this.f9221cb.onSuccess((Bitmap) null);
        }
    }

    /* renamed from: com.didi.beatles.im.glide4.BtsImageLoaderGlideModule$GifTarget */
    private static class GifTarget extends ImageViewTarget<GifDrawable> {

        /* renamed from: cb */
        private final Callback f9222cb;

        private GifTarget(ImageView imageView, Callback callback) {
            super(imageView);
            this.f9222cb = callback == null ? BtsImageLoader.getEmptyCallback() : callback;
        }

        public void onLoadStarted(Drawable drawable) {
            super.onLoadStarted(drawable);
            this.f9222cb.onStart();
        }

        public void onLoadFailed(Drawable drawable) {
            super.onLoadFailed(drawable);
            this.f9222cb.onFailed();
        }

        /* access modifiers changed from: protected */
        public void setResource(GifDrawable gifDrawable) {
            ((ImageView) this.view).setImageDrawable(gifDrawable);
        }

        public void onResourceReady(GifDrawable gifDrawable, Transition<? super GifDrawable> transition) {
            super.onResourceReady(gifDrawable, transition);
            this.f9222cb.onSuccess((Bitmap) null);
        }
    }

    /* renamed from: com.didi.beatles.im.glide4.BtsImageLoaderGlideModule$BitmapViewTarget */
    private static class BitmapViewTarget extends CustomViewTarget<View, Bitmap> {

        /* renamed from: cb */
        private final Callback f9219cb;

        /* access modifiers changed from: protected */
        public void onResourceCleared(Drawable drawable) {
        }

        public BitmapViewTarget(View view, Callback callback) {
            super(view);
            this.f9219cb = callback == null ? BtsImageLoader.getEmptyCallback() : callback;
        }

        /* access modifiers changed from: protected */
        public void onResourceLoading(Drawable drawable) {
            super.onResourceLoading(drawable);
            if (drawable != null) {
                IMCmLoader.getInstance().getViewUtil().setBackgroundCompat(this.view, drawable);
            }
            this.f9219cb.onStart();
        }

        public void onLoadFailed(Drawable drawable) {
            this.f9219cb.onFailed();
        }

        public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
            IMCmLoader.getInstance().getViewUtil().setBackgroundCompat(this.view, new BitmapDrawable(this.view.getResources(), bitmap));
            this.f9219cb.onSuccess(bitmap);
        }
    }

    /* renamed from: com.didi.beatles.im.glide4.BtsImageLoaderGlideModule$GifViewTarget */
    private static class GifViewTarget extends CustomViewTarget<View, GifDrawable> {

        /* renamed from: cb */
        private final Callback f9223cb;

        /* access modifiers changed from: protected */
        public void onResourceCleared(Drawable drawable) {
        }

        public GifViewTarget(View view, Callback callback) {
            super(view);
            this.f9223cb = callback == null ? BtsImageLoader.getEmptyCallback() : callback;
        }

        /* access modifiers changed from: protected */
        public void onResourceLoading(Drawable drawable) {
            super.onResourceLoading(drawable);
            if (drawable != null) {
                IMCmLoader.getInstance().getViewUtil().setBackgroundCompat(this.view, drawable);
            }
            this.f9223cb.onStart();
        }

        public void onLoadFailed(Drawable drawable) {
            this.f9223cb.onFailed();
        }

        public void onResourceReady(GifDrawable gifDrawable, Transition<? super GifDrawable> transition) {
            IMCmLoader.getInstance().getViewUtil().setBackgroundCompat(this.view, gifDrawable);
            this.f9223cb.onSuccess((Bitmap) null);
        }
    }
}
