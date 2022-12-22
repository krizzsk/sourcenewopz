package com.didi.global.fintech.cashier.p117ui.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.passenger.C10448R;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.global.fintech.cashier.ui.widget.LabelsView */
public class LabelsView extends ViewGroup implements View.OnClickListener, View.OnLongClickListener {

    /* renamed from: F */
    private static final String f21877F = "key_super_state";

    /* renamed from: G */
    private static final String f21878G = "key_text_color_state";

    /* renamed from: H */
    private static final String f21879H = "key_text_size_state";

    /* renamed from: I */
    private static final String f21880I = "key_bg_res_id_state";

    /* renamed from: J */
    private static final String f21881J = "key_padding_state";

    /* renamed from: K */
    private static final String f21882K = "key_word_margin_state";

    /* renamed from: L */
    private static final String f21883L = "key_line_margin_state";

    /* renamed from: M */
    private static final String f21884M = "key_select_type_state";

    /* renamed from: N */
    private static final String f21885N = "key_max_select_state";

    /* renamed from: O */
    private static final String f21886O = "key_min_select_state";

    /* renamed from: P */
    private static final String f21887P = "key_max_lines_state";

    /* renamed from: Q */
    private static final String f21888Q = "key_max_columns_state";

    /* renamed from: R */
    private static final String f21889R = "key_indicator_state";

    /* renamed from: S */
    private static final String f21890S = "key_labels_state";

    /* renamed from: T */
    private static final String f21891T = "key_select_labels_state";

    /* renamed from: U */
    private static final String f21892U = "key_select_compulsory_state";

    /* renamed from: V */
    private static final String f21893V = "key_label_width_state";

    /* renamed from: W */
    private static final String f21894W = "key_label_height_state";

    /* renamed from: X */
    private static final String f21895X = "key_label_gravity_state";

    /* renamed from: Y */
    private static final String f21896Y = "key_single_line_state";

    /* renamed from: Z */
    private static final String f21897Z = "key_text_style_state";

    /* renamed from: v */
    private static final int f21898v = 2131434418;

    /* renamed from: w */
    private static final int f21899w = 2131434419;

    /* renamed from: A */
    private int f21900A;

    /* renamed from: B */
    private OnLabelClickListener f21901B;

    /* renamed from: C */
    private OnLabelLongClickListener f21902C;

    /* renamed from: D */
    private OnLabelSelectChangeListener f21903D;

    /* renamed from: E */
    private OnSelectChangeIntercept f21904E;

    /* renamed from: a */
    private Context f21905a;

    /* renamed from: b */
    private ColorStateList f21906b;

    /* renamed from: c */
    private float f21907c;

    /* renamed from: d */
    private Drawable f21908d;

    /* renamed from: e */
    private int f21909e = -2;

    /* renamed from: f */
    private int f21910f = -2;

    /* renamed from: g */
    private int f21911g = 17;

    /* renamed from: h */
    private int f21912h;

    /* renamed from: i */
    private int f21913i;

    /* renamed from: j */
    private int f21914j;

    /* renamed from: k */
    private int f21915k;

    /* renamed from: l */
    private int f21916l;

    /* renamed from: m */
    private int f21917m;

    /* renamed from: n */
    private SelectType f21918n;

    /* renamed from: o */
    private int f21919o;

    /* renamed from: p */
    private int f21920p;

    /* renamed from: q */
    private int f21921q;

    /* renamed from: r */
    private int f21922r;

    /* renamed from: s */
    private boolean f21923s = false;

    /* renamed from: t */
    private boolean f21924t = false;

    /* renamed from: u */
    private boolean f21925u;

    /* renamed from: x */
    private ArrayList<Object> f21926x = new ArrayList<>();

    /* renamed from: y */
    private ArrayList<Integer> f21927y = new ArrayList<>();

    /* renamed from: z */
    private ArrayList<Integer> f21928z = new ArrayList<>();

