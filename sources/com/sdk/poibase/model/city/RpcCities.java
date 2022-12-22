package com.sdk.poibase.model.city;

import android.content.Context;
import com.google.gson.annotations.SerializedName;
import com.sdk.poibase.model.HttpResultBase;
import java.util.ArrayList;
import java.util.Iterator;

public class RpcCities extends HttpResultBase {
    @SerializedName("groups")
    public ArrayList<RpcCityGroup> groups;
    @SerializedName("version")
    public int version;

    public String toString() {
        return "{errno=" + this.errno + ", version=" + this.version + ", groups=" + this.groups + '}';
    }

    public ArrayList<RpcCity> getCities(Context context, int i, boolean z, boolean z2) {
        ArrayList<RpcCityGroup> arrayList = this.groups;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        RpcCities rpcCities = new RpcCities();
        rpcCities.groups = new ArrayList<>();
        Iterator<RpcCityGroup> it = this.groups.iterator();
        while (it.hasNext()) {
            RpcCityGroup next = it.next();
            if (next != null) {
                rpcCities.groups.add(next.getCityGroup(context, i, z, z2));
            }
        }
        return rpcCities.getCities(context);
    }

    public ArrayList<RpcCity> getCities(Context context) {
        ArrayList<RpcCityGroup> arrayList = this.groups;
        if (arrayList == null || arrayList.isEmpty() || context == null) {
            return null;
        }
        ArrayList<RpcCity> arrayList2 = new ArrayList<>();
        Iterator<RpcCityGroup> it = this.groups.iterator();
        while (it.hasNext()) {
            RpcCityGroup next = it.next();
            if (!(next == null || next.cities == null || next.cities.isEmpty())) {
                Iterator<RpcCity> it2 = next.cities.iterator();
                while (it2.hasNext()) {
                    RpcCity next2 = it2.next();
                    if (next2 != null) {
                        next2.group = next.getName(context);
                        next2.splitTags();
                        arrayList2.add(next2);
                    }
                }
            }
        }
        return arrayList2;
    }
}
