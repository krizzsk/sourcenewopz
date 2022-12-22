package com.didichuxing.carsliding.anim;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.didi.common.map.Map;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.model.animation.AlphaAnimation;
import com.didi.common.map.model.animation.AnimationListener;
import com.didi.common.map.model.animation.AnimationSet;
import com.didi.common.map.model.animation.RotateAnimation;
import com.didi.common.map.model.animation.TranslateAnimation;
import com.didichuxing.carsliding.api.CarSlidingMarkerCollection;
import com.didichuxing.carsliding.api.CarSlidingRender;
import com.didichuxing.carsliding.filter.VectorCoordinateFilter;
import com.didichuxing.carsliding.model.VectorCoordinate;
import com.didichuxing.carsliding.utils.ZIndexUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CarSlidingRenderAnimator implements ISlidingAnimator {

    /* renamed from: a */
    private static final String f46226a = CarSlidingRenderAnimator.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Marker f46227b;

    /* renamed from: c */
    private MarkerInfo f46228c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public List<SlidingMeta> f46229d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Map f46230e;

    /* renamed from: f */
    private Looper f46231f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f46232g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f46233h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public SlidingMeta f46234i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Handler f46235j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final Object f46236k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public final Object f46237l;

    public CarSlidingRenderAnimator(Map map, Looper looper) {
        this.f46229d = new ArrayList();
        this.f46236k = new Object();
        this.f46237l = new Object();
        this.f46229d = Collections.synchronizedList(new LinkedList());
        this.f46230e = map;
        this.f46231f = looper;
    }

    public void bind(MarkerInfo markerInfo, SlidingMeta slidingMeta) {
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(markerInfo.latLng).rotation(markerInfo.angle).anchor(0.5f, 0.5f).icon(markerInfo.bitmapDescriptor).draggable(false).zIndex(markerInfo.zIndex > 0 ? markerInfo.zIndex : ZIndexUtil.getZIndex(7));
        Marker addMarker = this.f46230e.addMarker(CarSlidingRender.CAR_SLIDING_MARKER_TAG, markerOptions);
        this.f46227b = addMarker;
        CarSlidingMarkerCollection.registerMarker(addMarker);
        this.f46228c = markerInfo;
        this.f46234i = slidingMeta;
        this.f46235j = new AnimHandler(this.f46231f);
    }

    public Marker get() {
        return this.f46227b;
    }

    public void updateIcon(BitmapDescriptor bitmapDescriptor) {
        Handler handler = this.f46235j;
        if (handler != null) {
            handler.obtainMessage(7, bitmapDescriptor).sendToTarget();
        }
    }

    public void insertAnimParamsCollection(List<SlidingMeta> list) {
        Handler handler = this.f46235j;
        if (handler != null) {
            handler.obtainMessage(1, list).sendToTarget();
        }
    }

    public void updatePosition(SlidingMeta slidingMeta, boolean z) {
        Handler handler = this.f46235j;
        if (handler != null) {
            handler.obtainMessage(3, z ? 1 : 0, 0, slidingMeta).sendToTarget();
        }
    }

    public void dismiss(boolean z, boolean z2) {
        Handler handler = this.f46235j;
        if (handler != null) {
            handler.obtainMessage(5, z ? 1 : 0, z2 ? 1 : 0).sendToTarget();
        }
    }

    public void display(boolean z, boolean z2) {
        Handler handler = this.f46235j;
        if (handler != null) {
            handler.obtainMessage(4, z ? 1 : 0, z2 ? 1 : 0).sendToTarget();
        }
    }

    public void destroy(boolean z) {
        Handler handler = this.f46235j;
        if (handler != null) {
            handler.obtainMessage(6, z ? 1 : 0, 0).sendToTarget();
        }
    }

    private class AnimHandler extends Handler {
        private static final int MSG_ANIM = 2;
        private static final int MSG_DESTROY = 6;
        private static final int MSG_HIDE = 5;
        private static final int MSG_INSERT = 1;
        private static final int MSG_SHOW = 4;
        private static final int MSG_UPDATE_ICON = 7;
        private static final int MSG_UPDATE_POS = 3;

        public AnimHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            View view;
            Message message2 = message;
            Object obj = message2.obj;
            float f = 0.0f;
            boolean z = false;
            switch (message2.what) {
                case 1:
                    List list = (List) obj;
                    if (list != null && !list.isEmpty()) {
                        if (CarSlidingRenderAnimator.this.f46229d.isEmpty() && !CarSlidingRenderAnimator.this.f46232g && !CarSlidingRenderAnimator.this.f46233h) {
                            z = true;
                        }
                        CarSlidingRenderAnimator.this.f46229d.addAll(list);
                        if (z && CarSlidingRenderAnimator.this.f46235j != null) {
                            CarSlidingRenderAnimator.this.f46235j.obtainMessage(2).sendToTarget();
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    if (!(!CarSlidingRenderAnimator.this.f46229d.isEmpty() && !CarSlidingRenderAnimator.this.f46232g) || CarSlidingRenderAnimator.this.f46227b == null) {
                        boolean unused = CarSlidingRenderAnimator.this.f46233h = false;
                        return;
                    }
                    SlidingMeta slidingMeta = (SlidingMeta) CarSlidingRenderAnimator.this.f46229d.remove(0);
                    VectorCoordinate vectorCoordinate = slidingMeta.getVectorCoordinate();
                    LatLng latLng = new LatLng(vectorCoordinate.getLat(), vectorCoordinate.getLng());
                    LatLng position = CarSlidingRenderAnimator.this.f46227b.getPosition();
                    if (position != null && !position.equals(latLng)) {
                        List<VectorCoordinateFilter> filterList = slidingMeta.getFilterList();
                        if (filterList != null && !filterList.isEmpty()) {
                            for (VectorCoordinateFilter filter : filterList) {
                                if (filter.filter(CarSlidingRenderAnimator.this.f46234i.getVectorCoordinate(), slidingMeta.getVectorCoordinate())) {
                                    if (CarSlidingRenderAnimator.this.f46235j != null) {
                                        CarSlidingRenderAnimator.this.f46235j.obtainMessage(2).sendToTarget();
                                        return;
                                    }
                                    return;
                                }
                            }
                        }
                        SlidingMeta unused2 = CarSlidingRenderAnimator.this.f46234i = slidingMeta;
                        boolean unused3 = CarSlidingRenderAnimator.this.f46233h = true;
                        CarSlidingRenderAnimator.this.f46227b.setVisible(true);
                        float rotation = CarSlidingRenderAnimator.this.f46227b.getRotation();
                        float reviseRotate = RenderAnimUtils.getReviseRotate(rotation, RenderAnimUtils.getAngel(position, latLng));
                        float rotate = RenderAnimUtils.getRotate(rotation, reviseRotate);
                        if (slidingMeta.isAngleSensitive()) {
                            f = rotation;
                        } else {
                            reviseRotate = 0.0f;
                        }
                        int slideAnimDuration = slidingMeta.getSlideAnimDuration();
                        if (slideAnimDuration < 0) {
                            slideAnimDuration = 300;
                        }
                        if (Math.abs((int) rotate) < 10) {
                            CarSlidingRenderAnimator.this.m33200a(latLng, f, reviseRotate, slideAnimDuration);
                            return;
                        } else {
                            CarSlidingRenderAnimator.this.m33208b(latLng, f, reviseRotate, slideAnimDuration);
                            return;
                        }
                    } else if (CarSlidingRenderAnimator.this.f46235j != null) {
                        CarSlidingRenderAnimator.this.f46235j.obtainMessage(2).sendToTarget();
                        return;
                    } else {
                        return;
                    }
                case 3:
                    SlidingMeta slidingMeta2 = (SlidingMeta) obj;
                    if (message2.arg1 == 1) {
                        z = true;
                    }
                    CarSlidingRenderAnimator.this.f46229d.clear();
                    SlidingMeta unused4 = CarSlidingRenderAnimator.this.f46234i = slidingMeta2;
                    if (CarSlidingRenderAnimator.this.f46227b != null) {
                        VectorCoordinate vectorCoordinate2 = slidingMeta2.getVectorCoordinate();
                        CarSlidingRenderAnimator.this.f46227b.setPosition(new LatLng(vectorCoordinate2.getLat(), vectorCoordinate2.getLng()));
                        if (slidingMeta2.isAngleSensitive()) {
                            CarSlidingRenderAnimator.this.f46227b.setRotation(vectorCoordinate2.getAngle());
                        }
                        if (z) {
                            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                            alphaAnimation.setDuration(z ? 500 : 0);
                            CarSlidingRenderAnimator.this.f46227b.startAnimation(alphaAnimation);
                            return;
                        }
                        return;
                    }
                    return;
                case 4:
                    boolean z2 = message2.arg1 == 1;
                    boolean z3 = message2.arg2 == 1;
                    if (CarSlidingRenderAnimator.this.f46227b != null && z3 && !CarSlidingRenderAnimator.this.f46229d.isEmpty()) {
                        SlidingMeta slidingMeta3 = (SlidingMeta) CarSlidingRenderAnimator.this.f46229d.get(CarSlidingRenderAnimator.this.f46229d.size() - 1);
                        CarSlidingRenderAnimator.this.f46227b.setRotation(slidingMeta3.getAngle());
                        VectorCoordinate vectorCoordinate3 = slidingMeta3.getVectorCoordinate();
                        CarSlidingRenderAnimator.this.f46227b.setPosition(new LatLng(vectorCoordinate3.getLat(), vectorCoordinate3.getLng()));
                        CarSlidingRenderAnimator.this.f46229d.clear();
                    }
                    boolean unused5 = CarSlidingRenderAnimator.this.f46232g = false;
                    if (CarSlidingRenderAnimator.this.f46227b != null) {
                        CarSlidingRenderAnimator.this.f46227b.setVisible(true);
                        AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                        alphaAnimation2.setDuration(z2 ? 500 : 0);
                        CarSlidingRenderAnimator.this.f46227b.setVisible(true);
                        CarSlidingRenderAnimator.this.f46227b.setAnimationListener(new AnimationListener() {
                            public void onAnimationEnd() {
                            }

                            public void onAnimationStart() {
                            }
                        });
                        CarSlidingRenderAnimator.this.f46227b.startAnimation(alphaAnimation2);
                        return;
                    }
                    return;
                case 5:
                    boolean z4 = message2.arg1 == 1;
                    boolean unused6 = CarSlidingRenderAnimator.this.f46232g = true;
                    boolean unused7 = CarSlidingRenderAnimator.this.f46233h = false;
                    AlphaAnimation alphaAnimation3 = new AlphaAnimation(1.0f, 0.0f);
                    alphaAnimation3.setDuration(z4 ? 500 : 0);
                    if (CarSlidingRenderAnimator.this.f46227b != null) {
                        CarSlidingRenderAnimator.this.f46227b.setAnimationListener(new AnimationListener() {
                            public void onAnimationStart() {
                            }

                            public void onAnimationEnd() {
                                synchronized (CarSlidingRenderAnimator.this.f46236k) {
                                    CarSlidingRenderAnimator.this.m33202a(CarSlidingRenderAnimator.this.f46227b);
                                }
                            }
                        });
                        CarSlidingRenderAnimator.this.f46227b.startAnimation(alphaAnimation3);
                        return;
                    }
                    return;
                case 6:
                    if (message2.arg1 == 1) {
                        z = true;
                    }
                    boolean unused8 = CarSlidingRenderAnimator.this.f46232g = true;
                    CarSlidingRenderAnimator.this.f46229d.clear();
                    removeMessages(1);
                    removeMessages(2);
                    removeMessages(3);
                    removeMessages(4);
                    removeMessages(5);
                    removeMessages(6);
                    synchronized (CarSlidingRenderAnimator.this.f46237l) {
                        Handler unused9 = CarSlidingRenderAnimator.this.f46235j = null;
                    }
                    if (CarSlidingRenderAnimator.this.f46227b != null) {
                        CarSlidingRenderAnimator.this.f46227b.setAnimationListener((AnimationListener) null);
                        if (z) {
                            AlphaAnimation alphaAnimation4 = new AlphaAnimation(1.0f, 0.0f);
                            alphaAnimation4.setDuration(500);
                            try {
                                CarSlidingRenderAnimator.this.f46227b.setAnimationListener(new AnimationListener() {
                                    public void onAnimationStart() {
                                    }

                                    public void onAnimationEnd() {
                                        synchronized (CarSlidingRenderAnimator.this.f46236k) {
                                            if (!(CarSlidingRenderAnimator.this.f46227b == null || CarSlidingRenderAnimator.this.f46230e == null)) {
                                                CarSlidingRenderAnimator.this.m33202a(CarSlidingRenderAnimator.this.f46227b);
                                                CarSlidingRenderAnimator.this.f46230e.remove(CarSlidingRenderAnimator.this.f46227b);
                                                Marker unused = CarSlidingRenderAnimator.this.f46227b = null;
                                            }
                                        }
                                    }
                                });
                                CarSlidingRenderAnimator.this.f46227b.startAnimation(alphaAnimation4);
                                return;
                            } catch (Exception e) {
                                e.printStackTrace();
                                return;
                            }
                        } else {
                            synchronized (CarSlidingRenderAnimator.this.f46236k) {
                                if (CarSlidingRenderAnimator.this.f46227b != null) {
                                    CarSlidingRenderAnimator.this.m33202a(CarSlidingRenderAnimator.this.f46227b);
                                    CarSlidingRenderAnimator.this.f46230e.remove(CarSlidingRenderAnimator.this.f46227b);
                                    Marker unused10 = CarSlidingRenderAnimator.this.f46227b = null;
                                }
                            }
                            return;
                        }
                    } else {
                        return;
                    }
                case 7:
                    BitmapDescriptor bitmapDescriptor = (BitmapDescriptor) message2.obj;
                    if (bitmapDescriptor != null && (view = CarSlidingRenderAnimator.this.f46230e.getView()) != null && CarSlidingRenderAnimator.this.f46227b != null) {
                        CarSlidingRenderAnimator.this.f46227b.setIcon(view.getContext(), bitmapDescriptor);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33202a(Marker marker) {
        if (marker != null) {
            marker.hideInfoWindow();
            marker.setVisible(false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33200a(final LatLng latLng, float f, final float f2, int i) {
        if (latLng != null && this.f46227b != null) {
            if (i < 0) {
                i = 300;
            }
            RotateAnimation rotateAnimation = new RotateAnimation(f, f2, 0.0f, 0.0f, -1.0f);
            long j = (long) i;
            rotateAnimation.setDuration(j);
            TranslateAnimation translateAnimation = new TranslateAnimation(latLng);
            translateAnimation.setDuration(j);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 1.0f);
            alphaAnimation.setDuration(j);
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.addAnimation(rotateAnimation);
            animationSet.addAnimation(translateAnimation);
            animationSet.addAnimation(alphaAnimation);
            animationSet.setDuration(j);
            this.f46227b.setAnimationListener(new AnimationListener() {
                public void onAnimationStart() {
                }

                public void onAnimationEnd() {
                    synchronized (CarSlidingRenderAnimator.this.f46236k) {
                        if (CarSlidingRenderAnimator.this.f46227b != null) {
                            CarSlidingRenderAnimator.this.f46227b.setRotation(f2);
                            CarSlidingRenderAnimator.this.f46227b.setPosition(latLng);
                        }
                    }
                    synchronized (CarSlidingRenderAnimator.this.f46237l) {
                        if (CarSlidingRenderAnimator.this.f46235j != null) {
                            CarSlidingRenderAnimator.this.f46235j.obtainMessage(2).sendToTarget();
                        }
                    }
                }
            });
            this.f46227b.startAnimation(animationSet);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m33208b(LatLng latLng, float f, float f2, int i) {
        Marker marker;
        if (latLng != null && (marker = this.f46227b) != null) {
            if (f == 0.0f && f2 == 0.0f) {
                marker.setRotation(f2);
                m33201a(latLng, i);
                return;
            }
            int abs = Math.abs((int) RenderAnimUtils.getRotate(f, f2)) * 4;
            final int i2 = abs > 0 ? abs : 300;
            RotateAnimation rotateAnimation = new RotateAnimation(f, f2, 0.0f, 0.0f, -1.0f);
            long j = (long) i2;
            rotateAnimation.setDuration(j);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 1.0f);
            alphaAnimation.setDuration(j);
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.addAnimation(rotateAnimation);
            animationSet.addAnimation(alphaAnimation);
            animationSet.setDuration(j);
            final float f3 = f2;
            final LatLng latLng2 = latLng;
            final int i3 = i;
            this.f46227b.setAnimationListener(new AnimationListener() {
                public void onAnimationStart() {
                }

                public void onAnimationEnd() {
                    synchronized (CarSlidingRenderAnimator.this.f46236k) {
                        if (CarSlidingRenderAnimator.this.f46227b != null) {
                            CarSlidingRenderAnimator.this.f46227b.setRotation(f3);
                            CarSlidingRenderAnimator.this.m33201a(latLng2, i3 - i2);
                        }
                    }
                }
            });
            this.f46227b.startAnimation(animationSet);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33201a(final LatLng latLng, int i) {
        if (this.f46227b != null) {
            if (i < 0) {
                i = 300;
            }
            TranslateAnimation translateAnimation = new TranslateAnimation(latLng);
            long j = (long) i;
            translateAnimation.setDuration(j);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 1.0f);
            alphaAnimation.setDuration(j);
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.addAnimation(translateAnimation);
            animationSet.addAnimation(alphaAnimation);
            animationSet.setDuration(j);
            this.f46227b.setAnimationListener(new AnimationListener() {
                public void onAnimationStart() {
                }

                public void onAnimationEnd() {
                    synchronized (CarSlidingRenderAnimator.this.f46236k) {
                        if (CarSlidingRenderAnimator.this.f46227b != null) {
                            CarSlidingRenderAnimator.this.f46227b.setPosition(latLng);
                        }
                    }
                    synchronized (CarSlidingRenderAnimator.this.f46237l) {
                        if (CarSlidingRenderAnimator.this.f46235j != null) {
                            CarSlidingRenderAnimator.this.f46235j.obtainMessage(2).sendToTarget();
                        }
                    }
                }
            });
            this.f46227b.startAnimation(animationSet);
        }
    }
}
