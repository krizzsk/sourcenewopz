package com.didi.map.global.flow.toolkit.bestview;

import android.os.Handler;
import android.os.Message;
import com.didi.common.map.BestViewer;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.listener.OnMapGestureListener;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.LatLngBounds;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.CollectionUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MapAutoBestViewLoop {

    /* renamed from: a */
    private static final int f27199a = 10000;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public long f27200b;

    /* renamed from: c */
    private Map f27201c;

    /* renamed from: d */
    private IBestViewCallback f27202d;

    /* renamed from: e */
    private Handler f27203e;

    /* renamed from: f */
    private float f27204f;

    /* renamed from: g */
    private String f27205g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f27206h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f27207i;

    public interface IBestViewCallback {
        void doBestView(boolean z);
    }

    public MapAutoBestViewLoop(Map map) {
        this(map, 10000);
    }

    public MapAutoBestViewLoop(Map map, long j) {
        this.f27203e = new BestViewHandler(this);
        this.f27204f = 0.0f;
        this.f27205g = "BestViewLoop";
        this.f27206h = true;
        this.f27207i = false;
        if (map != null) {
            this.f27201c = map;
            map.addOnMapGestureListener(new OnMapGestureListener() {
                public boolean onDoubleTap(float f, float f2) {
                    return false;
                }

                public boolean onFling(float f, float f2) {
                    return false;
                }

                public boolean onLongPress(float f, float f2) {
                    return false;
                }

                public void onMapStable() {
                }

                public boolean onScroll(float f, float f2) {
                    return false;
                }

                public boolean onSingleTap(float f, float f2) {
                    return false;
                }

                public boolean onDown(float f, float f2) {
                    boolean unused = MapAutoBestViewLoop.this.f27206h = false;
                    boolean unused2 = MapAutoBestViewLoop.this.f27207i = true;
                    return false;
                }

                public boolean onUp(float f, float f2) {
                    boolean unused = MapAutoBestViewLoop.this.f27206h = true;
                    MapAutoBestViewLoop mapAutoBestViewLoop = MapAutoBestViewLoop.this;
                    mapAutoBestViewLoop.m19241a(mapAutoBestViewLoop.f27200b);
                    return false;
                }
            });
        }
        if (j > 0) {
            this.f27200b = j;
        } else {
            this.f27200b = 10000;
        }
        m19241a(0);
    }

    public void destroy() {
        Handler handler = this.f27203e;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.f27203e = null;
        }
        this.f27202d = null;
        this.f27206h = true;
        this.f27207i = false;
    }

    public void onMapVisible(boolean z) {
        if (z) {
            m19241a(0);
        } else {
            m19240a();
        }
    }

    public void setOnBestViewCallback(IBestViewCallback iBestViewCallback) {
        this.f27202d = iBestViewCallback;
    }

    public void doBestViewImmediately(boolean z) {
        Handler handler = this.f27203e;
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage(0);
            obtainMessage.obj = Boolean.valueOf(z);
            this.f27203e.sendMessage(obtainMessage);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19244a(boolean z) {
        IBestViewCallback iBestViewCallback;
        if (this.f27206h && (iBestViewCallback = this.f27202d) != null) {
            iBestViewCallback.doBestView(z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19241a(long j) {
        m19240a();
        Handler handler = this.f27203e;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(1, j);
        }
    }

    /* renamed from: a */
    private void m19240a() {
        Handler handler = this.f27203e;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
    }

    public boolean doBestViewExecute(List<IMapElement> list, Padding padding, Padding padding2, boolean z) {
        return doBestViewExecute(list, (LatLng) null, padding, padding2, z);
    }

    public boolean doBestViewExecute(List<IMapElement> list, LatLng latLng, Padding padding, Padding padding2, boolean z) {
        Map map = this.f27201c;
        if (map == null || map.getWidth() <= 0) {
            return false;
        }
        if (z) {
            m19243a(list, latLng, padding, padding2);
            m19241a(this.f27200b);
            this.f27207i = false;
            return true;
        }
        if (m19246a(list, padding, padding2)) {
            m19243a(list, latLng, padding, padding2);
            m19241a(this.f27200b);
            this.f27207i = false;
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private void m19243a(List<IMapElement> list, LatLng latLng, Padding padding, Padding padding2) {
        if (latLng == null) {
            BestViewer.doBestView(this.f27201c, true, list, padding, padding2, (BestViewer.IBestViewListener) null);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (IMapElement next : list) {
            if (!CollectionUtil.isEmpty((Collection<?>) next.getBounderPoints())) {
                arrayList.addAll(next.getBounderPoints());
            }
        }
        BestViewer.doBestView(this.f27201c, true, latLng, (List<LatLng>) arrayList, padding, padding2);
    }

    /* renamed from: a */
    private boolean m19246a(List<IMapElement> list, Padding padding, Padding padding2) {
        int i;
        int i2;
        int i3;
        int i4;
        if (!CollectionUtil.isEmpty((Collection<?>) list) && this.f27201c != null) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (IMapElement next : list) {
                if (next != null && !CollectionUtil.isEmpty((Collection<?>) next.getBounderPoints())) {
                    builder.include(next.getBounderPoints());
                }
            }
            LatLngBounds build = builder.build();
            if (padding != null) {
                i4 = padding.left + 0;
                i3 = padding.right + 0;
                i2 = padding.top + 0;
                i = padding.bottom + 0;
            } else {
                i = 0;
                i4 = 0;
                i3 = 0;
                i2 = 0;
            }
            if (padding2 != null) {
                i4 += padding2.left;
                i3 += padding2.right;
                i2 += padding2.top;
                i += padding2.bottom;
            }
            Map map = this.f27201c;
            float calculateZoomToSpanLevel = map.calculateZoomToSpanLevel(i4, i3, i2, i, build.northeast, build.southwest);
            if (!this.f27207i && ((double) Math.abs(this.f27204f - calculateZoomToSpanLevel)) > 0.3d) {
                this.f27204f = calculateZoomToSpanLevel;
                return true;
            }
        }
        return false;
    }

    private class BestViewHandler extends Handler {
        private WeakReference<MapAutoBestViewLoop> loopWeakReference;

        public BestViewHandler(MapAutoBestViewLoop mapAutoBestViewLoop) {
            this.loopWeakReference = new WeakReference<>(mapAutoBestViewLoop);
        }

        public void dispatchMessage(Message message) {
            WeakReference<MapAutoBestViewLoop> weakReference;
            super.dispatchMessage(message);
            if (message != null) {
                int i = message.what;
                if (i == 0) {
                    WeakReference<MapAutoBestViewLoop> weakReference2 = this.loopWeakReference;
                    if (weakReference2 != null && weakReference2.get() != null && message.obj != null) {
                        ((MapAutoBestViewLoop) this.loopWeakReference.get()).m19244a(((Boolean) message.obj).booleanValue());
                    }
                } else if (i == 1 && (weakReference = this.loopWeakReference) != null && weakReference.get() != null) {
                    ((MapAutoBestViewLoop) this.loopWeakReference.get()).m19244a(true);
                    ((MapAutoBestViewLoop) this.loopWeakReference.get()).m19241a(((MapAutoBestViewLoop) this.loopWeakReference.get()).f27200b);
                }
            }
        }
    }
}
