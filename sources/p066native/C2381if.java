package p066native;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;

/* renamed from: native.if */
/* compiled from: Preferences */
public class C2381if {

    /* renamed from: a */
    private static final int[] f4776a = {73, 80, 114, 111, 111, 118, 73, 110, 116, 101, 114, 110, 97, 108};

    /* renamed from: b */
    private final SharedPreferences f4777b;

    public C2381if(Context context) {
        this.f4777b = SystemUtils.getSharedPreferences(context, m3042a(), 0);
    }

    /* renamed from: a */
    private static String m3042a() {
        StringBuilder sb = new StringBuilder();
        for (int i : f4776a) {
            sb.append((char) i);
        }
        return sb.toString();
    }

    /* renamed from: break  reason: not valid java name */
    public String m46144break() {
        SharedPreferences sharedPreferences = this.f4777b;
        return sharedPreferences.getString(m3042a() + "_tooFarExpression", (String) null);
    }

    /* renamed from: case  reason: not valid java name */
    public String m46145case() {
        SharedPreferences sharedPreferences = this.f4777b;
        return sharedPreferences.getString(m3042a() + "_shouldLockAndPhotoExpression", (String) null);
    }

    /* renamed from: catch  reason: not valid java name */
    public boolean m46146catch() {
        SharedPreferences sharedPreferences = this.f4777b;
        return sharedPreferences.getBoolean(m3042a() + "_hasNotDeletedKey", true);
    }

    /* renamed from: class  reason: not valid java name */
    public boolean m46147class() {
        SharedPreferences sharedPreferences = this.f4777b;
        return sharedPreferences.getBoolean(m3042a() + "_debugAvailable", false);
    }

    /* renamed from: const  reason: not valid java name */
    public boolean m46148const() {
        SharedPreferences sharedPreferences = this.f4777b;
        return sharedPreferences.getBoolean(m3042a() + "_debugEnabled", false);
    }

    /* renamed from: do */
    public void mo23986do(boolean z) {
        SharedPreferences.Editor edit = this.f4777b.edit();
        edit.putBoolean(m3042a() + "_debugEnabled", z).apply();
    }

    /* renamed from: else  reason: not valid java name */
    public String m46149else() {
        SharedPreferences sharedPreferences = this.f4777b;
        return sharedPreferences.getString(m3042a() + "_shouldUnlockAndPhotoExpression", (String) null);
    }

    /* renamed from: final  reason: not valid java name */
    public boolean m46150final() {
        if (!m46148const()) {
            SharedPreferences sharedPreferences = this.f4777b;
            StringBuilder sb = new StringBuilder();
            sb.append(m3042a());
            sb.append("_loggingEnabled");
            return sharedPreferences.getBoolean(sb.toString(), false);
        }
    }

    /* renamed from: for  reason: not valid java name */
    public String m46151for() {
        SharedPreferences sharedPreferences = this.f4777b;
        return sharedPreferences.getString(m3042a() + "_cluxExpression", (String) null);
    }

    /* renamed from: goto  reason: not valid java name */
    public String m46152goto() {
        SharedPreferences sharedPreferences = this.f4777b;
        return sharedPreferences.getString(m3042a() + "_tooBrightExpression", (String) null);
    }

    /* renamed from: new  reason: not valid java name */
    public String m46153new() {
        SharedPreferences sharedPreferences = this.f4777b;
        return sharedPreferences.getString(m3042a() + "_estimatedBrightnessExpression", (String) null);
    }

    /* renamed from: super  reason: not valid java name */
    public void m46154super() {
        SharedPreferences.Editor edit = this.f4777b.edit();
        edit.putBoolean(m3042a() + "_hasNotDeletedKey", false).apply();
    }

    /* renamed from: this  reason: not valid java name */
    public String m46155this() {
        SharedPreferences sharedPreferences = this.f4777b;
        return sharedPreferences.getString(m3042a() + "_tooCloseExpression", (String) null);
    }

    /* renamed from: throw  reason: not valid java name */
    public boolean m46156throw() {
        SharedPreferences sharedPreferences = this.f4777b;
        return sharedPreferences.getBoolean(m3042a() + "_startFlashingAutomatically", false);
    }

    /* renamed from: try  reason: not valid java name */
    public String m46157try() {
        SharedPreferences sharedPreferences = this.f4777b;
        return sharedPreferences.getString(m3042a() + "_screenBrightnessExpression", (String) null);
    }

    /* renamed from: do */
    public boolean mo23987do() {
        SharedPreferences sharedPreferences = this.f4777b;
        return sharedPreferences.getBoolean(m3042a() + "_alwaysAllowFlashingStart", false);
    }
}
