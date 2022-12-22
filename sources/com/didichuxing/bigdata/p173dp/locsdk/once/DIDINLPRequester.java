package com.didichuxing.bigdata.p173dp.locsdk.once;

import android.content.Context;
import android.location.Location;
import android.os.SystemClock;
import com.didichuxing.bigdata.p173dp.locsdk.Cgi;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DLog;
import com.didichuxing.bigdata.p173dp.locsdk.ErrInfo;
import com.didichuxing.bigdata.p173dp.locsdk.net.NetUtils;
import com.didichuxing.bigdata.p173dp.locsdk.ntp.TimeServiceManager;
import com.didichuxing.bigdata.p173dp.locsdk.ntp.TimeSource;
import com.didichuxing.bigdata.p173dp.locsdk.once.LocDataDef;
import com.didichuxing.bigdata.p173dp.locsdk.once.util.OmegaUtils;
import com.didichuxing.bigdata.p173dp.locsdk.trace.data.ETraceSource;
import com.didichuxing.request.ServerParam;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.once.DIDINLPRequester */
public class DIDINLPRequester {

    /* renamed from: f */
    private static volatile List<pre_didi_nlp_t> f46086f = new LinkedList();

    /* renamed from: a */
    LocationServiceRequest f46087a;

    /* renamed from: b */
    private Context f46088b;

    /* renamed from: c */
    private volatile DIDILocation f46089c = null;

    /* renamed from: d */
    private volatile long f46090d = 0;

    /* renamed from: e */
    private final String f46091e;

    public DIDINLPRequester(Context context) {
        this.f46088b = context;
        this.f46091e = Const.globalServerUrl;
    }

    /* renamed from: a */
    private NetUtils.HttpResponse m33109a(LocationServiceRequest locationServiceRequest) throws IOException {
        return sendRequest(locationServiceRequest.toJson());
    }

