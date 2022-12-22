package com.datadog.android.core.internal.net.info;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import com.datadog.android.core.internal.persistence.DataWriter;
import com.datadog.android.core.internal.utils.RuntimeUtilsKt;
import com.datadog.android.core.model.NetworkInfo;
import com.datadog.android.log.Logger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\b\u0001\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eB\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0017\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¢\u0006\u0002\u0010\u001aJ\u0017\u0010\u001b\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¢\u0006\u0002\u0010\u001aJ\u0017\u0010\u001c\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\t\u0010\n¨\u0006\u001f"}, mo175978d2 = {"Lcom/datadog/android/core/internal/net/info/CallbackNetworkInfoProvider;", "Landroid/net/ConnectivityManager$NetworkCallback;", "Lcom/datadog/android/core/internal/net/info/NetworkInfoProvider;", "dataWriter", "Lcom/datadog/android/core/internal/persistence/DataWriter;", "Lcom/datadog/android/core/model/NetworkInfo;", "(Lcom/datadog/android/core/internal/persistence/DataWriter;)V", "value", "lastNetworkInfo", "setLastNetworkInfo", "(Lcom/datadog/android/core/model/NetworkInfo;)V", "getLatestNetworkInfo", "getNetworkType", "Lcom/datadog/android/core/model/NetworkInfo$Connectivity;", "networkCapabilities", "Landroid/net/NetworkCapabilities;", "onCapabilitiesChanged", "", "network", "Landroid/net/Network;", "onLost", "register", "context", "Landroid/content/Context;", "resolveDownBandwidth", "", "(Landroid/net/NetworkCapabilities;)Ljava/lang/Long;", "resolveStrength", "resolveUpBandwidth", "unregister", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CallbackNetworkInfoProvider.kt */
public final class CallbackNetworkInfoProvider extends ConnectivityManager.NetworkCallback implements NetworkInfoProvider {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String ERROR_REGISTER = "We couldn't register a Network Callback, the network information reported will be less accurate.";
    public static final String ERROR_UNREGISTER = "We couldn't unregister the Network Callback";

    /* renamed from: a */
    private final DataWriter<NetworkInfo> f3502a;

    /* renamed from: b */
    private NetworkInfo f3503b = new NetworkInfo((NetworkInfo.Connectivity) null, (String) null, (Long) null, (Long) null, (Long) null, (Long) null, (String) null, 127, (DefaultConstructorMarker) null);

    public CallbackNetworkInfoProvider(DataWriter<NetworkInfo> dataWriter) {
        Intrinsics.checkNotNullParameter(dataWriter, "dataWriter");
        this.f3502a = dataWriter;
    }

