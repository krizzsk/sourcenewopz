package com.didi.soda.blocks.widget.scroller;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.C21490Reflection;
import kotlin.jvm.internal.FunctionReference;
import kotlin.reflect.KDeclarationContainer;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\t\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0015\u0010\u0007\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0015\u0010\t\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u0015\u0010\u000b\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f¢\u0006\u0002\b\r"}, mo175978d2 = {"<anonymous>", "", "p1", "", "Lkotlin/ParameterName;", "name", "l", "p2", "t", "p3", "oldl", "p4", "oldt", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: HorizontalScroller.kt */
final /* synthetic */ class HorizontalScroller$createView$1$1 extends FunctionReference implements Function4<Integer, Integer, Integer, Integer, Unit> {
    HorizontalScroller$createView$1$1(HorizontalScroller horizontalScroller) {
        super(4, horizontalScroller);
    }

    public final String getName() {
        return "onScrollChanged";
    }

    public final KDeclarationContainer getOwner() {
        return C21490Reflection.getOrCreateKotlinClass(HorizontalScroller.class);
    }

    public final String getSignature() {
        return "onScrollChanged(IIII)V";
    }

    public /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke(((Number) obj).intValue(), ((Number) obj2).intValue(), ((Number) obj3).intValue(), ((Number) obj4).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i, int i2, int i3, int i4) {
        ((HorizontalScroller) this.receiver).onScrollChanged(i, i2, i3, i4);
    }
}
