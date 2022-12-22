package com.didi.soda.business.manager;

import android.text.TextUtils;
import com.didi.soda.blocks.entity.Template;
import com.didi.soda.blocks.sdk.BlocksEngine;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.tracker.BlocksOmegaHelpter;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/soda/business/manager/BusinessDyDataAssist;", "", "()V", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BusinessDyDataAssist.kt */
public final class BusinessDyDataAssist {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @JvmStatic
    public static final void initTemplate(List<JsonObject> list) {
        Companion.initTemplate(list);
    }

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0007¨\u0006\b"}, mo175978d2 = {"Lcom/didi/soda/business/manager/BusinessDyDataAssist$Companion;", "", "()V", "initTemplate", "", "mTemplates", "", "Lcom/google/gson/JsonObject;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BusinessDyDataAssist.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final void initTemplate(List<JsonObject> list) {
            Template template;
            Collection collection = list;
            if (collection == null || collection.isEmpty()) {
                LogUtil.m29102e("BusinessDyDataAssist.initTemplate", "Template is null");
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (JsonObject jsonObject : list) {
                JsonElement jsonElement = jsonObject.get("tmplId");
                String asString = jsonElement == null ? null : jsonElement.getAsString();
                if (TextUtils.isEmpty(asString)) {
                    BlocksOmegaHelpter blocksOmegaHelpter = BlocksOmegaHelpter.INSTANCE;
                    String jsonObject2 = jsonObject.toString();
                    Intrinsics.checkNotNullExpressionValue(jsonObject2, "it.toString()");
                    blocksOmegaHelpter.trackTemplateWithoutId(jsonObject2);
                } else {
                    JsonElement jsonElement2 = jsonObject.get("content");
                    if (jsonElement2 == null || jsonElement2.isJsonNull()) {
                        LogUtil.m29102e("BusinessDyDataAssist.initTemplate", Intrinsics.stringPlus("Template without any content which tmplId is ", asString));
                    } else {
                        try {
                            template = (Template) new Gson().fromJson(jsonElement2.getAsString(), Template.class);
                        } catch (Exception unused) {
                            LogUtil.m29102e("BusinessDyDataAssist.initTemplate", "templateEntity serialized failed which tmplId is " + asString + " and content is " + jsonElement2.getAsString());
                            template = null;
                        }
                        if (template == null) {
                            LogUtil.m29102e("BusinessDyDataAssist.initTemplate", Intrinsics.stringPlus("templateEntity is null which tmplId is ", asString));
                        } else {
                            template.setTemplateId(asString);
                            arrayList.add(template);
                        }
                    }
                }
            }
            BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).initTemplate(arrayList);
        }
    }
}
