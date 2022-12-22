package com.didi.rfusion.widget.calendar;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.core.util.Pair;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.rfusion.utils.RFResUtils;
import com.taxis99.R;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0016\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo175978d2 = {"com/didi/rfusion/widget/calendar/RFCalendar$createItemDecoration$1", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "endItem", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "startItem", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onDraw", "canvas", "Landroid/graphics/Canvas;", "recyclerView", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: RFCalendar.kt */
public final class RFCalendar$createItemDecoration$1 extends RecyclerView.ItemDecoration {
    private final Calendar endItem = C11544e.m23567c();
    private final Calendar startItem = C11544e.m23567c();
    final /* synthetic */ RFCalendar this$0;

    RFCalendar$createItemDecoration$1(RFCalendar rFCalendar) {
        this.this$0 = rFCalendar;
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int i;
        int i2;
        int i3;
        RFCalendar$createItemDecoration$1 rFCalendar$createItemDecoration$1 = this;
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        Intrinsics.checkParameterIsNotNull(recyclerView, "recyclerView");
        Intrinsics.checkParameterIsNotNull(state, "state");
        if ((recyclerView.getAdapter() instanceof RFYearGridAdapter) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
            RFYearGridAdapter rFYearGridAdapter = (RFYearGridAdapter) recyclerView.getAdapter();
            GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
            for (Pair next : rFCalendar$createItemDecoration$1.this$0.getDateSelector$r_fusion_ninePhoneRelease().getSelectedRanges()) {
                if (next.first != null && next.second != null) {
                    Calendar calendar = rFCalendar$createItemDecoration$1.startItem;
                    Intrinsics.checkExpressionValueIsNotNull(calendar, "startItem");
                    F f = next.first;
                    if (f == null) {
                        Intrinsics.throwNpe();
                    }
                    calendar.setTimeInMillis(((Number) f).longValue());
                    Calendar calendar2 = rFCalendar$createItemDecoration$1.endItem;
                    Intrinsics.checkExpressionValueIsNotNull(calendar2, "endItem");
                    S s = next.second;
                    if (s == null) {
                        Intrinsics.throwNpe();
                    }
                    calendar2.setTimeInMillis(((Number) s).longValue());
                    if (rFYearGridAdapter == null) {
                        Intrinsics.throwNpe();
                    }
                    int positionForYear = rFYearGridAdapter.getPositionForYear(rFCalendar$createItemDecoration$1.startItem.get(1));
                    int positionForYear2 = rFYearGridAdapter.getPositionForYear(rFCalendar$createItemDecoration$1.endItem.get(1));
                    if (gridLayoutManager == null) {
                        Intrinsics.throwNpe();
                    }
                    View findViewByPosition = gridLayoutManager.findViewByPosition(positionForYear);
                    View findViewByPosition2 = gridLayoutManager.findViewByPosition(positionForYear2);
                    int spanCount = positionForYear / gridLayoutManager.getSpanCount();
                    int spanCount2 = positionForYear2 / gridLayoutManager.getSpanCount();
                    if (spanCount <= spanCount2) {
                        int i4 = spanCount;
                        while (true) {
                            View findViewByPosition3 = gridLayoutManager.findViewByPosition(gridLayoutManager.getSpanCount() * i4);
                            if (findViewByPosition3 != null) {
                                Intrinsics.checkExpressionValueIsNotNull(findViewByPosition3, "layoutManager.findViewBy…              ?: continue");
                                int top = findViewByPosition3.getTop() + RFCalendar.access$getCalendarStyle$p(rFCalendar$createItemDecoration$1.this$0).getYear().getTopInset();
                                int bottom = findViewByPosition3.getBottom() - RFCalendar.access$getCalendarStyle$p(rFCalendar$createItemDecoration$1.this$0).getYear().getBottomInset();
                                if (i4 == spanCount) {
                                    if (findViewByPosition == null) {
                                        Intrinsics.throwNpe();
                                    }
                                    i2 = findViewByPosition.getLeft() + (findViewByPosition.getWidth() / 2);
                                } else {
                                    i2 = 0;
                                }
                                if (i4 == spanCount2) {
                                    if (findViewByPosition2 == null) {
                                        Intrinsics.throwNpe();
                                    }
                                    i3 = findViewByPosition2.getLeft() + (findViewByPosition2.getWidth() / 2);
                                } else {
                                    i3 = recyclerView.getWidth();
                                }
                                float f2 = (float) top;
                                float f3 = (float) bottom;
                                Paint rangeFill = RFCalendar.access$getCalendarStyle$p(rFCalendar$createItemDecoration$1.this$0).getRangeFill();
                                float f4 = f3;
                                i = i4;
                                canvas.drawRect((float) i2, f2, (float) i3, f4, rangeFill);
                            } else {
                                i = i4;
                            }
                            if (i == spanCount2) {
                                break;
                            }
                            i4 = i + 1;
                            rFCalendar$createItemDecoration$1 = this;
                        }
                    }
                }
                rFCalendar$createItemDecoration$1 = this;
            }
        }
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        Intrinsics.checkParameterIsNotNull(rect, "outRect");
        Intrinsics.checkParameterIsNotNull(view, "view");
        Intrinsics.checkParameterIsNotNull(recyclerView, "parent");
        Intrinsics.checkParameterIsNotNull(state, "state");
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            Intrinsics.checkExpressionValueIsNotNull(adapter, "parent.adapter ?: return");
            if (layoutManager instanceof GridLayoutManager) {
                rect.set(0, 0, 0, childAdapterPosition < adapter.getItemCount() - ((GridLayoutManager) layoutManager).getSpanCount() ? (int) RFResUtils.getDimens(this.this$0.getContext(), R.dimen.rf_dimen_24) : 0);
            }
        }
    }
}
