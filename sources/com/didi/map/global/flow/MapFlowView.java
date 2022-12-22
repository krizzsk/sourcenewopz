package com.didi.map.global.flow;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.didi.common.map.Map;
import com.didi.common.map.MapView;
import com.didi.common.map.listener.OnMapLoadedCallback;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.NetUtils;
import com.didi.hawaii.p118ar.utils.MapVenderUtil;
import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.didi.map.global.flow.MapFlowView;
import com.didi.map.global.flow.presenter.IMapFlowPresenter;
import com.didi.map.global.flow.presenter.MapFlowPresenter;
import com.didi.map.global.flow.utils.MapFlowApolloUtils;
import com.didi.map.global.flow.utils.MapFlowOmegaUtil;
import com.didi.map.global.model.omega.AppFluentOmega;
import java.util.HashMap;

public class MapFlowView extends RelativeLayout implements IMapFlowView {

    /* renamed from: a */
    private static final String f26265a = "BaseMapFlowView";
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static boolean f26266h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static boolean f26267i;

    /* renamed from: b */
    private MapFlowPresenter f26268b;

    /* renamed from: c */
    private MapViewHolder f26269c;

    /* renamed from: d */
    private boolean f26270d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Map f26271e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Context f26272f;

    /* renamed from: g */
    private Handler f26273g;

    /* renamed from: j */
    private final Runnable f26274j;

    /* renamed from: k */
    private OnMapLoadedCallback f26275k;

    public interface OnMapReadyCallBack {
        void onMapReady();
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public MapFlowView(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public MapFlowView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MapFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f26270d = false;
        this.f26273g = new Handler(Looper.getMainLooper());
        this.f26274j = new Runnable() {
            public void run() {
                DLog.m7384d(MapFlowView.f26265a, "MapLoad Failed", new Object[0]);
                boolean unused = MapFlowView.f26267i = true;
                MapFlowOmegaUtil.trackMapLoadFailed(MapFlowView.this.f26271e != null ? MapFlowView.this.f26271e.getMapVendor().toString() : null);
            }
        };
        this.f26275k = new OnMapLoadedCallback() {
            public void onMapLoaded() {
                DLog.m7384d(MapFlowView.f26265a, "MapLoad Success", new Object[0]);
                AppFluentOmega.getInstance().stopCalculateTime(MapFlowView.this.f26272f, MapFlowView.this.f26271e, 2, (HashMap<String, Object>) null);
                MapFlowView.this.m18589a();
                boolean unused = MapFlowView.f26266h = true;
            }
        };
        this.f26272f = context;
        m18593b();
    }

    public IMapFlowPresenter getPresenter() {
        return this.f26268b;
    }

    public MapView getMapView() {
        MapViewHolder mapViewHolder = this.f26269c;
        if (mapViewHolder != null && mapViewHolder.getMapView() != null) {
            return this.f26269c.getMapView();
        }
        MapFlowOmegaUtil.onMapViewIsNull(isMapReady());
        return null;
    }

    public void getMapAsync(OnMapReadyCallBack onMapReadyCallBack) {
        DLog.m7384d("MapFlowView", "getMapAsync", new Object[0]);
        if (!this.f26270d) {
            MapViewHolder mapViewHolder = this.f26269c;
            if (mapViewHolder != null) {
                mapViewHolder.getMapAsync(m18588a(onMapReadyCallBack));
            }
        } else if (onMapReadyCallBack != null) {
            onMapReadyCallBack.onMapReady();
        }
    }

    public boolean isMapReady() {
        return this.f26270d;
    }

    public void onCreate(Bundle bundle) {
        NetUtils.init(getContext());
    }

    public void onStart() {
        this.f26269c.onStart();
        MapFlowApolloUtils.updateMapLoadMonitorParam(MapVenderUtil.getCurrentMapType(this.f26272f));
        if (!f26266h && !f26267i && MapFlowApolloUtils.enableMapLoadMonitor) {
            m18589a();
            if (this.f26273g != null) {
                DLog.m7384d(f26265a, "MapLoad Countdown", new Object[0]);
                this.f26273g.postDelayed(this.f26274j, (long) MapFlowApolloUtils.mapLoadTimeoutMillis);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18589a() {
        if (this.f26273g != null) {
            DLog.m7384d(f26265a, "MapLoad Countdown Cancel", new Object[0]);
            this.f26273g.removeCallbacks(this.f26274j);
        }
    }

    public void onResume() {
        this.f26269c.onResume();
        this.f26268b.onResume();
    }

    public void onPause() {
        this.f26269c.onPause();
        this.f26268b.onPause();
    }

    public void onStop() {
        this.f26269c.onStop();
        m18589a();
    }

    public void onDestroy() {
        DLog.m7384d(f26265a, "Map destroy", new Object[0]);
        this.f26270d = false;
        this.f26268b.onDestroy();
        this.f26269c.onDestroy();
        Map map = this.f26271e;
        if (map != null) {
            map.removeOnMapLoadedCallback(this.f26275k);
        }
        AppFluentOmega.getInstance().removeOmega(2);
        m18589a();
        this.f26273g = null;
    }

    public void onLowMemory() {
        MapViewHolder mapViewHolder = this.f26269c;
        if (mapViewHolder != null) {
            mapViewHolder.onLowMemory();
        }
    }

    /* renamed from: b */
    private void m18593b() {
        MapViewHolder mapViewHolder = new MapViewHolder(getContext());
        this.f26269c = mapViewHolder;
        addView(mapViewHolder.getMapView(), -1, -1);
        this.f26268b = new MapFlowPresenter(this.f26269c);
        AppFluentOmega.getInstance().removeOmega(2);
        DLog.m7384d(f26265a, "initMap", new Object[0]);
    }

    /* renamed from: a */
    private com.didi.common.map.OnMapReadyCallBack m18588a(OnMapReadyCallBack onMapReadyCallBack) {
        return new com.didi.common.map.OnMapReadyCallBack(onMapReadyCallBack) {
            public final /* synthetic */ MapFlowView.OnMapReadyCallBack f$1;

            {
                this.f$1 = r2;
            }

            public final void onMapReady(Map map) {
                MapFlowView.this.m18590a(this.f$1, map);
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m18590a(OnMapReadyCallBack onMapReadyCallBack, Map map) {
        this.f26270d = true;
        this.f26271e = map;
        DLog.m7384d(f26265a, "onMapReady , map.getMapStatus() = " + map.getMapStatus(), new Object[0]);
        if (onMapReadyCallBack != null) {
            onMapReadyCallBack.onMapReady();
        }
        Map map2 = this.f26271e;
        if (map2 != null) {
            map2.addOnMapLoadedCallback(this.f26275k);
        }
    }

    public void setGoogleLogoVisible(int i) {
        Map map = this.f26271e;
        if (map != null && map.getUiSettings() != null) {
            this.f26271e.getUiSettings().setLogoVisibility(i);
        }
    }
}
