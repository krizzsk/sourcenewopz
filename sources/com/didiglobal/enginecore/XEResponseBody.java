package com.didiglobal.enginecore;

import com.didiglobal.enginecore.cache.C16883Util;
import java.io.Closeable;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okio.Buffer;
import okio.BufferedSource;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH&J\u0006\u0010\t\u001a\u00020\n¨\u0006\f"}, mo175978d2 = {"Lcom/didiglobal/enginecore/XEResponseBody;", "Ljava/io/Closeable;", "()V", "charset", "Ljava/nio/charset/Charset;", "close", "", "source", "Lokio/BufferedSource;", "string", "", "Companion", "engine-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: XEResponseBody.kt */
public abstract class XEResponseBody implements Closeable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @JvmStatic
    public static final XEResponseBody create(String str) {
        return Companion.create(str);
    }

    @JvmStatic
    public static final XEResponseBody create(BufferedSource bufferedSource) {
        return Companion.create(bufferedSource);
    }

    public abstract BufferedSource source();

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0022, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001e, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        kotlin.p245io.CloseableKt.closeFinally(r0, r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String string() throws java.io.IOException {
        /*
            r4 = this;
            okio.BufferedSource r0 = r4.source()
            java.io.Closeable r0 = (java.io.Closeable) r0
            r1 = 0
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            r2 = r0
            okio.BufferedSource r2 = (okio.BufferedSource) r2     // Catch:{ all -> 0x001c }
            java.nio.charset.Charset r3 = r4.charset()     // Catch:{ all -> 0x001c }
            java.nio.charset.Charset r3 = com.didiglobal.enginecore.cache.C16883Util.readBomAsCharset(r2, r3)     // Catch:{ all -> 0x001c }
            java.lang.String r2 = r2.readString(r3)     // Catch:{ all -> 0x001c }
            kotlin.p245io.CloseableKt.closeFinally(r0, r1)
            return r2
        L_0x001c:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x001e }
        L_0x001e:
            r2 = move-exception
            kotlin.p245io.CloseableKt.closeFinally(r0, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.enginecore.XEResponseBody.string():java.lang.String");
    }

    private final Charset charset() {
        return Charsets.UTF_8;
    }

    public void close() {
        C16883Util.closeQuietly((Closeable) source());
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0007¢\u0006\u0002\b\u0006J\u0011\u0010\u0007\u001a\u00020\u0004*\u00020\bH\u0007¢\u0006\u0002\b\u0006¨\u0006\t"}, mo175978d2 = {"Lcom/didiglobal/enginecore/XEResponseBody$Companion;", "", "()V", "asResponseBody", "Lcom/didiglobal/enginecore/XEResponseBody;", "Lokio/BufferedSource;", "create", "toResponseBody", "", "engine-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: XEResponseBody.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final XEResponseBody create(String str) {
            Intrinsics.checkParameterIsNotNull(str, "$this$toResponseBody");
            return create((BufferedSource) new Buffer().writeString(str, Charsets.UTF_8));
        }

        @JvmStatic
        public final XEResponseBody create(BufferedSource bufferedSource) {
            Intrinsics.checkParameterIsNotNull(bufferedSource, "$this$asResponseBody");
            return new XEResponseBody$Companion$asResponseBody$1(bufferedSource);
        }
    }
}
