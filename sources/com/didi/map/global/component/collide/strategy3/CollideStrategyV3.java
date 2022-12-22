package com.didi.map.global.component.collide.strategy3;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.didi.common.map.Map;
import com.didi.common.map.listener.OnMapGestureListener;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.collide.ICollideStrategy;
import com.didi.map.global.component.collide.common.DMarker;
import com.didi.map.global.component.collide.common.DMarkerMgr;
import com.didi.map.global.component.collide.util.StrategyUtil;
import java.util.Collection;
import java.util.List;

public class CollideStrategyV3 implements ICollideStrategy {

    /* renamed from: a */
    private static final String f24835a = "CollideStrategyV3";

    /* renamed from: b */
    private DMarkerMgr f24836b;

    /* renamed from: c */
    private Map f24837c;

    /* renamed from: d */
    private IDMarkerContractV3 f24838d;

    /* renamed from: e */
    private OnMapGestureListener f24839e = new OnMapGestureListener() {
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
            CollideStrategyV3.this.m17695a(100);
        }
    };

    /* renamed from: f */
    private Handler f24840f = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 0) {
                CollideStrategyV3.this.m17701c();
            }
        }
    };

    public CollideStrategyV3(IDMarkerContractV3 iDMarkerContractV3) {
        this.f24838d = iDMarkerContractV3;
    }

    /* renamed from: a */
    private void m17694a() {
        IDMarkerContractV3 iDMarkerContractV3 = this.f24838d;
        if (iDMarkerContractV3 != null && this.f24837c == null) {
            Map map = iDMarkerContractV3.getMap();
            this.f24837c = map;
            if (map != null) {
                map.addOnMapGestureListener(this.f24839e);
                this.f24836b = new DMarkerMgr();
            }
        }
    }

    public void addMarker(DMarker... dMarkerArr) {
        m17694a();
        if (this.f24836b != null && (r0 = dMarkerArr.length) > 0) {
            m17699b();
            for (DMarker addMarker : dMarkerArr) {
                this.f24836b.addMarker(addMarker);
            }
            m17695a(100);
        }
    }

    public void updateMarker(DMarker dMarker) {
        DMarkerMgr dMarkerMgr = this.f24836b;
        if (dMarkerMgr != null) {
            dMarkerMgr.updateMarker(dMarker);
        }
    }

    public DMarker getMarker(String str) {
        DMarkerMgr dMarkerMgr = this.f24836b;
        if (dMarkerMgr != null) {
            return dMarkerMgr.getMarker(str);
        }
        return null;
    }

    public void removeMarker(String... strArr) {
        if (this.f24836b != null && (r0 = strArr.length) > 0) {
            m17699b();
            for (String removeMarker : strArr) {
                this.f24836b.removeMarker(removeMarker);
            }
            m17695a(100);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17695a(long j) {
        Handler handler;
        IDMarkerContractV3 iDMarkerContractV3 = this.f24838d;
        if (iDMarkerContractV3 != null && iDMarkerContractV3.isCanWork() && (handler = this.f24840f) != null) {
            handler.removeMessages(0);
            this.f24840f.sendEmptyMessageDelayed(0, j);
        }
    }

    /* renamed from: b */
    private void m17699b() {
        Handler handler = this.f24840f;
        if (handler != null) {
            handler.removeMessages(0);
        }
    }

    public void onDestroy() {
        Map map = this.f24837c;
        if (map != null) {
            map.removeOnMapGestureListener(this.f24839e);
        }
        Handler handler = this.f24840f;
        if (handler != null) {
            handler.removeMessages(0);
            this.f24840f = null;
        }
        this.f24837c = null;
        this.f24839e = null;
        DMarkerMgr dMarkerMgr = this.f24836b;
        if (dMarkerMgr != null) {
            dMarkerMgr.destroy();
            this.f24836b = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m17701c() {
        DMarkerMgr dMarkerMgr;
        Map map = this.f24837c;
        if (map != null && map.getProjection() != null && this.f24838d != null && (dMarkerMgr = this.f24836b) != null && !CollectionUtil.isEmpty((Collection<?>) dMarkerMgr.getAllMarkers())) {
            boolean z = false;
            DMarker dMarker = this.f24836b.getAllMarkers().get(0);
            if (dMarker != null && StrategyUtil.isMarkerInScreen(dMarker.mRootMarker, this.f24837c) && dMarker.mRootMarker != null && dMarker.mLabelMarker != null) {
                int defaultLabelPosition = this.f24838d.getDefaultLabelPosition();
                int i = defaultLabelPosition;
                while (true) {
                    Rect labelMarkerRectWithDirect = StrategyUtil.getLabelMarkerRectWithDirect(this.f24837c, dMarker, i);
                    if (!m17698a(labelMarkerRectWithDirect) && !m17700b(labelMarkerRectWithDirect)) {
                        z = true;
                        break;
                    }
                    i = m17693a(true, this.f24838d.getEnableLabelPosition(), i);
                    if (defaultLabelPosition == i) {
                        break;
                    }
                }
                if (z) {
                    this.f24838d.setLabelDirect(dMarker.f24811id, i);
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m17698a(Rect rect) {
        Rect d = m17702d();
        return d == null || d.left >= rect.left || d.right <= rect.right || d.top >= rect.top || d.bottom <= rect.bottom;
    }

    /* renamed from: b */
    private boolean m17700b(Rect rect) {
        List<Rect> collideAvoidRect;
        IDMarkerContractV3 iDMarkerContractV3 = this.f24838d;
        if (iDMarkerContractV3 == null || (collideAvoidRect = iDMarkerContractV3.getCollideAvoidRect()) == null) {
            return false;
        }
        for (Rect next : collideAvoidRect) {
            if (!(next == null || rect == null)) {
                int max = Math.max(next.right, rect.right);
                int min = Math.min(next.left, rect.left);
                int max2 = Math.max(next.bottom, rect.bottom);
                int min2 = Math.min(next.top, rect.top);
                int abs = Math.abs(max - min);
                int abs2 = Math.abs(max2 - min2);
                if (Math.abs(next.right - next.left) + Math.abs(rect.right - rect.left) >= abs && Math.abs(next.bottom - next.top) + Math.abs(rect.bottom - rect.top) >= abs2) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: d */
    private Rect m17702d() {
        IDMarkerContractV3 iDMarkerContractV3;
        if (this.f24837c == null || (iDMarkerContractV3 = this.f24838d) == null || iDMarkerContractV3.getPadding() == null) {
            return null;
        }
        Rect rect = new Rect();
        Padding padding = this.f24838d.getPadding();
        rect.left = padding.left;
        rect.right = this.f24837c.getWidth() - padding.right;
        rect.top = padding.top;
        rect.bottom = padding.bottom;
        DLog.m7384d(f24835a, "屏幕可视区域：" + rect.toString(), new Object[0]);
        return rect;
    }

    /* renamed from: a */
    private int m17693a(boolean z, int i, int i2) {
        int a = m17692a(z, i2);
        if ((a & i) == a) {
            return a;
        }
        return m17693a(z, i, a);
    }

    /* renamed from: a */
    private int m17692a(boolean z, int i) {
        if (i == 1 && !z) {
            return 128;
        }
        if (i != 128 || !z) {
            return z ? i * 2 : i / 2;
        }
        return 1;
    }
}
