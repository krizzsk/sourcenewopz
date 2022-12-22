package com.datadog.android.core.configuration;

import android.os.Build;
import com.datadog.android.DatadogSite;
import com.datadog.android.core.internal.event.NoOpEventMapper;
import com.datadog.android.core.internal.utils.RuntimeUtilsKt;
import com.datadog.android.event.EventMapper;
import com.datadog.android.event.NoOpSpanEventMapper;
import com.datadog.android.event.SpanEventMapper;
import com.datadog.android.event.ViewEventMapper;
import com.datadog.android.log.Logger;
import com.datadog.android.log.model.LogEvent;
import com.datadog.android.plugin.DatadogPlugin;
import com.datadog.android.rum.internal.domain.event.RumEventMapper;
import com.datadog.android.rum.internal.instrumentation.MainLooperLongTaskStrategy;
import com.datadog.android.rum.internal.instrumentation.UserActionTrackingStrategyApi29;
import com.datadog.android.rum.internal.instrumentation.UserActionTrackingStrategyLegacy;
import com.datadog.android.rum.internal.instrumentation.gestures.DatadogGesturesTracker;
import com.datadog.android.rum.internal.tracking.JetpackViewAttributesProvider;
import com.datadog.android.rum.internal.tracking.UserActionTrackingStrategy;
import com.datadog.android.rum.model.ActionEvent;
import com.datadog.android.rum.model.ErrorEvent;
import com.datadog.android.rum.model.LongTaskEvent;
import com.datadog.android.rum.model.ResourceEvent;
import com.datadog.android.rum.tracking.ActivityViewTrackingStrategy;
import com.datadog.android.rum.tracking.ComponentPredicate;
import com.datadog.android.rum.tracking.InteractionPredicate;
import com.datadog.android.rum.tracking.NoOpInteractionPredicate;
import com.datadog.android.rum.tracking.TrackingStrategy;
import com.datadog.android.rum.tracking.ViewAttributesProvider;
import com.datadog.android.rum.tracking.ViewTrackingStrategy;
import com.datadog.trace.api.Config;
import com.didi.travel.p171v2.store.IStoreCallback;
import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Authenticator;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0016\u0018\u0000 #2\u00020\u0001:\u0004\"#$%BU\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\u0010\u0011R \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0016\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\f\u001a\u0004\u0018\u00010\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006&"}, mo175978d2 = {"Lcom/datadog/android/core/configuration/Configuration;", "", "coreConfig", "Lcom/datadog/android/core/configuration/Configuration$Core;", "logsConfig", "Lcom/datadog/android/core/configuration/Configuration$Feature$Logs;", "tracesConfig", "Lcom/datadog/android/core/configuration/Configuration$Feature$Tracing;", "crashReportConfig", "Lcom/datadog/android/core/configuration/Configuration$Feature$CrashReport;", "rumConfig", "Lcom/datadog/android/core/configuration/Configuration$Feature$RUM;", "internalLogsConfig", "Lcom/datadog/android/core/configuration/Configuration$Feature$InternalLogs;", "additionalConfig", "", "", "(Lcom/datadog/android/core/configuration/Configuration$Core;Lcom/datadog/android/core/configuration/Configuration$Feature$Logs;Lcom/datadog/android/core/configuration/Configuration$Feature$Tracing;Lcom/datadog/android/core/configuration/Configuration$Feature$CrashReport;Lcom/datadog/android/core/configuration/Configuration$Feature$RUM;Lcom/datadog/android/core/configuration/Configuration$Feature$InternalLogs;Ljava/util/Map;)V", "getAdditionalConfig$dd_sdk_android_release", "()Ljava/util/Map;", "getCoreConfig$dd_sdk_android_release", "()Lcom/datadog/android/core/configuration/Configuration$Core;", "setCoreConfig$dd_sdk_android_release", "(Lcom/datadog/android/core/configuration/Configuration$Core;)V", "getCrashReportConfig$dd_sdk_android_release", "()Lcom/datadog/android/core/configuration/Configuration$Feature$CrashReport;", "getInternalLogsConfig$dd_sdk_android_release", "()Lcom/datadog/android/core/configuration/Configuration$Feature$InternalLogs;", "getLogsConfig$dd_sdk_android_release", "()Lcom/datadog/android/core/configuration/Configuration$Feature$Logs;", "getRumConfig$dd_sdk_android_release", "()Lcom/datadog/android/core/configuration/Configuration$Feature$RUM;", "getTracesConfig$dd_sdk_android_release", "()Lcom/datadog/android/core/configuration/Configuration$Feature$Tracing;", "Builder", "Companion", "Core", "Feature", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Configuration.kt */
public final class Configuration {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long DEFAULT_LONG_TASK_THRESHOLD_MS = 100;
    public static final float DEFAULT_SAMPLING_RATE = 100.0f;
    public static final String ERROR_MALFORMED_HOST_IP_ADDRESS = "The host name or ip address used for first party hosts: %s was malformed. It will be dropped.";
    public static final String ERROR_MALFORMED_URL = "The url: %s is malformed. It will be dropped";
    public static final String WARNING_USING_URL_FOR_HOST = "You are using an url: %s for declaring the first party hosts. You should use instead a valid host name: %s.";
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static final Core f3392h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static final Feature.Logs f3393i = new Feature.Logs("https://logs.browser-intake-datadoghq.com", CollectionsKt.emptyList(), new NoOpEventMapper());
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static final Feature.CrashReport f3394j = new Feature.CrashReport("https://logs.browser-intake-datadoghq.com", CollectionsKt.emptyList());
    /* access modifiers changed from: private */

    /* renamed from: k */
    public static final Feature.Tracing f3395k = new Feature.Tracing("https://trace.browser-intake-datadoghq.com", CollectionsKt.emptyList(), new NoOpSpanEventMapper());
    /* access modifiers changed from: private */

    /* renamed from: l */
    public static final Feature.RUM f3396l = new Feature.RUM("https://rum.browser-intake-datadoghq.com", CollectionsKt.emptyList(), 100.0f, Companion.provideUserTrackingStrategy(new ViewAttributesProvider[0], new NoOpInteractionPredicate()), new ActivityViewTrackingStrategy(false, (ComponentPredicate) null, 2, (DefaultConstructorMarker) null), new MainLooperLongTaskStrategy(100), new NoOpEventMapper(), false);
    /* access modifiers changed from: private */

    /* renamed from: m */
    public static final String f3397m = "The %s feature has been disabled in your Configuration.Builder, but you're trying to edit the RUM configuration with the %s() method.";
    /* access modifiers changed from: private */

    /* renamed from: n */
    public static final String f3398n = "^(http|https)://(.*)";

    /* renamed from: o */
    private static final String f3399o = "^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$";

    /* renamed from: p */
    private static final String f3400p = "^(([a-zA-Z0-9]|[a-zA-Z0-9][a-zA-Z0-9\\-]*[a-zA-Z0-9])\\.)+([A-Za-z]|[A-Za-z][A-Za-z0-9-]*[A-Za-z0-9])$";

    /* renamed from: q */
    private static final String f3401q = "^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$|^(([a-zA-Z0-9]|[a-zA-Z0-9][a-zA-Z0-9\\-]*[a-zA-Z0-9])\\.)+([A-Za-z]|[A-Za-z][A-Za-z0-9-]*[A-Za-z0-9])$";

    /* renamed from: a */
    private Core f3402a;

    /* renamed from: b */
    private final Feature.Logs f3403b;

    /* renamed from: c */
    private final Feature.Tracing f3404c;

    /* renamed from: d */
    private final Feature.CrashReport f3405d;

    /* renamed from: e */
    private final Feature.RUM f3406e;

    /* renamed from: f */
    private final Feature.InternalLogs f3407f;

    /* renamed from: g */
    private final Map<String, Object> f3408g;

    public Configuration(Core core, Feature.Logs logs, Feature.Tracing tracing, Feature.CrashReport crashReport, Feature.RUM rum, Feature.InternalLogs internalLogs, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(core, "coreConfig");
        Intrinsics.checkNotNullParameter(map, "additionalConfig");
        this.f3402a = core;
        this.f3403b = logs;
        this.f3404c = tracing;
        this.f3405d = crashReport;
        this.f3406e = rum;
        this.f3407f = internalLogs;
        this.f3408g = map;
    }

    public final Core getCoreConfig$dd_sdk_android_release() {
        return this.f3402a;
    }

    public final void setCoreConfig$dd_sdk_android_release(Core core) {
        Intrinsics.checkNotNullParameter(core, "<set-?>");
        this.f3402a = core;
    }

    public final Feature.Logs getLogsConfig$dd_sdk_android_release() {
        return this.f3403b;
    }

    public final Feature.Tracing getTracesConfig$dd_sdk_android_release() {
        return this.f3404c;
    }

    public final Feature.CrashReport getCrashReportConfig$dd_sdk_android_release() {
        return this.f3405d;
    }

    public final Feature.RUM getRumConfig$dd_sdk_android_release() {
        return this.f3406e;
    }

    public final Feature.InternalLogs getInternalLogsConfig$dd_sdk_android_release() {
        return this.f3407f;
    }

