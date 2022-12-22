package com.didi.soda.customer.blocks.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 *2\u00020\u0001:\u0001*B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0006\u0010\u001e\u001a\u00020\u0011J0\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\tH\u0014J\u0018\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\tH\u0014J\u000e\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020\u0011R\u001a\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0017\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000f¨\u0006+"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/view/PriceActionInnerView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "btnType", "getBtnType", "()I", "setBtnType", "(I)V", "isTextWrapNeed", "", "()Z", "setTextWrapNeed", "(Z)V", "isTextWrapSet", "setTextWrapSet", "outerBtnSpace", "getOuterBtnSpace", "setOuterBtnSpace", "addView", "", "child", "Landroid/view/View;", "isPriceTextWrapNeed", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setPriceTextWrap", "needWrap", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PriceActionInnerView.kt */
public final class PriceActionInnerView extends RelativeLayout {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int INDEX_ORI_PRICE = 1;
    public static final int INDEX_REAL_PRICE = 0;
    public static final int TOP_MARGIN = -2;

    /* renamed from: a */
    private int f40665a;

    /* renamed from: b */
    private int f40666b;

    /* renamed from: c */
    private boolean f40667c;

    /* renamed from: d */
    private boolean f40668d;

    public void _$_clearFindViewByIdCache() {
    }

    public PriceActionInnerView(Context context) {
        super(context);
    }

    public PriceActionInnerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PriceActionInnerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final int getOuterBtnSpace() {
        return this.f40665a;
    }

    public final void setOuterBtnSpace(int i) {
        this.f40665a = i;
    }

    public final int getBtnType() {
        return this.f40666b;
    }

    public final void setBtnType(int i) {
        this.f40666b = i;
    }

    public final boolean isTextWrapNeed() {
        return this.f40667c;
    }

    public final void setTextWrapNeed(boolean z) {
        this.f40667c = z;
    }

    public final boolean isTextWrapSet() {
        return this.f40668d;
    }

