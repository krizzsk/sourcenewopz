package com.didi.soda.customer.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.AttributeSet;
import com.didi.passenger.C10448R;
import com.didi.soda.customer.widget.support.CustomerEditTextCompat;

public class MaxLengthEditText extends CustomerEditTextCompat {

    /* renamed from: a */
    private static final int f41546a = 50;

    /* renamed from: b */
    private TextLengthFilter f41547b;
    protected int mMaxNumber = 50;

    public MaxLengthEditText(Context context) {
        super(context);
        m29377a(context, (AttributeSet) null);
    }

    public MaxLengthEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29377a(context, attributeSet);
    }

    public MaxLengthEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m29377a(context, attributeSet);
    }

    public void setMaxLengthCallback(MaxLengthCallback maxLengthCallback) {
        this.f41547b.setMaxLengthCallback(maxLengthCallback);
    }

    public void setMaxNumber(int i) {
        this.mMaxNumber = i;
        this.f41547b.setMaxLength(i);
        invalidate();
    }

    /* renamed from: a */
    private void m29377a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.MaxLengthEditText);
            this.mMaxNumber = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }
        TextLengthFilter textLengthFilter = new TextLengthFilter();
        this.f41547b = textLengthFilter;
        textLengthFilter.setMaxLength(this.mMaxNumber);
        setFilters(new InputFilter[]{this.f41547b});
    }

    public static class TextLengthFilter implements InputFilter {
        private MaxLengthCallback mCallback;
        private int mMaxLength;

        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            MaxLengthCallback maxLengthCallback;
            int length = this.mMaxLength - (spanned.length() - (i4 - i3));
            int i5 = i2 - i;
            if (length < i5 && (maxLengthCallback = this.mCallback) != null) {
                maxLengthCallback.maxLengthCallback(this.mMaxLength);
            }
            if (length <= 0) {
                return "";
            }
            if (length >= i5) {
                return null;
            }
            return charSequence.subSequence(i, length + i);
        }

        public void setMaxLength(int i) {
            this.mMaxLength = i;
        }

        public void setMaxLengthCallback(MaxLengthCallback maxLengthCallback) {
            this.mCallback = maxLengthCallback;
        }
    }
}
