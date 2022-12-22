package com.didichuxing.comp.telecom.biz.p176ui.voipcall.floatwindow.p178vh;

import android.view.View;
import com.didi.raven.config.RavenKey;
import com.didichuxing.comp.telecom.biz.p176ui.view.DebounceClickListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didichuxing/comp/telecom/biz/ui/voipcall/floatwindow/vh/InCallViewHolder$bindView$3", "Lcom/didichuxing/comp/telecom/biz/ui/view/DebounceClickListener;", "onBtnClick", "", "v", "Landroid/view/View;", "voip-biz_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* renamed from: com.didichuxing.comp.telecom.biz.ui.voipcall.floatwindow.vh.InCallViewHolder$bindView$3 */
/* compiled from: InCallViewHolder.kt */
public final class InCallViewHolder$bindView$3 extends DebounceClickListener {
    final /* synthetic */ InCallViewHolder this$0;

    InCallViewHolder$bindView$3(InCallViewHolder inCallViewHolder) {
        this.this$0 = inCallViewHolder;
    }

    public void onBtnClick(View view) {
        Intrinsics.checkParameterIsNotNull(view, RavenKey.VERSION);
        this.this$0.onHangUpClick(view);
    }
}
