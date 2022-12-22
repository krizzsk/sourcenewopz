package com.didi.rfusion.widget.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.didi.passenger.C10448R;

public abstract class RFButton extends FrameLayout {

    /* renamed from: a */
    private CharSequence f33351a = "";

    /* access modifiers changed from: protected */
    public abstract int getLayoutRes();

    /* access modifiers changed from: protected */
    public void initLogic(AttributeSet attributeSet) {
    }

    /* access modifiers changed from: protected */
    public void initView() {
    }

    /* access modifiers changed from: protected */
    public abstract void updateText(CharSequence charSequence);

    public RFButton(Context context) {
        super(context);
    }

    public RFButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RFButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void init(AttributeSet attributeSet) {
        LayoutInflater.from(getContext()).inflate(getLayoutRes(), this);
        initView();
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C10448R.styleable.RFButton);
        boolean z = obtainStyledAttributes.getBoolean(0, true);
        String string = obtainStyledAttributes.getString(1);
        obtainStyledAttributes.recycle();
        initLogic(attributeSet);
        setText(string);
        setEnabled(z);
    }

    public void setText(CharSequence charSequence) {
        this.f33351a = charSequence;
        updateText(charSequence);
    }

    public CharSequence getText() {
        return this.f33351a;
    }
}
