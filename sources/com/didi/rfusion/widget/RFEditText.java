package com.didi.rfusion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;
import com.didi.passenger.C10448R;
import com.didi.rfusion.utils.RFFontUtils;

public class RFEditText extends AppCompatEditText {
    /* access modifiers changed from: protected */
    public boolean useTypeFace() {
        return true;
    }

    public RFEditText(Context context) {
        super(context);
    }

    public RFEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m23439a(context, attributeSet);
    }

    public RFEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m23439a(context, attributeSet);
    }

    /* renamed from: a */
    private void m23439a(Context context, AttributeSet attributeSet) {
        if (useTypeFace()) {
            int i = 0;
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.RFEditText);
                i = obtainStyledAttributes.getInt(0, 0);
                obtainStyledAttributes.recycle();
            }
            RFFontUtils.setTypeFace(this, i);
        }
    }

    public void setTypeface(int i) {
        RFFontUtils.setTypeFace(this, i);
    }
}
