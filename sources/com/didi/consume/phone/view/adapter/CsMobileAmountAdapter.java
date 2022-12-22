package com.didi.consume.phone.view.adapter;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.consume.phone.model.CsAmountListResp;
import com.didi.payment.base.utils.UIUtil;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CsMobileAmountAdapter extends RecyclerView.Adapter<AmountHolder> implements View.OnClickListener {

    /* renamed from: a */
    private final List<CsAmountListResp.Amount> f16267a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final OnAmountClickListener f16268b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Context f16269c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f16270d = "";

    public interface OnAmountClickListener {
        void onClick(CsAmountListResp.Amount amount, String str);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
    }

    public CsMobileAmountAdapter(Context context, List<CsAmountListResp.Amount> list, String str, OnAmountClickListener onAmountClickListener) {
        ArrayList arrayList = new ArrayList();
        this.f16267a = arrayList;
        if (list != null) {
            arrayList.addAll(list);
        }
        this.f16270d = str;
        this.f16268b = onAmountClickListener;
        this.f16269c = context;
    }

    public void refreshSelectAmount(CsAmountListResp.Amount amount) {
        Iterator<CsAmountListResp.Amount> it = this.f16267a.iterator();
        while (it.hasNext()) {
            CsAmountListResp.Amount next = it.next();
            next.selected = next == amount;
        }
        notifyDataSetChanged();
    }

    public CsAmountListResp.Amount getCurrentSelectItem() {
        for (CsAmountListResp.Amount next : this.f16267a) {
            if (next.selected) {
                return next;
            }
        }
        return null;
    }

    public AmountHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new AmountHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cs_fragment_amount_item, viewGroup, false), this.f16268b);
    }

    public void onBindViewHolder(AmountHolder amountHolder, int i) {
        amountHolder.bind(this.f16267a.get(i));
    }

    public int getItemCount() {
        return this.f16267a.size();
    }

    public class AmountHolder extends RecyclerView.ViewHolder {
        private TextView mTVAmount;
        private TextView mTVCashBack;
        private View mVSelected;

        public AmountHolder(View view, OnAmountClickListener onAmountClickListener) {
            super(view);
            this.mTVAmount = (TextView) view.findViewById(R.id.tv_amount_text);
            this.mTVCashBack = (TextView) view.findViewById(R.id.tv_cashback);
            this.mVSelected = view.findViewById(R.id.v_amount_selected);
        }

        public void bind(final CsAmountListResp.Amount amount) {
            setAmount(amount.currencySymbol, amount.amount, "1".equalsIgnoreCase(amount.disabled));
            if (amount.cashBackAmount != null) {
                amount.cashBackAmount.bindTextView(this.mTVCashBack);
            }
            if (amount.selected) {
                this.mVSelected.setVisibility(0);
            } else {
                this.mVSelected.setVisibility(8);
            }
            this.itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (CsMobileAmountAdapter.this.f16268b != null) {
                        CsMobileAmountAdapter.this.f16268b.onClick(amount, CsMobileAmountAdapter.this.f16270d);
                    }
                }
            });
        }

        private void setAmount(String str, String str2, boolean z) {
            String str3 = str + str2;
            SpannableString spannableString = new SpannableString(str3);
            spannableString.setSpan(new AbsoluteSizeSpan(UIUtil.dip2px(CsMobileAmountAdapter.this.f16269c, 28.0f)), 0, str3.length(), 0);
            spannableString.setSpan(new AbsoluteSizeSpan(UIUtil.dip2px(CsMobileAmountAdapter.this.f16269c, 21.0f)), 0, str.length(), 0);
            spannableString.setSpan(new ForegroundColorSpan(CsMobileAmountAdapter.this.f16269c.getResources().getColor(z ? R.color.wallet_color_D4D7D9 : R.color.color_333333)), 0, str3.length(), 0);
            spannableString.setSpan(new StyleSpan(1), 0, str3.length(), 0);
            this.mTVAmount.setText(spannableString);
        }
    }
}
