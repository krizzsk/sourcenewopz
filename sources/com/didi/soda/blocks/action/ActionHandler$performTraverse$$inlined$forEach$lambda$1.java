package com.didi.soda.blocks.action;

import android.view.View;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.widget.Buildable;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0007"}, mo175978d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/didi/soda/blocks/action/ActionHandler$performTraverse$2$6$1", "com/didi/soda/blocks/action/ActionHandler$$special$$inlined$let$lambda$1"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: ActionHandler.kt */
final class ActionHandler$performTraverse$$inlined$forEach$lambda$1 implements View.OnClickListener {
    final /* synthetic */ List $actionList;
    final /* synthetic */ IBlockScope $scope$inlined;
    final /* synthetic */ Buildable $widget$inlined;
    final /* synthetic */ WidgetNodeModel $widgetNodeModel$inlined;
    final /* synthetic */ ActionHandler this$0;

    ActionHandler$performTraverse$$inlined$forEach$lambda$1(List list, ActionHandler actionHandler, WidgetNodeModel widgetNodeModel, IBlockScope iBlockScope, Buildable buildable) {
        this.$actionList = list;
        this.this$0 = actionHandler;
        this.$widgetNodeModel$inlined = widgetNodeModel;
        this.$scope$inlined = iBlockScope;
        this.$widget$inlined = buildable;
    }

    public final void onClick(View view) {
        this.this$0.getDoActions().invoke(this.$scope$inlined, this.$widget$inlined, this.$actionList);
    }
}
