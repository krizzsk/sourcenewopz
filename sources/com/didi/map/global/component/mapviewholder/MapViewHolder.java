package com.didi.map.global.component.mapviewholder;

import android.content.Context;
import android.os.Build;
import android.os.MessageQueue;
import android.text.TextUtils;
import com.didi.common.map.Map;
import com.didi.common.map.MapOption;
import com.didi.common.map.MapView;
import com.didi.common.map.OnMapReadyCallBack;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.myLocation.IMyLocationCompContract;
import com.didi.map.global.component.myLocation.MyLocationCompParam;
import com.didi.map.global.component.myLocation.MyLocationComponent;
import com.didi.map.global.model.location.NLPRegisterParam;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.List;

public class MapViewHolder {

    /* renamed from: c */
    private static final String f25962c = "MapViewHolder";

    /* renamed from: a */
    int f25963a;

    /* renamed from: b */
    int f25964b;

    /* renamed from: d */
    private MapView f25965d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Map f25966e;

    /* renamed from: f */
    private Context f25967f;

    /* renamed from: g */
    private IMyLocationCompContract f25968g;

    /* renamed from: h */
    private MyLocationCompParam f25969h;

    public MapViewHolder(Context context) {
        this.f25967f = context;
        m18453a(context, (MapOption) null);
    }

    public MapViewHolder(Context context, int i, int i2) {
        this.f25967f = context;
        this.f25963a = i;
        this.f25964b = i2;
        m18453a(context, (MapOption) null);
    }

    /* renamed from: a */
    private void m18453a(Context context, MapOption mapOption) {
        this.f25965d = DDMapInit.getInstance().getMapView(context, mapOption);
        getMapAsync(new OnMapReadyCallBack() {
            public void onMapReady(Map map) {
                Map unused = MapViewHolder.this.f25966e = map;
                MapViewHolder.this.m18454a(map);
                MapViewHolder.this.m18452a();
                SystemUtils.log(3, MapViewHolder.f25962c, "onMapReady: init location component...", (Throwable) null, "com.didi.map.global.component.mapviewholder.MapViewHolder$1", 62);
            }
        });
    }

    public MapViewHolder(Context context, MapOption mapOption) {
        this.f25967f = context;
        m18453a(context, mapOption);
    }

