package com.didi.safety.god.p144ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;

/* renamed from: com.didi.safety.god.ui.DetectionRectBgDrawables */
public class DetectionRectBgDrawables {

    /* renamed from: a */
    private static SparseArray<Drawable> f34730a;

    public static void setBg(View view, int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setBackgroundResource(i);
        } else {
            view.setBackgroundDrawable(m24516a(view.getContext(), i));
        }
    }

    /* renamed from: a */
    private static Drawable m24516a(Context context, int i) {
        if (f34730a == null) {
            f34730a = new SparseArray<>();
        }
        Drawable drawable = f34730a.get(i);
        if (drawable != null) {
            return drawable;
        }
        Drawable drawable2 = context.getResources().getDrawable(i);
        f34730a.put(i, drawable2);
        return drawable2;
    }

    public static void clearDrawables() {
        SparseArray<Drawable> sparseArray;
        if (Build.VERSION.SDK_INT < 26 && (sparseArray = f34730a) != null) {
            sparseArray.clear();
            f34730a = null;
        }
    }
}
