package com.didi.hawaii.p118ar.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DLog;
import com.didi.hawaii.p118ar.core.ThemeManager;
import com.didi.hawaii.p118ar.core.modle.ARCoreSession;
import com.didi.hawaii.p118ar.core.modle.DiARNavViewCAResponseData;
import com.didi.hawaii.p118ar.jni.AREngineJNI;
import com.didi.hawaii.p118ar.jni.DARCAskRequest;
import com.didi.hawaii.p118ar.jni.DARCAskRequestWrap;
import com.didi.hawaii.p118ar.jni.DARCAskResponse;
import com.didi.hawaii.p118ar.jni.DARCAskResponseWrap;
import com.didi.hawaii.p118ar.jni.DARCGPSData;
import com.didi.hawaii.p118ar.jni.DARCGeoPoint;
import com.didi.hawaii.p118ar.jni.DARCHTTPRequest;
import com.didi.hawaii.p118ar.jni.DARCNaviType;
import com.didi.hawaii.p118ar.utils.ARRequestUtil;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.sidebar.history.HistoryRecordFragment;
import com.didi.sdk.util.SystemUtil;
import com.didi.sdk.util.Utils;
import com.google.p217ar.core.ArCoreApk;
import com.taxis99.R;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.didi.hawaii.ar.utils.ARCoreCheckerAndGenerator */
public class ARCoreCheckerAndGenerator {
    private static final int ARCoreCheck_Support = 1;
    private static final int ARCoreCheck_Unsupport = 0;
    public static final String TAG = ARCoreCheckerAndGenerator.class.getSimpleName();
    private static ARCoreSession arCoreSession = null;
    public static DiARNavViewCAResponseData cacheResponseData = new DiARNavViewCAResponseData();
    private static long checkTimeOut = ((long) ARAPollo.getCheckTimeOut());
    public static Handler handler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public static volatile boolean hasCallback = false;
    private static boolean installRequested;
    /* access modifiers changed from: private */
    public static boolean isSupportDirectionGuide = ARAPollo.getSupportDirectionGuide();
    private static HashSet<String> supportModles = ARAPollo.getOtherSupportModle();

    /* renamed from: com.didi.hawaii.ar.utils.ARCoreCheckerAndGenerator$CheckCallBack */
    public interface CheckCallBack {
        void onCheckSuccessOrNot(boolean z, int i, String str);
    }

