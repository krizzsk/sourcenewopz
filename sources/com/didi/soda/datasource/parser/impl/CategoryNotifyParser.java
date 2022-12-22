package com.didi.soda.datasource.parser.impl;

import android.content.Context;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.customer.foundation.rpc.entity.TagEntity;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.datasource.parser.FeedParser;
import com.didi.soda.datasource.parser.FeedPayload;
import com.didi.soda.datasource.parser.ParserMeta;
import com.didi.soda.home.binder.model.CategoryNotifyTipsModel;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;

@ParserMeta(type = {"category_notify"})
public class CategoryNotifyParser extends FeedParser {
    public RecyclerModel parse(Context context, JsonObject jsonObject, FeedPayload feedPayload) {
        TagEntity tagEntity = (TagEntity) GsonUtil.fromJson((JsonElement) jsonObject, (Type) TagEntity.class);
        if (tagEntity != null) {
            return CategoryNotifyTipsModel.Companion.convert(tagEntity);
        }
        return null;
    }
}
