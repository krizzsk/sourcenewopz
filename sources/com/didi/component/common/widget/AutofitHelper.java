package com.didi.component.common.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.text.Editable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.SingleLineTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import com.didi.passenger.C10448R;
import java.util.ArrayList;
import java.util.Iterator;

public class AutofitHelper {

    /* renamed from: a */
    private static final String f11922a = "AutoFitTextHelper";

    /* renamed from: b */
    private static final boolean f11923b = false;

    /* renamed from: c */
    private static final int f11924c = 8;

    /* renamed from: d */
    private static final float f11925d = 0.5f;

    /* renamed from: e */
    private TextView f11926e;

    /* renamed from: f */
    private TextPaint f11927f;

    /* renamed from: g */
    private float f11928g;

    /* renamed from: h */
    private int f11929h;

    /* renamed from: i */
    private float f11930i;

    /* renamed from: j */
    private float f11931j;

    /* renamed from: k */
    private float f11932k;

    /* renamed from: l */
    private boolean f11933l;

    /* renamed from: m */
    private boolean f11934m;

    /* renamed from: n */
    private ArrayList<OnTextSizeChangeListener> f11935n;

    /* renamed from: o */
    private TextWatcher f11936o = new AutofitTextWatcher();

    /* renamed from: p */
    private View.OnLayoutChangeListener f11937p = new AutofitOnLayoutChangeListener();

    public interface OnTextSizeChangeListener {
        void onTextSizeChange(float f, float f2);
    }

    public static AutofitHelper create(TextView textView) {
        return create(textView, (AttributeSet) null, 0);
    }

    public static AutofitHelper create(TextView textView, AttributeSet attributeSet) {
        return create(textView, attributeSet, 0);
    }

