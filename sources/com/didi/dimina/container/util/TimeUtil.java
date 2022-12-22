package com.didi.dimina.container.util;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/dimina/container/util/TimeUtil;", "", "()V", "currentNanoMillis", "", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: TimeUtil.kt */
public final class TimeUtil {
    public static final TimeUtil INSTANCE = new TimeUtil();

    private TimeUtil() {
    }

    @JvmStatic
    public static final long currentNanoMillis() {
        return TimeUnit.NANOSECONDS.toMillis(System.nanoTime());
    }
}
