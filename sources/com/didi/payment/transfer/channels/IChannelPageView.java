package com.didi.payment.transfer.channels;

import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.transfer.channels.TransChannelResp;
import com.didi.payment.transfer.common.IPageView;

public interface IChannelPageView extends IPageView<IChannelPresenter> {
    void gotoCfmPhonePage(int i);

    void onBackHome();

    void onChannelClick(TransChannelResp.ChannelBean channelBean);

    void onLoadChannelFail(TransChannelResp.DataBean dataBean);

    void showAccountRegisteDialog(String str, String str2, String str3, String str4, DoubleCheckOnClickListener doubleCheckOnClickListener, DoubleCheckOnClickListener doubleCheckOnClickListener2);

    void toHistoryPage();

    void updateChannel(TransChannelResp.DataBean dataBean);
}
