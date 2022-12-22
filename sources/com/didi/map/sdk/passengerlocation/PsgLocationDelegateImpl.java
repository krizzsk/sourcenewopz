package com.didi.map.sdk.passengerlocation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.didi.common.map.Map;
import com.didi.common.map.model.GpsLocation;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.map.sdk.passengerlocation.IPsgLocationDataSource;
import java.util.Iterator;
import java.util.List;

public final class PsgLocationDelegateImpl implements IPassengerLocation {

    /* renamed from: a */
    private static final String f28589a = "PsgLocationDelegateImpl";

    /* renamed from: b */
    private static final int f28590b = 900;

    /* renamed from: c */
    private static final int f28591c = 3000;

    /* renamed from: d */
    private PsgLocationRunnable f28592d = null;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f28593e = false;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Context f28594f;

    /* renamed from: g */
    private LatLng f28595g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public List<PassengerInfo> f28596h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public PassengerLocationParam f28597i;

    /* renamed from: j */
    private int f28598j = 100;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public Handler f28599k = new Handler(Looper.getMainLooper()) {
        public void dispatchMessage(Message message) {
            super.dispatchMessage(message);
            if (message != null && message.what == 900 && PsgLocationDelegateImpl.this.f28593e) {
                PsgLocationDelegateImpl.this.m20202a((List<PassengerInfo>) (List) message.obj);
            }
        }
    };

    public void setConfigParam(PassengerLocationParam passengerLocationParam) {
        this.f28597i = passengerLocationParam;
        this.f28598j = passengerLocationParam.locationAccuracy;
        this.f28595g = passengerLocationParam.startPoint;
        this.f28596h = passengerLocationParam.passengerInfoList;
    }

