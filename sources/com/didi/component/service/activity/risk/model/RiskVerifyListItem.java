package com.didi.component.service.activity.risk.model;

import android.os.Parcel;
import android.os.Parcelable;

public class RiskVerifyListItem implements Parcelable {
    public static final Parcelable.Creator<RiskVerifyListItem> CREATOR = new Parcelable.Creator<RiskVerifyListItem>() {
        public RiskVerifyListItem createFromParcel(Parcel parcel) {
            return new RiskVerifyListItem(parcel);
        }

        public RiskVerifyListItem[] newArray(int i) {
            return new RiskVerifyListItem[i];
        }
    };
    public ItemClickParam cell_click_param;
    public String cell_click_scheme;
    public String content;
    public String head;

    public int describeContents() {
        return 0;
    }

    protected RiskVerifyListItem(Parcel parcel) {
        this.head = parcel.readString();
        this.content = parcel.readString();
        this.cell_click_scheme = parcel.readString();
        this.cell_click_param = (ItemClickParam) parcel.readParcelable(ItemClickParam.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.head);
        parcel.writeString(this.content);
        parcel.writeString(this.cell_click_scheme);
        parcel.writeParcelable(this.cell_click_param, i);
    }

    public static class ItemClickParam implements Parcelable {
        public static final Parcelable.Creator<ItemClickParam> CREATOR = new Parcelable.Creator<ItemClickParam>() {
            public ItemClickParam createFromParcel(Parcel parcel) {
                return new ItemClickParam(parcel);
            }

            public ItemClickParam[] newArray(int i) {
                return new ItemClickParam[i];
            }
        };
        public String from_type;
        public String url;

        public int describeContents() {
            return 0;
        }

        protected ItemClickParam(Parcel parcel) {
            this.from_type = parcel.readString();
            this.url = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.from_type);
            parcel.writeString(this.url);
        }
    }
}
