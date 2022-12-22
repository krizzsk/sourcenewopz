package com.datadog.android.log;

import com.datadog.android.Datadog;
import com.datadog.android.core.internal.CoreFeature;
import com.datadog.android.core.internal.net.info.NetworkInfoProvider;
import com.datadog.android.core.internal.persistence.DataWriter;
import com.datadog.android.core.internal.sampling.RateBasedSampler;
import com.datadog.android.core.internal.utils.MapUtilsKt;
import com.datadog.android.core.internal.utils.RuntimeUtilsKt;
import com.datadog.android.log.internal.LogsFeature;
import com.datadog.android.log.internal.domain.LogGenerator;
import com.datadog.android.log.internal.logger.CombinedLogHandler;
import com.datadog.android.log.internal.logger.DatadogLogHandler;
import com.datadog.android.log.internal.logger.LogHandler;
import com.datadog.android.log.internal.logger.LogcatLogHandler;
import com.datadog.android.log.internal.logger.NoOpLogHandler;
import com.datadog.android.log.internal.user.NoOpUserInfoProvider;
import com.datadog.android.log.model.LogEvent;
import com.datadog.android.monitoring.internal.InternalLogsFeature;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\u0010$\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u00015B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0011J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0012J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0013J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0014J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0015J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0016J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0017J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0007J\u0016\u0010\u0018\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007J\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0007H\u0002J4\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u00072\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001fH\u0007J4\u0010 \u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u00072\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001fH\u0007J4\u0010!\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u00072\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001fH\u0007JK\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001f2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0017H\u0000¢\u0006\u0004\b&\u0010'J<\u0010(\u001a\u00020\r2\u0006\u0010)\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00072\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001fH\u0007J\u000e\u0010*\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007J\u000e\u0010+\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0007J\u0010\u0010,\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0007H\u0002J\u000e\u0010-\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007J\u001a\u0010.\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0002J\u001c\u0010/\u001a\u00020\r2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001301H\u0002J4\u00102\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u00072\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001fH\u0007J4\u00103\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u00072\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001fH\u0007J4\u00104\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u00072\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001fH\u0007R\u001c\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bX\u0004¢\u0006\u0002\n\u0000¨\u00066"}, mo175978d2 = {"Lcom/datadog/android/log/Logger;", "", "handler", "Lcom/datadog/android/log/internal/logger/LogHandler;", "(Lcom/datadog/android/log/internal/logger/LogHandler;)V", "attributes", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getHandler$dd_sdk_android_release", "()Lcom/datadog/android/log/internal/logger/LogHandler;", "tags", "Ljava/util/concurrent/CopyOnWriteArraySet;", "addAttribute", "", "key", "value", "Lcom/google/gson/JsonArray;", "Lcom/google/gson/JsonObject;", "Ljava/util/Date;", "", "", "", "", "", "addTag", "tag", "addTagInternal", "d", "message", "throwable", "", "", "e", "i", "internalLog", "level", "localAttributes", "timestamp", "internalLog$dd_sdk_android_release", "(ILjava/lang/String;Ljava/lang/Throwable;Ljava/util/Map;Ljava/lang/Long;)V", "log", "priority", "removeAttribute", "removeTag", "removeTagInternal", "removeTagsWithKey", "safelyAddAttribute", "safelyRemoveTagsWithKey", "keyFilter", "Lkotlin/Function1;", "v", "w", "wtf", "Builder", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Logger.kt */
public final class Logger {

    /* renamed from: a */
    private final LogHandler f3610a;

    /* renamed from: b */
    private final ConcurrentHashMap<String, Object> f3611b = new ConcurrentHashMap<>();

    /* renamed from: c */
    private final CopyOnWriteArraySet<String> f3612c = new CopyOnWriteArraySet<>();

    /* renamed from: d */
    public final void mo20180d(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        d$default(this, str, (Throwable) null, (Map) null, 6, (Object) null);
    }

