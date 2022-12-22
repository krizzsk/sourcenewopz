package com.didi.beatles.p099im.views.widget.longimage;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import com.didi.hawaii.mapsdkv2.HWMapConstant;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* renamed from: com.didi.beatles.im.views.widget.longimage.IMImageSource */
public final class IMImageSource {

    /* renamed from: a */
    static final String f10517a = "file:///";

    /* renamed from: b */
    static final String f10518b = "file:///android_asset/";

    /* renamed from: c */
    private final Uri f10519c;

    /* renamed from: d */
    private final Bitmap f10520d;

    /* renamed from: e */
    private final Integer f10521e;

    /* renamed from: f */
    private boolean f10522f;

    /* renamed from: g */
    private int f10523g;

    /* renamed from: h */
    private int f10524h;

    /* renamed from: i */
    private Rect f10525i;

    /* renamed from: j */
    private boolean f10526j;

    private IMImageSource(Bitmap bitmap, boolean z) {
        this.f10520d = bitmap;
        this.f10519c = null;
        this.f10521e = null;
        this.f10522f = false;
        this.f10523g = bitmap.getWidth();
        this.f10524h = bitmap.getHeight();
        this.f10526j = z;
    }

    private IMImageSource(Uri uri) {
        String uri2 = uri.toString();
        if (uri2.startsWith(f10517a) && !new File(uri2.substring(7)).exists()) {
            try {
                uri = Uri.parse(URLDecoder.decode(uri2, "UTF-8"));
            } catch (UnsupportedEncodingException unused) {
            }
        }
        this.f10520d = null;
        this.f10519c = uri;
        this.f10521e = null;
        this.f10522f = true;
    }

    private IMImageSource(int i) {
        this.f10520d = null;
        this.f10519c = null;
        this.f10521e = Integer.valueOf(i);
        this.f10522f = true;
    }

    public static IMImageSource resource(int i) {
        return new IMImageSource(i);
    }

    public static IMImageSource asset(String str) {
        if (str != null) {
            return uri(f10518b + str);
        }
        throw new NullPointerException("Asset name must not be null");
    }

    public static IMImageSource uri(String str) {
        if (str != null) {
            if (!str.contains(HWMapConstant.HTTP.SEPARATOR)) {
                if (str.startsWith("/")) {
                    str = str.substring(1);
                }
                str = f10517a + str;
            }
            return new IMImageSource(Uri.parse(str));
        }
        throw new NullPointerException("Uri must not be null");
    }

    public static IMImageSource uri(Uri uri) {
        if (uri != null) {
            return new IMImageSource(uri);
        }
        throw new NullPointerException("Uri must not be null");
    }

    public static IMImageSource bitmap(Bitmap bitmap) {
        if (bitmap != null) {
            return new IMImageSource(bitmap, false);
        }
        throw new NullPointerException("Bitmap must not be null");
    }

    public static IMImageSource cachedBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            return new IMImageSource(bitmap, true);
        }
        throw new NullPointerException("Bitmap must not be null");
    }

    public IMImageSource tilingEnabled() {
        return tiling(true);
    }

    public IMImageSource tilingDisabled() {
        return tiling(false);
    }

    public IMImageSource tiling(boolean z) {
        this.f10522f = z;
        return this;
    }

    public IMImageSource region(Rect rect) {
        this.f10525i = rect;
        m7137a();
        return this;
    }

    public IMImageSource dimensions(int i, int i2) {
        if (this.f10520d == null) {
            this.f10523g = i;
            this.f10524h = i2;
        }
        m7137a();
        return this;
    }

    /* renamed from: a */
    private void m7137a() {
        Rect rect = this.f10525i;
        if (rect != null) {
            this.f10522f = true;
            this.f10523g = rect.width();
            this.f10524h = this.f10525i.height();
        }
    }

    /* access modifiers changed from: protected */
    public final Uri getUri() {
        return this.f10519c;
    }

    /* access modifiers changed from: protected */
    public final Bitmap getBitmap() {
        return this.f10520d;
    }

    /* access modifiers changed from: protected */
    public final Integer getResource() {
        return this.f10521e;
    }

    /* access modifiers changed from: protected */
    public final boolean getTile() {
        return this.f10522f;
    }

    /* access modifiers changed from: protected */
    public final int getSWidth() {
        return this.f10523g;
    }

    /* access modifiers changed from: protected */
    public final int getSHeight() {
        return this.f10524h;
    }

    /* access modifiers changed from: protected */
    public final Rect getSRegion() {
        return this.f10525i;
    }

    /* access modifiers changed from: protected */
    public final boolean isCached() {
        return this.f10526j;
    }
}
