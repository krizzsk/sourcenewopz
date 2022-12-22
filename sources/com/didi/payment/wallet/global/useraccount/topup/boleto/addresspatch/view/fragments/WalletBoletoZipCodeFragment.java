package com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.view.fragments;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.drouter.utils.TextUtils;
import com.didi.payment.base.utils.WalletToast;
import com.didi.payment.wallet.global.omega.GlobalOmegaUtils;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.contract.WalletBoletoZipCodeContract;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.AddressFromZipCodeResp;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.presenter.WalletBoletoZipCodePresenter;
import com.didi.payment.wallet.global.wallet.contract.WalletLoadingContract;
import com.taxis99.R;

public class WalletBoletoZipCodeFragment extends Fragment implements WalletBoletoZipCodeContract.View {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public EditText f31911a;

    /* renamed from: b */
    private TextView f31912b;

    /* renamed from: c */
    private ImageView f31913c;

    /* renamed from: d */
    private WalletBoletoZipCodeContract.Presenter f31914d;

    /* renamed from: e */
    private WalletLoadingContract f31915e;

    /* renamed from: f */
    private OnFragmentZipCodeInteractionListener f31916f;

    public interface OnFragmentZipCodeInteractionListener {
        void onFragmentZipCodeInteraction(AddressFromZipCodeResp.DataBean dataBean);
    }

    public void onNetworkError() {
    }

    public static WalletBoletoZipCodeFragment newInstance() {
        WalletBoletoZipCodeFragment walletBoletoZipCodeFragment = new WalletBoletoZipCodeFragment();
        walletBoletoZipCodeFragment.setArguments(new Bundle());
        return walletBoletoZipCodeFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.wallet_global_fragment_boleto_cashin_zipcode, viewGroup, false);
        m22601a(inflate);
        m22600a();
        this.f31914d = new WalletBoletoZipCodePresenter(getActivity(), this, this.f31915e);
        GlobalOmegaUtils.trackBoletoAddressPatchZipcodePageSW();
        return inflate;
    }

    /* renamed from: a */
    private void m22601a(View view) {
        this.f31911a = (EditText) view.findViewById(R.id.et_boleto_zipcode_text);
        this.f31912b = (TextView) view.findViewById(R.id.btn_boleto_zipcode_next);
        this.f31913c = (ImageView) view.findViewById(R.id.tv_boleto_zipcode_delete_btn);
    }

    /* renamed from: a */
    private void m22600a() {
        this.f31911a.post(new Runnable() {
            public void run() {
                WalletBoletoZipCodeFragment.this.f31911a.requestFocus();
            }
        });
        this.f31911a.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                WalletBoletoZipCodeFragment.this.m22602b();
                WalletBoletoZipCodeFragment.this.m22604c();
            }
        });
        this.f31912b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalOmegaUtils.trackBoletoAddressPatchZipcodeButtonCK();
                WalletBoletoZipCodeFragment walletBoletoZipCodeFragment = WalletBoletoZipCodeFragment.this;
                walletBoletoZipCodeFragment.onButtonPressed(walletBoletoZipCodeFragment.f31911a.getText().toString());
            }
        });
        this.f31913c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                WalletBoletoZipCodeFragment.this.f31911a.setText("");
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m22602b() {
        if (m22606d()) {
            this.f31913c.setVisibility(0);
        } else {
            this.f31913c.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m22604c() {
        this.f31912b.setEnabled(m22606d());
    }

    /* renamed from: d */
    private boolean m22606d() {
        return !TextUtils.isEmpty(this.f31911a.getEditableText().toString());
    }

    public void onButtonPressed(String str) {
        if (str.length() != 8) {
            WalletToast.showFailedMsg(getActivity(), getActivity().getResources().getString(R.string.wallet_boleto_zipcode_error_toast));
            return;
        }
        WalletBoletoZipCodeContract.Presenter presenter = this.f31914d;
        if (presenter != null) {
            presenter.requestData(str);
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentZipCodeInteractionListener) {
            this.f31916f = (OnFragmentZipCodeInteractionListener) context;
            if (context instanceof WalletLoadingContract) {
                this.f31915e = (WalletLoadingContract) context;
                return;
            }
            throw new RuntimeException(context.toString() + " must implement WalletLoadingContract");
        }
        throw new RuntimeException(context.toString() + " must implement OnFragmentZipCodeInteractionListener");
    }

    public void onDetach() {
        super.onDetach();
        this.f31916f = null;
        this.f31915e = null;
    }

    public void sendAddress(AddressFromZipCodeResp.DataBean dataBean) {
        OnFragmentZipCodeInteractionListener onFragmentZipCodeInteractionListener = this.f31916f;
        if (onFragmentZipCodeInteractionListener != null) {
            onFragmentZipCodeInteractionListener.onFragmentZipCodeInteraction(dataBean);
        }
    }
}
