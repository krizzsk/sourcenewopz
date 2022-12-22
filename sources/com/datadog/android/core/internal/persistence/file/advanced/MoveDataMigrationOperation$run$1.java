package com.datadog.android.core.internal.persistence.file.advanced;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: MoveDataMigrationOperation.kt */
final class MoveDataMigrationOperation$run$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ MoveDataMigrationOperation this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MoveDataMigrationOperation$run$1(MoveDataMigrationOperation moveDataMigrationOperation) {
        super(0);
        this.this$0 = moveDataMigrationOperation;
    }

    public final boolean invoke() {
        return this.this$0.getFileHandler$dd_sdk_android_release().moveFiles(this.this$0.getFromDir$dd_sdk_android_release(), this.this$0.getToDir$dd_sdk_android_release());
    }
}
