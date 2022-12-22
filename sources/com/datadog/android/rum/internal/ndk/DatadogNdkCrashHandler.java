package com.datadog.android.rum.internal.ndk;

import android.content.Context;
import com.datadog.android.core.internal.persistence.DataWriter;
import com.datadog.android.core.internal.persistence.Deserializer;
import com.datadog.android.core.internal.time.TimeProvider;
import com.datadog.android.core.model.NetworkInfo;
import com.datadog.android.core.model.UserInfo;
import com.datadog.android.log.LogAttributes;
import com.datadog.android.log.Logger;
import com.datadog.android.log.internal.domain.LogGenerator;
import com.datadog.android.log.model.LogEvent;
import com.datadog.android.rum.model.ErrorEvent;
import com.datadog.android.rum.model.ViewEvent;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p245io.FilesKt;

@Metadata(mo175977d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\b\u0000\u0018\u0000 C2\u00020\u0001:\u0001CBe\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\t\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\t\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J$\u0010)\u001a\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\f0,H\u0002J\b\u0010/\u001a\u00020*H\u0002J\b\u00100\u001a\u00020*H\u0002J$\u00101\u001a\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\f0,H\u0016JL\u00102\u001a\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\f0,2\b\u00103\u001a\u0004\u0018\u00010\n2\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u00010\u00102\b\u00107\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u00108\u001a\u00020*H\u0016J\b\u00109\u001a\u00020*H\u0002J \u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u00172\u0006\u00103\u001a\u00020\n2\u0006\u0010=\u001a\u000205H\u0002JN\u0010>\u001a\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,2\u0006\u0010<\u001a\u00020\u00172\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170@2\u0006\u00103\u001a\u00020\n2\b\u00107\u001a\u0004\u0018\u00010\u000e2\b\u00106\u001a\u0004\u0018\u00010\u0010H\u0002J\u0010\u0010A\u001a\u0002052\u0006\u00104\u001a\u000205H\u0002J.\u0010B\u001a\u00020*2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\f0,2\u0006\u0010<\u001a\u00020\u00172\u0006\u00103\u001a\u00020\n2\u0006\u00104\u001a\u000205H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u001c\u0010\"\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001bR\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020(X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\tX\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/ndk/DatadogNdkCrashHandler;", "Lcom/datadog/android/rum/internal/ndk/NdkCrashHandler;", "appContext", "Landroid/content/Context;", "dataPersistenceExecutorService", "Ljava/util/concurrent/ExecutorService;", "logGenerator", "Lcom/datadog/android/log/internal/domain/LogGenerator;", "ndkCrashLogDeserializer", "Lcom/datadog/android/core/internal/persistence/Deserializer;", "Lcom/datadog/android/rum/internal/ndk/NdkCrashLog;", "rumEventDeserializer", "", "networkInfoDeserializer", "Lcom/datadog/android/core/model/NetworkInfo;", "userInfoDeserializer", "Lcom/datadog/android/core/model/UserInfo;", "internalLogger", "Lcom/datadog/android/log/Logger;", "timeProvider", "Lcom/datadog/android/core/internal/time/TimeProvider;", "(Landroid/content/Context;Ljava/util/concurrent/ExecutorService;Lcom/datadog/android/log/internal/domain/LogGenerator;Lcom/datadog/android/core/internal/persistence/Deserializer;Lcom/datadog/android/core/internal/persistence/Deserializer;Lcom/datadog/android/core/internal/persistence/Deserializer;Lcom/datadog/android/core/internal/persistence/Deserializer;Lcom/datadog/android/log/Logger;Lcom/datadog/android/core/internal/time/TimeProvider;)V", "lastSerializedNdkCrashLog", "", "getLastSerializedNdkCrashLog$dd_sdk_android_release", "()Ljava/lang/String;", "setLastSerializedNdkCrashLog$dd_sdk_android_release", "(Ljava/lang/String;)V", "lastSerializedNetworkInformation", "getLastSerializedNetworkInformation$dd_sdk_android_release", "setLastSerializedNetworkInformation$dd_sdk_android_release", "lastSerializedRumViewEvent", "getLastSerializedRumViewEvent$dd_sdk_android_release", "setLastSerializedRumViewEvent$dd_sdk_android_release", "lastSerializedUserInformation", "getLastSerializedUserInformation$dd_sdk_android_release", "setLastSerializedUserInformation$dd_sdk_android_release", "getLogGenerator$dd_sdk_android_release", "()Lcom/datadog/android/log/internal/domain/LogGenerator;", "ndkCrashDataDirectory", "Ljava/io/File;", "checkAndHandleNdkCrashReport", "", "logWriter", "Lcom/datadog/android/core/internal/persistence/DataWriter;", "Lcom/datadog/android/log/model/LogEvent;", "rumWriter", "clearAllReferences", "clearCrashLog", "handleNdkCrash", "handleNdkCrashLog", "ndkCrashLog", "lastViewEvent", "Lcom/datadog/android/rum/model/ViewEvent;", "lastUserInfo", "lastNetworkInfo", "prepareData", "readCrashData", "resolveErrorEventFromViewEvent", "Lcom/datadog/android/rum/model/ErrorEvent;", "errorLogMessage", "viewEvent", "sendCrashLogEvent", "logAttributes", "", "updateViewEvent", "updateViewEventAndSendError", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DatadogNdkCrashHandler.kt */
public final class DatadogNdkCrashHandler implements NdkCrashHandler {
    public static final String CRASH_DATA_FILE_NAME = "crash_log";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DESERIALIZE_CRASH_EVENT_ERROR_MESSAGE = "Error while trying to deserialize the ndk crash log event";
    public static final String ERROR_READ_NDK_DIR = "Error while trying to read the NDK crash directory";
    public static final String LOGGER_NAME = "ndk_crash";
    public static final String LOG_CRASH_MSG = "NDK crash detected with signal: %s";
    public static final String NDK_CRASH_REPORTS_FOLDER_NAME = "ndk_crash_reports";
    public static final String NETWORK_INFO_FILE_NAME = "network_information";
    public static final String RUM_VIEW_EVENT_FILE_NAME = "last_view_event";
    public static final String USER_INFO_FILE_NAME = "user_information";
    /* access modifiers changed from: private */

