package com.didi.payment.wallet.global.wallet.contract;

import android.os.Parcel;
import android.os.Parcelable;
import com.didi.payment.wallet.global.wallet.contract.WalletCommonContract;
import com.didi.payment.wallet.global.wallet.entity.WalletSettingPageInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public interface WalletMainListSettingContract {
    public static final int SETTING_FAST_PAY = 6;
    public static final int SETTING_ID_HELP = 1;
    public static final int SETTING_ID_NIGHTLY_LIMIT = 4;
    public static final int SETTING_ID_PAYPAL = 3;
    public static final int SETTING_ID_PAY_PWD = 5;
    public static final int SETTING_ID_VERIFY = 2;

    public interface Presenter extends WalletCommonContract.Presenter {
        void onSettingItemClicked(int i, String str, ArrayList<SettingItemModel> arrayList);
    }

    public interface View extends WalletCommonContract.ILoadingView, WalletCommonContract.View<List<SettingItemModel>, WalletCommonContract.NullListener> {
        void onUpdate(WalletSettingPageInfo walletSettingPageInfo);
    }

    public static class SettingItemModel implements Parcelable, Serializable {
        public static final Parcelable.Creator<SettingItemModel> CREATOR = new Parcelable.Creator<SettingItemModel>() {
            public SettingItemModel createFromParcel(Parcel parcel) {
                return new SettingItemModel(parcel);
            }

            public SettingItemModel[] newArray(int i) {
                return new SettingItemModel[i];
            }
        };
        public boolean hasRedPoint;

        /* renamed from: id */
        public int f32011id;
        public int imgId;
        public String linkUrl;
        public String name;
        public String rightLabel1;
        public String rightLabel2;
        public int rightLabel2Color;
        public boolean showArrow = true;
        public boolean showTopGap = false;
        public String subName;
        public ArrayList<SettingItemModel> subSetting;
        public int type;

        public int describeContents() {
            return 0;
        }

        public SettingItemModel() {
        }

        protected SettingItemModel(Parcel parcel) {
            boolean z = true;
            this.type = parcel.readInt();
            this.f32011id = parcel.readInt();
            this.imgId = parcel.readInt();
            this.name = parcel.readString();
            this.subName = parcel.readString();
            this.rightLabel1 = parcel.readString();
            this.rightLabel2 = parcel.readString();
            this.rightLabel2Color = parcel.readInt();
            this.showArrow = parcel.readByte() != 0;
            this.showTopGap = parcel.readByte() != 0;
            this.linkUrl = parcel.readString();
            this.hasRedPoint = parcel.readByte() == 0 ? false : z;
            this.subSetting = parcel.createTypedArrayList(CREATOR);
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.type);
            parcel.writeInt(this.f32011id);
            parcel.writeInt(this.imgId);
            parcel.writeString(this.name);
            parcel.writeString(this.subName);
            parcel.writeString(this.rightLabel1);
            parcel.writeString(this.rightLabel2);
            parcel.writeInt(this.rightLabel2Color);
            parcel.writeByte(this.showArrow ? (byte) 1 : 0);
            parcel.writeByte(this.showTopGap ? (byte) 1 : 0);
            parcel.writeString(this.linkUrl);
            parcel.writeByte(this.hasRedPoint ? (byte) 1 : 0);
            parcel.writeTypedList(this.subSetting);
        }
    }
}
