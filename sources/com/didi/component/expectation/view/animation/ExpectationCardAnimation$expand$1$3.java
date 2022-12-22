package com.didi.component.expectation.view.animation;

import androidx.transition.Transition;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "it", "Landroidx/transition/Transition;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ExpectationCardAnimation.kt */
final class ExpectationCardAnimation$expand$1$3 extends Lambda implements Function1<Transition, Unit> {
    final /* synthetic */ Function0<Unit> $onTransitionEnd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExpectationCardAnimation$expand$1$3(Function0<Unit> function0) {
        super(1);
        this.$onTransitionEnd = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Transition) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Transition transition) {
        Intrinsics.checkNotNullParameter(transition, "it");
        this.$onTransitionEnd.invoke();
    }
}
