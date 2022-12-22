package com.didi.soda.blocks.widget.scroller;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JR\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¨\u0006\u000f"}, mo175978d2 = {"com/didi/soda/blocks/widget/scroller/HorizontalScrollerWithEntrance$generateEntrance$listener$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: HorizontalScrollerWithEntrance.kt */
public final class HorizontalScrollerWithEntrance$generateEntrance$listener$1 implements View.OnLayoutChangeListener {
    final /* synthetic */ ViewGroup $root;
    final /* synthetic */ HorizontalScrollerWithEntrance this$0;

    HorizontalScrollerWithEntrance$generateEntrance$listener$1(HorizontalScrollerWithEntrance horizontalScrollerWithEntrance, ViewGroup viewGroup) {
        this.this$0 = horizontalScrollerWithEntrance;
        this.$root = viewGroup;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0015, code lost:
        r3 = r3.getLayoutParams();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayoutChange(android.view.View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        /*
            r0 = this;
            com.didi.soda.blocks.widget.scroller.HorizontalScrollerWithEntrance r1 = r0.this$0
            android.view.ViewGroup r1 = r1.getEntrance()
            r2 = 0
            if (r1 == 0) goto L_0x002f
            float r1 = r1.getX()
            com.didi.soda.blocks.widget.scroller.HorizontalScrollerWithEntrance r3 = r0.this$0
            android.view.ViewGroup r3 = r3.getEntrance()
            if (r3 == 0) goto L_0x001e
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            if (r3 == 0) goto L_0x001e
            int r3 = r3.width
            goto L_0x001f
        L_0x001e:
            r3 = 0
        L_0x001f:
            int r3 = r4 - r3
            float r3 = (float) r3
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x002f
            android.view.ViewGroup r1 = r0.$root
            r2 = r0
            android.view.View$OnLayoutChangeListener r2 = (android.view.View.OnLayoutChangeListener) r2
            r1.removeOnLayoutChangeListener(r2)
            goto L_0x004c
        L_0x002f:
            com.didi.soda.blocks.widget.scroller.HorizontalScrollerWithEntrance r1 = r0.this$0
            android.view.ViewGroup r1 = r1.getEntrance()
            if (r1 == 0) goto L_0x004c
            com.didi.soda.blocks.widget.scroller.HorizontalScrollerWithEntrance r3 = r0.this$0
            android.view.ViewGroup r3 = r3.getEntrance()
            if (r3 == 0) goto L_0x0047
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            if (r3 == 0) goto L_0x0047
            int r2 = r3.width
        L_0x0047:
            int r4 = r4 - r2
            float r2 = (float) r4
            r1.setX(r2)
        L_0x004c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.blocks.widget.scroller.HorizontalScrollerWithEntrance$generateEntrance$listener$1.onLayoutChange(android.view.View, int, int, int, int, int, int, int, int):void");
    }
}
