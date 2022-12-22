package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

@Metadata(mo175977d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u0010052\b\u0012\u0004\u0012\u00028\u0000062\b\u0012\u0004\u0012\u00028\u0000072\b\u0012\u0004\u0012\u00028\u000008B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ-\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000 2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\bH\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0004\b%\u0010&J!\u0010)\u001a\u00020\r2\b\u0010'\u001a\u0004\u0018\u00010\u00022\u0006\u0010(\u001a\u00020\u0002H\u0002¢\u0006\u0004\b)\u0010\u000fR\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000*8VX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0016\u0010.\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010/R*\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00028\u00008V@VX\u000e¢\u0006\u0012\u0012\u0004\b3\u0010$\u001a\u0004\b0\u00101\"\u0004\b2\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u00064"}, mo175978d2 = {"Lkotlinx/coroutines/flow/StateFlowImpl;", "T", "", "initialState", "<init>", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expect", "update", "", "compareAndSet", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/flow/StateFlowSlot;", "createSlot", "()Lkotlinx/coroutines/flow/StateFlowSlot;", "", "size", "", "createSlotArray", "(I)[Lkotlinx/coroutines/flow/StateFlowSlot;", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "context", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/Flow;", "fuse", "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/Flow;", "resetReplayCache", "()V", "tryEmit", "(Ljava/lang/Object;)Z", "expectedState", "newState", "updateState", "", "getReplayCache", "()Ljava/util/List;", "replayCache", "sequence", "I", "getValue", "()Ljava/lang/Object;", "setValue", "getValue$annotations", "kotlinx-coroutines-core", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/internal/FusibleFlow;"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: kotlinx.coroutines.flow.ae */
/* compiled from: StateFlow.kt */
final class C21932ae<T> extends AbstractSharedFlow<C21933af> implements CancellableFlow<T>, MutableStateFlow<T>, FusibleFlow<T> {
    private volatile /* synthetic */ Object _state;

    /* renamed from: a */
    private int f61461a;

    /* renamed from: a */
    public static /* synthetic */ void m45733a() {
    }

    public /* synthetic */ AbstractSharedFlowSlot[] createSlotArray(int i) {
        return (AbstractSharedFlowSlot[]) mo181052a(i);
    }

    public C21932ae(Object obj) {
        this._state = obj;
    }

    public T getValue() {
        T t = NullSurrogateKt.NULL;
        T t2 = this._state;
        if (t2 == t) {
            return null;
        }
        return t2;
    }

    public void setValue(T t) {
        if (t == null) {
            t = NullSurrogateKt.NULL;
        }
        m45734a((Object) null, t);
    }

