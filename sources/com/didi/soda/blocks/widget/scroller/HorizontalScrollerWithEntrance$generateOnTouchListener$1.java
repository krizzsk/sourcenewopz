package com.didi.soda.blocks.widget.scroller;

import android.view.MotionEvent;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.C21490Reflection;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KDeclarationContainer;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0015\u0010\u0007\u001a\u00110\b¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t¢\u0006\u0002\b\n"}, mo175978d2 = {"<anonymous>", "", "p1", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "v", "p2", "Landroid/view/MotionEvent;", "ev", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: HorizontalScrollerWithEntrance.kt */
final /* synthetic */ class HorizontalScrollerWithEntrance$generateOnTouchListener$1 extends FunctionReference implements Function2<View, MotionEvent, Boolean> {
    HorizontalScrollerWithEntrance$generateOnTouchListener$1(HorizontalScrollerWithEntrance horizontalScrollerWithEntrance) {
        super(2, horizontalScrollerWithEntrance);
    }

    public final String getName() {
        return "onScrollerViewTouch";
    }

    public final KDeclarationContainer getOwner() {
        return C21490Reflection.getOrCreateKotlinClass(HorizontalScrollerWithEntrance.class);
    }

    public final String getSignature() {
        return "onScrollerViewTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z";
    }

    public /* synthetic */ Object invoke(Object obj, Object obj2) {
        return Boolean.valueOf(invoke((View) obj, (MotionEvent) obj2));
    }

    public final boolean invoke(View view, MotionEvent motionEvent) {
        Intrinsics.checkParameterIsNotNull(view, "p1");
        Intrinsics.checkParameterIsNotNull(motionEvent, "p2");
        return ((HorizontalScrollerWithEntrance) this.receiver).onScrollerViewTouch(view, motionEvent);
    }
}
