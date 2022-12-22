package com.didichuxing.publicservice.general;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Base64;
import android.widget.Toast;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.publicservice.network.HttpHelper;
import com.google.gson.Gson;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public class AppUtils {
    private static final String SHARED_PREFENCE_NAME = "sdk_sharedpreference";
    private static final String TAG = AppUtils.class.getSimpleName();
    private static final Logger logger = LoggerFactory.getLogger("AppUtils");
    private static Gson mGson;
    private static SharedPreferences mPrefence;
    public static boolean printLog = true;

    public static void makeShortToast(Context context, String str) {
        if (context != null) {
            SystemUtils.showToast(Toast.makeText(context, str, 0));
        }
    }

    public static void makeLongToast(Context context, String str) {
        SystemUtils.showToast(Toast.makeText(context, str, 1));
    }

    public static <K, V> String map2UrlString(Map<K, V> map) {
        if (map == null || map.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("?");
        for (Map.Entry next : map.entrySet()) {
            sb.append(next.getKey());
            sb.append("=");
            sb.append(next.getValue());
            sb.append(ParamKeys.SIGN_AND);
        }
        return sb.substring(0, sb.lastIndexOf(ParamKeys.SIGN_AND));
    }

    public static void log(String str) {
        if (printLog) {
            logger.debug(str, new Object[0]);
        }
    }

    public static void logE(String str) {
        if (printLog) {
            logger.error(str, new Object[0]);
        }
    }

    public static String encodeParam(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void encodeParamsWithUTF8(Map<String, Object> map) {
        if (map != null) {
            try {
                if (map.size() > 0) {
                    for (Map.Entry next : map.entrySet()) {
                        String valueOf = String.valueOf(next.getValue());
                        if (!TextUtils.isEmpty(valueOf)) {
                            next.setValue(URLEncoder.encode(valueOf, "UTF-8"));
                        }
                    }
                }
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void saveIntToPreference(Context context, String str, int i) {
        if (context != null) {
            if (mPrefence == null) {
                mPrefence = SystemUtils.getSharedPreferences(context, SHARED_PREFENCE_NAME, 0);
            }
            mPrefence.edit().putInt(str, i).apply();
        }
    }

    public static int getIntFromPreference(Context context, String str) {
        if (context == null) {
            return -1;
        }
        if (mPrefence == null) {
            mPrefence = SystemUtils.getSharedPreferences(context, SHARED_PREFENCE_NAME, 0);
        }
        return mPrefence.getInt(str, -1);
    }

    public static void saveBooleanToPreference(Context context, String str, boolean z) {
        if (context != null) {
            if (mPrefence == null) {
                mPrefence = SystemUtils.getSharedPreferences(context, SHARED_PREFENCE_NAME, 0);
            }
            mPrefence.edit().putBoolean(str, z).apply();
        }
    }

    public static boolean getBooleanFromPreference(Context context, String str) {
        if (context == null) {
            return false;
        }
        if (mPrefence == null) {
            mPrefence = SystemUtils.getSharedPreferences(context, SHARED_PREFENCE_NAME, 0);
        }
        return mPrefence.getBoolean(str, false);
    }

    public static boolean getBooleanFromPreference(Context context, String str, boolean z) {
        if (context == null) {
            return false;
        }
        if (mPrefence == null) {
            mPrefence = SystemUtils.getSharedPreferences(context, SHARED_PREFENCE_NAME, 0);
        }
        return mPrefence.getBoolean(str, z);
    }

    public static void setObjectToSPreference(Context context, String str, Object obj) {
        String str2;
        if (context != null) {
            if (mPrefence == null) {
                mPrefence = SystemUtils.getSharedPreferences(context, SHARED_PREFENCE_NAME, 0);
            }
            if (mPrefence != null) {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(2048);
                    new ObjectOutputStream(byteArrayOutputStream).writeObject(obj);
                    str2 = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                    str2 = "";
                }
                SharedPreferences.Editor edit = mPrefence.edit();
                edit.putString(str, str2);
                edit.apply();
            }
        }
    }

    public static Object getObjectFromSPrerence(Context context, String str, Object obj) {
        if (context == null) {
            return null;
        }
        if (mPrefence == null) {
            mPrefence = SystemUtils.getSharedPreferences(context, SHARED_PREFENCE_NAME, 0);
        }
        SharedPreferences sharedPreferences = mPrefence;
        if (sharedPreferences == null) {
            return null;
        }
        try {
            String string = sharedPreferences.getString(str, "");
            if (!TextUtils.isEmpty(string)) {
                return new ObjectInputStream(new ByteArrayInputStream(Base64.decode(string.getBytes(), 0))).readObject();
            }
            throw new NullPointerException("get an empty string accroding key" + str);
        } catch (Exception e) {
            mPrefence.edit().remove(str).apply();
            SystemUtils.log(6, TAG, e.toString(), (Throwable) null, "com.didichuxing.publicservice.general.AppUtils", 206);
            return null;
        }
    }

    public static void saveStringToPreference(Context context, String str, String str2) {
        if (context != null) {
            if (mPrefence == null) {
                mPrefence = SystemUtils.getSharedPreferences(context, SHARED_PREFENCE_NAME, 0);
            }
            mPrefence.edit().putString(str, str2).apply();
        }
    }

    public static String getStringFromPreference(Context context, String str) {
        if (context == null) {
            return "";
        }
        if (mPrefence == null) {
            mPrefence = SystemUtils.getSharedPreferences(context, SHARED_PREFENCE_NAME, 0);
        }
        return mPrefence.getString(str, "");
    }

    public static <T> T parseResultData(HttpHelper.HttpResult httpResult, Class<T> cls) {
        if (cls == null || httpResult == null || httpResult.status == null || httpResult.status.code != 0) {
            return null;
        }
        log(TAG + " ========= response: 　" + httpResult.getOriginJson());
        try {
            return parseJson(httpResult.getOriginJson(), cls);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> T parseJson(String str, Class<T> cls) {
        if (TextUtils.isEmpty(str) || cls == null) {
            return null;
        }
        try {
            if (mGson == null) {
                mGson = new Gson();
            }
            T fromJson = mGson.fromJson(str, cls);
            if (fromJson != null) {
                log(TAG + " ====parsedJson: " + fromJson);
            }
            return fromJson;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String convertObjectToString(Object obj) {
        if (mGson == null) {
            mGson = new Gson();
        }
        return mGson.toJson(obj);
    }

    public static boolean networkStatusOK(Context context) {
        try {
            NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo((ConnectivityManager) context.getSystemService("connectivity"));
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable() || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
