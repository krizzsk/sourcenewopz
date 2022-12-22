package com.didi.rfusion.widget.calendar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import androidx.core.util.Pair;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.rfusion.utils.RFResUtils;
import com.didi.rfusion.widget.RFIconView;
import com.didi.rfusion.widget.RFTextView;
import com.didi.rfusion.widget.calendar.RFCalendarConstraints;
import com.taxis99.R;
import java.util.Calendar;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u0000 M2\u00020\u0001:\u0004LMNOB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010&\u001a\u00020\u0010H\u0002J\b\u0010'\u001a\u00020(H\u0002J\u0006\u0010)\u001a\u00020\nJ\r\u0010*\u001a\u00020\u000eH\u0000¢\u0006\u0002\b+J\r\u0010,\u001a\u00020\u0010H\u0000¢\u0006\u0002\b-J\u0011\u0010.\u001a\u0006\u0012\u0002\b\u00030/H\u0000¢\u0006\u0002\b0J\b\u00101\u001a\u000202H\u0002J\u0010\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0002J\b\u00107\u001a\u000204H\u0002J\b\u00108\u001a\u000204H\u0002J\b\u00109\u001a\u000204H\u0002J\b\u0010:\u001a\u000204H\u0002J\b\u0010;\u001a\u000204H\u0002J\u001c\u0010<\u001a\u000204\"\u0004\b\u0000\u0010=2\f\u0010>\u001a\b\u0012\u0004\u0012\u0002H=0\u0012H\u0002J\u0010\u0010?\u001a\u0002042\u0006\u0010@\u001a\u00020\u0007H\u0002J\b\u0010A\u001a\u000204H\u0002J\u0015\u0010B\u001a\u0002042\u0006\u0010C\u001a\u00020\u0010H\u0000¢\u0006\u0002\bDJ\u0015\u0010E\u001a\u0002042\u0006\u0010F\u001a\u00020\fH\u0000¢\u0006\u0002\bGJ&\u0010H\u001a\u000204\"\u0004\b\u0000\u0010=2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u0002H=\u0018\u00010\u00122\b\u0010I\u001a\u0004\u0018\u00010\nJ\b\u0010J\u001a\u000204H\u0002J\b\u0010K\u001a\u000204H\u0002R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0001X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020!X.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020!X.¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020!X.¢\u0006\u0002\n\u0000¨\u0006P"}, mo175978d2 = {"Lcom/didi/rfusion/widget/calendar/RFCalendar;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "calendarConstraints", "Lcom/didi/rfusion/widget/calendar/RFCalendarConstraints;", "calendarSelector", "Lcom/didi/rfusion/widget/calendar/RFCalendar$CalendarSelector;", "calendarStyle", "Lcom/didi/rfusion/widget/calendar/RFCalendarStyle;", "current", "Lcom/didi/rfusion/widget/calendar/Month;", "dateSelection", "Lcom/didi/rfusion/widget/calendar/RFDateSelection;", "flTitle", "gvDaysOfWeek", "Landroid/widget/GridView;", "ivMonthIcon", "Lcom/didi/rfusion/widget/RFIconView;", "ivNext", "ivPrev", "llDaySelector", "Landroid/widget/LinearLayout;", "llMonthToggle", "rvMonths", "Landroidx/recyclerview/widget/RecyclerView;", "rvYearSelector", "tvEndDate", "Lcom/didi/rfusion/widget/RFTextView;", "tvMonthDate", "tvPartition", "tvStartDate", "tvTempTitle", "createDefaultOpenAt", "createItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getCalendarConstraints", "getCalendarStyle", "getCalendarStyle$r_fusion_ninePhoneRelease", "getCurrentMonth", "getCurrentMonth$r_fusion_ninePhoneRelease", "getDateSelector", "Lcom/didi/rfusion/widget/calendar/RFDateSelector;", "getDateSelector$r_fusion_ninePhoneRelease", "getLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "initActionsToMonthNavigation", "", "monthsPagerAdapter", "Lcom/didi/rfusion/widget/calendar/RFMonthsPagerAdapter;", "initData", "initDayOfMonth", "initDaysOfWeek", "initView", "initYear", "notifySelectedChanged", "T", "selection", "postSmoothRecyclerViewScroll", "position", "processLogic", "setCurrentMonth", "moveTo", "setCurrentMonth$r_fusion_ninePhoneRelease", "setSelector", "selector", "setSelector$r_fusion_ninePhoneRelease", "setup", "constraints", "toggleVisibleSelector", "updateTitle", "CalendarSelector", "Companion", "DateSelectionBuilder", "OnDayClickListener", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: RFCalendar.kt */
public final class RFCalendar extends FrameLayout {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: t */
    private static final int f33406t = 3;

    /* renamed from: u */
    private static final int f33407u = 4;

