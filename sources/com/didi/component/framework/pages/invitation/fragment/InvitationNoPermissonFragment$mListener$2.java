package com.didi.component.framework.pages.invitation.fragment;

import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, mo175978d2 = {"<anonymous>", "Lcom/didi/component/framework/pages/invitation/fragment/IInvitationListener;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InvitationNoPermissonFragment.kt */
final class InvitationNoPermissonFragment$mListener$2 extends Lambda implements Function0<IInvitationListener> {
    final /* synthetic */ InvitationNoPermissonFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InvitationNoPermissonFragment$mListener$2(InvitationNoPermissonFragment invitationNoPermissonFragment) {
        super(0);
        this.this$0 = invitationNoPermissonFragment;
    }

    public final IInvitationListener invoke() {
        if (!(this.this$0.getActivity() instanceof IInvitationListener)) {
            return null;
        }
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            return (IInvitationListener) activity;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.didi.component.framework.pages.invitation.fragment.IInvitationListener");
    }
}
