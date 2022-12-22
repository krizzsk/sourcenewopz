package com.didi.soda.customer.foundation.rpc.entity.address;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import com.didi.soda.bill.model.datamodel.AddressModel;
import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.google.gson.annotations.SerializedName;
import com.taxis99.R;

public class AddressEntity implements Parcelable, IEntity {
    public static final Parcelable.Creator<AddressEntity> CREATOR = new Parcelable.Creator<AddressEntity>() {
        public AddressEntity createFromParcel(Parcel parcel) {
            return new AddressEntity(parcel);
        }

        public AddressEntity[] newArray(int i) {
            return new AddressEntity[i];
        }
    };
    private static final long serialVersionUID = -3324340354282107484L;
    @SerializedName("aid")
    public String aid;
    @SerializedName("buildingName")
    public String buildingName;
    @SerializedName("callingCode")
    public String callingCode;
    @SerializedName("canUseCash")
    public boolean canUseCash;
    @SerializedName("phoneCountryId")
    public int countryId;
    @SerializedName("createTime")
    public long createTime;
    @SerializedName("firstName")
    public String firstName;
    @SerializedName("houseNumber")
    public String houseNumber;
    public boolean isHistory = false;
    @SerializedName("lastName")
    public String lastName;
    @SerializedName("name")
    public String name;
    @SerializedName("phone")
    public String phone;
    @SerializedName("poi")
    public PoiEntity poi;
    @SerializedName("address_strategy_version")
    public String recid;
    @SerializedName("source")
    public int source;
    public String tempAid;
    @SerializedName("type")
    public int type;
    @SerializedName("uid")
    public String uid;
    @SerializedName("userCountryCode")
    public String userCountryCode;

    public int describeContents() {
        return 0;
    }

    public AddressEntity clone() {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.aid = this.aid;
        addressEntity.poi = this.poi.clone();
        addressEntity.type = this.type;
        addressEntity.houseNumber = this.houseNumber;
        addressEntity.buildingName = this.buildingName;
        addressEntity.phone = this.phone;
        return addressEntity;
    }

    public AddressEntity cloneNoPoi() {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.aid = this.aid;
        addressEntity.type = this.type;
        addressEntity.phone = this.phone;
        return addressEntity;
    }

    public AddressEntity() {
    }

    protected AddressEntity(Parcel parcel) {
        boolean z = false;
        this.aid = parcel.readString();
        this.uid = parcel.readString();
        this.poi = (PoiEntity) parcel.readParcelable(PoiEntity.class.getClassLoader());
        this.type = parcel.readInt();
        this.houseNumber = parcel.readString();
        this.createTime = parcel.readLong();
        this.canUseCash = parcel.readByte() != 0;
        this.recid = parcel.readString();
        this.isHistory = parcel.readByte() != 0 ? true : z;
        this.callingCode = parcel.readString();
        this.tempAid = parcel.readString();
    }

