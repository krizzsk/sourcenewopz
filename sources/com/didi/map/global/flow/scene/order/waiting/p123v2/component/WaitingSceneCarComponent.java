package com.didi.map.global.flow.scene.order.waiting.p123v2.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.line.pax.commonline.CommonLineManager;
import com.didi.map.global.component.markers.view.ScaleAnimMarker;
import com.didi.map.global.component.slideCars.api.ApiType;
import com.didi.map.global.component.slideCars.api.CarNavigatorRequest;
import com.didi.map.global.component.slideCars.api.ICarNavigatorCallback;
import com.didi.map.global.component.slideCars.api.NearCarDriver;
import com.didi.map.global.component.slideCars.navigator.NavigatorPresenter;
import com.didi.map.global.flow.scene.order.waiting.p123v2.ICarPositionFlushCallback;
import com.didi.map.global.flow.scene.order.waiting.p123v2.WaitingCarParam;
import com.didi.map.sdk.component.IBaseComponent;
import com.didichuxing.carsliding.model.Driver;
import com.didichuxing.carsliding.model.VectorCoordinate;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.map.global.flow.scene.order.waiting.v2.component.WaitingSceneCarComponent */
public class WaitingSceneCarComponent implements IBaseComponent<WaitingCarParam> {

    /* renamed from: a */
    private static final String f26994a = "WaitingSceneCarComponent";

    /* renamed from: f */
    private static final int f26995f = 3000;

    /* renamed from: b */
    private Context f26996b;

    /* renamed from: c */
    private Map f26997c;

    /* renamed from: d */
    private CommonLineManager f26998d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ScaleAnimMarker f26999e;

    /* renamed from: g */
    private int f27000g = 3000;

    /* renamed from: h */
    private Driver f27001h;

    /* renamed from: i */
    private FlushCarPositionHandler f27002i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public ICarPositionFlushCallback f27003j;

    /* renamed from: k */
    private NavigatorPresenter f27004k;

    /* renamed from: l */
    private CarNavigatorRequest f27005l;

    public void create(Context context, Map map) {
        this.f26996b = context;
        this.f26997c = map;
        if (context != null) {
            this.f27004k = new NavigatorPresenter(context, ApiType.SINGLE);
        }
        FlushCarPositionHandler flushCarPositionHandler = new FlushCarPositionHandler();
        this.f27002i = flushCarPositionHandler;
        flushCarPositionHandler.setResponseCar(this);
    }

    public void destroy() {
        CommonLineManager commonLineManager = this.f26998d;
        if (commonLineManager != null) {
            commonLineManager.destroy();
            this.f26998d = null;
        }
        FlushCarPositionHandler flushCarPositionHandler = this.f27002i;
        if (flushCarPositionHandler != null) {
            flushCarPositionHandler.removeCallbacksAndMessages((Object) null);
            this.f27002i = null;
        }
        ScaleAnimMarker scaleAnimMarker = this.f26999e;
        if (scaleAnimMarker != null) {
            scaleAnimMarker.destroy();
            this.f26999e = null;
        }
        this.f27001h = null;
        this.f26996b = null;
        this.f26997c = null;
        this.f27005l = null;
    }

    public void setConfigParam(WaitingCarParam waitingCarParam) {
        if (waitingCarParam != null) {
            int pullIntervalMs = waitingCarParam.getPullIntervalMs();
            this.f27000g = pullIntervalMs;
            if (pullIntervalMs < 3000) {
                this.f27000g = 3000;
            }
            this.f27003j = waitingCarParam.getCarPositionFlushCallback();
            this.f27005l = waitingCarParam.getCarNavigatorRequest();
        }
    }

