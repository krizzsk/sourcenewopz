package com.didiglobal.enginecore.cache;

import com.didiglobal.enginecore.cache.XEDiskLruCache;
import kotlin.Metadata;
import kotlin.Unit;
import okio.ForwardingSource;
import okio.Source;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"com/didiglobal/enginecore/cache/XEDiskLruCache$Entry$newSource$1", "Lokio/ForwardingSource;", "closed", "", "close", "", "engine-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: XEDiskLruCache.kt */
public final class XEDiskLruCache$Entry$newSource$1 extends ForwardingSource {
    final /* synthetic */ Source $fileSource;
    private boolean closed;
    final /* synthetic */ XEDiskLruCache.Entry this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    XEDiskLruCache$Entry$newSource$1(XEDiskLruCache.Entry entry, Source source, Source source2) {
        super(source2);
        this.this$0 = entry;
        this.$fileSource = source;
    }

    public void close() {
        super.close();
        if (!this.closed) {
            this.closed = true;
            synchronized (this.this$0.this$0) {
                XEDiskLruCache.Entry entry = this.this$0;
                entry.setLockingSourceCount$engine_core_release(entry.getLockingSourceCount$engine_core_release() - 1);
                if (this.this$0.getLockingSourceCount$engine_core_release() == 0 && this.this$0.getZombie$engine_core_release()) {
                    this.this$0.this$0.removeEntry$engine_core_release(this.this$0);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }
}
