package global.didi.pay.presenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.unifiedPay.component.IViewCallback;
import com.didi.unifiedPay.sdk.internal.PayError;
import com.didi.unifiedPay.sdk.model.PayInfo;
import com.taxis99.R;
import global.didi.pay.IGlobalPayView;

public class GlobalUniPayPresenter extends GlobalNonTripPaymentPresenter {
    public GlobalUniPayPresenter(Context context, FragmentManager fragmentManager, String str, IViewCallback iViewCallback) {
        super(context, fragmentManager, str, iViewCallback);
    }

    /* access modifiers changed from: protected */
    public void requestPayInfoResult(boolean z, PayInfo payInfo, String str, int i) {
        ((IGlobalPayView) this.mView).hideLoadingPop(true);
        super.requestPayInfoResult(z, payInfo, str, i);
    }

    /* access modifiers changed from: protected */
    public void onPrePayFailed(int i, String str) {
        ((IGlobalPayView) this.mView).hideLoadingPop(true);
        super.onPrePayFailed(i, str);
    }

    public void onPayFailed(PayError payError, String str) {
        ((IGlobalPayView) this.mView).hideLoadingPop(true);
        super.onPayFailed(payError, str);
    }

    /* access modifiers changed from: protected */
    public void onPaySuccessed(int i, String str) {
        final boolean needJumpOfflineWebPage = GlobalOffLinePaymentHelper.needJumpOfflineWebPage(getOrderId());
        super.onPaySuccessed(i, str);
        UiThreadHandler.postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                if (needJumpOfflineWebPage) {
                    bundle.putInt("code", 7);
                } else {
                    bundle.putInt("code", 1);
                }
                bundle.putString("message", GlobalUniPayPresenter.this.mContext.getString(R.string.oc_pay_success_string));
                intent.putExtras(bundle);
                if (GlobalUniPayPresenter.this.mFragmentActivity != null) {
                    GlobalUniPayPresenter.this.mFragmentActivity.setResult(-1, intent);
                    GlobalUniPayPresenter.this.mFragmentActivity.finish();
                }
            }
        }, 1000);
    }
}