    public static void checkAvailabilityWithRequestData(final Context context, final CheckOption checkOption, final CheckCallBack checkCallBack) {
        ARNavGlobal.NOT_IN_FENCE = context.getString(R.string.err_msg_not_in_fence);
        ARNavGlobal.LOWER_POWER = context.getString(R.string.err_msg_power_low);
        ARNavGlobal.NET_FAILED = context.getString(R.string.err_msg_net);
        ARNavGlobal.OTHER_FAILED = context.getString(R.string.err_msg_not_support);
        ARNavGlobal.GPS_ACC_NOT_SATISFY = context.getString(R.string.GRider_guide_Weak_satellite_RVle) + context.getString(R.string.zg_comma) + context.getString(R.string.GRider_guide_It_may_ozfW);
        if (!checkOption.isCanUse) {
            checkCallBack.onCheckSuccessOrNot(false, 4, ARNavGlobal.OTHER_FAILED);
            DLog.m7384d("checkAvailability", "option is can not use", new Object[0]);
            return;
        }
        handler.removeCallbacksAndMessages((Object) null);
        hasCallback = false;
        setAREngineLanuage(context, checkOption.scene);
        ARThreadPool.execute(new Runnable() {
            public void run() {
                ARRequestUtil.init(context);
                if (BatteryUtil.isCharging(context) || BatteryUtil.getCurBatteryPcn(context) >= ((float) ARNavGlobal.BATTERY_MOSTLOW_STATE)) {
                    AROmega.zgMapARNavPreNetWork(checkOption);
                    DARCAskRequest alloc = DARCAskRequest.alloc();
                    alloc.setUid(checkOption.getmUID());
                    alloc.setOsKind("android");
                    alloc.setOsVersion(SystemUtil.getVersion());
                    alloc.setAppId(AppUtil.getPackageName(context));
                    alloc.setAppVersion(AppUtil.getVersionName(context));
                    alloc.setAppName(AppUtil.getAppName(context));
                    alloc.setDeviceModel(Utils.getModel());
                    alloc.setOrderID(checkOption.orderID);
                    alloc.setScene(checkOption.scene);
                    DARCGeoPoint dARCGeoPoint = new DARCGeoPoint();
                    dARCGeoPoint.setLat(checkOption.getDestLocation().latitude);
                    dARCGeoPoint.setLon(checkOption.getDestLocation().longitude);
                    alloc.setDestGeoPt(dARCGeoPoint);
                    DARCGeoPoint dARCGeoPoint2 = new DARCGeoPoint();
                    dARCGeoPoint2.setLat(checkOption.curLocation.latitude);
                    dARCGeoPoint2.setLon(checkOption.curLocation.longitude);
                    DARCGPSData dARCGPSData = new DARCGPSData();
                    dARCGPSData.setLocation(dARCGeoPoint2);
                    dARCGPSData.setAltitude((double) checkOption.curAltitude);
                    dARCGPSData.setHorizontalAccuracy((double) checkOption.horizontalAccuracy);
                    dARCGPSData.setVerticalAccuracy((double) checkOption.verticalAccuracy);
                    alloc.setCurGPSData(dARCGPSData);
                    final DARCHTTPRequest createHttpRequest = DARCAskRequestWrap.createHttpRequest(alloc);
                    ARRequestUtil.doAsyncHttpTask(ARRequestUtil.convertDARCHTTPRequest2ARRequest(createHttpRequest), new ARRequestUtil.Callback() {
                        public void onSuccess(byte[] bArr) {
                            if (bArr == null || bArr.length <= 0) {
                                ARCoreCheckerAndGenerator.handleCheckResult(false, 3, ARNavGlobal.NET_FAILED, checkCallBack, 0);
                                return;
                            }
                            ARNavGlobal.parseResult(new String(bArr));
                            DARCAskResponse createAskResponse = DARCAskResponseWrap.createAskResponse(ARRequestUtil.convertData2DARCHttpResponse(bArr, createHttpRequest));
                            if (createAskResponse != null) {
                                DLog.m7384d(HistoryRecordFragment.COUNTRY_CODE_AR, "req errcode:" + createAskResponse.getErrorCode() + " isSupport:" + createAskResponse.getIsSupport() + " entranceType:" + createAskResponse.getEntranceType().swigValue(), new Object[0]);
                                ARNavGlobal.destSpotName = ThemeManager.getDestSpotName(checkOption.scene);
                                if (!TextUtils.isEmpty(createAskResponse.getDestName())) {
                                    ARNavGlobal.destSpotName = createAskResponse.getDestName();
                                }
                                if (createAskResponse.getIsSupport()) {
                                    if (!ARCoreCheckerAndGenerator.isSupportDirectionGuide && createAskResponse.getEntranceType() == DARCNaviType.DARCNaviTypeARDirection) {
                                        ARCoreCheckerAndGenerator.handleCheckResult(false, 1, ARNavGlobal.NOT_IN_FENCE, checkCallBack, 0);
                                        return;
                                    } else if ((ARCoreCheckerAndGenerator.checkAvailabilityOfArcoreExtend(context) & 1) == 0 && createAskResponse.getEntranceType() == DARCNaviType.DARCNaviTypeAR) {
                                        ARCoreCheckerAndGenerator.handleCheckResult(false, 4, ARNavGlobal.OTHER_FAILED, checkCallBack, 0);
                                        return;
                                    } else {
                                        if (checkOption.getDestLocation() != null) {
                                            DLog.m7384d("AR-Option", "dest:" + checkOption.getDestLocation().longitude + "," + checkOption.getDestLocation().latitude, new Object[0]);
                                        }
                                        if (checkOption.getCurLocation() != null) {
                                            DLog.m7384d("AR-Option", "cur:" + checkOption.getCurLocation().longitude + "," + checkOption.getCurLocation().latitude, new Object[0]);
                                        }
                                        ARCoreCheckerAndGenerator.cacheResponseData.setArRequestOption(checkOption);
                                        ARCoreCheckerAndGenerator.cacheResponseData.setcResData(createAskResponse);
                                        ARCoreCheckerAndGenerator.handleCheckResult(true, 1, ARNavGlobal.NOT_IN_FENCE, checkCallBack, 0);
                                        return;
                                    }
                                } else if (createAskResponse.getErrorCode() == 5) {
                                    ARCoreCheckerAndGenerator.handleCheckResult(false, createAskResponse.getErrorCode(), ARNavGlobal.GPS_ACC_NOT_SATISFY, checkCallBack, 0);
                                    return;
                                }
                            }
                            ARCoreCheckerAndGenerator.handleCheckResult(false, 1, ARNavGlobal.NOT_IN_FENCE, checkCallBack, 0);
                        }

                        public void onFailed(int i, Exception exc) {
                            if (exc != null) {
                                DLog.m7384d(HistoryRecordFragment.COUNTRY_CODE_AR, "req onFailed:" + exc.toString(), new Object[0]);
                            }
                            ARCoreCheckerAndGenerator.handleCheckResult(false, 3, ARNavGlobal.NET_FAILED, checkCallBack, 0);
                        }
                    });
                    return;
                }
                ARCoreCheckerAndGenerator.handleCheckResult(false, 2, ARNavGlobal.LOWER_POWER, checkCallBack, 0);
            }
        });
        handleCheckResult(false, 3, ARNavGlobal.NET_FAILED, checkCallBack, checkTimeOut);
    }

