package com.didiglobal.component.imentrance.view;

import android.view.View;
import com.didi.raven.config.RavenKey;
import com.didiglobal.component.imentrance.view.MessageBubbleHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\b¨\u0006\t¸\u0006\u0000"}, mo175978d2 = {"com/didiglobal/component/imentrance/view/MessageBubbleHelper$onLayoutChange$1", "Lcom/didiglobal/component/imentrance/view/MessageBubbleHelper$AnchorLayoutObserver;", "onViewLayoutChange", "", "v", "Landroid/view/View;", "attached", "", "(Landroid/view/View;Ljava/lang/Boolean;)V", "comp-imentrance_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.component.imentrance.view.MessageBubbleHelper$mountWithAnchor$lambda-20$$inlined$onLayoutChange$1 */
/* compiled from: MessageBubbleHelper.kt */
public final class C16667xf878c890 extends MessageBubbleHelper.AnchorLayoutObserver {
    final /* synthetic */ MessageBubbleHelper.AnchorBubbleTag $tag$inlined;
    final /* synthetic */ View $this_mountWithAnchor$inlined;
    final /* synthetic */ View $this_onLayoutChange;
    final /* synthetic */ MessageBubbleHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C16667xf878c890(View view, MessageBubbleHelper messageBubbleHelper, View view2, MessageBubbleHelper.AnchorBubbleTag anchorBubbleTag) {
        super(view);
        this.$this_onLayoutChange = view;
        this.this$0 = messageBubbleHelper;
        this.$this_mountWithAnchor$inlined = view2;
        this.$tag$inlined = anchorBubbleTag;
    }

    public void onViewLayoutChange(View view, Boolean bool) {
        Intrinsics.checkNotNullParameter(view, RavenKey.VERSION);
        if (bool != null && bool.booleanValue()) {
            this.$tag$inlined.attach();
        }
        if (this.this$0.m35949c(view)) {
            this.this$0.m35943a(this.$this_mountWithAnchor$inlined, view, this.$tag$inlined);
            return;
        }
        View view2 = this.$this_mountWithAnchor$inlined;
        view2.setVisibility(4);
        view2.setEnabled(false);
    }
}