    public boolean compareAndSet(T t, T t2) {
        if (t == null) {
            t = NullSurrogateKt.NULL;
        }
        if (t2 == null) {
            t2 = NullSurrogateKt.NULL;
        }
        return m45734a(t, t2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002c, code lost:
        r7 = (kotlinx.coroutines.flow.C21933af[]) r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002e, code lost:
        if (r7 != null) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0031, code lost:
        r2 = r7.length;
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0033, code lost:
        if (r3 >= r2) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0035, code lost:
        r4 = r7[r3];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0037, code lost:
        if (r4 != null) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x003a, code lost:
        r4.mo181055a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003d, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0040, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0043, code lost:
        if (r5.f61461a != r6) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0045, code lost:
        r5.f61461a = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0048, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0049, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        r6 = r5.f61461a;
        r7 = getSlots();
        r2 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0052, code lost:
        monitor-exit(r5);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean m45734a(java.lang.Object r6, java.lang.Object r7) {
        /*
            r5 = this;
            r5.getSlots()
            monitor-enter(r5)
            java.lang.Object r0 = r5._state     // Catch:{ all -> 0x005d }
            r1 = 0
            if (r6 == 0) goto L_0x0011
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r6)     // Catch:{ all -> 0x005d }
            if (r6 != 0) goto L_0x0011
            monitor-exit(r5)
            return r1
        L_0x0011:
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r7)     // Catch:{ all -> 0x005d }
            r0 = 1
            if (r6 == 0) goto L_0x001a
            monitor-exit(r5)
            return r0
        L_0x001a:
            r5._state = r7     // Catch:{ all -> 0x005d }
            int r6 = r5.f61461a     // Catch:{ all -> 0x005d }
            r7 = r6 & 1
            if (r7 != 0) goto L_0x0057
            int r6 = r6 + r0
            r5.f61461a = r6     // Catch:{ all -> 0x005d }
            kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot[] r7 = r5.getSlots()     // Catch:{ all -> 0x005d }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x005d }
            monitor-exit(r5)
        L_0x002c:
            kotlinx.coroutines.flow.af[] r7 = (kotlinx.coroutines.flow.C21933af[]) r7
            if (r7 != 0) goto L_0x0031
            goto L_0x0040
        L_0x0031:
            int r2 = r7.length
            r3 = 0
        L_0x0033:
            if (r3 >= r2) goto L_0x0040
            r4 = r7[r3]
            if (r4 != 0) goto L_0x003a
            goto L_0x003d
        L_0x003a:
            r4.mo181055a()
        L_0x003d:
            int r3 = r3 + 1
            goto L_0x0033
        L_0x0040:
            monitor-enter(r5)
            int r7 = r5.f61461a     // Catch:{ all -> 0x0054 }
            if (r7 != r6) goto L_0x004a
            int r6 = r6 + r0
            r5.f61461a = r6     // Catch:{ all -> 0x0054 }
            monitor-exit(r5)
            return r0
        L_0x004a:
            int r6 = r5.f61461a     // Catch:{ all -> 0x0054 }
            kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot[] r7 = r5.getSlots()     // Catch:{ all -> 0x0054 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0054 }
            monitor-exit(r5)
            goto L_0x002c
        L_0x0054:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        L_0x0057:
            int r6 = r6 + 2
            r5.f61461a = r6     // Catch:{ all -> 0x005d }
            monitor-exit(r5)
            return r0
        L_0x005d:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.C21932ae.m45734a(java.lang.Object, java.lang.Object):boolean");
    }

    public List<T> getReplayCache() {
        return CollectionsKt.listOf(getValue());
    }

    public boolean tryEmit(T t) {
        setValue(t);
        return true;
    }

    public Object emit(T t, Continuation<? super Unit> continuation) {
        setValue(t);
        return Unit.INSTANCE;
    }

    public void resetReplayCache() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: kotlinx.coroutines.flow.af} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: kotlinx.coroutines.flow.ae} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ad A[Catch:{ all -> 0x0074 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ae A[Catch:{ all -> 0x0074 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00bd A[Catch:{ all -> 0x0074 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00bf A[Catch:{ all -> 0x0074 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d2 A[Catch:{ all -> 0x0074 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d3 A[Catch:{ all -> 0x0074 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00da A[Catch:{ all -> 0x0074 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object collect(kotlinx.coroutines.flow.FlowCollector<? super T> r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof kotlinx.coroutines.flow.StateFlowImpl$collect$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            kotlinx.coroutines.flow.StateFlowImpl$collect$1 r0 = (kotlinx.coroutines.flow.StateFlowImpl$collect$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            kotlinx.coroutines.flow.StateFlowImpl$collect$1 r0 = new kotlinx.coroutines.flow.StateFlowImpl$collect$1
            r0.<init>(r10, r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L_0x0077
            if (r2 == r6) goto L_0x0062
            if (r2 == r5) goto L_0x004b
            if (r2 != r4) goto L_0x0043
            java.lang.Object r11 = r0.L$4
            java.lang.Object r2 = r0.L$3
            kotlinx.coroutines.Job r2 = (kotlinx.coroutines.Job) r2
            java.lang.Object r6 = r0.L$2
            kotlinx.coroutines.flow.af r6 = (kotlinx.coroutines.flow.C21933af) r6
            java.lang.Object r7 = r0.L$1
            kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
            java.lang.Object r8 = r0.L$0
            kotlinx.coroutines.flow.ae r8 = (kotlinx.coroutines.flow.C21932ae) r8
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x0074 }
            goto L_0x00a9
        L_0x0043:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x004b:
            java.lang.Object r11 = r0.L$4
            java.lang.Object r2 = r0.L$3
            kotlinx.coroutines.Job r2 = (kotlinx.coroutines.Job) r2
            java.lang.Object r6 = r0.L$2
            kotlinx.coroutines.flow.af r6 = (kotlinx.coroutines.flow.C21933af) r6
            java.lang.Object r7 = r0.L$1
            kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
            java.lang.Object r8 = r0.L$0
            kotlinx.coroutines.flow.ae r8 = (kotlinx.coroutines.flow.C21932ae) r8
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x0074 }
            goto L_0x00d4
        L_0x0062:
            java.lang.Object r11 = r0.L$2
            r6 = r11
            kotlinx.coroutines.flow.af r6 = (kotlinx.coroutines.flow.C21933af) r6
            java.lang.Object r11 = r0.L$1
            kotlinx.coroutines.flow.FlowCollector r11 = (kotlinx.coroutines.flow.FlowCollector) r11
            java.lang.Object r2 = r0.L$0
            r8 = r2
            kotlinx.coroutines.flow.ae r8 = (kotlinx.coroutines.flow.C21932ae) r8
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x0074 }
            goto L_0x0098
        L_0x0074:
            r11 = move-exception
            goto L_0x00f0
        L_0x0077:
            kotlin.ResultKt.throwOnFailure(r12)
            kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot r12 = r10.allocateSlot()
            kotlinx.coroutines.flow.af r12 = (kotlinx.coroutines.flow.C21933af) r12
            boolean r2 = r11 instanceof kotlinx.coroutines.flow.SubscribedFlowCollector     // Catch:{ all -> 0x00ed }
            if (r2 == 0) goto L_0x0096
            r2 = r11
            kotlinx.coroutines.flow.SubscribedFlowCollector r2 = (kotlinx.coroutines.flow.SubscribedFlowCollector) r2     // Catch:{ all -> 0x00ed }
            r0.L$0 = r10     // Catch:{ all -> 0x00ed }
            r0.L$1 = r11     // Catch:{ all -> 0x00ed }
            r0.L$2 = r12     // Catch:{ all -> 0x00ed }
            r0.label = r6     // Catch:{ all -> 0x00ed }
            java.lang.Object r2 = r2.onSubscription(r0)     // Catch:{ all -> 0x00ed }
            if (r2 != r1) goto L_0x0096
            return r1
        L_0x0096:
            r8 = r10
            r6 = r12
        L_0x0098:
            kotlin.coroutines.CoroutineContext r12 = r0.getContext()     // Catch:{ all -> 0x0074 }
            kotlinx.coroutines.Job$Key r2 = kotlinx.coroutines.Job.Key     // Catch:{ all -> 0x0074 }
            kotlin.coroutines.CoroutineContext$Key r2 = (kotlin.coroutines.CoroutineContext.Key) r2     // Catch:{ all -> 0x0074 }
            kotlin.coroutines.CoroutineContext$Element r12 = r12.get(r2)     // Catch:{ all -> 0x0074 }
            kotlinx.coroutines.Job r12 = (kotlinx.coroutines.Job) r12     // Catch:{ all -> 0x0074 }
            r7 = r11
            r2 = r12
            r11 = r3
        L_0x00a9:
            java.lang.Object r12 = r8._state     // Catch:{ all -> 0x0074 }
            if (r2 != 0) goto L_0x00ae
            goto L_0x00b1
        L_0x00ae:
            kotlinx.coroutines.JobKt.ensureActive((kotlinx.coroutines.Job) r2)     // Catch:{ all -> 0x0074 }
        L_0x00b1:
            if (r11 == 0) goto L_0x00b9
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r12)     // Catch:{ all -> 0x0074 }
            if (r9 != 0) goto L_0x00d4
        L_0x00b9:
            kotlinx.coroutines.internal.Symbol r11 = kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL     // Catch:{ all -> 0x0074 }
            if (r12 != r11) goto L_0x00bf
            r11 = r3
            goto L_0x00c0
        L_0x00bf:
            r11 = r12
        L_0x00c0:
            r0.L$0 = r8     // Catch:{ all -> 0x0074 }
            r0.L$1 = r7     // Catch:{ all -> 0x0074 }
            r0.L$2 = r6     // Catch:{ all -> 0x0074 }
            r0.L$3 = r2     // Catch:{ all -> 0x0074 }
            r0.L$4 = r12     // Catch:{ all -> 0x0074 }
            r0.label = r5     // Catch:{ all -> 0x0074 }
            java.lang.Object r11 = r7.emit(r11, r0)     // Catch:{ all -> 0x0074 }
            if (r11 != r1) goto L_0x00d3
            return r1
        L_0x00d3:
            r11 = r12
        L_0x00d4:
            boolean r12 = r6.mo181058b()     // Catch:{ all -> 0x0074 }
            if (r12 != 0) goto L_0x00a9
            r0.L$0 = r8     // Catch:{ all -> 0x0074 }
            r0.L$1 = r7     // Catch:{ all -> 0x0074 }
            r0.L$2 = r6     // Catch:{ all -> 0x0074 }
            r0.L$3 = r2     // Catch:{ all -> 0x0074 }
            r0.L$4 = r11     // Catch:{ all -> 0x0074 }
            r0.label = r4     // Catch:{ all -> 0x0074 }
            java.lang.Object r12 = r6.mo181054a((kotlin.coroutines.Continuation<? super kotlin.Unit>) r0)     // Catch:{ all -> 0x0074 }
            if (r12 != r1) goto L_0x00a9
            return r1
        L_0x00ed:
            r11 = move-exception
            r8 = r10
            r6 = r12
        L_0x00f0:
            kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot r6 = (kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot) r6
            r8.freeSlot(r6)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.C21932ae.collect(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C21933af createSlot() {
        return new C21933af();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C21933af[] mo181052a(int i) {
        return new C21933af[i];
    }

    public Flow<T> fuse(CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        return StateFlowKt.fuseStateFlow(this, coroutineContext, i, bufferOverflow);
    }
}
