package com.didiglobal.enginecore.cache;

import com.didiglobal.enginecore.cache.XEDiskLruCache;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, mo175978d2 = {"<anonymous>", "", "it", "Ljava/io/IOException;", "invoke", "com/didiglobal/enginecore/cache/XEDiskLruCache$Editor$newSink$1$1"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: XEDiskLruCache.kt */
final class XEDiskLruCache$Editor$newSink$$inlined$synchronized$lambda$1 extends Lambda implements Function1<IOException, Unit> {
    final /* synthetic */ XEDiskLruCache.Editor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    XEDiskLruCache$Editor$newSink$$inlined$synchronized$lambda$1(XEDiskLruCache.Editor editor) {
        super(1);
        this.this$0 = editor;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((IOException) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(IOException iOException) {
        Intrinsics.checkParameterIsNotNull(iOException, "it");
        synchronized (this.this$0.this$0) {
            this.this$0.detach$engine_core_release();
            Unit unit = Unit.INSTANCE;
        }
    }
}
