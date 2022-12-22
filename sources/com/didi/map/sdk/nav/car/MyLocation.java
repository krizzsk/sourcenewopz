package com.didi.map.sdk.nav.car;

import android.content.Context;
import android.text.TextUtils;
import com.didi.common.map.Map;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.DLog;
import com.didi.map.sdk.nav.util.ApolloToggleUtils;
import com.map.sdk.nav.libc.common.CommonUtils;
import com.map.sdk.nav.libc.common.DMKEventPoint;
import java.util.List;

public class MyLocation implements IMyLocationDelegate {

    /* renamed from: a */
    private static final String f28394a = "MyLocation";

    /* renamed from: b */
    private Map f28395b;

    /* renamed from: c */
    private CarMarker f28396c;

    /* renamed from: d */
    private AnimationPartInterface f28397d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public onCarAnimationListener f28398e;

    /* renamed from: f */
    private int f28399f = 3000;

    /* renamed from: g */
    private boolean f28400g = false;

    /* renamed from: h */
    private List<LatLng> f28401h;

    /* renamed from: i */
    private CameraMode f28402i = CameraMode.NORTH_UP;

    /* renamed from: j */
    private boolean f28403j = false;

    /* renamed from: k */
    private int f28404k = -1;

    /* renamed from: l */
    private int f28405l = -1;

    /* renamed from: m */
    private NavOverlay f28406m;

    /* renamed from: n */
    private int f28407n = 0;

    /* renamed from: o */
    private int f28408o = (CommonUtils.getScreenWidth() / 2);

    /* renamed from: p */
    private int f28409p = 0;

    /* renamed from: q */
    private boolean f28410q = false;

    /* renamed from: r */
    private boolean f28411r = false;

    /* renamed from: s */
    private double f28412s;

    /* renamed from: t */
    private boolean f28413t = false;

    private MyLocation(Map map) {
        this.f28395b = map;
        if (map != null && DriverCarNewAnimApollo.getInstance().enable()) {
            DriverCarNewAnimApollo.getInstance().setMapVendor(map.getMapVendor());
        }
        this.f28412s = -1.0d;
    }

    public static IMyLocationDelegate create(Map map) {
        return new MyLocation(map);
    }

    public void set3DCarEnabled(boolean z) {
        this.f28410q = z && ApolloToggleUtils.is3DCarEnabled();
    }

    public void set3DCarIcons(List<String> list) {
        this.f28411r = CarAngleUtil.init(list);
    }

    public boolean refresh3DCarIcons(boolean z, List<String> list) {
        set3DCarEnabled(z);
        set3DCarIcons(list);
        this.f28410q = this.f28410q && this.f28411r;
        CarMarker carMarker = this.f28396c;
        if (carMarker == null) {
            return false;
        }
        int indexByAngle = CarAngleUtil.getIndexByAngle(carMarker.getRotation());
        this.f28396c.setRotation(0.0f);
        this.f28396c.set3DCarEnabled(this.f28410q);
        this.f28396c.setIcon(this.f28395b.getContext(), CarAngleUtil.getCarBitmapDescriptor(this.f28395b.getContext(), indexByAngle));
        return true;
    }

    public void setNavRoutePoints(List<LatLng> list, boolean z) {
        this.f28401h = list;
        m20118a(z);
        AnimationPartInterface animationPartInterface = this.f28397d;
        if (animationPartInterface != null) {
            animationPartInterface.setRoutePoints(list);
        }
    }

