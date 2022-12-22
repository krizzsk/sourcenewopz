package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u000e\u001a\u00020\u0002J\u001e\u0010\u000f\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R(\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0011"}, mo175978d2 = {"Lkotlin/coroutines/jvm/internal/RunSuspend;", "Lkotlin/coroutines/Continuation;", "", "()V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "result", "Lkotlin/Result;", "getResult-xLWZpok", "()Lkotlin/Result;", "setResult", "(Lkotlin/Result;)V", "await", "resumeWith", "(Ljava/lang/Object;)V", "kotlin-stdlib"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* renamed from: kotlin.coroutines.jvm.internal.a */
/* compiled from: RunSuspend.kt */
final class C21473a implements Continuation<Unit> {

    /* renamed from: a */
    private Result<Unit> f59872a;

    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    /* renamed from: a */
    public final Result<Unit> mo176696a() {
        return this.f59872a;
    }

    /* renamed from: a */
    public final void mo176697a(Result<Unit> result) {
        this.f59872a = result;
    }

    public void resumeWith(Object obj) {
        synchronized (this) {
            this.f59872a = Result.m47687boximpl(obj);
            notifyAll();
            Unit unit = Unit.INSTANCE;
        }
    }

    /* renamed from: b */
    public final void mo176698b() {
        synchronized (this) {
            while (true) {
                Result<Unit> result = this.f59872a;
                if (result == null) {
                    wait();
                } else {
                    ResultKt.throwOnFailure(result.m47697unboximpl());
                }
            }
        }
    }
}
