package global.didi.pay.merchantcore.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \b2\u00060\u0001j\u0002`\u0002:\u0001\bB\u001b\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\t"}, mo175978d2 = {"Lglobal/didi/pay/merchantcore/exception/ModelSerializationException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "modelClass", "Ljava/lang/Class;", "cause", "Lorg/json/JSONException;", "(Ljava/lang/Class;Lorg/json/JSONException;)V", "Companion", "merchantCore_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ModelSerializationException.kt */
public final class ModelSerializationException extends RuntimeException {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ModelSerializationException(Class<?> cls, JSONException jSONException) {
        super("Unexpected exception while serializing " + cls.getSimpleName() + ".", jSONException);
        Intrinsics.checkParameterIsNotNull(cls, "modelClass");
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lglobal/didi/pay/merchantcore/exception/ModelSerializationException$Companion;", "", "()V", "serialVersionUID", "", "merchantCore_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: ModelSerializationException.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
