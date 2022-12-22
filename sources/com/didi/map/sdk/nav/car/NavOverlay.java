package com.didi.map.sdk.nav.car;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.didi.common.map.Map;
import com.didi.common.map.model.BitmapDescriptor;

public class NavOverlay extends ImageView {

    /* renamed from: d */
    private static int f28414d;

    /* renamed from: a */
    private float f28415a;

    /* renamed from: b */
    private float f28416b;

    /* renamed from: c */
    private BitmapDescriptor f28417c;

    public NavOverlay(Context context) {
        super(context);
        this.f28415a = 0.5f;
        this.f28416b = 0.66f;
    }

    public NavOverlay(Context context, int i) {
        this(context);
        f28414d = i;
    }

    public void setIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.f28417c = bitmapDescriptor;
            setImageBitmap(bitmapDescriptor.getBitmap());
        }
    }

    public BitmapDescriptor getIcon() {
        return this.f28417c;
    }

    public void setAnchor(float f, float f2) {
        this.f28415a = f;
        this.f28416b = f2;
    }

    public float getAnchorX() {
        return this.f28415a;
    }

    public float getAnchorY() {
        return this.f28416b;
    }

    public void setRotation(float f) {
        setPivotX((float) (getWidth() / 2));
        setPivotY((float) (getHeight() / 2));
        setRotation(f);
    }

    public void setVisible(boolean z) {
        setVisibility(z ? 0 : 8);
    }

    public static void addToMapView(NavOverlay navOverlay, Map map) {
        View view;
        if (map != null && navOverlay != null && navOverlay.getIcon() != null && (view = map.getView()) != null && (view instanceof FrameLayout)) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = (int) (((((float) ((map.getWidth() - map.getPadding().left) - map.getPadding().right)) * navOverlay.getAnchorX()) - ((float) (navOverlay.getIcon().getBitmap().getWidth() / 2))) + ((float) map.getPadding().left));
            layoutParams.topMargin = (int) (((((float) map.getHeight()) * navOverlay.getAnchorY()) - ((float) (navOverlay.getIcon().getBitmap().getHeight() / 2))) + ((float) f28414d));
            ((FrameLayout) view).addView(navOverlay, layoutParams);
        }
    }

    public static void removeFromMapView(NavOverlay navOverlay, Map map) {
        View view;
        if (map != null && navOverlay != null && (view = map.getView()) != null && (view instanceof FrameLayout)) {
            ((FrameLayout) view).removeView(navOverlay);
        }
    }

    public void setMargin(int i, int i2, int i3, int i4, int i5) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = (int) (((((float) i5) * getAnchorY()) - ((float) (getIcon().getBitmap().getHeight() / 2))) + ((float) i2));
        }
    }
}
