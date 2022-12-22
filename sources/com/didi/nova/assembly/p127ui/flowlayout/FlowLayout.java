package com.didi.nova.assembly.p127ui.flowlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

/* renamed from: com.didi.nova.assembly.ui.flowlayout.FlowLayout */
class FlowLayout extends ViewGroup {
    public static final int SPACING_ALIGN = -65537;
    public static final int SPACING_AUTO = -65536;

    /* renamed from: a */
    private static final String f29254a = FlowLayout.class.getSimpleName();

    /* renamed from: b */
    private static final int f29255b = -65538;

    /* renamed from: c */
    private static final boolean f29256c = true;

    /* renamed from: d */
    private static final int f29257d = 0;

    /* renamed from: e */
    private static final int f29258e = -65538;

    /* renamed from: f */
    private static final float f29259f = 0.0f;

    /* renamed from: g */
    private static final boolean f29260g = false;

    /* renamed from: h */
    private static final int f29261h = Integer.MAX_VALUE;

    /* renamed from: i */
    private boolean f29262i;

    /* renamed from: j */
    private int f29263j;

    /* renamed from: k */
    private int f29264k;

    /* renamed from: l */
    private float f29265l;

    /* renamed from: m */
    private float f29266m;

    /* renamed from: n */
    private boolean f29267n;

    /* renamed from: o */
    private int f29268o;

    /* renamed from: p */
    private List<Float> f29269p;

    /* renamed from: q */
    private List<Integer> f29270q;

    /* renamed from: r */
    private List<Integer> f29271r;

