package com.didi.map.global.flow.scene.order.bluetooth_meet;

import android.content.Context;
import android.os.Build;
import com.didi.map.global.component.bluetooth.apollo.BluetoothApolloUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\u001a\u0019\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005\u001a\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, mo175978d2 = {"getBluetoothPermissions", "", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)[Ljava/lang/String;", "isLocationInfoTimeAvailable", "", "time", "", "sdk-mapflow_release"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BTMUtils.kt */
public final class BTMUtilsKt {
    public static final String[] getBluetoothPermissions(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (Build.VERSION.SDK_INT < 31 || context.getApplicationInfo().targetSdkVersion < 31) ? new String[0] : new String[]{"android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT", "android.permission.BLUETOOTH_ADVERTISE"};
    }

    public static final boolean isLocationInfoTimeAvailable(long j) {
        return Math.abs(System.currentTimeMillis() - j) <= BluetoothApolloUtil.getEngineValidTimeInterval();
    }
}
