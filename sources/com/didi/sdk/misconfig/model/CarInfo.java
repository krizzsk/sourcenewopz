package com.didi.sdk.misconfig.model;

import com.didi.sdk.util.SidConverter;
import java.io.Serializable;

public class CarInfo implements Serializable {
    private String businessId;
    private int businessNumId;
    private String carIcon;
    private String carId = "";
    private int carLevel;
    private int carpoolOrderScene = -1;
    private int comboType;
    private String mapIcon;
    private String name;
    private String subTitle;

    public String getName() {
        return this.name;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public int getCarLevel() {
        return this.carLevel;
    }

    public String getCarId() {
        return this.carId;
    }

    public String getBusinessId() {
        return this.businessId;
    }

    public int getBusinessNumId() {
        return this.businessNumId;
    }

    public int getComboType() {
        return this.comboType;
    }

    public String getMapIcon() {
        return this.mapIcon;
    }

    public String getCarIcon() {
        return this.carIcon;
    }

    public void setMapIcon(String str) {
        this.mapIcon = str;
    }

    public void setCarIcon(String str) {
        this.carIcon = str;
    }

    public int getCarpoolOrderScene() {
        this.carpoolOrderScene = -1;
        if (SidConverter.SID_CARPOOL.equals(this.carId)) {
            this.carpoolOrderScene = 0;
        } else if ("carpool-twoPrice".equals(this.carId)) {
            this.carpoolOrderScene = 1;
        } else if ("carpool-matchToGo".equals(this.carId)) {
            this.carpoolOrderScene = 2;
        } else if ("carpool-unmatchDiscount".equals(this.carId)) {
            this.carpoolOrderScene = 3;
        }
        return this.carpoolOrderScene;
    }

    public void setCarLevel(int i) {
        this.carLevel = i;
    }

    public void setCarId(String str) {
        this.carId = str;
    }

    public void setBusinessId(String str) {
        this.businessId = str;
    }

    public void setBusinessNumId(int i) {
        this.businessNumId = i;
    }

    public void setComboType(int i) {
        this.comboType = i;
    }

    public boolean isOpenTwoPrice() {
        return "carpool-twoPrice".equals(this.carId);
    }

    public String toString() {
        return "CarInfo{name='" + this.name + '\'' + ", subTitle='" + this.subTitle + '\'' + ", carLevel=" + this.carLevel + ", carId='" + this.carId + '\'' + ", businessId='" + this.businessId + '\'' + ", businessNumId=" + this.businessNumId + ", comboType=" + this.comboType + ", mapIcon='" + this.mapIcon + '\'' + ", carIcon='" + this.carIcon + '\'' + '}';
    }
}
