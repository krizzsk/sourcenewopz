package com.didi.component.framework.pages.invitation.fragment;

import android.widget.Button;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/component/framework/pages/invitation/fragment/InvitationTrackFragment$mScrollerListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InvitationTrackFragment.kt */
public final class InvitationTrackFragment$mScrollerListener$1 extends RecyclerView.OnScrollListener {
    final /* synthetic */ InvitationTrackFragment this$0;

    InvitationTrackFragment$mScrollerListener$1(InvitationTrackFragment invitationTrackFragment) {
        this.this$0 = invitationTrackFragment;
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i, i2);
        if (!recyclerView.canScrollVertically(1)) {
            if (this.this$0.m9634b()) {
                ProgressBar access$getMProgressBar$p = this.this$0.f13860g;
                if (access$getMProgressBar$p != null) {
                    access$getMProgressBar$p.setVisibility(0);
                }
                Button access$getMLoadTextView$p = this.this$0.f13861h;
                if (access$getMLoadTextView$p != null) {
                    access$getMLoadTextView$p.setVisibility(8);
                }
                IInvitationListener access$getMListener$p = this.this$0.f13856c;
                if (access$getMListener$p != null) {
                    boolean access$getMIsTop$p = this.this$0.f13858e;
                    InvitationTrackFragment invitationTrackFragment = this.this$0;
                    invitationTrackFragment.f13857d = invitationTrackFragment.f13857d + 1;
                    access$getMListener$p.updateContactsList(access$getMIsTop$p, invitationTrackFragment.f13857d, true);
                }
            } else {
                ProgressBar access$getMProgressBar$p2 = this.this$0.f13860g;
                if (access$getMProgressBar$p2 != null) {
                    access$getMProgressBar$p2.setVisibility(8);
                }
            }
        }
        this.this$0.m9624a(recyclerView);
    }
}
