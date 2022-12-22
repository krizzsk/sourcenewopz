package com.didi.rfusion.widget.calendar;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006"}, mo175978d2 = {"com/didi/rfusion/widget/calendar/RFSmoothCalendarLayoutManager$smoothScrollToPosition$linearSmoothScroller$1", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* renamed from: com.didi.rfusion.widget.calendar.RFSmoothCalendarLayoutManager$smoothScrollToPosition$linearSmoothScroller$1 */
/* compiled from: RFSmoothCalendarLayoutManager.kt */
public final class C11539xbd1fc49e extends LinearSmoothScroller {
    final /* synthetic */ RecyclerView $recyclerView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C11539xbd1fc49e(RecyclerView recyclerView, Context context) {
        super(context);
        this.$recyclerView = recyclerView;
    }

    /* access modifiers changed from: protected */
    public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        Intrinsics.checkParameterIsNotNull(displayMetrics, "displayMetrics");
        return 100.0f / ((float) displayMetrics.densityDpi);
    }
}
