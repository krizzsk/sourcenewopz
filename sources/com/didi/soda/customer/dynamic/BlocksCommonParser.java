package com.didi.soda.customer.dynamic;

import android.content.Context;
import android.text.TextUtils;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.blocks.model.ComponentModel;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.sdk.BlocksEngine;
import com.didi.soda.customer.foundation.rpc.entity.TemplateTagEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity;
import com.didi.soda.customer.foundation.tracker.BlocksOmegaHelpter;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/soda/customer/dynamic/BlocksCommonParser;", "", "()V", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BlocksCommonParser.kt */
public final class BlocksCommonParser {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @JvmStatic
    public static final boolean isBlockType(JsonObject jsonObject) {
        return Companion.isBlockType(jsonObject);
    }

    @JvmStatic
    public static final RecyclerModel parse(Context context, JsonObject jsonObject, IBlockScope iBlockScope) {
        return Companion.parse(context, jsonObject, iBlockScope);
    }

    @JvmStatic
    public static final RecyclerModel parseExceptWidgetNodeModel(Context context, JsonObject jsonObject, IBlockScope iBlockScope) {
        return Companion.parseExceptWidgetNodeModel(context, jsonObject, iBlockScope);
    }

    @JvmStatic
    public static final ComponentModel parseExceptWidgetNodeModelComponent(Context context, JsonObject jsonObject, IBlockScope iBlockScope) {
        return Companion.parseExceptWidgetNodeModelComponent(context, jsonObject, iBlockScope);
    }

    @JvmStatic
    public static final WidgetNodeModel parseWidgetNode(JsonObject jsonObject, ComponentModel componentModel, IBlockScope iBlockScope) {
        return Companion.parseWidgetNode(jsonObject, componentModel, iBlockScope);
    }

    @Metadata(mo175977d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J$\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fJ$\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J$\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0018\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fJ\"\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\fH\u0007¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/soda/customer/dynamic/BlocksCommonParser$Companion;", "", "()V", "isBlockType", "", "componentJsonObject", "Lcom/google/gson/JsonObject;", "parse", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "context", "Landroid/content/Context;", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "componentEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/topgun/ComponentEntity;", "parseExceptWidgetNodeModel", "parseExceptWidgetNodeModelComponent", "Lcom/didi/soda/blocks/model/ComponentModel;", "parseHeader", "parseWidgetNode", "Lcom/didi/soda/blocks/model/WidgetNodeModel;", "componentModel", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BlocksCommonParser.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final RecyclerModel parse(Context context, JsonObject jsonObject, IBlockScope iBlockScope) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(jsonObject, "componentJsonObject");
            ComponentModel componentModel = new ComponentModel();
            componentModel.setDataModel(jsonObject);
            JsonElement jsonElement = jsonObject.get("componentV2");
            JsonObject asJsonObject = jsonElement == null ? null : jsonElement.getAsJsonObject();
            if (asJsonObject == null) {
                return null;
            }
            JsonElement jsonElement2 = asJsonObject.get("tmplId");
            String asString = jsonElement2 == null ? null : jsonElement2.getAsString();
            if (asString == null) {
                return null;
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
            if (!TextUtils.isEmpty(asString)) {
                componentModel.setWidgetNodeModel(BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).buildWidgetNode(asString, asJsonObject2, componentModel, iBlockScope));
            }
            componentModel.setTemplateId(asString);
            return componentModel;
        }

