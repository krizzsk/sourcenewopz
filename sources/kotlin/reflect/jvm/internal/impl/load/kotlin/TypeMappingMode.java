package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* compiled from: TypeMappingMode.kt */
public final class TypeMappingMode {
    public static final TypeMappingMode CLASS_DECLARATION = new TypeMappingMode(false, true, false, false, false, GENERIC_ARGUMENT, false, (TypeMappingMode) null, (TypeMappingMode) null, false, 988, (DefaultConstructorMarker) null);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final TypeMappingMode DEFAULT = new TypeMappingMode(false, false, false, false, false, GENERIC_ARGUMENT, false, (TypeMappingMode) null, (TypeMappingMode) null, false, 988, (DefaultConstructorMarker) null);
    public static final TypeMappingMode DEFAULT_UAST = new TypeMappingMode(false, false, false, false, false, GENERIC_ARGUMENT_UAST, false, (TypeMappingMode) null, (TypeMappingMode) null, true, 476, (DefaultConstructorMarker) null);
    public static final TypeMappingMode GENERIC_ARGUMENT = new TypeMappingMode(false, false, false, false, false, (TypeMappingMode) null, false, (TypeMappingMode) null, (TypeMappingMode) null, false, 1023, (DefaultConstructorMarker) null);
    public static final TypeMappingMode GENERIC_ARGUMENT_UAST = new TypeMappingMode(false, false, false, false, false, (TypeMappingMode) null, false, (TypeMappingMode) null, (TypeMappingMode) null, true, 511, (DefaultConstructorMarker) null);
    public static final TypeMappingMode RETURN_TYPE_BOXED = new TypeMappingMode(false, true, false, false, false, (TypeMappingMode) null, false, (TypeMappingMode) null, (TypeMappingMode) null, false, 1021, (DefaultConstructorMarker) null);
    public static final TypeMappingMode SUPER_TYPE = new TypeMappingMode(false, false, false, true, false, GENERIC_ARGUMENT, false, (TypeMappingMode) null, (TypeMappingMode) null, false, 983, (DefaultConstructorMarker) null);
    public static final TypeMappingMode SUPER_TYPE_KOTLIN_COLLECTIONS_AS_IS = new TypeMappingMode(false, false, false, true, false, GENERIC_ARGUMENT, false, (TypeMappingMode) null, (TypeMappingMode) null, false, 919, (DefaultConstructorMarker) null);
    public static final TypeMappingMode VALUE_FOR_ANNOTATION = new TypeMappingMode(false, false, true, false, false, GENERIC_ARGUMENT, false, (TypeMappingMode) null, (TypeMappingMode) null, false, 984, (DefaultConstructorMarker) null);

    /* renamed from: a */
    private final boolean f60656a;

    /* renamed from: b */
    private final boolean f60657b;

    /* renamed from: c */
    private final boolean f60658c;

    /* renamed from: d */
    private final boolean f60659d;

    /* renamed from: e */
    private final boolean f60660e;

    /* renamed from: f */
    private final TypeMappingMode f60661f;

    /* renamed from: g */
    private final boolean f60662g;

    /* renamed from: h */
    private final TypeMappingMode f60663h;

    /* renamed from: i */
    private final TypeMappingMode f60664i;

    /* renamed from: j */
    private final boolean f60665j;

    /* compiled from: TypeMappingMode.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Variance.values().length];
            iArr[Variance.IN_VARIANCE.ordinal()] = 1;
            iArr[Variance.INVARIANT.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public TypeMappingMode() {
        this(false, false, false, false, false, (TypeMappingMode) null, false, (TypeMappingMode) null, (TypeMappingMode) null, false, 1023, (DefaultConstructorMarker) null);
    }

    public TypeMappingMode(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, TypeMappingMode typeMappingMode, boolean z6, TypeMappingMode typeMappingMode2, TypeMappingMode typeMappingMode3, boolean z7) {
        this.f60656a = z;
        this.f60657b = z2;
        this.f60658c = z3;
        this.f60659d = z4;
        this.f60660e = z5;
        this.f60661f = typeMappingMode;
        this.f60662g = z6;
        this.f60663h = typeMappingMode2;
        this.f60664i = typeMappingMode3;
        this.f60665j = z7;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TypeMappingMode(boolean r12, boolean r13, boolean r14, boolean r15, boolean r16, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode r17, boolean r18, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode r19, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode r20, boolean r21, int r22, kotlin.jvm.internal.DefaultConstructorMarker r23) {
        /*
            r11 = this;
            r0 = r22
            r1 = r0 & 1
            r2 = 1
            if (r1 == 0) goto L_0x0009
            r1 = 1
            goto L_0x000a
        L_0x0009:
            r1 = r12
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 1
            goto L_0x0011
        L_0x0010:
            r3 = r13
        L_0x0011:
            r4 = r0 & 4
            r5 = 0
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x0019
        L_0x0018:
            r4 = r14
        L_0x0019:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x001f
            r6 = 0
            goto L_0x0020
        L_0x001f:
            r6 = r15
        L_0x0020:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0026
            r7 = 0
            goto L_0x0028
        L_0x0026:
            r7 = r16
        L_0x0028:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x002e
            r8 = 0
            goto L_0x0030
        L_0x002e:
            r8 = r17
        L_0x0030:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0035
            goto L_0x0037
        L_0x0035:
            r2 = r18
        L_0x0037:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003d
            r9 = r8
            goto L_0x003f
        L_0x003d:
            r9 = r19
        L_0x003f:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0045
            r10 = r8
            goto L_0x0047
        L_0x0045:
            r10 = r20
        L_0x0047:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x004c
            goto L_0x004e
        L_0x004c:
            r5 = r21
        L_0x004e:
            r12 = r11
            r13 = r1
            r14 = r3
            r15 = r4
            r16 = r6
            r17 = r7
            r18 = r8
            r19 = r2
            r20 = r9
            r21 = r10
            r22 = r5
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode.<init>(boolean, boolean, boolean, boolean, boolean, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode, boolean, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final boolean getNeedPrimitiveBoxing() {
        return this.f60656a;
    }

    public final boolean getNeedInlineClassWrapping() {
        return this.f60657b;
    }

    public final boolean isForAnnotationParameter() {
        return this.f60658c;
    }

    public final boolean getKotlinCollectionsToJavaCollections() {
        return this.f60662g;
    }

    public final boolean getMapTypeAliases() {
        return this.f60665j;
    }

    /* compiled from: TypeMappingMode.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final TypeMappingMode toGenericArgumentMode(Variance variance, boolean z) {
        Intrinsics.checkNotNullParameter(variance, "effectiveVariance");
        if (!z || !this.f60658c) {
            int i = WhenMappings.$EnumSwitchMapping$0[variance.ordinal()];
            if (i == 1) {
                TypeMappingMode typeMappingMode = this.f60663h;
                if (typeMappingMode != null) {
                    return typeMappingMode;
                }
            } else if (i != 2) {
                TypeMappingMode typeMappingMode2 = this.f60661f;
                if (typeMappingMode2 != null) {
                    return typeMappingMode2;
                }
            } else {
                TypeMappingMode typeMappingMode3 = this.f60664i;
                if (typeMappingMode3 != null) {
                    return typeMappingMode3;
                }
            }
        }
        return this;
    }

    public final TypeMappingMode wrapInlineClassesMode() {
        return new TypeMappingMode(this.f60656a, true, this.f60658c, this.f60659d, this.f60660e, this.f60661f, this.f60662g, this.f60663h, this.f60664i, false, 512, (DefaultConstructorMarker) null);
    }
}
