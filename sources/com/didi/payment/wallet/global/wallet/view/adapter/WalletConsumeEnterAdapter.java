package com.didi.payment.wallet.global.wallet.view.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.wallet.global.model.resp.WalletHomeResp;
import com.didi.unifiedPay.util.UIUtils;
import com.taxis99.R;
import java.util.List;

@Deprecated
public class WalletConsumeEnterAdapter extends RecyclerView.Adapter {

    /* renamed from: a */
    OnActionInterceptor f32299a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public OnConsumeItemClickListener f32300b;

    /* renamed from: c */
    private List<WalletHomeResp.ConsumeItem> f32301c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Context f32302d;

    public interface OnActionInterceptor {
        boolean onIntercept(int i, WalletHomeResp.ConsumeItem consumeItem);
    }

    public interface OnConsumeItemClickListener {
        void onConsumeItemClick(WalletHomeResp.ConsumeItem consumeItem);
    }

    public WalletConsumeEnterAdapter(Context context) {
        this.f32302d = context;
    }

    public WalletConsumeEnterAdapter(Context context, OnConsumeItemClickListener onConsumeItemClickListener) {
        this.f32302d = context;
        this.f32300b = onConsumeItemClickListener;
    }

    public void setData(List<WalletHomeResp.ConsumeItem> list) {
        this.f32301c = list;
        notifyDataSetChanged();
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new CardViewHolder(LayoutInflater.from(this.f32302d).inflate(R.layout.wallet_consume_enter_item, viewGroup, false));
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ((CardViewHolder) viewHolder).bindData(this.f32301c.get(i));
    }

    public int getItemCount() {
        List<WalletHomeResp.ConsumeItem> list = this.f32301c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    class CardViewHolder extends RecyclerView.ViewHolder {
        private ImageView mIconIV;
        private TextView mNameTv;
        private View shadowView;

        public CardViewHolder(View view) {
            super(view);
            this.mNameTv = (TextView) view.findViewById(R.id.wallet_consume_enter_item_title_tv);
            this.mIconIV = (ImageView) view.findViewById(R.id.wallet_consume_enter_item_icon_iv);
            this.shadowView = view.findViewById(R.id.view_shadow);
            resetWidth();
        }

        private void resetWidth() {
            int screenWidth = UIUtils.getScreenWidth(WalletConsumeEnterAdapter.this.f32302d);
            ViewGroup.LayoutParams layoutParams = this.itemView.getLayoutParams();
            layoutParams.width = (screenWidth / 2) - ((int) WalletConsumeEnterAdapter.this.f32302d.getResources().getDimension(R.dimen.wallet_consume_enter_card_margin));
            this.itemView.setLayoutParams(layoutParams);
        }

        public void bindData(final WalletHomeResp.ConsumeItem consumeItem) {
            if (consumeItem != null) {
                this.mNameTv.setText(consumeItem.name);
                if (!TextUtils.isEmpty(consumeItem.iconUrl)) {
                    GlideUtils.with2load2into(WalletConsumeEnterAdapter.this.f32302d, consumeItem.iconUrl, this.mIconIV);
                }
                if (consumeItem.productLine == 99999) {
                    FinOmegaSDK.trackEvent("ibt_didipay_p2p_transfer_sw");
                }
                if (consumeItem.isBlocked) {
                    this.shadowView.setVisibility(0);
                } else {
                    this.shadowView.setVisibility(4);
                }
                this.itemView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if ((WalletConsumeEnterAdapter.this.f32299a == null || !WalletConsumeEnterAdapter.this.f32299a.onIntercept(0, consumeItem)) && !consumeItem.isBlocked && WalletConsumeEnterAdapter.this.f32300b != null) {
                            WalletConsumeEnterAdapter.this.f32300b.onConsumeItemClick(consumeItem);
                        }
                    }
                });
            }
        }
    }

    public void setInternalActionInterceptor(OnActionInterceptor onActionInterceptor) {
        this.f32299a = onActionInterceptor;
    }
}
