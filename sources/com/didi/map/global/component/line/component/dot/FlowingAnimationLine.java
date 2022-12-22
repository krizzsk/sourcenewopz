package com.didi.map.global.component.line.component.dot;

import android.animation.Animator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.animation.LinearInterpolator;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.listener.OnCameraChangeListener;
import com.didi.common.map.listener.OnMapGestureListener;
import com.didi.common.map.listener.OnMarkerClickListener;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.CameraPosition;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.DisplayUtils;
import com.didi.map.global.component.line.component.ICompLineContract;
import com.didi.map.global.component.line.component.LineParams;
import com.didi.map.global.component.line.component.OnLineClickListener;
import com.didi.map.global.component.line.component.OnLineDrawStatusListener;
import com.didi.map.global.component.line.utils.DouglasUtil;
import com.didi.map.global.component.line.utils.LineUtils;
import com.didi.trackupload.sdk.Constants;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FlowingAnimationLine implements ICompLineContract {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f25708a = FlowingAnimationLine.class.getSimpleName();

    /* renamed from: m */
    private static final long f25709m = 50;

    /* renamed from: n */
    private static final long f25710n = 500;

    /* renamed from: b */
    private LineParams f25711b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Map f25712c;

    /* renamed from: d */
    private Context f25713d;

    /* renamed from: e */
    private List<Marker> f25714e = new ArrayList();

    /* renamed from: f */
    private double f25715f;

    /* renamed from: g */
    private boolean f25716g = true;

    /* renamed from: h */
    private List<LatLng> f25717h;

    /* renamed from: i */
    private OnLineDrawStatusListener f25718i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f25719j;

    /* renamed from: k */
    private boolean f25720k = false;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f25721l = false;

    /* renamed from: o */
    private long f25722o;

    /* renamed from: p */
    private OnCameraChangeListener f25723p;

    /* renamed from: q */
    private OnMapGestureListener f25724q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public double f25725r;

    /* renamed from: s */
    private Handler f25726s = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            if (message.what == 13) {
                DLog.m7384d(FlowingAnimationLine.f25708a, "handleMessage:MSG_SHOW", new Object[0]);
                if (FlowingAnimationLine.this.f25712c != null && Math.abs(FlowingAnimationLine.this.f25725r - FlowingAnimationLine.this.f25712c.getCameraPosition().zoom) > 0.5d) {
                    FlowingAnimationLine flowingAnimationLine = FlowingAnimationLine.this;
                    double unused = flowingAnimationLine.f25725r = flowingAnimationLine.f25712c.getCameraPosition().zoom;
                    if (!FlowingAnimationLine.this.f25719j) {
                        boolean unused2 = FlowingAnimationLine.this.f25721l = true;
                        FlowingAnimationLine.this.start();
                        boolean unused3 = FlowingAnimationLine.this.f25721l = false;
                    }
                }
            }
        }
    };

    public void onMapVisible(boolean z) {
    }

    public void stop() {
    }

    public void create(Context context, Map map) {
        this.f25712c = map;
        this.f25713d = context;
    }

    public void setConfigParam(LineParams lineParams) {
        if (lineParams != null) {
            this.f25711b = lineParams;
            this.f25717h = lineParams.getLinePoints();
            this.f25715f = (double) DisplayUtils.dp2px(this.f25713d, lineParams.getDotSpace());
            if (!this.f25720k && lineParams.getExParam() != null && lineParams.getExParam().isHasDotLineZoomListener()) {
                this.f25720k = true;
                m18345b();
            }
        }
    }

    public List<IMapElement> getBestViewElements() {
        ArrayList arrayList = new ArrayList();
        if (!CollectionUtil.isEmpty((Collection<?>) this.f25714e)) {
            for (Marker next : this.f25714e) {
                if (next.isVisible()) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public void setListener(OnLineDrawStatusListener onLineDrawStatusListener) {
        this.f25718i = onLineDrawStatusListener;
    }

    public void setLineVisible(boolean z) {
        this.f25716g = z;
        if (!CollectionUtil.isEmpty((Collection<?>) this.f25714e)) {
            for (Marker next : this.f25714e) {
                if (next != null) {
                    next.setVisible(z);
                }
            }
        }
    }

    public void setLineClickListener(OnLineClickListener onLineClickListener) {
        Map map = this.f25712c;
        if (map != null && onLineClickListener != null) {
            map.addOnMarkerClickListener(new OnMarkerClickListener(onLineClickListener) {
                public final /* synthetic */ OnLineClickListener f$1;

                {
                    this.f$1 = r2;
                }

                public final boolean onMarkerClick(Marker marker) {
                    return FlowingAnimationLine.this.m18342a(this.f$1, marker);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ boolean m18342a(OnLineClickListener onLineClickListener, Marker marker) {
        if (CollectionUtil.isEmpty((Collection<?>) this.f25714e)) {
            return false;
        }
        for (Marker marker2 : this.f25714e) {
            if (marker2 == marker) {
                onLineClickListener.onLineClick(this);
                return true;
            }
        }
        return false;
    }

    public void start() {
        BitmapDescriptor bitmapDescriptor;
        OnLineDrawStatusListener onLineDrawStatusListener;
        if (LineUtils.INSTANCE.isMainThread()) {
            if (this.f25712c == null || this.f25713d == null || CollectionUtil.isEmpty((Collection<?>) this.f25717h) || this.f25714e == null) {
                DLog.m7384d(f25708a, "showFlowingAnimation:return2", new Object[0]);
                return;
            }
            if (this.f25725r == 0.0d) {
                this.f25725r = this.f25712c.getCameraPosition().zoom;
            }
            clear();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            arrayList.addAll(this.f25717h);
            DouglasUtil douglasUtil = new DouglasUtil(this.f25712c.getProjection());
            douglasUtil.setThreshold(5);
            arrayList2.addAll(douglasUtil.getDouglasOptimiseLatLngs(arrayList));
            List<LatLng> a = m18337a((List<LatLng>) arrayList2);
            DLog.m7384d(f25708a, "originalRoutes:%d, douglasRoutes:%d, fillRoutes:%d", Integer.valueOf(arrayList.size()), Integer.valueOf(arrayList2.size()), Integer.valueOf(a.size()));
            LineParams lineParams = this.f25711b;
            if (lineParams == null || lineParams.getDottedIconRes() == 0) {
                bitmapDescriptor = BitmapDescriptorFactory.fromResource(this.f25713d, R.drawable.blue_dot);
            } else {
                bitmapDescriptor = BitmapDescriptorFactory.fromResource(this.f25713d, this.f25711b.getDottedIconRes());
            }
            for (int i = 0; i < a.size(); i++) {
                MarkerOptions markerOptions = new MarkerOptions();
                if (this.f25711b.isClickable()) {
                    markerOptions.clickable(this.f25711b.isClickable());
                }
                markerOptions.position(a.get(i));
                markerOptions.icon(bitmapDescriptor);
                markerOptions.draggable(false);
                markerOptions.anchor(0.5f, 0.5f);
                Marker addMarker = this.f25712c.addMarker(markerOptions);
                if (addMarker != null) {
                    addMarker.setVisible(this.f25716g);
                    this.f25714e.add(addMarker);
                }
            }
            for (int i2 = 0; i2 < this.f25714e.size(); i2++) {
                m18341a(a, i2, this.f25714e.get(i2), this.f25711b.getExParam() != null ? (long) this.f25711b.getExParam().getPulseAnimDuration() : Constants.SUBTITUDE_LOC_EFFECTIVE_TIME);
            }
            if (!this.f25721l && (onLineDrawStatusListener = this.f25718i) != null) {
                onLineDrawStatusListener.onLineDrawFinished();
                return;
            }
            return;
        }
        throw new RuntimeException("don't run main thread.");
    }

    public void updateLinePoints(List<LatLng> list) {
        this.f25717h = list;
        start();
    }

    public List<LatLng> getAllLinePoints() {
        return this.f25717h;
    }

    /* renamed from: a */
    private List<LatLng> m18337a(List<LatLng> list) {
        Map map;
        List<LatLng> list2 = list;
        ArrayList arrayList = new ArrayList();
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            arrayList.add(list2.get(0));
            if (list.size() > 1) {
                LatLng latLng = null;
                int i = 0;
                for (int i2 = 1; i < list.size() - i2; i2 = 1) {
                    LatLng latLng2 = list2.get(i);
                    int i3 = i + 1;
                    LatLng latLng3 = list2.get(i3);
                    double computeDistanceBetween = DDSphericalUtil.computeDistanceBetween(latLng2, latLng3);
                    double d = (latLng3.latitude - latLng2.latitude) / computeDistanceBetween;
                    double d2 = (latLng3.longitude - latLng2.longitude) / computeDistanceBetween;
                    int i4 = i3;
                    latLng = latLng;
                    int i5 = 0;
                    while (true) {
                        double d3 = (double) i5;
                        if (d3 >= computeDistanceBetween) {
                            break;
                        }
                        double d4 = computeDistanceBetween;
                        double d5 = d;
                        LatLng latLng4 = new LatLng(latLng2.latitude + (d * d3), latLng2.longitude + (d3 * d2));
                        if (!(latLng == null || (map = this.f25712c) == null || map.getProjection() == null)) {
                            if (DouglasUtil.distance(this.f25712c.getProjection().toScreenLocation(latLng), this.f25712c.getProjection().toScreenLocation(latLng4)) < this.f25715f) {
                                i5++;
                                computeDistanceBetween = d4;
                                d = d5;
                            } else {
                                arrayList.add(latLng4);
                            }
                        }
                        latLng = latLng4;
                        i5++;
                        computeDistanceBetween = d4;
                        d = d5;
                    }
                    i = i4;
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18341a(List<LatLng> list, int i, Marker marker, long j) {
        if (this.f25714e.size() != 0 && list.size() > 1) {
            if (i == list.size() - 1) {
                i %= list.size() - 1;
            }
            final int i2 = i;
            LatLng latLng = list.get(i2);
            LatLng latLng2 = list.get(i2 + 1);
            marker.setRotation((float) DDSphericalUtil.computeHeading(latLng, latLng2));
            ValueAnimator ofObject = ValueAnimator.ofObject(new LatLngTypeEvaluator(), new Object[]{latLng, latLng2});
            ofObject.setDuration(j);
            ofObject.setInterpolator(new LinearInterpolator());
            ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FlowingAnimationLine.m18339a(Marker.this, valueAnimator);
                }
            });
            final Marker marker2 = marker;
            final List<LatLng> list2 = list;
            final long j2 = j;
            ofObject.addListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    Marker marker = marker2;
                    if (marker != null) {
                        FlowingAnimationLine.this.m18341a(list2, i2 + 1, marker, j2);
                    }
                }
            });
            ofObject.start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m18339a(Marker marker, ValueAnimator valueAnimator) {
        LatLng latLng = (LatLng) valueAnimator.getAnimatedValue();
        if (marker != null) {
            marker.setPosition(latLng);
        }
    }

    public void clear() {
        List<Marker> list;
        String str = f25708a;
        DLog.m7384d(str, this + " : stopFlowingAnimation", new Object[0]);
        if (this.f25712c != null && (list = this.f25714e) != null && !CollectionUtil.isEmpty((Collection<?>) list)) {
            for (int i = 0; i < this.f25714e.size(); i++) {
                if (this.f25714e.get(i) != null) {
                    this.f25712c.remove(this.f25714e.get(i));
                }
            }
            this.f25714e.clear();
        }
    }

    public void destroy() {
        OnCameraChangeListener onCameraChangeListener;
        this.f25719j = true;
        Map map = this.f25712c;
        if (!(map == null || (onCameraChangeListener = this.f25723p) == null || this.f25724q == null)) {
            map.removeOnCameraChangeListener(onCameraChangeListener);
            this.f25712c.removeOnMapGestureListener(this.f25724q);
        }
        clear();
    }

    private class LatLngTypeEvaluator implements TypeEvaluator<LatLng> {
        private LatLngTypeEvaluator() {
        }

        public LatLng evaluate(float f, LatLng latLng, LatLng latLng2) {
            double d = (double) f;
            return new LatLng(((latLng2.latitude - latLng.latitude) * d) + latLng.latitude, ((latLng2.longitude - latLng.longitude) * d) + latLng.longitude);
        }
    }

    /* renamed from: b */
    private void m18345b() {
        this.f25723p = new OnCameraChangeListener() {
            public final void onCameraChange(CameraPosition cameraPosition) {
                FlowingAnimationLine.this.m18338a(cameraPosition);
            }
        };
        this.f25724q = new OnMapGestureListener() {
            public boolean onDoubleTap(float f, float f2) {
                return false;
            }

            public boolean onDown(float f, float f2) {
                return false;
            }

            public boolean onFling(float f, float f2) {
                return false;
            }

            public boolean onLongPress(float f, float f2) {
                return false;
            }

            public boolean onScroll(float f, float f2) {
                return false;
            }

            public boolean onSingleTap(float f, float f2) {
                return false;
            }

            public void onMapStable() {
                FlowingAnimationLine.this.m18346c();
            }

            public boolean onUp(float f, float f2) {
                FlowingAnimationLine.this.m18346c();
                return false;
            }
        };
        Map map = this.f25712c;
        if (map != null) {
            map.addOnCameraChangeListener(this.f25723p);
            this.f25712c.addOnMapGestureListener(this.f25724q);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m18338a(CameraPosition cameraPosition) {
        if (System.currentTimeMillis() - this.f25722o > 50) {
            this.f25722o = System.currentTimeMillis();
            m18346c();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m18346c() {
        Handler handler = this.f25726s;
        if (handler != null) {
            handler.removeMessages(13);
            Message obtainMessage = this.f25726s.obtainMessage();
            obtainMessage.what = 13;
            this.f25726s.sendMessageDelayed(obtainMessage, 500);
            DLog.m7384d(f25708a, "：sendShowMessage", new Object[0]);
        }
    }
}
