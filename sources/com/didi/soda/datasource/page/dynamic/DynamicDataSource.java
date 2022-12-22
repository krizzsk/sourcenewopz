package com.didi.soda.datasource.page.dynamic;

import android.text.TextUtils;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Resource;
import com.didi.soda.blocks.entity.Template;
import com.didi.soda.blocks.sdk.BlocksEngine;
import com.didi.soda.customer.dynamic.DynamicDataMapFunction;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.tracker.BlocksOmegaHelpter;
import com.didi.soda.customer.repo.CustomerResource;
import com.didi.soda.datasource.page.DataSource;
import com.didi.soda.datasource.page.PageParams;
import com.didi.soda.datasource.page.dynamic.DynamicBaseEntity;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u00030\u0005B\u001f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00028\u0000\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ.\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00102\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0015J\u0016\u0010\u0015\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0010H\u0002¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/soda/datasource/page/dynamic/DynamicDataSource;", "Params", "Lcom/didi/soda/datasource/page/PageParams;", "Result", "Lcom/didi/soda/datasource/page/dynamic/DynamicBaseEntity;", "Lcom/didi/soda/datasource/page/DataSource;", "Lcom/google/gson/JsonObject;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "params", "dataMapFunction", "Lcom/didi/soda/customer/dynamic/DynamicDataMapFunction;", "(Lcom/didi/app/nova/skeleton/ScopeContext;Lcom/didi/soda/datasource/page/PageParams;Lcom/didi/soda/customer/dynamic/DynamicDataMapFunction;)V", "handleResult", "", "resource", "Lcom/didi/soda/customer/repo/CustomerResource;", "valueList", "", "pageIndex", "", "initTemplate", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DynamicDataSource.kt */
public abstract class DynamicDataSource<Params extends PageParams, Result extends DynamicBaseEntity> extends DataSource<Params, JsonObject, Result> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DynamicDataSource(ScopeContext scopeContext, Params params, DynamicDataMapFunction dynamicDataMapFunction) {
        super(scopeContext, params, dynamicDataMapFunction);
        Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(dynamicDataMapFunction, "dataMapFunction");
    }

    /* access modifiers changed from: protected */
    public void handleResult(CustomerResource<Result> customerResource, List<JsonObject> list, int i) {
        Intrinsics.checkNotNullParameter(customerResource, "resource");
        m29788a(customerResource);
        super.handleResult(customerResource, list, i);
    }

    /* renamed from: a */
    private final void m29788a(CustomerResource<Result> customerResource) {
        Template template;
        JsonObject asJsonObject;
        JsonElement jsonElement;
        String asString;
        if (customerResource.status == Resource.Status.SUCCESS && customerResource.data != null) {
            Collection mTemplates = ((DynamicBaseEntity) customerResource.data).getMTemplates();
            if (!(mTemplates == null || mTemplates.isEmpty())) {
                ArrayList arrayList = new ArrayList();
                List<JsonObject> mTemplates2 = ((DynamicBaseEntity) customerResource.data).getMTemplates();
                if (mTemplates2 != null) {
                    for (JsonObject jsonObject : mTemplates2) {
                        JsonElement jsonElement2 = jsonObject.get("tmplId");
                        String asString2 = jsonElement2 == null ? null : jsonElement2.getAsString();
                        if (TextUtils.isEmpty(asString2)) {
                            BlocksOmegaHelpter blocksOmegaHelpter = BlocksOmegaHelpter.INSTANCE;
                            String jsonObject2 = jsonObject.toString();
                            Intrinsics.checkNotNullExpressionValue(jsonObject2, "it.toString()");
                            blocksOmegaHelpter.trackTemplateWithoutId(jsonObject2);
                        } else {
                            JsonElement jsonElement3 = jsonObject.get("content");
                            if (jsonElement3 == null || jsonElement3.isJsonNull()) {
                                LogUtil.m29102e("DynamicDataSource.initTemplate", Intrinsics.stringPlus("Template without any content which tmplId is ", asString2));
                            } else {
                                JsonElement parse = new JsonParser().parse(jsonElement3.getAsString());
                                String str = "1";
                                if (!(parse == null || (asJsonObject = parse.getAsJsonObject()) == null || (jsonElement = asJsonObject.get("version")) == null || (asString = jsonElement.getAsString()) == null)) {
                                    str = asString;
                                }
                                if (Integer.parseInt(str) > 1) {
                                    try {
                                        template = (Template) new Gson().fromJson(jsonElement3.getAsString(), Template.class);
                                    } catch (Exception unused) {
                                        LogUtil.m29102e("DynamicDataSource.initTemplate", "templateEntity serialized failed which tmplId is " + asString2 + " and content is " + jsonElement3.getAsString());
                                        template = null;
                                    }
                                    if (template == null) {
                                        LogUtil.m29102e("DynamicDataSource.initTemplate", Intrinsics.stringPlus("templateEntity is null which tmplId is ", asString2));
                                    } else {
                                        template.setTemplateId(asString2);
                                    }
                                } else {
                                    template = new Template();
                                    template.setTmplId(asString2);
                                    template.setContent(jsonElement3.getAsString());
                                }
                                arrayList.add(template);
                            }
                        }
                    }
                }
                BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).initTemplate(arrayList);
            }
        }
    }
}
