package com.didi.payment.transfer.channels;

import android.content.Context;
import com.didi.payment.transfer.channels.TransChannelResp;
import com.didi.payment.transfer.common.AbsTransBasePresenter;

public abstract class IChannelPresenter extends AbsTransBasePresenter<IChannelPageView> {
    public abstract void loadChannels();

    public abstract void onHandleChannelItemClick(TransChannelResp.ChannelBean channelBean);

    public abstract void toHistoryPage();

    public IChannelPresenter(Context context, IChannelPageView iChannelPageView) {
        super(context, iChannelPageView);
    }
}
