package com.datadog.android.core.internal.persistence.file.batch;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "it", "Ljava/io/File;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BatchFileOrchestrator.kt */
final class BatchFileOrchestrator$deleteObsoleteFiles$1 extends Lambda implements Function1<File, Boolean> {
    final /* synthetic */ long $threshold;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BatchFileOrchestrator$deleteObsoleteFiles$1(long j) {
        super(1);
        this.$threshold = j;
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((File) obj));
    }

    public final boolean invoke(File file) {
        Intrinsics.checkNotNullParameter(file, "it");
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "it.name");
        return Long.parseLong(name) < this.$threshold;
    }
}
