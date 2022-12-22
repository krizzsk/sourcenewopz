package com.didi.hawaii.mapsdkv2.core;

import android.content.Context;
import android.os.Handler;
import android.view.MotionEvent;
import com.didi.hawaii.mapsdk.gesture.AndroidGestureOption;
import com.didi.hawaii.mapsdk.gesture.AndroidGesturesManager;
import com.didi.hawaii.mapsdk.gesture.Constants;
import com.didi.hawaii.mapsdk.gesture.MoveGestureDetector;
import com.didi.hawaii.mapsdk.gesture.MultiFingerTapGestureDetector;
import com.didi.hawaii.mapsdk.gesture.RotateGestureDetector;
import com.didi.hawaii.mapsdk.gesture.ShoveGestureDetector;
import com.didi.hawaii.mapsdk.gesture.StandardGestureDetector;
import com.didi.hawaii.mapsdk.gesture.StandardScaleGestureDetector;
import com.didi.hawaii.mapsdkv2.common.MapLog;
import com.didi.hawaii.mapsdkv2.core.MapEngine;
import com.didi.map.common.ApolloHawaii;
import com.didi.map.outer.model.LatLng;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

final class TouchDispatcher {

    /* renamed from: a */
    private static final String f23996a = "TouchDispatcher";

    /* renamed from: b */
    private static final boolean f23997b = ApolloHawaii.isUseNewGesture();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final AndroidGesturesManager f23998c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final GLViewRootImpl f23999d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final MapEngine f24000e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final GLBaseMapView f24001f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final GLUiSetting f24002g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public List<Runnable> f24003h = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f24004i;

    /* renamed from: j */
    private final Handler f24005j;

    public TouchDispatcher(GLViewRootImpl gLViewRootImpl, MapEngine mapEngine) {
        this.f23999d = gLViewRootImpl;
        this.f24000e = mapEngine;
        Context androidContext = gLViewRootImpl.getMapContext().getAndroidContext();
        AndroidGestureOption androidGestureOption = new AndroidGestureOption();
        androidGestureOption.applyDefaultThresholds = true;
        androidGestureOption.useNNClassfy = f23997b;
        this.f23998c = new AndroidGesturesManager(androidContext, androidGestureOption);
        GLBaseMapView baseMap = gLViewRootImpl.getBaseMap();
        this.f24001f = baseMap;
        this.f24002g = baseMap.getUiSetting();
        this.f24005j = gLViewRootImpl.getMainHandler();
        m17072a();
        m17075b();
    }

    /* renamed from: a */
    private void m17072a() {
        HashSet hashSet = new HashSet();
        hashSet.add(3);
        hashSet.add(13);
        HashSet hashSet2 = new HashSet();
        hashSet2.add(3);
        hashSet2.add(1);
        HashSet hashSet3 = new HashSet();
        hashSet3.add(3);
        hashSet3.add(2);
        HashSet hashSet4 = new HashSet();
        hashSet4.add(1);
        hashSet4.add(6);
        this.f23998c.setMutuallyExclusiveGestures((Set<Integer>[]) new Set[]{hashSet, hashSet2, hashSet3, hashSet4});
    }

    /* renamed from: b */
    private void m17075b() {
        this.f23998c.setStandardGestureListener(new StandardGestureListener());
        this.f23998c.setMoveGestureListener(new MoveGestureListener());
        this.f23998c.setRotateGestureListener(new RotateGestureListener());
        this.f23998c.setStandardScaleGestureListener(new ScaleGestureListener());
        this.f23998c.setShoveGestureListener(new ShoveGestureListener());
        this.f23998c.setMultiFingerTapGestureListener(new TapGestureListener());
    }

    private class StandardGestureListener extends StandardGestureDetector.SimpleStandardOnGestureListener {
        private StandardGestureListener() {
        }

