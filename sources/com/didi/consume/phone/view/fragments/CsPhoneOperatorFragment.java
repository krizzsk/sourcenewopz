package com.didi.consume.phone.view.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.consume.base.CsOmegaUtils;
import com.didi.consume.phone.model.CsOperatorListResp;
import com.didi.consume.phone.view.adapter.CsMobileOperatorAdapter;
import com.didi.consume.phone.view.contract.CsPhoneOperatorContract;
import com.didi.consume.phone.view.prsenter.CsPhoneOperatorPresenter;
import com.didi.payment.base.view.PayHomelandCityErrorView;
import com.didi.payment.creditcard.global.widget.NoDoubleClickListener;
import com.didi.payment.wallet.global.wallet.contract.WalletLoadingContract;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.taxis99.R;
import java.util.HashMap;

public class CsPhoneOperatorFragment extends Fragment implements CsPhoneOperatorContract.View {

    /* renamed from: a */
    private static final String f16330a = "param_country_code";

    /* renamed from: b */
    private static final String f16331b = "param_phone_num";

    /* renamed from: c */
    private String f16332c;

    /* renamed from: d */
    private String f16333d;

    /* renamed from: e */
    private LinearLayout f16334e;

    /* renamed from: f */
    private RecyclerView f16335f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public CsMobileOperatorAdapter f16336g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public TextView f16337h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public CsPhoneOperatorContract.Presenter f16338i;

    /* renamed from: j */
    private WalletLoadingContract f16339j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public OnFragmentOperatorInteractionListener f16340k;

    /* renamed from: l */
    private CsMobileOperatorAdapter.OnOperatorClickListener f16341l = new CsMobileOperatorAdapter.OnOperatorClickListener() {
        public void onClick(CsOperatorListResp.Operator operator) {
            CsPhoneOperatorFragment.this.f16336g.refreshSelectOperator(operator);
            CsPhoneOperatorFragment.this.f16337h.setEnabled(true);
            CsPhoneOperatorFragment.this.f16338i.trackOmega(0);
        }
    };

    /* renamed from: m */
    private View.OnClickListener f16342m = new NoDoubleClickListener() {
        public void onNoDoubleClick(View view) {
            if (CsPhoneOperatorFragment.this.f16336g.getCurrentSelectItem() != null) {
                CsOmegaUtils.trackPhoneBillConfirmBtnClicked(ErrorConst.ErrorParam.OPERATOR);
                CsPhoneOperatorFragment.this.f16340k.onFragmentOperatorInteraction(CsPhoneOperatorFragment.this.f16336g.getCurrentSelectItem());
            }
        }
    };

    public interface OnFragmentOperatorInteractionListener {
        void onFragmentOperatorInteraction(CsOperatorListResp.Operator operator);
    }

    public void onNetworkError() {
    }

    public static CsPhoneOperatorFragment newInstance(String str, String str2) {
        CsPhoneOperatorFragment csPhoneOperatorFragment = new CsPhoneOperatorFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(f16330a, str);
        bundle.putSerializable(f16331b, str2);
        csPhoneOperatorFragment.setArguments(bundle);
        return csPhoneOperatorFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f16332c = (String) getArguments().getSerializable(f16330a);
            this.f16333d = (String) getArguments().getSerializable(f16331b);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.cs_fragment_operator, viewGroup, false);
        m11970a(inflate);
        m11969a();
        this.f16338i = new CsPhoneOperatorPresenter(getActivity(), this, this.f16339j);
        return inflate;
    }

    public void onStart() {
        super.onStart();
        if (this.f16336g == null) {
            this.f16338i.getOperatorList(605, this.f16332c, this.f16333d);
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentOperatorInteractionListener) {
            this.f16340k = (OnFragmentOperatorInteractionListener) context;
            if (context instanceof WalletLoadingContract) {
                this.f16339j = (WalletLoadingContract) context;
                return;
            }
            throw new RuntimeException(context.toString() + " must implement WalletLoadingContract");
        }
        throw new RuntimeException(context.toString() + " must implement OnFragmentZipCodeInteractionListener");
    }

    /* renamed from: a */
    private void m11970a(View view) {
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_operator_content);
        this.f16334e = linearLayout;
        this.f16335f = (RecyclerView) linearLayout.findViewById(R.id.rv_operator_list);
        this.f16337h = (TextView) this.f16334e.findViewById(R.id.btn_operator_next);
    }

    /* renamed from: a */
    private void m11969a() {
        this.f16337h.setOnClickListener(this.f16342m);
    }

    public void showOperators(CsOperatorListResp csOperatorListResp) {
        this.f16336g = new CsMobileOperatorAdapter(getContext(), csOperatorListResp.data.operators, this.f16341l);
        this.f16335f.setLayoutManager(new GridLayoutManager(getContext(), 2));
        this.f16335f.setAdapter(this.f16336g);
        int intExtra = getActivity().getIntent().getIntExtra("order_type", -1);
        HashMap hashMap = new HashMap();
        int i = 1;
        if (intExtra != 1) {
            i = 0;
        }
        hashMap.put("order_type", Integer.valueOf(i));
        CsOmegaUtils.trackPhoneBillOperatorDisplay(hashMap);
    }

    public void showHomelandCityErrorPage() {
        PayHomelandCityErrorView.show(this.f16334e);
    }
}
