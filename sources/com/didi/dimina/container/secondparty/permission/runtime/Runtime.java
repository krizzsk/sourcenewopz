package com.didi.dimina.container.secondparty.permission.runtime;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.secondparty.permission.runtime.option.RuntimeOption;
import com.didi.dimina.container.secondparty.permission.runtime.setting.AllRequest;
import com.didi.dimina.container.secondparty.permission.runtime.setting.SettingRequest;
import com.didi.dimina.container.secondparty.permission.source.Source;
import com.didi.sdk.apm.SystemUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Runtime implements RuntimeOption {

    /* renamed from: a */
    private static final PermissionRequestFactory f17387a;

    /* renamed from: b */
    private static List<String> f17388b;

    /* renamed from: c */
    private final Source f17389c;

    public interface PermissionRequestFactory {
        PermissionRequest create(Source source);
    }

    static {
        if (Build.VERSION.SDK_INT >= 23) {
            f17387a = new MRequestFactory();
        } else {
            f17387a = new LRequestFactory();
        }
    }

    public Runtime(Source source) {
        this.f17389c = source;
    }

    public PermissionRequest permission(String... strArr) {
        m12927a(strArr);
        return f17387a.create(this.f17389c).permission(strArr);
    }

    public PermissionRequest permission(String[]... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String[] strArr2 : strArr) {
            m12927a(strArr2);
            arrayList.addAll(Arrays.asList(strArr2));
        }
        return permission((String[]) arrayList.toArray(new String[0]));
    }

    public SettingRequest setting() {
        return new AllRequest(this.f17389c);
    }

    /* renamed from: a */
    private void m12927a(String... strArr) {
        if (f17388b == null) {
            f17388b = m12926a(this.f17389c.getContext());
        }
        if (strArr.length != 0) {
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                String str = strArr[i];
                if (f17388b.contains(str)) {
                    i++;
                } else {
                    throw new IllegalStateException(String.format("The permission %1$s is not registered in manifest.xml", new Object[]{str}));
                }
            }
            return;
        }
        throw new IllegalArgumentException("Please enter at least one permission.");
    }

    /* renamed from: a */
    private static List<String> m12926a(Context context) {
        try {
            String[] strArr = SystemUtils.getPackageInfo(context.getPackageManager(), Dimina.getConfig().getAdapterConfig().getWsgService().getPackageName(context), 4096).requestedPermissions;
            if (strArr != null && strArr.length != 0) {
                return Collections.unmodifiableList(Arrays.asList(strArr));
            }
            throw new IllegalStateException("You did not register any permissions in the manifest.xml.");
        } catch (PackageManager.NameNotFoundException unused) {
            throw new AssertionError("Package name cannot be found.");
        }
    }
}
