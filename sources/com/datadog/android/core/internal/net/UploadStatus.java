package com.datadog.android.core.internal.net;

import com.datadog.android.log.Logger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J2\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, mo175978d2 = {"Lcom/datadog/android/core/internal/net/UploadStatus;", "", "shouldRetry", "", "(Ljava/lang/String;IZ)V", "getShouldRetry", "()Z", "logStatus", "", "context", "", "byteSize", "", "logger", "Lcom/datadog/android/log/Logger;", "ignoreInfo", "requestId", "SUCCESS", "NETWORK_ERROR", "INVALID_TOKEN_ERROR", "HTTP_REDIRECTION", "HTTP_CLIENT_ERROR", "HTTP_SERVER_ERROR", "HTTP_CLIENT_RATE_LIMITING", "UNKNOWN_ERROR", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: UploadStatus.kt */
public enum UploadStatus {
    SUCCESS(false),
    NETWORK_ERROR(true),
    INVALID_TOKEN_ERROR(false),
    HTTP_REDIRECTION(false),
    HTTP_CLIENT_ERROR(false),
    HTTP_SERVER_ERROR(true),
    HTTP_CLIENT_RATE_LIMITING(true),
    UNKNOWN_ERROR(false);
    
    private final boolean shouldRetry;

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: UploadStatus.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] iArr = new int[UploadStatus.values().length];
            iArr[UploadStatus.NETWORK_ERROR.ordinal()] = 1;
            iArr[UploadStatus.INVALID_TOKEN_ERROR.ordinal()] = 2;
            iArr[UploadStatus.HTTP_REDIRECTION.ordinal()] = 3;
            iArr[UploadStatus.HTTP_CLIENT_ERROR.ordinal()] = 4;
            iArr[UploadStatus.HTTP_CLIENT_RATE_LIMITING.ordinal()] = 5;
            iArr[UploadStatus.HTTP_SERVER_ERROR.ordinal()] = 6;
            iArr[UploadStatus.UNKNOWN_ERROR.ordinal()] = 7;
            iArr[UploadStatus.SUCCESS.ordinal()] = 8;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private UploadStatus(boolean z) {
        this.shouldRetry = z;
    }

    public final boolean getShouldRetry() {
        return this.shouldRetry;
    }

    public final void logStatus(String str, int i, Logger logger, boolean z, String str2) {
        String str3;
        Intrinsics.checkNotNullParameter(str, "context");
        Intrinsics.checkNotNullParameter(logger, "logger");
        if (str2 == null) {
            str3 = "Batch [" + i + " bytes] (" + str + VersionRange.RIGHT_OPEN;
        } else {
            str3 = "Batch " + str2 + " [" + i + " bytes] (" + str + VersionRange.RIGHT_OPEN;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                Logger.e$default(logger, Intrinsics.stringPlus(str3, " failed because of a network error; we will retry later."), (Throwable) null, (Map) null, 6, (Object) null);
                return;
            case 2:
                if (!z) {
                    Logger.e$default(logger, Intrinsics.stringPlus(str3, " failed because your token is invalid. Make sure that the provided token still exists."), (Throwable) null, (Map) null, 6, (Object) null);
                    return;
                }
                return;
            case 3:
                Logger.w$default(logger, Intrinsics.stringPlus(str3, " failed because of a network redirection; the batch was dropped."), (Throwable) null, (Map) null, 6, (Object) null);
                return;
            case 4:
                Logger.e$default(logger, Intrinsics.stringPlus(str3, " failed because of a processing error or invalid data; the batch was dropped."), (Throwable) null, (Map) null, 6, (Object) null);
                return;
            case 5:
                Logger.e$default(logger, Intrinsics.stringPlus(str3, " failed because of a request error; we will retry later."), (Throwable) null, (Map) null, 6, (Object) null);
                return;
            case 6:
                Logger.e$default(logger, Intrinsics.stringPlus(str3, " failed because of a server processing error; we will retry later."), (Throwable) null, (Map) null, 6, (Object) null);
                return;
            case 7:
                Logger.e$default(logger, Intrinsics.stringPlus(str3, " failed because of an unknown error; the batch was dropped."), (Throwable) null, (Map) null, 6, (Object) null);
                return;
            case 8:
                if (!z) {
                    Logger.v$default(logger, Intrinsics.stringPlus(str3, " sent successfully."), (Throwable) null, (Map) null, 6, (Object) null);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
