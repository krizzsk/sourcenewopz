package com.didichuxing.xpanel.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EdgeEffect;
import androidx.core.widget.EdgeEffectCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class BorderRecyclerView extends RecyclerView {
    /* access modifiers changed from: protected */
    public abstract Border[] getDismissBorder();

    public BorderRecyclerView(Context context) {
        super(context);
    }

    public BorderRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BorderRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        setBorderDismiss(getDismissBorder());
    }

    /* access modifiers changed from: protected */
    public void setBorderDismiss(Border[] borderArr) {
        for (Border borderDismiss : borderArr) {
            setBorderDismiss(borderDismiss);
        }
    }

    private void setBorderDismiss(Border border) {
        try {
            Method declaredMethod = RecyclerView.class.getDeclaredMethod(border.getMethodName(), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this, new Object[0]);
            Field declaredField = RecyclerView.class.getDeclaredField(border.getBorder());
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this);
            if (obj instanceof EdgeEffectCompat) {
                ((EdgeEffectCompat) declaredField.get(this)).setSize(0, 0);
            }
            if (obj instanceof EdgeEffect) {
                ((EdgeEffect) declaredField.get(this)).setSize(0, 0);
            }
        } catch (Exception unused) {
        }
    }

    public enum Border {
        LEFT("mLeftGlow", "ensureLeftGlow"),
        TOP("mTopGlow", "ensureTopGlow"),
        RIGHT("mRightGlow", "ensureRightGlow"),
        BOTTOM("mBottomGlow", "ensureBottomGlow");
        
        String border;
        String methodName;

        public String getBorder() {
            return this.border;
        }

        public String getMethodName() {
            return this.methodName;
        }

        private Border(String str, String str2) {
            this.border = str;
            this.methodName = str2;
        }
    }
}
