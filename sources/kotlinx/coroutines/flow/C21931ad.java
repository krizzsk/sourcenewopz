package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo175978d2 = {"Lkotlinx/coroutines/flow/StartedWhileSubscribed;", "Lkotlinx/coroutines/flow/SharingStarted;", "stopTimeout", "", "replayExpiration", "(JJ)V", "command", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/SharingCommand;", "subscriptionCount", "Lkotlinx/coroutines/flow/StateFlow;", "", "equals", "", "other", "", "hashCode", "toString", "", "kotlinx-coroutines-core"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: kotlinx.coroutines.flow.ad */
/* compiled from: SharingStarted.kt */
final class C21931ad implements SharingStarted {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final long f61459a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final long f61460b;

    public C21931ad(long j, long j2) {
        this.f61459a = j;
        this.f61460b = j2;
        boolean z = true;
        if (j >= 0) {
            if (!(this.f61460b < 0 ? false : z)) {
                throw new IllegalArgumentException(("replayExpiration(" + this.f61460b + " ms) cannot be negative").toString());
            }
            return;
        }
        throw new IllegalArgumentException(("stopTimeout(" + this.f61459a + " ms) cannot be negative").toString());
    }

    public Flow<SharingCommand> command(StateFlow<Integer> stateFlow) {
        return FlowKt.distinctUntilChanged(FlowKt.dropWhile(FlowKt.transformLatest(stateFlow, new StartedWhileSubscribed$command$1(this, (Continuation<? super StartedWhileSubscribed$command$1>) null)), new StartedWhileSubscribed$command$2((Continuation<? super StartedWhileSubscribed$command$2>) null)));
    }

    public String toString() {
        List createListBuilder = CollectionsKt.createListBuilder(2);
        if (this.f61459a > 0) {
            createListBuilder.add("stopTimeout=" + this.f61459a + "ms");
        }
        if (this.f61460b < Long.MAX_VALUE) {
            createListBuilder.add("replayExpiration=" + this.f61460b + "ms");
        }
        List build = CollectionsKt.build(createListBuilder);
        return "SharingStarted.WhileSubscribed(" + CollectionsKt.joinToString$default(build, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null) + VersionRange.RIGHT_OPEN;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C21931ad) {
            C21931ad adVar = (C21931ad) obj;
            return this.f61459a == adVar.f61459a && this.f61460b == adVar.f61460b;
        }
    }

    public int hashCode() {
        return (C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.f61459a) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.f61460b);
    }
}
