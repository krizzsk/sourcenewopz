package com.didi.component.substitute.call.contacts;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.component.substitute.call.widget.HistoryContactsAdapter;
import com.didi.sdk.view.dialog.LongPressDialog;
import com.didi.travel.psnger.model.response.estimate.daijiao.FriendItem;
import com.taxis99.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, mo175978d2 = {"com/didi/component/substitute/call/contacts/SubstituteCallHistorySheet$initView$2", "Lcom/didi/component/substitute/call/contacts/HistoryItemCallback;", "click", "", "data", "Lcom/didi/travel/psnger/model/response/estimate/daijiao/FriendItem;", "longClick", "", "comp-substitute-call_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SubstituteCallHistorySheet.kt */
public final class SubstituteCallHistorySheet$initView$2 implements HistoryItemCallback {
    final /* synthetic */ SubstituteCallHistorySheet this$0;

    SubstituteCallHistorySheet$initView$2(SubstituteCallHistorySheet substituteCallHistorySheet) {
        this.this$0 = substituteCallHistorySheet;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0011, code lost:
        r0 = r0.getData();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void click(com.didi.travel.psnger.model.response.estimate.daijiao.FriendItem r6) {
        /*
            r5 = this;
            java.lang.String r0 = "data"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            com.didi.component.substitute.call.contacts.SubstituteCallHistorySheet r0 = r5.this$0
            com.didi.component.substitute.call.widget.HistoryContactsAdapter r0 = r0.f16065b
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0011
        L_0x000f:
            r0 = 0
            goto L_0x001f
        L_0x0011:
            java.util.List r0 = r0.getData()
            if (r0 != 0) goto L_0x0018
            goto L_0x000f
        L_0x0018:
            int r0 = r0.indexOf(r6)
            if (r0 != 0) goto L_0x000f
            r0 = 1
        L_0x001f:
            if (r0 != 0) goto L_0x0038
            com.didi.component.business.data.form.FormStore r0 = com.didi.component.business.data.form.FormStore.getInstance()
            java.lang.String r3 = r6.getName()
            r0.setSubstituteCallText(r3)
            com.didi.component.business.data.form.FormStore r0 = com.didi.component.business.data.form.FormStore.getInstance()
            java.lang.String r3 = r6.getPortrait()
            r0.setSubstituteCallIcon(r3)
            goto L_0x0066
        L_0x0038:
            com.didi.component.business.data.form.FormStore r0 = com.didi.component.business.data.form.FormStore.getInstance()
            com.didi.component.business.data.form.FormStore r3 = com.didi.component.business.data.form.FormStore.getInstance()
            com.didi.travel.psnger.model.response.estimate.daijiao.SubstituteCallModel r3 = r3.getSubstituteCallModel()
            r4 = 0
            if (r3 != 0) goto L_0x0049
            r3 = r4
            goto L_0x004d
        L_0x0049:
            java.lang.String r3 = r3.getDefaultText()
        L_0x004d:
            r0.setSubstituteCallText(r3)
            com.didi.component.business.data.form.FormStore r0 = com.didi.component.business.data.form.FormStore.getInstance()
            com.didi.component.business.data.form.FormStore r3 = com.didi.component.business.data.form.FormStore.getInstance()
            com.didi.travel.psnger.model.response.estimate.daijiao.SubstituteCallModel r3 = r3.getSubstituteCallModel()
            if (r3 != 0) goto L_0x005f
            goto L_0x0063
        L_0x005f:
            java.lang.String r4 = r3.getDefaultIcon()
        L_0x0063:
            r0.setSubstituteCallIcon(r4)
        L_0x0066:
            com.didi.component.core.event.BaseEventPublisher r0 = com.didi.component.core.event.BaseEventPublisher.getPublisher()
            java.lang.String r3 = "event_form_item_change"
            r0.publish(r3)
            int r0 = r6.isSelected()
            if (r0 != r1) goto L_0x007b
            com.didi.component.substitute.call.contacts.SubstituteCallHistorySheet r6 = r5.this$0
            r6.dismiss()
            goto L_0x00e2
        L_0x007b:
            com.didi.component.business.data.form.PageCompDataTransfer r0 = com.didi.component.business.data.form.PageCompDataTransfer.getInstance()
            com.didi.component.business.data.form.listener.ConfirmListener r0 = r0.getConfirmListener()
            if (r0 == 0) goto L_0x0094
            boolean r0 = r0.getIsAnyCar()
            if (r0 == 0) goto L_0x0094
            com.didi.component.core.event.BaseEventPublisher r0 = com.didi.component.core.event.BaseEventPublisher.getPublisher()
            java.lang.String r3 = "estimate_get_estimate"
            r0.publish(r3)
        L_0x0094:
            com.didi.component.substitute.call.contacts.SubstituteCallHistorySheet r0 = r5.this$0
            com.didi.component.substitute.call.widget.HistoryContactsAdapter r0 = r0.f16065b
            if (r0 != 0) goto L_0x009d
            goto L_0x00be
        L_0x009d:
            java.util.List r0 = r0.getData()
            if (r0 != 0) goto L_0x00a4
            goto L_0x00be
        L_0x00a4:
            java.util.Iterator r0 = r0.iterator()
        L_0x00a8:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x00be
            java.lang.Object r3 = r0.next()
            com.didi.travel.psnger.model.response.estimate.daijiao.FriendItem r3 = (com.didi.travel.psnger.model.response.estimate.daijiao.FriendItem) r3
            int r4 = r3.isSelected()
            if (r4 != r1) goto L_0x00a8
            r3.setSelected(r2)
            goto L_0x00a8
        L_0x00be:
            r6.setSelected(r1)
            com.didi.component.business.data.form.FormStore r0 = com.didi.component.business.data.form.FormStore.getInstance()
            r0.setSelectedFriend(r6)
            com.didi.component.substitute.call.contacts.SubstituteCallHistorySheet r6 = r5.this$0
            com.didi.component.substitute.call.widget.HistoryContactsAdapter r6 = r6.f16065b
            if (r6 != 0) goto L_0x00d1
            goto L_0x00d4
        L_0x00d1:
            r6.notifyDataSetChanged()
        L_0x00d4:
            com.didi.component.substitute.call.contacts.SubstituteCallHistorySheet$initView$2$click$2 r6 = new com.didi.component.substitute.call.contacts.SubstituteCallHistorySheet$initView$2$click$2
            com.didi.component.substitute.call.contacts.SubstituteCallHistorySheet r0 = r5.this$0
            r6.<init>(r0)
            java.lang.Runnable r6 = (java.lang.Runnable) r6
            r0 = 200(0xc8, double:9.9E-322)
            com.didi.global.globaluikit.utils.UIThreadHandler.post(r6, r0)
        L_0x00e2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.substitute.call.contacts.SubstituteCallHistorySheet$initView$2.click(com.didi.travel.psnger.model.response.estimate.daijiao.FriendItem):void");
    }

    public boolean longClick(FriendItem friendItem) {
        List data;
        Intrinsics.checkNotNullParameter(friendItem, "data");
        HistoryContactsAdapter access$getMAdapter$p = this.this$0.f16065b;
        boolean z = false;
        if (!(access$getMAdapter$p == null || (data = access$getMAdapter$p.getData()) == null || data.indexOf(friendItem) != 0)) {
            z = true;
        }
        if (z) {
            return true;
        }
        LongPressDialog longPressDialog = new LongPressDialog();
        longPressDialog.setupButton(this.this$0.getString(R.string.history_record_title_delete), new SubstituteCallHistorySheet$initView$2$longClick$1(friendItem, this.this$0, longPressDialog));
        longPressDialog.setCancelable(true);
        try {
            FragmentActivity activity = this.this$0.getActivity();
            if (activity != null) {
                FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
                if (supportFragmentManager != null) {
                    longPressDialog.show(supportFragmentManager, (String) null);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
