package com.didiglobal.mew.framework.widget.p201ff;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: com.didiglobal.mew.framework.widget.ff.MSpaceItemDecoration */
public class MSpaceItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a */
    private int f50277a;

    /* renamed from: b */
    private int f50278b;

    /* renamed from: c */
    private int f50279c;

    /* renamed from: d */
    private int f50280d;

    /* renamed from: e */
    private Context f50281e;

    public MSpaceItemDecoration(int i, Context context) {
        this.f50277a = i;
        this.f50278b = i;
        this.f50279c = i;
        this.f50280d = i;
        this.f50281e = context;
    }

    public MSpaceItemDecoration(int i, int i2, int i3, int i4, Context context) {
        this.f50277a = i;
        this.f50278b = i2;
        this.f50279c = i3;
        this.f50280d = i4;
        this.f50281e = context;
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDraw(canvas, recyclerView, state);
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        rect.left = this.f50277a;
        rect.top = this.f50278b;
        rect.right = this.f50279c;
        rect.bottom = this.f50280d;
    }
}
