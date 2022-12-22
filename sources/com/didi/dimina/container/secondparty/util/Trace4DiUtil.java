package com.didi.dimina.container.secondparty.util;

import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.secondparty.trace.TraceActionServiceImpl;
import com.didi.dimina.container.service.TraceActionService;

public class Trace4DiUtil {

    /* renamed from: a */
    private static TraceActionServiceImpl f17484a;

    static {
        TraceActionService traceActionService = Dimina.getConfig().getAdapterConfig().getTraceActionService();
        if (traceActionService instanceof TraceActionServiceImpl) {
            f17484a = (TraceActionServiceImpl) traceActionService;
        }
    }

    public static void setMainPackageDownloadStartTime() {
        TraceActionServiceImpl traceActionServiceImpl = f17484a;
        if (traceActionServiceImpl != null) {
            traceActionServiceImpl.setMainPackageDownloadStartTime();
        }
    }

    public static void trackMainPackageDownloadStart(int i) {
        TraceActionServiceImpl traceActionServiceImpl = f17484a;
        if (traceActionServiceImpl != null) {
            traceActionServiceImpl.trackMainPackageDownloadStart(i);
        }
    }

    public static void trackMainPackageDownloadRemoteStart(int i) {
        TraceActionServiceImpl traceActionServiceImpl = f17484a;
        if (traceActionServiceImpl != null) {
            traceActionServiceImpl.trackMainPackageDownloadRemoteStart(i);
        }
    }

    public static void trackMainPackageDownloadLocalSuccess(int i, String str, String str2, String str3, String str4) {
        TraceActionServiceImpl traceActionServiceImpl = f17484a;
        if (traceActionServiceImpl != null) {
            traceActionServiceImpl.trackMainPackageDownloadLocalSuccess(i, str, str2, str3, str4);
        }
    }

    public static void trackMainPackageDownloadLocalFail(int i, int i2, String str, String str2, String str3, String str4) {
        TraceActionServiceImpl traceActionServiceImpl = f17484a;
        if (traceActionServiceImpl != null) {
            traceActionServiceImpl.trackMainPackageDownloadLocalFail(i, i2, str, str2, str3, str4);
        }
    }

    public static void trackMainPackageDownloadRemoteSuccess(int i, String str, String str2, String str3, String str4) {
        TraceActionServiceImpl traceActionServiceImpl = f17484a;
        if (traceActionServiceImpl != null) {
            traceActionServiceImpl.trackMainPackageDownloadRemoteSuccess(i, str, str2, str3, str4);
        }
    }

    public static void trackMainPackageDownloadRemoteFail(int i, int i2, String str, String str2, String str3, String str4) {
        TraceActionServiceImpl traceActionServiceImpl = f17484a;
        if (traceActionServiceImpl != null) {
            traceActionServiceImpl.trackMainPackageDownloadRemoteFail(i, i2, str, str2, str3, str4);
        }
    }

    public static void trackSubPackageDownloadStart(int i, String str) {
        TraceActionServiceImpl traceActionServiceImpl = f17484a;
        if (traceActionServiceImpl != null) {
            traceActionServiceImpl.trackSubPackageDownloadStart(i, str);
        }
    }

    public static void trackSubPackageDownloadResult(int i, boolean z, String str, int i2, boolean z2) {
        TraceActionServiceImpl traceActionServiceImpl = f17484a;
        if (traceActionServiceImpl != null) {
            traceActionServiceImpl.trackSubPackageDownloadResult(i, z, str, i2, z2);
        }
    }

    public static void newTraceForceUpdateErrorEnd(DMMina dMMina, String str, int i, String str2) {
        TraceActionServiceImpl traceActionServiceImpl = f17484a;
        if (traceActionServiceImpl != null) {
            traceActionServiceImpl.newTraceForceUpdateErrorEnd(dMMina, str, i, str2);
        }
    }

    public static void tracePmException(String str, int i, String str2) {
        TraceActionServiceImpl traceActionServiceImpl = f17484a;
        if (traceActionServiceImpl != null) {
            traceActionServiceImpl.tracePmException(str, i, str2);
        }
    }

