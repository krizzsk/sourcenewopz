package com.didi.soda.blocks.utils;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import rui.config.RConfigConstants;

public class DrawableUtil {
    public static void loadDrawable(Context context, String str, DrawableCallback drawableCallback) {
        if (TextUtils.isEmpty(str)) {
            if (drawableCallback != null) {
                drawableCallback.onDrawableLoaded((Drawable) null);
            }
        } else if (isRemoteImage(str)) {
            loadRemoteDrawable(context, str, drawableCallback);
        } else if (isLocalAbsoluteImage(str)) {
            loadLocalDrawable(context, str, drawableCallback);
        } else if (isBase64Image(str)) {
            loadBase64Drawable(str, drawableCallback);
        } else {
            loadResourceDrawable(context, str, drawableCallback);
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

    private static String fitRemoteUrl(String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith("//")) {
            return str;
        }
        return "https:" + str;
    }

    private static void loadRemoteDrawable(Context context, String str, DrawableCallback drawableCallback) {
        if (!TextUtils.isEmpty(str)) {
            loadByUrl(context, fitRemoteUrl(str), drawableCallback);
        }
    }

    private static void loadLocalDrawable(Context context, String str, DrawableCallback drawableCallback) {
        loadByUrl(context, str, drawableCallback);
    }

    private static void loadAssetsDrawable(Context context, String str, DrawableCallback drawableCallback) {
        loadByUrl(context, "file:///android_asset/" + str, drawableCallback);
    }

    private static void loadBase64Drawable(String str, DrawableCallback drawableCallback) {
        BitmapDrawable bitmapDrawable;
        try {
            byte[] decode = Base64.decode(str.split(",")[1], 0);
            bitmapDrawable = new BitmapDrawable(BitmapFactory.decodeByteArray(decode, 0, decode.length));
        } catch (Exception unused) {
            bitmapDrawable = null;
        }
        if (drawableCallback != null) {
            drawableCallback.onDrawableLoaded(bitmapDrawable);
        }
    }

    private static void loadResourceDrawable(Context context, String str, DrawableCallback drawableCallback) {
        loadById(context, ResUtils.getResourceId(str, RConfigConstants.TYPE_DRAWABLE, (String) null), drawableCallback);
    }

    private static void loadById(Context context, int i, DrawableCallback drawableCallback) {
        try {
            Drawable drawable = context.getResources().getDrawable(i);
            if (drawableCallback != null) {
                drawableCallback.onDrawableLoaded(drawable);
            }
        } catch (Exception unused) {
            if (drawableCallback != null) {
                drawableCallback.onDrawableLoaded((Drawable) null);
            }
        }
    }

    private static void loadByUrl(Context context, String str, final DrawableCallback drawableCallback) {
        try {
            Glide.with(context).load(str).into(new CustomTarget<Drawable>() {
                public void onLoadCleared(Drawable drawable) {
                }

                public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
                    DrawableCallback drawableCallback = drawableCallback;
                    if (drawableCallback != null) {
                        drawableCallback.onDrawableLoaded(drawable);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            if (drawableCallback != null) {
                drawableCallback.onDrawableLoaded((Drawable) null);
            }
        }
    }
}
