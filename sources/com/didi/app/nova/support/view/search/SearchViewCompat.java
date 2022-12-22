package com.didi.app.nova.support.view.search;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import com.didi.passenger.C10448R;
import com.taxis99.R;
import java.lang.reflect.Field;

public class SearchViewCompat extends SearchView {
    public SearchViewCompat(Context context) {
        super(context);
    }

    public SearchViewCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5804a(context, attributeSet);
    }

    public SearchViewCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5804a(context, attributeSet);
    }

    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        return super.onKeyPreIme(i, keyEvent);
    }

    /* renamed from: a */
    private void m5804a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.NovaSupportEditText);
        m5803a(obtainStyledAttributes.getResourceId(0, 0));
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    private void m5803a(int i) {
        if (i != 0) {
            findViewById(R.id.search_plate).getBackground().setColorFilter(0, PorterDuff.Mode.MULTIPLY);
            try {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                declaredField.set((SearchView.SearchAutoComplete) findViewById(R.id.search_src_text), Integer.valueOf(i));
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            }
        }
    }

    public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            return false;
        }
        return super.dispatchKeyEventPreIme(keyEvent);
    }
}
