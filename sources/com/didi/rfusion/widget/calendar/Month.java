package com.didi.rfusion.widget.calendar;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

final class Month implements Parcelable, Comparable<Month> {
    public static final Parcelable.Creator<Month> CREATOR = new Parcelable.Creator<Month>() {
        public Month createFromParcel(Parcel parcel) {
            return Month.m23472a(parcel.readInt(), parcel.readInt());
        }

        public Month[] newArray(int i) {
            return new Month[i];
        }
    };

    /* renamed from: a */
    final int f33399a;

    /* renamed from: b */
    final int f33400b = this.f33404f.get(1);

    /* renamed from: c */
    final int f33401c = this.f33404f.getMaximum(7);

    /* renamed from: d */
    final int f33402d = this.f33404f.getActualMaximum(5);

    /* renamed from: e */
    final long f33403e = this.f33404f.getTimeInMillis();

    /* renamed from: f */
    private final Calendar f33404f;

    /* renamed from: g */
    private String f33405g;

    public int describeContents() {
        return 0;
    }

    private Month(Calendar calendar) {
        calendar.set(5, 1);
        Calendar b = C11544e.m23565b(calendar);
        this.f33404f = b;
        this.f33399a = b.get(2);
    }

    /* renamed from: a */
    static Month m23473a(long j) {
        Calendar c = C11544e.m23567c();
        c.setTimeInMillis(j);
        return new Month(c);
    }

    /* renamed from: a */
    static Month m23472a(int i, int i2) {
        Calendar c = C11544e.m23567c();
        c.set(1, i);
        c.set(2, i2);
        return new Month(c);
    }

    /* renamed from: a */
    static Month m23471a() {
        return new Month(C11544e.m23564b());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo87538b() {
        int firstDayOfWeek = this.f33404f.get(7) - this.f33404f.getFirstDayOfWeek();
        return firstDayOfWeek < 0 ? firstDayOfWeek + this.f33401c : firstDayOfWeek;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Month)) {
            return false;
        }
        Month month = (Month) obj;
        if (this.f33399a == month.f33399a && this.f33400b == month.f33400b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f33399a), Integer.valueOf(this.f33400b)});
    }

    /* renamed from: a */
    public int compareTo(Month month) {
        return this.f33404f.compareTo(month.f33404f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo87540b(Month month) {
        if (this.f33404f instanceof GregorianCalendar) {
            return ((month.f33400b - this.f33400b) * 12) + (month.f33399a - this.f33399a);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public long mo87542c() {
        return this.f33404f.getTimeInMillis();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public long mo87536a(int i) {
        Calendar b = C11544e.m23565b(this.f33404f);
        b.set(5, i);
        return b.getTimeInMillis();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo87539b(long j) {
        Calendar b = C11544e.m23565b(this.f33404f);
        b.setTimeInMillis(j);
        return b.get(5);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Month mo87541b(int i) {
        Calendar b = C11544e.m23565b(this.f33404f);
        b.add(2, i);
        return new Month(b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo87537a(Context context) {
        if (this.f33405g == null) {
            this.f33405g = C11540a.m23523a(context, this.f33404f.getTimeInMillis());
        }
        return this.f33405g;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f33400b);
        parcel.writeInt(this.f33399a);
    }
}
