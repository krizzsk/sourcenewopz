package com.didi.soda.customer.blocks.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 (2\u00020\u0001:\u0001(B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\tH\u0002J\u0006\u0010\u001c\u001a\u00020\u0011J0\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\tH\u0014J\u0018\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\tH\u0014J\u000e\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u0011R\u001a\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014¨\u0006)"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/view/PriceActionOuterView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "btnType", "getBtnType", "()I", "setBtnType", "(I)V", "isBtnWrapNeed", "", "()Z", "setBtnWrapNeed", "(Z)V", "isBtnWrapSet", "setBtnWrapSet", "addView", "", "child", "Landroid/view/View;", "getMeasureButtonSpace", "isButtonWrapNeed", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setButtonWrap", "needWrap", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PriceActionOuterView.kt */
public final class PriceActionOuterView extends RelativeLayout {
    public static final int BTN_TYPE_ICON = 2;
    public static final int BTN_TYPE_NONE = 0;
    public static final int BTN_TYPE_TEXT = 1;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int INDEX_BTN_GROUP = 1;
    public static final int INDEX_INNER_VIEW = 0;
    public static final int TOP_MARGIN = 12;

    /* renamed from: a */
    private int f40669a;

    /* renamed from: b */
    private boolean f40670b;

    /* renamed from: c */
    private boolean f40671c;

    public void _$_clearFindViewByIdCache() {
    }

    public PriceActionOuterView(Context context) {
        super(context);
    }

    public PriceActionOuterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PriceActionOuterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final int getBtnType() {
        return this.f40669a;
    }

    public final void setBtnType(int i) {
        this.f40669a = i;
    }

    public final boolean isBtnWrapNeed() {
        return this.f40670b;
    }

    public final void setBtnWrapNeed(boolean z) {
        this.f40670b = z;
    }

    public final boolean isBtnWrapSet() {
        return this.f40671c;
    }

    public final void setBtnWrapSet(boolean z) {
        this.f40671c = z;
    }

    public void addView(View view) {
        Intrinsics.checkNotNullParameter(view, "child");
        if (getChildCount() <= 2) {
            super.addView(view);
            return;
        }
        throw new IllegalStateException("只能有两个子元素".toString());
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        PriceActionInnerView priceActionInnerView;
        int i5;
        int i6;
        String str;
        int i7;
        int i8;
        int i9;
        int i10 = i;
        int i11 = i2;
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        this.f40670b = false;
        int childCount = getChildCount();
        String str2 = "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams";
        if (this.f40671c) {
            String str3 = str2;
            if (childCount > 0) {
                int i12 = 0;
                PriceActionInnerView priceActionInnerView2 = null;
                int i13 = 0;
                while (true) {
                    int i14 = i13 + 1;
                    View childAt = getChildAt(i13);
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    if (layoutParams != null) {
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                        if (i13 == 0) {
                            int measureButtonSpace = getMeasureButtonSpace();
                            View childAt2 = getChildAt(i13);
                            priceActionInnerView = childAt2 instanceof PriceActionInnerView ? (PriceActionInnerView) childAt2 : null;
                            if (this.f40669a == 2) {
                                i6 = RelativeLayout.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(size - measureButtonSpace, Integer.MIN_VALUE), layoutParams2.leftMargin + layoutParams2.rightMargin, layoutParams2.width);
                                i4 = 0;
                                i5 = RelativeLayout.getChildMeasureSpec(i11, 0, layoutParams2.height);
                                if (priceActionInnerView != null) {
                                    priceActionInnerView.setOuterBtnSpace(0);
                                }
                            } else {
                                int childMeasureSpec = RelativeLayout.getChildMeasureSpec(i10, layoutParams2.leftMargin + layoutParams2.rightMargin, layoutParams2.width);
                                i5 = RelativeLayout.getChildMeasureSpec(i11, 0, layoutParams2.height);
                                if (priceActionInnerView != null) {
                                    priceActionInnerView.setOuterBtnSpace(measureButtonSpace);
                                }
                                i6 = childMeasureSpec;
                                i4 = 0;
                            }
                        } else {
                            int childMeasureSpec2 = RelativeLayout.getChildMeasureSpec(i10, layoutParams2.leftMargin + layoutParams2.rightMargin, layoutParams2.width);
                            i4 = 0;
                            i5 = RelativeLayout.getChildMeasureSpec(i11, 0, layoutParams2.height);
                            int i15 = childMeasureSpec2;
                            priceActionInnerView = priceActionInnerView2;
                            i6 = i15;
                        }
                        childAt.measure(i6, i5);
                        childAt.getMeasuredWidth();
                        int measuredHeight = childAt.getMeasuredHeight();
                        if (priceActionInnerView != null) {
                            priceActionInnerView.setOuterBtnSpace(i4);
                        }
                        i12 += measuredHeight;
                        if (i13 == childCount - 1) {
                            i12 += 12;
                        }
                        if (i14 >= childCount) {
                            i3 = i12;
                            break;
                        } else {
                            i13 = i14;
                            priceActionInnerView2 = priceActionInnerView;
                        }
                    } else {
                        throw new NullPointerException(str3);
                    }
                }
                setMeasuredDimension(size, i3);
            }
        } else if (childCount > 0) {
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            PriceActionInnerView priceActionInnerView3 = null;
            int i20 = 0;
            while (true) {
                int i21 = i16 + 1;
                View childAt3 = getChildAt(i16);
                ViewGroup.LayoutParams layoutParams3 = childAt3.getLayoutParams();
                if (layoutParams3 != null) {
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
                    if (i16 == 0) {
                        int measureButtonSpace2 = getMeasureButtonSpace();
                        View childAt4 = getChildAt(i16);
                        i7 = i19;
                        PriceActionInnerView priceActionInnerView4 = childAt4 instanceof PriceActionInnerView ? (PriceActionInnerView) childAt4 : null;
                        str = str2;
                        if (this.f40669a == 2) {
                            i9 = RelativeLayout.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(size - measureButtonSpace2, Integer.MIN_VALUE), layoutParams4.leftMargin + layoutParams4.rightMargin, layoutParams4.width);
                            i8 = RelativeLayout.getChildMeasureSpec(i11, 0, layoutParams4.height);
                            if (priceActionInnerView4 != null) {
                                priceActionInnerView4.setOuterBtnSpace(0);
                            }
                            priceActionInnerView3 = priceActionInnerView4;
                        } else {
                            int childMeasureSpec3 = RelativeLayout.getChildMeasureSpec(i10, layoutParams4.leftMargin + layoutParams4.rightMargin, layoutParams4.width);
                            i8 = RelativeLayout.getChildMeasureSpec(i11, 0, layoutParams4.height);
                            if (priceActionInnerView4 != null) {
                                priceActionInnerView4.setOuterBtnSpace(measureButtonSpace2);
                            }
                            priceActionInnerView3 = priceActionInnerView4;
                            i9 = childMeasureSpec3;
                        }
                    } else {
                        str = str2;
                        i7 = i19;
                        i9 = RelativeLayout.getChildMeasureSpec(i10, layoutParams4.leftMargin + layoutParams4.rightMargin, layoutParams4.width);
                        i8 = RelativeLayout.getChildMeasureSpec(i11, 0, layoutParams4.height);
                    }
                    childAt3.measure(i9, i8);
                    int measuredWidth = childAt3.getMeasuredWidth();
                    int measuredHeight2 = childAt3.getMeasuredHeight();
                    if (i17 + measuredWidth + layoutParams4.leftMargin + layoutParams4.rightMargin > size) {
                        if (this.f40669a != 2) {
                            this.f40670b = true;
                            if (priceActionInnerView3 != null) {
                                priceActionInnerView3.setOuterBtnSpace(0);
                            }
                            i20 += i18;
                            i18 = 0;
                        }
                        i19 = size;
                        i17 = 0;
                    } else {
                        i19 = i7;
                    }
                    i17 += measuredWidth + layoutParams4.leftMargin + layoutParams4.rightMargin;
                    i18 = RangesKt.coerceAtLeast(i18, measuredHeight2);
                    if (i16 == childCount - 1) {
                        int i22 = i19 >= size ? size : i17;
                        i20 = this.f40670b ? i20 + i18 + 12 : i20 + i18;
                        i19 = i22;
                    }
                    if (i21 >= childCount) {
                        size = i19;
                        i3 = i20;
                        break;
                    }
                    i16 = i21;
                    str2 = str;
                } else {
                    throw new NullPointerException(str2);
                }
            }
            setMeasuredDimension(size, i3);
        }
        size = 0;
        i3 = 0;
        setMeasuredDimension(size, i3);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f40670b || this.f40671c) {
            int childCount = getChildCount();
            if (childCount > 0) {
                int i5 = 0;
                int i6 = 0;
                while (true) {
                    int i7 = i5 + 1;
                    View childAt = getChildAt(i5);
                    if (i5 == 0 && childAt.getVisibility() == 0) {
                        int measuredHeight = childAt.getMeasuredHeight() + 0;
                        childAt.layout(0, 0, childAt.getMeasuredWidth() + 0, measuredHeight);
                        i6 = measuredHeight;
                    }
                    if (i5 == 1 && childAt.getVisibility() == 0) {
                        int i8 = i6 + 12;
                        childAt.layout(0, i8, childAt.getMeasuredWidth() + 0, childAt.getMeasuredHeight() + i8);
                    }
                    if (i7 < childCount) {
                        i5 = i7;
                    } else {
                        return;
                    }
                }
            }
        } else {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    private final int getMeasureButtonSpace() {
        View childAt = getChildAt(1);
        if (childAt != null) {
            RelativeLayout relativeLayout = (RelativeLayout) childAt;
            ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
            if (layoutParams != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                relativeLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                return relativeLayout.getMeasuredWidth() + layoutParams2.leftMargin + layoutParams2.rightMargin;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout");
    }

    public final boolean isButtonWrapNeed() {
        return this.f40670b;
    }

    public final void setButtonWrap(boolean z) {
        if (!z) {
            this.f40670b = false;
            this.f40671c = false;
            return;
        }
        this.f40671c = true;
        if (!this.f40670b) {
            requestLayout();
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/view/PriceActionOuterView$Companion;", "", "()V", "BTN_TYPE_ICON", "", "BTN_TYPE_NONE", "BTN_TYPE_TEXT", "INDEX_BTN_GROUP", "INDEX_INNER_VIEW", "TOP_MARGIN", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PriceActionOuterView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
