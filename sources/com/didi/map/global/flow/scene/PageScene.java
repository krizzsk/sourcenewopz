package com.didi.map.global.flow.scene;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.didi.common.map.BestViewer;
import com.didi.common.map.Map;
import com.didi.common.map.MapVendor;
import com.didi.common.map.listener.OnMapGestureListener;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.didi.map.global.flow.model.Bundle;
import com.didi.map.global.flow.scene.IScene;
import com.didi.map.global.flow.scene.PageSceneParam;
import com.didi.map.global.flow.scene.global.IMapChangeListener;
import com.didi.map.global.model.location.NLPRegisterParam;
import com.didi.map.global.model.omega.AppFluentOmega;

public abstract class PageScene<P extends PageSceneParam> implements IScene, ISceneController {

    /* renamed from: a */
    private static final String f26303a = "PageScene";

    /* renamed from: b */
    private final int f26304b;

    /* renamed from: c */
    private OnMapGestureListener f26305c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f26306d;

    /* renamed from: e */
    private AppFluentOmega f26307e;
    protected boolean isScenePaused;
    protected boolean isSceneValid;
    protected Bundle mBundle;
    protected LatLng mDownLatLng;
    protected double mDownZoom;
    protected Handler mHandler = new Handler(Looper.getMainLooper());
    protected IMapChangeListener mMapChangeListener;
    protected MapViewHolder mMapView;
    protected Padding mPadding;
    protected P mParam;

    /* access modifiers changed from: protected */
    public void handleTrackDragMapEvent() {
    }

    public Bundle transferParams() {
        return null;
    }

    public PageScene(P p, MapViewHolder mapViewHolder) {
        this.mParam = p;
        this.mMapChangeListener = p.getMapChangeListener();
        this.mMapView = mapViewHolder;
        if (getMap() != null) {
            this.mPadding = getMap().getPadding();
        }
        IScene.Scene scene = (IScene.Scene) getClass().getAnnotation(IScene.Scene.class);
        this.f26304b = scene != null ? scene.mo74615id() : -1;
        m18599a();
        m18602b();
        this.f26307e = AppFluentOmega.getInstance();
    }

