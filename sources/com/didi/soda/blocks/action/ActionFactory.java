package com.didi.soda.blocks.action;

import android.content.Context;
import com.didi.soda.blocks.model.ActionModel;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.sdk.BlocksEngine;
import com.didi.soda.blocks.sdk.config.IBlocksLogger;
import com.didi.soda.blocks.track.BlocksTrackHelper;
import com.didi.soda.blocks.widget.WidgetFactory;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J*\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011JV\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132&\u0010\u0014\u001a\"\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0015j\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u0016H\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0018"}, mo175978d2 = {"Lcom/didi/soda/blocks/action/ActionFactory;", "", "actionPool", "Lcom/didi/soda/blocks/action/ActionPool;", "(Lcom/didi/soda/blocks/action/ActionPool;)V", "getActionPool", "()Lcom/didi/soda/blocks/action/ActionPool;", "setActionPool", "createAction", "Lcom/didi/soda/blocks/action/BaseAction;", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "widgetNodeModel", "Lcom/didi/soda/blocks/model/WidgetNodeModel;", "context", "Landroid/content/Context;", "actionEntity", "Lcom/didi/soda/blocks/model/ActionModel;", "type", "", "params", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Companion", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ActionFactory.kt */
public final class ActionFactory {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "ActionFactory";
    private ActionPool actionPool;

    public ActionFactory(ActionPool actionPool2) {
        Intrinsics.checkParameterIsNotNull(actionPool2, "actionPool");
        this.actionPool = actionPool2;
    }

    public final ActionPool getActionPool() {
        return this.actionPool;
    }

    public final void setActionPool(ActionPool actionPool2) {
        Intrinsics.checkParameterIsNotNull(actionPool2, "<set-?>");
        this.actionPool = actionPool2;
    }

    public final BaseAction createAction(IBlockScope iBlockScope, WidgetNodeModel widgetNodeModel, Context context, ActionModel actionModel) {
        List list;
        Intrinsics.checkParameterIsNotNull(iBlockScope, "scope");
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(actionModel, "actionEntity");
        BaseAction createAction = createAction(iBlockScope, widgetNodeModel, context, actionModel.getActionType(), actionModel.getParams());
        boolean z = true;
        List list2 = null;
        if (createAction == null) {
            BlocksTrackHelper.Companion.trackAcionNotFound(widgetNodeModel != null ? widgetNodeModel.getTemplateId() : null, widgetNodeModel != null ? widgetNodeModel.getName() : null, actionModel.getActionType(), actionModel.getEvent());
            if (!BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).isDebug()) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("can't resolved action which type is ");
            String actionType = actionModel.getActionType();
            if (actionType == null) {
                actionType = "";
            }
            sb.append(actionType);
            sb.append(", please register the action when start up the BlocksEngine or register it in IBlockScope ");
            throw new IllegalStateException(sb.toString().toString());
        }
        List<ActionModel> onSuccess = actionModel.getOnSuccess();
        if (onSuccess != null) {
            Iterable<ActionModel> iterable = onSuccess;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (ActionModel createAction2 : iterable) {
                arrayList.add(createAction(iBlockScope, widgetNodeModel, context, createAction2));
            }
            list = (List) arrayList;
        } else {
            list = null;
        }
        Collection collection = list;
        if (!(collection == null || collection.isEmpty())) {
            createAction.attachSuccessCallBacks(list);
        }
        List<ActionModel> onError = actionModel.getOnError();
        if (onError != null) {
            Iterable<ActionModel> iterable2 = onError;
            Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
            for (ActionModel createAction3 : iterable2) {
                arrayList2.add(createAction(iBlockScope, widgetNodeModel, context, createAction3));
            }
            list2 = (List) arrayList2;
        }
        Collection collection2 = list2;
        if (collection2 != null && !collection2.isEmpty()) {
            z = false;
        }
        if (!z) {
            createAction.attachErrorCallBacks(list2);
        }
        return createAction;
    }

    private final BaseAction createAction(IBlockScope iBlockScope, WidgetNodeModel widgetNodeModel, Context context, String str, HashMap<String, Object> hashMap) {
        String message;
        Constructor<? extends BaseAction> declaredConstructor;
        if (str != null && iBlockScope.containsAction(str)) {
            return new ActionFactory$createAction$2(str, widgetNodeModel, context, hashMap, widgetNodeModel, context, hashMap);
        }
        try {
            Class<? extends BaseAction> action = this.actionPool.getAction(str);
            if (action == null || (declaredConstructor = action.getDeclaredConstructor(new Class[]{WidgetNodeModel.class, Context.class, HashMap.class})) == null) {
                return null;
            }
            return (BaseAction) declaredConstructor.newInstance(new Object[]{widgetNodeModel, context, hashMap});
        } catch (Exception e) {
            e.printStackTrace();
            IBlocksLogger logger = BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).getLogger();
            if (logger != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("can't create action which type is:");
                sb.append(str);
                sb.append(" with error:");
                String message2 = e.getMessage();
                String str2 = "";
                if (message2 == null) {
                    message2 = str2;
                }
                sb.append(message2);
                sb.append(' ');
                Throwable cause = e.getCause();
                if (cause == null || (message = cause.getMessage()) == null) {
                    str2 = null;
                } else if (message != null) {
                    str2 = message;
                }
                sb.append(str2);
                logger.error(WidgetFactory.TAG, sb.toString());
            }
            if (!BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).isDebug()) {
                return null;
            }
            throw e;
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/blocks/action/ActionFactory$Companion;", "", "()V", "TAG", "", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: ActionFactory.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
