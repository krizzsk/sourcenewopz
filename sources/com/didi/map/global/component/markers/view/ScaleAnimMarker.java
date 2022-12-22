package com.didi.map.global.component.markers.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.view.animation.Interpolator;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.didi.common.map.Map;
import com.didi.common.map.MapVendor;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.util.DLog;
import com.didi.map.sdk.component.IBaseComponent;
import java.util.ArrayList;
import java.util.List;

public class ScaleAnimMarker implements IBaseComponent<ScaleMarkerParam> {

    /* renamed from: a */
    private Canvas f26026a;

    /* renamed from: b */
    private ValueAnimator f26027b;

    /* renamed from: c */
    private Interpolator f26028c;

    /* renamed from: d */
    private Matrix f26029d;

    /* renamed from: e */
    private Paint f26030e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Marker f26031f;

    /* renamed from: g */
    private Context f26032g;

    /* renamed from: h */
    private Map f26033h;

    /* renamed from: i */
    private Bitmap f26034i;

    /* renamed from: j */
    private Bitmap f26035j;

    /* renamed from: k */
    private Bitmap f26036k;

    /* renamed from: l */
    private int f26037l = 500;

    /* renamed from: m */
    private ScaleMarkerParam f26038m;

    /* renamed from: n */
    private String f26039n = "ScaleAnimMarker";

    /* renamed from: o */
    private boolean f26040o = true;

    public void onMapVisible(boolean z) {
    }

    public void create(Context context, Map map) {
        this.f26032g = context;
        this.f26033h = map;
        if (map != null && map.getMapVendor() == MapVendor.HUAWEI) {
            boolean unused = this.f26038m.hasScaleAnim = false;
        }
        if (this.f26038m.hasScaleAnim) {
            m18479a();
        }
        if (this.f26033h != null && MapVendor.DIDI == this.f26033h.getMapVendor()) {
            this.f26040o = false;
        }
        m18482b();
    }

