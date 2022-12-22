package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import com.didi.soda.blocks.constant.TrackConst;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;

/* compiled from: annotationUtil.kt */
public final class AnnotationUtilKt {

    /* renamed from: a */
    private static final Name f60194a;

    /* renamed from: b */
    private static final Name f60195b;

    /* renamed from: c */
    private static final Name f60196c;

    /* renamed from: d */
    private static final Name f60197d;

    /* renamed from: e */
    private static final Name f60198e;

    public static /* synthetic */ AnnotationDescriptor createDeprecatedAnnotation$default(KotlinBuiltIns kotlinBuiltIns, String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        if ((i & 4) != 0) {
            str3 = "WARNING";
        }
        return createDeprecatedAnnotation(kotlinBuiltIns, str, str2, str3);
    }

    public static final AnnotationDescriptor createDeprecatedAnnotation(KotlinBuiltIns kotlinBuiltIns, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(kotlinBuiltIns, "<this>");
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(str2, "replaceWith");
        Intrinsics.checkNotNullParameter(str3, "level");
        BuiltInAnnotationDescriptor builtInAnnotationDescriptor = new BuiltInAnnotationDescriptor(kotlinBuiltIns, StandardNames.FqNames.replaceWith, MapsKt.mapOf(TuplesKt.m42317to(f60197d, new StringValue(str2)), TuplesKt.m42317to(f60198e, new ArrayValue(CollectionsKt.emptyList(), new C21562xf14e0c1a(kotlinBuiltIns)))));
        FqName fqName = StandardNames.FqNames.deprecated;
        Name name = f60196c;
        ClassId classId = ClassId.topLevel(StandardNames.FqNames.deprecationLevel);
        Intrinsics.checkNotNullExpressionValue(classId, "topLevel(StandardNames.FqNames.deprecationLevel)");
        Name identifier = Name.identifier(str3);
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(level)");
        return new BuiltInAnnotationDescriptor(kotlinBuiltIns, fqName, MapsKt.mapOf(TuplesKt.m42317to(f60194a, new StringValue(str)), TuplesKt.m42317to(f60195b, new AnnotationValue(builtInAnnotationDescriptor)), TuplesKt.m42317to(name, new EnumValue(classId, identifier))));
    }

    static {
        Name identifier = Name.identifier("message");
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(\"message\")");
        f60194a = identifier;
        Name identifier2 = Name.identifier("replaceWith");
        Intrinsics.checkNotNullExpressionValue(identifier2, "identifier(\"replaceWith\")");
        f60195b = identifier2;
        Name identifier3 = Name.identifier("level");
        Intrinsics.checkNotNullExpressionValue(identifier3, "identifier(\"level\")");
        f60196c = identifier3;
        Name identifier4 = Name.identifier(TrackConst.Params.EXPRESSION);
        Intrinsics.checkNotNullExpressionValue(identifier4, "identifier(\"expression\")");
        f60197d = identifier4;
        Name identifier5 = Name.identifier("imports");
        Intrinsics.checkNotNullExpressionValue(identifier5, "identifier(\"imports\")");
        f60198e = identifier5;
    }
}
