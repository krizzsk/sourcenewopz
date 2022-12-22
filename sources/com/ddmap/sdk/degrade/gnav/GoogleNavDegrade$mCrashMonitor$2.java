package com.ddmap.sdk.degrade.gnav;

import com.ddmap.sdk.degrade.CrashMonitorImpl;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo175978d2 = {"<anonymous>", "Lcom/ddmap/sdk/degrade/CrashMonitorImpl;", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 13})
/* compiled from: GoogleNavDegrade.kt */
final class GoogleNavDegrade$mCrashMonitor$2 extends Lambda implements Function0<CrashMonitorImpl> {
    public static final GoogleNavDegrade$mCrashMonitor$2 INSTANCE = new GoogleNavDegrade$mCrashMonitor$2();

    GoogleNavDegrade$mCrashMonitor$2() {
        super(0);
    }

    public final CrashMonitorImpl invoke() {
        return new CrashMonitorImpl();
    }
}
