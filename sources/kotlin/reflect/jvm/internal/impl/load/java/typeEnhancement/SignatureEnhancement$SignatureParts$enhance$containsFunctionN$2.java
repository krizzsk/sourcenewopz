package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.RawType;

/* compiled from: signatureEnhancement.kt */
final class SignatureEnhancement$SignatureParts$enhance$containsFunctionN$2 extends Lambda implements Function1<KotlinType, Boolean> {
    public static final SignatureEnhancement$SignatureParts$enhance$containsFunctionN$2 INSTANCE = new SignatureEnhancement$SignatureParts$enhance$containsFunctionN$2();

    SignatureEnhancement$SignatureParts$enhance$containsFunctionN$2() {
        super(1);
    }

    public final Boolean invoke(KotlinType kotlinType) {
        return Boolean.valueOf(kotlinType instanceof RawType);
    }
}
