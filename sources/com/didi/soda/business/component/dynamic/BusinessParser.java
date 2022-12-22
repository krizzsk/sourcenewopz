package com.didi.soda.business.component.dynamic;

import android.content.Context;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.customer.dynamic.AbsFeedParser;
import com.google.gson.JsonObject;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH&¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/soda/business/component/dynamic/BusinessParser;", "Lcom/didi/soda/customer/dynamic/AbsFeedParser;", "()V", "parser", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "context", "Landroid/content/Context;", "compJson", "Lcom/google/gson/JsonObject;", "payload", "Lcom/didi/soda/business/component/dynamic/BusinessPayload;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BusinessParser.kt */
public abstract class BusinessParser extends AbsFeedParser {
    public abstract RecyclerModel parser(Context context, JsonObject jsonObject, BusinessPayload businessPayload);
}
