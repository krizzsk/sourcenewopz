package com.didi.payment.commonsdk.p129ui.helper;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.commonsdk.fragment.QRDetectedDialog;
import com.didi.payment.commonsdk.net.PixQrCodeQueryResp;
import com.didi.payment.commonsdk.utils.NClipBoardUtil;

/* renamed from: com.didi.payment.commonsdk.ui.helper.NQRDetectedDialogHelper */
public class NQRDetectedDialogHelper {
    public static void showDialog(final Context context, final PixQrCodeQueryResp.QRCodeData qRCodeData) {
        final String key = qRCodeData != null ? qRCodeData.getKey() : "";
        QRDetectedDialog qRDetectedDialog = new QRDetectedDialog(new QRDetectedDialog.DialogBtnClicikListener() {
            public void onConfirmClicked(TextView textView) {
                FinOmegaSDK.trackEvent("ibt_didipay_pix_clipboard_copy_ck", "pix_payee_key", key);
                Bundle bundle = new Bundle();
                bundle.putSerializable("detected_qrcode", qRCodeData);
                bundle.putString("source_page", "clipboard_copy");
                ((Request) DRouter.build("99pay://one/pix_transfer").putExtras(bundle)).start(context);
                NClipBoardUtil.clearClipboard(context);
            }

            public void onNegativeClicked(TextView textView) {
                FinOmegaSDK.trackEvent("ibt_didipay_pix_clipboard_back_ck", "pix_payee_key", key);
                NClipBoardUtil.clearClipboard(context);
            }
        }, qRCodeData);
        qRDetectedDialog.setCancelable(false);
        qRDetectedDialog.show(((FragmentActivity) context).getSupportFragmentManager(), "qr_detected_fragment_tag");
        FinOmegaSDK.trackEvent("ibt_didipay_pix_clipboard_sw", "pix_payee_key", key);
    }
}
