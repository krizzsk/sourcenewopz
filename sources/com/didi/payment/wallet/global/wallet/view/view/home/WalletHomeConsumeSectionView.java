package com.didi.payment.wallet.global.wallet.view.view.home;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.payment.wallet.global.model.resp.WalletHomeResp;
import com.didi.payment.wallet.global.wallet.contract.WalletHomeContract;
import com.didi.payment.wallet.global.wallet.view.adapter.WalletHomeConsumeEnterAdapter;
import com.taxis99.R;

public class WalletHomeConsumeSectionView extends WalletHomeAbsSectionView<WalletHomeResp.ConsumeSection, WalletHomeContract.Listener> implements WalletHomeConsumeEnterAdapter.AdapterItemCallback {

    /* renamed from: a */
    private TextView f32585a;

    /* renamed from: b */
    private RecyclerView f32586b;

    /* renamed from: c */
    private WalletHomeConsumeEnterAdapter f32587c;

    public WalletHomeConsumeSectionView(Context context) {
        super(context);
    }

    public WalletHomeConsumeSectionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WalletHomeConsumeSectionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.wallet_global_home_consume_enter_section, this, true);
        this.f32585a = (TextView) findViewById(R.id.tv_consume_title);
        this.f32586b = (RecyclerView) findViewById(R.id.rv_consume_list);
        this.f32587c = new WalletHomeConsumeEnterAdapter(getContext(), this);
        this.f32586b.setLayoutManager(new GridLayoutManager(this.mContext, 2));
        this.f32586b.setAdapter(this.f32587c);
        this.f32586b.setNestedScrollingEnabled(false);
    }

    public void updateContent(WalletHomeResp.ConsumeSection consumeSection) {
        if (consumeSection == null || consumeSection.entryList == null || consumeSection.entryList.size() < 2) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.f32585a.setText(consumeSection.title);
        this.f32587c.setData(consumeSection.entryList);
    }

    public void onConsumeEntryItemClicked(WalletHomeResp.ConsumeItem consumeItem) {
        if (this.mListener != null) {
            ((WalletHomeContract.Listener) this.mListener).onConsumeItemClicked(consumeItem);
        }
    }
}
