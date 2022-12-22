package com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.view.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.drouter.utils.TextUtils;
import com.didi.payment.wallet.global.omega.GlobalOmegaUtils;
import com.didi.payment.wallet.global.useraccount.constant.WalletConstants;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.contract.WalletBoletoAddressContract;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.AddressFromZipCodeResp;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.recyclerview.ListFragmentExtraCity;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.recyclerview.ListFragmentExtraState;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.presenter.WalletBoletoAddressPresenter;
import com.didi.payment.wallet.global.wallet.contract.WalletLoadingContract;
import com.taxis99.R;

public class WalletBoletoAddressFragment extends Fragment implements WalletBoletoAddressContract.View {

    /* renamed from: a */
    private static final String f31882a = "boletoAddress";

    /* renamed from: b */
    private static final String f31883b = "SCROLL_POSITION";
    /* access modifiers changed from: private */

    /* renamed from: c */
    public AddressFromZipCodeResp.DataBean f31884c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public OnFragmentAddressInteractionListener f31885d;

    /* renamed from: e */
    private WalletLoadingContract f31886e;

    /* renamed from: f */
    private WalletBoletoAddressContract.Presenter f31887f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public ScrollView f31888g;

    /* renamed from: h */
    private EditText f31889h;

    /* renamed from: i */
    private EditText f31890i;

    /* renamed from: j */
    private EditText f31891j;

    /* renamed from: k */
    private EditText f31892k;

    /* renamed from: l */
    private EditText f31893l;

    /* renamed from: m */
    private EditText f31894m;

    /* renamed from: n */
    private EditText f31895n;

    /* renamed from: o */
    private TextView f31896o;

    public interface OnFragmentAddressInteractionListener {
        void onFragmentPatchSuccessInteraction();

        void onFragmentRequestCityInteraction(ListFragmentExtraCity listFragmentExtraCity, WalletBoletoAddressFragment walletBoletoAddressFragment);

        void onFragmentRequestStateInteraction(ListFragmentExtraState listFragmentExtraState, WalletBoletoAddressFragment walletBoletoAddressFragment);
    }

    public void onNetworkError() {
    }

