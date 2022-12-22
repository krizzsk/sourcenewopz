package com.didi.soda.compose.event;

import com.didi.app.nova.skeleton.repo.Action1;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/soda/compose/event/ComposeBus$register$1", "Lcom/didi/app/nova/skeleton/repo/Action1;", "Lcom/didi/soda/compose/event/ComposeAction;", "call", "", "action", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ComposeBus.kt */
public final class ComposeBus$register$1 implements Action1<ComposeAction> {
    final /* synthetic */ String $type;
    final /* synthetic */ ComposeBus this$0;

    ComposeBus$register$1(ComposeBus composeBus, String str) {
        this.this$0 = composeBus;
        this.$type = str;
    }

    public void call(ComposeAction composeAction) {
        IComposeHandler iComposeHandler;
        if (composeAction != null && this.this$0.f40125c.containsKey(this.$type) && (iComposeHandler = (IComposeHandler) this.this$0.f40125c.get(this.$type)) != null) {
            iComposeHandler.handleAction(composeAction);
        }
    }
}
