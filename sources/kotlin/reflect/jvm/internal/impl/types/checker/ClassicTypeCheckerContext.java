package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;

/* compiled from: ClassicTypeCheckerContext.kt */
public class ClassicTypeCheckerContext extends AbstractTypeCheckerContext {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private final boolean f61144a;

    /* renamed from: b */
    private final boolean f61145b;

    /* renamed from: c */
    private final boolean f61146c;

    /* renamed from: d */
    private final KotlinTypeRefiner f61147d;

    /* renamed from: e */
    private final KotlinTypePreparator f61148e;

    /* renamed from: f */
    private final ClassicTypeSystemContext f61149f;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ClassicTypeCheckerContext(boolean r6, boolean r7, boolean r8, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner r9, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator r10, kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r5 = this;
            r0 = r12 & 2
            r1 = 1
            if (r0 == 0) goto L_0x0007
            r0 = 1
            goto L_0x0008
        L_0x0007:
            r0 = r7
        L_0x0008:
            r2 = r12 & 4
            if (r2 == 0) goto L_0x000d
            goto L_0x000e
        L_0x000d:
            r1 = r8
        L_0x000e:
            r2 = r12 & 8
            if (r2 == 0) goto L_0x0017
            kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner$Default r2 = kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner.Default.INSTANCE
            kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner r2 = (kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner) r2
            goto L_0x0018
        L_0x0017:
            r2 = r9
        L_0x0018:
            r3 = r12 & 16
            if (r3 == 0) goto L_0x0021
            kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator$Default r3 = kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator.Default.INSTANCE
            kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator r3 = (kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator) r3
            goto L_0x0022
        L_0x0021:
            r3 = r10
        L_0x0022:
            r4 = r12 & 32
            if (r4 == 0) goto L_0x002b
            kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext r4 = kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext.INSTANCE
            kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext r4 = (kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext) r4
            goto L_0x002c
        L_0x002b:
            r4 = r11
        L_0x002c:
            r7 = r5
            r8 = r6
            r9 = r0
            r10 = r1
            r11 = r2
            r12 = r3
            r13 = r4
            r7.<init>(r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeCheckerContext.<init>(boolean, boolean, boolean, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator, kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public ClassicTypeSystemContext getTypeSystemContext() {
        return this.f61149f;
    }

    public ClassicTypeCheckerContext(boolean z, boolean z2, boolean z3, KotlinTypeRefiner kotlinTypeRefiner, KotlinTypePreparator kotlinTypePreparator, ClassicTypeSystemContext classicTypeSystemContext) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        Intrinsics.checkNotNullParameter(kotlinTypePreparator, "kotlinTypePreparator");
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "typeSystemContext");
        this.f61144a = z;
        this.f61145b = z2;
        this.f61146c = z3;
        this.f61147d = kotlinTypeRefiner;
        this.f61148e = kotlinTypePreparator;
        this.f61149f = classicTypeSystemContext;
    }

    public KotlinTypeMarker refineType(KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "type");
        if (kotlinTypeMarker instanceof KotlinType) {
            return this.f61147d.refineType((KotlinType) kotlinTypeMarker);
        }
        throw new IllegalArgumentException(ClassicTypeCheckerContextKt.m45069a(kotlinTypeMarker).toString());
    }

    public KotlinTypeMarker prepareType(KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "type");
        if (kotlinTypeMarker instanceof KotlinType) {
            return this.f61148e.prepareType(((KotlinType) kotlinTypeMarker).unwrap());
        }
        throw new IllegalArgumentException(ClassicTypeCheckerContextKt.m45069a(kotlinTypeMarker).toString());
    }

    public boolean isErrorTypeEqualsToAnything() {
        return this.f61144a;
    }

    public boolean isStubTypeEqualsToAnything() {
        return this.f61145b;
    }

    public AbstractTypeCheckerContext.SupertypesPolicy.DoCustomTransform substitutionSupertypePolicy(SimpleTypeMarker simpleTypeMarker) {
        Intrinsics.checkNotNullParameter(simpleTypeMarker, "type");
        return Companion.classicSubstitutionSupertypePolicy(getTypeSystemContext(), simpleTypeMarker);
    }

    public boolean isAllowedTypeVariable(KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
        return (kotlinTypeMarker instanceof UnwrappedType) && this.f61146c && (((UnwrappedType) kotlinTypeMarker).getConstructor() instanceof NewTypeVariableConstructor);
    }

    /* compiled from: ClassicTypeCheckerContext.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AbstractTypeCheckerContext.SupertypesPolicy.DoCustomTransform classicSubstitutionSupertypePolicy(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker) {
            Intrinsics.checkNotNullParameter(classicTypeSystemContext, "<this>");
            Intrinsics.checkNotNullParameter(simpleTypeMarker, "type");
            if (simpleTypeMarker instanceof SimpleType) {
                return new C21758x9ae7c99c(classicTypeSystemContext, TypeConstructorSubstitution.Companion.create((KotlinType) simpleTypeMarker).buildSubstitutor());
            }
            throw new IllegalArgumentException(ClassicTypeCheckerContextKt.m45069a(simpleTypeMarker).toString());
        }
    }
}
