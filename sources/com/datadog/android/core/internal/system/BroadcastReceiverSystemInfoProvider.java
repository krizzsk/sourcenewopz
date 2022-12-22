package com.datadog.android.core.internal.system;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.PowerManager;
import com.datadog.android.core.internal.receiver.ThreadSafeReceiver;
import com.datadog.android.core.internal.system.SystemInfo;
import com.datadog.android.core.internal.utils.RuntimeUtilsKt;
import com.datadog.android.log.Logger;
import com.didi.hawaii.mapsdk.gesture.NNGestureClassfy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u001a\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo175978d2 = {"Lcom/datadog/android/core/internal/system/BroadcastReceiverSystemInfoProvider;", "Lcom/datadog/android/core/internal/receiver/ThreadSafeReceiver;", "Lcom/datadog/android/core/internal/system/SystemInfoProvider;", "()V", "systemInfo", "Lcom/datadog/android/core/internal/system/SystemInfo;", "getLatestSystemInfo", "handleBatteryIntent", "", "intent", "Landroid/content/Intent;", "handlePowerSaveIntent", "context", "Landroid/content/Context;", "onReceive", "register", "registerIntentFilter", "action", "", "unregister", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BroadcastReceiverSystemInfoProvider.kt */
public final class BroadcastReceiverSystemInfoProvider extends ThreadSafeReceiver implements SystemInfoProvider {

    /* renamed from: a */
    private SystemInfo f3583a = new SystemInfo((SystemInfo.BatteryStatus) null, 0, false, 7, (DefaultConstructorMarker) null);

    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        String action = intent == null ? null : intent.getAction();
        if (Intrinsics.areEqual((Object) action, (Object) "android.intent.action.BATTERY_CHANGED")) {
            m2367a(intent);
        } else if (Intrinsics.areEqual((Object) action, (Object) "android.os.action.POWER_SAVE_MODE_CHANGED")) {
            m2365a(context);
        } else {
            Logger sdkLogger = RuntimeUtilsKt.getSdkLogger();
            Logger.d$default(sdkLogger, "Received unknown broadcast intent: [" + action + VersionRange.RIGHT_CLOSED, (Throwable) null, (Map) null, 6, (Object) null);
        }
    }

    public void register(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        m2366a(context, "android.intent.action.BATTERY_CHANGED");
        if (Build.VERSION.SDK_INT >= 21) {
            m2366a(context, "android.os.action.POWER_SAVE_MODE_CHANGED");
        }
    }

    public void unregister(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        unregisterReceiver(context);
    }

    public SystemInfo getLatestSystemInfo() {
        return this.f3583a;
    }

    /* renamed from: a */
    private final void m2366a(Context context, String str) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(str);
        Intent registerReceiver = registerReceiver(context, intentFilter);
        if (registerReceiver != null) {
            onReceive(context, registerReceiver);
        }
    }

    /* renamed from: a */
    private final void m2367a(Intent intent) {
        int intExtra = intent.getIntExtra("status", 1);
        int intExtra2 = intent.getIntExtra("level", -1);
        int intExtra3 = intent.getIntExtra(NNGestureClassfy.SCALE_LABLE, 100);
        this.f3583a = SystemInfo.copy$default(this.f3583a, SystemInfo.BatteryStatus.Companion.fromAndroidStatus(intExtra), (intExtra2 * 100) / intExtra3, false, 4, (Object) null);
    }

    /* renamed from: a */
    private final void m2365a(Context context) {
        boolean z;
        if (Build.VERSION.SDK_INT >= 21) {
            Object systemService = context.getSystemService("power");
            PowerManager powerManager = systemService instanceof PowerManager ? (PowerManager) systemService : null;
            if (powerManager == null) {
                z = false;
            } else {
                z = powerManager.isPowerSaveMode();
            }
            this.f3583a = SystemInfo.copy$default(this.f3583a, (SystemInfo.BatteryStatus) null, 0, z, 3, (Object) null);
        }
    }
}
