package com.didiglobal.enginecore.cache;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo175978d2 = {"<anonymous>", "", "it", "Ljava/io/IOException;", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: XEDiskLruCache.kt */
final class XEDiskLruCache$newJournalWriter$faultHidingSink$1 extends Lambda implements Function1<IOException, Unit> {
    final /* synthetic */ XEDiskLruCache this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    XEDiskLruCache$newJournalWriter$faultHidingSink$1(XEDiskLruCache xEDiskLruCache) {
        super(1);
        this.this$0 = xEDiskLruCache;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((IOException) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(IOException iOException) {
        Intrinsics.checkParameterIsNotNull(iOException, "it");
        this.this$0.f50126i = true;
    }
}
