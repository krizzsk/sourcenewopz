package com.didi.component.substitute.call.contacts;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.ConfirmListener;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.substitute.call.model.ContactModel;
import com.didi.component.substitute.call.widget.HistoryContactsAdapter;
import com.didi.global.globaluikit.utils.UIThreadHandler;
import com.didi.sdk.view.dialog.LongPressDialog;
import com.didi.travel.psnger.model.response.estimate.daijiao.FriendItem;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SubstituteCallHistorySheet.kt */
final class SubstituteCallHistorySheet$initView$2$longClick$1 implements View.OnClickListener {
    final /* synthetic */ FriendItem $data;
    final /* synthetic */ LongPressDialog $longPressDialog;
    final /* synthetic */ SubstituteCallHistorySheet this$0;

    SubstituteCallHistorySheet$initView$2$longClick$1(FriendItem friendItem, SubstituteCallHistorySheet substituteCallHistorySheet, LongPressDialog longPressDialog) {
        this.$data = friendItem;
        this.this$0 = substituteCallHistorySheet;
        this.$longPressDialog = longPressDialog;
    }

    public final void onClick(View view) {
        List data;
        AutoTrackHelper.trackViewOnClick(view);
        ContactModel contactModel = new ContactModel();
        contactModel.setId(this.$data.getFriendId());
        contactModel.setType(2);
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Estimate.EVENT_SIMPLE_REQUEST_SUBSTITUTE_CALL, contactModel);
        HistoryContactsAdapter access$getMAdapter$p = this.this$0.f16065b;
        if (!(access$getMAdapter$p == null || (data = access$getMAdapter$p.getData()) == null)) {
            FriendItem friendItem = this.$data;
            SubstituteCallHistorySheet substituteCallHistorySheet = this.this$0;
            int indexOf = data.indexOf(friendItem);
            data.remove(indexOf);
            HistoryContactsAdapter access$getMAdapter$p2 = substituteCallHistorySheet.f16065b;
            if (access$getMAdapter$p2 != null) {
                access$getMAdapter$p2.notifyItemRemoved(indexOf);
            }
            UIThreadHandler.post(new SubstituteCallHistorySheet$initView$2$longClick$1$1$1(substituteCallHistorySheet), 200);
            if (friendItem.isSelected() == 1) {
                ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
                if (confirmListener != null && confirmListener.getIsAnyCar()) {
                    BaseEventPublisher.getPublisher().publish(BaseEventKeys.Estimate.ESTIMATE_GET_ESTIMATE);
                }
                ((FriendItem) data.get(0)).setSelected(1);
                HistoryContactsAdapter access$getMAdapter$p3 = substituteCallHistorySheet.f16065b;
                if (access$getMAdapter$p3 != null) {
                    access$getMAdapter$p3.notifyItemChanged(0);
                }
                FormStore.getInstance().setSelectedFriend((FriendItem) data.get(0));
            }
        }
        this.$longPressDialog.dismiss();
    }
}
