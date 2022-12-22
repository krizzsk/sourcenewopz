package com.didi.soda.customer.blocks;

import android.content.Context;
import com.didi.foundation.sdk.utils.FileUtils;
import com.didi.soda.blocks.entity.Template;
import com.didi.soda.blocks.model.ComponentModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.sdk.BlocksEngine;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.tracker.BlocksOmegaHelpter;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/BlocksDowngradeHelper;", "", "scene", "", "(Ljava/lang/String;)V", "getScene", "()Ljava/lang/String;", "setScene", "generateModel", "Lcom/didi/soda/blocks/model/ComponentModel;", "dataJsonObject", "Lcom/google/gson/JsonObject;", "initDowngradeTemplate", "", "provideDowngradeModel", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BlocksDowngradeHelper.kt */
public final class BlocksDowngradeHelper {

    /* renamed from: a */
    private String f40547a;

    public BlocksDowngradeHelper(String str) {
        Intrinsics.checkNotNullParameter(str, "scene");
        this.f40547a = str;
    }

    public final String getScene() {
        return this.f40547a;
    }

    public final void setScene(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f40547a = str;
    }

    public final boolean initDowngradeTemplate() {
        String stringPlus = Intrinsics.stringPlus(this.f40547a, ".json");
        FileUtils fileUtils = FileUtils.INSTANCE;
        Context context = GlobalContext.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        try {
            Template template = (Template) new Gson().fromJson(fileUtils.getFormAssets(context, stringPlus), Template.class);
            if (template == null) {
                LogUtil.m29102e("BlocksDowngradeHelper.initDowngradeTemplate", Intrinsics.stringPlus("templateEntity is null which fileName is ", stringPlus));
                return false;
            }
            template.setTemplateId(this.f40547a);
            template.setVersion("2");
            BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).initTemplate(CollectionsKt.arrayListOf(template));
            return true;
        } catch (Exception unused) {
            LogUtil.m29102e("BlocksDowngradeHelper.initDowngradeTemplate", Intrinsics.stringPlus("templateEntity serialized failed which fileName is ", stringPlus));
            return false;
        }
    }

    public final ComponentModel provideDowngradeModel(JsonObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "dataJsonObject");
        if (BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).isTemplateIdEffective(this.f40547a)) {
            return generateModel(jsonObject);
        }
        if (initDowngradeTemplate()) {
            return generateModel(jsonObject);
        }
        return null;
    }

    public final ComponentModel generateModel(JsonObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "dataJsonObject");
        ComponentModel componentModel = new ComponentModel();
        componentModel.setDataModel(jsonObject);
        JsonElement jsonElement = jsonObject.get("data");
        JsonObject asJsonObject = jsonElement == null ? null : jsonElement.getAsJsonObject();
        if (asJsonObject == null) {
            BlocksOmegaHelpter blocksOmegaHelpter = BlocksOmegaHelpter.INSTANCE;
            JsonElement jsonElement2 = jsonObject.get("data");
            String jsonElement3 = jsonElement2 == null ? null : jsonElement2.toString();
            if (jsonElement3 == null) {
                jsonElement3 = "";
            }
            blocksOmegaHelpter.trackBusinessDataError(jsonElement3);
            return null;
        }
        componentModel.setWidgetNodeModel(BlocksEngine.buildWidgetNode$default(BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null), this.f40547a, asJsonObject, componentModel, (IBlockScope) null, 8, (Object) null));
        componentModel.setTemplateId(this.f40547a);
        return componentModel;
    }
}
