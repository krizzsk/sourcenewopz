package com.adyen.threeds2.internal.p059ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.didi.passenger.C10448R;
import com.taxis99.R;

/* renamed from: com.adyen.threeds2.internal.ui.widget.DividerView */
public final class DividerView extends View {

    /* renamed from: d */
    private static final C1424b f1064d = C1424b.HORIZONTAL;

    /* renamed from: a */
    private C1424b f1065a;

    /* renamed from: b */
    private int f1066b;

    /* renamed from: c */
    private int f1067c;

    /* renamed from: com.adyen.threeds2.internal.ui.widget.DividerView$a */
    static /* synthetic */ class C1423a {

        /* renamed from: a */
        static final /* synthetic */ int[] f1068a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.adyen.threeds2.internal.ui.widget.DividerView$b[] r0 = com.adyen.threeds2.internal.p059ui.widget.DividerView.C1424b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1068a = r0
                com.adyen.threeds2.internal.ui.widget.DividerView$b r1 = com.adyen.threeds2.internal.p059ui.widget.DividerView.C1424b.HORIZONTAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f1068a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.adyen.threeds2.internal.ui.widget.DividerView$b r1 = com.adyen.threeds2.internal.p059ui.widget.DividerView.C1424b.VERTICAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.adyen.threeds2.internal.p059ui.widget.DividerView.C1423a.<clinit>():void");
        }
    }

    /* renamed from: com.adyen.threeds2.internal.ui.widget.DividerView$b */
    public enum C1424b {
        HORIZONTAL,
        VERTICAL
    }

    public DividerView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* renamed from: a */
    private void m1210a(TypedArray typedArray) {
        setColor(typedArray.getColor(0, getDefaultColor()));
        setThickness((int) typedArray.getDimension(2, (float) getDefaultThickness()));
        setOrientation(C1424b.values()[typedArray.getInteger(1, f1064d.ordinal())]);
    }

    private int getDefaultColor() {
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(16842808, typedValue, true);
        return typedValue.data;
    }

    private int getDefaultThickness() {
        return (int) getContext().getResources().getDimension(R.dimen.a3ds2_divider_thickness);
    }

    public int getColor() {
        return this.f1067c;
    }

    public C1424b getOrientation() {
        return this.f1065a;
    }

    public int getThickness() {
        return this.f1066b;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int defaultSize = View.getDefaultSize(getSuggestedMinimumWidth(), i);
        int defaultSize2 = View.getDefaultSize(getSuggestedMinimumHeight(), i2);
        if (this.f1066b > 0) {
            int i3 = C1423a.f1068a[this.f1065a.ordinal()];
            if (i3 == 1) {
                defaultSize2 = this.f1066b;
            } else if (i3 == 2) {
                defaultSize = this.f1066b;
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    public void setColor(int i) {
        this.f1067c = i;
        setBackgroundColor(i);
    }

    public void setOrientation(C1424b bVar) {
        this.f1065a = bVar;
    }

    public void setThickness(int i) {
        this.f1066b = i;
    }

    public DividerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C10448R.styleable.DividerView, i, 0);
        try {
            m1210a(obtainStyledAttributes);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public DividerView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C10448R.styleable.DividerView, i, i2);
        try {
            m1210a(obtainStyledAttributes);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
