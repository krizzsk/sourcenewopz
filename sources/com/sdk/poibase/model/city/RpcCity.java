package com.sdk.poibase.model.city;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.sdk.poibase.ListItemBase;
import com.taxis99.R;
import java.io.Serializable;

public class RpcCity implements ListItemBase, Serializable {
    public static final int STATUS_NOT_OPEN = 0;
    public static final int STATUS_OPEN = 1;
    @SerializedName("cityid")
    public int cityId;
    public String cityNamePinyin;
    @SerializedName("coordinate_type")
    public String coordinate_type;
    public String group;
    @SerializedName("lat")
    public float lat;
    @SerializedName("lng")
    public float lng;
    @SerializedName("name")
    public String name;
    @SerializedName("open_bus")
    public int openBus;
    @SerializedName("open_shunfengche")
    public int openCarMate;
    @SerializedName("open_daijia")
    public int openDriverService;
    @SerializedName("open_firstclass")
    public int openFirstClass;
    @SerializedName("open_kuaiche")
    public int openFlash;
    @SerializedName("open_hktaxi")
    public int openHkTaxi;
    @SerializedName("open_zhuanche")
    public int openPremium;
    @SerializedName("open_rentcar")
    public int openRentCar;
    @SerializedName("open_shijia")
    public int openShijia;
    @SerializedName("open_didi")
    public int openTaxi;
    @SerializedName("open_twtaxi")
    public int openTwTaxi;
    @SerializedName("open_unitaxi")
    public int openUniTaxi;
    @SerializedName("open_wanliu")
    public int openWanliu;
    @SerializedName("tags")
    public String tags;

    public int getLayoutId() {
        return R.layout.base_one_address_search_city_item;
    }

    public String toString() {
        return "{lng=" + this.lng + ", lat=" + this.lat + ", cityId=" + this.cityId + ", name='" + this.name + '\'' + ", tags='" + this.tags + '\'' + ", coordinate_type='" + this.coordinate_type + '\'' + ", cityNamePinyin='" + this.cityNamePinyin + '\'' + ", group='" + this.group + '\'' + ", openTaxi=" + this.openTaxi + ", openWanliu=" + this.openWanliu + ", openCarMate=" + this.openCarMate + ", openBus=" + this.openBus + ", openDriverService=" + this.openDriverService + ", openShijia=" + this.openShijia + ", openPremium=" + this.openPremium + ", openFlash=" + this.openFlash + ", openRentCar=" + this.openRentCar + ", openFirstClass=" + this.openFirstClass + ", openUniTaxi=" + this.openUniTaxi + ", openTwTaxi=" + this.openTwTaxi + ", openHkTaxi=" + this.openHkTaxi + '}';
    }

    public void splitTags() {
        this.cityNamePinyin = this.tags.split(",")[0];
    }

    public boolean contains(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String str2 = this.name;
        if (str2 != null && str2.contains(str)) {
            return true;
        }
        String str3 = this.cityNamePinyin;
        if (str3 == null || !str3.toUpperCase().startsWith(str.toUpperCase())) {
            return false;
        }
        return true;
    }

    public boolean isOpenStatus(int i) {
        int i2;
        if (i != 270) {
            if (i != 274) {
                if (i == 276) {
                    i2 = this.openFirstClass;
                } else if (i == 307) {
                    i2 = this.openUniTaxi;
                } else if (i == 310) {
                    i2 = this.openHkTaxi;
                } else if (i != 362) {
                    switch (i) {
                        case 257:
                            i2 = this.openTaxi;
                            break;
                        case 258:
                            i2 = this.openPremium;
                            break;
                        case 259:
                            i2 = this.openCarMate;
                            break;
                        case 260:
                            i2 = this.openFlash;
                            break;
                        case 261:
                            i2 = this.openDriverService;
                            break;
                        case 262:
                            break;
                        default:
                            i2 = 1;
                            break;
                    }
                } else {
                    i2 = this.openTwTaxi;
                }
            }
            i2 = this.openBus;
        } else {
            i2 = this.openRentCar;
        }
        if (i2 == 1) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RpcCity rpcCity = (RpcCity) obj;
        if (this.cityId != rpcCity.cityId) {
            return false;
        }
        String str = this.name;
        if (str == null ? rpcCity.name != null : !str.equals(rpcCity.name)) {
            return false;
        }
        String str2 = this.group;
        String str3 = rpcCity.group;
        if (str2 != null) {
            return str2.equals(str3);
        }
        if (str3 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = this.cityId * 31;
        String str = this.name;
        return i + (str != null ? str.hashCode() : 0);
    }
}
