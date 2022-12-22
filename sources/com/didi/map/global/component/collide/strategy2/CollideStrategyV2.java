package com.didi.map.global.component.collide.strategy2;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.didi.common.map.Map;
import com.didi.common.map.listener.OnCameraChangeListener;
import com.didi.common.map.model.CameraPosition;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.collide.ICollideStrategy;
import com.didi.map.global.component.collide.common.DMarker;
import com.didi.map.global.component.collide.common.DMarkerMgr;
import com.didi.map.global.component.collide.util.StrategyUtil;
import com.didi.map.sdk.utils.DouglasUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollideStrategyV2 implements ICollideStrategy {

    /* renamed from: a */
    private static final String f24821a = "CollideStrategyV2";

    /* renamed from: b */
    private DMarkerMgr f24822b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public List<Rect> f24823c;

    /* renamed from: d */
    private List<LatLng>[] f24824d;

    /* renamed from: e */
    private Map f24825e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public double f24826f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public IDMarkerContractV2 f24827g;

    /* renamed from: h */
    private int f24828h = 0;

    /* renamed from: i */
    private int f24829i = 0;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public WorkThread f24830j;

    /* renamed from: k */
    private Handler f24831k = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 0) {
                if (CollideStrategyV2.this.f24830j == null) {
                    WorkThread unused = CollideStrategyV2.this.f24830j = new WorkThread();
                }
                if (CollideStrategyV2.this.f24830j != null) {
                    CollideStrategyV2.this.f24830j.executeTask(new Runnable() {
                        public void run() {
                            CollideStrategyV2.this.m17687c();
                        }
                    });
                }
            }
        }
    };
    protected OnCameraChangeListener mCameraChangeListener = new OnCameraChangeListener() {
        public void onCameraChange(CameraPosition cameraPosition) {
            if (cameraPosition != null && CollideStrategyV2.this.f24827g.isCanWork() && Math.abs(cameraPosition.zoom - CollideStrategyV2.this.f24826f) >= 0.5d) {
                double unused = CollideStrategyV2.this.f24826f = cameraPosition.zoom;
                CollideStrategyV2.this.m17678a(100);
            }
        }
    };

    public CollideStrategyV2(IDMarkerContractV2 iDMarkerContractV2) {
        this.f24827g = iDMarkerContractV2;
        Map map = iDMarkerContractV2.getMap();
        this.f24825e = map;
        if (map != null) {
            map.addOnCameraChangeListener(this.mCameraChangeListener);
            this.f24822b = new DMarkerMgr();
            this.f24823c = new ArrayList();
            this.f24826f = this.f24825e.getCameraPosition().zoom;
        }
    }

    /* renamed from: a */
    private void m17677a() {
        IDMarkerContractV2 iDMarkerContractV2;
        if (this.f24824d == null && (iDMarkerContractV2 = this.f24827g) != null) {
            List<RouteInfo> disabledLines = iDMarkerContractV2.getDisabledLines();
            if (!CollectionUtil.isEmpty((Collection<?>) disabledLines)) {
                this.f24824d = new List[disabledLines.size()];
            }
            for (int i = 0; i < disabledLines.size(); i++) {
                this.f24824d[i] = new DouglasUtil().getDouglasOptimiseLatLngs(disabledLines.get(i).latLngs);
            }
        }
    }

    public void addMarker(DMarker... dMarkerArr) {
        if (this.f24822b != null && (r0 = dMarkerArr.length) > 0) {
            m17684b();
            for (DMarker addMarker : dMarkerArr) {
                this.f24822b.addMarker(addMarker);
            }
            m17678a(100);
        }
    }

    public void updateMarker(DMarker dMarker) {
        DMarkerMgr dMarkerMgr = this.f24822b;
        if (dMarkerMgr != null) {
            dMarkerMgr.updateMarker(dMarker);
        }
    }

    public DMarker getMarker(String str) {
        DMarkerMgr dMarkerMgr = this.f24822b;
        if (dMarkerMgr != null) {
            return dMarkerMgr.getMarker(str);
        }
        return null;
    }

    public void removeMarker(String... strArr) {
        if (this.f24822b != null && (r0 = strArr.length) > 0) {
            m17684b();
            for (String removeMarker : strArr) {
                this.f24822b.removeMarker(removeMarker);
            }
            m17678a(100);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17678a(long j) {
        Handler handler;
        IDMarkerContractV2 iDMarkerContractV2 = this.f24827g;
        if (iDMarkerContractV2 != null && iDMarkerContractV2.isCanWork() && (handler = this.f24831k) != null) {
            handler.removeMessages(0);
            this.f24831k.sendEmptyMessageDelayed(0, j);
        }
    }

    /* renamed from: b */
    private void m17684b() {
        Handler handler = this.f24831k;
        if (handler != null) {
            handler.removeMessages(0);
        }
    }

    public void onDestroy() {
        Map map = this.f24825e;
        if (map != null) {
            map.removeOnCameraChangeListener(this.mCameraChangeListener);
        }
        Handler handler = this.f24831k;
        if (handler != null) {
            handler.removeMessages(0);
            this.f24831k = null;
        }
        List<Rect> list = this.f24823c;
        if (list != null) {
            list.clear();
            this.f24823c = null;
        }
        this.f24825e = null;
        this.f24824d = null;
        this.mCameraChangeListener = null;
        DMarkerMgr dMarkerMgr = this.f24822b;
        if (dMarkerMgr != null) {
            dMarkerMgr.destroy();
            this.f24822b = null;
        }
        WorkThread workThread = this.f24830j;
        if (workThread != null) {
            workThread.destroy();
            this.f24830j = null;
        }
        this.f24827g = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m17687c() {
        try {
            if (this.f24825e != null && this.f24825e.getProjection() != null) {
                if (this.f24827g != null) {
                    System.currentTimeMillis();
                    if (this.f24822b == null) {
                        return;
                    }
                    if (!CollectionUtil.isEmpty((Collection<?>) this.f24822b.getAllMarkers())) {
                        m17677a();
                        List<DMarker> allMarkers = this.f24822b.getAllMarkers();
                        if (allMarkers.size() > 1) {
                            Collections.sort(allMarkers, new Comparator<DMarker>() {
                                public int compare(DMarker dMarker, DMarker dMarker2) {
                                    if (CollideStrategyV2.this.f24827g.getHot(dMarker.f24811id) > CollideStrategyV2.this.f24827g.getHot(dMarker2.f24811id)) {
                                        return -1;
                                    }
                                    return CollideStrategyV2.this.f24827g.getHot(dMarker.f24811id) < CollideStrategyV2.this.f24827g.getHot(dMarker2.f24811id) ? 1 : 0;
                                }
                            });
                        }
                        this.f24823c.clear();
                        List<Rect> disabledRect = this.f24827g.getDisabledRect();
                        for (int i = 0; i < allMarkers.size(); i++) {
                            final DMarker dMarker = allMarkers.get(i);
                            if (!(dMarker == null || dMarker.mRootMarker == null || !StrategyUtil.isMarkerInScreen(dMarker.mRootMarker, this.f24825e) || dMarker.mLabelMarker == null || !dMarker.mLabelMarker.isVisible())) {
                                final int currentLabelPosition = this.f24827g.getCurrentLabelPosition(dMarker.f24811id);
                                final Rect rect = null;
                                int i2 = currentLabelPosition;
                                Rect rect2 = null;
                                int i3 = 0;
                                int i4 = 0;
                                while (true) {
                                    Rect labelMarkerRectWithDirect = StrategyUtil.getLabelMarkerRectWithDirect(this.f24825e, dMarker, i2);
                                    if (rect == null) {
                                        rect = labelMarkerRectWithDirect;
                                    }
                                    this.f24828h = 0;
                                    this.f24829i = 0;
                                    m17679a(labelMarkerRectWithDirect, this.f24823c);
                                    m17679a(labelMarkerRectWithDirect, disabledRect);
                                    m17680a(labelMarkerRectWithDirect, this.f24824d);
                                    if (this.f24828h > i3) {
                                        i3 = this.f24828h;
                                        i4 = i2;
                                        rect2 = labelMarkerRectWithDirect;
                                    }
                                    if (this.f24828h != this.f24829i) {
                                        i2 = m17674a(this.f24827g.isLabelDirectClockwise(), this.f24827g.getEnableLabelPosition(dMarker.f24811id), i2);
                                        if (currentLabelPosition == i2) {
                                            DLog.m7384d(f24821a, "都不能完美坐下，循环结束", new Object[0]);
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                }
                                if (i4 != 0) {
                                    DLog.m7384d(f24821a, "v2 使用备份方向：" + i4, new Object[0]);
                                    rect = rect2;
                                    currentLabelPosition = i4;
                                } else {
                                    DLog.m7384d(f24821a, "v2 使用默认方向：" + currentLabelPosition, new Object[0]);
                                }
                                this.f24831k.post(new Runnable() {
                                    public void run() {
                                        if (!(rect == null || CollideStrategyV2.this.f24823c == null)) {
                                            CollideStrategyV2.this.f24823c.add(rect);
                                        }
                                        if (CollideStrategyV2.this.f24827g != null && dMarker != null) {
                                            CollideStrategyV2.this.f24827g.setLabelDirect(dMarker.f24811id, currentLabelPosition);
                                        }
                                    }
                                });
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    private int m17674a(boolean z, int i, int i2) {
        int a = m17673a(z, i2);
        if ((a & i) == a) {
            return a;
        }
        return m17674a(z, i, a);
    }

    /* renamed from: a */
    private int m17673a(boolean z, int i) {
        if (i == 1 && !z) {
            return 128;
        }
        if (i != 128 || !z) {
            return z ? i * 2 : i / 2;
        }
        return 1;
    }

    /* renamed from: a */
    private void m17679a(Rect rect, List<Rect> list) {
        if (!CollectionUtil.isEmpty((Collection<?>) list) && rect != null) {
            this.f24829i += list.size() * 2;
            for (Rect isIntersect : list) {
                if (!StrategyUtil.isIntersect(rect, isIntersect)) {
                    this.f24828h += 2;
                }
            }
        }
    }

    /* renamed from: a */
    private void m17680a(Rect rect, List<LatLng>[] listArr) {
        if (!CollectionUtil.isEmpty((Object[]) listArr) && rect != null) {
            this.f24829i += listArr.length;
            for (List<LatLng> b : listArr) {
                System.currentTimeMillis();
                if (!m17685b(rect, b)) {
                    this.f24828h++;
                }
            }
        }
    }

    /* renamed from: b */
    private boolean m17685b(Rect rect, List<LatLng> list) {
        if (rect != null && !CollectionUtil.isEmpty((Collection<?>) list)) {
            int i = 0;
            while (i < list.size() - 1) {
                i++;
                if (m17682a(rect, list.get(i), list.get(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private boolean m17682a(Rect rect, LatLng latLng, LatLng latLng2) {
        Map map = this.f24825e;
        if (map == null || map.getProjection() == null || rect == null || !LatLngUtils.locateCorrect(latLng) || !LatLngUtils.locateCorrect(latLng2)) {
            return false;
        }
        return StrategyUtil.isLineIntersectWithRect(rect, this.f24825e.getProjection().toScreenLocation(latLng), this.f24825e.getProjection().toScreenLocation(latLng2));
    }
}
