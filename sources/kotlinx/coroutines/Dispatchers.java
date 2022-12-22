package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\f8FX\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0002\u001a\u0004\b\u0012\u0010\u0007¨\u0006\u0013"}, mo175978d2 = {"Lkotlinx/coroutines/Dispatchers;", "", "()V", "Default", "Lkotlinx/coroutines/CoroutineDispatcher;", "getDefault$annotations", "getDefault", "()Lkotlinx/coroutines/CoroutineDispatcher;", "IO", "getIO$annotations", "getIO", "Main", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "getMain$annotations", "getMain", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "Unconfined", "getUnconfined$annotations", "getUnconfined", "kotlinx-coroutines-core"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Dispatchers.kt */
public final class Dispatchers {
    public static final Dispatchers INSTANCE = new Dispatchers();

    /* renamed from: a */
    private static final CoroutineDispatcher f61325a = CoroutineContextKt.createDefaultDispatcher();

    /* renamed from: b */
    private static final CoroutineDispatcher f61326b = Unconfined.INSTANCE;

    /* renamed from: c */
    private static final CoroutineDispatcher f61327c = DefaultScheduler.INSTANCE.getIO();

    @JvmStatic
    public static /* synthetic */ void getDefault$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getIO$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getMain$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getUnconfined$annotations() {
    }

    private Dispatchers() {
    }

    public static final CoroutineDispatcher getDefault() {
        return f61325a;
    }

    public static final MainCoroutineDispatcher getMain() {
        return MainDispatcherLoader.dispatcher;
    }

    public static final CoroutineDispatcher getUnconfined() {
        return f61326b;
    }

    public static final CoroutineDispatcher getIO() {
        return f61327c;
    }
}
