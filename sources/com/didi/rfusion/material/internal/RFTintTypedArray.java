package com.didi.rfusion.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.content.res.AppCompatResources;

public final class RFTintTypedArray {

    /* renamed from: a */
    private final Context f33297a;

    /* renamed from: b */
    private final TypedArray f33298b;

    /* renamed from: c */
    private TypedValue f33299c;

    public static RFTintTypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr) {
        return new RFTintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static RFTintTypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new RFTintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    public static RFTintTypedArray obtainStyledAttributes(Context context, int i, int[] iArr) {
        return new RFTintTypedArray(context, context.obtainStyledAttributes(i, iArr));
    }

    private RFTintTypedArray(Context context, TypedArray typedArray) {
        this.f33297a = context;
        this.f33298b = typedArray;
    }

    public Drawable getDrawable(int i) {
        int resourceId;
        if (!this.f33298b.hasValue(i) || (resourceId = this.f33298b.getResourceId(i, 0)) == 0) {
            return this.f33298b.getDrawable(i);
        }
        return AppCompatResources.getDrawable(this.f33297a, resourceId);
    }

    public int length() {
        return this.f33298b.length();
    }

    public int getIndexCount() {
        return this.f33298b.getIndexCount();
    }

    public int getIndex(int i) {
        return this.f33298b.getIndex(i);
    }

    public Resources getResources() {
        return this.f33298b.getResources();
    }

    public CharSequence getText(int i) {
        return this.f33298b.getText(i);
    }

    public String getString(int i) {
        return this.f33298b.getString(i);
    }

    public String getNonResourceString(int i) {
        return this.f33298b.getNonResourceString(i);
    }

    public boolean getBoolean(int i, boolean z) {
        return this.f33298b.getBoolean(i, z);
    }

    public int getInt(int i, int i2) {
        return this.f33298b.getInt(i, i2);
    }

    public float getFloat(int i, float f) {
        return this.f33298b.getFloat(i, f);
    }

    public int getColor(int i, int i2) {
        return this.f33298b.getColor(i, i2);
    }

    public ColorStateList getColorStateList(int i) {
        int resourceId;
        ColorStateList colorStateList;
        if (!this.f33298b.hasValue(i) || (resourceId = this.f33298b.getResourceId(i, 0)) == 0 || (colorStateList = AppCompatResources.getColorStateList(this.f33297a, resourceId)) == null) {
            return this.f33298b.getColorStateList(i);
        }
        return colorStateList;
    }

    public int getInteger(int i, int i2) {
        return this.f33298b.getInteger(i, i2);
    }

    public float getDimension(int i, float f) {
        return this.f33298b.getDimension(i, f);
    }

    public int getDimensionPixelOffset(int i, int i2) {
        return this.f33298b.getDimensionPixelOffset(i, i2);
    }

    public int getDimensionPixelSize(int i, int i2) {
        return this.f33298b.getDimensionPixelSize(i, i2);
    }

    public int getLayoutDimension(int i, String str) {
        return this.f33298b.getLayoutDimension(i, str);
    }

    public int getLayoutDimension(int i, int i2) {
        return this.f33298b.getLayoutDimension(i, i2);
    }

    public float getFraction(int i, int i2, int i3, float f) {
        return this.f33298b.getFraction(i, i2, i3, f);
    }

    public int getResourceId(int i, int i2) {
        return this.f33298b.getResourceId(i, i2);
    }

    public CharSequence[] getTextArray(int i) {
        return this.f33298b.getTextArray(i);
    }

    public boolean getValue(int i, TypedValue typedValue) {
        return this.f33298b.getValue(i, typedValue);
    }

    public int getType(int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.f33298b.getType(i);
        }
        if (this.f33299c == null) {
            this.f33299c = new TypedValue();
        }
        this.f33298b.getValue(i, this.f33299c);
        return this.f33299c.type;
    }

    public boolean hasValue(int i) {
        return this.f33298b.hasValue(i);
    }

    public TypedValue peekValue(int i) {
        return this.f33298b.peekValue(i);
    }

    public String getPositionDescription() {
        return this.f33298b.getPositionDescription();
    }

    public void recycle() {
        this.f33298b.recycle();
    }

    public int getChangingConfigurations() {
        return this.f33298b.getChangingConfigurations();
    }
}
