package com.didichuxing.mas.sdk.quality.report.record;

import android.os.Build;
import android.text.TextUtils;
import com.didichuxing.mas.sdk.quality.report.MASConfig;
import com.didichuxing.mas.sdk.quality.report.analysis.AnalysisDelegater;
import com.didichuxing.mas.sdk.quality.report.analysis.Tracker;
import com.didichuxing.mas.sdk.quality.report.backend.BatteryChangeReceiver;
import com.didichuxing.mas.sdk.quality.report.collector.ActivityCollector;
import com.didichuxing.mas.sdk.quality.report.collector.CPUCollector;
import com.didichuxing.mas.sdk.quality.report.collector.CustomCollector;
import com.didichuxing.mas.sdk.quality.report.collector.DeviceCollector;
import com.didichuxing.mas.sdk.quality.report.collector.FragmentCollector;
import com.didichuxing.mas.sdk.quality.report.collector.LocaleCollector;
import com.didichuxing.mas.sdk.quality.report.collector.LocationCollector;
import com.didichuxing.mas.sdk.quality.report.collector.LogcatCollector;
import com.didichuxing.mas.sdk.quality.report.collector.MemoryCollector;
import com.didichuxing.mas.sdk.quality.report.collector.NetworkCollector;
import com.didichuxing.mas.sdk.quality.report.collector.PackageCollector;
import com.didichuxing.mas.sdk.quality.report.collector.PageCollector;
import com.didichuxing.mas.sdk.quality.report.collector.PersistentInfoCollector;
import com.didichuxing.mas.sdk.quality.report.collector.ScreenCollector;
import com.didichuxing.mas.sdk.quality.report.collector.ThreadCollector;
import com.didichuxing.mas.sdk.quality.report.collector.TimeCollector;
import com.didichuxing.mas.sdk.quality.report.utils.CommonUtil;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import com.didichuxing.mas.sdk.quality.report.utils.JsonUtil;
import com.didichuxing.mas.sdk.quality.report.utils.OLog;
import java.io.File;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;

public class RecordFactory {
    public static Record createRecord() {
        double[] location;
        Record record = new Record();
        record.put("rid", CommonUtil.randomBase64UUID());
        record.put("oid", PersistentInfoCollector.getOmegaId());
        record.put("mid", Long.valueOf(PersistentInfoCollector.getMomentId()));
        record.put("uid", CustomCollector.getUid());
        record.addIfNotEmpty("utk", CustomCollector.getUtk());
        record.addIfNotEmpty("cityid", CustomCollector.getCityId());
        record.addIfNotEmpty("tn", CustomCollector.getEncryptedPhone());
        Map<String, Object> extraParams = CustomCollector.getExtraParams();
        if (extraParams != null && !extraParams.isEmpty()) {
            record.putAll(extraParams);
        }
        record.addIfNotEmpty("udid", CustomCollector.getDidiDeviceId());
        record.put(Constants.JSON_KEY_ANDID, DeviceCollector.getDdfp());
        record.put(Constants.JSON_KEY_APOLLO_KEY, DeviceCollector.getApolloKey());
        record.addIfNotEmpty("usid", CustomCollector.getDidiSuuid());
        record.addIfNotEmpty("ucid", CustomCollector.getGetUiCid());
        record.put("an", MASConfig.CUSTOM_APP_NAME);
        String pkgName = PackageCollector.getPkgName();
        if (!MASConfig.CUSTOM_APP_NAME.equals(pkgName)) {
            record.put("oan", pkgName);
        }
        record.put("av", PackageCollector.getVN());
        if (!TextUtils.isEmpty(MASConfig.APP_ISSUE)) {
            record.put("nav", MASConfig.APP_ISSUE);
        }
        if (!TextUtils.isEmpty(MASConfig.CUSTOM_APP_VERSION)) {
            record.put("cvn", MASConfig.CUSTOM_APP_VERSION);
        }
        record.put("avn", Integer.valueOf(PackageCollector.getVC()));
        record.put("b", Build.BRAND);
        record.put("m", Build.MODEL);
        record.put("dp", Build.DISPLAY + "/" + Build.FINGERPRINT);
        record.put("ot", "android");
        record.put("ov", Build.VERSION.RELEASE);
        record.put("ch", CustomCollector.getChannel());
        record.put(Constants.JSON_KEY_MAS_SDK_VERSION, MASConfig.MAS_SDK_VERSION);
        record.put("sv", MASConfig.OMEGA_SDK_VERSION);
        record.put("dm", Integer.valueOf(CommonUtil.isApkInDebug() ? 1 : 0));
        if (AnalysisDelegater.isAppAtFront() && LocationCollector.isNeedUploadLocation() && (location = LocationCollector.getLocation()) != null && location.length >= 2) {
            record.put("lng", Double.valueOf(location[0]));
            record.put("lat", Double.valueOf(location[1]));
        }
        record.put("tc", Long.valueOf(CustomCollector.getTimeOffSet()));
        record.put("uo", Integer.valueOf(TimeCollector.getTimeZoneUtcOffset()));
        record.put("coi", Integer.valueOf(CustomCollector.getCountryId()));
        record.addIfNotEmpty("le", CustomCollector.getLocale());
        record.addIfNotEmpty("dcc", CustomCollector.getDailingCountryCode());
        return record;
    }

