package com.didi.payment.wallet.global.useraccount.topup.boleto.regular.view.widget;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.wallet.global.omega.GlobalOmegaUtils;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.contract.WalletSendEmailContract;
import com.didi.sdk.view.SimplePopupBase;
import com.taxis99.R;

public class BoletoSendEmailDialogFragment extends SimplePopupBase {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public EditText f31996a;

    /* renamed from: b */
    private TextView f31997b;

    /* renamed from: c */
    private String f31998c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public WalletSendEmailContract f31999d;

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.wallet_global_dialog_boleto_send_email;
    }

    /* access modifiers changed from: protected */
    public void initView() {
        this.f31996a = (EditText) this.mRootView.findViewById(R.id.tv_boleto_send_email_address);
        TextView textView = (TextView) this.mRootView.findViewById(R.id.btn_boleto_send_email_ok);
        this.f31997b = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalOmegaUtils.trackBillSendEmailBtnCK();
                if (BoletoSendEmailDialogFragment.this.f31999d != null) {
                    BoletoSendEmailDialogFragment.this.f31999d.onSendClick(BoletoSendEmailDialogFragment.this.f31996a.getText().toString());
                }
            }
        });
        m22651a(this.f31998c);
        m22650a();
    }

    public void setData(String str) {
        this.f31998c = str;
    }

    public void setWalletSendEmailContract(WalletSendEmailContract walletSendEmailContract) {
        this.f31999d = walletSendEmailContract;
    }

    /* renamed from: a */
    private void m22651a(String str) {
        this.f31996a.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                BoletoSendEmailDialogFragment.this.m22650a();
            }
        });
        if (!TextUtils.isEmpty(str)) {
            this.f31996a.setText(str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22650a() {
        this.f31997b.setEnabled(m22653b());
    }

    /* renamed from: b */
    private boolean m22653b() {
        return !com.didi.drouter.utils.TextUtils.isEmpty(this.f31996a.getEditableText().toString());
    }

    public void dismissEmailDialog() {
        dismissAllowingStateLoss();
    }
}
