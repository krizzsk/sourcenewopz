package kotlinx.coroutines;

import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, mo175978d2 = {"Lkotlinx/coroutines/CancelFutureOnCompletion;", "Lkotlinx/coroutines/JobNode;", "future", "Ljava/util/concurrent/Future;", "(Ljava/util/concurrent/Future;)V", "invoke", "", "cause", "", "kotlinx-coroutines-core"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: kotlinx.coroutines.f */
/* compiled from: Future.kt */
final class C21841f extends JobNode {

    /* renamed from: a */
    private final Future<?> f61440a;

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public C21841f(Future<?> future) {
        this.f61440a = future;
    }

    public void invoke(Throwable th) {
        if (th != null) {
            this.f61440a.cancel(false);
        }
    }
}
