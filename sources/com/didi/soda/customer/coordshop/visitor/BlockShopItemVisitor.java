package com.didi.soda.customer.coordshop.visitor;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.blocks.model.ComponentModel;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.coordshop.CollectedShopInfo;
import com.didi.soda.customer.coordshop.ModelVisitor;
import com.didi.soda.customer.coordshop.ModelVisitorType;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.util.CustomerExtentionKt;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000eH\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/soda/customer/coordshop/visitor/BlockShopItemVisitor;", "Lcom/didi/soda/customer/coordshop/ModelVisitor;", "()V", "type", "Lcom/didi/soda/customer/coordshop/ModelVisitorType;", "getType", "()Lcom/didi/soda/customer/coordshop/ModelVisitorType;", "visit", "Lcom/didi/soda/customer/coordshop/CollectedShopInfo;", "indexInRv", "", "model", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "visitBusinessInNearBy", "Lcom/didi/soda/blocks/model/ComponentModel;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BlockShopItemVisitor.kt */
public final class BlockShopItemVisitor implements ModelVisitor {
    public ModelVisitorType getType() {
        return ModelVisitorType.Home;
    }

    public CollectedShopInfo visit(int i, RecyclerModel recyclerModel) {
        JsonElement jsonElement;
        Intrinsics.checkNotNullParameter(recyclerModel, "model");
        if (recyclerModel instanceof ComponentModel) {
            ComponentModel componentModel = (ComponentModel) recyclerModel;
            Object dataModel = componentModel.getDataModel();
            JsonObject jsonObject = dataModel instanceof JsonObject ? (JsonObject) dataModel : null;
            if (Intrinsics.areEqual((Object) (jsonObject == null || (jsonElement = jsonObject.get("type")) == null) ? null : jsonElement.getAsString(), (Object) "1")) {
                return m29044a(i, componentModel);
            }
        }
        return null;
    }

    /* renamed from: a */
    private final CollectedShopInfo m29044a(int i, ComponentModel componentModel) {
        int i2;
        HashMap context;
        JsonElement jsonElement;
        JsonElement jsonElement2;
        JsonObject asJsonObject;
        JsonElement jsonElement3;
        Object dataModel = componentModel.getDataModel();
        Integer num = null;
        JsonObject jsonObject = dataModel instanceof JsonObject ? (JsonObject) dataModel : null;
        String asString = (jsonObject == null || (jsonElement2 = jsonObject.get("data")) == null || (asJsonObject = jsonElement2.getAsJsonObject()) == null || (jsonElement3 = asJsonObject.get("shopId")) == null) ? null : jsonElement3.getAsString();
        Object dataModel2 = componentModel.getDataModel();
        JsonObject jsonObject2 = dataModel2 instanceof JsonObject ? (JsonObject) dataModel2 : null;
        Integer valueOf = (jsonObject2 == null || (jsonElement = jsonObject2.get("position")) == null) ? null : Integer.valueOf(jsonElement.getAsInt());
        WidgetNodeModel widgetNodeModel = componentModel.getWidgetNodeModel();
        Object obj = (widgetNodeModel == null || (context = widgetNodeModel.getContext()) == null) ? null : context.get(BlocksConst.BLOCK_PARAM_PAGE_INDEX);
        if (obj instanceof Integer) {
            num = (Integer) obj;
        }
        CharSequence charSequence = asString;
        if ((charSequence == null || charSequence.length() == 0) || valueOf == null || num == null) {
            OmegaTracker.Builder addEventParam = OmegaTracker.Builder.create(EventConst.Home.SAILING_C_X_HOME_COORD_ERROR).addEventParam("error_type", 2);
            addEventParam.addEventParam("error_msg", "协同店铺解析模版配置化的店铺数据异常!!! shopId = " + asString + " position = " + valueOf + " pageNo = " + num).build().track();
            CustomerExtentionKt.safeThrow("协同店铺解析模版配置化的店铺数据异常!!! shopId = " + asString + " position = " + valueOf + " pageNo = " + num);
        }
        if (asString == null) {
            asString = "";
        }
        int i3 = -1;
        if (valueOf == null) {
            i2 = -1;
        } else {
            i2 = valueOf.intValue();
        }
        if (num != null) {
            i3 = num.intValue();
        }
        return new CollectedShopInfo(asString, i2, i3, i);
    }
}
