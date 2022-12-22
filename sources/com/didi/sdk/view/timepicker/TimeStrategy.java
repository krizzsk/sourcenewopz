package com.didi.sdk.view.timepicker;

import android.content.res.Resources;
import com.didi.sdk.view.dialog.ProductControllerStyleManager;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

@Deprecated
public class TimeStrategy {

    /* renamed from: a */
    private static final int f38233a = 24;

    /* renamed from: b */
    private static final int f38234b = 60;

    /* renamed from: c */
    private static final int f38235c = 10;

    /* renamed from: d */
    private static final int f38236d = 0;

    /* renamed from: e */
    private static final int f38237e = 0;

    /* renamed from: f */
    private static final int f38238f = 24;

    /* renamed from: g */
    private static final int f38239g = 0;

    /* renamed from: h */
    private int f38240h = 10;

    /* renamed from: i */
    private int f38241i = 24;

    /* renamed from: j */
    private int f38242j = 60;

    /* renamed from: k */
    private int f38243k = 3;

    /* renamed from: l */
    private int f38244l;

    /* renamed from: m */
    private int f38245m = 0;

    /* renamed from: n */
    private int f38246n = 0;

    /* renamed from: o */
    private int f38247o = 0;

    /* renamed from: p */
    private int f38248p = 24;

    /* renamed from: q */
    private Locale f38249q = ProductControllerStyleManager.getInstance().getLocaleDelegate().getLocale();

    /* renamed from: r */
    private boolean f38250r;

    public void setIsSupportNow(boolean z) {
        this.f38250r = z;
    }

    public int getAppointmentDay() {
        return this.f38243k;
    }

    public void setAppointmentDay(int i) {
        this.f38243k = i;
    }

    public int getmEarliestDelta() {
        return this.f38244l;
    }

    public void setEarliestDelta(int i) {
        this.f38244l = i;
    }

    public int getBeginHourInDay() {
        return this.f38245m;
    }

    public void setBeginHourInDay(int i) {
        this.f38245m = i;
    }

    public int getBeginMinInDay() {
        return this.f38246n;
    }

    public void setBeginMinInDay(int i) {
        this.f38246n = i;
    }

    public int getEndMinInDay() {
        return this.f38247o;
    }

    public void setEndMinInDay(int i) {
        this.f38247o = i;
    }

    public int getEndHourInDay() {
        return this.f38248p;
    }

    public void setEndHourInDay(int i) {
        this.f38248p = i;
    }

    public boolean isInvalid(long j) {
        if (this.f38250r && j == 0) {
            return false;
        }
        long latestAvailableTime = getLatestAvailableTime();
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        if (j < latestAvailableTime) {
            return true;
        }
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(latestAvailableTime);
        int i = this.f38243k;
        if (i > 1) {
            instance2.add(5, i - 1);
        }
        if (j > m27036b(instance2.getTimeInMillis()).getTimeInMillis()) {
            return true;
        }
        Calendar a = m27034a(j);
        if (!instance.after(m27036b(j)) && !instance.before(a)) {
            return false;
        }
        return true;
    }

    public int getEarliesDay() {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(getLatestAvailableTime());
        Calendar instance2 = Calendar.getInstance();
        int i = 0;
        int i2 = 1;
        while (i < 100) {
            if (instance2.get(5) == instance.get(5)) {
                return i2;
            }
            i2++;
            i++;
            instance2.add(5, 1);
        }
        return -1;
    }

    public long getLatestAvailableTime() {
        long a = m27033a();
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(a);
        Calendar a2 = m27034a(a);
        if (instance.compareTo(m27036b(a)) >= 0) {
            instance.add(5, 1);
            instance.set(11, this.f38245m);
            instance.set(12, this.f38246n);
            return instance.getTimeInMillis();
        } else if (instance.compareTo(a2) >= 0) {
            return a;
        } else {
            instance.set(11, this.f38245m);
            instance.set(12, this.f38246n);
            return instance.getTimeInMillis();
        }
    }

