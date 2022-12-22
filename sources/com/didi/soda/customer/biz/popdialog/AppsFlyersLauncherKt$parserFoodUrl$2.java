package com.didi.soda.customer.biz.popdialog;

import android.net.Uri;
import com.didi.soda.customer.biz.scheme.SchemeHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AppsFlyersLauncher.kt */
final class AppsFlyersLauncherKt$parserFoodUrl$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Uri.Builder $builder;
    final /* synthetic */ Function2<String, String, Unit> $track;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppsFlyersLauncherKt$parserFoodUrl$2(Uri.Builder builder, Function2<? super String, ? super String, Unit> function2) {
        super(0);
        this.$builder = builder;
        this.$track = function2;
    }

    public final void invoke() {
        try {
            Uri build = this.$builder.build();
            Function2<String, String, Unit> function2 = this.$track;
            String uri = build.toString();
            Intrinsics.checkNotNullExpressionValue(uri, "uri.toString()");
            function2.invoke(uri, "");
            SchemeHelper.dispatchMsg(build, true);
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
        }
    }
}
