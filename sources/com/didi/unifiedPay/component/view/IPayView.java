package com.didi.unifiedPay.component.view;

import android.view.View;
import com.didi.unifiedPay.component.model.PayChannelItem;
import com.didi.unifiedPay.component.model.PayErrorEvent;
import com.didi.unifiedPay.component.model.PayItem;
import com.didi.unifiedPay.component.model.PayTypes;
import com.didi.unifiedPay.component.model.PlatformPayItem;
import com.didi.unifiedPay.component.widget.FailStateView;
import com.didi.unifiedPay.component.widget.ToastView;
import global.didi.pay.model.LoadingState;
import java.util.List;

public interface IPayView extends IView {
    public static final String TYPE_MAIN = "main_page";

    public interface PayViewListener {
        void itemClicked(int i, PlatformPayItem platformPayItem);

        void onCloseBtnClick();

        void onClosePixBtnClick();

        void onDeductionItemClick(VoucherViewConfig voucherViewConfig);

        void onExpandAllThirdPayItemByUser();

        void onPayButtonClick();

        void onPayItemSelected(int i, PayChannelItem payChannelItem);

        void onPaySuccess();

        void onPlatformItemSelectChange(int i, boolean z, PlatformPayItem platformPayItem, boolean z2);

        void onShowFeeDetailClick();

        void onShowQueryPayResultView();

        void onThirdPartPayItemClicked(int i, PayItem payItem);

        void unSelectThirdPartItem(int i, PayChannelItem payChannelItem);
    }

    void addDeductionItem(VoucherViewConfig voucherViewConfig);

    void addDeductionItems(List<VoucherViewConfig> list);

    String getInitPayMethod();

    String getPayMethod();

    PayTypes getPayMethodTypes();

    boolean isCloseIconEnable();

    boolean isPayItemsExpand();

    PayErrorEvent isShowErrorView();

    boolean isShowSuccessOnBtn();

    void onPayBtnClick();

    void refreshTotalPayArea(String str, String str2, String str3);

    void removeAllDeductions();

    void removeThirdPartPay();

    void resetViewClickable();

    void selectedPayItem(PayChannelItem payChannelItem);

    void setBizType(PayBizType payBizType);

    void setCancelableForThirdPay(boolean z);

    void setCardPaddingTop(int i);

    void setChangePayItemResult(boolean z);

    void setCloseIconEnable(boolean z);

    void setCradTitle(String str);

    void setCrossFeeWithUnit(String str);

    void setDisplayFee(String str);

    void setDisplayFeeWithUnit(String str);

    void setJumpableItem(String str);

    void setListener(PayViewListener payViewListener);

    void setMarketing(String str, View.OnClickListener onClickListener);

    void setPayBtnState(PayBtnState payBtnState);

    void setPayBtnText(String str);

    void setPayStatement(String str);

    void setPayTypeInfo(CharSequence charSequence);

    void setPayTypeInfo(String str);

    void setThirdPartPayChangeMode(boolean z);

    void setVoucherDeductible(double d);

    void setVoucherView(VoucherViewConfig voucherViewConfig);

    void showErrorView(FailStateView.Config config);

    void showFeeDetailEntraView(boolean z);

    void showLoadingView(String str, boolean z);

    void showOrHideDeductionItem(DeductionItemType deductionItemType, boolean z);

    void showOrHideDeductions(boolean z);

    void showQueryPayResultView(boolean z, LoadingState loadingState, int i);

    void showSuccessOnPayBtn();

    void showSuccessView(boolean z);

    void showSuccessView(boolean z, String str);

    void showThirdPartPay();

    void showToastView(ToastView.Config config);

    void showVoucherView(boolean z);

    @Deprecated
    void updatePlatformPayView(List<PlatformPayItem> list);

    void updatePlatformPayView(List<PlatformPayItem> list, boolean z);

    @Deprecated
    void updateThirdPartPayView(List<PayChannelItem> list, int i);

    void updateThirdPartPayView(List<PayChannelItem> list, int i, boolean z);
}
