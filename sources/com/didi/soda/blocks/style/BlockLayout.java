package com.didi.soda.blocks.style;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.android.YogaLayout;

public class BlockLayout extends YogaLayout {
    /* access modifiers changed from: private */
    public boolean hasTrackLayout;
    private WidgetNodeModel mBlockNode;

    public BlockLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public BlockLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BlockLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hasTrackLayout = false;
        init(context);
    }

    private void init(Context context) {
        setClipChildren(false);
    }

    public void setBlockNode(WidgetNodeModel widgetNodeModel) {
        this.mBlockNode = widgetNodeModel;
        this.hasTrackLayout = false;
    }

    public WidgetNodeModel getBlockNode() {
        return this.mBlockNode;
    }

    public void addView(BaseBinder baseBinder) {
        addView(baseBinder, -1);
    }

    public void addView(BaseBinder baseBinder, int i) {
        if (baseBinder != null) {
            ViewParent parent = baseBinder.getView().getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(baseBinder.getView());
            }
            YogaNode yogaNode = baseBinder.getYogaNode();
            addView(baseBinder.getView(), yogaNode);
            int childCount = getYogaNode().getChildCount();
            if (i < 0) {
                i = childCount;
            }
            getYogaNode().addChildAt(yogaNode, i);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (!(getParent() instanceof YogaLayout)) {
            createLayout(View.MeasureSpec.makeMeasureSpec(i3 - i, 0), View.MeasureSpec.makeMeasureSpec(i4 - i2, 0));
        }
        if (getBlockNode() != null && getBlockNode().isRoot() && !this.hasTrackLayout) {
            System.currentTimeMillis();
            addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    System.currentTimeMillis();
                    if (BlockLayout.this.getBlockNode() != null) {
                        boolean unused = BlockLayout.this.hasTrackLayout = true;
                    }
                    BlockLayout.this.removeOnLayoutChangeListener(this);
                }
            });
        }
        applyLayoutRecursive(getYogaNode(), 0.0f, 0.0f);
    }

    public void createLayout(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode2 == 1073741824) {
            getYogaNode().setHeight((float) size2);
        }
        if (mode == 1073741824) {
            getYogaNode().setWidth((float) size);
        }
        if (mode2 == Integer.MIN_VALUE) {
            getYogaNode().setMaxHeight((float) size2);
        }
        if (mode == Integer.MIN_VALUE) {
            getYogaNode().setMaxWidth((float) size);
        }
        getYogaNode().calculateLayout(Float.NaN, Float.NaN);
    }

    private void applyLayoutRecursive(YogaNode yogaNode, float f, float f2) {
        View view = (View) yogaNode.getData();
        if (!(view == null || view == this)) {
            if (view.getVisibility() != 8) {
                int round = Math.round(yogaNode.getLayoutX() + f);
                int round2 = Math.round(yogaNode.getLayoutY() + f2);
                view.measure(View.MeasureSpec.makeMeasureSpec(Math.round(yogaNode.getLayoutWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.round(yogaNode.getLayoutHeight()), 1073741824));
                view.layout(round, round2, view.getMeasuredWidth() + round, view.getMeasuredHeight() + round2);
            } else {
                return;
            }
        }
        int childCount = yogaNode.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (equals(view)) {
                applyLayoutRecursive(yogaNode.getChildAt(i), f, f2);
            } else {
                boolean z = view instanceof YogaLayout;
            }
        }
    }
}
