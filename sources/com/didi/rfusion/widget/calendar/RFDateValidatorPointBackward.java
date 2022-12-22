package com.didi.rfusion.widget.calendar;

import android.os.Parcel;
import android.os.Parcelable;
import com.didi.rfusion.widget.calendar.RFCalendarConstraints;
import java.util.Arrays;

public class RFDateValidatorPointBackward implements RFCalendarConstraints.DateValidator {
    public static final Parcelable.Creator<RFDateValidatorPointBackward> CREATOR = new Parcelable.Creator<RFDateValidatorPointBackward>() {
        public RFDateValidatorPointBackward createFromParcel(Parcel parcel) {
            return new RFDateValidatorPointBackward(parcel.readLong());
        }

        public RFDateValidatorPointBackward[] newArray(int i) {
            return new RFDateValidatorPointBackward[i];
        }
    };

    /* renamed from: a */
    private final long f33459a;

    public int describeContents() {
        return 0;
    }

    private RFDateValidatorPointBackward(long j) {
        this.f33459a = j;
    }

    public static RFDateValidatorPointBackward before(long j) {
        return new RFDateValidatorPointBackward(j);
    }

    public static RFDateValidatorPointBackward now() {
        return before(C11544e.m23564b().getTimeInMillis());
    }

    public boolean isValid(long j) {
        return j <= this.f33459a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f33459a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof RFDateValidatorPointBackward) && this.f33459a == ((RFDateValidatorPointBackward) obj).f33459a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f33459a)});
    }
}
