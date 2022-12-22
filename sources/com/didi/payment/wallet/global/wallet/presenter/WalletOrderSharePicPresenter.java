package com.didi.payment.wallet.global.wallet.presenter;

import androidx.fragment.app.FragmentActivity;
import com.didi.onekeyshare.entity.SharePlatform;
import com.didi.payment.base.utils.FileUtil;
import com.didi.payment.base.utils.WalletToast;
import com.didi.payment.commonsdk.utils.NCommonShareManager;
import com.didi.payment.wallet.global.wallet.contract.WalletLoadingContract;
import com.didi.payment.wallet.global.wallet.contract.WalletOrderSharePicContract;
import com.didi.sdk.util.ResourcesHelper;
import com.taxis99.R;

public class WalletOrderSharePicPresenter implements WalletOrderSharePicContract.Presenter {

    /* renamed from: a */
    private WalletLoadingContract f32074a;
    protected FragmentActivity mContext;
    protected WalletOrderSharePicContract.View mView;

    public WalletOrderSharePicPresenter(FragmentActivity fragmentActivity, WalletOrderSharePicContract.View view) {
        this.mContext = fragmentActivity;
        this.mView = view;
    }

    public void setLoadingView(WalletLoadingContract walletLoadingContract) {
        this.f32074a = walletLoadingContract;
    }

    /* access modifiers changed from: protected */
    public void showLoading() {
        WalletLoadingContract walletLoadingContract = this.f32074a;
        if (walletLoadingContract != null) {
            walletLoadingContract.showLoadingDialog();
        }
    }

    /* access modifiers changed from: protected */
    public void dismissLoading() {
        WalletLoadingContract walletLoadingContract = this.f32074a;
        if (walletLoadingContract != null) {
            walletLoadingContract.dismissLoadingDialog();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
        r0 = r0.createSharePic();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onShareClicked() {
        /*
            r2 = this;
            com.didi.payment.wallet.global.wallet.contract.WalletOrderSharePicContract$View r0 = r2.mView
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            android.graphics.Bitmap r0 = r0.createSharePic()
            if (r0 != 0) goto L_0x000c
            return
        L_0x000c:
            r2.showLoading()
            com.didi.payment.wallet.global.wallet.presenter.WalletOrderSharePicPresenter$1 r1 = new com.didi.payment.wallet.global.wallet.presenter.WalletOrderSharePicPresenter$1
            r1.<init>(r0)
            r1.start()
            java.lang.String r0 = "ibt_didipay_receipt_sharing_ck"
            com.didi.payment.base.tracker.PayTracker.trackEvent(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.wallet.global.wallet.presenter.WalletOrderSharePicPresenter.onShareClicked():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22735a(final String str) {
        dismissLoading();
        NCommonShareManager.showOrderDetailShareWindow(this.mContext, "", str, new NCommonShareManager.CommonShareCallback() {
            public void onComplete(SharePlatform sharePlatform) {
                if (sharePlatform != null && sharePlatform == SharePlatform.SAVEIMAGE_PLATFORM) {
                    WalletToast.showSuccessMsg(WalletOrderSharePicPresenter.this.mContext, ResourcesHelper.getString(WalletOrderSharePicPresenter.this.mContext, R.string.GRider_sharing_Download_the_Nwar));
                    FileUtil.deleteFile(str);
                }
            }

            public void onError(SharePlatform sharePlatform) {
                if (sharePlatform != null && sharePlatform == SharePlatform.SAVEIMAGE_PLATFORM) {
                    WalletToast.showFailedMsg(WalletOrderSharePicPresenter.this.mContext, ResourcesHelper.getString(WalletOrderSharePicPresenter.this.mContext, R.string.GRider_sharing_Unable_to_IuyB));
                    FileUtil.deleteFile(str);
                }
            }

            public void onCancel(SharePlatform sharePlatform) {
                FileUtil.deleteFile(str);
            }
        });
    }
}
