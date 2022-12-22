package com.didi.hawaii.mapsdkv2.core;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Typeface;
import com.didi.hawaii.log.HWThreadPool;
import com.didi.hawaii.mapsdkv2.common.MapLog;
import com.didi.hawaii.mapsdkv2.core.GLBaseMapView;
import com.didi.hawaii.mapsdkv2.core.MapEngine;
import com.didi.map.base.TextLableOnRoute;
import com.didi.map.common.utils.SystemUtil;
import java.util.List;

/* renamed from: com.didi.hawaii.mapsdkv2.core.c */
/* compiled from: EngineCallbackImpl */
final class C9183c implements MapEngine.Callback {

    /* renamed from: a */
    private static final String f24009a = "EngineCallbackImpl";

    /* renamed from: b */
    private final GLBaseMapView f24010b;

    /* renamed from: c */
    private final Resources f24011c;

    /* renamed from: d */
    private Paint f24012d;

    /* renamed from: e */
    private float f24013e;

    /* renamed from: f */
    private Bitmap f24014f;

    /* renamed from: g */
    private int f24015g = 300;

    /* renamed from: h */
    private int f24016h = 100;

    /* renamed from: i */
    private final PointF f24017i = new PointF();

    /* renamed from: j */
    private final Canvas f24018j = new Canvas();

    C9183c(GLBaseMapView gLBaseMapView) {
        this.f24010b = gLBaseMapView;
        this.f24011c = gLBaseMapView.getMapContext().getResources();
    }

    public LoadedImage onLoadBitmap(int i, String str) {
        if (i == 1) {
            return new LoadedImage(this.f24011c.mo70590b(str), SystemUtil.getDensity(this.f24010b.getMapContext().getAndroidContext()), 0.5f, 0.5f);
        }
        Bitmap a = this.f24011c.mo70587a(str);
        if (a == null && this.f24010b.f23889j != null) {
            a = this.f24010b.f23889j.onLoadBitmap(i, str);
        }
        if (a == null) {
            a = this.f24011c.mo70591c(str);
        }
        if (a == null) {
            MapLog.m16915e(f24009a, "onLoadBitmap:Can't find texture " + str);
            a = Bitmap.createBitmap(16, 16, Bitmap.Config.RGB_565);
            new Canvas(a).drawColor(-65536);
        }
        return new LoadedImage(a, SystemUtil.getDensity(this.f24010b.getMapContext().getAndroidContext()), 0.5f, 0.5f);
    }

    public Bitmap onLoadTextBitmap(String str, int i, int i2, int i3, int i4, boolean z) {
        boolean z2 = this.f24016h < i3 || this.f24015g < i2;
        if (this.f24014f == null || z2) {
            int i5 = this.f24015g;
            if (i2 > i5) {
                i5 = i2;
            }
            this.f24015g = i5;
            int i6 = this.f24016h;
            if (i3 > i6) {
                i6 = i3;
            }
            this.f24016h = i6;
            Bitmap createBitmap = Bitmap.createBitmap(this.f24015g, i6, Bitmap.Config.ALPHA_8);
            this.f24014f = createBitmap;
            this.f24018j.setBitmap(createBitmap);
        }
        Paint a = m17083a(i);
        this.f24014f.eraseColor(0);
        a.setFakeBoldText(z);
        this.f24018j.drawText(str, ((float) i2) / 2.0f, (((float) i3) / 2.0f) - ((a.descent() + a.ascent()) / 2.0f), a);
        return this.f24014f;
    }

    public PointF onGetTextSize(String str, int i, boolean z) {
        Paint a = m17083a(i);
        this.f24017i.x = a.measureText(str) + 1.0f;
        this.f24017i.y = (float) (i + 2);
        return this.f24017i;
    }

    public void onDownload(String str) {
        MapDataUpdateHandler mapDataUpdateHandler = this.f24010b.f23882c;
        GLBaseMapView gLBaseMapView = this.f24010b;
        mapDataUpdateHandler.onUpdateBaseMapData(gLBaseMapView, gLBaseMapView.f23883d, str);
    }

    public void onLabelOnRouteNew(List<TextLableOnRoute> list) {
        GLBaseMapView.LabelOnRouteCallback labelOnRouteCallback = this.f24010b.f23888i;
        if (labelOnRouteCallback != null) {
            labelOnRouteCallback.onRouteNew(list);
        }
    }

    public void onDownloadDynamicLayer(boolean z, String str, byte[] bArr, int i) {
        GLBaseMapView gLBaseMapView = this.f24010b;
        if (gLBaseMapView != null && gLBaseMapView.f23882c != null) {
            MapDataUpdateHandler mapDataUpdateHandler = this.f24010b.f23882c;
            GLBaseMapView gLBaseMapView2 = this.f24010b;
            mapDataUpdateHandler.onDownloadDynamicLayer(gLBaseMapView2, gLBaseMapView2.f23883d, z, str, bArr);
        }
    }

    public void onWriteFile(String str, byte[] bArr) {
        HWThreadPool.execute(new EngineCallbackImpl$1(this, str, bArr));
    }

    /* renamed from: a */
    private Paint m17083a(int i) {
        if (this.f24012d == null) {
            Paint paint = new Paint();
            this.f24012d = paint;
            paint.setTypeface(Typeface.DEFAULT);
            this.f24012d.setAntiAlias(true);
            this.f24012d.setStyle(Paint.Style.FILL);
            this.f24012d.setTextAlign(Paint.Align.CENTER);
            this.f24012d.setLinearText(true);
            this.f24013e = this.f24012d.getTextSize();
        }
        float f = (float) i;
        if (this.f24013e != f) {
            this.f24012d.setTextSize(f);
            this.f24013e = f;
        }
        return this.f24012d;
    }
}
