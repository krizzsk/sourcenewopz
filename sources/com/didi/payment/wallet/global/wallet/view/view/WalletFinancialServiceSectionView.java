package com.didi.payment.wallet.global.wallet.view.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.payment.wallet.global.model.resp.WalletPageQueryResp;
import com.didi.payment.wallet.global.wallet.view.adapter.WalletFinancialServiceEnterAdapter;
import com.taxis99.R;
import java.util.ArrayList;

public class WalletFinancialServiceSectionView extends WalletAbsSectionView<WalletPageQueryResp.FinanceSection, IWalletMainListEventListener> implements WalletFinancialServiceEnterAdapter.FinanceItemClickListener {

    /* renamed from: a */
    private TextView f32417a;

    /* renamed from: b */
    private RecyclerView f32418b;

    /* renamed from: c */
    private WalletFinancialServiceEnterAdapter f32419c;

    public WalletFinancialServiceSectionView(Context context) {
        super(context);
    }

    public WalletFinancialServiceSectionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WalletFinancialServiceSectionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void onFinanceItemClick(WalletPageQueryResp.FinanceItem financeItem) {
        if (this.mListener != null) {
            ((IWalletMainListEventListener) this.mListener).onFinanceItemClick(financeItem);
        }
    }

    public void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.wallet_consume_enter_section, this, true);
        this.f32417a = (TextView) findViewById(R.id.wallet_consume_enter_title);
        this.f32418b = (RecyclerView) findViewById(R.id.wallet_consume_enter_rl);
        this.f32419c = new WalletFinancialServiceEnterAdapter(context, this);
        this.f32418b.setLayoutManager(new GridLayoutManager(this.mContext, 2));
        this.f32418b.setAdapter(this.f32419c);
        this.f32418b.setNestedScrollingEnabled(false);
    }

    public void updateContent(WalletPageQueryResp.FinanceSection financeSection) {
        if (financeSection == null || financeSection.entryList == null || financeSection.entryList.isEmpty()) {
            setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (WalletPageQueryResp.FinanceItem next : financeSection.entryList) {
            if (next.enabled) {
                arrayList.add(next);
            }
        }
        if (arrayList.isEmpty()) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.f32417a.setText(financeSection.title);
        this.f32419c.setData(arrayList);
    }
}
