package kotlin.reflect.jvm.internal.impl.types;

import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;

/* compiled from: AbstractStrictEqualityTypeChecker.kt */
public final class AbstractStrictEqualityTypeChecker {
    public static final AbstractStrictEqualityTypeChecker INSTANCE = new AbstractStrictEqualityTypeChecker();

    private AbstractStrictEqualityTypeChecker() {
    }

    public final boolean strictEqualTypes(TypeSystemContext typeSystemContext, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2) {
        Intrinsics.checkNotNullParameter(typeSystemContext, "context");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, Constants.FILE_ANR_KEY);
        Intrinsics.checkNotNullParameter(kotlinTypeMarker2, "b");
        return m45008a(typeSystemContext, kotlinTypeMarker, kotlinTypeMarker2);
    }

    /* renamed from: a */
    private final boolean m45008a(TypeSystemContext typeSystemContext, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2) {
        if (kotlinTypeMarker == kotlinTypeMarker2) {
            return true;
        }
        SimpleTypeMarker asSimpleType = typeSystemContext.asSimpleType(kotlinTypeMarker);
        SimpleTypeMarker asSimpleType2 = typeSystemContext.asSimpleType(kotlinTypeMarker2);
        if (asSimpleType != null && asSimpleType2 != null) {
            return m45009a(typeSystemContext, asSimpleType, asSimpleType2);
        }
        FlexibleTypeMarker asFlexibleType = typeSystemContext.asFlexibleType(kotlinTypeMarker);
        FlexibleTypeMarker asFlexibleType2 = typeSystemContext.asFlexibleType(kotlinTypeMarker2);
        if (asFlexibleType == null || asFlexibleType2 == null || !m45009a(typeSystemContext, typeSystemContext.lowerBound(asFlexibleType), typeSystemContext.lowerBound(asFlexibleType2)) || !m45009a(typeSystemContext, typeSystemContext.upperBound(asFlexibleType), typeSystemContext.upperBound(asFlexibleType2))) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private final boolean m45009a(TypeSystemContext typeSystemContext, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        int argumentsCount;
        KotlinTypeMarker kotlinTypeMarker = simpleTypeMarker;
        KotlinTypeMarker kotlinTypeMarker2 = simpleTypeMarker2;
        if (typeSystemContext.argumentsCount(kotlinTypeMarker) == typeSystemContext.argumentsCount(kotlinTypeMarker2) && typeSystemContext.isMarkedNullable(simpleTypeMarker) == typeSystemContext.isMarkedNullable(simpleTypeMarker2)) {
            if ((typeSystemContext.asDefinitelyNotNullType(simpleTypeMarker) == null) == (typeSystemContext.asDefinitelyNotNullType(simpleTypeMarker2) == null) && typeSystemContext.areEqualTypeConstructors(typeSystemContext.typeConstructor(simpleTypeMarker), typeSystemContext.typeConstructor(simpleTypeMarker2))) {
                if (!typeSystemContext.identicalArguments(simpleTypeMarker, simpleTypeMarker2) && (argumentsCount = typeSystemContext.argumentsCount(kotlinTypeMarker)) > 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i + 1;
                        TypeArgumentMarker argument = typeSystemContext.getArgument(kotlinTypeMarker, i);
                        TypeArgumentMarker argument2 = typeSystemContext.getArgument(kotlinTypeMarker2, i);
                        if (typeSystemContext.isStarProjection(argument) != typeSystemContext.isStarProjection(argument2)) {
                            return false;
                        }
                        if (!typeSystemContext.isStarProjection(argument) && (typeSystemContext.getVariance(argument) != typeSystemContext.getVariance(argument2) || !m45008a(typeSystemContext, typeSystemContext.getType(argument), typeSystemContext.getType(argument2)))) {
                            return false;
                        }
                        if (i2 >= argumentsCount) {
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
}
