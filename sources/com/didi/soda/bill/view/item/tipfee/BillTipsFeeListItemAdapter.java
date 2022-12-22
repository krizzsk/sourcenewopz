package com.didi.soda.bill.view.item.tipfee;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.bill.model.datamodel.BillTipModel;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.locale.LocalizationUtils;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class BillTipsFeeListItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final Long FLAG_OF_OTHER_ITEM_VALUE = -1L;
    public static final int VIEW_TYPE_NORMAL_ITEM = 1;
    public static final int VIEW_TYPE_OTHER = 2;

    /* renamed from: a */
    private BillTipModel f39253a;

    /* renamed from: b */
    private String f39254b;

    /* renamed from: c */
    private List<Long> f39255c = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public OnItemClickListener f39256d;

    /* renamed from: e */
    private OnItemBindListener f39257e;

    /* renamed from: f */
    private ScopeContext f39258f;

    public interface OnItemBindListener {
        void onItemBind(View view);
    }

    public interface OnItemClickListener {
        void onItemClick(Long l, int i, int i2);
    }

    public BillTipsFeeListItemAdapter(ScopeContext scopeContext) {
        this.f39258f = scopeContext;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.f39256d = onItemClickListener;
    }

    public void setOnItemBindListener(OnItemBindListener onItemBindListener) {
        this.f39257e = onItemBindListener;
    }

    public int getItemViewType(int i) {
        return (i != this.f39255c.size() - 1 || this.f39255c.get(i) == null) ? 1 : 2;
    }

    public int getItemCount() {
        return this.f39255c.size();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
        List<Long> list;
        String str;
        String str2;
        if (viewHolder != null && (list = this.f39255c) != null && i < list.size()) {
            final Long l = this.f39255c.get(i);
            if (this.f39253a != null && l != null) {
                boolean z = false;
                if (getItemViewType(i) == 1) {
                    if (this.f39253a.isPercent()) {
                        str2 = l + "%";
                    } else if (l.longValue() % 100 == 0) {
                        str2 = LocalizationUtils.CurrencyUtils.getSimplifiedCurrencyWithSymbol(l.longValue(), this.f39254b);
                    } else {
                        str2 = LocalizationUtils.CurrencyUtils.getCurrency(l.longValue(), this.f39254b);
                    }
                    BillTipFeeItemViewHolder billTipFeeItemViewHolder = (BillTipFeeItemViewHolder) viewHolder;
                    String str3 = (this.f39253a.getMSuggestionEntity() == null || i != this.f39253a.getMSuggestionEntity().iconPosition) ? "" : this.f39253a.getMSuggestionEntity().iconUrl;
                    TipsFeeListItemView access$000 = billTipFeeItemViewHolder.mTipFeeItemView;
                    if (l.longValue() == this.f39253a.getTipFeeValue()) {
                        z = true;
                    }
                    access$000.setData(str2, z, str3, this.f39258f);
                    billTipFeeItemViewHolder.mTipFeeItemView.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            if (BillTipsFeeListItemAdapter.this.f39256d != null) {
                                BillTipsFeeListItemAdapter.this.f39256d.onItemClick(l, i, 1);
                            }
                        }
                    });
                    return;
                }
                BillTipFeeOtherViewHolder billTipFeeOtherViewHolder = (BillTipFeeOtherViewHolder) viewHolder;
                if (l == FLAG_OF_OTHER_ITEM_VALUE) {
                    str = ResourceHelper.getString(R.string.customer_cart_business_tip_other);
                } else if (this.f39253a.isPercent()) {
                    str = l + "%";
                } else if (l.longValue() % 100 == 0) {
                    str = LocalizationUtils.CurrencyUtils.getSimplifiedCurrencyWithSymbol(l.longValue(), this.f39254b);
                } else {
                    str = LocalizationUtils.CurrencyUtils.getCurrency(l.longValue(), this.f39254b);
                }
                TipsFeeListOtherView access$200 = billTipFeeOtherViewHolder.mTipsOtherView;
                if (l != FLAG_OF_OTHER_ITEM_VALUE) {
                    z = true;
                }
                access$200.setData(str, z, this.f39258f);
                billTipFeeOtherViewHolder.mTipsOtherView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if (BillTipsFeeListItemAdapter.this.f39256d != null) {
                            BillTipsFeeListItemAdapter.this.f39256d.onItemClick(l, i, 2);
                        }
                    }
                });
            }
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new BillTipFeeItemViewHolder(new TipsFeeListItemView(viewGroup.getContext()));
        }
        return new BillTipFeeOtherViewHolder(new TipsFeeListOtherView(viewGroup.getContext()));
    }

    public void setData(BillTipModel billTipModel, String str) {
        if (billTipModel != null) {
            this.f39253a = billTipModel;
            this.f39254b = str;
            this.f39255c.clear();
            if (!CollectionsUtil.isEmpty(billTipModel.getTipConfigList())) {
                this.f39255c.addAll(billTipModel.getTipConfigList());
            }
            notifyDataSetChanged();
        }
    }

    static class BillTipFeeItemViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public TipsFeeListItemView mTipFeeItemView;

        BillTipFeeItemViewHolder(TipsFeeListItemView tipsFeeListItemView) {
            super(tipsFeeListItemView);
            this.mTipFeeItemView = tipsFeeListItemView;
        }
    }

    static class BillTipFeeOtherViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public TipsFeeListOtherView mTipsOtherView;

        BillTipFeeOtherViewHolder(TipsFeeListOtherView tipsFeeListOtherView) {
            super(tipsFeeListOtherView);
            this.mTipsOtherView = tipsFeeListOtherView;
        }
    }
}