    public void onMapVisible(boolean z) {
        CommonLineManager commonLineManager = this.f26998d;
        if (commonLineManager != null) {
            commonLineManager.setLineVisible(z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19047a() {
        Driver driver = this.f27001h;
        if (driver != null) {
            m19049a(driver);
            FlushCarPositionHandler flushCarPositionHandler = this.f27002i;
            if (flushCarPositionHandler != null) {
                flushCarPositionHandler.sendEmptyMessageDelayed(1, (long) this.f27000g);
            }
        }
    }

    public void stopLooper() {
        FlushCarPositionHandler flushCarPositionHandler = this.f27002i;
        if (flushCarPositionHandler != null) {
            flushCarPositionHandler.sendEmptyMessage(0);
        }
    }

    /* renamed from: a */
    private void m19048a(LatLng latLng, Bitmap bitmap, boolean z) {
        if (latLng != null) {
            DLog.m7384d(f26994a, "小车位置：lat" + latLng.latitude + "long" + latLng.longitude, new Object[0]);
            if (this.f26999e == null) {
                DLog.m7384d(f26994a, "初始化小车组件", new Object[0]);
                this.f26999e = new ScaleAnimMarker();
                ScaleAnimMarker.ScaleMarkerParam scaleMarkerParam = new ScaleAnimMarker.ScaleMarkerParam(latLng, bitmap, z);
                scaleMarkerParam.setzIndex(121);
                this.f26999e.setConfigParam(scaleMarkerParam);
                this.f26999e.create(this.f26996b, this.f26997c);
            }
            this.f26999e.showMarker(latLng);
            m19047a();
        }
    }

    /* renamed from: a */
    private void m19049a(Driver driver) {
        CarNavigatorRequest carNavigatorRequest;
        if (driver != null && this.f27004k != null && (carNavigatorRequest = this.f27005l) != null) {
            carNavigatorRequest.setDriverId(driver.getId());
            this.f27004k.getCarNavigatorData(this.f27005l, new ICarNavigatorCallback() {
                public void onSuccess(NearCarDriver nearCarDriver) {
                    List<NearCarDriver.Coordinate> list;
                    LatLng latLng = null;
                    if (((nearCarDriver == null || nearCarDriver.driverLocations == null || nearCarDriver.driverLocations.isEmpty()) ? false : true) && (list = nearCarDriver.driverLocations.get(0).coords) != null && !list.isEmpty() && list.get(0) != null) {
                        latLng = new LatLng(list.get(0).f26163x, list.get(0).f26164y);
                    }
                    if (!(WaitingSceneCarComponent.this.f26999e == null || latLng == null)) {
                        DLog.m7384d(WaitingSceneCarComponent.f26994a, "刷新小车位置：lat" + latLng.latitude + "long" + latLng.longitude, new Object[0]);
                        WaitingSceneCarComponent.this.f26999e.updatePosition(latLng);
                    }
                    if (WaitingSceneCarComponent.this.f27003j != null && latLng != null) {
                        WaitingSceneCarComponent.this.f27003j.onCarPositionFlushed(latLng);
                    }
                }

                public void onFails(String str) {
                    DLog.m7384d(WaitingSceneCarComponent.f26994a, "IRequestCapacityCallback onFailure " + str, new Object[0]);
                }
            });
        }
    }

    public void updateCarIcon(Bitmap bitmap) {
        if (this.f26999e != null && bitmap != null) {
            DLog.m7384d(f26994a, "刷新小车图片", new Object[0]);
            this.f26999e.updateIcon(bitmap);
        }
    }

    /* renamed from: b */
    private LatLng m19050b(Driver driver) {
        if (driver == null || driver.getVectorCoordinateList() == null || driver.getVectorCoordinateList().isEmpty()) {
            return null;
        }
        VectorCoordinate vectorCoordinate = (VectorCoordinate) driver.getVectorCoordinateList().get(0);
        return new LatLng(vectorCoordinate.getLat(), vectorCoordinate.getLng());
    }

    public void showCarMarker(Driver driver, Bitmap bitmap, boolean z) {
        if (driver != null) {
            this.f27001h = driver;
            LatLng b = m19050b(driver);
            Driver driver2 = this.f27001h;
            if (driver2 == null || driver2.getBitmap() == null || this.f27001h.getBitmap().getBitmap() == null) {
                DLog.m7384d(f26994a, "使用默认bitmap", new Object[0]);
            } else {
                DLog.m7384d(f26994a, "使用driver  bitmap", new Object[0]);
                bitmap = this.f27001h.getBitmap().getBitmap();
            }
            m19048a(b, bitmap, z);
        }
    }

    public void hideCarMarker(boolean z) {
        if (this.f26999e != null) {
            DLog.m7384d(f26994a, "隐藏小车图片", new Object[0]);
            this.f26999e.hideMarker(z);
        }
        stopLooper();
    }

    public List<IMapElement> getAllMarkerElements() {
        ArrayList arrayList = new ArrayList();
        ScaleAnimMarker scaleAnimMarker = this.f26999e;
        if (scaleAnimMarker != null) {
            arrayList.addAll(scaleAnimMarker.getMarkerElements());
        }
        CommonLineManager commonLineManager = this.f26998d;
        if (commonLineManager != null) {
            arrayList.addAll(commonLineManager.getBestViewElements());
        }
        return arrayList;
    }

    public List<IMapElement> getCarMarkerElements() {
        ArrayList arrayList = new ArrayList();
        ScaleAnimMarker scaleAnimMarker = this.f26999e;
        if (scaleAnimMarker != null) {
            arrayList.addAll(scaleAnimMarker.getMarkerElements());
        }
        return arrayList;
    }

    /* renamed from: com.didi.map.global.flow.scene.order.waiting.v2.component.WaitingSceneCarComponent$FlushCarPositionHandler */
    private static class FlushCarPositionHandler extends Handler {
        private WeakReference<WaitingSceneCarComponent> waitingSceneComponentWeakReference;

        private FlushCarPositionHandler() {
        }

        public void setResponseCar(WaitingSceneCarComponent waitingSceneCarComponent) {
            this.waitingSceneComponentWeakReference = new WeakReference<>(waitingSceneCarComponent);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 0) {
                DLog.m7384d(WaitingSceneCarComponent.f26994a, "停止刷新小车图片", new Object[0]);
                removeCallbacksAndMessages((Object) null);
            } else if (i == 1) {
                DLog.m7384d(WaitingSceneCarComponent.f26994a, "启动刷新小车图片", new Object[0]);
                WeakReference<WaitingSceneCarComponent> weakReference = this.waitingSceneComponentWeakReference;
                if (weakReference != null && weakReference.get() != null) {
                    ((WaitingSceneCarComponent) this.waitingSceneComponentWeakReference.get()).m19047a();
                }
            }
        }
    }
}
