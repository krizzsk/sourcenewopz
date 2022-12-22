package com.didi.soda.datasource.parser;

import android.content.Context;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.customer.dynamic.AbsFeedParser;
import com.google.gson.JsonObject;

public abstract class FeedParser extends AbsFeedParser {
    public abstract RecyclerModel parse(Context context, JsonObject jsonObject, FeedPayload feedPayload);
}
