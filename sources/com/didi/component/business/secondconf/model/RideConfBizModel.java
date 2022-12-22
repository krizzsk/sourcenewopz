package com.didi.component.business.secondconf.model;

import java.io.Serializable;

public class RideConfBizModel implements Serializable {
    private String businessId;
    private int businessNumId;
    private String carId;
    private int carLevel;
    private int comboType;
    private String mapIcon;
    private String name;

    public String getBusinessId() {
        return this.businessId;
    }

    public int getBusinessNumId() {
        return this.businessNumId;
    }

    public String getCarId() {
        return this.carId;
    }

    public int getCarLevel() {
        return this.carLevel;
    }

    public int getComboType() {
        return this.comboType;
    }

    public String getMapIcon() {
        return this.mapIcon;
    }

    public String getName() {
        return this.name;
    }
}
