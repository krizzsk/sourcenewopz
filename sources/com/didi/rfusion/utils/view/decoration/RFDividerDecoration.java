package com.didi.rfusion.utils.view.decoration;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 #2\u00020\u0001:\u0001#B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0011H\u0002J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J \u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J \u0010\u0016\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J \u0010\u0017\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0011H\u0002J(\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J \u0010!\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, mo175978d2 = {"Lcom/didi/rfusion/utils/view/decoration/RFDividerDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "orientation", "", "dividerWidth", "dividerColor", "(IILjava/lang/Integer;)V", "Ljava/lang/Integer;", "paint", "Landroid/graphics/Paint;", "drawBottom", "", "c", "Landroid/graphics/Canvas;", "child", "Landroid/view/View;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "drawGrid", "parent", "drawHorizontal", "drawLeft", "drawRight", "drawTop", "drawVertical", "getItemOffsets", "outRect", "Landroid/graphics/Rect;", "view", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "isGridLayoutManager", "", "onDraw", "setOrientation", "Companion", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: RFDividerDecoration.kt */
public final class RFDividerDecoration extends RecyclerView.ItemDecoration {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int GRID_DIV = 2;
    public static final int HORIZONTAL_DIV = 0;
    public static final int VERTICAL_DIV = 1;

    /* renamed from: e */
    private static final String f33314e = f33314e;

    /* renamed from: a */
    private final Paint f33315a;

    /* renamed from: b */
    private int f33316b;

    /* renamed from: c */
    private int f33317c;

    /* renamed from: d */
    private final Integer f33318d;

