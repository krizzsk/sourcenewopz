package com.didichuxing.omega.sdk.common.record;

import android.os.Build;
import android.text.TextUtils;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import com.didichuxing.omega.sdk.analysis.AnalysisDelegater;
import com.didichuxing.omega.sdk.analysis.Tracker;
import com.didichuxing.omega.sdk.common.OmegaCallback;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.backend.BatteryChangeReceiver;
import com.didichuxing.omega.sdk.common.collector.ActivityCollector;
import com.didichuxing.omega.sdk.common.collector.CPUCollector;
import com.didichuxing.omega.sdk.common.collector.CustomCollector;
import com.didichuxing.omega.sdk.common.collector.FragmentCollector;
import com.didichuxing.omega.sdk.common.collector.LocaleCollector;
import com.didichuxing.omega.sdk.common.collector.LocationCollector;
import com.didichuxing.omega.sdk.common.collector.LogcatCollector;
import com.didichuxing.omega.sdk.common.collector.MemoryCollector;
import com.didichuxing.omega.sdk.common.collector.NetworkCollector;
import com.didichuxing.omega.sdk.common.collector.PackageCollector;
import com.didichuxing.omega.sdk.common.collector.PageCollector;
import com.didichuxing.omega.sdk.common.collector.PersistentInfoCollector;
import com.didichuxing.omega.sdk.common.collector.ScreenCollector;
import com.didichuxing.omega.sdk.common.collector.ThreadCollector;
import com.didichuxing.omega.sdk.common.collector.TimeCollector;
import com.didichuxing.omega.sdk.common.utils.AdvertisingIdHelper;
import com.didichuxing.omega.sdk.common.utils.CommonUtil;
import com.didichuxing.omega.sdk.common.utils.JsonUtil;
import com.didichuxing.omega.sdk.common.utils.OLog;
import java.io.File;
import java.util.Date;

public class RecordFactory {
    public static Record createRecord() {
        Record record = new Record();
        record.put("rid", CommonUtil.randomBase64UUID());
        record.put("oid", PersistentInfoCollector.getOmegaId());
        record.put("mid", Long.valueOf(PersistentInfoCollector.getMomentId()));
        record.put("uid", CustomCollector.getUid());
        String utk = CustomCollector.getUtk();
        if (utk != null) {
            record.put("utk", utk);
        }
        int cityId = CustomCollector.getCityId();
        if (cityId != 0) {
            record.put("cityid", Integer.valueOf(cityId));
        }
        record.put("an", OmegaConfig.CUSTOM_APP_NAME);
        String pkgName = PackageCollector.getPkgName();
        if (!OmegaConfig.CUSTOM_APP_NAME.equals(pkgName)) {
            record.put("oan", pkgName);
        }
        record.put("av", PackageCollector.getVN());
        if (!TextUtils.isEmpty(OmegaConfig.APP_ISSUE)) {
            record.put("nav", OmegaConfig.APP_ISSUE);
        }
        if (!TextUtils.isEmpty(OmegaConfig.CUSTOM_APP_VERSION)) {
            record.put("cvn", OmegaConfig.CUSTOM_APP_VERSION);
        }
        record.put("avn", Integer.valueOf(PackageCollector.getVC()));
        record.put("b", Build.BRAND);
        record.put("m", Build.MODEL);
        record.put("dp", Build.DISPLAY + "/" + Build.FINGERPRINT);
        record.put("ot", "android");
        record.put("ov", Build.VERSION.RELEASE);
        record.put("ch", OmegaConfig.CHANNEL);
        record.put("sv", OmegaConfig.SDK_VERSION);
        record.put("dm", Integer.valueOf(OmegaConfig.DEBUG_MODEL ? 1 : 0));
        if (OmegaConfig.SWITCH_PUT_LOCATION_BACKGROUND || AnalysisDelegater.isAppIn()) {
            double[] location = LocationCollector.getLocation();
            record.put("lng", Double.valueOf(location[0]));
            record.put("lat", Double.valueOf(location[1]));
        }
        record.put("tc", Long.valueOf(OmegaConfig.CUSTOM_TIME_OFFSET));
        record.put("uo", Integer.valueOf(TimeCollector.getTimeZoneUtcOffset()));
        if (OmegaConfig.COUNTY_ID != 0) {
            record.put("coi", Integer.valueOf(OmegaConfig.COUNTY_ID));
        }
        if (OmegaConfig.iLocale != null) {
            record.put("le", OmegaConfig.iLocale.getLocale());
        }
        String dailingCountryCode = CustomCollector.getDailingCountryCode();
        if (dailingCountryCode != null) {
            record.put("dcc", dailingCountryCode);
        }
        AdvertisingIdHelper.putGaidInfo(record);
        AdvertisingIdHelper.putHaidInfo(record);
        return record;
    }

