package com.didi.payment.pix.qrpayee;

import com.didi.onekeyshare.entity.SharePlatform;
import com.didi.payment.base.utils.FileUtil;
import com.didi.payment.commonsdk.utils.NCommonShareManager;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.taxis99.R;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, mo175978d2 = {"com/didi/payment/pix/qrpayee/QRPayeeMainActivity$initContentView$3$task$1$1$1$1", "Lcom/didi/payment/commonsdk/utils/NCommonShareManager$CommonShareCallback;", "onCancel", "", "platform", "Lcom/didi/onekeyshare/entity/SharePlatform;", "onComplete", "onError", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: QRPayeeMainActivity.kt */
public final class QRPayeeMainActivity$initContentView$3$task$1$1$1$1 implements NCommonShareManager.CommonShareCallback {
    final /* synthetic */ String $filePath;
    final /* synthetic */ QRPayeeMainActivity this$0;

    QRPayeeMainActivity$initContentView$3$task$1$1$1$1(QRPayeeMainActivity qRPayeeMainActivity, String str) {
        this.this$0 = qRPayeeMainActivity;
        this.$filePath = str;
    }

    public void onComplete(SharePlatform sharePlatform) {
        if (sharePlatform != null && sharePlatform == SharePlatform.SAVEIMAGE_PLATFORM) {
            QRPayeeMainActivity qRPayeeMainActivity = this.this$0;
            WalletToastNew.showSuccessMsg(qRPayeeMainActivity, qRPayeeMainActivity.getString(R.string.GRider_payment_Saved_pictures_zlDT));
        }
    }

    public void onError(SharePlatform sharePlatform) {
        if (sharePlatform != null && sharePlatform == SharePlatform.SAVEIMAGE_PLATFORM) {
            QRPayeeMainActivity qRPayeeMainActivity = this.this$0;
            WalletToastNew.showSuccessMsg(qRPayeeMainActivity, qRPayeeMainActivity.getString(R.string.GRider_payment_Unable_to_HgJB));
        }
    }

    public void onCancel(SharePlatform sharePlatform) {
        FileUtil.deleteFile(this.$filePath);
    }
}
