package com.didi.hawaii.mapsdkv2.adapter;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.FrameLayout;
import com.didi.hawaii.utils.BitmapUtil;
import com.didi.map.outer.map.MapView;

/* renamed from: com.didi.hawaii.mapsdkv2.adapter.c */
/* compiled from: ViewBitmapGenerator */
final class C9004c {

    /* renamed from: a */
    private final MapView f23762a;

    /* renamed from: b */
    private View f23763b;

    C9004c(MapView mapView) {
        this.f23762a = mapView;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Bitmap mo69651a(View view) {
        if (view == null) {
            return null;
        }
        View view2 = this.f23763b;
        if (view2 == view) {
            return BitmapUtil.convertViewToBitmap(view);
        }
        if (!(view2 == null || view2.getParent() == null || this.f23762a.indexOfChild(this.f23763b) <= 0)) {
            this.f23762a.removeView(this.f23763b);
        }
        this.f23762a.addView(view, new FrameLayout.LayoutParams(-2, -2));
        view.setVisibility(4);
        this.f23763b = view;
        return BitmapUtil.convertViewToBitmap(view);
    }
}
