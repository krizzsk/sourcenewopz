package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

@Metadata(mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo175978d2 = {"<anonymous>", "", "T", "", "invoke"}, mo175979k = 3, mo175980mv = {1, 5, 1})
/* compiled from: KClassImpl.kt */
final class KClassImpl$Data$simpleName$2 extends Lambda implements Function0<String> {
    final /* synthetic */ KClassImpl.Data this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KClassImpl$Data$simpleName$2(KClassImpl.Data data) {
        super(0);
        this.this$0 = data;
    }

    public final String invoke() {
        if (KClassImpl.this.getJClass().isAnonymousClass()) {
            return null;
        }
        ClassId access$getClassId$p = KClassImpl.this.m44431a();
        if (access$getClassId$p.isLocal()) {
            KClassImpl.Data data = this.this$0;
            return data.calculateLocalClassName(KClassImpl.this.getJClass());
        }
        String asString = access$getClassId$p.getShortClassName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "classId.shortClassName.asString()");
        return asString;
    }
}
