package com.didi.hawaii.mapsdkv2.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.map.common.MapAssets;
import com.didi.map.outer.map.DMarker;
import com.didi.map.outer.map.DiMapInterface;
import com.taxis99.R;

/* renamed from: com.didi.hawaii.mapsdkv2.adapter.a */
/* compiled from: DefaultInfoWindowAdapter */
final class C9002a<T extends DMarker> implements DiMapInterface.IWindowAdapter<T> {

    /* renamed from: a */
    private final View[] f23756a = new View[2];

    /* renamed from: b */
    private final View[] f23757b = new View[2];

    /* renamed from: c */
    private final Context f23758c;

    /* renamed from: b */
    private void m16896b() {
    }

    C9002a(Context context) {
        this.f23758c = context;
    }

    public View[] getInfoWindow(T t) {
        m16895a();
        return this.f23756a;
    }

    public View[] getOverturnInfoWindow(T t) {
        m16896b();
        return this.f23757b;
    }

    public View getInfoContents(T t) {
        return this.f23756a[0];
    }

    /* renamed from: a */
    private void m16895a() {
        View[] viewArr = this.f23756a;
        if (viewArr[0] == null || viewArr[1] == null) {
            View inflate = LayoutInflater.from(this.f23758c).inflate(R.layout.hawaii_default_infowindow, (ViewGroup) null, false);
            Bitmap bitmapInMapDir = MapAssets.bitmapInMapDir(this.f23758c, "marker_infowindow.9.png");
            if (bitmapInMapDir != null) {
                inflate.setBackgroundDrawable(new NinePatchDrawable(this.f23758c.getResources(), bitmapInMapDir, bitmapInMapDir.getNinePatchChunk(), new Rect(), (String) null));
            }
            this.f23756a[0] = inflate;
            View inflate2 = LayoutInflater.from(this.f23758c).inflate(R.layout.hawaii_default_infowindow, (ViewGroup) null, false);
            Bitmap bitmapInMapDir2 = MapAssets.bitmapInMapDir(this.f23758c, "marker_infowindow.9.png");
            if (bitmapInMapDir2 != null) {
                inflate2.setBackgroundDrawable(new NinePatchDrawable(this.f23758c.getResources(), bitmapInMapDir2, bitmapInMapDir2.getNinePatchChunk(), new Rect(), (String) null));
            }
            this.f23756a[1] = inflate2;
        }
    }
}
