package com.didiglobal.component.imentrance.view;

import android.view.View;
import com.didi.raven.config.RavenKey;
import com.didiglobal.component.imentrance.view.MessageBubbleHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\b¨\u0006\t"}, mo175978d2 = {"com/didiglobal/component/imentrance/view/MessageBubbleHelper$onLayoutChange$1", "Lcom/didiglobal/component/imentrance/view/MessageBubbleHelper$AnchorLayoutObserver;", "onViewLayoutChange", "", "v", "Landroid/view/View;", "attached", "", "(Landroid/view/View;Ljava/lang/Boolean;)V", "comp-imentrance_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: MessageBubbleHelper.kt */
public final class MessageBubbleHelper$onLayoutChange$1 extends MessageBubbleHelper.AnchorLayoutObserver {
    final /* synthetic */ Function2<View, Boolean, Unit> $onLayoutChange;
    final /* synthetic */ View $this_onLayoutChange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MessageBubbleHelper$onLayoutChange$1(Function2<? super View, ? super Boolean, Unit> function2, View view) {
        super(view);
        this.$onLayoutChange = function2;
        this.$this_onLayoutChange = view;
    }

    public void onViewLayoutChange(View view, Boolean bool) {
        Intrinsics.checkNotNullParameter(view, RavenKey.VERSION);
        this.$onLayoutChange.invoke(view, bool);
    }
}
