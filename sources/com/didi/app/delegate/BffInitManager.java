package com.didi.app.delegate;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.android.didi.bfflib.Bff;
import com.didi.map.global.component.slideCars.api.ServerParamConstant;
import com.didi.sdk.component.protocol.ComponentLoadUtil;
import com.didi.sdk.component.protocol.IA3Manager;
import com.didi.sdk.idfa.IDFAManager;
import com.didi.sdk.misconfig.p153v2.ConfProxy;
import com.didi.sdk.nation.NationComponentData;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.push.ServerParam;
import com.didi.sdk.security.SecurityUtil;
import com.didi.sdk.util.AppUtils;
import com.didi.sdk.util.MixFlagUtil;
import com.didi.sdk.util.SystemUtil;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BffInitManager {

    /* renamed from: a */
    private static String f8239a;

    /* renamed from: b */
    private static String f8240b;

    /* renamed from: a */
    static void m5373a(final Application application) {
        Bff.getBffConfig().setCommonParamsGenerator(new Bff.BffConfig.CommonParamGenerator() {
            public Map<String, Object> generateParams() {
                int i;
                HashMap hashMap = new HashMap();
                hashMap.put("ticket", NationTypeUtil.getNationComponentData().getLoginInfo().getToken());
                StringBuilder sb = new StringBuilder();
                sb.append(SystemUtil.getVersionName(application));
                String str = "";
                sb.append(str);
                hashMap.put("app_version", sb.toString());
                int i2 = -1;
                try {
                    i = Integer.parseInt(AppUtils.getMetaDataByKey("terminal_id"));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    i = -1;
                }
                hashMap.put("terminal_id", Integer.valueOf(i));
                try {
                    i2 = Integer.parseInt(NationTypeUtil.getNationComponentData().getOriginID());
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
                hashMap.put("origin_id", Integer.valueOf(i2));
                DIDILocation didiLocation = NationTypeUtil.getNationComponentData().getDidiLocation();
                if (didiLocation != null) {
                    hashMap.put("lat", Double.valueOf(didiLocation.getLatitude()));
                    hashMap.put("lng", Double.valueOf(didiLocation.getLongitude()));
                }
                int productId = BffInitManager.getProductId(ConfProxy.getInstance().getSelectedType());
                if (productId != 0) {
                    hashMap.put("product_id", Integer.valueOf(productId));
                }
                NationComponentData nationComponentData = NationTypeUtil.getNationComponentData();
                String localeCode = nationComponentData.getLocaleCode();
                hashMap.put("utc_offset", Integer.valueOf(nationComponentData.getTimeZoneUtcOffset()));
                hashMap.put("lang", localeCode);
                hashMap.put("city_id", Integer.valueOf(Integer.parseInt(NationTypeUtil.getNationComponentData().getCityId())));
                hashMap.put("location_cityid", Integer.valueOf(Integer.parseInt(NationTypeUtil.getNationComponentData().getCityId())));
                if (!(NationTypeUtil.getNationComponentData() == null || NationTypeUtil.getNationComponentData().getLocCountry() == null)) {
                    str = NationTypeUtil.getNationComponentData().getLocCountry();
                }
                hashMap.put("location_country", str);
                hashMap.put("map_type", "wgs84");
                hashMap.put("datatype", "1");
                hashMap.put("data_type", "android");
                hashMap.put("networkType", SystemUtil.getNetworkType());
                hashMap.put("client_type", 1);
                int i3 = 0;
                try {
                    i3 = Integer.parseInt(SystemUtil.getChannelId());
                } catch (NumberFormatException e3) {
                    e3.printStackTrace();
                }
                hashMap.put("channel", Integer.valueOf(i3));
                String a = BffInitManager.m5374b(application);
                if (!TextUtils.isEmpty(a)) {
                    hashMap.put(ServerParamConstant.KEY_A3_TOKEN, a);
                }
                HashMap hashMap2 = new HashMap();
                hashMap2.put("uuid", SecurityUtil.getUUID());
                hashMap2.put("suuid", SecurityUtil.getSUUID());
                hashMap2.put("idfa", IDFAManager.getIdfa(application, (IDFAManager.onIDFAChangeListener) null));
                hashMap2.put("imei", SystemUtil.getIMEI());
                hashMap2.put("imsi", SystemUtil.getIMSI());
                hashMap2.put("pixels", BffInitManager.getScreenPixels());
                hashMap2.put(ParamKeys.PARAM_ICCID, BffInitManager.getSimSerialNumber(application));
                hashMap2.put(ParamKeys.PARAM_SDCARD_ID, BffInitManager.getSDCardId());
                hashMap2.put("model", SystemUtil.getModel());
                hashMap2.put("brand", Build.BRAND);
                hashMap2.put("os", Build.VERSION.RELEASE);
                hashMap2.put("deviceid", SecurityUtil.getDeviceId());
                hashMap2.put(ServerParam.PARAM_DDRIVER_OSTYPE, "android");
                hashMap2.put("osVersion", Build.VERSION.RELEASE);
                hashMap.put(DeviceRequestsHelper.DEVICE_INFO_PARAM, hashMap2);
                hashMap.put("platform_type", 2);
                hashMap.put("biz_type", 1);
                hashMap.put("mix_flag", Integer.valueOf(MixFlagUtil.getMixFlag(application)));
                return hashMap;
            }
        });
        Bff.getBffConfig().setHostAddr("https://api.didiglobal.com/");
    }

    public static int getProductId(String str) {
        Iterator<S> it = ServiceLoader.load(IBusinessParamsService.class).iterator();
        while (it.hasNext()) {
            IBusinessParamsService iBusinessParamsService = (IBusinessParamsService) it.next();
            ServiceProvider serviceProvider = (ServiceProvider) iBusinessParamsService.getClass().getAnnotation(ServiceProvider.class);
            if (serviceProvider != null && str.equals(serviceProvider.alias())) {
                return iBusinessParamsService.getProductId();
            }
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static String m5374b(Context context) {
        IA3Manager iA3Manager = (IA3Manager) ComponentLoadUtil.getComponent(IA3Manager.class);
        return iA3Manager != null ? iA3Manager.getToken(context) : "";
    }

    public static String getScreenPixels() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(SystemUtil.getScreenWidth());
        stringBuffer.append("*");
        stringBuffer.append(SystemUtil.getScreenHeight());
        return stringBuffer.toString();
    }

    public static String getSimSerialNumber(Context context) {
        if (!TextUtils.isEmpty(f8239a)) {
            return f8239a;
        }
        try {
            String simSerialNumber = ((TelephonyManager) context.getSystemService("phone")).getSimSerialNumber();
            f8239a = simSerialNumber;
            return simSerialNumber;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getSDCardId() {
        if (!TextUtils.isEmpty(f8240b)) {
            return f8240b;
        }
        String str = "/sys/block/mmcblk%s/device/" + "type";
        String str2 = "/sys/block/mmcblk%s/device/" + "cid";
        int i = 0;
        while (true) {
            if (i >= 5) {
                break;
            }
            String a = m5372a(String.format(str, new Object[]{Integer.valueOf(i)}));
            if (!TextUtils.isEmpty(a) && (a.equalsIgnoreCase("mmc") || !a.equalsIgnoreCase("sd"))) {
                String a2 = m5372a(String.format(str2, new Object[]{Integer.valueOf(i)}));
                if (!TextUtils.isEmpty(a2)) {
                    f8240b = a2;
                    break;
                }
            }
            i++;
        }
        return f8240b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0040 A[SYNTHETIC, Splitter:B:22:0x0040] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x004d A[SYNTHETIC, Splitter:B:30:0x004d] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m5372a(java.lang.String r3) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r3)
            boolean r3 = r0.exists()
            r1 = 0
            if (r3 == 0) goto L_0x0056
            boolean r3 = r0.isFile()
            if (r3 == 0) goto L_0x0056
            boolean r3 = r0.canRead()
            if (r3 != 0) goto L_0x0019
            goto L_0x0056
        L_0x0019:
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0039, all -> 0x0037 }
            r3.<init>(r0)     // Catch:{ IOException -> 0x0039, all -> 0x0037 }
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0035 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0035 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0035 }
            r0.<init>(r2)     // Catch:{ IOException -> 0x0035 }
            java.lang.String r0 = r0.readLine()     // Catch:{ IOException -> 0x0035 }
            r3.close()     // Catch:{ IOException -> 0x0030 }
            goto L_0x0034
        L_0x0030:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0034:
            return r0
        L_0x0035:
            r0 = move-exception
            goto L_0x003b
        L_0x0037:
            r0 = move-exception
            goto L_0x004b
        L_0x0039:
            r0 = move-exception
            r3 = r1
        L_0x003b:
            r0.printStackTrace()     // Catch:{ all -> 0x0049 }
            if (r3 == 0) goto L_0x0048
            r3.close()     // Catch:{ IOException -> 0x0044 }
            goto L_0x0048
        L_0x0044:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0048:
            return r1
        L_0x0049:
            r0 = move-exception
            r1 = r3
        L_0x004b:
            if (r1 == 0) goto L_0x0055
            r1.close()     // Catch:{ IOException -> 0x0051 }
            goto L_0x0055
        L_0x0051:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0055:
            throw r0
        L_0x0056:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.app.delegate.BffInitManager.m5372a(java.lang.String):java.lang.String");
    }
}