    public String getAptAndBuildingName() {
        if (TextUtils.isEmpty(this.houseNumber) && TextUtils.isEmpty(this.buildingName)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.houseNumber)) {
            sb.append(this.houseNumber);
        }
        if (!TextUtils.isEmpty(this.houseNumber) && !TextUtils.isEmpty(this.buildingName)) {
            sb.append(ResourceHelper.getString(R.string.customer_global_blank));
        }
        if (!TextUtils.isEmpty(this.buildingName)) {
            sb.append(this.buildingName);
        }
        return sb.toString();
    }

    public String getBuildNameAndApt() {
        if (TextUtils.isEmpty(this.houseNumber) && TextUtils.isEmpty(this.buildingName)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.buildingName)) {
            sb.append(this.buildingName);
        }
        if (!TextUtils.isEmpty(this.houseNumber)) {
            if (!TextUtils.isEmpty(this.buildingName)) {
                sb.append(" ");
            }
            sb.append(this.houseNumber);
        }
        return sb.toString();
    }

    public String getAptBuildAndContact() {
        StringBuilder sb = new StringBuilder();
        PoiEntity poiEntity = this.poi;
        if (poiEntity != null) {
            sb.append(poiEntity.displayName);
            if (sb.length() > 0) {
                sb.append(" ");
                sb.append(getBuildNameAndApt());
            }
        }
        AddressModel addressModel = new AddressModel();
        if (!TextUtils.isEmpty(addressModel.getContactPhone()) || (!TextUtils.isEmpty(addressModel.getContactName()) && sb.length() > 0)) {
            sb.append("\n");
        }
        if (!TextUtils.isEmpty(addressModel.getContactName())) {
            sb.append(addressModel.getContactName());
        }
        if (!TextUtils.isEmpty(addressModel.getContactPhone())) {
            if (!TextUtils.isEmpty(addressModel.getContactName())) {
                sb.append(" ");
            }
            sb.append(addressModel.getContactPhone());
        }
        return sb.toString();
    }

    public String getBusinessDepartPoi() {
        StringBuilder sb = new StringBuilder();
        PoiEntity poiEntity = this.poi;
        if (poiEntity != null && !TextUtils.isEmpty(poiEntity.displayName)) {
            sb.append(this.poi.displayName);
        }
        if (!TextUtils.isEmpty(this.houseNumber)) {
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(this.houseNumber);
        }
        if (!TextUtils.isEmpty(this.buildingName)) {
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(this.buildingName);
        }
        return sb.toString();
    }

    public String getHouseDepartPoi() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.houseNumber)) {
            sb.append(this.houseNumber);
        }
        if (!TextUtils.isEmpty(this.buildingName)) {
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(this.buildingName);
        }
        PoiEntity poiEntity = this.poi;
        if (poiEntity != null && !TextUtils.isEmpty(poiEntity.displayName)) {
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(this.poi.displayName);
        }
        return sb.toString();
    }

    public String getAidTypeName() {
        int i = this.type;
        if (i == 1) {
            return ResourceHelper.getString(R.string.customer_address_edit_home);
        }
        return i == 2 ? ResourceHelper.getString(R.string.customer_address_edit_company) : "";
    }

    public SpannableStringBuilder getPoiDisplayNamePrefix() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(getAidTypeName());
        int length = spannableStringBuilder.length();
        if (length > 0) {
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(11, true), 0, length, 17);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(0), 0, length, 17);
            spannableStringBuilder.append(ResourceHelper.getString(R.string.customer_global_blank_double));
            spannableStringBuilder.append(ResourceHelper.getString(R.string.customer_global_blank_double));
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(13, true), length, length + 4, 17);
        }
        return spannableStringBuilder;
    }

    public CharSequence getPoiDisplayName() {
        PoiEntity poiEntity = this.poi;
        if (poiEntity == null || TextUtils.isEmpty(poiEntity.displayName)) {
            return null;
        }
        return getPoiDisplayNamePrefix().append(this.poi.displayName);
    }

    public CharSequence getPoiDisplayNameHint() {
        return getPoiDisplayNamePrefix().append(ResourceHelper.getString(R.string.customer_name_edit_poi_hint));
    }

    public String getAid() {
        String str = this.aid;
        return str == null ? "" : str;
    }

    public String getBuildingName() {
        String str = this.buildingName;
        return str == null ? "" : str;
    }

    public String getHouseNumber() {
        String str = this.houseNumber;
        return str == null ? "" : str;
    }

    public String toString() {
        return "{aid=" + this.aid + '\'' + "houseNumber'" + this.houseNumber + '\'' + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.aid);
        parcel.writeString(this.uid);
        parcel.writeParcelable(this.poi, i);
        parcel.writeInt(this.type);
        parcel.writeString(this.houseNumber);
        parcel.writeLong(this.createTime);
        parcel.writeByte(this.canUseCash ? (byte) 1 : 0);
        parcel.writeString(this.recid);
        parcel.writeByte(this.isHistory ? (byte) 1 : 0);
        parcel.writeString(this.callingCode);
        parcel.writeString(this.tempAid);
    }

    public static class PoiEntity implements Parcelable, IEntity {
        public static final Parcelable.Creator<PoiEntity> CREATOR = new Parcelable.Creator<PoiEntity>() {
            public PoiEntity createFromParcel(Parcel parcel) {
                return new PoiEntity(parcel);
            }

            public PoiEntity[] newArray(int i) {
                return new PoiEntity[i];
            }
        };
        private static final long serialVersionUID = 4177519710428565934L;
        @SerializedName("address")
        public String address;
        @SerializedName("addressAll")
        public String addressAll;
        @SerializedName("addressAllDisplay")
        public String addressAllDisplay;
        @SerializedName("city")
        public String city;
        @SerializedName("cityId")
        public int cityId;
        @SerializedName("coordinateType")
        public String coordinateType;
        @SerializedName("countryCode")
        public String countryCode;
        @SerializedName("countryId")
        public int countryId;
        @SerializedName("countyGroupId")
        public long countyGroupId;
        @SerializedName("countyId")
        public long countyId;
        @SerializedName("displayName")
        public String displayName;
        @SerializedName("distStr")
        public String distStr;
        @SerializedName("lat")
        public double lat;
        @SerializedName("lng")
        public double lng;
        @SerializedName("poiId")
        public String poiId;
        @SerializedName("poiSrcTag")
        public String poiSrcTag;
        @SerializedName("poiType")
        public String poiType;
        @SerializedName("searchId")
        public String searchId;
        @SerializedName("srcTag")
        public String srcTag;

        public int describeContents() {
            return 0;
        }

        public PoiEntity() {
        }

        protected PoiEntity(Parcel parcel) {
            this.poiId = parcel.readString();
            this.city = parcel.readString();
            this.cityId = parcel.readInt();
            this.countryCode = parcel.readString();
            this.countryId = parcel.readInt();
            this.displayName = parcel.readString();
            this.address = parcel.readString();
            this.addressAll = parcel.readString();
            this.lat = parcel.readDouble();
            this.lng = parcel.readDouble();
            this.distStr = parcel.readString();
            this.coordinateType = parcel.readString();
            this.poiSrcTag = parcel.readString();
            this.srcTag = parcel.readString();
            this.searchId = parcel.readString();
            this.addressAllDisplay = parcel.readString();
            this.poiType = parcel.readString();
            this.countyId = parcel.readLong();
            this.countyGroupId = parcel.readLong();
        }

        public PoiEntity clone() {
            PoiEntity poiEntity = new PoiEntity();
            poiEntity.poiId = this.poiId;
            poiEntity.city = this.city;
            poiEntity.cityId = this.cityId;
            poiEntity.countryCode = this.countryCode;
            poiEntity.countryId = this.countryId;
            poiEntity.displayName = this.displayName;
            poiEntity.address = this.address;
            poiEntity.addressAll = this.addressAll;
            poiEntity.lat = this.lat;
            poiEntity.lng = this.lng;
            poiEntity.distStr = this.distStr;
            poiEntity.coordinateType = this.coordinateType;
            poiEntity.poiSrcTag = this.poiSrcTag;
            poiEntity.srcTag = this.srcTag;
            poiEntity.searchId = this.searchId;
            poiEntity.addressAllDisplay = this.addressAllDisplay;
            poiEntity.poiType = this.poiType;
            poiEntity.countyId = this.countyId;
            poiEntity.countyGroupId = this.countyGroupId;
            return poiEntity;
        }

        public String toString() {
            return "BaseAddress{poiId='" + this.poiId + '\'' + ", poiType='" + this.poiType + '\'' + ", city='" + this.city + '\'' + ", cityId=" + this.cityId + ", displayName='" + this.displayName + '\'' + ", address='" + this.address + '\'' + ", addressAll='" + this.addressAll + '\'' + ", addressAllDisplay='" + this.addressAllDisplay + '\'' + ", lat=" + this.lat + ", lng=" + this.lng + ", distStr='" + this.distStr + '\'' + ", coordinateType='" + this.coordinateType + '\'' + ", poiSrcTag='" + this.poiSrcTag + '\'' + ", srcTag='" + this.srcTag + '\'' + ", searchId='" + this.searchId + '\'' + ", countyId='" + this.countyId + '\'' + ", countyGroupId='" + this.countyGroupId + '\'' + '}';
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.poiId);
            parcel.writeString(this.city);
            parcel.writeInt(this.cityId);
            parcel.writeString(this.countryCode);
            parcel.writeInt(this.countryId);
            parcel.writeString(this.displayName);
            parcel.writeString(this.address);
            parcel.writeString(this.addressAll);
            parcel.writeDouble(this.lat);
            parcel.writeDouble(this.lng);
            parcel.writeString(this.distStr);
            parcel.writeString(this.coordinateType);
            parcel.writeString(this.poiSrcTag);
            parcel.writeString(this.srcTag);
            parcel.writeString(this.searchId);
            parcel.writeString(this.addressAllDisplay);
            parcel.writeString(this.poiType);
            parcel.writeLong(this.countyId);
            parcel.writeLong(this.countyGroupId);
        }
    }
}
