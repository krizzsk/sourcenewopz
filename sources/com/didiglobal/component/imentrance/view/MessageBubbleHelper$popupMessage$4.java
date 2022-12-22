package com.didiglobal.component.imentrance.view;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "it", "Landroid/view/View;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: MessageBubbleHelper.kt */
final class MessageBubbleHelper$popupMessage$4 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ Function1<View, Unit> $onClick;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MessageBubbleHelper$popupMessage$4(Function1<? super View, Unit> function1) {
        super(1);
        this.$onClick = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "it");
        this.$onClick.invoke(view);
    }
}
