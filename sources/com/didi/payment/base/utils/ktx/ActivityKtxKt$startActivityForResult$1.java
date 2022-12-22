package com.didi.payment.base.utils.ktx;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\n"}, mo175978d2 = {"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ActivityKtx.kt */
final class ActivityKtxKt$startActivityForResult$1 extends Lambda implements Function3<Integer, Integer, Intent, Unit> {
    final /* synthetic */ int $currentRequestCode;
    final /* synthetic */ Function2<Integer, Intent, Unit> $onActivityResult;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ActivityKtxKt$startActivityForResult$1(int i, Function2<? super Integer, ? super Intent, Unit> function2) {
        super(3);
        this.$currentRequestCode = i;
        this.$onActivityResult = function2;
    }

    public /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke(((Number) obj).intValue(), ((Number) obj2).intValue(), (Intent) obj3);
        return Unit.INSTANCE;
    }

    public final void invoke(int i, int i2, Intent intent) {
        if (i == this.$currentRequestCode) {
            this.$onActivityResult.invoke(Integer.valueOf(i2), intent);
        }
    }
}
