package com.didi.soda.home.topgun.component.feed;

import com.didi.soda.customer.foundation.rpc.entity.BannerEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeModuleEntity;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a\u0012\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n*\u00020\u0006\u001a\f\u0010\u000b\u001a\u0004\u0018\u00010\f*\u00020\u0006\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\r"}, mo175978d2 = {"KEY_FILTER", "", "SPECIAL_BANNER", "buildFilterObject", "Lcom/google/gson/JsonObject;", "data", "Lcom/didi/soda/customer/foundation/rpc/entity/topgun/HomeEntity;", "pageIndex", "", "getFeedDistributor", "", "getSpecialBanner", "Lcom/didi/soda/customer/foundation/rpc/entity/BannerEntity;", "customer-aar_brazilEmbedRelease"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeExt.kt */
public final class HomeExtKt {
    public static final String KEY_FILTER = "filterList";
    public static final String SPECIAL_BANNER = "701";

    public static final List<JsonObject> getFeedDistributor(HomeEntity homeEntity) {
        List<JsonObject> mJsonComponentList;
        Intrinsics.checkNotNullParameter(homeEntity, "<this>");
        HomeModuleEntity mDistributorEntity = homeEntity.getMDistributorEntity();
        if (mDistributorEntity == null || (mJsonComponentList = mDistributorEntity.getMJsonComponentList()) == null) {
            return null;
        }
        Collection arrayList = new ArrayList();
        for (Object next : mJsonComponentList) {
            JsonObject jsonObject = (JsonObject) next;
            if (jsonObject.has("type") && !Intrinsics.areEqual((Object) jsonObject.get("type").getAsString(), (Object) SPECIAL_BANNER)) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    public static final BannerEntity getSpecialBanner(HomeEntity homeEntity) {
        JsonObject jsonObject;
        JsonElement jsonElement;
        List<JsonObject> mJsonComponentList;
        Object obj;
        boolean z;
        Intrinsics.checkNotNullParameter(homeEntity, "<this>");
        HomeModuleEntity mDistributorEntity = homeEntity.getMDistributorEntity();
        if (mDistributorEntity == null || (mJsonComponentList = mDistributorEntity.getMJsonComponentList()) == null) {
            jsonObject = null;
        } else {
            Iterator it = mJsonComponentList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                JsonObject jsonObject2 = (JsonObject) obj;
                if (!jsonObject2.has("type") || !Intrinsics.areEqual((Object) jsonObject2.get("type").getAsString(), (Object) SPECIAL_BANNER)) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            jsonObject = (JsonObject) obj;
        }
        if (!(jsonObject == null || (jsonElement = jsonObject.get("data")) == null)) {
            try {
                ComponentEntity componentEntity = (ComponentEntity) GsonUtil.fromJson(jsonElement, (Type) ComponentEntity.class);
                if (componentEntity.mBannerList != null && componentEntity.mBannerList.size() > 0) {
                    return componentEntity.mBannerList.get(0);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static final JsonObject buildFilterObject(HomeEntity homeEntity, int i) {
        JsonElement jsonElement;
        Intrinsics.checkNotNullParameter(homeEntity, "data");
        if (i > 0) {
            return null;
        }
        HomeModuleEntity mFeedEntity = homeEntity.getMFeedEntity();
        if (mFeedEntity == null || (jsonElement = mFeedEntity.getMFilterList()) == null || jsonElement.isJsonNull()) {
            jsonElement = null;
        }
        JsonArray jsonArray = jsonElement instanceof JsonArray ? (JsonArray) jsonElement : null;
        if (jsonArray == null) {
            return null;
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.add(KEY_FILTER, jsonArray);
        jsonObject.addProperty("type", "filter");
        Unit unit = Unit.INSTANCE;
        return jsonObject;
    }
}
