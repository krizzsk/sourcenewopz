package com.didi.payment.wallet.global.prepaidcard;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.DialogFragment;
import com.didi.component.comp_xpanel.XPanelScene;
import com.didi.drouter.router.RouterCallback;
import com.didi.payment.wallet.global.model.resp.WalletPopUpWindowResp;
import com.didi.payment.wallet.global.prepaidcard.PrepaidCardManager;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletHomeTrackerManager;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J&\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/prepaidcard/PrepaidApplyDialog;", "Landroidx/fragment/app/DialogFragment;", "resp", "Lcom/didi/payment/wallet/global/model/resp/WalletPopUpWindowResp;", "(Lcom/didi/payment/wallet/global/model/resp/WalletPopUpWindowResp;)V", "getResp", "()Lcom/didi/payment/wallet/global/model/resp/WalletPopUpWindowResp;", "setResp", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PrepaidApplyDialog.kt */
public final class PrepaidApplyDialog extends DialogFragment {

    /* renamed from: a */
    private WalletPopUpWindowResp f31759a;

    public PrepaidApplyDialog(WalletPopUpWindowResp walletPopUpWindowResp) {
        this.f31759a = walletPopUpWindowResp;
    }

    public final WalletPopUpWindowResp getResp() {
        return this.f31759a;
    }

