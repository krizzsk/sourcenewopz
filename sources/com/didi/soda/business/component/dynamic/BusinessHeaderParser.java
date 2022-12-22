package com.didi.soda.business.component.dynamic;

import android.content.Context;
import android.text.TextUtils;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.blocks.model.ComponentModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.sdk.BlocksEngine;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.blocks.BlocksDowngradeHelper;
import com.didi.soda.customer.foundation.tracker.BlocksOmegaHelpter;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/soda/business/component/dynamic/BusinessHeaderParser;", "Lcom/didi/soda/business/component/dynamic/BusinessParser;", "()V", "parser", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "context", "Landroid/content/Context;", "compJson", "Lcom/google/gson/JsonObject;", "payload", "Lcom/didi/soda/business/component/dynamic/BusinessPayload;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BusinessHeaderParser.kt */
public final class BusinessHeaderParser extends BusinessParser {
    public RecyclerModel parser(Context context, JsonObject jsonObject, BusinessPayload businessPayload) {
        Intrinsics.checkNotNullParameter(jsonObject, "compJson");
        BlocksDowngradeHelper blocksDowngradeHelper = new BlocksDowngradeHelper(BlocksConst.DOWNGRADE_SCENE_BUSINESS_HEADER);
        ComponentModel componentModel = new ComponentModel();
        componentModel.setDataModel(jsonObject);
        JsonElement jsonElement = jsonObject.get("componentV2");
        JsonObject asJsonObject = jsonElement == null ? null : jsonElement.getAsJsonObject();
        if (asJsonObject == null) {
            return blocksDowngradeHelper.provideDowngradeModel(jsonObject);
        }
        JsonElement jsonElement2 = asJsonObject.get("tmplId");
        String asString = jsonElement2 == null ? null : jsonElement2.getAsString();
        CharSequence charSequence = asString;
        if (TextUtils.isEmpty(charSequence)) {
            return blocksDowngradeHelper.provideDowngradeModel(jsonObject);
        }
        JsonElement jsonElement3 = jsonObject.get("data");
        JsonObject asJsonObject2 = jsonElement3 == null ? null : jsonElement3.getAsJsonObject();
        if (asJsonObject2 == null) {
            BlocksOmegaHelpter blocksOmegaHelpter = BlocksOmegaHelpter.INSTANCE;
            JsonElement jsonElement4 = jsonObject.get("data");
            String jsonElement5 = jsonElement4 == null ? null : jsonElement4.toString();
            if (jsonElement5 == null) {
                jsonElement5 = "";
            }
            blocksOmegaHelpter.trackBusinessDataError(jsonElement5);
            return null;
        }
        if (!TextUtils.isEmpty(charSequence)) {
            BlocksEngine instance$default = BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null);
            Intrinsics.checkNotNull(asString);
            componentModel.setWidgetNodeModel(BlocksEngine.buildWidgetNode$default(instance$default, asString, asJsonObject2, componentModel, (IBlockScope) null, 8, (Object) null));
        }
        componentModel.setTemplateId(asString);
        return componentModel;
    }
}
