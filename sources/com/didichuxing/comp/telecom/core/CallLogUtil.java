package com.didichuxing.comp.telecom.core;

import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.comp.telecom.core.CallManagerAssist;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0007J,\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007J\u001e\u0010\f\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/core/CallLogUtil;", "", "()V", "TAG", "", "logDebug", "", "comp", "msg", "logError", "throwable", "", "logI", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: CallUtils.kt */
public final class CallLogUtil {
    public static final CallLogUtil INSTANCE = new CallLogUtil();

    /* renamed from: a */
    private static final String f46385a = "VoipCall";

    @JvmStatic
    public static final void logDebug(String str) {
        logDebug$default((String) null, str, 1, (Object) null);
    }

    @JvmStatic
    public static final void logError() {
        logError$default((String) null, (String) null, (Throwable) null, 7, (Object) null);
    }

    @JvmStatic
    public static final void logError(String str) {
        logError$default(str, (String) null, (Throwable) null, 6, (Object) null);
    }

    @JvmStatic
    public static final void logError(String str, String str2) {
        logError$default(str, str2, (Throwable) null, 4, (Object) null);
    }

    @JvmStatic
    public static final void logI(String str) {
        logI$default((String) null, str, 1, (Object) null);
    }

    private CallLogUtil() {
    }

    @JvmStatic
    public static /* synthetic */ void logError$default(String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            th = null;
        }
        logError(str, str2, th);
    }

    @JvmStatic
    public static final void logError(String str, String str2, Throwable th) {
        CallManagerAssist.AppServiceProvider appServiceProvider;
        StringBuilder sb = new StringBuilder();
        String str3 = "";
        if (str == null) {
            str = str3;
        }
        sb.append(str);
        sb.append(" - ");
        if (str2 != null) {
            str3 = str2;
        }
        sb.append(str3);
        SystemUtils.log(6, f46385a, sb.toString(), th, "com.didichuxing.comp.telecom.core.CallLogUtil", 56);
        CallManagerAssist instance = CallManagerAssist.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "CallManagerAssist.getInstance()");
        CallManagerAssist.CallManagerConfig config = instance.getConfig();
        if (config != null && (appServiceProvider = config.getAppServiceProvider()) != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(" : ");
            sb2.append(th != null ? th.toString() : null);
            appServiceProvider.log(f46385a, sb2.toString());
        }
    }

    @JvmStatic
    public static /* synthetic */ void logDebug$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        logDebug(str, str2);
    }

    @JvmStatic
    public static final void logDebug(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            str = "";
        }
        sb.append(str);
        sb.append(" - ");
        if (str2 == null) {
            str2 = "";
        }
        sb.append(str2);
        SystemUtils.log(3, f46385a, sb.toString(), (Throwable) null, "com.didichuxing.comp.telecom.core.CallLogUtil", 64);
    }

    @JvmStatic
    public static /* synthetic */ void logI$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        logI(str, str2);
    }

    @JvmStatic
    public static final void logI(String str, String str2) {
        CallManagerAssist.AppServiceProvider appServiceProvider;
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            str = "";
        }
        sb.append(str);
        sb.append(" - ");
        if (str2 == null) {
            str2 = "";
        }
        sb.append(str2);
        String sb2 = sb.toString();
        CallManagerAssist instance = CallManagerAssist.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "CallManagerAssist.getInstance()");
        CallManagerAssist.CallManagerConfig config = instance.getConfig();
        if (config != null && (appServiceProvider = config.getAppServiceProvider()) != null) {
            appServiceProvider.log(f46385a, sb2);
        }
    }
}
