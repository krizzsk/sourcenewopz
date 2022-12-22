package com.didi.payment.wallet.global.wallet.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.wallet.global.model.resp.CsHistoryItem;
import com.taxis99.R;
import java.util.List;

public class CsTopupHistoryAdapter extends RecyclerView.Adapter<CsHistoryViewHolder> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final CssHistoryListItemClickListener f32288a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f32289b;

    /* renamed from: c */
    private CsHistoryListCallback f32290c;

    /* renamed from: d */
    private List<CsHistoryItem> f32291d;

    public interface CsHistoryListCallback {
        void onLastItemShowed();
    }

    public interface CssHistoryListItemClickListener {
        void onItemClick(CsHistoryItem csHistoryItem);
    }

    public CsTopupHistoryAdapter(Context context, CsHistoryListCallback csHistoryListCallback, CssHistoryListItemClickListener cssHistoryListItemClickListener) {
        this.f32289b = context;
        this.f32290c = csHistoryListCallback;
        this.f32288a = cssHistoryListItemClickListener;
    }

    public void addData(List<CsHistoryItem> list) {
        List<CsHistoryItem> list2 = this.f32291d;
        if (list2 == null) {
            this.f32291d = list;
            notifyDataSetChanged();
            return;
        }
        int size = list2.size();
        this.f32291d.addAll(list);
        notifyItemInserted(size);
    }

    public void clearData() {
        List<CsHistoryItem> list = this.f32291d;
        if (list != null) {
            list.clear();
            notifyDataSetChanged();
        }
    }

    public CsHistoryViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new CsHistoryViewHolder(LayoutInflater.from(this.f32289b).inflate(R.layout.cs_history_list_item, viewGroup, false));
    }

    public void onBindViewHolder(CsHistoryViewHolder csHistoryViewHolder, int i) {
        CsHistoryListCallback csHistoryListCallback;
        csHistoryViewHolder.bindData(this.f32291d.get(i));
        if (i == this.f32291d.size() - 1 && (csHistoryListCallback = this.f32290c) != null) {
            csHistoryListCallback.onLastItemShowed();
        }
    }

    public int getItemCount() {
        List<CsHistoryItem> list = this.f32291d;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public class CsHistoryViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public CsHistoryItem mItem;
        private TextView mNameTv;
        private TextView mOrderIdTv;
        private TextView mOrderTimeTv;
        private TextView mPayTypeTv;
        private TextView mPriceTv;
        private TextView mStatusDescTv;

        public CsHistoryViewHolder(View view) {
            super(view);
            this.mNameTv = (TextView) view.findViewById(R.id.cs_history_item_name_tv);
            this.mOrderIdTv = (TextView) view.findViewById(R.id.cs_history_item_orderId_tv);
            this.mStatusDescTv = (TextView) view.findViewById(R.id.cs_history_item_pay_status_tv);
            this.mOrderTimeTv = (TextView) view.findViewById(R.id.cs_history_item_time_tv);
            this.mPriceTv = (TextView) view.findViewById(R.id.cs_history_item_price_tv);
            this.mPayTypeTv = (TextView) view.findViewById(R.id.cs_history_item_pay_type_tv);
            if (CsTopupHistoryAdapter.this.f32288a != null) {
                view.setOnClickListener(new View.OnClickListener(CsTopupHistoryAdapter.this) {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        CsTopupHistoryAdapter.this.f32288a.onItemClick(CsHistoryViewHolder.this.mItem);
                    }
                });
            }
        }

        public void bindData(CsHistoryItem csHistoryItem) {
            this.mItem = csHistoryItem;
            this.mNameTv.setText(csHistoryItem.name);
            this.mOrderIdTv.setText(csHistoryItem.orderId);
            this.mOrderTimeTv.setText(csHistoryItem.statusTime);
            this.mPayTypeTv.setText(csHistoryItem.payType);
            this.mPriceTv.setText(String.format(CsTopupHistoryAdapter.this.f32289b.getString(R.string.wallet_topup_item_symbal_formater), new Object[]{csHistoryItem.currencySymbol, csHistoryItem.amount}));
            csHistoryItem.statusDesc.bindTextView(this.mStatusDescTv);
        }
    }
}
