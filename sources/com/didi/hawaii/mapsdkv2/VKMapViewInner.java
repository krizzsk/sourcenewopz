package com.didi.hawaii.mapsdkv2;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import com.didi.hawaii.mapsdkv2.common.MathsUtils;
import com.didi.hawaii.mapsdkv2.core.EngineLogSwitch;
import com.didi.hawaii.mapsdkv2.core.GLBaseMapFactory;
import com.didi.hawaii.mapsdkv2.core.GLBaseMapView;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.core.OnBaseMapCreateCallback;
import com.didi.hawaii.mapsdkv2.core.VKHostView;
import com.didi.hawaii.utils.StorageUtils;
import com.didi.map.MapApolloHawaii;
import com.didi.map.outer.map.MapOpenGL;
import com.didi.map.outer.map.MapOptions;
import com.didi.map.outer.map.MapView;
import com.didi.map.outer.map.OnMapReadyCallback;
import com.didi.map.outer.model.CameraPosition;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

abstract class VKMapViewInner extends VKHostView implements MapOpenGL {
    /* access modifiers changed from: private */
    public final Handler handler = new Handler();
    /* access modifiers changed from: private */
    public HWDidiMap hwDidiMap;
    /* access modifiers changed from: private */
    public final MapCallback mapCallback = new MapCallback();
    private MapOptions options;

    public VKMapViewInner(Context context) {
        super(context);
        init();
    }

    public VKMapViewInner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public VKMapViewInner(Context context, MapOptions mapOptions) {
        super(context, mapOptions);
        init();
    }

    /* access modifiers changed from: protected */
    public void init() {
        setOnBaseMapCreatedCallback(new OnBaseMapCreateCallback() {
            public void onCreate() {
                VKMapViewInner.this.handler.post(new Runnable() {
                    public void run() {
                        if (VKMapViewInner.this.getParent() instanceof MapView) {
                            HWDidiMap unused = VKMapViewInner.this.hwDidiMap = new HWDidiMap(VKMapViewInner.this, (MapView) VKMapViewInner.this.getParent());
                            VKMapViewInner.this.mapCallback.onMapReady();
                            return;
                        }
                        throw new IllegalArgumentException("HWMapView must be in MapView!");
                    }
                });
            }
        });
    }

    public void setOnMapReadyCallback(OnMapReadyCallback onMapReadyCallback) {
        HWDidiMap hWDidiMap = this.hwDidiMap;
        if (hWDidiMap != null) {
            onMapReadyCallback.onMapReady(hWDidiMap);
        } else {
            this.mapCallback.addOnMapReadyCallback(onMapReadyCallback);
        }
    }

    /* access modifiers changed from: protected */
    public GLBaseMapFactory generateBaseMapFactory(MapOptions mapOptions) {
        return new HWBaseMapFactory(mapOptions);
    }

    private static class HWBaseMapFactory implements GLBaseMapFactory {
        private final MapOptions options;

        public HWBaseMapFactory(MapOptions mapOptions) {
            this.options = mapOptions;
        }

        public GLBaseMapView newGLBaseMapView(GLViewManager gLViewManager) {
            GLViewManager gLViewManager2 = gLViewManager;
            String configPath = gLViewManager.getMapContext().getResources().getPrefs().getConfigPath();
            String mapPath4Language = gLViewManager.getMapContext().getResources().getPrefs().getMapPath4Language(0);
            String satPath = gLViewManager.getMapContext().getResources().getPrefs().getSatPath();
            String wmsPath = gLViewManager.getMapContext().getResources().getPrefs().getWmsPath();
            ArrayList arrayList = new ArrayList();
            if (MapApolloHawaii.isMapLogOpen()) {
                arrayList.add(MapApolloHawaii.getMapLogState());
            }
            if (MapApolloHawaii.isNavFeatureOpen()) {
                arrayList.add(MapApolloHawaii.getNavFeature());
            }
            if (MapApolloHawaii.isMapWmsConfig()) {
                arrayList.add(MapApolloHawaii.getMapWmsConfig());
            }
            String andriodMapOverpass3dConfig = MapApolloHawaii.getAndriodMapOverpass3dConfig();
            if (andriodMapOverpass3dConfig != null && andriodMapOverpass3dConfig.length() > 0) {
                arrayList.add(andriodMapOverpass3dConfig);
            }
            String fishboneBubbleOnlyConfig = MapApolloHawaii.getFishboneBubbleOnlyConfig();
            if (fishboneBubbleOnlyConfig != null && fishboneBubbleOnlyConfig.length() > 0) {
                arrayList.add(fishboneBubbleOnlyConfig);
            }
            String showCurvyRouteName = MapApolloHawaii.getShowCurvyRouteName();
            if (showCurvyRouteName != null && showCurvyRouteName.length() > 0) {
                arrayList.add(showCurvyRouteName);
            }
            CameraPosition cameraPosition = this.options.getCameraPosition();
            float maxSkewAngle = this.options.getMaxSkewAngle();
            double d = cameraPosition.target.longitude;
            float f = maxSkewAngle;
            double d2 = cameraPosition.target.latitude;
            float scale = (float) MathsUtils.getScale((double) cameraPosition.zoom);
            float f2 = cameraPosition.bearing;
            float f3 = cameraPosition.tilt;
            int i = MapApolloHawaii.BASE_MAP_VERSION == 3 ? 3 : 4;
            EngineLogSwitch engineLogSwitch = EngineLogSwitch.OFF;
            C8982a aVar = r3;
            C8982a aVar2 = new C8982a();
            GLBaseMapView.Option option = r3;
            GLBaseMapView.Option option2 = new GLBaseMapView.Option(configPath, mapPath4Language, satPath, wmsPath, arrayList, 20, 4, f, d, d2, scale, f2, f3, false, 0, i, engineLogSwitch, aVar, this.options.isNight(), this.options.isNavi(), this.options.isTraffic(), true, this.options.getMapTheme(), this.options.isDynamicLayerEnable());
            return new GLBaseMapView(gLViewManager2, option, new C9015b(gLViewManager2), true);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.handler.removeCallbacksAndMessages((Object) null);
        this.mapCallback.onDestroy();
    }

    private class MapCallback {
        private final ArrayList<OnMapReadyCallback> onMapReadyCallbackList;

        private MapCallback() {
            this.onMapReadyCallbackList = new ArrayList<>();
        }

        /* access modifiers changed from: package-private */
        public void addOnMapReadyCallback(OnMapReadyCallback onMapReadyCallback) {
            this.onMapReadyCallbackList.add(onMapReadyCallback);
        }

        /* access modifiers changed from: package-private */
        public void onMapReady() {
            if (this.onMapReadyCallbackList.size() > 0) {
                Iterator<OnMapReadyCallback> it = this.onMapReadyCallbackList.iterator();
                while (it.hasNext()) {
                    OnMapReadyCallback next = it.next();
                    if (next != null) {
                        next.onMapReady(VKMapViewInner.this.hwDidiMap);
                    }
                    it.remove();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void onDestroy() {
            this.onMapReadyCallbackList.clear();
        }
    }

    public void dumpInspectInfo() {
        GLViewManager gLViewManage = getGLViewManage();
        gLViewManage.dumpInspectInfo(new File(StorageUtils.getSDRootPath() + "/.mapdump/"));
    }
}
