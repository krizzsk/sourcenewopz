package com.didi.beatles.p099im.views.widget.longimage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import java.io.InputStream;
import java.util.List;
import rui.config.RConfigConstants;

/* renamed from: com.didi.beatles.im.views.widget.longimage.IMSkiaImageRegionDecoder */
public class IMSkiaImageRegionDecoder implements ImageRegionDecoder {

    /* renamed from: c */
    private static final String f10530c = "file://";

    /* renamed from: d */
    private static final String f10531d = "file:///android_asset/";

    /* renamed from: e */
    private static final String f10532e = "android.resource://";

    /* renamed from: a */
    private BitmapRegionDecoder f10533a;

    /* renamed from: b */
    private final Object f10534b = new Object();

    public Point init(Context context, Uri uri) throws Exception {
        Resources resources;
        int i;
        String uri2 = uri.toString();
        if (uri2.startsWith(f10532e)) {
            String authority = uri.getAuthority();
            if (context.getPackageName().equals(authority)) {
                resources = context.getResources();
            } else {
                resources = context.getPackageManager().getResourcesForApplication(authority);
            }
            List<String> pathSegments = uri.getPathSegments();
            int size = pathSegments.size();
            if (size != 2 || !pathSegments.get(0).equals(RConfigConstants.TYPE_DRAWABLE)) {
                if (size == 1 && TextUtils.isDigitsOnly(pathSegments.get(0))) {
                    try {
                        i = Integer.parseInt(pathSegments.get(0));
                    } catch (NumberFormatException unused) {
                    }
                }
                i = 0;
            } else {
                i = resources.getIdentifier(pathSegments.get(1), RConfigConstants.TYPE_DRAWABLE, authority);
            }
            this.f10533a = BitmapRegionDecoder.newInstance(context.getResources().openRawResource(i), false);
        } else if (uri2.startsWith(f10531d)) {
            this.f10533a = BitmapRegionDecoder.newInstance(context.getAssets().open(uri2.substring(22), 1), false);
        } else if (uri2.startsWith(f10530c)) {
            this.f10533a = BitmapRegionDecoder.newInstance(uri2.substring(7), false);
        } else {
            InputStream inputStream = null;
            try {
                inputStream = context.getContentResolver().openInputStream(uri);
                this.f10533a = BitmapRegionDecoder.newInstance(inputStream, false);
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception unused2) {
                    }
                }
            }
        }
        return new Point(this.f10533a.getWidth(), this.f10533a.getHeight());
    }

    public Bitmap decodeRegion(Rect rect, int i) {
        Bitmap decodeRegion;
        synchronized (this.f10534b) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = i;
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            decodeRegion = this.f10533a.decodeRegion(rect, options);
            if (decodeRegion == null) {
                throw new RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");
            }
        }
        return decodeRegion;
    }

    public boolean isReady() {
        BitmapRegionDecoder bitmapRegionDecoder = this.f10533a;
        return bitmapRegionDecoder != null && !bitmapRegionDecoder.isRecycled();
    }

    public void recycle() {
        this.f10533a.recycle();
    }
}