    public final void setTextWrapSet(boolean z) {
        this.f40668d = z;
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
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b1 A[LOOP:0: B:4:0x0022->B:32:0x00b1, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0122 A[LOOP:1: B:37:0x00c3->B:58:0x0122, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00ad A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x011f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r20, int r21) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            super.onMeasure(r20, r21)
            int r3 = android.view.View.MeasureSpec.getSize(r20)
            r4 = 0
            r0.f40667c = r4
            int r5 = r19.getChildCount()
            boolean r6 = r0.f40668d
            java.lang.String r8 = "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams"
            if (r6 != 0) goto L_0x00bd
            if (r5 <= 0) goto L_0x012a
            r6 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
        L_0x0022:
            int r15 = r6 + 1
            android.view.View r7 = r0.getChildAt(r6)
            android.view.ViewGroup$LayoutParams r16 = r7.getLayoutParams()
            if (r16 == 0) goto L_0x00b7
            r9 = r16
            android.widget.RelativeLayout$LayoutParams r9 = (android.widget.RelativeLayout.LayoutParams) r9
            int r4 = r9.leftMargin
            r17 = r14
            int r14 = r9.rightMargin
            int r4 = r4 + r14
            int r14 = r9.width
            int r4 = android.widget.RelativeLayout.getChildMeasureSpec(r1, r4, r14)
            int r14 = r9.height
            r1 = 0
            int r14 = android.widget.RelativeLayout.getChildMeasureSpec(r2, r1, r14)
            r7.measure(r4, r14)
            int r1 = r7.getMeasuredWidth()
            int r4 = r7.getMeasuredHeight()
            int r7 = r9.leftMargin
            int r7 = r7 + r1
            int r14 = r9.rightMargin
            int r7 = r7 + r14
            int r10 = kotlin.ranges.RangesKt.coerceAtLeast((int) r10, (int) r7)
            int r7 = r0.f40666b
            if (r7 != 0) goto L_0x0070
            int r7 = r11 + r1
            int r14 = r9.leftMargin
            int r7 = r7 + r14
            int r14 = r9.rightMargin
            int r7 = r7 + r14
            if (r7 <= r3) goto L_0x006d
            r14 = 1
            r0.f40667c = r14
            goto L_0x0078
        L_0x006d:
            r18 = r11
            goto L_0x008e
        L_0x0070:
            r18 = r11
            r11 = 2
            r14 = 1
            if (r7 != r11) goto L_0x007d
            r0.f40667c = r14
        L_0x0078:
            int r12 = r12 + r13
            r14 = r3
        L_0x007a:
            r11 = 0
            r13 = 0
            goto L_0x0092
        L_0x007d:
            if (r7 != r14) goto L_0x008e
            r0.f40667c = r14
            int r7 = r0.f40665a
            int r11 = r3 - r7
            if (r10 <= r11) goto L_0x0089
            r14 = r3
            goto L_0x008c
        L_0x0089:
            int r7 = r3 - r7
            r14 = r7
        L_0x008c:
            int r12 = r12 + r13
            goto L_0x007a
        L_0x008e:
            r14 = r17
            r11 = r18
        L_0x0092:
            int r7 = r9.leftMargin
            int r1 = r1 + r7
            int r7 = r9.rightMargin
            int r1 = r1 + r7
            int r11 = r11 + r1
            int r13 = kotlin.ranges.RangesKt.coerceAtLeast((int) r13, (int) r4)
            int r1 = r5 + -1
            if (r6 != r1) goto L_0x00ab
            boolean r1 = r0.f40667c
            if (r1 == 0) goto L_0x00a9
            int r4 = r4 + -2
            int r12 = r12 + r4
            goto L_0x00ab
        L_0x00a9:
            int r14 = r14 + r11
            int r12 = r12 + r13
        L_0x00ab:
            if (r15 < r5) goto L_0x00b1
            r15 = r12
            r4 = r14
            goto L_0x012c
        L_0x00b1:
            r1 = r20
            r6 = r15
            r4 = 0
            goto L_0x0022
        L_0x00b7:
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            r1.<init>(r8)
            throw r1
        L_0x00bd:
            if (r5 <= 0) goto L_0x012a
            r1 = 0
            r4 = 0
            r6 = 0
            r7 = 0
        L_0x00c3:
            int r9 = r1 + 1
            android.view.View r10 = r0.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r11 = r10.getLayoutParams()
            if (r11 == 0) goto L_0x0124
            android.widget.RelativeLayout$LayoutParams r11 = (android.widget.RelativeLayout.LayoutParams) r11
            int r12 = r11.leftMargin
            int r13 = r11.rightMargin
            int r12 = r12 + r13
            int r13 = r11.width
            r14 = r20
            int r12 = android.widget.RelativeLayout.getChildMeasureSpec(r14, r12, r13)
            int r13 = r11.height
            r15 = 0
            int r13 = android.widget.RelativeLayout.getChildMeasureSpec(r2, r15, r13)
            r10.measure(r12, r13)
            int r12 = r10.getMeasuredWidth()
            int r10 = r10.getMeasuredHeight()
            int r13 = r11.leftMargin
            int r12 = r12 + r13
            int r11 = r11.rightMargin
            int r12 = r12 + r11
            int r4 = kotlin.ranges.RangesKt.coerceAtLeast((int) r4, (int) r12)
            int r11 = r0.f40666b
            if (r11 != 0) goto L_0x0103
            int r6 = r6 + r10
            r7 = r3
            r12 = 2
        L_0x0101:
            r13 = 1
            goto L_0x0117
        L_0x0103:
            r12 = 2
            if (r11 != r12) goto L_0x0109
            int r6 = r6 + r10
            r7 = r3
            goto L_0x0101
        L_0x0109:
            r13 = 1
            if (r11 != r13) goto L_0x0117
            int r7 = r0.f40665a
            int r11 = r3 - r7
            if (r4 <= r11) goto L_0x0114
            r7 = r3
            goto L_0x0116
        L_0x0114:
            int r7 = r3 - r7
        L_0x0116:
            int r6 = r6 + r10
        L_0x0117:
            int r10 = r5 + -1
            if (r1 != r10) goto L_0x011d
            int r6 = r6 + -2
        L_0x011d:
            if (r9 < r5) goto L_0x0122
            r15 = r6
            r4 = r7
            goto L_0x012c
        L_0x0122:
            r1 = r9
            goto L_0x00c3
        L_0x0124:
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            r1.<init>(r8)
            throw r1
        L_0x012a:
            r15 = 0
            r4 = 0
        L_0x012c:
            r0.setMeasuredDimension(r4, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.blocks.view.PriceActionInnerView.onMeasure(int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f40667c || this.f40668d) {
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
                        int i8 = i6 - 2;
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

    public final boolean isPriceTextWrapNeed() {
        return this.f40667c;
    }

    public final void setPriceTextWrap(boolean z) {
        if (!z) {
            this.f40667c = false;
            this.f40668d = false;
            return;
        }
        this.f40668d = true;
        if (!this.f40667c) {
            requestLayout();
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/view/PriceActionInnerView$Companion;", "", "()V", "INDEX_ORI_PRICE", "", "INDEX_REAL_PRICE", "TOP_MARGIN", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PriceActionInnerView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