    /* renamed from: d */
    public final void mo20181d(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, "message");
        d$default(this, str, th, (Map) null, 4, (Object) null);
    }

    /* renamed from: e */
    public final void mo20183e(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        e$default(this, str, (Throwable) null, (Map) null, 6, (Object) null);
    }

    /* renamed from: e */
    public final void mo20184e(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, "message");
        e$default(this, str, th, (Map) null, 4, (Object) null);
    }

    /* renamed from: i */
    public final void mo20187i(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        i$default(this, str, (Throwable) null, (Map) null, 6, (Object) null);
    }

    /* renamed from: i */
    public final void mo20188i(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, "message");
        i$default(this, str, th, (Map) null, 4, (Object) null);
    }

    public final void log(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        log$default(this, i, str, (Throwable) null, (Map) null, 12, (Object) null);
    }

    public final void log(int i, String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, "message");
        log$default(this, i, str, th, (Map) null, 8, (Object) null);
    }

    /* renamed from: v */
    public final void mo20197v(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        v$default(this, str, (Throwable) null, (Map) null, 6, (Object) null);
    }

    /* renamed from: v */
    public final void mo20198v(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, "message");
        v$default(this, str, th, (Map) null, 4, (Object) null);
    }

    /* renamed from: w */
    public final void mo20200w(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        w$default(this, str, (Throwable) null, (Map) null, 6, (Object) null);
    }

    /* renamed from: w */
    public final void mo20201w(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, "message");
        w$default(this, str, th, (Map) null, 4, (Object) null);
    }

    public final void wtf(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        wtf$default(this, str, (Throwable) null, (Map) null, 6, (Object) null);
    }

    public final void wtf(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, "message");
        wtf$default(this, str, th, (Map) null, 4, (Object) null);
    }

    public Logger(LogHandler logHandler) {
        Intrinsics.checkNotNullParameter(logHandler, "handler");
        this.f3610a = logHandler;
    }

    public final LogHandler getHandler$dd_sdk_android_release() {
        return this.f3610a;
    }

    public static /* synthetic */ void v$default(Logger logger, String str, Throwable th, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        if ((i & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        logger.mo20199v(str, th, map);
    }

    /* renamed from: v */
    public final void mo20199v(String str, Throwable th, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(map, "attributes");
        internalLog$dd_sdk_android_release$default(this, 2, str, th, map, (Long) null, 16, (Object) null);
    }

    public static /* synthetic */ void d$default(Logger logger, String str, Throwable th, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        if ((i & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        logger.mo20182d(str, th, map);
    }

    /* renamed from: d */
    public final void mo20182d(String str, Throwable th, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(map, "attributes");
        internalLog$dd_sdk_android_release$default(this, 3, str, th, map, (Long) null, 16, (Object) null);
    }

    public static /* synthetic */ void i$default(Logger logger, String str, Throwable th, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        if ((i & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        logger.mo20189i(str, th, map);
    }

    /* renamed from: i */
    public final void mo20189i(String str, Throwable th, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(map, "attributes");
        internalLog$dd_sdk_android_release$default(this, 4, str, th, map, (Long) null, 16, (Object) null);
    }

    public static /* synthetic */ void w$default(Logger logger, String str, Throwable th, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        if ((i & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        logger.mo20202w(str, th, map);
    }

    /* renamed from: w */
    public final void mo20202w(String str, Throwable th, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(map, "attributes");
        internalLog$dd_sdk_android_release$default(this, 5, str, th, map, (Long) null, 16, (Object) null);
    }

    public static /* synthetic */ void e$default(Logger logger, String str, Throwable th, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        if ((i & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        logger.mo20185e(str, th, map);
    }

    /* renamed from: e */
    public final void mo20185e(String str, Throwable th, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(map, "attributes");
        internalLog$dd_sdk_android_release$default(this, 6, str, th, map, (Long) null, 16, (Object) null);
    }

    public static /* synthetic */ void wtf$default(Logger logger, String str, Throwable th, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        if ((i & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        logger.wtf(str, th, map);
    }

    public final void wtf(String str, Throwable th, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(map, "attributes");
        internalLog$dd_sdk_android_release$default(this, 7, str, th, map, (Long) null, 16, (Object) null);
    }

    public static /* synthetic */ void log$default(Logger logger, int i, String str, Throwable th, Map map, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            th = null;
        }
        if ((i2 & 8) != 0) {
            map = MapsKt.emptyMap();
        }
        logger.log(i, str, th, map);
    }

    public final void log(int i, String str, Throwable th, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(map, "attributes");
        internalLog$dd_sdk_android_release$default(this, i, str, th, map, (Long) null, 16, (Object) null);
    }

    @Metadata(mo175977d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0014H\u0002J\u0010\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H\u0002J\b\u0010\u001a\u001a\u00020\u0012H\u0002J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0004J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0004J\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0004J\u0015\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0004H\u0000¢\u0006\u0002\b!J\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0004J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\nJ\u000e\u0010%\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0004J\u0010\u0010&\u001a\u00020\u00002\b\b\u0001\u0010'\u001a\u00020\rJ\u000e\u0010(\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, mo175978d2 = {"Lcom/datadog/android/log/Logger$Builder;", "", "()V", "bundleWithRumEnabled", "", "bundleWithTraceEnabled", "datadogLogsEnabled", "isInternalLogger", "logcatLogsEnabled", "loggerName", "", "networkInfoEnabled", "sampleRate", "", "serviceName", "build", "Lcom/datadog/android/log/Logger;", "buildDatadogHandler", "Lcom/datadog/android/log/internal/logger/LogHandler;", "buildInternalLogGenerator", "Lcom/datadog/android/log/internal/domain/LogGenerator;", "buildInternalLogWriter", "Lcom/datadog/android/core/internal/persistence/DataWriter;", "Lcom/datadog/android/log/model/LogEvent;", "buildLogGenerator", "buildLogWriter", "buildLogcatHandler", "setBundleWithRumEnabled", "enabled", "setBundleWithTraceEnabled", "setDatadogLogsEnabled", "setInternal", "isInternal", "setInternal$dd_sdk_android_release", "setLogcatLogsEnabled", "setLoggerName", "name", "setNetworkInfoEnabled", "setSampleRate", "rate", "setServiceName", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Logger.kt */
    public static final class Builder {
        private boolean bundleWithRumEnabled = true;
        private boolean bundleWithTraceEnabled = true;
        private boolean datadogLogsEnabled = true;
        private boolean isInternalLogger;
        private boolean logcatLogsEnabled;
        private String loggerName = CoreFeature.INSTANCE.getPackageName$dd_sdk_android_release();
        private boolean networkInfoEnabled;
        private float sampleRate = 1.0f;
        private String serviceName = CoreFeature.INSTANCE.getServiceName$dd_sdk_android_release();

        public final Logger build() {
            LogHandler logHandler;
            if (this.datadogLogsEnabled && this.logcatLogsEnabled) {
                logHandler = new CombinedLogHandler(buildDatadogHandler(), buildLogcatHandler());
            } else if (this.datadogLogsEnabled) {
                logHandler = buildDatadogHandler();
            } else if (this.logcatLogsEnabled) {
                logHandler = buildLogcatHandler();
            } else {
                logHandler = new NoOpLogHandler();
            }
            return new Logger(logHandler);
        }

        public final Builder setServiceName(String str) {
            Intrinsics.checkNotNullParameter(str, "serviceName");
            this.serviceName = str;
            return this;
        }

        public final Builder setDatadogLogsEnabled(boolean z) {
            this.datadogLogsEnabled = z;
            return this;
        }

        public final Builder setLogcatLogsEnabled(boolean z) {
            this.logcatLogsEnabled = z;
            return this;
        }

        public final Builder setNetworkInfoEnabled(boolean z) {
            this.networkInfoEnabled = z;
            return this;
        }

        public final Builder setLoggerName(String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            this.loggerName = str;
            return this;
        }

        public final Builder setBundleWithTraceEnabled(boolean z) {
            this.bundleWithTraceEnabled = z;
            return this;
        }

        public final Builder setBundleWithRumEnabled(boolean z) {
            this.bundleWithRumEnabled = z;
            return this;
        }

        public final Builder setSampleRate(float f) {
            this.sampleRate = f;
            return this;
        }

        public final Builder setInternal$dd_sdk_android_release(boolean z) {
            this.isInternalLogger = z;
            return this;
        }

        private final LogHandler buildLogcatHandler() {
            return new LogcatLogHandler(this.serviceName, true);
        }

        private final LogHandler buildDatadogHandler() {
            DataWriter<LogEvent> dataWriter;
            LogGenerator logGenerator;
            if (this.isInternalLogger) {
                dataWriter = buildInternalLogWriter();
            } else {
                dataWriter = buildLogWriter();
            }
            DataWriter<LogEvent> dataWriter2 = dataWriter;
            if (dataWriter2 == null) {
                return new NoOpLogHandler();
            }
            if (this.isInternalLogger) {
                logGenerator = buildInternalLogGenerator();
            } else {
                logGenerator = buildLogGenerator();
            }
            return new DatadogLogHandler(logGenerator, dataWriter2, this.bundleWithTraceEnabled, this.bundleWithRumEnabled, new RateBasedSampler(this.sampleRate));
        }

        private final DataWriter<LogEvent> buildInternalLogWriter() {
            if (InternalLogsFeature.INSTANCE.isInitialized()) {
                return InternalLogsFeature.INSTANCE.getPersistenceStrategy$dd_sdk_android_release().getWriter();
            }
            return null;
        }

        private final DataWriter<LogEvent> buildLogWriter() {
            if (LogsFeature.INSTANCE.isInitialized()) {
                return LogsFeature.INSTANCE.getPersistenceStrategy$dd_sdk_android_release().getWriter();
            }
            Logger.e$default(RuntimeUtilsKt.getDevLogger(), Datadog.MESSAGE_NOT_INITIALIZED, (Throwable) null, (Map) null, 6, (Object) null);
            return null;
        }

        private final LogGenerator buildLogGenerator() {
            NetworkInfoProvider networkInfoProvider;
            if (this.networkInfoEnabled) {
                networkInfoProvider = CoreFeature.INSTANCE.getNetworkInfoProvider$dd_sdk_android_release();
            } else {
                networkInfoProvider = null;
            }
            return new LogGenerator(this.serviceName, this.loggerName, networkInfoProvider, CoreFeature.INSTANCE.getUserInfoProvider$dd_sdk_android_release(), CoreFeature.INSTANCE.getTimeProvider$dd_sdk_android_release(), CoreFeature.INSTANCE.getSdkVersion$dd_sdk_android_release(), CoreFeature.INSTANCE.getEnvName$dd_sdk_android_release(), CoreFeature.INSTANCE.getPackageVersion$dd_sdk_android_release());
        }

        private final LogGenerator buildInternalLogGenerator() {
            NetworkInfoProvider networkInfoProvider;
            if (this.networkInfoEnabled) {
                networkInfoProvider = CoreFeature.INSTANCE.getNetworkInfoProvider$dd_sdk_android_release();
            } else {
                networkInfoProvider = null;
            }
            return new LogGenerator(InternalLogsFeature.SERVICE_NAME, this.loggerName, networkInfoProvider, new NoOpUserInfoProvider(), CoreFeature.INSTANCE.getTimeProvider$dd_sdk_android_release(), CoreFeature.INSTANCE.getSdkVersion$dd_sdk_android_release(), InternalLogsFeature.ENV_NAME, CoreFeature.INSTANCE.getPackageVersion$dd_sdk_android_release());
        }
    }

    public final void addAttribute(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.f3611b.put(str, Boolean.valueOf(z));
    }

    public final void addAttribute(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.f3611b.put(str, Integer.valueOf(i));
    }

    public final void addAttribute(String str, long j) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.f3611b.put(str, Long.valueOf(j));
    }

    public final void addAttribute(String str, float f) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.f3611b.put(str, Float.valueOf(f));
    }

    public final void addAttribute(String str, double d) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.f3611b.put(str, Double.valueOf(d));
    }

    public final void addAttribute(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        m2374a(str, str2);
    }

    public final void addAttribute(String str, Date date) {
        Intrinsics.checkNotNullParameter(str, "key");
        m2374a(str, date);
    }

    public final void addAttribute(String str, JsonObject jsonObject) {
        Intrinsics.checkNotNullParameter(str, "key");
        m2374a(str, jsonObject);
    }

    public final void addAttribute(String str, JsonArray jsonArray) {
        Intrinsics.checkNotNullParameter(str, "key");
        m2374a(str, jsonArray);
    }

    public final void removeAttribute(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.f3611b.remove(str);
    }

    public final void addTag(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "value");
        m2373a(str + ':' + str2);
    }

    public final void addTag(String str) {
        Intrinsics.checkNotNullParameter(str, "tag");
        m2373a(str);
    }

    public final void removeTag(String str) {
        Intrinsics.checkNotNullParameter(str, "tag");
        m2376b(str);
    }

    public final void removeTagsWithKey(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        m2375a((Function1<? super String, Boolean>) new Logger$removeTagsWithKey$1(Intrinsics.stringPlus(str, ":")));
    }

    public static /* synthetic */ void internalLog$dd_sdk_android_release$default(Logger logger, int i, String str, Throwable th, Map map, Long l, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            l = null;
        }
        logger.internalLog$dd_sdk_android_release(i, str, th, map, l);
    }

    public final void internalLog$dd_sdk_android_release(int i, String str, Throwable th, Map<String, ? extends Object> map, Long l) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(map, "localAttributes");
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(this.f3611b);
        linkedHashMap.putAll(map);
        this.f3610a.handleLog(i, str, th, linkedHashMap, this.f3612c, l);
    }

    /* renamed from: a */
    private final void m2373a(String str) {
        this.f3612c.add(str);
    }

    /* renamed from: b */
    private final void m2376b(String str) {
        this.f3612c.remove(str);
    }

    /* renamed from: a */
    private final void m2374a(String str, Object obj) {
        if (obj == null) {
            obj = MapUtilsKt.getNULL_MAP_VALUE();
        }
        this.f3611b.put(str, obj);
    }

    /* renamed from: a */
    private final void m2375a(Function1<? super String, Boolean> function1) {
        Object[] array = this.f3612c.toArray(new String[0]);
        if (array != null) {
            Collection arrayList = new ArrayList();
            for (Object obj : array) {
                if (function1.invoke(obj).booleanValue()) {
                    arrayList.add(obj);
                }
            }
            this.f3612c.removeAll((List) arrayList);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
