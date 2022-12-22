package kotlin.reflect.jvm.internal.impl.types;

import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext;
import kotlin.reflect.jvm.internal.impl.types.model.ArgumentList;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariableTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;

/* compiled from: AbstractTypeChecker.kt */
public final class AbstractTypeChecker {
    public static final AbstractTypeChecker INSTANCE = new AbstractTypeChecker();
    public static boolean RUN_SLOW_ASSERTIONS;

    /* compiled from: AbstractTypeChecker.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[TypeVariance.values().length];
            iArr[TypeVariance.INV.ordinal()] = 1;
            iArr[TypeVariance.OUT.ordinal()] = 2;
            iArr[TypeVariance.IN.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[AbstractTypeCheckerContext.LowerCapturedTypePolicy.values().length];
            iArr2[AbstractTypeCheckerContext.LowerCapturedTypePolicy.CHECK_ONLY_LOWER.ordinal()] = 1;
            iArr2[AbstractTypeCheckerContext.LowerCapturedTypePolicy.CHECK_SUBTYPE_AND_LOWER.ordinal()] = 2;
            iArr2[AbstractTypeCheckerContext.LowerCapturedTypePolicy.SKIP_LOWER.ordinal()] = 3;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    private AbstractTypeChecker() {
    }

    public static /* synthetic */ boolean isSubtypeOf$default(AbstractTypeChecker abstractTypeChecker, AbstractTypeCheckerContext abstractTypeCheckerContext, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        return abstractTypeChecker.isSubtypeOf(abstractTypeCheckerContext, kotlinTypeMarker, kotlinTypeMarker2, z);
    }

