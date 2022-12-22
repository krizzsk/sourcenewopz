package com.didi.sdk.misconfig.model;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class CarGrop implements Serializable {
    private String a_T = "";
    @SerializedName("submenuRange")
    List<CarInfo> carInfo;
    private String defaultCarId;
    private int defaultCarIndex;
    private String groupIcon;
    private String groupIconActived;
    private int groupId;
    private String groupType;
    private int iconFlipStatus;
    private String link;
    private String linkText;
    private String mapIcon;
    private String name;
    private String navTag;
    private int openStatus;
    private String schema;
    private WarmupActivity warmupActivity;

    public String getName() {
        return this.name;
    }

    public int getGroupId() {
        return this.groupId;
    }

    public String getLink() {
        return this.link;
    }

    public String getLinkText() {
        return this.linkText;
    }

    public int getIconFlipStatus() {
        return this.iconFlipStatus;
    }

    public String getMapIcon() {
        return this.mapIcon;
    }

    public String getDefaultCarId() {
        return this.defaultCarId;
    }

    public List<CarInfo> getCarInfo() {
        return this.carInfo;
    }

    public void setCarInfo(List<CarInfo> list) {
        this.carInfo = list;
    }

    public int getDefaultCarIndex() {
        return this.defaultCarIndex;
    }

    public void setDefaultCarIndex(int i) {
        this.defaultCarIndex = i;
    }

    public void setIconFlipStatus(int i) {
        this.iconFlipStatus = i;
    }

    public void setMapIcon(String str) {
        this.mapIcon = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setGroupId(int i) {
        this.groupId = i;
    }

    @Deprecated
    public int getOpenStatus() {
        return this.openStatus;
    }

    public void setOpenStatus(int i) {
        this.openStatus = i;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public void setLinkText(String str) {
        this.linkText = str;
    }

    public WarmupActivity getWarmupActivity() {
        return this.warmupActivity;
    }

    public void setWarmupActivity(WarmupActivity warmupActivity2) {
        this.warmupActivity = warmupActivity2;
    }

    public String getGroupType() {
        return this.groupType;
    }

    public void setGroupType(String str) {
        this.groupType = str;
    }

    public String getNavTag() {
        String str = this.navTag;
        if (str == null || TextUtils.isEmpty(str)) {
            return this.groupType;
        }
        return this.navTag;
    }

    public void setNavTag(String str) {
        this.navTag = str;
    }

    public String getSchema() {
        return this.schema;
    }

    public void setSchema(String str) {
        this.schema = str;
    }

    public String getA_T() {
        return this.a_T;
    }

    public void setA_T(String str) {
        this.a_T = str;
    }

    public String getGroupIcon() {
        return this.groupIcon;
    }

    public void setGroupIcon(String str) {
        this.groupIcon = str;
    }

    public String getGroupIconActived() {
        return this.groupIconActived;
    }

    public void setGroupIconActived(String str) {
        this.groupIconActived = str;
    }

    public void setDefaultCarId(String str) {
        this.defaultCarId = str;
    }

    public String toString() {
        return "CarGrop{name='" + this.name + '\'' + ", groupId=" + this.groupId + ", openStatus=" + this.openStatus + ", link='" + this.link + '\'' + ", linkText='" + this.linkText + '\'' + ", warmupActivity=" + this.warmupActivity + ", iconFlipStatus=" + this.iconFlipStatus + ", mapIcon='" + this.mapIcon + '\'' + ", defaultCarId='" + this.defaultCarId + '\'' + ", defaultCarIndex=" + this.defaultCarIndex + ", carInfo=" + this.carInfo + '}';
    }
}
