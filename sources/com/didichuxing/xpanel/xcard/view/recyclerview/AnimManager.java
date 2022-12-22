package com.didichuxing.xpanel.xcard.view.recyclerview;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class AnimManager {
    public static final int ANIM_BOTTOM_TO_TOP = 0;
    public static final int ANIM_TOP_TO_BOTTOM = 1;

    /* renamed from: a */
    private static final String f49696a = "AnimManager";

    /* renamed from: b */
    private static AnimManager f49697b;

    /* renamed from: c */
    private int f49698c = 0;

    /* renamed from: d */
    private float f49699d = 0.2f;

    /* renamed from: e */
    private float f49700e = 0.6f;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public float mo121804a(float f) {
        if (f < 0.0f) {
            return 0.0f;
        }
        if (f > 1.0f) {
            return 1.0f;
        }
        return f;
    }

    public static AnimManager getInstance() {
        if (f49697b == null) {
            f49697b = new AnimManager();
        }
        return f49697b;
    }

    public void setAnim(RecyclerView recyclerView, int i, float f, float f2, float f3) {
        int i2 = i - 1;
        View findViewByPosition = i2 > 0 ? recyclerView.getLayoutManager().findViewByPosition(i2) : null;
        View findViewByPosition2 = recyclerView.getLayoutManager().findViewByPosition(i);
        View findViewByPosition3 = recyclerView.getLayoutManager().findViewByPosition(i + 1);
        if (findViewByPosition != null) {
            float f4 = this.f49700e;
            findViewByPosition.setAlpha(mo121804a(f4 + (f * (1.0f - f4))));
        }
        if (findViewByPosition2 != null) {
            float f5 = this.f49700e;
            findViewByPosition2.setAlpha(mo121804a(f5 + (f2 * (1.0f - f5))));
        }
        if (findViewByPosition3 != null) {
            float f6 = this.f49700e;
            findViewByPosition3.setAlpha(mo121804a(f6 + (f3 * (1.0f - f6))));
        }
    }

    public void setAlpha(float f) {
        this.f49700e = f;
    }
}
