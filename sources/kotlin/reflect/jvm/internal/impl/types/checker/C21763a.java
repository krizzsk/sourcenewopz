package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* renamed from: kotlin.reflect.jvm.internal.impl.types.checker.a */
/* compiled from: utils.kt */
final class C21763a {

    /* renamed from: a */
    private final KotlinType f61167a;

    /* renamed from: b */
    private final C21763a f61168b;

    public C21763a(KotlinType kotlinType, C21763a aVar) {
        Intrinsics.checkNotNullParameter(kotlinType, "type");
        this.f61167a = kotlinType;
        this.f61168b = aVar;
    }

    /* renamed from: a */
    public final KotlinType mo180135a() {
        return this.f61167a;
    }

    /* renamed from: b */
    public final C21763a mo180136b() {
        return this.f61168b;
    }
}
