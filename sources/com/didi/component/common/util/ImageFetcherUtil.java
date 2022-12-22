package com.didi.component.common.util;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;

public class ImageFetcherUtil {

    public interface ImageLoadCallback {
        void onSuccess(Bitmap bitmap);
    }

    private static class ImageFetcherHolder {
        /* access modifiers changed from: private */
        public static final ImageFetcherUtil INSTANCE = new ImageFetcherUtil();

        private ImageFetcherHolder() {
        }
    }

    private ImageFetcherUtil() {
    }

    public static ImageFetcherUtil getInstance() {
        return ImageFetcherHolder.INSTANCE;
    }

    public void fetchCallback(Context context, String str, final ImageLoadCallback imageLoadCallback) {
        if (context != null) {
            try {
                Glide.with(context).asBitmap().load(str).into(new CustomTarget<Bitmap>() {
                    public void onLoadCleared(Drawable drawable) {
                    }

                    public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
                        ImageLoadCallback imageLoadCallback = imageLoadCallback;
                        if (imageLoadCallback != null) {
                            imageLoadCallback.onSuccess(bitmap);
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void fetchCallbackWithARGB8888AndOnlyCacheSource(Context context, String str, final ImageLoadCallback imageLoadCallback) {
        if (context != null) {
            try {
                ((RequestBuilder) ((RequestBuilder) Glide.with(context).asBitmap().load(str).format(DecodeFormat.PREFER_ARGB_8888)).diskCacheStrategy(DiskCacheStrategy.RESOURCE)).into(new CustomTarget<Bitmap>() {
                    public void onLoadCleared(Drawable drawable) {
                    }

                    public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
                        ImageLoadCallback imageLoadCallback = imageLoadCallback;
                        if (imageLoadCallback != null) {
                            imageLoadCallback.onSuccess(bitmap);
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void fetchCallback(Fragment fragment, String str, final ImageLoadCallback imageLoadCallback) {
        Glide.with(fragment).asBitmap().load(str).into(new CustomTarget<Bitmap>() {
            public void onLoadCleared(Drawable drawable) {
            }

            public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
                ImageLoadCallback imageLoadCallback = imageLoadCallback;
                if (imageLoadCallback != null) {
                    imageLoadCallback.onSuccess(bitmap);
                }
            }
        });
    }

    public void fetchCallback(Activity activity, String str, final ImageLoadCallback imageLoadCallback) {
        Glide.with(activity).asBitmap().load(str).into(new CustomTarget<Bitmap>() {
            public void onLoadCleared(Drawable drawable) {
            }

            public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
                ImageLoadCallback imageLoadCallback = imageLoadCallback;
                if (imageLoadCallback != null) {
                    imageLoadCallback.onSuccess(bitmap);
                }
            }
        });
    }

    public void fetch(Context context, int i, ImageView imageView) {
        try {
            ((RequestBuilder) Glide.with(context).asBitmap().load(Integer.valueOf(i)).dontAnimate()).into(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadCircleBorderImage(String str, int i, ImageView imageView, float f, int i2) {
        ((RequestBuilder) ((RequestBuilder) ((RequestBuilder) ((RequestBuilder) Glide.with(imageView.getContext()).load(str).placeholder(i)).dontAnimate()).transform((Transformation<Bitmap>) new GlideCircleTransform(imageView.getContext(), f, i2))).diskCacheStrategy(DiskCacheStrategy.RESOURCE)).into(imageView);
    }

    public void loadCircleImage(String str, int i, ImageView imageView) {
        ((RequestBuilder) ((RequestBuilder) ((RequestBuilder) ((RequestBuilder) Glide.with(imageView.getContext()).load(str).placeholder(i)).dontAnimate()).transform((Transformation<Bitmap>) new GlideCircleTransform(imageView.getContext()))).diskCacheStrategy(DiskCacheStrategy.RESOURCE)).into(imageView);
    }
}
