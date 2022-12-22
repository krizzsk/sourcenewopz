package com.didi.map.sdk.passengerlocation;

import android.content.Context;
import android.text.TextUtils;
import com.didi.common.map.model.GpsLocation;
import com.didi.common.map.util.DLog;
import com.didi.map.sdk.passengerlocation.IPsgLocationDataSource;
import com.didi.map.sdk.passengerlocation.http.IUserLocationCallback;
import com.didi.map.sdk.passengerlocation.http.UserLocationTask;
import com.didi.map.sdk.proto.driver_gl.UserInfo;
import com.didi.map.sdk.proto.driver_gl.UserLocation;
import com.didi.map.sdk.proto.driver_gl.UserLocationReq;
import com.didi.map.sdk.proto.driver_gl.UserLocationRes;
import java.util.ArrayList;
import java.util.List;

public class PsgLocationDataSource implements IPsgLocationDataSource {

    /* renamed from: a */
    private static final String f28583a = "PsgLocationDataSource";

    /* renamed from: b */
    private String f28584b;

    /* renamed from: c */
    private int f28585c;

    /* renamed from: d */
    private String f28586d;

    /* renamed from: e */
    private String f28587e;

    /* renamed from: f */
    private boolean f28588f = true;

    public PsgLocationDataSource(Context context) {
    }

    public void fetchPassengerLocation(final List<PassengerInfo> list, final IPsgLocationDataSource.PsgLocationCallback psgLocationCallback) {
        if (list == null || list.size() == 0) {
            DLog.m7384d(f28583a, "fetchPassengerLocation() passengerInfoList == null || passengerInfoList.size() == 0", new Object[0]);
        } else if (this.f28588f) {
            UserLocationReq a = m20200a(list);
            if (a == null) {
                DLog.m7384d("sfs", "PsgLocationDataSource fetchPassengerLocation UserLocationReq is null", new Object[0]);
                if (psgLocationCallback != null) {
                    psgLocationCallback.onSuccess(list);
                    return;
                }
                return;
            }
            new UserLocationTask(new IUserLocationCallback() {
                public void onStarted() {
                }

                public void onFinished(UserLocationRes userLocationRes, String str) {
                    DLog.m7384d("sfs", PsgLocationDataSource.f28583a + str, new Object[0]);
                    if (userLocationRes == null || userLocationRes.userLocations == null || userLocationRes.userLocations.size() <= 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("PsgLocationDataSource requestPassengerLocation onSuccess locRes == null || res.userLocations == null || res.userLocations.size() <= 0, msg: ");
                        sb.append(userLocationRes != null ? userLocationRes.msg : "null");
                        DLog.m7384d("sfs", sb.toString(), new Object[0]);
                        IPsgLocationDataSource.PsgLocationCallback psgLocationCallback = psgLocationCallback;
                        if (psgLocationCallback != null) {
                            psgLocationCallback.onSuccess(list);
                            return;
                        }
                        return;
                    }
                    for (PassengerInfo passengerInfo : list) {
                        for (UserLocation next : userLocationRes.userLocations) {
                            if (next.ret.intValue() == 0 && next.userLocation != null && next.userId != null && passengerInfo.getPassengerId() == next.userId.longValue()) {
                                DLog.m7384d(PsgLocationDataSource.f28583a, "requestPassengerLocation onSuccess foreach userLocation: " + next.toString(), new Object[0]);
                                GpsLocation gpsLocation = new GpsLocation();
                                gpsLocation.accuracy = next.accuracy != null ? next.accuracy.intValue() : -1;
                                gpsLocation.longitude = (double) next.userLocation.lng.floatValue();
                                gpsLocation.latitude = (double) next.userLocation.lat.floatValue();
                                gpsLocation.time = next.timestamp.longValue() * 1000;
                                gpsLocation.localTime = System.currentTimeMillis();
                                passengerInfo.setGpsLocation(gpsLocation);
                            }
                        }
                        DLog.m7384d("sfs", "PsgLocationDataSource requestPassengerLocation onSuccess", new Object[0]);
                    }
                    IPsgLocationDataSource.PsgLocationCallback psgLocationCallback2 = psgLocationCallback;
                    if (psgLocationCallback2 != null) {
                        psgLocationCallback2.onSuccess(list);
                    }
                }
            }).execute(new byte[][]{a.toByteArray()});
        }
    }

    /* renamed from: a */
    private UserLocationReq m20200a(List<PassengerInfo> list) {
        if (list == null || list.size() == 0) {
            DLog.m7384d(f28583a, "getUserLocationReq() passengerInfoList == null || passengerInfoList.size() == 0", new Object[0]);
            return null;
        }
        UserLocationReq.Builder builder = new UserLocationReq.Builder();
        ArrayList arrayList = new ArrayList();
        for (PassengerInfo next : list) {
            String orderId = next.getOrderId();
            long passengerId = next.getPassengerId();
            if (TextUtils.isEmpty(orderId) || passengerId <= 0) {
                DLog.m7384d("sfs", "PsgLocationDataSource getUserLocationReq() TextUtils.isEmpty(orderId) || passengerId <= 0", new Object[0]);
            } else {
                DLog.m7384d(f28583a, "getUserLocationReq() orderId: " + orderId + " passengerId: " + passengerId, new Object[0]);
                arrayList.add(new UserInfo(orderId, this.f28584b, Long.valueOf(passengerId), Integer.valueOf(this.f28585c)));
            }
        }
        if (arrayList.isEmpty()) {
            DLog.m7384d("sfs", "PsgLocationDataSource getUserLocationReq() userInfoList.isEmpty()", new Object[0]);
            return null;
        }
        builder.users(arrayList);
        builder.token(this.f28586d);
        builder.phoneNum(this.f28587e);
        return builder.build();
    }

    public void setTraverID(String str) {
        this.f28584b = str;
    }

    public void setBizType(int i) {
        this.f28585c = i;
    }

    public void setToken(String str) {
        this.f28586d = str;
    }

    public void setPhoneNum(String str) {
        this.f28587e = str;
    }

    public void onMapVisible(boolean z) {
        this.f28588f = z;
    }
}
