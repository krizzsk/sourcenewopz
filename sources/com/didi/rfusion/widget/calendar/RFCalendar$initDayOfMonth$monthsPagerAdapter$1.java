package com.didi.rfusion.widget.calendar;

import androidx.recyclerview.widget.RecyclerView;
import com.didi.rfusion.widget.calendar.RFCalendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/rfusion/widget/calendar/RFCalendar$initDayOfMonth$monthsPagerAdapter$1", "Lcom/didi/rfusion/widget/calendar/RFCalendar$OnDayClickListener;", "onDayClick", "", "day", "", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: RFCalendar.kt */
public final class RFCalendar$initDayOfMonth$monthsPagerAdapter$1 implements RFCalendar.OnDayClickListener {
    final /* synthetic */ RFCalendar this$0;

    RFCalendar$initDayOfMonth$monthsPagerAdapter$1(RFCalendar rFCalendar) {
        this.this$0 = rFCalendar;
    }

    public void onDayClick(long j) {
        if (RFCalendar.access$getCalendarConstraints$p(this.this$0).getDateValidator().isValid(j)) {
            this.this$0.getDateSelector$r_fusion_ninePhoneRelease().select(j);
            this.this$0.m23489e();
            RFCalendar rFCalendar = this.this$0;
            rFCalendar.m23484a(RFCalendar.access$getDateSelection$p(rFCalendar));
            RecyclerView.Adapter adapter = RFCalendar.access$getRvMonths$p(this.this$0).getAdapter();
            if (adapter == null) {
                Intrinsics.throwNpe();
            }
            adapter.notifyDataSetChanged();
            RecyclerView.Adapter adapter2 = RFCalendar.access$getRvYearSelector$p(this.this$0).getAdapter();
            if (adapter2 == null) {
                Intrinsics.throwNpe();
            }
            adapter2.notifyDataSetChanged();
        }
    }
}