    public final void setResp(WalletPopUpWindowResp walletPopUpWindowResp) {
        this.f31759a = walletPopUpWindowResp;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.WalletHomeDialogStyle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(false);
            dialog.requestWindowFeature(1);
            Window window = dialog.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
            }
            Window window2 = dialog.getWindow();
            WindowManager.LayoutParams attributes = window2 == null ? null : window2.getAttributes();
            if (attributes != null) {
                attributes.windowAnimations = R.style.common_dialog_anim_style;
            }
        }
        return layoutInflater.inflate(R.layout.dialog_prepaid_apply, viewGroup, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x008b, code lost:
        r11 = r11.getData();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onViewCreated(android.view.View r10, android.os.Bundle r11) {
        /*
            r9 = this;
            java.lang.String r11 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r11)
            r11 = 2131435390(0x7f0b1f7e, float:1.849262E38)
            android.view.View r11 = r10.findViewById(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            r0 = 2131435362(0x7f0b1f62, float:1.8492564E38)
            android.view.View r0 = r10.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 2131431863(0x7f0b11b7, float:1.8485467E38)
            android.view.View r1 = r10.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r2 = 2131434912(0x7f0b1da0, float:1.8491651E38)
            android.view.View r2 = r10.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r3 = 2131434954(0x7f0b1dca, float:1.8491737E38)
            android.view.View r3 = r10.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            r4 = 2131431769(0x7f0b1159, float:1.8485277E38)
            android.view.View r10 = r10.findViewById(r4)
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            com.didi.payment.wallet.global.model.resp.WalletPopUpWindowResp r4 = r9.f31759a
            r5 = 0
            if (r4 != 0) goto L_0x0041
            goto L_0x0052
        L_0x0041:
            com.didi.payment.wallet.global.model.resp.WalletPopUpWindowResp$Data r4 = r4.getData()
            if (r4 != 0) goto L_0x0048
            goto L_0x0052
        L_0x0048:
            com.didi.payment.base.view.PayRichInfo r4 = r4.getRewardMessage()
            if (r4 != 0) goto L_0x004f
            goto L_0x0052
        L_0x004f:
            r4.bindTextView(r0, r5)
        L_0x0052:
            com.didi.payment.wallet.global.model.resp.WalletPopUpWindowResp r0 = r9.f31759a
            if (r0 != 0) goto L_0x0057
            goto L_0x0085
        L_0x0057:
            com.didi.payment.wallet.global.model.resp.WalletPopUpWindowResp$Data r0 = r0.getData()
            if (r0 != 0) goto L_0x005e
            goto L_0x0085
        L_0x005e:
            java.lang.String r0 = r0.getTitle()
            if (r0 != 0) goto L_0x0065
            goto L_0x0085
        L_0x0065:
            android.content.Context r4 = r9.getContext()
            if (r4 != 0) goto L_0x006c
            goto L_0x0085
        L_0x006c:
            r6 = 2131101905(0x7f0608d1, float:1.7816233E38)
            int r4 = androidx.core.content.ContextCompat.getColor(r4, r6)
            com.didi.payment.wallet.global.prepaidcard.StringUtils$Companion r6 = com.didi.payment.wallet.global.prepaidcard.StringUtils.Companion
            com.didi.payment.wallet.global.prepaidcard.StringUtils$DefaultFont r7 = new com.didi.payment.wallet.global.prepaidcard.StringUtils$DefaultFont
            r8 = 22
            r7.<init>(r4, r8)
            com.didi.payment.wallet.global.prepaidcard.StringUtils$IFont r7 = (com.didi.payment.wallet.global.prepaidcard.StringUtils.IFont) r7
            java.lang.CharSequence r0 = r6.handleSpecialText(r0, r7)
            r11.setText(r0)
        L_0x0085:
            com.didi.payment.wallet.global.model.resp.WalletPopUpWindowResp r11 = r9.f31759a
            if (r11 != 0) goto L_0x008b
        L_0x0089:
            r11 = r5
            goto L_0x0096
        L_0x008b:
            com.didi.payment.wallet.global.model.resp.WalletPopUpWindowResp$Data r11 = r11.getData()
            if (r11 != 0) goto L_0x0092
            goto L_0x0089
        L_0x0092:
            java.lang.String r11 = r11.getButtonText()
        L_0x0096:
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r3.setText(r11)
            com.didi.payment.wallet.global.model.resp.WalletPopUpWindowResp r11 = r9.f31759a
            if (r11 != 0) goto L_0x00a1
        L_0x009f:
            r11 = r5
            goto L_0x00ac
        L_0x00a1:
            com.didi.payment.wallet.global.model.resp.WalletPopUpWindowResp$Data r11 = r11.getData()
            if (r11 != 0) goto L_0x00a8
            goto L_0x009f
        L_0x00a8:
            java.lang.String r11 = r11.getNegativeButtonText()
        L_0x00ac:
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r2.setText(r11)
            android.content.Context r11 = r9.getContext()
            com.didi.payment.wallet.global.model.resp.WalletPopUpWindowResp r0 = r9.f31759a
            if (r0 != 0) goto L_0x00ba
            goto L_0x00c5
        L_0x00ba:
            com.didi.payment.wallet.global.model.resp.WalletPopUpWindowResp$Data r0 = r0.getData()
            if (r0 != 0) goto L_0x00c1
            goto L_0x00c5
        L_0x00c1:
            java.lang.String r5 = r0.getPictureUrl()
        L_0x00c5:
            com.didi.payment.base.utils.GlideUtils.with2load2into(r11, r5, r1)
            com.didi.payment.wallet.global.prepaidcard.-$$Lambda$PrepaidApplyDialog$XC6KW79H21-8TEAKytRbAwFvkJw r11 = new com.didi.payment.wallet.global.prepaidcard.-$$Lambda$PrepaidApplyDialog$XC6KW79H21-8TEAKytRbAwFvkJw
            r11.<init>()
            r3.setOnClickListener(r11)
            com.didi.payment.wallet.global.prepaidcard.-$$Lambda$PrepaidApplyDialog$CYSbJn0Umz9Uxxtd07LXcvVdZuI r11 = new com.didi.payment.wallet.global.prepaidcard.-$$Lambda$PrepaidApplyDialog$CYSbJn0Umz9Uxxtd07LXcvVdZuI
            r11.<init>()
            r2.setOnClickListener(r11)
            com.didi.payment.wallet.global.prepaidcard.-$$Lambda$PrepaidApplyDialog$wDJeMwbp_aheRxmftrSSertvdgI r11 = new com.didi.payment.wallet.global.prepaidcard.-$$Lambda$PrepaidApplyDialog$wDJeMwbp_aheRxmftrSSertvdgI
            r11.<init>()
            r10.setOnClickListener(r11)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletHomeTrackerManager$Companion r10 = com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletHomeTrackerManager.Companion
            r10.trackHomePrepaidDialog()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.wallet.global.prepaidcard.PrepaidApplyDialog.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m22523a(PrepaidApplyDialog prepaidApplyDialog, View view) {
        Intrinsics.checkNotNullParameter(prepaidApplyDialog, "this$0");
        PrepaidCardManager.Companion.start$default(PrepaidCardManager.Companion, prepaidApplyDialog.getContext(), PrepaidSource.HOME_DIALOG.getValue(), PrepaidConstant.SCENE_APPLY, WalletHomeTrackerManager.Companion.getStatus(), "1", (String) null, (RouterCallback) null, 96, (Object) null);
        prepaidApplyDialog.dismiss();
        WalletHomeTrackerManager.Companion.trackHomePrepaidDialogClick(XPanelScene.SCENE_CONFIRM);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m22524b(PrepaidApplyDialog prepaidApplyDialog, View view) {
        Intrinsics.checkNotNullParameter(prepaidApplyDialog, "this$0");
        WalletHomeTrackerManager.Companion.trackHomePrepaidDialogClick("cancel");
        prepaidApplyDialog.dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m22525c(PrepaidApplyDialog prepaidApplyDialog, View view) {
        Intrinsics.checkNotNullParameter(prepaidApplyDialog, "this$0");
        prepaidApplyDialog.dismiss();
        WalletHomeTrackerManager.Companion.trackHomePrepaidDialogClick("cancel");
    }
}