    /* renamed from: com.didi.global.fintech.cashier.ui.widget.LabelsView$LabelTextProvider */
    public interface LabelTextProvider<T> {
        CharSequence getLabelText(TextView textView, int i, T t);
    }

    /* renamed from: com.didi.global.fintech.cashier.ui.widget.LabelsView$OnLabelClickListener */
    public interface OnLabelClickListener {
        void onLabelClick(TextView textView, Object obj, int i);
    }

    /* renamed from: com.didi.global.fintech.cashier.ui.widget.LabelsView$OnLabelLongClickListener */
    public interface OnLabelLongClickListener {
        boolean onLabelLongClick(TextView textView, Object obj, int i);
    }

    /* renamed from: com.didi.global.fintech.cashier.ui.widget.LabelsView$OnLabelSelectChangeListener */
    public interface OnLabelSelectChangeListener {
        void onLabelSelectChange(TextView textView, Object obj, boolean z, int i);
    }

    /* renamed from: com.didi.global.fintech.cashier.ui.widget.LabelsView$OnSelectChangeIntercept */
    public interface OnSelectChangeIntercept {
        boolean onIntercept(TextView textView, Object obj, boolean z, boolean z2, int i);
    }

    /* renamed from: com.didi.global.fintech.cashier.ui.widget.LabelsView$Selectable */
    public interface Selectable {
        boolean isSelected();

        void onSelected(boolean z);
    }

    /* renamed from: com.didi.global.fintech.cashier.ui.widget.LabelsView$SelectType */
    public enum SelectType {
        NONE(1),
        SINGLE(2),
        SINGLE_IRREVOCABLY(3),
        MULTI(4);
        
        int value;

        private SelectType(int i) {
            this.value = i;
        }

        static SelectType get(int i) {
            if (i == 1) {
                return NONE;
            }
            if (i == 2) {
                return SINGLE;
            }
            if (i == 3) {
                return SINGLE_IRREVOCABLY;
            }
            if (i != 4) {
                return NONE;
            }
            return MULTI;
        }
    }

    public LabelsView(Context context) {
        super(context);
        this.f21905a = context;
        m15843a();
    }

