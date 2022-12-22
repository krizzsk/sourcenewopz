package com.didi.map.global.component.markers.view;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.ImageUtil;
import com.didi.map.sdk.component.IBaseComponent;
import java.util.ArrayList;
import java.util.List;

public class BreathAnimMarker implements IBaseComponent<BreathMarkerParam> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ValueAnimator f25976a;

    /* renamed from: b */
    private Marker f25977b;

    /* renamed from: c */
    private Map f25978c;

    /* renamed from: d */
    private Context f25979d;

    /* renamed from: e */
    private int f25980e = 1000;

    /* renamed from: f */
    private BreathMarkerParam f25981f;

    /* renamed from: g */
    private MarkerModel f25982g;

    /* renamed from: h */
    private Bitmap f25983h;

    public void onMapVisible(boolean z) {
    }

    public Marker getMarker() {
        return this.f25977b;
    }

    public void playAnimation(boolean z) {
        ValueAnimator valueAnimator = this.f25976a;
        if (valueAnimator == null) {
            return;
        }
        if (z) {
            m18469a();
            this.f25976a.start();
            return;
        }
        valueAnimator.removeAllUpdateListeners();
        this.f25976a.cancel();
        setMarkerIcon(this.f25983h);
    }

    public void create(Context context, Map map) {
        this.f25979d = context;
        this.f25978c = map;
        BreathMarkerParam breathMarkerParam = this.f25981f;
        if (breathMarkerParam != null && breathMarkerParam.model != null) {
            MarkerModel access$000 = this.f25981f.model;
            this.f25982g = access$000;
            this.f25983h = access$000.getMarkerIcon();
            this.f25980e = this.f25981f.scaleAnimDuration;
            m18469a();
        }
    }

    public void destroy() {
        ValueAnimator valueAnimator = this.f25976a;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.f25976a.cancel();
            this.f25976a = null;
        }
        Map map = this.f25978c;
        if (map != null) {
            map.remove(this.f25977b);
        }
        this.f25977b = null;
    }

    public void setConfigParam(BreathMarkerParam breathMarkerParam) {
        this.f25981f = breathMarkerParam;
    }

    /* renamed from: a */
    private Marker m18468a(MarkerModel markerModel) {
        if (this.f25978c == null || this.f25979d == null || markerModel == null || markerModel.getPoint() == null) {
            return null;
        }
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(markerModel.getPoint()).anchor(markerModel.getAnchorU(), markerModel.getAnchorV()).icon(BitmapDescriptorFactory.fromBitmap(markerModel.getMarkerIcon())).draggable(false);
        if (markerModel.getZOrder() != 0) {
            markerOptions.zIndex(markerModel.getZOrder());
        }
        return this.f25978c.addMarker(markerOptions);
    }

    /* renamed from: a */
    private void m18469a() {
        BreathMarkerParam breathMarkerParam = this.f25981f;
        if (breathMarkerParam != null && this.f25976a == null) {
            float access$200 = breathMarkerParam.scaleMin;
            float access$300 = this.f25981f.scaleMax;
            if (access$200 != access$300) {
                ValueAnimator ofFloat = ObjectAnimator.ofFloat(new float[]{access$200, access$300});
                this.f25976a = ofFloat;
                ofFloat.setDuration((long) this.f25980e);
                this.f25976a.setRepeatMode(2);
                this.f25976a.setRepeatCount(-1);
                this.f25976a.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f));
                this.f25976a.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if (BreathAnimMarker.this.f25976a != null && BreathAnimMarker.this.f25976a.isRunning()) {
                            BreathAnimMarker.this.drawBitmapToMarker(valueAnimator);
                        }
                    }
                });
                return;
            }
            setMarkerIcon(this.f25983h);
        }
    }

    public void setMarkerIcon(Bitmap bitmap) {
        if (this.f25978c != null && this.f25979d != null && this.f25982g != null) {
            if (bitmap == null || bitmap.isRecycled()) {
                DLog.m7384d("start point ", "bitmap is null or recycled", new Object[0]);
                return;
            }
            Marker marker = this.f25977b;
            if (marker == null) {
                this.f25982g.setMarkerIcon(bitmap);
                this.f25977b = m18468a(this.f25982g);
                return;
            }
            marker.setIcon(this.f25979d, BitmapDescriptorFactory.fromBitmap(bitmap));
        }
    }

    /* access modifiers changed from: protected */
    public void drawBitmapToMarker(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        Bitmap bitmap = this.f25983h;
        if (bitmap != null && !bitmap.isRecycled()) {
            setMarkerIcon(ImageUtil.scale(this.f25983h, ((float) this.f25983h.getWidth()) * floatValue, ((float) this.f25983h.getHeight()) * floatValue, ImageView.ScaleType.CENTER_CROP, false));
        }
    }

    public List<IMapElement> getMarkerElements() {
        ArrayList arrayList = new ArrayList();
        Marker marker = this.f25977b;
        if (marker != null) {
            arrayList.add(marker);
        }
        return arrayList;
    }

    public static class BreathMarkerParam {
        /* access modifiers changed from: private */
        public MarkerModel model;
        /* access modifiers changed from: private */
        public int scaleAnimDuration;
        /* access modifiers changed from: private */
        public float scaleMax;
        /* access modifiers changed from: private */
        public float scaleMin;

        public MarkerModel getModel() {
            return this.model;
        }

        public void setModel(MarkerModel markerModel) {
            this.model = markerModel;
        }

        public int getScaleAnimDuration() {
            return this.scaleAnimDuration;
        }

        public void setScaleAnimDuration(int i) {
            this.scaleAnimDuration = i;
        }

        public float getScaleMin() {
            return this.scaleMin;
        }

        public void setScaleMin(float f) {
            this.scaleMin = f;
        }

        public float getScaleMax() {
            return this.scaleMax;
        }

        public void setScaleMax(float f) {
            this.scaleMax = f;
        }

        public BreathMarkerParam(MarkerModel markerModel, int i, float f, float f2) {
            this.model = markerModel;
            this.scaleAnimDuration = i;
            this.scaleMin = f;
            this.scaleMax = f2;
        }
    }
}