    public void destroy() {
        m18483b(false);
        Marker marker = this.f26031f;
        if (marker != null) {
            this.f26033h.remove(marker);
            this.f26031f.remove();
            this.f26031f = null;
        }
        ValueAnimator valueAnimator = this.f26027b;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f26027b.removeAllUpdateListeners();
            this.f26027b = null;
        }
        if (this.f26034i != null) {
            this.f26034i = null;
        }
        Bitmap bitmap = this.f26036k;
        if (bitmap != null) {
            if (this.f26040o) {
                bitmap.recycle();
            }
            this.f26036k = null;
        }
        Bitmap bitmap2 = this.f26035j;
        if (bitmap2 != null) {
            if (this.f26040o) {
                bitmap2.recycle();
            }
            this.f26035j = null;
        }
        this.f26026a = null;
        this.f26029d = null;
        this.f26030e = null;
    }

    public void setConfigParam(ScaleMarkerParam scaleMarkerParam) {
        if (scaleMarkerParam != null) {
            this.f26038m = scaleMarkerParam;
            this.f26034i = scaleMarkerParam.markerIcon;
        }
    }

    /* renamed from: a */
    private void m18479a() {
        this.f26029d = new Matrix();
        this.f26030e = new Paint();
        Bitmap bitmap = this.f26034i;
        if (bitmap == null || bitmap.isRecycled()) {
            DLog.m7384d(this.f26039n, "icon 参数为空", new Object[0]);
            return;
        }
        int width = this.f26034i.getWidth();
        int height = this.f26034i.getHeight();
        this.f26036k = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_4444);
        this.f26035j = Bitmap.createScaledBitmap(this.f26034i, width, height, true);
        Canvas canvas = new Canvas(this.f26036k);
        this.f26026a = canvas;
        canvas.setMatrix(this.f26029d);
    }

    /* renamed from: a */
    private void m18480a(Bitmap bitmap, LatLng latLng, int i) {
        if (latLng == null || this.f26033h == null || bitmap == null || bitmap.isRecycled()) {
            DLog.m7384d(this.f26039n, "scaleMarkerParam 参数异常", new Object[0]);
            return;
        }
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        if (i != 0) {
            markerOptions.zIndex(i);
        }
        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(bitmap));
        this.f26031f = this.f26033h.addMarker(markerOptions);
    }

    /* renamed from: b */
    private void m18482b() {
        ScaleMarkerParam scaleMarkerParam = this.f26038m;
        if (scaleMarkerParam == null) {
            return;
        }
        if (!scaleMarkerParam.hasScaleAnim) {
            m18480a(this.f26034i, this.f26038m.latLng, this.f26038m.zIndex);
            return;
        }
        Bitmap createScaleBitmap = createScaleBitmap(0.01f);
        if (createScaleBitmap != null) {
            m18480a(createScaleBitmap, this.f26038m.latLng, this.f26038m.zIndex);
        }
    }

    /* renamed from: a */
    private void m18481a(boolean z) {
        if (this.f26028c == null) {
            this.f26028c = PathInterpolatorCompat.create(0.3f, 0.2f, 0.1f, 1.0f);
        }
        ValueAnimator valueAnimator = this.f26027b;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f26027b.cancel();
            this.f26027b.removeAllUpdateListeners();
        }
        if (z) {
            ValueAnimator ofFloat = ObjectAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.f26027b = ofFloat;
            ofFloat.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    if (ScaleAnimMarker.this.f26031f != null) {
                        ScaleAnimMarker.this.f26031f.setVisible(true);
                    }
                }
            });
        } else {
            ValueAnimator ofFloat2 = ObjectAnimator.ofFloat(new float[]{1.0f, 0.0f});
            this.f26027b = ofFloat2;
            ofFloat2.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    if (ScaleAnimMarker.this.f26031f != null) {
                        ScaleAnimMarker.this.f26031f.setVisible(false);
                    }
                }
            });
        }
        this.f26027b.setDuration((long) this.f26037l);
        this.f26027b.setRepeatCount(0);
        this.f26027b.setInterpolator(this.f26028c);
        this.f26027b.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Bitmap createScaleBitmap = ScaleAnimMarker.this.createScaleBitmap(((Float) valueAnimator.getAnimatedValue()).floatValue());
                if (createScaleBitmap != null) {
                    ScaleAnimMarker.this.setMarkerIcon(createScaleBitmap);
                }
            }
        });
    }

    /* renamed from: b */
    private void m18483b(boolean z) {
        ValueAnimator valueAnimator = this.f26027b;
        if (valueAnimator == null) {
            return;
        }
        if (z) {
            valueAnimator.start();
        } else {
            valueAnimator.cancel();
        }
    }

    public void setMarkerIcon(Bitmap bitmap) {
        Context context;
        Marker marker = this.f26031f;
        if (marker != null && (context = this.f26032g) != null) {
            marker.setIcon(context, BitmapDescriptorFactory.fromBitmap(bitmap));
            if (this.f26038m.getzIndex() != 0) {
                this.f26031f.setZIndex(this.f26038m.getzIndex());
            }
        }
    }

    public void showMarker(LatLng latLng) {
        if (this.f26038m != null && this.f26033h != null) {
            Marker marker = this.f26031f;
            if (marker == null) {
                m18482b();
            } else {
                marker.setVisible(true);
            }
            if (latLng != null) {
                this.f26038m.setLatLng(latLng);
                updatePosition(latLng);
            }
            if (this.f26038m.hasScaleAnim) {
                m18481a(true);
                m18483b(true);
            }
        }
    }

    public void hideMarker(boolean z) {
        Map map;
        if (this.f26031f != null && (map = this.f26033h) != null) {
            if (!z || map.getMapVendor() == MapVendor.HUAWEI) {
                this.f26031f.setVisible(false);
                return;
            }
            m18481a(false);
            m18483b(true);
        }
    }

    public void updatePosition(LatLng latLng) {
        Marker marker = this.f26031f;
        if (marker != null && latLng != null) {
            float a = m18477a(marker.getPosition(), latLng);
            if (a != 0.0f) {
                this.f26031f.setRotation(a % 360.0f);
            }
            this.f26031f.setPosition(latLng);
        }
    }

    public void updateIcon(Bitmap bitmap) {
        Marker marker = this.f26031f;
        if (marker != null && marker.isVisible()) {
            this.f26034i = bitmap;
            setMarkerIcon(bitmap);
        }
    }

    public List<IMapElement> getMarkerElements() {
        ArrayList arrayList = new ArrayList();
        Marker marker = this.f26031f;
        if (marker != null) {
            arrayList.add(marker);
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public Bitmap createScaleBitmap(float f) {
        Bitmap bitmap;
        Bitmap bitmap2;
        if (this.f26029d == null || this.f26026a == null || this.f26030e == null || (bitmap = this.f26035j) == null || bitmap.isRecycled() || (bitmap2 = this.f26036k) == null || bitmap2.isRecycled()) {
            return null;
        }
        this.f26026a.drawColor(0, PorterDuff.Mode.CLEAR);
        this.f26029d.setScale(f, f, (float) (this.f26035j.getWidth() / 2), (float) (this.f26035j.getHeight() / 2));
        this.f26026a.drawBitmap(this.f26035j, this.f26029d, this.f26030e);
        return this.f26036k;
    }

    /* renamed from: a */
    private float m18477a(LatLng latLng, LatLng latLng2) {
        if (latLng == null || latLng2 == null) {
            return 0.0f;
        }
        return (float) (90.0d - ((Math.atan2(latLng2.latitude - latLng.latitude, latLng2.longitude - latLng.longitude) / 3.141592653589793d) * 180.0d));
    }

    public static class ScaleMarkerParam {
        /* access modifiers changed from: private */
        public boolean hasScaleAnim;
        /* access modifiers changed from: private */
        public LatLng latLng;
        /* access modifiers changed from: private */
        public Bitmap markerIcon;
        /* access modifiers changed from: private */
        public int zIndex;

        public ScaleMarkerParam(LatLng latLng2, Bitmap bitmap, boolean z) {
            this.latLng = latLng2;
            this.markerIcon = bitmap;
            this.hasScaleAnim = z;
        }

        public LatLng getLatLng() {
            return this.latLng;
        }

        public Bitmap getMarkerIcon() {
            return this.markerIcon;
        }

        public void setLatLng(LatLng latLng2) {
            this.latLng = latLng2;
        }

        public void setMarkerIcon(Bitmap bitmap) {
            this.markerIcon = bitmap;
        }

        public int getzIndex() {
            return this.zIndex;
        }

        public void setzIndex(int i) {
            this.zIndex = i;
        }

        public boolean isHasScaleAnim() {
            return this.hasScaleAnim;
        }

        public void setHasScaleAnim(boolean z) {
            this.hasScaleAnim = z;
        }
    }
}
