package com.didi.soda.customer.blocks.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.view.recyclerview.decorator.ItemDecorator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003H\u0016J2\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\tR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\t¨\u0006\u001f"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/view/BlocksItemLineDecoration;", "Lcom/didi/app/nova/support/view/recyclerview/decorator/ItemDecorator;", "color", "", "height", "leftMargin", "rightMargin", "(IIII)V", "getColor", "()I", "setColor", "(I)V", "getHeight", "setHeight", "getLeftMargin", "mPaint", "Landroid/graphics/Paint;", "getRightMargin", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "position", "positionType", "onDraw", "canvas", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "child", "Landroid/view/View;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BlocksItemLineDecoration.kt */
public final class BlocksItemLineDecoration implements ItemDecorator {

    /* renamed from: a */
    private int f40660a;

    /* renamed from: b */
    private int f40661b;

    /* renamed from: c */
    private final int f40662c;

    /* renamed from: d */
    private final int f40663d;

    /* renamed from: e */
    private Paint f40664e;

    public BlocksItemLineDecoration(int i, int i2, int i3, int i4) {
        this.f40660a = i;
        this.f40661b = i2;
        this.f40662c = i3;
        this.f40663d = i4;
        Paint paint = new Paint();
        this.f40664e = paint;
        paint.setColor(this.f40660a);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BlocksItemLineDecoration(int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, (i5 & 8) != 0 ? i3 : i4);
    }

    public final int getColor() {
        return this.f40660a;
    }

    public final int getHeight() {
        return this.f40661b;
    }

    public final int getLeftMargin() {
        return this.f40662c;
    }

    public final int getRightMargin() {
        return this.f40663d;
    }

    public final void setColor(int i) {
        this.f40660a = i;
    }

    public final void setHeight(int i) {
        this.f40661b = i;
    }

    public void getItemOffsets(Rect rect, int i, int i2) {
        Intrinsics.checkNotNullParameter(rect, "outRect");
        rect.bottom = this.f40661b;
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, View view, int i, int i2) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(view, "child");
        if (recyclerView != null) {
            int width = recyclerView.getWidth() - this.f40663d;
            Canvas canvas2 = canvas;
            canvas2.drawRect((float) this.f40662c, (float) view.getBottom(), (float) width, ((float) view.getBottom()) + ((float) this.f40661b), this.f40664e);
        }
    }
}
