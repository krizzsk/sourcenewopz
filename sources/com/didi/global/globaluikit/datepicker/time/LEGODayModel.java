package com.didi.global.globaluikit.datepicker.time;

import com.global.didi.elvish.DateStyle;
import com.global.didi.elvish.Elvish;
import com.global.didi.elvish.TimeStyle;
import java.util.Calendar;

public class LEGODayModel {

    /* renamed from: a */
    private int f22454a;

    /* renamed from: b */
    private int f22455b;

    /* renamed from: c */
    private int f22456c;

    /* renamed from: d */
    private int f22457d;

    /* renamed from: e */
    private String f22458e;

    public LEGODayModel(int i, int i2, int i3, int i4, String str) {
        this.f22454a = i3;
        this.f22455b = i;
        this.f22456c = i2;
        this.f22457d = i4;
        this.f22458e = str;
    }

    public String getDayString() {
        return toString();
    }

    public String toString() {
        Calendar instance = Calendar.getInstance();
        instance.set(this.f22455b, this.f22456c, this.f22454a);
        Calendar dateTimeCalendar = Elvish.Companion.getInstance().getDateTimeCalendar(System.currentTimeMillis());
        int i = dateTimeCalendar.get(1);
        int i2 = dateTimeCalendar.get(2);
        int i3 = dateTimeCalendar.get(5);
        if (i == this.f22455b && i2 == this.f22456c && i3 == this.f22454a) {
            return C8645a.f22474a;
        }
        return Elvish.Companion.getInstance().formatDateTime(instance.getTimeInMillis() / 1000, DateStyle.DATE_DD_MTH, TimeStyle.NONE, true);
    }

    public int getDay() {
        return this.f22454a;
    }

    public int getYear() {
        return this.f22455b;
    }

    public int getMonth() {
        return this.f22456c;
    }

    public int getDate() {
        return this.f22457d;
    }

    public boolean equals(Object obj) {
        LEGODayModel lEGODayModel = (LEGODayModel) obj;
        return this.f22455b == lEGODayModel.getYear() && this.f22456c == lEGODayModel.getMonth() && this.f22454a == lEGODayModel.getDay();
    }
}
