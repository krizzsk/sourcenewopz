package com.didiglobal.enginecore.cache;

import com.didi.soda.customer.blocks.BlocksConst;
import com.didiglobal.enginecore.XERealResponseBody;
import com.didiglobal.enginecore.XERequest;
import com.didiglobal.enginecore.XEResponse;
import com.didiglobal.enginecore.XEResponseBody;
import com.didiglobal.enginecore.cache.XEDiskLruCache;
import com.didiglobal.enginecore.cache.concurrent.TaskRunner;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSource;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0004*+,-B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0018\u00010\u0016R\u00020\fH\u0002J\u0018\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u0018J\b\u0010\u001c\u001a\u00020\u0014H\u0016J\u0006\u0010\u001d\u001a\u00020\u0014J\r\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\b\u001eJ\u0006\u0010\u001f\u001a\u00020\u0014J\b\u0010 \u001a\u00020\u0014H\u0016J\u0010\u0010!\u001a\u0004\u0018\u00010\u00182\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020\u0014J\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010%\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u0018J\u000e\u0010&\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#J\u0006\u0010'\u001a\u00020\u0006J\u000e\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\u0018R\u0014\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0003\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0012¨\u0006."}, mo175978d2 = {"Lcom/didiglobal/enginecore/cache/XEngineCache;", "Ljava/io/Closeable;", "Ljava/io/Flushable;", "directory", "Ljava/io/File;", "maxSize", "", "(Ljava/io/File;J)V", "fileSystem", "Lcom/didiglobal/enginecore/cache/XECacheFileSystem;", "(Ljava/io/File;JLcom/didiglobal/enginecore/cache/XECacheFileSystem;)V", "cache", "Lcom/didiglobal/enginecore/cache/XEDiskLruCache;", "getCache$engine_core_release", "()Lcom/didiglobal/enginecore/cache/XEDiskLruCache;", "()Ljava/io/File;", "isClosed", "", "()Z", "abortQuietly", "", "editor", "Lcom/didiglobal/enginecore/cache/XEDiskLruCache$Editor;", "cacheWritingResponse", "Lcom/didiglobal/enginecore/XEResponse;", "cacheRequest", "Lcom/didiglobal/enginecore/cache/XECacheRequest;", "response", "close", "delete", "-deprecated_directory", "evictAll", "flush", "get", "request", "Lcom/didiglobal/enginecore/XERequest;", "initialize", "put", "remove", "size", "update", "cached", "CacheResponseBody", "Companion", "Entry", "RealCacheRequest", "engine-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: XEngineCache.kt */
public final class XEngineCache implements Closeable, Flushable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: b */
    private static final int f50138b = 202204;

    /* renamed from: a */
    private final XEDiskLruCache f50139a;

    public XEngineCache(File file, long j, XECacheFileSystem xECacheFileSystem) {
        Intrinsics.checkParameterIsNotNull(file, "directory");
        Intrinsics.checkParameterIsNotNull(xECacheFileSystem, "fileSystem");
        this.f50139a = new XEDiskLruCache(xECacheFileSystem, file, f50138b, j, TaskRunner.INSTANCE);
    }

    public final XEDiskLruCache getCache$engine_core_release() {
        return this.f50139a;
    }

    public final boolean isClosed() {
        return this.f50139a.isClosed();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public XEngineCache(File file, long j) {
        this(file, j, XECacheFileSystem.SYSTEM);
        Intrinsics.checkParameterIsNotNull(file, "directory");
    }

    public final XEResponse get(XERequest xERequest) {
        Intrinsics.checkParameterIsNotNull(xERequest, "request");
        String keyId = xERequest.keyId();
        try {
            XEDiskLruCache.Snapshot snapshot = this.f50139a.get(keyId);
            if (snapshot != null) {
                Entry entry = new Entry(keyId);
                XEResponse response = entry.response(snapshot);
                if (entry.matches(xERequest, response)) {
                    return response;
                }
                XEResponseBody body = response.body();
                if (body != null) {
                    C16883Util.closeQuietly((Closeable) body);
                }
                return null;
            }
        } catch (IOException unused) {
        }
        return null;
    }

    public final XECacheRequest put(XEResponse xEResponse) {
        Intrinsics.checkParameterIsNotNull(xEResponse, "response");
        try {
            XEDiskLruCache.Editor edit$default = XEDiskLruCache.edit$default(this.f50139a, xEResponse.request().keyId(), 0, 2, (Object) null);
            if (edit$default != null) {
                return new RealCacheRequest(this, edit$default);
            }
            return null;
        } catch (IOException unused) {
            m36135a((XEDiskLruCache.Editor) null);
            return null;
        }
    }

    public final void remove(XERequest xERequest) throws IOException {
        Intrinsics.checkParameterIsNotNull(xERequest, "request");
        this.f50139a.remove(xERequest.keyId());
    }

    public final void update(XEResponse xEResponse) {
        Intrinsics.checkParameterIsNotNull(xEResponse, "cached");
        XEResponseBody body = xEResponse.body();
        if (body != null) {
            try {
                XEDiskLruCache.Editor edit = ((CacheResponseBody) body).getSnapshot().edit();
                if (edit != null) {
                    edit.commit();
                }
            } catch (IOException unused) {
                m36135a((XEDiskLruCache.Editor) null);
            }
        } else {
            throw new TypeCastException("null cannot be cast to non-null type com.didiglobal.enginecore.cache.XEngineCache.CacheResponseBody");
        }
    }

    /* renamed from: a */
    private final void m36135a(XEDiskLruCache.Editor editor) {
        if (editor != null) {
            try {
                editor.abort();
            } catch (IOException unused) {
            }
        }
    }

    public final void initialize() throws IOException {
        this.f50139a.initialize();
    }

    public final void delete() throws IOException {
        this.f50139a.delete();
    }

    public final void evictAll() throws IOException {
        this.f50139a.evictAll();
    }

    public final long size() throws IOException {
        return this.f50139a.size();
    }

    public final long maxSize() {
        return this.f50139a.getMaxSize();
    }

    public void flush() throws IOException {
        this.f50139a.flush();
    }

    public void close() throws IOException {
        this.f50139a.close();
    }

    public final File directory() {
        return this.f50139a.getDirectory();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "directory", imports = {}))
    /* renamed from: -deprecated_directory  reason: not valid java name */
    public final File m47046deprecated_directory() {
        return this.f50139a.getDirectory();
    }

    public final XEResponse cacheWritingResponse(XECacheRequest xECacheRequest, XEResponse xEResponse) throws IOException {
        Intrinsics.checkParameterIsNotNull(xEResponse, "response");
        if (xECacheRequest == null) {
            return xEResponse;
        }
        Sink body = xECacheRequest.body();
        XEResponseBody body2 = xEResponse.body();
        if (body2 == null) {
            Intrinsics.throwNpe();
        }
        return xEResponse.newBuilder().body(new XERealResponseBody(Okio.buffer((Source) new XEngineCache$cacheWritingResponse$cacheWritingSource$1(body2.source(), xECacheRequest, Okio.buffer(body))))).build();
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0012\u0010\u0002\u001a\u00060\u0003R\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo175978d2 = {"Lcom/didiglobal/enginecore/cache/XEngineCache$RealCacheRequest;", "Lcom/didiglobal/enginecore/cache/XECacheRequest;", "editor", "Lcom/didiglobal/enginecore/cache/XEDiskLruCache$Editor;", "Lcom/didiglobal/enginecore/cache/XEDiskLruCache;", "(Lcom/didiglobal/enginecore/cache/XEngineCache;Lcom/didiglobal/enginecore/cache/XEDiskLruCache$Editor;)V", "body", "Lokio/Sink;", "cacheOut", "done", "", "getDone", "()Z", "setDone", "(Z)V", "abort", "", "engine-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: XEngineCache.kt */
    private final class RealCacheRequest implements XECacheRequest {
        private final Sink body;
        private final Sink cacheOut;
        private boolean done;
        /* access modifiers changed from: private */
        public final XEDiskLruCache.Editor editor;
        final /* synthetic */ XEngineCache this$0;

        public RealCacheRequest(XEngineCache xEngineCache, XEDiskLruCache.Editor editor2) {
            Intrinsics.checkParameterIsNotNull(editor2, "editor");
            this.this$0 = xEngineCache;
            this.editor = editor2;
            Sink newSink = editor2.newSink();
            this.cacheOut = newSink;
            this.body = new ForwardingSink(this, newSink) {
                final /* synthetic */ RealCacheRequest this$0;

                {
                    this.this$0 = r1;
                }

                public void close() throws IOException {
                    synchronized (this.this$0.this$0) {
                        if (!this.this$0.getDone()) {
                            this.this$0.setDone(true);
                            Unit unit = Unit.INSTANCE;
                            super.close();
                            this.this$0.editor.commit();
                        }
                    }
                }
            };
        }

        public final boolean getDone() {
            return this.done;
        }

        public final void setDone(boolean z) {
            this.done = z;
        }

        public void abort() {
            synchronized (this.this$0) {
                if (!this.done) {
                    this.done = true;
                    Unit unit = Unit.INSTANCE;
                    C16883Util.closeQuietly((Closeable) this.cacheOut);
                    try {
                        this.editor.abort();
                    } catch (IOException unused) {
                    }
                }
            }
        }

        public Sink body() {
            return this.body;
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006J\u0012\u0010\u0005\u001a\u00020\u00062\n\u0010\f\u001a\u00060\rR\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo175978d2 = {"Lcom/didiglobal/enginecore/cache/XEngineCache$Entry;", "", "componentId", "", "(Ljava/lang/String;)V", "response", "Lcom/didiglobal/enginecore/XEResponse;", "(Lcom/didiglobal/enginecore/XEResponse;)V", "matches", "", "request", "Lcom/didiglobal/enginecore/XERequest;", "snapshot", "Lcom/didiglobal/enginecore/cache/XEDiskLruCache$Snapshot;", "Lcom/didiglobal/enginecore/cache/XEDiskLruCache;", "engine-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: XEngineCache.kt */
    private static final class Entry {
        private String componentId = "";

        public Entry(String str) throws IOException {
            Intrinsics.checkParameterIsNotNull(str, BlocksConst.BLOCK_PARAM_COMPONENT_ID);
            this.componentId = str;
        }

        public Entry(XEResponse xEResponse) {
            Intrinsics.checkParameterIsNotNull(xEResponse, "response");
            this.componentId = xEResponse.request().keyId();
        }

        public final boolean matches(XERequest xERequest, XEResponse xEResponse) {
            Intrinsics.checkParameterIsNotNull(xERequest, "request");
            Intrinsics.checkParameterIsNotNull(xEResponse, "response");
            return Intrinsics.areEqual((Object) this.componentId, (Object) xERequest.keyId());
        }

        public final XEResponse response(XEDiskLruCache.Snapshot snapshot) {
            Intrinsics.checkParameterIsNotNull(snapshot, "snapshot");
            return new XEResponse.Builder().request(new XERequest.Builder().key(this.componentId).build()).body(new CacheResponseBody(snapshot)).build();
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u0007H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, mo175978d2 = {"Lcom/didiglobal/enginecore/cache/XEngineCache$CacheResponseBody;", "Lcom/didiglobal/enginecore/XEResponseBody;", "snapshot", "Lcom/didiglobal/enginecore/cache/XEDiskLruCache$Snapshot;", "Lcom/didiglobal/enginecore/cache/XEDiskLruCache;", "(Lcom/didiglobal/enginecore/cache/XEDiskLruCache$Snapshot;)V", "bodySource", "Lokio/BufferedSource;", "getSnapshot", "()Lcom/didiglobal/enginecore/cache/XEDiskLruCache$Snapshot;", "source", "engine-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: XEngineCache.kt */
    private static final class CacheResponseBody extends XEResponseBody {
        private final BufferedSource bodySource;
        private final XEDiskLruCache.Snapshot snapshot;

        public final XEDiskLruCache.Snapshot getSnapshot() {
            return this.snapshot;
        }

        public CacheResponseBody(XEDiskLruCache.Snapshot snapshot2) {
            Intrinsics.checkParameterIsNotNull(snapshot2, "snapshot");
            this.snapshot = snapshot2;
            Source source = snapshot2.getSource();
            this.bodySource = Okio.buffer((Source) new ForwardingSource(this, source, source) {
                final /* synthetic */ Source $source;
                final /* synthetic */ CacheResponseBody this$0;

                {
                    this.this$0 = r1;
                    this.$source = r2;
                }

                public void close() throws IOException {
                    this.this$0.getSnapshot().close();
                    super.close();
                }
            });
        }

        public BufferedSource source() {
            return this.bodySource;
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didiglobal/enginecore/cache/XEngineCache$Companion;", "", "()V", "VERSION", "", "engine-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: XEngineCache.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
