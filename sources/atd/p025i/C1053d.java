package atd.p025i;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import atd.p025i.C1051c;
import atd.p046s0.C1172a;
import com.didi.sdk.apm.SystemUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* renamed from: atd.i.d */
public abstract class C1053d implements C1050b {
    /* renamed from: b */
    private void m436b(Context context) throws C1051c {
        List list;
        String packageName = context.getPackageName();
        try {
            PackageInfo packageInfo = SystemUtils.getPackageInfo(context.getPackageManager(), packageName, 4096);
            List<String> b = mo13784b();
            String[] strArr = packageInfo.requestedPermissions;
            if (strArr != null) {
                list = Arrays.asList(strArr);
            } else {
                list = Collections.emptyList();
            }
            for (String contains : b) {
                if (!list.contains(contains)) {
                    throw new C1051c(C1051c.C1052a.MISSING_PERMISSION, (Throwable) null);
                }
            }
            if (Build.VERSION.SDK_INT >= 23) {
                for (String checkSelfPermission : b) {
                    if (context.checkSelfPermission(checkSelfPermission) != 0) {
                        throw new C1051c(C1051c.C1052a.MISSING_PERMISSION, (Throwable) null);
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException(C1172a.m764a(-30795368843950L) + packageName, e);
        }
    }

    /* renamed from: a */
    public final Object mo13780a(Context context) throws C1051c {
        m436b(context);
        try {
            return mo13785c(context);
        } catch (SecurityException unused) {
            throw new C1051c(C1051c.C1052a.MISSING_PERMISSION, (Throwable) null);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract List<String> mo13784b();

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract Object mo13785c(Context context) throws C1051c;
}
