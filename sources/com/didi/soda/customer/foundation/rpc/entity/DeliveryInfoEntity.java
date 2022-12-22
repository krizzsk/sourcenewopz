package com.didi.soda.customer.foundation.rpc.entity;

public class DeliveryInfoEntity implements IEntity {
    private static final long serialVersionUID = 4106773450479319808L;
    public String deliveryDesc;
    public String deliveryId;
    public String deliveryTip;
    public String expectArrivalTime;
    public int isShowPhoneEntrance;
    public int riderArriveTime;
    public String riderId;
    public String riderImg;
    public double riderLat;
    public int riderLatestLeaveTime;
    public double riderLng;
    public String riderName;
    public String riderPhone;
    public int riderPhoneProtected;
    public String riderUid;
    public int status;
    public int vehicleType;
    public String vehicleTypeDesc;
    public int waitTime;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeliveryInfoEntity)) {
            return false;
        }
        DeliveryInfoEntity deliveryInfoEntity = (DeliveryInfoEntity) obj;
        if (this.riderPhoneProtected != deliveryInfoEntity.riderPhoneProtected || this.status != deliveryInfoEntity.status || this.riderArriveTime != deliveryInfoEntity.riderArriveTime || this.riderLatestLeaveTime != deliveryInfoEntity.riderLatestLeaveTime || this.waitTime != deliveryInfoEntity.waitTime || this.vehicleType != deliveryInfoEntity.vehicleType || Double.compare(deliveryInfoEntity.riderLat, this.riderLat) != 0 || Double.compare(deliveryInfoEntity.riderLng, this.riderLng) != 0 || this.isShowPhoneEntrance != deliveryInfoEntity.isShowPhoneEntrance) {
            return false;
        }
        String str = this.riderUid;
        if (str == null ? deliveryInfoEntity.riderUid != null : !str.equals(deliveryInfoEntity.riderUid)) {
            return false;
        }
        String str2 = this.deliveryId;
        if (str2 == null ? deliveryInfoEntity.deliveryId != null : !str2.equals(deliveryInfoEntity.deliveryId)) {
            return false;
        }
        String str3 = this.riderId;
        if (str3 == null ? deliveryInfoEntity.riderId != null : !str3.equals(deliveryInfoEntity.riderId)) {
            return false;
        }
        String str4 = this.riderName;
        if (str4 == null ? deliveryInfoEntity.riderName != null : !str4.equals(deliveryInfoEntity.riderName)) {
            return false;
        }
        String str5 = this.riderPhone;
        if (str5 == null ? deliveryInfoEntity.riderPhone != null : !str5.equals(deliveryInfoEntity.riderPhone)) {
            return false;
        }
        String str6 = this.expectArrivalTime;
        if (str6 == null ? deliveryInfoEntity.expectArrivalTime != null : !str6.equals(deliveryInfoEntity.expectArrivalTime)) {
            return false;
        }
        String str7 = this.riderImg;
        if (str7 == null ? deliveryInfoEntity.riderImg != null : !str7.equals(deliveryInfoEntity.riderImg)) {
            return false;
        }
        String str8 = this.deliveryDesc;
        if (str8 == null ? deliveryInfoEntity.deliveryDesc != null : !str8.equals(deliveryInfoEntity.deliveryDesc)) {
            return false;
        }
        String str9 = this.deliveryTip;
        if (str9 == null ? deliveryInfoEntity.deliveryTip != null : !str9.equals(deliveryInfoEntity.deliveryTip)) {
            return false;
        }
        String str10 = this.vehicleTypeDesc;
        String str11 = deliveryInfoEntity.vehicleTypeDesc;
        if (str10 != null) {
            return str10.equals(str11);
        }
        if (str11 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.riderUid;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.deliveryId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.riderId;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.riderName;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.riderPhone;
        int hashCode5 = (((hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.riderPhoneProtected) * 31;
        String str6 = this.expectArrivalTime;
        int hashCode6 = (((hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31) + this.status) * 31;
        String str7 = this.riderImg;
        int hashCode7 = (((((((hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31) + this.riderArriveTime) * 31) + this.riderLatestLeaveTime) * 31) + this.waitTime) * 31;
        String str8 = this.deliveryDesc;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.deliveryTip;
        int hashCode9 = (((hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31) + this.vehicleType) * 31;
        String str10 = this.vehicleTypeDesc;
        if (str10 != null) {
            i = str10.hashCode();
        }
        int i2 = hashCode9 + i;
        long doubleToLongBits = Double.doubleToLongBits(this.riderLat);
        long doubleToLongBits2 = Double.doubleToLongBits(this.riderLng);
        return (((((i2 * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + this.isShowPhoneEntrance;
    }

    public String toString() {
        return "DeliveryInfoEntity{riderUid='" + this.riderUid + '\'' + ", deliveryId='" + this.deliveryId + '\'' + ", riderId='" + this.riderId + '\'' + ", riderName='" + this.riderName + '\'' + ", riderPhone='" + this.riderPhone + '\'' + ", riderPhoneProtected=" + this.riderPhoneProtected + ", expectArrivalTime='" + this.expectArrivalTime + '\'' + ", status=" + this.status + ", riderImg='" + this.riderImg + '\'' + ", riderArriveTime=" + this.riderArriveTime + ", riderLatestLeaveTime=" + this.riderLatestLeaveTime + ", waitTime=" + this.waitTime + ", deliveryDesc='" + this.deliveryDesc + '\'' + ", deliveryTip='" + this.deliveryTip + '\'' + ", vehicleType=" + this.vehicleType + ", vehicleTypeDesc='" + this.vehicleTypeDesc + '\'' + ", riderLat=" + this.riderLat + ", riderLng=" + this.riderLng + ", isShowPhoneEntrance=" + this.isShowPhoneEntrance + '}';
    }
}
