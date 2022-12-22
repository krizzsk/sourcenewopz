package com.didi.soda.blocks.utils;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.didi.soda.blocks.sdk.BlocksEngine;
import rui.config.RConfigConstants;

public class ImageRenderUtil {
    public static void renderImage(Context context, ImageView imageView, String str, String str2) {
        renderImage(context, imageView, str, str2, (RequestListener<Drawable>) null);
    }

    public static void renderImage(Context context, ImageView imageView, String str, String str2, RequestListener<Drawable> requestListener) {
        if (imageView != null && !TextUtils.isEmpty(str)) {
            if (isRemoteImage(str)) {
                renderRemoteImage(context, imageView, str, str2, requestListener);
            } else if (isLocalAbsoluteImage(str)) {
                renderLocalImage(context, imageView, str, requestListener);
            } else if (isBase64Image(str)) {
                renderBase64Image(imageView, str, requestListener);
            } else {
                renderResourceImage(context, imageView, str, requestListener);
            }
        }
    }

    private static boolean isRemoteImage(String str) {
        return str != null && (str.startsWith("//") || str.toLowerCase().startsWith("http"));
    }

    private static boolean isLocalAbsoluteImage(String str) {
        return str != null && str.startsWith("/");
    }

    private static boolean isBase64Image(String str) {
        return str != null && (str.contains("base64") || str.contains("BASE64"));
    }

    /* access modifiers changed from: private */
    public static String fitRemoteUrl(String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith("//")) {
            return str;
        }
        return "https:" + str;
    }

    private static void renderRemoteImage(Context context, final ImageView imageView, final String str, String str2, final RequestListener<Drawable> requestListener) {
        if (!TextUtils.isEmpty(str)) {
            DrawableUtil.loadDrawable(context, str2, new DrawableCallback() {
                public void onDrawableLoaded(Drawable drawable) {
                    ImageRenderUtil.setImage(ImageRenderUtil.fitRemoteUrl(str), drawable, imageView, requestListener);
                }
            });
        }
    }

    private static void renderLocalImage(Context context, ImageView imageView, String str, RequestListener<Drawable> requestListener) {
        setImage(str, imageView, requestListener);
    }

    private static void renderAssetsImage(Context context, ImageView imageView, String str, RequestListener<Drawable> requestListener) {
        setImage("file:///android_asset/" + str, imageView, requestListener);
    }

    private static void renderBase64Image(ImageView imageView, String str, RequestListener<Drawable> requestListener) {
        try {
            byte[] decode = Base64.decode(str.split(",")[1], 0);
            imageView.setImageBitmap(BitmapFactory.decodeByteArray(decode, 0, decode.length));
            if (requestListener != null) {
                requestListener.onResourceReady(null, (Object) null, (Target<Drawable>) null, (DataSource) null, true);
            }
        } catch (Exception unused) {
            if (requestListener != null) {
                requestListener.onLoadFailed((GlideException) null, (Object) null, (Target<Drawable>) null, true);
            }
        }
    }

    private static void renderResourceImage(Context context, ImageView imageView, String str, RequestListener<Drawable> requestListener) {
        setImage(ResUtils.getResourceId(str, RConfigConstants.TYPE_DRAWABLE, (String) null), imageView, requestListener);
    }

    private static void setImage(int i, ImageView imageView, RequestListener<Drawable> requestListener) {
        if (imageView != null) {
            imageView.setImageResource(i);
            if (requestListener != null) {
                requestListener.onResourceReady(null, (Object) null, (Target<Drawable>) null, (DataSource) null, true);
            }
        } else if (requestListener != null) {
            requestListener.onLoadFailed((GlideException) null, (Object) null, (Target<Drawable>) null, true);
        }
    }

    private static void setImage(String str, ImageView imageView, RequestListener<Drawable> requestListener) {
        setImage(str, (Drawable) null, imageView, requestListener);
    }

    /* access modifiers changed from: private */
    public static void setImage(String str, Drawable drawable, ImageView imageView, RequestListener<Drawable> requestListener) {
        if (BlocksEngine.Companion.getInstance().getImageLoader() != null) {
            BlocksEngine.Companion.getInstance().getImageLoader().setImage(str, drawable, imageView);
            return;
        }
        try {
            RequestOptions requestOptions = new RequestOptions();
            if (imageView.getScaleType() == ImageView.ScaleType.CENTER) {
                requestOptions.override(Integer.MIN_VALUE, Integer.MIN_VALUE);
            }
            if (drawable != null) {
                requestOptions.placeholder(drawable);
            }
            if (requestListener != null) {
                Glide.with(imageView.getContext()).load(str).apply((BaseRequestOptions<?>) requestOptions).listener(requestListener).into(imageView);
            } else {
                Glide.with(imageView.getContext()).load(str).apply((BaseRequestOptions<?>) requestOptions).listener(new RequestListener<Drawable>() {
                    public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
                        return false;
                    }

                    public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
                        return false;
                    }
                }).into(imageView);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