        public boolean onSingleTapConfirmed(final MotionEvent motionEvent) {
            Future postToRenderThread = TouchDispatcher.this.f23999d.postToRenderThread(new Callable<MapEngine.TapItem>() {
                public MapEngine.TapItem call() throws Exception {
                    MapEngine.TapItem tapItem = new MapEngine.TapItem();
                    if (TouchDispatcher.this.f24000e.tap((int) motionEvent.getX(), (int) motionEvent.getY(), tapItem)) {
                        return tapItem;
                    }
                    LatLng fromScreenLocation = TouchDispatcher.this.f24000e.fromScreenLocation(motionEvent.getX(), motionEvent.getY());
                    tapItem.type = 0;
                    tapItem.geo.latitude = fromScreenLocation.latitude;
                    tapItem.geo.longitude = fromScreenLocation.longitude;
                    return tapItem;
                }
            });
            if (postToRenderThread == null) {
                return false;
            }
            try {
                MapEngine.TapItem tapItem = (MapEngine.TapItem) postToRenderThread.get(500, TimeUnit.MILLISECONDS);
                if (tapItem == null) {
                    return false;
                }
                GLOverlayView a = TouchDispatcher.this.f23999d.mo70267a(tapItem.displayId);
                if (a == null && tapItem.bubbleId > 0) {
                    a = TouchDispatcher.this.f23999d.mo70272b((int) tapItem.bubbleId);
                }
                if (a != null && tapItem.updateZIndex) {
                    a.setZIndex(tapItem.zIndex);
                }
                Gesture.m17048a(motionEvent.getX(), motionEvent.getY(), 17, tapItem.geo);
                Gesture a2 = Gesture.m17048a(motionEvent.getX(), motionEvent.getY(), 17, tapItem);
                a2.setGlOverlayView(a);
                boolean dispatchGestureEvent = TouchDispatcher.this.f24001f.dispatchGestureEvent(a2);
                if (a != null && a.isAdded()) {
                    a.dispatchGestureEvent(a2);
                    a2.mo70287a();
                }
                a2.mo70287a();
                return dispatchGestureEvent;
            } catch (InterruptedException e) {
                MapLog.m16916e(TouchDispatcher.f23996a, e.getMessage(), e);
                Thread.currentThread().interrupt();
                return false;
            } catch (ExecutionException | TimeoutException e2) {
                MapLog.m16916e(TouchDispatcher.f23996a, e2.getMessage(), e2);
                return false;
            }
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            Gesture a = Gesture.m17048a(motionEvent.getX(), motionEvent.getY(), 23, (Object) null);
            boolean dispatchGestureEvent = TouchDispatcher.this.f24001f.dispatchGestureEvent(a);
            a.mo70287a();
            return dispatchGestureEvent;
        }

        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            if (motionEvent.getActionMasked() == 0) {
                boolean unused = TouchDispatcher.this.f24004i = true;
            }
            if (motionEvent.getActionMasked() != 1) {
                return super.onDoubleTapEvent(motionEvent);
            }
            if (!TouchDispatcher.this.f24002g.isZoomGesturesEnabled() || !TouchDispatcher.this.f24004i) {
                return false;
            }
            Gesture a = Gesture.m17048a(motionEvent.getX(), motionEvent.getY(), 32, (Object) null);
            boolean dispatchGestureEvent = TouchDispatcher.this.f24001f.dispatchGestureEvent(a);
            a.mo70287a();
            return dispatchGestureEvent;
        }

        public boolean onDown(MotionEvent motionEvent) {
            return super.onDown(motionEvent);
        }

        public void onShowPress(MotionEvent motionEvent) {
            super.onShowPress(motionEvent);
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return super.onSingleTapUp(motionEvent);
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (f == 0.0f && f2 == 0.0f) {
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            Gesture a = Gesture.m17048a(f, f2, 8, (Object) null);
            boolean dispatchGestureEvent = TouchDispatcher.this.f24001f.dispatchGestureEvent(a);
            a.mo70287a();
            return dispatchGestureEvent;
        }

        public void onLongPress(MotionEvent motionEvent) {
            super.onLongPress(motionEvent);
            Gesture a = Gesture.m17048a(motionEvent.getX(), motionEvent.getY(), 18, TouchDispatcher.this.f24001f.getProjection().fromScreen(motionEvent.getX(), motionEvent.getY()));
            TouchDispatcher.this.f24001f.dispatchGestureEvent(a);
            a.mo70287a();
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (!TouchDispatcher.this.f24002g.isScrollGesturesEnabled() || Math.max(Math.abs(f), Math.abs(f2)) <= 512.0f) {
                return false;
            }
            Gesture a = Gesture.m17048a(f, f2, 19, (Object) null);
            boolean dispatchGestureEvent = TouchDispatcher.this.f24001f.dispatchGestureEvent(a);
            a.mo70287a();
            return dispatchGestureEvent;
        }
    }