    /* renamed from: a */
    private long m27033a() {
        long currentTimeMillis = System.currentTimeMillis() + ((long) (this.f38244l * 60 * 1000));
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(currentTimeMillis);
        instance.set(13, 0);
        instance.set(14, 0);
        int a = m27032a(instance.get(12));
        if (a == this.f38242j) {
            instance.add(11, 1);
            instance.set(12, 0);
        } else {
            instance.set(12, a);
        }
        return instance.getTimeInMillis();
    }

    /* renamed from: a */
    private Calendar m27034a(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        instance.set(11, this.f38245m);
        instance.set(12, this.f38246n);
        return instance;
    }

    /* renamed from: b */
    private Calendar m27036b(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        int i = this.f38248p;
        if (i == this.f38241i) {
            instance.add(5, 1);
            instance.set(11, 0);
            instance.set(12, 0);
        } else {
            instance.set(11, i);
            instance.set(12, this.f38247o);
        }
        return instance;
    }

    /* renamed from: a */
    private int m27032a(int i) {
        int i2 = this.f38240h;
        int i3 = i % i2;
        int i4 = i / i2;
        if (i3 != 0) {
            i4++;
        }
        return i4 * this.f38240h;
    }

    public List<String> getHour(int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = this.f38248p;
        int i3 = this.f38241i;
        if (i2 == i3) {
            i2 = i3;
        }
        for (int max = Math.max(this.f38245m, i); max < i2; max++) {
            arrayList.add(String.valueOf(max));
        }
        return arrayList;
    }

    public List<String> getMinute(int i) {
        String str;
        ArrayList arrayList = new ArrayList();
        for (int a = m27032a(i); a < this.f38242j; a += 10) {
            if (a == 0) {
                str = "00";
            } else {
                str = String.valueOf(a);
            }
            arrayList.add(str);
        }
        return arrayList;
    }

    public List<String> getDay(Resources resources, String[] strArr, boolean z) {
        ArrayList arrayList = new ArrayList();
        int earliesDay = getEarliesDay();
        if (z) {
            arrayList.add(strArr[0]);
        }
        if (earliesDay < 4) {
            for (int i = z ? earliesDay : earliesDay - 1; i < strArr.length; i++) {
                arrayList.add(strArr[i]);
            }
        }
        if (earliesDay == -1) {
            return null;
        }
        m27035a(resources, arrayList, earliesDay);
        return arrayList;
    }

    /* renamed from: a */
    private void m27035a(Resources resources, ArrayList<String> arrayList, int i) {
        int i2;
        int i3 = 3;
        if (i < 4) {
            i2 = this.f38243k - ((3 - i) + 1);
        } else {
            i3 = i - 1;
            i2 = this.f38243k;
        }
        Calendar instance = Calendar.getInstance();
        instance.add(5, i3);
        for (int i4 = 0; i4 < i2; i4++) {
            arrayList.add(formatTimeMillionsToMonthDayWeek(resources, instance, this.f38249q, false));
            instance.add(5, 1);
        }
        if (i2 < 0) {
            int i5 = i2 * -1;
            for (int i6 = 0; i6 < i5; i6++) {
                int size = arrayList.size() - 1;
                if (size >= 0) {
                    arrayList.remove(size);
                }
            }
        }
    }

    public static String formatTimeMillionsToMonthDayWeek(Resources resources, Calendar calendar, Locale locale, boolean z) {
        String displayName = calendar.getDisplayName(2, 1, locale);
        int i = calendar.get(5);
        String displayName2 = calendar.getDisplayName(7, locale == Locale.US ? 1 : 2, locale);
        String string = resources.getString(R.string.today);
        Object[] objArr = new Object[3];
        objArr[0] = displayName;
        objArr[1] = Integer.valueOf(i);
        if (z) {
            displayName2 = string;
        }
        objArr[2] = displayName2;
        return String.format(locale, resources.getString(R.string.time_picker_date_format, objArr), new Object[0]);
    }
}
