package com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.utils.Utils;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.FilterJumpGPSStrategyInterceptor */
public class FilterJumpGPSStrategyInterceptor implements C15138e<Location> {

    /* renamed from: c */
    private static volatile FilterJumpGPSStrategyInterceptor f45798c;

    /* renamed from: a */
    DIDILocation f45799a = null;

    /* renamed from: b */
    private boolean f45800b = false;

    public static FilterJumpGPSStrategyInterceptor getInstance(Context context) {
        if (f45798c == null) {
            synchronized (FilterJumpGPSStrategyInterceptor.class) {
                if (f45798c == null) {
                    f45798c = new FilterJumpGPSStrategyInterceptor(context);
                }
            }
        }
        return f45798c;
    }

    private FilterJumpGPSStrategyInterceptor(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(LocationStorage.ACTION_UPDATE_CURRENT_LOCATION);
        LocalBroadcastManager.getInstance(context).registerReceiver(new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                DIDILocation dIDILocation = (DIDILocation) intent.getSerializableExtra(LocationStorage.INTENT_EXTRA_DATA_LOCATION);
                String provider = dIDILocation.getProvider();
                if ("gps".equals(provider) || DIDILocation.WIFI_PROVIDER.equals(provider) || (DIDILocation.NLP_PROVIDER.equals(provider) && Float.compare(dIDILocation.getAccuracy(), 100.0f) < 0)) {
                    FilterJumpGPSStrategyInterceptor.this.f45799a = dIDILocation;
                }
            }
        }, intentFilter);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00a2, code lost:
        if (java.lang.Double.compare(r8, (double) r0[1]) > 0) goto L_0x00c0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0108  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.location.Location intercept(android.location.Location r13) {
        /*
            r12 = this;
            if (r13 != 0) goto L_0x0003
            return r13
        L_0x0003:
            com.didichuxing.bigdata.dp.locsdk.utils.ApolloProxy r0 = com.didichuxing.bigdata.p173dp.locsdk.utils.ApolloProxy.getInstance()
            long[] r0 = r0.requestFilterGPSParams()
            boolean r1 = r12.f45800b
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x002c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = "[filter gps]apollo:"
            r1.append(r4)
            if (r0 == 0) goto L_0x001f
            r4 = 1
            goto L_0x0020
        L_0x001f:
            r4 = 0
        L_0x0020:
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            com.didichuxing.bigdata.p173dp.locsdk.DLog.m32737d(r1)
            r12.f45800b = r2
        L_0x002c:
            if (r0 != 0) goto L_0x002f
            return r13
        L_0x002f:
            com.didichuxing.bigdata.dp.locsdk.ntp.TimeServiceManager r1 = com.didichuxing.bigdata.p173dp.locsdk.ntp.TimeServiceManager.getInstance()
            boolean r1 = r1.isNTPAvailable()
            if (r1 != 0) goto L_0x0056
            com.didichuxing.bigdata.dp.locsdk.ntp.TimeServiceManager r0 = com.didichuxing.bigdata.p173dp.locsdk.ntp.TimeServiceManager.getInstance()
            boolean r0 = r0.isNTPEnabled()
            if (r0 == 0) goto L_0x0055
            com.didichuxing.omega.sdk.common.record.Event r0 = new com.didichuxing.omega.sdk.common.record.Event
            java.lang.String r1 = "ntp_time_diff0"
            r0.<init>(r1)
            r0.putNetType()
            com.didiglobal.omegasdkadapter.OmegaSDKAdapter.trackEvent((com.didichuxing.omega.sdk.common.record.Event) r0)
            java.lang.String r0 = "[filter gps]:ts ntp time diff 0"
            com.didichuxing.bigdata.p173dp.locsdk.DLog.m32737d(r0)
        L_0x0055:
            return r13
        L_0x0056:
            com.didichuxing.bigdata.dp.locsdk.ntp.TimeServiceManager r1 = com.didichuxing.bigdata.p173dp.locsdk.ntp.TimeServiceManager.getInstance()
            long r4 = r1.getNTPCurrenTimeMillis()
            long r6 = r13.getTime()
            long r6 = r6 - r4
            long r4 = java.lang.Math.abs(r6)
            r8 = 600000(0x927c0, double:2.964394E-318)
            int r1 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r1 <= 0) goto L_0x0144
            r4 = r0[r3]
            r1 = 0
            int r8 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r8 <= 0) goto L_0x00bf
            com.didichuxing.bigdata.dp.locsdk.DIDILocation r4 = r12.f45799a
            java.lang.String r5 = "[filter gps][exceeded"
            if (r4 == 0) goto L_0x00a5
            double r8 = r12.m32816a(r4, r13)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r5)
            r10 = r0[r3]
            r4.append(r10)
            java.lang.String r3 = "]:speed is:"
            r4.append(r3)
            r4.append(r8)
            java.lang.String r3 = r4.toString()
            com.didichuxing.bigdata.p173dp.locsdk.DLog.m32737d(r3)
            r2 = r0[r2]
            double r2 = (double) r2
            int r0 = java.lang.Double.compare(r8, r2)
            if (r0 <= 0) goto L_0x00bf
            goto L_0x00c0
        L_0x00a5:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r5)
            r3 = r0[r3]
            r2.append(r3)
            java.lang.String r0 = "]:last loc null"
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.didichuxing.bigdata.p173dp.locsdk.DLog.m32737d(r0)
            goto L_0x00c0
        L_0x00bf:
            r1 = r13
        L_0x00c0:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.Long r2 = java.lang.Long.valueOf(r6)
            java.lang.String r3 = "diff_time"
            r0.put(r3, r2)
            com.didichuxing.bigdata.dp.locsdk.DIDILocation r2 = r12.f45799a
            double r2 = r12.m32816a(r2, r13)
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
            java.lang.String r3 = "speed"
            r0.put(r3, r2)
            double r2 = r13.getLatitude()
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
            java.lang.String r3 = "gpsloc_lat"
            r0.put(r3, r2)
            double r2 = r13.getLongitude()
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
            java.lang.String r3 = "gpsloc_lng"
            r0.put(r3, r2)
            float r13 = r13.getAccuracy()
            java.lang.Float r13 = java.lang.Float.valueOf(r13)
            java.lang.String r2 = "gpsloc_acc"
            r0.put(r2, r13)
            com.didichuxing.bigdata.dp.locsdk.DIDILocation r13 = r12.f45799a
            if (r13 == 0) goto L_0x013e
            double r2 = r13.getLongitude()
            java.lang.Double r13 = java.lang.Double.valueOf(r2)
            java.lang.String r2 = "lastloc_lng"
            r0.put(r2, r13)
            com.didichuxing.bigdata.dp.locsdk.DIDILocation r13 = r12.f45799a
            double r2 = r13.getLatitude()
            java.lang.Double r13 = java.lang.Double.valueOf(r2)
            java.lang.String r2 = "lastloc_lat"
            r0.put(r2, r13)
            com.didichuxing.bigdata.dp.locsdk.DIDILocation r13 = r12.f45799a
            float r13 = r13.getAccuracy()
            java.lang.Float r13 = java.lang.Float.valueOf(r13)
            java.lang.String r2 = "lastloc_acc"
            r0.put(r2, r13)
            com.didichuxing.bigdata.dp.locsdk.DIDILocation r13 = r12.f45799a
            java.lang.String r13 = r13.getProvider()
            java.lang.String r2 = "lastloc_pvd"
            r0.put(r2, r13)
        L_0x013e:
            java.lang.String r13 = "gps_time_diff_more_10min"
            com.didiglobal.omegasdkadapter.OmegaSDKAdapter.trackEvent((java.lang.String) r13, (java.util.Map<java.lang.String, java.lang.Object>) r0)
            r13 = r1
        L_0x0144:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3.FilterJumpGPSStrategyInterceptor.intercept(android.location.Location):android.location.Location");
    }

    /* renamed from: a */
    private double m32816a(DIDILocation dIDILocation, Location location) {
        DIDILocation convert2DidiLocation;
        if (dIDILocation == null || location == null || (convert2DidiLocation = DIDILocation.convert2DidiLocation(location, "gps", dIDILocation.getCoordinateType(), System.currentTimeMillis())) == null) {
            return -1.0d;
        }
        return DIDILocation.distanceBetween(dIDILocation.getLongitude(), dIDILocation.getLatitude(), convert2DidiLocation.getLongitude(), convert2DidiLocation.getLatitude()) / ((double) ((Utils.getTimeBoot() - dIDILocation.getElapsedRealtime()) / 1000));
    }
}
