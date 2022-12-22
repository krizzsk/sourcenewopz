package kotlinx.coroutines.debug.internal;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.concurrent.ThreadsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;

@Metadata(mo175977d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\bÀ\u0002\u0018\u00002\u00020\u0013:\u0002\u0001B\t\b\u0002¢\u0006\u0004\b\u0001\u0010\u0002J3\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012J>\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\"\b\b\u0000\u0010\u0014*\u00020\u00132\u001c\u0010\u0018\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00028\u00000\u0015H\b¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001b\u0010\u000eJ\u0013\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000f¢\u0006\u0004\b\u001d\u0010\u0012J)\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001f0\u000f2\u0006\u0010\u001e\u001a\u00020\u00102\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u000f¢\u0006\u0004\b!\u0010\"J5\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001f0\u000f2\u0006\u0010$\u001a\u00020#2\b\u0010&\u001a\u0004\u0018\u00010%2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u000fH\u0002¢\u0006\u0004\b'\u0010(J?\u0010.\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)0-2\u0006\u0010*\u001a\u00020)2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001f0+2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u000fH\u0002¢\u0006\u0004\b.\u0010/J3\u00101\u001a\u00020)2\u0006\u00100\u001a\u00020)2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001f0+2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u000fH\u0002¢\u0006\u0004\b1\u00102J\u001d\u00105\u001a\u0010\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\f\u0018\u000103H\u0002¢\u0006\u0004\b5\u00106J\u0015\u00109\u001a\u00020#2\u0006\u00108\u001a\u000207¢\u0006\u0004\b9\u0010:J\r\u0010;\u001a\u00020\f¢\u0006\u0004\b;\u0010\u0002J%\u0010=\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u001f0\u000fH\u0002¢\u0006\u0004\b=\u0010>J\u001b\u0010@\u001a\u00020\f2\n\u0010?\u001a\u0006\u0012\u0002\b\u00030\u0016H\u0002¢\u0006\u0004\b@\u0010AJ)\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0000¢\u0006\u0004\bB\u0010CJ\u001b\u0010G\u001a\u00020\f2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0000¢\u0006\u0004\bE\u0010FJ\u001b\u0010I\u001a\u00020\f2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0000¢\u0006\u0004\bH\u0010FJ'\u0010L\u001a\b\u0012\u0004\u0012\u00020\u001f0\u000f\"\b\b\u0000\u0010\u0003*\u00020J2\u0006\u0010K\u001a\u00028\u0000H\u0002¢\u0006\u0004\bL\u0010MJ\u000f\u0010N\u001a\u00020\fH\u0002¢\u0006\u0004\bN\u0010\u0002J\u000f\u0010O\u001a\u00020\fH\u0002¢\u0006\u0004\bO\u0010\u0002J\r\u0010P\u001a\u00020\f¢\u0006\u0004\bP\u0010\u0002J\u001f\u0010R\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020Q2\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\bR\u0010SJ#\u0010T\u001a\u00020\f2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\bT\u0010UJ/\u0010T\u001a\u00020\f2\n\u0010?\u001a\u0006\u0012\u0002\b\u00030\u00162\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\bT\u0010VJ;\u0010^\u001a\u00020\f*\u0002072\u0012\u0010Y\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020X0W2\n\u0010\\\u001a\u00060Zj\u0002`[2\u0006\u0010]\u001a\u00020#H\u0002¢\u0006\u0004\b^\u0010_J\u0017\u0010`\u001a\u000204*\u0006\u0012\u0002\b\u00030\u0016H\u0002¢\u0006\u0004\b`\u0010aJ\u001d\u0010?\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0016*\u0006\u0012\u0002\b\u00030\u0004H\u0002¢\u0006\u0004\b?\u0010bJ\u001a\u0010?\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0016*\u00020QH\u0010¢\u0006\u0004\b?\u0010cJ\u0016\u0010d\u001a\u0004\u0018\u00010Q*\u00020QH\u0010¢\u0006\u0004\bd\u0010eJ\u001b\u0010f\u001a\u0004\u0018\u00010\u0006*\b\u0012\u0004\u0012\u00020\u001f0\u000fH\u0002¢\u0006\u0004\bf\u0010gR\u0014\u0010h\u001a\u00020#8\u0002XT¢\u0006\u0006\n\u0004\bh\u0010iR \u0010k\u001a\u000e\u0012\u0004\u0012\u00020Q\u0012\u0004\u0012\u00020X0j8\u0002X\u0004¢\u0006\u0006\n\u0004\bk\u0010lR\u001e\u0010p\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00160m8BX\u0004¢\u0006\u0006\u001a\u0004\bn\u0010oR$\u0010q\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0016\u0012\u0004\u0012\u0002040j8\u0002X\u0004¢\u0006\u0006\n\u0004\bq\u0010lR\u0014\u0010s\u001a\u00020r8\u0002X\u0004¢\u0006\u0006\n\u0004\bs\u0010tR\u0014\u0010v\u001a\u00020u8\u0002X\u0004¢\u0006\u0006\n\u0004\bv\u0010wR\"\u0010x\u001a\u0010\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\f\u0018\u0001038\u0002X\u0004¢\u0006\u0006\n\u0004\bx\u0010yR\"\u0010z\u001a\u0002048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}\"\u0004\b~\u0010R\u0019\u0010\u0001\u001a\u00020)8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0016\u0010\u0001\u001a\u0002048@X\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010}R&\u0010\u0001\u001a\u0002048\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\b\u0001\u0010{\u001a\u0005\b\u0001\u0010}\"\u0005\b\u0001\u0010R\u001b\u0010\u0001\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\"\u0010\u0001\u001a\u00020#*\u0002078BX\u0004¢\u0006\u000f\u0012\u0006\b\u0001\u0010\u0001\u001a\u0005\b\u0001\u0010:R\u001b\u0010\u0001\u001a\u000204*\u00020\u001f8BX\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, mo175978d2 = {"Lkotlinx/coroutines/debug/internal/DebugProbesImpl;", "<init>", "()V", "T", "Lkotlin/coroutines/Continuation;", "completion", "Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "frame", "createOwner", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/debug/internal/StackTraceFrame;)Lkotlin/coroutines/Continuation;", "Ljava/io/PrintStream;", "out", "", "dumpCoroutines", "(Ljava/io/PrintStream;)V", "", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfo;", "dumpCoroutinesInfo", "()Ljava/util/List;", "", "R", "Lkotlin/Function2;", "Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "Lkotlin/coroutines/CoroutineContext;", "create", "dumpCoroutinesInfoImpl", "(Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "dumpCoroutinesSynchronized", "Lkotlinx/coroutines/debug/internal/DebuggerInfo;", "dumpDebuggerInfo", "info", "Ljava/lang/StackTraceElement;", "coroutineTrace", "enhanceStackTraceWithThreadDump", "(Lkotlinx/coroutines/debug/internal/DebugCoroutineInfo;Ljava/util/List;)Ljava/util/List;", "", "state", "Ljava/lang/Thread;", "thread", "enhanceStackTraceWithThreadDumpImpl", "(Ljava/lang/String;Ljava/lang/Thread;Ljava/util/List;)Ljava/util/List;", "", "indexOfResumeWith", "", "actualTrace", "Lkotlin/Pair;", "findContinuationStartIndex", "(I[Ljava/lang/StackTraceElement;Ljava/util/List;)Lkotlin/Pair;", "frameIndex", "findIndexOfFrame", "(I[Ljava/lang/StackTraceElement;Ljava/util/List;)I", "Lkotlin/Function1;", "", "getDynamicAttach", "()Lkotlin/jvm/functions/Function1;", "Lkotlinx/coroutines/Job;", "job", "hierarchyToString", "(Lkotlinx/coroutines/Job;)Ljava/lang/String;", "install", "frames", "printStackTrace", "(Ljava/io/PrintStream;Ljava/util/List;)V", "owner", "probeCoroutineCompleted", "(Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;)V", "probeCoroutineCreated$kotlinx_coroutines_core", "(Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "probeCoroutineCreated", "probeCoroutineResumed$kotlinx_coroutines_core", "(Lkotlin/coroutines/Continuation;)V", "probeCoroutineResumed", "probeCoroutineSuspended$kotlinx_coroutines_core", "probeCoroutineSuspended", "", "throwable", "sanitizeStackTrace", "(Ljava/lang/Throwable;)Ljava/util/List;", "startWeakRefCleanerThread", "stopWeakRefCleanerThread", "uninstall", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "updateRunningState", "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;Ljava/lang/String;)V", "updateState", "(Lkotlin/coroutines/Continuation;Ljava/lang/String;)V", "(Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;Lkotlin/coroutines/Continuation;Ljava/lang/String;)V", "", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "map", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "builder", "indent", "build", "(Lkotlinx/coroutines/Job;Ljava/util/Map;Ljava/lang/StringBuilder;Ljava/lang/String;)V", "isFinished", "(Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;)Z", "(Lkotlin/coroutines/Continuation;)Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "realCaller", "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "toStackTraceFrame", "(Ljava/util/List;)Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "ARTIFICIAL_FRAME_MESSAGE", "Ljava/lang/String;", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "callerInfoCache", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "", "getCapturedCoroutines", "()Ljava/util/Set;", "capturedCoroutines", "capturedCoroutinesMap", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "coroutineStateLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "Ljava/text/SimpleDateFormat;", "dateFormat", "Ljava/text/SimpleDateFormat;", "dynamicAttach", "Lkotlin/jvm/functions/Function1;", "enableCreationStackTraces", "Z", "getEnableCreationStackTraces", "()Z", "setEnableCreationStackTraces", "(Z)V", "installations", "I", "isInstalled$kotlinx_coroutines_core", "isInstalled", "sanitizeStackTraces", "getSanitizeStackTraces", "setSanitizeStackTraces", "weakRefCleanerThread", "Ljava/lang/Thread;", "getDebugString", "getDebugString$annotations", "(Lkotlinx/coroutines/Job;)V", "debugString", "isInternalMethod", "(Ljava/lang/StackTraceElement;)Z", "CoroutineOwner", "kotlinx-coroutines-core"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DebugProbesImpl.kt */
public final class DebugProbesImpl {
    public static final DebugProbesImpl INSTANCE = new DebugProbesImpl();