    private static ChanceRecord createChanceRecord(boolean z, boolean z2) {
        ChanceRecord chanceRecord = new ChanceRecord();
        chanceRecord.fromRecord(createRecord());
        try {
            chanceRecord.put("pt", Long.valueOf(new Date().getTime()));
            chanceRecord.put("sst", Long.valueOf(TimeCollector.getSysStartupTime()));
            chanceRecord.put("ast", Long.valueOf(TimeCollector.getAppStartupTime()));
            if (z) {
                chanceRecord.addScreenshot(ActivityCollector.getScreenshot());
            }
            chanceRecord.put("ph", ActivityCollector.getActivityHistory());
            chanceRecord.put("cp", OmegaCallback.iCurrentPageListener != null ? OmegaCallback.iCurrentPageListener.getCurActivityPage(ActivityCollector.getCurActivityPage()) : ActivityCollector.getCurActivityPage());
            chanceRecord.put("if", Integer.valueOf(AnalysisDelegater.isAppIn() ? 1 : 0));
            chanceRecord.put("fh", FragmentCollector.getFragmentHistory());
            chanceRecord.put("pph", PageCollector.getPageHistory());
            chanceRecord.put(Constants.JSON_KEY_CUR_CPU_STAT, CPUCollector.getMyAppCPUStat());
            chanceRecord.put("mi", MemoryCollector.getMemInfo());
            chanceRecord.put("smi", MemoryCollector.getSysMemInfo());
            chanceRecord.put("asi", MemoryCollector.getAppStatusInfo());
            chanceRecord.put("ni", NetworkCollector.getNetworkInfo());
            chanceRecord.put("nt", NetworkCollector.getNetworkType());
            chanceRecord.put("ovn", Integer.valueOf(CommonUtil.getAPILevel()));
            chanceRecord.put("bp", Integer.valueOf(BatteryChangeReceiver.getBatteryPercent()));
            chanceRecord.put("ss", ScreenCollector.getScreenSize());
            chanceRecord.put("loc", LocaleCollector.getLanguageAndCountry());
            chanceRecord.put(com.didichuxing.omega.sdk.common.utils.Constants.JSON_KEY_GOOGLE_PLAY_SERVICE_INFO, PackageCollector.getGooglePlayServiceInfo());
            if (z2) {
                chanceRecord.putLogcat(LogcatCollector.getLogcat().getBytes());
            }
        } catch (Throwable th) {
            OLog.m34770w("collectChanceData() error!", th);
        }
        return chanceRecord;
    }

    private static ChanceRecord createChanceRecord() {
        return createChanceRecord(true, true);
    }

    public static EventsRecord createEventsRecord() {
        Record createRecord = createRecord();
        EventsRecord eventsRecord = new EventsRecord();
        eventsRecord.fromRecord(createRecord);
        String canonicalCountryCode = LocaleCollector.getCanonicalCountryCode();
        if (!TextUtils.isEmpty(canonicalCountryCode)) {
            eventsRecord.put("ccc", canonicalCountryCode);
        }
        return eventsRecord;
    }

    public static NativeCrashRecord createNativeCrashRecord(boolean z, File file, File file2) {
        ChanceRecord createChanceRecord = createChanceRecord(false, false);
        NativeCrashRecord nativeCrashRecord = new NativeCrashRecord();
        nativeCrashRecord.put("patch_version", Long.valueOf(OmegaConfig.HOTPATCH_VERSION));
        nativeCrashRecord.fromRecord(createChanceRecord);
        nativeCrashRecord.setDumpFile(file);
        nativeCrashRecord.setLogFile(file2);
        nativeCrashRecord.takeStorageInfo();
        if (z) {
            nativeCrashRecord.markDumpAsSync();
        } else if (!OmegaConfig.NATIVE_CRASH_SAVE_LOGCAT) {
            nativeCrashRecord.takeLogcat();
        }
        nativeCrashRecord.put("seq", PersistentInfoCollector.getRecordSeq("c_seq"));
        String canonicalCountryCode = LocaleCollector.getCanonicalCountryCode();
        if (!TextUtils.isEmpty(canonicalCountryCode)) {
            nativeCrashRecord.put("ccc", canonicalCountryCode);
        }
        return nativeCrashRecord;
    }