    public NetUtils.HttpResponse sendRequest(String str) throws IOException {
        byte[] bArr;
        DLog.m32737d("-DIDINetworkLocateProxy- req json: " + str);
        try {
            bArr = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            DLog.m32737d(e.toString());
            bArr = null;
        }
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    DLog.m32737d("-DIDINetworkLocateProxy- param len before compress : " + bArr.length);
                    byte[] encrypt = Const.encrypt(Const.getGZipCompressed(bArr), false);
                    if (encrypt != null && encrypt.length > 0) {
                        DLog.m32737d("-DIDINetworkLocateProxy- param len after compress : " + encrypt.length);
                        return m33110a(encrypt, 0);
                    }
                }
            } catch (OutOfMemoryError e2) {
                DLog.m32737d("sendRequest:" + e2.getClass().getSimpleName() + ": " + e2.getMessage());
            }
        }
        return null;
    }

    /* renamed from: a */
    private NetUtils.HttpResponse m33110a(byte[] bArr, long j) throws IOException {
        try {
            return NetUtils.post4(this.f46091e, bArr);
        } catch (Exception e) {
            if (e instanceof SocketTimeoutException) {
                int i = (int) j;
                if (i == 0) {
                    DLog.m32737d("-DIDINetworkLocateProxy- time out 1 time");
                    return m33110a(bArr, 1000);
                } else if (i == 1000) {
                    DLog.m32737d("-DIDINetworkLocateProxy- time out 2 times");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException unused) {
                        DLog.m32737d(e.toString());
                    }
                    return m33110a(bArr, -1);
                } else {
                    DLog.m32737d("-DIDINetworkLocateProxy- time out 4 times");
                    throw e;
                }
            } else {
                DLog.m32737d(e.toString());
                throw e;
            }
        }
    }

    public LocationServiceResponse requestNetworkLocation(ErrInfo errInfo) {
        LocationServiceResponse locationServiceResponse = null;
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            NetUtils.HttpResponse a = m33109a(this.f46087a);
            long elapsedRealtime2 = (SystemClock.elapsedRealtime() - elapsedRealtime) / 2;
            boolean isNTPAvailable = TimeServiceManager.getInstance().isNTPAvailable();
            long nTPCurrenTimeMillis = TimeServiceManager.getInstance().getNTPCurrenTimeMillis();
            if (a == null) {
                errInfo.setErrNo(305);
                errInfo.setErrMessage(ErrInfo.ERROR_MSG_HTTP_RESPONSE_NULL);
            } else {
                int i = a.httpRespCode;
                if (i == 200) {
                    String str = a.body;
                    if (str == null) {
                        errInfo.setErrNo(304);
                        errInfo.setErrMessage(ErrInfo.ERROR_MSG_HTTP_REQUEST_NO_LOCATION_RETURN);
                    } else {
                        locationServiceResponse = m33111a(str);
                        if (locationServiceResponse == null) {
                            errInfo.setErrNo(304);
                            errInfo.setErrMessage(ErrInfo.ERROR_MSG_HTTP_REQUEST_NO_LOCATION_RETURN);
                        } else {
                            if (locationServiceResponse.ret_code == 0 && locationServiceResponse.locations != null) {
                                if (locationServiceResponse.locations.size() != 0) {
                                    if (locationServiceResponse.timestamp > 0) {
                                        long j = (locationServiceResponse.timestamp * 1000) + elapsedRealtime2;
                                        if (isNTPAvailable) {
                                            OmegaUtils.trackNTPAndLocTimeDiff(ETraceSource.didi.toString(), nTPCurrenTimeMillis - j);
                                        }
                                        TimeServiceManager.getInstance().updateStandardTimeRef(TimeSource.HTTP, j);
                                    }
                                    m33112a(locationServiceResponse, elapsedRealtime);
                                }
                            }
                            errInfo.setErrNo(304);
                            errInfo.setErrMessage(ErrInfo.ERROR_MSG_HTTP_REQUEST_NO_LOCATION_RETURN);
                        }
                    }
                } else {
                    errInfo.setErrNo(302);
                    errInfo.setErrMessage(ErrInfo.ERROR_MSG_HTTP_REQUEST_NORMAL_ERR);
                    errInfo.setResponseCode(i);
                    errInfo.setResponseMessage("");
                }
            }
        } catch (IOException e) {
            errInfo.setErrNo(303);
            errInfo.setErrMessage("网络请求出现异常。");
            errInfo.setRequestExceptionMessage(e.getMessage());
            if (NetUtils.isNetWorkConnected(this.f46088b)) {
                HashMap hashMap = new HashMap();
                hashMap.put("sdk_ver", BuildConfig.VERSION_NAME);
                hashMap.put("exception", e.getMessage());
                hashMap.put(ServerParam.PARAM_NETWORK_TYPE, Integer.valueOf(Utils.getConnectedType(this.f46088b)));
                OmegaSDKAdapter.trackEvent("loc_request_exception", (Map<String, Object>) hashMap);
            }
        }
        return locationServiceResponse;
    }

    /* renamed from: a */
    private void m33112a(LocationServiceResponse locationServiceResponse, long j) {
        LocationServiceResponse locationServiceResponse2 = locationServiceResponse;
        if (locationServiceResponse2 != null && locationServiceResponse2.ret_code == 0 && locationServiceResponse2.locations != null && locationServiceResponse2.locations.size() > 0) {
            location_info_t location_info_t = locationServiceResponse2.locations.get(0);
            for (location_info_t next : locationServiceResponse2.locations) {
                if (next.confidence > location_info_t.confidence) {
                    location_info_t = next;
                }
            }
            pre_didi_nlp_t pre_didi_nlp_t = new pre_didi_nlp_t(location_info_t.lon_gcj, location_info_t.lat_gcj, (double) ((int) location_info_t.accuracy), location_info_t.confidence, j, locationServiceResponse.getCoordinateType());
            synchronized (f46086f) {
                int size = f46086f.size();
                if (size >= 5) {
                    f46086f.remove(size - 1);
                }
                f46086f.add(0, pre_didi_nlp_t);
            }
        }
    }

    /* renamed from: a */
    private LocationServiceResponse m33111a(String str) {
        if (str == null || str.length() <= 0) {
            DLog.m32737d("-DIDINetworkLocateProxy- response=null");
            return null;
        }
        DLog.m32737d("-DIDINetworkLocateProxy- response=" + str);
        return LocationServiceResponse.toObject(str);
    }

    public void updatePreLocationInfo(DIDILocation dIDILocation, long j) {
        this.f46089c = dIDILocation;
        this.f46090d = j;
    }

    public void prepareNewRequestData() {
        LocationServiceRequest locationServiceRequest = new LocationServiceRequest();
        this.f46087a = locationServiceRequest;
        locationServiceRequest.wifis = WifiManagerWrapper.getInstance().mo114730a(false);
        mo114677a();
        mo114678a(CellManager.getInstance(), this.f46087a);
        m33113b(this.f46087a);
        m33114b(CellManager.getInstance(), this.f46087a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo114677a() {
        CellManager instance = CellManager.getInstance();
        if (instance.cgiNeedUpdate(Utils.airPlaneModeOn(this.f46088b))) {
            instance.requestCgiLocationUpdate();
        }
        instance.refresh();
    }

    public void appendExtraGPSData(Location location) {
        if (location != null) {
            this.f46087a.gps.lon = location.getLongitude();
            this.f46087a.gps.lat = location.getLatitude();
            this.f46087a.gps.spd = (double) location.getSpeed();
            this.f46087a.gps.dir = (double) location.getBearing();
            this.f46087a.gps.f46142ts = location.getTime();
            this.f46087a.gps.acy = (double) location.getAccuracy();
        }
    }

    public void appendExtraOSNLPData(Location location) {
        if (location != null) {
            this.f46087a.sys_nlp.lon = location.getLongitude();
            this.f46087a.sys_nlp.lat = location.getLatitude();
            this.f46087a.sys_nlp.spd = (double) location.getSpeed();
            this.f46087a.sys_nlp.dir = (double) location.getBearing();
            this.f46087a.sys_nlp.f46146ts = location.getTime();
            this.f46087a.sys_nlp.acy = (double) location.getAccuracy();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo114679a(List<DIDILocation> list) {
        DIDINLPRequester dIDINLPRequester = this;
        if (list != null) {
            dIDINLPRequester.f46087a.pre_locations.clear();
            for (DIDILocation next : list) {
                List<pre_location_t> list2 = dIDINLPRequester.f46087a.pre_locations;
                pre_location_t pre_location_t = r4;
                pre_location_t pre_location_t2 = new pre_location_t(next.getLongitude(), next.getLatitude(), (double) next.getSpeed(), next.getTime(), (double) next.getAccuracy(), next.getSource());
                list2.add(pre_location_t);
                dIDINLPRequester = this;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo114678a(CellManager cellManager, LocationServiceRequest locationServiceRequest) {
        Context context = this.f46088b;
        if (context != null) {
            if (Utils.airPlaneModeOn(context)) {
                DLog.m32737d("air plane mode on");
                cellManager.reset();
            } else {
                cellManager.refineCellT();
            }
            List<Cgi> detectedCgiList = cellManager.getDetectedCgiList();
            Cgi lastDetectedCgiInfo = cellManager.getLastDetectedCgiInfo();
            if (detectedCgiList != null && !detectedCgiList.isEmpty()) {
                locationServiceRequest.cell.neighcells.clear();
                for (int i = 0; i < detectedCgiList.size(); i++) {
                    Cgi cgi = detectedCgiList.get(i);
                    if (cgi != null) {
                        LocDataDef.LocCellInfo locCellInfo = locationServiceRequest.cell;
                        if (locCellInfo.mnc_sid == 0 && locCellInfo.mcc == 0 && locCellInfo.cellid_bsid == 0 && locCellInfo.lac_nid == 0) {
                            locationServiceRequest.cell.mcc = Long.parseLong(cgi.mcc);
                            locationServiceRequest.cell.mnc_sid = Long.parseLong(cgi.mnc_sid);
                            locationServiceRequest.cell.lac_nid = (long) cgi.lac_nid;
                            locationServiceRequest.cell.cellid_bsid = (long) cgi.cid_bid;
                            locationServiceRequest.cell.rssi = (long) cgi.sig;
                            locationServiceRequest.cell.type = (long) cgi.type;
                        } else {
                            LocDataDef.LocNeighboringCellInfo locNeighboringCellInfo = new LocDataDef.LocNeighboringCellInfo();
                            locNeighboringCellInfo.lac = (long) cgi.lac_nid;
                            locNeighboringCellInfo.cid = (long) cgi.cid_bid;
                            locNeighboringCellInfo.rssi = (long) cgi.sig;
                            locationServiceRequest.cell.neighcells.add(locNeighboringCellInfo);
                        }
                    }
                }
                if (lastDetectedCgiInfo != null && lastDetectedCgiInfo.detectedTs != detectedCgiList.get(0).detectedTs) {
                    locationServiceRequest.cell.pre_cell.clear();
                    LocDataDef.LocPreCellInfo locPreCellInfo = new LocDataDef.LocPreCellInfo();
                    long currentTimeMillis = (System.currentTimeMillis() / 1000) - lastDetectedCgiInfo.detectedTs;
                    if (currentTimeMillis > 0 && currentTimeMillis <= 300) {
                        locPreCellInfo.mcc = Long.parseLong(lastDetectedCgiInfo.mcc);
                        locPreCellInfo.mnc_sid = Long.parseLong(lastDetectedCgiInfo.mnc_sid);
                        locPreCellInfo.lac_nid = (long) lastDetectedCgiInfo.lac_nid;
                        locPreCellInfo.cellid_bsid = (long) lastDetectedCgiInfo.cid_bid;
                        locPreCellInfo.type = (long) lastDetectedCgiInfo.type;
                        locPreCellInfo.f46107dt = currentTimeMillis;
                        locPreCellInfo.rssi = (long) lastDetectedCgiInfo.sig;
                        locationServiceRequest.cell.pre_cell.add(locPreCellInfo);
                    }
                }
            }
        }
    }

    /* renamed from: b */
    private void m33113b(LocationServiceRequest locationServiceRequest) {
        if (this.f46090d != 0 && this.f46089c != null) {
            locationServiceRequest.pre_gps.clear();
            long currentTimeMillis = (System.currentTimeMillis() / 1000) - this.f46090d;
            if (currentTimeMillis > 0 && currentTimeMillis <= 300) {
                pre_gps_t pre_gps_t = new pre_gps_t();
                pre_gps_t.f46144dt = currentTimeMillis;
                pre_gps_t.lon = this.f46089c.getLongitude();
                pre_gps_t.lat = this.f46089c.getLatitude();
                pre_gps_t.acy = (double) this.f46089c.getAccuracy();
                pre_gps_t.dir = (double) this.f46089c.getBearing();
                pre_gps_t.spd = (double) this.f46089c.getSpeed();
                locationServiceRequest.pre_gps.add(pre_gps_t);
            }
        }
    }

    /* renamed from: c */
    private void m33115c(LocationServiceRequest locationServiceRequest) {
        locationServiceRequest.pre_nlps.clear();
        long timeBoot = Utils.getTimeBoot();
        synchronized (f46086f) {
            if (f46086f.size() > 0) {
                for (pre_didi_nlp_t next : f46086f) {
                    long j = timeBoot - next.elapse_time;
                    if (j > 0 && j <= 120000) {
                        next.f46143dt = j;
                        locationServiceRequest.pre_nlps.add(next);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x011e A[Catch:{ SecurityException -> 0x0145 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0120 A[Catch:{ SecurityException -> 0x0145 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0123 A[Catch:{ SecurityException -> 0x0145 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x012e A[Catch:{ SecurityException -> 0x0145 }] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m33114b(com.didichuxing.bigdata.p173dp.locsdk.once.CellManager r7, com.didichuxing.bigdata.p173dp.locsdk.once.LocationServiceRequest r8) {
        /*
            r6 = this;
            android.content.Context r0 = r6.f46088b
            r1 = 0
            if (r0 == 0) goto L_0x014d
            if (r8 != 0) goto L_0x0009
            goto L_0x014d
        L_0x0009:
            com.didichuxing.bigdata.dp.locsdk.SensorMonitor r0 = com.didichuxing.bigdata.p173dp.locsdk.SensorMonitor.getInstance(r0)
            com.didichuxing.bigdata.dp.locsdk.once.user_sensors_info_t r2 = r8.user_sensors_info
            if (r2 == 0) goto L_0x0067
            com.didichuxing.bigdata.dp.locsdk.once.user_sensors_info_t r2 = r8.user_sensors_info
            long r3 = java.lang.System.currentTimeMillis()
            r2.timestamp = r3
            com.didichuxing.bigdata.dp.locsdk.once.user_sensors_info_t r2 = r8.user_sensors_info
            boolean r3 = r0.isWifiEnabled()
            r2.wifi_open_not = r3
            com.didichuxing.bigdata.dp.locsdk.once.user_sensors_info_t r2 = r8.user_sensors_info
            boolean r3 = r0.isWifiAllowScan()
            r2.wifi_scan_available = r3
            com.didichuxing.bigdata.dp.locsdk.once.user_sensors_info_t r2 = r8.user_sensors_info
            boolean r3 = r0.isGpsEnabled()
            r2.gps_open_not = r3
            com.didichuxing.bigdata.dp.locsdk.once.user_sensors_info_t r2 = r8.user_sensors_info
            android.content.Context r3 = r6.f46088b
            int r3 = com.didichuxing.bigdata.p173dp.locsdk.once.Utils.getConnectedType(r3)
            r2.connect_type = r3
            com.didichuxing.bigdata.dp.locsdk.once.user_sensors_info_t r2 = r8.user_sensors_info
            int r3 = r0.getAirPressure()
            r2.air_press = r3
            com.didichuxing.bigdata.dp.locsdk.once.user_sensors_info_t r2 = r8.user_sensors_info
            int r3 = r0.getLight()
            r2.light_value = r3
            com.didichuxing.bigdata.dp.locsdk.once.user_sensors_info_t r2 = r8.user_sensors_info
            int r0 = r0.getGpsFixedInterval()
            r2.gps_inter = r0
            com.didichuxing.bigdata.dp.locsdk.once.user_sensors_info_t r0 = r8.user_sensors_info
            android.content.Context r2 = r6.f46088b
            int r2 = com.didichuxing.bigdata.p173dp.locsdk.once.Utils.getLocationSwitchLevel(r2)
            r0.location_switch_level = r2
            com.didichuxing.bigdata.dp.locsdk.once.user_sensors_info_t r0 = r8.user_sensors_info
            android.content.Context r2 = r6.f46088b
            int r2 = com.didichuxing.bigdata.p173dp.locsdk.once.Utils.getLocationPermissionLevel(r2)
            r0.location_permission = r2
        L_0x0067:
            r6.m33115c(r8)
            com.didichuxing.bigdata.dp.locsdk.once.location_user_info_t r0 = r8.user_info     // Catch:{ SecurityException -> 0x0145 }
            if (r0 == 0) goto L_0x00d0
            com.didichuxing.bigdata.dp.locsdk.once.location_user_info_t r0 = r8.user_info     // Catch:{ SecurityException -> 0x0145 }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ SecurityException -> 0x0145 }
            r0.timestamp = r2     // Catch:{ SecurityException -> 0x0145 }
            com.didichuxing.bigdata.dp.locsdk.once.location_user_info_t r0 = r8.user_info     // Catch:{ SecurityException -> 0x0145 }
            java.lang.String r7 = r7.getDeviceId()     // Catch:{ SecurityException -> 0x0145 }
            r0.imei = r7     // Catch:{ SecurityException -> 0x0145 }
            com.didichuxing.bigdata.dp.locsdk.once.location_user_info_t r7 = r8.user_info     // Catch:{ SecurityException -> 0x0145 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ SecurityException -> 0x0145 }
            r0.<init>()     // Catch:{ SecurityException -> 0x0145 }
            java.lang.String r2 = android.os.Build.MODEL     // Catch:{ SecurityException -> 0x0145 }
            r0.append(r2)     // Catch:{ SecurityException -> 0x0145 }
            java.lang.String r2 = "/"
            r0.append(r2)     // Catch:{ SecurityException -> 0x0145 }
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ SecurityException -> 0x0145 }
            r0.append(r2)     // Catch:{ SecurityException -> 0x0145 }
            java.lang.String r0 = r0.toString()     // Catch:{ SecurityException -> 0x0145 }
            r7.modellevel = r0     // Catch:{ SecurityException -> 0x0145 }
            com.didichuxing.bigdata.dp.locsdk.once.location_user_info_t r7 = r8.user_info     // Catch:{ SecurityException -> 0x0145 }
            android.content.Context r0 = r6.f46088b     // Catch:{ SecurityException -> 0x0145 }
            com.didichuxing.bigdata.dp.locsdk.DIDILocationManager r0 = com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager.getInstance(r0)     // Catch:{ SecurityException -> 0x0145 }
            java.lang.String r0 = r0.getAppid()     // Catch:{ SecurityException -> 0x0145 }
            r7.app_id = r0     // Catch:{ SecurityException -> 0x0145 }
            com.didichuxing.bigdata.dp.locsdk.once.location_user_info_t r7 = r8.user_info     // Catch:{ SecurityException -> 0x0145 }
            android.content.Context r0 = r6.f46088b     // Catch:{ SecurityException -> 0x0145 }
            java.lang.String r0 = com.didichuxing.bigdata.p173dp.locsdk.utils.TraceUtils.getPhone(r0)     // Catch:{ SecurityException -> 0x0145 }
            r7.phone = r0     // Catch:{ SecurityException -> 0x0145 }
            com.didichuxing.bigdata.dp.locsdk.once.location_user_info_t r7 = r8.user_info     // Catch:{ SecurityException -> 0x0145 }
            android.content.Context r0 = r6.f46088b     // Catch:{ SecurityException -> 0x0145 }
            java.lang.String r0 = r0.getPackageName()     // Catch:{ SecurityException -> 0x0145 }
            r7.user_id = r0     // Catch:{ SecurityException -> 0x0145 }
            com.didichuxing.bigdata.dp.locsdk.once.location_user_info_t r7 = r8.user_info     // Catch:{ SecurityException -> 0x0145 }
            android.content.Context r0 = r6.f46088b     // Catch:{ SecurityException -> 0x0145 }
            java.lang.String r0 = com.didichuxing.bigdata.p173dp.locsdk.utils.TraceUtils.getUid(r0)     // Catch:{ SecurityException -> 0x0145 }
            r7.didi_uid = r0     // Catch:{ SecurityException -> 0x0145 }
            com.didichuxing.bigdata.dp.locsdk.once.location_user_info_t r7 = r8.user_info     // Catch:{ SecurityException -> 0x0145 }
            android.content.Context r0 = r6.f46088b     // Catch:{ SecurityException -> 0x0145 }
            java.lang.String r0 = com.didichuxing.bigdata.p173dp.locsdk.once.Utils.getSelfVersionName(r0)     // Catch:{ SecurityException -> 0x0145 }
            r7.app_version = r0     // Catch:{ SecurityException -> 0x0145 }
        L_0x00d0:
            java.lang.String r7 = "1.0.017"
            r8.sdk_version = r7     // Catch:{ SecurityException -> 0x0145 }
            double r2 = java.lang.Math.random()     // Catch:{ SecurityException -> 0x0145 }
            r4 = 4681608360884174848(0x40f86a0000000000, double:100000.0)
            double r2 = r2 * r4
            long r2 = (long) r2     // Catch:{ SecurityException -> 0x0145 }
            r8.trace_id = r2     // Catch:{ SecurityException -> 0x0145 }
            com.didichuxing.bigdata.dp.locsdk.once.ValidFlagEnum r7 = com.didichuxing.bigdata.p173dp.locsdk.once.ValidFlagEnum.invalid     // Catch:{ SecurityException -> 0x0145 }
            int r7 = r7.ordinal()     // Catch:{ SecurityException -> 0x0145 }
            long r2 = (long) r7     // Catch:{ SecurityException -> 0x0145 }
            r8.valid_flag = r2     // Catch:{ SecurityException -> 0x0145 }
            com.didichuxing.bigdata.dp.locsdk.once.LocDataDef$LocCellInfo r7 = r8.cell     // Catch:{ SecurityException -> 0x0145 }
            long r2 = r7.mcc     // Catch:{ SecurityException -> 0x0145 }
            r7 = 1
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x0111
            com.didichuxing.bigdata.dp.locsdk.once.LocDataDef$LocCellInfo r0 = r8.cell     // Catch:{ SecurityException -> 0x0145 }
            long r2 = r0.mnc_sid     // Catch:{ SecurityException -> 0x0145 }
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x0111
            com.didichuxing.bigdata.dp.locsdk.once.LocDataDef$LocCellInfo r0 = r8.cell     // Catch:{ SecurityException -> 0x0145 }
            long r2 = r0.lac_nid     // Catch:{ SecurityException -> 0x0145 }
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x0111
            com.didichuxing.bigdata.dp.locsdk.once.LocDataDef$LocCellInfo r0 = r8.cell     // Catch:{ SecurityException -> 0x0145 }
            long r2 = r0.cellid_bsid     // Catch:{ SecurityException -> 0x0145 }
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x010f
            goto L_0x0111
        L_0x010f:
            r0 = 0
            goto L_0x0112
        L_0x0111:
            r0 = 1
        L_0x0112:
            java.util.List<com.didichuxing.bigdata.dp.locsdk.once.LocDataDef$LocWifiInfo> r2 = r8.wifis     // Catch:{ SecurityException -> 0x0145 }
            if (r2 == 0) goto L_0x0120
            java.util.List<com.didichuxing.bigdata.dp.locsdk.once.LocDataDef$LocWifiInfo> r2 = r8.wifis     // Catch:{ SecurityException -> 0x0145 }
            int r2 = r2.size()     // Catch:{ SecurityException -> 0x0145 }
            if (r2 <= 0) goto L_0x0120
            r2 = 1
            goto L_0x0121
        L_0x0120:
            r2 = 0
        L_0x0121:
            if (r0 == 0) goto L_0x012c
            com.didichuxing.bigdata.dp.locsdk.once.ValidFlagEnum r3 = com.didichuxing.bigdata.p173dp.locsdk.once.ValidFlagEnum.cell     // Catch:{ SecurityException -> 0x0145 }
            int r3 = r3.ordinal()     // Catch:{ SecurityException -> 0x0145 }
            long r3 = (long) r3     // Catch:{ SecurityException -> 0x0145 }
            r8.valid_flag = r3     // Catch:{ SecurityException -> 0x0145 }
        L_0x012c:
            if (r2 == 0) goto L_0x0137
            com.didichuxing.bigdata.dp.locsdk.once.ValidFlagEnum r3 = com.didichuxing.bigdata.p173dp.locsdk.once.ValidFlagEnum.wifi     // Catch:{ SecurityException -> 0x0145 }
            int r3 = r3.ordinal()     // Catch:{ SecurityException -> 0x0145 }
            long r3 = (long) r3     // Catch:{ SecurityException -> 0x0145 }
            r8.valid_flag = r3     // Catch:{ SecurityException -> 0x0145 }
        L_0x0137:
            if (r0 == 0) goto L_0x0144
            if (r2 == 0) goto L_0x0144
            com.didichuxing.bigdata.dp.locsdk.once.ValidFlagEnum r0 = com.didichuxing.bigdata.p173dp.locsdk.once.ValidFlagEnum.mixed     // Catch:{ SecurityException -> 0x0145 }
            int r0 = r0.ordinal()     // Catch:{ SecurityException -> 0x0145 }
            long r2 = (long) r0     // Catch:{ SecurityException -> 0x0145 }
            r8.valid_flag = r2     // Catch:{ SecurityException -> 0x0145 }
        L_0x0144:
            return r7
        L_0x0145:
            r7 = move-exception
            java.lang.String r7 = r7.toString()
            com.didichuxing.bigdata.p173dp.locsdk.DLog.m32737d(r7)
        L_0x014d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.bigdata.p173dp.locsdk.once.DIDINLPRequester.m33114b(com.didichuxing.bigdata.dp.locsdk.once.CellManager, com.didichuxing.bigdata.dp.locsdk.once.LocationServiceRequest):boolean");
    }

    public LocationServiceRequest getRequestData() {
        return this.f46087a;
    }

    public Context getContext() {
        return this.f46088b;
    }
}
