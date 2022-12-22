package com.didi.map.global.component;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.Circle;
import com.didi.common.map.model.CircleOptions;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.util.MapUtils;
import java.util.ArrayList;
import java.util.List;

public class CircleTip implements ICircleTipComponent {

    /* renamed from: a */
    private CircleTipParam f17674a;

    /* renamed from: b */
    private Circle f17675b;

    /* renamed from: c */
    private Marker f17676c;

    /* renamed from: d */
    private ValueAnimator f17677d;

    /* renamed from: e */
    private Context f17678e;

    /* renamed from: f */
    private Map f17679f;

    public void onMapVisible(boolean z) {
    }

    public void create(Context context, Map map) {
        this.f17678e = context;
        this.f17679f = map;
        m13161a();
    }

    public void destroy() {
        m13166d();
        m13165c();
        ValueAnimator valueAnimator = this.f17677d;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.f17677d.cancel();
            this.f17677d = null;
        }
        this.f17679f = null;
        this.f17678e = null;
        this.f17674a = null;
    }

    public void setConfigParam(CircleTipParam circleTipParam) {
        this.f17674a = circleTipParam;
    }

    public List<IMapElement> getBestViewElements() {
        ArrayList arrayList = new ArrayList();
        Circle circle = this.f17675b;
        if (circle != null) {
            arrayList.add(circle);
        }
        Marker marker = this.f17676c;
        if (marker != null) {
            arrayList.add(marker);
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m13161a() {
        CircleTipParam circleTipParam;
        if (!(this.f17679f == null || (circleTipParam = this.f17674a) == null)) {
            Circle circle = this.f17675b;
            if (circle == null) {
                CircleOptions circleOptions = new CircleOptions();
                circleOptions.center(this.f17674a.mCenter);
                if (this.f17674a.isUsingZIndex) {
                    circleOptions.zIndex(this.f17674a.zIndex);
                }
                circleOptions.fillColor(Color.argb(0, Color.red(this.f17674a.fillColor), Color.green(this.f17674a.fillColor), Color.blue(this.f17674a.fillColor)));
                circleOptions.strokeColor(Color.argb(0, Color.red(this.f17674a.strokeColor), Color.green(this.f17674a.fillColor), Color.blue(this.f17674a.strokeColor)));
                circleOptions.strokeWidth((float) this.f17674a.strokeWidthInPixel);
                circleOptions.radius(this.f17674a.radiusInMeters);
                this.f17675b = this.f17679f.addCircle(circleOptions);
                m13164b();
            } else {
                circle.setCenter(circleTipParam.mCenter);
            }
        }
        m13163a(this.f17675b);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m13164b() {
        /*
            r7 = this;
            com.didi.map.global.component.CircleTipParam r0 = r7.f17674a
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            int r0 = r0.fillColor
            com.didi.map.global.component.CircleTipParam r1 = r7.f17674a
            int r1 = r1.strokeColor
            com.didi.map.global.component.IntArrayEvaluator r2 = new com.didi.map.global.component.IntArrayEvaluator
            r2.<init>()
            r3 = 2
            java.lang.Object[] r4 = new java.lang.Object[r3]
            int[] r5 = new int[r3]
            r5 = {0, 0} // fill-array
            r6 = 0
            r4[r6] = r5
            int[] r3 = new int[r3]
            int r5 = android.graphics.Color.alpha(r0)
            r3[r6] = r5
            int r5 = android.graphics.Color.alpha(r1)
            r6 = 1
            r3[r6] = r5
            r4[r6] = r3
            android.animation.ValueAnimator r2 = android.animation.ValueAnimator.ofObject(r2, r4)
            r7.f17677d = r2
            r3 = 300(0x12c, double:1.48E-321)
            r2.setDuration(r3)
            android.animation.ValueAnimator r2 = r7.f17677d
            com.didi.map.global.component.-$$Lambda$CircleTip$t3E0D2zuVpFkCuot7I6TD6ro3t4 r3 = new com.didi.map.global.component.-$$Lambda$CircleTip$t3E0D2zuVpFkCuot7I6TD6ro3t4
            r3.<init>(r0, r1)
            r2.addUpdateListener(r3)
            android.animation.ValueAnimator r0 = r7.f17677d
            r0.start()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.component.CircleTip.m13164b():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m13162a(int i, int i2, ValueAnimator valueAnimator) {
        int[] iArr = (int[]) valueAnimator.getAnimatedValue();
        Circle circle = this.f17675b;
        if (circle != null) {
            circle.setFillColor(Color.argb(iArr[0], Color.red(i), Color.green(i), Color.blue(i)));
            this.f17675b.setStrokeColor(Color.argb(iArr[1], Color.red(i2), Color.green(i2), Color.blue(i2)));
        }
        Marker marker = this.f17676c;
        if (marker != null) {
            marker.setAlpha(valueAnimator.getAnimatedFraction());
        }
    }

    /* renamed from: a */
    private void m13163a(Circle circle) {
        if (this.f17674a.mViewTip != null && circle != null && this.f17679f != null) {
            Marker marker = this.f17676c;
            if (marker == null) {
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.anchor(0.5f, 0.7f);
                Circle circle2 = this.f17675b;
                if (circle2 != null) {
                    markerOptions.zIndex(circle2.getZIndex() + 1);
                }
                markerOptions.position(this.f17675b.getBottomTangencyPoint());
                markerOptions.icon(BitmapDescriptorFactory.fromBitmap(MapUtils.getViewBitmap(this.f17674a.mViewTip)));
                this.f17676c = this.f17679f.addMarker(markerOptions);
                return;
            }
            marker.setPosition(this.f17675b.getBottomTangencyPoint());
        }
    }

    /* renamed from: c */
    private void m13165c() {
        Map map;
        Marker marker = this.f17676c;
        if (marker != null && (map = this.f17679f) != null) {
            map.remove(marker);
            this.f17676c = null;
        }
    }

    /* renamed from: d */
    private void m13166d() {
        Map map;
        Circle circle = this.f17675b;
        if (circle != null && (map = this.f17679f) != null) {
            map.remove(circle);
            this.f17675b = null;
        }
    }
}