    public void setCarMarkerOptions(String str, MarkerOptions markerOptions) {
        if (this.f28395b != null && markerOptions != null) {
            boolean z = this.f28410q && this.f28411r;
            this.f28410q = z;
            if (z) {
                Context context = this.f28395b.getContext();
                CarMarker carMarker = this.f28396c;
                markerOptions.icon(CarAngleUtil.getCarBitmapDescriptor(context, carMarker == null ? 0 : carMarker.getLastIndex()));
            }
            CarMarker carMarker2 = this.f28396c;
            if (carMarker2 == null) {
                Map map = this.f28395b;
                if (TextUtils.isEmpty(str)) {
                    str = "GROUP_DEFAULT";
                }
                Marker addMarker = map.addMarker(str, markerOptions);
                if (addMarker != null) {
                    this.f28396c = new CarMarker(this.f28395b.getContext(), addMarker);
                } else {
                    DLog.m7384d(f28394a, "addMarker error", new Object[0]);
                }
            } else {
                carMarker2.setOptions(markerOptions);
            }
            CarMarker carMarker3 = this.f28396c;
            if (carMarker3 != null) {
                DLog.m7384d(f28394a, "setCarMarkerOptions() id:%s", carMarker3.getId());
                this.f28396c.set3DCarEnabled(this.f28410q);
                this.f28396c.updateOriginIcon(markerOptions.getIcon());
            }
        }
    }

    public synchronized void animateTo(AnimateNode animateNode) {
        animateTo(animateNode, (DMKEventPoint) null);
    }

    public void animateTo(AnimateNode animateNode, DMKEventPoint dMKEventPoint) {
        CarMarker carMarker = this.f28396c;
        if (carMarker == null || carMarker.getMarker() == null) {
            DLog.m7384d(f28394a, "MyLocation animateTo error", new Object[0]);
            return;
        }
        if (!(animateNode == null || animateNode.index == -1)) {
            this.f28409p = animateNode.index;
        }
        List<LatLng> list = this.f28401h;
        if (list != null && this.f28409p > list.size() - 1) {
            this.f28409p = 0;
        }
        m20118a(false);
        AnimationPartInterface animationPartInterface = this.f28397d;
        if (animationPartInterface != null) {
            animationPartInterface.start(animateNode, dMKEventPoint);
        }
    }

    public synchronized void animateCancel(onCarAnimationCancelListener oncaranimationcancellistener) {
        if (this.f28397d != null) {
            this.f28397d.setOnCarAnimationListener((onCarAnimationListener) null);
            this.f28397d.destroy();
            this.f28397d = null;
        }
        if (oncaranimationcancellistener != null) {
            oncaranimationcancellistener.onCancel();
        }
    }

    /* renamed from: a */
    private void m20118a(boolean z) {
        CarMarker carMarker;
        if (this.f28397d == null && (carMarker = this.f28396c) != null && carMarker.getMarker() != null) {
            AnimationNewPart animationNewPart = new AnimationNewPart(this.f28395b, this.f28396c);
            this.f28397d = animationNewPart;
            animationNewPart.setCarHeadParams(this.f28408o, this.f28409p);
            this.f28397d.setAnimationInterval(this.f28399f);
            this.f28397d.setOnCarAnimationListener(new onCarAnimationListener() {
                public void onUpdateAllLine(List<LatLng> list, List<LatLng> list2) {
                    if (MyLocation.this.f28398e != null) {
                        MyLocation.this.f28398e.onUpdateAllLine(list, list2);
                    }
                }

                public void onErase(List<LatLng> list) {
                    if (MyLocation.this.f28398e != null) {
                        MyLocation.this.f28398e.onErase(list);
                    }
                }

                public void onErase(int i, int i2, LatLng latLng) {
                    if (MyLocation.this.f28398e != null) {
                        MyLocation.this.f28398e.onErase(i, i2, latLng);
                    }
                }
            });
            this.f28397d.setCameraMode(this.f28402i, false);
            this.f28397d.setIsBackground(this.f28400g);
            this.f28397d.setRoutePoints(this.f28401h);
            if (z && this.f28402i == CameraMode.CAR_HEAD_UP) {
                this.f28397d.zoomToNav();
            }
            this.f28397d.setCarImageView(this.f28406m);
            this.f28397d.followMyLocation(this.f28403j);
            double d = this.f28412s;
            if (d > 0.0d) {
                this.f28397d.setCarHeadMaxMapLevel(d);
            }
        }
    }

