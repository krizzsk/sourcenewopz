package com.didichuxing.carsliding.api;

import android.graphics.Bitmap;
import android.os.Looper;
import android.util.AndroidRuntimeException;
import com.didi.common.map.Map;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.carsliding.anim.CarSlidingRenderAnimator;
import com.didichuxing.carsliding.anim.ISlidingAnimator;
import com.didichuxing.carsliding.anim.MarkerInfo;
import com.didichuxing.carsliding.anim.SlidingMeta;
import com.didichuxing.carsliding.filter.VectorCoordinateFilter;
import com.didichuxing.carsliding.model.Driver;
import com.didichuxing.carsliding.model.DriverCollection;
import com.didichuxing.carsliding.model.RenderParams;
import com.didichuxing.carsliding.model.RenderResult;
import com.didichuxing.carsliding.model.RenderStrategy;
import com.didichuxing.carsliding.model.VectorCoordinate;
import com.didichuxing.carsliding.model.VectorCoordinateList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class CarSlidingRenderImpl implements CarSlidingRender {
    public static final String Tag = "CarSlidingRenderImpl";

    /* renamed from: a */
    private Map f46246a;

    /* renamed from: b */
    private SlidingDataWrapper f46247b;

    /* renamed from: c */
    private String f46248c;

    /* renamed from: d */
    private Looper f46249d;

    /* renamed from: e */
    private boolean f46250e;

    CarSlidingRenderImpl(Map map) {
        this(map, (BitmapDescriptor) null, (BitmapDescriptor) null);
    }

    CarSlidingRenderImpl(Map map, BitmapDescriptor bitmapDescriptor, BitmapDescriptor bitmapDescriptor2) {
        this.f46247b = new SlidingDataWrapper();
        this.f46250e = false;
        this.f46246a = map;
        this.f46248c = hashCode() + "_";
        this.f46249d = Looper.getMainLooper();
        initIcon(bitmapDescriptor, bitmapDescriptor2);
    }

    public void initIcon(BitmapDescriptor bitmapDescriptor, BitmapDescriptor bitmapDescriptor2) {
        synchronized (this) {
            if (bitmapDescriptor == null) {
                bitmapDescriptor = bitmapDescriptor2;
            }
            BitmapDescriptor bitmapDescriptor3 = this.f46247b.bitmapDescriptor;
            if (!(bitmapDescriptor3 == null || bitmapDescriptor3 == bitmapDescriptor || this.f46247b == null || this.f46247b.isEmpty())) {
                Iterator it = this.f46247b.driverCollection.iterator();
                while (it.hasNext()) {
                    Driver driver = (Driver) it.next();
                    ISlidingAnimator iSlidingAnimator = this.f46247b.animatorMap.get(driver.getId());
                    if (iSlidingAnimator != null) {
                        BitmapDescriptor bitmap = driver.getBitmap();
                        if (bitmap == null) {
                            bitmap = bitmapDescriptor;
                        }
                        iSlidingAnimator.updateIcon(bitmap);
                    }
                }
            }
            this.f46247b.bitmapDescriptor = bitmapDescriptor;
        }
    }

    public List<RenderResult> render(RenderParams renderParams) {
        synchronized (this) {
            if (this.f46250e) {
                return null;
            }
            DriverCollection driverCollection = renderParams.getDriverCollection();
            if (driverCollection != null) {
                if (!driverCollection.isEmpty()) {
                    Iterator it = driverCollection.iterator();
                    while (true) {
                        boolean z = true;
                        if (!it.hasNext()) {
                            break;
                        }
                        Driver driver = (Driver) it.next();
                        VectorCoordinateList vectorCoordinateList = driver.getVectorCoordinateList();
                        if (vectorCoordinateList != null) {
                            if (!vectorCoordinateList.isEmpty()) {
                                VectorCoordinateList vectorCoordinateList2 = new VectorCoordinateList();
                                vectorCoordinateList2.addAll(vectorCoordinateList);
                                String id = driver.getId();
                                if (this.f46247b.driverCollection.contains(driver)) {
                                    z = false;
                                }
                                boolean isAngleSensitive = renderParams.isAngleSensitive();
                                long slidingTimeMillis = renderParams.getSlidingTimeMillis();
                                if (z) {
                                    this.f46247b.driverCollection.add(driver);
                                    VectorCoordinate vectorCoordinate = (VectorCoordinate) vectorCoordinateList2.remove(0);
                                    SlidingMeta slidingMeta = new SlidingMeta(vectorCoordinate, isAngleSensitive, vectorCoordinate.getAngle(), 0, renderParams.getFilterList());
                                    m33223a(id, driver.getBitmap(), vectorCoordinate, isAngleSensitive, renderParams.isFadeInAnimEnable(), slidingMeta, renderParams.getDriverMarkerZindex());
                                } else {
                                    this.f46247b.driverCollection.set(this.f46247b.driverCollection.indexOf(driver), driver);
                                    m33221a(driver);
                                }
                                m33222a(driver, slidingTimeMillis, isAngleSensitive, renderParams.getFilterList(), RenderStrategy.SKIP.equals(renderParams.getRenderStrategy()), renderParams.isFadeInAnimEnable(), vectorCoordinateList2);
                            }
                        }
                    }
                    Iterator it2 = this.f46247b.driverCollection.iterator();
                    while (it2.hasNext()) {
                        Driver driver2 = (Driver) it2.next();
                        if (!driverCollection.contains(driver2)) {
                            it2.remove();
                            m33224a(driver2.getId(), renderParams.isFadeOutAnimEnable());
                        }
                    }
                    List<RenderResult> a = m33220a();
                    return a;
                }
            }
            m33225a(renderParams.isFadeOutAnimEnable());
            return null;
        }
    }

    /* renamed from: a */
    private void m33221a(Driver driver) {
        Marker marker;
        BitmapDescriptor icon;
        Bitmap bitmap;
        BitmapDescriptor bitmap2 = driver.getBitmap();
        if (bitmap2 != null) {
            Bitmap bitmap3 = bitmap2.getBitmap();
            ISlidingAnimator iSlidingAnimator = this.f46247b.animatorMap.get(driver.getId());
            if (iSlidingAnimator != null && (marker = iSlidingAnimator.get()) != null && (icon = marker.getIcon()) != null && (bitmap = icon.getBitmap()) != null && !bitmap.isRecycled() && !bitmap.sameAs(bitmap3)) {
                iSlidingAnimator.updateIcon(bitmap2);
            }
        }
    }

    public void hide(boolean z) {
        SystemUtils.log(4, Tag, "hide -> anim = " + z + "  this=" + this, (Throwable) null, "com.didichuxing.carsliding.api.CarSlidingRenderImpl", 214);
        synchronized (this) {
            if (this.f46247b != null && !this.f46247b.isEmpty()) {
                Iterator it = this.f46247b.driverCollection.iterator();
                while (it.hasNext()) {
                    ISlidingAnimator iSlidingAnimator = this.f46247b.animatorMap.get(((Driver) it.next()).getId());
                    if (iSlidingAnimator != null) {
                        iSlidingAnimator.dismiss(z, true);
                    }
                }
            }
        }
    }

    public void show(boolean z) {
        SystemUtils.log(4, Tag, "hide -> show = " + z + "  this=" + this, (Throwable) null, "com.didichuxing.carsliding.api.CarSlidingRenderImpl", 230);
        synchronized (this) {
            if (this.f46247b != null && !this.f46247b.isEmpty()) {
                Iterator it = this.f46247b.driverCollection.iterator();
                while (it.hasNext()) {
                    ISlidingAnimator iSlidingAnimator = this.f46247b.animatorMap.get(((Driver) it.next()).getId());
                    if (iSlidingAnimator != null) {
                        if (iSlidingAnimator.get() != null) {
                            iSlidingAnimator.display(z, true);
                        } else {
                            this.f46247b.animatorMap.remove(iSlidingAnimator);
                        }
                    }
                }
            }
        }
    }

    public void destroy() {
        SystemUtils.log(4, Tag, "destroy this=" + this, (Throwable) null, "com.didichuxing.carsliding.api.CarSlidingRenderImpl", 250);
        synchronized (this) {
            m33225a(false);
            this.f46247b.bitmapDescriptor = null;
            this.f46250e = true;
        }
    }

    /* renamed from: a */
    private String m33219a(String str) {
        return this.f46248c + str;
    }

    /* renamed from: a */
    private void m33225a(boolean z) {
        SlidingDataWrapper slidingDataWrapper = this.f46247b;
        if (slidingDataWrapper != null && !slidingDataWrapper.isEmpty()) {
            this.f46247b.driverCollection.clear();
            Iterator<String> it = this.f46247b.animatorMap.keySet().iterator();
            while (it.hasNext()) {
                java.util.Map<String, ISlidingAnimator> map = this.f46247b.animatorMap;
                it.remove();
                map.get(it.next()).destroy(z);
            }
        }
    }

    /* renamed from: a */
    private void m33223a(String str, BitmapDescriptor bitmapDescriptor, VectorCoordinate vectorCoordinate, boolean z, boolean z2, SlidingMeta slidingMeta, int i) {
        double lat = vectorCoordinate.getLat();
        double lng = vectorCoordinate.getLng();
        float angle = vectorCoordinate.getAngle();
        BitmapDescriptor bitmapDescriptor2 = this.f46247b.bitmapDescriptor;
        if (bitmapDescriptor2 != null) {
            CarSlidingRenderAnimator carSlidingRenderAnimator = new CarSlidingRenderAnimator(this.f46246a, this.f46249d);
            String a = m33219a(str);
            LatLng latLng = new LatLng(lat, lng);
            MarkerInfo markerInfo = new MarkerInfo();
            markerInfo.f46238id = a;
            markerInfo.latLng = latLng;
            if (bitmapDescriptor == null) {
                bitmapDescriptor = bitmapDescriptor2;
            }
            markerInfo.bitmapDescriptor = bitmapDescriptor;
            if (!z) {
                angle = 0.0f;
            }
            markerInfo.angle = angle;
            markerInfo.zIndex = i;
            carSlidingRenderAnimator.bind(markerInfo, slidingMeta);
            carSlidingRenderAnimator.display(z2, false);
            this.f46247b.animatorMap.put(str, carSlidingRenderAnimator);
            return;
        }
        throw new NullPointerException("To make sure that bitmapDescriptor is Not Null! ");
    }

    /* renamed from: a */
    private void m33224a(String str, boolean z) {
        this.f46247b.animatorMap.remove(str);
        this.f46247b.animatorMap.get(str).destroy(z);
    }

    /* renamed from: a */
    private void m33222a(Driver driver, long j, boolean z, List<VectorCoordinateFilter> list, boolean z2, boolean z3, VectorCoordinateList vectorCoordinateList) {
        if (vectorCoordinateList != null && !vectorCoordinateList.isEmpty()) {
            if (z2) {
                VectorCoordinate vectorCoordinate = (VectorCoordinate) vectorCoordinateList.get(vectorCoordinateList.size() - 1);
                boolean z4 = z;
                this.f46247b.animatorMap.get(driver.getId()).updatePosition(new SlidingMeta(vectorCoordinate, z4, vectorCoordinate.getAngle(), ((int) j) / vectorCoordinateList.size(), list), false);
                return;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = vectorCoordinateList.iterator();
            while (it.hasNext()) {
                VectorCoordinate vectorCoordinate2 = (VectorCoordinate) it.next();
                boolean z5 = z;
                arrayList.add(new SlidingMeta(vectorCoordinate2, z5, vectorCoordinate2.getAngle(), ((int) j) / vectorCoordinateList.size(), list));
            }
            this.f46247b.animatorMap.get(driver.getId()).insertAnimParamsCollection(arrayList);
        }
    }

    /* renamed from: a */
    private List<RenderResult> m33220a() {
        ArrayList arrayList = new ArrayList(this.f46247b.animatorMap.size());
        for (String next : this.f46247b.animatorMap.keySet()) {
            arrayList.add(new RenderResult(next, this.f46247b.animatorMap.get(next).get()));
        }
        return arrayList;
    }

    class SlidingDataWrapper {
        java.util.Map<String, ISlidingAnimator> animatorMap = new HashMap();
        BitmapDescriptor bitmapDescriptor;
        DriverCollection driverCollection = new DriverCollection();

        SlidingDataWrapper() {
        }

        /* access modifiers changed from: package-private */
        public boolean isEmpty() {
            return this.driverCollection.isEmpty() && this.animatorMap.isEmpty();
        }
    }

    public static final class CalledFromWrongThreadException extends AndroidRuntimeException {
        public CalledFromWrongThreadException(String str) {
            super(str);
        }
    }
}
