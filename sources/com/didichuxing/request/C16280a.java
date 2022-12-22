package com.didichuxing.request;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.didichuxing.upgrade.BuildConfig;
import com.didichuxing.upgrade.UpgradeConfig;
import com.didichuxing.util.EncryptUtils;
import com.didichuxing.util.UpgradeSystemUtil;
import java.util.Map;

/* renamed from: com.didichuxing.request.a */
/* compiled from: ParamCombiner */
class C16280a {
    C16280a() {
    }

    /* renamed from: a */
    public static void m34792a(Context context, Map<String, String> map) {
        map.put("model", Build.MODEL);
        map.put(ServerParam.PARAM_OS_VERSION, Build.VERSION.RELEASE);
        map.put("pixels", UpgradeSystemUtil.getScreenInfo(context));
        map.put("cpu", UpgradeSystemUtil.getCPUSerialno());
        map.put("android_id", UpgradeSystemUtil.getAndroidID(context));
        map.put("brand", Build.BRAND);
        map.put("sdk_version", BuildConfig.SDK_VERSION);
    }

    /* renamed from: b */
    public static void m34794b(Context context, Map<String, String> map) {
        map.put("os_type", "android");
        map.put(ServerParam.PARAM_VERSION_CODE, String.valueOf(UpgradeSystemUtil.getVersionCode(context)));
        map.put("version", UpgradeSystemUtil.getVersionName(context));
        map.put(ServerParam.PARAM_NETWORK_TYPE, UpgradeSystemUtil.getNetworkType(context));
        map.put("app_name", context.getPackageName());
    }

    /* renamed from: a */
    public static void m34793a(Map<String, String> map) {
        if (UpgradeConfig.iConfig != null) {
            map.put("city_id", UpgradeConfig.iConfig.getCityId());
        }
        if (UpgradeConfig.iConfig != null) {
            map.put("uid", UpgradeConfig.iConfig.getUid());
        }
        if (UpgradeConfig.iConfig != null) {
            String phone = UpgradeConfig.iConfig.getPhone();
            if (!TextUtils.isEmpty(phone)) {
                map.put("tn", EncryptUtils.encrypt(phone.getBytes()));
            }
            map.put("lang", UpgradeConfig.iConfig.getAppLanguage());
            map.put("country_code", UpgradeConfig.iConfig.getCountryCode());
        }
    }
}
