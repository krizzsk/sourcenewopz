package com.didi.rfusion.widget.calendar;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.util.Preconditions;
import com.didi.rfusion.widget.calendar.RFCalendarConstraints;
import java.util.ArrayList;
import java.util.List;

public final class RFCompositeDateValidator implements RFCalendarConstraints.DateValidator {
    public static final Parcelable.Creator<RFCompositeDateValidator> CREATOR = new Parcelable.Creator<RFCompositeDateValidator>() {
        public RFCompositeDateValidator createFromParcel(Parcel parcel) {
            Operator operator;
            ArrayList readArrayList = parcel.readArrayList(RFCalendarConstraints.DateValidator.class.getClassLoader());
            int readInt = parcel.readInt();
            if (readInt == 2) {
                operator = RFCompositeDateValidator.f33454f;
            } else if (readInt == 1) {
                operator = RFCompositeDateValidator.f33453e;
            } else {
                operator = RFCompositeDateValidator.f33454f;
            }
            return new RFCompositeDateValidator((List) Preconditions.checkNotNull(readArrayList), operator);
        }

        public RFCompositeDateValidator[] newArray(int i) {
            return new RFCompositeDateValidator[i];
        }
    };

    /* renamed from: c */
    private static final int f33451c = 1;

    /* renamed from: d */
    private static final int f33452d = 2;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final Operator f33453e = new Operator() {
        public int getId() {
            return 1;
        }

        public boolean isValid(List<RFCalendarConstraints.DateValidator> list, long j) {
            for (RFCalendarConstraints.DateValidator next : list) {
                if (next != null && next.isValid(j)) {
                    return true;
                }
            }
            return false;
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final Operator f33454f = new Operator() {
        public int getId() {
            return 2;
        }

        public boolean isValid(List<RFCalendarConstraints.DateValidator> list, long j) {
            for (RFCalendarConstraints.DateValidator next : list) {
                if (next != null && !next.isValid(j)) {
                    return false;
                }
            }
            return true;
        }
    };

    /* renamed from: a */
    private final Operator f33455a;

    /* renamed from: b */
    private final List<RFCalendarConstraints.DateValidator> f33456b;

    private interface Operator {
        int getId();

        boolean isValid(List<RFCalendarConstraints.DateValidator> list, long j);
    }

    public int describeContents() {
        return 0;
    }

    private RFCompositeDateValidator(List<RFCalendarConstraints.DateValidator> list, Operator operator) {
        this.f33456b = list;
        this.f33455a = operator;
    }

    public static RFCalendarConstraints.DateValidator allOf(List<RFCalendarConstraints.DateValidator> list) {
        return new RFCompositeDateValidator(list, f33454f);
    }

    public static RFCalendarConstraints.DateValidator anyOf(List<RFCalendarConstraints.DateValidator> list) {
        return new RFCompositeDateValidator(list, f33453e);
    }

    public boolean isValid(long j) {
        return this.f33455a.isValid(this.f33456b, j);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f33456b);
        parcel.writeInt(this.f33455a.getId());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFCompositeDateValidator)) {
            return false;
        }
        RFCompositeDateValidator rFCompositeDateValidator = (RFCompositeDateValidator) obj;
        if (!this.f33456b.equals(rFCompositeDateValidator.f33456b) || this.f33455a.getId() != rFCompositeDateValidator.f33455a.getId()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f33456b.hashCode();
    }
}
