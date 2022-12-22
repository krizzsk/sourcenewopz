package com.didi.payment.wallet.global.wallet.view.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.base.utils.UIUtil;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.wallet.global.model.resp.WalletHomeResp;
import com.didi.payment.wallet.global.wallet.view.view.IPixEntryClickListener;
import com.didi.sdk.util.collection.CollectionUtil;
import com.taxis99.R;
import java.util.Collection;
import java.util.List;

public class PixEntryAdapter extends RecyclerView.Adapter<PixChannelViewHolder> {

    /* renamed from: a */
    List<WalletHomeResp.PixEntry> f32292a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Context f32293b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f32294c;
    public IPixEntryClickListener entryClickListener;

    public void setStyle(int i) {
    }

    public PixEntryAdapter(Context context) {
        this.f32293b = context;
    }

    public void setChannels(List<WalletHomeResp.PixEntry> list) {
        this.f32292a = list;
    }

    public PixChannelViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new PixChannelViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pix_entry_item, viewGroup, false));
    }

    public void onBindViewHolder(PixChannelViewHolder pixChannelViewHolder, int i) {
        pixChannelViewHolder.bind(i);
    }

    public int getItemCount() {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f32292a)) {
            return this.f32292a.size();
        }
        return 0;
    }

    class PixChannelViewHolder extends RecyclerView.ViewHolder {
        ImageView iconImg;
        /* access modifiers changed from: private */
        public WalletHomeResp.PixEntry pixEntry;
        View shadowView;
        TextView titleTv;

        public PixChannelViewHolder(View view) {
            super(view);
            this.iconImg = (ImageView) view.findViewById(R.id.pix_channel_item_icon_img);
            this.titleTv = (TextView) view.findViewById(R.id.pix_channel_item_title_tv);
            this.shadowView = view.findViewById(R.id.view_shadow);
            ViewGroup.LayoutParams layoutParams = this.iconImg.getLayoutParams();
            int dip2px = UIUtil.dip2px(PixEntryAdapter.this.f32293b, 46.0f);
            int b = PixEntryAdapter.this.f32294c;
            if (b == 0 || b == 1) {
                this.titleTv.setTextSize(12.0f);
                int dip2px2 = UIUtil.dip2px(PixEntryAdapter.this.f32293b, 46.0f);
                layoutParams.width = dip2px2;
                layoutParams.height = dip2px2;
                this.iconImg.setLayoutParams(layoutParams);
            } else if (b == 2 || b == 3) {
                this.titleTv.setTextSize(12.0f);
                layoutParams.width = dip2px;
                layoutParams.height = dip2px;
                this.iconImg.setLayoutParams(layoutParams);
            }
            view.setOnClickListener(new DoubleCheckOnClickListener(PixEntryAdapter.this) {
                public void doClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("pix_entry", PixChannelViewHolder.this.pixEntry);
                    int i = PixChannelViewHolder.this.pixEntry.typeId;
                    if (i == 1) {
                        FinOmegaSDK.trackEvent("ibt_didipay_pix_transfer_ck");
                    } else if (i == 2) {
                        FinOmegaSDK.trackEvent("ibt_didipay_pix_scan_ck");
                    } else if (i == 3) {
                        FinOmegaSDK.trackEvent("ibt_didipay_pix_receive_ck");
                    }
                    if (PixEntryAdapter.this.entryClickListener != null && !PixChannelViewHolder.this.pixEntry.isBlocked) {
                        PixEntryAdapter.this.entryClickListener.onPixEntryClick(bundle);
                    }
                }
            });
        }

        public void bind(int i) {
            if (!CollectionUtil.isEmpty((Collection<?>) PixEntryAdapter.this.f32292a) && i <= PixEntryAdapter.this.f32292a.size() - 1) {
                WalletHomeResp.PixEntry pixEntry2 = PixEntryAdapter.this.f32292a.get(i);
                this.pixEntry = pixEntry2;
                GlideUtils.with2load2into(PixEntryAdapter.this.f32293b, pixEntry2.iconUrl, this.iconImg);
                this.titleTv.setText(pixEntry2.name);
                if (pixEntry2.isBlocked) {
                    this.shadowView.setVisibility(0);
                } else {
                    this.shadowView.setVisibility(8);
                }
            }
        }
    }

    public void setEntryListener(IPixEntryClickListener iPixEntryClickListener) {
        this.entryClickListener = iPixEntryClickListener;
    }
}
