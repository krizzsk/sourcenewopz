package com.didi.hawaii.mapsdkv2.adapter;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.didi.hawaii.mapsdkv2.common.MapLog;
import com.didi.hawaii.mapsdkv2.common.evaluator.LatLngEvaluator;
import com.didi.hawaii.mapsdkv2.core.GLAnimator;
import com.didi.hawaii.mapsdkv2.core.GLOverlayView;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.core.Texture;
import com.didi.hawaii.mapsdkv2.core.overlay.GLMyLocation;
import com.didi.map.alpha.maps.internal.ILocationDelegate;
import com.didi.map.common.MapAssets;
import com.didi.map.common.utils.SystemUtil;
import com.didi.map.outer.map.CameraUpdateFactory;
import com.didi.map.outer.map.DidiMap;
import com.didi.map.outer.map.LocationSource;
import com.didi.map.outer.model.BitmapDescriptor;
import com.didi.map.outer.model.BitmapDescriptorFactory;
import com.didi.map.outer.model.CameraPosition;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.MyLocationOption;
import com.didi.sdk.util.ImageUtil;
import com.didi.soda.customer.blocks.BlocksConst;
import global.didi.pay.newview.pix.IPixView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class MyLocationDelegate extends C9003b implements ILocationDelegate, LocationSource.OnLocationChangedListener {

    /* renamed from: b */
    private static final String f23730b = "MyLocationDG";

    /* renamed from: c */
    private static final int f23731c = 5;

    /* renamed from: d */
    private static final float f23732d = 18.0f;

    /* renamed from: e */
    private static final int f23733e = 95;

    /* renamed from: f */
    private final LatLng f23734f = new LatLng(39.90881451094423d, 116.39735698699951d);
    /* access modifiers changed from: private */

    /* renamed from: g */
    public GLMyLocation f23735g;

    /* renamed from: h */
    private Location f23736h = new Location("GPS");

    /* renamed from: i */
    private boolean f23737i = true;

    /* renamed from: j */
    private LocationSource f23738j;

    /* renamed from: k */
    private MyLocationOption f23739k;

    /* renamed from: l */
    private DidiMap.OnMyLocationChangeListener f23740l;

    /* renamed from: m */
    private final DidiMap f23741m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f23742n = false;

    /* renamed from: o */
    private float f23743o = 0.0f;

    /* renamed from: p */
    private boolean f23744p = false;

    /* renamed from: q */
    private final ModeStrategy f23745q;

    /* renamed from: r */
    private final SensorFilter f23746r;

    /* renamed from: s */
    private Texture f23747s = null;

    /* renamed from: t */
    private Texture f23748t = null;

    /* renamed from: u */
    private DidiMap.CancelableCallback f23749u = new DidiMap.CancelableCallback() {
        public void onFinish() {
            boolean unused = MyLocationDelegate.this.f23742n = false;
        }

        public void onCancel() {
            boolean unused = MyLocationDelegate.this.f23742n = false;
        }
    };

    enum LocationMode {
        SENSOR,
        GPS
    }

    public MyLocationDelegate(GLViewManager gLViewManager, Map<String, Pair<?, GLOverlayView>> map, DidiMap didiMap) {
        super(gLViewManager, map);
        m16881b(IPixView.PAGE_STATUS_INIT);
        this.f23739k = new MyLocationOption.Builder().setLocationType(1).setPosition(this.f23734f).setAnchorX(0.5f).setAnchorY(0.5f).setMinRadius(15).setMaxRadius(1000).setIcon(BitmapDescriptorFactory.fromBitmap(m16866a(this.context, MapAssets.bitmap(this.context, MapAssets.HAWAII_SELF_DRIVING_LOCATOR)))).setFailedIcon(BitmapDescriptorFactory.fromBitmap(m16866a(this.context, MapAssets.bitmap(this.context, MapAssets.HAWAII_SELF_DRIVING_LOCATOR_DISABLE)))).setShowRing(true).build();
        this.f23736h.setLatitude(this.f23734f.latitude);
        this.f23736h.setLongitude(this.f23734f.longitude);
        this.f23741m = didiMap;
        this.f23745q = new ModeStrategy();
        this.f23746r = new SensorFilter();
    }

    public void release() {
        m16881b("release");
        disableMylocation();
    }

    public boolean enableMylocation() {
        return enableMylocation(18.0f, 0.0f, 0.0f);
    }

    public boolean enableMylocation(float f, float f2, float f3) {
        m16881b("enable--:" + this.f23737i);
        this.f23744p = true;
        if (!this.f23737i) {
            m16878b();
            if (this.f23735g != null && m16875a()) {
                m16869a(f, f2, f3);
            }
        } else if (m16875a()) {
            m16869a(f, f2, f3);
        }
        if (this.f23735g != null) {
            this.f23745q.cancelLocationLostTimer();
            this.f23745q.startLocationLostTimer();
        }
        LocationSource locationSource = this.f23738j;
        if (locationSource != null) {
            locationSource.activate(this);
        }
        return true;
    }

    public void disableMylocation() {
        m16881b("disable");
        this.f23744p = false;
        m16886d();
        this.f23745q.free();
        this.f23745q.free();
        if (this.f23735g != null) {
            this.viewManager.removeView(this.f23735g);
            this.f23735g = null;
        }
        LocationSource locationSource = this.f23738j;
        if (locationSource != null) {
            locationSource.deactivate();
        }
    }

    public void setLocationSource(LocationSource locationSource) {
        m16881b("setSource");
        this.f23738j = locationSource;
        if (isProviderEnable()) {
            enableMylocation();
        }
    }

    public boolean isProviderEnable() {
        return this.f23735g != null;
    }

    public Location getMyLocation() {
        return this.f23736h;
    }

    public void setOnMyLocationChangeListener(DidiMap.OnMyLocationChangeListener onMyLocationChangeListener) {
        m16881b("setListener");
        this.f23740l = onMyLocationChangeListener;
    }

    public void setMyLocationOption(MyLocationOption myLocationOption) {
        setMyLocationOption(myLocationOption, 18.0f, 0.0f, 0.0f);
    }

    public void setMyLocationOption(MyLocationOption myLocationOption, float f, float f2, float f3) {
        if (myLocationOption != null) {
            m16881b("setOp--" + myLocationOption.toString());
            if (this.f23737i && myLocationOption.getPosition() != null) {
                this.f23736h.setLatitude(myLocationOption.getPosition().latitude);
                this.f23736h.setLongitude(myLocationOption.getPosition().longitude);
                this.f23737i = false;
            }
            m16874a(myLocationOption);
            if (isProviderEnable()) {
                if (myLocationOption.getIcon() != null) {
                    m16870a(myLocationOption.getIcon().getBitmap(this.context));
                }
                if (myLocationOption.getFailedIcon() != null) {
                    m16880b(myLocationOption.getFailedIcon().getBitmap(this.context));
                }
                if (2 == myLocationOption.getLocationType().intValue()) {
                    m16869a(f, f2, f3);
                }
            }
        }
    }

    public MyLocationOption getMyLocationOption() {
        return this.f23739k;
    }

    public void onLocationChanged(Location location) {
        if (this.f23744p) {
            m16878b();
            m16871a(location);
        }
    }

    public void onAngleChanged(float f) {
        if (this.f23735g != null) {
            this.f23745q.setSensorEnable();
            this.f23746r.onSensorAngleChange(f);
            if (!this.f23745q.isGPSMode()) {
                float lastSensorAngle = this.f23746r.getLastSensorAngle();
                if (Math.abs(lastSensorAngle - this.f23743o) >= 5.0f) {
                    m16868a(360.0f - lastSensorAngle);
                    this.f23743o = lastSensorAngle;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m16875a() {
        return 2 == this.f23739k.getLocationType().intValue();
    }

    /* renamed from: a */
    private void m16869a(float f, float f2, float f3) {
        if (!this.f23742n) {
            m16881b("ToCenter " + f + ", " + f2 + ", " + f3);
            this.f23742n = true;
            this.f23741m.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(m16884c(), f, f2, f3)), this.f23749u);
        }
    }

    /* renamed from: a */
    private void m16874a(MyLocationOption myLocationOption) {
        BitmapDescriptor bitmapDescriptor;
        LatLng latLng;
        Integer num;
        Integer num2;
        Integer num3;
        Boolean bool;
        BitmapDescriptor icon = myLocationOption.getIcon() != null ? myLocationOption.getIcon() : this.f23739k.getIcon();
        if (myLocationOption.getFailedIcon() != null) {
            bitmapDescriptor = myLocationOption.getFailedIcon();
        } else {
            bitmapDescriptor = this.f23739k.getFailedIcon();
        }
        if (myLocationOption.getPosition() != null) {
            latLng = myLocationOption.getPosition();
        } else {
            latLng = this.f23739k.getPosition();
        }
        if (myLocationOption.getLocationType() != null) {
            num = myLocationOption.getLocationType();
        } else {
            num = this.f23739k.getLocationType();
        }
        MyLocationOption.Builder position = new MyLocationOption.Builder().setIcon(icon).setFailedIcon(bitmapDescriptor).setAnchorX(this.f23739k.getAnchorX().floatValue()).setAnchorY(this.f23739k.getAnchorY().floatValue()).setLocationType(num.intValue()).setPosition(latLng);
        if (myLocationOption.getMinRadius() != null) {
            num2 = myLocationOption.getMinRadius();
        } else {
            num2 = this.f23739k.getMinRadius();
        }
        MyLocationOption.Builder minRadius = position.setMinRadius(num2.intValue());
        if (myLocationOption.getMaxRadius() != null) {
            num3 = myLocationOption.getMaxRadius();
        } else {
            num3 = this.f23739k.getMaxRadius();
        }
        MyLocationOption.Builder maxRadius = minRadius.setMaxRadius(num3.intValue());
        if (myLocationOption.isShowRing() != null) {
            bool = myLocationOption.isShowRing();
        } else {
            bool = this.f23739k.isShowRing();
        }
        this.f23739k = maxRadius.setShowRing(bool.booleanValue()).build();
    }

    /* renamed from: b */
    private void m16878b() {
        if (this.f23735g == null) {
            m16881b("ensureMarker-showRing:" + this.f23739k.isShowRing());
            float density = 0.5f / SystemUtil.getDensity(this.viewManager.getMapContext().getAndroidContext());
            GLMyLocation.Option option = new GLMyLocation.Option();
            option.setCenter(m16884c());
            option.setAngle(0.0f);
            option.setZIndex(95);
            option.setColor(Color.parseColor("#1A4FA7FF"));
            option.setBorderWidth(density);
            option.setBorderColor(Color.parseColor("#A0CAF4"));
            option.setRadius(0.0f);
            option.setShowRing(this.f23739k.isShowRing().booleanValue());
            Texture h = m16892h();
            if (h != null) {
                option.setTexture(h);
                this.f23735g = new GLMyLocation(this.viewManager, option);
                this.viewManager.addView((GLOverlayView) this.f23735g);
            }
        }
    }

    /* renamed from: c */
    private LatLng m16884c() {
        return new LatLng(this.f23736h.getLatitude(), this.f23736h.getLongitude());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16868a(float f) {
        GLMyLocation gLMyLocation = this.f23735g;
        if (gLMyLocation != null) {
            gLMyLocation.setAngle(f);
        }
    }

    /* renamed from: b */
    private void m16879b(float f) {
        if (this.f23735g != null) {
            this.f23735g.setRadius(m16883c(f));
        }
    }

    /* renamed from: c */
    private float m16883c(float f) {
        if (f < ((float) this.f23739k.getMinRadius().intValue())) {
            return 0.0f;
        }
        return f > ((float) this.f23739k.getMaxRadius().intValue()) ? (float) this.f23739k.getMaxRadius().intValue() : f;
    }

    /* renamed from: d */
    private void m16886d() {
        m16881b("stopAnimal");
        GLMyLocation gLMyLocation = this.f23735g;
        if (gLMyLocation != null && gLMyLocation.getCarMarker() != null) {
            this.f23735g.getCarMarker().stopAnimation();
        }
    }

    /* renamed from: a */
    private void m16871a(Location location) {
        if (location != null) {
            this.f23745q.newLocation(location);
            m16879b(location.getAccuracy());
            DidiMap.OnMyLocationChangeListener onMyLocationChangeListener = this.f23740l;
            if (onMyLocationChangeListener != null) {
                onMyLocationChangeListener.onMyLocationChange(location);
            }
            ArrayList arrayList = new ArrayList(2);
            if (this.f23745q.isGPSMode()) {
                float bearing = location.getBearing();
                if (Math.abs(this.f23743o - bearing) > 2.0f) {
                    float f = 360.0f - this.f23743o;
                    float f2 = 360.0f - bearing;
                    if (Math.abs(f2 - f) > 180.0f) {
                        f2 = f > f2 ? f2 + 360.0f : f2 - 360.0f;
                    }
                    this.f23743o = bearing;
                    arrayList.add(PropertyValuesHolder.ofFloat(BlocksConst.WIDGET_PARAMS_ANGLE, new float[]{f, f2}));
                }
            }
            if (!(this.f23736h.getLatitude() == location.getLatitude() && this.f23736h.getLongitude() == location.getLongitude())) {
                arrayList.add(PropertyValuesHolder.ofObject("position", new LatLngEvaluator(), new Object[]{new LatLng(this.f23736h.getLatitude(), this.f23736h.getLongitude()), new LatLng(location.getLatitude(), location.getLongitude())}));
            }
            if (!m16877a((Collection<?>) arrayList)) {
                GLAnimator gLAnimator = new GLAnimator();
                gLAnimator.setDuration(1000);
                gLAnimator.setInterpolator(new LinearInterpolator());
                gLAnimator.setValues((PropertyValuesHolder[]) arrayList.toArray(new PropertyValuesHolder[arrayList.size()]));
                gLAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        LatLng latLng = (LatLng) valueAnimator.getAnimatedValue("position");
                        Object animatedValue = valueAnimator.getAnimatedValue(BlocksConst.WIDGET_PARAMS_ANGLE);
                        if (animatedValue != null) {
                            MyLocationDelegate.this.m16868a(((Float) animatedValue).floatValue());
                        }
                        if (latLng != null) {
                            if (MyLocationDelegate.this.f23735g != null) {
                                MyLocationDelegate.this.f23735g.setPosition(latLng);
                            }
                            if (MyLocationDelegate.this.m16875a() && !MyLocationDelegate.this.f23742n) {
                                MyLocationDelegate.this.viewManager.getBaseMap().setCenter(latLng);
                            }
                        }
                    }
                });
                GLMyLocation gLMyLocation = this.f23735g;
                if (gLMyLocation != null) {
                    gLMyLocation.getCarMarker().setAnimator(gLAnimator);
                    this.f23735g.getCarMarker().startAnimator();
                }
                this.f23737i = false;
                this.f23736h = location;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m16888e() {
        m16881b("locationLost");
        if (this.f23735g != null) {
            Texture g = m16891g();
            if (g != null) {
                this.f23735g.setTexture(g);
            }
            this.f23735g.setRadius(0.0f);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m16890f() {
        Texture h;
        m16881b("locationToNormal");
        if (this.f23735g != null && (h = m16892h()) != null) {
            this.f23735g.setTexture(h);
        }
    }

    /* renamed from: g */
    private Texture m16891g() {
        Bitmap bitmap;
        Texture texture = this.f23748t;
        if (texture != null) {
            return texture;
        }
        if (this.f23739k.getFailedIcon() == null || (bitmap = this.f23739k.getFailedIcon().getBitmap(this.context)) == null) {
            return null;
        }
        Texture bitmap2 = Texture.bitmap(this.viewManager.getMapContext().getResources(), bitmap);
        this.f23748t = bitmap2;
        return bitmap2;
    }

    /* renamed from: h */
    private Texture m16892h() {
        Texture texture = this.f23747s;
        if (texture != null) {
            return texture;
        }
        Bitmap bitmap = this.f23739k.getIcon().getBitmap(this.context);
        if (bitmap == null) {
            return null;
        }
        Texture bitmap2 = Texture.bitmap(this.viewManager.getMapContext().getResources(), bitmap);
        this.f23747s = bitmap2;
        return bitmap2;
    }

    /* renamed from: a */
    private void m16870a(Bitmap bitmap) {
        this.f23747s = Texture.bitmap(this.viewManager.getMapContext().getResources(), bitmap);
        if (!this.f23745q.locationLost) {
            this.f23735g.setTexture(this.f23747s);
        }
    }

    /* renamed from: b */
    private void m16880b(Bitmap bitmap) {
        if (this.f23748t != null) {
            this.f23748t = Texture.bitmap(this.viewManager.getMapContext().getResources(), bitmap);
            if (this.f23745q.locationLost) {
                this.f23735g.setTexture(this.f23748t);
            }
        }
    }

    /* renamed from: a */
    private boolean m16877a(Collection<?> collection) {
        return collection == null || collection.size() <= 0;
    }

    /* renamed from: a */
    private Bitmap m16866a(Context context, Bitmap bitmap) {
        if (context == null || bitmap == null) {
            return bitmap;
        }
        float f = context.getResources().getDisplayMetrics().density / 3.0f;
        if (f == 1.0f) {
            return bitmap;
        }
        return ImageUtil.scale(bitmap, ((float) bitmap.getWidth()) * f, ((float) bitmap.getHeight()) * f, ImageView.ScaleType.CENTER_CROP, true);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m16881b(String str) {
        MapLog.m16917i(f23730b, str + " " + System.identityHashCode(this));
    }

    private static class SensorFilter {
        private float mLastSensorAngle;

        public void free() {
        }

        public float toClockAngle(float f) {
            return ((f % 360.0f) + 360.0f) % 360.0f;
        }

        private SensorFilter() {
            this.mLastSensorAngle = 0.0f;
        }

        public void onSensorAngleChange(float f) {
            this.mLastSensorAngle = toClockAngle(f);
        }

        public float getLastSensorAngle() {
            return this.mLastSensorAngle;
        }
    }

    private class ModeStrategy {
        private static final int TIME_INTERVAL_LOCATION_FAILED = 30000;
        private static final int TIME_INTERVAL_MODE_SWITCH = 5000;
        private final float SPEED_CRITICAL_VALUE = 4.0f;
        private boolean isSensorEnable = false;
        /* access modifiers changed from: private */
        public boolean locationLost = false;
        Runnable locationLostRunnable = new Runnable() {
            public void run() {
                boolean unused = ModeStrategy.this.locationLost = true;
                MyLocationDelegate.this.m16888e();
            }
        };
        private final Handler mMainHandler = new Handler(Looper.getMainLooper());
        /* access modifiers changed from: private */
        public LocationMode mode = LocationMode.SENSOR;
        Runnable modeSwitchRunnable = new Runnable() {
            public void run() {
                MyLocationDelegate.this.m16881b("GPS overtime");
                LocationMode unused = ModeStrategy.this.mode = LocationMode.SENSOR;
            }
        };

        ModeStrategy() {
        }

        public void free() {
            cancelAllTimer();
        }

        public void setSensorEnable() {
            this.isSensorEnable = true;
        }

        public void newLocation(Location location) {
            LocationMode locationMode;
            if (location != null) {
                if (location.getSpeed() >= 4.0f) {
                    locationMode = LocationMode.GPS;
                } else {
                    locationMode = LocationMode.SENSOR;
                }
                this.mode = locationMode;
                if (this.locationLost) {
                    MyLocationDelegate.this.m16890f();
                    this.locationLost = false;
                }
                cancelAllTimer();
                if (!this.isSensorEnable) {
                    this.mode = LocationMode.GPS;
                } else if (isGPSMode()) {
                    startGPSCheckTimer();
                }
                startLocationLostTimer();
            }
        }

        public boolean isGPSMode() {
            return LocationMode.GPS == this.mode;
        }

        private void startGPSCheckTimer() {
            this.mMainHandler.postDelayed(this.modeSwitchRunnable, 5000);
        }

        /* access modifiers changed from: private */
        public void startLocationLostTimer() {
            this.mMainHandler.postDelayed(this.locationLostRunnable, 30000);
        }

        /* access modifiers changed from: private */
        public void cancelLocationLostTimer() {
            this.mMainHandler.removeCallbacks(this.locationLostRunnable);
        }

        private void cancelAllTimer() {
            this.mMainHandler.removeCallbacksAndMessages((Object) null);
        }
    }
}
