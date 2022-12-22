package com.didi.rfusion.widget.calendar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.rfusion.widget.calendar.RFCalendar;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH\u0016J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\rJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\rJ\u000e\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0012J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\rH\u0016J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\rH\u0016J\u001a\u0010\u001e\u001a\u00020\u00182\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, mo175978d2 = {"Lcom/didi/rfusion/widget/calendar/RFMonthsPagerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/didi/rfusion/widget/calendar/RFMonthsPagerAdapter$ViewHolder;", "context", "Landroid/content/Context;", "dateSelector", "Lcom/didi/rfusion/widget/calendar/RFDateSelector;", "calendarConstraints", "Lcom/didi/rfusion/widget/calendar/RFCalendarConstraints;", "onDayClickListener", "Lcom/didi/rfusion/widget/calendar/RFCalendar$OnDayClickListener;", "(Landroid/content/Context;Lcom/didi/rfusion/widget/calendar/RFDateSelector;Lcom/didi/rfusion/widget/calendar/RFCalendarConstraints;Lcom/didi/rfusion/widget/calendar/RFCalendar$OnDayClickListener;)V", "getItemCount", "", "getItemId", "", "position", "getPageMonth", "Lcom/didi/rfusion/widget/calendar/Month;", "getPageTitle", "", "getPosition", "month", "onBindViewHolder", "", "viewHolder", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "updateCalendar", "ViewHolder", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: RFMonthsPagerAdapter.kt */
public final class RFMonthsPagerAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: a */
    private final Context f33461a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final RFCalendar.OnDayClickListener f33462b;

    /* renamed from: c */
    private RFCalendarConstraints f33463c;

    /* renamed from: d */
    private RFDateSelector<?> f33464d;

    public RFMonthsPagerAdapter(Context context, RFDateSelector<?> rFDateSelector, RFCalendarConstraints rFCalendarConstraints, RFCalendar.OnDayClickListener onDayClickListener) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(rFDateSelector, "dateSelector");
        Intrinsics.checkParameterIsNotNull(rFCalendarConstraints, "calendarConstraints");
        Intrinsics.checkParameterIsNotNull(onDayClickListener, "onDayClickListener");
        Month a = rFCalendarConstraints.mo87568a();
        Intrinsics.checkExpressionValueIsNotNull(a, "calendarConstraints.start");
        Month b = rFCalendarConstraints.mo87571b();
        Intrinsics.checkExpressionValueIsNotNull(b, "calendarConstraints.end");
        Month c = rFCalendarConstraints.mo87573c();
        if (c == null) {
            Intrinsics.throwNpe();
        }
        boolean z = false;
        if (a.compareTo(c) <= 0) {
            if (c.compareTo(b) <= 0 ? true : z) {
                this.f33461a = context;
                this.f33463c = rFCalendarConstraints;
                this.f33464d = rFDateSelector;
                this.f33462b = onDayClickListener;
                setHasStableIds(true);
                return;
            }
            throw new IllegalArgumentException("currentPage cannot be after lastPage".toString());
        }
        throw new IllegalArgumentException("firstPage cannot be after currentPage".toString());
    }

    public final void updateCalendar(RFDateSelector<?> rFDateSelector, RFCalendarConstraints rFCalendarConstraints) {
        Intrinsics.checkParameterIsNotNull(rFDateSelector, "dateSelector");
        Intrinsics.checkParameterIsNotNull(rFCalendarConstraints, "calendarConstraints");
        this.f33464d = rFDateSelector;
        this.f33463c = rFCalendarConstraints;
        notifyDataSetChanged();
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "viewGroup");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rf_item_calendar_month, viewGroup, false);
        if (inflate != null) {
            return new ViewHolder((RFCalendarGridView) inflate);
        }
        throw new TypeCastException("null cannot be cast to non-null type com.didi.rfusion.widget.calendar.RFCalendarGridView");
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "viewHolder");
        Month b = this.f33463c.mo87568a().mo87541b(i);
        Intrinsics.checkExpressionValueIsNotNull(b, "calendarConstraints.start.monthsLater(position)");
        RFCalendarGridView monthGrid = viewHolder.getMonthGrid();
        if (monthGrid.getAdapter() == null || !Intrinsics.areEqual((Object) b, (Object) monthGrid.getAdapter().f33476b)) {
            C11542c cVar = new C11542c(b, this.f33464d, this.f33463c);
            monthGrid.setNumColumns(b.f33401c);
            monthGrid.setAdapter((ListAdapter) cVar);
        } else {
            monthGrid.invalidate();
            monthGrid.getAdapter().mo87675a(monthGrid);
        }
        monthGrid.setOnItemClickListener(new RFMonthsPagerAdapter$onBindViewHolder$1(this, monthGrid));
    }

    public long getItemId(int i) {
        Month b = this.f33463c.mo87568a().mo87541b(i);
        Intrinsics.checkExpressionValueIsNotNull(b, "calendarConstraints.start.monthsLater(position)");
        return b.mo87542c();
    }

    public int getItemCount() {
        return this.f33463c.mo87574d();
    }

    public final CharSequence getPageTitle(int i) {
        String a = getPageMonth(i).mo87537a(this.f33461a);
        Intrinsics.checkExpressionValueIsNotNull(a, "getPageMonth(position).getLongName(context)");
        return a;
    }

    public final Month getPageMonth(int i) {
        Month b = this.f33463c.mo87568a().mo87541b(i);
        Intrinsics.checkExpressionValueIsNotNull(b, "calendarConstraints.start.monthsLater(position)");
        return b;
    }

    public final int getPosition(Month month) {
        Intrinsics.checkParameterIsNotNull(month, "month");
        return this.f33463c.mo87568a().mo87540b(month);
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, mo175978d2 = {"Lcom/didi/rfusion/widget/calendar/RFMonthsPagerAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "container", "Lcom/didi/rfusion/widget/calendar/RFCalendarGridView;", "(Lcom/didi/rfusion/widget/calendar/RFCalendarGridView;)V", "monthGrid", "getMonthGrid", "()Lcom/didi/rfusion/widget/calendar/RFCalendarGridView;", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: RFMonthsPagerAdapter.kt */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final RFCalendarGridView monthGrid;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(RFCalendarGridView rFCalendarGridView) {
            super(rFCalendarGridView);
            Intrinsics.checkParameterIsNotNull(rFCalendarGridView, "container");
            this.monthGrid = rFCalendarGridView;
        }

        public final RFCalendarGridView getMonthGrid() {
            return this.monthGrid;
        }
    }
}
