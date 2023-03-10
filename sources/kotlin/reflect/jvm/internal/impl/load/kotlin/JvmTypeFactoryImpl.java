package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.NoWhenBranchMatchedException;
import kotlin._Assertions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.text.StringsKt;

/* compiled from: methodSignatureMapping.kt */
final class JvmTypeFactoryImpl implements JvmTypeFactory<JvmType> {

    /* renamed from: a */
    public static final JvmTypeFactoryImpl f60649a = new JvmTypeFactoryImpl();

    /* compiled from: methodSignatureMapping.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PrimitiveType.values().length];
            iArr[PrimitiveType.BOOLEAN.ordinal()] = 1;
            iArr[PrimitiveType.CHAR.ordinal()] = 2;
            iArr[PrimitiveType.BYTE.ordinal()] = 3;
            iArr[PrimitiveType.SHORT.ordinal()] = 4;
            iArr[PrimitiveType.INT.ordinal()] = 5;
            iArr[PrimitiveType.FLOAT.ordinal()] = 6;
            iArr[PrimitiveType.LONG.ordinal()] = 7;
            iArr[PrimitiveType.DOUBLE.ordinal()] = 8;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private JvmTypeFactoryImpl() {
    }

    /* renamed from: a */
    public JvmType boxType(JvmType jvmType) {
        Intrinsics.checkNotNullParameter(jvmType, "possiblyPrimitiveType");
        if (!(jvmType instanceof JvmType.Primitive)) {
            return jvmType;
        }
        JvmType.Primitive primitive = (JvmType.Primitive) jvmType;
        if (primitive.getJvmPrimitiveType() == null) {
            return jvmType;
        }
        String internalName = JvmClassName.byFqNameWithoutInnerClasses(primitive.getJvmPrimitiveType().getWrapperFqName()).getInternalName();
        Intrinsics.checkNotNullExpressionValue(internalName, "byFqNameWithoutInnerClas???apperFqName).internalName");
        return createObjectType(internalName);
    }

    /* renamed from: a */
    public JvmType createFromString(String str) {
        JvmPrimitiveType jvmPrimitiveType;
        Intrinsics.checkNotNullParameter(str, "representation");
        CharSequence charSequence = str;
        boolean z = false;
        boolean z2 = charSequence.length() > 0;
        if (!_Assertions.ENABLED || z2) {
            char charAt = str.charAt(0);
            JvmPrimitiveType[] values = JvmPrimitiveType.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    jvmPrimitiveType = null;
                    break;
                }
                jvmPrimitiveType = values[i];
                if (jvmPrimitiveType.getDesc().charAt(0) == charAt) {
                    break;
                }
                i++;
            }
            if (jvmPrimitiveType != null) {
                return new JvmType.Primitive(jvmPrimitiveType);
            }
            if (charAt == 'V') {
                return new JvmType.Primitive((JvmPrimitiveType) null);
            }
            if (charAt == '[') {
                String substring = str.substring(1);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                return new JvmType.Array(createFromString(substring));
            }
            if (charAt == 'L' && StringsKt.endsWith$default(charSequence, ';', false, 2, (Object) null)) {
                z = true;
            }
            if (!_Assertions.ENABLED || z) {
                String substring2 = str.substring(1, str.length() - 1);
                Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.Strin???ing(startIndex, endIndex)");
                return new JvmType.Object(substring2);
            }
            throw new AssertionError("Type that is not primitive nor array should be Object, but '" + str + "' was found");
        }
        throw new AssertionError("empty string as JvmType");
    }

    /* renamed from: a */
    public JvmType createPrimitiveType(PrimitiveType primitiveType) {
        Intrinsics.checkNotNullParameter(primitiveType, "primitiveType");
        switch (WhenMappings.$EnumSwitchMapping$0[primitiveType.ordinal()]) {
            case 1:
                return JvmType.Companion.getBOOLEAN$descriptors_jvm();
            case 2:
                return JvmType.Companion.getCHAR$descriptors_jvm();
            case 3:
                return JvmType.Companion.getBYTE$descriptors_jvm();
            case 4:
                return JvmType.Companion.getSHORT$descriptors_jvm();
            case 5:
                return JvmType.Companion.getINT$descriptors_jvm();
            case 6:
                return JvmType.Companion.getFLOAT$descriptors_jvm();
            case 7:
                return JvmType.Companion.getLONG$descriptors_jvm();
            case 8:
                return JvmType.Companion.getDOUBLE$descriptors_jvm();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* renamed from: b */
    public JvmType.Object createObjectType(String str) {
        Intrinsics.checkNotNullParameter(str, "internalName");
        return new JvmType.Object(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002a, code lost:
        r3 = r3.getDesc();
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString(kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType r3) {
        /*
            r2 = this;
            java.lang.String r0 = "type"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            boolean r0 = r3 instanceof kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Array
            if (r0 == 0) goto L_0x001a
            kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType$Array r3 = (kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Array) r3
            kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType r3 = r3.getElementType()
            java.lang.String r3 = r2.toString((kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType) r3)
            java.lang.String r0 = "["
            java.lang.String r3 = kotlin.jvm.internal.Intrinsics.stringPlus(r0, r3)
            goto L_0x0051
        L_0x001a:
            boolean r0 = r3 instanceof kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Primitive
            if (r0 == 0) goto L_0x0031
            kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType$Primitive r3 = (kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Primitive) r3
            kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType r3 = r3.getJvmPrimitiveType()
            java.lang.String r0 = "V"
            if (r3 != 0) goto L_0x002a
        L_0x0028:
            r3 = r0
            goto L_0x0051
        L_0x002a:
            java.lang.String r3 = r3.getDesc()
            if (r3 != 0) goto L_0x0051
            goto L_0x0028
        L_0x0031:
            boolean r0 = r3 instanceof kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Object
            if (r0 == 0) goto L_0x0052
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 76
            r0.append(r1)
            kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType$Object r3 = (kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Object) r3
            java.lang.String r3 = r3.getInternalName()
            r0.append(r3)
            r3 = 59
            r0.append(r3)
            java.lang.String r3 = r0.toString()
        L_0x0051:
            return r3
        L_0x0052:
            kotlin.NoWhenBranchMatchedException r3 = new kotlin.NoWhenBranchMatchedException
            r3.<init>()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactoryImpl.toString(kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType):java.lang.String");
    }

    /* renamed from: a */
    public JvmType getJavaLangClassType() {
        return createObjectType("java/lang/Class");
    }
}
