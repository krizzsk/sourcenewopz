package com.didi.global.globaluikit.datepicker.time;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.globaluikit.datepicker.LEGODatePickerCallback;
import com.didi.global.globaluikit.datepicker.model.LEGODatePickerModel;
import com.didi.global.globaluikit.datepicker.time.LEGODaysPicker;
import com.didi.global.globaluikit.datepicker.time.LEGOHourPicker;
import com.didi.global.globaluikit.drawer.LEGOAbsDrawer;
import com.global.didi.elvish.Elvish;
import com.taxis99.R;
import java.util.Calendar;

public class LEGODatePicker extends LEGOAbsDrawer {

    /* renamed from: p */
    private static final int f22436p = 4;

    /* renamed from: q */
    private static final int f22437q = 2;

    /* renamed from: r */
    private static final int f22438r = 1;

    /* renamed from: a */
    private final LEGODatePickerModel f22439a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final LEGODatePickerCallback f22440b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public LEGODaysPicker f22441c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public LEGOHourPicker f22442d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public LEGOMinutePicker f22443e;

    /* renamed from: f */
    private TextView f22444f;

    /* renamed from: g */
    private ImageView f22445g;

    /* renamed from: h */
    private TextView f22446h;

    /* renamed from: i */
    private TextView f22447i;

    /* renamed from: j */
    private int f22448j;

    /* renamed from: k */
    private int f22449k;

    /* renamed from: l */
    private int f22450l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f22451m;

    /* renamed from: n */
    private int f22452n;

    /* renamed from: o */
    private int f22453o;

    /* access modifiers changed from: protected */
    public int getCustomView() {
        return R.layout.lego_layout_date_picker;
    }

    public LEGODatePicker(Context context, LEGODatePickerModel lEGODatePickerModel, LEGODatePickerCallback lEGODatePickerCallback) {
        super(context);
        this.f22439a = lEGODatePickerModel;
        if (lEGODatePickerModel != null) {
            if (!TextUtils.isEmpty(lEGODatePickerModel.today)) {
                C8645a.f22474a = lEGODatePickerModel.today;
            }
            if (!TextUtils.isEmpty(lEGODatePickerModel.now)) {
                C8645a.f22475b = lEGODatePickerModel.now;
            }
            this.f22439a.beginTimeSecond = lEGODatePickerModel.beginTimeSecond * 1000;
            this.f22439a.endTimeSecond = lEGODatePickerModel.endTimeSecond * 1000;
            this.f22439a.defaultScrolledSecond = lEGODatePickerModel.defaultScrolledSecond * 1000;
        }
        this.f22440b = lEGODatePickerCallback;
    }

