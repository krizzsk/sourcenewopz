package com.didi.soda.customer.blocks.actions;

import android.content.Context;
import com.didi.soda.blocks.action.ActionNameMeta;
import com.didi.soda.blocks.action.ActionResult;
import com.didi.soda.blocks.action.BaseAction;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.foundation.util.GsonUtil;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B?\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u0001`\n¢\u0006\u0002\u0010\u000bJH\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u0001`\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/actions/ToJsonAction;", "Lcom/didi/soda/blocks/action/BaseAction;", "widgetNodeModel", "Lcom/didi/soda/blocks/model/WidgetNodeModel;", "context", "Landroid/content/Context;", "params", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "(Lcom/didi/soda/blocks/model/WidgetNodeModel;Landroid/content/Context;Ljava/util/HashMap;)V", "doExcute", "Lcom/didi/soda/blocks/action/ActionResult;", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "widget", "Lcom/didi/soda/blocks/widget/Buildable;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@ActionNameMeta(actionType = "toJson")
/* compiled from: ToJsonAction.kt */
public final class ToJsonAction extends BaseAction {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ToJsonAction(WidgetNodeModel widgetNodeModel, Context context, HashMap<String, Object> hashMap) {
        super(widgetNodeModel, context, hashMap);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public ActionResult doExcute(Context context, IBlockScope iBlockScope, HashMap<String, Object> hashMap, Buildable buildable) {
        HashMap<String, Object> context2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iBlockScope, "scope");
        Intrinsics.checkNotNullParameter(buildable, "widget");
        if (hashMap != null) {
            Object obj = hashMap.get("contextKey");
            String str = obj instanceof String ? (String) obj : null;
            Object obj2 = hashMap.get(BlocksConst.ACTION_PARAMS_ATTR);
            CharSequence charSequence = str;
            boolean z = false;
            if (!(charSequence == null || charSequence.length() == 0) && (!Intrinsics.areEqual((Object) charSequence, (Object) "null"))) {
                z = true;
            }
            if (z && obj2 != null) {
                String json = GsonUtil.toJson(obj2);
                WidgetNodeModel widgetNodeModel = getWidgetNodeModel();
                if (!(widgetNodeModel == null || (context2 = widgetNodeModel.getContext()) == null)) {
                    Intrinsics.checkNotNull(str);
                    context2.put(str, json);
                }
            }
        }
        return ActionResult.Companion.resolve$default(ActionResult.Companion, (HashMap) null, 1, (Object) null);
    }
}
