package com.sdk.poibase.util;

import com.didi.map.global.component.departure.DepartureConstants;
import com.didi.sdk.address.address.entity.Address;
import com.didi.soda.customer.app.constant.Const;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/sdk/poibase/util/DestInfoUtil;", "", "()V", "getDestInfo", "", "data", "Lcom/didi/sdk/address/address/entity/Address;", "poi_base_lib_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: DestInfoUtil.kt */
public final class DestInfoUtil {
    public static final DestInfoUtil INSTANCE = new DestInfoUtil();

    private DestInfoUtil() {
    }

    public final String getDestInfo(Address address) {
        Intrinsics.checkParameterIsNotNull(address, "data");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("poi_id", address.poiId);
        jsonObject.addProperty("displayname", address.getDisplayName());
        jsonObject.addProperty("address", address.getAddress());
        jsonObject.addProperty(Const.H5Params.ADDRESSALL, address.getFullName());
        jsonObject.addProperty("lat", (Number) Double.valueOf(address.getLatitude()));
        jsonObject.addProperty("lng", (Number) Double.valueOf(address.getLongitude()));
        jsonObject.addProperty(DepartureConstants.SRCTAG, address.getSrcTag());
        jsonObject.addProperty("coordinate_type", address.coordinate_type);
        String jsonObject2 = jsonObject.toString();
        Intrinsics.checkExpressionValueIsNotNull(jsonObject2, "jsonObject.toString()");
        return jsonObject2;
    }
}
