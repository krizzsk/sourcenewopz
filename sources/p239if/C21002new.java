package p239if;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.provider.Settings;
import android.view.Display;
import android.view.WindowManager;
import com.datadog.android.rum.RumAttributes;
import com.iproov.sdk.core.C19905this;
import com.jumio.core.environment.Environment;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import p066native.C2380do;
import p093switch.C3127throw;

/* renamed from: if.new */
/* compiled from: ClaimUtils */
public class C21002new {

    /* renamed from: if.new$do */
    /* compiled from: ClaimUtils */
    static /* synthetic */ class C21003do {

        /* renamed from: do */
        static final /* synthetic */ int[] f57279do;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                if.do[] r0 = p239if.C20994do.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f57279do = r0
                if.do r1 = p239if.C20994do.LIVENESS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f57279do     // Catch:{ NoSuchFieldError -> 0x001d }
                if.do r1 = p239if.C20994do.GENUINE_PRESENCE_ASSURANCE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p239if.C21002new.C21003do.<clinit>():void");
        }
    }

    /* renamed from: do */
    public static int m41067do(char c) {
        return c != '0' ? c != '1' ? c != 'b' ? c != 'c' ? c != 'g' ? c != 'm' ? c != 'r' ? c != 'y' ? R.color.iproov__black : R.color.iproov__yellow : R.color.iproov__red : R.color.iproov__magenta : R.color.iproov__green : R.color.iproov__cyan : R.color.iproov__blue : R.color.iproov__white : R.color.iproov__black;
    }

    /* renamed from: do */
    public static String m41068do(Context context, C20997for forR, double d, boolean z, C20994do doVar) {
        if (d < 0.75d) {
            return context.getResources().getString(z ? R.string.iproov__progress_streaming_slow : R.string.iproov__progress_streaming);
        } else if (d < 0.875d) {
            if (forR.equals(C20997for.ENROL)) {
                return context.getResources().getString(R.string.iproov__progress_finding_face);
            }
            return context.getResources().getString(R.string.iproov__progress_identifying_face);
        } else if (d < 0.94d) {
            if (forR.equals(C20997for.ENROL)) {
                return context.getResources().getString(R.string.iproov__progress_creating_identity);
            }
            return context.getResources().getString(R.string.iproov__progress_confirming_identity);
        } else if (d >= 0.975d) {
            return context.getResources().getString(R.string.iproov__progress_loading);
        } else {
            if (C21003do.f57279do[doVar.ordinal()] != 1) {
                return context.getResources().getString(R.string.iproov__progress_assessing_genuine_presence);
            }
            return context.getResources().getString(R.string.iproov__progress_assessing_liveness);
        }
    }

    /* renamed from: do */
    public static String m41069do(Context context, C21001if ifVar) {
        String str;
        if (ifVar.mo171508b() == null) {
            return "";
        }
        if (ifVar.m47668catch() == C20997for.ENROL) {
            str = context.getString(R.string.iproov__enrol);
        } else {
            str = context.getString(R.string.iproov__authenticate);
        }
        if (ifVar.mo171507a() != null) {
            return context.getString(R.string.iproov__message_format_with_username, new Object[]{str, ifVar.mo171507a(), ifVar.mo171508b()});
        }
        return context.getString(R.string.iproov__message_format, new Object[]{str, ifVar.mo171508b()});
    }

    /* renamed from: do */
    public static Map<String, String> m41070do(Context context, String str, C19905this thisR) {
        Point a = m41066a(context);
        HashMap hashMap = new HashMap();
        hashMap.put("platform", "Android");
        hashMap.put("name", Build.MODEL);
        hashMap.put("model", Build.BRAND);
        hashMap.put("language", Locale.getDefault().getLanguage());
        hashMap.put("language_file", context.getResources().getString(R.string.iproov__language_file));
        hashMap.put("manufacturer", Build.MANUFACTURER);
        hashMap.put("os", Build.DISPLAY);
        hashMap.put("type", Build.DEVICE);
        hashMap.put("dpi", context.getResources().getDisplayMetrics().toString());
        hashMap.put("width", String.valueOf(a.x));
        hashMap.put("height", String.valueOf(a.y));
        hashMap.put("version", Build.VERSION.RELEASE);
        hashMap.put("details", Settings.Secure.getString(context.getApplicationContext().getContentResolver(), "android_id"));
        hashMap.put("identifier", Settings.Secure.getString(context.getApplicationContext().getContentResolver(), "android_id"));
        hashMap.put("app_id", context.getPackageName());
        hashMap.put("app_version", String.format(TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(C3127throw.m4048do(context))}));
        hashMap.put("app_version_name", C3127throw.m4054if(context));
        hashMap.put("sdk_version", Environment.IPROOV_VERSION);
        hashMap.put("token", str);
        hashMap.put("language_version", "0.9.25");
        hashMap.put("gaze_x_buffer", "0.045");
        hashMap.put("transport", "socketio");
        hashMap.put("device_id", C2380do.m3041do(context));
        hashMap.put(RumAttributes.VARIANT, thisR.f54340do.f54342do);
        return hashMap;
    }

    /* renamed from: a */
    private static Point m41066a(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point;
    }
}
