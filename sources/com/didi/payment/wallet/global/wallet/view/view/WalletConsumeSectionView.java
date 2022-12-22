package com.didi.payment.wallet.global.wallet.view.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.payment.wallet.global.model.resp.WalletHomeResp;
import com.didi.payment.wallet.global.wallet.view.adapter.WalletHomeConsumeEnterAdapter;
import com.taxis99.R;

public class WalletConsumeSectionView extends WalletAbsSectionView<WalletHomeResp.ConsumeSection, IWalletMainListEventListener> implements WalletHomeConsumeEnterAdapter.AdapterItemCallback {

    /* renamed from: a */
    private TextView f32414a;

    /* renamed from: b */
    private RecyclerView f32415b;

    /* renamed from: c */
    private WalletHomeConsumeEnterAdapter f32416c;

    public WalletConsumeSectionView(Context context) {
        super(context);
    }

    public WalletConsumeSectionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WalletConsumeSectionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.wallet_consume_enter_section, this, true);
        this.f32414a = (TextView) findViewById(R.id.wallet_consume_enter_title);
        this.f32415b = (RecyclerView) findViewById(R.id.wallet_consume_enter_rl);
        WalletHomeConsumeEnterAdapter walletHomeConsumeEnterAdapter = new WalletHomeConsumeEnterAdapter(getContext(), this);
        this.f32416c = walletHomeConsumeEnterAdapter;
        walletHomeConsumeEnterAdapter.setInternalActionInterceptor(new WalletHomeConsumeEnterAdapter.OnActionInterceptor() {
            public boolean onIntercept(int i, WalletHomeResp.ConsumeItem consumeItem) {
                return WalletConsumeSectionView.this.mListener != null && ((IWalletMainListEventListener) WalletConsumeSectionView.this.mListener).onConsumeItemClickIntercept(consumeItem);
            }
        });
        this.f32415b.setLayoutManager(new GridLayoutManager(this.mContext, 2));
        this.f32415b.setAdapter(this.f32416c);
        this.f32415b.setNestedScrollingEnabled(false);
    }

    public void updateContent(WalletHomeResp.ConsumeSection consumeSection) {
        if (consumeSection == null || consumeSection.entryList == null || consumeSection.entryList.size() < 2) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.f32414a.setText(consumeSection.title);
        this.f32416c.setData(consumeSection.entryList);
    }

    public void onConsumeEntryItemClicked(WalletHomeResp.ConsumeItem consumeItem) {
        if (this.mListener != null) {
            ((IWalletMainListEventListener) this.mListener).onConsumeItemClicked(consumeItem);
        }
    }
}
