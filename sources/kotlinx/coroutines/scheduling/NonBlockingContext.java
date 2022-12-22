package kotlinx.coroutines.scheduling;

import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, mo175978d2 = {"Lkotlinx/coroutines/scheduling/NonBlockingContext;", "Lkotlinx/coroutines/scheduling/TaskContext;", "()V", "taskMode", "", "getTaskMode", "()I", "afterTask", "", "kotlinx-coroutines-core"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Tasks.kt */
public final class NonBlockingContext implements TaskContext {
    public static final NonBlockingContext INSTANCE = new NonBlockingContext();

    /* renamed from: a */
    private static final int f61591a = 0;

    public void afterTask() {
    }

    private NonBlockingContext() {
    }

    public int getTaskMode() {
        return f61591a;
    }
}
