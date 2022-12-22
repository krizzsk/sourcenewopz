package com.didi.sdk.view.picker;

import android.content.res.Resources;
import com.didi.sdk.view.dialog.ProductControllerStyleManager;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class TimeStrategy {

    /* renamed from: a */
    private static final int f38132a = 60;

    /* renamed from: b */
    private static final int f38133b = 24;

    /* renamed from: c */
    private static final int f38134c = 30;

    /* renamed from: d */
    private static final int f38135d = 10;

    /* renamed from: e */
    private int f38136e = 30;

    /* renamed from: f */
    private int f38137f = 10;

    /* renamed from: g */
    private int f38138g = 0;

    /* renamed from: h */
    private int f38139h = 0;

    /* renamed from: i */
    private int f38140i = 24;

    /* renamed from: j */
    private int f38141j = 60;

    /* renamed from: k */
    private int f38142k = 3;

    /* renamed from: l */
    private Locale f38143l = ProductControllerStyleManager.getInstance().getLocaleDelegate().getLocale();

    /* renamed from: m */
    private TimeZone f38144m = TimeZone.getDefault();

    /* renamed from: n */
    private Calendar f38145n;

    public Calendar getLatestAvailableCalendar() {
        Calendar calendar = this.f38145n;
        if (calendar != null) {
            return (Calendar) calendar.clone();
        }
        return null;
    }

    public Calendar getLastAvailableCalendar() {
        Calendar calendar = (Calendar) this.f38145n.clone();
        int i = this.f38142k;
        if (i > 1) {
            calendar.add(5, i - 1);
        }
        return m26968b(calendar.getTimeInMillis());
    }

    public List<String> getDay(Resources resources, String[] strArr) {
        boolean z = strArr.length == 4;
        ArrayList arrayList = new ArrayList();
        int b = m26967b();
        if (b == -1) {
            return null;
        }
        if (z) {
            arrayList.add(strArr[0]);
        }
        if (b < 4) {
            for (int i = z ? b : b - 1; i < strArr.length; i++) {
                arrayList.add(strArr[i]);
            }
        }
        m26966a(resources, arrayList, b);
        return arrayList;
    }

    public List<String> getHour(int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = this.f38140i;
        for (int max = Math.max(this.f38138g, i); max < i2; max++) {
            arrayList.add(String.valueOf(max));
        }
        return arrayList;
    }

    public List<String> getMinute(int i) {
        ArrayList arrayList = new ArrayList();
        int a = m26963a(Math.max(this.f38139h, i));
        while (a < this.f38141j) {
            arrayList.add(String.valueOf(a));
            a += this.f38137f;
        }
        return arrayList;
    }

    public long getLatestAvailableTime() {
        Calendar calendar = this.f38145n;
        if (calendar != null) {
            return calendar.getTimeInMillis();
        }
        long a = m26964a();
        Calendar instance = Calendar.getInstance(this.f38144m);
        this.f38145n = instance;
        instance.setTimeInMillis(a);
        Calendar a2 = m26965a(a);
        if (instance.compareTo(m26968b(a)) >= 0) {
            instance.add(5, 1);
            instance.set(11, this.f38138g);
            instance.set(12, this.f38139h);
            return instance.getTimeInMillis();
        } else if (instance.compareTo(a2) >= 0) {
            return a;
        } else {
            instance.set(11, this.f38138g);
            instance.set(12, this.f38139h);
            return instance.getTimeInMillis();
        }
    }

    /* renamed from: a */
    private long m26964a() {
        Calendar instance = Calendar.getInstance(this.f38144m);
        instance.setTimeInMillis(Calendar.getInstance(this.f38144m).getTimeInMillis() + ((long) (this.f38136e * 60 * 1000)));
        instance.set(13, 0);
        instance.set(14, 0);
        int a = m26963a(instance.get(12));
        if (a == 60) {
            instance.add(11, 1);
            instance.set(12, 0);
        } else {
            instance.set(12, a);
        }
        return instance.getTimeInMillis();
    }

    /* renamed from: a */
    private int m26963a(int i) {
        int i2 = this.f38137f;
        int i3 = i % i2;
        int i4 = i / i2;
        if (i3 != 0) {
            i4++;
        }
        return i4 * this.f38137f;
    }

    /* renamed from: a */
    private Calendar m26965a(long j) {
        Calendar instance = Calendar.getInstance(this.f38144m);
        instance.setTimeInMillis(j);
        instance.set(11, this.f38138g);
        instance.set(12, this.f38139h);
        return instance;
    }

    /* renamed from: b */
    private Calendar m26968b(long j) {
        Calendar instance = Calendar.getInstance(this.f38144m);
        instance.setTimeInMillis(j);
        int i = this.f38140i;
        if (i == 24) {
            instance.add(5, 1);
            instance.set(11, 0);
            instance.set(12, 0);
        } else {
            instance.set(11, i);
            instance.set(12, this.f38141j);
        }
        return instance;
    }

    /* renamed from: b */
    private int m26967b() {
        Calendar instance = Calendar.getInstance(this.f38144m);
        instance.setTimeInMillis(getLatestAvailableTime());
        Calendar instance2 = Calendar.getInstance(this.f38144m);
        for (int i = 1; i < 100; i++) {
            if (instance2.get(5) == instance.get(5)) {
                return i;
            }
            instance2.add(5, 1);
        }
        return -1;
    }

    /* renamed from: a */
    private void m26966a(Resources resources, List<String> list, int i) {
        int i2;
        int i3 = 3;
        if (i < 4) {
            i2 = this.f38142k - ((3 - i) + 1);
        } else {
            i3 = i - 1;
            i2 = this.f38142k;
        }
        Calendar instance = Calendar.getInstance(this.f38144m);
        instance.add(5, i3);
        for (int i4 = 0; i4 < i2; i4++) {
            list.add(formatTimeMillionsToMonthDayWeek(resources, instance, false));
            instance.add(5, 1);
        }
        if (i2 < 0) {
            int i5 = i2 * -1;
            for (int i6 = 0; i6 < i5; i6++) {
                int size = list.size() - 1;
                if (size >= 0) {
                    list.remove(size);
                }
            }
        }
    }

    public String formatTimeMillionsToMonthDayWeek(Resources resources, Calendar calendar, boolean z) {
        String displayName = calendar.getDisplayName(2, 1, this.f38143l);
        int i = calendar.get(5);
        String displayName2 = calendar.getDisplayName(7, this.f38143l == Locale.US ? 1 : 2, this.f38143l);
        String string = resources.getString(R.string.today);
        Locale locale = this.f38143l;
        Object[] objArr = new Object[3];
        objArr[0] = displayName;
        objArr[1] = Integer.valueOf(i);
        if (z) {
            displayName2 = string;
        }
        objArr[2] = displayName2;
        return String.format(locale, resources.getString(R.string.time_picker_date_format, objArr), new Object[0]);
    }

    public void setAppointmentDay(int i) {
        this.f38142k = i;
    }

    public void setEarliestDelta(int i) {
        this.f38136e = i;
    }

    public void setMinuteDelta(int i) {
        this.f38137f = i;
    }

    public void setBeginMinInDay(int i) {
        this.f38139h = i;
    }

    public void setBeginHourInDay(int i) {
        this.f38138g = i;
    }

    public void setEndMinInDay(int i) {
        this.f38141j = i;
    }

    public void setEndHourInDay(int i) {
        this.f38140i = i;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.f38144m = timeZone;
    }

    public int getAppointmentDay() {
        return this.f38142k;
    }
}