        @JvmStatic
        public final RecyclerModel parseExceptWidgetNodeModel(Context context, JsonObject jsonObject, IBlockScope iBlockScope) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(jsonObject, "componentJsonObject");
            ComponentModel componentModel = new ComponentModel();
            componentModel.setDataModel(jsonObject);
            JsonElement jsonElement = jsonObject.get("componentV2");
            JsonObject asJsonObject = jsonElement == null ? null : jsonElement.getAsJsonObject();
            if (asJsonObject == null) {
                return null;
            }
            JsonElement jsonElement2 = asJsonObject.get("tmplId");
            String asString = jsonElement2 == null ? null : jsonElement2.getAsString();
            if (asString == null) {
                return null;
            }
            componentModel.setTemplateId(asString);
            return componentModel;
        }

        @JvmStatic
        public final ComponentModel parseExceptWidgetNodeModelComponent(Context context, JsonObject jsonObject, IBlockScope iBlockScope) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(jsonObject, "componentJsonObject");
            ComponentModel componentModel = new ComponentModel();
            componentModel.setDataModel(jsonObject);
            JsonElement jsonElement = jsonObject.get("componentV2");
            JsonObject asJsonObject = jsonElement == null ? null : jsonElement.getAsJsonObject();
            if (asJsonObject == null) {
                return null;
            }
            JsonElement jsonElement2 = asJsonObject.get("tmplId");
            String asString = jsonElement2 == null ? null : jsonElement2.getAsString();
            if (asString == null) {
                return null;
            }
            componentModel.setTemplateId(asString);
            return componentModel;
        }

        @JvmStatic
        public final WidgetNodeModel parseWidgetNode(JsonObject jsonObject, ComponentModel componentModel, IBlockScope iBlockScope) {
            Intrinsics.checkNotNullParameter(jsonObject, "componentJsonObject");
            Intrinsics.checkNotNullParameter(componentModel, "componentModel");
            Intrinsics.checkNotNullParameter(iBlockScope, "scope");
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
            JsonElement jsonElement4 = jsonObject.get("componentV2");
            JsonObject asJsonObject2 = jsonElement4 == null ? null : jsonElement4.getAsJsonObject();
            if (asJsonObject2 == null) {
                return null;
            }
            JsonElement jsonElement5 = asJsonObject2.get("tmplId");
            String asString = jsonElement5 == null ? null : jsonElement5.getAsString();
            if (asString != null && !TextUtils.isEmpty(asString)) {
                return BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).buildWidgetNode(asString, asJsonObject, componentModel, iBlockScope);
            }
            return null;
        }

        public final RecyclerModel parseHeader(ComponentEntity componentEntity, IBlockScope iBlockScope) {
            JsonObject jsonObject;
            Intrinsics.checkNotNullParameter(componentEntity, "componentEntity");
            Intrinsics.checkNotNullParameter(iBlockScope, "scope");
            ComponentModel componentModel = new ComponentModel();
            componentModel.setDataModel(componentEntity.data);
            TemplateTagEntity templateTagEntity = componentEntity.mComponentV2;
            String tmplId = templateTagEntity == null ? null : templateTagEntity.getTmplId();
            if (tmplId == null) {
                return null;
            }
            JsonElement parseString = JsonParser.parseString(GsonUtil.toJson(componentEntity));
            if (parseString == null) {
                jsonObject = null;
            } else {
                jsonObject = parseString.getAsJsonObject();
            }
            if (jsonObject == null) {
                BlocksOmegaHelpter blocksOmegaHelpter = BlocksOmegaHelpter.INSTANCE;
                String json = GsonUtil.toJson(componentEntity);
                String str = json == null ? null : json.toString();
                if (str == null) {
                    str = "";
                }
                blocksOmegaHelpter.trackBusinessDataError(str);
                return null;
            }
            if (!TextUtils.isEmpty(tmplId)) {
                componentModel.setWidgetNodeModel(BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).buildWidgetNode(tmplId, jsonObject, componentModel, iBlockScope));
            }
            componentModel.setTemplateId(tmplId);
            return componentModel;
        }

        public final RecyclerModel parse(ComponentEntity componentEntity, IBlockScope iBlockScope) {
            Intrinsics.checkNotNullParameter(componentEntity, "componentEntity");
            Intrinsics.checkNotNullParameter(iBlockScope, "scope");
            ComponentModel componentModel = new ComponentModel();
            componentModel.setDataModel(componentEntity);
            TemplateTagEntity templateTagEntity = componentEntity.mComponentV2;
            String tmplId = templateTagEntity == null ? null : templateTagEntity.getTmplId();
            if (tmplId == null) {
                return null;
            }
            JsonObject jsonObject = componentEntity.data;
            if (jsonObject == null) {
                BlocksOmegaHelpter blocksOmegaHelpter = BlocksOmegaHelpter.INSTANCE;
                String json = GsonUtil.toJson(componentEntity);
                String str = json == null ? null : json.toString();
                if (str == null) {
                    str = "";
                }
                blocksOmegaHelpter.trackBusinessDataError(str);
                return null;
            }
            if (!TextUtils.isEmpty(tmplId)) {
                componentModel.setWidgetNodeModel(BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).buildWidgetNode(tmplId, jsonObject, componentModel, iBlockScope));
            }
            componentModel.setTemplateId(tmplId);
            return componentModel;
        }

        @JvmStatic
        public final boolean isBlockType(JsonObject jsonObject) {
            Intrinsics.checkNotNullParameter(jsonObject, "componentJsonObject");
            JsonElement jsonElement = jsonObject.get("componentV2");
            JsonObject asJsonObject = jsonElement == null ? null : jsonElement.getAsJsonObject();
            if (asJsonObject == null) {
                return false;
            }
            JsonElement jsonElement2 = asJsonObject.get("tmplId");
            String asString = jsonElement2 == null ? null : jsonElement2.getAsString();
            if (TextUtils.isEmpty(asString)) {
                return false;
            }
            boolean isTemplateIdEffective = BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).isTemplateIdEffective(asString);
            if (!isTemplateIdEffective) {
                BlocksOmegaHelpter blocksOmegaHelpter = BlocksOmegaHelpter.INSTANCE;
                Intrinsics.checkNotNull(asString);
                blocksOmegaHelpter.trackNoMatchTemplate(asString);
            }
            return isTemplateIdEffective;
        }
    }
}