    public static void trackBackgroundFetchDataDuration(int i, String str, String str2, String str3) {
        TraceActionServiceImpl traceActionServiceImpl = f17484a;
        if (traceActionServiceImpl != null) {
            traceActionServiceImpl.trackBackgroundFetchDataDuration(i, str, str2, str3);
        }
    }

    public static void trackBackgroundFetchDataError(int i, String str, int i2, String str2) {
        TraceActionServiceImpl traceActionServiceImpl = f17484a;
        if (traceActionServiceImpl != null) {
            traceActionServiceImpl.trackBackgroundFetchDataError(i, str, i2, str2);
        }
    }

    public static void tracePmInstallStart(String str, String str2, String str3) {
        TraceActionServiceImpl traceActionServiceImpl = f17484a;
        if (traceActionServiceImpl != null) {
            traceActionServiceImpl.tracePmInstallStart(str, str2, str3);
        }
    }

    public static void tracePmConfigRequestStart(int i) {
        TraceActionServiceImpl traceActionServiceImpl = f17484a;
        if (traceActionServiceImpl != null) {
            traceActionServiceImpl.tracePmConfigRequestStart(i);
        }
    }

    public static void tracePmConfigRequestEnd(int i, int i2, long j, String str, String str2) {
        TraceActionServiceImpl traceActionServiceImpl = f17484a;
        if (traceActionServiceImpl != null) {
            traceActionServiceImpl.tracePmConfigRequestEnd(i, i2, j, str, str2);
        }
    }

    public static void tracePmDownloadInstallStart(int i) {
        TraceActionServiceImpl traceActionServiceImpl = f17484a;
        if (traceActionServiceImpl != null) {
            traceActionServiceImpl.tracePmDownloadInstallStart(i);
        }
    }

    public static void tracePmDownloadInstallEnd(int i, int i2, long j, long j2, long j3, String str, String str2, String str3, String str4) {
        TraceActionServiceImpl traceActionServiceImpl = f17484a;
        if (traceActionServiceImpl != null) {
            traceActionServiceImpl.tracePmDownloadInstallEnd(i, i2, j, j2, j3, str, str2, str3, str4);
        }
    }

    public static void tracePmSubPackageRequestStart(int i) {
        TraceActionServiceImpl traceActionServiceImpl = f17484a;
        if (traceActionServiceImpl != null) {
            traceActionServiceImpl.tracePmSubPackageRequestStart(i);
        }
    }

    public static void tracePmSubPackageRequestEnd(int i, String str, long j, String str2, String str3, String str4) {
        TraceActionServiceImpl traceActionServiceImpl = f17484a;
        if (traceActionServiceImpl != null) {
            traceActionServiceImpl.tracePmSubPackageRequestEnd(i, str, j, str2, str3, str4);
        }
    }

    public static void tracePmSubPackageDownloadStart(int i) {
        TraceActionServiceImpl traceActionServiceImpl = f17484a;
        if (traceActionServiceImpl != null) {
            traceActionServiceImpl.tracePmSubPackageDownloadStart(i);
        }
    }

    public static void tracePmSubPackageDownloadEnd(int i, String str, long j, String str2, String str3, String str4) {
        TraceActionServiceImpl traceActionServiceImpl = f17484a;
        if (traceActionServiceImpl != null) {
            traceActionServiceImpl.tracePmSubPackageDownloadEnd(i, str, j, str2, str3, str4);
        }
    }

    public static void traceWebRequestBigImgWaring(String str, int i, int i2, long j, String str2, String str3, String str4, long j2, long j3, String str5, String str6) {
        TraceActionServiceImpl traceActionServiceImpl = f17484a;
        if (traceActionServiceImpl != null) {
            traceActionServiceImpl.traceWebRequestBigImgWaring(str, i, i2, j, str2, str3, str4, j2, j3, str5, str6);
        }
    }

    public static void traceImageWebRequestFromCache(String str, int i, int i2, long j, String str2, String str3, long j2, String str4, String str5) {
        TraceActionServiceImpl traceActionServiceImpl = f17484a;
        if (traceActionServiceImpl != null) {
            traceActionServiceImpl.traceImageWebRequestFromCache(str, i, i2, j, str2, str3, j2, str4, str5);
        }
    }
}
