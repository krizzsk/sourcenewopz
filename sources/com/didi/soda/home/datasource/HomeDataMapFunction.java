package com.didi.soda.home.datasource;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.dynamic.DynamicDataMapFunction;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.tracker.error.ErrorTracker;
import com.didi.soda.datasource.listener.PayloadProvider;
import com.didi.soda.datasource.parser.FeedParser;
import com.didi.soda.datasource.parser.FeedParserFactory;
import com.didi.soda.datasource.parser.FeedPayload;
import com.didi.soda.datasource.parser.ParseType;
import com.google.gson.JsonObject;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\tH\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J*\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\tH\u0016J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001b0!H\u0004R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\""}, mo175978d2 = {"Lcom/didi/soda/home/datasource/HomeDataMapFunction;", "Lcom/didi/soda/customer/dynamic/DynamicDataMapFunction;", "payloadProvider", "Lcom/didi/soda/datasource/listener/PayloadProvider;", "Lcom/didi/soda/datasource/parser/FeedPayload;", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "(Lcom/didi/soda/datasource/listener/PayloadProvider;Lcom/didi/soda/blocks/scope/IBlockScope;)V", "mIndexOffset", "", "getMIndexOffset", "()I", "setMIndexOffset", "(I)V", "getPayloadProvider", "()Lcom/didi/soda/datasource/listener/PayloadProvider;", "setPayloadProvider", "(Lcom/didi/soda/datasource/listener/PayloadProvider;)V", "attachContextParams", "", "componentModel", "Lcom/didi/soda/blocks/model/ComponentModel;", "pageIndex", "index", "isParsable", "", "type", "", "parse", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "itemJsonObject", "Lcom/google/gson/JsonObject;", "receivedDataTypeList", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeDataMapFunction.kt */
public final class HomeDataMapFunction extends DynamicDataMapFunction {

    /* renamed from: a */
    private PayloadProvider<FeedPayload> f42627a;

    /* renamed from: b */
    private int f42628b = 1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeDataMapFunction(PayloadProvider<FeedPayload> payloadProvider, IBlockScope iBlockScope) {
        super(iBlockScope);
        Intrinsics.checkNotNullParameter(payloadProvider, "payloadProvider");
        Intrinsics.checkNotNullParameter(iBlockScope, "scope");
        this.f42627a = payloadProvider;
    }

    public final PayloadProvider<FeedPayload> getPayloadProvider() {
        return this.f42627a;
    }

    public final void setPayloadProvider(PayloadProvider<FeedPayload> payloadProvider) {
        Intrinsics.checkNotNullParameter(payloadProvider, "<set-?>");
        this.f42627a = payloadProvider;
    }

    public int getMIndexOffset() {
        return this.f42628b;
    }

    public void setMIndexOffset(int i) {
        this.f42628b = i;
    }

    public boolean isParsable(String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        return receivedDataTypeList().contains(str);
    }

    public RecyclerModel parse(String str, JsonObject jsonObject, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(jsonObject, "itemJsonObject");
        FeedParser feedParser = (FeedParser) FeedParserFactory.getFactory().getParser(str);
        if (feedParser != null) {
            FeedPayload providePayload = this.f42627a.providePayload();
            Intrinsics.checkNotNullExpressionValue(providePayload, "payloadProvider.providePayload()");
            FeedPayload feedPayload = providePayload;
            feedPayload.mPageIndex = i;
            feedPayload.mComponentIndex = i2;
            RecyclerModel parse = feedParser.parse(GlobalContext.getContext(), jsonObject, feedPayload);
            if (parse == null) {
                ErrorTracker.create(ErrorConst.ErrorName.TECH_SAILING_C_HOME_COMPONENT_DATA_ERROR).addModuleName("home").addErrorMsg("component data parse error").addParam("type", str).build().trackError();
            }
            return parse;
        }
        ErrorTracker.create(ErrorConst.ErrorName.TECH_SAILING_C_HOME_COMPONENT_TYPE_ERROR).addModuleName("home").addErrorMsg("Unsupported component type").addParam("type", str).build().trackError();
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: com.google.gson.JsonObject} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void attachContextParams(com.didi.soda.blocks.model.ComponentModel r5, int r6, int r7) {
        /*
            r4 = this;
            java.lang.String r0 = "componentModel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            com.didi.soda.blocks.model.WidgetNodeModel r0 = r5.getWidgetNodeModel()
            if (r0 != 0) goto L_0x000d
            goto L_0x00d3
        L_0x000d:
            java.util.HashMap r0 = r0.getContext()
            if (r0 != 0) goto L_0x0015
            goto L_0x00d3
        L_0x0015:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.String r1 = "pageIndex"
            r0.put(r1, r6)
            java.lang.String r6 = "page"
            java.lang.String r1 = "homepage"
            r0.put(r6, r1)
            java.lang.String r6 = "module"
            java.lang.String r2 = "8888"
            r0.put(r6, r2)
            com.didi.soda.datasource.listener.PayloadProvider r6 = r4.getPayloadProvider()
            java.lang.Object r6 = r6.providePayload()
            com.didi.soda.datasource.parser.FeedPayload r6 = (com.didi.soda.datasource.parser.FeedPayload) r6
            java.lang.String r6 = r6.mPageId
            java.lang.String r2 = "pageId"
            r0.put(r2, r6)
            com.didi.soda.datasource.listener.PayloadProvider r6 = r4.getPayloadProvider()
            java.lang.Object r6 = r6.providePayload()
            com.didi.soda.datasource.parser.FeedPayload r6 = (com.didi.soda.datasource.parser.FeedPayload) r6
            r2 = 0
            if (r6 != 0) goto L_0x004f
            r6 = r2
            goto L_0x0051
        L_0x004f:
            java.lang.String r6 = r6.mPageFilter
        L_0x0051:
            if (r6 == 0) goto L_0x0054
            goto L_0x0056
        L_0x0054:
            java.lang.String r6 = ""
        L_0x0056:
            java.lang.String r3 = "filter"
            r0.put(r3, r6)
            java.lang.Object r6 = r5.getDataModel()
            boolean r3 = r6 instanceof com.google.gson.JsonObject
            if (r3 == 0) goto L_0x0066
            com.google.gson.JsonObject r6 = (com.google.gson.JsonObject) r6
            goto L_0x0067
        L_0x0066:
            r6 = r2
        L_0x0067:
            if (r6 != 0) goto L_0x006a
            goto L_0x0080
        L_0x006a:
            java.lang.String r3 = "type"
            com.google.gson.JsonElement r6 = r6.get(r3)
            if (r6 != 0) goto L_0x0074
            goto L_0x0080
        L_0x0074:
            java.lang.String r6 = r6.getAsString()
            if (r6 != 0) goto L_0x007b
            goto L_0x0080
        L_0x007b:
            java.lang.String r3 = "componentType"
            r0.put(r3, r6)
        L_0x0080:
            java.lang.Object r6 = r5.getDataModel()
            boolean r3 = r6 instanceof com.google.gson.JsonObject
            if (r3 == 0) goto L_0x008b
            com.google.gson.JsonObject r6 = (com.google.gson.JsonObject) r6
            goto L_0x008c
        L_0x008b:
            r6 = r2
        L_0x008c:
            if (r6 != 0) goto L_0x008f
            goto L_0x00a2
        L_0x008f:
            java.lang.String r3 = "componentId"
            com.google.gson.JsonElement r6 = r6.get(r3)
            if (r6 != 0) goto L_0x0098
            goto L_0x00a2
        L_0x0098:
            java.lang.String r6 = r6.getAsString()
            if (r6 != 0) goto L_0x009f
            goto L_0x00a2
        L_0x009f:
            r0.put(r3, r6)
        L_0x00a2:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)
            java.lang.String r7 = "absolutePosition"
            r0.put(r7, r6)
            java.lang.Object r5 = r5.getDataModel()
            boolean r6 = r5 instanceof com.google.gson.JsonObject
            if (r6 == 0) goto L_0x00b6
            r2 = r5
            com.google.gson.JsonObject r2 = (com.google.gson.JsonObject) r2
        L_0x00b6:
            if (r2 != 0) goto L_0x00b9
            goto L_0x00cd
        L_0x00b9:
            java.lang.String r5 = "position"
            com.google.gson.JsonElement r6 = r2.get(r5)
            if (r6 != 0) goto L_0x00c3
            goto L_0x00cd
        L_0x00c3:
            java.lang.String r6 = r6.getAsString()
            if (r6 != 0) goto L_0x00ca
            goto L_0x00cd
        L_0x00ca:
            r0.put(r5, r6)
        L_0x00cd:
            java.lang.String r5 = "pageName"
            r0.put(r5, r1)
        L_0x00d3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.home.datasource.HomeDataMapFunction.attachContextParams(com.didi.soda.blocks.model.ComponentModel, int, int):void");
    }

    /* access modifiers changed from: protected */
    public final List<String> receivedDataTypeList() {
        return CollectionsKt.listOf("1", "200", ParseType.TYPE_ORDER, ParseType.TYPE_BANNER, "900", "filter", "99", ParseType.TYPE_TASK_CENTER);
    }
}
