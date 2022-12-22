package com.didi.soda.blocks.style;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaNode;

public class BlockRootFrameLayout extends FrameLayout {
    public BlockRootFrameLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public BlockRootFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BlockRootFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            if (childAt instanceof BlockLayout) {
                BlockLayout blockLayout = (BlockLayout) childAt;
                float f = blockLayout.getYogaNode().getMargin(YogaEdge.LEFT).value;
                float f2 = blockLayout.getYogaNode().getMargin(YogaEdge.RIGHT).value;
                float f3 = blockLayout.getYogaNode().getMargin(YogaEdge.TOP).value;
                float f4 = blockLayout.getYogaNode().getMargin(YogaEdge.BOTTOM).value;
                if (Float.isNaN(f)) {
                    f = 0.0f;
                }
                if (Float.isNaN(f2)) {
                    f2 = 0.0f;
                }
                if (Float.isNaN(f3)) {
                    f3 = 0.0f;
                }
                if (Float.isNaN(f4)) {
                    f4 = 0.0f;
                }
                blockLayout.createLayout(View.MeasureSpec.makeMeasureSpec((i3 - i) - ((int) (f + f2)), 1073741824), View.MeasureSpec.makeMeasureSpec((i4 - i2) - ((int) (f3 + f4)), 1073741824));
                if (blockLayout.getBlockNode() != null && blockLayout.getBlockNode().isRoot()) {
                    realLayout(blockLayout, blockLayout.getYogaNode(), 0.0f, 0.0f);
                    return;
                }
                return;
            }
        }
    }

    private void realLayout(View view, YogaNode yogaNode, float f, float f2) {
        if (view.getVisibility() != 8) {
            int round = Math.round(f + yogaNode.getLayoutX());
            int round2 = Math.round(f2 + yogaNode.getLayoutY());
            view.measure(View.MeasureSpec.makeMeasureSpec(Math.round(yogaNode.getLayoutWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.round(yogaNode.getLayoutHeight()), 1073741824));
            view.layout(round, round2, view.getMeasuredWidth() + round, view.getMeasuredHeight() + round2);
        }
    }
}
