package com.didiglobal.enginecore;

import java.io.File;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, mo175978d2 = {"com/didiglobal/enginecore/XERequestBody$Companion$asRequestBody$1", "Lcom/didiglobal/enginecore/XERequestBody;", "contentLength", "", "writeTo", "", "sink", "Lokio/BufferedSink;", "engine-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: XERequestBody.kt */
public final class XERequestBody$Companion$asRequestBody$1 extends XERequestBody {
    final /* synthetic */ File $this_asRequestBody;

    XERequestBody$Companion$asRequestBody$1(File file) {
        this.$this_asRequestBody = file;
    }

    public long contentLength() {
        return this.$this_asRequestBody.length();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        kotlin.p245io.CloseableKt.closeFinally(r0, r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeTo(okio.BufferedSink r4) {
        /*
            r3 = this;
            java.lang.String r0 = "sink"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r0)
            java.io.File r0 = r3.$this_asRequestBody
            okio.Source r0 = okio.Okio.source((java.io.File) r0)
            java.io.Closeable r0 = (java.io.Closeable) r0
            r1 = 0
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            r2 = r0
            okio.Source r2 = (okio.Source) r2     // Catch:{ all -> 0x001a }
            r4.writeAll(r2)     // Catch:{ all -> 0x001a }
            kotlin.p245io.CloseableKt.closeFinally(r0, r1)
            return
        L_0x001a:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x001c }
        L_0x001c:
            r1 = move-exception
            kotlin.p245io.CloseableKt.closeFinally(r0, r4)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.enginecore.XERequestBody$Companion$asRequestBody$1.writeTo(okio.BufferedSink):void");
    }
}