    private static ChanceRecord createChanceRecord(boolean z, boolean z2) {
        String str;
        String str2;
        ChanceRecord chanceRecord = new ChanceRecord();
        chanceRecord.fromRecord(createRecord());
        try {
            chanceRecord.put("pt", Long.valueOf(new Date().getTime()));
            chanceRecord.put("sst", Long.valueOf(TimeCollector.getSysStartupTime()));
            chanceRecord.put("ast", Long.valueOf(TimeCollector.getAppStartupTime()));
            chanceRecord.put("timeZone", TimeZone.getDefault().getID());
            chanceRecord.put("ph", ActivityCollector.getActivityHistory());
            chanceRecord.put("cp", ActivityCollector.getCurPage());
            chanceRecord.put("if", Integer.valueOf(AnalysisDelegater.isAppAtFront() ? 1 : 0));
            str = "";
            str = (String) Class.forName("com.didichuxing.omega.sdk.common.collector.FragmentCollector").getMethod("getFragmentHistory", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            OLog.m34425w("collectChanceData() error!", th);
        }
        if (TextUtils.isEmpty(str)) {
            str2 = FragmentCollector.getFragmentHistory();
        } else {
            str2 = PageCollector.desensitizationString(str);
        }
        chanceRecord.put("fh", str2);
        chanceRecord.put("pph", PageCollector.getPageHistory());
        chanceRecord.put(Constants.JSON_KEY_CUR_CPU_STAT, CPUCollector.getMyAppCPUStat());
        chanceRecord.put(Constants.JSON_KEY_CPU_ABI, CPUCollector.getCpuArchitecture());
        chanceRecord.put("mi", MemoryCollector.getMemInfo());
        chanceRecord.put("smi", MemoryCollector.getSysMemInfo());
        chanceRecord.put("asi", MemoryCollector.getAppStatusInfo());
        chanceRecord.put("ni", NetworkCollector.getNetworkInfo());
        chanceRecord.put("nt", NetworkCollector.getNetworkType());
        chanceRecord.put("ovn", Integer.valueOf(CommonUtil.getAPILevel()));
        chanceRecord.put("bp", Integer.valueOf(BatteryChangeReceiver.getBatteryPercent()));
        chanceRecord.put("ss", ScreenCollector.getScreenSize());
        chanceRecord.put("loc", LocaleCollector.getLanguageAndCountry());
        if (z2) {
            chanceRecord.putLogcat(LogcatCollector.getLogcat().getBytes());
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
        nativeCrashRecord.put("patch_version", Long.valueOf(CustomCollector.getHotPatchVersion()));
        nativeCrashRecord.fromRecord(createChanceRecord);
        nativeCrashRecord.setDumpFile(file);
        nativeCrashRecord.setLogFile(file2);
        nativeCrashRecord.takeStorageInfo();
        if (z) {
            nativeCrashRecord.markDumpAsSync();
        } else {
            nativeCrashRecord.takeLogcat();
        }
        nativeCrashRecord.put("seq", PersistentInfoCollector.getRecordSeq("c_seq"));
        nativeCrashRecord.addIfNotEmpty("ccc", LocaleCollector.getCanonicalCountryCode());
        return nativeCrashRecord;
    }

    public static CrashRecord createCrashRecord() {
        ChanceRecord createChanceRecord = createChanceRecord(true, false);
        CrashRecord crashRecord = new CrashRecord();
        crashRecord.fromRecord(createChanceRecord);
        crashRecord.takeStorageInfo();
        if (Tracker.getGlobalAttrs() != null) {
            crashRecord.put("glb", JsonUtil.map2Json(Tracker.getGlobalAttrs()));
        }
        crashRecord.put("seq", PersistentInfoCollector.getRecordSeq("c_seq"));
        crashRecord.put("dycplugin", CustomCollector.getPluginInfo());
        crashRecord.put("patch_version", Long.valueOf(CustomCollector.getHotPatchVersion()));
        crashRecord.addIfNotEmpty("ccc", LocaleCollector.getCanonicalCountryCode());
        String jsonByCustomEventMap = CustomCollector.getJsonByCustomEventMap();
        if (jsonByCustomEventMap != null) {
            crashRecord.put("tags", jsonByCustomEventMap);
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
        aNRRecord.addIfNotEmpty("ccc", LocaleCollector.getCanonicalCountryCode());
        String jsonByCustomEventMap = CustomCollector.getJsonByCustomEventMap();
        if (jsonByCustomEventMap != null) {
            aNRRecord.put("tags", jsonByCustomEventMap);
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
        lagRecord.addIfNotEmpty("ccc", LocaleCollector.getCanonicalCountryCode());
        return lagRecord;
    }

    public static EventsRecord createLastEventsRecord(String str, String str2, String str3) {
        Record createRecord = createRecord();
        createRecord.put("av", str);
        createRecord.put("avn", str2);
        createRecord.addIfNotEmpty("ccc", LocaleCollector.getCanonicalCountryCode());
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
        nativeCrashRecord.put("patch_version", Long.valueOf(CustomCollector.getHotPatchVersion()));
        nativeCrashRecord.fromRecord(createChanceRecord);
        nativeCrashRecord.setDumpFile(file);
        nativeCrashRecord.takeStorageInfo();
        nativeCrashRecord.takeLogcat();
        nativeCrashRecord.put("seq", PersistentInfoCollector.getRecordSeq("c_seq"));
        nativeCrashRecord.addIfNotEmpty("ccc", LocaleCollector.getCanonicalCountryCode());
        String jsonByCustomEventMap = CustomCollector.getJsonByCustomEventMap();
        if (jsonByCustomEventMap != null) {
            nativeCrashRecord.put("tags", jsonByCustomEventMap);
        }
        return nativeCrashRecord;
    }
}
