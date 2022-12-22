package com.didi.dimina.container.secondparty.image;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.signature.EmptySignature;
import com.bumptech.glide.util.C1850Util;
import com.didi.dimina.container.service.ImageLoaderService;
import java.io.File;
import java.lang.reflect.Constructor;

public class DidiImageLoaderServiceManager implements ImageLoaderService {
    public void loadInto(Context context, String str, int i, ImageView imageView) {
        if (imageView == null || m12713a(m12712a(context))) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            loadInto(context, i, 0, imageView);
        } else {
            ((RequestBuilder) ((RequestBuilder) ((RequestBuilder) Glide.with(context).load((Object) new GlideUrl(str)).diskCacheStrategy(DiskCacheStrategy.RESOURCE)).dontAnimate()).error(i)).into(imageView);
        }
    }

    public void load(Context context, String str, ImageLoaderService.FinishDrawableListener finishDrawableListener) {
        load(context, str, 0, finishDrawableListener);
    }

    public void load(Context context, String str, int i, final ImageLoaderService.FinishDrawableListener finishDrawableListener) {
        if (!m12713a(m12712a(context))) {
            if (TextUtils.isEmpty(str)) {
                load(context, i, 0, finishDrawableListener);
                return;
            }
            RequestBuilder requestBuilder = (RequestBuilder) ((RequestBuilder) Glide.with(context).load((Object) new GlideUrl(str)).diskCacheStrategy(DiskCacheStrategy.RESOURCE)).dontAnimate();
            if (i != 0) {
                requestBuilder.error(i);
            }
            requestBuilder.into(new SimpleTarget<Drawable>() {
                public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
                    if (drawable == null) {
                        ImageLoaderService.FinishDrawableListener finishDrawableListener = finishDrawableListener;
                        if (finishDrawableListener != null) {
                            finishDrawableListener.onDrawableFinish((Drawable) null);
                            return;
                        }
                        return;
                    }
                    if (drawable instanceof AnimationDrawable) {
                        ((AnimationDrawable) drawable).start();
                    }
                    ImageLoaderService.FinishDrawableListener finishDrawableListener2 = finishDrawableListener;
                    if (finishDrawableListener2 != null) {
                        finishDrawableListener2.onDrawableFinish(drawable);
                    }
                }

                public void onLoadFailed(Drawable drawable) {
                    super.onLoadFailed(drawable);
                    ImageLoaderService.FinishDrawableListener finishDrawableListener = finishDrawableListener;
                    if (finishDrawableListener != null) {
                        finishDrawableListener.onDrawableFinish((Drawable) null);
                    }
                }
            });
        }
    }

    public void load(Context context, int i, int i2, final ImageLoaderService.FinishDrawableListener finishDrawableListener) {
        if (!m12713a(m12712a(context))) {
            RequestBuilder requestBuilder = (RequestBuilder) ((RequestBuilder) Glide.with(context).load(Integer.valueOf(i)).diskCacheStrategy(DiskCacheStrategy.RESOURCE)).dontAnimate();
            if (i2 != 0) {
                requestBuilder.error(i2);
            }
            requestBuilder.into(new SimpleTarget<Drawable>() {
                public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
                    if (drawable == null) {
                        ImageLoaderService.FinishDrawableListener finishDrawableListener = finishDrawableListener;
                        if (finishDrawableListener != null) {
                            finishDrawableListener.onDrawableFinish((Drawable) null);
                            return;
                        }
                        return;
                    }
                    if (drawable instanceof AnimationDrawable) {
                        ((AnimationDrawable) drawable).start();
                    }
                    ImageLoaderService.FinishDrawableListener finishDrawableListener2 = finishDrawableListener;
                    if (finishDrawableListener2 != null) {
                        finishDrawableListener2.onDrawableFinish(drawable);
                    }
                }

                public void onLoadFailed(Drawable drawable) {
                    super.onLoadFailed(drawable);
                    ImageLoaderService.FinishDrawableListener finishDrawableListener = finishDrawableListener;
                    if (finishDrawableListener != null) {
                        finishDrawableListener.onDrawableFinish((Drawable) null);
                    }
                }
            });
        }
    }

    public void load(Context context, int i, ImageLoaderService.FinishDrawableListener finishDrawableListener) {
        load(context, i, 0, finishDrawableListener);
    }

    public void loadInto(Context context, int i, int i2, ImageView imageView) {
        if (imageView != null && !m12713a(m12712a(context))) {
            ((RequestBuilder) ((RequestBuilder) ((RequestBuilder) Glide.with(context).load(Integer.valueOf(i)).diskCacheStrategy(DiskCacheStrategy.RESOURCE)).dontAnimate()).error(i2)).into(imageView);
        }
    }

    public boolean isLoaded(Context context, String str) {
        try {
            Constructor<?> constructor = Class.forName("com.bumptech.glide.load.engine.OriginalKey").getConstructor(new Class[]{String.class, Key.class});
            constructor.setAccessible(true);
            Object[] objArr = {str, EmptySignature.obtain()};
            if (GlideDiskCache.getDiskCache(context).build().get((Key) constructor.newInstance(objArr)) != null) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public void download(Context context, String str) {
        if (!m12713a(m12712a(context))) {
            Glide.with(context).load((Object) new GlideUrl(str)).downloadOnly(new SimpleTarget<File>() {
                public void onResourceReady(File file, Transition<? super File> transition) {
                }
            });
        }
    }

    public void download(Context context, String str, final ImageLoaderService.FinishFileListener finishFileListener) {
        if (!m12713a(m12712a(context))) {
            Glide.with(context).load((Object) new GlideUrl(str)).downloadOnly(new SimpleTarget<File>() {
                public void onResourceReady(File file, Transition<? super File> transition) {
                    finishFileListener.onFileFinish(file);
                }
            });
        }
    }

    public boolean load(Context context, File file, int i, int i2, final ImageLoaderService.FinishDrawableListener finishDrawableListener) {
        if (m12713a(m12712a(context))) {
            return false;
        }
        int[] a = m12714a(file);
        if (a[0] <= 0 || a[1] <= 0) {
            return false;
        }
        if (a[1] * i > a[0] * i2) {
            a[0] = i;
            a[1] = (a[1] * i) / a[0];
        } else {
            a[0] = (a[0] * i2) / a[1];
            a[1] = i2;
        }
        Glide.with(context).load(file).into(new SimpleTarget<Drawable>() {
            public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
                ImageLoaderService.FinishDrawableListener finishDrawableListener;
                if (drawable != null && (finishDrawableListener = finishDrawableListener) != null) {
                    finishDrawableListener.onDrawableFinish(drawable);
                }
            }
        });
        return true;
    }

    public void load(Context context, String str, ImageLoaderService.FinishBitmapListener finishBitmapListener) {
        load(context, str, 0, 0, 0, finishBitmapListener);
    }

    public void load(Context context, String str, int i, int i2, ImageLoaderService.FinishBitmapListener finishBitmapListener) {
        load(context, str, 0, i, i2, finishBitmapListener);
    }

    public void load(Context context, String str, int i, int i2, int i3, final ImageLoaderService.FinishBitmapListener finishBitmapListener) {
        if (!m12713a(m12712a(context))) {
            if (TextUtils.isEmpty(str)) {
                load(context, i, 0, finishBitmapListener);
                return;
            }
            RequestBuilder requestBuilder = (RequestBuilder) ((RequestBuilder) Glide.with(context).load((Object) new GlideUrl(str)).diskCacheStrategy(DiskCacheStrategy.RESOURCE)).dontAnimate();
            if (i2 > 0 && i3 > 0) {
                requestBuilder.override(i2, i3);
            }
            if (i != 0) {
                requestBuilder.error(i);
            }
            requestBuilder.into(new SimpleTarget<Drawable>() {
                public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
                    if (drawable == null) {
                        ImageLoaderService.FinishBitmapListener finishBitmapListener = finishBitmapListener;
                        if (finishBitmapListener != null) {
                            finishBitmapListener.onBitmapFinish((Bitmap) null);
                        }
                    } else if (finishBitmapListener != null && (drawable instanceof BitmapDrawable)) {
                        finishBitmapListener.onBitmapFinish(((BitmapDrawable) drawable).getBitmap());
                    }
                }

                public void onLoadFailed(Drawable drawable) {
                    super.onLoadFailed(drawable);
                    ImageLoaderService.FinishBitmapListener finishBitmapListener = finishBitmapListener;
                    if (finishBitmapListener != null) {
                        finishBitmapListener.onBitmapFinish((Bitmap) null);
                    }
                }
            });
        }
    }

    public void load(Context context, int i, int i2, final ImageLoaderService.FinishBitmapListener finishBitmapListener) {
        if (!m12713a(m12712a(context))) {
            RequestBuilder requestBuilder = (RequestBuilder) ((RequestBuilder) Glide.with(context).load(Integer.valueOf(i)).diskCacheStrategy(DiskCacheStrategy.RESOURCE)).dontAnimate();
            if (i2 != 0) {
                requestBuilder.error(i2);
            }
            requestBuilder.into(new SimpleTarget<Drawable>() {
                public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
                    if (drawable == null) {
                        ImageLoaderService.FinishBitmapListener finishBitmapListener = finishBitmapListener;
                        if (finishBitmapListener != null) {
                            finishBitmapListener.onBitmapFinish((Bitmap) null);
                        }
                    } else if (finishBitmapListener != null && (drawable instanceof BitmapDrawable)) {
                        finishBitmapListener.onBitmapFinish(((BitmapDrawable) drawable).getBitmap());
                    }
                }

                public void onLoadFailed(Drawable drawable) {
                    super.onLoadFailed(drawable);
                    ImageLoaderService.FinishBitmapListener finishBitmapListener = finishBitmapListener;
                    if (finishBitmapListener != null) {
                        finishBitmapListener.onBitmapFinish((Bitmap) null);
                    }
                }
            });
        }
    }

    public void load(Context context, int i, ImageLoaderService.FinishBitmapListener finishBitmapListener) {
        load(context, i, 0, finishBitmapListener);
    }

    public boolean load(Context context, File file, int i, int i2, final ImageLoaderService.FinishBitmapListener finishBitmapListener) {
        if (m12713a(m12712a(context))) {
            return false;
        }
        int[] a = m12714a(file);
        if (a[0] <= 0 || a[1] <= 0) {
            return false;
        }
        if (a[1] * i > a[0] * i2) {
            a[0] = i;
            a[1] = (a[1] * i) / a[0];
        } else {
            a[0] = (a[0] * i2) / a[1];
            a[1] = i2;
        }
        Glide.with(context).asBitmap().load(file).into(new SimpleTarget<Bitmap>() {
            public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
                ImageLoaderService.FinishBitmapListener finishBitmapListener;
                if (bitmap != null && (finishBitmapListener = finishBitmapListener) != null) {
                    finishBitmapListener.onBitmapFinish(bitmap);
                }
            }
        });
        return true;
    }

    public void load(Context context, File file, final ImageLoaderService.FinishBitmapListener finishBitmapListener) {
        if (!m12713a(m12712a(context))) {
            int[] a = m12714a(file);
            if (a[0] > 0 && a[1] > 0) {
                Glide.with(context).asBitmap().load(file).into(new SimpleTarget<Bitmap>() {
                    public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
                        ImageLoaderService.FinishBitmapListener finishBitmapListener;
                        if (bitmap != null && (finishBitmapListener = finishBitmapListener) != null) {
                            finishBitmapListener.onBitmapFinish(bitmap);
                        }
                    }
                });
            }
        }
    }

    public void loadInto(Context context, File file, ImageView imageView) {
        if (file != null && imageView != null && file.exists() && !m12713a(m12712a(context))) {
            Glide.with(context).load(file).into(imageView);
        }
    }

    public void loadCircleInto(Context context, File file, ImageView imageView) {
        GlideCircleTransform glideCircleTransform = new GlideCircleTransform();
        if (file != null && imageView != null && file.exists() && !m12713a(m12712a(context))) {
            ((RequestBuilder) Glide.with(context).load(file).transform((Transformation<Bitmap>) glideCircleTransform)).into(imageView);
        }
    }

    /* renamed from: a */
    private static int[] m12714a(File file) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        return new int[]{options.outHeight, options.outWidth};
    }

    /* renamed from: a */
    private static Activity m12712a(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return m12712a(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    /* renamed from: a */
    private static boolean m12713a(Activity activity) {
        if (C1850Util.isOnBackgroundThread() || activity == null) {
            return false;
        }
        if (activity.isFinishing() || activity.isDestroyed()) {
            return true;
        }
        return false;
    }
}
