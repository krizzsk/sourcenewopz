package com.didi.soda.blocks.widget.scroller;

import android.view.MotionEvent;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* renamed from: com.didi.soda.blocks.widget.scroller.HorizontalScrollerWithEntrance$sam$android_view_View_OnTouchListener$0 */
/* compiled from: HorizontalScrollerWithEntrance.kt */
final class C13423xcb2cb761 implements View.OnTouchListener {
    private final /* synthetic */ Function2 function;

    C13423xcb2cb761(Function2 function2) {
        this.function = function2;
    }

    public final /* synthetic */ boolean onTouch(View view, MotionEvent motionEvent) {
        Object invoke = this.function.invoke(view, motionEvent);
        Intrinsics.checkExpressionValueIsNotNull(invoke, "invoke(...)");
        return ((Boolean) invoke).booleanValue();
    }
}