    /* access modifiers changed from: protected */
    public boolean onShowPrepare() {
        this.f22441c = (LEGODaysPicker) this.mRealView.findViewById(R.id.dayPicker_layout_time);
        this.f22442d = (LEGOHourPicker) this.mRealView.findViewById(R.id.hourPicker_layout_time);
        this.f22443e = (LEGOMinutePicker) this.mRealView.findViewById(R.id.minutePicker_layout_time);
        this.f22444f = (TextView) this.mRealView.findViewById(R.id.date_picker_title);
        this.f22445g = (ImageView) this.mRealView.findViewById(R.id.date_picker_close_icon);
        this.f22446h = (TextView) this.mRealView.findViewById(R.id.date_picker_confirm);
        this.f22447i = (TextView) this.mRealView.findViewById(R.id.lego_date_picker_symbol);
        this.f22445g.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                LEGODatePicker.this.dismiss();
                if (LEGODatePicker.this.f22440b != null) {
                    LEGODatePicker.this.f22440b.onCancelClick();
                }
            }
        });
        this.f22446h.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                Calendar instance = Calendar.getInstance();
                LEGODayModel selectedDay = LEGODatePicker.this.f22441c.getSelectedDay();
                instance.set(selectedDay.getYear(), selectedDay.getMonth(), selectedDay.getDay(), LEGODatePicker.this.f22442d.getSelectedHour(), LEGODatePicker.this.f22443e.getSelectedMinute());
                long timeInMillis = instance.getTimeInMillis();
                if (LEGODatePicker.this.f22442d.getSelectedHour() == -1) {
                    timeInMillis = 0;
                }
                if (LEGODatePicker.this.f22440b != null) {
                    LEGODatePicker.this.f22440b.onConfirmClick(timeInMillis / 1000);
                }
                LEGODatePicker.this.dismiss();
            }
        });
        m16149a();
        return true;
    }

    /* renamed from: a */
    private void m16149a() {
        LEGODatePickerModel lEGODatePickerModel = this.f22439a;
        if (lEGODatePickerModel != null) {
            if (lEGODatePickerModel.title != null) {
                this.f22439a.title.bindTextView(this.f22444f);
            }
            if (this.f22439a.confirmTitle != null) {
                this.f22439a.confirmTitle.bindTextView(this.f22446h);
            }
            this.f22441c.init(this.f22439a.beginTimeSecond);
            this.f22441c.setOnDaySelectedListener(new LEGODaysPicker.OnDaySelectedListener() {
                public void onDaySelected(LEGODayModel lEGODayModel) {
                    int date = lEGODayModel.getDate();
                    if (lEGODayModel.getYear() > LEGODatePicker.this.f22451m) {
                        date += 366;
                    }
                    LEGODatePicker.this.m16160b(date);
                }
            });
            this.f22442d.setOnHourSelectedListener(new LEGOHourPicker.OnHourSelectedListener() {
                public void onHourSelected(int i) {
                    LEGODatePicker.this.m16150a(i);
                }
            });
            Calendar dateTimeCalendar = Elvish.Companion.getInstance().getDateTimeCalendar(this.f22439a.beginTimeSecond);
            this.f22449k = dateTimeCalendar.get(6);
            this.f22450l = dateTimeCalendar.get(11);
            this.f22451m = dateTimeCalendar.get(1);
            Calendar dateTimeCalendar2 = Elvish.Companion.getInstance().getDateTimeCalendar(this.f22439a.endTimeSecond);
            this.f22452n = dateTimeCalendar2.get(6);
            if (dateTimeCalendar2.get(1) > this.f22451m) {
                this.f22452n += 366;
            }
            this.f22453o = dateTimeCalendar2.get(11);
            int g = m16173g(this.f22439a.intervalSecond);
            this.f22448j = g;
            this.f22443e.setDelta(g);
            m16165c(7);
            m16166c(true);
            m16159b();
            if (this.f22439a.defaultScrolledSecond > 0 && this.f22439a.defaultScrolledSecond >= this.f22439a.beginTimeSecond && this.f22439a.defaultScrolledSecond <= this.f22439a.endTimeSecond) {
                m16151a(this.f22439a.defaultScrolledSecond);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16150a(int i) {
        boolean z = true;
        m16166c(this.f22442d.getSelectedHour() == -1);
        m16165c(1);
        if (this.f22441c.getSelectedDay().getDate() == this.f22449k) {
            if (i <= this.f22450l) {
                m16165c(1);
                if (i != this.f22450l) {
                    z = false;
                }
                m16156a(z);
                this.f22443e.setCurrentPosition(0);
            }
        } else if (this.f22441c.getSelectedDay().getDate() == this.f22452n && i >= this.f22453o) {
            m16168d(i);
            this.f22443e.setCurrentPosition(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m16160b(int i) {
        boolean z = false;
        if (i >= this.f22452n) {
            m16168d(this.f22439a.serviceBeginSecond);
            this.f22442d.setCurrentPosition(0);
            this.f22443e.setCurrentPosition(0);
        } else if (i > this.f22449k) {
            m16165c(3);
        } else {
            m16159b();
            this.f22442d.setCurrentPosition(0);
            this.f22443e.setCurrentPosition(0);
        }
        if (i == this.f22449k) {
            z = true;
        }
        m16166c(z);
    }

    /* renamed from: a */
    private void m16151a(long j) {
        m16152a(j, Elvish.Companion.getInstance().getDateTimeCalendar(j));
    }

    /* renamed from: a */
    private void m16152a(long j, final Calendar calendar) {
        this.f22441c.setSelectedDay(j);
        int i = calendar.get(6);
        if (calendar.get(1) > this.f22451m) {
            i += 366;
        }
        m16160b(i);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                LEGODatePicker.this.m16155a(calendar);
            }
        }, 500);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16155a(final Calendar calendar) {
        int i = calendar.get(11);
        this.f22442d.setSelectedHour(i, true);
        m16150a(i);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                LEGODatePicker.this.f22443e.setSelectedMinute(calendar.get(12), true);
            }
        }, 500);
    }

    /* renamed from: c */
    private void m16165c(int i) {
        if ((i & 4) == 4) {
            this.f22441c.setMinDay(this.f22439a.beginTimeSecond);
            this.f22441c.setMaxDay(this.f22439a.endTimeSecond);
            this.f22441c.updateDay();
            this.f22441c.setCurrentPosition(0, true);
        }
        if ((i & 2) == 2) {
            this.f22442d.setBeginHourInDay(m16172f(this.f22439a.serviceBeginSecond), false, false);
            this.f22442d.setEndHourInDay(m16172f(this.f22439a.serviceEndSecond));
            this.f22442d.updateHour();
            m16166c(false);
            this.f22442d.setCurrentPosition(0, true);
        }
        if ((i & 1) == 1) {
            this.f22443e.setBeginMinuteInHour(0);
            this.f22443e.setEndMinuteInHour(59);
            this.f22443e.updateMinute();
            this.f22443e.setCurrentPosition(0, true);
        }
    }

    /* renamed from: d */
    private void m16168d(int i) {
        m16162b(m16171e(i));
    }

    /* renamed from: b */
    private void m16159b() {
        m16156a(false);
    }

    /* renamed from: a */
    private void m16156a(boolean z) {
        m16157a(m16169d(), z);
        m16164c();
    }

    /* renamed from: c */
    private void m16164c() {
        this.f22441c.setMinDay(Elvish.Companion.getInstance().getDateTimeCalendar(this.f22439a.beginTimeSecond).getTimeInMillis());
        this.f22441c.updateDay();
    }

    /* renamed from: a */
    private void m16157a(boolean z, boolean z2) {
        int f = m16172f(this.f22439a.serviceBeginSecond);
        int f2 = m16172f(this.f22439a.serviceEndSecond);
        int max = Math.max(Elvish.Companion.getInstance().getDateTimeCalendar(this.f22439a.beginTimeSecond).get(11), f) + (z ? 1 : 0);
        boolean z3 = max > f2;
        LEGOHourPicker lEGOHourPicker = this.f22442d;
        if (z3) {
            max = -1;
        }
        lEGOHourPicker.setBeginHourInDay(max, true, z2);
        LEGOHourPicker lEGOHourPicker2 = this.f22442d;
        if (z3) {
            f2 = -1;
        }
        lEGOHourPicker2.setEndHourInDay(f2);
        this.f22442d.updateHour();
    }

    /* renamed from: e */
    private boolean m16171e(int i) {
        int f = m16172f(this.f22439a.serviceBeginSecond);
        int min = Math.min(Elvish.Companion.getInstance().getDateTimeCalendar(this.f22439a.endTimeSecond).get(11), m16172f(this.f22439a.serviceEndSecond));
        this.f22442d.setBeginHourInDay(f, false, false);
        this.f22442d.setEndHourInDay(min);
        this.f22442d.updateHour(true);
        if (i == min) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    private void m16162b(boolean z) {
        int i = 1;
        if (z) {
            int i2 = Elvish.Companion.getInstance().getDateTimeCalendar(this.f22439a.endTimeSecond).get(12);
            int i3 = this.f22448j;
            int i4 = i2 / i3;
            if (i2 % i3 == 0) {
                i = 0;
            }
            this.f22443e.setBeginMinuteInHour(0);
            this.f22443e.setEndMinuteInHour(Math.max(i3 * (i4 - i), 0));
            this.f22443e.updateMinute();
            return;
        }
        m16165c(1);
    }

    /* renamed from: c */
    private void m16166c(boolean z) {
        int i = 4;
        this.f22447i.setVisibility(z ? 4 : 0);
        LEGOMinutePicker lEGOMinutePicker = this.f22443e;
        if (!z) {
            i = 0;
        }
        lEGOMinutePicker.setVisibility(i);
    }

    /* renamed from: d */
    private boolean m16169d() {
        int i = Elvish.Companion.getInstance().getDateTimeCalendar(this.f22439a.beginTimeSecond).get(12);
        int i2 = this.f22448j;
        boolean z = true;
        int i3 = 0;
        int i4 = i2 * ((i / i2) + (i % i2 != 0 ? 1 : 0));
        if (i4 <= 59) {
            z = false;
        }
        LEGOMinutePicker lEGOMinutePicker = this.f22443e;
        if (!z) {
            i3 = i4;
        }
        lEGOMinutePicker.setBeginMinuteInHour(i3);
        this.f22443e.updateMinute();
        return z;
    }

    /* renamed from: f */
    private int m16172f(int i) {
        if (i <= 0) {
            return 0;
        }
        int i2 = (i / 60) / 60;
        if (i2 > 23) {
            return 23;
        }
        return i2;
    }

    /* renamed from: g */
    private int m16173g(int i) {
        if (i <= 0 || i % 60 != 0) {
            return 1;
        }
        return i / 60;
    }

    public void show() {
        super.show();
    }
}
