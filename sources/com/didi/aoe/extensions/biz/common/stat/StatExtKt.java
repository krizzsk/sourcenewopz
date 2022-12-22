package com.didi.aoe.extensions.biz.common.stat;

import com.didi.raven.config.RavenKey;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\u001a\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u0001\u001a\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00110\u0010\"\u0014\u0010\u0000\u001a\u00020\u0001XD¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0001XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\"\u0014\u0010\u0006\u001a\u00020\u0001XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0003\"\u0014\u0010\b\u001a\u00020\u0001XD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0003¨\u0006\u0012"}, mo175978d2 = {"STAT_KEY_CPU_RATE", "", "getSTAT_KEY_CPU_RATE", "()Ljava/lang/String;", "STAT_KEY_MEMORY", "getSTAT_KEY_MEMORY", "STAT_KEY_MODULE_TAG", "getSTAT_KEY_MODULE_TAG", "STAT_KEY_PROCESS_TIME_IN_MILLS", "getSTAT_KEY_PROCESS_TIME_IN_MILLS", "statReport", "", "id", "key", "value", "attrs", "", "", "features-biz-common_release"}, mo175979k = 2, mo175980mv = {1, 1, 15})
/* compiled from: StatExt.kt */
public final class StatExtKt {

    /* renamed from: a */
    private static final String f8129a = "key_module_tag";

    /* renamed from: b */
    private static final String f8130b = "cpu";

    /* renamed from: c */
    private static final String f8131c = "mem";

    /* renamed from: d */
    private static final String f8132d = "timec";

    public static final String getSTAT_KEY_MODULE_TAG() {
        return f8129a;
    }

    public static final String getSTAT_KEY_CPU_RATE() {
        return f8130b;
    }

    public static final String getSTAT_KEY_MEMORY() {
        return f8131c;
    }

    public static final String getSTAT_KEY_PROCESS_TIME_IN_MILLS() {
        return f8132d;
    }

    public static final void statReport(String str, Map<String, ? extends Object> map) {
        Intrinsics.checkParameterIsNotNull(str, "id");
        Intrinsics.checkParameterIsNotNull(map, RavenKey.ATTRS);
        OmegaSDKAdapter.trackEvent(str, (Map<String, Object>) map);
    }

    public static final void statReport(String str, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(str, "id");
        Intrinsics.checkParameterIsNotNull(str2, "key");
        Intrinsics.checkParameterIsNotNull(str3, "value");
        HashMap hashMap = new HashMap();
        hashMap.put(str2, str3);
        statReport(str, hashMap);
    }
}
