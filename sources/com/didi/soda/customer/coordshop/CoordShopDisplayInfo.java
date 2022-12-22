package com.didi.soda.customer.coordshop;

import android.text.TextUtils;
import com.didi.soda.blocks.entity.Template;
import com.didi.soda.blocks.sdk.BlocksEngine;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.tracker.BlocksOmegaHelpter;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/soda/customer/coordshop/CoordShopDisplayInfo;", "", "()V", "count", "", "getCount", "()I", "setCount", "(I)V", "isDisplayed", "", "()Z", "setDisplayed", "(Z)V", "model", "", "getModel", "()Ljava/lang/String;", "setModel", "(Ljava/lang/String;)V", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CoordShopDisplayInfo.kt */
public final class CoordShopDisplayInfo {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private int f40834a;

    /* renamed from: b */
    private boolean f40835b;

    /* renamed from: c */
    private String f40836c = "";

    public final int getCount() {
        return this.f40834a;
    }

    public final void setCount(int i) {
        this.f40834a = i;
    }

    public final boolean isDisplayed() {
        return this.f40835b;
    }

    public final void setDisplayed(boolean z) {
        this.f40835b = z;
    }

    public final String getModel() {
        return this.f40836c;
    }

    public final void setModel(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f40836c = str;
    }

    @Metadata(mo175977d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J4\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0018\u0010\u0013\u001a\u00020\u00142\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0016H\u0002¨\u0006\u0017"}, mo175978d2 = {"Lcom/didi/soda/customer/coordshop/CoordShopDisplayInfo$Companion;", "", "()V", "checkTemplatesId", "", "componentJsonObject", "Lcom/google/gson/JsonObject;", "create", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "requestInfo", "Lcom/didi/soda/customer/coordshop/RequestInfo;", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/CoordShopEntity;", "traceId", "", "alreadyShowTime", "", "initTemplates", "", "mTemplates", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CoordShopDisplayInfo.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final void initTemplates(List<JsonObject> list) {
            Template template;
            ArrayList arrayList = new ArrayList();
            if (list != null) {
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
                            LogUtil.m29102e("CoordManager.initTemplate", Intrinsics.stringPlus("Template without any content which tmplId is ", asString));
                        } else {
                            try {
                                template = (Template) new Gson().fromJson(jsonElement2.getAsString(), Template.class);
                            } catch (Exception unused) {
                                LogUtil.m29102e("CoordManager.initTemplate", "templateEntity serialized failed which tmplId is " + asString + " and content is " + jsonElement2.getAsString());
                                template = null;
                            }
                            if (template == null) {
                                LogUtil.m29102e("CoordManager.initTemplate", Intrinsics.stringPlus("templateEntity is null which tmplId is ", asString));
                            } else if (!BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).isTemplateIdEffective(asString)) {
                                template.setTemplateId(asString);
                                arrayList.add(template);
                            }
                        }
                    }
                }
            }
            if (arrayList.size() > 0) {
                BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).initTemplate(arrayList);
            }
        }

        private final boolean checkTemplatesId(JsonObject jsonObject) {
            JsonElement jsonElement = jsonObject.get("componentV2");
            String str = null;
            JsonObject asJsonObject = jsonElement == null ? null : jsonElement.getAsJsonObject();
            if (asJsonObject == null) {
                return false;
            }
            JsonElement jsonElement2 = asJsonObject.get("tmplId");
            if (jsonElement2 != null) {
                str = jsonElement2.getAsString();
            }
            if (str == null) {
                return false;
            }
            CharSequence charSequence = str;
            if ((charSequence.length() == 0) || !(!Intrinsics.areEqual((Object) charSequence, (Object) "null"))) {
                return false;
            }
            return true;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: java.lang.String} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel create(com.didi.soda.blocks.scope.IBlockScope r17, com.didi.soda.customer.coordshop.RequestInfo r18, com.didi.soda.customer.foundation.rpc.entity.CoordShopEntity r19, java.lang.String r20, int r21) {
            /*
                r16 = this;
                r1 = r16
                r0 = r19
                r2 = r20
                java.lang.String r3 = "requestInfo"
                r4 = r18
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r3)
                java.lang.String r3 = "entity"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
                com.didi.soda.customer.foundation.rpc.entity.CoordShopRequestEntity r3 = r18.getCurEnterShop()
                r5 = 0
                if (r3 != 0) goto L_0x001c
                r3 = 0
                goto L_0x001e
            L_0x001c:
                int r3 = r3.pageNo
            L_0x001e:
                java.util.List<com.google.gson.JsonObject> r6 = r0.compList
                java.lang.Object r5 = com.didi.soda.customer.foundation.util.CollectionUtilsKt.safeGet(r6, r5)
                com.google.gson.JsonObject r5 = (com.google.gson.JsonObject) r5
                r6 = 0
                if (r5 != 0) goto L_0x002a
                return r6
            L_0x002a:
                java.util.List r7 = r19.getMTemplates()
                int r7 = com.didi.soda.customer.foundation.util.CollectionUtilsKt.sizeOrNull(r7)
                java.lang.String r8 = "homePage"
                java.lang.String r9 = "data"
                java.lang.String r10 = "Coord"
                java.lang.String r11 = "type"
                java.lang.String r12 = "componentId"
                java.lang.String r13 = ""
                if (r7 <= 0) goto L_0x0160
                boolean r7 = r1.checkTemplatesId(r5)
                if (r7 == 0) goto L_0x0160
                java.lang.String r7 = ">>>>> show block card <<<<<<<<"
                com.didi.soda.customer.foundation.log.util.LogUtil.m29104i((java.lang.String) r10, (java.lang.String) r7)
                java.util.List r7 = r19.getMTemplates()
                r1.initTemplates(r7)
                com.didi.soda.customer.dynamic.BlocksCommonParser$Companion r7 = com.didi.soda.customer.dynamic.BlocksCommonParser.Companion
                android.content.Context r10 = com.didi.soda.customer.app.GlobalContext.getContext()
                java.lang.String r14 = "getContext()"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r14)
                r14 = r17
                com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel r5 = r7.parse(r10, r5, r14)
                boolean r7 = r5 instanceof com.didi.soda.blocks.model.ComponentModel
                if (r7 == 0) goto L_0x006c
                r7 = r5
                com.didi.soda.blocks.model.ComponentModel r7 = (com.didi.soda.blocks.model.ComponentModel) r7
                goto L_0x006d
            L_0x006c:
                r7 = r6
            L_0x006d:
                if (r7 != 0) goto L_0x0071
                goto L_0x01fc
            L_0x0071:
                com.didi.soda.blocks.model.WidgetNodeModel r10 = r7.getWidgetNodeModel()
                if (r10 != 0) goto L_0x0079
                goto L_0x01fc
            L_0x0079:
                java.util.HashMap r10 = r10.getContext()
                if (r10 != 0) goto L_0x0081
                goto L_0x01fc
            L_0x0081:
                java.lang.Object r14 = r7.getDataModel()
                boolean r15 = r14 instanceof com.google.gson.JsonObject
                if (r15 == 0) goto L_0x008c
                com.google.gson.JsonObject r14 = (com.google.gson.JsonObject) r14
                goto L_0x008d
            L_0x008c:
                r14 = r6
            L_0x008d:
                if (r14 != 0) goto L_0x0090
                goto L_0x00a3
            L_0x0090:
                com.google.gson.JsonElement r11 = r14.get(r11)
                if (r11 != 0) goto L_0x0097
                goto L_0x00a3
            L_0x0097:
                java.lang.String r11 = r11.getAsString()
                if (r11 != 0) goto L_0x009e
                goto L_0x00a3
            L_0x009e:
                java.lang.String r14 = "componentType"
                r10.put(r14, r11)
            L_0x00a3:
                java.lang.Object r11 = r7.getDataModel()
                boolean r14 = r11 instanceof com.google.gson.JsonObject
                if (r14 == 0) goto L_0x00ae
                com.google.gson.JsonObject r11 = (com.google.gson.JsonObject) r11
                goto L_0x00af
            L_0x00ae:
                r11 = r6
            L_0x00af:
                if (r11 != 0) goto L_0x00b2
                goto L_0x00c3
            L_0x00b2:
                com.google.gson.JsonElement r11 = r11.get(r12)
                if (r11 != 0) goto L_0x00b9
                goto L_0x00c3
            L_0x00b9:
                java.lang.String r11 = r11.getAsString()
                if (r11 != 0) goto L_0x00c0
                goto L_0x00c3
            L_0x00c0:
                r10.put(r12, r11)
            L_0x00c3:
                java.lang.Object r7 = r7.getDataModel()
                boolean r11 = r7 instanceof com.google.gson.JsonObject
                if (r11 == 0) goto L_0x00ce
                com.google.gson.JsonObject r7 = (com.google.gson.JsonObject) r7
                goto L_0x00cf
            L_0x00ce:
                r7 = r6
            L_0x00cf:
                java.lang.String r11 = "sourcePosition"
                if (r7 != 0) goto L_0x00d6
            L_0x00d4:
                r7 = r6
                goto L_0x00ff
            L_0x00d6:
                com.google.gson.JsonElement r7 = r7.get(r9)
                if (r7 != 0) goto L_0x00dd
                goto L_0x00d4
            L_0x00dd:
                com.google.gson.JsonObject r7 = r7.getAsJsonObject()
                if (r7 != 0) goto L_0x00e4
                goto L_0x00d4
            L_0x00e4:
                java.lang.String r9 = "collaborationInfo"
                com.google.gson.JsonElement r7 = r7.get(r9)
                if (r7 != 0) goto L_0x00ed
                goto L_0x00d4
            L_0x00ed:
                com.google.gson.JsonObject r7 = r7.getAsJsonObject()
                if (r7 != 0) goto L_0x00f4
                goto L_0x00d4
            L_0x00f4:
                com.google.gson.JsonElement r7 = r7.get(r11)
                if (r7 != 0) goto L_0x00fb
                goto L_0x00d4
            L_0x00fb:
                java.lang.String r7 = r7.getAsString()
            L_0x00ff:
                if (r7 == 0) goto L_0x0103
                r9 = r7
                goto L_0x0104
            L_0x0103:
                r9 = r13
            L_0x0104:
                java.lang.String r12 = "position"
                r10.put(r12, r9)
                java.lang.String r9 = "pageId"
                r10.put(r9, r8)
                int r8 = r18.getIndexInRv()
                int r8 = r8 + 1
                java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
                java.lang.String r9 = "absolutePosition"
                r10.put(r9, r8)
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                java.lang.String r8 = "pageIndex"
                r10.put(r8, r3)
                java.lang.String r0 = r0.recId
                java.lang.String r3 = "recId"
                r10.put(r3, r0)
                if (r2 == 0) goto L_0x0134
                goto L_0x0135
            L_0x0134:
                r2 = r13
            L_0x0135:
                java.lang.String r0 = "traceId"
                r10.put(r0, r2)
                com.didi.soda.customer.foundation.rpc.entity.CoordShopRequestEntity r0 = r18.getCurEnterShop()
                if (r0 != 0) goto L_0x0142
                goto L_0x0144
            L_0x0142:
                java.lang.String r6 = r0.shopId
            L_0x0144:
                if (r6 == 0) goto L_0x0147
                goto L_0x0148
            L_0x0147:
                r6 = r13
            L_0x0148:
                java.lang.String r0 = "synergyShopId"
                r10.put(r0, r6)
                java.lang.String r0 = java.lang.String.valueOf(r21)
                java.lang.String r2 = "synergySeq"
                r10.put(r2, r0)
                if (r7 == 0) goto L_0x015b
                r13 = r7
            L_0x015b:
                r10.put(r11, r13)
                goto L_0x01fc
            L_0x0160:
                java.lang.String r7 = ">>>>> show native card <<<<<<<<"
                com.didi.soda.customer.foundation.log.util.LogUtil.m29104i((java.lang.String) r10, (java.lang.String) r7)
                com.google.gson.JsonElement r7 = r5.get(r9)     // Catch:{ Exception -> 0x01f5 }
                java.lang.String r9 = "jsonObject.get(\"data\")"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r9)     // Catch:{ Exception -> 0x01f5 }
                java.lang.Class<com.didi.soda.customer.foundation.rpc.entity.BusinessInfoEntity> r9 = com.didi.soda.customer.foundation.rpc.entity.BusinessInfoEntity.class
                java.lang.reflect.Type r9 = (java.lang.reflect.Type) r9     // Catch:{ Exception -> 0x01f5 }
                java.lang.Object r7 = com.didi.soda.customer.foundation.util.GsonUtil.fromJson((com.google.gson.JsonElement) r7, (java.lang.reflect.Type) r9)     // Catch:{ Exception -> 0x01f5 }
                com.didi.soda.customer.foundation.rpc.entity.BusinessInfoEntity r7 = (com.didi.soda.customer.foundation.rpc.entity.BusinessInfoEntity) r7     // Catch:{ Exception -> 0x01f5 }
                com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel r9 = com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel.convertBusinessInfoEntity(r7)     // Catch:{ Exception -> 0x01f5 }
                if (r9 != 0) goto L_0x017f
                goto L_0x0181
            L_0x017f:
                r9.mPageInModule = r3     // Catch:{ Exception -> 0x01f5 }
            L_0x0181:
                if (r9 != 0) goto L_0x0184
                goto L_0x01a9
            L_0x0184:
                com.didi.soda.customer.coordshop.CoordShopModel$Companion r3 = com.didi.soda.customer.coordshop.CoordShopModel.Companion     // Catch:{ Exception -> 0x01f5 }
                com.didi.soda.customer.foundation.rpc.entity.BusinessInfoEntity$CollaborationInfo r10 = r7.collaborationInfo     // Catch:{ Exception -> 0x01f5 }
                com.didi.soda.customer.coordshop.CoordShopModel r3 = r3.create(r10)     // Catch:{ Exception -> 0x01f5 }
                if (r3 != 0) goto L_0x0190
                r3 = r6
                goto L_0x01a7
            L_0x0190:
                com.didi.soda.customer.foundation.rpc.entity.CoordShopRequestEntity r10 = r18.getCurEnterShop()     // Catch:{ Exception -> 0x01f5 }
                if (r10 != 0) goto L_0x0198
                r10 = r6
                goto L_0x019a
            L_0x0198:
                java.lang.String r10 = r10.shopId     // Catch:{ Exception -> 0x01f5 }
            L_0x019a:
                if (r10 == 0) goto L_0x019d
                r13 = r10
            L_0x019d:
                r3.setSynergyShopId(r13)     // Catch:{ Exception -> 0x01f5 }
                r10 = r21
                r3.setSynergySeq(r10)     // Catch:{ Exception -> 0x01f5 }
                kotlin.Unit r10 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x01f5 }
            L_0x01a7:
                r9.coordShopModel = r3     // Catch:{ Exception -> 0x01f5 }
            L_0x01a9:
                com.didi.soda.customer.foundation.rpc.entity.BusinessInfoEntity$CollaborationInfo r3 = r7.collaborationInfo     // Catch:{ Exception -> 0x01f5 }
                if (r3 == 0) goto L_0x01b4
                com.didi.soda.customer.foundation.rpc.entity.BusinessInfoEntity$CollaborationInfo r3 = r7.collaborationInfo     // Catch:{ Exception -> 0x01f5 }
                int r3 = r3.sourcePosition     // Catch:{ Exception -> 0x01f5 }
                r9.mIndexInModule = r3     // Catch:{ Exception -> 0x01f5 }
                goto L_0x01b7
            L_0x01b4:
                r3 = -1
                r9.mIndexInModule = r3     // Catch:{ Exception -> 0x01f5 }
            L_0x01b7:
                com.google.gson.JsonElement r3 = r5.get(r12)     // Catch:{ Exception -> 0x01f5 }
                if (r3 == 0) goto L_0x01c7
                com.google.gson.JsonElement r3 = r5.get(r12)     // Catch:{ Exception -> 0x01f5 }
                java.lang.String r3 = r3.getAsString()     // Catch:{ Exception -> 0x01f5 }
                r9.mComponentId = r3     // Catch:{ Exception -> 0x01f5 }
            L_0x01c7:
                com.google.gson.JsonElement r3 = r5.get(r11)     // Catch:{ Exception -> 0x01f5 }
                if (r3 == 0) goto L_0x01d7
                com.google.gson.JsonElement r3 = r5.get(r11)     // Catch:{ Exception -> 0x01f5 }
                java.lang.String r3 = r3.getAsString()     // Catch:{ Exception -> 0x01f5 }
                r9.mComponentType = r3     // Catch:{ Exception -> 0x01f5 }
            L_0x01d7:
                if (r9 != 0) goto L_0x01da
                goto L_0x01de
            L_0x01da:
                java.lang.String r0 = r0.recId     // Catch:{ Exception -> 0x01f5 }
                r9.mRecId = r0     // Catch:{ Exception -> 0x01f5 }
            L_0x01de:
                if (r9 != 0) goto L_0x01e1
                goto L_0x01e3
            L_0x01e1:
                r9.mTraceId = r2     // Catch:{ Exception -> 0x01f5 }
            L_0x01e3:
                if (r9 != 0) goto L_0x01e6
                goto L_0x01e8
            L_0x01e6:
                r9.mPageId = r8     // Catch:{ Exception -> 0x01f5 }
            L_0x01e8:
                if (r9 != 0) goto L_0x01eb
                goto L_0x01f3
            L_0x01eb:
                int r0 = r18.getIndexInRv()     // Catch:{ Exception -> 0x01f5 }
                int r0 = r0 + 1
                r9.mAbsoluteIndex = r0     // Catch:{ Exception -> 0x01f5 }
            L_0x01f3:
                r6 = r9
                goto L_0x01f9
            L_0x01f5:
                r0 = move-exception
                r0.printStackTrace()
            L_0x01f9:
                r5 = r6
                com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel r5 = (com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel) r5
            L_0x01fc:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.coordshop.CoordShopDisplayInfo.Companion.create(com.didi.soda.blocks.scope.IBlockScope, com.didi.soda.customer.coordshop.RequestInfo, com.didi.soda.customer.foundation.rpc.entity.CoordShopEntity, java.lang.String, int):com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel");
        }
    }
}
