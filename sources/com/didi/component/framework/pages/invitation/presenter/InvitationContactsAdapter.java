package com.didi.component.framework.pages.invitation.presenter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.didi.component.common.adapter.CommonRvAdapter;
import com.didi.component.common.adapter.CommonRvVH;
import com.didi.component.framework.pages.invitation.helper.InvitationItemClickedListener;
import com.didi.component.framework.pages.invitation.model.InviteContactInfo;
import com.didi.sdk.util.ResourcesHelper;
import com.taxis99.R;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010!\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\u0002J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0002J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\tJ\u0014\u0010\u0016\u001a\u00020\u000b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/component/framework/pages/invitation/presenter/InvitationContactsAdapter;", "Lcom/didi/component/common/adapter/CommonRvAdapter;", "Lcom/didi/component/framework/pages/invitation/model/InviteContactInfo;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "listener", "Lcom/didi/component/framework/pages/invitation/helper/InvitationItemClickedListener;", "bindData", "", "holder", "Lcom/didi/component/common/adapter/CommonRvVH;", "position", "", "bindDataToView", "item", "generateItemLayout", "getLayoutResourceId", "setInviteBtnClickedListener", "clickedListener", "updateListData", "datas", "", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InvitationContactsAdapter.kt */
public final class InvitationContactsAdapter extends CommonRvAdapter<InviteContactInfo> {

    /* renamed from: a */
    private final Context f13911a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public InvitationItemClickedListener f13912b;

    public final Context getContext() {
        return this.f13911a;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InvitationContactsAdapter(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f13911a = context;
    }

    public void bindData(CommonRvVH commonRvVH, int i) {
        List mData = getMData();
        Intrinsics.checkNotNull(mData);
        bindDataToView(commonRvVH, (InviteContactInfo) mData.get(i));
    }

    public int getLayoutResourceId(int i) {
        Collection mData = getMData();
        if (mData == null || mData.isEmpty()) {
            return R.layout.global_invitation_no_person_layout;
        }
        List mData2 = getMData();
        Intrinsics.checkNotNull(mData2);
        return generateItemLayout((InviteContactInfo) mData2.get(i));
    }

    public final void updateListData(List<InviteContactInfo> list) {
        Intrinsics.checkNotNullParameter(list, "datas");
        setMData(list);
        notifyDataSetChanged();
    }

    public final int generateItemLayout(InviteContactInfo inviteContactInfo) {
        Intrinsics.checkNotNullParameter(inviteContactInfo, "item");
        return inviteContactInfo.getType() == 2002 ? R.layout.global_invitation_contacts_divide_item : R.layout.global_invitation_contacts_item;
    }

    public final void bindDataToView(CommonRvVH commonRvVH, InviteContactInfo inviteContactInfo) {
        TextView textView;
        TextView textView2;
        Intrinsics.checkNotNullParameter(inviteContactInfo, "item");
        View view = null;
        TextView textView3 = commonRvVH == null ? null : commonRvVH.getTextView(R.id.invite_contacts_item_title);
        if (commonRvVH == null) {
            textView = null;
        } else {
            textView = commonRvVH.getTextView(R.id.invite_contacts_item_subtitle);
        }
        if (commonRvVH == null) {
            textView2 = null;
        } else {
            textView2 = commonRvVH.getTextView(R.id.invite_contacts_item_invite_btn);
        }
        if (commonRvVH != null) {
            view = commonRvVH.getTargetView(R.id.invite_contacts_item_extra);
        }
        if (view != null) {
            view.setVisibility(8);
        }
        if (textView3 != null) {
            CharSequence name = inviteContactInfo.getName();
            textView3.setText(name == null || name.length() == 0 ? inviteContactInfo.getPhone() : inviteContactInfo.getName());
        }
        int type = inviteContactInfo.getType();
        if (type == 2000) {
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            if (textView != null) {
                textView.setVisibility(0);
            }
            if (textView != null) {
                textView.setText(ResourcesHelper.getString(this.f13911a, R.string.Global_Rider_MgM_new_campaign_page_Use_DMeM));
            }
            if (textView2 != null) {
                textView2.setOnClickListener(new InvitationContactsAdapter$bindDataToView$1(this, inviteContactInfo));
            }
        } else if (type == 2001) {
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            if (textView != null) {
                textView.setVisibility(8);
            }
        }
    }

    public final void setInviteBtnClickedListener(InvitationItemClickedListener invitationItemClickedListener) {
        Intrinsics.checkNotNullParameter(invitationItemClickedListener, "clickedListener");
        this.f13912b = invitationItemClickedListener;
    }
}
