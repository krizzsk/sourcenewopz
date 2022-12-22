package com.didiglobal.privacy.disclosure;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.payment.wallet.global.prepaidcard.PrepaidConstant;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class DisclosureSpUtils {

    /* renamed from: a */
    private static final String f50475a = "privacy_disclosure_share_data";

    /* renamed from: b */
    private static final String f50476b = "has_agreed_for_";

    /* renamed from: c */
    private static final String f50477c = "disclosure_times_for_";

    /* renamed from: d */
    private static final String f50478d = "apollo_enable_for_";

    /* renamed from: e */
    private static final String f50479e = "apollo_most_disclosure_times";

    /* renamed from: f */
    private static final String f50480f = "need_extra_upload";

    /* renamed from: g */
    private static final String f50481g = "upload_info_appid";

    /* renamed from: h */
    private static final String f50482h = "upload_info_permission_type";

    /* renamed from: i */
    private static final String f50483i = "upload_info_current_permission_status";

    /* renamed from: j */
    private static final String f50484j = "upload_info_pop_content";

    /* renamed from: k */
    private static final String f50485k = "upload_info_user_action";

    /* renamed from: l */
    private static final String f50486l = "upload_info_pop_time";

    /* renamed from: m */
    private static final String f50487m = "upload_info_click_time";

    /* renamed from: c */
    private static String m36299c(Context context) {
        return f50479e;
    }

    /* renamed from: a */
    static boolean m36294a(Context context, IPrivacyType iPrivacyType) {
        return ((Boolean) get(context, m36290a(iPrivacyType), false)).booleanValue();
    }

    /* renamed from: b */
    static int m36295b(Context context, IPrivacyType iPrivacyType) {
        return ((Integer) get(context, m36297b(iPrivacyType), 0)).intValue();
    }

    /* renamed from: a */
    static void m36292a(Context context, IPrivacyType iPrivacyType, boolean z) {
        put(context, m36290a(iPrivacyType), Boolean.valueOf(z));
    }

    /* renamed from: c */
    static void m36301c(Context context, IPrivacyType iPrivacyType) {
        put(context, m36297b(iPrivacyType), Integer.valueOf(m36295b(context, iPrivacyType) + 1));
    }

    /* renamed from: a */
    private static String m36290a(IPrivacyType iPrivacyType) {
        return f50476b + iPrivacyType.getTypeId();
    }

    /* renamed from: b */
    private static String m36297b(IPrivacyType iPrivacyType) {
        return f50477c + iPrivacyType.getTypeId();
    }

    /* renamed from: d */
    static boolean m36303d(Context context, IPrivacyType iPrivacyType) {
        Map<String, Boolean> privacyTypeIdApolloEnableDefautValue = PrivacyDisclosureManager.getInitParam().getPrivacyTypeIdApolloEnableDefautValue();
        return ((Boolean) get(context, m36300c(iPrivacyType), Boolean.valueOf(privacyTypeIdApolloEnableDefautValue.containsKey(iPrivacyType.getTypeId()) ? privacyTypeIdApolloEnableDefautValue.get(iPrivacyType.getTypeId()).booleanValue() : false))).booleanValue();
    }

    /* renamed from: b */
    static void m36298b(Context context, IPrivacyType iPrivacyType, boolean z) {
        put(context, m36300c(iPrivacyType), Boolean.valueOf(z));
    }

    /* renamed from: a */
    static int m36289a(Context context) {
        return ((Integer) get(context, m36299c(context), -1)).intValue();
    }

    /* renamed from: a */
    static void m36291a(Context context, int i) {
        put(context, m36299c(context), Integer.valueOf(i));
    }

    /* renamed from: c */
    private static String m36300c(IPrivacyType iPrivacyType) {
        return f50478d + iPrivacyType.getTypeId();
    }

    /* renamed from: a */
    static void m36293a(Context context, boolean z) {
        put(context, f50480f, Boolean.valueOf(z));
    }

    /* renamed from: d */
    private static boolean m36302d(Context context) {
        return ((Boolean) get(context, f50480f, false)).booleanValue();
    }

    public static void setKeyUploadInfo(Context context, UploadParam uploadParam) {
        if (uploadParam != null) {
            put(context, f50481g, Integer.valueOf(uploadParam.getAppId()));
            put(context, f50482h, uploadParam.getPermissionType());
            put(context, f50483i, Integer.valueOf(uploadParam.getCurrentPermissionStatus()));
            put(context, f50484j, uploadParam.getPopContent());
            put(context, f50485k, Integer.valueOf(uploadParam.getUserAction()));
            put(context, f50486l, Long.valueOf(uploadParam.getPopTime()));
            put(context, f50487m, Long.valueOf(uploadParam.getClickTime()));
            m36293a(context, true);
        }
    }

    /* renamed from: b */
    static UploadParam m36296b(Context context) {
        if (!m36302d(context)) {
            return null;
        }
        UploadParam uploadParam = new UploadParam();
        try {
            uploadParam.setAppId(((Integer) get(context, f50481g, 0)).intValue());
            uploadParam.setPermissionType(((String) get(context, f50482h, "")) + "ExtraUploaded");
            uploadParam.setCurrentPermissionStatus(((Integer) get(context, f50483i, 0)).intValue());
            uploadParam.setPopContent((String) get(context, f50484j, ""));
            uploadParam.setUserAction(((Integer) get(context, f50485k, 0)).intValue());
            uploadParam.setPopTime(((Long) get(context, f50486l, 0L)).longValue());
            uploadParam.setClickTime(((Long) get(context, f50487m, 0L)).longValue());
            return uploadParam;
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean put(Context context, String str, Object obj) {
        if (obj == null || str == null) {
            return false;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(f50475a, 0).edit();
        if (obj instanceof String) {
            edit.putString(str, (String) obj);
        } else if (obj instanceof Integer) {
            edit.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Boolean) {
            edit.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Float) {
            edit.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Long) {
            edit.putLong(str, ((Long) obj).longValue());
        } else {
            edit.putString(str, obj.toString());
        }
        SharedPreferencesCompat.apply(edit);
        return true;
    }

    public static Object get(Context context, String str, Object obj) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(f50475a, 0);
        if (obj instanceof String) {
            return sharedPreferences.getString(str, (String) null);
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(sharedPreferences.getInt(str, ((Integer) obj).intValue()));
        }
        if (obj instanceof Boolean) {
            return Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue()));
        }
        if (obj instanceof Float) {
            return Float.valueOf(sharedPreferences.getFloat(str, ((Float) obj).floatValue()));
        }
        if (obj instanceof Long) {
            return Long.valueOf(sharedPreferences.getLong(str, ((Long) obj).longValue()));
        }
        return null;
    }

    public static void remove(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences(f50475a, 0).edit();
        edit.remove(str);
        SharedPreferencesCompat.apply(edit);
    }

    public static void clear(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences(f50475a, 0).edit();
        edit.clear();
        SharedPreferencesCompat.apply(edit);
    }

    public static boolean contains(Context context, String str) {
        return context.getSharedPreferences(f50475a, 0).contains(str);
    }

    public static Map<String, ?> getAll(Context context) {
        return context.getSharedPreferences(f50475a, 0).getAll();
    }

    private static class SharedPreferencesCompat {
        private static final Method sApplyMethod = findApplyMethod();

        private SharedPreferencesCompat() {
        }

        private static Method findApplyMethod() {
            try {
                return SharedPreferences.Editor.class.getMethod(PrepaidConstant.SCENE_APPLY, new Class[0]);
            } catch (NoSuchMethodException unused) {
                return null;
            }
        }

        public static void apply(SharedPreferences.Editor editor) {
            try {
                if (sApplyMethod != null) {
                    sApplyMethod.invoke(editor, new Object[0]);
                    return;
                }
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
            editor.apply();
        }
    }
}
