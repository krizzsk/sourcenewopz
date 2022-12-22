package com.didi.payment.pix.contacts;

import com.didi.payment.commonsdk.p129ui.WBaseActivity;
import com.didi.payment.pix.contacts.p134vm.HistoryContacksVM;
import com.taxis99.R;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0006\u0010\u0006\u001a\u00020\u0007J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\t\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014¨\u0006\f"}, mo175978d2 = {"Lcom/didi/payment/pix/contacts/PixTransferMainEntranceActivity;", "Lcom/didi/payment/commonsdk/ui/WBaseActivity;", "Lcom/didi/payment/pix/contacts/vm/HistoryContacksVM;", "()V", "getFragmentContainer", "", "initViews", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixTransferMainEntranceActivity.kt */
public final class PixTransferMainEntranceActivity extends WBaseActivity<HistoryContacksVM> {
    public int getFragmentContainer() {
        return R.id.fragment_container;
    }

    public final void initViews() {
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0022, code lost:
        r1 = r1.getExtras();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r9) {
        /*
            r8 = this;
            com.didi.sdk.apm.SystemUtils.hookOnlyFullscreenOpaque(r8)
            super.onCreate(r9)
            r9 = 2131624075(0x7f0e008b, float:1.887532E38)
            r8.setContentView((int) r9)
            android.content.Intent r9 = r8.getIntent()
            java.lang.String r0 = "source_page"
            java.lang.String r9 = r9.getStringExtra(r0)
            android.content.Intent r1 = r8.getIntent()
            java.lang.String r2 = "pix_account"
            r3 = 1
            r4 = 0
            if (r1 != 0) goto L_0x0022
        L_0x0020:
            r1 = 0
            goto L_0x0030
        L_0x0022:
            android.os.Bundle r1 = r1.getExtras()
            if (r1 != 0) goto L_0x0029
            goto L_0x0020
        L_0x0029:
            boolean r1 = r1.containsKey(r2)
            if (r1 != r3) goto L_0x0020
            r1 = 1
        L_0x0030:
            java.lang.String r5 = "fragment"
            java.lang.String r6 = "history_payee_list_tag"
            r7 = 2131430838(0x7f0b0db6, float:1.8483388E38)
            if (r1 == 0) goto L_0x0076
            android.content.Intent r1 = r8.getIntent()
            java.io.Serializable r1 = r1.getSerializableExtra(r2)
            if (r1 != 0) goto L_0x0045
            goto L_0x0132
        L_0x0045:
            java.lang.Class<com.didi.payment.pix.transfer.fragment.PixTransferAmountEditFragment> r3 = com.didi.payment.pix.transfer.fragment.PixTransferAmountEditFragment.class
            java.lang.Object r3 = r3.newInstance()
            com.didi.payment.pix.transfer.fragment.PixTransferAmountEditFragment r3 = (com.didi.payment.pix.transfer.fragment.PixTransferAmountEditFragment) r3
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            if (r1 == 0) goto L_0x006e
            com.didi.payment.pix.net.response.PixKeyVerifyResp$PixAccount r1 = (com.didi.payment.pix.net.response.PixKeyVerifyResp.PixAccount) r1
            java.io.Serializable r1 = (java.io.Serializable) r1
            r4.putSerializable(r2, r1)
            if (r9 != 0) goto L_0x005e
            goto L_0x0061
        L_0x005e:
            r4.putString(r0, r9)
        L_0x0061:
            r3.setArguments(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            androidx.fragment.app.Fragment r3 = (androidx.fragment.app.Fragment) r3
            r8.attachRootFragment((androidx.fragment.app.Fragment) r3, (int) r7, (java.lang.String) r6)
            goto L_0x0132
        L_0x006e:
            java.lang.NullPointerException r9 = new java.lang.NullPointerException
            java.lang.String r0 = "null cannot be cast to non-null type com.didi.payment.pix.net.response.PixKeyVerifyResp.PixAccount"
            r9.<init>(r0)
            throw r9
        L_0x0076:
            android.content.Intent r1 = r8.getIntent()
            java.lang.String r2 = "detected_qrcode"
            if (r1 != 0) goto L_0x0080
        L_0x007e:
            r1 = 0
            goto L_0x008e
        L_0x0080:
            android.os.Bundle r1 = r1.getExtras()
            if (r1 != 0) goto L_0x0087
            goto L_0x007e
        L_0x0087:
            boolean r1 = r1.containsKey(r2)
            if (r1 != r3) goto L_0x007e
            r1 = 1
        L_0x008e:
            if (r1 == 0) goto L_0x00cc
            android.content.Intent r1 = r8.getIntent()
            java.io.Serializable r1 = r1.getSerializableExtra(r2)
            if (r1 != 0) goto L_0x009c
            goto L_0x0132
        L_0x009c:
            java.lang.Class<com.didi.payment.pix.transfer.fragment.PixTransferAmountEditFragment> r3 = com.didi.payment.pix.transfer.fragment.PixTransferAmountEditFragment.class
            java.lang.Object r3 = r3.newInstance()
            com.didi.payment.pix.transfer.fragment.PixTransferAmountEditFragment r3 = (com.didi.payment.pix.transfer.fragment.PixTransferAmountEditFragment) r3
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            if (r1 == 0) goto L_0x00c4
            com.didi.payment.commonsdk.net.PixQrCodeQueryResp$QRCodeData r1 = (com.didi.payment.commonsdk.net.PixQrCodeQueryResp.QRCodeData) r1
            java.io.Serializable r1 = (java.io.Serializable) r1
            r4.putSerializable(r2, r1)
            if (r9 != 0) goto L_0x00b5
            goto L_0x00b8
        L_0x00b5:
            r4.putString(r0, r9)
        L_0x00b8:
            r3.setArguments(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            androidx.fragment.app.Fragment r3 = (androidx.fragment.app.Fragment) r3
            r8.attachRootFragment((androidx.fragment.app.Fragment) r3, (int) r7, (java.lang.String) r6)
            goto L_0x0132
        L_0x00c4:
            java.lang.NullPointerException r9 = new java.lang.NullPointerException
            java.lang.String r0 = "null cannot be cast to non-null type com.didi.payment.commonsdk.net.PixQrCodeQueryResp.QRCodeData"
            r9.<init>(r0)
            throw r9
        L_0x00cc:
            android.content.Intent r9 = r8.getIntent()
            java.lang.String r0 = "target_fragment"
            if (r9 != 0) goto L_0x00d6
        L_0x00d4:
            r3 = 0
            goto L_0x00e3
        L_0x00d6:
            android.os.Bundle r9 = r9.getExtras()
            if (r9 != 0) goto L_0x00dd
            goto L_0x00d4
        L_0x00dd:
            boolean r9 = r9.containsKey(r0)
            if (r9 != r3) goto L_0x00d4
        L_0x00e3:
            if (r3 == 0) goto L_0x0122
            android.content.Intent r9 = r8.getIntent()
            java.lang.String r9 = r9.getStringExtra(r0)
            android.content.Intent r0 = r8.getIntent()
            java.lang.String r1 = "source"
            java.lang.String r0 = r0.getStringExtra(r1)
            java.lang.String r2 = "/pix_bank_transfer"
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r2)
            if (r9 == 0) goto L_0x0132
            java.lang.Class<com.didi.payment.pix.transfer.fragment.PixNewBankAccountFragment> r9 = com.didi.payment.pix.transfer.fragment.PixNewBankAccountFragment.class
            java.lang.Object r9 = r9.newInstance()
            com.didi.payment.pix.transfer.fragment.PixNewBankAccountFragment r9 = (com.didi.payment.pix.transfer.fragment.PixNewBankAccountFragment) r9
            if (r0 != 0) goto L_0x010a
            goto L_0x0115
        L_0x010a:
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            r2.putString(r1, r0)
            r9.setArguments(r2)
        L_0x0115:
            java.lang.String r0 = "instance"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r0)
            androidx.fragment.app.Fragment r9 = (androidx.fragment.app.Fragment) r9
            java.lang.String r0 = "pix_bank_account_tag"
            r8.attachRootFragment((androidx.fragment.app.Fragment) r9, (int) r7, (java.lang.String) r0)
            goto L_0x0132
        L_0x0122:
            java.lang.Class<com.didi.payment.pix.contacts.fragment.PixHistoryPayeeFragment> r9 = com.didi.payment.pix.contacts.fragment.PixHistoryPayeeFragment.class
            java.lang.Object r9 = r9.newInstance()
            java.lang.String r0 = "PixHistoryPayeeFragment::class.java.newInstance()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r0)
            androidx.fragment.app.Fragment r9 = (androidx.fragment.app.Fragment) r9
            r8.attachRootFragment((androidx.fragment.app.Fragment) r9, (int) r7, (java.lang.String) r6)
        L_0x0132:
            r8.initViews()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.pix.contacts.PixTransferMainEntranceActivity.onCreate(android.os.Bundle):void");
    }

    public void onBackPressed() {
        super.onBackPressed();
    }
}
