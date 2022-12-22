package com.didi.soda.datasource.parser.impl;

import android.content.Context;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity;
import com.didi.soda.datasource.parser.FeedParser;
import com.didi.soda.datasource.parser.FeedPayload;
import com.didi.soda.datasource.parser.ParserMeta;
import com.didi.soda.home.topgun.binder.model.HomeTopicOperationRvModel;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@ParserMeta(type = {"2001"})
public class FeedTofuParser extends FeedParser {
    public RecyclerModel parse(Context context, JsonObject jsonObject, FeedPayload feedPayload) {
        return HomeTopicOperationRvModel.convertTofuEntity((ComponentEntity) new Gson().fromJson((JsonElement) jsonObject, ComponentEntity.class), feedPayload);
    }
}
