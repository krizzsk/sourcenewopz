package com.didi.rfusion.widget.calendar;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0014¨\u0006\u0006"}, mo175978d2 = {"com/didi/rfusion/widget/calendar/RFCalendar$initDayOfMonth$layoutManager$1", "Lcom/didi/rfusion/widget/calendar/RFSmoothCalendarLayoutManager;", "getExtraLayoutSpace", "", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: RFCalendar.kt */
public final class RFCalendar$initDayOfMonth$layoutManager$1 extends RFSmoothCalendarLayoutManager {
    final /* synthetic */ RFCalendar this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RFCalendar$initDayOfMonth$layoutManager$1(RFCalendar rFCalendar, Context context, int i, boolean z) {
        super(context, i, z);
        this.this$0 = rFCalendar;
    }

    /* access modifiers changed from: protected */
    public int getExtraLayoutSpace(RecyclerView.State state) {
        return RFCalendar.access$getRvMonths$p(this.this$0).getWidth();
    }
}
