package com.didi.unifiedPay.component.view;

import com.didi.unifiedPay.component.model.PayChannelItem;
import com.didi.unifiedPay.component.model.PayTypes;
import com.didi.unifiedPay.component.widget.loading.FailStateDialog;
import java.util.List;

public interface IPrePayView extends IView {

    public interface PayViewListener {
        void onCloseBtnClick();

        void onPayBtnClick();

        void onProtocolBtnClick();

        void onSelectPayMethod(int i, PayChannelItem payChannelItem);

        void onUnSelectPayMethod(int i, PayChannelItem payChannelItem);
    }

    void enableAllViews(boolean z);

    void enableChangeChannel(boolean z);

    void enableClose(boolean z);

    void enablePay(boolean z);

    PayTypes getPayMethodTypes();

    boolean isCloseEnabled();

    void onPageLoadingEnd();

    void onPageLoadingStart();

    void onPayFailure(FailStateDialog.Config config);

    void onPayLoadingEnd();

    void onPayLoadingStart();

    void onPayMethodSelected(boolean z);

    void onPaySuccess();

    void setFee(String str);

    void setListener(PayViewListener payViewListener);

    void setPayBtnState(PayBtnState payBtnState);

    void setPayBtnText(String str);

    void setTitle(CharSequence charSequence, CharSequence charSequence2);

    void updateThirdPartPayView(List<PayChannelItem> list, int i, boolean z);
}