    /* renamed from: n */
    public static final long f3866n = TimeUnit.HOURS.toMillis(4);

    /* renamed from: o */
    private static final String f3867o = "ndk_crash_reports_intermediary";

    /* renamed from: a */
    private final ExecutorService f3868a;

    /* renamed from: b */
    private final LogGenerator f3869b;

    /* renamed from: c */
    private final Deserializer<NdkCrashLog> f3870c;

    /* renamed from: d */
    private final Deserializer<Object> f3871d;

    /* renamed from: e */
    private final Deserializer<NetworkInfo> f3872e;

    /* renamed from: f */
    private final Deserializer<UserInfo> f3873f;

    /* renamed from: g */
    private final Logger f3874g;

    /* renamed from: h */
    private final TimeProvider f3875h;

    /* renamed from: i */
    private final File f3876i;

    /* renamed from: j */
    private String f3877j;

    /* renamed from: k */
    private String f3878k;

    /* renamed from: l */
    private String f3879l;

    /* renamed from: m */
    private String f3880m;

    public DatadogNdkCrashHandler(Context context, ExecutorService executorService, LogGenerator logGenerator, Deserializer<NdkCrashLog> deserializer, Deserializer<Object> deserializer2, Deserializer<NetworkInfo> deserializer3, Deserializer<UserInfo> deserializer4, Logger logger, TimeProvider timeProvider) {
        Intrinsics.checkNotNullParameter(context, "appContext");
        Intrinsics.checkNotNullParameter(executorService, "dataPersistenceExecutorService");
        Intrinsics.checkNotNullParameter(logGenerator, "logGenerator");
        Intrinsics.checkNotNullParameter(deserializer, "ndkCrashLogDeserializer");
        Intrinsics.checkNotNullParameter(deserializer2, "rumEventDeserializer");
        Intrinsics.checkNotNullParameter(deserializer3, "networkInfoDeserializer");
        Intrinsics.checkNotNullParameter(deserializer4, "userInfoDeserializer");
        Intrinsics.checkNotNullParameter(logger, "internalLogger");
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        this.f3868a = executorService;
        this.f3869b = logGenerator;
        this.f3870c = deserializer;
        this.f3871d = deserializer2;
        this.f3872e = deserializer3;
        this.f3873f = deserializer4;
        this.f3874g = logger;
        this.f3875h = timeProvider;
        this.f3876i = Companion.getNdkGrantedDir$dd_sdk_android_release(context);
    }

    public final LogGenerator getLogGenerator$dd_sdk_android_release() {
        return this.f3869b;
    }

    public final String getLastSerializedRumViewEvent$dd_sdk_android_release() {
        return this.f3877j;
    }

