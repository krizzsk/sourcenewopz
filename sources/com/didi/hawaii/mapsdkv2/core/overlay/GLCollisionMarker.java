package com.didi.hawaii.mapsdkv2.core.overlay;

import android.graphics.PointF;
import com.didi.hawaii.mapsdkv2.core.AnchorTexture;
import com.didi.hawaii.mapsdkv2.core.GLOverlayView;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.core.IGLInfoWindow;
import com.didi.hawaii.mapsdkv2.core.Texture;
import com.didi.hawaii.mapsdkv2.core.overlay.GLMarkerInfo;
import com.didi.hawaii.mapsdkv2.jni.DDMapPointArray;
import com.didi.hawaii.mapsdkv2.jni.HWBSManager;
import com.didi.hawaii.mapsdkv2.jni.MapEngineJNI;
import com.didi.hawaii.mapsdkv2.jni.MapOverlay;
import com.didi.hawaii.mapsdkv2.jni.MapOverlayRect;
import com.didi.hawaii.mapsdkv2.jni.MapOverlayRectArray;
import com.didi.hawaii.mapsdkv2.jni.MapPointArea;
import com.didi.hawaii.mapsdkv2.jni.MapPointSection;
import com.didi.hawaii.mapsdkv2.jni.MapPointSectionArray;
import com.didi.hawaii.mapsdkv2.jni.MapVisibleChangeAnimateAttrs;
import com.didi.hawaii.mapsdkv2.view.RenderTask;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.LatLngBounds;
import com.didi.sdk.apm.SystemUtils;
import java.util.ArrayList;
import java.util.List;

public class GLCollisionMarker extends GLMarkerInfo {

    /* renamed from: a */
    private static final String f24072a = "GLCollisionMarker";

    /* renamed from: b */
    private static final int f24073b = -1;

    /* renamed from: c */
    private int f24074c = Option.NO_GROUP;
    protected int collisionType;

    /* renamed from: d */
    private boolean f24075d;

    /* renamed from: e */
    private int f24076e = -1;

    /* renamed from: f */
    private boolean f24077f = true;

    /* renamed from: g */
    private List<AnchorTexture> f24078g = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public HWBSManager f24079h;

    /* renamed from: i */
    private float f24080i = -1.0f;

    /* renamed from: j */
    private int f24081j = -1;

    /* renamed from: k */
    private final Option.MarkerSection f24082k;

    /* renamed from: l */
    private MapVisibleChangeAnimateAttrs f24083l;

    /* renamed from: m */
    private boolean f24084m = false;
    protected int priority;
    protected int type;

    public GLCollisionMarker(GLViewManager gLViewManager, Option option) {
        super(gLViewManager, option);
        this.f24074c = option.groupId;
        this.priority = option.priority;
        this.collisionType = option.collisionType;
        this.f24082k = option.pointArea;
        this.type = option.type;
        this.f24078g = option.rects;
        this.f24083l = option.animateAttrs;
        this.f24077f = option.isInfoWindowCollied;
        if (this.f24078g.size() == 1) {
            this.anchorX = this.f24078g.get(0).anchorX;
            this.anchorY = this.f24078g.get(0).anchorY;
            this.texture = this.f24078g.get(0);
        }
    }

    public void attachCollisionEngine(HWBSManager hWBSManager) {
        this.f24079h = hWBSManager;
    }

    public int getCurShowTextureIndex() {
        return this.f24076e;
    }

    public boolean isTrueVisible() {
        return this.f24075d && this.visible;
    }

    /* access modifiers changed from: protected */
    public void onAdded() {
        if (m17128a()) {
            this.f24079h.addOverlay(m17134d());
            this.f24079h.handleCollision();
            m17133c();
        }
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        if (m17128a()) {
            boolean removeOverlay = this.f24079h.removeOverlay(Long.valueOf(getId()).longValue());
            this.f24079h.handleCollision();
            if (removeOverlay) {
                this.mDisplayId = -2;
            }
            this.f24079h = null;
        }
        super.onRemove();
    }

    public void setPosition(LatLng latLng) {
        if (latLng != null && !this.center.equalLatLng(latLng)) {
            this.center.set(latLng);
            this.infoWindowHolder.setPosition(latLng);
            set(new RenderTask() {
                public void run() {
                    if (GLCollisionMarker.this.m17128a()) {
                        GLCollisionMarker.this.f24079h.updateOverlayPosition(Long.valueOf(GLCollisionMarker.this.getId()).longValue(), GLCollisionMarker.this.center.getLongitude(), GLCollisionMarker.this.center.getLatitude());
                        GLCollisionMarker.this.f24079h.handleCollision();
                    }
                }
            });
        }
    }

    public void updateOption(GLMarkerInfo.Option option) {
        showInfoWindow(option.isVisible());
        setPosition(new LatLng(option.latitude, option.longitude));
        onUpdateOption(option);
    }

