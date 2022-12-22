package com.didi.rfusion.widget.calendar;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.util.Pair;
import com.didi.rfusion.material.internal.RFPreconditions;
import java.util.ArrayList;
import java.util.Collection;

public class RFRangeDateSelector implements RFDateSelector<Pair<Long, Long>> {
    public static final Parcelable.Creator<RFRangeDateSelector> CREATOR = new Parcelable.Creator<RFRangeDateSelector>() {
        public RFRangeDateSelector createFromParcel(Parcel parcel) {
            RFRangeDateSelector rFRangeDateSelector = new RFRangeDateSelector();
            Long unused = rFRangeDateSelector.f33465a = (Long) parcel.readValue(Long.class.getClassLoader());
            Long unused2 = rFRangeDateSelector.f33466b = (Long) parcel.readValue(Long.class.getClassLoader());
            return rFRangeDateSelector;
        }

        public RFRangeDateSelector[] newArray(int i) {
            return new RFRangeDateSelector[i];
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Long f33465a = null;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Long f33466b = null;

    /* renamed from: a */
    private boolean m23513a(long j, long j2) {
        return j <= j2;
    }

    public int describeContents() {
        return 0;
    }

    public void select(long j) {
        Long l = this.f33465a;
        if (l == null) {
            this.f33465a = Long.valueOf(j);
        } else if (this.f33466b != null || !m23513a(l.longValue(), j)) {
            this.f33466b = null;
            this.f33465a = Long.valueOf(j);
        } else {
            this.f33466b = Long.valueOf(j);
        }
    }

    public boolean isSelectionComplete() {
        Long l = this.f33465a;
        return (l == null || this.f33466b == null || !m23513a(l.longValue(), this.f33466b.longValue())) ? false : true;
    }

    public void setSelection(Pair<Long, Long> pair) {
        Long l;
        if (!(pair.first == null || pair.second == null)) {
            RFPreconditions.checkArgument(m23513a(((Long) pair.first).longValue(), ((Long) pair.second).longValue()));
        }
        Long l2 = null;
        if (pair.first == null) {
            l = null;
        } else {
            l = Long.valueOf(C11544e.m23553a(((Long) pair.first).longValue()));
        }
        this.f33465a = l;
        if (pair.second != null) {
            l2 = Long.valueOf(C11544e.m23553a(((Long) pair.second).longValue()));
        }
        this.f33466b = l2;
    }

    public Pair<Long, Long> getSelection() {
        return new Pair<>(this.f33465a, this.f33466b);
    }

    public Collection<Pair<Long, Long>> getSelectedRanges() {
        if (this.f33465a == null || this.f33466b == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair(this.f33465a, this.f33466b));
        return arrayList;
    }

    public Collection<Long> getSelectedDays() {
        ArrayList arrayList = new ArrayList();
        Long l = this.f33465a;
        if (l != null) {
            arrayList.add(l);
        }
        Long l2 = this.f33466b;
        if (l2 != null) {
            arrayList.add(l2);
        }
        return arrayList;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.f33465a);
        parcel.writeValue(this.f33466b);
    }
}