    public void destroy() {
        CarMarker carMarker;
        AnimationPartInterface animationPartInterface = this.f28397d;
        if (animationPartInterface != null) {
            animationPartInterface.setOnCarAnimationListener((onCarAnimationListener) null);
            this.f28397d.destroy();
            this.f28397d.resetMapTilt();
            this.f28397d = null;
        }
        NavOverlay navOverlay = this.f28406m;
        if (navOverlay != null) {
            NavOverlay.removeFromMapView(navOverlay, this.f28395b);
            this.f28406m = null;
        }
        this.f28401h = null;
        Map map = this.f28395b;
        if (!(map == null || (carMarker = this.f28396c) == null)) {
            map.remove(carMarker.getMarker());
            this.f28396c.destroy();
            this.f28396c = null;
        }
        if (this.f28410q) {
            CarAngleUtil.destroy();
        }
        this.f28395b = null;
        this.f28398e = null;
    }

    public void setIsBackground(boolean z) {
        this.f28400g = z;
        AnimationPartInterface animationPartInterface = this.f28397d;
        if (animationPartInterface != null) {
            animationPartInterface.setIsBackground(z);
        }
    }

    public void setCameraMode(CameraMode cameraMode) {
        if (this.f28402i != cameraMode) {
            if (cameraMode != CameraMode.CAR_HEAD_UP) {
                Padding padding = this.f28395b.getPadding();
                if (!(-1 == this.f28404k || -1 == this.f28405l)) {
                    this.f28395b.setPadding(padding.left, this.f28404k, padding.right, this.f28405l);
                }
            } else if (DriverCarNewAnimApollo.getInstance().enable()) {
                setCarImageMarginV2();
            } else {
                m20119b();
            }
        }
        this.f28402i = cameraMode;
        AnimationPartInterface animationPartInterface = this.f28397d;
        if (animationPartInterface != null) {
            animationPartInterface.setCameraMode(cameraMode);
            this.f28397d.setCarImageView(this.f28406m);
        }
    }

    public void followMyLocation(boolean z) {
        this.f28403j = z;
        AnimationPartInterface animationPartInterface = this.f28397d;
        if (animationPartInterface != null) {
            animationPartInterface.followMyLocation(z);
        }
    }

    public void onNewMargin(int i, int i2, int i3, int i4) {
        this.f28404k = i2;
        this.f28405l = i4;
        if (this.f28402i != CameraMode.CAR_HEAD_UP) {
            return;
        }
        if (DriverCarNewAnimApollo.getInstance().enable()) {
            setCarImageMarginV2();
        } else {
            m20119b();
        }
    }

    public void zoomToNav() {
        AnimationPartInterface animationPartInterface = this.f28397d;
        if (animationPartInterface != null) {
            animationPartInterface.zoomToNav();
        }
    }

    public double distanceLeft() {
        AnimationPartInterface animationPartInterface = this.f28397d;
        if (animationPartInterface != null) {
            return animationPartInterface.distanceLeft();
        }
        return -1.0d;
    }

    public void setCarHeadMaxMapLevel(double d) {
        this.f28412s = d;
        AnimationPartInterface animationPartInterface = this.f28397d;
        if (animationPartInterface != null) {
            animationPartInterface.setCarHeadMaxMapLevel(d);
        }
    }

    public void setCarMarkerOrImageEnable(boolean z) {
        AnimationPartInterface animationPartInterface = this.f28397d;
        if (animationPartInterface != null) {
            animationPartInterface.setCarMarkerOrImageEnable(z);
        }
    }

    public AnimateNode getCurrentAnimNode() {
        AnimationPartInterface animationPartInterface = this.f28397d;
        if (animationPartInterface != null) {
            return animationPartInterface.getCurrentAnimNode();
        }
        return null;
    }

    public void setIsPassenger(boolean z) {
        this.f28413t = z;
    }

    public AnimationPartInterface getCarAnimator() {
        return this.f28397d;
    }

    public CarMarker getCarMarker() {
        return this.f28396c;
    }