    private class MoveGestureListener extends MoveGestureDetector.SimpleOnMoveGestureListener {
        private MoveGestureListener() {
        }

        public boolean onMoveBegin(MoveGestureDetector moveGestureDetector) {
            if (!TouchDispatcher.this.f24002g.isScrollGesturesEnabled()) {
                return false;
            }
            if (TouchDispatcher.this.f24002g.mo70182c()) {
                TouchDispatcher.this.f23998c.getRotateGestureDetector().setAngleThresholdWhenMove(Constants.ROTATION_THRESHOLD_INCREASE_WHEN_MULTI_MOVE);
                TouchDispatcher.this.f23998c.getStandardScaleGestureDetector().setSpanSinceStartThreshold((float) Constants.MINI_SAPN_SCALE_WHEN_MULTI_MOVE);
            }
            return super.onMoveBegin(moveGestureDetector);
        }

        public boolean onMove(MoveGestureDetector moveGestureDetector, float f, float f2) {
            if (f == 0.0f && f2 == 0.0f) {
                return true;
            }
            Gesture a = Gesture.m17048a(f, f2, 8, (Object) null);
            boolean dispatchGestureEvent = TouchDispatcher.this.f24001f.dispatchGestureEvent(a);
            a.mo70287a();
            return dispatchGestureEvent;
        }

        public void onMoveEnd(MoveGestureDetector moveGestureDetector, float f, float f2) {
            if (TouchDispatcher.this.f24002g.isScrollGesturesEnabled()) {
                if (TouchDispatcher.this.f24002g.mo70182c()) {
                    TouchDispatcher.this.f23998c.getRotateGestureDetector().setAngleThreshold(Constants.DEFAULT_ROTATE_ANGLE_THRESHOLD);
                    TouchDispatcher.this.f23998c.getStandardScaleGestureDetector().setSpanSinceStartThreshold((float) Constants.DEFAULT_SCALE_SPAN_START);
                }
                if (Math.max(Math.abs(f), Math.abs(f2)) > 512.0f) {
                    Gesture a = Gesture.m17048a(f, f2, 19, (Object) null);
                    TouchDispatcher.this.f24001f.dispatchGestureEvent(a);
                    a.mo70287a();
                }
            }
        }
    }

    private final class RotateGestureListener extends RotateGestureDetector.SimpleOnRotateGestureListener {
        private boolean allowRotateGesture() {
            return true;
        }

        private RotateGestureListener() {
        }

        public boolean onRotateBegin(RotateGestureDetector rotateGestureDetector) {
            if (!TouchDispatcher.this.f24002g.isRotateGesturesEnabled() || !allowRotateGesture()) {
                return false;
            }
            if (TouchDispatcher.this.f24002g.mo70181b()) {
                TouchDispatcher.this.f23998c.getStandardScaleGestureDetector().setSpanSinceStartThreshold((float) Constants.MINI_SAPN_SCALE_WHEN_ROTATE);
                TouchDispatcher.this.f23998c.getStandardScaleGestureDetector().interrupt();
            }
            return super.onRotateBegin(rotateGestureDetector);
        }

        public boolean onRotate(RotateGestureDetector rotateGestureDetector, float f) {
            Gesture a = Gesture.m17048a(rotateGestureDetector.getFocalPoint().x, rotateGestureDetector.getFocalPoint().y, 21, Float.valueOf(-f));
            boolean dispatchGestureEvent = TouchDispatcher.this.f24001f.dispatchGestureEvent(a);
            a.mo70287a();
            return dispatchGestureEvent;
        }

