package rui.util;

import com.didi.sdk.apm.SystemUtils;
import rui.debug.RUIDebugControl;

/* renamed from: rui.util.Util */
public class C3022Util {
    public static int blue(int i) {
        return i & 255;
    }

    public static <V> V getGeneric(String str, Object obj, String str2) {
        if (obj == null) {
            return null;
        }
        return obj;
    }

    public static int green(int i) {
        return (i >> 8) & 255;
    }

    public static int red(int i) {
        return (i >> 16) & 255;
    }

    public static float[] imageFloatArray(float[] fArr) {
        int length = fArr.length;
        float[] fArr2 = new float[length];
        for (int i = 0; i < length; i++) {
            fArr2[i] = fArr[(length - i) - 1];
        }
        return fArr2;
    }

    public static String unicodeToString(String str) {
        try {
            String replace = str.replace("0x", "\\");
            StringBuilder sb = new StringBuilder();
            String[] split = replace.split("\\\\u");
            for (int i = 1; i < split.length; i++) {
                sb.append((char) Integer.parseInt(split[i], 16));
            }
            return sb.toString();
        } catch (Exception e) {
            if (!RUIDebugControl.isDebug()) {
                return str;
            }
            throw new RuntimeException(e);
        }
    }

    public static boolean isObjectEquals(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: a */
    private static void m3858a(String str, Object obj, String str2, ClassCastException classCastException) {
        StringBuilder sb = new StringBuilder();
        sb.append("Key ");
        String str3 = str;
        sb.append(str);
        sb.append(" expected ");
        sb.append(str2);
        sb.append(" but valueAt was a ");
        sb.append(obj.getClass().getName());
        sb.append(".");
        SystemUtils.log(5, "typeWarning", sb.toString(), (Throwable) null, "rui.util.Util", 130);
        SystemUtils.log(5, "typeWarning", "Attempt to cast generated internal exception:", classCastException, "rui.util.Util", 131);
    }
}
