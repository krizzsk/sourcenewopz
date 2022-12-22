package com.datadog.android.core.internal.net.info;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.datadog.android.core.internal.persistence.DataWriter;
import com.datadog.android.core.internal.receiver.ThreadSafeReceiver;
import com.datadog.android.core.model.NetworkInfo;
import com.didi.dimina.container.bridge.network.NetWorkStateReceiver;
import com.didi.sdk.apm.SystemUtils;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0001\u001cB\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u001a\u0010\u0010\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\t\u0010\n¨\u0006\u001d"}, mo175978d2 = {"Lcom/datadog/android/core/internal/net/info/BroadcastReceiverNetworkInfoProvider;", "Lcom/datadog/android/core/internal/receiver/ThreadSafeReceiver;", "Lcom/datadog/android/core/internal/net/info/NetworkInfoProvider;", "dataWriter", "Lcom/datadog/android/core/internal/persistence/DataWriter;", "Lcom/datadog/android/core/model/NetworkInfo;", "(Lcom/datadog/android/core/internal/persistence/DataWriter;)V", "value", "networkInfo", "setNetworkInfo", "(Lcom/datadog/android/core/model/NetworkInfo;)V", "buildMobileNetworkInfo", "context", "Landroid/content/Context;", "subtype", "", "buildNetworkInfo", "activeNetworkInfo", "Landroid/net/NetworkInfo;", "getCellularTechnology", "", "getLatestNetworkInfo", "onReceive", "", "intent", "Landroid/content/Intent;", "register", "unregister", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BroadcastReceiverNetworkInfoProvider.kt */
public final class BroadcastReceiverNetworkInfoProvider extends ThreadSafeReceiver implements NetworkInfoProvider {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: c */
    private static final Set<Integer> f3494c = SetsKt.setOf(0, 4, 5, 2, 3);

    /* renamed from: d */
    private static final Set<Integer> f3495d = SetsKt.setOf(1, 2, 4, 7, 11, 16);

    /* renamed from: e */
    private static final Set<Integer> f3496e = SetsKt.setOf(3, 5, 6, 8, 9, 10, 12, 14, 15, 17);

    /* renamed from: f */
    private static final Set<Integer> f3497f = SetsKt.setOf(13, 18, 19);

    /* renamed from: g */
    private static final Set<Integer> f3498g = SetsKt.setOf(20);

    /* renamed from: h */
    private static final String f3499h = "Unknown Carrier Name";

    /* renamed from: a */
    private final DataWriter<NetworkInfo> f3500a;

    /* renamed from: b */
    private NetworkInfo f3501b = new NetworkInfo((NetworkInfo.Connectivity) null, (String) null, (Long) null, (Long) null, (Long) null, (Long) null, (String) null, 127, (DefaultConstructorMarker) null);

    /* renamed from: a */
    private final String m2332a(int i) {
        switch (i) {
            case 1:
                return "GPRS";
            case 2:
                return "Edge";
            case 3:
                return "UMTS";
            case 4:
                return "CDMA";
            case 5:
                return "CDMAEVDORev0";
            case 6:
                return "CDMAEVDORevA";
            case 7:
                return "CDMA1x";
            case 8:
                return "HSDPA";
            case 9:
                return "HSUPA";
            case 10:
                return "HSPA";
            case 11:
                return "iDen";
            case 12:
                return "CDMAEVDORevB";
            case 13:
                return "LTE";
            case 14:
                return "eHRPD";
            case 15:
                return "HSPA+";
            case 16:
                return "GSM";
            case 17:
                return "TD_SCDMA";
            case 18:
                return "IWLAN";
            case 19:
                return "LTE_CA";
            case 20:
                return "New Radio";
            default:
                return null;
        }
    }

    public BroadcastReceiverNetworkInfoProvider(DataWriter<NetworkInfo> dataWriter) {
        Intrinsics.checkNotNullParameter(dataWriter, "dataWriter");
        this.f3500a = dataWriter;
    }

