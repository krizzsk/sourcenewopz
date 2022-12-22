package com.didi.beatles.p099im.views;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: com.didi.beatles.im.views.IMGridSpacingItemDecoration */
public class IMGridSpacingItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a */
    private int f9881a;

    /* renamed from: b */
    private int f9882b;

    /* renamed from: c */
    private boolean f9883c;

    public IMGridSpacingItemDecoration(int i, int i2, boolean z) {
        this.f9881a = i;
        this.f9882b = i2;
        this.f9883c = z;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i = this.f9881a;
        int i2 = childAdapterPosition % i;
        if (this.f9883c) {
            int i3 = this.f9882b;
            rect.left = i3 - ((i2 * i3) / i);
            rect.right = ((i2 + 1) * this.f9882b) / this.f9881a;
            if (childAdapterPosition < this.f9881a) {
                rect.top = this.f9882b;
            }
            rect.bottom = this.f9882b;
            return;
        }
        rect.left = (this.f9882b * i2) / i;
        int i4 = this.f9882b;
        rect.right = i4 - (((i2 + 1) * i4) / this.f9881a);
        if (childAdapterPosition < this.f9881a) {
            rect.top = this.f9882b;
        }
        rect.bottom = this.f9882b;
    }
}
