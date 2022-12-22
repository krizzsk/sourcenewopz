package com.didi.soda.search.storage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class HistoryTag implements Parcelable {
    public static final Parcelable.Creator<HistoryTag> CREATOR = new Parcelable.Creator<HistoryTag>() {
        public HistoryTag createFromParcel(Parcel parcel) {
            return new HistoryTag(parcel);
        }

        public HistoryTag[] newArray(int i) {
            return new HistoryTag[i];
        }
    };
    public List<String> mTagList = new ArrayList();

    public int describeContents() {
        return 0;
    }

    public HistoryTag() {
    }

    protected HistoryTag(Parcel parcel) {
        this.mTagList = parcel.createStringArrayList();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(this.mTagList);
    }
}
