package com.didi.soda.customer.foundation.rpc.entity;

import com.didi.soda.business.manager.BusinessDataHelper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "componentJson", "Lcom/google/gson/JsonObject;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SearchResultEntity.kt */
final class SearchResultEntity$operateNum$predicate$1 extends Lambda implements Function1<JsonObject, Boolean> {
    public static final SearchResultEntity$operateNum$predicate$1 INSTANCE = new SearchResultEntity$operateNum$predicate$1();

    SearchResultEntity$operateNum$predicate$1() {
        super(1);
    }

    public final Boolean invoke(JsonObject jsonObject) {
        JsonObject asJsonObject;
        JsonElement jsonElement;
        Intrinsics.checkNotNullParameter(jsonObject, "componentJson");
        JsonElement jsonElement2 = jsonObject.get("data");
        Integer num = null;
        if (!(jsonElement2 == null || (asJsonObject = jsonElement2.getAsJsonObject()) == null || (jsonElement = asJsonObject.get("cShopStatus")) == null)) {
            num = Integer.valueOf(jsonElement.getAsInt());
        }
        if (num == null) {
            return false;
        }
        return Boolean.valueOf(BusinessDataHelper.checkBusinessStatusNormal(num.intValue()));
    }
}
