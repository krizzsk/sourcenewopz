package com.didi.app.nova.support.view.edittext;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import com.didi.passenger.C10448R;
import java.lang.reflect.Field;

public class EditTextCompat extends AppCompatEditText {
    public EditTextCompat(Context context) {
        super(context);
    }

    public EditTextCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5690a(context, attributeSet);
    }

    public EditTextCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5690a(context, attributeSet);
    }

    /* renamed from: a */
    private void m5690a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.NovaSupportEditText);
        m5689a(obtainStyledAttributes.getResourceId(0, 0));
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    private void m5689a(int i) {
        if (i != 0) {
            try {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                declaredField.set(this, Integer.valueOf(i));
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            }
        }
    }
}