    /* renamed from: a */
    private static final String f61425a = "Coroutine creation stacktrace";

    /* renamed from: b */
    private static final SimpleDateFormat f61426b = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    /* renamed from: c */
    private static Thread f61427c;

    /* renamed from: d */
    private static final ConcurrentWeakMap<CoroutineOwner<?>, Boolean> f61428d = new ConcurrentWeakMap<>(false, 1, (DefaultConstructorMarker) null);

    /* renamed from: e */
    private static final /* synthetic */ SequenceNumberRefVolatile f61429e = new SequenceNumberRefVolatile(0);

    /* renamed from: f */
    private static final /* synthetic */ AtomicLongFieldUpdater f61430f = AtomicLongFieldUpdater.newUpdater(SequenceNumberRefVolatile.class, "sequenceNumber");
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static final ReentrantReadWriteLock f61431g = new ReentrantReadWriteLock();

    /* renamed from: h */
    private static boolean f61432h = true;

    /* renamed from: i */
    private static boolean f61433i = true;
    private static volatile int installations;

    /* renamed from: j */
    private static final Function1<Boolean, Unit> f61434j = INSTANCE.m45669b();
    /* access modifiers changed from: private */

    /* renamed from: k */
    public static final ConcurrentWeakMap<CoroutineStackFrame, DebugCoroutineInfoImpl> f61435k = new ConcurrentWeakMap<>(true);

    /* synthetic */ class SequenceNumberRefVolatile {
        volatile long sequenceNumber;

        public SequenceNumberRefVolatile(long j) {
            this.sequenceNumber = j;
        }
    }

    /* renamed from: b */
    private static /* synthetic */ void m45671b(Job job) {
    }

