package com.didi.component.framework.pages.invitation.fragment;

import android.view.View;
import com.didi.component.framework.pages.invitation.helper.INoInvite;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/component/framework/pages/invitation/fragment/InvitationContactsFragment$initRecView$1$onClicked$1$onSuccess$1", "Lcom/didi/component/framework/pages/invitation/helper/INoInvite;", "cancel", "", "dialog", "Lcom/didi/sdk/view/dialog/AlertDialogFragment;", "view", "Landroid/view/View;", "confirm", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InvitationContactsFragment.kt */
public final class InvitationContactsFragment$initRecView$1$onClicked$1$onSuccess$1 implements INoInvite {
    public void cancel(AlertDialogFragment alertDialogFragment, View view) {
    }

    InvitationContactsFragment$initRecView$1$onClicked$1$onSuccess$1() {
    }

    public void confirm(AlertDialogFragment alertDialogFragment, View view) {
        if (alertDialogFragment != null) {
            alertDialogFragment.dismiss();
        }
    }
}
