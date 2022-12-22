package com.didi.rfusion.widget.calendar;

import android.os.Build;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/rfusion/widget/calendar/RFCalendar$initActionsToMonthNavigation$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: RFCalendar.kt */
public final class RFCalendar$initActionsToMonthNavigation$1 extends RecyclerView.OnScrollListener {
    final /* synthetic */ RFMonthsPagerAdapter $monthsPagerAdapter;
    final /* synthetic */ RFCalendar this$0;

    RFCalendar$initActionsToMonthNavigation$1(RFCalendar rFCalendar, RFMonthsPagerAdapter rFMonthsPagerAdapter) {
        this.this$0 = rFCalendar;
        this.$monthsPagerAdapter = rFMonthsPagerAdapter;
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        int i3;
        Intrinsics.checkParameterIsNotNull(recyclerView, "recyclerView");
        if (i < 0) {
            i3 = this.this$0.getLayoutManager().findFirstVisibleItemPosition();
        } else {
            i3 = this.this$0.getLayoutManager().findLastVisibleItemPosition();
        }
        this.this$0.f33424q = this.$monthsPagerAdapter.getPageMonth(i3);
        RFCalendar.access$getTvMonthDate$p(this.this$0).setText(this.$monthsPagerAdapter.getPageTitle(i3));
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "recyclerView");
        if (i == 0) {
            CharSequence text = RFCalendar.access$getTvMonthDate$p(this.this$0).getText();
            if (Build.VERSION.SDK_INT >= 16) {
                recyclerView.announceForAccessibility(text);
            } else {
                recyclerView.sendAccessibilityEvent(2048);
            }
        }
    }
}