    public void onUpdateOption(GLOverlayView.Option option) {
        if (option instanceof Option) {
            update((Option) option);
            set(new RenderTask() {
                public void run() {
                    if (GLCollisionMarker.this.m17128a()) {
                        MapOverlay c = GLCollisionMarker.this.m17134d();
                        GLCollisionMarker.this.f24079h.updateOverlay(c);
                        if (GLCollisionMarker.this.getInfoWindowView() != null) {
                            GLCollisionMarker.this.getInfoWindowView().setCollisionOption(c);
                        }
                        GLCollisionMarker.this.f24079h.handleCollision();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void update(Option option) {
        super.update(option);
        this.f24074c = option.groupId;
        this.priority = option.priority;
        this.collisionType = option.collisionType;
        this.type = option.type;
        List<AnchorTexture> access$200 = option.rects;
        this.f24078g = access$200;
        if (access$200.size() == 1) {
            this.anchorX = this.f24078g.get(0).anchorX;
            this.anchorY = this.f24078g.get(0).anchorY;
            this.texture = this.f24078g.get(0);
        }
        this.zIndex = option.getzIndex();
        setZIndex(option.getzIndex());
    }

    public void setInfoWindowView(IGLInfoWindow iGLInfoWindow) {
        if (m17128a()) {
            if (this.f24077f) {
                iGLInfoWindow.attachCollisionEngine(this.f24079h, m17134d());
            }
            super.setInfoWindowView(iGLInfoWindow);
        }
    }

    public void setUpdateRealTime(boolean z) {
        attachToFrame(z);
    }

    public void onFrameFinish(boolean z) {
        if (m17128a()) {
            super.onFrameFinish(z);
            m17133c();
        }
    }

    /* access modifiers changed from: protected */
    public void onSetVisible(boolean z) {
        if (m17128a()) {
            this.f24079h.setOverlayVisible(Long.valueOf(getId()).longValue(), z);
            this.f24079h.handleCollision();
        }
    }

    public void onSetAlpha(float f) {
        if (m17128a()) {
            if (m17131b()) {
                super.onSetAlpha(f);
            } else {
                this.f24080i = f;
            }
        }
    }

    public void setZIndex(int i) {
        if (m17128a()) {
            if (m17131b()) {
                super.setZIndex(i);
            } else {
                this.f24081j = i;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m17128a() {
        return (this.f24079h == null || this.mDisplayId == -2) ? false : true;
    }

    /* renamed from: b */
    private boolean m17131b() {
        return this.mDisplayId > 0;
    }

    /* renamed from: c */
    private void m17133c() {
        if (this.mDisplayId != -2) {
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            int[] iArr3 = new int[1];
            this.f24079h.getOverlayProperty(Long.parseLong(getId()), iArr, iArr2, iArr3);
            this.mDisplayId = iArr[0];
            this.f24075d = iArr2[0] == 1;
            this.f24076e = iArr3[0];
            this.anchorX = this.f24078g.get(iArr3[0]).anchorX;
            this.anchorY = this.f24078g.get(iArr3[0]).anchorY;
            this.texture = this.f24078g.get(iArr3[0]);
            if (!this.f24084m && this.mDisplayId > 0) {
                this.mViewManager.insertCollisionDisPlayId(this.mDisplayId, this);
                if (this.f24081j != -1) {
                    this.mMapCanvas.setZIndex(this.mDisplayId, calculateTrueZIndex(this.mLayer, this.f24081j));
                }
                if (this.f24080i != -1.0f) {
                    this.mMapCanvas.setMarkerAlpha(this.mDisplayId, this.f24080i);
                }
                this.f24084m = true;
            }
        }
    }

    public static class Option extends GLMarkerInfo.Option {
        public static int NO_GROUP = -1;
        /* access modifiers changed from: private */
        public MapVisibleChangeAnimateAttrs animateAttrs;
        protected int collisionType;
        /* access modifiers changed from: private */
        public int groupId = NO_GROUP;
        /* access modifiers changed from: private */
        public boolean isInfoWindowCollied = true;
        /* access modifiers changed from: private */
        public MarkerSection pointArea;
        protected int priority;
        /* access modifiers changed from: private */
        public List<AnchorTexture> rects;
        protected int type;

        public static class MarkerSection {
            public int[] endNums;
            public List<LatLng> points;
            public long routeID;
            public int sectionCount;
            public int[] startNums;
        }

        public void setType(int i) {
            this.type = i;
        }

        public void setCollisionType(int i) {
            this.collisionType = i;
        }

        public void setPointArea(MarkerSection markerSection) {
            this.pointArea = markerSection;
        }

        public void setPriority(int i) {
            this.priority = i;
        }

        public void setGroupId(int i) {
            this.groupId = i;
        }

        public void setInfoWindowCollied(boolean z) {
            this.isInfoWindowCollied = z;
        }

        public void setRects(List<AnchorTexture> list) {
            this.rects = list;
        }

        public void setAnimateAttrs(MapVisibleChangeAnimateAttrs mapVisibleChangeAnimateAttrs) {
            this.animateAttrs = mapVisibleChangeAnimateAttrs;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public MapOverlay m17134d() {
        MapOverlay mapOverlay = new MapOverlay();
        mapOverlay.setOverlayId(Long.valueOf(getId()).longValue());
        mapOverlay.setType(this.type);
        mapOverlay.setGroupId(this.f24074c);
        mapOverlay.setCollisionType(this.collisionType);
        mapOverlay.setLongitude(this.center.getLongitude());
        mapOverlay.setLatitude(this.center.getLatitude());
        Option.MarkerSection markerSection = this.f24082k;
        if (!(markerSection == null || markerSection.points == null)) {
            MapPointArea mapPointArea = new MapPointArea();
            int size = this.f24082k.points.size();
            DDMapPointArray dDMapPointArray = new DDMapPointArray(size);
            for (int i = 0; i < size; i++) {
                dDMapPointArray.setitem(i, MapEngineJNI.DDMapPointForCoordinate(MapEngineJNI.DDLocationCoordinate2DMake(this.f24082k.points.get(i).longitude, this.f24082k.points.get(i).latitude)));
            }
            mapPointArea.setMapPoint(dDMapPointArray.cast());
            mapPointArea.setMapPointCount(size);
            mapPointArea.setRouteID(this.f24082k.routeID);
            MapPointSectionArray mapPointSectionArray = new MapPointSectionArray(32);
            for (int i2 = 0; i2 < this.f24082k.sectionCount; i2++) {
                MapPointSection mapPointSection = new MapPointSection();
                mapPointSection.setStartNum(this.f24082k.startNums[i2]);
                mapPointSection.setEndNum(this.f24082k.endNums[i2]);
                mapPointSectionArray.setitem(i2, mapPointSection);
            }
            mapPointArea.setSections(mapPointSectionArray.cast());
            mapPointArea.setSectionCount(this.f24082k.sectionCount);
            mapOverlay.setPointArea(mapPointArea);
        }
        mapOverlay.setScaleX(this.scaleX);
        mapOverlay.setScaleY(this.scaleY);
        mapOverlay.setFixPosX(this.fixPosX);
        mapOverlay.setFixPosY(this.fixPosY);
        mapOverlay.setAngle(this.angle);
        mapOverlay.setIsClockwise(this.isClockwise);
        mapOverlay.setIsFastLoad(this.isFastLoad);
        mapOverlay.setIsAvoidAnno(this.isAvoidAnno);
        mapOverlay.setIsOrthographicProject(this.isOrthographicProject);
        mapOverlay.setZIndex(this.zIndex);
        mapOverlay.setAlpha(this.alpha);
        mapOverlay.setVisible(this.visible);
        mapOverlay.setPriority(this.priority);
        mapOverlay.setRectCnt(this.f24078g.size());
        MapOverlayRectArray mapOverlayRectArray = new MapOverlayRectArray(4);
        String str = "" + this.f24078g.hashCode();
        int size2 = this.f24078g.size();
        for (int i3 = 0; i3 < size2; i3++) {
            AnchorTexture anchorTexture = this.f24078g.get(i3);
            MapOverlayRect mapOverlayRect = new MapOverlayRect();
            mapOverlayRect.setAnchorX(anchorTexture.anchorX);
            mapOverlayRect.setAnchorY(anchorTexture.anchorY);
            mapOverlayRect.setWidth(anchorTexture.width);
            mapOverlayRect.setHeight(anchorTexture.height);
            mapOverlayRect.setName(anchorTexture.getBitmapKey());
            mapOverlayRectArray.setitem(i3, mapOverlayRect);
            str = str + "|" + anchorTexture.getBitmapKey();
        }
        mapOverlay.setRects(mapOverlayRectArray.cast());
        mapOverlay.setShowInfo(f24072a + str);
        MapVisibleChangeAnimateAttrs mapVisibleChangeAnimateAttrs = this.f24083l;
        if (mapVisibleChangeAnimateAttrs != null) {
            mapOverlay.setVisibleChangeAnimateAttrs(mapVisibleChangeAnimateAttrs);
        }
        return mapOverlay;
    }

    public void setOffset(PointF pointF) {
        m17127a("setOffset");
    }

    public void setAnchor(float f, float f2) {
        m17127a("setAnchor");
    }

    public void setTexture(Texture texture) {
        m17127a("setTexture");
    }

    public void setGroundIcon(LatLngBounds latLngBounds, Texture texture) {
        m17127a("setGroundIcon");
    }

    /* renamed from: a */
    private void m17127a(String str) {
        SystemUtils.log(6, "mapsdk", "CollisionMarker can not support " + str + " when the inner marker in collision", (Throwable) null, "com.didi.hawaii.mapsdkv2.core.overlay.GLCollisionMarker", 433);
    }

    private static final class UnSupportMethodException extends RuntimeException {
        public UnSupportMethodException(String str) {
            super(str);
        }
    }
}