    public final void setLastSerializedRumViewEvent$dd_sdk_android_release(String str) {
        this.f3877j = str;
    }

    public final String getLastSerializedUserInformation$dd_sdk_android_release() {
        return this.f3878k;
    }

    public final void setLastSerializedUserInformation$dd_sdk_android_release(String str) {
        this.f3878k = str;
    }

    public final String getLastSerializedNdkCrashLog$dd_sdk_android_release() {
        return this.f3879l;
    }

    public final void setLastSerializedNdkCrashLog$dd_sdk_android_release(String str) {
        this.f3879l = str;
    }

    public final String getLastSerializedNetworkInformation$dd_sdk_android_release() {
        return this.f3880m;
    }

    public final void setLastSerializedNetworkInformation$dd_sdk_android_release(String str) {
        this.f3880m = str;
    }

    public void prepareData() {
        this.f3868a.submit(new Runnable() {
            public final void run() {
                DatadogNdkCrashHandler.m2508a(DatadogNdkCrashHandler.this);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m2508a(DatadogNdkCrashHandler datadogNdkCrashHandler) {
        Intrinsics.checkNotNullParameter(datadogNdkCrashHandler, "this$0");
        datadogNdkCrashHandler.m2503a();
    }

    public void handleNdkCrash(DataWriter<LogEvent> dataWriter, DataWriter<Object> dataWriter2) {
        Intrinsics.checkNotNullParameter(dataWriter, "logWriter");
        Intrinsics.checkNotNullParameter(dataWriter2, "rumWriter");
        this.f3868a.submit(new Runnable(dataWriter, dataWriter2) {
            public final /* synthetic */ DataWriter f$1;
            public final /* synthetic */ DataWriter f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                DatadogNdkCrashHandler.m2509a(DatadogNdkCrashHandler.this, this.f$1, this.f$2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m2509a(DatadogNdkCrashHandler datadogNdkCrashHandler, DataWriter dataWriter, DataWriter dataWriter2) {
        Intrinsics.checkNotNullParameter(datadogNdkCrashHandler, "this$0");
        Intrinsics.checkNotNullParameter(dataWriter, "$logWriter");
        Intrinsics.checkNotNullParameter(dataWriter2, "$rumWriter");
        datadogNdkCrashHandler.m2504a(dataWriter, dataWriter2);
    }

    /* renamed from: a */
    private final void m2503a() {
        if (this.f3876i.exists()) {
            try {
                File[] listFiles = this.f3876i.listFiles();
                if (listFiles != null) {
                    for (File file : listFiles) {
                        String name = file.getName();
                        if (name != null) {
                            switch (name.hashCode()) {
                                case -528983909:
                                    if (name.equals(NETWORK_INFO_FILE_NAME)) {
                                        Intrinsics.checkNotNullExpressionValue(file, "it");
                                        setLastSerializedNetworkInformation$dd_sdk_android_release(FilesKt.readText$default(file, (Charset) null, 1, (Object) null));
                                        break;
                                    } else {
                                        break;
                                    }
                                case 75377097:
                                    if (name.equals(RUM_VIEW_EVENT_FILE_NAME)) {
                                        Intrinsics.checkNotNullExpressionValue(file, "it");
                                        setLastSerializedRumViewEvent$dd_sdk_android_release(FilesKt.readText$default(file, (Charset) null, 1, (Object) null));
                                        break;
                                    } else {
                                        break;
                                    }
                                case 408381112:
                                    if (name.equals(USER_INFO_FILE_NAME)) {
                                        Intrinsics.checkNotNullExpressionValue(file, "it");
                                        setLastSerializedUserInformation$dd_sdk_android_release(FilesKt.readText$default(file, (Charset) null, 1, (Object) null));
                                        break;
                                    } else {
                                        break;
                                    }
                                case 1847397036:
                                    if (name.equals(CRASH_DATA_FILE_NAME)) {
                                        Intrinsics.checkNotNullExpressionValue(file, "it");
                                        setLastSerializedNdkCrashLog$dd_sdk_android_release(FilesKt.readText$default(file, (Charset) null, 1, (Object) null));
                                        break;
                                    } else {
                                        break;
                                    }
                            }
                        }
                    }
                }
            } catch (SecurityException e) {
                Logger.e$default(this.f3874g, ERROR_READ_NDK_DIR, e, (Map) null, 4, (Object) null);
            } catch (Throwable th) {
                m2511c();
                throw th;
            }
            m2511c();
        }
    }

    /* renamed from: a */
    private final void m2504a(DataWriter<LogEvent> dataWriter, DataWriter<Object> dataWriter2) {
        ViewEvent viewEvent;
        UserInfo userInfo;
        NetworkInfo networkInfo;
        String str = this.f3877j;
        String str2 = this.f3878k;
        String str3 = this.f3879l;
        String str4 = this.f3880m;
        if (str3 != null) {
            NdkCrashLog deserialize = this.f3870c.deserialize(str3);
            if (str == null) {
                viewEvent = null;
            } else {
                Object deserialize2 = this.f3871d.deserialize(str);
                viewEvent = deserialize2 instanceof ViewEvent ? (ViewEvent) deserialize2 : null;
            }
            if (str2 == null) {
                userInfo = null;
            } else {
                userInfo = this.f3873f.deserialize(str2);
            }
            if (str4 == null) {
                networkInfo = null;
            } else {
                networkInfo = this.f3872e.deserialize(str4);
            }
            m2505a(dataWriter, dataWriter2, deserialize, viewEvent, userInfo, networkInfo);
        }
        m2510b();
    }

    /* renamed from: b */
    private final void m2510b() {
        this.f3879l = null;
        this.f3880m = null;
        this.f3877j = null;
        this.f3878k = null;
    }

    /* renamed from: a */
    private final void m2505a(DataWriter<LogEvent> dataWriter, DataWriter<Object> dataWriter2, NdkCrashLog ndkCrashLog, ViewEvent viewEvent, UserInfo userInfo, NetworkInfo networkInfo) {
        Map map;
        if (ndkCrashLog != null) {
            String format = String.format(Locale.US, LOG_CRASH_MSG, Arrays.copyOf(new Object[]{ndkCrashLog.getSignalName()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, this, *args)");
            if (viewEvent != null) {
                Map mapOf = MapsKt.mapOf(TuplesKt.m42317to("session_id", viewEvent.getSession().getId()), TuplesKt.m42317to(LogAttributes.RUM_APPLICATION_ID, viewEvent.getApplication().getId()), TuplesKt.m42317to(LogAttributes.RUM_VIEW_ID, viewEvent.getView().getId()), TuplesKt.m42317to("error.stack", ndkCrashLog.getStacktrace()));
                m2506a(dataWriter2, format, ndkCrashLog, viewEvent);
                map = mapOf;
            } else {
                map = MapsKt.mapOf(TuplesKt.m42317to("error.stack", ndkCrashLog.getStacktrace()));
            }
            m2507a(dataWriter, format, (Map<String, String>) map, ndkCrashLog, networkInfo, userInfo);
        }
    }

    /* renamed from: a */
    private final void m2506a(DataWriter<Object> dataWriter, String str, NdkCrashLog ndkCrashLog, ViewEvent viewEvent) {
        dataWriter.write(m2501a(str, ndkCrashLog, viewEvent));
        if (System.currentTimeMillis() - viewEvent.getDate() < f3866n) {
            dataWriter.write(m2502a(viewEvent));
        }
    }

    /* renamed from: a */
    private final void m2507a(DataWriter<LogEvent> dataWriter, String str, Map<String, String> map, NdkCrashLog ndkCrashLog, NetworkInfo networkInfo, UserInfo userInfo) {
        DataWriter<LogEvent> dataWriter2 = dataWriter;
        dataWriter2.write(LogGenerator.generateLog$default(this.f3869b, 9, str, (Throwable) null, map, SetsKt.emptySet(), ndkCrashLog.getTimestamp(), (String) null, false, false, userInfo, networkInfo, 64, (Object) null));
    }

    /* renamed from: a */
    private final ViewEvent m2502a(ViewEvent viewEvent) {
        ViewEvent.Crash crash;
        ViewEvent.Crash crash2 = viewEvent.getView().getCrash();
        if (crash2 == null) {
            crash = null;
        } else {
            crash = crash2.copy(crash2.getCount() + 1);
        }
        if (crash == null) {
            crash = new ViewEvent.Crash(1);
        }
        return ViewEvent.copy$default(viewEvent, 0, (ViewEvent.Application) null, (String) null, (ViewEvent.ViewEventSession) null, ViewEvent.View.copy$default(viewEvent.getView(), (String) null, (String) null, (String) null, (String) null, (Long) null, (ViewEvent.LoadingType) null, 0, (Long) null, (Long) null, (Long) null, (Long) null, (Number) null, (Long) null, (Long) null, (Long) null, (Long) null, (ViewEvent.CustomTimings) null, false, (Boolean) null, (ViewEvent.Action) null, (ViewEvent.Error) null, crash, (ViewEvent.LongTask) null, (ViewEvent.FrozenFrame) null, (ViewEvent.Resource) null, (List) null, (Number) null, (Number) null, (Number) null, (Number) null, (Number) null, (Number) null, -2228225, (Object) null), (ViewEvent.Usr) null, (ViewEvent.Connectivity) null, (ViewEvent.Synthetics) null, ViewEvent.C2205Dd.copy$default(viewEvent.getDd(), (ViewEvent.DdSession) null, viewEvent.getDd().getDocumentVersion() + 1, 1, (Object) null), (ViewEvent.Context) null, 751, (Object) null);
    }

    /* renamed from: a */
    private final ErrorEvent m2501a(String str, NdkCrashLog ndkCrashLog, ViewEvent viewEvent) {
        ErrorEvent.Connectivity connectivity;
        ViewEvent.Connectivity connectivity2 = viewEvent.getConnectivity();
        String str2 = null;
        if (connectivity2 == null) {
            connectivity = null;
        } else {
            ErrorEvent.Status valueOf = ErrorEvent.Status.valueOf(connectivity2.getStatus().name());
            Iterable<ViewEvent.Interface> interfaces = connectivity2.getInterfaces();
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(interfaces, 10));
            for (ViewEvent.Interface name : interfaces) {
                arrayList.add(ErrorEvent.Interface.valueOf(name.name()));
            }
            List list = (List) arrayList;
            ViewEvent.Cellular cellular = connectivity2.getCellular();
            String technology = cellular == null ? null : cellular.getTechnology();
            ViewEvent.Cellular cellular2 = connectivity2.getCellular();
            connectivity = new ErrorEvent.Connectivity(valueOf, list, new ErrorEvent.Cellular(technology, cellular2 == null ? null : cellular2.getCarrierName()));
        }
        ViewEvent.Context context = viewEvent.getContext();
        Map<String, Object> additionalProperties = context == null ? null : context.getAdditionalProperties();
        if (additionalProperties == null) {
            additionalProperties = MapsKt.emptyMap();
        }
        ViewEvent.Usr usr = viewEvent.getUsr();
        Map<String, Object> additionalProperties2 = usr == null ? null : usr.getAdditionalProperties();
        if (additionalProperties2 == null) {
            additionalProperties2 = MapsKt.emptyMap();
        }
        long serverOffsetMillis = this.f3875h.getServerOffsetMillis() + ndkCrashLog.getTimestamp();
        ErrorEvent.Application application = new ErrorEvent.Application(viewEvent.getApplication().getId());
        String service = viewEvent.getService();
        ErrorEvent.ErrorEventSession errorEventSession = new ErrorEvent.ErrorEventSession(viewEvent.getSession().getId(), ErrorEvent.ErrorEventSessionType.USER, (Boolean) null, 4, (DefaultConstructorMarker) null);
        ErrorEvent.View view = new ErrorEvent.View(viewEvent.getView().getId(), viewEvent.getView().getReferrer(), viewEvent.getView().getUrl(), viewEvent.getView().getName(), (Boolean) null, 16, (DefaultConstructorMarker) null);
        ViewEvent.Usr usr2 = viewEvent.getUsr();
        String id = usr2 == null ? null : usr2.getId();
        ViewEvent.Usr usr3 = viewEvent.getUsr();
        String name2 = usr3 == null ? null : usr3.getName();
        ViewEvent.Usr usr4 = viewEvent.getUsr();
        if (usr4 != null) {
            str2 = usr4.getEmail();
        }
        return new ErrorEvent(serverOffsetMillis, application, service, errorEventSession, view, new ErrorEvent.Usr(id, name2, str2, additionalProperties2), connectivity, (ErrorEvent.Synthetics) null, new ErrorEvent.C2202Dd(new ErrorEvent.DdSession(ErrorEvent.Plan.PLAN_1)), new ErrorEvent.Context(additionalProperties), new ErrorEvent.Error((String) null, str, ErrorEvent.Source.SOURCE, ndkCrashLog.getStacktrace(), true, ndkCrashLog.getSignalName(), (ErrorEvent.Handling) null, (String) null, ErrorEvent.SourceType.ANDROID, (ErrorEvent.Resource) null, 705, (DefaultConstructorMarker) null), (ErrorEvent.Action) null, 2176, (DefaultConstructorMarker) null);
    }

    /* renamed from: c */
    private final void m2511c() {
        if (this.f3876i.exists()) {
            try {
                File[] listFiles = this.f3876i.listFiles();
                if (listFiles != null) {
                    for (File file : listFiles) {
                        Intrinsics.checkNotNullExpressionValue(file, "it");
                        FilesKt.deleteRecursively(file);
                    }
                }
            } catch (Throwable th) {
                Logger.e$default(this.f3874g, Intrinsics.stringPlus("Unable to clear the NDK crash report file: ", this.f3876i.getAbsolutePath()), th, (Map) null, 4, (Object) null);
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u0016J\u0015\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u0018J\u0015\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u001aJ\u0015\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u001cJ\u0015\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u001eJ\u0015\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0000¢\u0006\u0002\b J\u0015\u0010!\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\"J\u0015\u0010#\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0000¢\u0006\u0002\b$R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006%"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/ndk/DatadogNdkCrashHandler$Companion;", "", "()V", "CRASH_DATA_FILE_NAME", "", "DESERIALIZE_CRASH_EVENT_ERROR_MESSAGE", "ERROR_READ_NDK_DIR", "LOGGER_NAME", "LOG_CRASH_MSG", "NDK_CRASH_REPORTS_FOLDER_NAME", "NDK_CRASH_REPORTS_PENDING_FOLDER_NAME", "NETWORK_INFO_FILE_NAME", "RUM_VIEW_EVENT_FILE_NAME", "USER_INFO_FILE_NAME", "VIEW_EVENT_AVAILABILITY_TIME_THRESHOLD", "", "getVIEW_EVENT_AVAILABILITY_TIME_THRESHOLD$dd_sdk_android_release", "()J", "getCrashDataFile", "Ljava/io/File;", "context", "Landroid/content/Context;", "getCrashDataFile$dd_sdk_android_release", "getGrantedNetworkInfoFile", "getGrantedNetworkInfoFile$dd_sdk_android_release", "getGrantedUserInfoFile", "getGrantedUserInfoFile$dd_sdk_android_release", "getLastViewEventFile", "getLastViewEventFile$dd_sdk_android_release", "getNdkGrantedDir", "getNdkGrantedDir$dd_sdk_android_release", "getNdkPendingDir", "getNdkPendingDir$dd_sdk_android_release", "getPendingNetworkInfoFile", "getPendingNetworkInfoFile$dd_sdk_android_release", "getPendingUserInfoFile", "getPendingUserInfoFile$dd_sdk_android_release", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: DatadogNdkCrashHandler.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final long getVIEW_EVENT_AVAILABILITY_TIME_THRESHOLD$dd_sdk_android_release() {
            return DatadogNdkCrashHandler.f3866n;
        }

        public final File getNdkGrantedDir$dd_sdk_android_release(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new File(context.getFilesDir(), DatadogNdkCrashHandler.NDK_CRASH_REPORTS_FOLDER_NAME);
        }

        public final File getNdkPendingDir$dd_sdk_android_release(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new File(context.getFilesDir(), DatadogNdkCrashHandler.f3867o);
        }

        public final File getLastViewEventFile$dd_sdk_android_release(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new File(getNdkGrantedDir$dd_sdk_android_release(context), DatadogNdkCrashHandler.RUM_VIEW_EVENT_FILE_NAME);
        }

        public final File getPendingNetworkInfoFile$dd_sdk_android_release(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new File(getNdkPendingDir$dd_sdk_android_release(context), DatadogNdkCrashHandler.NETWORK_INFO_FILE_NAME);
        }

        public final File getGrantedNetworkInfoFile$dd_sdk_android_release(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new File(getNdkGrantedDir$dd_sdk_android_release(context), DatadogNdkCrashHandler.NETWORK_INFO_FILE_NAME);
        }

        public final File getPendingUserInfoFile$dd_sdk_android_release(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new File(getNdkPendingDir$dd_sdk_android_release(context), DatadogNdkCrashHandler.USER_INFO_FILE_NAME);
        }

        public final File getGrantedUserInfoFile$dd_sdk_android_release(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new File(getNdkGrantedDir$dd_sdk_android_release(context), DatadogNdkCrashHandler.USER_INFO_FILE_NAME);
        }

        public final File getCrashDataFile$dd_sdk_android_release(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new File(getNdkGrantedDir$dd_sdk_android_release(context), DatadogNdkCrashHandler.CRASH_DATA_FILE_NAME);
        }
    }
}
