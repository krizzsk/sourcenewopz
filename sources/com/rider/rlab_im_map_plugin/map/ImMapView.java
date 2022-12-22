package com.rider.rlab_im_map_plugin.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.didi.common.map.BestViewer;
import com.didi.common.map.Map;
import com.didi.common.map.MapVendor;
import com.didi.common.map.MapView;
import com.didi.common.map.OnMapReadyCallBack;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.listener.CancelableCallback;
import com.didi.common.map.listener.OnMapGestureListener;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.CameraUpdate;
import com.didi.common.map.model.CameraUpdateFactory;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.DisplayUtils;
import com.didi.common.map.util.ImageUtil;
import com.didi.flutter.nacho2.p115v2.NachoLifecycleManager;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager;
import com.rider.rlab_im_map_plugin.channel.MapIMPluginHelper;
import com.rider.rlab_im_map_plugin.channel.NavIMServiceImpl;
import com.rider.rlab_im_map_plugin.engine.ImMapConfig;
import com.rider.rlab_im_map_plugin.marker.MyLocationMarker;
import com.rider.rlab_im_map_plugin.tool.ImFavorFrom;
import com.rider.rlab_im_map_plugin.tool.ImMapTrace;
import com.rider.rlab_im_map_plugin.tool.ImMapUtils;
import com.rider.rlab_im_map_plugin.xpanel.XPanelLayout;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class ImMapView extends FrameLayout implements IMapView {

    /* renamed from: a */
    private static final String f55882a = "GoogleWatermark";

    /* renamed from: c */
    private static final String f55883c = "im_water_marker_tag";
    /* access modifiers changed from: private */

    /* renamed from: A */
    public final MapView.TouchEventListener f55884A;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Logger f55885b;

    /* renamed from: d */
    private ImageView f55886d;

    /* renamed from: e */
    private final Context f55887e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Map f55888f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public MapView f55889g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final MyLocationListener f55890h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public MyLocationMarker f55891i;

    /* renamed from: j */
    private int f55892j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public double f55893k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public double f55894l;

    /* renamed from: m */
    private View f55895m;

    /* renamed from: n */
    private View f55896n;

    /* renamed from: o */
    private View f55897o;

    /* renamed from: p */
    private View f55898p;

    /* renamed from: q */
    private List<IMapElement> f55899q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public final DefaultMapGestureListener f55900r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public int f55901s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public int f55902t;

    /* renamed from: u */
    private int f55903u;

    /* renamed from: v */
    private int f55904v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public final double f55905w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public final double f55906x;

    /* renamed from: y */
    private Marker f55907y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public boolean f55908z;

    public ImMapView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ImMapView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImMapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f55885b = LoggerFactory.getLogger("MapViewImpl");
        this.f55899q = new ArrayList();
        this.f55900r = new DefaultMapGestureListener();
        this.f55908z = false;
        this.f55884A = new MapView.TouchEventListener() {
            private float currentX = 0.0f;
            private float currentY = 0.0f;
            private int touchSlop = 0;
            private XPanelLayout xPanelLayout;

            public void onTouchEvent(MotionEvent motionEvent) {
                if (this.touchSlop == 0) {
                    this.touchSlop = ViewConfiguration.get(ImMapView.this.getContext()).getScaledTouchSlop();
                }
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            float x = motionEvent.getX();
                            float y = motionEvent.getY();
                            float f = x - this.currentX;
                            float f2 = y - this.currentY;
                            if (!ImMapView.this.f55908z && ImMapView.this.getMap() != null && (Math.abs(f) > ((float) this.touchSlop) || Math.abs(f2) > ((float) this.touchSlop))) {
                                ImMapView.this.f55885b.debug("onTouchEvent: setMapDragStartChange start drag", new Object[0]);
                                boolean unused = ImMapView.this.f55908z = true;
                                MapIMPluginHelper.setMapDragStartChange();
                                MapIMPluginHelper.isCheckOverlap(false);
                            }
                            XPanelLayout xPanelLayout2 = this.xPanelLayout;
                            if (xPanelLayout2 != null) {
                                xPanelLayout2.setMoveFlag(true);
                                return;
                            }
                            return;
                        } else if (action != 3) {
                            return;
                        }
                    }
                    float x2 = motionEvent.getX();
                    float y2 = motionEvent.getY();
                    float f3 = x2 - this.currentX;
                    float f4 = y2 - this.currentY;
                    if ((Math.abs(f3) > ((float) this.touchSlop) || Math.abs(f4) > ((float) this.touchSlop)) && ImMapView.this.getMap() != null) {
                        ImMapView.this.f55885b.debug("onTouchEvent: up drag change", new Object[0]);
                        LatLng fromScreenLocation = ImMapUtils.fromScreenLocation(ImMapView.this.f55888f, (float) (ImMapView.this.f55905w / 2.0d), (float) ((((ImMapView.this.f55906x - ((double) ImMapView.this.f55902t)) - ((double) ImMapView.this.f55901s)) / 2.0d) + ((double) ImMapView.this.f55901s)));
                        if (fromScreenLocation != null) {
                            MapIMPluginHelper.setMapDragDidChange(fromScreenLocation.latitude, fromScreenLocation.longitude);
                        } else {
                            MapIMPluginHelper.setMapDragDidChange(ImMapView.this.f55893k, ImMapView.this.f55894l);
                        }
                        MapIMPluginHelper.isCheckOverlap(false);
                    }
                    boolean unused2 = ImMapView.this.f55908z = false;
                    XPanelLayout xPanelLayout3 = this.xPanelLayout;
                    if (xPanelLayout3 != null) {
                        xPanelLayout3.setMoveFlag(false);
                        return;
                    }
                    return;
                }
                this.currentX = motionEvent.getX();
                this.currentY = motionEvent.getY();
                XPanelLayout xPanelLayout4 = NavIMServiceImpl.iNavigationProvider.getXPanelLayout();
                this.xPanelLayout = xPanelLayout4;
                if (xPanelLayout4 != null) {
                    xPanelLayout4.setMoveFlag(false);
                }
            }
        };
        this.f55887e = context;
        m40255a();
        this.f55890h = new MyLocationListener(this.f55887e);
        this.f55905w = (double) DisplayUtils.getWindowWidth(this.f55887e);
        this.f55906x = (double) DisplayUtils.getWindowHeight(this.f55887e);
    }

    /* renamed from: a */
    private void m40255a() {
        if (getMapView() != null) {
            MapVendor mapVendor = MapVendor.GOOGLE;
            if (ImMapConfig.getInstance().isHmsService()) {
                mapVendor = MapVendor.HUAWEI;
            }
            this.f55889g.init(mapVendor);
            boolean isDowngradeMap = ImMapConfig.getInstance().isDowngradeMap();
            Logger logger = this.f55885b;
            logger.info("map downgrade toggle is " + isDowngradeMap, new Object[0]);
            if (isDowngradeMap) {
                this.f55885b.info("map downgrade true , no add mapView to parent", new Object[0]);
            } else {
                addView(this.f55889g);
            }
        }
    }

    public void onCreate() {
        this.f55885b.info(NachoLifecycleManager.LIFECYCLE_ON_CREATE, new Object[0]);
        MapView mapView = this.f55889g;
        if (mapView != null) {
            mapView.onCreate((Bundle) null);
        }
    }

    public void onStart() {
        this.f55885b.info("onStart", new Object[0]);
        MapView mapView = this.f55889g;
        if (mapView != null) {
            mapView.onStart();
        }
    }

    public void onResume() {
        this.f55885b.info("onResume", new Object[0]);
        MapView mapView = this.f55889g;
        if (mapView != null) {
            mapView.onResume();
        }
    }

    public void onPause() {
        this.f55885b.info("onPause", new Object[0]);
        MapView mapView = this.f55889g;
        if (mapView != null) {
            mapView.onPause();
        }
    }

    public void onStop() {
        this.f55885b.info("onStop", new Object[0]);
        MapView mapView = this.f55889g;
        if (mapView != null) {
            mapView.onStop();
        }
    }

    public void onDestroy() {
        this.f55885b.info(NachoLifecycleManager.LIFECYCLE_ON_DESTROY, new Object[0]);
        MyLocationListener myLocationListener = this.f55890h;
        if (myLocationListener != null) {
            myLocationListener.stopLocation();
        }
        if (getMap() != null) {
            this.f55888f.removeOnMapGestureListener(this.f55900r);
        }
        MapView mapView = this.f55889g;
        if (mapView != null) {
            mapView.removeTouchEventListener(this.f55884A);
            this.f55889g.onDestroy();
        }
    }

    public MapView getMapView() {
        if (this.f55889g == null) {
            this.f55889g = new MapView(this.f55887e);
        }
        return this.f55889g;
    }

    public void getMapAsync(final IMapReadyCallBack iMapReadyCallBack) {
        final long currentTimeMillis = System.currentTimeMillis();
        this.f55885b.info("getMapAsync start", new Object[0]);
        MapView mapView = this.f55889g;
        if (mapView != null) {
            mapView.getMapAsync(new OnMapReadyCallBack() {
                public void onMapReady(Map map) {
                    long currentTimeMillis = System.currentTimeMillis();
                    Logger a = ImMapView.this.f55885b;
                    a.debug("getMapAsync ready : " + (currentTimeMillis - currentTimeMillis), new Object[0]);
                    Map unused = ImMapView.this.f55888f = map;
                    IMapReadyCallBack iMapReadyCallBack = iMapReadyCallBack;
                    if (iMapReadyCallBack != null) {
                        iMapReadyCallBack.onMapReady();
                    }
                    ImMapView.this.f55888f.addOnMapGestureListener(ImMapView.this.f55900r);
                    ImMapView.this.f55889g.addTouchEventListener(ImMapView.this.f55884A);
                    ImMapView.this.f55888f.getUiSettings().setZoomControlsEnabled(false);
                    String mapStyle = ImMapConfig.getInstance().getMapStyle();
                    if (!TextUtils.isEmpty(mapStyle)) {
                        ImMapView.this.f55888f.setMapStyle(mapStyle);
                    }
                    ImMapView.this.m40259b();
                    ImMapView.this.m40262c();
                    ImMapView imMapView = ImMapView.this;
                    imMapView.m40256a(imMapView.f55888f);
                    if (ImMapView.this.f55890h != null) {
                        ImMapView.this.f55890h.startLocation();
                    }
                    ImMapView.this.m40264d();
                }
            });
        }
    }

    public void setMapData(int i, double d, double d2) {
        this.f55892j = i;
        this.f55893k = d;
        this.f55894l = d2;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m40256a(Map map) {
        this.f55885b.info("initMapCenter", new Object[0]);
        this.f55891i = new MyLocationMarker(this, map);
        DIDILocation lastKnownLocation = DIDILocationManager.getInstance(this.f55887e).getLastKnownLocation();
        this.f55891i.addMarker();
        this.f55890h.setMarker(this.f55891i);
        if (lastKnownLocation != null) {
            this.f55891i.updatePosition(new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude()));
        } else {
            this.f55891i.updatePosition(new LatLng(this.f55893k, this.f55894l));
        }
        this.f55899q.add(this.f55891i.getMarker());
    }

    public Map getMap() {
        return this.f55888f;
    }

    public boolean isDowngradeMap() {
        return ImMapConfig.getInstance().isDowngradeMap();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m40259b() {
        if (ImMapConfig.getInstance().isDebug() && this.f55895m == null) {
            View view = new View(this.f55889g.getContext());
            this.f55895m = view;
            view.setBackgroundResource(R.drawable.rider_shape_betview_bg);
            addView(this.f55895m, new FrameLayout.LayoutParams(-1, -1));
            if (ImMapConfig.getInstance().isShowMapTool() && this.f55892j == 0) {
                View view2 = new View(this.f55889g.getContext());
                this.f55896n = view2;
                view2.setBackgroundColor(-16776961);
                addView(this.f55896n, new FrameLayout.LayoutParams(-1, 1));
                View view3 = new View(this.f55889g.getContext());
                this.f55897o = view3;
                view3.setBackgroundColor(-16776961);
                addView(this.f55897o, new FrameLayout.LayoutParams(1, -1));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m40262c() {
        if (this.f55898p == null && this.f55892j == 0) {
            View view = new View(this.f55889g.getContext());
            this.f55898p = view;
            view.setBackgroundResource(R.color.white);
            addView(this.f55898p, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void setHintView(int i, int i2, int i3, int i4) {
        View view;
        this.f55901s = i;
        this.f55902t = i3;
        this.f55903u = i2;
        this.f55904v = i4;
        if (ImMapConfig.getInstance().isDebug() && (view = this.f55895m) != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams.topMargin = i;
            layoutParams.leftMargin = i2;
            layoutParams.bottomMargin = i3;
            layoutParams.rightMargin = i4;
            this.f55895m.setLayoutParams(layoutParams);
            if (ImMapConfig.getInstance().isShowMapTool() && this.f55892j == 0) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f55896n.getLayoutParams();
                layoutParams2.topMargin = ((int) ((((this.f55906x + ((double) ImMapUtils.getNavigationBarHeight(this.f55887e))) - ((double) i3)) - ((double) i)) / 2.0d)) + i;
                this.f55896n.setLayoutParams(layoutParams2);
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f55897o.getLayoutParams();
                layoutParams3.leftMargin = (int) (this.f55905w / 2.0d);
                this.f55897o.setLayoutParams(layoutParams3);
            }
        }
        View view2 = this.f55898p;
        if (view2 != null && this.f55892j == 0) {
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) view2.getLayoutParams();
            layoutParams4.topMargin = Math.max((int) ((this.f55906x - ((double) this.f55902t)) + ((double) ImMapUtils.getNavigationBarHeight(this.f55887e)) + ((double) DisplayUtils.dp2px(getContext(), 100.0f))), 0);
            layoutParams4.leftMargin = 0;
            layoutParams4.bottomMargin = 0;
            layoutParams4.rightMargin = 0;
            this.f55898p.setLayoutParams(layoutParams4);
        }
    }

    public void setMapRecenter() {
        this.f55885b.debug("setMapRecenter", new Object[0]);
        if (this.f55888f == null) {
            return;
        }
        if (this.f55892j != 1) {
            MyLocationMarker myLocationMarker = this.f55891i;
            if (myLocationMarker != null) {
                setCamera(myLocationMarker.getLatLng().latitude, this.f55891i.getLatLng().longitude);
            }
        } else if (this.f55907y != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f55891i.getLatLng());
            arrayList.add(this.f55907y.getPosition());
            arrayList.add(ImMapUtils.calMirrorLatLng(this.f55891i.getLatLng(), this.f55907y.getPosition()));
            this.f55888f.setPadding(this.f55903u, this.f55901s, this.f55904v, this.f55902t);
            this.f55888f.animateCamera(ImMapUtils.calculateBestZoom(this.f55889g, arrayList, this.f55903u, this.f55901s, this.f55904v, this.f55902t, 9, 16), 300, new CancelableCallback() {
                public void onCancel() {
                }

                public void onFinish() {
                    MapIMPluginHelper.isCheckOverlap(true);
                }
            });
        } else {
            setMapCenterCoordinate();
        }
    }

    public void setMapCenterCoordinate() {
        MyLocationListener myLocationListener;
        LatLng latLng;
        this.f55885b.debug("setMapCenterCoordinate", new Object[0]);
        if (this.f55888f != null && (myLocationListener = this.f55890h) != null && (latLng = myLocationListener.getLatLng()) != null) {
            CameraUpdate newLatLngZoom = CameraUpdateFactory.newLatLngZoom(latLng, (float) ImMapConfig.getInstance().getZoomLevel());
            this.f55888f.setPadding(this.f55901s, this.f55902t, this.f55903u, this.f55904v);
            this.f55888f.animateCamera(newLatLngZoom, new CancelableCallback() {
                public void onCancel() {
                }

                public void onFinish() {
                    MapIMPluginHelper.isCheckOverlap(true);
                }
            });
        }
    }

    public void setCamera(double d, double d2) {
        if (this.f55888f != null && this.f55892j == 0) {
            int zoomLevel = ImMapConfig.getInstance().getZoomLevel();
            final double d3 = d;
            final double d4 = d2;
            BestViewer.doBestView(this.f55888f, true, Float.valueOf((float) zoomLevel), new LatLng(d3, d4), new Padding(this.f55903u, this.f55901s, this.f55904v, this.f55902t), (BestViewer.IBestViewListener) new BestViewer.IBestViewListener() {
                public void onFinished() {
                    if (d3 == ImMapView.this.f55891i.getLatLng().latitude && d4 == ImMapView.this.f55891i.getLatLng().longitude) {
                        MapIMPluginHelper.isCheckOverlap(true);
                        Logger a = ImMapView.this.f55885b;
                        a.debug("setCamera overlap true" + d3 + " " + d4, new Object[0]);
                        return;
                    }
                    MapIMPluginHelper.isCheckOverlap(false);
                    Logger a2 = ImMapView.this.f55885b;
                    a2.debug("setCamera overlap false" + d3 + " " + d4, new Object[0]);
                }
            });
        }
    }

    public void setMapOverView(double d, double d2) {
        LatLng latLng;
        if (this.f55888f != null && this.f55891i != null) {
            if (d == 0.0d && d2 == 0.0d) {
                double navigationBarHeight = (this.f55906x + ((double) ImMapUtils.getNavigationBarHeight(this.f55887e))) - ((double) this.f55902t);
                int i = this.f55901s;
                latLng = ImMapUtils.fromScreenLocation(this.f55888f, (float) ((int) (this.f55905w / 2.0d)), (float) ((int) (((navigationBarHeight - ((double) i)) / 2.0d) + ((double) i))));
            } else {
                latLng = new LatLng(d, d2);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f55891i.getLatLng());
            arrayList.add(latLng);
            this.f55888f.setPadding(this.f55903u, this.f55901s, this.f55904v, this.f55902t);
            this.f55888f.animateCamera(ImMapUtils.calculateBestZoom(this.f55889g, arrayList, this.f55903u, this.f55901s, this.f55904v, this.f55902t, 9, 16));
        }
    }

    public void setWaterMarker(String str, double d, double d2) {
        MapView mapView;
        if (this.f55892j == 1 && (mapView = this.f55889g) != null) {
            Context context = mapView.getContext();
            ImFavorFrom favorFrom = ImMapConfig.getInstance().getFavorFrom();
            Map map = getMapView().getMap();
            Marker marker = this.f55907y;
            if (marker != null) {
                marker.setPosition(new LatLng(d, d2));
                return;
            }
            Bitmap imageFromAssetsFile = ImMapUtils.getImageFromAssetsFile(context, str);
            if (imageFromAssetsFile == null) {
                imageFromAssetsFile = ImageUtil.getScaledBitmap(context, BitmapDescriptorFactory.fromResource(context, favorFrom == ImFavorFrom.IMMAP_GLOBAL ? R.drawable.rider_im_water_icon : R.drawable.rider_im_99_water_icon).getBitmap());
            }
            if (map != null) {
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.icon(BitmapDescriptorFactory.fromBitmap(imageFromAssetsFile));
                markerOptions.anchor(0.5f, 0.5f);
                markerOptions.zIndex(30);
                markerOptions.position(new LatLng(d, d2));
                Marker addMarker = map.addMarker(f55883c, markerOptions);
                this.f55907y = addMarker;
                this.f55899q.add(addMarker);
                return;
            }
            this.f55885b.info("map is null , so not add marker", new Object[0]);
        }
    }

    public void updatePosition(LatLng latLng) {
        this.f55893k = latLng.latitude;
        this.f55894l = latLng.longitude;
    }

    private class DefaultMapGestureListener implements OnMapGestureListener {
        private boolean mScrolled;
        private int mStartZoomLevel;

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

        public boolean onSingleTap(float f, float f2) {
            return false;
        }

        private DefaultMapGestureListener() {
        }

        public boolean onDown(float f, float f2) {
            this.mStartZoomLevel = (int) ImMapView.this.getZoomLevel();
            return false;
        }

        public boolean onScroll(float f, float f2) {
            this.mScrolled = true;
            return false;
        }

        public boolean onUp(float f, float f2) {
            int zoomLevel = (int) ImMapView.this.getZoomLevel();
            Logger a = ImMapView.this.f55885b;
            a.info("onUp map zoom level ： " + zoomLevel, new Object[0]);
            if (this.mScrolled) {
                ImMapTrace.traceMapDrag(zoomLevel);
            } else {
                int i = this.mStartZoomLevel;
                if (i != zoomLevel) {
                    ImMapTrace.traceMapZoom(zoomLevel, zoomLevel > i ? 1 : 0);
                }
            }
            this.mScrolled = false;
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m40264d() {
        ImageView imageView;
        MapView mapView = this.f55889g;
        if (mapView != null && (imageView = (ImageView) mapView.findViewWithTag(f55882a)) != null && imageView.getDrawable() != null && this.f55886d == null && getMap() != null) {
            try {
                Drawable drawable = imageView.getDrawable();
                ImageView imageView2 = new ImageView(getContext());
                this.f55886d = imageView2;
                imageView2.setImageDrawable(drawable);
                int dp2px = DisplayUtils.dp2px(getContext(), 14.0f);
                int dp2px2 = DisplayUtils.dp2px(getContext(), 10.0f);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, dp2px);
                layoutParams.leftMargin = dp2px;
                layoutParams.bottomMargin = dp2px2;
                layoutParams.gravity = 80;
                addView(this.f55886d, layoutParams);
                this.f55888f.getUiSettings().setLogoVisibility(0);
            } catch (Exception e) {
                this.f55885b.error("setMapLogoPosition", (Throwable) e);
            }
        }
    }

    public void setMarkerStates(String str, boolean z) {
        Marker oneMarkerByTag = ImMapUtils.getOneMarkerByTag(this.f55889g, str);
        if (oneMarkerByTag != null) {
            oneMarkerByTag.setVisible(z);
        }
    }

    public double getZoomLevel() {
        if (getMap() == null || getMap().getCameraPosition() == null) {
            return -1.0d;
        }
        return getMap().getCameraPosition().zoom;
    }
}
