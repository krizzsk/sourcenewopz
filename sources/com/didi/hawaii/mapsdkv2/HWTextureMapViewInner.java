package com.didi.hawaii.mapsdkv2;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import com.didi.hawaii.log.HWLog;
import com.didi.hawaii.mapsdkv2.common.MapGlobal;
import com.didi.hawaii.mapsdkv2.common.MathsUtils;
import com.didi.hawaii.mapsdkv2.core.EngineLogSwitch;
import com.didi.hawaii.mapsdkv2.core.GLBaseMapFactory;
import com.didi.hawaii.mapsdkv2.core.GLBaseMapView;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.core.OnBaseMapCreateCallback;
import com.didi.hawaii.mapsdkv2.core.TextureHostView;
import com.didi.hawaii.utils.OmegaUtils;
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

abstract class HWTextureMapViewInner extends TextureHostView implements MapOpenGL {
    /* access modifiers changed from: private */
    public final Handler handler = new Handler();
    /* access modifiers changed from: private */
    public HWDidiMap hwDidiMap;
    /* access modifiers changed from: private */
    public boolean isDestroyed = false;
    /* access modifiers changed from: private */
    public final MapCallback mapCallback = new MapCallback();

    public HWTextureMapViewInner(Context context) {
        super(context);
        init();
    }

    public HWTextureMapViewInner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public HWTextureMapViewInner(Context context, MapOptions mapOptions) {
        super(context, mapOptions);
        init();
    }

    /* access modifiers changed from: protected */
    public void init() {
        OmegaUtils.reportTextureView();
        setOnBaseMapCreatedCallback(new OnBaseMapCreateCallback() {
            public void onCreate() {
                HWLog.m16761i("hawaii-map", "MapView init callback");
                HWTextureMapViewInner.this.handler.post(new Runnable() {
                    public void run() {
                        if (!(HWTextureMapViewInner.this.getParent() instanceof MapView)) {
                            throw new IllegalArgumentException("HWMapView must be in MapView!");
                        } else if (!HWTextureMapViewInner.this.isDestroyed) {
                            HWDidiMap unused = HWTextureMapViewInner.this.hwDidiMap = new HWDidiMap(HWTextureMapViewInner.this, (MapView) HWTextureMapViewInner.this.getParent());
                            HWTextureMapViewInner.this.mapCallback.onMapReady();
                        }
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

        HWBaseMapFactory(MapOptions mapOptions) {
            this.options = mapOptions;
        }

        public GLBaseMapView newGLBaseMapView(GLViewManager gLViewManager) {
            GLViewManager gLViewManager2 = gLViewManager;
            String configPath = gLViewManager.getMapContext().getResources().getPrefs().getConfigPath();
            String mapPath4Language = gLViewManager.getMapContext().getResources().getPrefs().getMapPath4Language(MapGlobal.curLanguage);
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
            int i = MapGlobal.curLanguage;
            int i2 = MapApolloHawaii.BASE_MAP_VERSION == 3 ? 3 : 4;
            EngineLogSwitch engineLogSwitch = EngineLogSwitch.OFF;
            C8982a aVar = r3;
            C8982a aVar2 = new C8982a();
            GLBaseMapView.Option option = r3;
            GLBaseMapView.Option option2 = new GLBaseMapView.Option(configPath, mapPath4Language, satPath, wmsPath, arrayList, 20, 4, f, d, d2, scale, f2, f3, false, i, i2, engineLogSwitch, aVar, this.options.isNight(), this.options.isNavi(), this.options.isTraffic(), false, this.options.getMapTheme(), this.options.isDynamicLayerEnable());
            return new GLBaseMapView(gLViewManager2, option, new C9015b(gLViewManager2), false);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.handler.removeCallbacksAndMessages((Object) null);
        HWLog.m16761i("hawaii-map", "MapViewInner onDestroy:" + this.hwDidiMap);
        this.mapCallback.onDestroy();
        this.isDestroyed = true;
        HWDidiMap hWDidiMap = this.hwDidiMap;
        if (hWDidiMap != null) {
            hWDidiMap.onDestroy();
        } else {
            OmegaUtils.trackMapException("HWDidiMap is null in HWViewInner");
        }
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
                        next.onMapReady(HWTextureMapViewInner.this.hwDidiMap);
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
