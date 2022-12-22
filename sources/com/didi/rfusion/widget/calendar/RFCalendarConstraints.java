package com.didi.rfusion.widget.calendar;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.util.ObjectsCompat;
import java.util.Arrays;

public final class RFCalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<RFCalendarConstraints> CREATOR = new Parcelable.Creator<RFCalendarConstraints>() {
        public RFCalendarConstraints createFromParcel(Parcel parcel) {
            return new RFCalendarConstraints((Month) parcel.readParcelable(Month.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), (DateValidator) parcel.readParcelable(DateValidator.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()));
        }

        public RFCalendarConstraints[] newArray(int i) {
            return new RFCalendarConstraints[i];
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Month f33428a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Month f33429b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final DateValidator f33430c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Month f33431d;

    /* renamed from: e */
    private final int f33432e;

    /* renamed from: f */
    private final int f33433f;

    public interface DateValidator extends Parcelable {
        boolean isValid(long j);
    }

    public int describeContents() {
        return 0;
    }

    private RFCalendarConstraints(Month month, Month month2, DateValidator dateValidator, Month month3) {
        this.f33428a = month;
        this.f33429b = month2;
        this.f33431d = month3;
        this.f33430c = dateValidator;
        if (month3 != null && month.compareTo(month3) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        } else if (month3 == null || month3.compareTo(month2) <= 0) {
            this.f33433f = month.mo87540b(month2) + 1;
            this.f33432e = (month2.f33400b - month.f33400b) + 1;
        } else {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo87570a(long j) {
        if (this.f33428a.mo87536a(1) <= j) {
            Month month = this.f33429b;
            if (j <= month.mo87536a(month.f33402d)) {
                return true;
            }
        }
        return false;
    }

    public DateValidator getDateValidator() {
        return this.f33430c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Month mo87568a() {
        return this.f33428a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Month mo87571b() {
        return this.f33429b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public Month mo87573c() {
        return this.f33431d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo87569a(Month month) {
        this.f33431d = month;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo87574d() {
        return this.f33433f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public int mo87576e() {
        return this.f33432e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFCalendarConstraints)) {
            return false;
        }
        RFCalendarConstraints rFCalendarConstraints = (RFCalendarConstraints) obj;
        if (!this.f33428a.equals(rFCalendarConstraints.f33428a) || !this.f33429b.equals(rFCalendarConstraints.f33429b) || !ObjectsCompat.equals(this.f33431d, rFCalendarConstraints.f33431d) || !this.f33430c.equals(rFCalendarConstraints.f33430c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f33428a, this.f33429b, this.f33431d, this.f33430c});
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f33428a, 0);
        parcel.writeParcelable(this.f33429b, 0);
        parcel.writeParcelable(this.f33431d, 0);
        parcel.writeParcelable(this.f33430c, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Month mo87572b(Month month) {
        if (month.compareTo(this.f33428a) < 0) {
            return this.f33428a;
        }
        return month.compareTo(this.f33429b) > 0 ? this.f33429b : month;
    }

    public static final class Builder {
        private static final String DEEP_COPY_VALIDATOR_KEY = "DEEP_COPY_VALIDATOR_KEY";
        static final long DEFAULT_END = C11544e.m23553a(Month.m23472a(2100, 11).f33403e);
        static final long DEFAULT_START = C11544e.m23553a(Month.m23472a(1970, 0).f33403e);
        private long end = DEFAULT_END;
        private Long openAt;
        private long start = DEFAULT_START;
        private DateValidator validator = RFDateValidatorPointForward.from(Long.MIN_VALUE);

        public Builder() {
        }

        Builder(RFCalendarConstraints rFCalendarConstraints) {
            this.start = rFCalendarConstraints.f33428a.f33403e;
            this.end = rFCalendarConstraints.f33429b.f33403e;
            this.openAt = Long.valueOf(rFCalendarConstraints.f33431d.f33403e);
            this.validator = rFCalendarConstraints.f33430c;
        }

        public Builder setStart(long j) {
            this.start = j;
            return this;
        }

        public Builder setEnd(long j) {
            this.end = j;
            return this;
        }

        public Builder setOpenAt(long j) {
            this.openAt = Long.valueOf(j);
            return this;
        }

        public Builder setValidator(DateValidator dateValidator) {
            this.validator = dateValidator;
            return this;
        }

        public RFCalendarConstraints build() {
            Month month;
            Bundle bundle = new Bundle();
            bundle.putParcelable(DEEP_COPY_VALIDATOR_KEY, this.validator);
            Month a = Month.m23473a(this.start);
            Month a2 = Month.m23473a(this.end);
            DateValidator dateValidator = (DateValidator) bundle.getParcelable(DEEP_COPY_VALIDATOR_KEY);
            Long l = this.openAt;
            if (l == null) {
                month = null;
            } else {
                month = Month.m23473a(l.longValue());
            }
            return new RFCalendarConstraints(a, a2, dateValidator, month);
        }
    }
}
