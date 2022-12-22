package com.didi.hawaii.mapsdkv2.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import com.didi.hawaii.mapsdkv2.MapConfigHelper;
import com.didi.hawaii.mapsdkv2.Prefs;
import com.didi.hawaii.utils.C9266IO;
import com.didi.map.common.MapAssets;
import java.io.File;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import rui.config.RConfigConstants;

public final class Resources {

    /* renamed from: a */
    private static final String f23982a = "hawaii_sdk_user_custom_color#";

    /* renamed from: d */
    private static boolean f23983d;

    /* renamed from: b */
    private final Context f23984b;

    /* renamed from: c */
    private final MapContext f23985c;

    /* renamed from: e */
    private final Map<String, WeakReference<Bitmap>> f23986e = new HashMap();

    /* renamed from: f */
    private final Prefs f23987f;

    Resources(Context context, MapContext mapContext) {
        this.f23984b = context;
        this.f23985c = mapContext;
        this.f23987f = new Prefs(context);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo70589a(boolean z) {
        synchronized (Resources.class) {
            if (z) {
                C9266IO.deleteFileOrFolder(this.f23987f.getConfigPath());
                f23983d = false;
            }
            if (!f23983d) {
                m17060a();
                MapConfigHelper mapConfigHelper = new MapConfigHelper(this.f23984b, this.f23985c.getHttpClient(), this.f23987f);
                mapConfigHelper.copyBaseMapConfigFile();
                if (!z) {
                    mapConfigHelper.checkUpdate();
                }
                f23983d = true;
            }
        }
    }

    /* renamed from: a */
    private void m17060a() {
        C9266IO.ensureDir(this.f23987f.getMapPath4Language(0));
        C9266IO.ensureDir(this.f23987f.getSatPath());
        C9266IO.ensureDir(this.f23987f.getConfigPath());
        C9266IO.ensureDir(this.f23987f.getWmsPath());
    }

    public Prefs getPrefs() {
        return this.f23987f;
    }

    /* renamed from: a */
    static String m17059a(int i) {
        return f23982a + i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo70588a(Bitmap bitmap) {
        String b = m17062b(bitmap);
        this.f23986e.put(b, new WeakReference(bitmap));
        return b;
    }

    /* renamed from: b */
    private String m17062b(Bitmap bitmap) {
        String hexString = Integer.toHexString(bitmap.hashCode());
        return hexString + RConfigConstants.KEYWORD_COLOR_SIGN + bitmap.getWidth() + RConfigConstants.KEYWORD_COLOR_SIGN + bitmap.getHeight() + RConfigConstants.KEYWORD_COLOR_SIGN + bitmap.getRowBytes() + RConfigConstants.KEYWORD_COLOR_SIGN + bitmap.getPixel(bitmap.getWidth() / 2, bitmap.getHeight() / 2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Bitmap mo70587a(String str) {
        if (str.contains(f23982a)) {
            return m17061b(Integer.valueOf(str.replace(f23982a, "")).intValue());
        }
        WeakReference weakReference = this.f23986e.get(str);
        if (weakReference != null) {
            return (Bitmap) weakReference.get();
        }
        return null;
    }

    /* renamed from: b */
    private Bitmap m17061b(int i) {
        int[] iArr = new int[33];
        for (int i2 = 0; i2 < 33; i2++) {
            iArr[i2] = i;
        }
        return Bitmap.createBitmap(iArr, 0, 33, 33, 1, Bitmap.Config.ARGB_8888);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Bitmap mo70590b(String str) {
        if (!new File(str).exists()) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        try {
            return BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public Bitmap mo70591c(String str) {
        Bitmap d = m17063d(str);
        if (d != null) {
            return d;
        }
        Bitmap bitmapInMapDir = MapAssets.bitmapInMapDir(this.f23984b, str);
        if (bitmapInMapDir != null) {
            return bitmapInMapDir;
        }
        return MapAssets.bitmap(this.f23984b, str);
    }

    /* renamed from: d */
    private Bitmap m17063d(String str) {
        InputStream inputStream;
        Throwable th;
        try {
            inputStream = C9266IO.getInputStream(this.f23987f.getConfigPath() + str);
            if (inputStream != null) {
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inScaled = false;
                    Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, (Rect) null, options);
                    C9266IO.safeClose(inputStream);
                    return decodeStream;
                } catch (Throwable th2) {
                    th = th2;
                    C9266IO.safeClose(inputStream);
                    throw th;
                }
            } else {
                C9266IO.safeClose(inputStream);
                return null;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            C9266IO.safeClose(inputStream);
            throw th;
        }
    }
}
