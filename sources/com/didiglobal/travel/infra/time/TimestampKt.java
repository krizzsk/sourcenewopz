package com.didiglobal.travel.infra.time;

import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, mo175978d2 = {"rawOffsetTime", "", "Ljava/util/TimeZone;", "getRawOffsetTime", "(Ljava/util/TimeZone;)J", "lib-common_release"}, mo175979k = 2, mo175980mv = {1, 1, 16})
/* compiled from: Timestamp.kt */
public final class TimestampKt {
    public static final long getRawOffsetTime(TimeZone timeZone) {
        Intrinsics.checkParameterIsNotNull(timeZone, "$this$rawOffsetTime");
        return (long) timeZone.getRawOffset();
    }
}
