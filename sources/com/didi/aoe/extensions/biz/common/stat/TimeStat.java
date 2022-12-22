package com.didi.aoe.extensions.biz.common.stat;

import com.didi.aoe.library.logging.Logger;
import com.didi.aoe.library.logging.LoggerFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000f\u001a\u00020\u0006J\u0006\u0010\u0010\u001a\u00020\u0011R\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/aoe/extensions/biz/common/stat/TimeStat;", "", "tag", "", "(Ljava/lang/String;)V", "<set-?>", "", "avgTimeInMills", "getAvgTimeInMills", "()J", "count", "mLogger", "Lcom/didi/aoe/library/logging/Logger;", "timeTotal", "timestamp", "markEnd", "markStart", "", "features-biz-common_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: TimeStat.kt */
public final class TimeStat {

    /* renamed from: a */
    private final Logger f8133a;

    /* renamed from: b */
    private long f8134b;

    /* renamed from: c */
    private long f8135c;

    /* renamed from: d */
    private long f8136d;

    /* renamed from: e */
    private long f8137e;

    /* renamed from: f */
    private final String f8138f;

    public TimeStat(String str) {
        Intrinsics.checkParameterIsNotNull(str, "tag");
        this.f8138f = str;
        Logger logger = LoggerFactory.getLogger("TimeStat");
        Intrinsics.checkExpressionValueIsNotNull(logger, "LoggerFactory.getLogger(\"TimeStat\")");
        this.f8133a = logger;
    }

    public final long getAvgTimeInMills() {
        return this.f8137e;
    }

    public final void markStart() {
        this.f8136d = System.currentTimeMillis();
    }

    public final long markEnd() {
        long currentTimeMillis = System.currentTimeMillis() - this.f8136d;
        long j = this.f8135c + currentTimeMillis;
        this.f8135c = j;
        long j2 = this.f8134b + 1;
        this.f8134b = j2;
        this.f8137e = j / j2;
        return currentTimeMillis;
    }
}
