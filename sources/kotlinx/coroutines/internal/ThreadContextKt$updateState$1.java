package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.ThreadContextElement;

@Metadata(mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, mo175978d2 = {"<no name provided>", "Lkotlinx/coroutines/internal/ThreadState;", "state", "element", "Lkotlin/coroutines/CoroutineContext$Element;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ThreadContext.kt */
final class ThreadContextKt$updateState$1 extends Lambda implements Function2<C21980e, CoroutineContext.Element, C21980e> {
    public static final ThreadContextKt$updateState$1 INSTANCE = new ThreadContextKt$updateState$1();

    ThreadContextKt$updateState$1() {
        super(2);
    }

    public final C21980e invoke(C21980e eVar, CoroutineContext.Element element) {
        if (element instanceof ThreadContextElement) {
            ThreadContextElement threadContextElement = (ThreadContextElement) element;
            eVar.mo181255a(threadContextElement, threadContextElement.updateThreadContext(eVar.f61558a));
        }
        return eVar;
    }
}
