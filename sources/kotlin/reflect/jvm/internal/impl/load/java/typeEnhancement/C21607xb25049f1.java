package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder;

/* renamed from: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$3$3 */
/* compiled from: predefinedEnhancementInfo.kt */
final class C21607xb25049f1 extends Lambda implements Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit> {
    final /* synthetic */ String $JUStream;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C21607xb25049f1(String str) {
        super(1);
        this.$JUStream = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
        Intrinsics.checkNotNullParameter(functionEnhancementBuilder, "$this$function");
        functionEnhancementBuilder.returns(this.$JUStream, PredefinedEnhancementInfoKt.f60605b, PredefinedEnhancementInfoKt.f60605b);
    }
}
