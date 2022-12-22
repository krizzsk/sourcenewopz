package com.facebook.yoga.android;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import com.didi.passenger.C10448R;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaDirection;
import com.facebook.yoga.YogaDisplay;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaFlexDirection;
import com.facebook.yoga.YogaJustify;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.YogaNodeFactory;
import com.facebook.yoga.YogaOverflow;
import com.facebook.yoga.YogaPositionType;
import com.facebook.yoga.YogaWrap;
import java.util.Map;
import kotlinx.coroutines.DebugKt;

public class YogaLayout extends ViewGroup {
    private final YogaNode mYogaNode;
    private final Map<View, YogaNode> mYogaNodes;

    public YogaLayout(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public YogaLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARNING: type inference failed for: r2v2, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public YogaLayout(android.content.Context r2, android.util.AttributeSet r3, int r4) {
        /*
            r1 = this;
            r1.<init>(r2, r3, r4)
            com.facebook.yoga.YogaNode r4 = com.facebook.yoga.YogaNodeFactory.create()
            r1.mYogaNode = r4
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            r1.mYogaNodes = r4
            com.facebook.yoga.YogaNode r4 = r1.mYogaNode
            r4.setData(r1)
            com.facebook.yoga.YogaNode r4 = r1.mYogaNode
            com.facebook.yoga.android.YogaLayout$ViewMeasureFunction r0 = new com.facebook.yoga.android.YogaLayout$ViewMeasureFunction
            r0.<init>()
            r4.setMeasureFunction(r0)
            if (r3 == 0) goto L_0x0027
            com.facebook.yoga.android.YogaLayout$LayoutParams r4 = new com.facebook.yoga.android.YogaLayout$LayoutParams
            r4.<init>((android.content.Context) r2, (android.util.AttributeSet) r3)
            goto L_0x002e
        L_0x0027:
            android.view.ViewGroup$LayoutParams r2 = r1.generateDefaultLayoutParams()
            r4 = r2
            com.facebook.yoga.android.YogaLayout$LayoutParams r4 = (com.facebook.yoga.android.YogaLayout.LayoutParams) r4
        L_0x002e:
            com.facebook.yoga.YogaNode r2 = r1.mYogaNode
            applyLayoutParams(r4, r2, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.yoga.android.YogaLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public YogaNode getYogaNode() {
        return this.mYogaNode;
    }

    public YogaNode getYogaNodeForView(View view) {
        return this.mYogaNodes.get(view);
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        YogaNode yogaNode;
        this.mYogaNode.setMeasureFunction((YogaMeasureFunction) null);
        if (view instanceof VirtualYogaLayout) {
            VirtualYogaLayout virtualYogaLayout = (VirtualYogaLayout) view;
            virtualYogaLayout.transferChildren(this);
            YogaNode yogaNode2 = virtualYogaLayout.getYogaNode();
            YogaNode yogaNode3 = this.mYogaNode;
            yogaNode3.addChildAt(yogaNode2, yogaNode3.getChildCount());
            return;
        }
        super.addView(view, i, layoutParams);
        if (!this.mYogaNodes.containsKey(view)) {
            if (view instanceof YogaLayout) {
                yogaNode = ((YogaLayout) view).getYogaNode();
            } else {
                if (this.mYogaNodes.containsKey(view)) {
                    yogaNode = this.mYogaNodes.get(view);
                } else {
                    yogaNode = YogaNodeFactory.create();
                }
                yogaNode.setData(view);
                yogaNode.setMeasureFunction(new ViewMeasureFunction());
            }
            applyLayoutParams((LayoutParams) view.getLayoutParams(), yogaNode, view);
            this.mYogaNodes.put(view, yogaNode);
            YogaNode yogaNode4 = this.mYogaNode;
            yogaNode4.addChildAt(yogaNode, yogaNode4.getChildCount());
        }
    }

    public void addView(View view, YogaNode yogaNode) {
        this.mYogaNodes.put(view, yogaNode);
        addView(view);
    }

    public void removeView(View view) {
        removeViewFromYogaTree(view, false);
        super.removeView(view);
    }

    public void removeViewAt(int i) {
        removeViewFromYogaTree(getChildAt(i), false);
        super.removeViewAt(i);
    }

    public void removeViewInLayout(View view) {
        removeViewFromYogaTree(view, true);
        super.removeViewInLayout(view);
    }

    public void removeViews(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            removeViewFromYogaTree(getChildAt(i3), false);
        }
        super.removeViews(i, i2);
    }

    public void removeViewsInLayout(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            removeViewFromYogaTree(getChildAt(i3), true);
        }
        super.removeViewsInLayout(i, i2);
    }

    public void removeAllViews() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            removeViewFromYogaTree(getChildAt(i), false);
        }
        super.removeAllViews();
    }

    public void removeAllViewsInLayout() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            removeViewFromYogaTree(getChildAt(i), true);
        }
        super.removeAllViewsInLayout();
    }

    public void invalidate(View view) {
        if (this.mYogaNodes.containsKey(view)) {
            this.mYogaNodes.get(view).dirty();
            return;
        }
        int childCount = this.mYogaNode.getChildCount();
        for (int i = 0; i < childCount; i++) {
            YogaNode childAt = this.mYogaNode.getChildAt(i);
            if (childAt.getData() instanceof YogaLayout) {
                ((YogaLayout) childAt.getData()).invalidate(view);
            }
        }
        invalidate();
    }

    private void removeViewFromYogaTree(View view, boolean z) {
        YogaNode yogaNode = this.mYogaNodes.get(view);
        if (yogaNode != null) {
            YogaNode owner = yogaNode.getOwner();
            int i = 0;
            while (true) {
                if (i >= owner.getChildCount()) {
                    break;
                } else if (owner.getChildAt(i).equals(yogaNode)) {
                    owner.removeChildAt(i);
                    break;
                } else {
                    i++;
                }
            }
            yogaNode.setData((Object) null);
            this.mYogaNodes.remove(view);
            if (z) {
                this.mYogaNode.calculateLayout(Float.NaN, Float.NaN);
            }
        }
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
            } else if (!(view instanceof YogaLayout)) {
                applyLayoutRecursive(yogaNode.getChildAt(i), yogaNode.getLayoutX() + f, yogaNode.getLayoutY() + f2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (!(getParent() instanceof YogaLayout)) {
            createLayout(View.MeasureSpec.makeMeasureSpec(i3 - i, 1073741824), View.MeasureSpec.makeMeasureSpec(i4 - i2, 1073741824));
        }
        applyLayoutRecursive(this.mYogaNode, 0.0f, 0.0f);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (!(getParent() instanceof YogaLayout)) {
            createLayout(i, i2);
        }
        setMeasuredDimension(Math.round(this.mYogaNode.getLayoutWidth()), Math.round(this.mYogaNode.getLayoutHeight()));
    }

    private void createLayout(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode2 == 1073741824) {
            this.mYogaNode.setHeight((float) size2);
        }
        if (mode == 1073741824) {
            this.mYogaNode.setWidth((float) size);
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.mYogaNode.setMaxHeight((float) size2);
        }
        if (mode == Integer.MIN_VALUE) {
            this.mYogaNode.setMaxWidth((float) size);
        }
        this.mYogaNode.calculateLayout(Float.NaN, Float.NaN);
    }

    protected static void applyLayoutParams(LayoutParams layoutParams, YogaNode yogaNode, View view) {
        int i;
        LayoutParams layoutParams2 = layoutParams;
        YogaNode yogaNode2 = yogaNode;
        int i2 = 1;
        if (Build.VERSION.SDK_INT >= 17 && view.getResources().getConfiguration().getLayoutDirection() == 1) {
            yogaNode2.setDirection(YogaDirection.RTL);
        }
        Drawable background = view.getBackground();
        if (background != null) {
            Rect rect = new Rect();
            if (background.getPadding(rect)) {
                yogaNode2.setPadding(YogaEdge.LEFT, (float) rect.left);
                yogaNode2.setPadding(YogaEdge.TOP, (float) rect.top);
                yogaNode2.setPadding(YogaEdge.RIGHT, (float) rect.right);
                yogaNode2.setPadding(YogaEdge.BOTTOM, (float) rect.bottom);
            }
        }
        int i3 = 0;
        while (true) {
            i = 16;
            if (i3 >= layoutParams2.numericAttributes.size()) {
                break;
            }
            int keyAt = layoutParams2.numericAttributes.keyAt(i3);
            float floatValue = layoutParams2.numericAttributes.valueAt(i3).floatValue();
            if (keyAt == 0) {
                yogaNode2.setAlignContent(YogaAlign.fromInt(Math.round(floatValue)));
            } else if (keyAt == i2) {
                yogaNode2.setAlignItems(YogaAlign.fromInt(Math.round(floatValue)));
            } else if (keyAt == 2) {
                yogaNode2.setAlignSelf(YogaAlign.fromInt(Math.round(floatValue)));
            } else if (keyAt == 3) {
                yogaNode2.setAspectRatio(floatValue);
            } else if (keyAt == 8) {
                yogaNode2.setBorder(YogaEdge.LEFT, floatValue);
            } else if (keyAt == 11) {
                yogaNode2.setBorder(YogaEdge.TOP, floatValue);
            } else if (keyAt == 9) {
                yogaNode2.setBorder(YogaEdge.RIGHT, floatValue);
            } else if (keyAt == 5) {
                yogaNode2.setBorder(YogaEdge.BOTTOM, floatValue);
            } else if (keyAt == 10) {
                yogaNode2.setBorder(YogaEdge.START, floatValue);
            } else if (keyAt == 6) {
                yogaNode2.setBorder(YogaEdge.END, floatValue);
            } else if (keyAt == 7) {
                yogaNode2.setBorder(YogaEdge.HORIZONTAL, floatValue);
            } else if (keyAt == 12) {
                yogaNode2.setBorder(YogaEdge.VERTICAL, floatValue);
            } else if (keyAt == 4) {
                yogaNode2.setBorder(YogaEdge.ALL, floatValue);
            } else if (keyAt == 13) {
                yogaNode2.setDirection(YogaDirection.fromInt(Math.round(floatValue)));
            } else if (keyAt == 14) {
                yogaNode2.setDisplay(YogaDisplay.fromInt(Math.round(floatValue)));
            } else if (keyAt == 15) {
                yogaNode2.setFlex(floatValue);
            } else if (keyAt == 16) {
                yogaNode2.setFlexBasis(floatValue);
            } else if (keyAt == 17) {
                yogaNode2.setFlexDirection(YogaFlexDirection.fromInt(Math.round(floatValue)));
            } else if (keyAt == 18) {
                yogaNode2.setFlexGrow(floatValue);
            } else if (keyAt == 19) {
                yogaNode2.setFlexShrink(floatValue);
            } else if (keyAt == 20) {
                yogaNode2.setHeight(floatValue);
            } else if (keyAt == 26) {
                yogaNode2.setMargin(YogaEdge.LEFT, floatValue);
            } else if (keyAt == 21) {
                yogaNode2.setJustifyContent(YogaJustify.fromInt(Math.round(floatValue)));
            } else if (keyAt == 29) {
                yogaNode2.setMargin(YogaEdge.TOP, floatValue);
            } else if (keyAt == 27) {
                yogaNode2.setMargin(YogaEdge.RIGHT, floatValue);
            } else if (keyAt == 23) {
                yogaNode2.setMargin(YogaEdge.BOTTOM, floatValue);
            } else if (keyAt == 28) {
                yogaNode2.setMargin(YogaEdge.START, floatValue);
            } else if (keyAt == 24) {
                yogaNode2.setMargin(YogaEdge.END, floatValue);
            } else if (keyAt == 25) {
                yogaNode2.setMargin(YogaEdge.HORIZONTAL, floatValue);
            } else if (keyAt == 30) {
                yogaNode2.setMargin(YogaEdge.VERTICAL, floatValue);
            } else if (keyAt == 22) {
                yogaNode2.setMargin(YogaEdge.ALL, floatValue);
            } else if (keyAt == 31) {
                yogaNode2.setMaxHeight(floatValue);
            } else if (keyAt == 32) {
                yogaNode2.setMaxWidth(floatValue);
            } else if (keyAt == 33) {
                yogaNode2.setMinHeight(floatValue);
            } else if (keyAt == 34) {
                yogaNode2.setMinWidth(floatValue);
            } else if (keyAt == 35) {
                yogaNode2.setOverflow(YogaOverflow.fromInt(Math.round(floatValue)));
            } else if (keyAt == 40) {
                yogaNode2.setPadding(YogaEdge.LEFT, floatValue);
            } else if (keyAt == 43) {
                yogaNode2.setPadding(YogaEdge.TOP, floatValue);
            } else if (keyAt == 41) {
                yogaNode2.setPadding(YogaEdge.RIGHT, floatValue);
            } else if (keyAt == 37) {
                yogaNode2.setPadding(YogaEdge.BOTTOM, floatValue);
            } else if (keyAt == 42) {
                yogaNode2.setPadding(YogaEdge.START, floatValue);
            } else if (keyAt == 38) {
                yogaNode2.setPadding(YogaEdge.END, floatValue);
            } else if (keyAt == 39) {
                yogaNode2.setPadding(YogaEdge.HORIZONTAL, floatValue);
            } else if (keyAt == 44) {
                yogaNode2.setPadding(YogaEdge.VERTICAL, floatValue);
            } else if (keyAt == 36) {
                yogaNode2.setPadding(YogaEdge.ALL, floatValue);
            } else if (keyAt == 49) {
                yogaNode2.setPosition(YogaEdge.LEFT, floatValue);
            } else if (keyAt == 52) {
                yogaNode2.setPosition(YogaEdge.TOP, floatValue);
            } else if (keyAt == 50) {
                yogaNode2.setPosition(YogaEdge.RIGHT, floatValue);
            } else if (keyAt == 46) {
                yogaNode2.setPosition(YogaEdge.BOTTOM, floatValue);
            } else if (keyAt == 51) {
                yogaNode2.setPosition(YogaEdge.START, floatValue);
            } else if (keyAt == 47) {
                yogaNode2.setPosition(YogaEdge.END, floatValue);
            } else if (keyAt == 48) {
                yogaNode2.setPosition(YogaEdge.HORIZONTAL, floatValue);
            } else if (keyAt == 54) {
                yogaNode2.setPosition(YogaEdge.VERTICAL, floatValue);
            } else if (keyAt == 45) {
                yogaNode2.setPosition(YogaEdge.ALL, floatValue);
            } else if (keyAt == 53) {
                yogaNode2.setPositionType(YogaPositionType.fromInt(Math.round(floatValue)));
            } else if (keyAt == 55) {
                yogaNode2.setWidth(floatValue);
            } else if (keyAt == 56) {
                yogaNode2.setWrap(YogaWrap.fromInt(Math.round(floatValue)));
            }
            i3++;
            i2 = 1;
        }
        int i4 = 0;
        while (i4 < layoutParams2.stringAttributes.size()) {
            int keyAt2 = layoutParams2.stringAttributes.keyAt(i4);
            String valueAt = layoutParams2.stringAttributes.valueAt(i4);
            if (valueAt.equals(DebugKt.DEBUG_PROPERTY_VALUE_AUTO)) {
                if (keyAt2 == 26) {
                    yogaNode2.setMarginAuto(YogaEdge.LEFT);
                } else if (keyAt2 == 29) {
                    yogaNode2.setMarginAuto(YogaEdge.TOP);
                } else if (keyAt2 == 27) {
                    yogaNode2.setMarginAuto(YogaEdge.RIGHT);
                } else if (keyAt2 == 23) {
                    yogaNode2.setMarginAuto(YogaEdge.BOTTOM);
                } else if (keyAt2 == 28) {
                    yogaNode2.setMarginAuto(YogaEdge.START);
                } else if (keyAt2 == 24) {
                    yogaNode2.setMarginAuto(YogaEdge.END);
                } else if (keyAt2 == 25) {
                    yogaNode2.setMarginAuto(YogaEdge.HORIZONTAL);
                } else if (keyAt2 == 30) {
                    yogaNode2.setMarginAuto(YogaEdge.VERTICAL);
                } else if (keyAt2 == 22) {
                    yogaNode2.setMarginAuto(YogaEdge.ALL);
                }
            }
            if (valueAt.endsWith("%")) {
                float parseFloat = Float.parseFloat(valueAt.substring(0, valueAt.length() - 1));
                if (keyAt2 == i) {
                    yogaNode2.setFlexBasisPercent(parseFloat);
                } else if (keyAt2 == 20) {
                    yogaNode2.setHeightPercent(parseFloat);
                } else if (keyAt2 == 26) {
                    yogaNode2.setMarginPercent(YogaEdge.LEFT, parseFloat);
                } else if (keyAt2 == 29) {
                    yogaNode2.setMarginPercent(YogaEdge.TOP, parseFloat);
                } else if (keyAt2 == 27) {
                    yogaNode2.setMarginPercent(YogaEdge.RIGHT, parseFloat);
                } else if (keyAt2 == 23) {
                    yogaNode2.setMarginPercent(YogaEdge.BOTTOM, parseFloat);
                } else if (keyAt2 == 28) {
                    yogaNode2.setMarginPercent(YogaEdge.START, parseFloat);
                } else if (keyAt2 == 24) {
                    yogaNode2.setMarginPercent(YogaEdge.END, parseFloat);
                } else if (keyAt2 == 25) {
                    yogaNode2.setMarginPercent(YogaEdge.HORIZONTAL, parseFloat);
                } else if (keyAt2 == 30) {
                    yogaNode2.setMarginPercent(YogaEdge.VERTICAL, parseFloat);
                } else if (keyAt2 == 22) {
                    yogaNode2.setMarginPercent(YogaEdge.ALL, parseFloat);
                } else if (keyAt2 == 31) {
                    yogaNode2.setMaxHeightPercent(parseFloat);
                } else if (keyAt2 == 32) {
                    yogaNode2.setMaxWidthPercent(parseFloat);
                } else if (keyAt2 == 33) {
                    yogaNode2.setMinHeightPercent(parseFloat);
                } else if (keyAt2 == 34) {
                    yogaNode2.setMinWidthPercent(parseFloat);
                } else if (keyAt2 == 40) {
                    yogaNode2.setPaddingPercent(YogaEdge.LEFT, parseFloat);
                } else if (keyAt2 == 43) {
                    yogaNode2.setPaddingPercent(YogaEdge.TOP, parseFloat);
                } else if (keyAt2 == 41) {
                    yogaNode2.setPaddingPercent(YogaEdge.RIGHT, parseFloat);
                } else if (keyAt2 == 37) {
                    yogaNode2.setPaddingPercent(YogaEdge.BOTTOM, parseFloat);
                } else if (keyAt2 == 42) {
                    yogaNode2.setPaddingPercent(YogaEdge.START, parseFloat);
                } else if (keyAt2 == 38) {
                    yogaNode2.setPaddingPercent(YogaEdge.END, parseFloat);
                } else if (keyAt2 == 39) {
                    yogaNode2.setPaddingPercent(YogaEdge.HORIZONTAL, parseFloat);
                } else if (keyAt2 == 44) {
                    yogaNode2.setPaddingPercent(YogaEdge.VERTICAL, parseFloat);
                } else if (keyAt2 == 36) {
                    yogaNode2.setPaddingPercent(YogaEdge.ALL, parseFloat);
                } else if (keyAt2 == 49) {
                    yogaNode2.setPositionPercent(YogaEdge.LEFT, parseFloat);
                } else if (keyAt2 == 52) {
                    yogaNode2.setPositionPercent(YogaEdge.TOP, parseFloat);
                } else if (keyAt2 == 50) {
                    yogaNode2.setPositionPercent(YogaEdge.RIGHT, parseFloat);
                } else if (keyAt2 == 46) {
                    yogaNode2.setPositionPercent(YogaEdge.BOTTOM, parseFloat);
                } else if (keyAt2 == 51) {
                    yogaNode2.setPositionPercent(YogaEdge.START, parseFloat);
                } else if (keyAt2 == 47) {
                    yogaNode2.setPositionPercent(YogaEdge.END, parseFloat);
                } else if (keyAt2 == 48) {
                    yogaNode2.setPositionPercent(YogaEdge.HORIZONTAL, parseFloat);
                } else if (keyAt2 == 54) {
                    yogaNode2.setPositionPercent(YogaEdge.VERTICAL, parseFloat);
                } else if (keyAt2 == 45) {
                    yogaNode2.setPositionPercent(YogaEdge.ALL, parseFloat);
                } else if (keyAt2 == 55) {
                    yogaNode2.setWidthPercent(parseFloat);
                }
            }
            i4++;
            i = 16;
        }
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public static class LayoutParams extends ViewGroup.LayoutParams {
        SparseArray<Float> numericAttributes;
        SparseArray<String> stringAttributes;

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            if (layoutParams instanceof LayoutParams) {
                LayoutParams layoutParams2 = (LayoutParams) layoutParams;
                this.numericAttributes = layoutParams2.numericAttributes.clone();
                this.stringAttributes = layoutParams2.stringAttributes.clone();
                return;
            }
            this.numericAttributes = new SparseArray<>();
            this.stringAttributes = new SparseArray<>();
            if (layoutParams.width >= 0) {
                this.numericAttributes.put(55, Float.valueOf((float) this.width));
            }
            if (layoutParams.height >= 0) {
                this.numericAttributes.put(20, Float.valueOf((float) this.height));
            }
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.numericAttributes = new SparseArray<>();
            this.stringAttributes = new SparseArray<>();
            if (i >= 0) {
                this.numericAttributes.put(55, Float.valueOf((float) i));
            }
            if (i2 >= 0) {
                this.numericAttributes.put(20, Float.valueOf((float) i2));
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.numericAttributes = new SparseArray<>();
            this.stringAttributes = new SparseArray<>();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.yoga);
            if (this.width >= 0) {
                this.numericAttributes.put(55, Float.valueOf((float) this.width));
            }
            if (this.height >= 0) {
                this.numericAttributes.put(20, Float.valueOf((float) this.height));
            }
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                TypedValue typedValue = new TypedValue();
                obtainStyledAttributes.getValue(index, typedValue);
                if (typedValue.type == 5) {
                    this.numericAttributes.put(index, Float.valueOf((float) obtainStyledAttributes.getDimensionPixelSize(index, 0)));
                } else if (typedValue.type == 3) {
                    this.stringAttributes.put(index, obtainStyledAttributes.getString(index));
                } else {
                    this.numericAttributes.put(index, Float.valueOf(obtainStyledAttributes.getFloat(index, 0.0f)));
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public static class ViewMeasureFunction implements YogaMeasureFunction {
        public long measure(YogaNode yogaNode, float f, YogaMeasureMode yogaMeasureMode, float f2, YogaMeasureMode yogaMeasureMode2) {
            View view = (View) yogaNode.getData();
            if (view == null || (view instanceof YogaLayout)) {
                return YogaMeasureOutput.make(0, 0);
            }
            view.measure(View.MeasureSpec.makeMeasureSpec((int) f, viewMeasureSpecFromYogaMeasureMode(yogaMeasureMode)), View.MeasureSpec.makeMeasureSpec((int) f2, viewMeasureSpecFromYogaMeasureMode(yogaMeasureMode2)));
            return YogaMeasureOutput.make(view.getMeasuredWidth(), view.getMeasuredHeight());
        }

        private int viewMeasureSpecFromYogaMeasureMode(YogaMeasureMode yogaMeasureMode) {
            if (yogaMeasureMode == YogaMeasureMode.AT_MOST) {
                return Integer.MIN_VALUE;
            }
            return yogaMeasureMode == YogaMeasureMode.EXACTLY ? 1073741824 : 0;
        }
    }
}
