package com.didiglobal.enginecore.cache.concurrent;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo175978d2 = {"com/didiglobal/enginecore/cache/concurrent/TaskQueue$schedule$2", "Lcom/didiglobal/enginecore/cache/concurrent/Task;", "runOnce", "", "engine-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: TaskQueue.kt */
public final class TaskQueue$schedule$2 extends Task {
    final /* synthetic */ Function0 $block;
    final /* synthetic */ String $name;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TaskQueue$schedule$2(Function0 function0, String str, String str2) {
        super(str2, false, 2, (DefaultConstructorMarker) null);
        this.$block = function0;
        this.$name = str;
    }

    public long runOnce() {
        return ((Number) this.$block.invoke()).longValue();
    }
}
