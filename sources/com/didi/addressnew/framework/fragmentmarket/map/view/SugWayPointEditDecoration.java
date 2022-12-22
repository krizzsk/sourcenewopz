package com.didi.addressnew.framework.fragmentmarket.map.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.common.map.util.DisplayUtils;

public class SugWayPointEditDecoration extends RecyclerView.ItemDecoration {
    public static boolean IS_DRAW_DIVIDER = true;

    /* renamed from: a */
    private int f7181a;

    /* renamed from: b */
    private int f7182b;

    /* renamed from: c */
    private float f7183c;

    /* renamed from: d */
    private int f7184d;

    /* renamed from: e */
    private int f7185e;

    /* renamed from: f */
    private Paint f7186f;

    /* renamed from: g */
    private int f7187g;

    /* renamed from: h */
    private Path f7188h = new Path();

    /* renamed from: i */
    private Context f7189i;

    public SugWayPointEditDecoration(Context context) {
        this.f7189i = context;
        this.f7181a = DisplayUtils.dp2px(context, 1.0f);
        this.f7182b = DisplayUtils.dp2px(context, 12.0f);
        this.f7184d = DisplayUtils.dp2px(context, 2.0f);
        this.f7187g = DisplayUtils.dp2px(context, 37.0f);
        this.f7183c = (float) (DisplayUtils.dp2px(context, 36.0f) - this.f7182b);
        this.f7185e = DisplayUtils.dp2px(context, 4.0f);
        Paint paint = new Paint(1);
        this.f7186f = paint;
        paint.setStrokeWidth((float) this.f7181a);
        this.f7186f.setStyle(Paint.Style.STROKE);
        this.f7186f.setPathEffect(new DashPathEffect(new float[]{(float) DisplayUtils.dp2px(context, 4.0f), (float) DisplayUtils.dp2px(context, 4.0f)}, (float) DisplayUtils.dp2px(context, 4.0f)));
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        rect.bottom = this.f7184d;
        rect.left = this.f7182b;
        if (recyclerView.indexOfChild(view) == 0) {
            rect.top = DisplayUtils.dp2px(this.f7189i, 9.0f);
        }
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        if (IS_DRAW_DIVIDER && recyclerView.getChildCount() > 2) {
            int childCount = recyclerView.getChildCount();
            for (int i = 0; i < childCount - 1; i++) {
                View childAt = recyclerView.getChildAt(i);
                float left = ((float) childAt.getLeft()) + this.f7183c;
                float top = (float) (childAt.getTop() + DisplayUtils.dp2px(this.f7189i, 21.0f));
                float f = ((float) this.f7187g) + top;
                this.f7188h.reset();
                this.f7188h.moveTo(left, top);
                this.f7188h.lineTo(left, f);
                canvas.drawPath(this.f7188h, this.f7186f);
            }
        }
    }
}
