package com.didi.dimina.container.mina;

import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, mo175978d2 = {"<anonymous>", "", "T", "run"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: DMSingleTaskExecutor.kt */
final class SingleTaskRunnable$run$1 implements Runnable {
    final /* synthetic */ SingleTaskRunnable this$0;

    SingleTaskRunnable$run$1(SingleTaskRunnable singleTaskRunnable) {
        this.this$0 = singleTaskRunnable;
    }

    public final void run() {
        ITask task = this.this$0.getTask();
        if (task != null) {
            task.onComplete(this.this$0.getResult());
        }
    }
}
