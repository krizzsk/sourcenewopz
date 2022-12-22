package com.didi.rfusion.widget.calendar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.rfusion.RFusion;
import com.taxis99.R;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\tH\u0016J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/rfusion/widget/calendar/RFYearGridAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/didi/rfusion/widget/calendar/RFYearGridAdapter$ViewHolder;", "materialCalendar", "Lcom/didi/rfusion/widget/calendar/RFCalendar;", "(Lcom/didi/rfusion/widget/calendar/RFCalendar;)V", "createYearClickListener", "Landroid/view/View$OnClickListener;", "year", "", "getItemCount", "getPositionForYear", "getYearForPosition", "position", "onBindViewHolder", "", "viewHolder", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: RFYearGridAdapter.kt */
public final class RFYearGridAdapter extends RecyclerView.Adapter<ViewHolder> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final RFCalendar f33468a;

    public RFYearGridAdapter(RFCalendar rFCalendar) {
        Intrinsics.checkParameterIsNotNull(rFCalendar, "materialCalendar");
        this.f33468a = rFCalendar;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/rfusion/widget/calendar/RFYearGridAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: RFYearGridAdapter.kt */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkParameterIsNotNull(view, "view");
            View findViewById = view.findViewById(R.id.rf_tv_year);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "view.findViewById(R.id.rf_tv_year)");
            this.textView = (TextView) findViewById;
        }

        public final TextView getTextView() {
            return this.textView;
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "viewGroup");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rf_item_calendar_year, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "yearContainer");
        return new ViewHolder(inflate);
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "viewHolder");
        int yearForPosition = getYearForPosition(i);
        TextView textView = viewHolder.getTextView();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Locale locale = RFusion.getLocale();
        Intrinsics.checkExpressionValueIsNotNull(locale, "RFusion.getLocale()");
        String format = String.format(locale, TimeModel.NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(yearForPosition)}, 1));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(locale, format, *args)");
        textView.setText(format);
        RFCalendarStyle calendarStyle$r_fusion_ninePhoneRelease = this.f33468a.getCalendarStyle$r_fusion_ninePhoneRelease();
        Calendar b = C11544e.m23564b();
        RFCalendarItemStyle todayYear = b.get(1) == yearForPosition ? calendarStyle$r_fusion_ninePhoneRelease.getTodayYear() : calendarStyle$r_fusion_ninePhoneRelease.getYear();
        for (Long next : this.f33468a.getDateSelector$r_fusion_ninePhoneRelease().getSelectedDays()) {
            Intrinsics.checkExpressionValueIsNotNull(b, "calendar");
            if (next == null) {
                Intrinsics.throwNpe();
            }
            b.setTimeInMillis(next.longValue());
            if (b.get(1) == yearForPosition) {
                todayYear = calendarStyle$r_fusion_ninePhoneRelease.getSelectedYear();
            }
        }
        todayYear.styleItem(viewHolder.getTextView());
        viewHolder.getTextView().setOnClickListener(m23517a(yearForPosition));
    }

    /* renamed from: a */
    private final View.OnClickListener m23517a(int i) {
        return new RFYearGridAdapter$createYearClickListener$1(this, i);
    }

    public int getItemCount() {
        return this.f33468a.getCalendarConstraints().mo87576e();
    }

    public final int getPositionForYear(int i) {
        return i - this.f33468a.getCalendarConstraints().mo87568a().f33400b;
    }

    public final int getYearForPosition(int i) {
        return this.f33468a.getCalendarConstraints().mo87568a().f33400b + i;
    }
}
