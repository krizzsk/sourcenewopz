package com.didi.payment.wallet.global.wallet.view.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.wallet.global.model.resp.WalletPageQueryResp;
import com.didi.unifiedPay.util.UIUtils;
import com.taxis99.R;
import java.util.HashMap;
import java.util.List;

public class WalletFinancialServiceEnterAdapter extends RecyclerView.Adapter<CardViewHolder> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f32303a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public FinanceItemClickListener f32304b;

    /* renamed from: c */
    private List<WalletPageQueryResp.FinanceItem> f32305c;

    public interface FinanceItemClickListener {
        void onFinanceItemClick(WalletPageQueryResp.FinanceItem financeItem);
    }

    public WalletFinancialServiceEnterAdapter(Context context, FinanceItemClickListener financeItemClickListener) {
        this.f32303a = context;
        this.f32304b = financeItemClickListener;
    }

    public void setData(List<WalletPageQueryResp.FinanceItem> list) {
        this.f32305c = list;
        notifyDataSetChanged();
    }

    public CardViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new CardViewHolder(LayoutInflater.from(this.f32303a).inflate(R.layout.wallet_finance_service_enter_item, viewGroup, false));
    }

    public void onBindViewHolder(CardViewHolder cardViewHolder, int i) {
        cardViewHolder.bindData(this.f32305c.get(i));
    }

    public int getItemCount() {
        List<WalletPageQueryResp.FinanceItem> list = this.f32305c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    class CardViewHolder extends RecyclerView.ViewHolder {
        private ImageView mIconIV;
        private TextView mNameTv;
        private TextView mTagTv;

        public CardViewHolder(View view) {
            super(view);
            this.mNameTv = (TextView) view.findViewById(R.id.tv_finance_item_title);
            this.mIconIV = (ImageView) view.findViewById(R.id.iv_finance_item_icon);
            this.mTagTv = (TextView) view.findViewById(R.id.tv_finance_item_tag);
            resetWidth();
        }

        private void resetWidth() {
            int screenWidth = UIUtils.getScreenWidth(WalletFinancialServiceEnterAdapter.this.f32303a);
            ViewGroup.LayoutParams layoutParams = this.itemView.getLayoutParams();
            layoutParams.width = (screenWidth / 2) - UIUtils.dip2px(WalletFinancialServiceEnterAdapter.this.f32303a, 8.0f);
            this.itemView.setLayoutParams(layoutParams);
        }

        public void bindData(final WalletPageQueryResp.FinanceItem financeItem) {
            if (financeItem != null) {
                this.mNameTv.setText(financeItem.name);
                if (financeItem.promotionText != null && !financeItem.promotionText.isEmpty()) {
                    this.mTagTv.setVisibility(0);
                    this.mTagTv.setText(financeItem.promotionText);
                }
                if (!TextUtils.isEmpty(financeItem.iconUrl)) {
                    GlideUtils.with2load2into(WalletFinancialServiceEnterAdapter.this.f32303a, financeItem.iconUrl, this.mIconIV);
                }
                if (TextUtils.equals(financeItem.f31756id, "creditCardDebit")) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("channel_id", "WALLET");
                    FinOmegaSDK.trackEvent("ibt_mx_wallet_homepage_credit_card_sw", hashMap);
                } else if (TextUtils.equals(financeItem.f31756id, "cashDebit")) {
                    FinOmegaSDK.trackEvent("ibt_mx_wallet_homepage_micro_loan_sw");
                }
                this.itemView.setOnClickListener(new DoubleCheckOnClickListener(500) {
                    public void doClick(View view) {
                        if (TextUtils.equals(financeItem.f31756id, "creditCardDebit")) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("channel_id", "WALLET");
                            FinOmegaSDK.trackEvent("ibt_mx_wallet_homepage_credit_card_ck", hashMap);
                        } else if (TextUtils.equals(financeItem.f31756id, "cashDebit")) {
                            FinOmegaSDK.trackEvent("ibt_mx_wallet_homepage_micro_loan_ck");
                        }
                        if (WalletFinancialServiceEnterAdapter.this.f32304b != null) {
                            WalletFinancialServiceEnterAdapter.this.f32304b.onFinanceItemClick(financeItem);
                        }
                    }
                });
            }
        }
    }
}
