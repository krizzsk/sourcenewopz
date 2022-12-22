package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.holder;

import android.content.Context;
import android.view.ContextThemeWrapper;
import com.didi.component.framework.pages.invitation.InvitationPageActivity;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.Entry;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletHomeTrackerManager;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "it", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.TopCardViewHolder$layoutQuickFunction$1$2$1$1$1 */
/* compiled from: TopCardViewHolder.kt */
final class TopCardViewHolder$layoutQuickFunction$1$2$1$1$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ Entry $entry;
    final /* synthetic */ Integer $status;
    final /* synthetic */ TopCardViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TopCardViewHolder$layoutQuickFunction$1$2$1$1$1(Entry entry, Integer num, TopCardViewHolder topCardViewHolder) {
        super(1);
        this.$entry = entry;
        this.$status = num;
        this.this$0 = topCardViewHolder;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Integer) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Integer num) {
        Request request = (Request) ((Request) DRouter.build(this.$entry.getLinkUrl()).putExtra(InvitationPageActivity.RESOURCE_ID, "1")).putExtra("kycStatus", (Serializable) this.$status);
        Context context = this.this$0.itemView.getContext();
        if (context != null) {
            request.start(((ContextThemeWrapper) context).getBaseContext());
            WalletHomeTrackerManager.Companion.trackQuickFunctionClick(this.$entry.getName());
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ContextThemeWrapper");
    }
}
