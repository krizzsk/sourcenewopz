package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KPackageImpl;

@Metadata(mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0012 \u0003*\b\u0018\u00010\u0001R\u00020\u00020\u0001R\u00020\u0002H\n¢\u0006\u0002\b\u0004"}, mo175978d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/KPackageImpl$Data;", "Lkotlin/reflect/jvm/internal/KPackageImpl;", "kotlin.jvm.PlatformType", "invoke"}, mo175979k = 3, mo175980mv = {1, 5, 1})
/* compiled from: KPackageImpl.kt */
final class KPackageImpl$data$1 extends Lambda implements Function0<KPackageImpl.Data> {
    final /* synthetic */ KPackageImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KPackageImpl$data$1(KPackageImpl kPackageImpl) {
        super(0);
        this.this$0 = kPackageImpl;
    }

    public final KPackageImpl.Data invoke() {
        return new KPackageImpl.Data();
    }
}