        public void onRotateEnd(RotateGestureDetector rotateGestureDetector, float f, float f2, float f3) {
            super.onRotateEnd(rotateGestureDetector, f, f2, f3);
            if (TouchDispatcher.this.f24002g.mo70181b()) {
                TouchDispatcher.this.f23998c.getStandardScaleGestureDetector().setSpanSinceStartThreshold((float) Constants.DEFAULT_SCALE_SPAN_START);
            }
            final float f4 = f;
            final float f5 = f2;
            final float f6 = f3;
            final RotateGestureDetector rotateGestureDetector2 = rotateGestureDetector;
            TouchDispatcher.this.f24003h.add(new Runnable() {
                public void run() {
                    if (f4 == 0.0f && f5 == 0.0f) {
                        TouchDispatcher.this.f24001f.stopAnimation();
                        return;
                    }
                    float min = Math.min(20.0f, Math.max((float) Math.pow((double) f6, 2.0d), 1.5f));
                    long log = (long) (Math.log((double) (1.0f + min)) * 500.0d);
                    if (f6 > 0.0f) {
                        min = -min;
                    }
                    TouchDispatcher.this.f24001f.mo69789b(min, log, rotateGestureDetector2.getFocalPoint());
                }
            });
        }
    }

    private final class ScaleGestureListener extends StandardScaleGestureDetector.SimpleStandardOnScaleGestureListener {
        private boolean quickZoom;

        private ScaleGestureListener() {
        }

        public boolean onScaleBegin(StandardScaleGestureDetector standardScaleGestureDetector) {
            if (!TouchDispatcher.this.f24002g.isZoomGesturesEnabled()) {
                return false;
            }
            boolean z = true;
            if (standardScaleGestureDetector.getPointersCount() != 1) {
                z = false;
            }
            this.quickZoom = z;
            if (z) {
                boolean unused = TouchDispatcher.this.f24004i = false;
                TouchDispatcher.this.f23998c.getMoveGestureDetector().setEnabled(false);
            }
            if (TouchDispatcher.this.f24002g.mo70180a()) {
                TouchDispatcher.this.f23998c.getRotateGestureDetector().setAngleThreshold((float) Constants.ROTATION_THRESHOLD_INCREASE_WHEN_SCALING);
            }
            return super.onScaleBegin(standardScaleGestureDetector);
        }

        public boolean onScale(StandardScaleGestureDetector standardScaleGestureDetector) {
            Gesture gesture;
            float scaleFactor = standardScaleGestureDetector.getScaleFactor();
            if (this.quickZoom) {
                gesture = Gesture.m17049a(35, Float.valueOf(getNewFactor(scaleFactor)));
            } else {
                gesture = Gesture.m17048a(standardScaleGestureDetector.getFocalPoint().x, standardScaleGestureDetector.getFocalPoint().y, 22, Float.valueOf(scaleFactor));
            }
            boolean dispatchGestureEvent = TouchDispatcher.this.f24001f.dispatchGestureEvent(gesture);
            gesture.mo70287a();
            return dispatchGestureEvent;
        }

        private float getNewFactor(float f) {
            return Math.min(1.2f, Math.max(f, 0.8f));
        }

        public void onScaleEnd(final StandardScaleGestureDetector standardScaleGestureDetector, final float f, final float f2) {
            if (this.quickZoom) {
                TouchDispatcher.this.f23998c.getMoveGestureDetector().setEnabled(true);
            }
            if (TouchDispatcher.this.f24002g.mo70180a()) {
                TouchDispatcher.this.f23998c.getRotateGestureDetector().setAngleThreshold(Constants.DEFAULT_ROTATE_ANGLE_THRESHOLD);
            }
            TouchDispatcher.this.f24003h.add(new Runnable() {
                public void run() {
                    float abs = Math.abs(f) + Math.abs(f2);
                    boolean z = false;
                    boolean z2 = abs != 0.0f;
                    if (abs >= 800.0f) {
                        z = z2;
                    } else if (standardScaleGestureDetector.getMoveVelocityAverage() >= 5.0f ? !(standardScaleGestureDetector.getCustomComputeVelocity() <= 4.5f || abs <= standardScaleGestureDetector.getMoveVelocityAverage()) : standardScaleGestureDetector.getCustomComputeVelocity() > 4.5f) {
                        z = true;
                    }
                    if (!z) {
                        TouchDispatcher.this.f24001f.stopAnimation();
                        return;
                    }
                    double access$1300 = ScaleGestureListener.this.calculateScale((double) abs, standardScaleGestureDetector.isScalingOut());
                    TouchDispatcher.this.f24001f.mo69780a((float) access$1300, ((long) ((Math.abs(access$1300) * 400.0d) / 4.0d)) + 150, standardScaleGestureDetector.getFocalPoint());
                }
            });
        }

        /* access modifiers changed from: private */
        public double calculateScale(double d, boolean z) {
            double log = (double) ((float) Math.log((d / 400.0d) + 3.5d));
            return z ? -log : log;
        }
    }

