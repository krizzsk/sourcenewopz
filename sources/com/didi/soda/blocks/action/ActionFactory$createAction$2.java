package com.didi.soda.blocks.action;

import android.content.Context;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.widget.Buildable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JH\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072&\u0010\b\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, mo175978d2 = {"com/didi/soda/blocks/action/ActionFactory$createAction$2", "Lcom/didi/soda/blocks/action/BaseAction;", "doExcute", "Lcom/didi/soda/blocks/action/ActionResult;", "context", "Landroid/content/Context;", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "params", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "widget", "Lcom/didi/soda/blocks/widget/Buildable;", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ActionFactory.kt */
public final class ActionFactory$createAction$2 extends BaseAction {
    final /* synthetic */ Context $context;
    final /* synthetic */ HashMap $params;
    final /* synthetic */ String $type;
    final /* synthetic */ WidgetNodeModel $widgetNodeModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ActionFactory$createAction$2(String str, WidgetNodeModel widgetNodeModel, Context context, HashMap hashMap, WidgetNodeModel widgetNodeModel2, Context context2, HashMap hashMap2) {
        super(widgetNodeModel2, context2, hashMap2);
        this.$type = str;
        this.$widgetNodeModel = widgetNodeModel;
        this.$context = context;
        this.$params = hashMap;
    }

    public ActionResult doExcute(Context context, IBlockScope iBlockScope, HashMap<String, Object> hashMap, Buildable buildable) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(iBlockScope, "scope");
        Intrinsics.checkParameterIsNotNull(buildable, "widget");
        Function4<Context, IBlockScope, HashMap<String, Object>, Buildable, ActionResult> action = iBlockScope.getAction(this.$type);
        if (action == null) {
            Intrinsics.throwNpe();
        }
        return action.invoke(context, iBlockScope, hashMap, buildable);
    }
}
