package com.didi.soda.search.component.result.parser;

import android.content.Context;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.datasource.parser.FeedParser;
import com.didi.soda.datasource.parser.FeedPayload;
import com.didi.soda.datasource.parser.ParserMeta;
import com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel;
import com.google.gson.JsonObject;

@ParserMeta(type = {"2", "3", "4"})
public class SearchBusinessResultParser extends FeedParser {
    public RecyclerModel parse(Context context, JsonObject jsonObject, FeedPayload feedPayload) {
        return HomeBusinessInfoRvModel.convertCompJson(jsonObject, feedPayload);
    }
}
