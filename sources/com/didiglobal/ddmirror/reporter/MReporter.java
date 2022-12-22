package com.didiglobal.ddmirror.reporter;

import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didiglobal/ddmirror/reporter/MReporter;", "", "()V", "Companion", "DDMirrorReporter_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: MReporter.kt */
public final class MReporter {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J:\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u0018\u0010\n\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000bJ]\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u0018\u0010\n\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b¢\u0006\u0002\u0010\u000fJ(\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0016\u0010\u0011\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012H\u0002¨\u0006\u0013"}, mo175978d2 = {"Lcom/didiglobal/ddmirror/reporter/MReporter$Companion;", "", "()V", "reportError", "", "eventKey", "", "errType", "", "module", "extra", "", "errMsg", "errNo", "traceId", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "trackEvent", "attrs", "", "DDMirrorReporter_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: MReporter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void reportError(String str, int i, String str2, Map<String, Object> map) {
            Intrinsics.checkParameterIsNotNull(str, "eventKey");
            reportError(str, Integer.valueOf(i), "", 0, "", str2, map);
        }

        public final void reportError(String str, Integer num, String str2, int i, String str3, String str4, Map<String, Object> map) {
            Intrinsics.checkParameterIsNotNull(str, "eventKey");
            Map hashMap = new HashMap();
            hashMap.put("err_type", num);
            hashMap.put("err_msg", str2);
            hashMap.put("err_no", Integer.valueOf(i));
            hashMap.put(ParamConst.TRACE_ID, str3);
            hashMap.put("module", str4);
            if (map != null) {
                hashMap.putAll(map);
            }
            trackEvent(str, hashMap);
        }

        private final void trackEvent(String str, Map<String, ? extends Object> map) {
            OmegaSDKAdapter.trackEvent(MConstants.INSTANCE.getOMEGA_TECH_EVENT_PEFIX() + str, (Map<String, Object>) map);
        }
    }
}
