package com.didi.payment.wallet.global.wallet.view.adapter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.payment.base.adapter.BaseViewHolder;
import com.didi.payment.base.adapter.FastAdapter;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.wallet.global.model.resp.WalletTopUpChannelResp;
import com.didi.sdk.util.TextUtil;
import com.taxis99.R;

public class WalletTopUpChannelAdapter extends FastAdapter<WalletTopUpChannelResp.ChannelBean> {
    public WalletTopUpChannelAdapter() {
        super(R.layout.wallet_global_v_topup_channel_item);
    }

    /* access modifiers changed from: protected */
    public void onBindItem(BaseViewHolder baseViewHolder, WalletTopUpChannelResp.ChannelBean channelBean, int i) {
        ImageView imageView = (ImageView) baseViewHolder.findViewById(R.id.iv_channel_icon);
        TextView textView = (TextView) baseViewHolder.findViewById(R.id.tv_channel_name);
        TextView textView2 = (TextView) baseViewHolder.findViewById(R.id.tv_channel_desc);
        TextView textView3 = (TextView) baseViewHolder.findViewById(R.id.tv_channel_extra);
        View findViewById = baseViewHolder.findViewById(R.id.view_shadow);
        View findViewById2 = baseViewHolder.findViewById(R.id.iv_arrow);
        if ((channelBean.statusInfo == null || channelBean.statusInfo.status != 1) && !channelBean.disable) {
            findViewById.setVisibility(8);
            findViewById2.setVisibility(0);
        } else {
            findViewById.setVisibility(0);
            findViewById2.setVisibility(8);
        }
        GlideUtils.with2load2into(baseViewHolder.getContext(), channelBean.iconUrl, imageView);
        textView.setText(channelBean.name);
        if (!TextUtil.isEmpty(channelBean.desc)) {
            textView2.setText(channelBean.desc);
            textView2.setVisibility(0);
        } else {
            textView2.setVisibility(8);
        }
        if (TextUtils.isEmpty(channelBean.promotion)) {
            textView3.setVisibility(8);
            return;
        }
        textView3.setVisibility(0);
        textView3.setText(channelBean.promotion);
    }
}