    /* renamed from: a */
    private void m18599a() {
        this.f26305c = new OnMapGestureListener() {
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
                boolean unused = PageScene.this.f26306d = true;
                PageScene.this.showResetView();
                if (PageScene.this.getMap() == null || PageScene.this.getMap().getCameraPosition() == null) {
                    return false;
                }
                PageScene pageScene = PageScene.this;
                pageScene.mDownLatLng = pageScene.getMap().getCameraPosition().target;
                PageScene pageScene2 = PageScene.this;
                pageScene2.mDownZoom = pageScene2.getMap().getCameraPosition().zoom;
                return false;
            }

            public boolean onUp(float f, float f2) {
                if (PageScene.this.f26306d) {
                    boolean unused = PageScene.this.f26306d = false;
                    PageScene.this.handleTrackDragMapEvent();
                }
                return false;
            }
        };
    }

    public void enter(Bundle bundle) {
        this.isSceneValid = true;
        this.mBundle = bundle;
        if (getMap() != null) {
            getMap().addOnMapGestureListener(this.f26305c);
        }
        MapViewHolder mapViewHolder = this.mMapView;
        if (mapViewHolder != null) {
            mapViewHolder.setLocationVisible(true);
        }
        BestViewer.setDefaultZoomLevel(getDefaultZoomLevel());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x005e, code lost:
        com.didi.map.sdk.env.PaxEnvironment.getInstance().setPage(com.didi.map.sdk.env.Page.SUG_PAGE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x007c, code lost:
        com.didi.map.sdk.env.PaxEnvironment.getInstance().setPage(com.didi.map.sdk.env.Page.INSERVICE_PAGE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0090, code lost:
        com.didi.map.sdk.env.PaxEnvironment.getInstance().setPage(com.didi.map.sdk.env.Page.PICONF_PAGE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x009a, code lost:
        com.didi.map.sdk.env.PaxEnvironment.getInstance().setPage(com.didi.map.sdk.env.Page.CONF_PAGE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00a4, code lost:
        com.didi.map.sdk.env.PaxEnvironment.getInstance().setPage(com.didi.map.sdk.env.Page.HOMEPAGE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        return;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m18602b() {
        /*
            r2 = this;
            com.didi.map.sdk.env.PaxEnvironment r0 = com.didi.map.sdk.env.PaxEnvironment.getInstance()
            com.didi.map.sdk.env.RoleType r1 = com.didi.map.sdk.env.RoleType.PASSENGER
            r0.setRoleTypeInternal(r1)
            int r0 = r2.f26304b
            switch(r0) {
                case 1001: goto L_0x00a4;
                case 1002: goto L_0x009a;
                case 1003: goto L_0x0090;
                case 1004: goto L_0x0086;
                case 1005: goto L_0x007c;
                case 1006: goto L_0x007c;
                case 1007: goto L_0x007c;
                case 1008: goto L_0x007c;
                case 1009: goto L_0x0072;
                case 1010: goto L_0x0068;
                case 1011: goto L_0x005e;
                default: goto L_0x000e;
            }
        L_0x000e:
            switch(r0) {
                case 2001: goto L_0x00a4;
                case 2002: goto L_0x0090;
                case 2003: goto L_0x009a;
                case 2004: goto L_0x009a;
                case 2005: goto L_0x0054;
                case 2006: goto L_0x0054;
                case 2007: goto L_0x007c;
                case 2008: goto L_0x007c;
                case 2009: goto L_0x007c;
                case 2010: goto L_0x007c;
                case 2011: goto L_0x007c;
                case 2012: goto L_0x007c;
                case 2013: goto L_0x007c;
                case 2014: goto L_0x007c;
                case 2015: goto L_0x005e;
                case 2016: goto L_0x005e;
                case 2017: goto L_0x005e;
                case 2018: goto L_0x005e;
                case 2019: goto L_0x005e;
                case 2020: goto L_0x005e;
                case 2021: goto L_0x005e;
                default: goto L_0x0011;
            }
        L_0x0011:
            switch(r0) {
                case 3001: goto L_0x004a;
                case 3002: goto L_0x0040;
                case 3003: goto L_0x0035;
                case 3004: goto L_0x002a;
                case 3005: goto L_0x001f;
                default: goto L_0x0014;
            }
        L_0x0014:
            com.didi.map.sdk.env.PaxEnvironment r0 = com.didi.map.sdk.env.PaxEnvironment.getInstance()
            com.didi.map.sdk.env.Page r1 = com.didi.map.sdk.env.Page.OTHER_PAGE
            r0.setPage(r1)
            goto L_0x00ad
        L_0x001f:
            com.didi.map.sdk.env.PaxEnvironment r0 = com.didi.map.sdk.env.PaxEnvironment.getInstance()
            com.didi.map.sdk.env.Page r1 = com.didi.map.sdk.env.Page.MINIBUS_OVER_PAGE
            r0.setPage(r1)
            goto L_0x00ad
        L_0x002a:
            com.didi.map.sdk.env.PaxEnvironment r0 = com.didi.map.sdk.env.PaxEnvironment.getInstance()
            com.didi.map.sdk.env.Page r1 = com.didi.map.sdk.env.Page.MINIBUS_SERVICE_PAGE
            r0.setPage(r1)
            goto L_0x00ad
        L_0x0035:
            com.didi.map.sdk.env.PaxEnvironment r0 = com.didi.map.sdk.env.PaxEnvironment.getInstance()
            com.didi.map.sdk.env.Page r1 = com.didi.map.sdk.env.Page.MINIBUS_PICKING_PAGE
            r0.setPage(r1)
            goto L_0x00ad
        L_0x0040:
            com.didi.map.sdk.env.PaxEnvironment r0 = com.didi.map.sdk.env.PaxEnvironment.getInstance()
            com.didi.map.sdk.env.Page r1 = com.didi.map.sdk.env.Page.MINIBUS_APPOINT_PAGE
            r0.setPage(r1)
            goto L_0x00ad
        L_0x004a:
            com.didi.map.sdk.env.PaxEnvironment r0 = com.didi.map.sdk.env.PaxEnvironment.getInstance()
            com.didi.map.sdk.env.Page r1 = com.didi.map.sdk.env.Page.MINIBUS_CONFIRM_PAGE
            r0.setPage(r1)
            goto L_0x00ad
        L_0x0054:
            com.didi.map.sdk.env.PaxEnvironment r0 = com.didi.map.sdk.env.PaxEnvironment.getInstance()
            com.didi.map.sdk.env.Page r1 = com.didi.map.sdk.env.Page.PREVIEW_PAGE
            r0.setPage(r1)
            goto L_0x00ad
        L_0x005e:
            com.didi.map.sdk.env.PaxEnvironment r0 = com.didi.map.sdk.env.PaxEnvironment.getInstance()
            com.didi.map.sdk.env.Page r1 = com.didi.map.sdk.env.Page.SUG_PAGE
            r0.setPage(r1)
            goto L_0x00ad
        L_0x0068:
            com.didi.map.sdk.env.PaxEnvironment r0 = com.didi.map.sdk.env.PaxEnvironment.getInstance()
            com.didi.map.sdk.env.Page r1 = com.didi.map.sdk.env.Page.ENDS_PAGE
            r0.setPage(r1)
            goto L_0x00ad
        L_0x0072:
            com.didi.map.sdk.env.PaxEnvironment r0 = com.didi.map.sdk.env.PaxEnvironment.getInstance()
            com.didi.map.sdk.env.Page r1 = com.didi.map.sdk.env.Page.LOCKSCREEN_PAGE
            r0.setPage(r1)
            goto L_0x00ad
        L_0x007c:
            com.didi.map.sdk.env.PaxEnvironment r0 = com.didi.map.sdk.env.PaxEnvironment.getInstance()
            com.didi.map.sdk.env.Page r1 = com.didi.map.sdk.env.Page.INSERVICE_PAGE
            r0.setPage(r1)
            goto L_0x00ad
        L_0x0086:
            com.didi.map.sdk.env.PaxEnvironment r0 = com.didi.map.sdk.env.PaxEnvironment.getInstance()
            com.didi.map.sdk.env.Page r1 = com.didi.map.sdk.env.Page.WAITING_PAGE
            r0.setPage(r1)
            goto L_0x00ad
        L_0x0090:
            com.didi.map.sdk.env.PaxEnvironment r0 = com.didi.map.sdk.env.PaxEnvironment.getInstance()
            com.didi.map.sdk.env.Page r1 = com.didi.map.sdk.env.Page.PICONF_PAGE
            r0.setPage(r1)
            goto L_0x00ad
        L_0x009a:
            com.didi.map.sdk.env.PaxEnvironment r0 = com.didi.map.sdk.env.PaxEnvironment.getInstance()
            com.didi.map.sdk.env.Page r1 = com.didi.map.sdk.env.Page.CONF_PAGE
            r0.setPage(r1)
            goto L_0x00ad
        L_0x00a4:
            com.didi.map.sdk.env.PaxEnvironment r0 = com.didi.map.sdk.env.PaxEnvironment.getInstance()
            com.didi.map.sdk.env.Page r1 = com.didi.map.sdk.env.Page.HOMEPAGE
            r0.setPage(r1)
        L_0x00ad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.flow.scene.PageScene.m18602b():void");
    }

    public void onResume() {
        this.isScenePaused = false;
    }

    public void onPause() {
        this.isScenePaused = true;
    }

    public void leave() {
        this.isSceneValid = false;
        if (getMap() != null) {
            if (this.f26305c != null) {
                getMap().removeOnMapGestureListener(this.f26305c);
            }
            if (getMap().getUiSettings() != null) {
                getMap().getUiSettings().setLogoGravityWithMargin(0, 0, 0, 0, 0);
            }
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        removeMapChangeListener();
        MapViewHolder mapViewHolder = this.mMapView;
        if (mapViewHolder != null) {
            mapViewHolder.setNeedNlpLocation((NLPRegisterParam) null);
            this.mMapView.setLocationVisible(false);
        }
    }

    public void hideResetView() {
        IMapChangeListener iMapChangeListener = this.mMapChangeListener;
        if (iMapChangeListener != null) {
            iMapChangeListener.hideResetView();
        }
    }

    public void showResetView() {
        IMapChangeListener iMapChangeListener = this.mMapChangeListener;
        if (iMapChangeListener != null) {
            iMapChangeListener.showResetView();
        }
    }

    public Context getContext() {
        MapViewHolder mapViewHolder = this.mMapView;
        if (mapViewHolder == null || mapViewHolder.getMapView() == null) {
            return null;
        }
        return this.mMapView.getMapView().getContext();
    }

    public Map getMap() {
        MapViewHolder mapViewHolder = this.mMapView;
        if (mapViewHolder == null || mapViewHolder.getMapView() == null) {
            return null;
        }
        return this.mMapView.getMapView().getMap();
    }

    public void removeMapChangeListener() {
        this.mMapChangeListener = null;
    }

    public void doBestView(Padding padding) {
        DLog.m7384d(f26303a, "doBestView  padding =" + padding.toString(), new Object[0]);
        this.mPadding = padding;
    }

    /* renamed from: com.didi.map.global.flow.scene.PageScene$2 */
    static /* synthetic */ class C96352 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$common$map$MapVendor;

        static {
            int[] iArr = new int[MapVendor.values().length];
            $SwitchMap$com$didi$common$map$MapVendor = iArr;
            try {
                iArr[MapVendor.DIDI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public float getDefaultZoomLevel() {
        if (getMap() != null && C96352.$SwitchMap$com$didi$common$map$MapVendor[getMap().getMapVendor().ordinal()] == 1) {
            return 18.0f;
        }
        return 16.0f;
    }

    public AppFluentOmega getAppFluentOmega() {
        return this.f26307e;
    }
}
