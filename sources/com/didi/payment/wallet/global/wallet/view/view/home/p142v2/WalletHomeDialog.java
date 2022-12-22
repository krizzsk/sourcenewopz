package com.didi.payment.wallet.global.wallet.view.view.home.p142v2;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.DialogFragment;
import com.didi.drouter.api.DRouter;
import com.didi.global.globalgenerickit.eventtracker.Const;
import com.didi.payment.wallet.global.model.resp.WalletPopUpWindowResp;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletHomeTrackerManager;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J&\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/WalletHomeDialog;", "Landroidx/fragment/app/DialogFragment;", "resp", "Lcom/didi/payment/wallet/global/model/resp/WalletPopUpWindowResp;", "(Lcom/didi/payment/wallet/global/model/resp/WalletPopUpWindowResp;)V", "getResp", "()Lcom/didi/payment/wallet/global/model/resp/WalletPopUpWindowResp;", "setResp", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomeDialog */
/* compiled from: WalletHomeDialog.kt */
public final class WalletHomeDialog extends DialogFragment {

    /* renamed from: a */
    private WalletPopUpWindowResp f32638a;

    public WalletHomeDialog(WalletPopUpWindowResp walletPopUpWindowResp) {
        this.f32638a = walletPopUpWindowResp;
    }

    public final WalletPopUpWindowResp getResp() {
        return this.f32638a;
    }

    public final void setResp(WalletPopUpWindowResp walletPopUpWindowResp) {
        this.f32638a = walletPopUpWindowResp;
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
        return layoutInflater.inflate(R.layout.dialog_wallet_home, viewGroup, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0022, code lost:
        r1 = r1.getData();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onViewCreated(android.view.View r4, android.os.Bundle r5) {
        /*
            r3 = this;
            java.lang.String r5 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r5)
            r5 = 2131431774(0x7f0b115e, float:1.8485287E38)
            android.view.View r5 = r4.findViewById(r5)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            r0 = 2131431769(0x7f0b1159, float:1.8485277E38)
            android.view.View r4 = r4.findViewById(r0)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            android.content.Context r0 = r3.getContext()
            com.didi.payment.wallet.global.model.resp.WalletPopUpWindowResp r1 = r3.f32638a
            r2 = 0
            if (r1 != 0) goto L_0x0022
        L_0x0020:
            r1 = r2
            goto L_0x002d
        L_0x0022:
            com.didi.payment.wallet.global.model.resp.WalletPopUpWindowResp$Data r1 = r1.getData()
            if (r1 != 0) goto L_0x0029
            goto L_0x0020
        L_0x0029:
            java.lang.String r1 = r1.getPictureUrl()
        L_0x002d:
            com.didi.payment.base.utils.GlideUtils.with2load2into(r0, r1, r5)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.-$$Lambda$WalletHomeDialog$qKI3Cqus5TZ1qgI_7DrspT2rr0o r0 = new com.didi.payment.wallet.global.wallet.view.view.home.v2.-$$Lambda$WalletHomeDialog$qKI3Cqus5TZ1qgI_7DrspT2rr0o
            r0.<init>()
            r5.setOnClickListener(r0)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.-$$Lambda$WalletHomeDialog$rKcakpAritl_JKbKCGmXX0rc40Q r5 = new com.didi.payment.wallet.global.wallet.view.view.home.v2.-$$Lambda$WalletHomeDialog$rKcakpAritl_JKbKCGmXX0rc40Q
            r5.<init>()
            r4.setOnClickListener(r5)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletHomeTrackerManager$Companion r4 = com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletHomeTrackerManager.Companion
            com.didi.payment.wallet.global.model.resp.WalletPopUpWindowResp r5 = r3.f32638a
            if (r5 != 0) goto L_0x0047
            goto L_0x0052
        L_0x0047:
            com.didi.payment.wallet.global.model.resp.WalletPopUpWindowResp$Data r5 = r5.getData()
            if (r5 != 0) goto L_0x004e
            goto L_0x0052
        L_0x004e:
            java.lang.String r2 = r5.getLinkUrl()
        L_0x0052:
            r4.trackWalletHomeDialogSW(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.wallet.global.wallet.view.view.home.p142v2.WalletHomeDialog.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m23088a(WalletHomeDialog walletHomeDialog, View view) {
        WalletPopUpWindowResp.Data data;
        Intrinsics.checkNotNullParameter(walletHomeDialog, "this$0");
        WalletPopUpWindowResp resp = walletHomeDialog.getResp();
        String str = null;
        if (!(resp == null || (data = resp.getData()) == null)) {
            str = data.getLinkUrl();
        }
        DRouter.build(str).start(walletHomeDialog.getContext());
        WalletHomeTrackerManager.Companion.trackWalletHomeDialogClick("", Const.POPUP);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m23089b(WalletHomeDialog walletHomeDialog, View view) {
        Intrinsics.checkNotNullParameter(walletHomeDialog, "this$0");
        walletHomeDialog.dismiss();
        WalletHomeTrackerManager.Companion.trackWalletHomeDialogClick("", "close");
    }
}
