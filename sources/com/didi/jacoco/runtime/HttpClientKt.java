package com.didi.jacoco.runtime;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.didi.sdk.apm.SystemUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jacoco.agent.p086rt.internal_8ff85ea.Offline;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, mo175978d2 = {"getPackageInfo", "Landroid/content/pm/PackageInfo;", "Landroid/content/Context;", "jacoco-runtime_release"}, mo175979k = 2, mo175980mv = {1, 1, 16})
/* compiled from: HttpClient.kt */
public final class HttpClientKt {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4853155099063751376L, "com/didi/jacoco/runtime/HttpClientKt", 3);
        $jacocoData = probes;
        return probes;
    }

    public static final PackageInfo getPackageInfo(Context context) {
        boolean[] $jacocoInit = $jacocoInit();
        Intrinsics.checkParameterIsNotNull(context, "$this$getPackageInfo");
        $jacocoInit[0] = true;
        PackageManager packageManager = context.getPackageManager();
        $jacocoInit[1] = true;
        PackageInfo packageInfo = SystemUtils.getPackageInfo(packageManager, context.getPackageName(), 0);
        Intrinsics.checkExpressionValueIsNotNull(packageInfo, "packageManager.getPackageInfo(this.packageName, 0)");
        $jacocoInit[2] = true;
        return packageInfo;
    }
}
