package com.airbnb.lottie.manager;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.didi.soda.customer.app.constant.Const;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.p071io.IOUtils;

public class ImageAssetManager {

    /* renamed from: a */
    private static final Object f1363a = new Object();

    /* renamed from: b */
    private final Context f1364b;

    /* renamed from: c */
    private String f1365c;

    /* renamed from: d */
    private ImageAssetDelegate f1366d;

    /* renamed from: e */
    private final Map<String, LottieImageAsset> f1367e;

    public ImageAssetManager(Drawable.Callback callback, String str, ImageAssetDelegate imageAssetDelegate, Map<String, LottieImageAsset> map) {
        this.f1365c = str;
        if (!TextUtils.isEmpty(str)) {
            String str2 = this.f1365c;
            if (str2.charAt(str2.length() - 1) != '/') {
                this.f1365c += IOUtils.DIR_SEPARATOR_UNIX;
            }
        }
        if (!(callback instanceof View)) {
            Logger.warning("LottieDrawable must be inside of a view for images to work.");
            this.f1367e = new HashMap();
            this.f1364b = null;
            return;
        }
        this.f1364b = ((View) callback).getContext();
        this.f1367e = map;
        setDelegate(imageAssetDelegate);
    }

    public void setDelegate(ImageAssetDelegate imageAssetDelegate) {
        this.f1366d = imageAssetDelegate;
    }

    public Bitmap updateBitmap(String str, Bitmap bitmap) {
        if (bitmap == null) {
            LottieImageAsset lottieImageAsset = this.f1367e.get(str);
            Bitmap bitmap2 = lottieImageAsset.getBitmap();
            lottieImageAsset.setBitmap((Bitmap) null);
            return bitmap2;
        }
        Bitmap bitmap3 = this.f1367e.get(str).getBitmap();
        m1302a(str, bitmap);
        return bitmap3;
    }

    public Bitmap bitmapForId(String str) {
        LottieImageAsset lottieImageAsset = this.f1367e.get(str);
        if (lottieImageAsset == null) {
            return null;
        }
        Bitmap bitmap = lottieImageAsset.getBitmap();
        if (bitmap != null) {
            return bitmap;
        }
        ImageAssetDelegate imageAssetDelegate = this.f1366d;
        if (imageAssetDelegate != null) {
            Bitmap fetchBitmap = imageAssetDelegate.fetchBitmap(lottieImageAsset);
            if (fetchBitmap != null) {
                m1302a(str, fetchBitmap);
            }
            return fetchBitmap;
        }
        String fileName = lottieImageAsset.getFileName();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (!fileName.startsWith("data:") || fileName.indexOf(Const.ImageUpload.STR_PREFIX) <= 0) {
            try {
                if (!TextUtils.isEmpty(this.f1365c)) {
                    AssetManager assets = this.f1364b.getAssets();
                    return m1302a(str, Utils.resizeBitmapIfNeeded(BitmapFactory.decodeStream(assets.open(this.f1365c + fileName), (Rect) null, options), lottieImageAsset.getWidth(), lottieImageAsset.getHeight()));
                }
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            } catch (IOException e) {
                Logger.warning("Unable to open asset.", e);
                return null;
            }
        } else {
            try {
                byte[] decode = Base64.decode(fileName.substring(fileName.indexOf(44) + 1), 0);
                return m1302a(str, BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
            } catch (IllegalArgumentException e2) {
                Logger.warning("data URL did not have correct base64 format.", e2);
                return null;
            }
        }
    }

    public boolean hasSameContext(Context context) {
        return (context == null && this.f1364b == null) || this.f1364b.equals(context);
    }

    /* renamed from: a */
    private Bitmap m1302a(String str, Bitmap bitmap) {
        synchronized (f1363a) {
            this.f1367e.get(str).setBitmap(bitmap);
        }
        return bitmap;
    }
}
