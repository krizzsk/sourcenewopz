package com.didi.consume.phone.view.fragments;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.consume.base.CsOmegaUtils;
import com.didi.consume.base.CsRouter;
import com.didi.consume.phone.model.CsDefaultPhoneNumberResp;
import com.didi.consume.phone.view.contract.CsCountryCodePickerContract;
import com.didi.consume.phone.view.contract.CsPhoneNumContract;
import com.didi.consume.phone.view.prsenter.CsPhoneNumPresenter;
import com.didi.consume.phone.view.widget.CountryCodePickerFragment;
import com.didi.consume.phone.view.widget.KeyboardEditText;
import com.didi.payment.base.utils.TextHighlightUtil;
import com.didi.payment.base.utils.WalletToast;
import com.didi.payment.creditcard.global.widget.NoDoubleClickListener;
import com.didi.payment.wallet.global.wallet.contract.WalletLoadingContract;
import com.didi.sdk.util.TextUtil;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class CsPhoneNumberFragment extends Fragment implements CsCountryCodePickerContract, CsPhoneNumContract.View {

    /* renamed from: b */
    private static final Integer f16311b = 11;

    /* renamed from: a */
    List<String> f16312a;

    /* renamed from: c */
    private View f16313c;

    /* renamed from: d */
    private TextView f16314d;

    /* renamed from: e */
    private TextView f16315e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public TextView f16316f;

    /* renamed from: g */
    private TextView f16317g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public KeyboardEditText f16318h;

    /* renamed from: i */
    private TextView f16319i;

    /* renamed from: j */
    private ImageView f16320j;

    /* renamed from: k */
    private TextView f16321k;

    /* renamed from: l */
    private TextView f16322l;

    /* renamed from: m */
    private CountryCodePickerFragment f16323m;

    /* renamed from: n */
    private CsDefaultPhoneNumberResp.HistoryDataBean f16324n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public CsPhoneNumContract.Presenter f16325o;

    /* renamed from: p */
    private WalletLoadingContract f16326p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public OnFragmentPhoneNumberInteractionListener f16327q;

    /* renamed from: r */
    private View.OnTouchListener f16328r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public KeyboardEditText.KeyboardListener f16329s;

    public interface OnFragmentPhoneNumberInteractionListener {
        void onFragmentPhoneNumberInteraction(String str, String str2);
    }

    public static CsPhoneNumberFragment newInstance() {
        return new CsPhoneNumberFragment();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f16325o = new CsPhoneNumPresenter(getActivity(), this, this.f16326p);
        View inflate = layoutInflater.inflate(R.layout.cs_fragment_phone_number, viewGroup, false);
        this.f16313c = inflate;
        m11953a(inflate);
        m11952a();
        this.f16325o.init();
        return this.f16313c;
    }

    public void onResume() {
        super.onResume();
    }

    public void onStart() {
        super.onStart();
        if (TextUtils.isEmpty(this.f16318h.getEditableText().toString())) {
            this.f16318h.setText("");
            this.f16316f.setText("");
            this.f16325o.getDefaultPhoneNum(605);
        }
    }

    /* renamed from: a */
    private void m11953a(View view) {
        this.f16314d = (TextView) view.findViewById(R.id.tv_phone_number_title);
        this.f16315e = (TextView) view.findViewById(R.id.tv_phone_number_sub_title);
        this.f16317g = (TextView) view.findViewById(R.id.tv_phone_number_activity);
        this.f16316f = (TextView) view.findViewById(R.id.country_switch_view);
        this.f16318h = (KeyboardEditText) view.findViewById(R.id.et_phone_number);
        this.f16319i = (TextView) view.findViewById(R.id.btn_phone_number_next);
        this.f16320j = (ImageView) view.findViewById(R.id.tv_phone_number_delete_btn);
        this.f16321k = (TextView) view.findViewById(R.id.tv_kyc_tag);
        this.f16322l = (TextView) view.findViewById(R.id.tv_verify_kyc);
        this.f16323m = new CountryCodePickerFragment();
    }

    /* renamed from: a */
    private void m11952a() {
        OnTouchEventImpl onTouchEventImpl = new OnTouchEventImpl();
        this.f16328r = onTouchEventImpl;
        this.f16313c.setOnTouchListener(onTouchEventImpl);
        KeyboardVisibilityListenerImpl keyboardVisibilityListenerImpl = new KeyboardVisibilityListenerImpl();
        this.f16329s = keyboardVisibilityListenerImpl;
        this.f16318h.setOnKeyboardListener(keyboardVisibilityListenerImpl);
    }

    /* renamed from: b */
    private void m11956b() {
        this.f16316f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CsPhoneNumberFragment.this.m11957c();
            }
        });
        this.f16318h.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                CsPhoneNumberFragment.this.f16318h.setTextColor(ResourcesCompat.getColor(CsPhoneNumberFragment.this.getResources(), R.color.black, CsPhoneNumberFragment.this.getActivity().getTheme()));
                CsPhoneNumberFragment.this.m11960d();
                CsPhoneNumberFragment.this.updateDeleteBtn();
            }
        });
        this.f16318h.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6) {
                    CsPhoneNumberFragment.this.f16329s.onStateChanged((KeyboardEditText) null, false);
                }
                return false;
            }
        });
        this.f16319i.setOnClickListener(new NoDoubleClickListener() {
            public void onNoDoubleClick(View view) {
                if (CsPhoneNumberFragment.this.m11961e()) {
                    CsOmegaUtils.trackPhoneBillConfirmBtnClicked("phonenumber");
                    CsPhoneNumberFragment.this.f16327q.onFragmentPhoneNumberInteraction(CsPhoneNumberFragment.this.f16316f.getText().toString(), CsPhoneNumberFragment.this.f16318h.getText().toString());
                }
            }
        });
        this.f16320j.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CsPhoneNumberFragment.this.f16318h.setText("");
            }
        });
    }

    public void checkPhoneNumberFormat() {
        if (!m11961e()) {
            this.f16318h.setTextColor(ResourcesCompat.getColor(getResources(), R.color.wallet_color_FF525D, getActivity().getTheme()));
            WalletToast.showFailedMsg(getContext(), getContext().getResources().getString(R.string.cs_phone_num_invalid_phone_num));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m11957c() {
        this.f16323m.setData(this.f16312a);
        this.f16323m.setWalletSendEmailContract(this);
        if (getFragmentManager() != null) {
            this.f16323m.show(getFragmentManager(), "countryCodePicker");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m11960d() {
        this.f16319i.setEnabled(m11961e());
    }

    public void updateDeleteBtn() {
        if (!TextUtil.isEmpty(this.f16318h.getText().toString())) {
            setDeleteBtnVisible();
        } else {
            setDeleteBtnInvisible();
        }
    }

    public void setDeleteBtnInvisible() {
        this.f16320j.setVisibility(8);
    }

    public void setDeleteBtnVisible() {
        this.f16320j.setVisibility(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public boolean m11961e() {
        return !TextUtils.isEmpty(this.f16318h.getEditableText().toString()) && this.f16318h.getEditableText().toString().length() >= f16311b.intValue();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentPhoneNumberInteractionListener) {
            this.f16327q = (OnFragmentPhoneNumberInteractionListener) context;
            if (context instanceof WalletLoadingContract) {
                this.f16326p = (WalletLoadingContract) context;
                return;
            }
            throw new RuntimeException(context.toString() + " must implement WalletLoadingContract");
        }
        throw new RuntimeException(context.toString() + " must implement OnFragmentZipCodeInteractionListener");
    }

    public void onDetach() {
        super.onDetach();
        this.f16327q = null;
        this.f16326p = null;
    }

    public void showActivity(String str) {
        this.f16317g.setVisibility(0);
        this.f16317g.setText(str);
        this.f16317g.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CsPhoneNumberFragment.this.f16325o.jumpToActivityPage();
            }
        });
    }

    public void showPhoneNumber(final CsDefaultPhoneNumberResp.DataBean dataBean) {
        if (dataBean != null) {
            if (1 != dataBean.status && !TextUtils.isEmpty(dataBean.statusMessage)) {
                TextView textView = this.f16322l;
                textView.setText(TextHighlightUtil.highlight(dataBean.statusMessage + " >", Color.parseColor("#5C6166"), Color.parseColor("#FF8040")));
                this.f16322l.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        CsRouter.gotoAccountPage(CsPhoneNumberFragment.this.getActivity(), dataBean.status, dataBean.accountStatus);
                    }
                });
            }
            if (dataBean.mobileRechargeTopMessage != null) {
                dataBean.mobileRechargeTopMessage.bindTextView(this.f16315e);
            }
            this.f16324n = dataBean.history;
            if (dataBean.phoneCountryCodes.size() > 0) {
                this.f16312a = dataBean.phoneCountryCodes;
            } else {
                ArrayList arrayList = new ArrayList();
                this.f16312a = arrayList;
                arrayList.add("+55");
            }
            this.f16316f.setEnabled(true);
            this.f16316f.setText(dataBean.phoneCountryCodes.get(0));
            this.f16318h.setEnabled(true);
            this.f16318h.setText(dataBean.history.phoneNumber);
            m11956b();
            m11960d();
        }
    }

    public void onNetworkError() {
        if (getContext() != null) {
            ArrayList arrayList = new ArrayList();
            this.f16312a = arrayList;
            arrayList.add("+55");
            this.f16312a.add("+52");
            this.f16316f.setEnabled(true);
            this.f16316f.setText(this.f16312a.get(0));
            this.f16318h.setEnabled(true);
            this.f16318h.setText("");
            m11956b();
            m11960d();
        }
    }

    public void onCountryCodeSelected(String str) {
        this.f16323m.dismissEmailDialog();
        this.f16316f.setText(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m11964f() {
        View currentFocus = getActivity().getCurrentFocus();
        if (currentFocus != null) {
            currentFocus.clearFocus();
            ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

    class OnTouchEventImpl implements View.OnTouchListener {
        OnTouchEventImpl() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                View currentFocus = CsPhoneNumberFragment.this.getActivity().getCurrentFocus();
                if (currentFocus instanceof EditText) {
                    Rect rect = new Rect();
                    currentFocus.getGlobalVisibleRect(rect);
                    if (!rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        currentFocus.clearFocus();
                        ((InputMethodManager) CsPhoneNumberFragment.this.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
                        CsPhoneNumberFragment.this.f16329s.onStateChanged((KeyboardEditText) null, false);
                    }
                }
            }
            return true;
        }
    }

    class KeyboardVisibilityListenerImpl implements KeyboardEditText.KeyboardListener {
        KeyboardVisibilityListenerImpl() {
        }

        public void onStateChanged(KeyboardEditText keyboardEditText, boolean z) {
            if (!z) {
                CsPhoneNumberFragment.this.checkPhoneNumberFormat();
                CsPhoneNumberFragment.this.m11964f();
                CsPhoneNumberFragment.this.setDeleteBtnInvisible();
                return;
            }
            CsPhoneNumberFragment.this.updateDeleteBtn();
        }
    }
}
