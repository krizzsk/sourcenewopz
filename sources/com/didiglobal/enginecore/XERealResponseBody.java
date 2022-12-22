package com.didiglobal.enginecore;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSource;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0002\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didiglobal/enginecore/XERealResponseBody;", "Lcom/didiglobal/enginecore/XEResponseBody;", "source", "Lokio/BufferedSource;", "(Lokio/BufferedSource;)V", "engine-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: XERealResponseBody.kt */
public final class XERealResponseBody extends XEResponseBody {

    /* renamed from: a */
    private final BufferedSource f50106a;

    public XERealResponseBody(BufferedSource bufferedSource) {
        Intrinsics.checkParameterIsNotNull(bufferedSource, "source");
        this.f50106a = bufferedSource;
    }

    public BufferedSource source() {
        return this.f50106a;
    }
}