    public LabelsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21905a = context;
        m15845a(context, attributeSet);
        m15843a();
    }

    public LabelsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f21905a = context;
        m15845a(context, attributeSet);
        m15843a();
    }

    /* renamed from: a */
    private void m15845a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.LabelsView);
            this.f21918n = SelectType.get(obtainStyledAttributes.getInt(18, 1));
            this.f21919o = obtainStyledAttributes.getInteger(16, 0);
            this.f21920p = obtainStyledAttributes.getInteger(17, 0);
            this.f21921q = obtainStyledAttributes.getInteger(15, 0);
            this.f21922r = obtainStyledAttributes.getInteger(14, 0);
            this.f21925u = obtainStyledAttributes.getBoolean(0, false);
            this.f21911g = obtainStyledAttributes.getInt(3, this.f21911g);
            this.f21909e = obtainStyledAttributes.getLayoutDimension(12, this.f21909e);
            this.f21910f = obtainStyledAttributes.getLayoutDimension(5, this.f21910f);
            if (obtainStyledAttributes.hasValue(4)) {
                this.f21906b = obtainStyledAttributes.getColorStateList(4);
            } else {
                this.f21906b = ColorStateList.valueOf(-16777216);
            }
            this.f21907c = obtainStyledAttributes.getDimension(11, (float) m15842a(14.0f));
            if (obtainStyledAttributes.hasValue(6)) {
                int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(6, 0);
                this.f21915k = dimensionPixelOffset;
                this.f21914j = dimensionPixelOffset;
                this.f21913i = dimensionPixelOffset;
                this.f21912h = dimensionPixelOffset;
            } else {
                this.f21912h = obtainStyledAttributes.getDimensionPixelOffset(8, m15849b(10.0f));
                this.f21913i = obtainStyledAttributes.getDimensionPixelOffset(10, m15849b(5.0f));
                this.f21914j = obtainStyledAttributes.getDimensionPixelOffset(9, m15849b(10.0f));
                this.f21915k = obtainStyledAttributes.getDimensionPixelOffset(7, m15849b(5.0f));
            }
            this.f21917m = obtainStyledAttributes.getDimensionPixelOffset(13, m15849b(5.0f));
            this.f21916l = obtainStyledAttributes.getDimensionPixelOffset(20, m15849b(5.0f));
            if (obtainStyledAttributes.hasValue(2)) {
                int resourceId = obtainStyledAttributes.getResourceId(2, 0);
                if (resourceId != 0) {
                    this.f21908d = ContextCompat.getDrawable(this.f21905a, resourceId);
                } else {
                    this.f21908d = new ColorDrawable(obtainStyledAttributes.getColor(2, 0));
                }
            } else {
                this.f21908d = ContextCompat.getDrawable(this.f21905a, R.drawable.shape_label_bg);
            }
            this.f21923s = obtainStyledAttributes.getBoolean(19, false);
            this.f21924t = obtainStyledAttributes.getBoolean(1, false);
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: a */
    private void m15843a() {
        if (isInEditMode()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("Label 1");
            arrayList.add("Label 2");
            arrayList.add("Label 3");
            arrayList.add("Label 4");
            arrayList.add("Label 5");
            arrayList.add("Label 6");
            arrayList.add("Label 7");
            setLabels(arrayList);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.f21923s) {
            m15844a(i, i2);
        } else {
            m15851b(i, i2);
        }
    }

    /* renamed from: a */
    private void m15844a(int i, int i2) {
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            int i7 = this.f21922r;
            if (i7 > 0 && i6 == i7) {
                break;
            }
            View childAt = getChildAt(i6);
            measureChild(childAt, i, i2);
            i4 += childAt.getMeasuredWidth();
            if (i6 != childCount - 1) {
                i4 += this.f21916l;
            }
            i5 = Math.max(i5, childAt.getMeasuredHeight());
        }
        setMeasuredDimension(m15852c(i, i4 + getPaddingLeft() + getPaddingRight()), m15852c(i2, i5 + getPaddingTop() + getPaddingBottom()));
        if (childCount > 0) {
            i3 = 1;
        }
        this.f21900A = i3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0039, code lost:
        r10 = r10 - 1;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m15851b(int r14, int r15) {
        /*
            r13 = this;
            int r0 = r13.getChildCount()
            int r1 = android.view.View.MeasureSpec.getSize(r14)
            int r2 = r13.getPaddingLeft()
            int r1 = r1 - r2
            int r2 = r13.getPaddingRight()
            int r1 = r1 - r2
            r2 = 1
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 1
        L_0x001b:
            if (r4 >= r0) goto L_0x0079
            android.view.View r11 = r13.getChildAt(r4)
            r13.measureChild(r11, r14, r15)
            int r12 = r11.getMeasuredWidth()
            int r12 = r12 + r5
            if (r12 > r1) goto L_0x0031
            int r12 = r13.f21922r
            if (r12 <= 0) goto L_0x0047
            if (r6 != r12) goto L_0x0047
        L_0x0031:
            int r10 = r10 + 1
            int r6 = r13.f21921q
            if (r6 <= 0) goto L_0x003c
            if (r10 <= r6) goto L_0x003c
        L_0x0039:
            int r10 = r10 + -1
            goto L_0x0079
        L_0x003c:
            int r6 = r13.f21917m
            int r8 = r8 + r6
            int r8 = r8 + r7
            int r9 = java.lang.Math.max(r9, r5)
            r5 = 0
            r6 = 0
            r7 = 0
        L_0x0047:
            int r12 = r11.getMeasuredWidth()
            int r5 = r5 + r12
            int r6 = r6 + r2
            int r11 = r11.getMeasuredHeight()
            int r7 = java.lang.Math.max(r7, r11)
            int r11 = r0 + -1
            if (r4 == r11) goto L_0x0076
            int r11 = r13.f21916l
            int r12 = r5 + r11
            if (r12 <= r1) goto L_0x0075
            int r10 = r10 + 1
            int r6 = r13.f21921q
            if (r6 <= 0) goto L_0x0068
            if (r10 <= r6) goto L_0x0068
            goto L_0x0039
        L_0x0068:
            int r6 = r13.f21917m
            int r8 = r8 + r6
            int r8 = r8 + r7
            int r5 = java.lang.Math.max(r9, r5)
            r9 = r5
            r5 = 0
            r6 = 0
            r7 = 0
            goto L_0x0076
        L_0x0075:
            int r5 = r5 + r11
        L_0x0076:
            int r4 = r4 + 1
            goto L_0x001b
        L_0x0079:
            int r8 = r8 + r7
            int r1 = java.lang.Math.max(r9, r5)
            int r2 = r13.getPaddingLeft()
            int r1 = r1 + r2
            int r2 = r13.getPaddingRight()
            int r1 = r1 + r2
            int r14 = r13.m15852c(r14, r1)
            int r1 = r13.getPaddingTop()
            int r8 = r8 + r1
            int r1 = r13.getPaddingBottom()
            int r8 = r8 + r1
            int r15 = r13.m15852c(r15, r8)
            r13.setMeasuredDimension(r14, r15)
            if (r0 <= 0) goto L_0x00a0
            r3 = r10
        L_0x00a0:
            r13.f21900A = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.p117ui.widget.LabelsView.m15851b(int, int):void");
    }

    /* renamed from: c */
    private int m15852c(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            i2 = size;
        } else if (mode == Integer.MIN_VALUE) {
            i2 = Math.min(i2, size);
        }
        return resolveSizeAndState(Math.max(i2, getSuggestedMinimumWidth()), i, 0);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i7 = i3 - i;
        int childCount = getChildCount();
        int i8 = 1;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i9 < childCount) {
            View childAt = getChildAt(i9);
            if (!this.f21923s && (i7 < childAt.getMeasuredWidth() + paddingLeft + getPaddingRight() || ((i6 = this.f21922r) > 0 && i10 == i6))) {
                i8++;
                int i12 = this.f21921q;
                if (i12 <= 0 || i8 <= i12) {
                    paddingLeft = getPaddingLeft();
                    paddingTop = paddingTop + this.f21917m + i11;
                    i10 = 0;
                    i11 = 0;
                } else {
                    return;
                }
            }
            if (!this.f21923s || (i5 = this.f21922r) <= 0 || i10 != i5) {
                childAt.layout(paddingLeft, paddingTop, childAt.getMeasuredWidth() + paddingLeft, childAt.getMeasuredHeight() + paddingTop);
                paddingLeft = paddingLeft + childAt.getMeasuredWidth() + this.f21916l;
                i11 = Math.max(i11, childAt.getMeasuredHeight());
                i10++;
                i9++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(f21877F, super.onSaveInstanceState());
        ColorStateList colorStateList = this.f21906b;
        if (colorStateList != null) {
            bundle.putParcelable(f21878G, colorStateList);
        }
        bundle.putFloat(f21879H, this.f21907c);
        bundle.putInt(f21893V, this.f21909e);
        bundle.putInt(f21894W, this.f21910f);
        bundle.putInt(f21895X, this.f21911g);
        bundle.putIntArray(f21881J, new int[]{this.f21912h, this.f21913i, this.f21914j, this.f21915k});
        bundle.putInt(f21882K, this.f21916l);
        bundle.putInt(f21883L, this.f21917m);
        bundle.putInt(f21884M, this.f21918n.value);
        bundle.putInt(f21885N, this.f21919o);
        bundle.putInt(f21886O, this.f21920p);
        bundle.putInt(f21887P, this.f21921q);
        bundle.putInt(f21888Q, this.f21922r);
        bundle.putBoolean(f21889R, this.f21925u);
        if (!this.f21927y.isEmpty()) {
            bundle.putIntegerArrayList(f21891T, this.f21927y);
        }
        if (!this.f21928z.isEmpty()) {
            bundle.putIntegerArrayList(f21892U, this.f21928z);
        }
        bundle.putBoolean(f21896Y, this.f21923s);
        bundle.putBoolean(f21897Z, this.f21924t);
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            super.onRestoreInstanceState(bundle.getParcelable(f21877F));
            ColorStateList colorStateList = (ColorStateList) bundle.getParcelable(f21878G);
            if (colorStateList != null) {
                setLabelTextColor(colorStateList);
            }
            setLabelTextSize(bundle.getFloat(f21879H, this.f21907c));
            this.f21909e = bundle.getInt(f21893V, this.f21909e);
            this.f21910f = bundle.getInt(f21894W, this.f21910f);
            setLabelGravity(bundle.getInt(f21895X, this.f21911g));
            int[] intArray = bundle.getIntArray(f21881J);
            if (intArray != null && intArray.length == 4) {
                setLabelTextPadding(intArray[0], intArray[1], intArray[2], intArray[3]);
            }
            setWordMargin(bundle.getInt(f21882K, this.f21916l));
            setLineMargin(bundle.getInt(f21883L, this.f21917m));
            setSelectType(SelectType.get(bundle.getInt(f21884M, this.f21918n.value)));
            setMaxSelect(bundle.getInt(f21885N, this.f21919o));
            setMinSelect(bundle.getInt(f21886O, this.f21920p));
            setMaxLines(bundle.getInt(f21887P, this.f21921q));
            setMaxLines(bundle.getInt(f21888Q, this.f21922r));
            setIndicator(bundle.getBoolean(f21889R, this.f21925u));
            setSingleLine(bundle.getBoolean(f21896Y, this.f21923s));
            setTextBold(bundle.getBoolean(f21897Z, this.f21924t));
            ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList(f21892U);
            if (integerArrayList != null && !integerArrayList.isEmpty()) {
                setCompulsorys((List<Integer>) integerArrayList);
            }
            ArrayList<Integer> integerArrayList2 = bundle.getIntegerArrayList(f21891T);
            if (integerArrayList2 != null && !integerArrayList2.isEmpty()) {
                int size = integerArrayList2.size();
                int[] iArr = new int[size];
                for (int i = 0; i < size; i++) {
                    iArr[i] = integerArrayList2.get(i).intValue();
                }
                setSelects(iArr);
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void setLabels(List<String> list) {
        setLabels(list, new LabelTextProvider<String>() {
            public CharSequence getLabelText(TextView textView, int i, String str) {
                return str.trim();
            }
        });
    }

    public <T> void setLabels(List<T> list, LabelTextProvider<T> labelTextProvider) {
        m15853c();
        removeAllViews();
        this.f21926x.clear();
        if (list != null) {
            this.f21926x.addAll(list);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                m15847a(list.get(i), i, labelTextProvider);
            }
            m15850b();
        }
        if (this.f21918n == SelectType.SINGLE_IRREVOCABLY) {
            setSelects(0);
        }
    }

    public <T> List<T> getLabels() {
        return this.f21926x;
    }

    /* renamed from: a */
    private <T> void m15847a(T t, int i, LabelTextProvider<T> labelTextProvider) {
        TextView textView = new TextView(this.f21905a);
        textView.setPadding(this.f21912h, this.f21913i, this.f21914j, this.f21915k);
        textView.setTextSize(0, this.f21907c);
        textView.setGravity(this.f21911g);
        textView.setTextColor(this.f21906b);
        textView.setBackgroundDrawable(this.f21908d.getConstantState().newDrawable());
        textView.setTag(f21898v, t);
        textView.setTag(f21899w, Integer.valueOf(i));
        textView.setOnClickListener(this);
        textView.setOnLongClickListener(this);
        textView.getPaint().setFakeBoldText(this.f21924t);
        addView(textView, this.f21909e, this.f21910f);
        textView.setText(labelTextProvider.getLabelText(textView, i, t));
    }

    /* renamed from: b */
    private void m15850b() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ((TextView) getChildAt(i)).setClickable((this.f21901B == null && this.f21902C == null && this.f21918n == SelectType.NONE) ? false : true);
        }
    }

    public void onClick(View view) {
        int i;
        AutoTrackHelper.trackViewOnClick(view);
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (!this.f21925u && this.f21918n != SelectType.NONE) {
                boolean z = true;
                if (textView.isSelected()) {
                    if (!((this.f21918n == SelectType.MULTI && this.f21928z.contains((Integer) textView.getTag(f21899w))) || (this.f21918n == SelectType.MULTI && this.f21927y.size() <= this.f21920p)) && this.f21918n != SelectType.SINGLE_IRREVOCABLY) {
                        z = false;
                    }
                    if (!z && !m15848a(textView)) {
                        m15846a(textView, false);
                    }
                } else if (this.f21918n == SelectType.SINGLE || this.f21918n == SelectType.SINGLE_IRREVOCABLY) {
                    if (!m15848a(textView)) {
                        m15853c();
                        m15846a(textView, true);
                    }
                } else if (this.f21918n == SelectType.MULTI && (((i = this.f21919o) <= 0 || i > this.f21927y.size()) && !m15848a(textView))) {
                    m15846a(textView, true);
                }
            }
            OnLabelClickListener onLabelClickListener = this.f21901B;
            if (onLabelClickListener != null) {
                onLabelClickListener.onLabelClick(textView, textView.getTag(f21898v), ((Integer) textView.getTag(f21899w)).intValue());
            }
        }
    }

    public boolean onLongClick(View view) {
        if (!(view instanceof TextView)) {
            return false;
        }
        TextView textView = (TextView) view;
        OnLabelLongClickListener onLabelLongClickListener = this.f21902C;
        if (onLabelLongClickListener != null) {
            return onLabelLongClickListener.onLabelLongClick(textView, textView.getTag(f21898v), ((Integer) textView.getTag(f21899w)).intValue());
        }
        return false;
    }

    /* renamed from: a */
    private void m15846a(TextView textView, boolean z) {
        if (textView.isSelected() != z) {
            textView.setSelected(z);
            if (z) {
                this.f21927y.add((Integer) textView.getTag(f21899w));
            } else {
                this.f21927y.remove((Integer) textView.getTag(f21899w));
            }
            OnLabelSelectChangeListener onLabelSelectChangeListener = this.f21903D;
            if (onLabelSelectChangeListener != null) {
                onLabelSelectChangeListener.onLabelSelectChange(textView, textView.getTag(f21898v), z, ((Integer) textView.getTag(f21899w)).intValue());
            }
        }
    }

    /* renamed from: a */
    private boolean m15848a(TextView textView) {
        OnSelectChangeIntercept onSelectChangeIntercept = this.f21904E;
        if (onSelectChangeIntercept != null) {
            if (onSelectChangeIntercept.onIntercept(textView, textView.getTag(f21898v), textView.isSelected(), !textView.isSelected(), ((Integer) textView.getTag(f21899w)).intValue())) {
                return true;
            }
        }
        return false;
    }

    public void clearAllSelect() {
        if (this.f21918n == SelectType.SINGLE_IRREVOCABLY) {
            return;
        }
        if (this.f21918n != SelectType.MULTI || this.f21928z.isEmpty()) {
            m15853c();
        } else {
            m15854d();
        }
    }

    /* renamed from: c */
    private void m15853c() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            m15846a((TextView) getChildAt(i), false);
        }
        this.f21927y.clear();
    }

    /* renamed from: d */
    private void m15854d() {
        int childCount = getChildCount();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < childCount; i++) {
            if (!this.f21928z.contains(Integer.valueOf(i))) {
                m15846a((TextView) getChildAt(i), false);
                arrayList.add(Integer.valueOf(i));
            }
        }
        this.f21927y.removeAll(arrayList);
    }

    public void setSelects(List<Integer> list) {
        if (list != null) {
            int size = list.size();
            int[] iArr = new int[size];
            for (int i = 0; i < size; i++) {
                iArr[i] = list.get(i).intValue();
            }
            setSelects(iArr);
        }
    }

    public void setSelects(int... iArr) {
        if (this.f21918n != SelectType.NONE) {
            ArrayList arrayList = new ArrayList();
            int childCount = getChildCount();
            int i = (this.f21918n == SelectType.SINGLE || this.f21918n == SelectType.SINGLE_IRREVOCABLY) ? 1 : this.f21919o;
            for (int i2 : iArr) {
                if (i2 < childCount) {
                    TextView textView = (TextView) getChildAt(i2);
                    if (!arrayList.contains(textView)) {
                        m15846a(textView, true);
                        arrayList.add(textView);
                    }
                    if (i > 0 && arrayList.size() == i) {
                        break;
                    }
                }
            }
            for (int i3 = 0; i3 < childCount; i3++) {
                TextView textView2 = (TextView) getChildAt(i3);
                if (!arrayList.contains(textView2)) {
                    m15846a(textView2, false);
                }
            }
        }
    }

    public void setCompulsorys(List<Integer> list) {
        if (this.f21918n == SelectType.MULTI && list != null) {
            this.f21928z.clear();
            this.f21928z.addAll(list);
            m15853c();
            setSelects(list);
        }
    }

    public void setCompulsorys(int... iArr) {
        if (this.f21918n == SelectType.MULTI && iArr != null) {
            ArrayList arrayList = new ArrayList(iArr.length);
            for (int valueOf : iArr) {
                arrayList.add(Integer.valueOf(valueOf));
            }
            setCompulsorys((List<Integer>) arrayList);
        }
    }

    public List<Integer> getCompulsorys() {
        return this.f21928z;
    }

    public void clearCompulsorys() {
        if (this.f21918n == SelectType.MULTI && !this.f21928z.isEmpty()) {
            this.f21928z.clear();
            m15853c();
        }
    }

    public List<Integer> getSelectLabels() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f21927y);
        return arrayList;
    }

    public <T> List<T> getSelectLabelDatas() {
        ArrayList arrayList = new ArrayList();
        int size = this.f21927y.size();
        for (int i = 0; i < size; i++) {
            Object tag = getChildAt(this.f21927y.get(i).intValue()).getTag(f21898v);
            if (tag != null) {
                arrayList.add(tag);
            }
        }
        return arrayList;
    }

    public void setLabelBackgroundResource(int i) {
        setLabelBackgroundDrawable(ContextCompat.getDrawable(this.f21905a, i));
    }

    public void setLabelBackgroundColor(int i) {
        setLabelBackgroundDrawable(new ColorDrawable(i));
    }

    public void setLabelBackgroundDrawable(Drawable drawable) {
        this.f21908d = drawable;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ((TextView) getChildAt(i)).setBackground(this.f21908d.getConstantState().newDrawable());
        }
    }

    public void setLabelTextPadding(int i, int i2, int i3, int i4) {
        if (this.f21912h != i || this.f21913i != i2 || this.f21914j != i3 || this.f21915k != i4) {
            this.f21912h = i;
            this.f21913i = i2;
            this.f21914j = i3;
            this.f21915k = i4;
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                ((TextView) getChildAt(i5)).setPadding(i, i2, i3, i4);
            }
        }
    }

    public int getTextPaddingLeft() {
        return this.f21912h;
    }

    public int getTextPaddingTop() {
        return this.f21913i;
    }

    public int getTextPaddingRight() {
        return this.f21914j;
    }

    public int getTextPaddingBottom() {
        return this.f21915k;
    }

    public void setLabelTextSize(float f) {
        if (this.f21907c != f) {
            this.f21907c = f;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                ((TextView) getChildAt(i)).setTextSize(0, f);
            }
        }
    }

    public float getLabelTextSize() {
        return this.f21907c;
    }

    public void setLabelTextColor(int i) {
        setLabelTextColor(ColorStateList.valueOf(i));
    }

    public void setLabelTextColor(ColorStateList colorStateList) {
        this.f21906b = colorStateList;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ((TextView) getChildAt(i)).setTextColor(this.f21906b);
        }
    }

    public ColorStateList getLabelTextColor() {
        return this.f21906b;
    }

    public void setLabelGravity(int i) {
        if (this.f21911g != i) {
            this.f21911g = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                ((TextView) getChildAt(i2)).setGravity(i);
            }
        }
    }

    public int getLabelGravity() {
        return this.f21911g;
    }

    public void setTextBold(boolean z) {
        if (this.f21924t != z) {
            this.f21924t = z;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                TextView textView = (TextView) getChildAt(i);
                textView.getPaint().setFakeBoldText(this.f21924t);
                textView.invalidate();
            }
        }
    }

    public boolean isTextBold() {
        return this.f21924t;
    }

    public void setLineMargin(int i) {
        if (this.f21917m != i) {
            this.f21917m = i;
            requestLayout();
        }
    }

    public int getLineMargin() {
        return this.f21917m;
    }

    public void setWordMargin(int i) {
        if (this.f21916l != i) {
            this.f21916l = i;
            requestLayout();
        }
    }

    public int getWordMargin() {
        return this.f21916l;
    }

    public void setSelectType(SelectType selectType) {
        if (this.f21918n != selectType) {
            this.f21918n = selectType;
            m15853c();
            if (this.f21918n == SelectType.SINGLE_IRREVOCABLY) {
                setSelects(0);
            }
            if (this.f21918n != SelectType.MULTI) {
                this.f21928z.clear();
            }
            m15850b();
        }
    }

    public SelectType getSelectType() {
        return this.f21918n;
    }

    public void setMaxSelect(int i) {
        if (this.f21919o != i) {
            this.f21919o = i;
            if (this.f21918n == SelectType.MULTI) {
                m15853c();
            }
        }
    }

    public int getMaxSelect() {
        return this.f21919o;
    }

    public void setMinSelect(int i) {
        this.f21920p = i;
    }

    public int getMinSelect() {
        return this.f21920p;
    }

    public void setMaxLines(int i) {
        if (this.f21921q != i) {
            this.f21921q = i;
            requestLayout();
        }
    }

    public int getMaxLines() {
        return this.f21921q;
    }

    public void setMaxColumns(int i) {
        if (this.f21922r != i) {
            this.f21922r = i;
            requestLayout();
        }
    }

    public int getMaxColumns() {
        return this.f21922r;
    }

    public void setIndicator(boolean z) {
        this.f21925u = z;
    }

    public boolean isIndicator() {
        return this.f21925u;
    }

    public void setSingleLine(boolean z) {
        if (this.f21923s != z) {
            this.f21923s = z;
            requestLayout();
        }
    }

    public boolean isSingleLine() {
        return this.f21923s;
    }

    public int getLines() {
        return this.f21900A;
    }

    public void setOnLabelClickListener(OnLabelClickListener onLabelClickListener) {
        this.f21901B = onLabelClickListener;
        m15850b();
    }

    public void setOnLabelLongClickListener(OnLabelLongClickListener onLabelLongClickListener) {
        this.f21902C = onLabelLongClickListener;
        m15850b();
    }

    public void setOnLabelSelectChangeListener(OnLabelSelectChangeListener onLabelSelectChangeListener) {
        this.f21903D = onLabelSelectChangeListener;
    }

    public void setOnSelectChangeIntercept(OnSelectChangeIntercept onSelectChangeIntercept) {
        this.f21904E = onSelectChangeIntercept;
    }

    /* renamed from: a */
    private int m15842a(float f) {
        return (int) TypedValue.applyDimension(2, f, getResources().getDisplayMetrics());
    }

    /* renamed from: b */
    private int m15849b(float f) {
        return (int) TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }
}
