package com.didiglobal.enginecore.cache;

import com.didiglobal.enginecore.cache.concurrent.Task;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo175978d2 = {"com/didiglobal/enginecore/cache/XEDiskLruCache$cleanupTask$1", "Lcom/didiglobal/enginecore/cache/concurrent/Task;", "runOnce", "", "engine-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: XEDiskLruCache.kt */
public final class XEDiskLruCache$cleanupTask$1 extends Task {
    final /* synthetic */ XEDiskLruCache this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    XEDiskLruCache$cleanupTask$1(XEDiskLruCache xEDiskLruCache, String str) {
        super(str, false, 2, (DefaultConstructorMarker) null);
        this.this$0 = xEDiskLruCache;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r6.this$0.f50131n = true;
        r6.this$0.f50123f = okio.Okio.buffer(okio.Okio.blackhole());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004b, code lost:
        return -1;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x001d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0036 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long runOnce() {
        /*
            r6 = this;
            com.didiglobal.enginecore.cache.XEDiskLruCache r0 = r6.this$0
            monitor-enter(r0)
            com.didiglobal.enginecore.cache.XEDiskLruCache r1 = r6.this$0     // Catch:{ all -> 0x004c }
            boolean r1 = r1.f50128k     // Catch:{ all -> 0x004c }
            r2 = -1
            if (r1 == 0) goto L_0x004a
            com.didiglobal.enginecore.cache.XEDiskLruCache r1 = r6.this$0     // Catch:{ all -> 0x004c }
            boolean r1 = r1.getClosed$engine_core_release()     // Catch:{ all -> 0x004c }
            if (r1 == 0) goto L_0x0016
            goto L_0x004a
        L_0x0016:
            r1 = 1
            com.didiglobal.enginecore.cache.XEDiskLruCache r4 = r6.this$0     // Catch:{ IOException -> 0x001d }
            r4.trimToSize()     // Catch:{ IOException -> 0x001d }
            goto L_0x0022
        L_0x001d:
            com.didiglobal.enginecore.cache.XEDiskLruCache r4 = r6.this$0     // Catch:{ all -> 0x004c }
            r4.f50130m = r1     // Catch:{ all -> 0x004c }
        L_0x0022:
            com.didiglobal.enginecore.cache.XEDiskLruCache r4 = r6.this$0     // Catch:{ IOException -> 0x0036 }
            boolean r4 = r4.m36132d()     // Catch:{ IOException -> 0x0036 }
            if (r4 == 0) goto L_0x0048
            com.didiglobal.enginecore.cache.XEDiskLruCache r4 = r6.this$0     // Catch:{ IOException -> 0x0036 }
            r4.rebuildJournal$engine_core_release()     // Catch:{ IOException -> 0x0036 }
            com.didiglobal.enginecore.cache.XEDiskLruCache r4 = r6.this$0     // Catch:{ IOException -> 0x0036 }
            r5 = 0
            r4.f50125h = r5     // Catch:{ IOException -> 0x0036 }
            goto L_0x0048
        L_0x0036:
            com.didiglobal.enginecore.cache.XEDiskLruCache r4 = r6.this$0     // Catch:{ all -> 0x004c }
            r4.f50131n = r1     // Catch:{ all -> 0x004c }
            com.didiglobal.enginecore.cache.XEDiskLruCache r1 = r6.this$0     // Catch:{ all -> 0x004c }
            okio.Sink r4 = okio.Okio.blackhole()     // Catch:{ all -> 0x004c }
            okio.BufferedSink r4 = okio.Okio.buffer((okio.Sink) r4)     // Catch:{ all -> 0x004c }
            r1.f50123f = r4     // Catch:{ all -> 0x004c }
        L_0x0048:
            monitor-exit(r0)
            return r2
        L_0x004a:
            monitor-exit(r0)
            return r2
        L_0x004c:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.enginecore.cache.XEDiskLruCache$cleanupTask$1.runOnce():long");
    }
}