    public final boolean isSubtypeOf(AbstractTypeCheckerContext abstractTypeCheckerContext, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2, boolean z) {
        Intrinsics.checkNotNullParameter(abstractTypeCheckerContext, "context");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "subType");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker2, "superType");
        if (kotlinTypeMarker == kotlinTypeMarker2) {
            return true;
        }
        if (!abstractTypeCheckerContext.customIsSubtypeOf(kotlinTypeMarker, kotlinTypeMarker2)) {
            return false;
        }
        return m45014a(abstractTypeCheckerContext, kotlinTypeMarker, kotlinTypeMarker2, z);
    }

    public final boolean equalTypes(AbstractTypeCheckerContext abstractTypeCheckerContext, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2) {
        Intrinsics.checkNotNullParameter(abstractTypeCheckerContext, "context");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, Constants.FILE_ANR_KEY);
        Intrinsics.checkNotNullParameter(kotlinTypeMarker2, "b");
        TypeSystemContext typeSystemContext = abstractTypeCheckerContext.getTypeSystemContext();
        if (kotlinTypeMarker == kotlinTypeMarker2) {
            return true;
        }
        if (INSTANCE.m45017a(typeSystemContext, kotlinTypeMarker) && INSTANCE.m45017a(typeSystemContext, kotlinTypeMarker2)) {
            KotlinTypeMarker prepareType = abstractTypeCheckerContext.prepareType(abstractTypeCheckerContext.refineType(kotlinTypeMarker));
            KotlinTypeMarker prepareType2 = abstractTypeCheckerContext.prepareType(abstractTypeCheckerContext.refineType(kotlinTypeMarker2));
            SimpleTypeMarker lowerBoundIfFlexible = typeSystemContext.lowerBoundIfFlexible(prepareType);
            if (!typeSystemContext.areEqualTypeConstructors(typeSystemContext.typeConstructor(prepareType), typeSystemContext.typeConstructor(prepareType2))) {
                return false;
            }
            if (typeSystemContext.argumentsCount(lowerBoundIfFlexible) == 0) {
                if (typeSystemContext.hasFlexibleNullability(prepareType) || typeSystemContext.hasFlexibleNullability(prepareType2) || typeSystemContext.isMarkedNullable(lowerBoundIfFlexible) == typeSystemContext.isMarkedNullable(typeSystemContext.lowerBoundIfFlexible(prepareType2))) {
                    return true;
                }
                return false;
            }
        }
        if (!isSubtypeOf$default(INSTANCE, abstractTypeCheckerContext, kotlinTypeMarker, kotlinTypeMarker2, false, 8, (Object) null) || !isSubtypeOf$default(INSTANCE, abstractTypeCheckerContext, kotlinTypeMarker2, kotlinTypeMarker, false, 8, (Object) null)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private final boolean m45014a(AbstractTypeCheckerContext abstractTypeCheckerContext, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2, boolean z) {
        TypeSystemContext typeSystemContext = abstractTypeCheckerContext.getTypeSystemContext();
        KotlinTypeMarker prepareType = abstractTypeCheckerContext.prepareType(abstractTypeCheckerContext.refineType(kotlinTypeMarker));
        KotlinTypeMarker prepareType2 = abstractTypeCheckerContext.prepareType(abstractTypeCheckerContext.refineType(kotlinTypeMarker2));
        Boolean c = INSTANCE.m45023c(abstractTypeCheckerContext, typeSystemContext.lowerBoundIfFlexible(prepareType), typeSystemContext.upperBoundIfFlexible(prepareType2));
        if (c == null) {
            Boolean addSubtypeConstraint = abstractTypeCheckerContext.addSubtypeConstraint(prepareType, prepareType2, z);
            if (addSubtypeConstraint == null) {
                return INSTANCE.m45022b(abstractTypeCheckerContext, typeSystemContext.lowerBoundIfFlexible(prepareType), typeSystemContext.upperBoundIfFlexible(prepareType2));
            }
            return addSubtypeConstraint.booleanValue();
        }
        boolean booleanValue = c.booleanValue();
        abstractTypeCheckerContext.addSubtypeConstraint(prepareType, prepareType2, z);
        return booleanValue;
    }

    /* renamed from: a */
    private final Boolean m45010a(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        TypeSystemContext typeSystemContext = abstractTypeCheckerContext.getTypeSystemContext();
        if (!typeSystemContext.isIntegerLiteralType(simpleTypeMarker) && !typeSystemContext.isIntegerLiteralType(simpleTypeMarker2)) {
            return null;
        }
        if (typeSystemContext.isIntegerLiteralType(simpleTypeMarker) && typeSystemContext.isIntegerLiteralType(simpleTypeMarker2)) {
            return true;
        }
        if (typeSystemContext.isIntegerLiteralType(simpleTypeMarker)) {
            if (m45016a(typeSystemContext, abstractTypeCheckerContext, simpleTypeMarker, simpleTypeMarker2, false)) {
                return true;
            }
        } else if (typeSystemContext.isIntegerLiteralType(simpleTypeMarker2) && (m45019a(typeSystemContext, simpleTypeMarker) || m45016a(typeSystemContext, abstractTypeCheckerContext, simpleTypeMarker2, simpleTypeMarker, true))) {
            return true;
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0046, code lost:
        if (isSubtypeOf$default(INSTANCE, r11, r13, r6, false, 8, (java.lang.Object) null) != false) goto L_0x004b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004e A[SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final boolean m45016a(kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext r10, kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext r11, kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r12, kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r13, boolean r14) {
        /*
            java.util.Collection r12 = r10.possibleIntegerTypes(r12)
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            boolean r0 = r12 instanceof java.util.Collection
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0017
            r0 = r12
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0017
        L_0x0015:
            r1 = 0
            goto L_0x004e
        L_0x0017:
            java.util.Iterator r12 = r12.iterator()
        L_0x001b:
            boolean r0 = r12.hasNext()
            if (r0 == 0) goto L_0x0015
            java.lang.Object r0 = r12.next()
            r6 = r0
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r6 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r6
            kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker r0 = r10.typeConstructor((kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r6)
            kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker r3 = r10.typeConstructor((kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r13)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r3)
            if (r0 != 0) goto L_0x004b
            if (r14 == 0) goto L_0x0049
            kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker r3 = INSTANCE
            r5 = r13
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r5 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r5
            r7 = 0
            r8 = 8
            r9 = 0
            r4 = r11
            boolean r0 = isSubtypeOf$default(r3, r4, r5, r6, r7, r8, r9)
            if (r0 == 0) goto L_0x0049
            goto L_0x004b
        L_0x0049:
            r0 = 0
            goto L_0x004c
        L_0x004b:
            r0 = 1
        L_0x004c:
            if (r0 == 0) goto L_0x001b
        L_0x004e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker.m45016a(kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext, kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext, kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker, kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker, boolean):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final boolean m45019a(kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext r3, kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r4) {
        /*
            kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker r4 = r3.typeConstructor((kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r4)
            boolean r0 = r4 instanceof kotlin.reflect.jvm.internal.impl.types.model.IntersectionTypeConstructorMarker
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0044
            java.util.Collection r4 = r3.supertypes(r4)
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            boolean r0 = r4 instanceof java.util.Collection
            if (r0 == 0) goto L_0x001f
            r0 = r4
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x001f
        L_0x001d:
            r3 = 0
            goto L_0x0041
        L_0x001f:
            java.util.Iterator r4 = r4.iterator()
        L_0x0023:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x001d
            java.lang.Object r0 = r4.next()
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r0 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r0
            kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r0 = r3.asSimpleType(r0)
            if (r0 != 0) goto L_0x0037
        L_0x0035:
            r0 = 0
            goto L_0x003e
        L_0x0037:
            boolean r0 = r3.isIntegerLiteralType(r0)
            if (r0 != r1) goto L_0x0035
            r0 = 1
        L_0x003e:
            if (r0 == 0) goto L_0x0023
            r3 = 1
        L_0x0041:
            if (r3 == 0) goto L_0x0044
            goto L_0x0045
        L_0x0044:
            r1 = 0
        L_0x0045:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker.m45019a(kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker):boolean");
    }

    /* renamed from: a */
    private final boolean m45015a(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker) {
        AbstractTypeCheckerContext.SupertypesPolicy supertypesPolicy;
        TypeSystemContext typeSystemContext = abstractTypeCheckerContext.getTypeSystemContext();
        TypeConstructorMarker typeConstructor = typeSystemContext.typeConstructor(simpleTypeMarker);
        if (typeSystemContext.isClassTypeConstructor(typeConstructor)) {
            return typeSystemContext.isNothingConstructor(typeConstructor);
        }
        if (typeSystemContext.isNothingConstructor(typeSystemContext.typeConstructor(simpleTypeMarker))) {
            return true;
        }
        abstractTypeCheckerContext.initialize();
        ArrayDeque<SimpleTypeMarker> supertypesDeque = abstractTypeCheckerContext.getSupertypesDeque();
        Intrinsics.checkNotNull(supertypesDeque);
        Set<SimpleTypeMarker> supertypesSet = abstractTypeCheckerContext.getSupertypesSet();
        Intrinsics.checkNotNull(supertypesSet);
        supertypesDeque.push(simpleTypeMarker);
        while (!supertypesDeque.isEmpty()) {
            if (supertypesSet.size() <= 1000) {
                SimpleTypeMarker pop = supertypesDeque.pop();
                Intrinsics.checkNotNullExpressionValue(pop, "current");
                if (supertypesSet.add(pop)) {
                    if (typeSystemContext.isClassType(pop)) {
                        supertypesPolicy = AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE;
                    } else {
                        supertypesPolicy = AbstractTypeCheckerContext.SupertypesPolicy.LowerIfFlexible.INSTANCE;
                    }
                    if (!(!Intrinsics.areEqual((Object) supertypesPolicy, (Object) AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE))) {
                        supertypesPolicy = null;
                    }
                    if (supertypesPolicy == null) {
                        continue;
                    } else {
                        TypeSystemContext typeSystemContext2 = abstractTypeCheckerContext.getTypeSystemContext();
                        for (KotlinTypeMarker transformType : typeSystemContext2.supertypes(typeSystemContext2.typeConstructor(pop))) {
                            SimpleTypeMarker transformType2 = supertypesPolicy.transformType(abstractTypeCheckerContext, transformType);
                            if (typeSystemContext.isNothingConstructor(typeSystemContext.typeConstructor(transformType2))) {
                                abstractTypeCheckerContext.clear();
                                return true;
                            }
                            supertypesDeque.add(transformType2);
                        }
                        continue;
                    }
                }
            } else {
                throw new IllegalStateException(("Too many supertypes for type: " + simpleTypeMarker + ". Supertypes = " + CollectionsKt.joinToString$default(supertypesSet, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null)).toString());
            }
        }
        abstractTypeCheckerContext.clear();
        return false;
    }

    /* renamed from: b */
    private final boolean m45022b(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        boolean z;
        TypeConstructorMarker typeConstructorMarker;
        TypeConstructorMarker typeConstructorMarker2;
        AbstractTypeCheckerContext abstractTypeCheckerContext2 = abstractTypeCheckerContext;
        SimpleTypeMarker simpleTypeMarker3 = simpleTypeMarker;
        SimpleTypeMarker simpleTypeMarker4 = simpleTypeMarker2;
        TypeSystemContext typeSystemContext = abstractTypeCheckerContext.getTypeSystemContext();
        if (RUN_SLOW_ASSERTIONS) {
            boolean z2 = typeSystemContext.isSingleClassifierType(simpleTypeMarker3) || typeSystemContext.isIntersection(typeSystemContext.typeConstructor(simpleTypeMarker3)) || abstractTypeCheckerContext2.isAllowedTypeVariableBridge(simpleTypeMarker3);
            if (!_Assertions.ENABLED || z2) {
                boolean z3 = typeSystemContext.isSingleClassifierType(simpleTypeMarker4) || abstractTypeCheckerContext2.isAllowedTypeVariableBridge(simpleTypeMarker4);
                if (_Assertions.ENABLED && !z3) {
                    throw new AssertionError(Intrinsics.stringPlus("Not singleClassifierType superType: ", simpleTypeMarker4));
                }
            } else {
                throw new AssertionError(Intrinsics.stringPlus("Not singleClassifierType and not intersection subType: ", simpleTypeMarker3));
            }
        }
        if (!AbstractNullabilityChecker.INSTANCE.isPossibleSubtype(abstractTypeCheckerContext2, simpleTypeMarker3, simpleTypeMarker4)) {
            return false;
        }
        KotlinTypeMarker kotlinTypeMarker = simpleTypeMarker3;
        KotlinTypeMarker kotlinTypeMarker2 = simpleTypeMarker4;
        Boolean a = INSTANCE.m45010a(abstractTypeCheckerContext2, typeSystemContext.lowerBoundIfFlexible(kotlinTypeMarker), typeSystemContext.upperBoundIfFlexible(kotlinTypeMarker2));
        if (a == null) {
            TypeConstructorMarker typeConstructor = typeSystemContext.typeConstructor(simpleTypeMarker4);
            if ((typeSystemContext.areEqualTypeConstructors(typeSystemContext.typeConstructor(simpleTypeMarker3), typeConstructor) && typeSystemContext.parametersCount(typeConstructor) == 0) || typeSystemContext.isAnyConstructor(typeSystemContext.typeConstructor(simpleTypeMarker4))) {
                return true;
            }
            Iterable<SimpleTypeMarker> findCorrespondingSupertypes = INSTANCE.findCorrespondingSupertypes(abstractTypeCheckerContext2, simpleTypeMarker3, typeConstructor);
            int i = 10;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(findCorrespondingSupertypes, 10));
            for (SimpleTypeMarker simpleTypeMarker5 : findCorrespondingSupertypes) {
                SimpleTypeMarker asSimpleType = typeSystemContext.asSimpleType(abstractTypeCheckerContext2.prepareType(simpleTypeMarker5));
                if (asSimpleType != null) {
                    simpleTypeMarker5 = asSimpleType;
                }
                arrayList.add(simpleTypeMarker5);
            }
            List list = (List) arrayList;
            int size = list.size();
            if (size == 0) {
                return INSTANCE.m45015a(abstractTypeCheckerContext2, simpleTypeMarker3);
            }
            if (size == 1) {
                return INSTANCE.isSubtypeForSameConstructor(abstractTypeCheckerContext2, typeSystemContext.asArgumentList((SimpleTypeMarker) CollectionsKt.first(list)), simpleTypeMarker4);
            }
            ArgumentList argumentList = new ArgumentList(typeSystemContext.parametersCount(typeConstructor));
            int parametersCount = typeSystemContext.parametersCount(typeConstructor);
            if (parametersCount > 0) {
                int i2 = 0;
                z = false;
                while (true) {
                    int i3 = i2 + 1;
                    z = z || typeSystemContext.getVariance(typeSystemContext.getParameter(typeConstructor, i2)) != TypeVariance.OUT;
                    if (z) {
                        typeConstructorMarker = typeConstructor;
                    } else {
                        Iterable<SimpleTypeMarker> iterable = list;
                        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, i));
                        for (SimpleTypeMarker simpleTypeMarker6 : iterable) {
                            TypeArgumentMarker argumentOrNull = typeSystemContext.getArgumentOrNull(simpleTypeMarker6, i2);
                            KotlinTypeMarker kotlinTypeMarker3 = null;
                            if (argumentOrNull == null) {
                                typeConstructorMarker2 = typeConstructor;
                            } else {
                                typeConstructorMarker2 = typeConstructor;
                                if (!(typeSystemContext.getVariance(argumentOrNull) == TypeVariance.INV)) {
                                    argumentOrNull = null;
                                }
                                if (argumentOrNull != null) {
                                    kotlinTypeMarker3 = typeSystemContext.getType(argumentOrNull);
                                }
                            }
                            KotlinTypeMarker kotlinTypeMarker4 = kotlinTypeMarker3;
                            if (kotlinTypeMarker4 != null) {
                                arrayList2.add(kotlinTypeMarker4);
                                typeConstructor = typeConstructorMarker2;
                            } else {
                                throw new IllegalStateException(("Incorrect type: " + simpleTypeMarker6 + ", subType: " + simpleTypeMarker3 + ", superType: " + simpleTypeMarker4).toString());
                            }
                        }
                        typeConstructorMarker = typeConstructor;
                        argumentList.add(typeSystemContext.asTypeArgument(typeSystemContext.intersectTypes((List) arrayList2)));
                    }
                    if (i3 >= parametersCount) {
                        break;
                    }
                    i2 = i3;
                    typeConstructor = typeConstructorMarker;
                    i = 10;
                }
            } else {
                z = false;
            }
            if (!z && INSTANCE.isSubtypeForSameConstructor(abstractTypeCheckerContext2, argumentList, simpleTypeMarker4)) {
                return true;
            }
            Iterable<SimpleTypeMarker> iterable2 = list;
            if (!(iterable2 instanceof Collection) || !((Collection) iterable2).isEmpty()) {
                for (SimpleTypeMarker asArgumentList : iterable2) {
                    if (INSTANCE.isSubtypeForSameConstructor(abstractTypeCheckerContext2, typeSystemContext.asArgumentList(asArgumentList), simpleTypeMarker4)) {
                        return true;
                    }
                }
            }
            return false;
        }
        boolean booleanValue = a.booleanValue();
        AbstractTypeCheckerContext.addSubtypeConstraint$default(abstractTypeCheckerContext, kotlinTypeMarker, kotlinTypeMarker2, false, 4, (Object) null);
        return booleanValue;
    }

    /* renamed from: a */
    private final boolean m45018a(TypeSystemContext typeSystemContext, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2, TypeConstructorMarker typeConstructorMarker) {
        TypeParameterMarker typeParameter;
        SimpleTypeMarker asSimpleType = typeSystemContext.asSimpleType(kotlinTypeMarker);
        if (!(asSimpleType instanceof CapturedTypeMarker)) {
            return false;
        }
        CapturedTypeMarker capturedTypeMarker = (CapturedTypeMarker) asSimpleType;
        if (typeSystemContext.isOldCapturedType(capturedTypeMarker) || !typeSystemContext.isStarProjection(typeSystemContext.projection(typeSystemContext.typeConstructor(capturedTypeMarker))) || typeSystemContext.captureStatus(capturedTypeMarker) != CaptureStatus.FOR_SUBTYPING) {
            return false;
        }
        TypeConstructorMarker typeConstructor = typeSystemContext.typeConstructor(kotlinTypeMarker2);
        TypeVariableTypeConstructorMarker typeVariableTypeConstructorMarker = typeConstructor instanceof TypeVariableTypeConstructorMarker ? (TypeVariableTypeConstructorMarker) typeConstructor : null;
        if (typeVariableTypeConstructorMarker == null || (typeParameter = typeSystemContext.getTypeParameter(typeVariableTypeConstructorMarker)) == null || !typeSystemContext.hasRecursiveBounds(typeParameter, typeConstructorMarker)) {
            return false;
        }
        return true;
    }

    public final boolean isSubtypeForSameConstructor(AbstractTypeCheckerContext abstractTypeCheckerContext, TypeArgumentListMarker typeArgumentListMarker, SimpleTypeMarker simpleTypeMarker) {
        boolean z;
        AbstractTypeCheckerContext abstractTypeCheckerContext2 = abstractTypeCheckerContext;
        TypeArgumentListMarker typeArgumentListMarker2 = typeArgumentListMarker;
        SimpleTypeMarker simpleTypeMarker2 = simpleTypeMarker;
        Intrinsics.checkNotNullParameter(abstractTypeCheckerContext2, "<this>");
        Intrinsics.checkNotNullParameter(typeArgumentListMarker2, "capturedSubArguments");
        Intrinsics.checkNotNullParameter(simpleTypeMarker2, "superType");
        TypeSystemContext typeSystemContext = abstractTypeCheckerContext.getTypeSystemContext();
        TypeConstructorMarker typeConstructor = typeSystemContext.typeConstructor(simpleTypeMarker2);
        int size = typeSystemContext.size(typeArgumentListMarker2);
        int parametersCount = typeSystemContext.parametersCount(typeConstructor);
        if (size == parametersCount) {
            KotlinTypeMarker kotlinTypeMarker = simpleTypeMarker2;
            if (size == typeSystemContext.argumentsCount(kotlinTypeMarker)) {
                if (parametersCount > 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i + 1;
                        TypeArgumentMarker argument = typeSystemContext.getArgument(kotlinTypeMarker, i);
                        if (!typeSystemContext.isStarProjection(argument)) {
                            KotlinTypeMarker type = typeSystemContext.getType(argument);
                            TypeArgumentMarker typeArgumentMarker = typeSystemContext.get(typeArgumentListMarker2, i);
                            boolean z2 = typeSystemContext.getVariance(typeArgumentMarker) == TypeVariance.INV;
                            if (!_Assertions.ENABLED || z2) {
                                KotlinTypeMarker type2 = typeSystemContext.getType(typeArgumentMarker);
                                TypeVariance effectiveVariance = INSTANCE.effectiveVariance(typeSystemContext.getVariance(typeSystemContext.getParameter(typeConstructor, i)), typeSystemContext.getVariance(argument));
                                if (effectiveVariance == null) {
                                    return abstractTypeCheckerContext.isErrorTypeEqualsToAnything();
                                }
                                if (!(effectiveVariance == TypeVariance.INV && (INSTANCE.m45018a(typeSystemContext, type2, type, typeConstructor) || INSTANCE.m45018a(typeSystemContext, type, type2, typeConstructor)))) {
                                    if (abstractTypeCheckerContext.f61084a <= 100) {
                                        abstractTypeCheckerContext2.f61084a = abstractTypeCheckerContext.f61084a + 1;
                                        int i3 = WhenMappings.$EnumSwitchMapping$0[effectiveVariance.ordinal()];
                                        if (i3 == 1) {
                                            z = INSTANCE.equalTypes(abstractTypeCheckerContext2, type2, type);
                                        } else if (i3 == 2) {
                                            z = isSubtypeOf$default(INSTANCE, abstractTypeCheckerContext, type2, type, false, 8, (Object) null);
                                        } else if (i3 == 3) {
                                            z = isSubtypeOf$default(INSTANCE, abstractTypeCheckerContext, type, type2, false, 8, (Object) null);
                                        } else {
                                            throw new NoWhenBranchMatchedException();
                                        }
                                        abstractTypeCheckerContext2.f61084a = abstractTypeCheckerContext.f61084a - 1;
                                        if (!z) {
                                            return false;
                                        }
                                    } else {
                                        throw new IllegalStateException(Intrinsics.stringPlus("Arguments depth is too high. Some related argument: ", type2).toString());
                                    }
                                }
                            } else {
                                throw new AssertionError(Intrinsics.stringPlus("Incorrect sub argument: ", typeArgumentMarker));
                            }
                        }
                        if (i2 >= parametersCount) {
                            break;
                        }
                        i = i2;
                    }
                }
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private final boolean m45017a(TypeSystemContext typeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
        return typeSystemContext.isDenotable(typeSystemContext.typeConstructor(kotlinTypeMarker)) && !typeSystemContext.isDynamic(kotlinTypeMarker) && !typeSystemContext.isDefinitelyNotNullType(kotlinTypeMarker) && Intrinsics.areEqual((Object) typeSystemContext.typeConstructor(typeSystemContext.lowerBoundIfFlexible(kotlinTypeMarker)), (Object) typeSystemContext.typeConstructor(typeSystemContext.upperBoundIfFlexible(kotlinTypeMarker)));
    }

    public final TypeVariance effectiveVariance(TypeVariance typeVariance, TypeVariance typeVariance2) {
        Intrinsics.checkNotNullParameter(typeVariance, "declared");
        Intrinsics.checkNotNullParameter(typeVariance2, "useSite");
        if (typeVariance == TypeVariance.INV) {
            return typeVariance2;
        }
        if (typeVariance2 == TypeVariance.INV || typeVariance == typeVariance2) {
            return typeVariance;
        }
        return null;
    }

    /* renamed from: a */
    private final boolean m45020a(TypeSystemContext typeSystemContext, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        SimpleTypeMarker simpleTypeMarker3;
        SimpleTypeMarker simpleTypeMarker4;
        DefinitelyNotNullTypeMarker asDefinitelyNotNullType = typeSystemContext.asDefinitelyNotNullType(simpleTypeMarker);
        if (asDefinitelyNotNullType == null || (simpleTypeMarker3 = typeSystemContext.original(asDefinitelyNotNullType)) == null) {
            simpleTypeMarker3 = simpleTypeMarker;
        }
        DefinitelyNotNullTypeMarker asDefinitelyNotNullType2 = typeSystemContext.asDefinitelyNotNullType(simpleTypeMarker2);
        if (asDefinitelyNotNullType2 == null || (simpleTypeMarker4 = typeSystemContext.original(asDefinitelyNotNullType2)) == null) {
            simpleTypeMarker4 = simpleTypeMarker2;
        }
        if (typeSystemContext.typeConstructor(simpleTypeMarker3) != typeSystemContext.typeConstructor(simpleTypeMarker4)) {
            return false;
        }
        if (!typeSystemContext.isDefinitelyNotNullType(simpleTypeMarker) && typeSystemContext.isDefinitelyNotNullType(simpleTypeMarker2)) {
            return false;
        }
        if (!typeSystemContext.isMarkedNullable(simpleTypeMarker) || typeSystemContext.isMarkedNullable(simpleTypeMarker2)) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0154, code lost:
        if (r11 != false) goto L_0x0156;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Boolean m45023c(kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext r18, kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r19, kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r20) {
        /*
            r17 = this;
            r0 = r19
            r1 = r20
            kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext r2 = r18.getTypeSystemContext()
            r10 = r0
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r10 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r10
            boolean r3 = r2.isError(r10)
            r11 = 0
            r12 = 1
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r12)
            if (r3 != 0) goto L_0x0177
            r14 = r1
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r14 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r14
            boolean r3 = r2.isError(r14)
            if (r3 == 0) goto L_0x0022
            goto L_0x0177
        L_0x0022:
            boolean r3 = r2.isStubTypeForBuilderInference(r0)
            if (r3 == 0) goto L_0x0042
            boolean r3 = r2.isStubTypeForBuilderInference(r1)
            if (r3 == 0) goto L_0x0042
            kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker r3 = INSTANCE
            boolean r0 = r3.m45020a((kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext) r2, (kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r0, (kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r1)
            if (r0 != 0) goto L_0x003c
            boolean r0 = r18.isStubTypeEqualsToAnything()
            if (r0 == 0) goto L_0x003d
        L_0x003c:
            r11 = 1
        L_0x003d:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r11)
            return r0
        L_0x0042:
            boolean r3 = r2.isStubType(r0)
            if (r3 != 0) goto L_0x016e
            boolean r3 = r2.isStubType(r1)
            if (r3 == 0) goto L_0x0050
            goto L_0x016e
        L_0x0050:
            kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker r3 = r2.asDefinitelyNotNullType(r1)
            if (r3 != 0) goto L_0x0057
            goto L_0x005d
        L_0x0057:
            kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r3 = r2.original(r3)
            if (r3 != 0) goto L_0x005e
        L_0x005d:
            r3 = r1
        L_0x005e:
            kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker r3 = r2.asCapturedType(r3)
            r15 = 0
            if (r3 != 0) goto L_0x0067
            r4 = r15
            goto L_0x006b
        L_0x0067:
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r4 = r2.lowerType(r3)
        L_0x006b:
            if (r3 == 0) goto L_0x00bf
            if (r4 == 0) goto L_0x00bf
            boolean r5 = r2.isMarkedNullable((kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r1)
            if (r5 == 0) goto L_0x007d
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r4 = r2.withNullability((kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r4, (boolean) r12)
        L_0x0079:
            r9 = r18
            r6 = r4
            goto L_0x0088
        L_0x007d:
            boolean r5 = r2.isDefinitelyNotNullType(r14)
            if (r5 == 0) goto L_0x0079
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r4 = r2.makeDefinitelyNotNullOrNotNull(r4)
            goto L_0x0079
        L_0x0088:
            kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext$LowerCapturedTypePolicy r3 = r9.getLowerCapturedTypePolicy(r0, r3)
            int[] r4 = kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker.WhenMappings.$EnumSwitchMapping$1
            int r3 = r3.ordinal()
            r3 = r4[r3]
            if (r3 == r12) goto L_0x00ad
            r4 = 2
            if (r3 == r4) goto L_0x009a
            goto L_0x00bf
        L_0x009a:
            kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker r3 = INSTANCE
            r7 = 0
            r8 = 8
            r16 = 0
            r4 = r18
            r5 = r10
            r9 = r16
            boolean r3 = isSubtypeOf$default(r3, r4, r5, r6, r7, r8, r9)
            if (r3 == 0) goto L_0x00bf
            return r13
        L_0x00ad:
            kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker r3 = INSTANCE
            r7 = 0
            r8 = 8
            r9 = 0
            r4 = r18
            r5 = r10
            boolean r0 = isSubtypeOf$default(r3, r4, r5, r6, r7, r8, r9)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            return r0
        L_0x00bf:
            kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker r3 = r2.typeConstructor((kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r1)
            boolean r4 = r2.isIntersection(r3)
            if (r4 == 0) goto L_0x011d
            boolean r0 = r2.isMarkedNullable((kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r1)
            r0 = r0 ^ r12
            boolean r4 = kotlin._Assertions.ENABLED
            if (r4 == 0) goto L_0x00e3
            if (r0 == 0) goto L_0x00d5
            goto L_0x00e3
        L_0x00d5:
            java.lang.String r0 = "Intersection type should not be marked nullable!: "
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r0, r1)
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>(r0)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x00e3:
            java.util.Collection r0 = r2.supertypes(r3)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r1 = r0 instanceof java.util.Collection
            if (r1 == 0) goto L_0x00f8
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x00f8
        L_0x00f6:
            r11 = 1
            goto L_0x0118
        L_0x00f8:
            java.util.Iterator r0 = r0.iterator()
        L_0x00fc:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00f6
            java.lang.Object r1 = r0.next()
            r6 = r1
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r6 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r6
            kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker r3 = INSTANCE
            r7 = 0
            r8 = 8
            r9 = 0
            r4 = r18
            r5 = r10
            boolean r1 = isSubtypeOf$default(r3, r4, r5, r6, r7, r8, r9)
            if (r1 != 0) goto L_0x00fc
        L_0x0118:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r11)
            return r0
        L_0x011d:
            kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker r3 = r2.typeConstructor((kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r0)
            boolean r0 = r0 instanceof kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker
            if (r0 != 0) goto L_0x0156
            boolean r0 = r2.isIntersection(r3)
            if (r0 == 0) goto L_0x016d
            java.util.Collection r0 = r2.supertypes(r3)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r3 = r0 instanceof java.util.Collection
            if (r3 == 0) goto L_0x0140
            r3 = r0
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x0140
        L_0x013e:
            r11 = 1
            goto L_0x0154
        L_0x0140:
            java.util.Iterator r0 = r0.iterator()
        L_0x0144:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x013e
            java.lang.Object r3 = r0.next()
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r3 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r3
            boolean r3 = r3 instanceof kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker
            if (r3 != 0) goto L_0x0144
        L_0x0154:
            if (r11 == 0) goto L_0x016d
        L_0x0156:
            kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker r0 = INSTANCE
            kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext r3 = r18.getTypeSystemContext()
            kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker r0 = r0.m45013a((kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext) r3, (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r14, (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r10)
            if (r0 == 0) goto L_0x016d
            kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker r1 = r2.typeConstructor((kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r1)
            boolean r0 = r2.hasRecursiveBounds(r0, r1)
            if (r0 == 0) goto L_0x016d
            return r13
        L_0x016d:
            return r15
        L_0x016e:
            boolean r0 = r18.isStubTypeEqualsToAnything()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            return r0
        L_0x0177:
            boolean r3 = r18.isErrorTypeEqualsToAnything()
            if (r3 == 0) goto L_0x017e
            return r13
        L_0x017e:
            boolean r3 = r2.isMarkedNullable((kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r0)
            if (r3 == 0) goto L_0x018f
            boolean r3 = r2.isMarkedNullable((kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r1)
            if (r3 != 0) goto L_0x018f
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r11)
            return r0
        L_0x018f:
            kotlin.reflect.jvm.internal.impl.types.AbstractStrictEqualityTypeChecker r3 = kotlin.reflect.jvm.internal.impl.types.AbstractStrictEqualityTypeChecker.INSTANCE
            kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r0 = r2.withNullability((kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r0, (boolean) r11)
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r0 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r0
            kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r1 = r2.withNullability((kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r1, (boolean) r11)
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r1 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r1
            boolean r0 = r3.strictEqualTypes(r2, r0, r1)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker.m45023c(kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext, kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker, kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker):java.lang.Boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0069, code lost:
        return r9.getParameter(r9.typeConstructor(r10), r3);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker m45013a(kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext r9, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r10, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r11) {
        /*
            r8 = this;
            int r0 = r9.argumentsCount(r10)
            r1 = 0
            if (r0 <= 0) goto L_0x006a
            r2 = 0
            r3 = 0
        L_0x0009:
            int r4 = r3 + 1
            kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker r5 = r9.getArgument(r10, r3)
            boolean r6 = r9.isStarProjection(r5)
            r7 = 1
            r6 = r6 ^ r7
            if (r6 == 0) goto L_0x0018
            goto L_0x0019
        L_0x0018:
            r5 = r1
        L_0x0019:
            if (r5 != 0) goto L_0x001d
            r5 = r1
            goto L_0x0021
        L_0x001d:
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r5 = r9.getType(r5)
        L_0x0021:
            if (r5 != 0) goto L_0x0024
            goto L_0x005b
        L_0x0024:
            kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r6 = r9.lowerBoundIfFlexible(r5)
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r6 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r6
            boolean r6 = r9.isCapturedType(r6)
            if (r6 == 0) goto L_0x003d
            kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r6 = r9.lowerBoundIfFlexible(r11)
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r6 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r6
            boolean r6 = r9.isCapturedType(r6)
            if (r6 == 0) goto L_0x003d
            goto L_0x003e
        L_0x003d:
            r7 = 0
        L_0x003e:
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r11)
            if (r6 != 0) goto L_0x0061
            if (r7 == 0) goto L_0x0055
            kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker r6 = r9.typeConstructor((kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r5)
            kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker r7 = r9.typeConstructor((kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r11)
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r6 == 0) goto L_0x0055
            goto L_0x0061
        L_0x0055:
            kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker r3 = r8.m45013a((kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext) r9, (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r5, (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r11)
            if (r3 != 0) goto L_0x0060
        L_0x005b:
            if (r4 < r0) goto L_0x005e
            goto L_0x006a
        L_0x005e:
            r3 = r4
            goto L_0x0009
        L_0x0060:
            return r3
        L_0x0061:
            kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker r10 = r9.typeConstructor((kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r10)
            kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker r9 = r9.getParameter(r10, r3)
            return r9
        L_0x006a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker.m45013a(kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker):kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker");
    }

    /* renamed from: a */
    private final List<SimpleTypeMarker> m45012a(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        AbstractTypeCheckerContext.SupertypesPolicy supertypesPolicy;
        AbstractTypeCheckerContext abstractTypeCheckerContext2 = abstractTypeCheckerContext;
        SimpleTypeMarker simpleTypeMarker2 = simpleTypeMarker;
        TypeConstructorMarker typeConstructorMarker2 = typeConstructorMarker;
        TypeSystemContext typeSystemContext = abstractTypeCheckerContext.getTypeSystemContext();
        List<SimpleTypeMarker> fastCorrespondingSupertypes = typeSystemContext.fastCorrespondingSupertypes(simpleTypeMarker2, typeConstructorMarker2);
        if (fastCorrespondingSupertypes == null) {
            if (!typeSystemContext.isClassTypeConstructor(typeConstructorMarker2) && typeSystemContext.isClassType(simpleTypeMarker2)) {
                return CollectionsKt.emptyList();
            }
            if (!typeSystemContext.isCommonFinalClassConstructor(typeConstructorMarker2)) {
                fastCorrespondingSupertypes = new SmartList<>();
                abstractTypeCheckerContext.initialize();
                ArrayDeque<SimpleTypeMarker> supertypesDeque = abstractTypeCheckerContext.getSupertypesDeque();
                Intrinsics.checkNotNull(supertypesDeque);
                Set<SimpleTypeMarker> supertypesSet = abstractTypeCheckerContext.getSupertypesSet();
                Intrinsics.checkNotNull(supertypesSet);
                supertypesDeque.push(simpleTypeMarker2);
                while (!supertypesDeque.isEmpty()) {
                    if (supertypesSet.size() <= 1000) {
                        SimpleTypeMarker pop = supertypesDeque.pop();
                        Intrinsics.checkNotNullExpressionValue(pop, "current");
                        if (supertypesSet.add(pop)) {
                            SimpleTypeMarker captureFromArguments = typeSystemContext.captureFromArguments(pop, CaptureStatus.FOR_SUBTYPING);
                            if (captureFromArguments == null) {
                                captureFromArguments = pop;
                            }
                            if (typeSystemContext.areEqualTypeConstructors(typeSystemContext.typeConstructor(captureFromArguments), typeConstructorMarker2)) {
                                fastCorrespondingSupertypes.add(captureFromArguments);
                                supertypesPolicy = AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE;
                            } else if (typeSystemContext.argumentsCount(captureFromArguments) == 0) {
                                supertypesPolicy = AbstractTypeCheckerContext.SupertypesPolicy.LowerIfFlexible.INSTANCE;
                            } else {
                                supertypesPolicy = abstractTypeCheckerContext2.substitutionSupertypePolicy(captureFromArguments);
                            }
                            if (!(!Intrinsics.areEqual((Object) supertypesPolicy, (Object) AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE))) {
                                supertypesPolicy = null;
                            }
                            if (supertypesPolicy != null) {
                                TypeSystemContext typeSystemContext2 = abstractTypeCheckerContext.getTypeSystemContext();
                                for (KotlinTypeMarker transformType : typeSystemContext2.supertypes(typeSystemContext2.typeConstructor(pop))) {
                                    supertypesDeque.add(supertypesPolicy.transformType(abstractTypeCheckerContext2, transformType));
                                }
                            }
                        }
                    } else {
                        throw new IllegalStateException(("Too many supertypes for type: " + simpleTypeMarker2 + ". Supertypes = " + CollectionsKt.joinToString$default(supertypesSet, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null)).toString());
                    }
                }
                abstractTypeCheckerContext.clear();
            } else if (!typeSystemContext.areEqualTypeConstructors(typeSystemContext.typeConstructor(simpleTypeMarker2), typeConstructorMarker2)) {
                return CollectionsKt.emptyList();
            } else {
                SimpleTypeMarker captureFromArguments2 = typeSystemContext.captureFromArguments(simpleTypeMarker2, CaptureStatus.FOR_SUBTYPING);
                if (captureFromArguments2 == null) {
                    captureFromArguments2 = simpleTypeMarker2;
                }
                return CollectionsKt.listOf(captureFromArguments2);
            }
        }
        return fastCorrespondingSupertypes;
    }

    /* renamed from: b */
    private final List<SimpleTypeMarker> m45021b(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        return m45011a(abstractTypeCheckerContext, (List<? extends SimpleTypeMarker>) m45012a(abstractTypeCheckerContext, simpleTypeMarker, typeConstructorMarker));
    }

    /* renamed from: a */
    private final List<SimpleTypeMarker> m45011a(AbstractTypeCheckerContext abstractTypeCheckerContext, List<? extends SimpleTypeMarker> list) {
        TypeSystemContext typeSystemContext = abstractTypeCheckerContext.getTypeSystemContext();
        if (list.size() < 2) {
            return list;
        }
        Collection arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            TypeArgumentListMarker asArgumentList = typeSystemContext.asArgumentList((SimpleTypeMarker) next);
            int size = typeSystemContext.size(asArgumentList);
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                if (!(typeSystemContext.asFlexibleType(typeSystemContext.getType(typeSystemContext.get(asArgumentList, i))) == null)) {
                    z = false;
                    break;
                }
                i++;
            }
            if (z) {
                arrayList.add(next);
            }
        }
        List<SimpleTypeMarker> list2 = (List) arrayList;
        return list2.isEmpty() ^ true ? list2 : list;
    }

    public final List<SimpleTypeMarker> findCorrespondingSupertypes(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        AbstractTypeCheckerContext.SupertypesPolicy supertypesPolicy;
        AbstractTypeCheckerContext abstractTypeCheckerContext2 = abstractTypeCheckerContext;
        SimpleTypeMarker simpleTypeMarker2 = simpleTypeMarker;
        TypeConstructorMarker typeConstructorMarker2 = typeConstructorMarker;
        Intrinsics.checkNotNullParameter(abstractTypeCheckerContext2, "context");
        Intrinsics.checkNotNullParameter(simpleTypeMarker2, "subType");
        Intrinsics.checkNotNullParameter(typeConstructorMarker2, "superConstructor");
        TypeSystemContext typeSystemContext = abstractTypeCheckerContext.getTypeSystemContext();
        if (typeSystemContext.isClassType(simpleTypeMarker2)) {
            return INSTANCE.m45021b(abstractTypeCheckerContext2, simpleTypeMarker2, typeConstructorMarker2);
        }
        if (!typeSystemContext.isClassTypeConstructor(typeConstructorMarker2) && !typeSystemContext.isIntegerLiteralTypeConstructor(typeConstructorMarker2)) {
            return INSTANCE.m45012a(abstractTypeCheckerContext2, simpleTypeMarker2, typeConstructorMarker2);
        }
        SmartList<SimpleTypeMarker> smartList = new SmartList<>();
        abstractTypeCheckerContext.initialize();
        ArrayDeque<SimpleTypeMarker> supertypesDeque = abstractTypeCheckerContext.getSupertypesDeque();
        Intrinsics.checkNotNull(supertypesDeque);
        Set<SimpleTypeMarker> supertypesSet = abstractTypeCheckerContext.getSupertypesSet();
        Intrinsics.checkNotNull(supertypesSet);
        supertypesDeque.push(simpleTypeMarker2);
        while (!supertypesDeque.isEmpty()) {
            if (supertypesSet.size() <= 1000) {
                SimpleTypeMarker pop = supertypesDeque.pop();
                Intrinsics.checkNotNullExpressionValue(pop, "current");
                if (supertypesSet.add(pop)) {
                    if (typeSystemContext.isClassType(pop)) {
                        smartList.add(pop);
                        supertypesPolicy = AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE;
                    } else {
                        supertypesPolicy = AbstractTypeCheckerContext.SupertypesPolicy.LowerIfFlexible.INSTANCE;
                    }
                    if (!(!Intrinsics.areEqual((Object) supertypesPolicy, (Object) AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE))) {
                        supertypesPolicy = null;
                    }
                    if (supertypesPolicy != null) {
                        TypeSystemContext typeSystemContext2 = abstractTypeCheckerContext.getTypeSystemContext();
                        for (KotlinTypeMarker transformType : typeSystemContext2.supertypes(typeSystemContext2.typeConstructor(pop))) {
                            supertypesDeque.add(supertypesPolicy.transformType(abstractTypeCheckerContext2, transformType));
                        }
                    }
                }
            } else {
                throw new IllegalStateException(("Too many supertypes for type: " + simpleTypeMarker2 + ". Supertypes = " + CollectionsKt.joinToString$default(supertypesSet, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null)).toString());
            }
        }
        abstractTypeCheckerContext.clear();
        Collection arrayList = new ArrayList();
        for (SimpleTypeMarker simpleTypeMarker3 : smartList) {
            AbstractTypeChecker abstractTypeChecker = INSTANCE;
            Intrinsics.checkNotNullExpressionValue(simpleTypeMarker3, "it");
            CollectionsKt.addAll(arrayList, abstractTypeChecker.m45021b(abstractTypeCheckerContext2, simpleTypeMarker3, typeConstructorMarker2));
        }
        return (List) arrayList;
    }
}
