package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "<anonymous parameter 0>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Semaphore.kt */
final class SemaphoreImpl$onCancellationRelease$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ C21994c this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SemaphoreImpl$onCancellationRelease$1(C21994c cVar) {
        super(1);
        this.this$0 = cVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Throwable th) {
        this.this$0.release();
    }
}