package com.didi.component.expectation.view.animation;

import androidx.transition.Transition;
import androidx.transition.TransitionListenerAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, mo175978d2 = {"com/didi/component/expectation/view/animation/ExpectationCardAnimation$makeTransition$1$1$1", "Landroidx/transition/TransitionListenerAdapter;", "onTransitionEnd", "", "transition", "Landroidx/transition/Transition;", "onTransitionStart", "comp-expectation_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ExpectationCardAnimation.kt */
public final class ExpectationCardAnimation$makeTransition$1$1$1 extends TransitionListenerAdapter {
    final /* synthetic */ Function1<Transition, Unit> $onEnd;
    final /* synthetic */ Function1<Transition, Unit> $onStart;
    final /* synthetic */ ExpectationCardAnimation this$0;

    ExpectationCardAnimation$makeTransition$1$1$1(ExpectationCardAnimation expectationCardAnimation, Function1<? super Transition, Unit> function1, Function1<? super Transition, Unit> function12) {
        this.this$0 = expectationCardAnimation;
        this.$onStart = function1;
        this.$onEnd = function12;
    }

    public void onTransitionStart(Transition transition) {
        Intrinsics.checkNotNullParameter(transition, "transition");
        this.this$0.f13728h = true;
        this.$onStart.invoke(transition);
    }

    public void onTransitionEnd(Transition transition) {
        Intrinsics.checkNotNullParameter(transition, "transition");
        this.$onEnd.invoke(transition);
        this.this$0.f13728h = false;
    }
}
