package com.didi.payment.commonsdk.activity;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.commonsdk.fragment.QRDetectedDialog;
import com.didi.payment.commonsdk.net.PixQrCodeQueryResp;
import com.didi.payment.commonsdk.utils.NClipBoardUtil;
import com.didi.payment.pix.constant.PixRouter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, mo175978d2 = {"com/didi/payment/commonsdk/activity/AutoDetectQRCodeActivity$showQRDetectDialog$qrDetectedDialog$1", "Lcom/didi/payment/commonsdk/fragment/QRDetectedDialog$DialogBtnClicikListener;", "onConfirmClicked", "", "view", "Landroid/widget/TextView;", "onNegativeClicked", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AutoDetectQRCodeActivity.kt */
public final class AutoDetectQRCodeActivity$showQRDetectDialog$qrDetectedDialog$1 implements QRDetectedDialog.DialogBtnClicikListener {
    final /* synthetic */ Context $context;
    final /* synthetic */ PixQrCodeQueryResp.QRCodeData $qrCode;

    AutoDetectQRCodeActivity$showQRDetectDialog$qrDetectedDialog$1(PixQrCodeQueryResp.QRCodeData qRCodeData, Context context) {
        this.$qrCode = qRCodeData;
        this.$context = context;
    }

    public void onConfirmClicked(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "view");
        FinOmegaSDK.trackEvent("ibt_didipay_pix_clipboard_copy_ck", "pix_payee_key", this.$qrCode.getKey());
        Bundle bundle = new Bundle();
        bundle.putSerializable("detected_qrcode", this.$qrCode);
        bundle.putString("source_page", "clipboard_copy");
        ((Request) DRouter.build(PixRouter.build("/pix_transfer")).putExtras(bundle)).start(this.$context);
        NClipBoardUtil.Companion.clearClipboard(this.$context);
    }

    public void onNegativeClicked(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "view");
        FinOmegaSDK.trackEvent("ibt_didipay_pix_clipboard_back_ck", "pix_payee_key", this.$qrCode.getKey());
        NClipBoardUtil.Companion.clearClipboard(this.$context);
    }
}
