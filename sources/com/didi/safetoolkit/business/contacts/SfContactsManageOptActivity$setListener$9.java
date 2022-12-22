package com.didi.safetoolkit.business.contacts;

import android.view.View;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo175978d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo175979k = 3, mo175980mv = {1, 1, 15})
/* compiled from: SfContactsManageOptActivity.kt */
final class SfContactsManageOptActivity$setListener$9 implements View.OnClickListener {
    final /* synthetic */ SfContactsManageOptActivity this$0;

    SfContactsManageOptActivity$setListener$9(SfContactsManageOptActivity sfContactsManageOptActivity) {
        this.this$0 = sfContactsManageOptActivity;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0019, code lost:
        r1 = r1.getText();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r4) {
        /*
            r3 = this;
            com.didi.autotracker.AutoTrackHelper.trackViewOnClick(r4)
            com.didi.safetoolkit.business.contacts.SfContactsManageOptActivity r4 = r3.this$0
            com.didi.safetoolkit.business.share.controller.SfGetOptController r4 = r4.f34312i
            if (r4 == 0) goto L_0x004c
            com.didi.safetoolkit.model.SfContactsModel r0 = new com.didi.safetoolkit.model.SfContactsModel
            r0.<init>()
            com.didi.safetoolkit.business.contacts.SfContactsManageOptActivity r1 = r3.this$0
            android.widget.EditText r1 = r1.f34306c
            r2 = 0
            if (r1 == 0) goto L_0x0024
            android.text.Editable r1 = r1.getText()
            if (r1 == 0) goto L_0x0024
            java.lang.String r1 = r1.toString()
            goto L_0x0025
        L_0x0024:
            r1 = r2
        L_0x0025:
            r0.phone = r1
            com.didi.safetoolkit.business.contacts.SfContactsManageOptActivity r1 = r3.this$0
            android.widget.EditText r1 = r1.f34305b
            if (r1 == 0) goto L_0x0039
            android.text.Editable r1 = r1.getText()
            if (r1 == 0) goto L_0x0039
            java.lang.String r2 = r1.toString()
        L_0x0039:
            r1 = r2
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0045
            r0.name = r2
            goto L_0x0049
        L_0x0045:
            java.lang.String r1 = r0.phone
            r0.name = r1
        L_0x0049:
            r4.addContact(r0)
        L_0x004c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.safetoolkit.business.contacts.SfContactsManageOptActivity$setListener$9.onClick(android.view.View):void");
    }
}
