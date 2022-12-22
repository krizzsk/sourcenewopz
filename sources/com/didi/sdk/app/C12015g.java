package com.didi.sdk.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import androidx.multidex.MultiDex;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.ZipUtil;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.didi.sdk.app.g */
/* compiled from: MultidexManager */
class C12015g {

    /* renamed from: a */
    public static final String f35229a = "multidex_load_dex.tmp";

    /* renamed from: b */
    public static final String f35230b = "main_to_load_dex_flag";

    /* renamed from: c */
    private static final String f35231c = "MultidexManager";

    /* renamed from: d */
    private static final String f35232d = "multidex.version";

    /* renamed from: e */
    private static final long f35233e = -1;

    /* renamed from: f */
    private static final boolean f35234f = m24934a(System.getProperty("java.vm.version"));

    C12015g() {
    }

    /* renamed from: a */
    public static void m24931a(Context context) {
        if (context != null) {
            if (m24936b(context)) {
                SystemUtils.log(3, f35231c, "need to install dex!", (Throwable) null, "com.didi.sdk.app.MultidexManager", 48);
                m24939e(context);
                try {
                    Intent intent = new Intent(context, Class.forName("com.didi.sdk.app.DidiLoadDexActivity"));
                    intent.putExtra(f35230b, 1);
                    intent.setFlags(268435456);
                    context.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                m24938d(context);
            }
            if (Build.VERSION.SDK_INT < 21) {
                MultiDex.install(context);
                SystemUtils.log(3, f35231c, "main process install done!", (Throwable) null, "com.didi.sdk.app.MultidexManager", 69);
            }
        }
    }

    /* renamed from: d */
    private static void m24938d(Context context) {
        File file = new File(context.getCacheDir().getAbsolutePath(), f35229a);
        try {
            SystemUtils.log(3, f35231c, "checkUntilLoadDexSuccess: >>> ", (Throwable) null, "com.didi.sdk.app.MultidexManager", 83);
            int i = 0;
            while (file.exists()) {
                Thread.sleep((long) 100);
                i++;
                SystemUtils.log(3, f35231c, "checkUntilLoadDexSuccess: sleep count = " + i, (Throwable) null, "com.didi.sdk.app.MultidexManager", 87);
            }
            SystemUtils.log(3, f35231c, "checkUntilLoadDexSuccess: 轮循结束，等待时间 " + (100 * i), (Throwable) null, "com.didi.sdk.app.MultidexManager", 90);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: e */
    private static void m24939e(Context context) {
        try {
            File file = new File(context.getCacheDir().getAbsolutePath(), f35229a);
            if (!file.exists()) {
                SystemUtils.log(3, f35231c, "newTempFile: multidex_load_dex.tmp", (Throwable) null, "com.didi.sdk.app.MultidexManager", 105);
                file.createNewFile();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    public static boolean m24936b(Context context) {
        return m24940f(context) && !f35234f;
    }

    /* renamed from: f */
    private static boolean m24940f(Context context) {
        ApplicationInfo applicationInfo;
        if (context == null || (applicationInfo = context.getApplicationInfo()) == null) {
            return false;
        }
        File file = new File(applicationInfo.sourceDir);
        try {
            boolean a = m24932a(context, file, m24935b(file), "");
            SystemUtils.log(3, f35231c, "apk is cover installed:" + a, (Throwable) null, "com.didi.sdk.app.MultidexManager", 137);
            return a;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m24932a(Context context, File file, long j, String str) {
        SharedPreferences g = m24941g(context);
        if (g.getLong(str + "timestamp", -1) == m24930a(file)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("crc");
            return g.getLong(sb.toString(), -1) != j;
        }
    }

    /* renamed from: g */
    private static SharedPreferences m24941g(Context context) {
        return context.getSharedPreferences(f35232d, Build.VERSION.SDK_INT < 11 ? 0 : 4);
    }

    /* renamed from: a */
    private static long m24930a(File file) {
        long lastModified = file.lastModified();
        return lastModified == -1 ? lastModified - 1 : lastModified;
    }

    /* renamed from: b */
    private static long m24935b(File file) throws IOException {
        long zipCrc = ZipUtil.getZipCrc(file);
        return zipCrc == -1 ? zipCrc - 1 : zipCrc;
    }

    /* renamed from: a */
    public static boolean m24933a(Intent intent) {
        if (intent == null) {
            return false;
        }
        try {
            return intent.getIntExtra(f35230b, 0) == 1;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: c */
    public static void m24937c(Context context) {
        try {
            File file = new File(context.getCacheDir().getAbsolutePath(), f35229a);
            if (file.exists()) {
                file.delete();
                SystemUtils.log(3, f35231c, "deleteTempFile: multidex_load_dex.tmp", (Throwable) null, "com.didi.sdk.app.MultidexManager", 199);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    private static boolean m24934a(String str) {
        boolean z = false;
        if (str != null) {
            Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(str);
            if (matcher.matches()) {
                try {
                    int parseInt = Integer.parseInt(matcher.group(1));
                    int parseInt2 = Integer.parseInt(matcher.group(2));
                    if (parseInt > 2 || (parseInt == 2 && parseInt2 >= 1)) {
                        z = true;
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("VM with version ");
        sb.append(str);
        sb.append(z ? " has multidex support" : " does not have multidex support");
        SystemUtils.log(4, "MultiDex", sb.toString(), (Throwable) null, "com.didi.sdk.app.MultidexManager", 220);
        return z;
    }
}
