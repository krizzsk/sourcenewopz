package com.didi.soda.datasource.parser.impl;

import android.content.Context;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.datasource.parser.FeedParser;
import com.didi.soda.datasource.parser.FeedPayload;
import com.didi.soda.datasource.parser.ParserMeta;
import com.didi.soda.search.binder.model.SearchAdjustableTitleRvModel;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/soda/datasource/parser/impl/ExpandMoreTitleParser;", "Lcom/didi/soda/datasource/parser/FeedParser;", "()V", "parse", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "context", "Landroid/content/Context;", "compJson", "Lcom/google/gson/JsonObject;", "payload", "Lcom/didi/soda/datasource/parser/FeedPayload;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@ParserMeta(type = {"more_title"})
/* compiled from: ExpandMoreTitleParser.kt */
public final class ExpandMoreTitleParser extends FeedParser {
    public RecyclerModel parse(Context context, JsonObject jsonObject, FeedPayload feedPayload) {
        JsonElement jsonElement;
        JsonElement jsonElement2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(jsonObject, "compJson");
        Intrinsics.checkNotNullParameter(feedPayload, "payload");
        JsonElement jsonElement3 = jsonObject.get("data");
        JsonObject jsonObject2 = jsonElement3 instanceof JsonObject ? (JsonObject) jsonElement3 : null;
        String asString = (jsonObject2 == null || (jsonElement2 = jsonObject2.get("type")) == null) ? null : jsonElement2.getAsString();
        JsonElement jsonElement4 = jsonObject.get("data");
        JsonObject jsonObject3 = jsonElement4 instanceof JsonObject ? (JsonObject) jsonElement4 : null;
        String asString2 = (jsonObject3 == null || (jsonElement = jsonObject3.get("title")) == null) ? null : jsonElement.getAsString();
        if (asString == null || asString2 == null) {
            return null;
        }
        return new SearchAdjustableTitleRvModel(asString2, asString);
    }
}
