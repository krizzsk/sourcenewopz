package com.didi.soda.search.component.result;

import android.text.TextUtils;
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

@Metadata(mo175977d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000fH\u0016J\u0018\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 H\u0016J$\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0%2\b\b\u0002\u0010&\u001a\u00020\u000f2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020(0%J*\u0010)\u001a\u0004\u0018\u00010\"2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010*\u001a\u00020(2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000fH\u0016J\u000e\u0010+\u001a\b\u0012\u0004\u0012\u00020 0%H\u0004R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006,"}, mo175978d2 = {"Lcom/didi/soda/search/component/result/SearchResultDataMapFunction;", "Lcom/didi/soda/customer/dynamic/DynamicDataMapFunction;", "payloadProvider", "Lcom/didi/soda/datasource/listener/PayloadProvider;", "Lcom/didi/soda/datasource/parser/FeedPayload;", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "(Lcom/didi/soda/datasource/listener/PayloadProvider;Lcom/didi/soda/blocks/scope/IBlockScope;)V", "ignoreIndex", "", "getIgnoreIndex", "()Z", "setIgnoreIndex", "(Z)V", "mIndexOffset", "", "getMIndexOffset", "()I", "setMIndexOffset", "(I)V", "getPayloadProvider", "()Lcom/didi/soda/datasource/listener/PayloadProvider;", "setPayloadProvider", "(Lcom/didi/soda/datasource/listener/PayloadProvider;)V", "attachContextParams", "", "componentModel", "Lcom/didi/soda/blocks/model/ComponentModel;", "pageIndex", "index", "isIndexIgnoreType", "type", "", "rvModel", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "isParsable", "mapExpandData", "", "startIndex", "list", "Lcom/google/gson/JsonObject;", "parse", "itemJsonObject", "receivedDataTypeList", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SearchResultDataMapFunction.kt */
public final class SearchResultDataMapFunction extends DynamicDataMapFunction {

    /* renamed from: a */
    private PayloadProvider<FeedPayload> f43721a;

    /* renamed from: b */
    private int f43722b;

    /* renamed from: c */
    private boolean f43723c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchResultDataMapFunction(PayloadProvider<FeedPayload> payloadProvider, IBlockScope iBlockScope) {
        super(iBlockScope);
        Intrinsics.checkNotNullParameter(payloadProvider, "payloadProvider");
        Intrinsics.checkNotNullParameter(iBlockScope, "scope");
        this.f43721a = payloadProvider;
    }

    public final PayloadProvider<FeedPayload> getPayloadProvider() {
        return this.f43721a;
    }

    public final void setPayloadProvider(PayloadProvider<FeedPayload> payloadProvider) {
        Intrinsics.checkNotNullParameter(payloadProvider, "<set-?>");
        this.f43721a = payloadProvider;
    }

    public int getMIndexOffset() {
        return this.f43722b;
    }

    public void setMIndexOffset(int i) {
        this.f43722b = i;
    }

    public final boolean getIgnoreIndex() {
        return this.f43723c;
    }

    public final void setIgnoreIndex(boolean z) {
        this.f43723c = z;
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
            FeedPayload providePayload = this.f43721a.providePayload();
            Intrinsics.checkNotNullExpressionValue(providePayload, "payloadProvider.providePayload()");
            FeedPayload feedPayload = providePayload;
            feedPayload.mPageIndex = i;
            if (!this.f43723c) {
                feedPayload.mComponentIndex = i2;
            }
            RecyclerModel parse = feedParser.parse(GlobalContext.getContext(), jsonObject, feedPayload);
            if (parse == null) {
                ErrorTracker.create(ErrorConst.ErrorName.TECH_SAILING_C_SEARCH_COMPONENT_DATA_ERROR).addModuleName("search").addErrorMsg("component data parse error").addParam("type", str).build().trackError();
            }
            return parse;
        }
        ErrorTracker.create(ErrorConst.ErrorName.TECH_SAILING_C_SEARCH_COMPONENT_TYPE_ERROR).addModuleName("search").addErrorMsg("Unsupported component type").addParam("type", str).build().trackError();
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: com.google.gson.JsonObject} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void attachContextParams(com.didi.soda.blocks.model.ComponentModel r4, int r5, int r6) {
        /*
            r3 = this;
            java.lang.String r0 = "componentModel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            com.didi.soda.blocks.model.WidgetNodeModel r0 = r4.getWidgetNodeModel()
            if (r0 != 0) goto L_0x000d
            goto L_0x0120
        L_0x000d:
            java.util.HashMap r0 = r0.getContext()
            if (r0 != 0) goto L_0x0015
            goto L_0x0120
        L_0x0015:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r1 = "pageIndex"
            r0.put(r1, r5)
            java.lang.String r5 = "page"
            java.lang.String r1 = "specialpage"
            r0.put(r5, r1)
            java.lang.String r5 = "module"
            java.lang.String r1 = "7777"
            r0.put(r5, r1)
            com.didi.soda.datasource.listener.PayloadProvider r5 = r3.getPayloadProvider()
            java.lang.Object r5 = r5.providePayload()
            com.didi.soda.datasource.parser.FeedPayload r5 = (com.didi.soda.datasource.parser.FeedPayload) r5
            java.lang.String r5 = r5.mPageId
            java.lang.String r1 = "pageId"
            r0.put(r1, r5)
            com.didi.soda.datasource.listener.PayloadProvider r5 = r3.getPayloadProvider()
            java.lang.Object r5 = r5.providePayload()
            com.didi.soda.datasource.parser.FeedPayload r5 = (com.didi.soda.datasource.parser.FeedPayload) r5
            r1 = 0
            if (r5 != 0) goto L_0x0050
            r5 = r1
            goto L_0x0052
        L_0x0050:
            java.lang.String r5 = r5.mPageFilter
        L_0x0052:
            if (r5 == 0) goto L_0x0055
            goto L_0x0057
        L_0x0055:
            java.lang.String r5 = ""
        L_0x0057:
            java.lang.String r2 = "filter"
            r0.put(r2, r5)
            java.lang.Object r5 = r4.getDataModel()
            boolean r2 = r5 instanceof com.google.gson.JsonObject
            if (r2 == 0) goto L_0x0067
            com.google.gson.JsonObject r5 = (com.google.gson.JsonObject) r5
            goto L_0x0068
        L_0x0067:
            r5 = r1
        L_0x0068:
            if (r5 != 0) goto L_0x006b
            goto L_0x008a
        L_0x006b:
            java.lang.String r2 = "type"
            com.google.gson.JsonElement r5 = r5.get(r2)
            if (r5 != 0) goto L_0x0075
            goto L_0x008a
        L_0x0075:
            java.lang.String r5 = r5.getAsString()
            if (r5 != 0) goto L_0x007c
            goto L_0x008a
        L_0x007c:
            java.lang.String r2 = "componentType"
            r0.put(r2, r5)
            java.lang.String r5 = com.didi.soda.search.helper.SearchNewOmegaHelper.getComponentDescWithType(r5)
            java.lang.String r2 = "componentDescByType"
            r0.put(r2, r5)
        L_0x008a:
            java.lang.Object r5 = r4.getDataModel()
            boolean r2 = r5 instanceof com.google.gson.JsonObject
            if (r2 == 0) goto L_0x0095
            com.google.gson.JsonObject r5 = (com.google.gson.JsonObject) r5
            goto L_0x0096
        L_0x0095:
            r5 = r1
        L_0x0096:
            if (r5 != 0) goto L_0x0099
            goto L_0x00ac
        L_0x0099:
            java.lang.String r2 = "componentId"
            com.google.gson.JsonElement r5 = r5.get(r2)
            if (r5 != 0) goto L_0x00a2
            goto L_0x00ac
        L_0x00a2:
            java.lang.String r5 = r5.getAsString()
            if (r5 != 0) goto L_0x00a9
            goto L_0x00ac
        L_0x00a9:
            r0.put(r2, r5)
        L_0x00ac:
            java.lang.Object r5 = r4.getDataModel()
            boolean r2 = r5 instanceof com.google.gson.JsonObject
            if (r2 == 0) goto L_0x00b7
            com.google.gson.JsonObject r5 = (com.google.gson.JsonObject) r5
            goto L_0x00b8
        L_0x00b7:
            r5 = r1
        L_0x00b8:
            if (r5 != 0) goto L_0x00bb
            goto L_0x00de
        L_0x00bb:
            java.lang.String r2 = "data"
            com.google.gson.JsonElement r5 = r5.get(r2)
            if (r5 != 0) goto L_0x00c4
            goto L_0x00de
        L_0x00c4:
            com.google.gson.JsonObject r5 = r5.getAsJsonObject()
            if (r5 != 0) goto L_0x00cb
            goto L_0x00de
        L_0x00cb:
            java.lang.String r2 = "moduleId"
            com.google.gson.JsonElement r5 = r5.get(r2)
            if (r5 != 0) goto L_0x00d4
            goto L_0x00de
        L_0x00d4:
            java.lang.String r5 = r5.getAsString()
            if (r5 != 0) goto L_0x00db
            goto L_0x00de
        L_0x00db:
            r0.put(r2, r5)
        L_0x00de:
            boolean r5 = r3.getIgnoreIndex()
            if (r5 != 0) goto L_0x00f6
            java.lang.Integer r5 = java.lang.Integer.valueOf(r6)
            java.lang.String r2 = "absolutePosition"
            r0.put(r2, r5)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r6)
            java.lang.String r6 = "index"
            r0.put(r6, r5)
        L_0x00f6:
            java.lang.Object r4 = r4.getDataModel()
            boolean r5 = r4 instanceof com.google.gson.JsonObject
            if (r5 == 0) goto L_0x0101
            r1 = r4
            com.google.gson.JsonObject r1 = (com.google.gson.JsonObject) r1
        L_0x0101:
            if (r1 != 0) goto L_0x0104
            goto L_0x0118
        L_0x0104:
            java.lang.String r4 = "position"
            com.google.gson.JsonElement r5 = r1.get(r4)
            if (r5 != 0) goto L_0x010e
            goto L_0x0118
        L_0x010e:
            java.lang.String r5 = r5.getAsString()
            if (r5 != 0) goto L_0x0115
            goto L_0x0118
        L_0x0115:
            r0.put(r4, r5)
        L_0x0118:
            java.lang.String r4 = "pageName"
            java.lang.String r5 = "homepage"
            r0.put(r4, r5)
        L_0x0120:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.search.component.result.SearchResultDataMapFunction.attachContextParams(com.didi.soda.blocks.model.ComponentModel, int, int):void");
    }

    /* access modifiers changed from: protected */
    public final List<String> receivedDataTypeList() {
        return CollectionsKt.listOf("1", "2", "3", "4", "filter", "99", ParseType.SIMPLE_TITLE, ParseType.MORE_TITLE);
    }

    public boolean isIndexIgnoreType(String str, RecyclerModel recyclerModel) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(recyclerModel, "rvModel");
        CharSequence charSequence = str;
        return TextUtils.equals(charSequence, ParseType.SIMPLE_TITLE) || TextUtils.equals(charSequence, ParseType.MORE_TITLE);
    }

    public static /* synthetic */ List mapExpandData$default(SearchResultDataMapFunction searchResultDataMapFunction, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return searchResultDataMapFunction.mapExpandData(i, list);
    }

    public final List<RecyclerModel> mapExpandData(int i, List<JsonObject> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        setMIndexOffset(i);
        return mapData(0, list);
    }
}
