package com.sdk.poibase.model.city;

import android.content.Context;
import com.google.gson.annotations.SerializedName;
import com.taxis99.R;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class RpcCityGroup implements Serializable {
    @SerializedName("bus_hot_cities")
    public ArrayList<RpcCity> busHotCities;
    @SerializedName("shunfengche_hot_cities")
    public ArrayList<RpcCity> carMateHotCities;
    @SerializedName("cities")
    public ArrayList<RpcCity> cities;
    @SerializedName("daijia_hot_cities")
    public ArrayList<RpcCity> driverHotCities;
    @SerializedName("kuaiche_hot_cities")
    public ArrayList<RpcCity> flashHotCities;
    @SerializedName("hktaxi_hot_cities")
    public ArrayList<RpcCity> hkTaxiHotCities;
    @SerializedName("name")
    public String name;
    @SerializedName("zhuanche_hot_cities")
    public ArrayList<RpcCity> premiumHotCities;
    @SerializedName("rentcar_hot_cities")
    public ArrayList<RpcCity> rentCarHotCities;
    @SerializedName("didi_hot_cities")
    public ArrayList<RpcCity> taxiHotCities;
    @SerializedName("twtaxi_hot_cities")
    public ArrayList<RpcCity> twTaxiHotCities;
    @SerializedName("wanliu_hot_cities")
    public ArrayList<RpcCity> wanliuHotCities;

    public String toString() {
        return "{name='" + this.name + '\'' + ", cities=" + this.cities + ", taxiHotCities=" + this.taxiHotCities + ", wanliuHotCities=" + this.wanliuHotCities + ", carMateHotCities=" + this.carMateHotCities + ", busHotCities=" + this.busHotCities + ", driverHotCities=" + this.driverHotCities + ", premiumHotCities=" + this.premiumHotCities + ", flashHotCities=" + this.flashHotCities + ", rentCarHotCities=" + this.rentCarHotCities + ", twTaxiHotCities=" + this.twTaxiHotCities + ", hkTaxiHotCities=" + this.hkTaxiHotCities + '}';
    }

    public RpcCityGroup getCityGroup(Context context, int i, boolean z, boolean z2) {
        if (context == null) {
            return null;
        }
        RpcCityGroup rpcCityGroup = new RpcCityGroup();
        rpcCityGroup.name = getName(context);
        if (!isHotGroup(context)) {
            ArrayList<RpcCity> arrayList = new ArrayList<>();
            ArrayList<RpcCity> arrayList2 = this.cities;
            if (arrayList2 != null && !arrayList2.isEmpty()) {
                Iterator<RpcCity> it = this.cities.iterator();
                while (it.hasNext()) {
                    RpcCity next = it.next();
                    if (next != null) {
                        if (z2) {
                            arrayList.add(next);
                        } else if (next.isOpenStatus(i)) {
                            arrayList.add(next);
                        }
                    }
                }
            }
            rpcCityGroup.cities = arrayList;
        } else if (z) {
            rpcCityGroup.cities = getHotCities();
        } else {
            rpcCityGroup.cities = getHotCities(i);
        }
        return rpcCityGroup;
    }

    public ArrayList<RpcCity> getHotCities() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList<RpcCity> arrayList = this.busHotCities;
        if (arrayList != null) {
            linkedHashSet.addAll(arrayList);
        }
        ArrayList<RpcCity> arrayList2 = this.carMateHotCities;
        if (arrayList2 != null) {
            linkedHashSet.addAll(arrayList2);
        }
        ArrayList<RpcCity> arrayList3 = this.driverHotCities;
        if (arrayList3 != null) {
            linkedHashSet.addAll(arrayList3);
        }
        ArrayList<RpcCity> arrayList4 = this.flashHotCities;
        if (arrayList4 != null) {
            linkedHashSet.addAll(arrayList4);
        }
        ArrayList<RpcCity> arrayList5 = this.taxiHotCities;
        if (arrayList5 != null) {
            linkedHashSet.addAll(arrayList5);
        }
        ArrayList<RpcCity> arrayList6 = this.premiumHotCities;
        if (arrayList6 != null) {
            linkedHashSet.addAll(arrayList6);
        }
        ArrayList<RpcCity> arrayList7 = this.wanliuHotCities;
        if (arrayList7 != null) {
            linkedHashSet.addAll(arrayList7);
        }
        ArrayList<RpcCity> arrayList8 = this.rentCarHotCities;
        if (arrayList8 != null) {
            linkedHashSet.addAll(arrayList8);
        }
        ArrayList<RpcCity> arrayList9 = this.twTaxiHotCities;
        if (arrayList9 != null) {
            linkedHashSet.addAll(arrayList9);
        }
        ArrayList<RpcCity> arrayList10 = this.hkTaxiHotCities;
        if (arrayList10 != null) {
            linkedHashSet.addAll(arrayList10);
        }
        ArrayList<RpcCity> arrayList11 = new ArrayList<>();
        arrayList11.addAll(linkedHashSet);
        return arrayList11;
    }

    public ArrayList<RpcCity> getHotCities(int i) {
        ArrayList<RpcCity> arrayList = new ArrayList<>();
        if (i == 270) {
            return this.rentCarHotCities;
        }
        if (i != 274) {
            if (i == 310) {
                return this.hkTaxiHotCities;
            }
            if (i == 362) {
                return this.twTaxiHotCities;
            }
            switch (i) {
                case 257:
                    return this.taxiHotCities;
                case 258:
                    return this.premiumHotCities;
                case 259:
                    return this.carMateHotCities;
                case 260:
                    return this.flashHotCities;
                case 261:
                    return this.driverHotCities;
                case 262:
                    break;
                default:
                    return arrayList;
            }
        }
        return this.busHotCities;
    }

    public String getName(Context context) {
        if (isHotGroup(context)) {
            return context.getString(R.string.base_one_address_search_hot_group_name_without_star);
        }
        return this.name;
    }

    public boolean isHotGroup(Context context) {
        if (context == null) {
            return false;
        }
        return context.getString(R.string.base_one_address_search_hot_group_name).equals(this.name);
    }
}
