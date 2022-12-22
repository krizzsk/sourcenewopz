package com.didi.sdk.global.balance.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.global.balance.model.bean.BalanceAccount;
import com.didi.sdk.global.balance.model.bean.BalanceDetail;
import com.didi.sdk.global.balance.model.bean.BalancePageResponse;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public class GlobalBalanceCardAdapter extends RecyclerView.Adapter {

    /* renamed from: a */
    private Context f36019a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public List<BalanceAccount> f36020b = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public OnItemClickListener f36021c;

    public interface OnItemClickListener {
        void onDetailClick(BalanceDetail balanceDetail, int i);
    }

    public GlobalBalanceCardAdapter(Context context) {
        this.f36019a = context;
    }

    public void refreshData(BalancePageResponse balancePageResponse) {
        this.f36020b.clear();
        this.f36020b.addAll(balancePageResponse.data.allEntries);
        notifyDataSetChanged();
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new CardViewHolder(LayoutInflater.from(this.f36019a).inflate(R.layout.one_payment_v_global_balance_cardview, viewGroup, false));
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof CardViewHolder) {
            ((CardViewHolder) viewHolder).bind(i);
        }
    }

    public int getItemCount() {
        return this.f36020b.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.f36021c = onItemClickListener;
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_symbol;
        private TextView tv_trans_detail;
        private TextView tv_value;

        public CardViewHolder(View view) {
            super(view);
            this.tv_symbol = (TextView) view.findViewById(R.id.tv_balance_symbol);
            this.tv_value = (TextView) view.findViewById(R.id.tv_balance_value);
            this.tv_trans_detail = (TextView) view.findViewById(R.id.tv_balance_trans_detail);
        }

        public void bind(final int i) {
            BalanceAccount balanceAccount = (BalanceAccount) GlobalBalanceCardAdapter.this.f36020b.get(i);
            final BalanceDetail balanceDetail = balanceAccount.balanceDetail;
            if (balanceDetail == null) {
                this.tv_trans_detail.setVisibility(8);
                return;
            }
            this.tv_symbol.setText(balanceDetail.currencySymbol);
            this.tv_symbol.setEnabled(balanceAccount.isActive.booleanValue());
            this.tv_value.setText(balanceDetail.value);
            this.tv_value.setEnabled(balanceAccount.isActive.booleanValue());
            if (!TextUtils.isEmpty(balanceDetail.transDetailDesc)) {
                this.tv_trans_detail.setText(balanceDetail.transDetailDesc);
            }
            this.tv_trans_detail.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (GlobalBalanceCardAdapter.this.f36021c != null) {
                        GlobalBalanceCardAdapter.this.f36021c.onDetailClick(balanceDetail, i);
                    }
                }
            });
        }
    }
}
