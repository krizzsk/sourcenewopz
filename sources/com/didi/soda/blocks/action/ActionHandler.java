package com.didi.soda.blocks.action;

import android.content.Context;
import com.didi.soda.blocks.entity.CallBackEntity;
import com.didi.soda.blocks.model.ActionModel;
import com.didi.soda.blocks.model.CallBackModel;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.widget.Buildable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J6\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u000b2\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020 0\u001fj\b\u0012\u0004\u0012\u00020 `!R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R<\u0010\b\u001a$\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f\u0012\u0004\u0012\u00020\u000e0\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012RD\u0010\u0013\u001a,\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u000b\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f\u0012\u0004\u0012\u00020\u000e0\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\""}, mo175978d2 = {"Lcom/didi/soda/blocks/action/ActionHandler;", "", "actionFactory", "Lcom/didi/soda/blocks/action/ActionFactory;", "(Lcom/didi/soda/blocks/action/ActionFactory;)V", "getActionFactory", "()Lcom/didi/soda/blocks/action/ActionFactory;", "setActionFactory", "doActions", "Lkotlin/Function3;", "Lcom/didi/soda/blocks/scope/IBlockScope;", "Lcom/didi/soda/blocks/widget/Buildable;", "", "Lcom/didi/soda/blocks/action/BaseAction;", "", "getDoActions", "()Lkotlin/jvm/functions/Function3;", "setDoActions", "(Lkotlin/jvm/functions/Function3;)V", "doShownActions", "Lkotlin/Function4;", "Lcom/didi/soda/blocks/model/WidgetNodeModel;", "getDoShownActions", "()Lkotlin/jvm/functions/Function4;", "setDoShownActions", "(Lkotlin/jvm/functions/Function4;)V", "performTraverse", "scope", "widgetNodeModel", "widget", "callBacks", "Ljava/util/ArrayList;", "Lcom/didi/soda/blocks/model/CallBackModel;", "Lkotlin/collections/ArrayList;", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ActionHandler.kt */
public final class ActionHandler {
    private ActionFactory actionFactory;
    private Function3<? super IBlockScope, ? super Buildable, ? super List<? extends BaseAction>, Unit> doActions = ActionHandler$doActions$1.INSTANCE;
    private Function4<? super IBlockScope, ? super WidgetNodeModel, ? super Buildable, ? super List<? extends BaseAction>, Unit> doShownActions = ActionHandler$doShownActions$1.INSTANCE;

    public ActionHandler(ActionFactory actionFactory2) {
        Intrinsics.checkParameterIsNotNull(actionFactory2, "actionFactory");
        this.actionFactory = actionFactory2;
    }

    public final ActionFactory getActionFactory() {
        return this.actionFactory;
    }

    public final void setActionFactory(ActionFactory actionFactory2) {
        Intrinsics.checkParameterIsNotNull(actionFactory2, "<set-?>");
        this.actionFactory = actionFactory2;
    }

    public final void performTraverse(IBlockScope iBlockScope, WidgetNodeModel widgetNodeModel, Buildable buildable, ArrayList<CallBackModel> arrayList) {
        Intrinsics.checkParameterIsNotNull(iBlockScope, "scope");
        Intrinsics.checkParameterIsNotNull(widgetNodeModel, "widgetNodeModel");
        Intrinsics.checkParameterIsNotNull(buildable, "widget");
        Intrinsics.checkParameterIsNotNull(arrayList, "callBacks");
        Collection arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            CharSequence type = ((CallBackModel) next).getType();
            if (type == null || type.length() == 0) {
                z = true;
            }
            if (!z) {
                arrayList2.add(next);
            }
        }
        for (CallBackModel callBackModel : (List) arrayList2) {
            String type2 = callBackModel.getType();
            List list = null;
            if (type2 != null) {
                int hashCode = type2.hashCode();
                if (hashCode != -1351902487) {
                    if (hashCode == -1012968068 && type2.equals(CallBackEntity.CALLBACK_TYPE_SHOW)) {
                        boolean needRealTimeExposure = ShowActionHelper.Companion.needRealTimeExposure(widgetNodeModel);
                        List<ActionModel> actions = callBackModel.getActions();
                        if (actions != null) {
                            Iterable<ActionModel> iterable = actions;
                            Collection arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                            for (ActionModel createAction : iterable) {
                                ActionFactory actionFactory2 = this.actionFactory;
                                Context context = buildable.getView().getContext();
                                Intrinsics.checkExpressionValueIsNotNull(context, "widget.getView().context");
                                arrayList3.add(actionFactory2.createAction(iBlockScope, widgetNodeModel, context, createAction));
                            }
                            List list2 = (List) arrayList3;
                            if (!(buildable.handleShownTrigger(iBlockScope, widgetNodeModel, list2, this.doShownActions) || needRealTimeExposure)) {
                                list = list2;
                            }
                            if (list != null) {
                                this.doShownActions.invoke(iBlockScope, widgetNodeModel, buildable, list);
                            }
                        }
                    }
                } else if (type2.equals(CallBackEntity.CALLBACK_TYPE_CLICK)) {
                    List<ActionModel> actions2 = callBackModel.getActions();
                    if (actions2 != null) {
                        Iterable<ActionModel> iterable2 = actions2;
                        Collection arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
                        for (ActionModel createAction2 : iterable2) {
                            ActionFactory actionFactory3 = this.actionFactory;
                            Context context2 = buildable.getView().getContext();
                            Intrinsics.checkExpressionValueIsNotNull(context2, "widget.getView().context");
                            arrayList4.add(actionFactory3.createAction(iBlockScope, widgetNodeModel, context2, createAction2));
                        }
                        List list3 = (List) arrayList4;
                        List list4 = !buildable.handleClickTrigger(iBlockScope, list3, this.doActions) ? list3 : null;
                        if (list4 != null) {
                            buildable.getView().setOnClickListener(new ActionHandler$performTraverse$$inlined$forEach$lambda$1(list4, this, widgetNodeModel, iBlockScope, buildable));
                        }
                    }
                }
            }
            List<ActionModel> actions3 = callBackModel.getActions();
            if (actions3 != null) {
                Iterable<ActionModel> iterable3 = actions3;
                Collection arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable3, 10));
                for (ActionModel createAction3 : iterable3) {
                    ActionFactory actionFactory4 = this.actionFactory;
                    Context context3 = buildable.getView().getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context3, "widget.getView().context");
                    arrayList5.add(actionFactory4.createAction(iBlockScope, widgetNodeModel, context3, createAction3));
                }
                List list5 = (List) arrayList5;
                if (!buildable.handleOtherTrigger(iBlockScope, callBackModel.getType(), list5, this.doActions)) {
                    list = list5;
                }
                if (list != null) {
                    this.doActions.invoke(iBlockScope, buildable, list);
                }
            }
        }
    }

    public final Function3<IBlockScope, Buildable, List<? extends BaseAction>, Unit> getDoActions() {
        return this.doActions;
    }

    public final void setDoActions(Function3<? super IBlockScope, ? super Buildable, ? super List<? extends BaseAction>, Unit> function3) {
        Intrinsics.checkParameterIsNotNull(function3, "<set-?>");
        this.doActions = function3;
    }

    public final Function4<IBlockScope, WidgetNodeModel, Buildable, List<? extends BaseAction>, Unit> getDoShownActions() {
        return this.doShownActions;
    }

    public final void setDoShownActions(Function4<? super IBlockScope, ? super WidgetNodeModel, ? super Buildable, ? super List<? extends BaseAction>, Unit> function4) {
        Intrinsics.checkParameterIsNotNull(function4, "<set-?>");
        this.doShownActions = function4;
    }
}
