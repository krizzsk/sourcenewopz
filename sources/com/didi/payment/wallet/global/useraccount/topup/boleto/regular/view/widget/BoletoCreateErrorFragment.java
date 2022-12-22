package com.didi.payment.wallet.global.useraccount.topup.boleto.regular.view.widget;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.view.SimplePopupBase;
import com.taxis99.R;

public class BoletoCreateErrorFragment extends SimplePopupBase {

    /* renamed from: a */
    private TextView f31993a;

    /* renamed from: b */
    private TextView f31994b;

    /* renamed from: c */
    private String f31995c;

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.wallet_global_dialog_create_new_boleto_error;
    }

    /* access modifiers changed from: protected */
    public void initView() {
        this.f31994b = (TextView) this.mRootView.findViewById(R.id.tv_new_boleto_error_title);
        TextView textView = (TextView) this.mRootView.findViewById(R.id.btn_new_boleto_error_title);
        this.f31993a = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                BoletoCreateErrorFragment.this.dismissAllowingStateLoss();
            }
        });
        m22648a(this.f31995c);
    }

    public void setData(String str) {
        this.f31995c = str;
    }

    /* renamed from: a */
    private void m22648a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f31994b.setText(str);
        }
    }
}
