package com.didi.map.global.component.departure.model;

import com.google.gson.annotations.SerializedName;
import com.sdk.poibase.model.RpcPoi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AirPortPickUpModel {
    @SerializedName("base_area_info")
    public BaseAreaInfo baseAreaInfo;
    public List<Result> result;

    public static class AreaInfo {

        /* renamed from: id */
        public String f25173id;
        public String name;
    }

    public static class BaseAreaInfo {
        public String name;
    }

    public static class Result {
        @SerializedName("area_info")
        public AreaInfo areaInfo;
        @SerializedName("pick_points")
        public ArrayList<RpcPoi> pickPoints;
    }

    public Result whichResult(RpcPoi rpcPoi) {
        if (!(rpcPoi == null || rpcPoi.base_info == null || rpcPoi.extend_info == null)) {
            for (Result next : this.result) {
                Iterator<RpcPoi> it = next.pickPoints.iterator();
                while (true) {
                    if (it.hasNext()) {
                        RpcPoi next2 = it.next();
                        if (next2 != null && next2.base_info != null && next2.base_info.poi_id != null && next2.base_info.poi_id.equals(rpcPoi.base_info.poi_id)) {
                            return next;
                        }
                    }
                }
            }
        }
        return null;
    }
}