    /* renamed from: a */
    private final void m2333a(NetworkInfo networkInfo) {
        this.f3501b = networkInfo;
        this.f3500a.write(networkInfo);
    }

    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("connectivity");
        android.net.NetworkInfo networkInfo = null;
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        if (connectivityManager != null) {
            networkInfo = SystemUtils.getActiveNetworkInfo(connectivityManager);
        }
        m2333a(m2331a(context, networkInfo));
    }

    public void register(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        onReceive(context, registerReceiver(context, new IntentFilter(NetWorkStateReceiver.ANDROID_NET_CHANGE_ACTION)));
    }

    public void unregister(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        unregisterReceiver(context);
    }

    public NetworkInfo getLatestNetworkInfo() {
        return this.f3501b;
    }

    /* renamed from: a */
    private final NetworkInfo m2331a(Context context, android.net.NetworkInfo networkInfo) {
        NetworkInfo networkInfo2;
        if (networkInfo == null || !networkInfo.isConnected()) {
            return new NetworkInfo(NetworkInfo.Connectivity.NETWORK_NOT_CONNECTED, (String) null, (Long) null, (Long) null, (Long) null, (Long) null, (String) null, 126, (DefaultConstructorMarker) null);
        }
        if (networkInfo.getType() == 1) {
            networkInfo2 = new NetworkInfo(NetworkInfo.Connectivity.NETWORK_WIFI, (String) null, (Long) null, (Long) null, (Long) null, (Long) null, (String) null, 126, (DefaultConstructorMarker) null);
        } else if (networkInfo.getType() == 9) {
            networkInfo2 = new NetworkInfo(NetworkInfo.Connectivity.NETWORK_ETHERNET, (String) null, (Long) null, (Long) null, (Long) null, (Long) null, (String) null, 126, (DefaultConstructorMarker) null);
        } else if (f3494c.contains(Integer.valueOf(networkInfo.getType()))) {
            return m2330a(context, networkInfo.getSubtype());
        } else {
            return new NetworkInfo(NetworkInfo.Connectivity.NETWORK_OTHER, (String) null, (Long) null, (Long) null, (Long) null, (Long) null, (String) null, 126, (DefaultConstructorMarker) null);
        }
        return networkInfo2;
    }

    /* renamed from: a */
    private final NetworkInfo m2330a(Context context, int i) {
        NetworkInfo.Connectivity connectivity;
        Long l;
        CharSequence simCarrierIdName;
        if (f3495d.contains(Integer.valueOf(i))) {
            connectivity = NetworkInfo.Connectivity.NETWORK_2G;
        } else if (f3496e.contains(Integer.valueOf(i))) {
            connectivity = NetworkInfo.Connectivity.NETWORK_3G;
        } else if (f3497f.contains(Integer.valueOf(i))) {
            connectivity = NetworkInfo.Connectivity.NETWORK_4G;
        } else if (f3498g.contains(Integer.valueOf(i))) {
            connectivity = NetworkInfo.Connectivity.NETWORK_5G;
        } else {
            connectivity = NetworkInfo.Connectivity.NETWORK_MOBILE_OTHER;
        }
        NetworkInfo.Connectivity connectivity2 = connectivity;
        String a = m2332a(i);
        if (Build.VERSION.SDK_INT < 28) {
            return new NetworkInfo(connectivity2, (String) null, (Long) null, (Long) null, (Long) null, (Long) null, a, 62, (DefaultConstructorMarker) null);
        }
        Object systemService = context.getSystemService("phone");
        TelephonyManager telephonyManager = systemService instanceof TelephonyManager ? (TelephonyManager) systemService : null;
        CharSequence charSequence = (telephonyManager == null || (simCarrierIdName = telephonyManager.getSimCarrierIdName()) == null) ? f3499h : simCarrierIdName;
        if (telephonyManager == null) {
            l = null;
        } else {
            l = Long.valueOf((long) telephonyManager.getSimCarrierId());
        }
        return new NetworkInfo(connectivity2, charSequence.toString(), l, (Long) null, (Long) null, (Long) null, a, 56, (DefaultConstructorMarker) null);
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo175978d2 = {"Lcom/datadog/android/core/internal/net/info/BroadcastReceiverNetworkInfoProvider$Companion;", "", "()V", "UNKNOWN_CARRIER_NAME", "", "known2GSubtypes", "", "", "known3GSubtypes", "known4GSubtypes", "known5GSubtypes", "knownMobileTypes", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BroadcastReceiverNetworkInfoProvider.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