    public static Map<String, String> getARLogData() {
        DiARNavViewCAResponseData diARNavViewCAResponseData = cacheResponseData;
        if (diARNavViewCAResponseData == null || diARNavViewCAResponseData.getArRequestOption() == null || cacheResponseData.getcResData() == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("user_id", cacheResponseData.getArRequestOption().getmUID());
        hashMap.put("order_id", cacheResponseData.getArRequestOption().getOrderID());
        hashMap.put("session", cacheResponseData.getcResData().getSession());
        hashMap.put("model", cacheResponseData.getcResData().getModel());
        return hashMap;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void setAREngineLanuage(android.content.Context r3, int r4) {
        /*
            android.content.res.Resources r3 = r3.getResources()
            android.content.res.Configuration r3 = r3.getConfiguration()
            java.util.Locale r0 = r3.locale
            java.lang.String r0 = r0.getLanguage()
            java.util.Locale r3 = r3.locale
            java.lang.String r3 = r3.getCountry()
            com.didi.hawaii.ar.jni.DARCLanguage r1 = com.didi.hawaii.p118ar.jni.DARCLanguage.DARCLanguage_ChineseSimplified
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r3)
            java.lang.String r3 = r2.toString()
            int r0 = r3.hashCode()
            switch(r0) {
                case 3116701: goto L_0x006a;
                case 3117319: goto L_0x0060;
                case 3121559: goto L_0x0056;
                case 3121562: goto L_0x004c;
                case 3121881: goto L_0x0042;
                case 3253437: goto L_0x0038;
                case 3450196: goto L_0x002d;
                default: goto L_0x002c;
            }
        L_0x002c:
            goto L_0x0074
        L_0x002d:
            java.lang.String r0 = "ptBR"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0074
            r3 = 3
            goto L_0x0075
        L_0x0038:
            java.lang.String r0 = "jaJP"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0074
            r3 = 6
            goto L_0x0075
        L_0x0042:
            java.lang.String r0 = "esMX"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0074
            r3 = 0
            goto L_0x0075
        L_0x004c:
            java.lang.String r0 = "esCO"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0074
            r3 = 2
            goto L_0x0075
        L_0x0056:
            java.lang.String r0 = "esCL"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0074
            r3 = 1
            goto L_0x0075
        L_0x0060:
            java.lang.String r0 = "enUS"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0074
            r3 = 5
            goto L_0x0075
        L_0x006a:
            java.lang.String r0 = "enAU"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0074
            r3 = 4
            goto L_0x0075
        L_0x0074:
            r3 = -1
        L_0x0075:
            switch(r3) {
                case 0: goto L_0x008b;
                case 1: goto L_0x0088;
                case 2: goto L_0x0085;
                case 3: goto L_0x0082;
                case 4: goto L_0x007f;
                case 5: goto L_0x007c;
                case 6: goto L_0x0079;
                default: goto L_0x0078;
            }
        L_0x0078:
            goto L_0x008d
        L_0x0079:
            com.didi.hawaii.ar.jni.DARCLanguage r1 = com.didi.hawaii.p118ar.jni.DARCLanguage.DARCLanguage_Japanese
            goto L_0x008d
        L_0x007c:
            com.didi.hawaii.ar.jni.DARCLanguage r1 = com.didi.hawaii.p118ar.jni.DARCLanguage.DARCLanguage_EnglishUS
            goto L_0x008d
        L_0x007f:
            com.didi.hawaii.ar.jni.DARCLanguage r1 = com.didi.hawaii.p118ar.jni.DARCLanguage.DARCLanguage_EnglishAustralia
            goto L_0x008d
        L_0x0082:
            com.didi.hawaii.ar.jni.DARCLanguage r1 = com.didi.hawaii.p118ar.jni.DARCLanguage.DARCLanguage_Portuguese
            goto L_0x008d
        L_0x0085:
            com.didi.hawaii.ar.jni.DARCLanguage r1 = com.didi.hawaii.p118ar.jni.DARCLanguage.DARCLanguage_SpanishColombia
            goto L_0x008d
        L_0x0088:
            com.didi.hawaii.ar.jni.DARCLanguage r1 = com.didi.hawaii.p118ar.jni.DARCLanguage.DARCLanguage_SpanishChile
            goto L_0x008d
        L_0x008b:
            com.didi.hawaii.ar.jni.DARCLanguage r1 = com.didi.hawaii.p118ar.jni.DARCLanguage.DARCLanguage_SpanishMexico
        L_0x008d:
            com.didi.hawaii.p118ar.jni.AREngineJNI.languageSet(r1, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.p118ar.utils.ARCoreCheckerAndGenerator.setAREngineLanuage(android.content.Context, int):void");
    }

    /* access modifiers changed from: private */
    public static void handleCheckResult(final boolean z, final int i, final String str, final CheckCallBack checkCallBack, long j) {
        DLog.m7384d(HistoryRecordFragment.COUNTRY_CODE_AR, "handleCheckResult suc:" + z + " errcode:" + i + " failReason:" + str, new Object[0]);
        if (j == 0) {
            handler.post(new Runnable() {
                public void run() {
                    if (!ARCoreCheckerAndGenerator.hasCallback) {
                        checkCallBack.onCheckSuccessOrNot(z, i, str);
                        boolean unused = ARCoreCheckerAndGenerator.hasCallback = true;
                    }
                }
            });
        } else {
            handler.postDelayed(new Runnable() {
                public void run() {
                    if (!ARCoreCheckerAndGenerator.hasCallback) {
                        checkCallBack.onCheckSuccessOrNot(z, i, str);
                        boolean unused = ARCoreCheckerAndGenerator.hasCallback = true;
                    }
                }
            }, j);
        }
    }

    public static boolean checkAvailabilityOfArcore(Context context) {
        String model = Utils.getModel();
        if (supportModles.size() == 0 || TextUtils.isEmpty(model) || !supportModles.contains(model) || C89074.$SwitchMap$com$google$ar$core$ArCoreApk$Availability[ArCoreApk.getInstance().checkAvailability(context).ordinal()] != 1) {
            return false;
        }
        return true;
    }

    /* renamed from: com.didi.hawaii.ar.utils.ARCoreCheckerAndGenerator$4 */
    static /* synthetic */ class C89074 {
        static final /* synthetic */ int[] $SwitchMap$com$google$ar$core$ArCoreApk$Availability;

        static {
            int[] iArr = new int[ArCoreApk.Availability.values().length];
            $SwitchMap$com$google$ar$core$ArCoreApk$Availability = iArr;
            try {
                iArr[ArCoreApk.Availability.SUPPORTED_INSTALLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static int checkAvailabilityOfArcoreExtend(Context context) {
        int i = 0;
        DLog.m7384d(HistoryRecordFragment.COUNTRY_CODE_AR, "checkAvailabilityOfArcoreExtend:true", new Object[0]);
        String model = Utils.getModel();
        int i2 = (supportModles.size() == 0 || TextUtils.isEmpty(model) || !supportModles.contains(model)) ? 0 : 1;
        Iterator<String> it = supportModles.iterator();
        String str = "";
        while (it.hasNext()) {
            str = str + it.next() + ";";
        }
        DLog.m7384d(HistoryRecordFragment.COUNTRY_CODE_AR, "checkAvailabilityOfArcoreExtend Modle:" + model + " list:" + str + " support:" + i2, new Object[0]);
        if (i2 <= 0) {
            i = i2;
        } else if (C89074.$SwitchMap$com$google$ar$core$ArCoreApk$Availability[ArCoreApk.getInstance().checkAvailability(context).ordinal()] == 1) {
            DLog.m7384d(HistoryRecordFragment.COUNTRY_CODE_AR, "checkAvailabilityOfArcoreExtend:SUPPORTED_INSTALLED", new Object[0]);
            i = 1;
        }
        return ((isSupportDirectionGuide ? 1 : 0) << true) | i;
    }

    public static void clearCache() {
        SystemUtils.log(4, "zgdebug", "clearCache", (Throwable) null, "com.didi.hawaii.ar.utils.ARCoreCheckerAndGenerator", 347);
        cacheResponseData.setArRequestOption((CheckOption) null);
        cacheResponseData.setcResData((DARCAskResponse) null);
    }

    /* renamed from: com.didi.hawaii.ar.utils.ARCoreCheckerAndGenerator$CheckOption */
    public static class CheckOption {
        /* access modifiers changed from: private */
        public float curAltitude;
        /* access modifiers changed from: private */
        public LatLng curLocation;
        private LatLng destLocation;
        /* access modifiers changed from: private */
        public float horizontalAccuracy;
        /* access modifiers changed from: private */
        public boolean isCanUse = true;
        private String mUID;
        /* access modifiers changed from: private */
        public String orderID;
        /* access modifiers changed from: private */
        public int scene = 0;
        private int source = 0;
        private boolean useDevEnv = false;
        /* access modifiers changed from: private */
        public float verticalAccuracy;

        public int getScene() {
            return this.scene;
        }

        /* access modifiers changed from: private */
        public void setScene(int i) {
            this.scene = i;
        }

        public int getSource() {
            return this.source;
        }

        /* access modifiers changed from: private */
        public void setSource(int i) {
            this.source = i;
        }

        public String getmUID() {
            return this.mUID;
        }

        public void setmUID(String str) {
            this.mUID = str;
        }

        /* access modifiers changed from: private */
        public void setOrderID(String str) {
            this.orderID = str;
        }

        /* access modifiers changed from: private */
        public void setDestLocation(LatLng latLng) {
            this.destLocation = latLng;
        }

        /* access modifiers changed from: private */
        public void setCurLocation(LatLng latLng) {
            this.curLocation = latLng;
        }

        /* access modifiers changed from: private */
        public void setCurAltitude(float f) {
            this.curAltitude = f;
        }

        /* access modifiers changed from: private */
        public void setVerticalAccuracy(float f) {
            this.verticalAccuracy = f;
        }

        /* access modifiers changed from: private */
        public void setHorizontalAccuracy(float f) {
            this.horizontalAccuracy = f;
        }

        public String getOrderID() {
            return this.orderID;
        }

        public LatLng getDestLocation() {
            return this.destLocation;
        }

        public LatLng getCurLocation() {
            return this.curLocation;
        }

        public float getCurAltitude() {
            return this.curAltitude;
        }

        public float getVerticalAccuracy() {
            return this.verticalAccuracy;
        }

        public float getHorizontalAccuracy() {
            return this.horizontalAccuracy;
        }

        public boolean isUseDevEnv() {
            return this.useDevEnv;
        }

        /* access modifiers changed from: private */
        public void setUseDevEnv(boolean z) {
            this.useDevEnv = z;
        }

        /* renamed from: com.didi.hawaii.ar.utils.ARCoreCheckerAndGenerator$CheckOption$CheckOptionBuilder */
        public static class CheckOptionBuilder {
            public static final int SCENE_BUS = 1;
            public static final int SCENE_TAXI = 0;
            public static final int SOURCE_CLICK = 1;
            public static final int SOURCE_SHOW_ENTRANCE = 0;
            private CheckOption option = new CheckOption();

            public CheckOptionBuilder setOrderId(String str) {
                if (TextUtils.isEmpty(str)) {
                    boolean unused = this.option.isCanUse = false;
                    return this;
                }
                this.option.setOrderID(str);
                return this;
            }

            public CheckOptionBuilder setDestLocation(LatLng latLng) {
                if (latLng == null) {
                    boolean unused = this.option.isCanUse = false;
                    return this;
                }
                DLog.m7384d("AR-SetOpition", "destLoc:" + latLng.longitude + "," + latLng.latitude, new Object[0]);
                this.option.setDestLocation(latLng);
                return this;
            }

            public CheckOptionBuilder setCurLocation(LatLng latLng) {
                if (latLng == null) {
                    boolean unused = this.option.isCanUse = false;
                    return this;
                }
                DLog.m7384d("AR-SetOpition", "curLoc:" + latLng.longitude + "," + latLng.latitude, new Object[0]);
                this.option.setCurLocation(latLng);
                return this;
            }

            public CheckOptionBuilder setCurAltitude(float f) {
                this.option.setCurAltitude(f);
                return this;
            }

            public CheckOptionBuilder setVerticalAccuracy(float f) {
                this.option.setVerticalAccuracy(f);
                return this;
            }

            public CheckOptionBuilder setHorizontalAccuracy(float f) {
                DLog.m7384d("AR-SetOpition", "horizontalAccuracy:" + f, new Object[0]);
                this.option.setHorizontalAccuracy(f);
                return this;
            }

            @Deprecated
            public CheckOptionBuilder setUseDevEnv(boolean z) {
                this.option.setUseDevEnv(z);
                return this;
            }

            public CheckOptionBuilder setUID(String str) {
                if (TextUtils.isEmpty(str)) {
                    boolean unused = this.option.isCanUse = false;
                    return this;
                }
                this.option.setmUID(AREngineJNI.encryptStringWrap(str, str.length()));
                return this;
            }

            public CheckOptionBuilder setScene(int i) {
                this.option.setScene(i);
                return this;
            }

            public CheckOptionBuilder setSource(int i) {
                this.option.setSource(i);
                return this;
            }

            public CheckOption build() {
                return this.option;
            }
        }
    }
}