    /* renamed from: a */
    private final void m2335a(NetworkInfo networkInfo) {
        this.f3503b = networkInfo;
        this.f3502a.write(networkInfo);
    }

    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.checkNotNullParameter(network, "network");
        Intrinsics.checkNotNullParameter(networkCapabilities, "networkCapabilities");
        super.onCapabilitiesChanged(network, networkCapabilities);
        m2335a(new NetworkInfo(m2338d(networkCapabilities), (String) null, (Long) null, m2334a(networkCapabilities), m2336b(networkCapabilities), m2337c(networkCapabilities), (String) null, 70, (DefaultConstructorMarker) null));
    }

    public void onLost(Network network) {
        Intrinsics.checkNotNullParameter(network, "network");
        super.onLost(network);
        m2335a(new NetworkInfo(NetworkInfo.Connectivity.NETWORK_NOT_CONNECTED, (String) null, (Long) null, (Long) null, (Long) null, (Long) null, (String) null, 126, (DefaultConstructorMarker) null));
    }

    public void register(Context context) {
        Context context2 = context;
        Intrinsics.checkNotNullParameter(context2, "context");
        Object systemService = context2.getSystemService("connectivity");
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        if (connectivityManager == null) {
            Logger.e$default(RuntimeUtilsKt.getDevLogger(), ERROR_REGISTER, (Throwable) null, (Map) null, 6, (Object) null);
            return;
        }
        try {
            connectivityManager.registerDefaultNetworkCallback(this);
            Network activeNetwork = connectivityManager.getActiveNetwork();
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
            if (activeNetwork != null && networkCapabilities != null) {
                onCapabilitiesChanged(activeNetwork, networkCapabilities);
            }
        } catch (SecurityException e) {
            Logger.e$default(RuntimeUtilsKt.getDevLogger(), ERROR_REGISTER, e, (Map) null, 4, (Object) null);
            m2335a(new NetworkInfo(NetworkInfo.Connectivity.NETWORK_OTHER, (String) null, (Long) null, (Long) null, (Long) null, (Long) null, (String) null, 126, (DefaultConstructorMarker) null));
        } catch (RuntimeException e2) {
            Logger.e$default(RuntimeUtilsKt.getDevLogger(), ERROR_REGISTER, e2, (Map) null, 4, (Object) null);
            m2335a(new NetworkInfo(NetworkInfo.Connectivity.NETWORK_OTHER, (String) null, (Long) null, (Long) null, (Long) null, (Long) null, (String) null, 126, (DefaultConstructorMarker) null));
        }
    }

    public void unregister(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("connectivity");
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        if (connectivityManager == null) {
            Logger.e$default(RuntimeUtilsKt.getDevLogger(), ERROR_UNREGISTER, (Throwable) null, (Map) null, 6, (Object) null);
            return;
        }
        try {
            connectivityManager.unregisterNetworkCallback(this);
        } catch (SecurityException e) {
            Logger.e$default(RuntimeUtilsKt.getDevLogger(), ERROR_UNREGISTER, e, (Map) null, 4, (Object) null);
        } catch (RuntimeException e2) {
            Logger.e$default(RuntimeUtilsKt.getDevLogger(), ERROR_UNREGISTER, e2, (Map) null, 4, (Object) null);
        }
    }

    public NetworkInfo getLatestNetworkInfo() {
        return this.f3503b;
    }

    /* renamed from: a */
    private final Long m2334a(NetworkCapabilities networkCapabilities) {
        if (networkCapabilities.getLinkUpstreamBandwidthKbps() > 0) {
            return Long.valueOf((long) networkCapabilities.getLinkUpstreamBandwidthKbps());
        }
        return null;
    }

    /* renamed from: b */
    private final Long m2336b(NetworkCapabilities networkCapabilities) {
        if (networkCapabilities.getLinkDownstreamBandwidthKbps() > 0) {
            return Long.valueOf((long) networkCapabilities.getLinkDownstreamBandwidthKbps());
        }
        return null;
    }

    /* renamed from: c */
    private final Long m2337c(NetworkCapabilities networkCapabilities) {
        if (Build.VERSION.SDK_INT < 29 || networkCapabilities.getSignalStrength() == Integer.MIN_VALUE) {
            return null;
        }
        return Long.valueOf((long) networkCapabilities.getSignalStrength());
    }

    /* renamed from: d */
    private final NetworkInfo.Connectivity m2338d(NetworkCapabilities networkCapabilities) {
        if (networkCapabilities.hasTransport(1)) {
            return NetworkInfo.Connectivity.NETWORK_WIFI;
        }
        if (networkCapabilities.hasTransport(3)) {
            return NetworkInfo.Connectivity.NETWORK_ETHERNET;
        }
        if (networkCapabilities.hasTransport(0)) {
            return NetworkInfo.Connectivity.NETWORK_CELLULAR;
        }
        if (networkCapabilities.hasTransport(2)) {
            return NetworkInfo.Connectivity.NETWORK_BLUETOOTH;
        }
        return NetworkInfo.Connectivity.NETWORK_OTHER;
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"Lcom/datadog/android/core/internal/net/info/CallbackNetworkInfoProvider$Companion;", "", "()V", "ERROR_REGISTER", "", "ERROR_UNREGISTER", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CallbackNetworkInfoProvider.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
