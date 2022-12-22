package com.didi.soda.datasource.parser.impl;

import android.content.Context;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.datasource.parser.FeedParser;
import com.didi.soda.datasource.parser.FeedPayload;
import com.didi.soda.datasource.parser.ParserMeta;
import com.didi.soda.home.topgun.binder.model.HomeNoResultRvModel;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\"\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\f"}, mo175978d2 = {"Lcom/didi/soda/datasource/parser/impl/FeedNoResultParser;", "Lcom/didi/soda/datasource/parser/FeedParser;", "()V", "parse", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "context", "Landroid/content/Context;", "compJson", "Lcom/google/gson/JsonObject;", "payload", "Lcom/didi/soda/datasource/parser/FeedPayload;", "parseUnderdata", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@ParserMeta(type = {"99"})
/* compiled from: FeedNoResultParser.kt */
public final class FeedNoResultParser extends FeedParser {
    public RecyclerModel parse(Context context, JsonObject jsonObject, FeedPayload feedPayload) {
        JsonElement jsonElement;
        JsonElement jsonElement2;
        JsonElement jsonElement3;
        JsonElement jsonElement4;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(jsonObject, "compJson");
        Intrinsics.checkNotNullParameter(feedPayload, "payload");
        JsonElement jsonElement5 = jsonObject.get("data");
        JsonObject jsonObject2 = jsonElement5 instanceof JsonObject ? (JsonObject) jsonElement5 : null;
        String asString = (jsonObject2 == null || (jsonElement4 = jsonObject2.get("title")) == null) ? null : jsonElement4.getAsString();
        JsonElement jsonElement6 = jsonObject.get("data");
        JsonObject jsonObject3 = jsonElement6 instanceof JsonObject ? (JsonObject) jsonElement6 : null;
        String asString2 = (jsonObject3 == null || (jsonElement3 = jsonObject3.get("subTitle")) == null) ? null : jsonElement3.getAsString();
        JsonElement jsonElement7 = jsonObject.get("data");
        JsonObject jsonObject4 = jsonElement7 instanceof JsonObject ? (JsonObject) jsonElement7 : null;
        String asString3 = (jsonObject4 == null || (jsonElement2 = jsonObject4.get("bgImg")) == null) ? null : jsonElement2.getAsString();
        JsonElement jsonElement8 = jsonObject.get("data");
        JsonObject jsonObject5 = jsonElement8 instanceof JsonObject ? (JsonObject) jsonElement8 : null;
        String asString4 = (jsonObject5 == null || (jsonElement = jsonObject5.get("btnText")) == null) ? null : jsonElement.getAsString();
        if (asString == null) {
            return null;
        }
        String str = feedPayload.mPageFilter;
        if (str == null) {
            str = "";
        }
        return HomeNoResultRvModel.convertDividerEntity(asString, asString2, asString3, asString4, str, feedPayload.mPageId, feedPayload.mCateId, feedPayload.mRecId);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0010, code lost:
        r0 = r11.get("title");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel parseUnderdata(android.content.Context r10, com.google.gson.JsonObject r11, com.didi.soda.datasource.parser.FeedPayload r12) {
        /*
            r9 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r10 = "payload"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r10)
            r10 = 0
            if (r11 != 0) goto L_0x0010
        L_0x000e:
            r1 = r10
            goto L_0x001f
        L_0x0010:
            java.lang.String r0 = "title"
            com.google.gson.JsonElement r0 = r11.get(r0)
            if (r0 != 0) goto L_0x001a
            goto L_0x000e
        L_0x001a:
            java.lang.String r0 = r0.getAsString()
            r1 = r0
        L_0x001f:
            if (r11 != 0) goto L_0x0023
        L_0x0021:
            r2 = r10
            goto L_0x0032
        L_0x0023:
            java.lang.String r0 = "subTitle"
            com.google.gson.JsonElement r0 = r11.get(r0)
            if (r0 != 0) goto L_0x002d
            goto L_0x0021
        L_0x002d:
            java.lang.String r0 = r0.getAsString()
            r2 = r0
        L_0x0032:
            if (r11 != 0) goto L_0x0036
        L_0x0034:
            r3 = r10
            goto L_0x0044
        L_0x0036:
            java.lang.String r0 = "bgImg"
            com.google.gson.JsonElement r0 = r11.get(r0)
            if (r0 != 0) goto L_0x003f
            goto L_0x0034
        L_0x003f:
            java.lang.String r0 = r0.getAsString()
            r3 = r0
        L_0x0044:
            if (r11 != 0) goto L_0x0048
        L_0x0046:
            r4 = r10
            goto L_0x0056
        L_0x0048:
            java.lang.String r0 = "btnText"
            com.google.gson.JsonElement r11 = r11.get(r0)
            if (r11 != 0) goto L_0x0051
            goto L_0x0046
        L_0x0051:
            java.lang.String r11 = r11.getAsString()
            r4 = r11
        L_0x0056:
            if (r1 != 0) goto L_0x005b
            com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel r10 = (com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel) r10
            goto L_0x006f
        L_0x005b:
            java.lang.String r10 = r12.mPageFilter
            if (r10 == 0) goto L_0x0060
            goto L_0x0062
        L_0x0060:
            java.lang.String r10 = ""
        L_0x0062:
            r5 = r10
            java.lang.String r6 = r12.mPageId
            java.lang.String r7 = r12.mCateId
            java.lang.String r8 = r12.mRecId
            com.didi.soda.home.topgun.binder.model.HomeNoResultRvModel r10 = com.didi.soda.home.topgun.binder.model.HomeNoResultRvModel.convertDividerEntity(r1, r2, r3, r4, r5, r6, r7, r8)
            com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel r10 = (com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel) r10
        L_0x006f:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.datasource.parser.impl.FeedNoResultParser.parseUnderdata(android.content.Context, com.google.gson.JsonObject, com.didi.soda.datasource.parser.FeedPayload):com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel");
    }
}
