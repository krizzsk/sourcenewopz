package com.didi.global.fintech.cashier.p117ui.viewholder.divider;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/divider/GridGapDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "lineWidth", "", "(I)V", "horizontalLineWidth", "verticalLineWidth", "(II)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "getSpanCount", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.viewholder.divider.GridGapDecoration */
/* compiled from: GridGapDecoration.kt */
public final class GridGapDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a */
    private final int f21834a;

    /* renamed from: b */
    private final int f21835b;

    public GridGapDecoration(int i, int i2) {
        this.f21834a = i;
        this.f21835b = i2;
    }

    public GridGapDecoration(int i) {
        this(i, i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0057  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void getItemOffsets(android.graphics.Rect r3, android.view.View r4, androidx.recyclerview.widget.RecyclerView r5, androidx.recyclerview.widget.RecyclerView.State r6) {
        /*
            r2 = this;
            java.lang.String r0 = "outRect"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "parent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            int r6 = r5.getChildAdapterPosition(r4)
            int r0 = r2.m15834a(r5)
            r1 = -1
            if (r6 != r1) goto L_0x002b
            androidx.recyclerview.widget.RecyclerView$ViewHolder r4 = r5.getChildViewHolder(r4)
            int r6 = r4.getOldPosition()
        L_0x002b:
            r4 = 0
            if (r6 >= 0) goto L_0x0031
            r3.set(r4, r4, r4, r4)
        L_0x0031:
            int r5 = r6 + 1
            int r5 = r5 % r0
            r1 = 1
            if (r5 == 0) goto L_0x0048
            if (r5 == r1) goto L_0x0040
            int r5 = r2.f21834a
            int r1 = r5 / 2
            int r5 = r5 / 2
            goto L_0x0052
        L_0x0040:
            if (r0 != r1) goto L_0x0043
            goto L_0x004a
        L_0x0043:
            int r5 = r2.f21834a
            int r5 = r5 / 2
            goto L_0x004b
        L_0x0048:
            if (r0 != r1) goto L_0x004d
        L_0x004a:
            r5 = 0
        L_0x004b:
            r1 = 0
            goto L_0x0052
        L_0x004d:
            int r5 = r2.f21834a
            int r1 = r5 / 2
            r5 = 0
        L_0x0052:
            if (r6 < r0) goto L_0x0057
            int r6 = r2.f21835b
            goto L_0x0058
        L_0x0057:
            r6 = 0
        L_0x0058:
            r3.set(r1, r6, r5, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.p117ui.viewholder.divider.GridGapDecoration.getItemOffsets(android.graphics.Rect, android.view.View, androidx.recyclerview.widget.RecyclerView, androidx.recyclerview.widget.RecyclerView$State):void");
    }

    /* renamed from: a */
    private final int m15834a(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) layoutManager).getSpanCount();
        }
        throw new IllegalStateException("GridDividerDecoration only support GridLayoutManager now!".toString());
    }
}
