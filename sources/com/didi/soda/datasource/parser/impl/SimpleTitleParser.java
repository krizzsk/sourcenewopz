package com.didi.soda.datasource.parser.impl;

import android.content.Context;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.customer.binder.model.CustomerSimpleTitleRvModel;
import com.didi.soda.datasource.parser.FeedParser;
import com.didi.soda.datasource.parser.FeedPayload;
import com.didi.soda.datasource.parser.ParserMeta;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/soda/datasource/parser/impl/SimpleTitleParser;", "Lcom/didi/soda/datasource/parser/FeedParser;", "()V", "parse", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "context", "Landroid/content/Context;", "compJson", "Lcom/google/gson/JsonObject;", "payload", "Lcom/didi/soda/datasource/parser/FeedPayload;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@ParserMeta(type = {"simple_title"})
/* compiled from: SimpleTitleParser.kt */
public final class SimpleTitleParser extends FeedParser {
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
        String asString2 = (jsonObject3 == null || (jsonElement3 = jsonObject3.get("titleSizeDP")) == null) ? null : jsonElement3.getAsString();
        JsonElement jsonElement7 = jsonObject.get("data");
        JsonObject jsonObject4 = jsonElement7 instanceof JsonObject ? (JsonObject) jsonElement7 : null;
        String asString3 = (jsonObject4 == null || (jsonElement2 = jsonObject4.get("fontType")) == null) ? null : jsonElement2.getAsString();
        JsonElement jsonElement8 = jsonObject.get("data");
        JsonObject jsonObject5 = jsonElement8 instanceof JsonObject ? (JsonObject) jsonElement8 : null;
        String asString4 = (jsonObject5 == null || (jsonElement = jsonObject5.get("paddingTopDp")) == null) ? null : jsonElement.getAsString();
        if (asString == null) {
            return null;
        }
        return new CustomerSimpleTitleRvModel(asString, asString2, asString3, asString4);
    }
}