    public void start() {
        List<PassengerInfo> list = this.f28596h;
        if (list == null || list.isEmpty() || ((this.f28595g == null && this.f28594f == null) || this.f28593e)) {
            DLog.m7384d(f28589a, "start param error", new Object[0]);
            return;
        }
        for (final PassengerInfo next : this.f28596h) {
            if (!TextUtils.isEmpty(next.getHeadUrl())) {
                DLog.m7384d(f28589a, "start() headUrl: " + next.getHeadUrl(), new Object[0]);
                try {
                    Glide.with(this.f28594f).asBitmap().load(next.getHeadUrl()).into(new CustomTarget<Bitmap>(50, 50) {
                        public void onLoadCleared(Drawable drawable) {
                        }

                        public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
                            if (bitmap != null) {
                                next.setHeadIcon(bitmap);
                                DLog.m7384d(PsgLocationDelegateImpl.f28589a, "replace head icon", new Object[0]);
                            }
                        }
                    });
                } catch (Exception e) {
                    DLog.m7384d("glide", "start() Exception:" + e.toString(), new Object[0]);
                }
            }
        }
        if (this.f28592d == null) {
            this.f28592d = new PsgLocationRunnable();
        }
        Handler handler = this.f28599k;
        if (handler != null) {
            handler.removeCallbacks(this.f28592d);
            this.f28599k.post(this.f28592d);
            this.f28593e = true;
        }
    }

    public void stop() {
        Handler handler = this.f28599k;
        if (handler != null) {
            PsgLocationRunnable psgLocationRunnable = this.f28592d;
            if (psgLocationRunnable != null) {
                handler.removeCallbacks(psgLocationRunnable);
            }
            this.f28599k.removeMessages(900);
        }
        this.f28592d = null;
        this.f28597i = null;
        this.f28595g = null;
        this.f28596h = null;
        this.f28593e = false;
    }

    public void create(Context context, Map map) {
        this.f28594f = context.getApplicationContext();
    }

    public void destroy() {
        stop();
        this.f28594f = null;
        this.f28599k = null;
    }

    public void onMapVisible(boolean z) {
        PsgLocationRunnable psgLocationRunnable = this.f28592d;
        if (psgLocationRunnable != null) {
            psgLocationRunnable.onMapVisible(z);
        }
    }

    private final class PsgLocationRunnable implements Runnable {
        private IPsgLocationDataSource mLocationModel;

        PsgLocationRunnable() {
            this.mLocationModel = new PsgLocationDataSource(PsgLocationDelegateImpl.this.f28594f);
            if (PsgLocationDelegateImpl.this.f28597i != null) {
                this.mLocationModel.setBizType(Integer.valueOf(PaxEnvironment.getInstance().getProductId()).intValue());
                this.mLocationModel.setPhoneNum(PaxEnvironment.getInstance().getPhoneNumber());
                this.mLocationModel.setToken(PaxEnvironment.getInstance().getToken());
                this.mLocationModel.setTraverID(PsgLocationDelegateImpl.this.f28597i.travelId);
            }
        }

        public void run() {
            if (!PsgLocationDelegateImpl.this.f28593e) {
                DLog.m7384d(PsgLocationDelegateImpl.f28589a, "PsgLocationRunnable run() isStarted() is false!", new Object[0]);
                return;
            }
            DLog.m7384d(PsgLocationDelegateImpl.f28589a, "PsgLocationRunnable run() loop", new Object[0]);
            this.mLocationModel.fetchPassengerLocation(PsgLocationDelegateImpl.this.f28596h, new IPsgLocationDataSource.PsgLocationCallback() {
                public void onSuccess(List<PassengerInfo> list) {
                    if (PsgLocationDelegateImpl.this.f28599k != null && PsgLocationDelegateImpl.this.f28593e) {
                        Message obtain = Message.obtain();
                        obtain.what = 900;
                        obtain.obj = list;
                        PsgLocationDelegateImpl.this.f28599k.sendMessage(obtain);
                    }
                }
            });
            if (PsgLocationDelegateImpl.this.f28599k != null) {
                PsgLocationDelegateImpl.this.f28599k.postDelayed(this, 3000);
            }
        }

        public void onMapVisible(boolean z) {
            IPsgLocationDataSource iPsgLocationDataSource = this.mLocationModel;
            if (iPsgLocationDataSource != null) {
                iPsgLocationDataSource.onMapVisible(z);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20202a(List<PassengerInfo> list) {
        for (PassengerInfo next : list) {
            if (next != null && next.getGpsLocation() != null) {
                GpsLocation gpsLocation = next.getGpsLocation();
                LatLng latLng = new LatLng(gpsLocation.latitude, gpsLocation.longitude);
                if (LatLngUtils.locateCorrect(latLng)) {
                    if (gpsLocation.accuracy >= 0 && gpsLocation.accuracy <= this.f28598j) {
                        LatLng latLng2 = this.f28595g;
                        if (latLng2 == null) {
                            break;
                        }
                        double computeDistanceBetween = DDSphericalUtil.computeDistanceBetween(latLng, latLng2);
                        if (computeDistanceBetween > 1000.0d) {
                            DLog.m7384d("sfs", "PsgLocationDelegateImpl updatePassengerMarkersCallback() passenger2StartDistance: " + computeDistanceBetween, new Object[0]);
                        } else {
                            List<PassengerInfo> list2 = this.f28596h;
                            if (list2 != null && !list2.isEmpty()) {
                                Iterator<PassengerInfo> it = this.f28596h.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    PassengerInfo next2 = it.next();
                                    if (next2.getPassengerId() == next.getPassengerId()) {
                                        if (next2.getGpsLocation() != null && next2.getGpsLocation().time < gpsLocation.time) {
                                            next2.setGpsLocation(gpsLocation);
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        DLog.m7384d("sfs", "PsgLocationDelegateImpl updatePassengerMarkersCallback() location.accuracy: " + gpsLocation.accuracy, new Object[0]);
                    }
                } else {
                    DLog.m7384d("sfs", "PsgLocationDelegateImpl updatePassengerMarkersCallback() passengerLatLng is not valid", new Object[0]);
                }
            } else {
                DLog.m7384d("sfs", "PsgLocationDelegateImpl updatePassengerMarkersCallback() passengerInfo == null || passengerInfo.getGpsLocation() == null", new Object[0]);
            }
        }
        PassengerLocationParam passengerLocationParam = this.f28597i;
        if (passengerLocationParam != null && passengerLocationParam.listener != null) {
            this.f28597i.listener.updatePassengerMarkers(this.f28596h);
        }
    }
}