    public final Map<String, Object> getAdditionalConfig$dd_sdk_android_release() {
        return this.f3408g;
    }

    @Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\t\u0010!\u001a\u00020\nHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010#\u001a\u00020\u000eHÆ\u0003JM\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010%\u001a\u00020\u00032\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006*"}, mo175978d2 = {"Lcom/datadog/android/core/configuration/Configuration$Core;", "", "needsClearTextHttp", "", "firstPartyHosts", "", "", "batchSize", "Lcom/datadog/android/core/configuration/BatchSize;", "uploadFrequency", "Lcom/datadog/android/core/configuration/UploadFrequency;", "proxy", "Ljava/net/Proxy;", "proxyAuth", "Lokhttp3/Authenticator;", "(ZLjava/util/List;Lcom/datadog/android/core/configuration/BatchSize;Lcom/datadog/android/core/configuration/UploadFrequency;Ljava/net/Proxy;Lokhttp3/Authenticator;)V", "getBatchSize", "()Lcom/datadog/android/core/configuration/BatchSize;", "getFirstPartyHosts", "()Ljava/util/List;", "getNeedsClearTextHttp", "()Z", "setNeedsClearTextHttp", "(Z)V", "getProxy", "()Ljava/net/Proxy;", "getProxyAuth", "()Lokhttp3/Authenticator;", "getUploadFrequency", "()Lcom/datadog/android/core/configuration/UploadFrequency;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Configuration.kt */
    public static final class Core {
        private final BatchSize batchSize;
        private final List<String> firstPartyHosts;
        private boolean needsClearTextHttp;
        private final Proxy proxy;
        private final Authenticator proxyAuth;
        private final UploadFrequency uploadFrequency;

        public static /* synthetic */ Core copy$default(Core core, boolean z, List<String> list, BatchSize batchSize2, UploadFrequency uploadFrequency2, Proxy proxy2, Authenticator authenticator, int i, Object obj) {
            if ((i & 1) != 0) {
                z = core.needsClearTextHttp;
            }
            if ((i & 2) != 0) {
                list = core.firstPartyHosts;
            }
            List<String> list2 = list;
            if ((i & 4) != 0) {
                batchSize2 = core.batchSize;
            }
            BatchSize batchSize3 = batchSize2;
            if ((i & 8) != 0) {
                uploadFrequency2 = core.uploadFrequency;
            }
            UploadFrequency uploadFrequency3 = uploadFrequency2;
            if ((i & 16) != 0) {
                proxy2 = core.proxy;
            }
            Proxy proxy3 = proxy2;
            if ((i & 32) != 0) {
                authenticator = core.proxyAuth;
            }
            return core.copy(z, list2, batchSize3, uploadFrequency3, proxy3, authenticator);
        }

        public final boolean component1() {
            return this.needsClearTextHttp;
        }

        public final List<String> component2() {
            return this.firstPartyHosts;
        }

        public final BatchSize component3() {
            return this.batchSize;
        }

        public final UploadFrequency component4() {
            return this.uploadFrequency;
        }

        public final Proxy component5() {
            return this.proxy;
        }

        public final Authenticator component6() {
            return this.proxyAuth;
        }

