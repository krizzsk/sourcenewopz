package com.didi.soda.datasource.parser.impl;

import android.content.Context;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.customer.foundation.rpc.entity.topgun.FilterEntity;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.datasource.parser.FeedParser;
import com.didi.soda.datasource.parser.FeedPayload;
import com.didi.soda.datasource.parser.ParserMeta;
import com.didi.soda.home.topgun.binder.model.FilterRvModel;
import com.didi.soda.home.topgun.component.feed.HomeExtKt;
import com.didi.soda.home.topgun.component.filter.FilterDataManager;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;

@ParserMeta(type = {"filter"})
public class FilterParser extends FeedParser {
    public RecyclerModel parse(Context context, JsonObject jsonObject, FeedPayload feedPayload) {
        if (!jsonObject.has(HomeExtKt.KEY_FILTER)) {
            return null;
        }
        FilterDataManager instanceByScene = FilterDataManager.Companion.getInstanceByScene(1);
        instanceByScene.parseFilterEntity((ArrayList) GsonUtil.fromJson((JsonElement) jsonObject.getAsJsonArray(HomeExtKt.KEY_FILTER), new TypeToken<ArrayList<FilterEntity>>() {
        }.getType()));
        FilterRvModel filterRvModel = new FilterRvModel();
        filterRvModel.setHasAnim(false);
        filterRvModel.setFilterManager(instanceByScene);
        return filterRvModel;
    }
}