    public FlowLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x005a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x006e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0047 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FlowLayout(android.content.Context r7, android.util.AttributeSet r8) {
        /*
            r6 = this;
            r6.<init>(r7, r8)
            r0 = 1
            r6.f29262i = r0
            r1 = 0
            r6.f29263j = r1
            r2 = -65538(0xfffffffffffefffe, float:NaN)
            r6.f29264k = r2
            r3 = 0
            r6.f29265l = r3
            r6.f29266m = r3
            r6.f29267n = r1
            r4 = 2147483647(0x7fffffff, float:NaN)
            r6.f29268o = r4
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r6.f29269p = r5
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r6.f29270q = r5
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r6.f29271r = r5
            android.content.res.Resources$Theme r7 = r7.getTheme()
            int[] r5 = com.didi.passenger.C10448R.styleable.FlowLayout
            android.content.res.TypedArray r7 = r7.obtainStyledAttributes(r8, r5, r1, r1)
            r8 = 3
            boolean r8 = r7.getBoolean(r8, r0)     // Catch:{ all -> 0x008b }
            r6.f29262i = r8     // Catch:{ all -> 0x008b }
            int r8 = r7.getInt(r0, r1)     // Catch:{ NumberFormatException -> 0x0047 }
            r6.f29263j = r8     // Catch:{ NumberFormatException -> 0x0047 }
            goto L_0x0052
        L_0x0047:
            float r8 = r6.m20639a(r3)     // Catch:{ all -> 0x008b }
            int r8 = (int) r8     // Catch:{ all -> 0x008b }
            int r8 = r7.getDimensionPixelSize(r0, r8)     // Catch:{ all -> 0x008b }
            r6.f29263j = r8     // Catch:{ all -> 0x008b }
        L_0x0052:
            r8 = 2
            int r0 = r7.getInt(r8, r2)     // Catch:{ NumberFormatException -> 0x005a }
            r6.f29264k = r0     // Catch:{ NumberFormatException -> 0x005a }
            goto L_0x0065
        L_0x005a:
            float r0 = r6.m20639a(r3)     // Catch:{ all -> 0x008b }
            int r0 = (int) r0     // Catch:{ all -> 0x008b }
            int r8 = r7.getDimensionPixelSize(r8, r0)     // Catch:{ all -> 0x008b }
            r6.f29264k = r8     // Catch:{ all -> 0x008b }
        L_0x0065:
            r8 = 6
            int r0 = r7.getInt(r8, r1)     // Catch:{ NumberFormatException -> 0x006e }
            float r0 = (float) r0     // Catch:{ NumberFormatException -> 0x006e }
            r6.f29265l = r0     // Catch:{ NumberFormatException -> 0x006e }
            goto L_0x0078
        L_0x006e:
            float r0 = r6.m20639a(r3)     // Catch:{ all -> 0x008b }
            float r8 = r7.getDimension(r8, r0)     // Catch:{ all -> 0x008b }
            r6.f29265l = r8     // Catch:{ all -> 0x008b }
        L_0x0078:
            r8 = 4
            int r8 = r7.getInt(r8, r4)     // Catch:{ all -> 0x008b }
            r6.f29268o = r8     // Catch:{ all -> 0x008b }
            r8 = 8
            boolean r8 = r7.getBoolean(r8, r1)     // Catch:{ all -> 0x008b }
            r6.f29267n = r8     // Catch:{ all -> 0x008b }
            r7.recycle()
            return
        L_0x008b:
            r8 = move-exception
            r7.recycle()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.nova.assembly.p127ui.flowlayout.FlowLayout.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        float f;
        int i11;
        int i12;
        int i13;
        int i14;
        View view;
        int i15;
        int i16;
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        this.f29269p.clear();
        this.f29271r.clear();
        this.f29270q.clear();
        int childCount = getChildCount();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        boolean z = mode != 0 && this.f29262i;
        int i17 = (this.f29263j == -65536 && mode == 0) ? 0 : this.f29263j;
        float f2 = i17 == -65536 ? 0.0f : (float) i17;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        while (i19 < childCount) {
            View childAt = getChildAt(i19);
            int i24 = i18;
            if (childAt.getVisibility() == 8) {
                int i25 = i;
                i11 = i17;
                i8 = size;
                i6 = size2;
                i10 = mode2;
                i7 = childCount;
                i12 = i24;
                i9 = i19;
                f = f2;
                int i26 = i2;
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    i7 = childCount;
                    i14 = i24;
                    i9 = i19;
                    i6 = size2;
                    f = f2;
                    i10 = mode2;
                    view = childAt;
                    i13 = i17;
                    i8 = size;
                    measureChildWithMargins(childAt, i, 0, i2, i22);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i16 = marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                    i15 = marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                    int i27 = i;
                    int i28 = i2;
                } else {
                    i13 = i17;
                    i8 = size;
                    i6 = size2;
                    i10 = mode2;
                    i7 = childCount;
                    i14 = i24;
                    i9 = i19;
                    f = f2;
                    view = childAt;
                    measureChild(view, i, i2);
                    i16 = 0;
                    i15 = 0;
                }
                int measuredWidth = view.getMeasuredWidth() + i16;
                int measuredHeight = view.getMeasuredHeight() + i15;
                if (!z || i14 + measuredWidth <= paddingLeft) {
                    i11 = i13;
                    i20++;
                    i23 = Math.max(i23, measuredHeight);
                    i12 = (int) (((float) i14) + ((float) measuredWidth) + f);
                } else {
                    i11 = i13;
                    this.f29269p.add(Float.valueOf(m20640a(i11, paddingLeft, i14, i20)));
                    this.f29271r.add(Integer.valueOf(i20));
                    this.f29270q.add(Integer.valueOf(i23));
                    if (this.f29269p.size() <= this.f29268o) {
                        i22 += i23;
                    }
                    i21 = Math.max(i21, i14);
                    i12 = ((int) f) + measuredWidth;
                    i23 = measuredHeight;
                    i20 = 1;
                }
            }
            i19 = i9 + 1;
            i18 = i12;
            i17 = i11;
            f2 = f;
            mode2 = i10;
            size = i8;
            childCount = i7;
            size2 = i6;
        }
        int i29 = i18;
        int i30 = i17;
        int i31 = size;
        int i32 = size2;
        int i33 = mode2;
        int i34 = i23;
        int i35 = this.f29264k;
        if (i35 == -65537) {
            if (this.f29269p.size() >= 1) {
                List<Float> list = this.f29269p;
                list.add(list.get(list.size() - 1));
            } else {
                this.f29269p.add(Float.valueOf(m20640a(i30, paddingLeft, i29, i20)));
            }
        } else if (i35 != -65538) {
            this.f29269p.add(Float.valueOf(m20640a(i35, paddingLeft, i29, i20)));
        } else {
            this.f29269p.add(Float.valueOf(m20640a(i30, paddingLeft, i29, i20)));
        }
        this.f29271r.add(Integer.valueOf(i20));
        this.f29270q.add(Integer.valueOf(i34));
        if (this.f29269p.size() <= this.f29268o) {
            i22 += i34;
        }
        int max = Math.max(i21, i29);
        if (i30 == -65536) {
            i4 = i31;
            i3 = i4;
        } else if (mode == 0) {
            i4 = max + getPaddingLeft() + getPaddingRight();
            i3 = i31;
        } else {
            i3 = i31;
            i4 = Math.min(max + getPaddingLeft() + getPaddingRight(), i3);
        }
        int paddingTop = i22 + getPaddingTop() + getPaddingBottom();
        int min = Math.min(this.f29269p.size(), this.f29268o);
        float f3 = (this.f29265l == -65536.0f && i33 == 0) ? 0.0f : this.f29265l;
        if (f3 == -65536.0f) {
            if (min > 1) {
                this.f29266m = (float) ((i32 - paddingTop) / (min - 1));
            } else {
                this.f29266m = 0.0f;
            }
            paddingTop = i32;
            i5 = paddingTop;
        } else {
            this.f29266m = f3;
            if (min > 1) {
                paddingTop = (int) (((float) paddingTop) + (f3 * ((float) (min - 1))));
                if (i33 != 0) {
                    i5 = i32;
                    paddingTop = Math.min(paddingTop, i5);
                }
            }
            i5 = i32;
        }
        setMeasuredDimension(mode == 1073741824 ? i3 : i4, i33 == 1073741824 ? i5 : paddingTop);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        float f;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int width = this.f29267n ? getWidth() - paddingRight : paddingLeft;
        int size = this.f29271r.size();
        int i11 = 0;
        int i12 = 0;
        while (i11 < size) {
            int intValue = this.f29271r.get(i11).intValue();
            int intValue2 = this.f29270q.get(i11).intValue();
            float floatValue = this.f29269p.get(i11).floatValue();
            int i13 = 0;
            while (i13 < intValue && i12 < getChildCount()) {
                int i14 = i12 + 1;
                View childAt = getChildAt(i12);
                if (childAt.getVisibility() != 8) {
                    int i15 = i13 + 1;
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        i6 = marginLayoutParams.leftMargin;
                        i8 = marginLayoutParams.rightMargin;
                        i7 = marginLayoutParams.topMargin;
                        i5 = paddingLeft;
                    } else {
                        i5 = paddingLeft;
                        i8 = 0;
                        i7 = 0;
                        i6 = 0;
                    }
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    int i16 = size;
                    if (this.f29267n) {
                        int i17 = width - i8;
                        i10 = intValue;
                        int i18 = i7 + paddingTop;
                        i9 = i15;
                        childAt.layout(i17 - measuredWidth, i18, i17, i18 + measuredHeight);
                        f = ((float) width) - (((((float) measuredWidth) + floatValue) + ((float) i6)) + ((float) i8));
                    } else {
                        i10 = intValue;
                        i9 = i15;
                        int i19 = width + i6;
                        int i20 = i7 + paddingTop;
                        childAt.layout(i19, i20, i19 + measuredWidth, i20 + measuredHeight);
                        f = ((float) width) + ((float) measuredWidth) + floatValue + ((float) i6) + ((float) i8);
                    }
                    width = (int) f;
                    paddingLeft = i5;
                    size = i16;
                    intValue = i10;
                    i13 = i9;
                }
                i12 = i14;
            }
            int i21 = paddingLeft;
            int i22 = size;
            width = this.f29267n ? getWidth() - paddingRight : i21;
            paddingTop = (int) (((float) paddingTop) + ((float) intValue2) + this.f29266m);
            i11++;
            paddingLeft = i21;
            size = i22;
        }
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public boolean isFlow() {
        return this.f29262i;
    }

    public void setFlow(boolean z) {
        this.f29262i = z;
        requestLayout();
    }

    public int getChildSpacing() {
        return this.f29263j;
    }

    public void setChildSpacing(int i) {
        this.f29263j = i;
        requestLayout();
    }

    public int getChildSpacingForLastRow() {
        return this.f29264k;
    }

    public void setChildSpacingForLastRow(int i) {
        this.f29264k = i;
        requestLayout();
    }

    public float getRowSpacing() {
        return this.f29265l;
    }

    public void setRowSpacing(float f) {
        this.f29265l = f;
        requestLayout();
    }

    public int getMaxRows() {
        return this.f29268o;
    }

    public void setMaxRows(int i) {
        this.f29268o = i;
        requestLayout();
    }

    /* renamed from: a */
    private float m20640a(int i, int i2, int i3, int i4) {
        if (i != -65536) {
            return (float) i;
        }
        if (i4 > 1) {
            return (float) ((i2 - i3) / (i4 - 1));
        }
        return 0.0f;
    }

    /* renamed from: a */
    private float m20639a(float f) {
        return TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    public int getViewCountForRow(int i) {
        return this.f29271r.get(i).intValue();
    }

    public int getDataMaxRows() {
        return this.f29271r.size();
    }

    public int getHeightForRow(int i) {
        return this.f29270q.get(i).intValue();
    }

    public int getVisibleViewCount() {
        int min = Math.min(this.f29271r.size(), this.f29268o);
        int i = 0;
        for (int i2 = 0; i2 < min; i2++) {
            i += this.f29271r.get(i2).intValue();
        }
        return i;
    }
}
