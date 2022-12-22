package com.didichuxing.omega.sdk.analysis;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.backend.BatteryChangeReceiver;
import com.didichuxing.omega.sdk.common.collector.DeviceCollector;
import com.didichuxing.omega.sdk.common.collector.LocaleCollector;
import com.didichuxing.omega.sdk.common.collector.LocationCollector;
import com.didichuxing.omega.sdk.common.collector.MemoryCollector;
import com.didichuxing.omega.sdk.common.collector.NetworkCollector;
import com.didichuxing.omega.sdk.common.collector.StorageCollector;
import com.didichuxing.omega.sdk.common.record.ChanceRecord;
import com.didichuxing.omega.sdk.common.record.Event;
import com.didichuxing.omega.sdk.common.record.Record;
import com.didichuxing.omega.sdk.common.transport.FileTooLargeException;
import com.didichuxing.omega.sdk.common.transport.HttpSender;
import com.didichuxing.omega.sdk.common.utils.AdvertisingIdHelper;
import com.didichuxing.omega.sdk.common.utils.Constants;
import com.didichuxing.omega.sdk.common.utils.ZipUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class Security {
    private static int batteryInfoStart;
    private static int batteryStatusStart;

    public static String getKey() {
        return "";
    }

    public static void setHeaderCityIdEncrypt(Map<String, String> map, String str) {
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0040 */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0035 A[SYNTHETIC, Splitter:B:16:0x0035] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static synchronized void push(com.didichuxing.omega.sdk.common.record.Event r5) {
        /*
            java.lang.Class<com.didichuxing.omega.sdk.analysis.Security> r0 = com.didichuxing.omega.sdk.analysis.Security.class
            monitor-enter(r0)
            r1 = 0
            java.lang.String r2 = com.didichuxing.omega.sdk.common.perforence.RuntimeCheck.getProcessNameInMD5()     // Catch:{ all -> 0x002e }
            java.io.File r2 = com.didichuxing.omega.sdk.analysis.EventStorage.getInternalCacheFile(r2)     // Catch:{ all -> 0x002e }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x002e }
            r4 = 1
            r3.<init>(r2, r4)     // Catch:{ all -> 0x002e }
            java.lang.String r5 = r5.toJson()     // Catch:{ all -> 0x002d }
            java.lang.String r1 = "UTF-8"
            byte[] r5 = r5.getBytes(r1)     // Catch:{ all -> 0x002d }
            r3.write(r5)     // Catch:{ all -> 0x002d }
            byte[] r5 = new byte[r4]     // Catch:{ all -> 0x002d }
            r1 = 0
            r2 = 10
            r5[r1] = r2     // Catch:{ all -> 0x002d }
            r3.write(r5)     // Catch:{ all -> 0x002d }
            r3.close()     // Catch:{ IOException -> 0x0038 }
            goto L_0x0038
        L_0x002d:
            r1 = r3
        L_0x002e:
            java.lang.String r5 = "EventStorage.push fail"
            com.didichuxing.omega.sdk.common.utils.OLog.m34769w(r5)     // Catch:{ all -> 0x003a }
            if (r1 == 0) goto L_0x0038
            r1.close()     // Catch:{ IOException -> 0x0038 }
        L_0x0038:
            monitor-exit(r0)
            return
        L_0x003a:
            r5 = move-exception
            if (r1 == 0) goto L_0x0040
            r1.close()     // Catch:{ IOException -> 0x0040 }
        L_0x0040:
            throw r5     // Catch:{ all -> 0x0041 }
        L_0x0041:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.analysis.Security.push(com.didichuxing.omega.sdk.common.record.Event):void");
    }

    static synchronized String decrypt(String str) {
        synchronized (Security.class) {
        }
        return str;
    }

    public static String post(String str, File file, Map<String, String> map, boolean z) throws IOException {
        int i = 0;
        while (true) {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                String post = HttpSender.post(str, (InputStream) fileInputStream, map, file.length() > 1048576);
                try {
                    fileInputStream.close();
                } catch (IOException unused) {
                }
                return post;
            } catch (FileTooLargeException e) {
                throw e;
            } catch (IOException e2) {
                int i2 = i + 1;
                if (i < OmegaConfig.HTTP_SENDER_RETRY_TIMES) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused2) {
                    }
                    i = i2;
                } else {
                    throw e2;
                }
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (IOException unused3) {
                }
                throw th;
            }
        }
    }

    public static String packageName(Context context) {
        return context.getPackageName();
    }

    public static void takeStorageInfo(ChanceRecord chanceRecord) {
        long[] externalStorage = StorageCollector.getExternalStorage();
        chanceRecord.put("isi", "disk_total:" + externalStorage[0] + "\ndisk_free:" + externalStorage[1]);
    }

    public static void putMemInfo(Event event) {
        event.putAttr("mi", MemoryCollector.getMemInfo());
    }

    public static void putBatteryInfo(Event event) {
        event.putAttr("bi", Integer.valueOf(BatteryChangeReceiver.getBatteryPercent()));
        event.putAttr("bs", Integer.valueOf(BatteryChangeReceiver.getBatteryIsCharging() ? 1 : 0));
    }

    public static void putNetType(Event event) {
        event.putAttr("nt", NetworkCollector.getNetworkType());
    }

    public static void putGpsLocation(Event event) {
        double[] location = LocationCollector.getLocation();
        event.putAttr("lng", Double.valueOf(location[0]));
        event.putAttr("lat", Double.valueOf(location[1]));
    }

    public static void zip(Record record, List<Map.Entry<String, byte[]>> list, File file) throws Exception {
        ZipUtil.zip(record.getExtraFiles(), list, file);
    }

    public static void putEventText(Event event, String str) {
        event.putAttr("text", str);
    }

    public static String getManifestIssue(Context context) {
        return getManifestIssue(context, "issue");
    }

    private static String getManifestIssue(Context context, String str) {
        try {
            ApplicationInfo applicationInfo = SystemUtils.getApplicationInfo(context.getPackageManager(), context.getPackageName(), 128);
            if (applicationInfo.metaData == null || !applicationInfo.metaData.containsKey(str)) {
                return "";
            }
            Object obj = applicationInfo.metaData.get(str);
            if (obj instanceof String) {
                return ((String) obj).trim();
            }
            if (obj != null) {
                return String.valueOf(obj);
            }
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void initHaidAndGaid(Context context) {
        AdvertisingIdHelper.initHaidAndGaid(context);
    }

    public static void setBatteryStatusInfo() {
        batteryInfoStart = BatteryChangeReceiver.getBatteryPercent();
        batteryStatusStart = BatteryChangeReceiver.getBatteryIsCharging() ? 1 : 0;
    }

    public static void putBatteryStatusInfo(Event event) {
        event.putAttr("bi1", Integer.valueOf(batteryInfoStart));
        event.putAttr("bs1", Integer.valueOf(batteryStatusStart));
    }

    public static void putPageResumeInfo(Event event) {
        event.putAttr("andid", DeviceCollector.getAndroidId());
        if (!TextUtils.isEmpty(OmegaConfig.OMEGA_OAID)) {
            event.putAttr(Constants.JSON_KEY_OMEGA_OAID, OmegaConfig.OMEGA_OAID);
        }
    }

    public static void putBecomeActiveInfo(Event event) {
        event.putAttr("dbm", Integer.valueOf(NetworkCollector.getNetWorkStrength()));
        event.putAttr("lang", LocaleCollector.getLanguageAndCountry());
        event.putAttr("carrier", NetworkCollector.getNetworkOperatorName());
        event.putWifiSsid();
    }

    public static boolean exIsLowBattery() {
        int batteryPercent = BatteryChangeReceiver.getBatteryPercent();
        if (batteryPercent >= 0 && batteryPercent <= OmegaConfig.EX_LOW_BATTERY_THRESHOLD) {
            return true;
        }
        return false;
    }
}
