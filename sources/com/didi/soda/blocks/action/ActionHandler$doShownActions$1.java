package com.didi.soda.blocks.action;

import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.widget.Buildable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tH\n¢\u0006\u0002\b\u000b"}, mo175978d2 = {"<no name provided>", "", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "widgetNode", "Lcom/didi/soda/blocks/model/WidgetNodeModel;", "widget", "Lcom/didi/soda/blocks/widget/Buildable;", "actions", "", "Lcom/didi/soda/blocks/action/BaseAction;", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: ActionHandler.kt */
final class ActionHandler$doShownActions$1 extends Lambda implements Function4<IBlockScope, WidgetNodeModel, Buildable, List<? extends BaseAction>, Unit> {
    public static final ActionHandler$doShownActions$1 INSTANCE = new ActionHandler$doShownActions$1();

    ActionHandler$doShownActions$1() {
        super(4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke((IBlockScope) obj, (WidgetNodeModel) obj2, (Buildable) obj3, (List<? extends BaseAction>) (List) obj4);
        return Unit.INSTANCE;
    }

    public final void invoke(IBlockScope iBlockScope, WidgetNodeModel widgetNodeModel, Buildable buildable, List<? extends BaseAction> list) {
        Intrinsics.checkParameterIsNotNull(iBlockScope, "scope");
        Intrinsics.checkParameterIsNotNull(buildable, "widget");
        if (widgetNodeModel == null || !widgetNodeModel.getHasShown()) {
            if (list != null) {
                for (BaseAction baseAction : list) {
                    if (baseAction != null) {
                        baseAction.excute(iBlockScope, buildable);
                    }
                }
            }
            if (widgetNodeModel != null) {
                widgetNodeModel.setHasShown(true);
            }
        }
    }
}