    public NavOverlay getCarImage() {
        return this.f28406m;
    }

    public void setAnimationInterval(int i) {
        this.f28399f = i;
        AnimationPartInterface animationPartInterface = this.f28397d;
        if (animationPartInterface != null) {
            animationPartInterface.setAnimationInterval(i);
        }
    }

    public void setCarAnimationListener(onCarAnimationListener oncaranimationlistener) {
        this.f28398e = oncaranimationlistener;
    }

    /* renamed from: a */
    private void m20117a() {
        Map map;
        if (this.f28406m != null || this.f28395b == null) {
            NavOverlay navOverlay = this.f28406m;
            if (navOverlay != null && (map = this.f28395b) != null) {
                navOverlay.setMargin(0, this.f28407n, 0, 0, map.getHeight());
                return;
            }
            return;
        }
        NavOverlay navOverlay2 = new NavOverlay(this.f28395b.getContext(), this.f28407n);
        this.f28406m = navOverlay2;
        CarMarker carMarker = this.f28396c;
        if (carMarker != null) {
            navOverlay2.setIcon(carMarker.getIcon());
        }
        this.f28406m.setVisible(false);
        NavOverlay.addToMapView(this.f28406m, this.f28395b);
    }

    /* renamed from: b */
    private void m20119b() {
        int i;
        Map map = this.f28395b;
        if (map == null) {
            DLog.m7384d(f28394a, "setCarImageMargin , map is null", new Object[0]);
            return;
        }
        Padding padding = map.getPadding();
        int dp2pixel = CommonUtils.dp2pixel(50);
        this.f28407n = this.f28395b.getHeight() / 16;
        double height = ((double) this.f28395b.getHeight()) * 0.33d;
        int i2 = this.f28407n;
        while (true) {
            i = (int) (height + ((double) (i2 * 2)));
            if ((this.f28395b.getHeight() / 2) - i >= this.f28405l + dp2pixel) {
                break;
            }
            this.f28407n -= dp2pixel / 4;
            height = ((double) this.f28395b.getHeight()) * 0.33d;
            i2 = this.f28407n;
        }
        int height2 = ((this.f28395b.getHeight() / 2) - this.f28404k) + i;
        this.f28408o = height2;
        AnimationPartInterface animationPartInterface = this.f28397d;
        if (animationPartInterface != null) {
            animationPartInterface.setCarHeadParams(height2, this.f28409p);
        }
        if (i >= 0) {
            this.f28395b.setPadding(padding.left, i, padding.right, 0);
        } else {
            this.f28395b.setPadding(padding.left, 0, padding.right, -i);
        }
    }

    public void setCarImageMarginV2() {
        Map map = this.f28395b;
        if (map == null || map.getPadding() == null) {
            DLog.m7384d(f28394a, "mMap or padding is null", new Object[0]);
            return;
        }
        Padding padding = this.f28395b.getPadding();
        int i = padding.left;
        int i2 = this.f28404k;
        int i3 = padding.right;
        int i4 = this.f28405l;
        float carPaddingTopRatio = DriverCarNewAnimApollo.getInstance().getCarPaddingTopRatio();
        if (this.f28404k >= 0 && this.f28405l >= 0 && this.f28395b.getHeight() > 0) {
            i2 = (int) (((float) this.f28404k) + (carPaddingTopRatio * ((float) ((this.f28395b.getHeight() - this.f28404k) - this.f28405l))));
            this.f28408o = (int) (((float) i2) + (((float) ((this.f28395b.getHeight() - i2) - i4)) / 2.0f));
            DLog.m7384d(f28394a, "DriverCarAnim pixelNumBetweenCarAndTopView: " + this.f28408o, new Object[0]);
            AnimationPartInterface animationPartInterface = this.f28397d;
            if (animationPartInterface != null) {
                animationPartInterface.setCarHeadParams(this.f28408o, this.f28409p);
            }
        }
        this.f28395b.setPadding(i, i2, i3, i4);
    }
}
