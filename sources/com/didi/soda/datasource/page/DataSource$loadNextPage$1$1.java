package com.didi.soda.datasource.page;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u0005*\u0002H\u0002H\n"}, mo175978d2 = {"<anonymous>", "", "Params", "Lcom/didi/soda/datasource/page/PageParams;", "Value", "Result"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DataSource.kt */
final class DataSource$loadNextPage$1$1 extends Lambda implements Function1<Params, Unit> {
    final /* synthetic */ Function1<Params, Unit> $it;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataSource$loadNextPage$1$1(Function1<? super Params, Unit> function1) {
        super(1);
        this.$it = function1;
    }

    public final void invoke(Params params) {
        Intrinsics.checkNotNullParameter(params, "$this$updateParams");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PageParams) obj);
        return Unit.INSTANCE;
    }
}
