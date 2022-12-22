package com.didi.soda.blocks.widget.scroller;

import android.view.View;
import com.didi.soda.blocks.scope.IBlockScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo175978d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: HorizontalScrollerWithEntrance.kt */
final class HorizontalScrollerWithEntrance$handleOtherTrigger$1 implements View.OnClickListener {
    final /* synthetic */ List $actions;
    final /* synthetic */ Function3 $handler;
    final /* synthetic */ IBlockScope $scope;
    final /* synthetic */ HorizontalScrollerWithEntrance this$0;

    HorizontalScrollerWithEntrance$handleOtherTrigger$1(HorizontalScrollerWithEntrance horizontalScrollerWithEntrance, Function3 function3, IBlockScope iBlockScope, List list) {
        this.this$0 = horizontalScrollerWithEntrance;
        this.$handler = function3;
        this.$scope = iBlockScope;
        this.$actions = list;
    }

    public final void onClick(View view) {
        this.$handler.invoke(this.$scope, this.this$0, this.$actions);
    }
}