    public RFDividerDecoration() {
        this(0, 0, (Integer) null, 7, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RFDividerDecoration(int i, int i2, Integer num, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 1 : i, (i3 & 2) != 0 ? 1 : i2, (i3 & 4) != 0 ? null : num);
    }

    public RFDividerDecoration(int i, int i2, Integer num) {
        this.f33318d = num;
        Paint paint = new Paint();
        this.f33315a = paint;
        this.f33316b = 1;
        this.f33317c = 1;
        if (this.f33318d != null) {
            paint.setAntiAlias(true);
            paint.setColor(this.f33318d.intValue());
            paint.setStyle(Paint.Style.FILL);
        }
        this.f33317c = i2;
        m23431a(i);
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo175978d2 = {"Lcom/didi/rfusion/utils/view/decoration/RFDividerDecoration$Companion;", "", "()V", "GRID_DIV", "", "HORIZONTAL_DIV", "TAG", "", "VERTICAL_DIV", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: RFDividerDecoration.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: a */
    private final void m23431a(int i) {
        int i2 = this.f33316b;
        boolean z = true;
        if (!(i2 == 0 || i2 == 1 || i2 == 2)) {
            z = false;
        }
        if (z) {
            this.f33316b = i;
            return;
        }
        throw new IllegalArgumentException("ItemDecorationPowerful：分割线类型设置异常".toString());
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        Intrinsics.checkParameterIsNotNull(canvas, "c");
        Intrinsics.checkParameterIsNotNull(recyclerView, "parent");
        Intrinsics.checkParameterIsNotNull(state, "state");
        if (this.f33318d != null) {
            int i = this.f33316b;
            if (i == 0) {
                drawHorizontal(canvas, recyclerView);
            } else if (i == 1) {
                m23433a(canvas, recyclerView);
            } else if (i != 2) {
                m23433a(canvas, recyclerView);
            } else {
                m23436b(canvas, recyclerView);
            }
        }
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        Intrinsics.checkParameterIsNotNull(rect, "outRect");
        Intrinsics.checkParameterIsNotNull(view, "view");
        Intrinsics.checkParameterIsNotNull(recyclerView, "parent");
        Intrinsics.checkParameterIsNotNull(state, "state");
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            int itemCount = adapter.getItemCount();
            int i = this.f33316b;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                        if (layoutManager instanceof GridLayoutManager) {
                            int spanCount = ((GridLayoutManager) layoutManager).getSpanCount();
                            if (childAdapterPosition == 0) {
                                int i2 = this.f33317c;
                                rect.set(i2, i2, i2, i2);
                            } else if (childAdapterPosition + 1 <= spanCount) {
                                int i3 = this.f33317c;
                                rect.set(0, i3, i3, i3);
                            } else if ((childAdapterPosition + spanCount) % spanCount == 0) {
                                int i4 = this.f33317c;
                                rect.set(i4, 0, i4, i4);
                            } else {
                                int i5 = this.f33317c;
                                rect.set(0, 0, i5, i5);
                            }
                        }
                    } else if (childAdapterPosition != itemCount - 1) {
                        rect.set(0, 0, 0, this.f33317c);
                    }
                } else if (childAdapterPosition != 0) {
                    rect.set(0, this.f33317c, 0, 0);
                }
            } else if (childAdapterPosition != 0) {
                rect.set(this.f33317c, 0, 0, 0);
            }
        }
    }

    public void drawHorizontal(Canvas canvas, RecyclerView recyclerView) {
        Intrinsics.checkParameterIsNotNull(canvas, "c");
        Intrinsics.checkParameterIsNotNull(recyclerView, "parent");
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            Intrinsics.checkExpressionValueIsNotNull(childAt, "child");
            m23432a(canvas, childAt, recyclerView);
        }
    }

    /* renamed from: a */
    private final void m23433a(Canvas canvas, RecyclerView recyclerView) {
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            Intrinsics.checkExpressionValueIsNotNull(childAt, "child");
            m23435b(canvas, childAt, recyclerView);
        }
    }

    /* renamed from: b */
    private final void m23436b(Canvas canvas, RecyclerView recyclerView) {
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof GridLayoutManager) {
                int spanCount = ((GridLayoutManager) layoutManager).getSpanCount();
                if (i == 0) {
                    Intrinsics.checkExpressionValueIsNotNull(childAt, "child");
                    m23435b(canvas, childAt, recyclerView);
                    m23432a(canvas, childAt, recyclerView);
                }
                if (i + 1 <= spanCount) {
                    Intrinsics.checkExpressionValueIsNotNull(childAt, "child");
                    m23435b(canvas, childAt, recyclerView);
                }
                if ((i + spanCount) % spanCount == 0) {
                    Intrinsics.checkExpressionValueIsNotNull(childAt, "child");
                    m23432a(canvas, childAt, recyclerView);
                }
                Intrinsics.checkExpressionValueIsNotNull(childAt, "child");
                m23437c(canvas, childAt, recyclerView);
                m23438d(canvas, childAt, recyclerView);
            }
        }
    }

    /* renamed from: a */
    private final void m23432a(Canvas canvas, View view, RecyclerView recyclerView) {
        int i;
        int i2;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
            int left = (view.getLeft() - this.f33317c) - layoutParams2.leftMargin;
            int top = view.getTop() - layoutParams2.topMargin;
            int left2 = view.getLeft() - layoutParams2.leftMargin;
            if (m23434a(recyclerView)) {
                i2 = view.getBottom() + layoutParams2.bottomMargin;
                i = this.f33317c;
            } else {
                i2 = view.getBottom();
                i = layoutParams2.bottomMargin;
            }
            canvas.drawRect((float) left, (float) top, (float) left2, (float) (i2 + i), this.f33315a);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
    }

    /* renamed from: b */
    private final void m23435b(Canvas canvas, View view, RecyclerView recyclerView) {
        int i;
        int i2;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
            int top = (view.getTop() - layoutParams2.topMargin) - this.f33317c;
            int right = view.getRight() + layoutParams2.rightMargin;
            int top2 = view.getTop() - layoutParams2.topMargin;
            if (m23434a(recyclerView)) {
                i2 = view.getLeft() - layoutParams2.leftMargin;
                i = this.f33317c;
            } else {
                i2 = view.getLeft();
                i = layoutParams2.leftMargin;
            }
            canvas.drawRect((float) (i2 - i), (float) top, (float) right, (float) top2, this.f33315a);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
    }

    /* renamed from: c */
    private final void m23437c(Canvas canvas, View view, RecyclerView recyclerView) {
        int i;
        int i2;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
            int right = view.getRight() + layoutParams2.rightMargin;
            int i3 = this.f33317c + right;
            int bottom = view.getBottom() + layoutParams2.bottomMargin;
            if (m23434a(recyclerView)) {
                i2 = view.getTop() - layoutParams2.topMargin;
                i = this.f33317c;
            } else {
                i2 = view.getTop();
                i = layoutParams2.topMargin;
            }
            canvas.drawRect((float) right, (float) (i2 - i), (float) i3, (float) bottom, this.f33315a);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
    }

    /* renamed from: d */
    private final void m23438d(Canvas canvas, View view, RecyclerView recyclerView) {
        int i;
        int i2;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
            int left = view.getLeft() - layoutParams2.leftMargin;
            int bottom = view.getBottom() + layoutParams2.bottomMargin;
            int i3 = this.f33317c + bottom;
            if (m23434a(recyclerView)) {
                i2 = view.getRight() + layoutParams2.rightMargin;
                i = this.f33317c;
            } else {
                i2 = view.getRight();
                i = layoutParams2.rightMargin;
            }
            canvas.drawRect((float) left, (float) bottom, (float) (i2 + i), (float) i3, this.f33315a);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
    }

    /* renamed from: a */
    private final boolean m23434a(RecyclerView recyclerView) {
        return recyclerView.getLayoutManager() instanceof GridLayoutManager;
    }
}