    public void getMapAsync(OnMapReadyCallBack onMapReadyCallBack) {
        MapView mapView = this.f25965d;
        if (mapView != null) {
            mapView.getMapAsync(onMapReadyCallBack);
            SystemUtils.log(3, f25962c, "getMapAsync: ready callback...", (Throwable) null, "com.didi.map.global.component.mapviewholder.MapViewHolder", 81);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18452a() {
        m18458b();
        this.f25968g = new MyLocationComponent();
        MyLocationCompParam build = new MyLocationCompParam.Builder(80).arrowIcon(this.f25963a).positionIcon(this.f25964b).build();
        this.f25969h = build;
        this.f25968g.setConfigParam(build);
        this.f25968g.create(this.f25967f, this.f25966e);
    }

    /* renamed from: b */
    private void m18458b() {
        IMyLocationCompContract iMyLocationCompContract = this.f25968g;
        if (iMyLocationCompContract != null) {
            iMyLocationCompContract.destroy();
            this.f25968g = null;
        }
    }

    public MapView getMapView() {
        return this.f25965d;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18454a(Map map) {
        if (map != null && this.f25965d != null) {
            boolean z = false;
            map.setIndoorEnabled(false);
            map.setTrafficEnabled(false);
            map.getUiSettings().setScaleViewEnabled(false);
            map.getUiSettings().setZoomControlsEnabled(false);
            map.getUiSettings().setCompassEnabled(false);
            map.getUiSettings().setTiltEnabled(false);
            map.getUiSettings().setRotateGesturesEnabled(false);
            ApolloParamsGoogleMapStyle instance = ApolloParamsGoogleMapStyle.getInstance();
            DLog.m7384d(f25962c, "initMap() ApolloStyleParams:" + instance, new Object[0]);
            if (instance != null && instance.buildingEnable) {
                z = true;
            }
            map.setBuildingsEnabled(z);
            m18455a(map, instance);
            this.f25965d.addErrorHintView(this.f25967f.getResources().getString(R.string.GRider_backup_Please_understand_cgii));
        }
    }

    /* renamed from: a */
    private void m18455a(Map map, ApolloParamsGoogleMapStyle apolloParamsGoogleMapStyle) {
        if (map != null && apolloParamsGoogleMapStyle != null) {
            try {
                String str = apolloParamsGoogleMapStyle.styleJson;
                if (this.f25965d == null || this.f25965d.getContext() == null || Build.VERSION.SDK_INT < 23) {
                    if (!map.setMapStyle(str)) {
                        DLog.m7384d(f25962c, "3, Style parsing failed.," + hashCode(), new Object[0]);
                    }
                    DLog.m7384d(f25962c, "setMapStyle end," + hashCode(), new Object[0]);
                }
                this.f25965d.getContext().getMainLooper().getQueue().addIdleHandler(new MessageQueue.IdleHandler(str, map) {
                    public final /* synthetic */ String f$1;
                    public final /* synthetic */ Map f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final boolean queueIdle() {
                        return MapViewHolder.this.m18457a(this.f$1, this.f$2);
                    }
                });
                DLog.m7384d(f25962c, "setMapStyle end," + hashCode(), new Object[0]);
            } catch (Exception e) {
                DLog.m7384d(f25962c, "Can't find style. Error:" + e.toString(), new Object[0]);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ boolean m18457a(String str, Map map) {
        if (TextUtils.isEmpty(str)) {
            if (!map.setMapStyle((int) R.raw.map_style)) {
                DLog.m7384d(f25962c, "1, Style parsing failed.," + hashCode(), new Object[0]);
            }
        } else if (!map.setMapStyle(str)) {
            DLog.m7384d(f25962c, "2, Style parsing failed.," + hashCode(), new Object[0]);
        }
        return false;
    }

    public void onResume() {
        MapView mapView = this.f25965d;
        if (mapView != null) {
            mapView.onResume();
        }
    }

    public void onPause() {
        MapView mapView = this.f25965d;
        if (mapView != null) {
            mapView.onPause();
        }
    }

    public void onStart() {
        MapView mapView = this.f25965d;
        if (mapView != null) {
            mapView.onStart();
        }
    }

    public void onStop() {
        MapView mapView = this.f25965d;
        if (mapView != null) {
            mapView.onStop();
        }
    }

    public void onDestroy() {
        m18458b();
        MapView mapView = this.f25965d;
        if (mapView != null) {
            if (!(mapView.getMap() == null || this.f25965d.getMap().getUiSettings() == null)) {
                this.f25965d.getMap().getUiSettings().clear();
            }
            this.f25965d.onDestroy();
            this.f25965d = null;
        }
    }

    public void onLowMemory() {
        MapView mapView = this.f25965d;
        if (mapView != null) {
            mapView.onLowMemory();
        }
    }

    public List<IMapElement> getMyLocationMarkers() {
        IMyLocationCompContract iMyLocationCompContract = this.f25968g;
        if (iMyLocationCompContract != null) {
            return iMyLocationCompContract.getMyLocationMarkers();
        }
        return null;
    }

    public void setLocationVisible(boolean z) {
        IMyLocationCompContract iMyLocationCompContract = this.f25968g;
        if (iMyLocationCompContract != null) {
            iMyLocationCompContract.setVisible(z);
        }
    }

    public void setNeedNlpLocation(NLPRegisterParam nLPRegisterParam) {
        IMyLocationCompContract iMyLocationCompContract = this.f25968g;
        if (iMyLocationCompContract != null) {
            iMyLocationCompContract.setNeedNlpLocation(nLPRegisterParam);
        }
    }
}
