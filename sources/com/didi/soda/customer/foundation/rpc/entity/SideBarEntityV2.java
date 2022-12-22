package com.didi.soda.customer.foundation.rpc.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.didi.soda.customer.foundation.rpc.entity.order.UnevaluatedPopupEntity;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class SideBarEntityV2 implements Parcelable, IEntity {
    public static final Parcelable.Creator<SideBarEntityV2> CREATOR = new Parcelable.Creator<SideBarEntityV2>() {
        public SideBarEntityV2 createFromParcel(Parcel parcel) {
            return new SideBarEntityV2(parcel);
        }

        public SideBarEntityV2[] newArray(int i) {
            return new SideBarEntityV2[i];
        }
    };
    private static final long serialVersionUID = 5519171467409331642L;
    @SerializedName("bannerList")
    public List<BannerEntity> mBannerList = new ArrayList();
    @SerializedName("userInfo")
    public UserInfoEntity mSelfInfo;
    @SerializedName("itemList")
    public List<SideGroup> mSideList = new ArrayList();
    @SerializedName("traceId")
    public String traceId;
    @SerializedName("unEvaluatedPopUp")
    public UnevaluatedPopupEntity unEvaluatedPopUp;

    public int describeContents() {
        return 0;
    }

    public SideBarEntityV2() {
    }

    protected SideBarEntityV2(Parcel parcel) {
        this.mSelfInfo = (UserInfoEntity) parcel.readParcelable(UserInfoEntity.class.getClassLoader());
        this.mSideList = parcel.createTypedArrayList(SideGroup.CREATOR);
        this.mBannerList = parcel.createTypedArrayList(BannerEntity.CREATOR);
        this.traceId = parcel.readString();
    }

    public void updateUserInfo(UserInfoEntity userInfoEntity) {
        UserInfoEntity userInfoEntity2 = this.mSelfInfo;
        if (userInfoEntity2 == null) {
            userInfoEntity2 = new UserInfoEntity();
        }
        if (userInfoEntity.headUrl != null) {
            userInfoEntity2.headUrl = userInfoEntity.headUrl;
        }
        if (userInfoEntity.firstName != null) {
            userInfoEntity2.firstName = userInfoEntity.firstName;
        }
        if (userInfoEntity.lastName != null) {
            userInfoEntity2.lastName = userInfoEntity.lastName;
        }
        this.mSelfInfo = userInfoEntity2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mSelfInfo, i);
        parcel.writeTypedList(this.mSideList);
        parcel.writeTypedList(this.mBannerList);
        parcel.writeString(this.traceId);
    }

    public static class SideItem implements Parcelable, IEntity {
        public static final Parcelable.Creator<SideItem> CREATOR = new Parcelable.Creator<SideItem>() {
            public SideItem createFromParcel(Parcel parcel) {
                return new SideItem(parcel);
            }

            public SideItem[] newArray(int i) {
                return new SideItem[i];
            }
        };
        private static final long serialVersionUID = -6418306680041972109L;
        public String content;
        public String icon;
        public String img;
        public int islogin;
        public int msgFlag;
        public int num;
        public String scheme;
        public String tag;

        public int describeContents() {
            return 0;
        }

        public SideItem() {
        }

        protected SideItem(Parcel parcel) {
            this.content = parcel.readString();
            this.scheme = parcel.readString();
            this.icon = parcel.readString();
            this.img = parcel.readString();
            this.tag = parcel.readString();
            this.msgFlag = parcel.readInt();
            this.num = parcel.readInt();
            this.islogin = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.content);
            parcel.writeString(this.scheme);
            parcel.writeString(this.icon);
            parcel.writeString(this.img);
            parcel.writeString(this.tag);
            parcel.writeInt(this.msgFlag);
            parcel.writeInt(this.num);
            parcel.writeInt(this.islogin);
        }
    }

    public static class SideGroup implements Parcelable, IEntity {
        public static final Parcelable.Creator<SideGroup> CREATOR = new Parcelable.Creator<SideGroup>() {
            public SideGroup createFromParcel(Parcel parcel) {
                return new SideGroup(parcel);
            }

            public SideGroup[] newArray(int i) {
                return new SideGroup[i];
            }
        };
        private static final long serialVersionUID = -1351330193706230424L;
        public List<SideItem> items = new ArrayList();
        public int type;

        public int describeContents() {
            return 0;
        }

        public SideGroup() {
        }

        protected SideGroup(Parcel parcel) {
            this.items = parcel.createTypedArrayList(SideItem.CREATOR);
            this.type = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeTypedList(this.items);
            parcel.writeInt(this.type);
        }
    }
}
