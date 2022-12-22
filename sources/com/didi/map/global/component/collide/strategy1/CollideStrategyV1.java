package com.didi.map.global.component.collide.strategy1;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.didi.common.map.Map;
import com.didi.common.map.listener.OnCameraChangeListener;
import com.didi.common.map.listener.OnMapGestureListener;
import com.didi.common.map.model.CameraPosition;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.collide.ICollideStrategy;
import com.didi.map.global.component.collide.common.DMarker;
import com.didi.map.global.component.collide.common.DMarkerMgr;
import com.didi.map.global.component.collide.util.StrategyUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollideStrategyV1 implements ICollideStrategy {

    /* renamed from: a */
    private static final String f24813a = "CollideStrategyV1";

    /* renamed from: b */
    private DMarkerMgr f24814b;

    /* renamed from: c */
    private List<Rect> f24815c;

    /* renamed from: d */
    private Map f24816d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public double f24817e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public IDMarkerContractV1 f24818f;

    /* renamed from: g */
    private OnMapGestureListener f24819g = new OnMapGestureListener() {
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

        public boolean onUp(float f, float f2) {
            return false;
        }

        public void onMapStable() {
            if (CollideStrategyV1.this.f24818f != null && !CollideStrategyV1.this.f24818f.isZoomConditionOnly()) {
                CollideStrategyV1.this.m17663a(100);
            }
        }
    };

    /* renamed from: h */
    private Handler f24820h = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 0) {
                CollideStrategyV1.this.m17670c();
            }
        }
    };
    protected OnCameraChangeListener mCameraChangeListener = new OnCameraChangeListener() {
        public void onCameraChange(CameraPosition cameraPosition) {
            if (cameraPosition != null && CollideStrategyV1.this.f24818f.isCanWork() && Math.abs(cameraPosition.zoom - CollideStrategyV1.this.f24817e) >= 0.1d) {
                double unused = CollideStrategyV1.this.f24817e = cameraPosition.zoom;
                CollideStrategyV1.this.m17663a(100);
            }
        }
    };

    public CollideStrategyV1(IDMarkerContractV1 iDMarkerContractV1) {
        this.f24818f = iDMarkerContractV1;
    }

    /* renamed from: a */
    private void m17662a() {
        IDMarkerContractV1 iDMarkerContractV1 = this.f24818f;
        if (iDMarkerContractV1 != null && this.f24816d == null) {
            Map map = iDMarkerContractV1.getMap();
            this.f24816d = map;
            if (map != null) {
                map.addOnCameraChangeListener(this.mCameraChangeListener);
                this.f24816d.addOnMapGestureListener(this.f24819g);
                this.f24814b = new DMarkerMgr();
                this.f24815c = new ArrayList();
                this.f24817e = this.f24816d.getCameraPosition().zoom;
            }
        }
    }

    public void addMarker(DMarker... dMarkerArr) {
        m17662a();
        if (this.f24814b != null && (r0 = dMarkerArr.length) > 0) {
            m17669b();
            for (DMarker addMarker : dMarkerArr) {
                this.f24814b.addMarker(addMarker);
            }
            m17663a(100);
        }
    }

    public void updateMarker(DMarker dMarker) {
        DMarkerMgr dMarkerMgr = this.f24814b;
        if (dMarkerMgr != null) {
            dMarkerMgr.updateMarker(dMarker);
        }
    }

    public DMarker getMarker(String str) {
        DMarkerMgr dMarkerMgr = this.f24814b;
        if (dMarkerMgr != null) {
            return dMarkerMgr.getMarker(str);
        }
        return null;
    }

    public void removeMarker(String... strArr) {
        if (this.f24814b != null && (r0 = strArr.length) > 0) {
            m17669b();
            for (String removeMarker : strArr) {
                this.f24814b.removeMarker(removeMarker);
            }
            m17663a(100);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17663a(long j) {
        Handler handler;
        IDMarkerContractV1 iDMarkerContractV1 = this.f24818f;
        if (iDMarkerContractV1 != null && iDMarkerContractV1.isCanWork() && (handler = this.f24820h) != null) {
            handler.removeMessages(0);
            this.f24820h.sendEmptyMessageDelayed(0, j);
        }
    }

    /* renamed from: b */
    private void m17669b() {
        Handler handler = this.f24820h;
        if (handler != null) {
            handler.removeMessages(0);
        }
    }

    public void onDestroy() {
        Map map = this.f24816d;
        if (map != null) {
            map.removeOnCameraChangeListener(this.mCameraChangeListener);
            this.f24816d.removeOnMapGestureListener(this.f24819g);
        }
        Handler handler = this.f24820h;
        if (handler != null) {
            handler.removeMessages(0);
            this.f24820h = null;
        }
        List<Rect> list = this.f24815c;
        if (list != null) {
            list.clear();
            this.f24815c = null;
        }
        this.f24816d = null;
        this.mCameraChangeListener = null;
        this.f24819g = null;
        DMarkerMgr dMarkerMgr = this.f24814b;
        if (dMarkerMgr != null) {
            dMarkerMgr.destroy();
            this.f24814b = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m17670c() {
        Rect labelMarkerRectWithDirect;
        boolean z;
        Rect labelMarkerRectWithDirect2;
        Map map = this.f24816d;
        if (map != null && map.getProjection() != null && this.f24818f != null) {
            System.currentTimeMillis();
            DMarkerMgr dMarkerMgr = this.f24814b;
            if (dMarkerMgr == null || CollectionUtil.isEmpty((Collection<?>) dMarkerMgr.getAllMarkers()) || this.f24814b.getAllMarkers().size() <= 1) {
                DLog.m7384d(f24813a, "少于一个点", new Object[0]);
                return;
            }
            List<DMarker> allMarkers = this.f24814b.getAllMarkers();
            Collections.sort(allMarkers, new Comparator<DMarker>() {
                public int compare(DMarker dMarker, DMarker dMarker2) {
                    if (CollideStrategyV1.this.f24818f.isPined(dMarker2.f24811id)) {
                        return 1;
                    }
                    if (CollideStrategyV1.this.f24818f.isPined(dMarker.f24811id)) {
                        return -1;
                    }
                    if (CollideStrategyV1.this.m17666a(dMarker2) && !CollideStrategyV1.this.m17666a(dMarker)) {
                        return 1;
                    }
                    if ((!CollideStrategyV1.this.m17666a(dMarker2) && CollideStrategyV1.this.m17666a(dMarker)) || CollideStrategyV1.this.f24818f.getHot(dMarker.f24811id) > CollideStrategyV1.this.f24818f.getHot(dMarker2.f24811id)) {
                        return -1;
                    }
                    if (CollideStrategyV1.this.f24818f.getHot(dMarker.f24811id) < CollideStrategyV1.this.f24818f.getHot(dMarker2.f24811id)) {
                        return 1;
                    }
                    return 0;
                }
            });
            this.f24815c.clear();
            for (int i = 0; i < allMarkers.size(); i++) {
                DMarker dMarker = allMarkers.get(i);
                if (dMarker != null && StrategyUtil.isMarkerInScreen(dMarker.mRootMarker, this.f24816d)) {
                    if (this.f24818f.isPined(dMarker.f24811id)) {
                        this.f24818f.setVisible(dMarker.f24811id, true);
                        Rect markerRect = StrategyUtil.getMarkerRect(this.f24816d, dMarker.mRootMarker, dMarker.mRootMarkerPadding, true);
                        if (markerRect != null) {
                            this.f24815c.add(markerRect);
                        }
                        if (!this.f24818f.getIsLabelHideWhenPined() && (labelMarkerRectWithDirect2 = StrategyUtil.getLabelMarkerRectWithDirect(this.f24816d, dMarker, this.f24818f.getDefaultLabelPosition())) != null) {
                            this.f24815c.add(labelMarkerRectWithDirect2);
                        }
                    } else if (dMarker.mRootMarker != null) {
                        Rect markerRect2 = StrategyUtil.getMarkerRect(this.f24816d, dMarker.mRootMarker, dMarker.mRootMarkerPadding, true);
                        if (m17665a(markerRect2, this.f24818f.getDisabledRect()) || m17665a(markerRect2, this.f24815c)) {
                            this.f24818f.setVisible(dMarker.f24811id, false);
                        } else if (dMarker.mLabelMarker != null) {
                            int defaultLabelPosition = this.f24818f.getDefaultLabelPosition();
                            int i2 = defaultLabelPosition;
                            while (true) {
                                labelMarkerRectWithDirect = StrategyUtil.getLabelMarkerRectWithDirect(this.f24816d, dMarker, i2);
                                if (!m17665a(labelMarkerRectWithDirect, this.f24818f.getDisabledRect()) && !m17665a(labelMarkerRectWithDirect, this.f24815c)) {
                                    z = true;
                                    break;
                                }
                                i2 = m17660a(this.f24818f.isLabelDirectClockwise(), this.f24818f.getEnableLabelPosition(), i2);
                                if (defaultLabelPosition == i2) {
                                    z = false;
                                    break;
                                }
                            }
                            if (z) {
                                this.f24818f.setLabelDirect(dMarker.f24811id, i2);
                                this.f24818f.setVisible(dMarker.f24811id, true);
                                this.f24815c.add(labelMarkerRectWithDirect);
                                this.f24815c.add(markerRect2);
                            } else {
                                this.f24818f.setVisible(dMarker.f24811id, false);
                            }
                        } else {
                            this.f24818f.setVisible(dMarker.f24811id, true);
                            this.f24815c.add(markerRect2);
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m17666a(DMarker dMarker) {
        if (this.f24816d == null || dMarker.mRootMarker.getPosition() == null) {
            return false;
        }
        return LatLngUtils.isSameLatLng(this.f24816d.getCameraPosition().target, dMarker.mRootMarker.getPosition());
    }

    /* renamed from: a */
    private int m17660a(boolean z, int i, int i2) {
        int a = m17659a(z, i2);
        if ((a & i) == a) {
            return a;
        }
        return m17660a(z, i, a);
    }

    /* renamed from: a */
    private int m17659a(boolean z, int i) {
        if (i == 1 && !z) {
            return 128;
        }
        if (i != 128 || !z) {
            return z ? i * 2 : i / 2;
        }
        return 1;
    }

    /* renamed from: a */
    private boolean m17665a(Rect rect, List<Rect> list) {
        if (!CollectionUtil.isEmpty((Collection<?>) list) && rect != null) {
            for (Rect isIntersect : list) {
                if (StrategyUtil.isIntersect(rect, isIntersect)) {
                    return true;
                }
            }
        }
        return false;
    }
}