    /* renamed from: a */
    private FrameLayout f33408a;

    /* renamed from: b */
    private RFTextView f33409b;

    /* renamed from: c */
    private RFTextView f33410c;

    /* renamed from: d */
    private RFTextView f33411d;

    /* renamed from: e */
    private RFTextView f33412e;

    /* renamed from: f */
    private LinearLayout f33413f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public RFTextView f33414g;

    /* renamed from: h */
    private RFIconView f33415h;

    /* renamed from: i */
    private RFIconView f33416i;

    /* renamed from: j */
    private RFIconView f33417j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public RecyclerView f33418k;

    /* renamed from: l */
    private LinearLayout f33419l;

    /* renamed from: m */
    private GridView f33420m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public RecyclerView f33421n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public RFDateSelection<?> f33422o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public RFCalendarConstraints f33423p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public Month f33424q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public RFCalendarStyle f33425r;

    /* renamed from: s */
    private CalendarSelector f33426s;

    /* renamed from: v */
    private HashMap f33427v;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/rfusion/widget/calendar/RFCalendar$CalendarSelector;", "", "(Ljava/lang/String;I)V", "DAY", "YEAR", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: RFCalendar.kt */
    public enum CalendarSelector {
        DAY,
        YEAR
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/rfusion/widget/calendar/RFCalendar$OnDayClickListener;", "", "onDayClick", "", "day", "", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: RFCalendar.kt */
    public interface OnDayClickListener {
        void onDayClick(long j);
    }

    public RFCalendar(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public RFCalendar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.f33427v;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f33427v == null) {
            this.f33427v = new HashMap();
        }
        View view = (View) this.f33427v.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f33427v.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public static final /* synthetic */ RFCalendarConstraints access$getCalendarConstraints$p(RFCalendar rFCalendar) {
        RFCalendarConstraints rFCalendarConstraints = rFCalendar.f33423p;
        if (rFCalendarConstraints == null) {
            Intrinsics.throwUninitializedPropertyAccessException("calendarConstraints");
        }
        return rFCalendarConstraints;
    }

    public static final /* synthetic */ RFCalendarStyle access$getCalendarStyle$p(RFCalendar rFCalendar) {
        RFCalendarStyle rFCalendarStyle = rFCalendar.f33425r;
        if (rFCalendarStyle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("calendarStyle");
        }
        return rFCalendarStyle;
    }

    public static final /* synthetic */ Month access$getCurrent$p(RFCalendar rFCalendar) {
        Month month = rFCalendar.f33424q;
        if (month == null) {
            Intrinsics.throwUninitializedPropertyAccessException("current");
        }
        return month;
    }

    public static final /* synthetic */ RFDateSelection access$getDateSelection$p(RFCalendar rFCalendar) {
        RFDateSelection<?> rFDateSelection = rFCalendar.f33422o;
        if (rFDateSelection == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dateSelection");
        }
        return rFDateSelection;
    }

    public static final /* synthetic */ RecyclerView access$getRvMonths$p(RFCalendar rFCalendar) {
        RecyclerView recyclerView = rFCalendar.f33421n;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rvMonths");
        }
        return recyclerView;
    }

