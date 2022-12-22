package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: typeQualifiers.kt */
public final class JavaTypeQualifiers {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final JavaTypeQualifiers f60596e = new JavaTypeQualifiers((NullabilityQualifier) null, (MutabilityQualifier) null, false, false, 8, (DefaultConstructorMarker) null);

    /* renamed from: a */
    private final NullabilityQualifier f60597a;

    /* renamed from: b */
    private final MutabilityQualifier f60598b;

    /* renamed from: c */
    private final boolean f60599c;

    /* renamed from: d */
    private final boolean f60600d;

    public JavaTypeQualifiers(NullabilityQualifier nullabilityQualifier, MutabilityQualifier mutabilityQualifier, boolean z, boolean z2) {
        this.f60597a = nullabilityQualifier;
        this.f60598b = mutabilityQualifier;
        this.f60599c = z;
        this.f60600d = z2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JavaTypeQualifiers(NullabilityQualifier nullabilityQualifier, MutabilityQualifier mutabilityQualifier, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(nullabilityQualifier, mutabilityQualifier, z, (i & 8) != 0 ? false : z2);
    }

    public final NullabilityQualifier getNullability() {
        return this.f60597a;
    }

    public final MutabilityQualifier getMutability() {
        return this.f60598b;
    }

    public final boolean isNotNullTypeParameter() {
        return this.f60599c;
    }

    public final boolean isNullabilityQualifierForWarning() {
        return this.f60600d;
    }

    /* compiled from: typeQualifiers.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final JavaTypeQualifiers getNONE() {
            return JavaTypeQualifiers.f60596e;
        }
    }
}
