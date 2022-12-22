package com.datadog.android;

import androidx.core.app.NotificationCompat;
import com.datadog.android.core.internal.net.RequestUniqueIdentifierKt;
import com.datadog.android.rum.GlobalRum;
import com.datadog.android.rum.RumMonitor;
import com.datadog.android.rum.internal.domain.event.ResourceTiming;
import com.datadog.android.rum.internal.monitor.AdvancedRumMonitor;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

@Metadata(mo175977d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u00015B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\b\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J*\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J \u0010#\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J&\u0010\u000b\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u00032\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&H\u0016J\u0018\u0010\f\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u0003H\u0016J\u0018\u0010(\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u0006H\u0016J\u0010\u0010*\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010+\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u001a\u0010/\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0010\u00102\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u00103\u001a\u00020\u0016H\u0002J\b\u00104\u001a\u00020\u0016H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u00066"}, mo175978d2 = {"Lcom/datadog/android/DatadogEventListener;", "Lokhttp3/EventListener;", "key", "", "(Ljava/lang/String;)V", "bodyEnd", "", "bodyStart", "callStart", "connEnd", "connStart", "dnsEnd", "dnsStart", "headersEnd", "headersStart", "getKey", "()Ljava/lang/String;", "sslEnd", "sslStart", "buildTiming", "Lcom/datadog/android/rum/internal/domain/event/ResourceTiming;", "callEnd", "", "call", "Lokhttp3/Call;", "callFailed", "ioe", "Ljava/io/IOException;", "connectEnd", "inetSocketAddress", "Ljava/net/InetSocketAddress;", "proxy", "Ljava/net/Proxy;", "protocol", "Lokhttp3/Protocol;", "connectStart", "domainName", "inetAddressList", "", "Ljava/net/InetAddress;", "responseBodyEnd", "byteCount", "responseBodyStart", "responseHeadersEnd", "response", "Lokhttp3/Response;", "responseHeadersStart", "secureConnectEnd", "handshake", "Lokhttp3/Handshake;", "secureConnectStart", "sendTiming", "sendWaitForResourceTimingEvent", "Factory", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DatadogEventListener.kt */
public final class DatadogEventListener extends EventListener {

    /* renamed from: a */
    private final String f3378a;

    /* renamed from: b */
    private long f3379b;

    /* renamed from: c */
    private long f3380c;

    /* renamed from: d */
    private long f3381d;

    /* renamed from: e */
    private long f3382e;

    /* renamed from: f */
    private long f3383f;

    /* renamed from: g */
    private long f3384g;

    /* renamed from: h */
    private long f3385h;

    /* renamed from: i */
    private long f3386i;

    /* renamed from: j */
    private long f3387j;

    /* renamed from: k */
    private long f3388k;

    /* renamed from: l */
    private long f3389l;

    public DatadogEventListener(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.f3378a = str;
    }

    public final String getKey() {
        return this.f3378a;
    }

    public void callStart(Call call) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        super.callStart(call);
        m2284a();
        this.f3379b = System.nanoTime();
    }

    public void dnsStart(Call call, String str) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(str, "domainName");
        super.dnsStart(call, str);
        m2284a();
        this.f3380c = System.nanoTime();
    }

    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(str, "domainName");
        Intrinsics.checkNotNullParameter(list, "inetAddressList");
        super.dnsEnd(call, str, list);
        this.f3381d = System.nanoTime();
    }

    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        super.connectStart(call, inetSocketAddress, proxy);
        m2284a();
        this.f3382e = System.nanoTime();
    }

    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        super.connectEnd(call, inetSocketAddress, proxy, protocol);
        this.f3383f = System.nanoTime();
    }

    public void secureConnectStart(Call call) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        super.secureConnectStart(call);
        m2284a();
        this.f3384g = System.nanoTime();
    }

    public void secureConnectEnd(Call call, Handshake handshake) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        super.secureConnectEnd(call, handshake);
        this.f3385h = System.nanoTime();
    }

    public void responseHeadersStart(Call call) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        super.responseHeadersStart(call);
        m2284a();
        this.f3386i = System.nanoTime();
    }

    public void responseHeadersEnd(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(response, "response");
        super.responseHeadersEnd(call, response);
        this.f3387j = System.nanoTime();
        if (response.code() >= 400) {
            m2285b();
        }
    }

    public void responseBodyStart(Call call) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        super.responseBodyStart(call);
        m2284a();
        this.f3388k = System.nanoTime();
    }

    public void responseBodyEnd(Call call, long j) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        super.responseBodyEnd(call, j);
        this.f3389l = System.nanoTime();
    }

    public void callEnd(Call call) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        super.callEnd(call);
        m2285b();
    }

    public void callFailed(Call call, IOException iOException) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(iOException, "ioe");
        super.callFailed(call, iOException);
        m2285b();
    }

    /* renamed from: a */
    private final void m2284a() {
        RumMonitor rumMonitor = GlobalRum.get();
        AdvancedRumMonitor advancedRumMonitor = rumMonitor instanceof AdvancedRumMonitor ? (AdvancedRumMonitor) rumMonitor : null;
        if (advancedRumMonitor != null) {
            advancedRumMonitor.waitForResourceTiming(this.f3378a);
        }
    }

    /* renamed from: b */
    private final void m2285b() {
        ResourceTiming c = m2286c();
        RumMonitor rumMonitor = GlobalRum.get();
        AdvancedRumMonitor advancedRumMonitor = rumMonitor instanceof AdvancedRumMonitor ? (AdvancedRumMonitor) rumMonitor : null;
        if (advancedRumMonitor != null) {
            advancedRumMonitor.addResourceTiming(this.f3378a, c);
        }
    }

    /* renamed from: c */
    private final ResourceTiming m2286c() {
        Pair pair;
        Pair pair2;
        long j;
        Pair pair3;
        long j2;
        Pair pair4;
        Pair pair5;
        long j3 = this.f3380c;
        if (j3 == 0) {
            pair = TuplesKt.m42317to(0L, 0L);
        } else {
            pair = TuplesKt.m42317to(Long.valueOf(j3 - this.f3379b), Long.valueOf(this.f3381d - this.f3380c));
        }
        long longValue = ((Number) pair.component1()).longValue();
        long longValue2 = ((Number) pair.component2()).longValue();
        long j4 = this.f3382e;
        if (j4 == 0) {
            pair2 = TuplesKt.m42317to(0L, 0L);
        } else {
            pair2 = TuplesKt.m42317to(Long.valueOf(j4 - this.f3379b), Long.valueOf(this.f3383f - this.f3382e));
        }
        long longValue3 = ((Number) pair2.component1()).longValue();
        long longValue4 = ((Number) pair2.component2()).longValue();
        long j5 = this.f3384g;
        if (j5 == 0) {
            pair3 = TuplesKt.m42317to(0L, 0L);
            j = longValue4;
        } else {
            j = longValue4;
            pair3 = TuplesKt.m42317to(Long.valueOf(j5 - this.f3379b), Long.valueOf(this.f3385h - this.f3384g));
        }
        long longValue5 = ((Number) pair3.component1()).longValue();
        long longValue6 = ((Number) pair3.component2()).longValue();
        long j6 = this.f3386i;
        if (j6 == 0) {
            pair4 = TuplesKt.m42317to(0L, 0L);
            j2 = longValue5;
        } else {
            j2 = longValue5;
            pair4 = TuplesKt.m42317to(Long.valueOf(j6 - this.f3379b), Long.valueOf(this.f3387j - this.f3386i));
        }
        long longValue7 = ((Number) pair4.component1()).longValue();
        long longValue8 = ((Number) pair4.component2()).longValue();
        long j7 = this.f3388k;
        if (j7 == 0) {
            pair5 = TuplesKt.m42317to(0L, 0L);
        } else {
            pair5 = TuplesKt.m42317to(Long.valueOf(j7 - this.f3379b), Long.valueOf(this.f3389l - this.f3388k));
        }
        return new ResourceTiming(longValue, longValue2, longValue3, j, j2, longValue6, longValue7, longValue8, ((Number) pair5.component1()).longValue(), ((Number) pair5.component2()).longValue());
    }

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, mo175978d2 = {"Lcom/datadog/android/DatadogEventListener$Factory;", "Lokhttp3/EventListener$Factory;", "()V", "create", "Lokhttp3/EventListener;", "call", "Lokhttp3/Call;", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: DatadogEventListener.kt */
    public static final class Factory implements EventListener.Factory {
        public EventListener create(Call call) {
            Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
            Request request = call.request();
            Intrinsics.checkNotNullExpressionValue(request, "call.request()");
            return new DatadogEventListener(RequestUniqueIdentifierKt.identifyRequest(request));
        }
    }
}
