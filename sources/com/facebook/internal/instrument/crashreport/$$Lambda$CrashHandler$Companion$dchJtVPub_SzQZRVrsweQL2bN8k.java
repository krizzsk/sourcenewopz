package com.facebook.internal.instrument.crashreport;

import com.facebook.internal.instrument.InstrumentData;
import com.facebook.internal.instrument.crashreport.CrashHandler;
import java.util.Comparator;

/* renamed from: com.facebook.internal.instrument.crashreport.-$$Lambda$CrashHandler$Companion$dchJtVPub_SzQZRVrsweQL2bN8k  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$CrashHandler$Companion$dchJtVPub_SzQZRVrsweQL2bN8k implements Comparator {
    public static final /* synthetic */ $$Lambda$CrashHandler$Companion$dchJtVPub_SzQZRVrsweQL2bN8k INSTANCE = new $$Lambda$CrashHandler$Companion$dchJtVPub_SzQZRVrsweQL2bN8k();

    private /* synthetic */ $$Lambda$CrashHandler$Companion$dchJtVPub_SzQZRVrsweQL2bN8k() {
    }

    public final int compare(Object obj, Object obj2) {
        return CrashHandler.Companion.m47416sendExceptionReports$lambda2((InstrumentData) obj, (InstrumentData) obj2);
    }
}
