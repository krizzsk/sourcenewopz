package com.didichuxing.omega.sdk.analysis;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.didi.sdk.util.EventKeys;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.collector.CPUCollector;
import com.didichuxing.omega.sdk.common.collector.CustomCollector;
import com.didichuxing.omega.sdk.common.collector.DeviceCollector;
import com.didichuxing.omega.sdk.common.collector.LocaleCollector;
import com.didichuxing.omega.sdk.common.collector.LocationCollector;
import com.didichuxing.omega.sdk.common.collector.NetworkCollector;
import com.didichuxing.omega.sdk.common.collector.PackageCollector;
import com.didichuxing.omega.sdk.common.collector.PersistentInfoCollector;
import com.didichuxing.omega.sdk.common.collector.ScreenCollector;
import com.didichuxing.omega.sdk.common.collector.StorageCollector;
import com.didichuxing.omega.sdk.common.collector.ThreadCollector;
import com.didichuxing.omega.sdk.common.collector.TimeCollector;
import com.didichuxing.omega.sdk.common.record.Event;
import com.didichuxing.omega.sdk.common.utils.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class SystemTrack {
    public static void trackODAT() {
        if (PersistentInfoCollector.ifNeedODAT()) {
            Event event = new Event("OMGODAT");
            long[] externalStorage = StorageCollector.getExternalStorage();
            event.putAttr("disk_total", Long.valueOf(externalStorage[0]));
            event.putAttr("disk_free", Long.valueOf(externalStorage[1]));
            event.putAttr("app_total_size", Long.valueOf(StorageCollector.getAppTotalSize()));
            event.putNetType();
            event.putAttr("screen_size", ScreenCollector.getScreenSize());
            event.putAttr("cpuAbi", CPUCollector.getCpuArchitecture());
            event.putAttr("omg_key", EncrypteUtil.getDesKey());
            event.putAttr("paired_bluetooth", PackageCollector.getBlueToothList());
            event.putAttr("isEmulator", Integer.valueOf(DeviceCollector.getEmulatorType()));
            event.putNetType();
            event.putAttr("mcc", NetworkCollector.getNetworkOperatorMCC());
            event.putAttr("mnc", NetworkCollector.getNetworkOperatorMNC());
            event.putAttr("msin", NetworkCollector.getNetworkOperatorMSIN());
            event.putAttr("udid", CustomCollector.getDidiDeviceId());
            event.putAttr("usid", CustomCollector.getDidiSuuid());
            event.putAttr("ucid", CustomCollector.getGetuiCid());
            event.putAttr("channel", OmegaConfig.CHANNEL);
            event.putAttr(EventKeys.USER_AGENT_PREFIX, DeviceCollector.getUserAgent());
            event.putAttr("andid", DeviceCollector.getAndroidId());
            if (!TextUtils.isEmpty(OmegaConfig.OMEGA_OAID)) {
                event.putAttr(Constants.JSON_KEY_OMEGA_OAID, OmegaConfig.OMEGA_OAID);
            }
            Tracker.trackEvent(event);
        }
    }

    public static void trackHourly() {
        if (OmegaConfig.SWITCH_OMG_HOURLY) {
            Event event = new Event("OMGHourly");
            event.putAttr("thread_count", Integer.valueOf(ThreadCollector.getCurrentThreadCount()));
            event.putAttr("fd_count", Integer.valueOf(ThreadCollector.getCurrentFDList().size()));
            Tracker.trackEvent(event);
        }
    }

    public static void trackAppSession(SharedPreferences sharedPreferences) {
        long currentTimeMillis = System.currentTimeMillis() - sharedPreferences.getLong("sslst", 0);
        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String string = sharedPreferences.getString("ssld", "");
        if (currentTimeMillis > OmegaConfig.MOMENT_ID_INTERVAL || !format.equals(string)) {
            Event event = new Event("OMGAppSession");
            event.putAttr("interval", Integer.valueOf(currentTimeMillis > OmegaConfig.MOMENT_ID_INTERVAL ? 1 : 0));
            event.putAttr("cross", Integer.valueOf(format.equals(string) ^ true ? 1 : 0));
            Tracker.trackEvent(event);
        }
        try {
            sharedPreferences.edit().putLong("sslst", System.currentTimeMillis()).apply();
            sharedPreferences.edit().putString("ssld", format).apply();
        } catch (Throwable unused) {
        }
    }

    static void buildRealtimeAttr(Map<String, Object> map) {
        map.put("cityid", Integer.valueOf(CustomCollector.getCityId()));
        map.put("otn", 1);
        if (OmegaConfig.SWITCH_PUT_LOCATION_BACKGROUND || AnalysisDelegater.isAppIn()) {
            double[] location = LocationCollector.getLocation();
            map.put("lng", Double.valueOf(location[0]));
            map.put("lat", Double.valueOf(location[1]));
        }
        String phone = CustomCollector.getPhone();
        if (phone != null && !"".equals(phone)) {
            map.put("tel", phone);
        }
        String canonicalCountryCode = LocaleCollector.getCanonicalCountryCode();
        if (canonicalCountryCode != null && !"".equals(canonicalCountryCode)) {
            map.put("ccc", canonicalCountryCode);
        }
        map.put("uo", Integer.valueOf(TimeCollector.getTimeZoneUtcOffset()));
    }
}
