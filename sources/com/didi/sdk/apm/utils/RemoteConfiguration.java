package com.didi.sdk.apm.utils;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import java.util.ArrayList;
import java.util.List;

public class RemoteConfiguration {
    public static final String APM_COMMON_CONFIG = "app_apm_config";
    public static final String KEY_BLACK_BUILD_MODEL = "black_model";
    public static final String KEY_BLACK_BUILD_MODEL_VER = "black_model_ver";
    public static final String KEY_BLACK_OS_VERSION = "black_os_ver";

    /* renamed from: a */
    private static final String f35066a = "black_phone_model";

    public static boolean isOpen(String str, boolean z) {
        IToggle toggle = Apollo.getToggle(str, z);
        IExperiment experiment = toggle.getExperiment();
        if (!new BlackListPairParser((String) experiment.getParam(KEY_BLACK_BUILD_MODEL_VER, "")) {
            /* access modifiers changed from: protected */
            public boolean onCheck(String[] strArr) {
                if (!Build.MODEL.equals(strArr[0]) || !String.valueOf(Build.VERSION.SDK_INT).equals(strArr[1])) {
                    return false;
                }
                return true;
            }
        }.check() && !new BlackListParser((String) experiment.getParam(KEY_BLACK_BUILD_MODEL, "")) {
            /* access modifiers changed from: protected */
            public boolean onCheck(String str) {
                return Build.MODEL.equals(str);
            }
        }.check() && !new BlackListParser((String) experiment.getParam(KEY_BLACK_OS_VERSION, "")) {
            /* access modifiers changed from: protected */
            public boolean onCheck(String str) {
                return String.valueOf(Build.VERSION.SDK_INT).equals(str);
            }
        }.check()) {
            return toggle.allow();
        }
        return false;
    }

    public static boolean isHit(String str, boolean z) {
        return new BlackPhoneListParser((String) Apollo.getToggle(str, z).getExperiment().getParam(f35066a, "")) {
            private static final String TAG = "BlackPhoneListParser";

            /* access modifiers changed from: protected */
            public boolean onCheck(String str, String str2) {
                Log.d(TAG, "model:" + str + ";osVersion is:" + str2);
                return TextUtils.equals(Build.MODEL, str) && TextUtils.equals(Build.VERSION.RELEASE, str2);
            }
        }.check();
    }

    public static <T> T getConfig(String str, String str2, T t) {
        try {
            return Apollo.getToggle(str).getExperiment().getParam(str2, t);
        } catch (Exception unused) {
            return t;
        }
    }

    public static <T> T getCommonConfig(String str, T t) {
        try {
            return Apollo.getToggle(APM_COMMON_CONFIG).getExperiment().getParam(str, t);
        } catch (Exception unused) {
            return t;
        }
    }

    private static abstract class BlackListParser {
        private static final String SPLIT = ",";
        String config;

        /* access modifiers changed from: protected */
        public abstract boolean onCheck(String str);

        private BlackListParser(String str) {
            this.config = str;
        }

        /* access modifiers changed from: package-private */
        public boolean check() {
            if (TextUtils.isEmpty(this.config)) {
                return false;
            }
            String trim = this.config.trim();
            this.config = trim;
            for (String trim2 : trim.split(",")) {
                if (onCheck(trim2.trim())) {
                    return true;
                }
            }
            return false;
        }
    }

    private static abstract class BlackListPairParser {
        private static final String PAIR_SPLIT = ":";
        private static final String SPLIT = ",";
        String config;

        /* access modifiers changed from: protected */
        public abstract boolean onCheck(String[] strArr);

        private BlackListPairParser(String str) {
            this.config = str;
        }

        /* access modifiers changed from: package-private */
        public boolean check() {
            if (TextUtils.isEmpty(this.config)) {
                return false;
            }
            String trim = this.config.trim();
            this.config = trim;
            for (String str : trim.split(",")) {
                if (!TextUtils.isEmpty(str)) {
                    String[] split = str.split(":");
                    if (split.length != 2) {
                        continue;
                    } else {
                        split[0] = split[0].trim();
                        split[1] = split[1].trim();
                        if (onCheck(split)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }

    private static abstract class BlackPhoneListParser {
        private static final String INNER_SPLIT = "&";
        private static final String SPLIT = ",";
        private static final String TAG = "BlackPhoneListParser";
        String config;

        /* access modifiers changed from: protected */
        public abstract boolean onCheck(String str, String str2);

        private BlackPhoneListParser(String str) {
            Log.d(TAG, "filter config is :" + str);
            this.config = str;
        }

        /* access modifiers changed from: package-private */
        public boolean check() {
            if (TextUtils.isEmpty(this.config)) {
                return false;
            }
            String trim = this.config.trim();
            this.config = trim;
            for (String str : trim.split(",")) {
                if (!TextUtils.isEmpty(str)) {
                    Log.d(TAG, "item is:" + str);
                    String[] split = str.split("&");
                    if (split != null && split.length == 2 && onCheck(split[0], split[1])) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static List<String> getSplittableConfig(String str, String str2) {
        return getSplittableConfig(str, str2, ",");
    }

    public static List<String> getSplittableConfig(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        try {
            for (String str4 : ((String) Apollo.getToggle(str).getExperiment().getParam(str2, "")).split(str3)) {
                if (!TextUtils.isEmpty(str4)) {
                    arrayList.add(str4.trim());
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }
}