    public static CrashRecord createCrashRecord() {
        ChanceRecord createChanceRecord = createChanceRecord(true, false);
        createChanceRecord.imageDeepCompress();
        CrashRecord crashRecord = new CrashRecord();
        crashRecord.fromRecord(createChanceRecord);
        crashRecord.takeStorageInfo();
        if (Tracker.getGlobalAttrs() != null) {
            crashRecord.put("glb", JsonUtil.map2Json(Tracker.getGlobalAttrs()));
        }
        crashRecord.put("seq", PersistentInfoCollector.getRecordSeq("c_seq"));
        if (OmegaConfig.PLUGIN_INFO != null) {
            crashRecord.put("dycplugin", OmegaConfig.PLUGIN_INFO);
        } else {
            crashRecord.put("dycplugin", "{}");
        }
        crashRecord.put("patch_version", Long.valueOf(OmegaConfig.HOTPATCH_VERSION));
        String canonicalCountryCode = LocaleCollector.getCanonicalCountryCode();
        if (!TextUtils.isEmpty(canonicalCountryCode)) {
            crashRecord.put("ccc", canonicalCountryCode);
        }
        return crashRecord;
    }

    public static ANRRecord createANRRecord(String str) {
        ChanceRecord createChanceRecord = createChanceRecord(true, false);
        createChanceRecord.imageDeepCompress();
        ANRRecord aNRRecord = new ANRRecord();
        aNRRecord.fromRecord(createChanceRecord);
        aNRRecord.setTraceFilename(str);
        aNRRecord.setAllThreadStack(ThreadCollector.getAllThreadStacks(true, new String[0]));
        aNRRecord.takeStorageInfo();
        if (Tracker.getGlobalAttrs() != null) {
            aNRRecord.put("glb", JsonUtil.map2Json(Tracker.getGlobalAttrs()));
        }
        aNRRecord.put("seq", PersistentInfoCollector.getRecordSeq("a_seq"));
        String canonicalCountryCode = LocaleCollector.getCanonicalCountryCode();
        if (!TextUtils.isEmpty(canonicalCountryCode)) {
            aNRRecord.put("ccc", canonicalCountryCode);
        }
        return aNRRecord;
    }

    public static LagRecord createLagRecord() {
        ChanceRecord createChanceRecord = createChanceRecord(false, false);
        createChanceRecord.imageDeepCompress();
        LagRecord lagRecord = new LagRecord();
        lagRecord.fromRecord(createChanceRecord);
        lagRecord.setAllThreadStack(ThreadCollector.getAllThreadStacks(true, new String[0]));
        lagRecord.takeStorageInfo();
        if (Tracker.getGlobalAttrs() != null) {
            lagRecord.put("glb", JsonUtil.map2Json(Tracker.getGlobalAttrs()));
        }
        lagRecord.put("seq", PersistentInfoCollector.getRecordSeq("l_seq"));
        String canonicalCountryCode = LocaleCollector.getCanonicalCountryCode();
        if (!TextUtils.isEmpty(canonicalCountryCode)) {
            lagRecord.put("ccc", canonicalCountryCode);
        }
        return lagRecord;
    }

    public static EventsRecord createLastEventsRecord(String str, String str2, String str3) {
        Record createRecord = createRecord();
        createRecord.put("av", str);
        createRecord.put("avn", str2);
        String canonicalCountryCode = LocaleCollector.getCanonicalCountryCode();
        if (!TextUtils.isEmpty(canonicalCountryCode)) {
            createRecord.put("ccc", canonicalCountryCode);
        }
        if (!TextUtils.isEmpty(str3)) {
            createRecord.put("nav", str3);
        }
        EventsRecord eventsRecord = new EventsRecord();
        eventsRecord.fromRecord(createRecord);
        return eventsRecord;
    }

    public static NativeCrashRecord createUnwindRecord(File file) {
        ChanceRecord createChanceRecord = createChanceRecord(false, false);
        NativeCrashRecord nativeCrashRecord = new NativeCrashRecord();
        nativeCrashRecord.put("patch_version", Long.valueOf(OmegaConfig.HOTPATCH_VERSION));
        nativeCrashRecord.fromRecord(createChanceRecord);
        nativeCrashRecord.setDumpFile(file);
        nativeCrashRecord.takeStorageInfo();
        nativeCrashRecord.takeLogcat();
        nativeCrashRecord.put("seq", PersistentInfoCollector.getRecordSeq("c_seq"));
        String canonicalCountryCode = LocaleCollector.getCanonicalCountryCode();
        if (!TextUtils.isEmpty(canonicalCountryCode)) {
            nativeCrashRecord.put("ccc", canonicalCountryCode);
        }
        return nativeCrashRecord;
    }
}