        public final Core copy(boolean z, List<String> list, BatchSize batchSize2, UploadFrequency uploadFrequency2, Proxy proxy2, Authenticator authenticator) {
            Intrinsics.checkNotNullParameter(list, "firstPartyHosts");
            Intrinsics.checkNotNullParameter(batchSize2, "batchSize");
            Intrinsics.checkNotNullParameter(uploadFrequency2, "uploadFrequency");
            Intrinsics.checkNotNullParameter(authenticator, "proxyAuth");
            return new Core(z, list, batchSize2, uploadFrequency2, proxy2, authenticator);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Core)) {
                return false;
            }
            Core core = (Core) obj;
            return this.needsClearTextHttp == core.needsClearTextHttp && Intrinsics.areEqual((Object) this.firstPartyHosts, (Object) core.firstPartyHosts) && this.batchSize == core.batchSize && this.uploadFrequency == core.uploadFrequency && Intrinsics.areEqual((Object) this.proxy, (Object) core.proxy) && Intrinsics.areEqual((Object) this.proxyAuth, (Object) core.proxyAuth);
        }

        public int hashCode() {
            boolean z = this.needsClearTextHttp;
            if (z) {
                z = true;
            }
            int hashCode = (((((((z ? 1 : 0) * true) + this.firstPartyHosts.hashCode()) * 31) + this.batchSize.hashCode()) * 31) + this.uploadFrequency.hashCode()) * 31;
            Proxy proxy2 = this.proxy;
            return ((hashCode + (proxy2 == null ? 0 : proxy2.hashCode())) * 31) + this.proxyAuth.hashCode();
        }

        public String toString() {
            return "Core(needsClearTextHttp=" + this.needsClearTextHttp + ", firstPartyHosts=" + this.firstPartyHosts + ", batchSize=" + this.batchSize + ", uploadFrequency=" + this.uploadFrequency + ", proxy=" + this.proxy + ", proxyAuth=" + this.proxyAuth + VersionRange.RIGHT_OPEN;
        }

        public Core(boolean z, List<String> list, BatchSize batchSize2, UploadFrequency uploadFrequency2, Proxy proxy2, Authenticator authenticator) {
            Intrinsics.checkNotNullParameter(list, "firstPartyHosts");
            Intrinsics.checkNotNullParameter(batchSize2, "batchSize");
            Intrinsics.checkNotNullParameter(uploadFrequency2, "uploadFrequency");
            Intrinsics.checkNotNullParameter(authenticator, "proxyAuth");
            this.needsClearTextHttp = z;
            this.firstPartyHosts = list;
            this.batchSize = batchSize2;
            this.uploadFrequency = uploadFrequency2;
            this.proxy = proxy2;
            this.proxyAuth = authenticator;
        }

        public final boolean getNeedsClearTextHttp() {
            return this.needsClearTextHttp;
        }

        public final void setNeedsClearTextHttp(boolean z) {
            this.needsClearTextHttp = z;
        }

        public final List<String> getFirstPartyHosts() {
            return this.firstPartyHosts;
        }

        public final BatchSize getBatchSize() {
            return this.batchSize;
        }

        public final UploadFrequency getUploadFrequency() {
            return this.uploadFrequency;
        }

        public final Proxy getProxy() {
            return this.proxy;
        }

        public final Authenticator getProxyAuth() {
            return this.proxyAuth;
        }
    }

    @Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0005\f\r\u000e\u000f\u0010B\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0001\u0005\u0011\u0012\u0013\u0014\u0015¨\u0006\u0016"}, mo175978d2 = {"Lcom/datadog/android/core/configuration/Configuration$Feature;", "", "()V", "endpointUrl", "", "getEndpointUrl", "()Ljava/lang/String;", "plugins", "", "Lcom/datadog/android/plugin/DatadogPlugin;", "getPlugins", "()Ljava/util/List;", "CrashReport", "InternalLogs", "Logs", "RUM", "Tracing", "Lcom/datadog/android/core/configuration/Configuration$Feature$Logs;", "Lcom/datadog/android/core/configuration/Configuration$Feature$InternalLogs;", "Lcom/datadog/android/core/configuration/Configuration$Feature$CrashReport;", "Lcom/datadog/android/core/configuration/Configuration$Feature$Tracing;", "Lcom/datadog/android/core/configuration/Configuration$Feature$RUM;", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Configuration.kt */
    public static abstract class Feature {
        public /* synthetic */ Feature(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract String getEndpointUrl();

        public abstract List<DatadogPlugin> getPlugins();

        private Feature() {
        }

        @Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, mo175978d2 = {"Lcom/datadog/android/core/configuration/Configuration$Feature$Logs;", "Lcom/datadog/android/core/configuration/Configuration$Feature;", "endpointUrl", "", "plugins", "", "Lcom/datadog/android/plugin/DatadogPlugin;", "logsEventMapper", "Lcom/datadog/android/event/EventMapper;", "Lcom/datadog/android/log/model/LogEvent;", "(Ljava/lang/String;Ljava/util/List;Lcom/datadog/android/event/EventMapper;)V", "getEndpointUrl", "()Ljava/lang/String;", "getLogsEventMapper", "()Lcom/datadog/android/event/EventMapper;", "getPlugins", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: Configuration.kt */
        public static final class Logs extends Feature {
            private final String endpointUrl;
            private final EventMapper<LogEvent> logsEventMapper;
            private final List<DatadogPlugin> plugins;

            public static /* synthetic */ Logs copy$default(Logs logs, String str, List<DatadogPlugin> list, EventMapper<LogEvent> eventMapper, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = logs.getEndpointUrl();
                }
                if ((i & 2) != 0) {
                    list = logs.getPlugins();
                }
                if ((i & 4) != 0) {
                    eventMapper = logs.logsEventMapper;
                }
                return logs.copy(str, list, eventMapper);
            }

            public final String component1() {
                return getEndpointUrl();
            }

            public final List<DatadogPlugin> component2() {
                return getPlugins();
            }

            public final EventMapper<LogEvent> component3() {
                return this.logsEventMapper;
            }

            public final Logs copy(String str, List<? extends DatadogPlugin> list, EventMapper<LogEvent> eventMapper) {
                Intrinsics.checkNotNullParameter(str, "endpointUrl");
                Intrinsics.checkNotNullParameter(list, "plugins");
                Intrinsics.checkNotNullParameter(eventMapper, "logsEventMapper");
                return new Logs(str, list, eventMapper);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Logs)) {
                    return false;
                }
                Logs logs = (Logs) obj;
                return Intrinsics.areEqual((Object) getEndpointUrl(), (Object) logs.getEndpointUrl()) && Intrinsics.areEqual((Object) getPlugins(), (Object) logs.getPlugins()) && Intrinsics.areEqual((Object) this.logsEventMapper, (Object) logs.logsEventMapper);
            }

            public int hashCode() {
                return (((getEndpointUrl().hashCode() * 31) + getPlugins().hashCode()) * 31) + this.logsEventMapper.hashCode();
            }

            public String toString() {
                return "Logs(endpointUrl=" + getEndpointUrl() + ", plugins=" + getPlugins() + ", logsEventMapper=" + this.logsEventMapper + VersionRange.RIGHT_OPEN;
            }

            public String getEndpointUrl() {
                return this.endpointUrl;
            }

            public List<DatadogPlugin> getPlugins() {
                return this.plugins;
            }

            public final EventMapper<LogEvent> getLogsEventMapper() {
                return this.logsEventMapper;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Logs(String str, List<? extends DatadogPlugin> list, EventMapper<LogEvent> eventMapper) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "endpointUrl");
                Intrinsics.checkNotNullParameter(list, "plugins");
                Intrinsics.checkNotNullParameter(eventMapper, "logsEventMapper");
                this.endpointUrl = str;
                this.plugins = list;
                this.logsEventMapper = eventMapper;
            }
        }

        @Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, mo175978d2 = {"Lcom/datadog/android/core/configuration/Configuration$Feature$InternalLogs;", "Lcom/datadog/android/core/configuration/Configuration$Feature;", "internalClientToken", "", "endpointUrl", "plugins", "", "Lcom/datadog/android/plugin/DatadogPlugin;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getEndpointUrl", "()Ljava/lang/String;", "getInternalClientToken", "getPlugins", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: Configuration.kt */
        public static final class InternalLogs extends Feature {
            private final String endpointUrl;
            private final String internalClientToken;
            private final List<DatadogPlugin> plugins;

            public static /* synthetic */ InternalLogs copy$default(InternalLogs internalLogs, String str, String str2, List<DatadogPlugin> list, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = internalLogs.internalClientToken;
                }
                if ((i & 2) != 0) {
                    str2 = internalLogs.getEndpointUrl();
                }
                if ((i & 4) != 0) {
                    list = internalLogs.getPlugins();
                }
                return internalLogs.copy(str, str2, list);
            }

            public final String component1() {
                return this.internalClientToken;
            }

            public final String component2() {
                return getEndpointUrl();
            }

            public final List<DatadogPlugin> component3() {
                return getPlugins();
            }

            public final InternalLogs copy(String str, String str2, List<? extends DatadogPlugin> list) {
                Intrinsics.checkNotNullParameter(str, "internalClientToken");
                Intrinsics.checkNotNullParameter(str2, "endpointUrl");
                Intrinsics.checkNotNullParameter(list, "plugins");
                return new InternalLogs(str, str2, list);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof InternalLogs)) {
                    return false;
                }
                InternalLogs internalLogs = (InternalLogs) obj;
                return Intrinsics.areEqual((Object) this.internalClientToken, (Object) internalLogs.internalClientToken) && Intrinsics.areEqual((Object) getEndpointUrl(), (Object) internalLogs.getEndpointUrl()) && Intrinsics.areEqual((Object) getPlugins(), (Object) internalLogs.getPlugins());
            }

            public int hashCode() {
                return (((this.internalClientToken.hashCode() * 31) + getEndpointUrl().hashCode()) * 31) + getPlugins().hashCode();
            }

            public String toString() {
                return "InternalLogs(internalClientToken=" + this.internalClientToken + ", endpointUrl=" + getEndpointUrl() + ", plugins=" + getPlugins() + VersionRange.RIGHT_OPEN;
            }

            public final String getInternalClientToken() {
                return this.internalClientToken;
            }

            public String getEndpointUrl() {
                return this.endpointUrl;
            }

            public List<DatadogPlugin> getPlugins() {
                return this.plugins;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public InternalLogs(String str, String str2, List<? extends DatadogPlugin> list) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "internalClientToken");
                Intrinsics.checkNotNullParameter(str2, "endpointUrl");
                Intrinsics.checkNotNullParameter(list, "plugins");
                this.internalClientToken = str;
                this.endpointUrl = str2;
                this.plugins = list;
            }
        }

        @Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, mo175978d2 = {"Lcom/datadog/android/core/configuration/Configuration$Feature$CrashReport;", "Lcom/datadog/android/core/configuration/Configuration$Feature;", "endpointUrl", "", "plugins", "", "Lcom/datadog/android/plugin/DatadogPlugin;", "(Ljava/lang/String;Ljava/util/List;)V", "getEndpointUrl", "()Ljava/lang/String;", "getPlugins", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: Configuration.kt */
        public static final class CrashReport extends Feature {
            private final String endpointUrl;
            private final List<DatadogPlugin> plugins;

            public static /* synthetic */ CrashReport copy$default(CrashReport crashReport, String str, List<DatadogPlugin> list, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = crashReport.getEndpointUrl();
                }
                if ((i & 2) != 0) {
                    list = crashReport.getPlugins();
                }
                return crashReport.copy(str, list);
            }

            public final String component1() {
                return getEndpointUrl();
            }

            public final List<DatadogPlugin> component2() {
                return getPlugins();
            }

            public final CrashReport copy(String str, List<? extends DatadogPlugin> list) {
                Intrinsics.checkNotNullParameter(str, "endpointUrl");
                Intrinsics.checkNotNullParameter(list, "plugins");
                return new CrashReport(str, list);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof CrashReport)) {
                    return false;
                }
                CrashReport crashReport = (CrashReport) obj;
                return Intrinsics.areEqual((Object) getEndpointUrl(), (Object) crashReport.getEndpointUrl()) && Intrinsics.areEqual((Object) getPlugins(), (Object) crashReport.getPlugins());
            }

            public int hashCode() {
                return (getEndpointUrl().hashCode() * 31) + getPlugins().hashCode();
            }

            public String toString() {
                return "CrashReport(endpointUrl=" + getEndpointUrl() + ", plugins=" + getPlugins() + VersionRange.RIGHT_OPEN;
            }

            public String getEndpointUrl() {
                return this.endpointUrl;
            }

            public List<DatadogPlugin> getPlugins() {
                return this.plugins;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public CrashReport(String str, List<? extends DatadogPlugin> list) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "endpointUrl");
                Intrinsics.checkNotNullParameter(list, "plugins");
                this.endpointUrl = str;
                this.plugins = list;
            }
        }

        @Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, mo175978d2 = {"Lcom/datadog/android/core/configuration/Configuration$Feature$Tracing;", "Lcom/datadog/android/core/configuration/Configuration$Feature;", "endpointUrl", "", "plugins", "", "Lcom/datadog/android/plugin/DatadogPlugin;", "spanEventMapper", "Lcom/datadog/android/event/SpanEventMapper;", "(Ljava/lang/String;Ljava/util/List;Lcom/datadog/android/event/SpanEventMapper;)V", "getEndpointUrl", "()Ljava/lang/String;", "getPlugins", "()Ljava/util/List;", "getSpanEventMapper", "()Lcom/datadog/android/event/SpanEventMapper;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: Configuration.kt */
        public static final class Tracing extends Feature {
            private final String endpointUrl;
            private final List<DatadogPlugin> plugins;
            private final SpanEventMapper spanEventMapper;

            public static /* synthetic */ Tracing copy$default(Tracing tracing, String str, List<DatadogPlugin> list, SpanEventMapper spanEventMapper2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = tracing.getEndpointUrl();
                }
                if ((i & 2) != 0) {
                    list = tracing.getPlugins();
                }
                if ((i & 4) != 0) {
                    spanEventMapper2 = tracing.spanEventMapper;
                }
                return tracing.copy(str, list, spanEventMapper2);
            }

            public final String component1() {
                return getEndpointUrl();
            }

            public final List<DatadogPlugin> component2() {
                return getPlugins();
            }

            public final SpanEventMapper component3() {
                return this.spanEventMapper;
            }

            public final Tracing copy(String str, List<? extends DatadogPlugin> list, SpanEventMapper spanEventMapper2) {
                Intrinsics.checkNotNullParameter(str, "endpointUrl");
                Intrinsics.checkNotNullParameter(list, "plugins");
                Intrinsics.checkNotNullParameter(spanEventMapper2, "spanEventMapper");
                return new Tracing(str, list, spanEventMapper2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Tracing)) {
                    return false;
                }
                Tracing tracing = (Tracing) obj;
                return Intrinsics.areEqual((Object) getEndpointUrl(), (Object) tracing.getEndpointUrl()) && Intrinsics.areEqual((Object) getPlugins(), (Object) tracing.getPlugins()) && Intrinsics.areEqual((Object) this.spanEventMapper, (Object) tracing.spanEventMapper);
            }

            public int hashCode() {
                return (((getEndpointUrl().hashCode() * 31) + getPlugins().hashCode()) * 31) + this.spanEventMapper.hashCode();
            }

            public String toString() {
                return "Tracing(endpointUrl=" + getEndpointUrl() + ", plugins=" + getPlugins() + ", spanEventMapper=" + this.spanEventMapper + VersionRange.RIGHT_OPEN;
            }

            public String getEndpointUrl() {
                return this.endpointUrl;
            }

            public List<DatadogPlugin> getPlugins() {
                return this.plugins;
            }

            public final SpanEventMapper getSpanEventMapper() {
                return this.spanEventMapper;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Tracing(String str, List<? extends DatadogPlugin> list, SpanEventMapper spanEventMapper2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "endpointUrl");
                Intrinsics.checkNotNullParameter(list, "plugins");
                Intrinsics.checkNotNullParameter(spanEventMapper2, "spanEventMapper");
                this.endpointUrl = str;
                this.plugins = list;
                this.spanEventMapper = spanEventMapper2;
            }
        }

        @Metadata(mo175977d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010'\u001a\u00020\bHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0003J\t\u0010,\u001a\u00020\u0013HÆ\u0003Jk\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u0013HÆ\u0001J\u0013\u0010.\u001a\u00020\u00132\b\u0010/\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u00100\u001a\u000201HÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u00063"}, mo175978d2 = {"Lcom/datadog/android/core/configuration/Configuration$Feature$RUM;", "Lcom/datadog/android/core/configuration/Configuration$Feature;", "endpointUrl", "", "plugins", "", "Lcom/datadog/android/plugin/DatadogPlugin;", "samplingRate", "", "userActionTrackingStrategy", "Lcom/datadog/android/rum/internal/tracking/UserActionTrackingStrategy;", "viewTrackingStrategy", "Lcom/datadog/android/rum/tracking/ViewTrackingStrategy;", "longTaskTrackingStrategy", "Lcom/datadog/android/rum/tracking/TrackingStrategy;", "rumEventMapper", "Lcom/datadog/android/event/EventMapper;", "", "backgroundEventTracking", "", "(Ljava/lang/String;Ljava/util/List;FLcom/datadog/android/rum/internal/tracking/UserActionTrackingStrategy;Lcom/datadog/android/rum/tracking/ViewTrackingStrategy;Lcom/datadog/android/rum/tracking/TrackingStrategy;Lcom/datadog/android/event/EventMapper;Z)V", "getBackgroundEventTracking", "()Z", "getEndpointUrl", "()Ljava/lang/String;", "getLongTaskTrackingStrategy", "()Lcom/datadog/android/rum/tracking/TrackingStrategy;", "getPlugins", "()Ljava/util/List;", "getRumEventMapper", "()Lcom/datadog/android/event/EventMapper;", "getSamplingRate", "()F", "getUserActionTrackingStrategy", "()Lcom/datadog/android/rum/internal/tracking/UserActionTrackingStrategy;", "getViewTrackingStrategy", "()Lcom/datadog/android/rum/tracking/ViewTrackingStrategy;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: Configuration.kt */
        public static final class RUM extends Feature {
            private final boolean backgroundEventTracking;
            private final String endpointUrl;
            private final TrackingStrategy longTaskTrackingStrategy;
            private final List<DatadogPlugin> plugins;
            private final EventMapper<Object> rumEventMapper;
            private final float samplingRate;
            private final UserActionTrackingStrategy userActionTrackingStrategy;
            private final ViewTrackingStrategy viewTrackingStrategy;

            public static /* synthetic */ RUM copy$default(RUM rum, String str, List list, float f, UserActionTrackingStrategy userActionTrackingStrategy2, ViewTrackingStrategy viewTrackingStrategy2, TrackingStrategy trackingStrategy, EventMapper eventMapper, boolean z, int i, Object obj) {
                RUM rum2 = rum;
                int i2 = i;
                return rum.copy((i2 & 1) != 0 ? rum.getEndpointUrl() : str, (i2 & 2) != 0 ? rum.getPlugins() : list, (i2 & 4) != 0 ? rum2.samplingRate : f, (i2 & 8) != 0 ? rum2.userActionTrackingStrategy : userActionTrackingStrategy2, (i2 & 16) != 0 ? rum2.viewTrackingStrategy : viewTrackingStrategy2, (i2 & 32) != 0 ? rum2.longTaskTrackingStrategy : trackingStrategy, (i2 & 64) != 0 ? rum2.rumEventMapper : eventMapper, (i2 & 128) != 0 ? rum2.backgroundEventTracking : z);
            }

            public final String component1() {
                return getEndpointUrl();
            }

            public final List<DatadogPlugin> component2() {
                return getPlugins();
            }

            public final float component3() {
                return this.samplingRate;
            }

            public final UserActionTrackingStrategy component4() {
                return this.userActionTrackingStrategy;
            }

            public final ViewTrackingStrategy component5() {
                return this.viewTrackingStrategy;
            }

            public final TrackingStrategy component6() {
                return this.longTaskTrackingStrategy;
            }

            public final EventMapper<Object> component7() {
                return this.rumEventMapper;
            }

            public final boolean component8() {
                return this.backgroundEventTracking;
            }

            public final RUM copy(String str, List<? extends DatadogPlugin> list, float f, UserActionTrackingStrategy userActionTrackingStrategy2, ViewTrackingStrategy viewTrackingStrategy2, TrackingStrategy trackingStrategy, EventMapper<Object> eventMapper, boolean z) {
                Intrinsics.checkNotNullParameter(str, "endpointUrl");
                Intrinsics.checkNotNullParameter(list, "plugins");
                EventMapper<Object> eventMapper2 = eventMapper;
                Intrinsics.checkNotNullParameter(eventMapper2, "rumEventMapper");
                return new RUM(str, list, f, userActionTrackingStrategy2, viewTrackingStrategy2, trackingStrategy, eventMapper2, z);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof RUM)) {
                    return false;
                }
                RUM rum = (RUM) obj;
                return Intrinsics.areEqual((Object) getEndpointUrl(), (Object) rum.getEndpointUrl()) && Intrinsics.areEqual((Object) getPlugins(), (Object) rum.getPlugins()) && Intrinsics.areEqual((Object) Float.valueOf(this.samplingRate), (Object) Float.valueOf(rum.samplingRate)) && Intrinsics.areEqual((Object) this.userActionTrackingStrategy, (Object) rum.userActionTrackingStrategy) && Intrinsics.areEqual((Object) this.viewTrackingStrategy, (Object) rum.viewTrackingStrategy) && Intrinsics.areEqual((Object) this.longTaskTrackingStrategy, (Object) rum.longTaskTrackingStrategy) && Intrinsics.areEqual((Object) this.rumEventMapper, (Object) rum.rumEventMapper) && this.backgroundEventTracking == rum.backgroundEventTracking;
            }

            public int hashCode() {
                int hashCode = ((((getEndpointUrl().hashCode() * 31) + getPlugins().hashCode()) * 31) + Float.floatToIntBits(this.samplingRate)) * 31;
                UserActionTrackingStrategy userActionTrackingStrategy2 = this.userActionTrackingStrategy;
                int i = 0;
                int hashCode2 = (hashCode + (userActionTrackingStrategy2 == null ? 0 : userActionTrackingStrategy2.hashCode())) * 31;
                ViewTrackingStrategy viewTrackingStrategy2 = this.viewTrackingStrategy;
                int hashCode3 = (hashCode2 + (viewTrackingStrategy2 == null ? 0 : viewTrackingStrategy2.hashCode())) * 31;
                TrackingStrategy trackingStrategy = this.longTaskTrackingStrategy;
                if (trackingStrategy != null) {
                    i = trackingStrategy.hashCode();
                }
                int hashCode4 = (((hashCode3 + i) * 31) + this.rumEventMapper.hashCode()) * 31;
                boolean z = this.backgroundEventTracking;
                if (z) {
                    z = true;
                }
                return hashCode4 + (z ? 1 : 0);
            }

            public String toString() {
                return "RUM(endpointUrl=" + getEndpointUrl() + ", plugins=" + getPlugins() + ", samplingRate=" + this.samplingRate + ", userActionTrackingStrategy=" + this.userActionTrackingStrategy + ", viewTrackingStrategy=" + this.viewTrackingStrategy + ", longTaskTrackingStrategy=" + this.longTaskTrackingStrategy + ", rumEventMapper=" + this.rumEventMapper + ", backgroundEventTracking=" + this.backgroundEventTracking + VersionRange.RIGHT_OPEN;
            }

            public String getEndpointUrl() {
                return this.endpointUrl;
            }

            public List<DatadogPlugin> getPlugins() {
                return this.plugins;
            }

            public final float getSamplingRate() {
                return this.samplingRate;
            }

            public final UserActionTrackingStrategy getUserActionTrackingStrategy() {
                return this.userActionTrackingStrategy;
            }

            public final ViewTrackingStrategy getViewTrackingStrategy() {
                return this.viewTrackingStrategy;
            }

            public final TrackingStrategy getLongTaskTrackingStrategy() {
                return this.longTaskTrackingStrategy;
            }

            public final EventMapper<Object> getRumEventMapper() {
                return this.rumEventMapper;
            }

            public final boolean getBackgroundEventTracking() {
                return this.backgroundEventTracking;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public RUM(String str, List<? extends DatadogPlugin> list, float f, UserActionTrackingStrategy userActionTrackingStrategy2, ViewTrackingStrategy viewTrackingStrategy2, TrackingStrategy trackingStrategy, EventMapper<Object> eventMapper, boolean z) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "endpointUrl");
                Intrinsics.checkNotNullParameter(list, "plugins");
                Intrinsics.checkNotNullParameter(eventMapper, "rumEventMapper");
                this.endpointUrl = str;
                this.plugins = list;
                this.samplingRate = f;
                this.userActionTrackingStrategy = userActionTrackingStrategy2;
                this.viewTrackingStrategy = viewTrackingStrategy2;
                this.longTaskTrackingStrategy = trackingStrategy;
                this.rumEventMapper = eventMapper;
                this.backgroundEventTracking = z;
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000ø\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0016\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J&\u0010!\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010#\u001a\u00020\n2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0%H\u0002J\u0006\u0010&\u001a\u00020'J\u0010\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\nH\u0002J\b\u0010*\u001a\u00020+H\u0002J\u000e\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020.J\u001a\u0010/\u001a\u00020\u00002\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\tJ\u000e\u00100\u001a\u00020\u00002\u0006\u00101\u001a\u000202J\u0014\u00103\u001a\u00020\u00002\f\u00104\u001a\b\u0012\u0004\u0012\u00020\n05J\u0016\u00106\u001a\u00020\u00002\u0006\u00107\u001a\u00020\n2\u0006\u00108\u001a\u00020\nJ\u0014\u00109\u001a\u00020\u00002\f\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;J\u0018\u0010=\u001a\u00020\u00002\u0006\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010AJ\u0014\u0010B\u001a\u00020\u00002\f\u0010:\u001a\b\u0012\u0004\u0012\u00020C0;J\u0014\u0010D\u001a\u00020\u00002\f\u0010:\u001a\b\u0012\u0004\u0012\u00020E0;J\u0014\u0010F\u001a\u00020\u00002\f\u0010:\u001a\b\u0012\u0004\u0012\u00020G0;J\u0014\u0010H\u001a\u00020\u00002\f\u0010:\u001a\b\u0012\u0004\u0012\u00020I0;J\u000e\u0010J\u001a\u00020\u00002\u0006\u0010:\u001a\u00020KJ\u000e\u0010L\u001a\u00020\u00002\u0006\u0010:\u001a\u00020MJ\u000e\u0010N\u001a\u00020\u00002\u0006\u0010O\u001a\u00020PJ\u000e\u0010Q\u001a\u00020\u00002\u0006\u0010R\u001a\u00020\u0003J'\u0010S\u001a\u00020\u00002\u000e\b\u0002\u0010T\u001a\b\u0012\u0004\u0012\u00020V0U2\b\b\u0002\u0010W\u001a\u00020XH\u0007¢\u0006\u0002\u0010YJ\u0012\u0010Z\u001a\u00020\u00002\b\b\u0002\u0010[\u001a\u00020\\H\u0007J\u000e\u0010]\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\nJ\u000e\u0010^\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\nJ\u000e\u0010_\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\nJ\u000e\u0010`\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\nJ\b\u0010a\u001a\u00020\u0000H\u0007J\b\u0010b\u001a\u00020\u0000H\u0007J\u000e\u0010c\u001a\u00020\u00002\u0006\u0010d\u001a\u00020eJ\b\u0010f\u001a\u00020\u0000H\u0007J\u000e\u0010g\u001a\u00020\u00002\u0006\u0010h\u001a\u00020iR\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0010¨\u0006j"}, mo175978d2 = {"Lcom/datadog/android/core/configuration/Configuration$Builder;", "", "logsEnabled", "", "tracesEnabled", "crashReportsEnabled", "rumEnabled", "(ZZZZ)V", "additionalConfig", "", "", "coreConfig", "Lcom/datadog/android/core/configuration/Configuration$Core;", "crashReportConfig", "Lcom/datadog/android/core/configuration/Configuration$Feature$CrashReport;", "getCrashReportsEnabled", "()Z", "internalLogsConfig", "Lcom/datadog/android/core/configuration/Configuration$Feature$InternalLogs;", "logsConfig", "Lcom/datadog/android/core/configuration/Configuration$Feature$Logs;", "getLogsEnabled", "rumConfig", "Lcom/datadog/android/core/configuration/Configuration$Feature$RUM;", "getRumEnabled", "tracesConfig", "Lcom/datadog/android/core/configuration/Configuration$Feature$Tracing;", "getTracesEnabled", "addPlugin", "plugin", "Lcom/datadog/android/plugin/DatadogPlugin;", "feature", "Lcom/datadog/android/plugin/Feature;", "applyIfFeatureEnabled", "", "method", "block", "Lkotlin/Function0;", "build", "Lcom/datadog/android/core/configuration/Configuration;", "checkCustomEndpoint", "endpoint", "getRumEventMapper", "Lcom/datadog/android/rum/internal/domain/event/RumEventMapper;", "sampleRumSessions", "samplingRate", "", "setAdditionalConfiguration", "setBatchSize", "batchSize", "Lcom/datadog/android/core/configuration/BatchSize;", "setFirstPartyHosts", "hosts", "", "setInternalLogsEnabled", "clientToken", "endpointUrl", "setLogEventMapper", "eventMapper", "Lcom/datadog/android/event/EventMapper;", "Lcom/datadog/android/log/model/LogEvent;", "setProxy", "proxy", "Ljava/net/Proxy;", "authenticator", "Lokhttp3/Authenticator;", "setRumActionEventMapper", "Lcom/datadog/android/rum/model/ActionEvent;", "setRumErrorEventMapper", "Lcom/datadog/android/rum/model/ErrorEvent;", "setRumLongTaskEventMapper", "Lcom/datadog/android/rum/model/LongTaskEvent;", "setRumResourceEventMapper", "Lcom/datadog/android/rum/model/ResourceEvent;", "setRumViewEventMapper", "Lcom/datadog/android/event/ViewEventMapper;", "setSpanEventMapper", "Lcom/datadog/android/event/SpanEventMapper;", "setUploadFrequency", "uploadFrequency", "Lcom/datadog/android/core/configuration/UploadFrequency;", "trackBackgroundRumEvents", "enabled", "trackInteractions", "touchTargetExtraAttributesProviders", "", "Lcom/datadog/android/rum/tracking/ViewAttributesProvider;", "interactionPredicate", "Lcom/datadog/android/rum/tracking/InteractionPredicate;", "([Lcom/datadog/android/rum/tracking/ViewAttributesProvider;Lcom/datadog/android/rum/tracking/InteractionPredicate;)Lcom/datadog/android/core/configuration/Configuration$Builder;", "trackLongTasks", "longTaskThresholdMs", "", "useCustomCrashReportsEndpoint", "useCustomLogsEndpoint", "useCustomRumEndpoint", "useCustomTracesEndpoint", "useEUEndpoints", "useGovEndpoints", "useSite", "site", "Lcom/datadog/android/DatadogSite;", "useUSEndpoints", "useViewTrackingStrategy", "strategy", "Lcom/datadog/android/rum/tracking/ViewTrackingStrategy;", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Configuration.kt */
    public static final class Builder {
        private Map<String, ? extends Object> additionalConfig = MapsKt.emptyMap();
        private Core coreConfig = Configuration.Companion.getDEFAULT_CORE_CONFIG$dd_sdk_android_release();
        /* access modifiers changed from: private */
        public Feature.CrashReport crashReportConfig = Configuration.Companion.getDEFAULT_CRASH_CONFIG$dd_sdk_android_release();
        private final boolean crashReportsEnabled;
        private Feature.InternalLogs internalLogsConfig;
        /* access modifiers changed from: private */
        public Feature.Logs logsConfig = Configuration.Companion.getDEFAULT_LOGS_CONFIG$dd_sdk_android_release();
        private final boolean logsEnabled;
        /* access modifiers changed from: private */
        public Feature.RUM rumConfig = Configuration.Companion.getDEFAULT_RUM_CONFIG$dd_sdk_android_release();
        private final boolean rumEnabled;
        /* access modifiers changed from: private */
        public Feature.Tracing tracesConfig = Configuration.Companion.getDEFAULT_TRACING_CONFIG$dd_sdk_android_release();
        private final boolean tracesEnabled;

        @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: Configuration.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[com.datadog.android.plugin.Feature.values().length];
                iArr[com.datadog.android.plugin.Feature.LOG.ordinal()] = 1;
                iArr[com.datadog.android.plugin.Feature.TRACE.ordinal()] = 2;
                iArr[com.datadog.android.plugin.Feature.CRASH.ordinal()] = 3;
                iArr[com.datadog.android.plugin.Feature.RUM.ordinal()] = 4;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public final Builder trackInteractions() {
            return trackInteractions$default(this, (ViewAttributesProvider[]) null, (InteractionPredicate) null, 3, (Object) null);
        }

        public final Builder trackInteractions(ViewAttributesProvider[] viewAttributesProviderArr) {
            Intrinsics.checkNotNullParameter(viewAttributesProviderArr, "touchTargetExtraAttributesProviders");
            return trackInteractions$default(this, viewAttributesProviderArr, (InteractionPredicate) null, 2, (Object) null);
        }

        public final Builder trackLongTasks() {
            return trackLongTasks$default(this, 0, 1, (Object) null);
        }

        public Builder(boolean z, boolean z2, boolean z3, boolean z4) {
            this.logsEnabled = z;
            this.tracesEnabled = z2;
            this.crashReportsEnabled = z3;
            this.rumEnabled = z4;
        }

        public final boolean getLogsEnabled() {
            return this.logsEnabled;
        }

        public final boolean getTracesEnabled() {
            return this.tracesEnabled;
        }

        public final boolean getCrashReportsEnabled() {
            return this.crashReportsEnabled;
        }

        public final boolean getRumEnabled() {
            return this.rumEnabled;
        }

        public final Configuration build() {
            return new Configuration(this.coreConfig, this.logsEnabled ? this.logsConfig : null, this.tracesEnabled ? this.tracesConfig : null, this.crashReportsEnabled ? this.crashReportConfig : null, this.rumEnabled ? this.rumConfig : null, this.internalLogsConfig, this.additionalConfig);
        }

        public final Builder setFirstPartyHosts(List<String> list) {
            Intrinsics.checkNotNullParameter(list, "hosts");
            this.coreConfig = Core.copy$default(this.coreConfig, false, Configuration.Companion.sanitizeHosts$dd_sdk_android_release(list), (BatchSize) null, (UploadFrequency) null, (Proxy) null, (Authenticator) null, 61, (Object) null);
            return this;
        }

        public final Builder useSite(DatadogSite datadogSite) {
            Intrinsics.checkNotNullParameter(datadogSite, Config.SITE);
            this.logsConfig = Feature.Logs.copy$default(this.logsConfig, datadogSite.logsEndpoint(), (List) null, (EventMapper) null, 6, (Object) null);
            this.tracesConfig = Feature.Tracing.copy$default(this.tracesConfig, datadogSite.tracesEndpoint(), (List) null, (SpanEventMapper) null, 6, (Object) null);
            this.crashReportConfig = Feature.CrashReport.copy$default(this.crashReportConfig, datadogSite.logsEndpoint(), (List) null, 2, (Object) null);
            this.rumConfig = Feature.RUM.copy$default(this.rumConfig, datadogSite.rumEndpoint(), (List) null, 0.0f, (UserActionTrackingStrategy) null, (ViewTrackingStrategy) null, (TrackingStrategy) null, (EventMapper) null, false, 254, (Object) null);
            this.coreConfig = Core.copy$default(this.coreConfig, false, (List) null, (BatchSize) null, (UploadFrequency) null, (Proxy) null, (Authenticator) null, 62, (Object) null);
            return this;
        }

        @Deprecated(message = "Use the `useSite()` method instead.", replaceWith = @ReplaceWith(expression = "useSite(DatadogSite.EU1)", imports = {"com.datadog.android.DatadogSite"}))
        public final Builder useEUEndpoints() {
            RuntimeUtilsKt.warnDeprecated("Configuration.Builder.useEUEndpoints()", "1.10.0", "1.12.0", "Configuration.Builder.useSite(DatadogSite.EU1)");
            this.logsConfig = Feature.Logs.copy$default(this.logsConfig, "https://mobile-http-intake.logs.datadoghq.eu", (List) null, (EventMapper) null, 6, (Object) null);
            this.tracesConfig = Feature.Tracing.copy$default(this.tracesConfig, "https:/public-trace-http-intake.logs.datadoghq.eu", (List) null, (SpanEventMapper) null, 6, (Object) null);
            this.crashReportConfig = Feature.CrashReport.copy$default(this.crashReportConfig, "https://mobile-http-intake.logs.datadoghq.eu", (List) null, 2, (Object) null);
            this.rumConfig = Feature.RUM.copy$default(this.rumConfig, "https://rum-http-intake.logs.datadoghq.eu", (List) null, 0.0f, (UserActionTrackingStrategy) null, (ViewTrackingStrategy) null, (TrackingStrategy) null, (EventMapper) null, false, 254, (Object) null);
            this.coreConfig = Core.copy$default(this.coreConfig, false, (List) null, (BatchSize) null, (UploadFrequency) null, (Proxy) null, (Authenticator) null, 62, (Object) null);
            return this;
        }

        @Deprecated(message = "Use the `useSite()` method instead.", replaceWith = @ReplaceWith(expression = "useSite(DatadogSite.US1)", imports = {"com.datadog.android.DatadogSite"}))
        public final Builder useUSEndpoints() {
            RuntimeUtilsKt.warnDeprecated("Configuration.Builder.useUSEndpoints()", "1.10.0", "1.12.0", "Configuration.Builder.useSite(DatadogSite.US1)");
            this.logsConfig = Feature.Logs.copy$default(this.logsConfig, "https://logs.browser-intake-datadoghq.com", (List) null, (EventMapper) null, 6, (Object) null);
            this.tracesConfig = Feature.Tracing.copy$default(this.tracesConfig, "https://trace.browser-intake-datadoghq.com", (List) null, (SpanEventMapper) null, 6, (Object) null);
            this.crashReportConfig = Feature.CrashReport.copy$default(this.crashReportConfig, "https://logs.browser-intake-datadoghq.com", (List) null, 2, (Object) null);
            this.rumConfig = Feature.RUM.copy$default(this.rumConfig, "https://rum.browser-intake-datadoghq.com", (List) null, 0.0f, (UserActionTrackingStrategy) null, (ViewTrackingStrategy) null, (TrackingStrategy) null, (EventMapper) null, false, 254, (Object) null);
            this.coreConfig = Core.copy$default(this.coreConfig, false, (List) null, (BatchSize) null, (UploadFrequency) null, (Proxy) null, (Authenticator) null, 62, (Object) null);
            return this;
        }

        @Deprecated(message = "Use the `useSite()` method instead.", replaceWith = @ReplaceWith(expression = "useSite(DatadogSite.US1_FED)", imports = {"com.datadog.android.DatadogSite"}))
        public final Builder useGovEndpoints() {
            RuntimeUtilsKt.warnDeprecated("Configuration.Builder.useGovEndpoints()", "1.10.0", "1.12.0", "Configuration.Builder.useSite(DatadogSite.US1_FED)");
            this.logsConfig = Feature.Logs.copy$default(this.logsConfig, "https://logs.browser-intake-ddog-gov.com", (List) null, (EventMapper) null, 6, (Object) null);
            this.tracesConfig = Feature.Tracing.copy$default(this.tracesConfig, "https://trace.browser-intake-ddog-gov.com", (List) null, (SpanEventMapper) null, 6, (Object) null);
            this.crashReportConfig = Feature.CrashReport.copy$default(this.crashReportConfig, "https://logs.browser-intake-ddog-gov.com", (List) null, 2, (Object) null);
            this.rumConfig = Feature.RUM.copy$default(this.rumConfig, "https://rum.browser-intake-ddog-gov.com", (List) null, 0.0f, (UserActionTrackingStrategy) null, (ViewTrackingStrategy) null, (TrackingStrategy) null, (EventMapper) null, false, 254, (Object) null);
            this.coreConfig = Core.copy$default(this.coreConfig, false, (List) null, (BatchSize) null, (UploadFrequency) null, (Proxy) null, (Authenticator) null, 62, (Object) null);
            return this;
        }

        public final Builder useCustomLogsEndpoint(String str) {
            Intrinsics.checkNotNullParameter(str, "endpoint");
            applyIfFeatureEnabled(com.datadog.android.plugin.Feature.LOG, "useCustomLogsEndpoint", new Configuration$Builder$useCustomLogsEndpoint$1(this, str));
            return this;
        }

        public final Builder useCustomTracesEndpoint(String str) {
            Intrinsics.checkNotNullParameter(str, "endpoint");
            applyIfFeatureEnabled(com.datadog.android.plugin.Feature.TRACE, "useCustomTracesEndpoint", new Configuration$Builder$useCustomTracesEndpoint$1(this, str));
            return this;
        }

        public final Builder useCustomCrashReportsEndpoint(String str) {
            Intrinsics.checkNotNullParameter(str, "endpoint");
            applyIfFeatureEnabled(com.datadog.android.plugin.Feature.CRASH, "useCustomCrashReportsEndpoint", new Configuration$Builder$useCustomCrashReportsEndpoint$1(this, str));
            return this;
        }

        public final Builder useCustomRumEndpoint(String str) {
            Intrinsics.checkNotNullParameter(str, "endpoint");
            applyIfFeatureEnabled(com.datadog.android.plugin.Feature.RUM, "useCustomRumEndpoint", new Configuration$Builder$useCustomRumEndpoint$1(this, str));
            return this;
        }

        public static /* synthetic */ Builder trackInteractions$default(Builder builder, ViewAttributesProvider[] viewAttributesProviderArr, InteractionPredicate interactionPredicate, int i, Object obj) {
            if ((i & 1) != 0) {
                viewAttributesProviderArr = new ViewAttributesProvider[0];
            }
            if ((i & 2) != 0) {
                interactionPredicate = new NoOpInteractionPredicate();
            }
            return builder.trackInteractions(viewAttributesProviderArr, interactionPredicate);
        }

        public final Builder trackInteractions(ViewAttributesProvider[] viewAttributesProviderArr, InteractionPredicate interactionPredicate) {
            Intrinsics.checkNotNullParameter(viewAttributesProviderArr, "touchTargetExtraAttributesProviders");
            Intrinsics.checkNotNullParameter(interactionPredicate, "interactionPredicate");
            applyIfFeatureEnabled(com.datadog.android.plugin.Feature.RUM, "trackInteractions", new Configuration$Builder$trackInteractions$1(this, Configuration.Companion.provideUserTrackingStrategy(viewAttributesProviderArr, interactionPredicate)));
            return this;
        }

        public static /* synthetic */ Builder trackLongTasks$default(Builder builder, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = 100;
            }
            return builder.trackLongTasks(j);
        }

        public final Builder trackLongTasks(long j) {
            applyIfFeatureEnabled(com.datadog.android.plugin.Feature.RUM, "trackLongTasks", new Configuration$Builder$trackLongTasks$1(this, j));
            return this;
        }

        public final Builder useViewTrackingStrategy(ViewTrackingStrategy viewTrackingStrategy) {
            Intrinsics.checkNotNullParameter(viewTrackingStrategy, "strategy");
            applyIfFeatureEnabled(com.datadog.android.plugin.Feature.RUM, "useViewTrackingStrategy", new Configuration$Builder$useViewTrackingStrategy$1(this, viewTrackingStrategy));
            return this;
        }

        public final Builder addPlugin(DatadogPlugin datadogPlugin, com.datadog.android.plugin.Feature feature) {
            Intrinsics.checkNotNullParameter(datadogPlugin, SDKConsts.MSG_TAG_PLUGIN);
            Intrinsics.checkNotNullParameter(feature, "feature");
            applyIfFeatureEnabled(feature, "addPlugin", new Configuration$Builder$addPlugin$1(feature, this, datadogPlugin));
            return this;
        }

        public final Builder setBatchSize(BatchSize batchSize) {
            Intrinsics.checkNotNullParameter(batchSize, "batchSize");
            this.coreConfig = Core.copy$default(this.coreConfig, false, (List) null, batchSize, (UploadFrequency) null, (Proxy) null, (Authenticator) null, 59, (Object) null);
            return this;
        }

        public final Builder setUploadFrequency(UploadFrequency uploadFrequency) {
            Intrinsics.checkNotNullParameter(uploadFrequency, "uploadFrequency");
            this.coreConfig = Core.copy$default(this.coreConfig, false, (List) null, (BatchSize) null, uploadFrequency, (Proxy) null, (Authenticator) null, 55, (Object) null);
            return this;
        }

        public final Builder sampleRumSessions(float f) {
            applyIfFeatureEnabled(com.datadog.android.plugin.Feature.RUM, "sampleRumSessions", new Configuration$Builder$sampleRumSessions$1(this, f));
            return this;
        }

        public final Builder trackBackgroundRumEvents(boolean z) {
            applyIfFeatureEnabled(com.datadog.android.plugin.Feature.RUM, "trackBackgroundRumEvents", new Configuration$Builder$trackBackgroundRumEvents$1(this, z));
            return this;
        }

        public final Builder setRumViewEventMapper(ViewEventMapper viewEventMapper) {
            Intrinsics.checkNotNullParameter(viewEventMapper, "eventMapper");
            applyIfFeatureEnabled(com.datadog.android.plugin.Feature.RUM, "setRumViewEventMapper", new Configuration$Builder$setRumViewEventMapper$1(this, viewEventMapper));
            return this;
        }

        public final Builder setRumResourceEventMapper(EventMapper<ResourceEvent> eventMapper) {
            Intrinsics.checkNotNullParameter(eventMapper, "eventMapper");
            applyIfFeatureEnabled(com.datadog.android.plugin.Feature.RUM, "setRumResourceEventMapper", new Configuration$Builder$setRumResourceEventMapper$1(this, eventMapper));
            return this;
        }

        public final Builder setRumActionEventMapper(EventMapper<ActionEvent> eventMapper) {
            Intrinsics.checkNotNullParameter(eventMapper, "eventMapper");
            applyIfFeatureEnabled(com.datadog.android.plugin.Feature.RUM, "setRumActionEventMapper", new Configuration$Builder$setRumActionEventMapper$1(this, eventMapper));
            return this;
        }

        public final Builder setRumErrorEventMapper(EventMapper<ErrorEvent> eventMapper) {
            Intrinsics.checkNotNullParameter(eventMapper, "eventMapper");
            applyIfFeatureEnabled(com.datadog.android.plugin.Feature.RUM, "setRumErrorEventMapper", new Configuration$Builder$setRumErrorEventMapper$1(this, eventMapper));
            return this;
        }

        public final Builder setRumLongTaskEventMapper(EventMapper<LongTaskEvent> eventMapper) {
            Intrinsics.checkNotNullParameter(eventMapper, "eventMapper");
            applyIfFeatureEnabled(com.datadog.android.plugin.Feature.RUM, "setRumLongTaskEventMapper", new Configuration$Builder$setRumLongTaskEventMapper$1(this, eventMapper));
            return this;
        }

        public final Builder setSpanEventMapper(SpanEventMapper spanEventMapper) {
            Intrinsics.checkNotNullParameter(spanEventMapper, "eventMapper");
            applyIfFeatureEnabled(com.datadog.android.plugin.Feature.TRACE, "setSpanEventMapper", new Configuration$Builder$setSpanEventMapper$1(this, spanEventMapper));
            return this;
        }

        public final Builder setLogEventMapper(EventMapper<LogEvent> eventMapper) {
            Intrinsics.checkNotNullParameter(eventMapper, "eventMapper");
            applyIfFeatureEnabled(com.datadog.android.plugin.Feature.LOG, "setLogEventMapper", new Configuration$Builder$setLogEventMapper$1(this, eventMapper));
            return this;
        }

        public final Builder setInternalLogsEnabled(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "clientToken");
            Intrinsics.checkNotNullParameter(str2, "endpointUrl");
            this.internalLogsConfig = new Feature.InternalLogs(str, str2, CollectionsKt.emptyList());
            return this;
        }

        public final Builder setAdditionalConfiguration(Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(map, "additionalConfig");
            Builder builder = this;
            builder.additionalConfig = map;
            return builder;
        }

        public final Builder setProxy(Proxy proxy, Authenticator authenticator) {
            Intrinsics.checkNotNullParameter(proxy, "proxy");
            Core core = this.coreConfig;
            if (authenticator == null) {
                authenticator = Authenticator.NONE;
            }
            Authenticator authenticator2 = authenticator;
            Intrinsics.checkNotNullExpressionValue(authenticator2, "authenticator ?: Authenticator.NONE");
            this.coreConfig = Core.copy$default(core, false, (List) null, (BatchSize) null, (UploadFrequency) null, proxy, authenticator2, 15, (Object) null);
            return this;
        }

        /* access modifiers changed from: private */
        public final void checkCustomEndpoint(String str) {
            if (StringsKt.startsWith$default(str, "http://", false, 2, (Object) null)) {
                this.coreConfig = Core.copy$default(this.coreConfig, true, (List) null, (BatchSize) null, (UploadFrequency) null, (Proxy) null, (Authenticator) null, 62, (Object) null);
            }
        }

        /* access modifiers changed from: private */
        public final RumEventMapper getRumEventMapper() {
            EventMapper<Object> rumEventMapper = this.rumConfig.getRumEventMapper();
            if (rumEventMapper instanceof RumEventMapper) {
                return (RumEventMapper) rumEventMapper;
            }
            return new RumEventMapper((EventMapper) null, (EventMapper) null, (EventMapper) null, (EventMapper) null, (EventMapper) null, 31, (DefaultConstructorMarker) null);
        }

        private final void applyIfFeatureEnabled(com.datadog.android.plugin.Feature feature, String str, Function0<Unit> function0) {
            boolean z;
            int i = WhenMappings.$EnumSwitchMapping$0[feature.ordinal()];
            if (i == 1) {
                z = this.logsEnabled;
            } else if (i == 2) {
                z = this.tracesEnabled;
            } else if (i == 3) {
                z = this.crashReportsEnabled;
            } else if (i == 4) {
                z = this.rumEnabled;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            if (z) {
                function0.invoke();
                return;
            }
            Logger devLogger = RuntimeUtilsKt.getDevLogger();
            String eRROR_FEATURE_DISABLED$dd_sdk_android_release = Configuration.Companion.getERROR_FEATURE_DISABLED$dd_sdk_android_release();
            String format = String.format(Locale.US, eRROR_FEATURE_DISABLED$dd_sdk_android_release, Arrays.copyOf(new Object[]{feature.getFeatureName$dd_sdk_android_release(), str}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, this, *args)");
            Logger.e$default(devLogger, format, (Throwable) null, (Map) null, 6, (Object) null);
        }
    }

    @Metadata(mo175977d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J#\u0010&\u001a\u00020'2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)2\u0006\u0010+\u001a\u00020,H\u0002¢\u0006\u0002\u0010-J#\u0010.\u001a\u00020/2\f\u00100\u001a\b\u0012\u0004\u0012\u00020*0)2\u0006\u0010+\u001a\u00020,H\u0002¢\u0006\u0002\u00101J!\u00102\u001a\b\u0012\u0004\u0012\u00020\u001c032\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u001c03H\u0000¢\u0006\u0002\b5R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001cXD¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u001cXT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001cXT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001cXD¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001cXT¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001cXT¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001cXT¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001cXT¢\u0006\u0002\n\u0000¨\u00066"}, mo175978d2 = {"Lcom/datadog/android/core/configuration/Configuration$Companion;", "", "()V", "DEFAULT_CORE_CONFIG", "Lcom/datadog/android/core/configuration/Configuration$Core;", "getDEFAULT_CORE_CONFIG$dd_sdk_android_release", "()Lcom/datadog/android/core/configuration/Configuration$Core;", "DEFAULT_CRASH_CONFIG", "Lcom/datadog/android/core/configuration/Configuration$Feature$CrashReport;", "getDEFAULT_CRASH_CONFIG$dd_sdk_android_release", "()Lcom/datadog/android/core/configuration/Configuration$Feature$CrashReport;", "DEFAULT_LOGS_CONFIG", "Lcom/datadog/android/core/configuration/Configuration$Feature$Logs;", "getDEFAULT_LOGS_CONFIG$dd_sdk_android_release", "()Lcom/datadog/android/core/configuration/Configuration$Feature$Logs;", "DEFAULT_LONG_TASK_THRESHOLD_MS", "", "DEFAULT_RUM_CONFIG", "Lcom/datadog/android/core/configuration/Configuration$Feature$RUM;", "getDEFAULT_RUM_CONFIG$dd_sdk_android_release", "()Lcom/datadog/android/core/configuration/Configuration$Feature$RUM;", "DEFAULT_SAMPLING_RATE", "", "DEFAULT_TRACING_CONFIG", "Lcom/datadog/android/core/configuration/Configuration$Feature$Tracing;", "getDEFAULT_TRACING_CONFIG$dd_sdk_android_release", "()Lcom/datadog/android/core/configuration/Configuration$Feature$Tracing;", "ERROR_FEATURE_DISABLED", "", "getERROR_FEATURE_DISABLED$dd_sdk_android_release", "()Ljava/lang/String;", "ERROR_MALFORMED_HOST_IP_ADDRESS", "ERROR_MALFORMED_URL", "URL_REGEX", "VALID_DOMAIN_REGEX", "VALID_HOSTNAME_REGEX", "VALID_IP_REGEX", "WARNING_USING_URL_FOR_HOST", "provideGestureTracker", "Lcom/datadog/android/rum/internal/instrumentation/gestures/DatadogGesturesTracker;", "customProviders", "", "Lcom/datadog/android/rum/tracking/ViewAttributesProvider;", "interactionPredicate", "Lcom/datadog/android/rum/tracking/InteractionPredicate;", "([Lcom/datadog/android/rum/tracking/ViewAttributesProvider;Lcom/datadog/android/rum/tracking/InteractionPredicate;)Lcom/datadog/android/rum/internal/instrumentation/gestures/DatadogGesturesTracker;", "provideUserTrackingStrategy", "Lcom/datadog/android/rum/internal/tracking/UserActionTrackingStrategy;", "touchTargetExtraAttributesProviders", "([Lcom/datadog/android/rum/tracking/ViewAttributesProvider;Lcom/datadog/android/rum/tracking/InteractionPredicate;)Lcom/datadog/android/rum/internal/tracking/UserActionTrackingStrategy;", "sanitizeHosts", "", "hosts", "sanitizeHosts$dd_sdk_android_release", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Configuration.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Core getDEFAULT_CORE_CONFIG$dd_sdk_android_release() {
            return Configuration.f3392h;
        }

        public final Feature.Logs getDEFAULT_LOGS_CONFIG$dd_sdk_android_release() {
            return Configuration.f3393i;
        }

        public final Feature.CrashReport getDEFAULT_CRASH_CONFIG$dd_sdk_android_release() {
            return Configuration.f3394j;
        }

        public final Feature.Tracing getDEFAULT_TRACING_CONFIG$dd_sdk_android_release() {
            return Configuration.f3395k;
        }

        public final Feature.RUM getDEFAULT_RUM_CONFIG$dd_sdk_android_release() {
            return Configuration.f3396l;
        }

        public final String getERROR_FEATURE_DISABLED$dd_sdk_android_release() {
            return Configuration.f3397m;
        }

        public final List<String> sanitizeHosts$dd_sdk_android_release(List<String> list) {
            List<String> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "hosts");
            Regex regex = new Regex(Configuration.f3401q);
            Regex regex2 = new Regex(Configuration.f3398n);
            Collection arrayList = new ArrayList();
            for (String str : list2) {
                CharSequence charSequence = str;
                if (regex2.matches(charSequence)) {
                    try {
                        URL url = new URL(str);
                        Logger devLogger = RuntimeUtilsKt.getDevLogger();
                        String format = String.format(Locale.US, Configuration.WARNING_USING_URL_FOR_HOST, Arrays.copyOf(new Object[]{str, url.getHost()}, 2));
                        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, this, *args)");
                        Logger.w$default(devLogger, format, (Throwable) null, (Map) null, 6, (Object) null);
                        str = url.getHost();
                    } catch (MalformedURLException e) {
                        Logger devLogger2 = RuntimeUtilsKt.getDevLogger();
                        String format2 = String.format(Locale.US, Configuration.ERROR_MALFORMED_URL, Arrays.copyOf(new Object[]{str}, 1));
                        Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(locale, this, *args)");
                        Logger.e$default(devLogger2, format2, e, (Map) null, 4, (Object) null);
                        str = null;
                    }
                } else if (!regex.matches(charSequence)) {
                    Locale locale = Locale.ENGLISH;
                    Intrinsics.checkNotNullExpressionValue(locale, ViewHierarchyConstants.ENGLISH);
                    if (str != null) {
                        String lowerCase = str.toLowerCase(locale);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                        if (!Intrinsics.areEqual((Object) lowerCase, (Object) Config.DEFAULT_AGENT_HOST)) {
                            Logger devLogger3 = RuntimeUtilsKt.getDevLogger();
                            String format3 = String.format(Locale.US, Configuration.ERROR_MALFORMED_HOST_IP_ADDRESS, Arrays.copyOf(new Object[]{str}, 1));
                            Intrinsics.checkNotNullExpressionValue(format3, "java.lang.String.format(locale, this, *args)");
                            Logger.e$default(devLogger3, format3, (Throwable) null, (Map) null, 6, (Object) null);
                            str = null;
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                }
                if (str != null) {
                    arrayList.add(str);
                }
            }
            return (List) arrayList;
        }

        /* access modifiers changed from: private */
        public final UserActionTrackingStrategy provideUserTrackingStrategy(ViewAttributesProvider[] viewAttributesProviderArr, InteractionPredicate interactionPredicate) {
            DatadogGesturesTracker provideGestureTracker = provideGestureTracker(viewAttributesProviderArr, interactionPredicate);
            if (Build.VERSION.SDK_INT >= 29) {
                return new UserActionTrackingStrategyApi29(provideGestureTracker);
            }
            return new UserActionTrackingStrategyLegacy(provideGestureTracker);
        }

        private final DatadogGesturesTracker provideGestureTracker(ViewAttributesProvider[] viewAttributesProviderArr, InteractionPredicate interactionPredicate) {
            return new DatadogGesturesTracker((ViewAttributesProvider[]) ArraysKt.plus((T[]) viewAttributesProviderArr, (T[]) new JetpackViewAttributesProvider[]{new JetpackViewAttributesProvider()}), interactionPredicate);
        }
    }

    static {
        List emptyList = CollectionsKt.emptyList();
        BatchSize batchSize = BatchSize.MEDIUM;
        UploadFrequency uploadFrequency = UploadFrequency.AVERAGE;
        Authenticator authenticator = Authenticator.NONE;
        Intrinsics.checkNotNullExpressionValue(authenticator, IStoreCallback.DEFAULT_API_DETAIL_KEY);
        f3392h = new Core(false, emptyList, batchSize, uploadFrequency, (Proxy) null, authenticator);
    }
}
