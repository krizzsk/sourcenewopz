package com.didi.soda.datasource.parser.impl;

import android.content.Context;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.customer.foundation.rpc.entity.OrderInfoEntity;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.datasource.parser.FeedParser;
import com.didi.soda.datasource.parser.FeedPayload;
import com.didi.soda.datasource.parser.ParserMeta;
import com.didi.soda.home.topgun.binder.model.HomeOrderCardRvModel;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerOrderManager;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/soda/datasource/parser/impl/FeedOrderCardParser;", "Lcom/didi/soda/datasource/parser/FeedParser;", "()V", "parse", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "context", "Landroid/content/Context;", "compJson", "Lcom/google/gson/JsonObject;", "payload", "Lcom/didi/soda/datasource/parser/FeedPayload;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@ParserMeta(type = {"600"})
/* compiled from: FeedOrderCardParser.kt */
public final class FeedOrderCardParser extends FeedParser {
    public RecyclerModel parse(Context context, JsonObject jsonObject, FeedPayload feedPayload) {
        int i;
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(jsonObject, "compJson");
        Intrinsics.checkNotNullParameter(feedPayload, "payload");
        HomeOrderCardRvModel homeOrderCardRvModel = new HomeOrderCardRvModel();
        try {
            JsonElement jsonElement = jsonObject.get("data");
            if (jsonElement == null) {
                return homeOrderCardRvModel;
            }
            OrderInfoEntity orderInfoEntity = (OrderInfoEntity) GsonUtil.fromJson(jsonElement, (Type) OrderInfoEntity.class);
            if (orderInfoEntity == null || (str = orderInfoEntity.unfinishOrderIds) == null) {
                i = 1;
            } else {
                CharSequence charSequence = str;
                if (charSequence.length() > 0) {
                    ((ICustomerOrderManager) CustomerManagerLoader.loadManager(ICustomerOrderManager.class)).updateOrder2Monitor(str, 2);
                }
                i = StringsKt.split$default(charSequence, new String[]{","}, false, 0, 6, (Object) null).size();
            }
            HomeOrderCardRvModel convertHomeOrderStatus = HomeOrderCardRvModel.convertHomeOrderStatus(CollectionsKt.arrayListOf(orderInfoEntity), i);
            Intrinsics.checkNotNullExpressionValue(convertHomeOrderStatus, "convertHomeOrderStatus(a…yListOf(entity),orderNum)");
            return convertHomeOrderStatus;
        } catch (Exception unused) {
            return homeOrderCardRvModel;
        }
    }
}
