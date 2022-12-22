package com.didi.payment.pix.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.pix.home.PixChannelResp;
import com.didi.payment.pix.home.p135vm.ChannelEntryClickVM;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.collection.CollectionUtil;
import com.taxis99.R;
import java.util.Collection;
import java.util.List;

class PixChannelItemAdapter extends RecyclerView.Adapter<PixChannelViewHolder> {

    /* renamed from: a */
    List<PixChannelResp.ChannelEntry> f31071a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Context f31072b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ChannelEntryClickVM f31073c;

    public PixChannelItemAdapter(FragmentActivity fragmentActivity) {
        this.f31072b = fragmentActivity;
        this.f31073c = (ChannelEntryClickVM) new ViewModelProvider(fragmentActivity).get(ChannelEntryClickVM.class);
    }

    /* renamed from: a */
    public void mo83686a(List<PixChannelResp.ChannelEntry> list) {
        this.f31071a = list;
    }

    /* renamed from: a */
    public PixChannelViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new PixChannelViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pix_channel_item, viewGroup, false));
    }

    /* renamed from: a */
    public void onBindViewHolder(PixChannelViewHolder pixChannelViewHolder, int i) {
        pixChannelViewHolder.bind(i);
    }

    public int getItemCount() {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f31071a)) {
            return this.f31071a.size();
        }
        return 0;
    }

    class PixChannelViewHolder extends RecyclerView.ViewHolder {
        ImageView iconImg;
        /* access modifiers changed from: private */
        public PixChannelResp.ChannelEntry mChannel;
        TextView titleTv;

        public PixChannelViewHolder(View view) {
            super(view);
            this.iconImg = (ImageView) view.findViewById(R.id.pix_channel_item_icon_img);
            this.titleTv = (TextView) view.findViewById(R.id.pix_channel_item_title_tv);
            view.setOnClickListener(new DoubleCheckOnClickListener(PixChannelItemAdapter.this) {
                public void doClick(View view) {
                    if (PixChannelViewHolder.this.mChannel != null) {
                        int typeId = PixChannelViewHolder.this.mChannel.getTypeId();
                        if (typeId == 1) {
                            FinOmegaSDK.trackEvent("ibt_didipay_pix_transfer_ck");
                        } else if (typeId == 2) {
                            FinOmegaSDK.trackEvent("ibt_didipay_pix_scan_ck");
                        } else if (typeId == 3) {
                            FinOmegaSDK.trackEvent("ibt_didipay_pix_receive_ck");
                        }
                        PixChannelItemAdapter.this.f31073c.pixChannel.setValue(PixChannelViewHolder.this.mChannel);
                    }
                }
            });
        }

        public void bind(int i) {
            if (!CollectionUtil.isEmpty((Collection<?>) PixChannelItemAdapter.this.f31071a) && i <= PixChannelItemAdapter.this.f31071a.size() - 1) {
                PixChannelResp.ChannelEntry channelEntry = PixChannelItemAdapter.this.f31071a.get(i);
                this.mChannel = channelEntry;
                if (!TextUtil.isEmpty(channelEntry.icon)) {
                    GlideUtils.with2load2into(PixChannelItemAdapter.this.f31072b, channelEntry.icon, this.iconImg);
                }
                this.titleTv.setText(channelEntry.name);
            }
        }
    }
}
