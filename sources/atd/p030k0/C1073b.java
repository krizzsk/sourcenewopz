package atd.p030k0;

import android.content.Context;
import atd.p046s0.C1172a;
import com.didi.sdk.apm.SystemUtils;

/* renamed from: atd.k0.b */
public final class C1073b implements C1072a {

    /* renamed from: a */
    private final String f317a;

    static {
        C1172a.m764a(-706612767836846L);
    }

    private C1073b(String str) {
        this.f317a = str == null ? C1172a.m764a(-706522573523630L) : str;
    }

    /* renamed from: a */
    public static C1073b m488a() {
        return m489a(C1172a.m764a(-706432379210414L));
    }

    /* renamed from: a */
    public static C1073b m489a(String str) {
        return new C1073b(str);
    }

    /* renamed from: a */
    public String mo13807a(Context context, String str) {
        return SystemUtils.getSharedPreferences(context, this.f317a, 0).getString(str, (String) null);
    }

    /* renamed from: a */
    public void mo13808a(Context context, String str, String str2) {
        SystemUtils.getSharedPreferences(context, this.f317a, 0).edit().putString(str, str2).apply();
    }
}
