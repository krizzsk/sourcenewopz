package com.didi.soda.customer.blocks.actions;

import android.content.Context;
import com.didi.soda.blocks.action.ActionNameMeta;
import com.didi.soda.blocks.action.ActionResult;
import com.didi.soda.blocks.action.BaseAction;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.customer.blocks.BlocksConst;
import com.google.gson.JsonArray;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B?\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u0001`\n¢\u0006\u0002\u0010\u000bJH\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u0001`\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/actions/ForEachTrackParams;", "Lcom/didi/soda/blocks/action/BaseAction;", "widgetNodeModel", "Lcom/didi/soda/blocks/model/WidgetNodeModel;", "context", "Landroid/content/Context;", "params", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "(Lcom/didi/soda/blocks/model/WidgetNodeModel;Landroid/content/Context;Ljava/util/HashMap;)V", "doExcute", "Lcom/didi/soda/blocks/action/ActionResult;", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "widget", "Lcom/didi/soda/blocks/widget/Buildable;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@ActionNameMeta(actionType = "forEachTrackParams")
/* compiled from: ForEachTrackParams.kt */
public final class ForEachTrackParams extends BaseAction {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ForEachTrackParams(WidgetNodeModel widgetNodeModel, Context context, HashMap<String, Object> hashMap) {
        super(widgetNodeModel, context, hashMap);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public ActionResult doExcute(Context context, IBlockScope iBlockScope, HashMap<String, Object> hashMap, Buildable buildable) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iBlockScope, "scope");
        Intrinsics.checkNotNullParameter(buildable, "widget");
        if (hashMap != null) {
            for (Map.Entry value : hashMap.entrySet()) {
                Object value2 = value.getValue();
                HashMap hashMap2 = value2 instanceof HashMap ? (HashMap) value2 : null;
                ForActionBean forActionBean = new ForActionBean(getWidgetNodeModel());
                if (hashMap2 == null) {
                    obj = null;
                } else {
                    obj = hashMap2.get("data");
                }
                forActionBean.setData(obj instanceof JsonArray ? (JsonArray) obj : null);
                if (hashMap2 == null) {
                    obj2 = null;
                } else {
                    obj2 = hashMap2.get(BlocksConst.VALUE_KEY);
                }
                forActionBean.setValueKey(obj2 instanceof String ? (String) obj2 : null);
                if (hashMap2 == null) {
                    obj3 = null;
                } else {
                    obj3 = hashMap2.get(BlocksConst.WIDGET_PARAMS_DIVIDER);
                }
                forActionBean.setDivider(obj3 instanceof String ? (String) obj3 : null);
                if (hashMap2 == null) {
                    obj4 = null;
                } else {
                    obj4 = hashMap2.get("contextKey");
                }
                forActionBean.setContextKey(obj4 instanceof String ? (String) obj4 : null);
                if (hashMap2 == null) {
                    obj5 = null;
                } else {
                    obj5 = hashMap2.get("type");
                }
                forActionBean.setType(obj5 instanceof String ? (String) obj5 : null);
                if (hashMap2 == null) {
                    obj6 = null;
                } else {
                    obj6 = hashMap2.get("jsonKey");
                }
                forActionBean.setJsonKey(obj6 instanceof String ? (String) obj6 : null);
                forActionBean.run();
            }
        }
        return ActionResult.Companion.resolve$default(ActionResult.Companion, (HashMap) null, 1, (Object) null);
    }
}
