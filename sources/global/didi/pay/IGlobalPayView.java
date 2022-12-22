package global.didi.pay;

import android.view.View;
import com.didi.unifiedPay.component.view.IInstallmentView;
import com.didi.unifiedPay.component.view.IPayView;
import com.didi.unifiedPay.component.view.ITransactionFeeView;
import com.didi.unifiedPay.sdk.model.InternalPayChannel;
import com.didi.unifiedPay.sdk.model.MerchantInfo;
import global.didi.pay.model.GlobalPayType;
import global.didi.pay.newview.pix.IPixView;
import global.didi.pay.view.dialog.UnifiedPayDialogConfig;

public interface IGlobalPayView extends IInstallmentView, IPayView, ITransactionFeeView {
    public static final String TYPE_NEW_UI = "type_new_ui";
    public static final String TYPE_OLD_UI = "type_old_ui";

    public interface CheckCallBack {
        void onCheckChanged(boolean z);
    }

    public interface DialogConfirmListener extends DialogTipsListener {
        void onCancel();
    }

    public interface DialogTipsListener {
        void onConfirm();
    }

    public interface OnWebLinkClickListener {
        void onClick(String str);
    }

    String getPixCode();

    String getUIType();

    void hideLoadingPop(boolean z);

    boolean newUIType();

    void onPayInfoLoadComplete(String str);

    void setPixViewListener(IPixView.PixViewListener pixViewListener);

    void setTitle(boolean z, String str, String str2);

    void setTitle(boolean z, boolean z2, String str, String str2);

    void setTitleLink(boolean z, String str, String str2, OnWebLinkClickListener onWebLinkClickListener);

    void showConfirmDialog(UnifiedPayDialogConfig unifiedPayDialogConfig, DialogConfirmListener dialogConfirmListener);

    void showLoadingPop(int i);

    void showLoadingView(String str, boolean z, int i);

    void showLoadingView(String str, boolean z, int i, int i2);

    void showRetryView(View.OnClickListener onClickListener);

    void updateBalance(InternalPayChannel internalPayChannel, CheckCallBack checkCallBack);

    void updateCashbackInfo(String str);

    void updateMerchantInfo(MerchantInfo merchantInfo);

    void updatePayType(GlobalPayType globalPayType);

    void updatePix(String str, String str2);
}
