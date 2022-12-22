package com.didi.beatles.p099im.utils;

import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.math.BigDecimal;
import org.json.JSONException;
import org.json.JSONObject;
import rui.config.RConfigConstants;

/* renamed from: com.didi.beatles.im.utils.IMParseUtil */
public class IMParseUtil {
    public static final String STRING_PARSE_ERROR = "string_parse_error";
    public static final String TAG_PARSE_UTIL = "parse";

    /* renamed from: a */
    private static final double f9783a = 6378137.0d;

    public static String parseString(Intent intent, String str) {
        String stringExtra;
        if (intent != null && str != null && str.length() > 0 && intent.hasExtra(str) && (stringExtra = intent.getStringExtra(str)) != null) {
            return stringExtra;
        }
        IMLog.m6631d(TAG_PARSE_UTIL, "parse string error, key: " + str);
        return STRING_PARSE_ERROR;
    }

    public static int parseInt(Intent intent, String str) {
        if (intent != null && str != null && str.length() > 0 && intent.hasExtra(str)) {
            return intent.getIntExtra(str, 0);
        }
        IMLog.m6631d(TAG_PARSE_UTIL, "parse int error, key: " + str);
        return 0;
    }

    public static long parseLong(Intent intent, String str) {
        if (intent != null && str != null && str.length() > 0 && intent.hasExtra(str)) {
            return intent.getLongExtra(str, 0);
        }
        IMLog.m6631d(TAG_PARSE_UTIL, "parse long error, key: " + str);
        return 0;
    }

    public static double parseDouble(Intent intent, String str) {
        if (intent != null && str != null && str.length() > 0 && intent.hasExtra(str)) {
            return intent.getDoubleExtra(str, 0.0d);
        }
        IMLog.m6631d(TAG_PARSE_UTIL, "parse double error, key: " + str);
        return 0.0d;
    }

    public static String parseString(JSONObject jSONObject, String str) {
        if (jSONObject != null && jSONObject.has(str)) {
            try {
                return jSONObject.getString(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        IMLog.m6631d(TAG_PARSE_UTIL, "parse string error, key: " + str);
        return STRING_PARSE_ERROR;
    }

    public static boolean parseBoolean(JSONObject jSONObject, String str) {
        if (jSONObject != null && jSONObject.has(str)) {
            try {
                return jSONObject.getBoolean(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        IMLog.m6631d(TAG_PARSE_UTIL, "parse boolean error, key: " + str);
        return false;
    }

    public static double parseDouble(JSONObject jSONObject, String str) {
        return parseDouble(parseString(jSONObject, str));
    }

    public static long parseLong(JSONObject jSONObject, String str) {
        return parseLong(parseString(jSONObject, str));
    }

    public static int parseInt(JSONObject jSONObject, String str) {
        return parseInt(parseString(jSONObject, str));
    }

    public static double parseDouble(String str) {
        if (!(str == null || str.length() == 0 || str.trim().length() == 0)) {
            try {
                return Double.parseDouble(str.trim());
            } catch (Exception e) {
                e.printStackTrace();
                IMLog.m6631d(TAG_PARSE_UTIL, "parse double error, str: " + str);
            }
        }
        return 0.0d;
    }

    public static int parseInt(String str, int i) {
        if (IMTextUtil.isEmpty(str)) {
            return i;
        }
        try {
            return Integer.parseInt(str.trim());
        } catch (Exception | NumberFormatException unused) {
            return i;
        }
    }

    public static int parseInt(String str) {
        return parseInt(str, 0);
    }

    public static int parseInt(long j) {
        return Long.valueOf(j).intValue();
    }

    public static int parseInt(float f) {
        return Float.valueOf(f).intValue();
    }

    public static int parseInt(double d) {
        return Double.valueOf(d).intValue();
    }

    public static long parseLong(String str) {
        if (IMTextUtil.isEmpty(str)) {
            return 0;
        }
        try {
            return Long.parseLong(str.trim());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            IMLog.m6631d(TAG_PARSE_UTIL, "parse long error, str: " + str);
            return 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            IMLog.m6631d(TAG_PARSE_UTIL, "parse long error, str: " + str);
            return 0;
        }
    }

    public static double doubleValue(String str) {
        if (IMTextUtil.isEmpty(str)) {
            return 0.0d;
        }
        try {
            return new BigDecimal(str).doubleValue();
        } catch (NumberFormatException e) {
            e.printStackTrace();
            IMLog.m6631d(TAG_PARSE_UTIL, "parse double error, str: " + str);
            return 0.0d;
        }
    }

    public static String parseUrlForTrace(String str) {
        int indexOf;
        String str2 = "[url=" + str + Const.jaRight;
        if (!IMTextUtil.isEmpty(str) && (indexOf = str.indexOf("?")) > 0) {
            String[] split = str.substring(indexOf + 1).split(ParamKeys.SIGN_AND);
            if (split.length > 0) {
                for (int i = 0; i < split.length; i++) {
                    if (split[i].contains("regfrom") || split[i].contains("channel") || split[i].contains("psource")) {
                        str2 = str2 + Const.jaLeft + split[i] + Const.jaRight;
                    }
                }
            }
        }
        return str2;
    }

    public static int parseColor(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            if (str.contains(RConfigConstants.KEYWORD_COLOR_SIGN)) {
                return Color.parseColor(str.trim());
            }
            return Color.parseColor(RConfigConstants.KEYWORD_COLOR_SIGN + str);
        } catch (Exception e) {
            IMLog.m6633e(e);
            return 0;
        }
    }
}
