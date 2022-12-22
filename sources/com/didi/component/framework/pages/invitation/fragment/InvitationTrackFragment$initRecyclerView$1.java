package com.didi.component.framework.pages.invitation.fragment;

import androidx.fragment.app.FragmentActivity;
import com.didi.component.common.adapter.CommonRvAdapter;
import com.didi.component.common.adapter.CommonRvVH;
import com.didi.component.framework.pages.invitation.item.TrackItem;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, mo175978d2 = {"com/didi/component/framework/pages/invitation/fragment/InvitationTrackFragment$initRecyclerView$1", "Lcom/didi/component/common/adapter/CommonRvAdapter;", "Lcom/didi/component/framework/pages/invitation/item/TrackItem;", "bindData", "", "holder", "Lcom/didi/component/common/adapter/CommonRvVH;", "position", "", "getLayoutResourceId", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InvitationTrackFragment.kt */
public final class InvitationTrackFragment$initRecyclerView$1 extends CommonRvAdapter<TrackItem> {
    final /* synthetic */ InvitationTrackFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InvitationTrackFragment$initRecyclerView$1(InvitationTrackFragment invitationTrackFragment, FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        this.this$0 = invitationTrackFragment;
        Intrinsics.checkNotNullExpressionValue(fragmentActivity, "requireActivity()");
    }

    public int getLayoutResourceId(int i) {
        Collection mData = getMData();
        if (mData == null || mData.isEmpty()) {
            return -1;
        }
        InvitationTrackFragment invitationTrackFragment = this.this$0;
        List mData2 = getMData();
        Intrinsics.checkNotNull(mData2);
        return invitationTrackFragment.m9622a(((TrackItem) mData2.get(i)).getType());
    }

    public void bindData(CommonRvVH commonRvVH, int i) {
        InvitationTrackFragment invitationTrackFragment = this.this$0;
        List mData = getMData();
        Intrinsics.checkNotNull(mData);
        invitationTrackFragment.m9625a(commonRvVH, (TrackItem) mData.get(i));
    }
}
