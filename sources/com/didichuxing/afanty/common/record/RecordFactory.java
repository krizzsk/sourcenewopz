package com.didichuxing.afanty.common.record;

import android.os.Build;
import android.text.TextUtils;
import com.didichuxing.afanty.common.AfantyConfig;
import com.didichuxing.afanty.common.collector.LogcatCollector;
import com.didichuxing.afanty.common.collector.MemoryCollector;
import com.didichuxing.afanty.common.collector.NetworkCollector;
import com.didichuxing.afanty.common.collector.PackageCollector;
import com.didichuxing.afanty.common.collector.ScreenCollector;
import com.didichuxing.afanty.common.collector.UserInfoCollector;
import com.didichuxing.afanty.common.utils.CommonUtil;
import com.didichuxing.afanty.common.utils.Constants;
import com.didichuxing.omega.sdk.feedback.judgment.EncryptUtils;
import com.didichuxing.omega.sdk.feedback.util.SwarmUtil;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

public class RecordFactory {
    /* renamed from: a */
    private static Record m32661a() {
        Record record = new Record();
        record.put("rid", UUID.randomUUID().toString());
        record.put("oid", UserInfoCollector.getOmegaId());
        record.put("uid", SwarmUtil.getUserUid());
        record.put("pn", SwarmUtil.getUserPhone());
        record.put(Constants.JSON_KEY_HUIDU_ID, SwarmUtil.getHuiduId());
        double[] location = SwarmUtil.getLocation();
        record.put("lng", Double.valueOf(location[0]));
        record.put("lat", Double.valueOf(location[1]));
        record.put("cityId", SwarmUtil.getCityId());
        record.put(Constants.JSON_BUSINESS_ID, SwarmUtil.getBusinessId());
        return record;
    }

    /* renamed from: b */
    private static ChanceRecord m32662b() {
        ChanceRecord chanceRecord = new ChanceRecord();
        chanceRecord.fromRecord(m32661a());
        try {
            chanceRecord.put("pt", Long.valueOf(new Date().getTime()));
            chanceRecord.put("mi", MemoryCollector.getMemInfo());
            chanceRecord.put("smi", MemoryCollector.getSysMemInfo());
            chanceRecord.put("nt", NetworkCollector.getNetworkType());
            chanceRecord.put("an", PackageCollector.getPkgName());
            chanceRecord.put("av", PackageCollector.getVN());
            chanceRecord.put("avn", Integer.valueOf(PackageCollector.getVC()));
            chanceRecord.put("ot", "android");
            chanceRecord.put("ov", Build.VERSION.RELEASE);
            chanceRecord.put("ovn", Integer.valueOf(CommonUtil.getAPILevel()));
            chanceRecord.put("m", Build.MODEL);
            chanceRecord.put("b", Build.BRAND);
            chanceRecord.put("ss", ScreenCollector.getScreenSize());
            chanceRecord.put("si", ScreenCollector.getScreenInfo());
            chanceRecord.putLogcat(LogcatCollector.getLogcat().getBytes());
        } catch (Throwable unused) {
        }
        return chanceRecord;
    }

    public static FeedbackRecord createFeedbackRecord() {
        ChanceRecord b = m32662b();
        FeedbackRecord feedbackRecord = new FeedbackRecord();
        feedbackRecord.fromRecord(b);
        feedbackRecord.put("seq", UserInfoCollector.getSeq("f_seq"));
        return feedbackRecord;
    }

    public static Record createUserInfo() {
        Record record = new Record();
        record.put("pt", Long.valueOf(new Date().getTime()));
        record.put("mi", MemoryCollector.getMemInfo());
        record.put("smi", MemoryCollector.getSysMemInfo());
        record.put("nt", NetworkCollector.getNetworkType());
        record.put("an", PackageCollector.getPkgName());
        record.put("av", PackageCollector.getVN());
        record.put("avn", Integer.valueOf(PackageCollector.getVC()));
        record.put("ot", "android");
        record.put("ov", Build.VERSION.RELEASE);
        record.put("ovn", Integer.valueOf(CommonUtil.getAPILevel()));
        record.put("m", Build.MODEL);
        record.put("b", Build.BRAND);
        record.put("ss", ScreenCollector.getScreenSize());
        record.put("si", ScreenCollector.getScreenInfo());
        record.put("rid", UUID.randomUUID().toString());
        record.put("oid", UserInfoCollector.getOmegaId());
        record.put("uid", SwarmUtil.getUserUid());
        record.put("pn", !TextUtils.isEmpty(SwarmUtil.getUserPhone()) ? EncryptUtils.encrypt(SwarmUtil.getUserPhone().getBytes()) : "");
        record.put(Constants.JSON_KEY_PHONE_COUNTRY_CODE, SwarmUtil.getUserPhoneCountryCode());
        record.put("ccc", SwarmUtil.getCanonicalCountryCode());
        record.put("lang", SwarmUtil.getLang());
        record.put("nav", SwarmUtil.getHuiduId());
        double[] location = SwarmUtil.getLocation();
        record.put("lng", Double.valueOf(location[0]));
        record.put("lat", Double.valueOf(location[1]));
        record.put("cityId", SwarmUtil.getCityId());
        record.put(Constants.JSON_BUSINESS_ID, SwarmUtil.getBusinessId());
        String imsi = NetworkCollector.getIMSI((String) null);
        if (imsi != null) {
            record.put("imsi", imsi);
            if (imsi.length() == 15) {
                record.put("carrier", imsi.substring(0, 5));
            }
        }
        try {
            Map<String, Object> customInfo = AfantyConfig.getCustomInfo();
            if (customInfo != null && !customInfo.isEmpty()) {
                record.put(Constants.CUSTOM_INFO, customInfo);
            }
        } catch (Exception unused) {
        }
        return record;
    }
}
