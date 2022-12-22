package com.didi.rfusion.widget.calendar;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.util.Pair;
import java.util.ArrayList;
import java.util.Collection;

public class RFSingleDateSelector implements RFDateSelector<Long> {
    public static final Parcelable.Creator<RFSingleDateSelector> CREATOR = new Parcelable.Creator<RFSingleDateSelector>() {
        public RFSingleDateSelector createFromParcel(Parcel parcel) {
            RFSingleDateSelector rFSingleDateSelector = new RFSingleDateSelector();
            Long unused = rFSingleDateSelector.f33467a = (Long) parcel.readValue(Long.class.getClassLoader());
            return rFSingleDateSelector;
        }

        public RFSingleDateSelector[] newArray(int i) {
            return new RFSingleDateSelector[i];
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Long f33467a;

    public int describeContents() {
        return 0;
    }

    public void select(long j) {
        this.f33467a = Long.valueOf(j);
    }

    /* renamed from: a */
    private void m23516a() {
        this.f33467a = null;
    }

    public void setSelection(Long l) {
        this.f33467a = l == null ? null : Long.valueOf(C11544e.m23553a(l.longValue()));
    }

    public boolean isSelectionComplete() {
        return this.f33467a != null;
    }

    public Collection<Pair<Long, Long>> getSelectedRanges() {
        return new ArrayList();
    }

    public Collection<Long> getSelectedDays() {
        ArrayList arrayList = new ArrayList();
        Long l = this.f33467a;
        if (l != null) {
            arrayList.add(l);
        }
        return arrayList;
    }

    public Long getSelection() {
        return this.f33467a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.f33467a);
    }
}
