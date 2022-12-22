package com.didi.payment.wallet.global.wallet.view.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.taxis99.R;
import java.util.List;

public class WalletBalanceIntroductionView extends LinearLayout {

    /* renamed from: a */
    private TextView f32400a;

    /* renamed from: b */
    private LinearLayout f32401b;

    public WalletBalanceIntroductionView(Context context) {
        this(context, (AttributeSet) null);
    }

    public WalletBalanceIntroductionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WalletBalanceIntroductionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        m23001a();
    }

    /* renamed from: a */
    private void m23001a() {
        this.f32400a = (TextView) findViewById(R.id.tv_introduction_title);
        this.f32401b = (LinearLayout) findViewById(R.id.ll_introduction_list);
        this.f32400a.setText("");
    }

    public void updateContent(String str, List<String> list) {
        if (list == null || list.size() <= 0) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.f32400a.setText(str);
        this.f32401b.removeAllViews();
        for (String text : list) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.wallet_global_new_balance_introduction_item, this.f32401b, false);
            ((TextView) inflate.findViewById(R.id.tv_notification_item)).setText(text);
            this.f32401b.addView(inflate);
        }
    }
}
