package com.didi.global.fintech.cashier.p117ui.viewholder;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.SchemeDispatcherImpl;
import com.didi.global.fintech.cashier.p117ui.kts.ContextKtxKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J \u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/FastPayItemDividerDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "height", "", "paint", "Landroid/graphics/Paint;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onDraw", "c", "Landroid/graphics/Canvas;", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.viewholder.FastPayItemDividerDecoration */
/* compiled from: FastPayOrderContentViewHolder.kt */
public final class FastPayItemDividerDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a */
    private int f21768a;

    /* renamed from: b */
    private Paint f21769b;

    public FastPayItemDividerDecoration(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint = new Paint();
        this.f21769b = paint;
        paint.setColor(Color.parseColor("#110A121A"));
        this.f21768a = (int) TypedValue.applyDimension(0, 1.0f, context.getResources().getDisplayMetrics());
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        super.getItemOffsets(rect, view, recyclerView, state);
        rect.bottom = this.f21768a;
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        Paint paint;
        Intrinsics.checkNotNullParameter(canvas, "c");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        int childCount = recyclerView.getChildCount();
        int paddingLeft = recyclerView.getPaddingLeft();
        Context context = recyclerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        int dp2px = paddingLeft + ContextKtxKt.dp2px(context, 20);
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int i = childCount - 1;
        if (i > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                View childAt = recyclerView.getChildAt(i2);
                if (Intrinsics.areEqual(childAt.getTag(), (Object) SchemeDispatcherImpl.HOST_PAY) && (paint = this.f21769b) != null) {
                    canvas.drawRect((float) dp2px, (float) childAt.getBottom(), (float) width, (float) (childAt.getBottom() + this.f21768a), paint);
                }
                if (i3 < i) {
                    i2 = i3;
                } else {
                    return;
                }
            }
        }
    }
}
