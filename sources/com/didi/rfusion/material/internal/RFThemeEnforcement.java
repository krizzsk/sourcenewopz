package com.didi.rfusion.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.didi.passenger.C10448R;
import com.taxis99.R;

public final class RFThemeEnforcement {

    /* renamed from: a */
    private static final int[] f33293a = {R.attr.colorPrimary};

    /* renamed from: b */
    private static final String f33294b = "Theme.AppCompat";

    /* renamed from: c */
    private static final int[] f33295c = {R.attr.colorSecondary};

    /* renamed from: d */
    private static final String f33296d = "Theme.MaterialComponents";

    private RFThemeEnforcement() {
    }

    public static TypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2, int... iArr2) {
        m23411a(context, attributeSet, i, i2);
        m23412a(context, attributeSet, iArr, i, i2, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, i, i2);
    }

    public static RFTintTypedArray obtainTintedStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2, int... iArr2) {
        m23411a(context, attributeSet, i, i2);
        m23412a(context, attributeSet, iArr, i, i2, iArr2);
        return RFTintTypedArray.obtainStyledAttributes(context, attributeSet, iArr, i, i2);
    }

    /* renamed from: a */
    private static void m23411a(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.ThemeEnforcement, i, i2);
        boolean z = obtainStyledAttributes.getBoolean(1, false);
        obtainStyledAttributes.recycle();
        if (z) {
            checkMaterialTheme(context);
        }
        checkAppCompatTheme(context);
    }

    /* renamed from: a */
    private static void m23412a(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2, int... iArr2) {
        boolean z;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.ThemeEnforcement, i, i2);
        boolean z2 = false;
        if (!obtainStyledAttributes.getBoolean(2, false)) {
            obtainStyledAttributes.recycle();
            return;
        }
        if (iArr2 == null || iArr2.length == 0) {
            if (obtainStyledAttributes.getResourceId(0, -1) != -1) {
                z2 = true;
            }
            z = z2;
        } else {
            z = m23415b(context, attributeSet, iArr, i, i2, iArr2);
        }
        obtainStyledAttributes.recycle();
        if (!z) {
            throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
        }
    }

    /* renamed from: b */
    private static boolean m23415b(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2, int... iArr2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, i2);
        for (int resourceId : iArr2) {
            if (obtainStyledAttributes.getResourceId(resourceId, -1) == -1) {
                obtainStyledAttributes.recycle();
                return false;
            }
        }
        obtainStyledAttributes.recycle();
        return true;
    }

    public static void checkAppCompatTheme(Context context) {
        m23413a(context, f33293a, f33294b);
    }

    public static void checkMaterialTheme(Context context) {
        m23413a(context, f33295c, f33296d);
    }

    public static boolean isAppCompatTheme(Context context) {
        return m23414a(context, f33293a);
    }

    public static boolean isMaterialTheme(Context context) {
        return m23414a(context, f33295c);
    }

    /* renamed from: a */
    private static boolean m23414a(Context context, int[] iArr) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(iArr);
        boolean hasValue = obtainStyledAttributes.hasValue(0);
        obtainStyledAttributes.recycle();
        return hasValue;
    }

    /* renamed from: a */
    private static void m23413a(Context context, int[] iArr, String str) {
        if (!m23414a(context, iArr)) {
            throw new IllegalArgumentException("The style on this component requires your app theme to be " + str + " (or a descendant).");
        }
    }
}