    private final class ShoveGestureListener extends ShoveGestureDetector.SimpleOnShoveGestureListener {
        private ShoveGestureListener() {
        }

        public boolean onShoveBegin(ShoveGestureDetector shoveGestureDetector) {
            if (!TouchDispatcher.this.f24002g.isTiltGesturesEnabled()) {
                return false;
            }
            TouchDispatcher.this.f23998c.getMoveGestureDetector().setEnabled(false);
            TouchDispatcher.this.f23998c.getStandardScaleGestureDetector().setEnabled(false);
            TouchDispatcher.this.f23998c.getRotateGestureDetector().setEnabled(false);
            return super.onShoveBegin(shoveGestureDetector);
        }

        public boolean onShove(ShoveGestureDetector shoveGestureDetector, float f, float f2) {
            Gesture a = Gesture.m17048a(0.0f, -0.1f * f, 20, Float.valueOf(f));
            boolean dispatchGestureEvent = TouchDispatcher.this.f24001f.dispatchGestureEvent(a);
            a.mo70287a();
            return dispatchGestureEvent;
        }

        public void onShoveEnd(ShoveGestureDetector shoveGestureDetector, float f, float f2) {
            TouchDispatcher.this.f23998c.getMoveGestureDetector().setEnabled(true);
            TouchDispatcher.this.f23998c.getStandardScaleGestureDetector().setEnabled(true);
            TouchDispatcher.this.f23998c.getRotateGestureDetector().setEnabled(true);
            super.onShoveEnd(shoveGestureDetector, f, f2);
        }
    }

    private final class TapGestureListener implements MultiFingerTapGestureDetector.OnMultiFingerTapGestureListener {
        private TapGestureListener() {
        }

        public boolean onMultiFingerDown(MotionEvent motionEvent) {
            Gesture a = Gesture.m17048a(motionEvent.getX(), motionEvent.getY(), 5, (Object) null);
            TouchDispatcher.this.f24001f.dispatchGestureEvent(a);
            a.mo70287a();
            return true;
        }

        public boolean onMultiFingerUp(MotionEvent motionEvent) {
            Gesture a = Gesture.m17048a(motionEvent.getX(), motionEvent.getY(), 6, (Object) null);
            TouchDispatcher.this.f24001f.dispatchGestureEvent(a);
            a.mo70287a();
            return true;
        }

        public boolean onMultiFingerTap(MultiFingerTapGestureDetector multiFingerTapGestureDetector, int i) {
            if (!TouchDispatcher.this.f24002g.isZoomGesturesEnabled() || i != 2) {
                return false;
            }
            Gesture a = Gesture.m17049a(36, multiFingerTapGestureDetector.getFocalPoint());
            boolean dispatchGestureEvent = TouchDispatcher.this.f24001f.dispatchGestureEvent(a);
            a.mo70287a();
            return dispatchGestureEvent;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo70609a(MotionEvent motionEvent) {
        if (!this.f24002g.isAllGestureEnabled()) {
            return false;
        }
        boolean onTouchEvent = this.f23998c.onTouchEvent(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            m17077c();
            Gesture a = Gesture.m17048a(motionEvent.getX(), motionEvent.getY(), 0, (Object) null);
            this.f24001f.dispatchGestureEvent(a);
            a.mo70287a();
        } else if (actionMasked == 1) {
            if (!this.f24003h.isEmpty()) {
                for (Runnable post : this.f24003h) {
                    this.f24005j.post(post);
                }
                this.f24003h.clear();
            }
            Gesture a2 = Gesture.m17048a(motionEvent.getX(), motionEvent.getY(), 1, (Object) null);
            this.f24001f.dispatchGestureEvent(a2);
            a2.mo70287a();
        } else if (actionMasked == 2) {
            Gesture a3 = Gesture.m17048a(motionEvent.getX(), motionEvent.getY(), 2, (Object) null);
            this.f24001f.dispatchGestureEvent(a3);
            a3.mo70287a();
        } else if (actionMasked == 3) {
            this.f24003h.clear();
        }
        return onTouchEvent;
    }

    /* renamed from: c */
    private void m17077c() {
        this.f24003h.clear();
        this.f24001f.stopAnimation();
    }
}
