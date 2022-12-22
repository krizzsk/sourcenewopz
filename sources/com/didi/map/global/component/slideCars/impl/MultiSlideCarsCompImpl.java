package com.didi.map.global.component.slideCars.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.didi.common.map.Map;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.slideCars.ISlideCarsCompContract;
import com.didi.map.global.component.slideCars.SlideCarsCompParams;
import com.didi.map.global.component.slideCars.api.ApiType;
import com.didi.map.global.component.slideCars.api.CarNavigatorRequest;
import com.didi.map.global.component.slideCars.api.ICarNavigatorCallback;
import com.didi.map.global.component.slideCars.api.NearCarDriver;
import com.didi.map.global.component.slideCars.model.IDriverChangeListener;
import com.didi.map.global.component.slideCars.navigator.CarDriverModel;
import com.didi.map.global.component.slideCars.navigator.CarNavigatorConfigParam;
import com.didi.map.global.component.slideCars.navigator.NavigatorPresenter;
import com.didi.map.global.model.location.LocationHelper;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.carsliding.api.CarSlidingRender;
import com.didichuxing.carsliding.api.CarSlidingRenderFactory;
import com.didichuxing.carsliding.filter.DistanceFilter;
import com.didichuxing.carsliding.filter.TimestampFilter;
import com.didichuxing.carsliding.model.Driver;
import com.didichuxing.carsliding.model.DriverCollection;
import com.didichuxing.carsliding.model.RenderParams;
import com.didichuxing.carsliding.model.RenderStrategy;
import com.didichuxing.carsliding.model.VectorCoordinate;
import com.didichuxing.carsliding.model.VectorCoordinateList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MultiSlideCarsCompImpl implements ISlideCarsCompContract {

    /* renamed from: a */
    private static final String f26170a = "SlideCarsCompImpl";

    /* renamed from: b */
    private static final int f26171b = 5000;

    /* renamed from: c */
    private static final int f26172c = 10000;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f26173d = 10000;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ArrayList<LatLng> f26174e = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public CarSlidingRender f26175f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public SlideCarsCompParams f26176g;

    /* renamed from: h */
    private Handler f26177h = new Handler(Looper.getMainLooper());

    /* renamed from: i */
    private Map f26178i;

    /* renamed from: j */
    private Context f26179j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f26180k = true;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public IDriverChangeListener f26181l;

    /* renamed from: m */
    private CapacitiesReqRunnable f26182m = new CapacitiesReqRunnable();

    /* renamed from: n */
    private NavigatorPresenter f26183n;

    /* renamed from: o */
    private CarNavigatorRequest f26184o;

    /* renamed from: p */
    private boolean f26185p = true;

    public void create(Context context, Map map) {
        this.f26178i = map;
        this.f26179j = context;
        if (this.f26176g != null && map != null && context != null) {
            m18534a();
            int pullIntervalMs = this.f26176g.getPullIntervalMs();
            this.f26173d = pullIntervalMs;
            if (pullIntervalMs < 5000) {
                this.f26173d = 5000;
            }
            this.f26183n = new NavigatorPresenter(this.f26179j, ApiType.MULTI);
        }
    }

    public void destroy() {
        m18539b();
        m18545e();
        Handler handler = this.f26177h;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.f26177h = null;
        }
    }

    public void setConfigParam(SlideCarsCompParams slideCarsCompParams) {
        this.f26176g = slideCarsCompParams;
        if (slideCarsCompParams != null) {
            this.f26184o = slideCarsCompParams.getCarSlidingRequestParam();
            this.f26185p = this.f26176g.isShowSlidingCar();
        }
    }

    public void onMapVisible(boolean z) {
        this.f26180k = z;
        if (z) {
            CarSlidingRender carSlidingRender = this.f26175f;
            if (carSlidingRender != null) {
                carSlidingRender.show(false);
            }
            m18535a(1);
            return;
        }
        CarSlidingRender carSlidingRender2 = this.f26175f;
        if (carSlidingRender2 != null) {
            carSlidingRender2.hide(false);
        }
        m18539b();
    }

    public void start() {
        m18535a(10);
    }

    public void stop() {
        m18539b();
    }

    public void reStart(CarNavigatorRequest carNavigatorRequest) {
        if (this.f26178i != null && this.f26176g != null) {
            if (carNavigatorRequest != null) {
                this.f26184o = carNavigatorRequest;
            }
            m18545e();
            m18534a();
            m18535a(10);
        }
    }

    public void setCarVisible(boolean z) {
        CarSlidingRender carSlidingRender = this.f26175f;
        if (carSlidingRender != null) {
            this.f26185p = z;
            if (z) {
                carSlidingRender.show(false);
            } else {
                carSlidingRender.hide(false);
            }
        }
    }

    public void updateLocationPosition(LatLng latLng) {
        CarNavigatorRequest carNavigatorRequest = this.f26184o;
        if (carNavigatorRequest != null && latLng != null) {
            carNavigatorRequest.setStartPosition(latLng);
        }
    }

    public void refreshCarIcon() {
        SlideCarsCompParams slideCarsCompParams;
        if (this.f26175f != null && (slideCarsCompParams = this.f26176g) != null && slideCarsCompParams.getBitmapGetter() != null) {
            this.f26175f.initIcon(this.f26176g.getBitmapGetter().getBitmapDescriptor(), this.f26176g.getBitmapGetter().getDefaultBitmapDescriptor());
        }
    }

    public List<LatLng> getDriverPoints() {
        return this.f26174e;
    }

    public void setListener(IDriverChangeListener iDriverChangeListener) {
        this.f26181l = iDriverChangeListener;
    }

    /* renamed from: a */
    private void m18534a() {
        Map map = this.f26178i;
        if (map != null && this.f26185p) {
            if (this.f26175f == null) {
                this.f26175f = CarSlidingRenderFactory.createRender(map);
            }
            if (this.f26176g.getBitmapGetter() != null) {
                this.f26175f.initIcon(this.f26176g.getBitmapGetter().getBitmapDescriptor(), this.f26176g.getBitmapGetter().getDefaultBitmapDescriptor());
            }
        }
    }

    /* renamed from: b */
    private void m18539b() {
        Handler handler = this.f26177h;
        if (handler != null) {
            handler.removeCallbacks(this.f26182m);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18535a(long j) {
        Handler handler = this.f26177h;
        if (handler != null) {
            handler.removeCallbacks(this.f26182m);
            this.f26177h.postDelayed(this.f26182m, j);
        }
    }

    /* renamed from: c */
    private LatLng m18540c() {
        DIDILocation lastKnownLocation;
        CarNavigatorRequest carNavigatorRequest = this.f26184o;
        if (carNavigatorRequest != null && carNavigatorRequest.getStartPosition() != null) {
            return this.f26184o.getStartPosition();
        }
        Context context = this.f26179j;
        if (context == null || (lastKnownLocation = LocationHelper.getLastKnownLocation(context)) == null) {
            return null;
        }
        return new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m18543d() {
        NavigatorPresenter navigatorPresenter;
        CarNavigatorRequest carNavigatorRequest;
        if (this.f26176g != null && this.f26179j != null && LatLngUtils.locateCorrect(m18540c()) && (navigatorPresenter = this.f26183n) != null && (carNavigatorRequest = this.f26184o) != null) {
            navigatorPresenter.getCarNavigatorData(carNavigatorRequest, new ICarNavigatorCallback() {
                public void onSuccess(NearCarDriver nearCarDriver) {
                    VectorCoordinate vectorCoordinate;
                    try {
                        RenderParams navigatorResponse = MultiSlideCarsCompImpl.this.getNavigatorResponse(nearCarDriver);
                        if (!(!MultiSlideCarsCompImpl.this.f26180k || MultiSlideCarsCompImpl.this.f26175f == null || MultiSlideCarsCompImpl.this.f26176g == null)) {
                            if (MultiSlideCarsCompImpl.this.f26176g.getBitmapGetter() != null) {
                                if ((navigatorResponse == null || navigatorResponse.getDriverCollection() == null || navigatorResponse.getDriverCollection().isEmpty()) ? false : true) {
                                    MultiSlideCarsCompImpl.this.f26175f.initIcon(MultiSlideCarsCompImpl.this.f26176g.getBitmapGetter().getBitmapDescriptor(), MultiSlideCarsCompImpl.this.f26176g.getBitmapGetter().getDefaultBitmapDescriptor());
                                    MultiSlideCarsCompImpl.this.f26175f.render(navigatorResponse);
                                    if (MultiSlideCarsCompImpl.this.f26174e == null) {
                                        ArrayList unused = MultiSlideCarsCompImpl.this.f26174e = new ArrayList();
                                    }
                                    MultiSlideCarsCompImpl.this.f26174e.clear();
                                    Iterator it = navigatorResponse.getDriverCollection().iterator();
                                    while (it.hasNext()) {
                                        Driver driver = (Driver) it.next();
                                        if (!(driver == null || driver.getVectorCoordinateList() == null || driver.getVectorCoordinateList().isEmpty() || (vectorCoordinate = (VectorCoordinate) driver.getVectorCoordinateList().get(0)) == null)) {
                                            MultiSlideCarsCompImpl.this.f26174e.add(new LatLng(vectorCoordinate.getLat(), vectorCoordinate.getLng()));
                                        }
                                    }
                                }
                                if (MultiSlideCarsCompImpl.this.f26181l == null) {
                                    return;
                                }
                                MultiSlideCarsCompImpl.this.f26181l.onGetResultSuccess(nearCarDriver);
                                return;
                            }
                        }
                        if (MultiSlideCarsCompImpl.this.f26181l != null) {
                            MultiSlideCarsCompImpl.this.f26181l.onGetResultSuccess(nearCarDriver);
                        }
                    } catch (Exception e) {
                        DLog.m7384d(MultiSlideCarsCompImpl.f26170a, "IRequestCapacityCallback onSuccess 发生异常" + e.getMessage(), new Object[0]);
                        if (MultiSlideCarsCompImpl.this.f26181l == null) {
                        }
                    } catch (Throwable th) {
                        if (MultiSlideCarsCompImpl.this.f26181l != null) {
                            MultiSlideCarsCompImpl.this.f26181l.onGetResultSuccess(nearCarDriver);
                        }
                        throw th;
                    }
                }

                public void onFails(String str) {
                    if (MultiSlideCarsCompImpl.this.f26181l != null) {
                        MultiSlideCarsCompImpl.this.f26181l.onGetResultError(str);
                    }
                    DLog.m7384d(MultiSlideCarsCompImpl.f26170a, "IRequestCapacityCallback onFailure " + str, new Object[0]);
                }
            });
        }
    }

    /* renamed from: e */
    private void m18545e() {
        CarSlidingRender carSlidingRender = this.f26175f;
        if (carSlidingRender != null) {
            carSlidingRender.hide(false);
            this.f26175f.destroy();
            this.f26175f = null;
        }
        ArrayList<LatLng> arrayList = this.f26174e;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    /* access modifiers changed from: protected */
    public RenderParams getNavigatorResponse(NearCarDriver nearCarDriver) {
        DLog.m7384d(f26170a, "renderParam" + nearCarDriver, new Object[0]);
        if (nearCarDriver == null) {
            return null;
        }
        return initBaseRenderParam(nearCarDriver).create();
    }

    /* access modifiers changed from: protected */
    public DriverCollection getDriverCollection(NearCarDriver nearCarDriver) {
        NearCarDriver nearCarDriver2 = nearCarDriver;
        DriverCollection driverCollection = new DriverCollection();
        if (!(nearCarDriver2 == null || nearCarDriver2.driverLocations == null || nearCarDriver2.driverLocations.isEmpty())) {
            for (NearCarDriver.Loc next : nearCarDriver2.driverLocations) {
                if (next != null) {
                    CarDriverModel carDriverModel = new CarDriverModel(next.driverId + "");
                    VectorCoordinateList vectorCoordinateList = new VectorCoordinateList();
                    List<NearCarDriver.Coordinate> list = next.coords;
                    if (list != null) {
                        for (NearCarDriver.Coordinate next2 : list) {
                            if (next2 != null) {
                                long j = (long) next2.timestamp;
                                VectorCoordinate vectorCoordinate = r8;
                                VectorCoordinate vectorCoordinate2 = new VectorCoordinate(next2.f26163x, next2.f26164y, (float) next2.angle, j);
                                vectorCoordinateList.add(vectorCoordinate);
                            }
                        }
                    }
                    carDriverModel.setVectorCoordinateList(vectorCoordinateList);
                    if (nearCarDriver2.isDebugOpen == 1) {
                        carDriverModel.setDebugStatus(next.debugStatus);
                        carDriverModel.setDebugStatusDetail(next.debugStatusDetail);
                    }
                    carDriverModel.setCarLevel(next.carLevel);
                    driverCollection.add(carDriverModel);
                }
            }
        }
        return driverCollection;
    }

    /* access modifiers changed from: protected */
    public RenderParams.Builder initBaseRenderParam(NearCarDriver nearCarDriver) {
        DriverCollection driverCollection = getDriverCollection(nearCarDriver);
        RenderParams.Builder builder = new RenderParams.Builder();
        if (driverCollection == null) {
            return builder;
        }
        builder.setDriverCollection(driverCollection);
        CarNavigatorConfigParam carNavigatorConfigParam = new CarNavigatorConfigParam();
        carNavigatorConfigParam.setAngleSensitive(true);
        carNavigatorConfigParam.setSlidingTime(5000);
        builder.setSlidingTimeMillis(carNavigatorConfigParam.getSlidingTime());
        if (carNavigatorConfigParam.getRenderStrategy() == 2) {
            builder.setRenderStrategy(RenderStrategy.SLIDE);
        } else {
            builder.setRenderStrategy(RenderStrategy.SKIP);
        }
        builder.setFadeAnimEnable(carNavigatorConfigParam.isFadeAnimInEnable(), carNavigatorConfigParam.isFadeAnimOutEnable());
        builder.setAngleSensitive(carNavigatorConfigParam.isAngleSensitive());
        TimestampFilter timestampFilter = new TimestampFilter();
        DistanceFilter distanceFilter = new DistanceFilter(10.0d);
        builder.addVectorCoordinateFilter(timestampFilter);
        builder.addVectorCoordinateFilter(distanceFilter);
        return builder;
    }

    private class CapacitiesReqRunnable implements Runnable {
        private CapacitiesReqRunnable() {
        }

        public void run() {
            MultiSlideCarsCompImpl.this.m18543d();
            MultiSlideCarsCompImpl multiSlideCarsCompImpl = MultiSlideCarsCompImpl.this;
            multiSlideCarsCompImpl.m18535a((long) multiSlideCarsCompImpl.f26173d);
        }
    }
}
