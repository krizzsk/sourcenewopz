package com.didi.soda.address.edit.binder;

import com.didi.soda.address.edit.binder.EditContactBinder;
import com.didi.soda.customer.foundation.rpc.entity.address.ContactEntity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, mo175978d2 = {"<anonymous>", "Lcom/didi/soda/customer/foundation/rpc/entity/address/ContactEntity;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: EditContactBinder.kt */
final class EditContactBinder$bind$7 extends Lambda implements Function0<ContactEntity> {
    final /* synthetic */ EditContactBinder.ViewHolder $holder;
    final /* synthetic */ ContactEntity $item;
    final /* synthetic */ EditContactBinder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EditContactBinder$bind$7(EditContactBinder.ViewHolder viewHolder, ContactEntity contactEntity, EditContactBinder editContactBinder) {
        super(0);
        this.$holder = viewHolder;
        this.$item = contactEntity;
        this.this$0 = editContactBinder;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0112, code lost:
        if ((r1 == null || r1.length() == 0) != false) goto L_0x0114;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.didi.soda.customer.foundation.rpc.entity.address.ContactEntity invoke() {
        /*
            r10 = this;
            com.didi.soda.customer.foundation.rpc.entity.address.ContactEntity r0 = new com.didi.soda.customer.foundation.rpc.entity.address.ContactEntity
            r0.<init>()
            com.didi.soda.address.edit.binder.EditContactBinder$ViewHolder r1 = r10.$holder
            android.widget.EditText r1 = r1.getFirstName()
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r2 = r1.length()
            r3 = 1
            int r2 = r2 - r3
            r4 = 0
            r5 = 0
            r6 = 0
        L_0x001e:
            r7 = 32
            if (r5 > r2) goto L_0x0043
            if (r6 != 0) goto L_0x0026
            r8 = r5
            goto L_0x0027
        L_0x0026:
            r8 = r2
        L_0x0027:
            char r8 = r1.charAt(r8)
            int r8 = kotlin.jvm.internal.Intrinsics.compare((int) r8, (int) r7)
            if (r8 > 0) goto L_0x0033
            r8 = 1
            goto L_0x0034
        L_0x0033:
            r8 = 0
        L_0x0034:
            if (r6 != 0) goto L_0x003d
            if (r8 != 0) goto L_0x003a
            r6 = 1
            goto L_0x001e
        L_0x003a:
            int r5 = r5 + 1
            goto L_0x001e
        L_0x003d:
            if (r8 != 0) goto L_0x0040
            goto L_0x0043
        L_0x0040:
            int r2 = r2 + -1
            goto L_0x001e
        L_0x0043:
            int r2 = r2 + r3
            java.lang.CharSequence r1 = r1.subSequence(r5, r2)
            java.lang.String r1 = r1.toString()
            com.didi.soda.address.edit.binder.EditContactBinder$ViewHolder r2 = r10.$holder
            android.widget.EditText r2 = r2.getLastName()
            android.text.Editable r2 = r2.getText()
            java.lang.String r2 = r2.toString()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r5 = r2.length()
            int r5 = r5 - r3
            r6 = 0
            r8 = 0
        L_0x0063:
            if (r6 > r5) goto L_0x0086
            if (r8 != 0) goto L_0x0069
            r9 = r6
            goto L_0x006a
        L_0x0069:
            r9 = r5
        L_0x006a:
            char r9 = r2.charAt(r9)
            int r9 = kotlin.jvm.internal.Intrinsics.compare((int) r9, (int) r7)
            if (r9 > 0) goto L_0x0076
            r9 = 1
            goto L_0x0077
        L_0x0076:
            r9 = 0
        L_0x0077:
            if (r8 != 0) goto L_0x0080
            if (r9 != 0) goto L_0x007d
            r8 = 1
            goto L_0x0063
        L_0x007d:
            int r6 = r6 + 1
            goto L_0x0063
        L_0x0080:
            if (r9 != 0) goto L_0x0083
            goto L_0x0086
        L_0x0083:
            int r5 = r5 + -1
            goto L_0x0063
        L_0x0086:
            int r5 = r5 + r3
            java.lang.CharSequence r2 = r2.subSequence(r6, r5)
            java.lang.String r2 = r2.toString()
            r0.setName(r1, r2)
            com.didi.soda.address.edit.binder.EditContactBinder$ViewHolder r1 = r10.$holder
            android.widget.EditText r1 = r1.getPhone()
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r2 = r1.length()
            int r2 = r2 - r3
            r5 = 0
            r6 = 0
        L_0x00a9:
            if (r5 > r2) goto L_0x00cc
            if (r6 != 0) goto L_0x00af
            r8 = r5
            goto L_0x00b0
        L_0x00af:
            r8 = r2
        L_0x00b0:
            char r8 = r1.charAt(r8)
            int r8 = kotlin.jvm.internal.Intrinsics.compare((int) r8, (int) r7)
            if (r8 > 0) goto L_0x00bc
            r8 = 1
            goto L_0x00bd
        L_0x00bc:
            r8 = 0
        L_0x00bd:
            if (r6 != 0) goto L_0x00c6
            if (r8 != 0) goto L_0x00c3
            r6 = 1
            goto L_0x00a9
        L_0x00c3:
            int r5 = r5 + 1
            goto L_0x00a9
        L_0x00c6:
            if (r8 != 0) goto L_0x00c9
            goto L_0x00cc
        L_0x00c9:
            int r2 = r2 + -1
            goto L_0x00a9
        L_0x00cc:
            int r2 = r2 + r3
            java.lang.CharSequence r1 = r1.subSequence(r5, r2)
            java.lang.String r1 = r1.toString()
            r0.phone = r1
            com.didi.soda.customer.foundation.rpc.entity.address.ContactEntity r1 = r10.$item
            java.lang.String r1 = r1.callingCode
            r0.callingCode = r1
            com.didi.soda.customer.foundation.rpc.entity.address.ContactEntity r1 = r10.$item
            int r1 = r1.countryId
            r0.countryId = r1
            com.didi.soda.address.edit.binder.EditContactBinder r1 = r10.this$0
            boolean r1 = r1.isCheckNameEmpty
            r2 = 0
            if (r1 == 0) goto L_0x011f
            java.lang.String r1 = r0.getFirstName()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x00fd
            int r1 = r1.length()
            if (r1 != 0) goto L_0x00fb
            goto L_0x00fd
        L_0x00fb:
            r1 = 0
            goto L_0x00fe
        L_0x00fd:
            r1 = 1
        L_0x00fe:
            if (r1 != 0) goto L_0x0114
            java.lang.String r1 = r0.getLastName()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x0111
            int r1 = r1.length()
            if (r1 != 0) goto L_0x010f
            goto L_0x0111
        L_0x010f:
            r1 = 0
            goto L_0x0112
        L_0x0111:
            r1 = 1
        L_0x0112:
            if (r1 == 0) goto L_0x011f
        L_0x0114:
            com.didi.soda.address.edit.binder.EditContactBinder r0 = r10.this$0
            com.didi.soda.address.edit.binder.EditContactBinder$ViewHolder r1 = r10.$holder
            r0.showNameEmpty(r1)
            r0 = r2
            com.didi.soda.customer.foundation.rpc.entity.address.ContactEntity r0 = (com.didi.soda.customer.foundation.rpc.entity.address.ContactEntity) r0
            goto L_0x0159
        L_0x011f:
            java.lang.String r1 = r0.phone
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x012d
            int r1 = r1.length()
            if (r1 != 0) goto L_0x012c
            goto L_0x012d
        L_0x012c:
            r3 = 0
        L_0x012d:
            if (r3 == 0) goto L_0x0159
            r0 = 2131953958(0x7f130926, float:1.9544402E38)
            java.lang.String r0 = com.didi.soda.customer.foundation.util.ResourceHelper.getString(r0)
            com.didi.soda.address.edit.binder.EditContactBinder$ViewHolder r1 = r10.$holder
            android.widget.TextView r1 = r1.getPhoneErrorHintView()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1.setText(r0)
            com.didi.soda.address.edit.binder.EditContactBinder$ViewHolder r0 = r10.$holder
            android.widget.TextView r0 = r0.getPhoneErrorHintView()
            r0.setVisibility(r4)
            com.didi.soda.address.edit.binder.EditContactBinder$ViewHolder r0 = r10.$holder
            android.view.View r0 = r0.getPhoneLine()
            r1 = 2131101454(0x7f06070e, float:1.7815318E38)
            r0.setBackgroundResource(r1)
            r0 = r2
            com.didi.soda.customer.foundation.rpc.entity.address.ContactEntity r0 = (com.didi.soda.customer.foundation.rpc.entity.address.ContactEntity) r0
        L_0x0159:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.address.edit.binder.EditContactBinder$bind$7.invoke():com.didi.soda.customer.foundation.rpc.entity.address.ContactEntity");
    }
}
