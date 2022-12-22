package com.didi.sdk.address.address.entity;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Address implements Serializable, Cloneable {
    public static final float ACCURACY_INVALID_VALUE = Float.MIN_VALUE;
    public static final double INVALID_VALUE = 0.0d;
    public static final int TYPE_CUR_LOCATION = 2;
    public static final int TYPE_OPNEN_INPUT = 1;
    private final String SRCTAG_HD = "hd";
    private final String SRCTAG_TOP = "top";
    private final String SRCTAG_UD = "ud";
    public float accuracy = Float.MIN_VALUE;
    @SerializedName("address")
    public String address;
    public String airportStr;
    public String business_district;
    @SerializedName("area")
    public int cityId = -1;
    @SerializedName("city")
    public String cityName;
    public String coordinate_type;
    @SerializedName("cotype")
    public int cotype;
    @SerializedName("count")
    public int count;
    public String countryCode;
    public int countryID;
    public long curTimeMills;
    @SerializedName("displayname")
    public String displayName;
    @SerializedName("distance")
    public String distance;
    public boolean enableConfirmDropoff;
    @SerializedName("expr")
    @Deprecated
    public float expr;
    @SerializedName("fullname")
    public String fullName;
    public String[] geofence;
    @SerializedName("hide_address")
    public String hideAddress;
    public boolean isDiscountPoi;
    @SerializedName("is_history")
    public int isHistory;
    @SerializedName("is_default_recom")
    public int isRecommendTag = -1;
    public boolean isSuggestDeparture;
    public String language;
    @SerializedName("lat")
    public double latitude = 0.0d;
    @SerializedName("lng")
    public double longitude = 0.0d;
    public String mainTitleDesc;
    @SerializedName("name")
    public String name;
    @SerializedName("oldaddr")
    public String oldAddress;
    public int operationType;
    @SerializedName("pic_url")
    public String picUrl;
    private int pickupPointOrderStatus;
    public String poiId;
    public String provider;
    @SerializedName("reallat")
    public double realLatitude = 0.0d;
    @SerializedName("reallng")
    public double reallongitude = 0.0d;
    public String searchId;
    @SerializedName("showproduct")
    public String showProduct;
    public String sourceDisplayName;
    @SerializedName("srctag")
    public String srcTag;
    public String state;
    @SerializedName("subpois")
    public ArrayList<Address> subPois = null;
    public String subTitleDesc;
    @SerializedName("tag")
    public String tag;
    public int type;
    @SerializedName("uid")
    public String uid;
    @SerializedName("weight")
    public double weight;
    public String xpanelDesc;

    public boolean isRecommendTag() {
        return this.isRecommendTag == 1;
    }

    public int getPickupPointOrderStatus() {
        return this.pickupPointOrderStatus;
    }

    public void setPickupPointOrderStatus(int i) {
        this.pickupPointOrderStatus = i;
    }

    public boolean isHistoryMark() {
        if (!TextUtils.isEmpty(this.srcTag)) {
            return this.srcTag.startsWith("ud") || this.srcTag.endsWith("top");
        }
        return false;
    }

    public boolean hasDistrict() {
        return !TextUtils.isEmpty(this.business_district);
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getAddress() {
        return this.address;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public boolean isSameCity(Address address2) {
        return address2 != null && this.cityId == address2.cityId;
    }

    public String toString() {
        return "Address{SRCTAG_UD='ud', SRCTAG_TOP='top', SRCTAG_HD='hd', uid='" + this.uid + '\'' + ", name='" + this.name + '\'' + ", displayName='" + this.displayName + '\'' + ", fullName='" + this.fullName + '\'' + ", address='" + this.address + '\'' + ", oldAddress='" + this.oldAddress + '\'' + ", longitude=" + this.longitude + ", reallongitude=" + this.reallongitude + ", latitude=" + this.latitude + ", realLatitude=" + this.realLatitude + ", subPois=" + this.subPois + ", cityName='" + this.cityName + '\'' + ", cityId=" + this.cityId + ", distance='" + this.distance + '\'' + ", srcTag='" + this.srcTag + '\'' + ", cotype=" + this.cotype + ", isRecommendTag=" + this.isRecommendTag + ", weight=" + this.weight + ", isHistory=" + this.isHistory + ", count=" + this.count + ", tag='" + this.tag + '\'' + ", showProduct='" + this.showProduct + '\'' + ", picUrl='" + this.picUrl + '\'' + ", expr=" + this.expr + ", isSuggestDeparture=" + this.isSuggestDeparture + ", sourceDisplayName='" + this.sourceDisplayName + '\'' + ", searchId='" + this.searchId + '\'' + ", geofence=" + Arrays.toString(this.geofence) + ", curTimeMills=" + this.curTimeMills + ", business_district=" + this.business_district + ", airportStr=" + this.airportStr + ", business_district=" + this.business_district + ", accuracy=" + this.accuracy + ", provider=" + this.provider + ", mainTitleDesc=" + this.mainTitleDesc + ", subTitleDesc=" + this.subTitleDesc + ", hideAddress=" + this.hideAddress + ", operationType=" + this.operationType + ", enableConfirmDropoff=" + this.enableConfirmDropoff + '}';
    }

    public String getUid() {
        return this.uid;
    }

    public String getName() {
        return this.name;
    }

    public String getFullName() {
        return this.fullName;
    }

    public String getOldAddress() {
        return this.oldAddress;
    }

    public double getReallongitude() {
        return this.reallongitude;
    }

    public double getRealLatitude() {
        return this.realLatitude;
    }

    public ArrayList<Address> getSubPois() {
        return this.subPois;
    }

    public String getCityName() {
        return this.cityName;
    }

    public int getCityId() {
        return this.cityId;
    }

    public String getDistance() {
        return this.distance;
    }

    public String getSrcTag() {
        return this.srcTag;
    }

    public int getCotype() {
        return this.cotype;
    }

    public int getIsRecommendTag() {
        return this.isRecommendTag;
    }

    public double getWeight() {
        return this.weight;
    }

    public int getIsHistory() {
        return this.isHistory;
    }

    public int getCount() {
        return this.count;
    }

    public String getTag() {
        return this.tag;
    }

    public String getShowProduct() {
        return this.showProduct;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public float getExpr() {
        return this.expr;
    }

    public boolean isSuggestDeparture() {
        return this.isSuggestDeparture;
    }

    public String getSourceDisplayName() {
        return this.sourceDisplayName;
    }

    public String getSearchId() {
        return this.searchId;
    }

    public String[] getGeofence() {
        return this.geofence;
    }

    public long getCurTimeMills() {
        return this.curTimeMills;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public void setFullName(String str) {
        this.fullName = str;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setOldAddress(String str) {
        this.oldAddress = str;
    }

    public void setLongitude(double d) {
        this.longitude = d;
    }

    public void setReallongitude(double d) {
        this.reallongitude = d;
    }

    public void setLatitude(double d) {
        this.latitude = d;
    }

    public void setRealLatitude(double d) {
        this.realLatitude = d;
    }

    public void setSubPois(ArrayList<Address> arrayList) {
        this.subPois = arrayList;
    }

    public void setCityName(String str) {
        this.cityName = str;
    }

    public void setCityId(int i) {
        this.cityId = i;
    }

    public void setDistance(String str) {
        this.distance = str;
    }

    public void setSrcTag(String str) {
        this.srcTag = str;
    }

    public void setCotype(int i) {
        this.cotype = i;
    }

    public void setIsRecommendTag(int i) {
        this.isRecommendTag = i;
    }

    public void setWeight(double d) {
        this.weight = d;
    }

    public void setIsHistory(int i) {
        this.isHistory = i;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public void setShowProduct(String str) {
        this.showProduct = str;
    }

    public void setPicUrl(String str) {
        this.picUrl = str;
    }

    public void setExpr(float f) {
        this.expr = f;
    }

    public void setSuggestDeparture(boolean z) {
        this.isSuggestDeparture = z;
    }

    public void setSourceDisplayName(String str) {
        this.sourceDisplayName = str;
    }

    public void setSearchId(String str) {
        this.searchId = str;
    }

    public void setGeofence(String[] strArr) {
        this.geofence = strArr;
    }

    public void setCurTimeMills(long j) {
        this.curTimeMills = j;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String str) {
        this.state = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String getMainTitleDesc() {
        return this.mainTitleDesc;
    }

    public void setMainTitleDesc(String str) {
        this.mainTitleDesc = str;
    }

    public String getSubTitleDesc() {
        return this.subTitleDesc;
    }

    public void setSubTitleDesc(String str) {
        this.subTitleDesc = str;
    }

    public String getHideAddress() {
        return this.hideAddress;
    }

    public void setHideAddress(String str) {
        this.hideAddress = str;
    }

    public Address clone() {
        try {
            return (Address) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getAirportStr() {
        return this.airportStr;
    }

    public void setAirportStr(String str) {
        this.airportStr = str;
    }

    public boolean getEnableConfirmDropoff() {
        return this.enableConfirmDropoff;
    }

    public void setEnableConfirmDropoff(boolean z) {
        this.enableConfirmDropoff = z;
    }
}
