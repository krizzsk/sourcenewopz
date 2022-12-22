package com.didi.payment.base.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.didi.payment.base.utils.GlideRoundedCornersTransform;

public class GlideUtils {
    public static void with2load2into(Context context, String str, ImageView imageView) {
        Glide.with(context).load(str).into(imageView);
    }

    public static void with2load2SkipMemCache2into(Context context, String str, ImageView imageView) {
        Glide.with(context).load(str).into(imageView);
    }

    public static void loadSuperBigImageSafely(Context context, String str, int i, int i2, ImageView imageView) {
        try {
            ((RequestOptions) ((RequestOptions) ((RequestOptions) new RequestOptions().priority(Priority.NORMAL)).override(i, i2)).diskCacheStrategy(DiskCacheStrategy.RESOURCE)).skipMemoryCache(true);
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Error e2) {
            e2.printStackTrace();
        }
        ((RequestBuilder) ((RequestBuilder) Glide.with(context).load(str).listener(new RequestListener<Drawable>() {
            public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
                return false;
            }

            public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
                return false;
            }
        }).override(i, i2)).priority(Priority.NORMAL)).into(imageView);
    }

    public static void loadRoundImage(Context context, String str, int i, ImageView imageView) {
        GlideRoundedCornersTransform glideRoundedCornersTransform = new GlideRoundedCornersTransform((float) i, GlideRoundedCornersTransform.CornerType.ALL);
        RequestOptions requestOptions = (RequestOptions) new RequestOptions().transform((Transformation<Bitmap>) glideRoundedCornersTransform);
        ((RequestBuilder) Glide.with(context).load(str).transform((Transformation<Bitmap>) glideRoundedCornersTransform)).into(imageView);
    }

    public static void loadCircleImageWithDefaultImg(Context context, Uri uri, int i, ImageView imageView) {
        RequestOptions requestOptions = (RequestOptions) ((RequestOptions) new RequestOptions().centerCrop()).placeholder(i);
        RequestOptions.bitmapTransform(new CircleCrop());
        ((RequestBuilder) ((RequestBuilder) Glide.with(context).load(uri).transform((Transformation<Bitmap>) new CircleCrop())).placeholder(i)).into(imageView);
    }

    public static void loadGifWithCount(Context context, int i, ImageView imageView, final int i2, final Runnable runnable) {
        Glide.with(context).asGif().load(Integer.valueOf(i)).apply((BaseRequestOptions<?>) (RequestOptions) ((RequestOptions) ((RequestOptions) new RequestOptions().fitCenter()).skipMemoryCache(true)).diskCacheStrategy(DiskCacheStrategy.DATA)).listener(new RequestListener<GifDrawable>() {
            public boolean onLoadFailed(GlideException glideException, Object obj, Target<GifDrawable> target, boolean z) {
                return false;
            }

            public boolean onResourceReady(GifDrawable gifDrawable, Object obj, Target<GifDrawable> target, DataSource dataSource, boolean z) {
                gifDrawable.setLoopCount(i2);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    public void run() {
                        runnable.run();
                    }
                }, ((long) i2) * 3000);
                return false;
            }
        }).into(imageView);
    }

    public static void loadTopRoundImageMix(Context context, int i, String str, float f, ImageView imageView) {
        if (context != null && imageView != null) {
            GlideRoundedCornersTransform glideRoundedCornersTransform = new GlideRoundedCornersTransform(GlideRoundedCornersTransform.CornerType.TOP, f);
            RequestOptions requestOptions = (RequestOptions) new RequestOptions().transform((Transformation<Bitmap>) glideRoundedCornersTransform);
            RequestBuilder<Drawable> requestBuilder = null;
            if (!TextUtils.isEmpty(str)) {
                requestBuilder = Glide.with(context).load(str);
            } else if (i != -1) {
                requestBuilder = Glide.with(context).load(Integer.valueOf(i));
            }
            if (requestBuilder != null) {
                ((RequestBuilder) requestBuilder.transform((Transformation<Bitmap>) glideRoundedCornersTransform)).into(imageView);
            }
        }
    }
}
