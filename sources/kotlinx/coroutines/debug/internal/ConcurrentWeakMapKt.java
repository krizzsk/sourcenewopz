package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.Symbol;

@Metadata(mo175977d1 = {"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0000\n\u0000\u001a\b\u0010\b\u001a\u00020\tH\u0002\u001a\u000e\u0010\n\u001a\u00020\u0003*\u0004\u0018\u00010\u000bH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo175978d2 = {"MAGIC", "", "MARKED_NULL", "Lkotlinx/coroutines/debug/internal/Marked;", "MARKED_TRUE", "MIN_CAPACITY", "REHASH", "Lkotlinx/coroutines/internal/Symbol;", "noImpl", "", "mark", "", "kotlinx-coroutines-core"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ConcurrentWeakMap.kt */
public final class ConcurrentWeakMapKt {

    /* renamed from: a */
    private static final int f61408a = -1640531527;

    /* renamed from: b */
    private static final int f61409b = 16;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final Symbol f61410c = new Symbol("REHASH");

    /* renamed from: d */
    private static final C21839a f61411d = new C21839a((Object) null);

    /* renamed from: e */
    private static final C21839a f61412e = new C21839a(true);

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final C21839a m45647a(Object obj) {
        if (obj == null) {
            return f61411d;
        }
        if (Intrinsics.areEqual(obj, (Object) true)) {
            return f61412e;
        }
        return new C21839a(obj);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final Void m45646a() {
        throw new UnsupportedOperationException("not implemented");
    }
}
