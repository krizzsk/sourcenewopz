package xcrash;

import com.didi.sdk.apm.SystemUtils;

/* renamed from: xcrash.b */
/* compiled from: DefaultLogger */
class C3164b implements ILogger {
    C3164b() {
    }

    /* renamed from: v */
    public void mo38733v(String str, String str2) {
        SystemUtils.log(2, str, str2, (Throwable) null, "xcrash.DefaultLogger", 30);
    }

    /* renamed from: v */
    public void mo38734v(String str, String str2, Throwable th) {
        SystemUtils.log(2, str, str2, th, "xcrash.DefaultLogger", 35);
    }

    /* renamed from: d */
    public void mo38727d(String str, String str2) {
        SystemUtils.log(3, str, str2, (Throwable) null, "xcrash.DefaultLogger", 40);
    }

    /* renamed from: d */
    public void mo38728d(String str, String str2, Throwable th) {
        SystemUtils.log(3, str, str2, th, "xcrash.DefaultLogger", 45);
    }

    /* renamed from: i */
    public void mo38731i(String str, String str2) {
        SystemUtils.log(4, str, str2, (Throwable) null, "xcrash.DefaultLogger", 50);
    }

    /* renamed from: i */
    public void mo38732i(String str, String str2, Throwable th) {
        SystemUtils.log(4, str, str2, th, "xcrash.DefaultLogger", 55);
    }

    /* renamed from: w */
    public void mo38735w(String str, String str2) {
        SystemUtils.log(5, str, str2, (Throwable) null, "xcrash.DefaultLogger", 60);
    }

    /* renamed from: w */
    public void mo38736w(String str, String str2, Throwable th) {
        SystemUtils.log(5, str, str2, th, "xcrash.DefaultLogger", 65);
    }

    /* renamed from: e */
    public void mo38729e(String str, String str2) {
        SystemUtils.log(6, str, str2, (Throwable) null, "xcrash.DefaultLogger", 70);
    }

    /* renamed from: e */
    public void mo38730e(String str, String str2, Throwable th) {
        SystemUtils.log(6, str, str2, th, "xcrash.DefaultLogger", 75);
    }
}