    public static WalletBoletoAddressFragment newInstance(AddressFromZipCodeResp.DataBean dataBean) {
        WalletBoletoAddressFragment walletBoletoAddressFragment = new WalletBoletoAddressFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(f31882a, dataBean);
        walletBoletoAddressFragment.setArguments(bundle);
        return walletBoletoAddressFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f31884c = (AddressFromZipCodeResp.DataBean) getArguments().getSerializable(f31882a);
        }
        this.f31887f = new WalletBoletoAddressPresenter(getActivity(), this, this.f31886e);
    }

    public void onResume() {
        super.onResume();
        m22587a();
    }

    public void onPause() {
        super.onPause();
        if (this.f31884c == null) {
            this.f31884c = new AddressFromZipCodeResp.DataBean();
        }
        this.f31884c.zipCode = this.f31889h.getText().toString();
        this.f31884c.streetName = this.f31890i.getText().toString();
        this.f31884c.number = this.f31891j.getText().toString();
        this.f31884c.complement = this.f31892k.getText().toString();
        this.f31884c.neighborhood = this.f31893l.getText().toString();
        this.f31884c.state = this.f31894m.getText().toString();
        this.f31884c.city = this.f31895n.getText().toString();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.wallet_global_fragment_boleto_cashin_address, viewGroup, false);
        m22588a(inflate);
        GlobalOmegaUtils.trackBoletoAddressPatchDetailSW();
        return inflate;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putIntArray(f31883b, new int[]{this.f31888g.getScrollX(), this.f31888g.getScrollY()});
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
        r3 = r3.getIntArray(f31883b);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onViewStateRestored(android.os.Bundle r3) {
        /*
            r2 = this;
            super.onViewStateRestored(r3)
            if (r3 != 0) goto L_0x0006
            return
        L_0x0006:
            java.lang.String r0 = "SCROLL_POSITION"
            int[] r3 = r3.getIntArray(r0)
            if (r3 == 0) goto L_0x0018
            android.widget.ScrollView r0 = r2.f31888g
            com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.view.fragments.WalletBoletoAddressFragment$1 r1 = new com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.view.fragments.WalletBoletoAddressFragment$1
            r1.<init>(r3)
            r0.post(r1)
        L_0x0018:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.view.fragments.WalletBoletoAddressFragment.onViewStateRestored(android.os.Bundle):void");
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            return;
        }
        if (i == 103) {
            this.f31884c.state = intent.getStringExtra(WalletConstants.KEY_INTENT_LIST_CALLBACK_KEY);
        } else if (i == 104) {
            this.f31884c.city = intent.getStringExtra(WalletConstants.KEY_INTENT_LIST_CALLBACK_KEY);
        }
    }

    /* renamed from: a */
    private void m22588a(View view) {
        this.f31888g = (ScrollView) view.findViewById(R.id.sv_boleto_address);
        this.f31889h = (EditText) view.findViewById(R.id.et_topup_boleto_zipcode_content);
        this.f31890i = (EditText) view.findViewById(R.id.et_topup_boleto_street_content);
        this.f31891j = (EditText) view.findViewById(R.id.et_topup_boleto_number_content);
        this.f31892k = (EditText) view.findViewById(R.id.et_topup_boleto_complement_content);
        this.f31893l = (EditText) view.findViewById(R.id.et_topup_boleto_district_content);
        this.f31894m = (EditText) view.findViewById(R.id.et_topup_boleto_state_content);
        this.f31895n = (EditText) view.findViewById(R.id.et_topup_boleto_city_content);
        this.f31896o = (TextView) view.findViewById(R.id.btn_view_boleto_submit_address);
    }

    /* renamed from: a */
    private void m22587a() {
        C111352 r0 = new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                WalletBoletoAddressFragment.this.m22589b();
            }
        };
        this.f31889h.addTextChangedListener(r0);
        this.f31890i.addTextChangedListener(r0);
        this.f31891j.addTextChangedListener(r0);
        this.f31892k.addTextChangedListener(r0);
        this.f31893l.addTextChangedListener(r0);
        this.f31894m.addTextChangedListener(r0);
        this.f31895n.addTextChangedListener(r0);
        AddressFromZipCodeResp.DataBean dataBean = this.f31884c;
        if (dataBean != null) {
            if (dataBean.zipCode != null) {
                this.f31889h.setText(this.f31884c.zipCode);
            }
            if (this.f31884c.streetName != null) {
                this.f31890i.setText(this.f31884c.streetName);
            }
            if (this.f31884c.number != null) {
                this.f31891j.setText(this.f31884c.number);
            }
            if (this.f31884c.complement != null) {
                this.f31892k.setText(this.f31884c.complement);
            }
            if (this.f31884c.neighborhood != null) {
                this.f31893l.setText(this.f31884c.neighborhood);
            }
            if (this.f31884c.state != null) {
                this.f31894m.setText(this.f31884c.state);
            }
            if (this.f31884c.city != null) {
                this.f31895n.setText(this.f31884c.city);
            }
        }
        this.f31894m.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                WalletBoletoAddressFragment.this.f31885d.onFragmentRequestStateInteraction(new ListFragmentExtraState("BR"), WalletBoletoAddressFragment.this);
            }
        });
        this.f31895n.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (WalletBoletoAddressFragment.this.f31884c.state != null && !TextUtils.isEmpty(WalletBoletoAddressFragment.this.f31884c.state)) {
                    WalletBoletoAddressFragment.this.f31885d.onFragmentRequestCityInteraction(new ListFragmentExtraCity("BR", WalletBoletoAddressFragment.this.f31884c.state), WalletBoletoAddressFragment.this);
                }
            }
        });
        this.f31896o.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalOmegaUtils.trackBoletoAddressPatchDetailBtnCK();
                WalletBoletoAddressFragment.this.onButtonPressed();
            }
        });
        this.f31889h.requestFocus();
        ((InputMethodManager) getActivity().getSystemService("input_method")).toggleSoftInput(2, 0);
        EditText editText = this.f31889h;
        editText.setSelection(editText.length());
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m22589b() {
        this.f31896o.setEnabled(m22592c());
    }

    /* renamed from: c */
    private boolean m22592c() {
        return !TextUtils.isEmpty(this.f31889h.getEditableText().toString()) && !TextUtils.isEmpty(this.f31890i.getEditableText().toString()) && !TextUtils.isEmpty(this.f31893l.getEditableText().toString()) && !TextUtils.isEmpty(this.f31894m.getEditableText().toString()) && !TextUtils.isEmpty(this.f31895n.getEditableText().toString());
    }

    public void onButtonPressed() {
        this.f31884c.zipCode = this.f31889h.getText().toString();
        this.f31884c.streetName = this.f31890i.getText().toString();
        this.f31884c.number = this.f31891j.getText().toString();
        this.f31884c.complement = this.f31892k.getText().toString();
        this.f31884c.neighborhood = this.f31893l.getText().toString();
        this.f31884c.state = this.f31894m.getText().toString();
        this.f31884c.city = this.f31895n.getText().toString();
        this.f31887f.requestData(this.f31884c);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentAddressInteractionListener) {
            this.f31885d = (OnFragmentAddressInteractionListener) context;
            if (context instanceof WalletLoadingContract) {
                this.f31886e = (WalletLoadingContract) context;
                return;
            }
            throw new RuntimeException(context.toString() + " must implement WalletLoadingContract");
        }
        throw new RuntimeException(context.toString() + " must implement OnFragmentAddressInteractionListener");
    }

    public void onDetach() {
        super.onDetach();
        this.f31885d = null;
        this.f31886e = null;
    }

    public void onAddressPatchSuccessful() {
        OnFragmentAddressInteractionListener onFragmentAddressInteractionListener = this.f31885d;
        if (onFragmentAddressInteractionListener != null) {
            onFragmentAddressInteractionListener.onFragmentPatchSuccessInteraction();
        }
    }
}