    public static AutofitHelper create(TextView textView, AttributeSet attributeSet, int i) {
        AutofitHelper autofitHelper = new AutofitHelper(textView);
        boolean z = true;
        if (attributeSet != null) {
            Context context = textView.getContext();
            float precision = autofitHelper.getPrecision();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.AutofitTextView, i, 0);
            boolean z2 = obtainStyledAttributes.getBoolean(2, true);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, (int) autofitHelper.getMinTextSize());
            float f = obtainStyledAttributes.getFloat(1, precision);
            obtainStyledAttributes.recycle();
            autofitHelper.setMinTextSize(0, (float) dimensionPixelSize).setPrecision(f);
            z = z2;
        }
        autofitHelper.setEnabled(z);
        return autofitHelper;
    }

    /* renamed from: a */
    private static void m8054a(TextView textView, TextPaint textPaint, float f, float f2, int i, float f3) {
        if (i > 0 && i != Integer.MAX_VALUE) {
            final TextView textView2 = textView;
            final float f4 = f2;
            final TextPaint textPaint2 = textPaint;
            final int i2 = i;
            final float f5 = f3;
            final float f6 = f;
            textView.post(new Runnable() {
                public void run() {
                    int width = (textView2.getWidth() - textView2.getPaddingLeft()) - textView2.getPaddingRight();
                    if (width > 0) {
                        CharSequence text = textView2.getText();
                        TransformationMethod transformationMethod = textView2.getTransformationMethod();
                        if (transformationMethod != null) {
                            text = transformationMethod.getTransformation(text, textView2);
                        }
                        CharSequence charSequence = text;
                        Context context = textView2.getContext();
                        Resources system = Resources.getSystem();
                        float f = f4;
                        if (context != null) {
                            system = context.getResources();
                        }
                        DisplayMetrics displayMetrics = system.getDisplayMetrics();
                        textPaint2.set(textView2.getPaint());
                        textPaint2.setTextSize(f);
                        if ((i2 == 1 && textPaint2.measureText(charSequence, 0, charSequence.length()) > ((float) width)) || AutofitHelper.m8057b(charSequence, textPaint2, f, (float) width, displayMetrics) > i2) {
                            f = AutofitHelper.m8056b(charSequence, textPaint2, (float) width, i2, 0.0f, f, f5, displayMetrics);
                        }
                        float f2 = f6;
                        if (f < f2) {
                            f = f2;
                        }
                        textView2.setTextSize(0, f);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static float m8056b(CharSequence charSequence, TextPaint textPaint, float f, int i, float f2, float f3, float f4, DisplayMetrics displayMetrics) {
        StaticLayout staticLayout;
        int i2;
        float f5;
        TextPaint textPaint2 = textPaint;
        float f6 = f;
        int i3 = i;
        float f7 = (f2 + f3) / 2.0f;
        textPaint2.setTextSize(TypedValue.applyDimension(0, f7, displayMetrics));
        if (i3 != 1) {
            staticLayout = new StaticLayout(charSequence, textPaint, (int) f6, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            i2 = staticLayout.getLineCount();
        } else {
            staticLayout = null;
            i2 = 1;
        }
        if (i2 > i3) {
            return f3 - f2 < f4 ? f2 : m8056b(charSequence, textPaint, f, i, f2, f7, f4, displayMetrics);
        }
        if (i2 < i3) {
            return m8056b(charSequence, textPaint, f, i, f7, f3, f4, displayMetrics);
        }
        float f8 = 0.0f;
        if (i3 == 1) {
            f5 = textPaint2.measureText(charSequence, 0, charSequence.length());
        } else {
            CharSequence charSequence2 = charSequence;
            for (int i4 = 0; i4 < i2; i4++) {
                if (staticLayout.getLineWidth(i4) > f8) {
                    f8 = staticLayout.getLineWidth(i4);
                }
            }
            f5 = f8;
        }
        if (f3 - f2 < f4) {
            return f2;
        }
        if (f5 > f6) {
            return m8056b(charSequence, textPaint, f, i, f2, f7, f4, displayMetrics);
        }
        return f5 < f6 ? m8056b(charSequence, textPaint, f, i, f7, f3, f4, displayMetrics) : f7;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static int m8057b(CharSequence charSequence, TextPaint textPaint, float f, float f2, DisplayMetrics displayMetrics) {
        textPaint.setTextSize(TypedValue.applyDimension(0, f, displayMetrics));
        return new StaticLayout(charSequence, textPaint, (int) f2, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true).getLineCount();
    }

    /* renamed from: a */
    private static int m8049a(TextView textView) {
        TransformationMethod transformationMethod = textView.getTransformationMethod();
        if (transformationMethod != null && (transformationMethod instanceof SingleLineTransformationMethod)) {
            return 1;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return textView.getMaxLines();
        }
        return -1;
    }

    private AutofitHelper(TextView textView) {
        float f = textView.getContext().getResources().getDisplayMetrics().scaledDensity;
        this.f11926e = textView;
        this.f11927f = new TextPaint();
        m8059c(textView.getTextSize());
        this.f11929h = m8049a(textView);
        this.f11930i = f * 8.0f;
        this.f11931j = this.f11928g;
        this.f11932k = 0.5f;
    }

    public AutofitHelper addOnTextSizeChangeListener(OnTextSizeChangeListener onTextSizeChangeListener) {
        if (this.f11935n == null) {
            this.f11935n = new ArrayList<>();
        }
        this.f11935n.add(onTextSizeChangeListener);
        return this;
    }

    public AutofitHelper removeOnTextSizeChangeListener(OnTextSizeChangeListener onTextSizeChangeListener) {
        ArrayList<OnTextSizeChangeListener> arrayList = this.f11935n;
        if (arrayList != null) {
            arrayList.remove(onTextSizeChangeListener);
        }
        return this;
    }

    public float getPrecision() {
        return this.f11932k;
    }

    public AutofitHelper setPrecision(float f) {
        if (this.f11932k != f) {
            this.f11932k = f;
            m8051a();
        }
        return this;
    }

    public float getMinTextSize() {
        return this.f11930i;
    }

    public AutofitHelper setMinTextSize(float f) {
        return setMinTextSize(2, f);
    }

    public AutofitHelper setMinTextSize(int i, float f) {
        Context context = this.f11926e.getContext();
        Resources system = Resources.getSystem();
        if (context != null) {
            system = context.getResources();
        }
        m8052a(TypedValue.applyDimension(i, f, system.getDisplayMetrics()));
        return this;
    }

    /* renamed from: a */
    private void m8052a(float f) {
        if (f != this.f11930i) {
            this.f11930i = f;
            m8051a();
        }
    }

    public float getMaxTextSize() {
        return this.f11931j;
    }

    public AutofitHelper setMaxTextSize(float f) {
        return setMaxTextSize(2, f);
    }

    public AutofitHelper setMaxTextSize(int i, float f) {
        Context context = this.f11926e.getContext();
        Resources system = Resources.getSystem();
        if (context != null) {
            system = context.getResources();
        }
        m8058b(TypedValue.applyDimension(i, f, system.getDisplayMetrics()));
        return this;
    }

    /* renamed from: b */
    private void m8058b(float f) {
        if (f != this.f11931j) {
            this.f11931j = f;
            m8051a();
        }
    }

    public int getMaxLines() {
        return this.f11929h;
    }

    public AutofitHelper setMaxLines(int i) {
        if (this.f11929h != i) {
            this.f11929h = i;
            m8051a();
        }
        return this;
    }

    public boolean isEnabled() {
        return this.f11933l;
    }

    public AutofitHelper setEnabled(boolean z) {
        if (this.f11933l != z) {
            this.f11933l = z;
            if (z) {
                this.f11926e.addTextChangedListener(this.f11936o);
                this.f11926e.addOnLayoutChangeListener(this.f11937p);
                m8051a();
            } else {
                this.f11926e.removeTextChangedListener(this.f11936o);
                this.f11926e.removeOnLayoutChangeListener(this.f11937p);
                this.f11926e.setTextSize(0, this.f11928g);
            }
        }
        return this;
    }

    public float getTextSize() {
        return this.f11928g;
    }

    public void setTextSize(float f) {
        setTextSize(2, f);
    }

    public void setTextSize(int i, float f) {
        if (!this.f11934m) {
            Context context = this.f11926e.getContext();
            Resources system = Resources.getSystem();
            if (context != null) {
                system = context.getResources();
            }
            m8059c(TypedValue.applyDimension(i, f, system.getDisplayMetrics()));
        }
    }

    /* renamed from: c */
    private void m8059c(float f) {
        if (this.f11928g != f) {
            this.f11928g = f;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8051a() {
        float textSize = this.f11926e.getTextSize();
        this.f11934m = true;
        m8054a(this.f11926e, this.f11927f, this.f11930i, this.f11931j, this.f11929h, this.f11932k);
        this.f11934m = false;
        float textSize2 = this.f11926e.getTextSize();
        if (textSize2 != textSize) {
            m8053a(textSize2, textSize);
        }
    }

    /* renamed from: a */
    private void m8053a(float f, float f2) {
        ArrayList<OnTextSizeChangeListener> arrayList = this.f11935n;
        if (arrayList != null) {
            Iterator<OnTextSizeChangeListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onTextSizeChange(f, f2);
            }
        }
    }

    private class AutofitTextWatcher implements TextWatcher {
        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        private AutofitTextWatcher() {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AutofitHelper.this.m8051a();
        }
    }

    private class AutofitOnLayoutChangeListener implements View.OnLayoutChangeListener {
        private AutofitOnLayoutChangeListener() {
        }

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            AutofitHelper.this.m8051a();
        }
    }
}
