package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.flow.internal.FusibleFlow;

@Metadata(mo175977d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0012\u0004\u0012\u0002H\u00010\u00052\b\u0012\u0004\u0012\u0002H\u00010\u0006:\u0001bB\u001d\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0019\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010)J\u0010\u0010*\u001a\u00020'2\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020'H\u0002J\u001f\u0010.\u001a\u00020'2\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u000000H@ø\u0001\u0000¢\u0006\u0002\u00101J\u0010\u00102\u001a\u00020'2\u0006\u00103\u001a\u00020\u0012H\u0002J\b\u00104\u001a\u00020\u0003H\u0014J\u001d\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000e2\u0006\u00106\u001a\u00020\bH\u0014¢\u0006\u0002\u00107J\b\u00108\u001a\u00020'H\u0002J\u0019\u00109\u001a\u00020'2\u0006\u0010:\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010;J\u0019\u0010<\u001a\u00020'2\u0006\u0010:\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010;J\u0012\u0010=\u001a\u00020'2\b\u0010>\u001a\u0004\u0018\u00010\u000fH\u0002J1\u0010?\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020'\u0018\u00010@0\u000e2\u0014\u0010A\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020'\u0018\u00010@0\u000eH\u0002¢\u0006\u0002\u0010BJ&\u0010C\u001a\b\u0012\u0004\u0012\u00028\u00000D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010H\u001a\u0004\u0018\u00010\u000f2\u0006\u0010I\u001a\u00020\u0012H\u0002J7\u0010J\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e2\u0010\u0010K\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e2\u0006\u0010L\u001a\u00020\b2\u0006\u0010M\u001a\u00020\bH\u0002¢\u0006\u0002\u0010NJ\b\u0010O\u001a\u00020'H\u0016J\u0015\u0010P\u001a\u00020Q2\u0006\u0010:\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010RJ\u0015\u0010S\u001a\u00020Q2\u0006\u0010:\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010RJ\u0015\u0010T\u001a\u00020Q2\u0006\u0010:\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010RJ\u0010\u0010U\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u0003H\u0002J\u0012\u0010V\u001a\u0004\u0018\u00010\u000f2\u0006\u0010(\u001a\u00020\u0003H\u0002J(\u0010W\u001a\u00020'2\u0006\u0010X\u001a\u00020\u00122\u0006\u0010Y\u001a\u00020\u00122\u0006\u0010Z\u001a\u00020\u00122\u0006\u0010[\u001a\u00020\u0012H\u0002J%\u0010\\\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020'\u0018\u00010@0\u000e2\u0006\u0010]\u001a\u00020\u0012H\u0000¢\u0006\u0004\b^\u0010_J\r\u0010`\u001a\u00020\u0012H\u0000¢\u0006\u0002\baR\u001a\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000eX\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0014R\u000e\u0010\u0018\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0014R\u000e\u0010\u001b\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010#\u0002\u0004\n\u0002\b\u0019¨\u0006c"}, mo175978d2 = {"Lkotlinx/coroutines/flow/SharedFlowImpl;", "T", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/SharedFlowSlot;", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "replay", "", "bufferCapacity", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(IILkotlinx/coroutines/channels/BufferOverflow;)V", "buffer", "", "", "[Ljava/lang/Object;", "bufferEndIndex", "", "getBufferEndIndex", "()J", "bufferSize", "head", "getHead", "minCollectorIndex", "queueEndIndex", "getQueueEndIndex", "queueSize", "replayCache", "", "getReplayCache", "()Ljava/util/List;", "replayIndex", "replaySize", "getReplaySize", "()I", "totalSize", "getTotalSize", "awaitValue", "", "slot", "(Lkotlinx/coroutines/flow/SharedFlowSlot;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelEmitter", "emitter", "Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;", "cleanupTailLocked", "collect", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "correctCollectorIndexesOnDropOldest", "newHead", "createSlot", "createSlotArray", "size", "(I)[Lkotlinx/coroutines/flow/SharedFlowSlot;", "dropOldestLocked", "emit", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitSuspend", "enqueueLocked", "item", "findSlotsToResumeLocked", "Lkotlin/coroutines/Continuation;", "resumesIn", "([Lkotlin/coroutines/Continuation;)[Lkotlin/coroutines/Continuation;", "fuse", "Lkotlinx/coroutines/flow/Flow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "getPeekedValueLockedAt", "index", "growBuffer", "curBuffer", "curSize", "newSize", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "resetReplayCache", "tryEmit", "", "(Ljava/lang/Object;)Z", "tryEmitLocked", "tryEmitNoCollectorsLocked", "tryPeekLocked", "tryTakeValue", "updateBufferLocked", "newReplayIndex", "newMinCollectorIndex", "newBufferEndIndex", "newQueueEndIndex", "updateCollectorIndexLocked", "oldIndex", "updateCollectorIndexLocked$kotlinx_coroutines_core", "(J)[Lkotlin/coroutines/Continuation;", "updateNewCollectorIndexLocked", "updateNewCollectorIndexLocked$kotlinx_coroutines_core", "Emitter", "kotlinx-coroutines-core"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SharedFlow.kt */
final class SharedFlowImpl<T> extends AbstractSharedFlow<C21971z> implements CancellableFlow<T>, MutableSharedFlow<T>, FusibleFlow<T> {

    /* renamed from: a */
    private final int f61441a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final int f61442b;

    /* renamed from: c */
    private final BufferOverflow f61443c;

    /* renamed from: d */
    private Object[] f61444d;

    /* renamed from: e */
    private long f61445e;

    /* renamed from: f */
    private long f61446f;

    /* renamed from: g */
    private int f61447g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f61448h;

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: SharedFlow.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BufferOverflow.values().length];
            iArr[BufferOverflow.SUSPEND.ordinal()] = 1;
            iArr[BufferOverflow.DROP_LATEST.ordinal()] = 2;
            iArr[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ AbstractSharedFlowSlot[] createSlotArray(int i) {
        return (AbstractSharedFlowSlot[]) mo181032a(i);
    }

    public SharedFlowImpl(int i, int i2, BufferOverflow bufferOverflow) {
        this.f61441a = i;
        this.f61442b = i2;
        this.f61443c = bufferOverflow;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final long m45712c() {
        return Math.min(this.f61446f, this.f61445e);
    }

    /* renamed from: d */
    private final int m45716d() {
        return (int) ((m45712c() + ((long) this.f61447g)) - this.f61445e);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public final int m45718e() {
        return this.f61447g + this.f61448h;
    }

    /* renamed from: f */
    private final long m45719f() {
        return m45712c() + ((long) this.f61447g);
    }

    /* renamed from: g */
    private final long m45720g() {
        return m45712c() + ((long) this.f61447g) + ((long) this.f61448h);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: kotlinx.coroutines.flow.z} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: kotlinx.coroutines.flow.SharedFlowImpl} */
    /* JADX WARNING: type inference failed for: r10v9, types: [kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot] */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c2 A[Catch:{ all -> 0x0070 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00d2 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ab A[EDGE_INSN: B:51:0x00ab->B:37:0x00ab ?: BREAK  , SYNTHETIC] */
    public java.lang.Object collect(kotlinx.coroutines.flow.FlowCollector<? super T> r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof kotlinx.coroutines.flow.SharedFlowImpl$collect$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            kotlinx.coroutines.flow.SharedFlowImpl$collect$1 r0 = (kotlinx.coroutines.flow.SharedFlowImpl$collect$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            kotlinx.coroutines.flow.SharedFlowImpl$collect$1 r0 = new kotlinx.coroutines.flow.SharedFlowImpl$collect$1
            r0.<init>(r8, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0072
            if (r2 == r5) goto L_0x005e
            if (r2 == r4) goto L_0x004a
            if (r2 != r3) goto L_0x0042
            java.lang.Object r9 = r0.L$3
            kotlinx.coroutines.Job r9 = (kotlinx.coroutines.Job) r9
            java.lang.Object r2 = r0.L$2
            kotlinx.coroutines.flow.z r2 = (kotlinx.coroutines.flow.C21971z) r2
            java.lang.Object r5 = r0.L$1
            kotlinx.coroutines.flow.FlowCollector r5 = (kotlinx.coroutines.flow.FlowCollector) r5
            java.lang.Object r6 = r0.L$0
            kotlinx.coroutines.flow.SharedFlowImpl r6 = (kotlinx.coroutines.flow.SharedFlowImpl) r6
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x0070 }
        L_0x003f:
            r10 = r9
            r9 = r5
            goto L_0x00a1
        L_0x0042:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x004a:
            java.lang.Object r9 = r0.L$3
            kotlinx.coroutines.Job r9 = (kotlinx.coroutines.Job) r9
            java.lang.Object r2 = r0.L$2
            kotlinx.coroutines.flow.z r2 = (kotlinx.coroutines.flow.C21971z) r2
            java.lang.Object r5 = r0.L$1
            kotlinx.coroutines.flow.FlowCollector r5 = (kotlinx.coroutines.flow.FlowCollector) r5
            java.lang.Object r6 = r0.L$0
            kotlinx.coroutines.flow.SharedFlowImpl r6 = (kotlinx.coroutines.flow.SharedFlowImpl) r6
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x0070 }
            goto L_0x00a3
        L_0x005e:
            java.lang.Object r9 = r0.L$2
            r2 = r9
            kotlinx.coroutines.flow.z r2 = (kotlinx.coroutines.flow.C21971z) r2
            java.lang.Object r9 = r0.L$1
            kotlinx.coroutines.flow.FlowCollector r9 = (kotlinx.coroutines.flow.FlowCollector) r9
            java.lang.Object r5 = r0.L$0
            r6 = r5
            kotlinx.coroutines.flow.SharedFlowImpl r6 = (kotlinx.coroutines.flow.SharedFlowImpl) r6
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x0070 }
            goto L_0x0093
        L_0x0070:
            r9 = move-exception
            goto L_0x00d5
        L_0x0072:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot r10 = r8.allocateSlot()
            r2 = r10
            kotlinx.coroutines.flow.z r2 = (kotlinx.coroutines.flow.C21971z) r2
            boolean r10 = r9 instanceof kotlinx.coroutines.flow.SubscribedFlowCollector     // Catch:{ all -> 0x00d3 }
            if (r10 == 0) goto L_0x0092
            r10 = r9
            kotlinx.coroutines.flow.SubscribedFlowCollector r10 = (kotlinx.coroutines.flow.SubscribedFlowCollector) r10     // Catch:{ all -> 0x00d3 }
            r0.L$0 = r8     // Catch:{ all -> 0x00d3 }
            r0.L$1 = r9     // Catch:{ all -> 0x00d3 }
            r0.L$2 = r2     // Catch:{ all -> 0x00d3 }
            r0.label = r5     // Catch:{ all -> 0x00d3 }
            java.lang.Object r10 = r10.onSubscription(r0)     // Catch:{ all -> 0x00d3 }
            if (r10 != r1) goto L_0x0092
            return r1
        L_0x0092:
            r6 = r8
        L_0x0093:
            kotlin.coroutines.CoroutineContext r10 = r0.getContext()     // Catch:{ all -> 0x0070 }
            kotlinx.coroutines.Job$Key r5 = kotlinx.coroutines.Job.Key     // Catch:{ all -> 0x0070 }
            kotlin.coroutines.CoroutineContext$Key r5 = (kotlin.coroutines.CoroutineContext.Key) r5     // Catch:{ all -> 0x0070 }
            kotlin.coroutines.CoroutineContext$Element r10 = r10.get(r5)     // Catch:{ all -> 0x0070 }
            kotlinx.coroutines.Job r10 = (kotlinx.coroutines.Job) r10     // Catch:{ all -> 0x0070 }
        L_0x00a1:
            r5 = r9
            r9 = r10
        L_0x00a3:
            java.lang.Object r10 = r6.m45696a((kotlinx.coroutines.flow.C21971z) r2)     // Catch:{ all -> 0x0070 }
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.flow.SharedFlowKt.NO_VALUE     // Catch:{ all -> 0x0070 }
            if (r10 == r7) goto L_0x00c2
            if (r9 != 0) goto L_0x00ae
            goto L_0x00b1
        L_0x00ae:
            kotlinx.coroutines.JobKt.ensureActive((kotlinx.coroutines.Job) r9)     // Catch:{ all -> 0x0070 }
        L_0x00b1:
            r0.L$0 = r6     // Catch:{ all -> 0x0070 }
            r0.L$1 = r5     // Catch:{ all -> 0x0070 }
            r0.L$2 = r2     // Catch:{ all -> 0x0070 }
            r0.L$3 = r9     // Catch:{ all -> 0x0070 }
            r0.label = r3     // Catch:{ all -> 0x0070 }
            java.lang.Object r10 = r5.emit(r10, r0)     // Catch:{ all -> 0x0070 }
            if (r10 != r1) goto L_0x003f
            return r1
        L_0x00c2:
            r0.L$0 = r6     // Catch:{ all -> 0x0070 }
            r0.L$1 = r5     // Catch:{ all -> 0x0070 }
            r0.L$2 = r2     // Catch:{ all -> 0x0070 }
            r0.L$3 = r9     // Catch:{ all -> 0x0070 }
            r0.label = r4     // Catch:{ all -> 0x0070 }
            java.lang.Object r10 = r6.m45697a((kotlinx.coroutines.flow.C21971z) r2, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r0)     // Catch:{ all -> 0x0070 }
            if (r10 != r1) goto L_0x00a3
            return r1
        L_0x00d3:
            r9 = move-exception
            r6 = r8
        L_0x00d5:
            kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot r2 = (kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot) r2
            r6.freeSlot(r2)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.collect(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public boolean tryEmit(T t) {
        int i;
        boolean z;
        Continuation<Unit>[] continuationArr = AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            i = 0;
            if (m45703a(t)) {
                continuationArr = m45706a(continuationArr);
                z = true;
            } else {
                z = false;
            }
        }
        int length = continuationArr.length;
        while (i < length) {
            Continuation<Unit> continuation = continuationArr[i];
            i++;
            if (continuation != null) {
                Unit unit = Unit.INSTANCE;
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.m47688constructorimpl(unit));
            }
        }
        return z;
    }

    public Object emit(T t, Continuation<? super Unit> continuation) {
        if (tryEmit(t)) {
            return Unit.INSTANCE;
        }
        Object a = m45693a(t, continuation);
        return a == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final boolean m45703a(T t) {
        if (getNCollectors() == 0) {
            return m45710b(t);
        }
        if (this.f61447g >= this.f61442b && this.f61446f <= this.f61445e) {
            int i = WhenMappings.$EnumSwitchMapping$0[this.f61443c.ordinal()];
            if (i == 1) {
                return false;
            }
            if (i == 2) {
                return true;
            }
        }
        m45715c((Object) t);
        int i2 = this.f61447g + 1;
        this.f61447g = i2;
        if (i2 > this.f61442b) {
            m45721h();
        }
        if (m45716d() > this.f61441a) {
            m45698a(this.f61445e + 1, this.f61446f, m45719f(), m45720g());
        }
        return true;
    }

    /* renamed from: b */
    private final boolean m45710b(T t) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(getNCollectors() == 0)) {
                throw new AssertionError();
            }
        }
        if (this.f61441a == 0) {
            return true;
        }
        m45715c((Object) t);
        int i = this.f61447g + 1;
        this.f61447g = i;
        if (i > this.f61441a) {
            m45721h();
        }
        this.f61446f = m45712c() + ((long) this.f61447g);
        return true;
    }

    /* renamed from: h */
    private final void m45721h() {
        Object[] objArr = this.f61444d;
        Intrinsics.checkNotNull(objArr);
        SharedFlowKt.m45728a(objArr, m45712c(), (Object) null);
        this.f61447g--;
        long c = m45712c() + 1;
        if (this.f61445e < c) {
            this.f61445e = c;
        }
        if (this.f61446f < c) {
            m45709b(c);
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(m45712c() == c)) {
                throw new AssertionError();
            }
        }
    }

    /* renamed from: b */
    private final void m45709b(long j) {
        AbstractSharedFlowSlot[] access$getSlots;
        AbstractSharedFlow abstractSharedFlow = this;
        if (!(abstractSharedFlow.f61475b == 0 || (access$getSlots = abstractSharedFlow.f61474a) == null)) {
            for (AbstractSharedFlowSlot abstractSharedFlowSlot : access$getSlots) {
                if (abstractSharedFlowSlot != null) {
                    C21971z zVar = (C21971z) abstractSharedFlowSlot;
                    if (zVar.f61502a >= 0 && zVar.f61502a < j) {
                        zVar.f61502a = j;
                    }
                }
            }
        }
        this.f61446f = j;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final void m45715c(Object obj) {
        int e = m45718e();
        Object[] objArr = this.f61444d;
        if (objArr == null) {
            objArr = m45704a((Object[]) null, 0, 2);
        } else if (e >= objArr.length) {
            objArr = m45704a(objArr, e, objArr.length * 2);
        }
        SharedFlowKt.m45728a(objArr, m45712c() + ((long) e), obj);
    }

    /* renamed from: a */
    private final Object[] m45704a(Object[] objArr, int i, int i2) {
        int i3 = 0;
        if (i2 > 0) {
            Object[] objArr2 = new Object[i2];
            this.f61444d = objArr2;
            if (objArr == null) {
                return objArr2;
            }
            long c = m45712c();
            if (i > 0) {
                while (true) {
                    int i4 = i3 + 1;
                    long j = ((long) i3) + c;
                    SharedFlowKt.m45728a(objArr2, j, SharedFlowKt.m45727a(objArr, j));
                    if (i4 >= i) {
                        break;
                    }
                    i3 = i4;
                }
            }
            return objArr2;
        }
        throw new IllegalStateException("Buffer size overflow".toString());
    }

    /* renamed from: a */
    public final long mo181030a() {
        long j = this.f61445e;
        if (j < this.f61446f) {
            this.f61446f = j;
        }
        return j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:70:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.coroutines.Continuation<kotlin.Unit>[] mo181031a(long r24) {
        /*
            r23 = this;
            r9 = r23
            boolean r0 = kotlinx.coroutines.DebugKt.getASSERTIONS_ENABLED()
            if (r0 == 0) goto L_0x001a
            long r0 = r9.f61446f
            int r2 = (r24 > r0 ? 1 : (r24 == r0 ? 0 : -1))
            if (r2 < 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            if (r0 == 0) goto L_0x0014
            goto L_0x001a
        L_0x0014:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>()
            throw r0
        L_0x001a:
            long r0 = r9.f61446f
            int r2 = (r24 > r0 ? 1 : (r24 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0023
            kotlin.coroutines.Continuation<kotlin.Unit>[] r0 = kotlinx.coroutines.flow.internal.AbstractSharedFlowKt.EMPTY_RESUMES
            return r0
        L_0x0023:
            long r0 = r23.m45712c()
            int r2 = r9.f61447g
            long r2 = (long) r2
            long r2 = r2 + r0
            int r4 = r9.f61442b
            r5 = 1
            if (r4 != 0) goto L_0x0036
            int r4 = r9.f61448h
            if (r4 <= 0) goto L_0x0036
            long r2 = r2 + r5
        L_0x0036:
            r4 = r9
            kotlinx.coroutines.flow.internal.AbstractSharedFlow r4 = (kotlinx.coroutines.flow.internal.AbstractSharedFlow) r4
            int r7 = r4.f61475b
            if (r7 != 0) goto L_0x0040
            goto L_0x0064
        L_0x0040:
            kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot[] r4 = r4.f61474a
            if (r4 != 0) goto L_0x0047
            goto L_0x0064
        L_0x0047:
            int r7 = r4.length
            r8 = 0
        L_0x0049:
            if (r8 >= r7) goto L_0x0064
            r12 = r4[r8]
            if (r12 == 0) goto L_0x0061
            kotlinx.coroutines.flow.z r12 = (kotlinx.coroutines.flow.C21971z) r12
            long r13 = r12.f61502a
            r15 = 0
            int r17 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r17 < 0) goto L_0x0061
            long r13 = r12.f61502a
            int r15 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r15 >= 0) goto L_0x0061
            long r2 = r12.f61502a
        L_0x0061:
            int r8 = r8 + 1
            goto L_0x0049
        L_0x0064:
            boolean r4 = kotlinx.coroutines.DebugKt.getASSERTIONS_ENABLED()
            if (r4 == 0) goto L_0x007c
            long r7 = r9.f61446f
            int r4 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r4 < 0) goto L_0x0072
            r4 = 1
            goto L_0x0073
        L_0x0072:
            r4 = 0
        L_0x0073:
            if (r4 == 0) goto L_0x0076
            goto L_0x007c
        L_0x0076:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>()
            throw r0
        L_0x007c:
            long r7 = r9.f61446f
            int r4 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r4 > 0) goto L_0x0085
            kotlin.coroutines.Continuation<kotlin.Unit>[] r0 = kotlinx.coroutines.flow.internal.AbstractSharedFlowKt.EMPTY_RESUMES
            return r0
        L_0x0085:
            long r7 = r23.m45719f()
            int r4 = r23.getNCollectors()
            if (r4 <= 0) goto L_0x009c
            long r12 = r7 - r2
            int r4 = (int) r12
            int r12 = r9.f61448h
            int r13 = r9.f61442b
            int r13 = r13 - r4
            int r4 = java.lang.Math.min(r12, r13)
            goto L_0x009e
        L_0x009c:
            int r4 = r9.f61448h
        L_0x009e:
            kotlin.coroutines.Continuation<kotlin.Unit>[] r12 = kotlinx.coroutines.flow.internal.AbstractSharedFlowKt.EMPTY_RESUMES
            int r13 = r9.f61448h
            long r13 = (long) r13
            long r13 = r13 + r7
            if (r4 <= 0) goto L_0x00f6
            kotlin.coroutines.Continuation[] r12 = new kotlin.coroutines.Continuation[r4]
            java.lang.Object[] r15 = r9.f61444d
            kotlin.jvm.internal.Intrinsics.checkNotNull(r15)
            int r16 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
            if (r16 >= 0) goto L_0x00f6
            r10 = r7
            r18 = 0
        L_0x00b4:
            long r19 = r7 + r5
            java.lang.Object r5 = kotlinx.coroutines.flow.SharedFlowKt.m45727a(r15, r7)
            kotlinx.coroutines.internal.Symbol r6 = kotlinx.coroutines.flow.SharedFlowKt.NO_VALUE
            if (r5 == r6) goto L_0x00e7
            if (r5 == 0) goto L_0x00df
            kotlinx.coroutines.flow.SharedFlowImpl$Emitter r5 = (kotlinx.coroutines.flow.SharedFlowImpl.Emitter) r5
            int r6 = r18 + 1
            r21 = r2
            kotlin.coroutines.Continuation<kotlin.Unit> r2 = r5.cont
            r12[r18] = r2
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.flow.SharedFlowKt.NO_VALUE
            kotlinx.coroutines.flow.SharedFlowKt.m45728a(r15, r7, r2)
            java.lang.Object r2 = r5.value
            kotlinx.coroutines.flow.SharedFlowKt.m45728a(r15, r10, r2)
            r2 = 1
            long r7 = r10 + r2
            if (r6 < r4) goto L_0x00db
            goto L_0x00f8
        L_0x00db:
            r18 = r6
            r10 = r7
            goto L_0x00e9
        L_0x00df:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter"
            r0.<init>(r1)
            throw r0
        L_0x00e7:
            r21 = r2
        L_0x00e9:
            int r2 = (r19 > r13 ? 1 : (r19 == r13 ? 0 : -1))
            if (r2 < 0) goto L_0x00ef
            r7 = r10
            goto L_0x00f8
        L_0x00ef:
            r7 = r19
            r2 = r21
            r5 = 1
            goto L_0x00b4
        L_0x00f6:
            r21 = r2
        L_0x00f8:
            long r0 = r7 - r0
            int r1 = (int) r0
            int r0 = r23.getNCollectors()
            if (r0 != 0) goto L_0x0103
            r3 = r7
            goto L_0x0105
        L_0x0103:
            r3 = r21
        L_0x0105:
            long r5 = r9.f61445e
            int r0 = r9.f61441a
            int r0 = java.lang.Math.min(r0, r1)
            long r0 = (long) r0
            long r0 = r7 - r0
            long r0 = java.lang.Math.max(r5, r0)
            int r2 = r9.f61442b
            if (r2 != 0) goto L_0x0131
            int r2 = (r0 > r13 ? 1 : (r0 == r13 ? 0 : -1))
            if (r2 >= 0) goto L_0x0131
            java.lang.Object[] r2 = r9.f61444d
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            java.lang.Object r2 = kotlinx.coroutines.flow.SharedFlowKt.m45727a(r2, r0)
            kotlinx.coroutines.internal.Symbol r5 = kotlinx.coroutines.flow.SharedFlowKt.NO_VALUE
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r5)
            if (r2 == 0) goto L_0x0131
            r5 = 1
            long r7 = r7 + r5
            long r0 = r0 + r5
        L_0x0131:
            r1 = r0
            r5 = r7
            r0 = r23
            r7 = r13
            r0.m45698a(r1, r3, r5, r7)
            r23.m45722i()
            int r0 = r12.length
            if (r0 != 0) goto L_0x0141
            r10 = 1
            goto L_0x0142
        L_0x0141:
            r10 = 0
        L_0x0142:
            r0 = 1
            r0 = r0 ^ r10
            if (r0 == 0) goto L_0x014a
            kotlin.coroutines.Continuation[] r12 = r9.m45706a((kotlin.coroutines.Continuation<kotlin.Unit>[]) r12)
        L_0x014a:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.mo181031a(long):kotlin.coroutines.Continuation[]");
    }

    /* renamed from: a */
    private final void m45698a(long j, long j2, long j3, long j4) {
        long j5 = j;
        long j6 = j2;
        long min = Math.min(j6, j5);
        boolean z = true;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(min >= m45712c())) {
                throw new AssertionError();
            }
        }
        long c = m45712c();
        if (c < min) {
            while (true) {
                long j7 = 1 + c;
                Object[] objArr = this.f61444d;
                Intrinsics.checkNotNull(objArr);
                SharedFlowKt.m45728a(objArr, c, (Object) null);
                if (j7 >= min) {
                    break;
                }
                c = j7;
            }
        }
        this.f61445e = j5;
        this.f61446f = j6;
        this.f61447g = (int) (j3 - min);
        this.f61448h = (int) (j4 - j3);
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(this.f61447g >= 0)) {
                throw new AssertionError();
            }
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(this.f61448h >= 0)) {
                throw new AssertionError();
            }
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (this.f61445e > m45712c() + ((long) this.f61447g)) {
                z = false;
            }
            if (!z) {
                throw new AssertionError();
            }
        }
    }

    /* renamed from: i */
    private final void m45722i() {
        if (this.f61442b != 0 || this.f61448h > 1) {
            Object[] objArr = this.f61444d;
            Intrinsics.checkNotNull(objArr);
            while (this.f61448h > 0 && SharedFlowKt.m45727a(objArr, (m45712c() + ((long) m45718e())) - 1) == SharedFlowKt.NO_VALUE) {
                this.f61448h--;
                SharedFlowKt.m45728a(objArr, m45712c() + ((long) m45718e()), (Object) null);
            }
        }
    }

    /* renamed from: a */
    private final Object m45696a(C21971z zVar) {
        Object obj;
        Continuation<Unit>[] continuationArr = AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            long b = m45708b(zVar);
            if (b < 0) {
                obj = SharedFlowKt.NO_VALUE;
            } else {
                long j = zVar.f61502a;
                Object c = m45714c(b);
                zVar.f61502a = b + 1;
                Object obj2 = c;
                continuationArr = mo181031a(j);
                obj = obj2;
            }
        }
        int i = 0;
        int length = continuationArr.length;
        while (i < length) {
            Continuation<Unit> continuation = continuationArr[i];
            i++;
            if (continuation != null) {
                Unit unit = Unit.INSTANCE;
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.m47688constructorimpl(unit));
            }
        }
        return obj;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final long m45708b(C21971z zVar) {
        long j = zVar.f61502a;
        if (j < m45719f()) {
            return j;
        }
        if (this.f61442b <= 0 && j <= m45712c() && this.f61448h != 0) {
            return j;
        }
        return -1;
    }

    /* renamed from: c */
    private final Object m45714c(long j) {
        Object[] objArr = this.f61444d;
        Intrinsics.checkNotNull(objArr);
        Object access$getBufferAt = SharedFlowKt.m45727a(objArr, j);
        return access$getBufferAt instanceof Emitter ? ((Emitter) access$getBufferAt).value : access$getBufferAt;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v5, resolved type: kotlin.coroutines.Continuation<kotlin.Unit>[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: kotlin.coroutines.Continuation<kotlin.Unit>[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v10, resolved type: kotlin.coroutines.Continuation<kotlin.Unit>[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v11, resolved type: kotlin.coroutines.Continuation<kotlin.Unit>[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v12, resolved type: kotlin.coroutines.Continuation<kotlin.Unit>[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v13, resolved type: kotlin.coroutines.Continuation<kotlin.Unit>[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v14, resolved type: kotlin.coroutines.Continuation<kotlin.Unit>[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v15, resolved type: kotlin.coroutines.Continuation<kotlin.Unit>[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v16, resolved type: kotlin.coroutines.Continuation<kotlin.Unit>[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v17, resolved type: kotlin.coroutines.Continuation<kotlin.Unit>[]} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004e, code lost:
        r12 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004e, code lost:
        r12 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        r4 = (kotlinx.coroutines.flow.C21971z) r4;
     */
    /* JADX WARNING: Incorrect type for immutable var: ssa=kotlin.coroutines.Continuation<kotlin.Unit>[], code=kotlin.coroutines.Continuation[], for r12v0, types: [kotlin.coroutines.Continuation<kotlin.Unit>[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.coroutines.Continuation<kotlin.Unit>[] m45706a(kotlin.coroutines.Continuation[] r12) {
        /*
            r11 = this;
            int r0 = r12.length
            r1 = r11
            kotlinx.coroutines.flow.internal.AbstractSharedFlow r1 = (kotlinx.coroutines.flow.internal.AbstractSharedFlow) r1
            int r2 = r1.f61475b
            if (r2 != 0) goto L_0x000b
            goto L_0x0051
        L_0x000b:
            kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot[] r1 = r1.f61474a
            if (r1 != 0) goto L_0x0012
            goto L_0x0051
        L_0x0012:
            int r2 = r1.length
            r3 = 0
        L_0x0014:
            if (r3 >= r2) goto L_0x0051
            r4 = r1[r3]
            if (r4 == 0) goto L_0x004e
            kotlinx.coroutines.flow.z r4 = (kotlinx.coroutines.flow.C21971z) r4
            kotlin.coroutines.Continuation<? super kotlin.Unit> r5 = r4.f61503b
            if (r5 != 0) goto L_0x0021
            goto L_0x004e
        L_0x0021:
            long r6 = r11.m45708b((kotlinx.coroutines.flow.C21971z) r4)
            r8 = 0
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 >= 0) goto L_0x002c
            goto L_0x004e
        L_0x002c:
            r6 = r12
            java.lang.Object[] r6 = (java.lang.Object[]) r6
            int r7 = r6.length
            if (r0 < r7) goto L_0x0043
            int r12 = r6.length
            r7 = 2
            int r12 = r12 * 2
            int r12 = java.lang.Math.max(r7, r12)
            java.lang.Object[] r12 = java.util.Arrays.copyOf(r6, r12)
            java.lang.String r6 = "java.util.Arrays.copyOf(this, newSize)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r6)
        L_0x0043:
            r6 = r12
            kotlin.coroutines.Continuation[] r6 = (kotlin.coroutines.Continuation[]) r6
            int r7 = r0 + 1
            r6[r0] = r5
            r0 = 0
            r4.f61503b = r0
            r0 = r7
        L_0x004e:
            int r3 = r3 + 1
            goto L_0x0014
        L_0x0051:
            kotlin.coroutines.Continuation[] r12 = (kotlin.coroutines.Continuation[]) r12
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.m45706a(kotlin.coroutines.Continuation[]):kotlin.coroutines.Continuation[]");
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C21971z createSlot() {
        return new C21971z();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C21971z[] mo181032a(int i) {
        return new C21971z[i];
    }

    public Flow<T> fuse(CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        return SharedFlowKt.fuseSharedFlow(this, coroutineContext, i, bufferOverflow);
    }

    @Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B1\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\nH\u0016R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, mo175978d2 = {"Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;", "Lkotlinx/coroutines/DisposableHandle;", "flow", "Lkotlinx/coroutines/flow/SharedFlowImpl;", "index", "", "value", "", "cont", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/flow/SharedFlowImpl;JLjava/lang/Object;Lkotlin/coroutines/Continuation;)V", "dispose", "kotlinx-coroutines-core"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: SharedFlow.kt */
    private static final class Emitter implements DisposableHandle {
        public final Continuation<Unit> cont;
        public final SharedFlowImpl<?> flow;
        public long index;
        public final Object value;

        public Emitter(SharedFlowImpl<?> sharedFlowImpl, long j, Object obj, Continuation<? super Unit> continuation) {
            this.flow = sharedFlowImpl;
            this.index = j;
            this.value = obj;
            this.cont = continuation;
        }

        public void dispose() {
            this.flow.m45699a(this);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0032, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<T> getReplayCache() {
        /*
            r10 = this;
            monitor-enter(r10)
            int r0 = r10.m45716d()     // Catch:{ all -> 0x0033 }
            if (r0 != 0) goto L_0x000d
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()     // Catch:{ all -> 0x0033 }
            monitor-exit(r10)
            return r0
        L_0x000d:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0033 }
            r1.<init>(r0)     // Catch:{ all -> 0x0033 }
            java.lang.Object[] r2 = r10.f61444d     // Catch:{ all -> 0x0033 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)     // Catch:{ all -> 0x0033 }
            r3 = 0
            if (r0 <= 0) goto L_0x002f
        L_0x001a:
            int r4 = r3 + 1
            r5 = r1
            java.util.Collection r5 = (java.util.Collection) r5     // Catch:{ all -> 0x0033 }
            long r6 = r10.f61445e     // Catch:{ all -> 0x0033 }
            long r8 = (long) r3     // Catch:{ all -> 0x0033 }
            long r6 = r6 + r8
            java.lang.Object r3 = kotlinx.coroutines.flow.SharedFlowKt.m45727a(r2, r6)     // Catch:{ all -> 0x0033 }
            r5.add(r3)     // Catch:{ all -> 0x0033 }
            if (r4 < r0) goto L_0x002d
            goto L_0x002f
        L_0x002d:
            r3 = r4
            goto L_0x001a
        L_0x002f:
            monitor-exit(r10)
            java.util.List r1 = (java.util.List) r1
            return r1
        L_0x0033:
            r0 = move-exception
            monitor-exit(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.getReplayCache():java.util.List");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final Object m45693a(T t, Continuation<? super Unit> continuation) {
        Continuation<Unit>[] continuationArr;
        Emitter emitter;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        Continuation<Unit>[] continuationArr2 = AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            if (m45703a(t)) {
                Unit unit = Unit.INSTANCE;
                Result.Companion companion = Result.Companion;
                cancellableContinuation.resumeWith(Result.m47688constructorimpl(unit));
                continuationArr = m45706a(continuationArr2);
                emitter = null;
            } else {
                Emitter emitter2 = new Emitter(this, ((long) m45718e()) + m45712c(), t, cancellableContinuation);
                m45715c((Object) emitter2);
                this.f61448h = this.f61448h + 1;
                if (this.f61442b == 0) {
                    continuationArr2 = m45706a(continuationArr2);
                }
                continuationArr = continuationArr2;
                emitter = emitter2;
            }
        }
        if (emitter != null) {
            CancellableContinuationKt.disposeOnCancellation(cancellableContinuation, emitter);
        }
        int i = 0;
        int length = continuationArr.length;
        while (i < length) {
            Continuation<Unit> continuation2 = continuationArr[i];
            i++;
            if (continuation2 != null) {
                Unit unit2 = Unit.INSTANCE;
                Result.Companion companion2 = Result.Companion;
                continuation2.resumeWith(Result.m47688constructorimpl(unit2));
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m45699a(Emitter emitter) {
        synchronized (this) {
            if (emitter.index >= m45712c()) {
                Object[] objArr = this.f61444d;
                Intrinsics.checkNotNull(objArr);
                if (SharedFlowKt.m45727a(objArr, emitter.index) == emitter) {
                    SharedFlowKt.m45728a(objArr, emitter.index, SharedFlowKt.NO_VALUE);
                    m45722i();
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final Object m45697a(C21971z zVar, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        synchronized (this) {
            if (m45708b(zVar) < 0) {
                zVar.f61503b = cancellableContinuation;
                zVar.f61503b = cancellableContinuation;
            } else {
                Unit unit = Unit.INSTANCE;
                Result.Companion companion = Result.Companion;
                cancellableContinuation.resumeWith(Result.m47688constructorimpl(unit));
            }
            Unit unit2 = Unit.INSTANCE;
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    public void resetReplayCache() {
        synchronized (this) {
            m45698a(m45719f(), this.f61446f, m45719f(), m45720g());
            Unit unit = Unit.INSTANCE;
        }
    }
}