    private DebugProbesImpl() {
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final Set<CoroutineOwner<?>> m45654a() {
        return f61428d.keySet();
    }

    public final boolean isInstalled$kotlinx_coroutines_core() {
        return installations > 0;
    }

    public final boolean getSanitizeStackTraces() {
        return f61432h;
    }

    public final void setSanitizeStackTraces(boolean z) {
        f61432h = z;
    }

    public final boolean getEnableCreationStackTraces() {
        return f61433i;
    }

    public final void setEnableCreationStackTraces(boolean z) {
        f61433i = z;
    }

    /* renamed from: b */
    private final Function1<Boolean, Unit> m45669b() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            DebugProbesImpl debugProbesImpl = this;
            Object newInstance = Class.forName("kotlinx.coroutines.debug.internal.ByteBuddyDynamicAttach").getConstructors()[0].newInstance(new Object[0]);
            if (newInstance != null) {
                obj = Result.m47688constructorimpl((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(newInstance, 1));
                if (Result.m47694isFailureimpl(obj)) {
                    obj = null;
                }
                return (Function1) obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Function1<kotlin.Boolean, kotlin.Unit>");
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m47688constructorimpl(ResultKt.createFailure(th));
        }
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final void install() {
        /*
            r6 = this;
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = f61431g
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r0.readLock()
            int r2 = r0.getWriteHoldCount()
            r3 = 0
            if (r2 != 0) goto L_0x0012
            int r2 = r0.getReadHoldCount()
            goto L_0x0013
        L_0x0012:
            r2 = 0
        L_0x0013:
            r4 = 0
        L_0x0014:
            if (r4 >= r2) goto L_0x001c
            r1.unlock()
            int r4 = r4 + 1
            goto L_0x0014
        L_0x001c:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            int r4 = installations     // Catch:{ all -> 0x006c }
            r5 = 1
            int r4 = r4 + r5
            installations = r4     // Catch:{ all -> 0x006c }
            int r4 = installations     // Catch:{ all -> 0x006c }
            if (r4 <= r5) goto L_0x0039
        L_0x002d:
            if (r3 >= r2) goto L_0x0035
            r1.lock()
            int r3 = r3 + 1
            goto L_0x002d
        L_0x0035:
            r0.unlock()
            return
        L_0x0039:
            kotlinx.coroutines.debug.internal.DebugProbesImpl r4 = INSTANCE     // Catch:{ all -> 0x006c }
            r4.m45673c()     // Catch:{ all -> 0x006c }
            kotlinx.coroutines.debug.AgentPremain r4 = kotlinx.coroutines.debug.AgentPremain.INSTANCE     // Catch:{ all -> 0x006c }
            boolean r4 = r4.isInstalledStatically()     // Catch:{ all -> 0x006c }
            if (r4 == 0) goto L_0x0052
        L_0x0046:
            if (r3 >= r2) goto L_0x004e
            r1.lock()
            int r3 = r3 + 1
            goto L_0x0046
        L_0x004e:
            r0.unlock()
            return
        L_0x0052:
            kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> r4 = f61434j     // Catch:{ all -> 0x006c }
            if (r4 != 0) goto L_0x0057
            goto L_0x005e
        L_0x0057:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ all -> 0x006c }
            r4.invoke(r5)     // Catch:{ all -> 0x006c }
        L_0x005e:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x006c }
        L_0x0060:
            if (r3 >= r2) goto L_0x0068
            r1.lock()
            int r3 = r3 + 1
            goto L_0x0060
        L_0x0068:
            r0.unlock()
            return
        L_0x006c:
            r4 = move-exception
        L_0x006d:
            if (r3 >= r2) goto L_0x0075
            r1.lock()
            int r3 = r3 + 1
            goto L_0x006d
        L_0x0075:
            r0.unlock()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugProbesImpl.install():void");
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final void uninstall() {
        /*
            r6 = this;
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = f61431g
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r0.readLock()
            int r2 = r0.getWriteHoldCount()
            r3 = 0
            if (r2 != 0) goto L_0x0012
            int r2 = r0.getReadHoldCount()
            goto L_0x0013
        L_0x0012:
            r2 = 0
        L_0x0013:
            r4 = 0
        L_0x0014:
            if (r4 >= r2) goto L_0x001c
            r1.unlock()
            int r4 = r4 + 1
            goto L_0x0014
        L_0x001c:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            kotlinx.coroutines.debug.internal.DebugProbesImpl r4 = INSTANCE     // Catch:{ all -> 0x008c }
            boolean r4 = r4.isInstalled$kotlinx_coroutines_core()     // Catch:{ all -> 0x008c }
            if (r4 == 0) goto L_0x007e
            int r4 = installations     // Catch:{ all -> 0x008c }
            int r4 = r4 + -1
            installations = r4     // Catch:{ all -> 0x008c }
            int r4 = installations     // Catch:{ all -> 0x008c }
            if (r4 == 0) goto L_0x0041
        L_0x0035:
            if (r3 >= r2) goto L_0x003d
            r1.lock()
            int r3 = r3 + 1
            goto L_0x0035
        L_0x003d:
            r0.unlock()
            return
        L_0x0041:
            kotlinx.coroutines.debug.internal.DebugProbesImpl r4 = INSTANCE     // Catch:{ all -> 0x008c }
            r4.m45674d()     // Catch:{ all -> 0x008c }
            kotlinx.coroutines.debug.internal.ConcurrentWeakMap<kotlinx.coroutines.debug.internal.DebugProbesImpl$CoroutineOwner<?>, java.lang.Boolean> r4 = f61428d     // Catch:{ all -> 0x008c }
            r4.clear()     // Catch:{ all -> 0x008c }
            kotlinx.coroutines.debug.internal.ConcurrentWeakMap<kotlin.coroutines.jvm.internal.CoroutineStackFrame, kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl> r4 = f61435k     // Catch:{ all -> 0x008c }
            r4.clear()     // Catch:{ all -> 0x008c }
            kotlinx.coroutines.debug.AgentPremain r4 = kotlinx.coroutines.debug.AgentPremain.INSTANCE     // Catch:{ all -> 0x008c }
            boolean r4 = r4.isInstalledStatically()     // Catch:{ all -> 0x008c }
            if (r4 == 0) goto L_0x0064
        L_0x0058:
            if (r3 >= r2) goto L_0x0060
            r1.lock()
            int r3 = r3 + 1
            goto L_0x0058
        L_0x0060:
            r0.unlock()
            return
        L_0x0064:
            kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> r4 = f61434j     // Catch:{ all -> 0x008c }
            if (r4 != 0) goto L_0x0069
            goto L_0x0070
        L_0x0069:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x008c }
            r4.invoke(r5)     // Catch:{ all -> 0x008c }
        L_0x0070:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x008c }
        L_0x0072:
            if (r3 >= r2) goto L_0x007a
            r1.lock()
            int r3 = r3 + 1
            goto L_0x0072
        L_0x007a:
            r0.unlock()
            return
        L_0x007e:
            java.lang.String r4 = "Agent was not installed"
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ all -> 0x008c }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x008c }
            r5.<init>(r4)     // Catch:{ all -> 0x008c }
            java.lang.Throwable r5 = (java.lang.Throwable) r5     // Catch:{ all -> 0x008c }
            throw r5     // Catch:{ all -> 0x008c }
        L_0x008c:
            r4 = move-exception
        L_0x008d:
            if (r3 >= r2) goto L_0x0095
            r1.lock()
            int r3 = r3 + 1
            goto L_0x008d
        L_0x0095:
            r0.unlock()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugProbesImpl.uninstall():void");
    }

    /* renamed from: c */
    private final void m45673c() {
        f61427c = ThreadsKt.thread$default(false, true, (ClassLoader) null, "Coroutines Debugger Cleaner", 0, DebugProbesImpl$startWeakRefCleanerThread$1.INSTANCE, 21, (Object) null);
    }

    /* renamed from: d */
    private final void m45674d() {
        Thread thread = f61427c;
        if (thread != null) {
            thread.interrupt();
        }
        f61427c = null;
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final java.lang.String hierarchyToString(kotlinx.coroutines.Job r10) {
        /*
            r9 = this;
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = f61431g
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r0.readLock()
            int r2 = r0.getWriteHoldCount()
            r3 = 0
            if (r2 != 0) goto L_0x0012
            int r2 = r0.getReadHoldCount()
            goto L_0x0013
        L_0x0012:
            r2 = 0
        L_0x0013:
            r4 = 0
        L_0x0014:
            if (r4 >= r2) goto L_0x001c
            r1.unlock()
            int r4 = r4 + 1
            goto L_0x0014
        L_0x001c:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            kotlinx.coroutines.debug.internal.DebugProbesImpl r4 = INSTANCE     // Catch:{ all -> 0x00d1 }
            boolean r4 = r4.isInstalled$kotlinx_coroutines_core()     // Catch:{ all -> 0x00d1 }
            if (r4 == 0) goto L_0x00c3
            kotlinx.coroutines.debug.internal.DebugProbesImpl r4 = INSTANCE     // Catch:{ all -> 0x00d1 }
            java.util.Set r4 = r4.m45654a()     // Catch:{ all -> 0x00d1 }
            java.lang.Iterable r4 = (java.lang.Iterable) r4     // Catch:{ all -> 0x00d1 }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x00d1 }
            r5.<init>()     // Catch:{ all -> 0x00d1 }
            java.util.Collection r5 = (java.util.Collection) r5     // Catch:{ all -> 0x00d1 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x00d1 }
        L_0x003e:
            boolean r6 = r4.hasNext()     // Catch:{ all -> 0x00d1 }
            if (r6 == 0) goto L_0x0064
            java.lang.Object r6 = r4.next()     // Catch:{ all -> 0x00d1 }
            r7 = r6
            kotlinx.coroutines.debug.internal.DebugProbesImpl$CoroutineOwner r7 = (kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner) r7     // Catch:{ all -> 0x00d1 }
            kotlin.coroutines.Continuation<T> r7 = r7.delegate     // Catch:{ all -> 0x00d1 }
            kotlin.coroutines.CoroutineContext r7 = r7.getContext()     // Catch:{ all -> 0x00d1 }
            kotlinx.coroutines.Job$Key r8 = kotlinx.coroutines.Job.Key     // Catch:{ all -> 0x00d1 }
            kotlin.coroutines.CoroutineContext$Key r8 = (kotlin.coroutines.CoroutineContext.Key) r8     // Catch:{ all -> 0x00d1 }
            kotlin.coroutines.CoroutineContext$Element r7 = r7.get(r8)     // Catch:{ all -> 0x00d1 }
            if (r7 == 0) goto L_0x005d
            r7 = 1
            goto L_0x005e
        L_0x005d:
            r7 = 0
        L_0x005e:
            if (r7 == 0) goto L_0x003e
            r5.add(r6)     // Catch:{ all -> 0x00d1 }
            goto L_0x003e
        L_0x0064:
            java.util.List r5 = (java.util.List) r5     // Catch:{ all -> 0x00d1 }
            java.lang.Iterable r5 = (java.lang.Iterable) r5     // Catch:{ all -> 0x00d1 }
            r4 = 10
            int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r5, r4)     // Catch:{ all -> 0x00d1 }
            int r4 = kotlin.collections.MapsKt.mapCapacity(r4)     // Catch:{ all -> 0x00d1 }
            r6 = 16
            int r4 = kotlin.ranges.RangesKt.coerceAtLeast((int) r4, (int) r6)     // Catch:{ all -> 0x00d1 }
            java.util.LinkedHashMap r6 = new java.util.LinkedHashMap     // Catch:{ all -> 0x00d1 }
            r6.<init>(r4)     // Catch:{ all -> 0x00d1 }
            java.util.Map r6 = (java.util.Map) r6     // Catch:{ all -> 0x00d1 }
            java.util.Iterator r4 = r5.iterator()     // Catch:{ all -> 0x00d1 }
        L_0x0083:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x00d1 }
            if (r5 == 0) goto L_0x00a2
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x00d1 }
            r7 = r5
            kotlinx.coroutines.debug.internal.DebugProbesImpl$CoroutineOwner r7 = (kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner) r7     // Catch:{ all -> 0x00d1 }
            kotlin.coroutines.Continuation<T> r7 = r7.delegate     // Catch:{ all -> 0x00d1 }
            kotlin.coroutines.CoroutineContext r7 = r7.getContext()     // Catch:{ all -> 0x00d1 }
            kotlinx.coroutines.Job r7 = kotlinx.coroutines.JobKt.getJob(r7)     // Catch:{ all -> 0x00d1 }
            kotlinx.coroutines.debug.internal.DebugProbesImpl$CoroutineOwner r5 = (kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner) r5     // Catch:{ all -> 0x00d1 }
            kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl r5 = r5.info     // Catch:{ all -> 0x00d1 }
            r6.put(r7, r5)     // Catch:{ all -> 0x00d1 }
            goto L_0x0083
        L_0x00a2:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d1 }
            r4.<init>()     // Catch:{ all -> 0x00d1 }
            kotlinx.coroutines.debug.internal.DebugProbesImpl r5 = INSTANCE     // Catch:{ all -> 0x00d1 }
            java.lang.String r7 = ""
            r5.m45664a(r10, r6, r4, r7)     // Catch:{ all -> 0x00d1 }
            java.lang.String r10 = r4.toString()     // Catch:{ all -> 0x00d1 }
            java.lang.String r4 = "StringBuilder().apply(builderAction).toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r4)     // Catch:{ all -> 0x00d1 }
        L_0x00b7:
            if (r3 >= r2) goto L_0x00bf
            r1.lock()
            int r3 = r3 + 1
            goto L_0x00b7
        L_0x00bf:
            r0.unlock()
            return r10
        L_0x00c3:
            java.lang.String r10 = "Debug probes are not installed"
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00d1 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x00d1 }
            r4.<init>(r10)     // Catch:{ all -> 0x00d1 }
            java.lang.Throwable r4 = (java.lang.Throwable) r4     // Catch:{ all -> 0x00d1 }
            throw r4     // Catch:{ all -> 0x00d1 }
        L_0x00d1:
            r10 = move-exception
        L_0x00d2:
            if (r3 >= r2) goto L_0x00da
            r1.lock()
            int r3 = r3 + 1
            goto L_0x00d2
        L_0x00da:
            r0.unlock()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugProbesImpl.hierarchyToString(kotlinx.coroutines.Job):java.lang.String");
    }

    /* renamed from: a */
    private final void m45664a(Job job, Map<Job, DebugCoroutineInfoImpl> map, StringBuilder sb, String str) {
        DebugCoroutineInfoImpl debugCoroutineInfoImpl = map.get(job);
        if (debugCoroutineInfoImpl != null) {
            String state = debugCoroutineInfoImpl.getState();
            sb.append(str + m45650a(job) + ", continuation is " + state + " at line " + ((StackTraceElement) CollectionsKt.firstOrNull(debugCoroutineInfoImpl.lastObservedStackTrace())) + 10);
            str = Intrinsics.stringPlus(str, "\t");
        } else if (!(job instanceof ScopeCoroutine)) {
            sb.append(str + m45650a(job) + 10);
            str = Intrinsics.stringPlus(str, "\t");
        }
        for (Job a : job.getChildren()) {
            m45664a(a, map, sb, str);
        }
    }

    /* renamed from: a */
    private final String m45650a(Job job) {
        return job instanceof JobSupport ? ((JobSupport) job).toDebugString() : job.toString();
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* renamed from: a */
    private final <R> java.util.List<R> m45653a(kotlin.jvm.functions.Function2<? super kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner<?>, ? super kotlin.coroutines.CoroutineContext, ? extends R> r11) {
        /*
            r10 = this;
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = f61431g
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r0.readLock()
            int r2 = r0.getWriteHoldCount()
            r3 = 0
            if (r2 != 0) goto L_0x0014
            int r2 = r0.getReadHoldCount()
            goto L_0x0015
        L_0x0014:
            r2 = 0
        L_0x0015:
            r4 = 0
        L_0x0016:
            if (r4 >= r2) goto L_0x001e
            r1.unlock()
            int r4 = r4 + 1
            goto L_0x0016
        L_0x001e:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            r4 = 1
            kotlinx.coroutines.debug.internal.DebugProbesImpl r5 = INSTANCE     // Catch:{ all -> 0x0099 }
            boolean r5 = r5.isInstalled$kotlinx_coroutines_core()     // Catch:{ all -> 0x0099 }
            if (r5 == 0) goto L_0x008b
            kotlinx.coroutines.debug.internal.DebugProbesImpl r5 = INSTANCE     // Catch:{ all -> 0x0099 }
            java.util.Set r5 = r5.m45654a()     // Catch:{ all -> 0x0099 }
            java.lang.Iterable r5 = (java.lang.Iterable) r5     // Catch:{ all -> 0x0099 }
            kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesInfoImpl$lambda-14$$inlined$sortedBy$1 r6 = new kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesInfoImpl$lambda-14$$inlined$sortedBy$1     // Catch:{ all -> 0x0099 }
            r6.<init>()     // Catch:{ all -> 0x0099 }
            java.util.Comparator r6 = (java.util.Comparator) r6     // Catch:{ all -> 0x0099 }
            java.util.List r5 = kotlin.collections.CollectionsKt.sortedWith(r5, r6)     // Catch:{ all -> 0x0099 }
            java.lang.Iterable r5 = (java.lang.Iterable) r5     // Catch:{ all -> 0x0099 }
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x0099 }
            r6.<init>()     // Catch:{ all -> 0x0099 }
            java.util.Collection r6 = (java.util.Collection) r6     // Catch:{ all -> 0x0099 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x0099 }
        L_0x004e:
            boolean r7 = r5.hasNext()     // Catch:{ all -> 0x0099 }
            if (r7 == 0) goto L_0x0077
            java.lang.Object r7 = r5.next()     // Catch:{ all -> 0x0099 }
            kotlinx.coroutines.debug.internal.DebugProbesImpl$CoroutineOwner r7 = (kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner) r7     // Catch:{ all -> 0x0099 }
            kotlinx.coroutines.debug.internal.DebugProbesImpl r8 = INSTANCE     // Catch:{ all -> 0x0099 }
            boolean r8 = r8.m45667a((kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner<?>) r7)     // Catch:{ all -> 0x0099 }
            r9 = 0
            if (r8 == 0) goto L_0x0064
            goto L_0x0071
        L_0x0064:
            kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl r8 = r7.info     // Catch:{ all -> 0x0099 }
            kotlin.coroutines.CoroutineContext r8 = r8.getContext()     // Catch:{ all -> 0x0099 }
            if (r8 != 0) goto L_0x006d
            goto L_0x0071
        L_0x006d:
            java.lang.Object r9 = r11.invoke(r7, r8)     // Catch:{ all -> 0x0099 }
        L_0x0071:
            if (r9 == 0) goto L_0x004e
            r6.add(r9)     // Catch:{ all -> 0x0099 }
            goto L_0x004e
        L_0x0077:
            java.util.List r6 = (java.util.List) r6     // Catch:{ all -> 0x0099 }
            kotlin.jvm.internal.InlineMarker.finallyStart(r4)
        L_0x007c:
            if (r3 >= r2) goto L_0x0084
            r1.lock()
            int r3 = r3 + 1
            goto L_0x007c
        L_0x0084:
            r0.unlock()
            kotlin.jvm.internal.InlineMarker.finallyEnd(r4)
            return r6
        L_0x008b:
            java.lang.String r11 = "Debug probes are not installed"
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0099 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0099 }
            r5.<init>(r11)     // Catch:{ all -> 0x0099 }
            java.lang.Throwable r5 = (java.lang.Throwable) r5     // Catch:{ all -> 0x0099 }
            throw r5     // Catch:{ all -> 0x0099 }
        L_0x0099:
            r11 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r4)
        L_0x009d:
            if (r3 >= r2) goto L_0x00a5
            r1.lock()
            int r3 = r3 + 1
            goto L_0x009d
        L_0x00a5:
            r0.unlock()
            kotlin.jvm.internal.InlineMarker.finallyEnd(r4)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugProbesImpl.m45653a(kotlin.jvm.functions.Function2):java.util.List");
    }

    public final void dumpCoroutines(PrintStream printStream) {
        synchronized (printStream) {
            INSTANCE.m45660a(printStream);
            Unit unit = Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final boolean m45667a(CoroutineOwner<?> coroutineOwner) {
        CoroutineContext context = coroutineOwner.info.getContext();
        Job job = context == null ? null : (Job) context.get(Job.Key);
        if (job == null || !job.isCompleted()) {
            return false;
        }
        f61428d.remove(coroutineOwner);
        return true;
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* renamed from: a */
    private final void m45660a(java.io.PrintStream r13) {
        /*
            r12 = this;
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = f61431g
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r0.readLock()
            int r2 = r0.getWriteHoldCount()
            r3 = 0
            if (r2 != 0) goto L_0x0012
            int r2 = r0.getReadHoldCount()
            goto L_0x0013
        L_0x0012:
            r2 = 0
        L_0x0013:
            r4 = 0
        L_0x0014:
            if (r4 >= r2) goto L_0x001c
            r1.unlock()
            int r4 = r4 + 1
            goto L_0x0014
        L_0x001c:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            kotlinx.coroutines.debug.internal.DebugProbesImpl r4 = INSTANCE     // Catch:{ all -> 0x00ff }
            boolean r4 = r4.isInstalled$kotlinx_coroutines_core()     // Catch:{ all -> 0x00ff }
            if (r4 == 0) goto L_0x00f1
            java.lang.String r4 = "Coroutines dump "
            java.text.SimpleDateFormat r5 = f61426b     // Catch:{ all -> 0x00ff }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00ff }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x00ff }
            java.lang.String r5 = r5.format(r6)     // Catch:{ all -> 0x00ff }
            java.lang.String r4 = kotlin.jvm.internal.Intrinsics.stringPlus(r4, r5)     // Catch:{ all -> 0x00ff }
            r13.print(r4)     // Catch:{ all -> 0x00ff }
            kotlinx.coroutines.debug.internal.DebugProbesImpl r4 = INSTANCE     // Catch:{ all -> 0x00ff }
            java.util.Set r4 = r4.m45654a()     // Catch:{ all -> 0x00ff }
            java.lang.Iterable r4 = (java.lang.Iterable) r4     // Catch:{ all -> 0x00ff }
            kotlin.sequences.Sequence r4 = kotlin.collections.CollectionsKt.asSequence(r4)     // Catch:{ all -> 0x00ff }
            kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesSynchronized$1$2 r5 = kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesSynchronized$1$2.INSTANCE     // Catch:{ all -> 0x00ff }
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5     // Catch:{ all -> 0x00ff }
            kotlin.sequences.Sequence r4 = kotlin.sequences.SequencesKt.filter(r4, r5)     // Catch:{ all -> 0x00ff }
            kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesSynchronized$lambda-21$$inlined$sortedBy$1 r5 = new kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesSynchronized$lambda-21$$inlined$sortedBy$1     // Catch:{ all -> 0x00ff }
            r5.<init>()     // Catch:{ all -> 0x00ff }
            java.util.Comparator r5 = (java.util.Comparator) r5     // Catch:{ all -> 0x00ff }
            kotlin.sequences.Sequence r4 = kotlin.sequences.SequencesKt.sortedWith(r4, r5)     // Catch:{ all -> 0x00ff }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x00ff }
        L_0x0065:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x00ff }
            if (r5 == 0) goto L_0x00e3
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x00ff }
            kotlinx.coroutines.debug.internal.DebugProbesImpl$CoroutineOwner r5 = (kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner) r5     // Catch:{ all -> 0x00ff }
            kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl r6 = r5.info     // Catch:{ all -> 0x00ff }
            java.util.List r7 = r6.lastObservedStackTrace()     // Catch:{ all -> 0x00ff }
            kotlinx.coroutines.debug.internal.DebugProbesImpl r8 = INSTANCE     // Catch:{ all -> 0x00ff }
            java.lang.String r9 = r6.getState()     // Catch:{ all -> 0x00ff }
            java.lang.Thread r10 = r6.lastObservedThread     // Catch:{ all -> 0x00ff }
            java.util.List r8 = r8.m45651a((java.lang.String) r9, (java.lang.Thread) r10, (java.util.List<java.lang.StackTraceElement>) r7)     // Catch:{ all -> 0x00ff }
            java.lang.String r9 = r6.getState()     // Catch:{ all -> 0x00ff }
            java.lang.String r10 = "RUNNING"
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r10)     // Catch:{ all -> 0x00ff }
            if (r9 == 0) goto L_0x009c
            if (r8 != r7) goto L_0x009c
            java.lang.String r9 = r6.getState()     // Catch:{ all -> 0x00ff }
            java.lang.String r10 = " (Last suspension stacktrace, not an actual stacktrace)"
            java.lang.String r9 = kotlin.jvm.internal.Intrinsics.stringPlus(r9, r10)     // Catch:{ all -> 0x00ff }
            goto L_0x00a0
        L_0x009c:
            java.lang.String r9 = r6.getState()     // Catch:{ all -> 0x00ff }
        L_0x00a0:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ff }
            r10.<init>()     // Catch:{ all -> 0x00ff }
            java.lang.String r11 = "\n\nCoroutine "
            r10.append(r11)     // Catch:{ all -> 0x00ff }
            kotlin.coroutines.Continuation<T> r5 = r5.delegate     // Catch:{ all -> 0x00ff }
            r10.append(r5)     // Catch:{ all -> 0x00ff }
            java.lang.String r5 = ", state: "
            r10.append(r5)     // Catch:{ all -> 0x00ff }
            r10.append(r9)     // Catch:{ all -> 0x00ff }
            java.lang.String r5 = r10.toString()     // Catch:{ all -> 0x00ff }
            r13.print(r5)     // Catch:{ all -> 0x00ff }
            boolean r5 = r7.isEmpty()     // Catch:{ all -> 0x00ff }
            if (r5 == 0) goto L_0x00dd
            java.lang.String r5 = "\n\tat "
            java.lang.String r7 = "Coroutine creation stacktrace"
            java.lang.StackTraceElement r7 = kotlinx.coroutines.internal.StackTraceRecoveryKt.artificialFrame(r7)     // Catch:{ all -> 0x00ff }
            java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r5, r7)     // Catch:{ all -> 0x00ff }
            r13.print(r5)     // Catch:{ all -> 0x00ff }
            kotlinx.coroutines.debug.internal.DebugProbesImpl r5 = INSTANCE     // Catch:{ all -> 0x00ff }
            java.util.List r6 = r6.getCreationStackTrace()     // Catch:{ all -> 0x00ff }
            r5.m45661a((java.io.PrintStream) r13, (java.util.List<java.lang.StackTraceElement>) r6)     // Catch:{ all -> 0x00ff }
            goto L_0x0065
        L_0x00dd:
            kotlinx.coroutines.debug.internal.DebugProbesImpl r5 = INSTANCE     // Catch:{ all -> 0x00ff }
            r5.m45661a((java.io.PrintStream) r13, (java.util.List<java.lang.StackTraceElement>) r8)     // Catch:{ all -> 0x00ff }
            goto L_0x0065
        L_0x00e3:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00ff }
        L_0x00e5:
            if (r3 >= r2) goto L_0x00ed
            r1.lock()
            int r3 = r3 + 1
            goto L_0x00e5
        L_0x00ed:
            r0.unlock()
            return
        L_0x00f1:
            java.lang.String r13 = "Debug probes are not installed"
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00ff }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x00ff }
            r4.<init>(r13)     // Catch:{ all -> 0x00ff }
            java.lang.Throwable r4 = (java.lang.Throwable) r4     // Catch:{ all -> 0x00ff }
            throw r4     // Catch:{ all -> 0x00ff }
        L_0x00ff:
            r13 = move-exception
        L_0x0100:
            if (r3 >= r2) goto L_0x0108
            r1.lock()
            int r3 = r3 + 1
            goto L_0x0100
        L_0x0108:
            r0.unlock()
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugProbesImpl.m45660a(java.io.PrintStream):void");
    }

    /* renamed from: a */
    private final void m45661a(PrintStream printStream, List<StackTraceElement> list) {
        for (StackTraceElement stringPlus : list) {
            printStream.print(Intrinsics.stringPlus("\n\tat ", stringPlus));
        }
    }

    public final List<StackTraceElement> enhanceStackTraceWithThreadDump(DebugCoroutineInfo debugCoroutineInfo, List<StackTraceElement> list) {
        return m45651a(debugCoroutineInfo.getState(), debugCoroutineInfo.getLastObservedThread(), list);
    }

    /* renamed from: a */
    private final List<StackTraceElement> m45651a(String str, Thread thread, List<StackTraceElement> list) {
        Object obj;
        if (!Intrinsics.areEqual((Object) str, (Object) DebugCoroutineInfoImplKt.RUNNING) || thread == null) {
            return list;
        }
        try {
            Result.Companion companion = Result.Companion;
            DebugProbesImpl debugProbesImpl = this;
            obj = Result.m47688constructorimpl(thread.getStackTrace());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m47688constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m47694isFailureimpl(obj)) {
            obj = null;
        }
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) obj;
        if (stackTraceElementArr == null) {
            return list;
        }
        int length = stackTraceElementArr.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            }
            StackTraceElement stackTraceElement = stackTraceElementArr[i2];
            if (Intrinsics.areEqual((Object) stackTraceElement.getClassName(), (Object) "kotlin.coroutines.jvm.internal.BaseContinuationImpl") && Intrinsics.areEqual((Object) stackTraceElement.getMethodName(), (Object) "resumeWith") && Intrinsics.areEqual((Object) stackTraceElement.getFileName(), (Object) "ContinuationImpl.kt")) {
                break;
            }
            i2++;
        }
        Pair<Integer, Integer> a = m45655a(i2, stackTraceElementArr, list);
        int intValue = a.component1().intValue();
        int intValue2 = a.component2().intValue();
        if (intValue == -1) {
            return list;
        }
        ArrayList arrayList = new ArrayList((((list.size() + i2) - intValue) - 1) - intValue2);
        int i3 = i2 - intValue2;
        if (i3 > 0) {
            while (true) {
                int i4 = i + 1;
                arrayList.add(stackTraceElementArr[i]);
                if (i4 >= i3) {
                    break;
                }
                i = i4;
            }
        }
        int i5 = intValue + 1;
        int size = list.size();
        if (i5 < size) {
            while (true) {
                int i6 = i5 + 1;
                arrayList.add(list.get(i5));
                if (i6 >= size) {
                    break;
                }
                i5 = i6;
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private final Pair<Integer, Integer> m45655a(int i, StackTraceElement[] stackTraceElementArr, List<StackTraceElement> list) {
        for (int i2 = 0; i2 < 3; i2++) {
            int b = INSTANCE.m45668b((i - 1) - i2, stackTraceElementArr, list);
            if (b != -1) {
                return TuplesKt.m42317to(Integer.valueOf(b), Integer.valueOf(i2));
            }
        }
        return TuplesKt.m42317to(-1, 0);
    }

    /* renamed from: b */
    private final int m45668b(int i, StackTraceElement[] stackTraceElementArr, List<StackTraceElement> list) {
        StackTraceElement stackTraceElement = (StackTraceElement) ArraysKt.getOrNull((T[]) stackTraceElementArr, i);
        if (stackTraceElement == null) {
            return -1;
        }
        int i2 = 0;
        for (StackTraceElement next : list) {
            if (Intrinsics.areEqual((Object) next.getFileName(), (Object) stackTraceElement.getFileName()) && Intrinsics.areEqual((Object) next.getClassName(), (Object) stackTraceElement.getClassName()) && Intrinsics.areEqual((Object) next.getMethodName(), (Object) stackTraceElement.getMethodName())) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public final void probeCoroutineResumed$kotlinx_coroutines_core(Continuation<?> continuation) {
        m45662a(continuation, DebugCoroutineInfoImplKt.RUNNING);
    }

    public final void probeCoroutineSuspended$kotlinx_coroutines_core(Continuation<?> continuation) {
        m45662a(continuation, DebugCoroutineInfoImplKt.SUSPENDED);
    }

    /* renamed from: a */
    private final void m45662a(Continuation<?> continuation, String str) {
        if (isInstalled$kotlinx_coroutines_core()) {
            if (!Intrinsics.areEqual((Object) str, (Object) DebugCoroutineInfoImplKt.RUNNING) || !KotlinVersion.CURRENT.isAtLeast(1, 3, 30)) {
                CoroutineOwner<?> a = m45658a(continuation);
                if (a != null) {
                    m45665a(a, continuation, str);
                    return;
                }
                return;
            }
            CoroutineStackFrame coroutineStackFrame = continuation instanceof CoroutineStackFrame ? (CoroutineStackFrame) continuation : null;
            if (coroutineStackFrame != null) {
                m45663a(coroutineStackFrame, str);
            }
        }
    }

    /* renamed from: a */
    private final void m45663a(CoroutineStackFrame coroutineStackFrame, String str) {
        ReentrantReadWriteLock.ReadLock readLock = f61431g.readLock();
        readLock.lock();
        try {
            if (INSTANCE.isInstalled$kotlinx_coroutines_core()) {
                DebugCoroutineInfoImpl remove = f61435k.remove(coroutineStackFrame);
                if (remove == null) {
                    CoroutineOwner<?> b = INSTANCE.m45670b(coroutineStackFrame);
                    if (b == null) {
                        readLock.unlock();
                        return;
                    }
                    remove = b.info;
                    CoroutineStackFrame lastObservedFrame$kotlinx_coroutines_core = remove.getLastObservedFrame$kotlinx_coroutines_core();
                    CoroutineStackFrame a = lastObservedFrame$kotlinx_coroutines_core == null ? null : INSTANCE.m45657a(lastObservedFrame$kotlinx_coroutines_core);
                    if (a != null) {
                        f61435k.remove(a);
                    }
                }
                remove.updateState$kotlinx_coroutines_core(str, (Continuation) coroutineStackFrame);
                CoroutineStackFrame a2 = INSTANCE.m45657a(coroutineStackFrame);
                if (a2 == null) {
                    readLock.unlock();
                    return;
                }
                f61435k.put(a2, remove);
                Unit unit = Unit.INSTANCE;
                readLock.unlock();
            }
        } finally {
            readLock.unlock();
        }
    }

    /* renamed from: a */
    private final CoroutineStackFrame m45657a(CoroutineStackFrame coroutineStackFrame) {
        do {
            coroutineStackFrame = coroutineStackFrame.getCallerFrame();
            if (coroutineStackFrame == null) {
                return null;
            }
        } while (coroutineStackFrame.getStackTraceElement() == null);
        return coroutineStackFrame;
    }

    /* renamed from: a */
    private final void m45665a(CoroutineOwner<?> coroutineOwner, Continuation<?> continuation, String str) {
        ReentrantReadWriteLock.ReadLock readLock = f61431g.readLock();
        readLock.lock();
        try {
            if (INSTANCE.isInstalled$kotlinx_coroutines_core()) {
                coroutineOwner.info.updateState$kotlinx_coroutines_core(str, continuation);
                Unit unit = Unit.INSTANCE;
                readLock.unlock();
            }
        } finally {
            readLock.unlock();
        }
    }

    /* renamed from: a */
    private final CoroutineOwner<?> m45658a(Continuation<?> continuation) {
        CoroutineStackFrame coroutineStackFrame = continuation instanceof CoroutineStackFrame ? (CoroutineStackFrame) continuation : null;
        if (coroutineStackFrame == null) {
            return null;
        }
        return m45670b(coroutineStackFrame);
    }

    /* renamed from: b */
    private final CoroutineOwner<?> m45670b(CoroutineStackFrame coroutineStackFrame) {
        while (!(coroutineStackFrame instanceof CoroutineOwner)) {
            coroutineStackFrame = coroutineStackFrame.getCallerFrame();
            if (coroutineStackFrame == null) {
                return null;
            }
        }
        return (CoroutineOwner) coroutineStackFrame;
    }

    public final <T> Continuation<T> probeCoroutineCreated$kotlinx_coroutines_core(Continuation<? super T> continuation) {
        StackTraceFrame stackTraceFrame;
        if (!isInstalled$kotlinx_coroutines_core() || m45658a((Continuation<?>) continuation) != null) {
            return continuation;
        }
        if (f61433i) {
            stackTraceFrame = m45659a(m45652a(new Exception()));
        } else {
            stackTraceFrame = null;
        }
        return m45656a(continuation, stackTraceFrame);
    }

    /* renamed from: a */
    private final <T> Continuation<T> m45656a(Continuation<? super T> continuation, StackTraceFrame stackTraceFrame) {
        if (!isInstalled$kotlinx_coroutines_core()) {
            return continuation;
        }
        CoroutineOwner coroutineOwner = new CoroutineOwner(continuation, new DebugCoroutineInfoImpl(continuation.getContext(), stackTraceFrame, f61430f.incrementAndGet(f61429e)), stackTraceFrame);
        f61428d.put(coroutineOwner, true);
        if (!isInstalled$kotlinx_coroutines_core()) {
            f61428d.clear();
        }
        return coroutineOwner;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m45672b(CoroutineOwner<?> coroutineOwner) {
        f61428d.remove(coroutineOwner);
        CoroutineStackFrame lastObservedFrame$kotlinx_coroutines_core = coroutineOwner.info.getLastObservedFrame$kotlinx_coroutines_core();
        CoroutineStackFrame a = lastObservedFrame$kotlinx_coroutines_core == null ? null : m45657a(lastObservedFrame$kotlinx_coroutines_core);
        if (a != null) {
            f61435k.remove(a);
        }
    }

    @Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B%\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001e\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, mo175978d2 = {"Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "T", "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "delegate", "info", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "frame", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "resumeWith", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "toString", "", "kotlinx-coroutines-core"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: DebugProbesImpl.kt */
    private static final class CoroutineOwner<T> implements Continuation<T>, CoroutineStackFrame {
        public final Continuation<T> delegate;
        private final CoroutineStackFrame frame;
        public final DebugCoroutineInfoImpl info;

        public CoroutineContext getContext() {
            return this.delegate.getContext();
        }

        public CoroutineOwner(Continuation<? super T> continuation, DebugCoroutineInfoImpl debugCoroutineInfoImpl, CoroutineStackFrame coroutineStackFrame) {
            this.delegate = continuation;
            this.info = debugCoroutineInfoImpl;
            this.frame = coroutineStackFrame;
        }

        public CoroutineStackFrame getCallerFrame() {
            CoroutineStackFrame coroutineStackFrame = this.frame;
            if (coroutineStackFrame == null) {
                return null;
            }
            return coroutineStackFrame.getCallerFrame();
        }

        public StackTraceElement getStackTraceElement() {
            CoroutineStackFrame coroutineStackFrame = this.frame;
            if (coroutineStackFrame == null) {
                return null;
            }
            return coroutineStackFrame.getStackTraceElement();
        }

        public void resumeWith(Object obj) {
            DebugProbesImpl.INSTANCE.m45672b((CoroutineOwner<?>) this);
            this.delegate.resumeWith(obj);
        }

        public String toString() {
            return this.delegate.toString();
        }
    }

    /* renamed from: a */
    private final <T extends Throwable> List<StackTraceElement> m45652a(T t) {
        int i;
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i2 = -1;
        int length2 = stackTrace.length - 1;
        while (true) {
            if (length2 < 0) {
                break;
            } else if (Intrinsics.areEqual((Object) stackTrace[length2].getClassName(), (Object) "kotlin.coroutines.jvm.internal.DebugProbesKt")) {
                i2 = length2;
                break;
            } else {
                length2--;
            }
        }
        if (!f61432h) {
            int i3 = length - i;
            ArrayList arrayList = new ArrayList(i3);
            int i4 = 0;
            while (i4 < i3) {
                arrayList.add(i4 == 0 ? StackTraceRecoveryKt.artificialFrame(f61425a) : stackTrace[i4 + i]);
                i4++;
            }
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList((length - i) + 1);
        Collection collection = arrayList2;
        collection.add(StackTraceRecoveryKt.artificialFrame(f61425a));
        while (true) {
            i++;
            while (i < length) {
                if (m45666a(stackTrace[i])) {
                    collection.add(stackTrace[i]);
                    int i5 = i + 1;
                    while (i5 < length && m45666a(stackTrace[i5])) {
                        i5++;
                    }
                    int i6 = i5 - 1;
                    int i7 = i6;
                    while (i7 > i && stackTrace[i7].getFileName() == null) {
                        i7--;
                    }
                    if (i7 > i && i7 < i6) {
                        collection.add(stackTrace[i7]);
                    }
                    collection.add(stackTrace[i6]);
                    i = i5;
                } else {
                    collection.add(stackTrace[i]);
                }
            }
            return arrayList2;
        }
    }

    /* renamed from: a */
    private final boolean m45666a(StackTraceElement stackTraceElement) {
        return StringsKt.startsWith$default(stackTraceElement.getClassName(), "kotlinx.coroutines", false, 2, (Object) null);
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final java.util.List<kotlinx.coroutines.debug.internal.DebugCoroutineInfo> dumpCoroutinesInfo() {
        /*
            r9 = this;
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = f61431g
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r0.readLock()
            int r2 = r0.getWriteHoldCount()
            r3 = 0
            if (r2 != 0) goto L_0x0014
            int r2 = r0.getReadHoldCount()
            goto L_0x0015
        L_0x0014:
            r2 = 0
        L_0x0015:
            r4 = 0
        L_0x0016:
            if (r4 >= r2) goto L_0x001e
            r1.unlock()
            int r4 = r4 + 1
            goto L_0x0016
        L_0x001e:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            kotlinx.coroutines.debug.internal.DebugProbesImpl r4 = INSTANCE     // Catch:{ all -> 0x0095 }
            boolean r4 = r4.isInstalled$kotlinx_coroutines_core()     // Catch:{ all -> 0x0095 }
            if (r4 == 0) goto L_0x0087
            kotlinx.coroutines.debug.internal.DebugProbesImpl r4 = INSTANCE     // Catch:{ all -> 0x0095 }
            java.util.Set r4 = r4.m45654a()     // Catch:{ all -> 0x0095 }
            java.lang.Iterable r4 = (java.lang.Iterable) r4     // Catch:{ all -> 0x0095 }
            kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesInfoImpl$lambda-14$$inlined$sortedBy$1 r5 = new kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesInfoImpl$lambda-14$$inlined$sortedBy$1     // Catch:{ all -> 0x0095 }
            r5.<init>()     // Catch:{ all -> 0x0095 }
            java.util.Comparator r5 = (java.util.Comparator) r5     // Catch:{ all -> 0x0095 }
            java.util.List r4 = kotlin.collections.CollectionsKt.sortedWith(r4, r5)     // Catch:{ all -> 0x0095 }
            java.lang.Iterable r4 = (java.lang.Iterable) r4     // Catch:{ all -> 0x0095 }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x0095 }
            r5.<init>()     // Catch:{ all -> 0x0095 }
            java.util.Collection r5 = (java.util.Collection) r5     // Catch:{ all -> 0x0095 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x0095 }
        L_0x004d:
            boolean r6 = r4.hasNext()     // Catch:{ all -> 0x0095 }
            if (r6 == 0) goto L_0x0079
            java.lang.Object r6 = r4.next()     // Catch:{ all -> 0x0095 }
            kotlinx.coroutines.debug.internal.DebugProbesImpl$CoroutineOwner r6 = (kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner) r6     // Catch:{ all -> 0x0095 }
            kotlinx.coroutines.debug.internal.DebugProbesImpl r7 = INSTANCE     // Catch:{ all -> 0x0095 }
            boolean r7 = r7.m45667a((kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner<?>) r6)     // Catch:{ all -> 0x0095 }
            r8 = 0
            if (r7 == 0) goto L_0x0063
            goto L_0x0073
        L_0x0063:
            kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl r7 = r6.info     // Catch:{ all -> 0x0095 }
            kotlin.coroutines.CoroutineContext r7 = r7.getContext()     // Catch:{ all -> 0x0095 }
            if (r7 != 0) goto L_0x006c
            goto L_0x0073
        L_0x006c:
            kotlinx.coroutines.debug.internal.DebugCoroutineInfo r8 = new kotlinx.coroutines.debug.internal.DebugCoroutineInfo     // Catch:{ all -> 0x0095 }
            kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl r6 = r6.info     // Catch:{ all -> 0x0095 }
            r8.<init>(r6, r7)     // Catch:{ all -> 0x0095 }
        L_0x0073:
            if (r8 == 0) goto L_0x004d
            r5.add(r8)     // Catch:{ all -> 0x0095 }
            goto L_0x004d
        L_0x0079:
            java.util.List r5 = (java.util.List) r5     // Catch:{ all -> 0x0095 }
        L_0x007b:
            if (r3 >= r2) goto L_0x0083
            r1.lock()
            int r3 = r3 + 1
            goto L_0x007b
        L_0x0083:
            r0.unlock()
            return r5
        L_0x0087:
            java.lang.String r4 = "Debug probes are not installed"
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0095 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0095 }
            r5.<init>(r4)     // Catch:{ all -> 0x0095 }
            java.lang.Throwable r5 = (java.lang.Throwable) r5     // Catch:{ all -> 0x0095 }
            throw r5     // Catch:{ all -> 0x0095 }
        L_0x0095:
            r4 = move-exception
        L_0x0096:
            if (r3 >= r2) goto L_0x009e
            r1.lock()
            int r3 = r3 + 1
            goto L_0x0096
        L_0x009e:
            r0.unlock()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugProbesImpl.dumpCoroutinesInfo():java.util.List");
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final java.util.List<kotlinx.coroutines.debug.internal.DebuggerInfo> dumpDebuggerInfo() {
        /*
            r9 = this;
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = f61431g
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r0.readLock()
            int r2 = r0.getWriteHoldCount()
            r3 = 0
            if (r2 != 0) goto L_0x0014
            int r2 = r0.getReadHoldCount()
            goto L_0x0015
        L_0x0014:
            r2 = 0
        L_0x0015:
            r4 = 0
        L_0x0016:
            if (r4 >= r2) goto L_0x001e
            r1.unlock()
            int r4 = r4 + 1
            goto L_0x0016
        L_0x001e:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            kotlinx.coroutines.debug.internal.DebugProbesImpl r4 = INSTANCE     // Catch:{ all -> 0x0095 }
            boolean r4 = r4.isInstalled$kotlinx_coroutines_core()     // Catch:{ all -> 0x0095 }
            if (r4 == 0) goto L_0x0087
            kotlinx.coroutines.debug.internal.DebugProbesImpl r4 = INSTANCE     // Catch:{ all -> 0x0095 }
            java.util.Set r4 = r4.m45654a()     // Catch:{ all -> 0x0095 }
            java.lang.Iterable r4 = (java.lang.Iterable) r4     // Catch:{ all -> 0x0095 }
            kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesInfoImpl$lambda-14$$inlined$sortedBy$1 r5 = new kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesInfoImpl$lambda-14$$inlined$sortedBy$1     // Catch:{ all -> 0x0095 }
            r5.<init>()     // Catch:{ all -> 0x0095 }
            java.util.Comparator r5 = (java.util.Comparator) r5     // Catch:{ all -> 0x0095 }
            java.util.List r4 = kotlin.collections.CollectionsKt.sortedWith(r4, r5)     // Catch:{ all -> 0x0095 }
            java.lang.Iterable r4 = (java.lang.Iterable) r4     // Catch:{ all -> 0x0095 }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x0095 }
            r5.<init>()     // Catch:{ all -> 0x0095 }
            java.util.Collection r5 = (java.util.Collection) r5     // Catch:{ all -> 0x0095 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x0095 }
        L_0x004d:
            boolean r6 = r4.hasNext()     // Catch:{ all -> 0x0095 }
            if (r6 == 0) goto L_0x0079
            java.lang.Object r6 = r4.next()     // Catch:{ all -> 0x0095 }
            kotlinx.coroutines.debug.internal.DebugProbesImpl$CoroutineOwner r6 = (kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner) r6     // Catch:{ all -> 0x0095 }
            kotlinx.coroutines.debug.internal.DebugProbesImpl r7 = INSTANCE     // Catch:{ all -> 0x0095 }
            boolean r7 = r7.m45667a((kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner<?>) r6)     // Catch:{ all -> 0x0095 }
            r8 = 0
            if (r7 == 0) goto L_0x0063
            goto L_0x0073
        L_0x0063:
            kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl r7 = r6.info     // Catch:{ all -> 0x0095 }
            kotlin.coroutines.CoroutineContext r7 = r7.getContext()     // Catch:{ all -> 0x0095 }
            if (r7 != 0) goto L_0x006c
            goto L_0x0073
        L_0x006c:
            kotlinx.coroutines.debug.internal.DebuggerInfo r8 = new kotlinx.coroutines.debug.internal.DebuggerInfo     // Catch:{ all -> 0x0095 }
            kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl r6 = r6.info     // Catch:{ all -> 0x0095 }
            r8.<init>(r6, r7)     // Catch:{ all -> 0x0095 }
        L_0x0073:
            if (r8 == 0) goto L_0x004d
            r5.add(r8)     // Catch:{ all -> 0x0095 }
            goto L_0x004d
        L_0x0079:
            java.util.List r5 = (java.util.List) r5     // Catch:{ all -> 0x0095 }
        L_0x007b:
            if (r3 >= r2) goto L_0x0083
            r1.lock()
            int r3 = r3 + 1
            goto L_0x007b
        L_0x0083:
            r0.unlock()
            return r5
        L_0x0087:
            java.lang.String r4 = "Debug probes are not installed"
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0095 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0095 }
            r5.<init>(r4)     // Catch:{ all -> 0x0095 }
            java.lang.Throwable r5 = (java.lang.Throwable) r5     // Catch:{ all -> 0x0095 }
            throw r5     // Catch:{ all -> 0x0095 }
        L_0x0095:
            r4 = move-exception
        L_0x0096:
            if (r3 >= r2) goto L_0x009e
            r1.lock()
            int r3 = r3 + 1
            goto L_0x0096
        L_0x009e:
            r0.unlock()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugProbesImpl.dumpDebuggerInfo():java.util.List");
    }

    /* renamed from: a */
    private final StackTraceFrame m45659a(List<StackTraceElement> list) {
        StackTraceFrame stackTraceFrame = null;
        if (!list.isEmpty()) {
            ListIterator<StackTraceElement> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                stackTraceFrame = new StackTraceFrame(stackTraceFrame, listIterator.previous());
            }
        }
        return stackTraceFrame;
    }
}
