package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H@"}, mo175978d2 = {"clearSource", "", "T", "continuation", "Lkotlin/coroutines/Continuation;", ""}, mo175979k = 3, mo175980mv = {1, 1, 15})
@DebugMetadata(mo176686c = "androidx.lifecycle.CoroutineLiveData", mo176687f = "CoroutineLiveData.kt", mo176688i = {0}, mo176689l = {234}, mo176690m = "clearSource$lifecycle_livedata_ktx_release", mo176691n = {"this"}, mo176692s = {"L$0"})
/* compiled from: CoroutineLiveData.kt */
final class CoroutineLiveData$clearSource$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CoroutineLiveData this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoroutineLiveData$clearSource$1(CoroutineLiveData coroutineLiveData, Continuation continuation) {
        super(continuation);
        this.this$0 = coroutineLiveData;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.clearSource$lifecycle_livedata_ktx_release(this);
    }
}