    public static final /* synthetic */ RecyclerView access$getRvYearSelector$p(RFCalendar rFCalendar) {
        RecyclerView recyclerView = rFCalendar.f33418k;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rvYearSelector");
        }
        return recyclerView;
    }

    public static final /* synthetic */ RFTextView access$getTvMonthDate$p(RFCalendar rFCalendar) {
        RFTextView rFTextView = rFCalendar.f33414g;
        if (rFTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvMonthDate");
        }
        return rFTextView;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RFCalendar(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RFCalendar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        FrameLayout.inflate(context, R.layout.rf_calendar, this);
        m23486b();
        m23482a();
        m23490f();
        m23491g();
        m23492h();
        m23488d();
    }

    /* renamed from: a */
    private final void m23482a() {
        View findViewById = findViewById(R.id.rf_fl_title);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "findViewById(R.id.rf_fl_title)");
        this.f33408a = (FrameLayout) findViewById;
        View findViewById2 = findViewById(R.id.rf_tv_start_date);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "findViewById(R.id.rf_tv_start_date)");
        this.f33409b = (RFTextView) findViewById2;
        View findViewById3 = findViewById(R.id.rf_tv_partition);
        Intrinsics.checkExpressionValueIsNotNull(findViewById3, "findViewById(R.id.rf_tv_partition)");
        this.f33410c = (RFTextView) findViewById3;
        View findViewById4 = findViewById(R.id.rf_tv_end_date);
        Intrinsics.checkExpressionValueIsNotNull(findViewById4, "findViewById(R.id.rf_tv_end_date)");
        this.f33411d = (RFTextView) findViewById4;
        View findViewById5 = findViewById(R.id.rf_tv_temp_title);
        Intrinsics.checkExpressionValueIsNotNull(findViewById5, "findViewById(R.id.rf_tv_temp_title)");
        this.f33412e = (RFTextView) findViewById5;
        View findViewById6 = findViewById(R.id.rf_ll_month_toggle);
        Intrinsics.checkExpressionValueIsNotNull(findViewById6, "findViewById(R.id.rf_ll_month_toggle)");
        this.f33413f = (LinearLayout) findViewById6;
        View findViewById7 = findViewById(R.id.rf_tv_month_date);
        Intrinsics.checkExpressionValueIsNotNull(findViewById7, "findViewById(R.id.rf_tv_month_date)");
        this.f33414g = (RFTextView) findViewById7;
        View findViewById8 = findViewById(R.id.rf_iv_month_icon);
        Intrinsics.checkExpressionValueIsNotNull(findViewById8, "findViewById(R.id.rf_iv_month_icon)");
        this.f33415h = (RFIconView) findViewById8;
        View findViewById9 = findViewById(R.id.rf_iv_previous);
        Intrinsics.checkExpressionValueIsNotNull(findViewById9, "findViewById(R.id.rf_iv_previous)");
        this.f33416i = (RFIconView) findViewById9;
        View findViewById10 = findViewById(R.id.rf_iv_next);
        Intrinsics.checkExpressionValueIsNotNull(findViewById10, "findViewById(R.id.rf_iv_next)");
        this.f33417j = (RFIconView) findViewById10;
        View findViewById11 = findViewById(R.id.rf_rv_year_selector);
        Intrinsics.checkExpressionValueIsNotNull(findViewById11, "findViewById(R.id.rf_rv_year_selector)");
        this.f33418k = (RecyclerView) findViewById11;
        View findViewById12 = findViewById(R.id.rf_ll_day_selector);
        Intrinsics.checkExpressionValueIsNotNull(findViewById12, "findViewById(R.id.rf_ll_day_selector)");
        this.f33419l = (LinearLayout) findViewById12;
        View findViewById13 = findViewById(R.id.rf_gv_days_of_week);
        Intrinsics.checkExpressionValueIsNotNull(findViewById13, "findViewById(R.id.rf_gv_days_of_week)");
        this.f33420m = (GridView) findViewById13;
        View findViewById14 = findViewById(R.id.rf_rv_months);
        Intrinsics.checkExpressionValueIsNotNull(findViewById14, "findViewById(R.id.rf_rv_months)");
        this.f33421n = (RecyclerView) findViewById14;
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        RecyclerView recyclerView = this.f33421n;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rvMonths");
        }
        pagerSnapHelper.attachToRecyclerView(recyclerView);
    }

    /* renamed from: b */
    private final void m23486b() {
        RFCalendarConstraints build = new RFCalendarConstraints.Builder().build();
        Intrinsics.checkExpressionValueIsNotNull(build, "RFCalendarConstraints.Builder().build()");
        this.f33423p = build;
        this.f33422o = DateSelectionBuilder.Companion.singleDateSelection().build();
        RFCalendarConstraints rFCalendarConstraints = this.f33423p;
        if (rFCalendarConstraints == null) {
            Intrinsics.throwUninitializedPropertyAccessException("calendarConstraints");
        }
        if (rFCalendarConstraints.mo87573c() == null) {
            RFCalendarConstraints rFCalendarConstraints2 = this.f33423p;
            if (rFCalendarConstraints2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("calendarConstraints");
            }
            rFCalendarConstraints2.mo87569a(m23487c());
        }
        RFCalendarConstraints rFCalendarConstraints3 = this.f33423p;
        if (rFCalendarConstraints3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("calendarConstraints");
        }
        Month c = rFCalendarConstraints3.mo87573c();
        if (c == null) {
            Intrinsics.throwNpe();
        }
        this.f33424q = c;
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        this.f33425r = new RFCalendarStyle(context);
    }

    /* renamed from: c */
    private final Month m23487c() {
        RFCalendarConstraints rFCalendarConstraints = this.f33423p;
        if (rFCalendarConstraints == null) {
            Intrinsics.throwUninitializedPropertyAccessException("calendarConstraints");
        }
        long j = rFCalendarConstraints.mo87568a().f33403e;
        RFCalendarConstraints rFCalendarConstraints2 = this.f33423p;
        if (rFCalendarConstraints2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("calendarConstraints");
        }
        long j2 = rFCalendarConstraints2.mo87571b().f33403e;
        if (!getDateSelector$r_fusion_ninePhoneRelease().getSelectedDays().isEmpty()) {
            Long next = getDateSelector$r_fusion_ninePhoneRelease().getSelectedDays().iterator().next();
            Intrinsics.checkExpressionValueIsNotNull(next, "getDateSelector().selectedDays.iterator().next()");
            long longValue = next.longValue();
            if (j <= longValue && j2 >= longValue) {
                Month a = Month.m23473a(longValue);
                Intrinsics.checkExpressionValueIsNotNull(a, "Month.create(firstSelectedDay)");
                return a;
            }
        }
        long j3 = Month.m23471a().f33403e;
        if (j <= j3 && j2 >= j3) {
            j = j3;
        }
        Month a2 = Month.m23473a(j);
        Intrinsics.checkExpressionValueIsNotNull(a2, "Month.create(openAt)");
        return a2;
    }

    /* renamed from: d */
    private final void m23488d() {
        setSelector$r_fusion_ninePhoneRelease(CalendarSelector.DAY);
        m23489e();
        RFTextView rFTextView = this.f33414g;
        if (rFTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvMonthDate");
        }
        Month month = this.f33424q;
        if (month == null) {
            Intrinsics.throwUninitializedPropertyAccessException("current");
        }
        rFTextView.setText(month.mo87537a(getContext()));
        RecyclerView recyclerView = this.f33421n;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rvMonths");
        }
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            RFMonthsPagerAdapter rFMonthsPagerAdapter = (RFMonthsPagerAdapter) adapter;
            RecyclerView recyclerView2 = this.f33421n;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rvMonths");
            }
            Month month2 = this.f33424q;
            if (month2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("current");
            }
            recyclerView2.scrollToPosition(rFMonthsPagerAdapter.getPosition(month2));
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.didi.rfusion.widget.calendar.RFMonthsPagerAdapter");
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public final void m23489e() {
        String str;
        String str2;
        RFDateSelector<?> dateSelector$r_fusion_ninePhoneRelease = getDateSelector$r_fusion_ninePhoneRelease();
        if (dateSelector$r_fusion_ninePhoneRelease instanceof RFRangeDateSelector) {
            FrameLayout frameLayout = this.f33408a;
            if (frameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("flTitle");
            }
            frameLayout.setVisibility(0);
            RFRangeDateSelector rFRangeDateSelector = (RFRangeDateSelector) dateSelector$r_fusion_ninePhoneRelease;
            Pair<Long, Long> selection = rFRangeDateSelector.getSelection();
            Intrinsics.checkExpressionValueIsNotNull(selection, "dateSelection.selection");
            StringBuilder sb = new StringBuilder();
            if (selection.first != null) {
                F f = selection.first;
                if (f == null) {
                    Intrinsics.throwNpe();
                }
                Intrinsics.checkExpressionValueIsNotNull(f, "selection.first!!");
                str = C11540a.m23530e(((Number) f).longValue());
            } else {
                Context context = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context, "context");
                str = context.getResources().getString(R.string.rf_calendar_start_date);
            }
            sb.append(str);
            RFTextView rFTextView = this.f33410c;
            if (rFTextView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvPartition");
            }
            sb.append(rFTextView.getText());
            if (selection.second != null) {
                S s = selection.second;
                if (s == null) {
                    Intrinsics.throwNpe();
                }
                Intrinsics.checkExpressionValueIsNotNull(s, "selection.second!!");
                str2 = C11540a.m23530e(((Number) s).longValue());
            } else {
                Context context2 = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context2, "context");
                str2 = context2.getResources().getString(R.string.rf_calendar_end_date);
            }
            sb.append(str2);
            String sb2 = sb.toString();
            Intrinsics.checkExpressionValueIsNotNull(sb2, "titleBuilder.toString()");
            RFTextView rFTextView2 = this.f33412e;
            if (rFTextView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvTempTitle");
            }
            rFTextView2.setText(sb2);
            RFTextView rFTextView3 = this.f33409b;
            if (rFTextView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvStartDate");
            }
            RFTextView rFTextView4 = this.f33412e;
            if (rFTextView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvTempTitle");
            }
            rFTextView3.setTextSize(0, rFTextView4.getTextSize());
            RFTextView rFTextView5 = this.f33410c;
            if (rFTextView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvPartition");
            }
            RFTextView rFTextView6 = this.f33412e;
            if (rFTextView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvTempTitle");
            }
            rFTextView5.setTextSize(0, rFTextView6.getTextSize());
            RFTextView rFTextView7 = this.f33411d;
            if (rFTextView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvEndDate");
            }
            RFTextView rFTextView8 = this.f33412e;
            if (rFTextView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvTempTitle");
            }
            rFTextView7.setTextSize(0, rFTextView8.getTextSize());
            if (selection.first != null) {
                RFTextView rFTextView9 = this.f33409b;
                if (rFTextView9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvStartDate");
                }
                F f2 = selection.first;
                if (f2 == null) {
                    Intrinsics.throwNpe();
                }
                Intrinsics.checkExpressionValueIsNotNull(f2, "selection.first!!");
                rFTextView9.setText(C11540a.m23530e(((Number) f2).longValue()));
                RFTextView rFTextView10 = this.f33409b;
                if (rFTextView10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvStartDate");
                }
                rFTextView10.setTextColor(RFResUtils.getColor(R.color.rf_color_gery_1_0_000000));
                RFTextView rFTextView11 = this.f33409b;
                if (rFTextView11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvStartDate");
                }
                rFTextView11.setTypeface(1);
            } else {
                RFTextView rFTextView12 = this.f33409b;
                if (rFTextView12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvStartDate");
                }
                Context context3 = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context3, "context");
                rFTextView12.setText(context3.getResources().getString(R.string.rf_calendar_start_date));
                RFTextView rFTextView13 = this.f33409b;
                if (rFTextView13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvStartDate");
                }
                rFTextView13.setTextColor(RFResUtils.getColor(R.color.rf_color_gery_3_60_999999));
                RFTextView rFTextView14 = this.f33409b;
                if (rFTextView14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvStartDate");
                }
                rFTextView14.setTypeface(3);
            }
            if (selection.second != null) {
                RFTextView rFTextView15 = this.f33411d;
                if (rFTextView15 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvEndDate");
                }
                S s2 = selection.second;
                if (s2 == null) {
                    Intrinsics.throwNpe();
                }
                Intrinsics.checkExpressionValueIsNotNull(s2, "selection.second!!");
                rFTextView15.setText(C11540a.m23530e(((Number) s2).longValue()));
                RFTextView rFTextView16 = this.f33411d;
                if (rFTextView16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvEndDate");
                }
                rFTextView16.setTextColor(RFResUtils.getColor(R.color.rf_color_gery_1_0_000000));
                RFTextView rFTextView17 = this.f33411d;
                if (rFTextView17 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvEndDate");
                }
                rFTextView17.setTypeface(1);
            } else {
                RFTextView rFTextView18 = this.f33411d;
                if (rFTextView18 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvEndDate");
                }
                Context context4 = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context4, "context");
                rFTextView18.setText(context4.getResources().getString(R.string.rf_calendar_end_date));
                RFTextView rFTextView19 = this.f33411d;
                if (rFTextView19 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvEndDate");
                }
                rFTextView19.setTextColor(RFResUtils.getColor(R.color.rf_color_gery_3_60_999999));
                RFTextView rFTextView20 = this.f33411d;
                if (rFTextView20 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvEndDate");
                }
                rFTextView20.setTypeface(3);
            }
            if (rFRangeDateSelector.isSelectionComplete()) {
                RFTextView rFTextView21 = this.f33410c;
                if (rFTextView21 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvPartition");
                }
                rFTextView21.setTextColor(RFResUtils.getColor(R.color.rf_color_gery_1_0_000000));
                RFTextView rFTextView22 = this.f33410c;
                if (rFTextView22 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvPartition");
                }
                rFTextView22.setTypeface(1);
                return;
            }
            RFTextView rFTextView23 = this.f33410c;
            if (rFTextView23 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvPartition");
            }
            rFTextView23.setTextColor(RFResUtils.getColor(R.color.rf_color_gery_3_60_999999));
            RFTextView rFTextView24 = this.f33410c;
            if (rFTextView24 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvPartition");
            }
            rFTextView24.setTypeface(3);
            return;
        }
        FrameLayout frameLayout2 = this.f33408a;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flTitle");
        }
        frameLayout2.setVisibility(8);
    }

    /* renamed from: f */
    private final void m23490f() {
        RecyclerView recyclerView = this.f33418k;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rvYearSelector");
        }
        recyclerView.setHasFixedSize(true);
        RecyclerView recyclerView2 = this.f33418k;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rvYearSelector");
        }
        recyclerView2.setLayoutManager(new GridLayoutManager(getContext(), 4, 1, false));
        RecyclerView recyclerView3 = this.f33418k;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rvYearSelector");
        }
        recyclerView3.setAdapter(new RFYearGridAdapter(this));
        RecyclerView recyclerView4 = this.f33418k;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rvYearSelector");
        }
        if (recyclerView4.getItemDecorationCount() == 0) {
            RecyclerView recyclerView5 = this.f33418k;
            if (recyclerView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rvYearSelector");
            }
            recyclerView5.addItemDecoration(m23493i());
        }
    }

    /* renamed from: g */
    private final void m23491g() {
        RFCalendarConstraints rFCalendarConstraints = this.f33423p;
        if (rFCalendarConstraints == null) {
            Intrinsics.throwUninitializedPropertyAccessException("calendarConstraints");
        }
        Month a = rFCalendarConstraints.mo87568a();
        Intrinsics.checkExpressionValueIsNotNull(a, "calendarConstraints.start");
        GridView gridView = this.f33420m;
        if (gridView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gvDaysOfWeek");
        }
        gridView.setAdapter(new C11541b());
        GridView gridView2 = this.f33420m;
        if (gridView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gvDaysOfWeek");
        }
        gridView2.setNumColumns(a.f33401c);
        GridView gridView3 = this.f33420m;
        if (gridView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gvDaysOfWeek");
        }
        gridView3.setEnabled(false);
    }

    /* renamed from: h */
    private final void m23492h() {
        RFSmoothCalendarLayoutManager rFCalendar$initDayOfMonth$layoutManager$1 = new RFCalendar$initDayOfMonth$layoutManager$1(this, getContext(), 0, false);
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        RFDateSelector<?> dateSelector$r_fusion_ninePhoneRelease = getDateSelector$r_fusion_ninePhoneRelease();
        RFCalendarConstraints rFCalendarConstraints = this.f33423p;
        if (rFCalendarConstraints == null) {
            Intrinsics.throwUninitializedPropertyAccessException("calendarConstraints");
        }
        RFMonthsPagerAdapter rFMonthsPagerAdapter = new RFMonthsPagerAdapter(context, dateSelector$r_fusion_ninePhoneRelease, rFCalendarConstraints, new RFCalendar$initDayOfMonth$monthsPagerAdapter$1(this));
        RecyclerView recyclerView = this.f33421n;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rvMonths");
        }
        recyclerView.setLayoutManager(rFCalendar$initDayOfMonth$layoutManager$1);
        RecyclerView recyclerView2 = this.f33421n;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rvMonths");
        }
        recyclerView2.setAdapter(rFMonthsPagerAdapter);
        m23485a(rFMonthsPagerAdapter);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final <T> void m23484a(RFDateSelection<T> rFDateSelection) {
        OnSelectionChangedListener<T> listener = rFDateSelection.getListener();
        if (listener != null) {
            RFDateSelector<T> dateSelector = rFDateSelection.getDateSelector();
            if (dateSelector == null) {
                Intrinsics.throwNpe();
            }
            T selection = dateSelector.getSelection();
            if (selection == null) {
                Intrinsics.throwNpe();
            }
            listener.onSelectionChanged(selection);
        }
    }

    /* renamed from: i */
    private final RecyclerView.ItemDecoration m23493i() {
        return new RFCalendar$createItemDecoration$1(this);
    }

    /* renamed from: a */
    private final void m23485a(RFMonthsPagerAdapter rFMonthsPagerAdapter) {
        RecyclerView recyclerView = this.f33421n;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rvMonths");
        }
        recyclerView.addOnScrollListener(new RFCalendar$initActionsToMonthNavigation$1(this, rFMonthsPagerAdapter));
        LinearLayout linearLayout = this.f33413f;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llMonthToggle");
        }
        linearLayout.setOnClickListener(new RFCalendar$initActionsToMonthNavigation$2(this));
        RFIconView rFIconView = this.f33417j;
        if (rFIconView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivNext");
        }
        rFIconView.setOnClickListener(new RFCalendar$initActionsToMonthNavigation$3(this, rFMonthsPagerAdapter));
        RFIconView rFIconView2 = this.f33416i;
        if (rFIconView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivPrev");
        }
        rFIconView2.setOnClickListener(new RFCalendar$initActionsToMonthNavigation$4(this, rFMonthsPagerAdapter));
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public final void m23494j() {
        if (this.f33426s == CalendarSelector.YEAR) {
            setSelector$r_fusion_ninePhoneRelease(CalendarSelector.DAY);
        } else if (this.f33426s == CalendarSelector.DAY) {
            setSelector$r_fusion_ninePhoneRelease(CalendarSelector.YEAR);
        }
    }

    /* access modifiers changed from: private */
    public final LinearLayoutManager getLayoutManager() {
        RecyclerView recyclerView = this.f33421n;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rvMonths");
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager != null) {
            return (LinearLayoutManager) layoutManager;
        }
        throw new TypeCastException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    }

    /* renamed from: a */
    private final void m23483a(int i) {
        RecyclerView recyclerView = this.f33421n;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rvMonths");
        }
        recyclerView.post(new RFCalendar$postSmoothRecyclerViewScroll$1(this, i));
    }

    public final void setCurrentMonth$r_fusion_ninePhoneRelease(Month month) {
        Intrinsics.checkParameterIsNotNull(month, "moveTo");
        RecyclerView recyclerView = this.f33421n;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rvMonths");
        }
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            RFMonthsPagerAdapter rFMonthsPagerAdapter = (RFMonthsPagerAdapter) adapter;
            int position = rFMonthsPagerAdapter.getPosition(month);
            Month month2 = this.f33424q;
            if (month2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("current");
            }
            int position2 = position - rFMonthsPagerAdapter.getPosition(month2);
            boolean z = true;
            boolean z2 = Math.abs(position2) > 3;
            if (position2 <= 0) {
                z = false;
            }
            this.f33424q = month;
            if (z2 && z) {
                RecyclerView recyclerView2 = this.f33421n;
                if (recyclerView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rvMonths");
                }
                recyclerView2.scrollToPosition(position - 3);
                m23483a(position);
            } else if (z2) {
                RecyclerView recyclerView3 = this.f33421n;
                if (recyclerView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rvMonths");
                }
                recyclerView3.scrollToPosition(position + 3);
                m23483a(position);
            } else {
                m23483a(position);
            }
        } else {
            throw new TypeCastException("null cannot be cast to non-null type com.didi.rfusion.widget.calendar.RFMonthsPagerAdapter");
        }
    }

    public final Month getCurrentMonth$r_fusion_ninePhoneRelease() {
        Month month = this.f33424q;
        if (month == null) {
            Intrinsics.throwUninitializedPropertyAccessException("current");
        }
        return month;
    }

    public final void setSelector$r_fusion_ninePhoneRelease(CalendarSelector calendarSelector) {
        Intrinsics.checkParameterIsNotNull(calendarSelector, "selector");
        this.f33426s = calendarSelector;
        if (calendarSelector == CalendarSelector.YEAR) {
            RecyclerView recyclerView = this.f33418k;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rvYearSelector");
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager == null) {
                Intrinsics.throwNpe();
            }
            RecyclerView recyclerView2 = this.f33418k;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rvYearSelector");
            }
            RecyclerView.Adapter adapter = recyclerView2.getAdapter();
            if (adapter != null) {
                RFYearGridAdapter rFYearGridAdapter = (RFYearGridAdapter) adapter;
                Month month = this.f33424q;
                if (month == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("current");
                }
                layoutManager.scrollToPosition(rFYearGridAdapter.getPositionForYear(month.f33400b));
                RecyclerView recyclerView3 = this.f33418k;
                if (recyclerView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rvYearSelector");
                }
                recyclerView3.setVisibility(0);
                LinearLayout linearLayout = this.f33419l;
                if (linearLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("llDaySelector");
                }
                linearLayout.setVisibility(8);
                RFIconView rFIconView = this.f33415h;
                if (rFIconView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ivMonthIcon");
                }
                rFIconView.setRotation(180.0f);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.didi.rfusion.widget.calendar.RFYearGridAdapter");
        } else if (calendarSelector == CalendarSelector.DAY) {
            RecyclerView recyclerView4 = this.f33418k;
            if (recyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rvYearSelector");
            }
            recyclerView4.setVisibility(8);
            LinearLayout linearLayout2 = this.f33419l;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("llDaySelector");
            }
            linearLayout2.setVisibility(0);
            RFIconView rFIconView2 = this.f33415h;
            if (rFIconView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivMonthIcon");
            }
            rFIconView2.setRotation(0.0f);
            Month month2 = this.f33424q;
            if (month2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("current");
            }
            setCurrentMonth$r_fusion_ninePhoneRelease(month2);
        }
    }

    public final RFCalendarStyle getCalendarStyle$r_fusion_ninePhoneRelease() {
        RFCalendarStyle rFCalendarStyle = this.f33425r;
        if (rFCalendarStyle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("calendarStyle");
        }
        return rFCalendarStyle;
    }

    public final RFDateSelector<?> getDateSelector$r_fusion_ninePhoneRelease() {
        RFDateSelection<?> rFDateSelection = this.f33422o;
        if (rFDateSelection == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dateSelection");
        }
        RFDateSelector<?> dateSelector = rFDateSelection.getDateSelector();
        if (dateSelector != null) {
            return dateSelector;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.didi.rfusion.widget.calendar.RFDateSelector<*>");
    }

    /* JADX WARNING: Failed to insert additional move for type inference */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> void setup(com.didi.rfusion.widget.calendar.RFDateSelection<T> r2, com.didi.rfusion.widget.calendar.RFCalendarConstraints r3) {
        /*
            r1 = this;
            if (r2 == 0) goto L_0x0003
            goto L_0x000c
        L_0x0003:
            com.didi.rfusion.widget.calendar.RFDateSelection<?> r2 = r1.f33422o
            if (r2 != 0) goto L_0x000c
            java.lang.String r0 = "dateSelection"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
        L_0x000c:
            r1.f33422o = r2
            java.lang.String r2 = "calendarConstraints"
            if (r3 == 0) goto L_0x0013
            goto L_0x001a
        L_0x0013:
            com.didi.rfusion.widget.calendar.RFCalendarConstraints r3 = r1.f33423p
            if (r3 != 0) goto L_0x001a
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x001a:
            r1.f33423p = r3
            if (r3 != 0) goto L_0x0021
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x0021:
            com.didi.rfusion.widget.calendar.Month r0 = r1.m23487c()
            r3.mo87569a((com.didi.rfusion.widget.calendar.Month) r0)
            com.didi.rfusion.widget.calendar.RFCalendarConstraints r3 = r1.f33423p
            if (r3 != 0) goto L_0x002f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x002f:
            com.didi.rfusion.widget.calendar.Month r2 = r3.mo87573c()
            if (r2 != 0) goto L_0x0038
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0038:
            r1.f33424q = r2
            r1.m23490f()
            r1.m23491g()
            r1.m23492h()
            r1.m23488d()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.rfusion.widget.calendar.RFCalendar.setup(com.didi.rfusion.widget.calendar.RFDateSelection, com.didi.rfusion.widget.calendar.RFCalendarConstraints):void");
    }

    public final RFCalendarConstraints getCalendarConstraints() {
        RFCalendarConstraints rFCalendarConstraints = this.f33423p;
        if (rFCalendarConstraints == null) {
            Intrinsics.throwUninitializedPropertyAccessException("calendarConstraints");
        }
        return rFCalendarConstraints;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u0010*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0010B\u0015\b\u0002\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bJ\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007J\u0019\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0002\u0010\u000fR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/rfusion/widget/calendar/RFCalendar$DateSelectionBuilder;", "T", "", "dateSelector", "Lcom/didi/rfusion/widget/calendar/RFDateSelector;", "(Lcom/didi/rfusion/widget/calendar/RFDateSelector;)V", "onSelectionChangedListener", "Lcom/didi/rfusion/widget/calendar/OnSelectionChangedListener;", "selection", "Ljava/lang/Object;", "build", "Lcom/didi/rfusion/widget/calendar/RFDateSelection;", "setOnSelectionChangedListener", "listener", "setSelection", "(Ljava/lang/Object;)Lcom/didi/rfusion/widget/calendar/RFCalendar$DateSelectionBuilder;", "Companion", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: RFCalendar.kt */
    public static final class DateSelectionBuilder<T> {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final RFDateSelector<T> dateSelector;
        private OnSelectionChangedListener<T> onSelectionChangedListener;
        private T selection;

        private DateSelectionBuilder(RFDateSelector<T> rFDateSelector) {
            this.dateSelector = rFDateSelector;
        }

        public /* synthetic */ DateSelectionBuilder(RFDateSelector rFDateSelector, DefaultConstructorMarker defaultConstructorMarker) {
            this(rFDateSelector);
        }

        public final DateSelectionBuilder<T> setSelection(T t) {
            this.selection = t;
            return this;
        }

        public final DateSelectionBuilder<T> setOnSelectionChangedListener(OnSelectionChangedListener<T> onSelectionChangedListener2) {
            Intrinsics.checkParameterIsNotNull(onSelectionChangedListener2, "listener");
            this.onSelectionChangedListener = onSelectionChangedListener2;
            return this;
        }

        public final RFDateSelection<T> build() {
            T t = this.selection;
            if (t != null) {
                RFDateSelector<T> rFDateSelector = this.dateSelector;
                if (t == null) {
                    Intrinsics.throwNpe();
                }
                rFDateSelector.setSelection(t);
            }
            return new RFDateSelection<>(this.dateSelector, this.onSelectionChangedListener);
        }

        @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00050\u0004J\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0004¨\u0006\b"}, mo175978d2 = {"Lcom/didi/rfusion/widget/calendar/RFCalendar$DateSelectionBuilder$Companion;", "", "()V", "rangeDateSelection", "Lcom/didi/rfusion/widget/calendar/RFCalendar$DateSelectionBuilder;", "Landroidx/core/util/Pair;", "", "singleDateSelection", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
        /* compiled from: RFCalendar.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final DateSelectionBuilder<Long> singleDateSelection() {
                return new DateSelectionBuilder<>(new RFSingleDateSelector(), (DefaultConstructorMarker) null);
            }

            public final DateSelectionBuilder<Pair<Long, Long>> rangeDateSelection() {
                return new DateSelectionBuilder<>(new RFRangeDateSelector(), (DefaultConstructorMarker) null);
            }
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo175978d2 = {"Lcom/didi/rfusion/widget/calendar/RFCalendar$Companion;", "", "()V", "COLUMN_YEAR", "", "SMOOTH_SCROLL_MAX", "todayInUtcMilliseconds", "", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: RFCalendar.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long todayInUtcMilliseconds() {
            Calendar b = C11544e.m23564b();
            Intrinsics.checkExpressionValueIsNotNull(b, "UtcDates.getTodayCalendar()");
            return b.getTimeInMillis();
        }
    }
}
