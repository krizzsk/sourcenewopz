package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.Symbol;

@Metadata(mo175977d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016*\u0004\u0018\u00010\u0016H\u0000\u001a\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0016*\u0004\u0018\u00010\u0016H\u0000\"\u0016\u0010\u0000\u001a\u00020\u00018\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u00018\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0003\"\u0016\u0010\u0006\u001a\u00020\u00018\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0003\"\u0016\u0010\b\u001a\u00020\t8\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u0003\"\u0016\u0010\u000b\u001a\u00020\t8\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\u0003\"\u000e\u0010\r\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000\"\u0016\u0010\u0010\u001a\u00020\u00018\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0003\"\u0016\u0010\u0012\u001a\u00020\u00018\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0003\"\u000e\u0010\u0014\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo175978d2 = {"COMPLETING_ALREADY", "Lkotlinx/coroutines/internal/Symbol;", "getCOMPLETING_ALREADY$annotations", "()V", "COMPLETING_RETRY", "getCOMPLETING_RETRY$annotations", "COMPLETING_WAITING_CHILDREN", "getCOMPLETING_WAITING_CHILDREN$annotations", "EMPTY_ACTIVE", "Lkotlinx/coroutines/Empty;", "getEMPTY_ACTIVE$annotations", "EMPTY_NEW", "getEMPTY_NEW$annotations", "FALSE", "", "RETRY", "SEALED", "getSEALED$annotations", "TOO_LATE_TO_CANCEL", "getTOO_LATE_TO_CANCEL$annotations", "TRUE", "boxIncomplete", "", "unboxState", "kotlinx-coroutines-core"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: JobSupport.kt */
public final class JobSupportKt {
    public static final Symbol COMPLETING_WAITING_CHILDREN = new Symbol("COMPLETING_WAITING_CHILDREN");
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Symbol f61347a = new Symbol("COMPLETING_ALREADY");
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final Symbol f61348b = new Symbol("COMPLETING_RETRY");
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final Symbol f61349c = new Symbol("TOO_LATE_TO_CANCEL");

    /* renamed from: d */
    private static final int f61350d = -1;

    /* renamed from: e */
    private static final int f61351e = 0;

    /* renamed from: f */
    private static final int f61352f = 1;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static final Symbol f61353g = new Symbol("SEALED");
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static final C21984m f61354h = new C21984m(false);
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static final C21984m f61355i = new C21984m(true);

    /* renamed from: a */
    private static /* synthetic */ void m45514a() {
    }

    /* renamed from: b */
    private static /* synthetic */ void m45515b() {
    }

    /* renamed from: c */
    private static /* synthetic */ void m45516c() {
    }

    /* renamed from: d */
    private static /* synthetic */ void m45517d() {
    }

    /* renamed from: e */
    private static /* synthetic */ void m45518e() {
    }

    /* renamed from: f */
    private static /* synthetic */ void m45519f() {
    }

    public static /* synthetic */ void getCOMPLETING_WAITING_CHILDREN$annotations() {
    }

    public static final Object boxIncomplete(Object obj) {
        return obj instanceof Incomplete ? new C21985n((Incomplete) obj) : obj;
    }

    public static final Object unboxState(Object obj) {
        C21985n nVar = obj instanceof C21985n ? (C21985n) obj : null;
        return nVar == null ? obj : nVar.f61566a;
    }
}
