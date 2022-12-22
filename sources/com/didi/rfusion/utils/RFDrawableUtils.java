package com.didi.rfusion.utils;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import androidx.core.graphics.drawable.DrawableCompat;

public class RFDrawableUtils {
    public static Drawable tintDrawable(Drawable drawable, int i) {
        Drawable a = m23422a(drawable);
        DrawableCompat.setTint(a, i);
        return a;
    }

    public static Drawable tintListDrawable(Drawable drawable, ColorStateList colorStateList) {
        Drawable a = m23422a(drawable);
        DrawableCompat.setTintList(a, colorStateList);
        return a;
    }

    /* renamed from: a */
    private static Drawable m23422a(Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState != null) {
            drawable = constantState.newDrawable();
        }
        return DrawableCompat.wrap(drawable).mutate();
    }

    public static StateListDrawable getSelectorDrawable(Drawable drawable, Drawable drawable2) {
        if (drawable == null) {
            return null;
        }
        if (drawable2 == null) {
            drawable2 = drawable;
        }
        int[][] iArr = {new int[]{16842910, -16842919}, new int[]{16842910, 16842919}};
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(iArr[0], drawable);
        stateListDrawable.addState(iArr[1], drawable2);
        return stateListDrawable;
    }

    public static StateListDrawable getSelectorDrawable(int i, int i2, float f) {
        return getSelectorDrawable(new Builder(0).setColor(i).setCornerRadius(f).create(), new Builder(0).setColor(i2).setCornerRadius(f).create());
    }

    public static Builder getBuilder(int i) {
        return new Builder(i);
    }

    public static class Builder {
        public static final int LINE = 2;
        public static final int OVAL = 1;
        public static final int RECTANGLE = 0;
        private int[] mGradientColors;
        GradientDrawable mGradientDrawable;
        private float mRadius = 0.0f;
        private float[] mRadiusArray = null;
        private ColorStateList mSolidColors;
        private ColorStateList mStrokeColors;
        private float mStrokeDashGap = 0.0f;
        private float mStrokeDashWidth = 0.0f;
        private int mStrokeWidth = -1;

        public Builder(int i) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            this.mGradientDrawable = gradientDrawable;
            if (!(i == 0 || i == 1 || i == 2)) {
                i = 0;
            }
            gradientDrawable.setShape(i);
        }

        public Builder setColors(int[] iArr) {
            this.mGradientColors = iArr;
            return this;
        }

        public Builder setColor(int i) {
            this.mSolidColors = ColorStateList.valueOf(i);
            return this;
        }

        public Builder setColor(ColorStateList colorStateList) {
            this.mSolidColors = colorStateList;
            return this;
        }

        public Builder setStroke(int i, int i2) {
            this.mStrokeWidth = i;
            this.mStrokeColors = ColorStateList.valueOf(i2);
            return this;
        }

        public Builder setStroke(int i, ColorStateList colorStateList) {
            this.mStrokeWidth = i;
            this.mStrokeColors = colorStateList;
            return this;
        }

        public Builder setStroke(int i, int i2, float f, float f2) {
            this.mStrokeWidth = i;
            this.mStrokeColors = ColorStateList.valueOf(i2);
            this.mStrokeDashWidth = f;
            this.mStrokeDashGap = f2;
            return this;
        }

        public Builder setStroke(int i, ColorStateList colorStateList, float f, float f2) {
            this.mStrokeWidth = i;
            this.mStrokeColors = colorStateList;
            this.mStrokeDashWidth = f;
            this.mStrokeDashGap = f2;
            return this;
        }

        public Builder setCornerRadius(float f) {
            if (f < 0.0f) {
                f = 0.0f;
            }
            this.mRadius = f;
            this.mRadiusArray = null;
            return this;
        }

        public Builder setCornerRadii(float[] fArr) {
            this.mRadiusArray = fArr;
            if (fArr == null) {
                this.mRadius = 0.0f;
            }
            return this;
        }

        public Drawable create() {
            float[] fArr = this.mRadiusArray;
            if (fArr != null) {
                this.mGradientDrawable.setCornerRadii(fArr);
            } else {
                float f = this.mRadius;
                if (f > 0.0f) {
                    this.mGradientDrawable.setCornerRadius(f);
                }
            }
            int[] iArr = this.mGradientColors;
            if (iArr != null) {
                this.mGradientDrawable.setColors(iArr);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                ColorStateList colorStateList = this.mSolidColors;
                if (colorStateList != null) {
                    this.mGradientDrawable.setColor(colorStateList);
                }
                this.mGradientDrawable.setStroke(this.mStrokeWidth, this.mStrokeColors, this.mStrokeDashWidth, this.mStrokeDashGap);
            } else {
                GradientDrawable gradientDrawable = this.mGradientDrawable;
                if (gradientDrawable != null) {
                    gradientDrawable.setColor(this.mSolidColors.getDefaultColor());
                }
                this.mGradientDrawable.setStroke(this.mStrokeWidth, this.mStrokeColors.getDefaultColor(), this.mStrokeDashWidth, this.mStrokeDashGap);
            }
            return this.mGradientDrawable;
        }
    }
}
