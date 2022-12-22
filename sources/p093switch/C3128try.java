package p093switch;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.Base64;
import com.iproov.sdk.IProov;
import com.iproov.sdk.cameray.Orientation;
import com.iproov.sdk.core.exception.InvalidOptionsException;
import com.iproov.sdk.logging.IPLog;
import java.util.ArrayList;
import java.util.List;
import kotlinx.coroutines.DebugKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: switch.try */
/* compiled from: JSONUtils */
public class C3128try {

    /* renamed from: do */
    public static final String f6959do = "try";

    /* renamed from: switch.try$do */
    /* compiled from: JSONUtils */
    static /* synthetic */ class C3129do {

        /* renamed from: do */
        static final /* synthetic */ int[] f6960do;

        /* renamed from: for  reason: not valid java name */
        static final /* synthetic */ int[] f61707for;

        /* renamed from: if */
        static final /* synthetic */ int[] f6961if;

        /* renamed from: new  reason: not valid java name */
        static final /* synthetic */ int[] f61708new;

        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|20|21|23|24|25|26|27|28|(2:29|30)|31|33|34|35|36|(3:37|38|40)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|23|24|25|26|27|28|(2:29|30)|31|33|34|35|36|(3:37|38|40)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|1|2|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|23|24|25|26|27|28|(2:29|30)|31|33|34|35|36|(3:37|38|40)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|23|24|25|26|27|28|(2:29|30)|31|33|34|35|36|37|38|40) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x005f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0069 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0073 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x008e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0098 */
        static {
            /*
                com.iproov.sdk.IProov$FaceDetector[] r0 = com.iproov.sdk.IProov.FaceDetector.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f61708new = r0
                r1 = 1
                com.iproov.sdk.IProov$FaceDetector r2 = com.iproov.sdk.IProov.FaceDetector.CLASSIC     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f61708new     // Catch:{ NoSuchFieldError -> 0x001d }
                com.iproov.sdk.IProov$FaceDetector r3 = com.iproov.sdk.IProov.FaceDetector.BLAZEFACE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f61708new     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.iproov.sdk.IProov$FaceDetector r4 = com.iproov.sdk.IProov.FaceDetector.ML_KIT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f61708new     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.iproov.sdk.IProov$FaceDetector r5 = com.iproov.sdk.IProov.FaceDetector.AUTO     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.iproov.sdk.IProov$Camera[] r4 = com.iproov.sdk.IProov.Camera.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f61707for = r4
                com.iproov.sdk.IProov$Camera r5 = com.iproov.sdk.IProov.Camera.EXTERNAL     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r4 = f61707for     // Catch:{ NoSuchFieldError -> 0x004e }
                com.iproov.sdk.IProov$Camera r5 = com.iproov.sdk.IProov.Camera.FRONT     // Catch:{ NoSuchFieldError -> 0x004e }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                com.iproov.sdk.cameray.Orientation[] r4 = com.iproov.sdk.cameray.Orientation.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f6961if = r4
                com.iproov.sdk.cameray.Orientation r5 = com.iproov.sdk.cameray.Orientation.LANDSCAPE     // Catch:{ NoSuchFieldError -> 0x005f }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x005f }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x005f }
            L_0x005f:
                int[] r4 = f6961if     // Catch:{ NoSuchFieldError -> 0x0069 }
                com.iproov.sdk.cameray.Orientation r5 = com.iproov.sdk.cameray.Orientation.REVERSE_PORTRAIT     // Catch:{ NoSuchFieldError -> 0x0069 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0069 }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x0069 }
            L_0x0069:
                int[] r4 = f6961if     // Catch:{ NoSuchFieldError -> 0x0073 }
                com.iproov.sdk.cameray.Orientation r5 = com.iproov.sdk.cameray.Orientation.REVERSE_LANDSCAPE     // Catch:{ NoSuchFieldError -> 0x0073 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0073 }
                r4[r5] = r2     // Catch:{ NoSuchFieldError -> 0x0073 }
            L_0x0073:
                int[] r4 = f6961if     // Catch:{ NoSuchFieldError -> 0x007d }
                com.iproov.sdk.cameray.Orientation r5 = com.iproov.sdk.cameray.Orientation.PORTRAIT     // Catch:{ NoSuchFieldError -> 0x007d }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x007d }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x007d }
            L_0x007d:
                com.iproov.sdk.IProov$Filter[] r3 = com.iproov.sdk.IProov.Filter.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f6960do = r3
                com.iproov.sdk.IProov$Filter r4 = com.iproov.sdk.IProov.Filter.SHADED     // Catch:{ NoSuchFieldError -> 0x008e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x008e }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x008e }
            L_0x008e:
                int[] r1 = f6960do     // Catch:{ NoSuchFieldError -> 0x0098 }
                com.iproov.sdk.IProov$Filter r3 = com.iproov.sdk.IProov.Filter.VIBRANT     // Catch:{ NoSuchFieldError -> 0x0098 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0098 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0098 }
            L_0x0098:
                int[] r0 = f6960do     // Catch:{ NoSuchFieldError -> 0x00a2 }
                com.iproov.sdk.IProov$Filter r1 = com.iproov.sdk.IProov.Filter.CLASSIC     // Catch:{ NoSuchFieldError -> 0x00a2 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a2 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a2 }
            L_0x00a2:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p093switch.C3128try.C3129do.<clinit>():void");
        }
    }

    /* renamed from: do */
    public static String m4075do(JSONObject jSONObject, String str, String str2) {
        return (jSONObject == null || jSONObject.isNull(str)) ? str2 : jSONObject.optString(str);
    }

    /* renamed from: if */
    public static String m4081if(JSONObject jSONObject, String str) {
        return m4075do(jSONObject, str, (String) null);
    }

    /* renamed from: do */
    public static Bitmap m4065do(JSONObject jSONObject, String str) throws JSONException {
        byte[] decode = Base64.decode(jSONObject.getString(str), 0);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    /* renamed from: if */
    public static void m4084if(JSONObject jSONObject, String str, IProov.Filter filter) {
        m4080do(jSONObject, str, (Object) m4061a(filter));
    }

    /* renamed from: if */
    public static void m4085if(JSONObject jSONObject, String str, Orientation orientation) {
        m4080do(jSONObject, str, (Object) m4062a(orientation));
    }

    /* renamed from: do */
    public static Bitmap m4066do(JSONObject jSONObject, String str, Bitmap bitmap) {
        try {
            return m4065do(jSONObject, str);
        } catch (JSONException unused) {
            return bitmap;
        }
    }

    /* renamed from: if */
    public static void m4086if(JSONObject jSONObject, String str, Integer num) {
        m4080do(jSONObject, str, (Object) m4074do(num));
    }

    /* renamed from: do */
    public static JSONObject m4079do(JSONObject jSONObject) {
        try {
            return new JSONObject(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: if */
    public static void m4082if(JSONObject jSONObject, String str, IProov.Camera camera) {
        m4080do(jSONObject, str, (Object) m4059a(camera));
    }

    /* renamed from: if */
    public static void m4083if(JSONObject jSONObject, String str, IProov.FaceDetector faceDetector) {
        m4080do(jSONObject, str, (Object) m4060a(faceDetector));
    }

    /* renamed from: do */
    public static IProov.Filter m4069do(JSONObject jSONObject, String str, IProov.Filter filter) {
        return m4057a(jSONObject.optString(str, m4061a(filter)), filter);
    }

    /* renamed from: do */
    public static int m4064do(JSONObject jSONObject, String str, int i) {
        try {
            return jSONObject.has(str) ? Color.parseColor(jSONObject.optString(str)) : i;
        } catch (IllegalArgumentException unused) {
            return i;
        }
    }

    /* renamed from: do */
    public static Orientation m4070do(JSONObject jSONObject, String str, Orientation orientation) {
        return m4058a(jSONObject.optString(str, m4062a(orientation)), orientation);
    }

    /* renamed from: do */
    public static IProov.Camera m4067do(JSONObject jSONObject, String str, IProov.Camera camera) {
        return m4055a(jSONObject.optString(str, m4059a(camera)), camera);
    }

    /* renamed from: do */
    public static IProov.FaceDetector m4068do(JSONObject jSONObject, String str, IProov.FaceDetector faceDetector) {
        return m4056a(jSONObject.optString(str, m4060a(faceDetector)), faceDetector);
    }

    /* renamed from: do */
    public static Float m4072do(JSONObject jSONObject, String str, Float f) {
        return (!jSONObject.has(str) || jSONObject.isNull(str)) ? f : Float.valueOf((float) jSONObject.optDouble(str));
    }

    /* renamed from: do */
    public static Double m4071do(JSONObject jSONObject, String str, Double d) {
        return (!jSONObject.has(str) || jSONObject.isNull(str)) ? d : Double.valueOf((double) ((float) jSONObject.optDouble(str)));
    }

    /* renamed from: do */
    public static Integer m4073do(JSONObject jSONObject, String str, Integer num) {
        return (!jSONObject.has(str) || jSONObject.isNull(str)) ? num : Integer.valueOf(jSONObject.optInt(str));
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0047  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.iproov.sdk.IProov.Filter m4057a(java.lang.String r4, com.iproov.sdk.IProov.Filter r5) {
        /*
            r4.hashCode()
            int r0 = r4.hashCode()
            r1 = -903579689(0xffffffffca2477d7, float:-2694645.8)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x002f
            r1 = 451310788(0x1ae674c4, float:9.5314415E-23)
            if (r0 == r1) goto L_0x0024
            r1 = 853620882(0x32e13892, float:2.6219173E-8)
            if (r0 == r1) goto L_0x0019
            goto L_0x0037
        L_0x0019:
            java.lang.String r0 = "classic"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L_0x0022
            goto L_0x0037
        L_0x0022:
            r4 = 2
            goto L_0x003a
        L_0x0024:
            java.lang.String r0 = "vibrant"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L_0x002d
            goto L_0x0037
        L_0x002d:
            r4 = 1
            goto L_0x003a
        L_0x002f:
            java.lang.String r0 = "shaded"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L_0x0039
        L_0x0037:
            r4 = -1
            goto L_0x003a
        L_0x0039:
            r4 = 0
        L_0x003a:
            if (r4 == 0) goto L_0x0047
            if (r4 == r3) goto L_0x0044
            if (r4 == r2) goto L_0x0041
            return r5
        L_0x0041:
            com.iproov.sdk.IProov$Filter r4 = com.iproov.sdk.IProov.Filter.CLASSIC
            return r4
        L_0x0044:
            com.iproov.sdk.IProov$Filter r4 = com.iproov.sdk.IProov.Filter.VIBRANT
            return r4
        L_0x0047:
            com.iproov.sdk.IProov$Filter r4 = com.iproov.sdk.IProov.Filter.SHADED
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p093switch.C3128try.m4057a(java.lang.String, com.iproov.sdk.IProov$Filter):com.iproov.sdk.IProov$Filter");
    }

    /* renamed from: a */
    private static String m4061a(IProov.Filter filter) {
        int i = C3129do.f6960do[filter.ordinal()];
        if (i != 1) {
            return i != 2 ? "classic" : "vibrant";
        }
        return "shaded";
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.iproov.sdk.cameray.Orientation m4058a(java.lang.String r4, com.iproov.sdk.cameray.Orientation r5) {
        /*
            r4.hashCode()
            int r0 = r4.hashCode()
            r1 = 3
            r2 = 2
            r3 = 1
            switch(r0) {
                case -675508834: goto L_0x002f;
                case -31410088: goto L_0x0024;
                case 729267099: goto L_0x0019;
                case 1430647483: goto L_0x000e;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x003a
        L_0x000e:
            java.lang.String r0 = "landscape"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L_0x0017
            goto L_0x003a
        L_0x0017:
            r4 = 3
            goto L_0x003b
        L_0x0019:
            java.lang.String r0 = "portrait"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L_0x0022
            goto L_0x003a
        L_0x0022:
            r4 = 2
            goto L_0x003b
        L_0x0024:
            java.lang.String r0 = "reverse_portrait"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L_0x002d
            goto L_0x003a
        L_0x002d:
            r4 = 1
            goto L_0x003b
        L_0x002f:
            java.lang.String r0 = "reverse_landscape"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L_0x0038
            goto L_0x003a
        L_0x0038:
            r4 = 0
            goto L_0x003b
        L_0x003a:
            r4 = -1
        L_0x003b:
            if (r4 == 0) goto L_0x004d
            if (r4 == r3) goto L_0x004a
            if (r4 == r2) goto L_0x0047
            if (r4 == r1) goto L_0x0044
            return r5
        L_0x0044:
            com.iproov.sdk.cameray.Orientation r4 = com.iproov.sdk.cameray.Orientation.LANDSCAPE
            return r4
        L_0x0047:
            com.iproov.sdk.cameray.Orientation r4 = com.iproov.sdk.cameray.Orientation.PORTRAIT
            return r4
        L_0x004a:
            com.iproov.sdk.cameray.Orientation r4 = com.iproov.sdk.cameray.Orientation.REVERSE_PORTRAIT
            return r4
        L_0x004d:
            com.iproov.sdk.cameray.Orientation r4 = com.iproov.sdk.cameray.Orientation.REVERSE_LANDSCAPE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p093switch.C3128try.m4058a(java.lang.String, com.iproov.sdk.cameray.Orientation):com.iproov.sdk.cameray.Orientation");
    }

    /* renamed from: a */
    private static String m4062a(Orientation orientation) {
        int i = C3129do.f6961if[orientation.ordinal()];
        if (i == 1) {
            return "landscape";
        }
        if (i != 2) {
            return i != 3 ? "portrait" : "reverse_landscape";
        }
        return "reverse_portrait";
    }

    /* renamed from: a */
    private static IProov.Camera m4055a(String str, IProov.Camera camera) {
        str.hashCode();
        if (str.equals("external")) {
            return IProov.Camera.EXTERNAL;
        }
        if (!str.equals("front")) {
            return camera;
        }
        return IProov.Camera.FRONT;
    }

    /* renamed from: a */
    private static String m4059a(IProov.Camera camera) {
        return C3129do.f61707for[camera.ordinal()] != 1 ? "front" : "external";
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.iproov.sdk.IProov.FaceDetector m4056a(java.lang.String r6, com.iproov.sdk.IProov.FaceDetector r7) {
        /*
            r6.hashCode()
            int r0 = r6.hashCode()
            r1 = 5
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            switch(r0) {
                case -1071713226: goto L_0x0047;
                case -563351033: goto L_0x003c;
                case 3005871: goto L_0x0031;
                case 103987415: goto L_0x0026;
                case 853620882: goto L_0x001b;
                case 1985755167: goto L_0x0010;
                default: goto L_0x000f;
            }
        L_0x000f:
            goto L_0x0052
        L_0x0010:
            java.lang.String r0 = "blazeface"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0019
            goto L_0x0052
        L_0x0019:
            r6 = 5
            goto L_0x0053
        L_0x001b:
            java.lang.String r0 = "classic"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0024
            goto L_0x0052
        L_0x0024:
            r6 = 4
            goto L_0x0053
        L_0x0026:
            java.lang.String r0 = "mlkit"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x002f
            goto L_0x0052
        L_0x002f:
            r6 = 3
            goto L_0x0053
        L_0x0031:
            java.lang.String r0 = "auto"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x003a
            goto L_0x0052
        L_0x003a:
            r6 = 2
            goto L_0x0053
        L_0x003c:
            java.lang.String r0 = "firebase"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0045
            goto L_0x0052
        L_0x0045:
            r6 = 1
            goto L_0x0053
        L_0x0047:
            java.lang.String r0 = "ml_kit"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0050
            goto L_0x0052
        L_0x0050:
            r6 = 0
            goto L_0x0053
        L_0x0052:
            r6 = -1
        L_0x0053:
            if (r6 == 0) goto L_0x0069
            if (r6 == r5) goto L_0x0069
            if (r6 == r4) goto L_0x0066
            if (r6 == r3) goto L_0x0069
            if (r6 == r2) goto L_0x0063
            if (r6 == r1) goto L_0x0060
            return r7
        L_0x0060:
            com.iproov.sdk.IProov$FaceDetector r6 = com.iproov.sdk.IProov.FaceDetector.BLAZEFACE
            return r6
        L_0x0063:
            com.iproov.sdk.IProov$FaceDetector r6 = com.iproov.sdk.IProov.FaceDetector.CLASSIC
            return r6
        L_0x0066:
            com.iproov.sdk.IProov$FaceDetector r6 = com.iproov.sdk.IProov.FaceDetector.AUTO
            return r6
        L_0x0069:
            com.iproov.sdk.IProov$FaceDetector r6 = com.iproov.sdk.IProov.FaceDetector.ML_KIT
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p093switch.C3128try.m4056a(java.lang.String, com.iproov.sdk.IProov$FaceDetector):com.iproov.sdk.IProov$FaceDetector");
    }

    /* renamed from: a */
    private static String m4060a(IProov.FaceDetector faceDetector) {
        int i = C3129do.f61708new[faceDetector.ordinal()];
        if (i == 1) {
            return "classic";
        }
        if (i != 2) {
            return i != 3 ? DebugKt.DEBUG_PROPERTY_VALUE_AUTO : "mlkit";
        }
        return "blazeface";
    }

    /* renamed from: do */
    public static String m4074do(Integer num) {
        return String.format("#%08X", new Object[]{num});
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r1 = r1.getResources().getIdentifier(r2, r4, r1.getPackageName());
     */
    /* renamed from: do */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int m4063do(android.content.Context r1, org.json.JSONObject r2, java.lang.String r3, java.lang.String r4, int r5) {
        /*
            r0 = 0
            java.lang.String r2 = r2.optString(r3, r0)
            if (r2 != 0) goto L_0x0008
            return r5
        L_0x0008:
            android.content.res.Resources r3 = r1.getResources()
            java.lang.String r1 = r1.getPackageName()
            int r1 = r3.getIdentifier(r2, r4, r1)
            if (r1 == 0) goto L_0x0017
            r5 = r1
        L_0x0017:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p093switch.C3128try.m4063do(android.content.Context, org.json.JSONObject, java.lang.String, java.lang.String, int):int");
    }

    /* renamed from: do */
    public static List<Object> m4076do(Context context, JSONObject jSONObject, String str, List<Object> list) throws InvalidOptionsException {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < optJSONArray.length()) {
            String optString = optJSONArray.optString(i, (String) null);
            if (optString != null) {
                arrayList.add(Base64.decode(optString, 2));
                i++;
            } else {
                throw new InvalidOptionsException(context, "Certificates array can not contain a null certificate, item must be a base 64 encoded string in DER format");
            }
        }
        return arrayList;
    }

    /* renamed from: do */
    public static void m4080do(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (JSONException unused) {
            IPLog.m39305w(f6959do, String.format("JSON Error adding value %s to key %s", new Object[]{obj, str}));
        }
    }

    /* renamed from: do */
    public static JSONArray m4078do(String[] strArr) {
        try {
            return new JSONArray(strArr);
        } catch (JSONException unused) {
            return new JSONArray();
        }
    }

    /* renamed from: do */
    public static JSONArray m4077do(float[] fArr) {
        try {
            return new JSONArray(fArr);
        } catch (JSONException unused) {
            return new JSONArray();
        }
    }
}
